package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projet.beans.Chambre;
import projet.db.ChambreDB;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChambreDB chdb = null;
    public AddRoom() {
        super();
        chdb = new ChambreDB();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  resp.sendRedirect(req.getServletContext().getContextPath()+ "/addroom.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String titre = request.getParameter("titre");
		String prix = request.getParameter("prix");
		String descp = request.getParameter("description");
		String image = request.getParameter("image");
		String superf = request.getParameter("superfice");
		int pers = Integer.parseInt(request.getParameter("pers"));
		int typ = Integer.parseInt(request.getParameter("lits"));
		int id_hotel = (int) session.getAttribute("id_hotelm");
		Chambre room = new Chambre();
		room.setId_ch(0);
		room.setId_hotel(id_hotel);
		room.setType_ch(typ);
		room.setEtat_ch(0);
		room.setImage_ch(image);
		room.setTitre_ch(titre);
		room.setDescp_ch(descp);
		room.setPrix_ch(prix);
		room.setSuperfice(superf);
		room.setNbr_pers(pers);
		String a = chdb.AddRoom(room);
		if(a.equals("sc"))   //On success, you can display a message to user on Home page
		 {
		 RequestDispatcher rqs = request.getRequestDispatcher("/ManageRooms");
		 rqs.forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", a);
		 request.getRequestDispatcher("/addroom.jsp").forward(request, response);
		 }
	}

}
