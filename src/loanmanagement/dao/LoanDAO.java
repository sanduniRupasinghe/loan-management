package loanmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loanmanagement.model.Loan;

//This DAO class provides CRUD database operations for the table loans in the database
public class LoanDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_LOAN_SQL = "INSERT INTO loan" + " (accNo, type, method, amount) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_LOAN_BY_ID = "select id, accNo, type, method, amount from loan where id = ?";
	private static final String SELECT_ALL_LOAN = "select * from loan";
	private static final String DELETE_LOAN_SQL = "delete from loan where id = ?;";
	private static final String UPDATE_LOAN_SQL = "update loan set accNo = ?, type = ?, method = ?, amount = ? where id = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//insert loan
	public void insertLoan(Loan loan) throws SQLException {
		System.out.println(INSERT_LOAN_SQL);
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LOAN_SQL);){
			preparedStatement.setString(1, loan.getAccNo());
			preparedStatement.setString(2, loan.getType());
			preparedStatement.setString(3, loan.getMethod());
			preparedStatement.setString(4, loan.getAmount());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//update loan
	public boolean updateLoan(Loan loan) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_LOAN_SQL);){
			statement.setString(1, loan.getAccNo());
			statement.setString(2, loan.getType());
			statement.setString(3, loan.getMethod());
			statement.setString(4, loan.getAmount());
			statement.setInt(5, loan.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//select loan by id
	public Loan selectLoan(int id) {
		Loan loan = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOAN_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String accNo = rs.getString("accNo");
				String type = rs.getString("type");
				String method = rs.getString("method");
				String amount = rs.getString("amount");
				loan = new Loan(id, accNo, type, method, amount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loan;
	}
	
	//select loan
	public List<Loan> selectAllLoan() {
		List<Loan> loan = new ArrayList<>();
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOAN);){
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String accNo = rs.getString("accNo");
				String type = rs.getString("type");
				String method = rs.getString("method");
				String amount = rs.getString("amount");
				loan.add(new Loan(id, accNo, type, method, amount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loan;
	}
	
	//delete loan
	public boolean deleteLoan(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_LOAN_SQL);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
}
