package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.db.ChambreDB;
import projet.beans.Chambre;

/**
 * Servlet implementation class ShwoRooms
 */
@WebServlet("/ShowRooms")
public class ShowRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChambreDB chdb = null;
    public ShowRooms() {
        super();
        chdb = new ChambreDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession(true);	
		  int id_hotel = (int) session.getAttribute("id_hotel");
		  List<Chambre> rooms= chdb.getRoomsById(id_hotel);
		  request.setAttribute("rooms", rooms);
		  request.getRequestDispatcher("/hotel-single.jsp").forward(request, response);
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
