package lib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafeteria.MenuPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insert_Productos extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;

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
		setBounds(100, 100, 431, 348);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(38, 56, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(38, 139, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblTipo = new JLabel("Tipo Producto");
		lblTipo.setBounds(38, 228, 107, 14);
		contentPane.add(lblTipo);
		
		textNombre = new JTextField();
		textNombre.setBounds(38, 81, 167, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(38, 164, 167, 20);
		contentPane.add(textPrecio);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MenuPrincipal.main(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(254, 210, 124, 23);
		contentPane.add(btnVolver);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert modSql = new Insert();
				Productos mod = new Productos();
				
				if (textNombre.getText().equals("") || textPrecio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos vacios, debe completar todos los campos");
				}
			}
		});
		btnAadir.setBounds(254, 116, 124, 23);
		contentPane.add(btnAadir);
		
		JButton btnQuitarProducto = new JButton("Quitar Producto");
		btnQuitarProducto.setBounds(254, 163, 124, 23);
		contentPane.add(btnQuitarProducto);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.addItem("Bebida");
		comboTipo.addItem("Comida");
		comboTipo.addItem("Helados");
		comboTipo.addItem("Dulces");
		comboTipo.setBounds(38, 253, 167, 20);
		contentPane.add(comboTipo);
		
	}
}
