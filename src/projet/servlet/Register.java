package projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.beans.Personne;
import projet.db.PersonneDB;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneDB persndb;
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	persndb = new PersonneDB();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		Personne prs = new Personne();
		prs.setId_prs(0);
		prs.setNom_prs(request.getParameter("nom"));
		prs.setPrenom_prs(request.getParameter("prenom"));
		prs.setEmail(request.getParameter("email"));
		prs.setTel_prs(request.getParameter("tele"));
		prs.setType_prs(request.getParameter("type"));
		prs.setPassword_prs(request.getParameter("password"));
		String a = persndb.getInsert(prs);
		System.out.println(a);
		if(a.equals("sc"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/login.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", a);
		 request.getRequestDispatcher("/register.jsp").forward(request, response);
		 }
		
	}
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	 
	        resp.sendRedirect(req.getServletContext().getContextPath()+ "/register.jsp");
	    }
}
