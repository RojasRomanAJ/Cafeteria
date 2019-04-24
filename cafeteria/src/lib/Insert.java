package lib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Insert extends Conexion{

	public boolean registrar(Usuarios usr) {
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO usuarios (id, nombre, apellidos, direccion, correo_electronico, contraseña, id_tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getNombre());
			ps.setString(3, usr.getApellidos());
			ps.setString(4, usr.getDireccion());
			ps.setString(5, usr.getCorreo_electronico());
			ps.setString(6, usr.getContraseña());
			ps.setInt(7, usr.getId_tipo());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int existeUsuario(String usr) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "SELECT count(id) FROM usuarios WHERE usuarios = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, usr);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	public boolean esEmail(String correo) {
		
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
		Matcher matcher = pattern.matcher(correo);
		
		return matcher.find();
	}
}
