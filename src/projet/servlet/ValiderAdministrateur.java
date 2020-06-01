package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Endroit;
import projet.db.EndroitDB;

@WebServlet("/ValiderAdministrateur")
public class ValiderAdministrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EndroitDB endb = null;
    public ValiderAdministrateur() {
        super();
       endb = new EndroitDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Endroit> endroits = endb.getEndroitAll();
		request.setAttribute("endroits", endroits);
		request.getRequestDispatcher("/showendroitstoadmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_end"));
		
		endb.updateEndroit(id);
		RequestDispatcher requestdis = request.getRequestDispatcher("/ValiderAdministrateur");
		requestdis.forward(request, response);
	}

}
