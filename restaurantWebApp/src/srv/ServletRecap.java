package srv;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCommande;
import model.Article;
import model.Client;
import model.Commande;
import model.LignePanier;
import model.Panier;

/**
 * Servlet implementation class ServletRecap
 */
@WebServlet("/recap")
public class ServletRecap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Panier panier = new Panier();
		
		if (session.getAttribute("panier") != null) {
			panier = (Panier)session.getAttribute("panier");
		}
		
		Client client = (Client)session.getAttribute("client");
		String jour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		Commande commande = new Commande(client.getId(),jour,panier.getTotal());
		commande.generateInfos(panier);
		
//		ArrayList<Article> articles = new ArrayList<Article>();
//		Article a1 = new Article(1, "article1", "super article", 5, "leuzvleuvf");
//		Article a2 = new Article(2, "article2", "super article aussi", 6, "leuzvleuvf");
//		Article a3 = new Article(3, "article3", "super article", 7, "leuzvleuvf");	
//		
//		
//		LignePanier l1 = new LignePanier(a1, 2);
//		LignePanier l2 = new LignePanier(a2, 3);
//		LignePanier l3 = new LignePanier(a3, 1);
//		
//		List<LignePanier> lignesPanierTest= new ArrayList<LignePanier>();
//		lignesPanierTest.add(l1);
//		lignesPanierTest.add(l2);
//		lignesPanierTest.add(l3);
//		
//		Panier panierTest = new Panier(lignesPanierTest);
//		session.setAttribute("panier", panier);
//		
//		Client clientTest = new Client(1, "DUPOND", "Toto");
//		session.setAttribute("client", clientTest);
//		
//		Commande commandeTest = new Commande(clientTest.getId(),jour,panierTest.getTotal());
//		commandeTest.generateInfos(panierTest);
//		
//		
//		DaoCommande c = new DaoCommande();
//		try {
//			c.insert(commandeTest);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		
		DaoCommande c = new DaoCommande();
		try {
			c.insert(commande);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("panier", new Panier());
		
		request.getRequestDispatcher("WEB-INF/recapitulatif.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
