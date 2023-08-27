package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BookDAO;
import Model.BookDTO;
@WebServlet(urlPatterns = {"/searchlink","/addtocartlink","/cartlink","/bookinglink","/orderslink","/ratecommentbooklink"})
public class BookController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getServletPath();
		
		switch(url) {
		case "/searchlink":
			 searchByCategory(req,resp);
			 break;
		case "/addtocartlink":
			addBookInCart(req,resp);
			break;
		case"/cartlink":
			getCartBook(req,resp);
			break;
		case"/bookinglink":
		     placedOrder(req,resp);
		     break;
		case"/orderslink":
			getOrders(req,resp);
			break;
		case"/ratecommentbooklink":
			rateAndComment(req,resp);
			break;
		default:
            throw new IllegalArgumentException("Unexpected value: " + url);    
		}
	}

	private void rateAndComment(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			String username=(String) ses.getAttribute("username");
			int bookId=Integer.parseInt(req.getParameter("bookId"));
			int rating=Integer.parseInt(req.getParameter("rating"));
			String comment=req.getParameter("comment");
			BookDAO b1=new BookDAO();
			int count=b1.rateAndComment(username,bookId,rating,comment);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	private void getOrders(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			String username=(String) ses.getAttribute("username");
			BookDAO b1=new BookDAO();
			ArrayList<BookDTO>ordersList=b1.getOrders(username);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	private void placedOrder(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			String username=(String) ses.getAttribute("username");
			int bookId=Integer.parseInt(req.getParameter("bookId"));
			double price=Double.parseDouble(req.getParameter("bookPrice"));
			BookDAO b1=new BookDAO();
			int count=b1.placedOrder(username,bookId,price);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	private void getCartBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		if(ses!=null) {
		String username=(String) ses.getAttribute("username");
		BookDAO b1=new BookDAO();
		ArrayList<BookDTO> booklist=b1.getBooksFromCart(username);
		ses.setAttribute("list", booklist);
		RequestDispatcher rd=req.getRequestDispatcher("displaycart.jsp");
		rd.forward(req, resp);
		}
		
	}

	private void addBookInCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			int bookId=Integer.parseInt(req.getParameter("bookId"));
			String username=(String) ses.getAttribute("username");
			int qty=Integer.parseInt(req.getParameter("quantity"));
			BookDAO d1=new BookDAO();
			int count=d1.addToCart(bookId,username,qty);
			ses.setAttribute("count", count);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		
	}

	private void searchByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		if (ses!=null) {
			String book=req.getParameter("searchbook");
			
			BookDAO b1=new BookDAO();
			ArrayList<BookDTO> bookList=b1.getBooksByCategory(book);
			
			req.setAttribute("list",bookList);
			RequestDispatcher rd=req.getRequestDispatcher("book.jsp");
			rd.forward(req, resp);
		}else {
			resp.sendRedirect("home.jsp");
		}
		}
		
	}
	


