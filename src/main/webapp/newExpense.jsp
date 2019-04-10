<html>
<head>
<%@ include file="index.html"%>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<title>Add new Expense</title>

<style>

body { 
	background-color:#dcddd3
}
</style>
</head>
<body>
	<div
		class="d-flex justify-content-center align-items-center container ">
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-md-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h3 class="card-title text-center">
								<c:if test="${not empty Expense.id}">Edit Expense</c:if> 
								<c:if test="${empty Expense.id}">New Expense</c:if>
							</h3>
							<div class="Absolute-Center is-Responsive">
							
							
							<c:if test="${not empty SuccessText}">
								<h5 class="text-center alert alert-success">${SuccessText} <a href="/expense-list">Expense List</a> </h5>
							</c:if>
							
							
								<form:form class="form-horizontal" method="post"
									modelAttribute="Expense" id="submitForm"
									action="${pageContext.request.contextPath}/submit-form">

									<div class="row my-5">
										<div class="col-sm-5 field-label-responsive">
											<label for="name">Date:</label>
										</div>
										<div class="col-md-5">
											<div>
												<form:input type="date" path="date" value="${Expense.date}" />
											</div>
										</div>
									</div>

									<div class="row my-5">
										<div class="col-sm-5 field-label-responsive">
											<label for="name">ExpenseHead:</label>
										</div>
										<div class="col-md-5">
											<div>

												<form:select class="form-control" path="expenseHead"
													value="${Expense.expenseHead}">
													<form:option value="Taxi" label="Taxi" />
													<form:option value="Meal" label="Meal" />
													<form:option value="Travel" label="Travel" />
													<form:option value="Stationary" label="Stationary" />
												</form:select>

											</div>
										</div>
									</div>

									<div class="row my-5">
										<div class="col-sm-5 field-label-responsive">
											<label for="name">Amount:</label>
										</div>
										<div class="col-md-5">
											<div>
												<form:input type="number" path="amount"
													value="${Expense.amount}" />
											</div>
										</div>
									</div>

									<div class="row my-5">
										<div class="col-sm-5 field-label-responsive">
											<label for="name">Currency:</label>
										</div>
										<div class="col-md-5">
											<div>
												<form:select class="form-control" path="currency"
													value="${Expense.currency}">
													<!-- <option value="INR">INR</option>
													<option value="USD">USD</option>
													<option value="YEN">YEN</option>
													<option value="EURO">EURO</option> -->
													<form:option value="INR" label="INR" />
													<form:option value="USD" label="USD" />
													<form:option value="YEN" label="YEN" />
													<form:option value="EUR" label="EUR" />
												</form:select>
											</div>
										</div>
									</div>




									<div class="row my-5">
										<div class="col-4"></div>
										<div class="col-4">
											<form:input type="hidden" path="userId"
												value="${Expense.userId}" />
											<form:input type="hidden" path="id" value="${Expense.id}" />
											<button type="submit" class="btn btn-primary btn-block">Save</button>
										</div>
										<div class="col-4"></div>
									</div>

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
</body>
</html>