package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.*;

public class InterfazApp extends JFrame implements ActionListener {

	private JPanel contentPane;
	AfdVentana afdVentana;
	AfnVentana afnVentana;
	Afn2Ventana afn2Ventana;
	AfnLVentana afnLVentana;
	Controlador ctrl;
	

	/**
	 * Create the frame.
	 */
	public InterfazApp(Controlador ctrl) {
		
		afdVentana = new AfdVentana(ctrl);
		afnVentana = new AfnVentana(ctrl);
		afn2Ventana = new Afn2Ventana(ctrl);
		afnLVentana = new AfnLVentana(ctrl);
		this.ctrl =ctrl;
		
		setTitle("Automatas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnAfd = new JButton("AFD");
		btnAfd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAfd.setBounds(10, 42, 88, 64);
		contentPane.add(btnAfd);
		
		JButton btnAfn = new JButton("AFN");
		
		btnAfd.addActionListener(this);
		btnAfn.addActionListener(this);
		btnAfn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAfn.setBounds(122, 42, 88, 64);
		contentPane.add(btnAfn);
		
		JButton btnAfn2 = new JButton("AFN2");
		btnAfn2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAfn2.setBounds(230, 42, 92, 64);
		contentPane.add(btnAfn2);
		btnAfn2.addActionListener(this);
		
		JButton btnAfnl = new JButton("AFN-L");
		btnAfnl.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnAfnl.setBounds(339, 43, 95, 64);
		contentPane.add(btnAfnl);
		btnAfnl.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		
		
		if (evento.equals("AFD")) {
			
			afdVentana.setVisible(true);
			
		}
		else if (evento.equals("AFN")) {
			afnVentana.setVisible(true);
			
		}
		
		else if (evento.equals("AFN2")) {
			afn2Ventana.setVisible(true);
			
		}
		
		else if (evento.equals("AFN-L")) {
			afnLVentana.setVisible(true);
			
		}
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		InterfazApp interfazApp = new InterfazApp(new Controlador());
		
		interfazApp.setVisible(true);
	
	}
}
