package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.MovimentacaoDAO;
import models.Movimentacao;

public class saida extends JFrame {
	
	String saidaFim;
	long tempoFim;
	double valorFim;
	String placaFim;
	private JPanel contentPane;
	private JTextField textSaida;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saida frame = new saida();
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
	public saida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saida");
		lblNewLabel.setBounds(208, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizar();
				home home = new home();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(165, 186, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Digite a placa do veiculo que vai sair: ");
		lblNewLabel_4.setBounds(33, 48, 182, 14);
		contentPane.add(lblNewLabel_4);
		
		textSaida = new JTextField();
		textSaida.setBounds(225, 45, 86, 20);
		contentPane.add(textSaida);
		textSaida.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saida();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(335, 44, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane infos = new JScrollPane();
		infos.setBounds(33, 91, 370, 84);
		contentPane.add(infos);
		
		table = new JTable();
		infos.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hor\u00E1rio de sa\u00EDda: ", "Tempo Estacionado: ", "Valor a pagar:"
			}
		));
	}
	
	private void saida() throws ParseException {
		String placa = textSaida.getText();
		placaFim = placa;
		MovimentacaoDAO movDAO = new MovimentacaoDAO();
		
		ArrayList<Movimentacao> mov = movDAO.saida(placa);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		
		long tempo;
		SimpleDateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US); 
		Date entrada = formato.parse(mov.get(0).getDateEntrada());
		Date saida = new Date();
		tempo =saida.getTime() - entrada.getTime();
		tempo = ((tempo/1000)/60)/60;
		int valor;
		if(tempo<2) {
			valor = 6;
		}else {
			valor = (int) (6 + ((tempo -1)*4));
		}
		tempoFim = tempo;
		saidaFim = saida.toString();
		valorFim = valor;
		
		model.addRow(new Object [] {
				saida.getHours() + ":"+ saida.getMinutes(),
				tempo + " horas",
				"R$ " + valor+",00" 
			});
	}
	
	private void finalizar() {
		
		MovimentacaoDAO movDAO = new MovimentacaoDAO();
		movDAO.finalizar(saidaFim, tempoFim, valorFim, placaFim);
	}
}
