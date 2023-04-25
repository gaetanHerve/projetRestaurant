package srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Carte;
import model.LignePanier;
import model.Panier;

/**
 * Servlet implementation class ServletPanier
 */
@WebServlet("/panier")
public class ServletPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext app = request.getServletContext();

		if (session.getAttribute("panier") == null) {
			Panier panier = new Panier();
			session.setAttribute("panier", panier);
		} /*
			 * else { Panier panier = (Panier)session.getAttribute("panier"); }
			 */

		Carte carte = new Carte();
		if (session.getAttribute("carte") == null) {
			app.setAttribute("carte", carte);
		} else {
			carte = (Carte) app.getAttribute("carte");
		}

		// TO REMOVE : test dataset
		// ArrayList<Article> articlesCarte = new ArrayList<Article>();
		// Article a1 = new Article(1, "article1", "super article", 12.5,
		// "leuzvleuvf");
		// Article a2 = new Article(2, "article2", "super article aussi", 34.5,
		// "leuzvleuvf");
		// Article a3 = new Article(3, "article3", "super article", 12.5,
		// "leuzvleuvf");
		// Article a4 = new Article(4, "article4", "super article aussi", 34.5,
		// "leuzvleuvf");
		// Article a5 = new Article(5, "article5", "super article", 12.5,
		// "leuzvleuvf");
		// Article a6 = new Article(6, "article6", "super article aussi", 34.5,
		// "leuzvleuvf");
		// articlesCarte.add(a1);
		// articlesCarte.add(a2);
		// articlesCarte.add(a3);
		// articlesCarte.add(a4);
		// articlesCarte.add(a5);
		// articlesCarte.add(a6);
		// carte.setArticles(articlesCarte);
		// Client client = new Client(1, "DUPOND", "Toto");
		// session.setAttribute("client", client);
		// END TO REMOVE;

		request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO : eviter de récupérer le panier et la carte ici et impacter ceux
		// du doGet();
		HttpSession session = request.getSession();
		ServletContext app = request.getServletContext();

		Panier panier = new Panier();
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", panier);
		} else {
			panier = (Panier) session.getAttribute("panier");
		}
		ArrayList<LignePanier> lignes = (panier.getLignes() != null) ? new ArrayList<LignePanier>(panier.getLignes())
				: new ArrayList<LignePanier>();

		Carte carte = (Carte) app.getAttribute("carte");
		int qte = 1;
		if (request.getParameter("quantity") != null) {
			qte = Integer.parseInt(request.getParameter("quantity"));
		}
		int articleRef = Integer.parseInt(request.getParameter("article"));
		Article article = carte.getArticleByRef(articleRef);
		int articleIndexInPanier = panier.getArticleIndexInPanier(articleRef);
		if (articleIndexInPanier != -1) {
			LignePanier line = lignes.get(articleIndexInPanier);
			line.setQte((line.getQte() + qte));
			lignes.set(articleIndexInPanier, line);
		} else {
			lignes.add(new LignePanier(article, qte));
		}
		panier.setLignes(lignes);
		session.setAttribute("panier", panier);
		System.out.println(panier.getLignes());
		doGet(request, response);
	}

}
