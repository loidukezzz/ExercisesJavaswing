package BAI3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connect {
	public Connection conn = null;
	public void connectSQL() throws SQLException {
	
	try {
		String userName ="sa";
		String password ="sa";
		String url = "jdbc:sqlserver://DESKTOP\\SQLEXPRESS;databaseName=QLNV;";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = java.sql.DriverManager.getConnection(url,userName,password);
	} catch (ClassNotFoundException e) {
		System.out.println("Kết nối thất bại");
	}	
	}
	public ResultSet LoadData(String sql) {
		ResultSet rs = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void UpdateData(String sql) {
		
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}