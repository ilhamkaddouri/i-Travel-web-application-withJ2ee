package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class DeleteHotel
 */
@WebServlet("/DeleteHotel")
public class DeleteHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
   ShowHotelList htldb = null;
    public DeleteHotel() {
        super();
        htldb = new ShowHotelList();
        		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	
		htldb.deleteHotel(id);
		RequestDispatcher requestdis = request.getRequestDispatcher("/HotelManager");
		requestdis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
