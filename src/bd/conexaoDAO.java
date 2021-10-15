package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexaoDAO {
	
	public Connection connectaDB() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/testejava?user=root&password=58545256jj";
			conn = DriverManager.getConnection(url);
			
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error.getMessage());
		}
		return conn;
	}
}	
