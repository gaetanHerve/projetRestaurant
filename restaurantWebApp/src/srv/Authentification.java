package srv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoClient;
import model.Client;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("identifiant"));
		String password = request.getParameter("password");
		
		DaoClient dc = new DaoClient();		
		
		Client c = new Client();
		
		try {
			c = dc.selectById(id);
			if(dc.selectById(id) != null & (dc.selectById(id).getPassword()).equals(password))
				{
				//System.out.println("OK");
				request.getRequestDispatcher("menu.jsp").forward(request, response);
				}
			else
			{
				//System.out.println("NOK");
				request.getRequestDispatcher("inscription.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("client", c);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
