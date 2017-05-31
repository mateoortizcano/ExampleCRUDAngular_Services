package dao.persona.jdbc;

public class PersonaSQL {
	
	private static final String TABLE_NAME="persona";
	public static final String FIND_BY_ID ="SELECT id, nombre, apellido, telefono FROM "+ TABLE_NAME+" where id = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( id, nombre, apellido, telefono)  VALUES (?, ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET id=?, nombre=?, apellido=?, telefono=? WHERE id = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" WHERE id = ?";
	public static final String LIST = "SELECT id, nombre, apellido, telefono FROM "+TABLE_NAME;
	
	
	public PersonaSQL(){
		super();
	}
	
	
	

}
