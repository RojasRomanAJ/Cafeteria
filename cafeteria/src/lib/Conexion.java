package lib;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

	private final String base = "cafeteria";
	private final String user = "root";
	private final String password = "manolo";
	private final String time = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String url = "jdbc:mysql://localhost:3308/" + base + time ;
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public Connection getConexion() {

		try {
			Class.forName(driver);
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
