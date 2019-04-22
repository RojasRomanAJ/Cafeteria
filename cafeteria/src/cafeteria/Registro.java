package cafeteria;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lib.Insert;
import lib.OcultarPass;
import lib.Usuarios;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtContacto;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
		setBounds(100, 100, 698, 428);
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
		btnAtrs.setBounds(463, 346, 89, 23);
		panel.add(btnAtrs);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert modSql = new Insert();
				Usuarios mod = new Usuarios();
				
				String pass = new String(passwordField.getPassword());
				String passCon = new String(passwordField_1.getPassword());
				
				if(pass.equals(passCon)) {
					
					String nuevoPass = OcultarPass.sha1(pass);
					
					mod.setNombre(txtNombre.getText());
					mod.setApellidos(txtApellidos.getText());
					//mod.setNum_contacto(txtContacto.getText());
					mod.setDireccion(txtDireccion.getText());
					mod.setCorreo_electronico(txtCorreo.getText());
					mod.setContraseña(nuevoPass);
					mod.setId_tipo(1);
					
					if(modSql.registrar(mod)) {
						JOptionPane.showMessageDialog(null, "Registro guardado");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error al guardar");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
				}
			}
		});
		btnGuardar.setBounds(573, 346, 89, 23);
		panel.add(btnGuardar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(275, 205, 94, 14);
		panel.add(lblContrasea);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(54, 73, 149, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(54, 154, 149, 20);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtContacto = new JTextField();
		txtContacto.setBounds(54, 230, 149, 20);
		panel.add(txtContacto);
		txtContacto.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(275, 73, 176, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(275, 154, 176, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 230, 176, 20);
		panel.add(passwordField);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarContrasea.setBounds(275, 278, 176, 14);
		panel.add(lblConfirmarContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(275, 303, 176, 20);
		panel.add(passwordField_1);
		
	}
}
