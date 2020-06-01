package projet.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class HotelManager
 */
@WebServlet("/HotelManager")
public class HotelManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShowHotelList hotelman = null;
    public HotelManager() {
        super();
        hotelman = new ShowHotelList();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		int id = (int) session.getAttribute("id_manager");
		Hotel hotel = hotelman.getHotelManager(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("managerHotel.jsp");
        request.setAttribute("hm", hotel);
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
