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
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link">Add Loan</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="container col-md-11">
		<div class="card">
			<div class="card-body">
			<h3 class="text-center">List of Loans</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Add New Loan</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Account No</th>
						<th>Loan Type</th>
						<th>Payment Method</th>
						<th>Loan Amount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="loan" items="${listLoan}">

						<tr>
							<td><c:out value="${loan.id}" /></td>
							<td><c:out value="${loan.accNo}" /></td>
							<td><c:out value="${loan.type}" /></td>
							<td><c:out value="${loan.method}" /></td>
							<td><c:out value="${loan.amount}" /></td>
							<td><a href="edit?id=<c:out value='${loan.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${loan.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
				</div>
	</div></div><br><br><br><br>
	
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