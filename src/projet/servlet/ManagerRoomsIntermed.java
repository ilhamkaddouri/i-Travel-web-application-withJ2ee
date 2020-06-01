package projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;

/**
 * Servlet implementation class ManagerRoomsIntermed
 */
@WebServlet("/ManagerRoomsIntermed")
public class ManagerRoomsIntermed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManagerRoomsIntermed() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("rmid"));
		HttpSession session = request.getSession(true);
		session.setAttribute("id_hotelm",id);
		RequestDispatcher rqsdisp = request.getRequestDispatcher("/ManageRooms");
		rqsdisp.forward(request, response);
				  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
