package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Hotel;
import projet.db.HotelDB;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class ShowHotels
 */
@WebServlet("/SearchHotels")
public class SearchHotels extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchHotels() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelDB hotdb = new HotelDB();
		response.setContentType("text/html");  
		Hotel hot = new Hotel();
		hot.setVille_hotel(request.getParameter("villeHotel")); 

		ArrayList<Hotel> status = hotdb.findvilles(hot.getVille_hotel());
		try {
				request.setAttribute("villes", status); 
				response.sendRedirect("showindexhotels.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
