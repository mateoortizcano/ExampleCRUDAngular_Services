package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PersonaDTO;
import negocio.persona.IPersonaNegocio;
import negocio.persona.impl.PersonaNegocio;

@Path("/services")
public class PersonaServiceWS {
	
	private IPersonaNegocio  personaNegocio;
	
	public PersonaServiceWS(){
		personaNegocio = new PersonaNegocio();
	}
	
	@GET
	@Path("/findById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPorId(@PathParam("id") Integer id) {
		return personaNegocio.consultarPorId(id);
	}
	
	@GET
	@Path("/getlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> Listar() {
		return personaNegocio.Listar();
	}
	@GET
	@Path("/deletePerson/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String borrar(@PathParam("id") Integer id) {
		return personaNegocio.borrar(id);
	}
	
	@PUT
	@Path("/addPerson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crear(PersonaDTO personaDTO) {
		System.out.println(personaDTO.getNombre());
		return personaNegocio.crear(personaDTO);
	}
	
	
	@POST
	@Path("/updatePerson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizar(PersonaDTO personaDTO) {
		return personaNegocio.actualizar(personaDTO);
	}

	



}
