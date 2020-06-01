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

import projet.beans.Personne;
import projet.beans.Reservation;
import projet.db.PersonneDB;
import projet.db.ReservationDB;

/**
 * Servlet implementation class ShowReservations
 */
@WebServlet("/ShowReservations")
public class ShowReservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonneDB prsdb = null;
	ReservationDB rsvdb = null;
    public ShowReservations() {
        super();
        prsdb = new PersonneDB();
        rsvdb = new ReservationDB();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int id_prs = (int) session.getAttribute("id_prs");
		Personne personne = prsdb.findById(id_prs);
		List<Reservation> reserves = rsvdb.getReservation(id_prs);
		RequestDispatcher rqstdisp = request.getRequestDispatcher("showreservations.jsp");
		request.setAttribute("personne", personne);
		request.setAttribute("reserves", reserves);
		rqstdisp.forward(request, response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
