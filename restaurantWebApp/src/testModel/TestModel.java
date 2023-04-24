package testModel;

import java.sql.SQLException;

import dao.DaoArticle;
import dao.DaoClient;
import dao.DaoCommande;
import model.Article;
import model.Client;
import model.Commande;
import model.Complement;
import model.Panier;

public class TestModel {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		//testDaoArticle();
		//testDaoClient();
		testDaoCommande();

	}
	
	public static void testDaoArticle() throws ClassNotFoundException, SQLException {

		DaoArticle da = new DaoArticle();

		System.out.println("Test Insert");
		da.insert(new Article(1, "Salade a la caprese", "Tomates, mozzarela et basilic", 5, "salade-Caprese"));
		da.insert(new Article(2, "Bruschetta de la mer", "Saumon fumee sur sa tartine et pesto", 7, "bruschetta"));
		da.insert(new Article(3, "Aubergines parmigiana", "Aubergines sur son lit de parmesan", 8, "aubergines"));

		System.out.println("Test Delete");
		da.delete(1);

		System.out.println("Test Update");
		da.update(new Article(3, "Aubergines parmigiana", "Aubergines sur son lit de parmesan", 12, "aubergines"));

		System.out.println("Test SelectById");
		System.out.println(da.selectById(3));

		System.out.println("Test Select");
		System.out.println(da.select());

	}

	public static void testDaoClient() throws ClassNotFoundException, SQLException {
		
		DaoClient dc = new DaoClient();
		
		Complement comp1 = new Complement("12 rue de wall street", "0600000000", "allergie 1");
		Complement comp2 = new Complement("16 avenue des champ elysee", "0600000001", "allergie 2");

		System.out.println("Test Insert");
		dc.insert(new Client(1, "aa", "bb", "mdpaa"));
		dc.insert(new Client(2, "cc", "dd", comp1, "mdpcc"));
		dc.insert(new Client(3, "ee", "ff", comp2, "mdpee"));

		System.out.println("Test Delete");
		dc.delete(1);

		System.out.println("Test Update");
		Complement comp3 = new Complement("dans la france", "0600000002", "allergie 3");
		dc.update(new Client(3, "gg", "hh", comp3, "mdpgg"));
		
		System.out.println("Test SelectById");
		System.out.println(dc.selectById(3));

		System.out.println("Test Select");
		System.out.println(dc.select());

	}

	public static void testDaoCommande() throws ClassNotFoundException, SQLException {
		
		DaoCommande dc = new DaoCommande();
		
		Panier p = new Panier();

		System.out.println("Test Insert");
		dc.insert(new Commande(1, "Lundi", 45, p, "commande regle"));
		dc.insert(new Commande(2, "Mardi", 50, p, "commande regle"));
		dc.insert(new Commande(3, "Mercredi", 55, p, "commande regle"));

		System.out.println("Test Delete");
		dc.delete(1);

		System.out.println("Test Update");
		dc.update(new Commande(3, 3, "Jeudi", 45, p, "commande non reglee"));

		System.out.println("Test SelectById");
		System.out.println(dc.selectById(3));

		System.out.println("Test Select");
		System.out.println(dc.select());
	}
	
}
