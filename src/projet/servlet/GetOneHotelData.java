package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.beans.Deal;
import projet.beans.Hotel;
import projet.beans.HotelReview;
import projet.db.ChambreDB;
import projet.db.DealDB;
import projet.db.HotelDB;
import projet.db.ReviewDB;

/**
 * Servlet implementation class GetOneHotelData
 */
@WebServlet("/GetOneHotelData")
public class GetOneHotelData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelDB hoteldb = null;
	 ChambreDB chdb = null;
	 ReviewDB rvdb = null;
	 DealDB dedb = null;
    public GetOneHotelData() {
        super();
        hoteldb = new HotelDB();
        chdb = new ChambreDB();
        rvdb = new ReviewDB();
        dedb = new DealDB();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		
			int id_hotel = (int) session.getAttribute("id_hotel");
	        Hotel existingHotel = hoteldb.find(id_hotel);
			
			 List<Chambre> rooms= chdb.getRoomsById(id_hotel);
			 List<HotelReview> reviews = rvdb.getReviews(id_hotel);
			 List<Deal> deals = dedb.ShowDealId(id_hotel);
			 
			 System.out.println(rooms);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("hotel-single.jsp");
	        request.setAttribute("rooms", rooms);
	        request.setAttribute("reviews", reviews);
	        request.setAttribute("h", existingHotel);
	        request.setAttribute("deals", deals);
	        
	        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
