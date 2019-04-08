package cafeteria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Dulces extends JFrame {

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dulces frame = new Dulces();
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
	public Dulces() {
		setTitle("Dulces");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 395);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblListaDeDulces = new JLabel("Lista de dulces");
		lblListaDeDulces.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblListaDeDulces.setBounds(31, 22, 106, 14);
		panel.add(lblListaDeDulces);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 597, 3);
		panel.add(separator);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 56, 387, 248);
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
		
		JButton btnQuitarDeCuenta = new JButton("Quitar de cuenta");
		btnQuitarDeCuenta.setBounds(452, 90, 132, 23);
		panel.add(btnQuitarDeCuenta);
	}

}
