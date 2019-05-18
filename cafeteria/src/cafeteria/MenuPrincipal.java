package cafeteria;

import java.awt.*;
import javax.swing.*;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lib.Insert_Productos;

import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Cafeteria El Maestro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Toolkit mipantalla = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = mipantalla.getScreenSize();

		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton btnBebidas = new JButton("Bebidas");
		btnBebidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bebidas.main(null);
				setVisible(false);
			}
		});

		btnBebidas.setBounds(61, 25, 244, 80);
		panel.add(btnBebidas);

		JButton btnComida = new JButton("Comida");
		btnComida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Comida.main(null);
				setVisible(false);
			}
		});
		btnComida.setBounds(61, 116, 244, 80);
		panel.add(btnComida);

		JButton btnHelados = new JButton("Helados");
		btnHelados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Helados.main(null);
				setVisible(false);
			}
		});
		btnHelados.setBounds(61, 298, 244, 80);
		panel.add(btnHelados);

		JButton btnDulces = new JButton("Dulces");
		btnDulces.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Dulces.main(null);
				setVisible(false);
			}
		});
		btnDulces.setBounds(61, 207, 244, 80);
		panel.add(btnDulces);
		
		JButton btnImprimirCuenta = new JButton("Imprimir cuenta");
		btnImprimirCuenta.setBounds(366, 54, 161, 23);
		panel.add(btnImprimirCuenta);
		
		JButton btnAadirProducto = new JButton("Gestion Productos");
		btnAadirProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Insert_Productos.main(null);
				setVisible(false);
			}
		});
		btnAadirProducto.setBounds(366, 99, 161, 23);
		panel.add(btnAadirProducto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogIn.main(null);
				setVisible(false);
			}
		});
		btnSalir.setBounds(391, 355, 136, 23);
		panel.add(btnSalir);
	}
}
