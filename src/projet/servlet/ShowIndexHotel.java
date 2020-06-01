package projet.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class ShowIndexHotel
 */
@WebServlet("/ShowIndexHotel")
public class ShowIndexHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowIndexHotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("/index.jsp").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowHotelList shl = new ShowHotelList();

		 
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			String ville = (String) request.getParameter("ville");
			String dateinit = (String) request.getParameter("date_init");
			String dateend = (String) request.getParameter("date_end");
			System.out.println(dateinit);
			
			Date date_init = new Date(formatter.parse(dateinit).getTime());
			System.out.println(date_init);
			Date date_end = new Date(formatter.parse(dateend).getTime());
			String prs = request.getParameter("personne");
			String ch = request.getParameter("chambre"); 
			ArrayList<Hotel> indexhotelList = shl.SearchHotels(ville, date_init, date_end, prs, ch); 
	     	request.setAttribute("indexhotelList", indexhotelList);

	   	    request.getRequestDispatcher("/showindexhotels.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}