<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Adventure - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Adventure</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="places.html" class="nav-link">Places</a></li>
	          <li class="nav-item active"><a href="hotel.html" class="nav-link">Hotels</a></li>
	          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url('images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 text-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">Home</a></span> <span>Hotel</span></p>
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Hotels</h1>
          </div>
        </div>
      </div>
    </div>
		
		<section class="ftco-section">
      <div class="container">
        <div class="row">
        	<div class="col-lg-3 sidebar order-md-last ftco-animate">
        		<div class="sidebar-wrap ftco-animate">
        		<form action="FilterBy" method="post">
        			<h3 class="heading mb-4">Trier les Hotels</h3>
        			<hr>
        			<label style="color: black;font-weight: bold">Prix</label>
        			<div style="width: 35px;height: 0px;border: 0.25px solid #000000;"></div>
        			<br>
        			
        			<div class="fields">
		              <div class="form-group">
		              	<input type="radio" name="prix" value="500"> Moins que 500 DH<br>
						  <input type="radio" name="prix" value="1000"> 500 - 1000 DH<br>
						  <input type="radio" name="prix" value="1500"> 1000 - 1500 DH<br>
						  <input type="radio" name="prix" value="2000"> Plus que 1500 DH<br>
						  <br>
 
		              
		             
		             <label style="color: black;font-weight: bold">Etoiles</label>
		             <div style="width: 58px;height: 0px;border: 0.25px solid #000000;"></div>
        			<br>
						  <input type="radio" name="stars" value="2"> 2 Etoiles<br>
						  <input type="radio" name="stars" value="3"> 3 Etoiles<br>
						  <input type="radio" name="stars" value="4"> 4 Etoiles<br>
						  <input type="radio" name="stars" value="5"> 5 Etoiles<br>
						<hr>
					</div>
		              <div class="form-group">
		                <input type="submit" value="Search" class="btn btn-primary py-3 px-5">
		              </div>
		            </div>
	            </form>
        		</div>
          </div><!-- END-->
          <div class="col-lg-9">
          	<div class="row">
          			 <c:forEach var = "h" items = "${hotelList}" varStatus="status"> 
		    			<div class="col-sm col-md-6 col-lg-4 ftco-animate">
		    				<div class="destination">
		    					<a href="GetOneHotelDataInter?hotel=${h.getId_hotel()}" class="img img-2 d-flex justify-content-center align-items-center" style="background-image: url(${h.image_hotel});">
		    						<div class="icon d-flex justify-content-center align-items-center">
		    							<span class="icon-link"></span>
		    						</div>
		    					</a>
		    					<div class="text p-3">
		    						<div class="d-flex">
		    							<div class="one">
				    						<h3><a href="GetOneHotelDataInter?hotel=${h.getId_hotel()}">${h.getNom_hotel()}</a></h3>
				    						<p class="rate">
				    							<c:if test="${h.getNbr_etoiles()=='1'}">
										    <i class="icon-star"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
										</c:if>
										<c:if test="${h.getNbr_etoiles()=='2'}">
										    <i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
										</c:if>
			    						<c:if test="${h.getNbr_etoiles()=='3'}">
										    <i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star-o"></i>
			    							<i class="icon-star-o"></i>
										</c:if>
										<c:if test="${h.getNbr_etoiles()=='4'}">
										    <i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star-o"></i>
										</c:if>
										<c:if test="${h.getNbr_etoiles()=='5'}">
										    <i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
			    							<i class="icon-star"></i>
										</c:if>	
			    							<span>Etoiles</span>
			    							<span style="/* Rectangle 1 */
		    									width: 50px;height: 50px;background: #F9BE37;mix-blend-mode: normal;opacity: 0.7;
		    									box-sizing: border-box;box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
		    									border-radius: 0px 10px;
		    									/* 4.6 */
												width: 43px;height: 26px;font-family: Quicksand;fot-style: normal;
												font-weight: medium;font-size: 24px;line-height: 28px;color: #FFFFFF;text-align: center" >${h.getRating()}
											</span>
				    						</p>
			    						</div>
		    						</div>
		    						
		    						<hr>
		    						<p class="bottom-area d-flex">
		    							<span><i class="icon-map-o"></i>  ${h.getVille_hotel()}</span> 
										<c:if test="${h.getId_deal()>'0'}">
										    <span class="ml-auto"><a href="#">Deal offert !</a></span>
										</c:if>
										<c:if test="${h.getId_deal()==null}">
										    <span class="ml-auto"><a href="#">Nothing</a></span>
										</c:if>
		    						</p>
		    					</div>
		    				</div>
		    			</div>
		     	</c:forEach>
		     	
		     </div>
          	<div class="row mt-5">
		          <div class="col text-center">
		            <div class="block-27">
		              <ul>
		                <li><a href="#">&lt;</a></li>
		                <li class="active"><span>1</span></li>
		                <li><a href="#">2</a></li>
		                <li><a href="#">3</a></li>
		                <li><a href="#">4</a></li>
		                <li><a href="#">5</a></li>
		                <li><a href="#">&gt;</a></li>
		              </ul>
		            </div>
		          </div>
		  </div>
          </div> <!-- .col-md-8 -->
      </div>
      </div>
    </section> <!-- .section -->

		<section class="ftco-section-parallax">
      <div class="parallax-img d-flex align-items-center">
        <div class="container">
          <div class="row d-flex justify-content-center">
            <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
              <h2>Subcribe to our Newsletter</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
              <div class="row d-flex justify-content-center mt-5">
                <div class="col-md-8">
                  <form action="#" class="subscribe-form">
                    <div class="form-group d-flex">
                      <input type="text" class="form-control" placeholder="Enter email address">
                      <input type="submit" value="Subscribe" class="submit px-3">
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Adventure</h2>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Information</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">About Us</a></li>
                <li><a href="#" class="py-2 d-block">Online enquiry</a></li>
                <li><a href="#" class="py-2 d-block">Call Us</a></li>
                <li><a href="#" class="py-2 d-block">General enquiries</a></li>
                <li><a href="#" class="py-2 d-block">Booking Conditions</a></li>
                <li><a href="#" class="py-2 d-block">Privacy and Policy</a></li>
                <li><a href="#" class="py-2 d-block">Refund policy</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Experience</h2>
              <ul class="list-unstyled">
                <li><a href="#" class="py-2 d-block">Beach</a></li>
                <li><a href="#" class="py-2 d-block">Adventure</a></li>
                <li><a href="#" class="py-2 d-block">Wildlife</a></li>
                <li><a href="#" class="py-2 d-block">Honeymoon</a></li>
                <li><a href="#" class="py-2 d-block">Nature</a></li>
                <li><a href="#" class="py-2 d-block">Party</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>