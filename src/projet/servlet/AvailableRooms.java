package projet.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.beans.Hotel;
import projet.db.ChambreDB;

/**
 * Servlet implementation class AvailableRooms
 */
@WebServlet("/AvailableRooms")
public class AvailableRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChambreDB chdb = null;
    public AvailableRooms() {
        super();
        chdb = new ChambreDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datedep = request.getParameter("date_dep");
		 String datearr = request.getParameter("date_arr");
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			HttpSession session = request.getSession(true);
			 int id_hotel =(int) session.getAttribute("id_hotel") ;
			 
			 String chambre = request.getParameter("chambre");
			 String personne = request.getParameter("personne");
			
			 Date date_dep = new Date(formatter.parse(datedep).getTime());
			 Date date_arr =  new Date(formatter.parse(datearr).getTime());
			 session.setAttribute("date_dep", date_dep);
			 session.setAttribute("date_arr", date_arr);
			 ArrayList<Chambre> avlrooms = chdb.SearchHotels(id_hotel, date_dep, date_arr, personne, chambre);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("availablerooms.jsp");
	     	request.setAttribute("avlrooms", avlrooms);
	     	dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
