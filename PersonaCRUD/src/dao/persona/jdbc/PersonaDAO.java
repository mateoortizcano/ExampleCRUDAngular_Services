package dao.persona.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.persona.IPersonaDAO;
import dao.secuencia.ISecuenciaDao;
import dao.secuencia.jdbc.SecuenciaDAO;
import dto.PersonaDTO;
import util.PersistUtil;

public class PersonaDAO implements IPersonaDAO {

	@Override
	public PersonaDTO consultarPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		PersonaDTO personaDTO = null;
		try {
			query = PersonaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				personaDTO = new PersonaDTO();
				setInfoPersona(resultado, personaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return personaDTO;
	}

	private void setInfoPersona(ResultSet resultado, PersonaDTO personaDTO) throws Exception {
		personaDTO.setId(resultado.getInt("id"));
		personaDTO.setNombre(resultado.getString("nombre"));
		personaDTO.setApellidos(resultado.getString("apellido"));
		personaDTO.setTelefono(resultado.getString("telefono"));
	}

	@Override
	public String actualizar(PersonaDTO personaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PersonaSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, personaDTO.getId());
            instruccion.setString(index++, personaDTO.getNombre());
            instruccion.setString(index++, personaDTO.getApellidos());
            instruccion.setString(index++, personaDTO.getTelefono());
            instruccion.setInt(index++, personaDTO.getId());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String crear(PersonaDTO personaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PersonaSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
			ISecuenciaDao secuenciaDao = new SecuenciaDAO();
            personaDTO.setId(secuenciaDao.obtenerConsecutivo("sec_persona", con));
            instruccion.setInt(index++, personaDTO.getId());
            instruccion.setString(index++, personaDTO.getNombre());
            instruccion.setString(index++, personaDTO.getApellidos());
            instruccion.setString(index++, personaDTO.getTelefono());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String borrar(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PersonaSQL.DELETE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, id);
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public List<PersonaDTO> Listar(Connection con) throws Exception {
		// prepara la consulta (Query)
		PreparedStatement instruccion = null;
		// captura el resultado de la consulta
		ResultSet resultado = null;
		String query;
		PersonaDTO personaDTO = null;
		List<PersonaDTO> listaPersonas = new ArrayList<>();
		try {
			query = PersonaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				personaDTO = new PersonaDTO();
				setInfoPersona(resultado, personaDTO);
				listaPersonas.add(personaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaPersonas;
	}
}
