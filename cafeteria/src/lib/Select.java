package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

import cafeteria.LogIn;

public class Select extends Conexion {

	public boolean seleccionUsr(Usuarios usr) {

		String usuario = LogIn.textUsuario.getText();
		String pass = String.valueOf(LogIn.textPasswd.getPassword());

		String sql = "SELECT * FROM usuarios WHERE nombre = '" + usuario + "' AND contraseña = md5('" + pass + "')"; 
				

		Connection con = null;

		try {

			con = getConexion();
			Statement ps = con.createStatement();
			java.sql.ResultSet rs = ps.executeQuery(sql);

			if (rs.next()) {
				
				return true;
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e, "Error de conexión", JOptionPane.ERROR_MESSAGE);

		} finally {

			try {
				con.close();

			} catch (SQLException e) {

				JOptionPane.showMessageDialog(null, e, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

			}
		}
		
		return false;
	}
	
	public boolean existeUsuario(String usr) {

		PreparedStatement ps = null;
		java.sql.ResultSet rs = null;
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
}
