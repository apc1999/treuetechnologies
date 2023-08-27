package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class ParkingDAO {

	static Connection con=null;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingsystem ?user=root & password=sql@123");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
}
	public List<ParkingDTO> displaySpots(String location) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ParkingDTO> spots=new  ArrayList();
		
		String query="select spot_id,spot_number,location,spot_availability,price from parking_info where location=?";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, location);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
			      int spotId= rs.getInt(1);
			      int spotNumber=rs.getInt(2);
			      String loc=rs.getString(3);
			      int availbility=rs.getInt(4);
			      double price=rs.getDouble(5);
			      
			      ParkingDTO d1=new ParkingDTO();
			      
			      d1.setSpotId(spotId);
			      d1.setSpotNumber(spotNumber);
			      d1.setLocation(loc);
			      d1.setSpotAvailability(availbility);
			      d1.setPrice(price);
			      
			      spots.add(d1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return spots;
	}
	
	public int bookSpotInDb(String username, int spotId, String combinedCheckInDateTime, String combinedCheckOutDateTime) {
	    PreparedStatement pstmt = null;
	    ResultSet resultSet = null;
	    int count = 0;

	    String getUserIDQuery = "SELECT user_id FROM user_info WHERE username = ?";

	    try {
	        pstmt = con.prepareStatement(getUserIDQuery);
	        pstmt.setString(1, username);
	        resultSet = pstmt.executeQuery();

	        if (resultSet.next()) {
	            int userId = resultSet.getInt("user_id");

	            // Check spot availability
	            String checkSpotAvailabilityQuery = "SELECT spot_availability FROM parking_info WHERE spot_id = ?";
	            pstmt = con.prepareStatement(checkSpotAvailabilityQuery);
	            pstmt.setInt(1, spotId);
	            resultSet = pstmt.executeQuery();

	            boolean isSpotAvailable = false;
	            if (resultSet.next()) {
	                int availableCount = resultSet.getInt(1);
	                isSpotAvailable = availableCount > 0;
	            }
	            
	            // Insert booking information
	            String insertBookingQuery = "INSERT INTO booking_info (booking_id, user_id, spot_id, book_date, check_in, check_out, booking_status) VALUES (?,?,?,?,?,?,?)";
	            pstmt = con.prepareStatement(insertBookingQuery);
	            pstmt.setInt(1, 0);
	            pstmt.setInt(2, userId);
	            pstmt.setInt(3, spotId);
	            pstmt.setString(4, combinedCheckInDateTime); // Use combinedCheckInDateTime here
	            pstmt.setString(5, combinedCheckInDateTime);
	            pstmt.setString(6, combinedCheckOutDateTime);
	            pstmt.setBoolean(7, isSpotAvailable);

	            count = pstmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    
	    return count;
	}

	public int registerUser(String name, String contactNumber, String username, String password) {
		PreparedStatement pstmt=null;
		int count=0;
		
		String query="insert into user_info values(?,?,?,?,?)";
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,0);
			pstmt.setString(2, username);
			pstmt.setString(3,password);
			pstmt.setString(4, name);
			pstmt.setString(5, contactNumber);
			count=pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<ParkingDTO> getBookingInfo(String username) {
	    PreparedStatement getUserIdStmt = null;
	    PreparedStatement getBookingStmt = null;
	    ResultSet userRs = null;
	    ResultSet bookingRs = null;
	    ArrayList<ParkingDTO> bookingList = new ArrayList<>();

	    String getUserIdQuery = "SELECT user_id FROM user_info WHERE username = ?";
	    String getBookingQuery = "SELECT p.location, p.price, b.booking_id, b.book_date, b.check_in, b.check_out " +
	                             "FROM parking_info p " +
	                             "INNER JOIN booking_info b ON p.spot_id = b.spot_id " +
	                             "WHERE user_id = ?";

	    try {
	        // Get the user ID using the username
	        getUserIdStmt = con.prepareStatement(getUserIdQuery);
	        getUserIdStmt.setString(1, username);
	        userRs = getUserIdStmt.executeQuery();

	        if (userRs.next()) {
	            int userId = userRs.getInt("user_id");

	            // Get booking information using the obtained user ID
	            getBookingStmt = con.prepareStatement(getBookingQuery);
	            getBookingStmt.setInt(1, userId);
	            bookingRs = getBookingStmt.executeQuery();

	            while (bookingRs.next()) {
	                int bookingId = bookingRs.getInt("booking_id");
	                String location = bookingRs.getString("location");
	                double price = bookingRs.getDouble("price");
	                String bookDate = bookingRs.getString("book_date");
	                String checkIn = bookingRs.getString("check_in");
	                String checkOut = bookingRs.getString("check_out");

	                ParkingDTO parkingDTO = new ParkingDTO();
	                parkingDTO.setBookingId(bookingId);
	                parkingDTO.setLocation(location);
	                parkingDTO.setPrice(price);
	                parkingDTO.setBookDate(bookDate);
	                parkingDTO.setCheckIn(checkIn);
	                parkingDTO.setCheckOut(checkOut);

	                bookingList.add(parkingDTO);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Close the ResultSets and PreparedStatements in reverse order of creation
	        if (bookingRs != null) {
	            try {
	                bookingRs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (getBookingStmt != null) {
	            try {
	                getBookingStmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (userRs != null) {
	            try {
	                userRs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (getUserIdStmt != null) {
	            try {
	                getUserIdStmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return bookingList;
	}

}
