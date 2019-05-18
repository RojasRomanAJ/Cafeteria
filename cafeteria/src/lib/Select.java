package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;

import cafeteria.LogIn;

public class Select extends Conexion {

	public int seleccionUsr(Usuarios usr) {

		String usuario = LogIn.textUsuario.getText();
		String pass = String.valueOf(LogIn.textPasswd.getPassword());

		int resultado = 0;

		String sql = "SELECT nombre = "+usuario+" AND contraseña = md5('"+pass+"') FROM usuarios";

		Connection con = null;

		try {

			con = getConexion();
			Statement ps = con.createStatement();
			java.sql.ResultSet rs = ps.executeQuery(sql);

			if (rs.next()) {

				resultado = 1;
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
		
		return resultado;
	}
}
