package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.db.DealDB;
import projet.beans.Deal;

/**
 * Servlet implementation class EditDeal
 */
@WebServlet("/EditDeal")
public class EditDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DealDB deal = null;
    public EditDeal() {
        super();
        deal = new DealDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("deal"));
		Deal deal1 = deal.ShowDealByID(id);
		request.setAttribute("deal1", deal1);
		RequestDispatcher requestdis = request.getRequestDispatcher("/editDeal.jsp");
		requestdis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idd = Integer.parseInt(request.getParameter("id_deal"));
		String type = request.getParameter("type");
		String desc = request.getParameter("desc");
		Deal dealch = new Deal();
		dealch.setId_deal(idd);
		dealch.setType_deal(type);
		dealch.setDesc_deal(desc);
		deal.updateDeal(dealch);
		RequestDispatcher requestdis = request.getRequestDispatcher("/ShowDeals");
		requestdis.forward(request, response);
	}

}
