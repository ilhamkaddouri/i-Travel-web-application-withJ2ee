package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.ReservationDB;

/**
 * Servlet implementation class EditReservation
 */
@WebServlet("/EditReservation")
public class EditReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservationDB rsvdb = null;
    public EditReservation() {
        super();
        rsvdb = new ReservationDB();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_res"));
		
		rsvdb.updateReservation(id);
		RequestDispatcher requestdis = request.getRequestDispatcher("/ShowReservations");
		requestdis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
