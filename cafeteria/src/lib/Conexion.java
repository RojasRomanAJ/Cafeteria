package lib;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

	private final String base = "cafeteria";
	private final String user = "root";
	private final String password = "manolo";
	private final String url = "jdbc:mysql://localhost:3308/" + base;
	private Connection con = null;

	public Connection getConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
