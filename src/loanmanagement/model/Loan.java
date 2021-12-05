package loanmanagement.model;

public class Loan {
	private int id;
	private String accNo;
	private String type;
	private String method;
	private String amount;
	
	
	public Loan(int id, String accNo, String type, String method, String amount) {
		super();
		this.id = id;
		this.accNo = accNo;
		this.type = type;
		this.method = method;
		this.amount = amount;
	}
	
	
	
	public Loan(String accNo, String type, String method, String amount) {
		super();
		this.accNo = accNo;
		this.type = type;
		this.method = method;
		this.amount = amount;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	

}
