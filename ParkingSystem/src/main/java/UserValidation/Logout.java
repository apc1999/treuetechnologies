package UserValidation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logoutlink")
public class Logout extends HttpServlet{
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ses=req.getSession(false);
		//to stop the Session and then send to login.html page
		ses.invalidate();
		resp.sendRedirect("index.html");
		}
	}

