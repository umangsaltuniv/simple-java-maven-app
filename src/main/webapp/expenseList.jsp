<html>
<head>
<title>Expense List data</title>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>


<style>

body { 
	background-color:#dcddd3
}
</style>
</head>
<body>
<%@ include file="index.html"%>
	<div class="container">
		<h3>Expense List</h3>
		<!--${expeseList}  -->

		<table class="table table-striped table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Date<span style="font-size:8pt; color: grey">(YYYY-MM-DD)</span></th>
					<th scope="col">ExpenseHead</th>
					<th scope="col">Amount</th>
					<th scope="col">Currency</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${expeseList}" var="expense">
					<tr>
						<td>${expense.date}</td>
						<td>${expense.expenseHead}</td>
						<td>${expense.amount}</td>
						<td>${expense.currency}</td>
						<td align="center">
						<button type="button" class="btn btn-primary"><a href="${pageContext.request.contextPath}/edit/${expense.id}"><span style="color: white;"><i class="far fa-edit"></i> Edit</span></a></button>
						<button type="button" class="btn btn-danger"><a href="${pageContext.request.contextPath}/delete/${expense.id}"><span style="color: white;"><i class="far fa-trash-alt"></i> Delete</span></a></button>
						<%-- [<a
							href="${pageContext.request.contextPath}/edit/${expense.id}">Edit</a>]
							&nbsp; --%> <%-- [<a
							href="${pageContext.request.contextPath}/delete/${expense.id}">Delete</a>] --%>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>