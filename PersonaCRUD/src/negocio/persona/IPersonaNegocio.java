package negocio.persona;

import java.util.List;

import dto.PersonaDTO;

public interface IPersonaNegocio {

	public PersonaDTO consultarPorId(Integer id);

	public String actualizar(PersonaDTO personaDTO);

	public String crear(PersonaDTO personaDTO);

	public String borrar(Integer id);
	
	public List<PersonaDTO> Listar();
	
}
