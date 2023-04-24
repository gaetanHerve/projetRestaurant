<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body class="d-flex justify-content-center my-4">
	<main>
		<header class="mb-4">
			<img alt="logo" src="images/logo.jpg">
			<nav class="navbar navbar-expand-lg bg-success">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="accueil.html">Eat & Love</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="carte.html">Notre carte</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Login</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Inscription</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Mon Menu</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</header>
		
		<section class="carousel_img">
		
			<div id="carouselExample" class="carousel slide">
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="images/salade-Caprese.jpg" class="" alt="salade capresse">
			    </div>
			    <div class="carousel-item">
			      <img src="images/lasgnes.jpg" class="" alt="lasagnes">
			    </div>
			    <div class="carousel-item">
			      <img src="images/tiramisu1.png" class="" alt="tiramisu">
			    </div>
			  </div>
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
		
		</section>
		
		<section class="d-flex justify-content-center">
		<div>
			<img alt="banniere" src="images/banniere.PNG">
			
			<div class="mt-3 w-100">
			  <div class="mt-4 p-4 bg-light text-dark">
			    <h1>Contact</h1> 
			    <p>Paris,France</p> 
			    <form action="Servlet1" method="post">
			       <br>  
			       <input type="text" name="nom" placeholder="Nom">
			       <input type="email" name="email" placeholder="Email">
			       <input type="text" name="avis" placeholder="Laissez votre commentaire">
			      <input type="submit" value="Submit">
				
				</form>
			  </div>
			</div>
		</div>
			
		</section>
		
		
	
	</main>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>