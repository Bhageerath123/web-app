package com.niit.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logincontroller
 */
@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Logincontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		loginDAO logindao=new loginDAO();
		RequestDispatcher dispatcher;
		if(logindao.iSValidUser(userid,password)==true)
		{
			//navigate to html.html
		dispatcher= request.getRequestDispatcher("home.html");
		dispatcher.forward(request,response);
		}
		else
		{
			//navigate to login page itself with error message
			dispatcher=request.getRequestDispatcher("login.html");
			//to create a objetc in printwriterclass
			PrintWriter writer=response.getWriter();
				writer.append("invalid credentials..........please type again" );
			dispatcher.include(request,response);
			
		}
	}

}
