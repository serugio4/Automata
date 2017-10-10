package vista;


import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Afn2Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private Controlador ctrl;
	ImageIcon image, imageExpresionRegular;
	JLabel labelImagen, labelExpresionRegular;



	public Afn2Ventana(Controlador ctrl) {
		this.ctrl = ctrl;
		
		image = new ImageIcon("src/img/afn segundo corte.jpg");
		image = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		
		imageExpresionRegular = new ImageIcon(getClass().getResource("/img/expresion_regular_afn_segundo_corte.jpg"));
		imageExpresionRegular = new ImageIcon(imageExpresionRegular.getImage().getScaledInstance(290, 45, Image.SCALE_DEFAULT));
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("hice click");
				File file = new File("src/img/afn segundo corte.jpg");
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}});
		labelImagen = new JLabel(image);
		labelExpresionRegular = new JLabel(imageExpresionRegular);
		
		panel.add(labelImagen);
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 595, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("desarrollado por Sergio Garcia y Jose Alvarez");
		
		JLabel lblAutomataFinitoDeterminista = new JLabel("AUTOMATA FINITO NO DETERMINISTA");
		lblAutomataFinitoDeterminista.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
		lblAutomataFinitoDeterminista.setBounds(100, 22, 400, 29);
		contentPane.add(lblAutomataFinitoDeterminista);
		
		
		panel.setBorder(new TitledBorder(null, "Imagen del automata", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(338, 62, 219, 175);
		contentPane.add(panel);
		
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
		labelExpresionRegular.setBounds(0, 0, panel_1.getWidth(), panel_1.getHeight());
		panel_1.add(labelExpresionRegular);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Descripcion del lenguaje", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 62, 303, 123);
		contentPane.add(panel_2);
		
		JTextArea txtrAutmataFinitoDeterminista = new JTextArea();
		panel_2.add(txtrAutmataFinitoDeterminista);
		txtrAutmataFinitoDeterminista.setEditable(false);
		txtrAutmataFinitoDeterminista.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrAutmataFinitoDeterminista.setText("Automata finito no determinista que \r\nacepta el lenguajes de todas las"
				+ " \r\ncadenas que tengan impar a's o par b's\r\n dentro del alfabeto {a,b} ");
		txtrAutmataFinitoDeterminista.setToolTipText("");
		
		btnNewButton.addActionListener(this);
	}

	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand().equalsIgnoreCase("validar")) {
			 
			 ctrl.Afn2(textField.getText());
			 textField.setText("");
			 
		 }
		
		// TODO Auto-generated method stub
		
	}
}
