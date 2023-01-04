package CountryTiming;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CountryTimeZone
 */

public class CountryTimingZone extends HttpServlet {

	public void service(HttpServletRequest r,HttpServletResponse res) throws IOException {
		try {
		res.setContentType("text/html");
	PrintWriter pWriter =	res.getWriter();
	String cname = r.getParameter("country");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	simpleDateFormat.setTimeZone(TimeZone.getTimeZone(cname));
	simpleDateFormat.applyPattern("dd mmm yyyy HH:mm:ss z");
	RequestDispatcher rDispatcher = r.getRequestDispatcher("/CountryTime.html");
	rDispatcher.include(r, res);
	pWriter.println(simpleDateFormat.format(Calendar.getInstance().getTime()));
	
	} catch (ServletException e) {
				
				e.printStackTrace();
	} 
	

		
	}
	
	
}
