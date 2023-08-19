package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

public class BookDAO {
	static Connection con=null;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book?user=root & password=sql@123");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
}
	public ArrayList<BookDTO> getBooksByCategory(String category) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    ArrayList<BookDTO> bookList = new ArrayList<>();
	    String query = "select book_id,book_name, book_author, price, category from book_details where category=?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, category);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	int bookId=rs.getInt("book_id");
	            String bookName = rs.getString("book_name");
	            String bookAuthor = rs.getString("book_author");
	            double price = rs.getDouble("price");
	            String bookCategory = rs.getString("category");

	            BookDTO book = new BookDTO();
	            book.setBookId(bookId);
	            book.setBookName(bookName);
	            book.setBookAuthor(bookAuthor);
	            book.setBookPrice(price);
	            book.setBookCategory(bookCategory);

	            bookList.add(book);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    
	    }
	    return bookList;
	}
	public int addToCart(int bookId, String username, int qty) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int  count=0;
		
		String query="select user_id from user_info where username=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,username);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			int userId=rs.getInt("user_id");
			
			String query1="insert into cart_details values(?,?,?,?)";
			pstmt=con.prepareStatement(query1);
			pstmt.setInt(1,0);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, bookId);
			pstmt.setInt(4, qty);
		    count=pstmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public ArrayList<BookDTO> getBooksFromCart(String username) {
	    PreparedStatement pstmt1 = null; // Use separate PreparedStatement instances
	    PreparedStatement pstmt2 = null;
	    ResultSet rs1 = null; // Use separate ResultSet instances
	    ResultSet rs2 = null;
	    ArrayList<BookDTO> bookList = new ArrayList<>();

	    String getUserIdQuery = "SELECT user_id FROM user_info WHERE username=?";
	    String getBooksQuery = "SELECT b.book_id, b.book_name, b.book_author, b.price, b.category, c.quantity FROM book_details b INNER JOIN cart_details c ON b.book_id=c.book_id WHERE c.user_id=?";

	    try {
	        pstmt1 = con.prepareStatement(getUserIdQuery);
	        pstmt1.setString(1, username);
	        rs1 = pstmt1.executeQuery();

	        if (rs1.next()) {
	            int userId = rs1.getInt("user_id");

	            pstmt2 = con.prepareStatement(getBooksQuery);
	            pstmt2.setInt(1, userId);
	            rs2 = pstmt2.executeQuery();

	            while (rs2.next()) {
	                int bookId = rs2.getInt("book_id");
	                String name = rs2.getString("book_name");
	                String author = rs2.getString("book_author");
	                double price = rs2.getDouble("price");
	                String category = rs2.getString("category");
	                int qty = rs2.getInt("quantity");

	                BookDTO book = new BookDTO();
	                book.setBookId(bookId);
	                book.setBookName(name);
	                book.setBookAuthor(author);
	                book.setBookPrice(price*qty);
	                book.setBookCategory(category);
	                book.setQty(qty);

	                bookList.add(book);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return bookList;
	}
	
		public int placedOrder(String username, int bookId, double price) {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    int count = 0;
		    String query = "SELECT user_id FROM user_info WHERE username=?";
		    try {
		        pstmt = con.prepareStatement(query);
		        pstmt.setString(1, username);
		        rs = pstmt.executeQuery();
		        if (rs.next()) {
		            int userId = rs.getInt("user_id");
		            
		            String insertQuery = "INSERT INTO order_details (order_id, user_id, book_id, price) VALUES (?, ?, ?, ?)";
		            pstmt = con.prepareStatement(insertQuery);
		            pstmt.setInt(1, 0);  // Assuming order_id is auto-incremented in the database
		            pstmt.setInt(2, userId);
		            pstmt.setInt(3, bookId);
		            pstmt.setDouble(4, price);
		            count = pstmt.executeUpdate();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }   
		        
		return count;
	}
		public ArrayList<BookDTO> getOrders(String username) {
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    ArrayList<BookDTO> orderList = new ArrayList<BookDTO>();
		    String queryUserId = "SELECT user_id FROM user_info WHERE username=?";
		    String queryOrders = "SELECT b.book_name, b.book_author, b.category, o.totalamt FROM book_details b INNER JOIN order_details o ON b.bookId = o.bookId WHERE o.user_id=?";
		    
		    try {
		        pstmt = con.prepareStatement(queryUserId);
		        pstmt.setString(1, username);
		        rs = pstmt.executeQuery();
		        
		        if (rs.next()) {
		            int userId = rs.getInt("user_id");
		            pstmt = con.prepareStatement(queryOrders);
		            pstmt.setInt(1, userId);
		            rs = pstmt.executeQuery();
		            
		            while (rs.next()) {
		                String bookName = rs.getString("book_name");
		                String bookAuthor = rs.getString("book_author");
		                String category = rs.getString("category");
		                double price = rs.getDouble("totalamt");
		                
		                BookDTO b1 = new BookDTO();
		                b1.setBookName(bookName);
		                b1.setBookAuthor(bookAuthor);
		                b1.setBookCategory(category);
		                b1.setBookPrice(price);
		                
		                orderList.add(b1);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } 
		    
		    return orderList;
		}
		public int rateAndComment(String username, int bookId, int rating, String comment) {
		    PreparedStatement pstmt = null;
		    int count = 0;
		    String getUserIdQuery = "SELECT user_id FROM user_info WHERE username=?";
		    String insertReviewQuery = "INSERT INTO review_info (user_id, book_id, rating, comment) VALUES (?, ?, ?, ?)";

		    try {
		        pstmt = con.prepareStatement(getUserIdQuery);
		        pstmt.setString(1, username);
		        ResultSet rs = pstmt.executeQuery();

		        if (rs.next()) {
		            int userId = rs.getInt("user_id");

		            pstmt = con.prepareStatement(insertReviewQuery);
		            pstmt.setInt(1, userId);
		            pstmt.setInt(2, bookId);
		            pstmt.setInt(3, rating);
		            pstmt.setString(4, comment);
		            count = pstmt.executeUpdate();
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    } 
		    return count;
		}

}
