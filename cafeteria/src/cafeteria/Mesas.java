package cafeteria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Mesas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesas frame = new Mesas();
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
	public Mesas() {
		setTitle("Mesas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 428);
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
		
		JButton btnMesa = new JButton("Mesa 1");
		btnMesa.setBounds(21, 34, 89, 23);
		panel.add(btnMesa);
		
		JButton btnMesa_1 = new JButton("Mesa 2");
		btnMesa_1.setBounds(21, 74, 89, 23);
		panel.add(btnMesa_1);
		
		JButton btnMesa_2 = new JButton("Mesa 3");
		btnMesa_2.setBounds(21, 118, 89, 23);
		panel.add(btnMesa_2);
		
		JButton btnMesa_3 = new JButton("Mesa 4");
		btnMesa_3.setBounds(21, 163, 89, 23);
		panel.add(btnMesa_3);
		
		JButton btnMesa_4 = new JButton("Mesa 5");
		btnMesa_4.setBounds(21, 213, 89, 23);
		panel.add(btnMesa_4);
		
		JButton btnMesa_5 = new JButton("Mesa 6");
		btnMesa_5.setBounds(21, 261, 89, 23);
		panel.add(btnMesa_5);
		
		JButton btnMesa_6 = new JButton("Mesa 7");
		btnMesa_6.setBounds(21, 307, 89, 23);
		panel.add(btnMesa_6);
		
		JButton btnMesa_7 = new JButton("Mesa 8");
		btnMesa_7.setBounds(165, 34, 89, 23);
		panel.add(btnMesa_7);
		
		JButton btnMesa_8 = new JButton("Mesa 9");
		btnMesa_8.setBounds(165, 74, 89, 23);
		panel.add(btnMesa_8);
		
		JButton btnMesa_9 = new JButton("Mesa 10");
		btnMesa_9.setBounds(165, 118, 89, 23);
		panel.add(btnMesa_9);
		
		JButton btnMesa_10 = new JButton("Mesa 11");
		btnMesa_10.setBounds(165, 163, 89, 23);
		panel.add(btnMesa_10);
		
		JButton btnMesa_11 = new JButton("Mesa 12");
		btnMesa_11.setBounds(165, 213, 89, 23);
		panel.add(btnMesa_11);
		
		JButton btnMesa_12 = new JButton("Mesa 13");
		btnMesa_12.setBounds(165, 261, 89, 23);
		panel.add(btnMesa_12);
		
		JButton btnMesa_13 = new JButton("Mesa 14");
		btnMesa_13.setBounds(165, 307, 89, 23);
		panel.add(btnMesa_13);
		
		JButton btnMesa_14 = new JButton("Mesa 15");
		btnMesa_14.setBounds(309, 34, 89, 23);
		panel.add(btnMesa_14);
		
		JButton btnMesa_15 = new JButton("Mesa 16");
		btnMesa_15.setBounds(309, 74, 89, 23);
		panel.add(btnMesa_15);
		
		JButton btnMesa_16 = new JButton("Mesa 17");
		btnMesa_16.setBounds(309, 118, 89, 23);
		panel.add(btnMesa_16);
		
		JButton btnMesa_17 = new JButton("Mesa 18");
		btnMesa_17.setBounds(309, 163, 89, 23);
		panel.add(btnMesa_17);
		
		JButton btnMesa_18 = new JButton("Mesa 19");
		btnMesa_18.setBounds(309, 213, 89, 23);
		panel.add(btnMesa_18);
		
		JButton btnMesa_19 = new JButton("Mesa 20");
		btnMesa_19.setBounds(309, 261, 89, 23);
		panel.add(btnMesa_19);
		
		JButton btnBarra = new JButton("Barra 1");
		btnBarra.setBounds(496, 34, 89, 23);
		panel.add(btnBarra);
		
		JButton btnBarra_1 = new JButton("Barra 2");
		btnBarra_1.setBounds(496, 74, 89, 23);
		panel.add(btnBarra_1);
		
		JButton btnBarra_2 = new JButton("Barra 3");
		btnBarra_2.setBounds(496, 118, 89, 23);
		panel.add(btnBarra_2);
		
		JButton btnBarra_3 = new JButton("Barra 4");
		btnBarra_3.setBounds(496, 163, 89, 23);
		panel.add(btnBarra_3);
		
		JButton btnVolver = new JButton("Menu Principal");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal.main(null);
				setVisible(false);
			}
		});
		btnVolver.setBounds(434, 307, 151, 23);
		panel.add(btnVolver);
	}
}
		
		
