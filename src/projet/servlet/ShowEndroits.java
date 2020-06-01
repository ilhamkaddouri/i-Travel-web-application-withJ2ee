package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.EndroitDB;
import projet.beans.Endroit;

@WebServlet("/ShowEndroits")
public class ShowEndroits extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EndroitDB enddb = null;
 
    public ShowEndroits() {
        super();
        enddb = new EndroitDB();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Endroit> endroits = enddb.getEndroits();
		request.setAttribute("endroits", endroits);

  	    request.getRequestDispatcher("/showEndroits.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
