package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Deal;
import projet.db.DealDB;

/**
 * Servlet implementation class AddDeal
 */
@WebServlet("/AddDeal")
public class AddDeal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DealDB dealdb;
    
    public AddDeal() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	dealdb = new DealDB();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		Deal deal = new Deal();
		deal.setId_deal(0);
		deal.setType_deal(request.getParameter("type"));
		deal.setDesc_deal(request.getParameter("desc"));
		String a = dealdb.AjouterDeal(deal);
		System.out.println(a);
		if(a.equals("sc")) {
			request.getRequestDispatcher("/ShowDeals").forward(request, response);
		}
		else   //On Failure, display a meaningful message to the User.
		 {
			 request.setAttribute("errMessage", a);
			 request.getRequestDispatcher("/addDeal.jsp").forward(request, response);
		 }	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getServletContext().getContextPath()+ "/addDeal.jsp");
	}

}
