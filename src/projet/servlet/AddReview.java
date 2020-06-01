package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.db.ReviewDB;

/**
 * Servlet implementation class AddReview
 */
@WebServlet("/AddReview")
public class AddReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewDB reviewdb = null;
    public AddReview() {
        super();
       reviewdb = new ReviewDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("/hotel-single.jsp").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String message = request.getParameter("comment");
		int id_prs = (int) session.getAttribute("id_prs");
		int id_hotel = (int) session.getAttribute("id_hotel");
		
		reviewdb.AddReview(message, id_hotel, id_prs);
		RequestDispatcher rqsdisp = request.getRequestDispatcher("/GetOneHotelData");
		rqsdisp.forward(request, response);
	
	}

}
