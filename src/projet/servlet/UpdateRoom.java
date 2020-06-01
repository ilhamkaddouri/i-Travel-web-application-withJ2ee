package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Chambre;
import projet.db.ChambreDB;

/**
 * Servlet implementation class UpdateRoom
 */
@WebServlet("/UpdateRoom")
public class UpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChambreDB chdb = null;
    public UpdateRoom() {
        super();
      chdb = new ChambreDB();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String prix = request.getParameter("prix");
		String descp = request.getParameter("descp");
		String image = request.getParameter("image");
		String superf = request.getParameter("superf");
		int pers = Integer.parseInt(request.getParameter("pers"));
		int typ = Integer.parseInt(request.getParameter("type"));
		int id_ch = Integer.parseInt(request.getParameter("id_ch"));
		int id_hotel = Integer.parseInt(request.getParameter("id_hotel"));
		int etat_ch = Integer.parseInt(request.getParameter("etat"));
		Chambre ch = new Chambre(id_ch,id_hotel,typ,etat_ch,descp,superf,prix,pers,titre,image);
		chdb.updateRoom(ch);
		RequestDispatcher requestdis = request.getRequestDispatcher("/ManageRooms");
		requestdis.forward(request, response);
	}

}
