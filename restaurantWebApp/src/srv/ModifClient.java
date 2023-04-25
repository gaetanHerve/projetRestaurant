package srv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoClient;
import model.Client;
import model.Complement;

/**
 * Servlet implementation class ModifClient
 */
@WebServlet("/ModifClient")
public class ModifClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Client c = (Client)session.getAttribute("client");

		int idclient = c.getId();
		String nom = c.getNom();
		String prenom = c.getPrenom();
		String password = c.getPassword();
		
		Complement comp = c.getComplement();
		String telephone = comp.getTelephone();
		String instructions = comp.getInstructions();
		
		String adresse = request.getParameter("newadresse");
		
		Complement compnew = new Complement(adresse, telephone, instructions);
		Client cnew = new Client(idclient, nom, prenom, compnew, password);
		
		DaoClient dc = new DaoClient();
		
		try {
			dc.update(cnew);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
