<%-- 
    Document   : regUsers
    Created on : Mar 5, 2020, 1:14:19 PM
    Author     : Rishi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food Ordering System</title>
        <%@include file="scriptandcss.html" %>

  
    </head>
    <body>
        <%@include file="adminnavbar.jsp" %>
       
            <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">
        <br/>
        <BR/>
        <br/>
         <h1>Registered Users</h1>
<BR/>
<BR/>

          <table class="table" border="2">
    <thead class="thead-dark">
            
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Contact</th>
                <th>Email</th>
                
            </tr>   </thead>   <tbody>                       
            <c:forEach items="${reguser}" var="current2" >
                
                <tr>
		
		
                            <td><c:out value="${current2.id}" /></td>
                            <td><c:out value="${current2.firstname}" /></td>
			    <td><c:out value="${current2.lastname}" /></td>
			    <td><c:out value="${current2.contact}" /></td>
			    <td><c:out value="${current2.email}" /></td>
                           
	       </tr>                                                
          </c:forEach>
          </tbody>
            </table>              
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

