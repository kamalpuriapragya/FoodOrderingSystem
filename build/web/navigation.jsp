
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <% } else {
        
                ArrayList list=  (ArrayList)session.getAttribute("cart");                     
                if (list != null) {
            %>
         <li><a href="${pageContext.servletContext.contextPath }/CartController">Cart</a></li>
        <li><a href="${pageContext.servletContext.contextPath }/DisplayOrderServlet">My Orders</a></li>
        <%}else {%>
        <li><a href="emptycart.jsp">Cart</a></li>
        <li><a href="emptycart.jsp">My Orders</a></li>
        <% }} 
         %>
        <%
                String address= (String) session.getAttribute("loggedemail");                     
                if (address != null) {
            %>
        <li>   
<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">My Account
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="settings.jsp">Settings</a></li>
    <li><a href="${pageContext.servletContext.contextPath }/ProfileServlet">Profile</a></li>
    <li><a href="${pageContext.servletContext.contextPath }/LogoutServlet">Logout</a></li>
  </ul>
</div></li>
<%}%>
      </ul>
         <ul class="nav navbar-nav navbar-left navbar-nav-primary">
             <li> <a href="index.jsp" class="active">Home</a></li>
             <li><a href="index.jsp#about">About</a></li>
             <li><a href="index.jsp#features" >Features</a></li>
         </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
 </nav></body></html>
 
