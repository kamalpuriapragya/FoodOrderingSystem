<%-- 
    Document   : navigation1.jsp
    Created on : Feb 5, 2020, 4:00:18 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="scriptandcss.html" %>
        <style>
        .banner {
  background: #fff;
  font-family: Lato, sans-serif;
}
.navbar-nav-primary {
  text-transform: uppercase;
}

.navbar-form-search {
  position: relative;
  .form-control {
    width: 250px;
  }
  .btn {
    border: 0;
    background: transparent;
    font-size: 18px;
    &:active,
    &:hover,
    &:focus {
      color: #000;
      outline: none;
      box-shadow: none;
    }
  }
  .search-form-container {
    text-align: right;
    position: absolute;
    width: 300px;
    overflow: hidden;
    background: #fff;
    right: 60px;
    top: 0;
    z-index: 9;
    transition: all .3s ease-in-out;
    &.hdn {
      width: 0;
    }
    
    .search-input-group {
      width: 300px;
    }
  }
 
}</style>
        
      
    </head>
    <body>
 <nav class="navbar navbar-default banner">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
       
      <a class="navbar-brand" href="#">Foodie</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav navbar-right navbar-nav-primary">

        <li><a href="${pageContext.servletContext.contextPath }/GetFoodData">Menu</a></li>
         <%
                String emailaddress= (String) session.getAttribute("loggedemail");                     
                if (emailaddress == null) {
            %>
        <li><a href="signup.jsp">Signup</a></li>
        <li><a href="login.jsp">Signin</a></li>
        <%}%>
        <li>   
<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">My Account
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="settings.jsp">Settings</a></li>
    <li><a href="profile.jsp">Profile</a></li>
     <li><a href="${pageContext.servletContext.contextPath }/LogoutServlet">Logout</a></li>
  </ul>
</div></li>
    
      </ul>
         <ul class="nav navbar-nav navbar-left navbar-nav-primary">
             <li> <a href="index.jsp" class="active">Home</a></li>
             <li><a href="index.jsp#about">About</a></li>
             <li><a href="index.jsp#features" >Features</a></li>
         </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
 </nav>
     
    <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">

                    <div class="col-md-8 col-md-offset-2">
                        <h2 class="heading to-animate">Order Detail</h2>
                      
                    </div>

                </div>	
                    <div class="col-md-8 col-md-offset-2">
                        <h2 >Order Cancelled Successfully</h2>
                      
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
        <script>

  
    </body></html>
 
