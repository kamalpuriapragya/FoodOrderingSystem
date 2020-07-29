
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoodOrderingSystem</title>
        <%@include file="scriptandcss.html" %>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

        <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
         <%@include file="navigation.jsp" %>

          
    <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">


                      

        <div id="loginbox" style="margin-top: 50px;"
             class="mainbox col-md-5 col-md-offset-2 col-sm-6 col-sm-offset-2">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <div class="bg-primary text-white">Profile</div>
                </div>

                <div style="padding-top: 30px" class="panel-body">
                 
                    <!-- Address Form -->
                    <form action="${pageContext.request.contextPath}/UpdateProfileServlet"   class="form-horizontal">




                        <div style="margin-bottom: 25px" class="input-group">

                            First Name :  <input type="text" name="firstname" placeholder="firstname" value="${User.firstname}" class="form-control">
                        </div>



                        <div style="margin-bottom: 25px" class="input-group">


                            Last Name : <input type="text" name="lastname" placeholder="lastname" value="${User.lastname}" class="form-control" >
                        </div>
            
                        <div style="margin-bottom: 25px" class="input-group">



                            Email :  <input type="text" name="email" placeholder="email" value="${User.email}" class="form-control" >
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">



                            Password :  <input type="text" name="password" placeholder="password" value="${User.password}" class="form-control" >
                        </div>
               
                        <div style="margin-bottom: 25px" class="input-group">


                           Contact   : <input type="text" name="contact" placeholder="contact" value="${User.contact}" class="form-control" >
                        </div>



                        <div  >						

                            <input type="submit" class="btn btn-success" value="update"/>

                        </div><br/>
                        <br/>


                    </form>

                </div>

            </div>

        </div>

                </div></div></div>



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

    </body>
</html>

