package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class AfdVentana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	Controlador controlador;
	ImageIcon image, imageExpresionRegular;
	JLabel labelImagen, labelExpresionRegular;
	


	public AfdVentana(Controlador controlador) {
		
		image = new ImageIcon("src/img/afd_primer_corte.jpg");
		image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		
		imageExpresionRegular = new ImageIcon(getClass().getResource("/img/expresion_regular_afd_primer_corte.jpg"));
		imageExpresionRegular = new ImageIcon(imageExpresionRegular.getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("hice click");
				File file = new File("src/img/afd_primer_corte.jpg");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}});
		labelImagen = new JLabel(image);
		labelExpresionRegular = new JLabel(imageExpresionRegular);
		
		this.controlador = controlador;
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 595, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("desarollado por Sergio Garcia y Jose Alvarez");
		
		JLabel lblAutomataFinitoDeterminista = new JLabel("AUTOMATA FINITO DETERMINISTA");
		lblAutomataFinitoDeterminista.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblAutomataFinitoDeterminista.setBounds(124, 22, 350, 29);
		contentPane.add(lblAutomataFinitoDeterminista);
		
		
	
		
		panel.setBorder(new TitledBorder(null, "Imagen del automata", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(338, 62, 219, 175);
		
		
		
		panel.add(labelImagen);
		labelImagen.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		contentPane.add(panel);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(140, 297, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite una cadena");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 291, 120, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnNewButton.setBounds(376, 274, 159, 66);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Expresion regular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 196, 303, 72);
		panel_1.add(labelExpresionRegular);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripcion del lenguaje", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel_2.setBounds(10, 62, 303, 135);
		contentPane.add(panel_2);
		
		JTextArea txtrAutmataFinitoDeterminista = new JTextArea();
		panel_2.add(txtrAutmataFinitoDeterminista);
		txtrAutmataFinitoDeterminista.setEditable(false);
		txtrAutmataFinitoDeterminista.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrAutmataFinitoDeterminista.setText("Automata finito determinista que \r\nacepta el lenguajes de todas las\r\ncadenas formadas por un numero\r\nimpar  de 'a' y par de 'b' dentro \r\ndel alfabeto {a,b}");
		txtrAutmataFinitoDeterminista.setToolTipText("");
		
		btnNewButton.addActionListener(this);
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		
		if (event.equals("Validar")) {
			
			controlador.ejecutarAfd(textField.getText());
			textField.setText("");
					}
	
	}
}
	


	