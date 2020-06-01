package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.DealDB;

/**
 * Servlet implementation class DeleteDeal
 */
@WebServlet("/DeleteDeal")
public class DeleteDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DealDB dealdb = null;
    public DeleteDeal() {
        super();
        dealdb = new DealDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("deal"));
		dealdb.deleteDeal(id);
		
			RequestDispatcher requestdis = request.getRequestDispatcher("/ShowDeals");
			requestdis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
