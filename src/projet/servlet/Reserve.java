package projet.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Hotel;
import projet.beans.Reservation;
import projet.db.ReservationDB;

/**
 * Servlet implementation class Reserve
 */
@WebServlet("/Reserve")
public class Reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReservationDB resvdb = null;
    public Reserve() {
        super();
       resvdb = new ReservationDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datedep = request.getParameter("date_dep");
		String datearr = request.getParameter("date_arr");
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 try {
			 HttpSession session = request.getSession(true);	
			Date date_res =  new Date(System.currentTimeMillis());
			 System.out.println(date_res);
			 Date date_dep = (Date) session.getAttribute("date_dep");
			 Date date_arr =  (Date) session.getAttribute("date_arr");
			 Reservation rsv = new Reservation();
				
					
				int id_prs =  (int) session.getAttribute("id_prs");
				int id_ch =  (int) session.getAttribute("id_ch");
				rsv.setId_res(0);
				rsv.setId_prs(id_prs);
				rsv.setId_ch(id_ch);
				rsv.setDate_arr( date_arr);
				rsv.setDate_dep(date_dep);
				rsv.setDate_res(date_res);
				rsv.setConfirmation(0);
				Reservation resv = resvdb.AddReservation(rsv);
				RequestDispatcher requestdisp = request.getRequestDispatcher("/ShowReservations");
				request.setAttribute("reservation", resv);
				requestdisp.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
