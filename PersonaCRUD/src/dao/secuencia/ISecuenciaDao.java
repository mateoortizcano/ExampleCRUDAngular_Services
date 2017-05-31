package dao.secuencia;

import java.sql.Connection;

public interface ISecuenciaDao {
	
	public Integer obtenerConsecutivo(String nombreSecuencia,Connection con) throws Exception;

}
