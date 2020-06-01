package projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.db.ReservationDB;

/**
 * Servlet implementation class VerifyReservation
 */
@WebServlet("/VerifyReservation")
public class VerifyReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReservationDB rsvdb = null;
   
    public VerifyReservation() {
        super();
        rsvdb = new ReservationDB();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(true);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
