package cafeteria;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import lib.Select;
import lib.Usuarios;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static JTextField textUsuario;
	private JPasswordField passwordField;
	public static JPasswordField textPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
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
	public LogIn() {
		setAlwaysOnTop(true);
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\macmini\\Downloads\\Screenshot_2019-04-03-16-46-23-282_com.instagram.android.png"));
		setTitle("Cafeteria el Maestro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(true);

		Toolkit mipantalla = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = mipantalla.getScreenSize();

		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setSize(669, 385);

		setLocation(anchoPantalla / 4, alturaPantalla / 4);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblLogin = new JLabel("LogIn");
		lblLogin.setBounds(104, 25, 78, 32);
		panel.add(lblLogin);

		JLabel lblCreateNewAccount = new JLabel("Crear Nueva Cuenta");
		lblCreateNewAccount.setBounds(459, 21, 129, 40);
		panel.add(lblCreateNewAccount);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 68, 623, 2);
		panel.add(separator);

		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(75, 115, 46, 14);
		panel.add(lblUser);

		textUsuario = new JTextField();
		textUsuario.setBounds(75, 140, 142, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(75, 171, 106, 14);
		panel.add(lblPassword);

		textPasswd = new JPasswordField();
		textPasswd.setBounds(75, 196, 142, 20);
		panel.add(textPasswd);

		JButton btnLogin = new JButton("Entrar");
		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				MenuPrincipal.main(null);
				setVisible(false);
				
				Select existeUsr = new Select();
				
			/*	if(Select.class() == 1) {
					
					JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado " + "satisfactoriamente al sistema", "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña válidos", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
					
				} */
			}
		});
		btnLogin.setBounds(75, 227, 142, 23);
		panel.add(btnLogin);

		JButton btnNew = new JButton("Nuevo");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Registro.main(null);
				setVisible(false);
			}
		});
		btnNew.setBounds(445, 227, 143, 23);
		panel.add(btnNew);

		JLabel lblAreYouNew = new JLabel("Eres nuevo?");
		lblAreYouNew.setBounds(458, 142, 130, 17);
		panel.add(lblAreYouNew);

		JLabel lblClickHereTo = new JLabel("Click aqu\u00ED para crear ");
		lblClickHereTo.setBounds(445, 183, 143, 14);
		panel.add(lblClickHereTo);

		textField = new JTextField();
		textField.setBounds(75, 140, 142, 20);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(75, 196, 142, 20);
		panel.add(passwordField);

	}
}
