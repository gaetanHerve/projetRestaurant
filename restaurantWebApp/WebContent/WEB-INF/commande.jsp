<%@page import="model.LignePanier"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="model.Panier"%>
<%@page import="model.Client"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commande</title>
<link rel="stylesheet" href="style/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center my-4">
	<main>
		<header class="mb-4">
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
			        	Client clientMenu = (Client)session.getAttribute("client");
			        	boolean isClient = (clientMenu !=null && clientMenu.getId()!=0);
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
		</header>
		
		<%
			Client client = new Client();
			if (session.getAttribute("client") != null) {
				client = (Client) session.getAttribute("client");	
			}
			Panier panier = (Panier) session.getAttribute("panier");
		%>
		
		<section class="recap-articles">
			<h1>La commande de
				<c:out value="${client.getPrenom()}"/>
				<c:out value="${client.getNom()}"/>
				(Montant panier :
				<c:out value="${panier.getTotal()}€)"/>
			</h1>
			
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Articles</th>
			      <th scope="col">Quantité</th>
			      <th scope="col">Prix total</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="ligne" items="${panier.getLignes()}">
				    <tr>
				      <th scope="row"><c:out value="${ligne.getArticle().getNom()}" /></th>
				      <td><c:out value="${ligne.getQte()}"/></td>
				      <td><c:out value="${ligne.getPrixTotal()}"/></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<div class="row">
				<div class="col">
					<a href="./panier">
						<button type="button" class="btn btn-success impact-btn">
							Retour au panier
						</button>
					</a> 
				</div>
				<!-- RENAME ACTION!! -->
				<form class="col" action="recap" method="POST">
					<input type="hidden" name="prixTotal" value="${panier.getTotal()}">
					<button type="submit" style="float: right;" class="btn btn-success impact-btn">
						Valider la commande
					</button>
				</form>
			</div>
			
		</section>
		
		<section class="d-flex justify-content-center">
		<div>
			<img alt="banniere" src="images/banniere.PNG">
		</section>
	</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>