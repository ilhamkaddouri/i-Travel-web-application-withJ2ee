package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import projet.beans.Hotel;
import projet.beans.Personne;
import projet.db.PersonneDB;
import projet.db.ShowHotelList;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ShowHotelList hotelman = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        hotelman = new ShowHotelList();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getServletContext().getContextPath()+ "/login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	    PersonneDB prsdb = new PersonneDB();
	    HttpSession session = request.getSession(true);	
	    Personne prs = new Personne();
	    String n = request.getParameter("email");
	    session.setAttribute("email", n);
	    String p = request.getParameter("password");
	    session.setAttribute("password", p);
	    prs = prsdb.find(n, p);
		String status = prsdb.validate(n, p);
		session.setAttribute("status",status);
		try {
			if(status.equals("Client")) {
					session.setAttribute("id_prs", prs.getId_prs());
					session.setAttribute("currentSessionUser",prs); 
					request.getRequestDispatcher("/IndexServlet").forward(request, response);
			}else if(status.equals("Manager")){
				session.setAttribute("id_manager", prs.getId_prs());
				
				session.setAttribute("currentSessionUser",prs); 
				response.sendRedirect("indexManager.jsp");
				
			}
			else if(status.equals("password incorrect")) {
				request.setAttribute("test", status );
				
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				request.setAttribute("test", status );
			
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}catch(Exception e ){
			
		}
		
	}

}
