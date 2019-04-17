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

.required {
	color: red;
}
</style>

<script type="text/javascript">
	function validate() {
		var name = document.getElementById("name").value;
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		console.log("name : ", name);
		console.log("name.length : ", name.length);

		if (name == "" || username == "" || password == "") {
			alert("Please enter mandatory fields");
			return false;
		} else if (name.length < 5 || username.length < 5
				|| password.length < 5) {
			alert("Name, Username and Password should be at least 5 characters")
			return false;
		} else {
			return true;
		}

	}
</script>
</head>
<body>
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

							<c:if test="${not empty SuccessText}">
								<h5 class="text-center alert alert-success">${SuccessText}
									<a href="/login.jsp">Login</a>
								</h5>
							</c:if>


							<div class="Absolute-Center is-Responsive">

								<form:form method="POST" modelAttribute="User"
									onsubmit="return validate()" action="/add-user"
									name="registerForm" id="registerForm">

									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name" class="control-label">Name<span
												class="required">*</span></label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="text" path="name" id="name"
													value="${User.name}" />
											</div>
										</div>
									</div>

									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Username<span class="required">*</span></label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="text" path="username" id="username"
													value="${User.username}" />
											</div>
										</div>
									</div>
									<div class="row my-5">
										<div class="col-md-3 field-label-responsive">
											<label for="name">Password<span class="required">*</span></label>
										</div>
										<div class="col-md-3">
											<div>
												<form:input type="password" path="password" id="password"
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
													id="currency" value="${User.currency}">
													<option value="INR" selected>INR</option>
													<option value="USD">USD</option>
													<option value="YEN">YEN</option>
													<option value="EUR">EUR</option>
												</form:select>
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
								<div class="row my-5">
								<div class="col-4"></div>
								<div class="col-4">
									<button type="submit" class="btn btn-success btn-block">
										<a href="/login.jsp"><span style="color: white;">Login
									</button>
								</div>
								</div>
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