package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.db.ChambreDB;

/**
 * Servlet implementation class ManageRooms
 */
@WebServlet("/ManageRooms")
public class ManageRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ChambreDB chdb = null;
   
    public ManageRooms() {
        super();
       chdb = new ChambreDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		int id = (int) session.getAttribute("id_hotelm");
		System.out.println("lol");
		System.out.println(id);
		 List<Chambre> rooms= chdb.getRoomsById(id);
		  request.setAttribute("rooms", rooms);
		  request.getRequestDispatcher("/Managerooms.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
