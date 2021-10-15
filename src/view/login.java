package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(194, 22, 66, 30);
		contentPane.add(lblNewLabel);
		
		textUser = new JTextField();
		textUser.setBounds(174, 73, 155, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setBounds(105, 76, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(105, 107, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(174, 104, 155, 20);
		contentPane.add(textSenha);
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLogin(textUser.getText(),textSenha.getText())) {
					home home = new home();
					home.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Dados Inválidos");
				}

			}			
		});
		btnNewButton.setBounds(205, 165, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public boolean checkLogin(String login, String senha) {
		return login.equals("admin") && senha.equals("123456");
	}
}
