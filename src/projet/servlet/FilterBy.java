package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class FilterBy
 */
@WebServlet("/FilterBy")
public class FilterBy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShowHotelList swlist = null;
    public FilterBy() {
        super();
        swlist = new ShowHotelList();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/showhotelsbysearch.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int etoiles = Integer.parseInt(request.getParameter("stars"));
		System.out.println(etoiles);
		int price = Integer.parseInt(request.getParameter("prix"));
		System.out.println(price);
		List<Hotel> hotels = null;
		
			 hotels = swlist.searchByPriceAndEtoiles(price, etoiles);
		request.setAttribute("hotels", hotels);
		request.getRequestDispatcher("/showhotelsbysearch.jsp").forward(request, response);
	}

}
