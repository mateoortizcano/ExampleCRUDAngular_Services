package dao.persona;

import java.sql.Connection;
import java.util.List;

import dto.PersonaDTO;

public interface IPersonaDAO {
	
	public PersonaDTO consultarPorId(Integer id, Connection con) throws Exception;

	public String actualizar(PersonaDTO personaDTO, Connection con) throws Exception;

	public String crear(PersonaDTO personaDTO,Connection con) throws Exception;

	public String borrar(Integer id, Connection con) throws Exception;
	
	public List<PersonaDTO> Listar(Connection con) throws Exception;

}
