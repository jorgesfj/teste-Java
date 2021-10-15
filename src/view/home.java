package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.MovimentacaoDAO;
import models.Movimentacao;
import java.awt.Color;
import javax.swing.JScrollPane;

public class home extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(202, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicionar Ve\u00EDculo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				form form = new form();
				form.setVisible(true);
			}
		});
		btnNewButton.setBounds(71, 36, 135, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Listar Veiculos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVeiculos();
			}
		});
		btnNewButton_1.setBounds(243, 36, 140, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formAlterar alterar = new formAlterar();
				alterar.setVisible(true);
			}
		});
		btnEditar.setBounds(71, 70, 135, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 104, 312, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa", "Modelo", "Entrada"
			}
		));
		
		JButton btnNewButton_2 = new JButton("Saida");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saida saida = new saida();
				saida.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(243, 70, 140, 23);
		contentPane.add(btnNewButton_2);
	}
	
	private void listarVeiculos() {
		try {
			MovimentacaoDAO movDAO = new MovimentacaoDAO();
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			
			ArrayList<Movimentacao> lista= movDAO.ListarMovimentacao();
			for(int num = 0; num<lista.size(); num++) {
				if(lista.get(num).getDateSaida() == null) {
				model.addRow(new Object [] {
						lista.get(num).getPlaca(),
						lista.get(num).getModelo(),
						lista.get(num).getDateEntrada()
					});
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Listar : " + e);
		}
	}
	
}
