package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Insert extends Conexion {

	public boolean registrar(Usuarios usr) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO usuarios (id, nombre, apellidos, correo_electronico, contraseña, direccion, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean existeUsuario(String usr) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();

		String sql = "SELECT count(id) FROM usuarios WHERE nombre = ?";

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, usr);
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

	public boolean esEmail(String correo) {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher matcher = pattern.matcher(correo);

		return matcher.find();
	}
	
	public boolean addProducto (Productos pro) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "INSERT INTO productos (id_Producto, nombre, tipo_Producto, precio) VALUES (?, ?, ?, ?)";

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

			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
