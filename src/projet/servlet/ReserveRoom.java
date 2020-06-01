package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.db.ChambreDB;

/**
 * Servlet implementation class ReserveRoom
 */
@WebServlet("/ReserveRoom")
public class ReserveRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChambreDB chdb=null;
    public ReserveRoom() {
        super();
        chdb = new ChambreDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_room"));
		HttpSession session = request.getSession(true);	
		session.setAttribute("id_ch", id);
		Chambre room = chdb.findRoomById(id);
		RequestDispatcher requestdisp = request.getRequestDispatcher("reserveroom.jsp");
		request.setAttribute("room", room);
		requestdisp.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
