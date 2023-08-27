package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.mysql.cj.xdevapi.PreparableStatement;

import Model.ParkingDAO;
import Model.ParkingDTO;

@WebServlet(urlPatterns = {"/searchlink","/bookspotlink","/registerlink","/bookinglink"})
public class ParkingController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String url = req.getServletPath();
		
        switch (url) {
            case "/searchlink":
                searchSpot(req, resp);
                break;
            case "/bookspotlink":
                bookSpot(req, resp);
                break;
            case "/registerlink":
            	registeruser(req,resp);
            	break;
            case "/bookinglink":
            	getBookingInfo(req,resp);
            	break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + url);     
        }

}

	private void getBookingInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession(true);
		if(ses!=null) {
			ParkingDAO p1=new ParkingDAO();
			 String username = (String) ses.getAttribute("username");
			 
			ArrayList<ParkingDTO> bookingList=p1.getBookingInfo(username);
			for(ParkingDTO b:bookingList) {
			b.getBookingId();
			b.getBookDate();
			b.getCheckIn();
			b.getCheckOut();
			b.getLocation();
			b.getPrice();
			}
			if(bookingList!=null) {
			ses.setAttribute("bookinglist", bookingList);
			RequestDispatcher rs=req.getRequestDispatcher("showbooking.jsp");
			
				rs.forward(req, resp);
			}else {
				
					resp.sendRedirect("home.jsp");	
			}
		}else {
			
				resp.sendRedirect("home.jsp");
			
		}
			
		
			
		
	}

	private void registeruser(HttpServletRequest req, HttpServletResponse resp) {
		String name=req.getParameter("name");
		String contactNumber=req.getParameter("phone");
		String username=req.getParameter("user");
		String password=req.getParameter("pass");
		 ParkingDAO p = new ParkingDAO();
		int count=p.registerUser(name,contactNumber,username,password);
		
		
	}

	private void bookSpot(HttpServletRequest req, HttpServletResponse resp) {
	    HttpSession ses = req.getSession();
	    if (ses != null) {
	        String username = (String) ses.getAttribute("username");
	        int spotId = Integer.parseInt(req.getParameter("spotId"));
	        String date = req.getParameter("bookdate");
	        String checkInTime = req.getParameter("checkintime");
	        String checkOutTime = req.getParameter("checkouttime");
	        
	        // Combine date and time into a valid datetime format
	        String combinedCheckInDateTime = date + " " + checkInTime;
	        String combinedCheckOutDateTime = date + " " + checkOutTime;
	        
	        ParkingDAO p = new ParkingDAO();
	        
	        int count = p.bookSpotInDb(username, spotId, combinedCheckInDateTime, combinedCheckOutDateTime);
	        System.out.println(count);
	        
	        if (count > 0) {
	            req.setAttribute("count", count);
	            RequestDispatcher rd = req.getRequestDispatcher("confirm.jsp");
	            try {
	                rd.forward(req, resp);
	            } catch (ServletException | IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                resp.sendRedirect("bookform.jsp");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	private void searchSpot(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			ParkingDAO p=new ParkingDAO();
			 String location=req.getParameter("loc");
			 
			 List<ParkingDTO> spots=p.displaySpots(location);
			 
			 

             req.setAttribute("spot",spots);
             
             RequestDispatcher rd=req.getRequestDispatcher("displayspots.jsp");
             try {
				rd.forward(req, resp);
			} catch (ServletException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
        }else {
        	try {
				resp.sendRedirect("home.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
		
	}
		
}

