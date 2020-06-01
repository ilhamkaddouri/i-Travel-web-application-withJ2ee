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
import projet.beans.Hotel;
import projet.db.EndroitDB;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowHotelList shl = null;
    EndroitDB enddb = null;
    public IndexServlet() {
        super();
        shl = new ShowHotelList();
        enddb = new EndroitDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hotel> randomHotels = shl.GetRandomHotels();
		List<Endroit> randomEndroits = enddb.getRandomEndroits();
		RequestDispatcher rqs = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("randomhotels", randomHotels);
		request.setAttribute("randomEndroits", randomEndroits);
		rqs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
