package negocio.persona.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.persona.IPersonaDAO;
import dao.persona.jdbc.PersonaDAO;
import dto.PersonaDTO;
import negocio.persona.IPersonaNegocio;
import util.PersistUtil;

public class PersonaNegocio implements IPersonaNegocio {
	
    private IPersonaDAO personaDAO;
    private DataSource dataSource;
	
	public PersonaNegocio(){
		dataSource = PersistUtil.getDataSource();
		personaDAO = new PersonaDAO();
	}
	
	@Override
	public PersonaDTO consultarPorId(Integer id) {
		Connection con = null;
		PersonaDTO personaDTO = null;
		try {
			con = dataSource.getConnection();
			personaDTO= personaDAO.consultarPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return personaDTO;
	}

	@Override
	public String actualizar(PersonaDTO personaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.actualizar(personaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crear(PersonaDTO personaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.crear(personaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrar(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.borrar(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<PersonaDTO> Listar() {
		Connection con = null;
		List<PersonaDTO> listaPersonas = null;
		try {
			con = dataSource.getConnection();
			listaPersonas= personaDAO.Listar(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaPersonas;
	}

}
