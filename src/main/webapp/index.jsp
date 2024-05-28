<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	width: 100%;
	height: 100vh;
}

.navbar {
	padding: 10px;
	text-align: center;
	vertical-align: middle;
}

.navbar img {
	max-width: 100px; /* Increased image size */
	margin-right: 10px;
	vertical-align: middle;
}

.navbar span {
	font-size: 40px; /* Increased font size */
	font-weight: bold;
	vertical-align: middle;
}

.navbar a {
	display: flex; /* To align items to the left */
	align-items: center; /* To vertically center items */
	align-content: center;
	justify-content: flex-start; /* To move items to the left */
	text-decoration: none; /* Remove underline */
	vertical-align: middle;
}

.section1 {
	display: flex;
	flex-direction: row;
	height: 100%;
}

.row {
	text-align: center;
	min-width: 280px;
	width: 300px;
	height: 100%;
	padding-bottom: 10px;
}

.col-md-2 {
	height: 100vh;
	text-align: center;
	align-items: center;
}

form {
	text-align: center;
	margin: auto;
	width: 100px;
	align-items: center;
}

#lgButton {
	text-align: center;
	margin: auto;
	width: 150px;
}

.map {
	width: 100%;
	height: 100vh;
}

.FreeMap {
	height: 100vh;
}

.form-group {
	margin: auto;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
}

input[type="text"], input[type="password"], input[type="email"] {
	width: 250px;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
	margin: 8px auto;
	display: block;
}

input[placeholder] {
	text-align: center;
}

@media screen and (max-width:800px) {
	* {
		padding: 0;
		margin: 0;
	}
	.section1 {
		display: flex;
		flex-direction: column;
		height: 100vh;
	}
	.row {
		margin: auto;
		align-items: center;
		width: 100%;
	}
	.col-md-2 {
		width: 100%;
		height: 100%;
		margin: 0;
		margin: auto;
	}
}
</style>
<title>Navbar with Sidebar</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp"> <img src="images/R.png"
			alt="Weather Logo" height="50" class="d-inline-block align-top">
			Weatherly
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Services</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
			</ul>
		</div>
	</nav>

	<section class="section1">
		<div class="row">
			<div class="col-md-11 bg-dark text-light">
				<!-- Sidebar Content Here -->
				<button class="btn btn-primary btn-block mt-3" id="lgButton"
					type="button" data-toggle="collapse" data-target="#loginCollapse"
					aria-expanded="false" aria-controls="loginCollapse">Log In</button>
				<div class="collapse" id="loginCollapse">

					<form action="LoginServlet" method="post">
						<div class="form-group">
							<!-- <label for="username">Username</label> -->
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Username">
						</div>
						<div class="form-group">
							<!-- <label for="password">Password </label> -->
							<input type="password" class="form-control" id="password"
								name="password" placeholder="Password">
						</div>
						<button type="submit" class="btn btn-primary btn-block">Log
							In</button>
					</form>

				</div>
				<form action="signup.jsp" method="post">
					<button type="submit" class="btn btn-success btn-block mt-3">Sign
						In</button>
				</form>
			</div>
		</div>

		<div class="map">
			<div class="FreeMap">
				<!--<iframe
					src="https://owm-inc.github.io/VANE-intro/apps/leaflet-owm.html"
					frameborder="0" width="100%" height="100%"> </iframe> -->
		<iframe
    src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d16492108.250543837!2d79.25861124689348!3d21.539118401480216!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e1!3m2!1sen!2sin!4v1707155400630!5m2!1sen!2sin"
    width="100%" height="100%" style="border: 0;"
    allowfullscreen="" loading=auto referrerpolicy="no-referrer-when-downgrade"
    title="Interactive Google Map" aria-label="Interactive Google Map"
></iframe>
			</div>
		</div>
	</section>


	<footer class="footer mt-auto py-3 bg-dark text-white">
		<div class="container text-center">
			<span>&copy; 2023 Your Weatherly App. All rights reserved.</span>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
