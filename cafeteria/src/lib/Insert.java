package lib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert extends Conexion{

	public boolean registrar(Usuarios usr) {
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO usuarios (id, nombre, apellidos, num_contacto, direccion, correo_electronico, contraseña, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getNombre());
			ps.setString(3, usr.getApellidos());
			ps.setInt(4, usr.getNum_contacto());
			ps.setString(5, usr.getDireccion());
			ps.setString(6, usr.getCorreo_electronico());
			ps.setString(7, usr.getContraseña());
			ps.setInt(8, usr.getId_tipo());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
