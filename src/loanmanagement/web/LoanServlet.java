package loanmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loanmanagement.dao.LoanDAO;
import loanmanagement.model.Loan;

/**
 * Servlet implementation class LoanServlet
 */
@WebServlet("/")
public class LoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoanDAO loanDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoanServlet() {
    	this.loanDAO = new LoanDAO();
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertLoan(request, response);
			break;
		case "/delete":
			deleteLoan(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			updateLoan(request, response);
			break;
		default:
			//handle list
			listLoan(request, response);
			break;
		}
	}
	
	
	private void listLoan(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Loan> listLoan = loanDAO.selectAllLoan();
		request.setAttribute("listLoan", listLoan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loan-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void updateLoan(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String accNo = request.getParameter("accNo");
		String type = request.getParameter("type");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		
		Loan loan = new Loan(id, accNo, type, method, amount);
		try {
			loanDAO.updateLoan(loan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void deleteLoan(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			loanDAO.deleteLoan(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Loan existingLoan = loanDAO.selectLoan(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("loan-form.jsp");
		request.setAttribute("loan", existingLoan);
		dispatcher.forward(request, response);
	}
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("loan-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertLoan(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String accNo = request.getParameter("accNo");
		String type = request.getParameter("type");
		String method = request.getParameter("method");
		String amount = request.getParameter("amount");
		Loan newLoan = new Loan(accNo, type, method, amount);
		try {
			loanDAO.insertLoan(newLoan);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	

	
}
