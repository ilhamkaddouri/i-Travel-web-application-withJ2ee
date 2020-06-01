package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Deal;
import projet.beans.Rating;
import projet.db.RatingDB;

/**
 * Servlet implementation class AddRating
 */
@WebServlet("/AddRating")
public class AddRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RatingDB ratingdb;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRating() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	ratingdb = new RatingDB();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.getWriter().append("/hotel-single.jsp").append(request.getContextPath());
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id_hotel = (int) session.getAttribute("id_hotel");
		int rating = Integer.parseInt(request.getParameter("star"));
		
		ratingdb.AjouterRating(id_hotel,rating);
			RequestDispatcher ab = request.getRequestDispatcher("/GetOneHotelData");
			ab.forward(request, response);
		
	}
	

}
