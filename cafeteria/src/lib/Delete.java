package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete extends Conexion {

	public boolean eliminar (Productos pro) {
	
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
}