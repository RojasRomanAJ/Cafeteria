package lib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;

import cafeteria.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Insert_Productos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textProducto;
	private JTextField textId;
	private JTable jtProductos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Productos frame = new Insert_Productos();
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
	public Insert_Productos() {
		setTitle("Añadir Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 466);

		Toolkit mipantalla = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = mipantalla.getScreenSize();

		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(432, 94, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(432, 150, 46, 14);
		contentPane.add(lblPrecio);

		JLabel lblTipo = new JLabel("Tipo Producto");
		lblTipo.setBounds(432, 214, 107, 14);
		contentPane.add(lblTipo);

		textNombre = new JTextField();
		textNombre.setBounds(432, 119, 167, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(432, 170, 167, 20);
		textPrecio.setColumns(10);
		contentPane.add(textPrecio);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(56, 382, 124, 23);
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuPrincipal.main(null);
				setVisible(false);
			}
		});
		contentPane.add(btnVolver);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(444, 277, 124, 23);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert modSql = new Insert();
				Productos mod = new Productos();

				if (textNombre.getText().equals("") || textPrecio.getText().equals("")
						|| textProducto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
				} else {
					if (modSql.existeProducto(textNombre.getText())) {

						mod.setNombre(textNombre.getText());
						mod.setPrecio(Double.parseDouble(textPrecio.getText()));
						mod.setTipo_Producto(textProducto.getText());
						mod.getId_Producto();

						if (modSql.addProducto(mod)) {
							JOptionPane.showMessageDialog(null, "Registro guardado");
							limpiar();
						} else {
							JOptionPane.showMessageDialog(null, "Error al guardar");
						}
					} else {
						JOptionPane.showMessageDialog(null, "El producto ya existe");
						limpiar();
					}
				}
			}

			private void limpiar() {
				textNombre.setText("");
				textPrecio.setText("");
				textProducto.setText("");
			}
		});
		contentPane.add(btnAadir);

		textProducto = new JTextField();
		textProducto.setBounds(432, 231, 167, 20);
		contentPane.add(textProducto);
		textProducto.setColumns(10);

		JButton btnQuitar = new JButton("Eliminar");
		btnQuitar.setBounds(444, 311, 124, 23);
		btnQuitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Delete modSql = new Delete();
				Productos mod = new Productos();

				if (textNombre.getText().equals("") || textPrecio.getText().equals("")
						|| textProducto.getText().equals("") || textId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
				} else {
					if (modSql.existeProducto(textNombre.getText())) {

						mod.setNombre(textNombre.getText());
						mod.setPrecio(Double.parseDouble(textPrecio.getText()));
						mod.setTipo_Producto(textProducto.getText());
						mod.setId_Producto(Integer.parseInt(textId.getText()));
					}
				}
				if (modSql.eliminarProducto(mod)) {
					JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "Error al eliminar");
				}

			}

			private void limpiar() {
				textNombre.setText("");
				textPrecio.setText("");
				textProducto.setText("");
				textId.setText("");
			}
		});
		contentPane.add(btnQuitar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(444, 344, 124, 23);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Update modSql = new Update();
				Productos mod = new Productos();

				if (textPrecio.getText().equals("") || textId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
				} else {
					if (!modSql.existeProducto(textNombre.getText())) {

						//mod.setNombre(textNombre.getText());
						mod.setPrecio(Double.parseDouble(textPrecio.getText()));
						//mod.setTipo_Producto(textProducto.getText());
						mod.setId_Producto(Integer.parseInt(textId.getText()));
					}
				}
				if (modSql.updateProducto(mod)) {
					JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
					limpiar();
				} else {
					JOptionPane.showMessageDialog(null, "Error al actualizar");
				}
			}
			
			private void limpiar() {
				textNombre.setText("");
				textPrecio.setText("");
				textProducto.setText("");
				textId.setText("");
			}
		});
		contentPane.add(btnActualizar);

		JLabel lblIdProducto = new JLabel("Id Producto");
		lblIdProducto.setBounds(432, 35, 107, 14);
		contentPane.add(lblIdProducto);

		textId = new JTextField();
		textId.setBounds(432, 63, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		jtProductos = new JTable();
		jtProductos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jtProductos.setBounds(10, 11, 412, 346);
		panel.add(jtProductos);
		
		setVisible(true);
		setResizable(false);
		
		try {
			
			Object[][] data = new Object[0][0];
			String[] datos = { "Id_Producto", "Nombre", "Precio €", "Tipo_Producto" };
			DefaultTableModel modelo = new DefaultTableModel(data, datos);
			jtProductos.setModel(modelo);
			modelo.fireTableDataChanged();
			JScrollPane scroll = new JScrollPane(jtProductos);
			scroll.setBounds(10, 11, 412, 346);
			getContentPane().add(scroll, BorderLayout.NORTH);
			
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
