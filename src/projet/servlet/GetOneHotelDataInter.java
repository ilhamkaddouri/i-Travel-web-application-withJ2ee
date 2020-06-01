package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetOneHotelDataInter
 */
@WebServlet("/GetOneHotelDataInter")
public class GetOneHotelDataInter extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetOneHotelDataInter() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		int id = Integer.parseInt(request.getParameter("hotel"));
		session.setAttribute("id_hotel", id);
		RequestDispatcher rqsdisp = request.getRequestDispatcher("/GetOneHotelData");
		rqsdisp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
