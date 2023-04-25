<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Carte"%>
<%@page import="model.Panier"%>
<%@page import="model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Récapitulatif</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="style/style.css">
</head>
<body class="d-flex justify-content-center my-4">
	<main>
		<header class="mb-4">
			<img alt="logo" src="images/logo.jpg">
			<nav class="navbar navbar-expand-lg bg-success">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="accueil.jsp">Eat & Love</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="carte.jsp">Notre carte</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="authentification.jsp">Login</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="inscription.jsp">Inscription</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="menu.jsp">Mon Menu</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</header>
		
		<%
			if (session.getAttribute("client") != null) {
				Client client = (Client) session.getAttribute("client");	
			} else {
				Client client = new Client();
			}
			Panier panier = (Panier) session.getAttribute("panier");
		%>	
		
		<section class="d-flex align-items-center flex-column">
			<p class="text-success recap">Félicitation <c:out value="${client.getPrenom()}"/> <c:out value="${client.getNom()}"/>.
			<br>Votre commande est validée.<br>
			Le montant total est de <c:out value="${request.getAttribute("prixTotal")}€"/></p>
			<img alt="photo bon appetit" width="200px" src="images/validee.jpg">
		</section>
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>