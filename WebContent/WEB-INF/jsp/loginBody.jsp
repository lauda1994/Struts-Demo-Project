<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://cdn.example.com/bootstrap.css">

<div class="container">
	<div class="row justify-content-end">
		<div class="col-6">
			<div class="card custom-card">
				<div class="card-body">
					<h5 class="card-title">Login Admin</h5>
					<form id="loginForm" action="Login.do" method="post">
						<div class="form-group">
							<label for="user">User:</label>
							<input class="form-control" type="text" id="user" name="username">
						</div>
						<div class="form-group">
							<label for="pw">Password:</label>
							<input class="form-control" type="password" id="pw" name="password">
						</div>
						<img class="right-image" src="https://icons.iconarchive.com/icons/aha-soft/free-large-boss/512/Admin-icon.png" alt="Immagine di esempio">
						<input id="loginButton" class="btn btn-primary" type="submit" value="Login">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<style>
	.custom-card {
		background-color: #feda66;
		max-width: 400px;
		margin-top: 100px;
		margin-right: 50px;
		height: 300px;
	}

	.right-image {
		border-radius: 15px;
		height: 100px;
		width: 70px;
	}

	#loginButton {
		position: relative;
		left: 50%;
		transform: translateX(-50%);
		width: 150px;
	}

	body {
		font-family: Oldtown, fantasy;;
		font-size: 14px;
	}

	h5.card-title {
		font-size: 18px;
	}
</style>
