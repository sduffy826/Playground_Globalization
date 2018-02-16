package com.corti.demo.global;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GlobalizationExample
 */
@WebServlet("/GlobalizationExample")
public class GlobalizationExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalizationExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setContentType("text/html");
	        
			PrintWriter pw = response.getWriter();
			pw.println("<!Doctype HTML>");		
		    pw.println("<html><head>");
		    pw.println("<style> table,td,td { border: 1px solid black; border-collapse: collapse; padding: 5px; }");
		    pw.println("th { text-align: center }</style>");
		    pw.println("<title>Globalization Example</title>");
		    pw.println("</head>");
		    pw.println("<body>");
		    pw.println("<h3>Globalization Example</h3>");
		    pw.println("<hr />");
		    dumpLocale(request, pw);
		    pw.println("</body></html>");
		    pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void dumpLocale(HttpServletRequest request, PrintWriter out) {
		Locale local = request.getLocale();
		out.println("<p>getLanguage(): " + local.getLanguage()+"</p>");
		out.println("<p>getDisplayLanguage(): " + local.getDisplayLanguage()+"</p>");
		out.println("<p>getCountry(): " + local.getCountry()+"</p>");
		out.println("<p>getDisplayCountry(): " + local.getDisplayCountry()+"</p>");
		out.println("<p>getDisplayName(): " + local.getDisplayName()+"</p>");
		out.println("<p>getScript(): " + local.getScript()+"</p>");
		out.println("<p>getVariant(): " + local.getVariant()+"</p>");
		out.println("<p>getISO3Country(): " + local.getISO3Country()+"</p>");
		out.println("<p>getISO3Language(): " + local.getISO3Language()+"</p>");
		
		out.println("<hr />");
		System.out.println("Before loop");
		Locale[] availableLocals = local.getAvailableLocales();
		
		Long bigNumber = 5000000L;
		Date currentDate = new Date();
		
		out.println("<table><thead><tr>");
		out.println("<td>toString</td>");
		out.println("<td>getCountry</td>");
		out.println("<td>getDisplayCountry</td>");
		out.println("<td>getISO3Country</td>");
		out.println("<td>getDisplayLanguage</td>");
		out.println("<td>getVariant</td>");
		out.println("<td>Number</td>");
		out.println("<td>Currency</td>");
		out.println("<td>Date</td>");
		out.println("</tr></thead><tbody>");
		for (Locale anotherLocal : availableLocals) {
			out.println("<tr>");
			try {
			   out.println("<td>" + anotherLocal.toString() + "</td>");
			   out.println("<td>" + anotherLocal.getCountry() + "</td>");
			   out.println("<td>" + anotherLocal.getDisplayCountry() + "</td>");
			   out.println("<td>" + anotherLocal.getISO3Country() + "</td>");
			   out.println("<td>" + anotherLocal.getDisplayLanguage() + "</td>");
			   out.println("<td>" + anotherLocal.getVariant() + "</td>");
			   out.println("<td>" + NumberFormat.getInstance(anotherLocal).format(bigNumber) + "</td>");
			   out.println("<td>" + NumberFormat.getCurrencyInstance(anotherLocal).format(bigNumber) + "</td>");
			   out.println("<td>" + DateFormat.getDateInstance(DateFormat.SHORT,anotherLocal).format(currentDate) + "</td>");
			   
			} catch (Exception e) {
				out.println("<td>ExceptionThrown</td>");
			}
			out.println("</tr>");
		}
		out.println("</tbody></table>");		
	}

	
}
