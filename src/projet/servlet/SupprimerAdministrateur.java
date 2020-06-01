package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.EndroitDB;

@WebServlet("/SupprimerAdministrateur")
public class SupprimerAdministrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EndroitDB endb = null;
    public SupprimerAdministrateur() {
        super();
        endb = new EndroitDB();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("code"));
		endb.deleteEndroit(id);
		RequestDispatcher requestdis = request.getRequestDispatcher("/ValiderAdministrateur");
		requestdis.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
