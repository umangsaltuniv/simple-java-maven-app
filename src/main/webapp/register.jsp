<html>
<head>
<title>User registration page</title>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<style>
body {
	/* The image used */
	background-image:
		url("${pageContext.request.contextPath}/images/bank-notes.jpg");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<!-- <h3>Welcome, Enter The User Details</h3> -->

	<div
		class="d-flex justify-content-center align-items-center container ">
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-6 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h2 class="card-title text-center">User Registration Form</h2>
							<c:if test="${not empty ErrorText}">
								<h5 class="text-center alert alert-warning">${ErrorText}</h5>
							</c:if>


							<div class="Absolute-Center is-Responsive">

								<form:form method="POST" modelAttribute="User"
									action="/add-user">
									
									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Name</label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="text" path="name" value="${User.name}" />
											</div>
										</div>
									</div>

									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Username</label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="text" path="username"
													value="${User.username}" />
											</div>
										</div>
									</div>
									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Password</label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="password" path="password"
													value="${User.password}" />
											</div>
										</div>
									</div>
									
									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Currency</label>
										</div>
										<div class="col-md-3">
											<div>
												<form:select class="form-control" path="currency"
													value="${User.currency}" >
													<option value="INR" selected>INR</option>
													<option value="USD">USD</option>
													<option value="YEN">YEN</option>
													<option value="EUR">EUR</option>
												</form:select>
												<%-- 	<form:input path="currency" value="${User.currency}"  /> --%>
											</div>
										</div>
									</div>
									

									<div class="row my-5">
										<div class="col-4"></div>
										<div class="col-4">
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