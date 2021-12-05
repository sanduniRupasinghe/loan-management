<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Online Banking System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: #A9CCE3;">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #5F6A6A">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Online Banking System </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Loan List</a></li>
					
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${loan != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${loan == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${loan != null}">
            			Edit Loan
            		</c:if>
						<c:if test="${loan == null}">
            			Add New Loan
            		</c:if>
					</h3> 
				</caption> <br>

				<c:if test="${loan != null}">
					<input type="hidden" name="id" value="<c:out value='${loan.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Account No</label> <input type="text"
						value="<c:out value='${loan.accNo}' />" class="form-control"
						name="accNo" pattern = "[0-9]{10}" required="required">
				</fieldset>

				<div class="form-group">
                               <label>Loan Type</label>
                                <select id="inputState"  class="form-control" name="type" required>
                                    <option value="Home Loan">Home Loan</option>
                                    <option value="Personal Loan">Personal Loan</option>
                                    <option value="Auto Loan">Auto Loan</option>
                                    <option value="Student Loan">Student Loan</option>
                                </select>
                            </div>
				
				<div class="form-group">
                               <label>Payment Method</label>
                                <select id="inputState"  class="form-control" name="method" required>
                                    <option value="Cash">Cash</option>
                                    <option value="Checks">Checks</option>
                                    <option value="Debit Cards">Debit Cards</option>
                                    <option value="Mobile Payments">Mobile Payments</option>
                                </select>
                            </div>

				<fieldset class="form-group">
					<label>Loan Amount</label> <input type="text"
						value="<c:out value='${loan.amount}' />" class="form-control"
						name="amount" required="required">
				</fieldset>

				<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
	</div><br><br>
	
	<!-- Footer -->
<footer style="background: #5F6A6A;" class="page-footer font-small blue">
  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2021 Copyright:
    <a href="https://codedec.com/"> OnlineBanking.com</a>
  </div>
</footer>
<!-- Footer -->
</body>
</html>