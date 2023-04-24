package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Client;
import model.Complement;

public class DaoClient {

	public void insert(Client c) throws ClassNotFoundException, SQLException {
		String sql="insert into clients values(?,?,?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		Complement comp = c.getComplement();
		
		ps.setInt(1, c.getId());
		ps.setString(2, c.getPassword());
		ps.setString(3, c.getNom());
		ps.setString(4, c.getPrenom());
		ps.setString(5, c.getComplement().getAdresse());
		ps.setString(6, c.getComplement().getTelephone());
		ps.setString(7, c.getComplement().getInstructions());
		ps.executeUpdate();

		conn.close();
	}
	
	public ArrayList<Client> select() throws ClassNotFoundException, SQLException {
		ArrayList<Client> c = new ArrayList<Client>();
		String sql = "select * from clients";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			Complement comp = new Complement( 
				rs.getString("adresse"),
				rs.getString("telephone"),
				rs.getString("instructions")
			);
			c.add(new Client(
				rs.getInt("id"),
				rs.getString("nom"),
				rs.getString("prenom"),
				comp)
			);
		}
		
		conn.close();
		return c;
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from clients where id='"+id+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	
	public void update(Client c) throws ClassNotFoundException, SQLException {
		String sql = "update clients set pass=?,nom=?,prenom=?, adresse=?, telephone=?, instructions=? where id=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, c.getPassword());
		ps.setString(2, c.getNom());
		ps.setString(3, c.getPrenom());
		ps.setString(4, c.getComplement().getAdresse());
		ps.setString(5, c.getComplement().getTelephone());
		ps.setString(6, c.getComplement().getInstructions());
		ps.setInt(7, c.getId());
		ps.executeUpdate();
		conn.close();
	}
	
	public Client selectById(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from clients where id='"+id+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		Client c = null;
		while(rs.next()){
			Complement comp = new Complement( 
					rs.getString("adresse"),
					rs.getString("telephone"),
					rs.getString("instructions")
				);
				c = new Client(
					rs.getInt("id"),
					rs.getString("nom"),
					rs.getString("prenom"),
					comp
				);
		}

		conn.close();
		return c;
	}
	
}
