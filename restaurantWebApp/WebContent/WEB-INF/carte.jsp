<%@ page import="java.util.List"%>
<%@page import="model.Article"%>
<%@page import="model.Panier"%>
<%@ page import="dao.DaoArticle"%>
<%@page import="model.Client"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="style/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carte</title>
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
		</header> <c:forEach var="article" items="${requestScope.article}">
		<div class="card" style="display: inline-block; width: 18rem;">

			<img src="${article.urlImage}" class="card-img-top"
				alt="photo ${article.nom}" style="width: 100%">
			<div class="card-body">
				<h5 class="card-title">${article.nom}</h5>
				<p class="card-text">${article.description}</p>
				<div class="d-flex align-items-end">
					<p class="card-text align-items-end">${article.tarif}€</p>
				</div>
				<div class="d-flex align-items-end">
					<form action="panier" method="post">
					<input name="article" type ="hidden" value="${article.ref}">
						<button type="submit" class="btn btn-primary">Panier</button>
					</form>
				</div>

			</div>

		</div>
	</c:forEach> </main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>