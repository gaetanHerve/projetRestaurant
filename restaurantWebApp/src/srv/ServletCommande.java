package srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Client;
import model.LignePanier;
import model.Panier;

/**
 * Servlet implementation class ServletCommande
 */
@WebServlet("/commande")
public class ServletCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("panier") == null) {
			Panier panier = new Panier();
			session.setAttribute("panier", panier);
		} /* else {
			Panier panier = (Panier)session.getAttribute("panier");
		} */
		
		// TO REMOVE : test dataset
//		Client client = new Client(1, "DUPOND", "Toto");
//		Article a1 = new Article(1, "article1", "super article", 12.5, "leuzvleuvf");
//		Article a2 = new Article(2, "article2", "super article aussi", 34.5, "leuzvleuvf");
//		LignePanier lp1 = new LignePanier(a1, 3);
//		LignePanier lp2 = new LignePanier(a2, 1);
//		ArrayList<LignePanier> lignes = new ArrayList<LignePanier>();
//		lignes.add(lp1);
//		lignes.add(lp2);
//		
//		Panier panier = new Panier(lignes);
//		request.setAttribute("panier", panier);
//		request.setAttribute("lignes", lignes);
//		session.setAttribute("client", client);
		// END TO REMOVE
		
		request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
