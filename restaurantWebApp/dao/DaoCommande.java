package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCommande {

	public void insert(Commande com) throws ClassNotFoundException, SQLException {
		String sql="insert into commandes (idclient, jour, prixtotal, infos) VALUE (?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ps.setInt(1, com.getIdClient());
		ps.setString(2, com.getJour());
		ps.setDouble(3, com.getPrixTotal());
		ps.setInfos(4, com.getInfos());
		ps.executeUpdate();

		conn.close();
	}
	
	public ArrayList<Commande> select() throws ClassNotFoundException, SQLException {
		ArrayList<Commande> com = new ArrayList<Commande>();
		String sql = "select * from commandes";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			com.add(new Commande(rs.getInt("id"), rs.getInt("idclient"), rs.getString("jour"),rs.getDouble("prixtotal"),rs.getInfos("infos")));
		}
		
		conn.close();
		return com;
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "delete from commandes where id='"+id+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	
	public void update(Commande com) throws ClassNotFoundException, SQLException {
		String sql = "update commandes set idclient=?,jour=?,prixtotal=?,infos=? where id=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, com.getIdClient());
		ps.setString(2, com.getJour());
		ps.setDouble(3, com.getPrixTotal());
		ps.setString(4, com.getInfos());
		ps.setInt(5, com.getId());
		ps.executeUpdate();
		conn.close();
	}
	
	public Commande selectById(int id) throws ClassNotFoundException, SQLException {
		String sql = "select * from commandes where id='"+id+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		Commande com = null;
		while(rs.next()){
			com = new Commande(rs.getInt("id"), rs.getInt("idclient"), rs.getString("jour"),rs.getDouble("prixtotal"),rs.getInfos("infos"));	
		}

		conn.close();
		return com;
	}
	
}
