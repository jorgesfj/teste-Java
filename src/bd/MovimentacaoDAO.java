package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.Movimentacao;

public class MovimentacaoDAO {
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<Movimentacao> lista = new ArrayList<>();
	Movimentacao mov = new Movimentacao();
	
	public void cadastrarMov(Movimentacao mov) {
		String sql = "INSERT INTO tbl_movimentacao (placa, modelo, tempo, valor_pago, date_entada, date_saida) VALUES (?,?,?,?,?,?)";
	
		conn = new conexaoDAO().connectaDB();
		
		try {
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, mov.getPlaca());
			pstm.setString(2, mov.getModelo());
			pstm.setLong(3, mov.getTempo());
			pstm.setDouble(4, mov.getValor_pago());
			pstm.setString(5, mov.getDateEntrada());
			pstm.setString(6, mov.getDateSaida());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception error) {
			 JOptionPane.showMessageDialog(null, "MOVIMENTACAO DAO: " + error.getMessage());
		}
	}
	
	public ArrayList<Movimentacao> ListarMovimentacao(){
		String sql = "SELECT * FROM tbl_movimentacao";
		conn = new conexaoDAO().connectaDB();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				 Movimentacao mov = new Movimentacao();
				 mov.setId(rs.getInt("id"));
				 mov.setPlaca(rs.getString("placa"));
				 mov.setModelo(rs.getString("modelo"));
				 mov.setTempo(rs.getInt("tempo"));
				 mov.setValor_pago(rs.getDouble("valor_pago"));
				 mov.setDateEntrada(rs.getString("date_entada"));
				 mov.setDateSaida(rs.getString("date_saida"));
				 
				 lista.add(mov);
			}
			
		} catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Movimentacao Pesquisar: " + error);
		}
		
		return lista;
	}
	
	public void alterarMov(Movimentacao mov, String placa) {
		String sql = "update tbl_movimentacao set placa = ?, modelo = ?, valor_pago = ? where placa = ?";
		
		conn = new conexaoDAO().connectaDB();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, mov.getPlaca());
			pstm.setString(2, mov.getModelo());
			pstm.setString(3, placa);
			
			pstm.execute();
			pstm.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ALTER MOV: " + e);
		}
		
		
	}
	
	public void finalizar(String saidaFim, long tempoFim,double valorFim, String placa) {
		String sql = "update tbl_movimentacao set tempo = ?, date_saida = ?, valor_pago = ?  where placa = ?";
		
		conn = new conexaoDAO().connectaDB();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, tempoFim);
			pstm.setString(2, saidaFim);
			pstm.setDouble(3, valorFim);
			pstm.setString(4, placa);
			
			pstm.execute();
			pstm.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"ALTER MOV: " + e);
		}
		
		
	}
	
	public ArrayList<Movimentacao> saida(String placa){
		String sql = "SELECT * FROM tbl_movimentacao where placa = ?";
		conn = new conexaoDAO().connectaDB();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, placa);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				 Movimentacao mov = new Movimentacao();
				 mov.setId(rs.getInt("id"));
				 mov.setPlaca(rs.getString("placa"));
				 mov.setModelo(rs.getString("modelo"));
				 mov.setTempo(rs.getInt("tempo"));
				 mov.setValor_pago(rs.getDouble("valor_pago"));
				 mov.setDateEntrada(rs.getString("date_entada"));
				 mov.setDateSaida(rs.getString("date_saida"));
				 
				 lista.add(mov);
			}
			
		} catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "Movimentacao Pesquisar: " + error);
		}
		
		return lista;
	}
}
