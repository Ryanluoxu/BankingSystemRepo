package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerAccount;
import dao.AdminDAO;



@WebServlet("/AdminCreateAccout")
public class AdminCreateAccout extends HttpServlet {
		
	// make association
	CustomerAccount account = null;
	AdminDAO adminDAO = null;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		// take data from HTML
		String password = request.getParameter("password"); // same with HTML.
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		
		// pass data to POJO
		account = new CustomerAccount();
		
		account.setPassword(password);
		account.setName(name);
		account.setEmail(email);
		account.setMobileNumber(mobile);
		
		// store POJO to database
		adminDAO = new AdminDAO();
		
		if (adminDAO.register(account)) {	
			rd = request.getRequestDispatcher("createSuccessfully"); 
			rd.forward(request, response);
			
		} else {
			out.println("<html><body><font color='red'>Register is unsuccessful.</font></body></html>");				
			rd = request.getRequestDispatcher("adminCreateAccount.html");
			rd.include(request, response);
		}
			
	}

}
