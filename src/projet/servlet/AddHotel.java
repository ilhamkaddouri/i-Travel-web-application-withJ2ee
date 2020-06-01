package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.crimson.tree.ParseContext;

import projet.beans.Deal;
import projet.beans.Hotel;
import projet.db.DealDB;
import projet.db.HotelDB;

/**
 * Servlet implementation class AddHotel
 */
@WebServlet("/AddHotel")
public class AddHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HotelDB hoteldb;
	DealDB deals = null;
       
    public AddHotel() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	hoteldb = new HotelDB();
    	deals = new DealDB();
    }
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		 HttpSession session = request.getSession(true);	
		Hotel hot = new Hotel();
		Deal deal = new Deal();
		hot.setId_hotel(0);
		int id =  (int) session.getAttribute("id_manager");
		hot.setId_prs(id);
		hot.setNom_hotel(request.getParameter("nom"));
		hot.setAdresse_hotel(request.getParameter("ville"));
    	hot.setDescription(request.getParameter("adresse"));
        hot.setVille_hotel(request.getParameter("phone"));
        hot.setTel_hotel(request.getParameter("desc"));
        hot.setNbr_etoiles(Integer.parseInt(request.getParameter("stars")));
        hot.setImage_hotel(request.getParameter("photo"));
        hot.setId_deal(Integer.parseInt(request.getParameter("deals")));
		String a = hoteldb.AddHotel(hot);
		System.out.println(a);
		if(a.equals("sc"))   //On success, you can display a message to user on Home page
		 {
			
			request.getRequestDispatcher("/hotadded.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			 request.setAttribute("errMessage", a);
			 request.getRequestDispatcher("/addhotel.jsp").forward(request, response);
		 }
		
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		ArrayList<Deal> dealList = deals.ShowDeal();
		req.setAttribute("dealList", dealList);
		req.getRequestDispatcher("/addhotel.jsp").forward(req, resp);
    }
}
