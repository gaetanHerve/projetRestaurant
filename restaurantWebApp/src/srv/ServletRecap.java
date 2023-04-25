package srv;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCommande;
import model.Client;
import model.Commande;
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
		
		Client client = new Client();
		if (session.getAttribute("client") != null) {
			client = (Client)session.getAttribute("client");
		}
		
		String jour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		Commande commande = new Commande(client.getId(),jour,panier.getTotal());
		commande.generateInfos(panier);
		
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
