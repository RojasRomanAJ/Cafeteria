package lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update extends Conexion {

	public boolean updateProducto (Productos pro) {

		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE productos SET nombre = ?, precio = ?, tipo_producto = ? WHERE id_producto = ?";

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

			return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
