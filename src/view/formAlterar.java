package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bd.MovimentacaoDAO;
import models.Movimentacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class formAlterar extends JFrame {

	private JPanel contentPane;
	private JTextField textAlterar;
	private JTextField textPlaca;
	private JTextField textModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formAlterar frame = new formAlterar();
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
	public formAlterar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Dados");
		lblNewLabel.setBounds(174, 11, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite a placa do ve\u00EDculo que deseja alterar: ");
		lblNewLabel_1.setBounds(56, 56, 220, 14);
		contentPane.add(lblNewLabel_1);
		
		textAlterar = new JTextField();
		textAlterar.setBounds(286, 53, 86, 20);
		contentPane.add(textAlterar);
		textAlterar.setColumns(10);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarVeiculo();
				home home = new home();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(170, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		textPlaca = new JTextField();
		textPlaca.setBounds(217, 101, 86, 20);
		contentPane.add(textPlaca);
		textPlaca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setBounds(217, 132, 86, 20);
		contentPane.add(textModelo);
		textModelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nova Placa:");
		lblNewLabel_2.setBounds(136, 104, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Novo Modelo: ");
		lblNewLabel_2_1.setBounds(120, 135, 85, 14);
		contentPane.add(lblNewLabel_2_1);
	}
	
	private void alterarVeiculo() {
		String placa;
		String modelo;
		String veiculoAlterar;
		
		veiculoAlterar = textAlterar.getText();
		placa = textPlaca.getText();
		modelo = textModelo.getText();
		
		Movimentacao mov = new Movimentacao();
		
		mov.setModelo(modelo);
		mov.setPlaca(placa);
		
		MovimentacaoDAO movDAO = new MovimentacaoDAO();
		
		movDAO.alterarMov(mov, veiculoAlterar);
		
	}
}
