<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Authentification</title>
<link rel="stylesheet" href="style/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center my-4">
	<main> <header class="mb-4">
			<img alt="logo" src="images/logo.jpg">
			<nav class="navbar navbar-expand-lg bg-success">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="./accueil.jsp">Eat & Love</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="carte">Notre carte</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="panier">Mon Menu</a>
			        </li>
			        <%
			        	Client client = (Client)session.getAttribute("client");
			        	boolean isClient = (client !=null && client.getId()!=0);
			        %>
			        <%if(isClient){%>
			        	<li class="nav-item">
			          		<a class="nav-link" href="compte.jsp">Compte</a>
			        	</li>
			        	<li class="nav-item">
			          		<a class="nav-link" href="deco">Déconnexion</a>
			        	</li>
			        <%} %>
			        <%if(!isClient){%>
			        	<li class="nav-item">
				          <a class="nav-link" href="authentification">Login</a>
				        </li>
				        <li class="nav-item">
				          <a class="nav-link" href="inscription">Inscription</a>
				        </li>
			        <%} %>
			      </ul>
			    </div>
			  </div>
			</nav>
		</header> <section class="d-flex justify-content-center">

		<form action="getauthentification" >
		
			<div class="form-outline mb-4">
				Indentifiant : <input type="text" id="form2Example1"
					class="form-control" placeholder="Saisir votre identifiant"
					name="identifiant" /> <label class="form-label"
					for="form2Example1"></label>
			</div>

			<div class="form-outline mb-4">
				Mot de passe : <input type="password" id="form2Example2"
					class="form-control" placeholder="Saisir votre mot de passe"
					name="password" /> <label class="form-label" for="form2Example2"></label>
			</div>

			<div class="row mb-4">
				<div class="col d-flex justify-content-center">
					<div class="form-check">
						<input type="checkbox" /> <label class="form-check-label"
							for="form2Example31">Se souvenir de moi</label>
					</div>
				</div>

			</div>

			<button type="submit" class="btn btn-light">Se connecter</button>
			
		</form>
		
</body>
</html>