package cafeteria;

import java.awt.*;

import javax.swing.*;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lib.Insert_Productos;

import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Bebidas extends JFrame {

	private JTable table;

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
		lblListaDeBebidas.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblListaDeBebidas.setBounds(31, 22, 106, 14);
		panel.add(lblListaDeBebidas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 597, 3);
		panel.add(separator);
		
		table = new JTable();
		table.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				String sql = "SELECT id_Producto, Nombre, Tipo_Producto, Precio FROM productos WHERE tipo_Producto = Bebida";
				
			}
		});
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 56, 432, 290);
		panel.add(table);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal.main(null);
				setVisible(false);
			}
		});
		
		btnVolver.setBounds(452, 323, 91, 23);
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
	}
}
