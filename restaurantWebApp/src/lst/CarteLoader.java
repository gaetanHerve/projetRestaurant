package lst;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DaoArticle;
import model.Article;
import model.Carte;

/**
 * Application Lifecycle Listener implementation class CarteLoader
 *
 */
@WebListener
public class CarteLoader implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CarteLoader() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         Carte carte = new Carte();
         DaoArticle articleDao = new DaoArticle();
         ArrayList<Article> articles = new ArrayList<Article>();
         try {
			 articles = articleDao.select();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         carte.setArticles(articles);
         ServletContext app = arg0.getServletContext();
         app.setAttribute("carte", carte);
    }
	
}
