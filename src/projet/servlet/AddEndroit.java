package projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Endroit;
import projet.db.EndroitDB;

/**
 * Servlet implementation class AddEndroit
 */
@WebServlet("/AddEndroit")
public class AddEndroit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EndroitDB endDb = null;
    public AddEndroit() {
        super();
        endDb = new EndroitDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Endroit e = new Endroit();
		e.setId_endroit(0);
		e.setNom_endroit(request.getParameter("nom"));
		e.setVille_endroit(request.getParameter("ville"));
		e.setDescp_endroit(request.getParameter("desc"));
		e.setLocation_endroit(request.getParameter("location"));
		e.setImage_endroit(request.getParameter("image"));
		String rs = endDb.AddEndroit(e);
		if(rs.equals("sc")) {
			request.getRequestDispatcher("/hotadded.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/addendroit.jsp").forward(request, response);
		}
		
	}

}
