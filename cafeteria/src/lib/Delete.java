package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends Conexion {

	public boolean eliminarProducto (Productos pro) {
	
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "DELETE FROM productos (id_Producto, nombre, tipo_Producto, precio) VALUES (?, ?, ?, ?)";

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, pro.getId_Producto());
			ps.setString(2, pro.getNombre());
			ps.setString(3, pro.getTipo_Producto());
			ps.setDouble(4, pro.getPrecio());
			ps.executeUpdate();
			
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarUsuario (Usuarios usr) {
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "DELETE FROM usuarios(id, nombre, apellidos, correo_electronico, contraseña, dirrecion, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getNombre());
			ps.setString(3, usr.getApellidos());
			ps.setString(4, usr.getCorreo_electronico());
			ps.setString(5, usr.getContraseña());
			ps.setString(6, usr.getDireccion());
			ps.setInt(7, usr.getId_tipo());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}