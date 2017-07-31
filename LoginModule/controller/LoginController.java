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

import bean.User;
import dao.LoginDAO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	User user = null;
	LoginDAO refLoginDAO = null;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
		int userID = 0;
		String userPassword = null;
		
		try {
			userID = Integer.parseInt(request.getParameter("userID"));	// same with HTML.
			userPassword = request.getParameter("pwd"); // same with HTML.
			
			user = new User();
			refLoginDAO = new LoginDAO();
			
			user.setUserID(userID);
			user.setPassword(userPassword);
			
			try {
				if (refLoginDAO.loginValidate(user)) {	
					
					// this is valid user, get the userType:
					String userType = refLoginDAO.getUserType(user);
					
					// for admin:
					if (userType.equals("admin")) {
						rd = request.getRequestDispatcher("adminMenu.html"); 
						rd.include(request, response);
					}
					
					// for customer:
					if (userType.equals("customer")) {
						rd = request.getRequestDispatcher("customerMenu.html"); 
						rd.include(request, response);
					}
					
				} else {
					out.println("<html><body><font color='red'>User ID or Password not match</font></body></html>");
					
					rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			out.println("<html><body><font color='red'>Invalid input..</font></body></html>");
			rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

	}

}
