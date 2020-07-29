
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
        <h1>Order List</h1>
<BR/>
<BR/>

          <table class="table" border="2">
          
    <thead class="thead-dark">
            
            <tr>
                
                <th>SNo</th>
                <th>OrderNo</th>
                <th>orderdetails</th>
               
            </tr>   
    </thead> 
            <tbody>                       
            <c:forEach items="${totalorder}" var="current2" varStatus="counter">
                
                
                <tr>
		
	

                            <td><c:out value="${counter.count}" /></td>
                            <td><c:out value="${current2}" /></td>
                            <td><a href="${pageContext.request.contextPath}/OrderDetailsServlet?orderid=${current2}" >details</a></td>
                              
                           
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

