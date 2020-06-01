package projet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Deal;
import projet.beans.Hotel;
import projet.db.DealDB;

/**
 * Servlet implementation class ShowDeals
 */
@WebServlet("/ShowDeals")
public class ShowDeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DealDB deals = null;
    public ShowDeals() {
        super();
        deals = new DealDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Deal> dealList = deals.ShowDeal(); 
    	request.setAttribute("dealList", dealList);

  	    request.getRequestDispatcher("/showdeals.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
