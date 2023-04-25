<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
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
		
		<section class="carousel_img">
		
			<div id="carouselExample" class="carousel slide">
			 <div class="carousel-indicators">
			    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
			    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
			    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
			  </div>
			  <div class="carousel-inner">
			    <div class="carousel-item active">
			      <img src="images/salade-Caprese.jpg" class="" alt="salade capresse">
			      <div class="carousel-caption d-none d-md-block commentaires">
			        <h4 class="text-dark">Tomates de nos régions</h4>
			      </div>
			    </div>
			    <div class="carousel-item">
			      <img src="images/lasgnes.jpg" class="" alt="lasagnes">
			      <div class="carousel-caption d-none d-md-block commentaires">
			        <h4 class="text-dark">Pâtes faites maison !</h4>
			      </div>
			    </div>
			    <div class="carousel-item">
			      <img src="images/tiramisu1.png" class="" alt="tiramisu">
			      <div class="carousel-caption d-none d-md-block commentaires">
			        <h4 class="text-dark">Cacao du jardin</h4>
			      </div>
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
		
		<section class="d-flex justify-content-center flex-column">
			<img width="400px" class="d-block m-auto" alt="banniere" src="images/banniere.PNG">
			
			<div class="mt-3 contact">
			  <div class="mt-4 p-4 bg-light text-dark">
			    <h1>Contact</h1> 
			    <div class="d-flex">
			    	<div class="w-50">
			    		<p>Paris,France</p>
			    	</div>
			    	
			    	<div class="w-50">
				    	<form action="" method="">
					    	<div class="form-group">
						    	<input type="text" class="form-control m-3" name="nom" placeholder="Nom">
						       <input type="email" class="form-control m-3" name="email" placeholder="Email">
						       <textarea class="form-control m-3" name="avis" placeholder="Laissez votre commentaire"></textarea>
								<input class="btn btn-primary mt-3" value="Envoyer" data-bs-toggle="modal" data-bs-target="#myModal">
					    	</div>
						</form>
			    	</div>			    	
				    
			    </div>
			    
			    
			  </div>
			</div>
			
			
		</section>
		
		<section>
			
			<!-- Modal -->
			<div class="modal" id="myModal">
			  <div class="modal-dialog">
			    <div class="modal-content">
			
			      <!-- Modal Header -->
			      <div class="modal-header">
			        <h4 class="modal-title">Commentaire</h4>
			        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			      </div>
			
			      <!-- Modal body -->
			      <div class="modal-body">
			        Votre commentaire a été envoyé avec succès !
			      </div>
			
			      <!-- Modal footer -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Fermer</button>
			      </div>
			
			    </div>
			  </div>
			</div>
		</section>
		
		
	
	</main>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>