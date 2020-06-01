package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.HotelDB;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class ShowHotels
 */
@WebServlet("/ShowHotels")
public class ShowHotels extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShowHotelList hotels = null;
	 public ShowHotels() {
	        super();
	        hotels = new ShowHotelList();
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        	 ArrayList<Hotel> hotelList = hotels.ShowList(); 
	        	request.setAttribute("hotelList", hotelList);

	      	    request.getRequestDispatcher("/showhotels.jsp").forward(request, response);
	       
		
	}


}
