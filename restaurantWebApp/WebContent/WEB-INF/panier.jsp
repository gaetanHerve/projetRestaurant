<%@page import="model.Carte"%>
<%@page import="model.Panier"%>
<%@page import="model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panier</title>
<link rel="stylesheet" href="style/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
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
			Carte carte = (Carte) application.getAttribute("carte");
		%>
		
		<div class="row mb-5" style="text-align: center">
			<h1>Fais ton propre repas</h1>
			<h3>La commande de
				<c:out value="${client.getPrenom()}"/>
				<c:out value="${client.getNom()}"/>
				(Montant panier :
				<c:out value="${panier.getTotal()}€)"/>
			</h3>
		</div>
		
		<div id="mainSection" class="row">
			<div id="selectionArticles" class="col m-2">
				<form action="panier" method="POST">
					 <label for="articles"><b>Fais ton choix parmis nos plats fait maison :</b></label>
					<select class="form-select mt-2" name="article" id="articles">
						<c:forEach var="article" items="${carte.getArticles()}">
					   		<option value="${article.getRef()}"><c:out value="${article.getNom()}"></c:out></option>
				   		</c:forEach>	
					</select>
					<div class="mt-2 mb-2" style="display: inline-block;">
						<label for="cars"><b>Quantité :</b></label>
						<input class="mt-2" type="number" name="quantity" value="1">
					</div>
					<button class="btn btn-secondary btn-sm" type="submit">Ajouter au panier</button>
				</form>
			</div>
			<div id="recapArticles" class="col m-2 mt-0">
				
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
			</div>
		</div>
		
		<form class="col" action="commande" method="POST">
			<input type="hidden" name="prixTotal" value="${panier.getTotal()}">
			<button type="submit" style="float: right;" class="btn btn-success impact-btn">
				Valider la commande
			</button>
		</form>
		
		<div class="d-flex justify-content-center flex-column">
			<img width="400px" class="d-block m-auto" alt="banniere" src="images/banniere.PNG">
		</div>
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>