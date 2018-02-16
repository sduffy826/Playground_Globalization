package com.corti.demo.global;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GlobalizationForm
 */
@WebServlet("/GlobalizationForm")
public class GlobalizationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalizationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// First get the resource bundle for the request local
		ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.resourceBundle", request.getLocale());

		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");
		pw.println("<html><head>");
		
		pw.println("<title>" + resourceBundle.getString("Title") + "</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<img src='" + resourceBundle.getString("Flag") + "'></img>");
		
		pw.println("<form name='TestForm' action='GlobalizationData'>");
		pw.println("<p>" + resourceBundle.getString("PromptLabel"));
		pw.println("<input type='text' name='inpfield' />");
		pw.println("<input type='text' name='inpfield2' /></p>");
		
		pw.println("<p><input type='submit' name='btnSubmit' value='" + 
		           resourceBundle.getString("SubmitButtonLabel") + "'/></p>");
		
		pw.println("</form></body></html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
