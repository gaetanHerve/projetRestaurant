package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Article;

public class DaoArticle {

	public void insert(Article a) throws ClassNotFoundException, SQLException {
		String sql="insert into articles values(?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		
		ps.setInt(1, a.getRef());
		ps.setString(2, a.getNom());
		ps.setString(3, a.getDescription());
		ps.setDouble(4, a.getTarif());
		ps.setString(5, a.getUrlImage());
		ps.executeUpdate();

		conn.close();
	}
	
	public ArrayList<Article> select() throws ClassNotFoundException, SQLException {
		ArrayList<Article> a = new ArrayList<Article>();
		String sql = "select * from articles";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			a.add(new Article(rs.getInt("ref"), rs.getString("nom"), rs.getString("description"),rs.getDouble("tarif"),rs.getString("url_image")));
		}
		
		conn.close();
		return a;
	}
	
	public void delete(int ref) throws ClassNotFoundException, SQLException {
		String sql = "delete from articles where ref='"+ref+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
		conn.close();
	}
	
	public void update(Article a) throws ClassNotFoundException, SQLException {
		String sql = "update articles set nom=?,description=?,tarif=?,url_image=? where ref=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, a.getNom());
		ps.setString(2, a.getDescription());
		ps.setDouble(3, a.getTarif());
		ps.setString(4, a.getUrlImage());
		ps.setInt(5, a.getRef());
		ps.executeUpdate();
		conn.close();
	}
	
	public Article selectById(int ref) throws ClassNotFoundException, SQLException {
		String sql = "select * from articles where ref='"+ref+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojetrestaurant","root","root");
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		
		Article a = null;
		while(rs.next()){
			a = new Article(rs.getInt("ref"), rs.getString("nom"), rs.getString("description"),rs.getDouble("tarif"),rs.getString("url_image"));	
		}

		conn.close();
		return a;
	}
	
}
