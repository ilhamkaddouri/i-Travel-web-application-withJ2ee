package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.ChambreDB;

@WebServlet("/DeleteRoom")
public class DeleteRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ChambreDB chdb = null;
    public DeleteRoom() {
        super();
        chdb = new ChambreDB();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("room"));
		System.out.println("bitch");
		System.out.println(id);
		chdb.deleteRoom(id);
		
			RequestDispatcher requestdis = request.getRequestDispatcher("/ManageRooms");
			requestdis.forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
