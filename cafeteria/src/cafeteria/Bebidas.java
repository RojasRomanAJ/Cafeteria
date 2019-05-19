package cafeteria;

import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lib.Conexion;
import lib.Insert_Productos;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Bebidas extends JFrame {
	private JTable jtBebidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bebidas frame = new Bebidas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bebidas() {
		setTitle("Bebidas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 395);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblListaDeBebidas = new JLabel("Lista de bebidas");
		lblListaDeBebidas.setBounds(31, 22, 106, 14);
		lblListaDeBebidas.setFont(new Font("Arial Black", Font.PLAIN, 11));
		panel.add(lblListaDeBebidas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 597, 3);
		panel.add(separator);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(452, 323, 91, 23);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal.main(null);
				setVisible(false);
			}
		});
		panel.add(btnVolver);
		
		JButton btnAadirACuenta = new JButton("A\u00F1adir a cuenta");
		btnAadirACuenta.setBounds(452, 56, 132, 23);
		panel.add(btnAadirACuenta);
		
		btnAadirACuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Mesas.main(null);
				setVisible(false);
			}
		});
		
		JButton btnQuitarDeCuenta = new JButton("Quitar de cuenta");
		btnQuitarDeCuenta.setBounds(452, 90, 132, 23);
		panel.add(btnQuitarDeCuenta);
		
		jtBebidas = new JTable();
		//jtBebidas.setBounds(20, 55, 424, 291);
		panel.add(jtBebidas);
		
		setVisible(true);
		setResizable(true);
		
try {
			
			Object[][] data = new Object[0][0];
			String[] datos = { "Id_Producto", "Nombre", "Precio €", "Tipo_Producto" };
			DefaultTableModel modelo = new DefaultTableModel(data, datos);
			jtBebidas.setModel(modelo);
			modelo.fireTableDataChanged();
			JScrollPane scroll = new JScrollPane(jtBebidas);
			scroll.setBounds(10, 11, 412, 346);
			getContentPane().add(scroll).getBounds();
			
			java.sql.PreparedStatement ps = null;
			java.sql.ResultSet rs = null;
			Conexion con = new Conexion();
			java.sql.Connection conn = con.getConexion();
			
			String sql = "SELECT * FROM productos";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData rsMd = rs.getMetaData();
			int cantidadColumnas = rsMd.getColumnCount();
			
			while (rs.next()) {
				
				Object[] filas = new Object[cantidadColumnas];
				
				for (int i = 0; i < cantidadColumnas; i++) {
					filas[i] = rs.getObject(i + 1);
				}
				
				modelo.addRow(filas);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla productos");
		}
	}
}
