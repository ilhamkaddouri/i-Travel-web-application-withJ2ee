package projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Hotel;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class UpdateHotel
 */
@WebServlet("/UpdateHotel")
public class UpdateHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShowHotelList hotldb = null;
    public UpdateHotel() {
        super();
        hotldb = new ShowHotelList();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_hotel = Integer.parseInt(request.getParameter("id"));
		int id_prs = Integer.parseInt(request.getParameter("id_prs"));
		String nom = request.getParameter("nom");
		String ville = request.getParameter("ville");
		String description = request.getParameter("desc");
		String tel = request.getParameter("phone");
		int etoiles = Integer.parseInt(request.getParameter("etoiles"));
		String adresse = request.getParameter("adresse");
		String img = request.getParameter("img");
		Hotel hotel = new Hotel(id_hotel,nom,adresse,ville,tel,description,etoiles,img,id_prs);
		hotldb.updateHotel(hotel);
		RequestDispatcher requestdis = request.getRequestDispatcher("/HotelManager");
		requestdis.forward(request, response);
	}

}
