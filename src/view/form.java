package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.MovimentacaoDAO;
import models.Movimentacao;

public class form extends JFrame {

	private JPanel contentPane;
	private JTextField textPlaca;
	private JTextField textModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Ve\u00EDculo");
		lblNewLabel.setBounds(175, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setBounds(64, 60, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Placa");
		lblNewLabel_1_1.setBounds(64, 60, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Modelo");
		lblNewLabel_1_2.setBounds(64, 85, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(149, 57, 165, 20);
		contentPane.add(textPlaca);
		textPlaca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(149, 82, 165, 20);
		contentPane.add(textModelo);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String placa, modelo;
				placa = textPlaca.getText();
				modelo = textModelo.getText();
				
				Movimentacao mov = new Movimentacao(modelo, placa, null, 0, 0);
				
				MovimentacaoDAO objmovdao = new MovimentacaoDAO();
				objmovdao.cadastrarMov(mov);
				
				home home = new home();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(181, 134, 89, 23);
		contentPane.add(btnNewButton);
	}
}
