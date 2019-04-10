<html>
<head>
<title>Expense List data</title>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<%@ include file="index.html"%>

<style>
body {
	background-color: #dcddd3
}
</style>

<script type="text/javascript">
	window.setTimeout(function() {
		$("#deleteAlert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2000);
</script>



</head>
<body>

	<div class="container">
		<h3>Expense List</h3>

		<c:if test="${not empty msg}">
			<div id="deleteAlert" class="alert alert-success">
				<a id="linkClose" href="#" class="close">&times;</a> <strong>${msg}</strong>
			</div>
		</c:if>

		<table class="table table-striped table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Date<span style="font-size: 8pt; color: grey">(YYYY-MM-DD)</span></th>
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
							<button type="button" class="btn btn-primary">
								<a href="${pageContext.request.contextPath}/edit/${expense.id}"><span
									style="color: white;"><i class="far fa-edit"></i> Edit</span></a>
							</button>
							<button id="btnDelete" class="btn btn-danger">
								<a
									href="${pageContext.request.contextPath}/delete/${expense.id}"
									onclick="return confirm(' Confirm! Do you want to delete expense?')"><span
									style="color: white;"><i class="far fa-trash-alt"></i>
										Delete</span></a>
							</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<%@ include file="footer.html"%>
</body>
</html>