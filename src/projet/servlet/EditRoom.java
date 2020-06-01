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
import projet.beans.Hotel;
import projet.db.ChambreDB;

/**
 * Servlet implementation class EditRoom
 */
@WebServlet("/EditRoom")
public class EditRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChambreDB chdb = null;
    public EditRoom() {
        super();
       chdb = new ChambreDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("room"));
		HttpSession session = request.getSession(true);
		session.setAttribute("id_room", id);
		System.out.println(id);
		Chambre room = chdb.findRoomById(id);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("RoomForm.jsp");
        request.setAttribute("roomup", room);
        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
