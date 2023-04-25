<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Commande"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Client"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commandes Passees</title>
<link rel="stylesheet" href="style/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
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
		</header>

<%

ArrayList<Commande> commandes = (ArrayList<Commande>)request.getAttribute("commandes"); // entre () : caster

%>
	
	<div id="recapCommandes" class="col m-2 mt-0">
				
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">ID Commandes</th>
				      <th scope="col">Jour</th>
				      <th scope="col">Prix total</th>
				      <th scope="col">Infos</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="c" items="${commandes}">
					    <tr>
					      <th scope="row"><c:out value="${c.getId()}" /></th>
					      <td><c:out value="${c.getJour()}"/></td>
					      <td><c:out value="${c.getPrixTotal()}"/></td>
					  	  <td><c:out value="${c.getInfos()}"/></td>
					    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</div>
	
	</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>