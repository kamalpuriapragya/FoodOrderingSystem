
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Food Ordering System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
               <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

        <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <center>
       
        
                <div id="loginbox" style="left: 16%;"
                     class="mainbox col-md-5 col-md-offset-2 col-sm-6 col-sm-offset-2">

                    <div class="panel panel-info">

                        <div class="panel-heading">
                            <div class="panel-title">Sign up</div>
                        </div>

                        <div style="align-self: center" class="panel-body">

                            <!-- Address Form -->
                            <form action="${pageContext.request.contextPath}/SignupServlet"  class="form-horizontal">




                                <div style="margin-bottom: 25px" class="input-group">


                                    First Name :	<input type="text" name="firstname" placeholder="First name" class="form-control">
                                </div>


                                <div style="margin-bottom: 25px" class="input-group">


                                    Last Name :	<input type="text" name="lastname" placeholder="Last name" class="form-control" >
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    Email Address :	<input type="email" name="email" placeholder="email" class="form-control" >
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    Mobile number :	<input type="text" name="contact" placeholder="mobile no." class="form-control" >
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    Password :	<input type="password" name="password" placeholder="password" class="form-control" >
                                </div>
                                                                <div style="margin-bottom: 25px" class="input-group">


                                   Confirm password :	<input type="password" name="cpassword" placeholder="confirm password" class="form-control" >
                                </div>

                                <div  >						

                                    <input type="submit" class="btn btn-success" value="Register"/>

                                </div><br/>
                                <br/>
                                ${message}
                           
                            </form>

                        </div>

                    </div>

                </div>

           


        
     
        </center>
    </body>
</html>
