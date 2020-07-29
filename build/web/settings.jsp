


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="scriptandcss.html" %>
        
      <title>Food Ordering System</title>
    </head>
    <body>

    <%@include file="navigation.jsp" %>
     
    <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">

                    <div class="col-md-8 col-md-offset-2">
                        <h2 class="heading to-animate">User Board</h2>
                      
                    </div>

                </div>
                	<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
			
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Set new password</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form action="SetNewPassword" class="form-horizontal">

					   

						<!-- User name -->
						<div style="margin-bottom: 25px" class="input-group">
					
							
                                               New password :      <input type="password" name="npassword"  class="form-control" >

						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="input-group">
			
							
                                                     Confirm password :   <input type="password" name="cpassword"  class="form-control"  >
				
                                                         </div> 

						<!-- Login/Submit Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<input type="submit" class="btn btn-success" value="change"/>
							</div>
						</div>
                                                

					</form>

				</div>

			</div>

		</div>
      
  



				</div>

			</div>

		
       

                     <%@include file="footer.jsp" %>
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Bootstrap --> 
        <script src="js/bootstrap.min.js"></script>
        <!-- Bootstrap DateTimePicker -->
        <script src="js/moment.js"></script>
        <script src="js/bootstrap-datetimepicker.min.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>

        <!-- Flexslider -->
        <script src="js/jquery.flexslider-min.js"></script>
        <script>
                $(function () {
                    $('#date').datetimepicker();
                });
        </script>
        <!-- Main JS -->
        <script src="js/main.js"></script>
        <script>

  
    </body></html>
 

