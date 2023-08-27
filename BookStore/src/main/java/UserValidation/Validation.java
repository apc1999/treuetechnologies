package UserValidation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginlink")
public class Validation extends HttpServlet {
		Connection con=null;
		

	    @Override
	    public void init() throws ServletException {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?user=root&password=sql@123");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				 String user = req.getParameter("username");
	      	      String pass = req.getParameter("password");

		        PreparedStatement stmt = null;
		        ResultSet rs = null;
		        String query = "select username, password from user_info where username = ? and password = ?";

		        try {
		            stmt = con.prepareStatement(query);
		           
		            stmt.setString(1, user);
		            stmt.setString(2, pass);
		            rs = stmt.executeQuery();

		            if (rs.next()) {
		            	String dbusername=rs.getString(1);
		            	String dbpassword=rs.getString(2);
		            	if (user.contains(dbusername)||(pass.contains(dbpassword))) {
		            		HttpSession ses = req.getSession(true);
		            		ses.setAttribute("username",dbusername);
		            		
			                RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			                rd.forward(req, resp);
		            	}  else {
			                resp.sendRedirect("userlogin.html");
			            }
		            } 
		        } catch (SQLException e) {
		            e.printStackTrace();
		            
		        } 
			}
	    
            
            

}
