<html>
<head>
<title>Login page</title>
<%@ include file="link.jsp"%>
<%@ include file="script.jsp"%>
<style>

body { 
  /* The image used */
  background-image: url("${pageContext.request.contextPath}/images/bank-notes.jpg");

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
	<div
		class="d-flex justify-content-center align-items-center container ">
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<h3 class="card-title text-center mt-2 mb-5">Expense Tracker</h3>
							<div class="Absolute-Center is-Responsive">
								<c:if test="${not empty error}">
									<div class="error">${error}</div>
								</c:if>

								<c:url value="/login" var="login" />
								<form:form action="/login" method="post">


									<div class="form-group">
										<div class="row">
											<div class="col-3">
												<label>Username:</label>
											</div>
											<div class="col-9">
												<input type="text" name="username">
											</div>
										</div>


									</div>
									<div class="form-group">
										
											
															<div class="row">
											<div class="col-3">
												<label>Password:</label>
											</div>
											<div class="col-9">
												 <input type="password"
											name="password">
											</div>
										</div>
										

									</div>
									<div class="row">
										<div class="col-6 justify-content-center">

											<input type="submit" name="submit"
												class="btn btn-primary btn-md btn-block" value="Login" />

										</div>
										<div class="col-6 justify-content-center">

											<!-- <input type="submit" name="submit"
											class="btn btn-success btn-lg" value="Register" /> -->
											<a class="btn btn-secondary btn-md btn-block" href="/add-user">Register</a>

										</div>
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