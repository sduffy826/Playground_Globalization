package com.corti.demo.global;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet(description = "Get Globalization Form Data", urlPatterns = { "/GlobalizationData" })
public class GlobalizationData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalizationData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get parms by name
		String inpField1 = request.getParameter("inpfield");
		String inpField2 = request.getParameter("inpfield2");
		
        response.setContentType("text/html");		
		PrintWriter pw = response.getWriter();
		
		pw.println("<div>");
		pw.println("<p>Field One: " + inpField1 + "</p>");
		pw.println("<p>Field Two: " + inpField2 + "</p>");
		
		pw.println("</div>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
