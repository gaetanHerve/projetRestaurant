<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
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
			          <a class="nav-link" href="authentification">Login</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="inscription">Inscription</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="panier">Mon Menu</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</header> <section class="d-flex justify-content-center">
	<div>
	
<form action="Inscription" method = "post">
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Identifiant</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Saisir un identifiant" name = "id">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Saisir un nom" name = "nom">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Prenom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Saisir un prenom" name = "prenom">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword" class="col-sm-5 col-form-label">Mot de passe</label>
    <div class="col-sm-7">
      <input type="password" class="form-control" id="inputPassword" placeholder="Saisir un mot de passe" name = "password">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Adresse</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Inidiquer une adresse" name = "adresse">
    </div>
  </div>
  
  <button type="submit" class="btn btn-light">Soumettre</button>
  
</form>
    
    <img alt="banniere" src="images/banniere.PNG">
    	
	</section> </main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>