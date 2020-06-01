package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Hotel;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class EditHotel
 */
@WebServlet("/EditHotel")
public class EditHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowHotelList hoteldb = null;
 
    public EditHotel() {
        super();
        hoteldb = new ShowHotelList();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(true);
		session.setAttribute("id_hotel", id);
		System.out.println(id);
		Hotel hotel = hoteldb.findHotelById(id);
		System.out.println(hotel.getAdresse_hotel());
		RequestDispatcher dispatcher = request.getRequestDispatcher("HotelForm.jsp");
        request.setAttribute("hm", hotel);
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
