package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete extends Conexion {

	public boolean eliminarProducto (Productos pro) {
	
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "DELETE FROM productos WHERE id_Producto = ? AND nombre = ? AND precio = ? AND tipo_producto = ?";

		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, pro.getId_Producto());
			ps.setString(2, pro.getNombre());
			ps.setDouble(3, pro.getPrecio());
			ps.setString(4, pro.getTipo_Producto());
			ps.executeUpdate();
			
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean existeProducto(String pro) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT count(id_Producto) FROM productos WHERE nombre = ?";

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, pro);
			rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

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
