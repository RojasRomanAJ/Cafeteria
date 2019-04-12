package cafeteria;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Nuevo Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setLocation(anchoPantalla/4, alturaPantalla/4);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 48, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setBounds(54, 129, 104, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNumeroContacto = new JLabel("Numero Contacto");
		lblNumeroContacto.setBounds(54, 205, 149, 14);
		panel.add(lblNumeroContacto);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(275, 48, 56, 14);
		panel.add(lblDireccion);
		
		JLabel lblCorreoElectronico = new JLabel("Correo Electronico");
		lblCorreoElectronico.setBounds(275, 129, 158, 14);
		panel.add(lblCorreoElectronico);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(377, 285, 89, 23);
		panel.add(btnAtrs);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(487, 285, 89, 23);
		panel.add(btnGuardar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(275, 205, 94, 14);
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(54, 73, 149, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(54, 154, 149, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 230, 149, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(275, 73, 176, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(275, 154, 176, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 230, 176, 20);
		panel.add(passwordField);
		
	}

}
