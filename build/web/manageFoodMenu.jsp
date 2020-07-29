
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>

<html>
    <head><title>Food Ordering System</title>

        <%@include file="scriptandcss.html" %>
         <script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script> 
       
       
             <style type="text/css">
td
{
    padding:0 15px;
}

         </style>

    </head>




    <body>
        <%@include file="adminnavbar.jsp" %>

        <%@include file="search.jsp" %>

        <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">

                    <div class="col-md-8 col-md-offset-2">
                        <h2 class="heading to-animate">Food Menu</h2>     
                    </div>
                </div>	
            <br/><br/>

                <div class="row row-padded">
                    <div class="col-md-6">
                        <div class="fh5co-food-menu to-animate-2">
                            <c:forEach items="${foodlist}"  var="current" begin="0" end="${(fn:length(foodlist)-1)/2}">
                                 <table>
                                            <tr>
                                                <td>  <a href="${pageContext.servletContext.contextPath }/GetMenutoUpdateServlet?food_id=${current.food_id}">Edit</a></td>
                                                <td><a href="${pageContext.servletContext.contextPath }/RemoveItem?food_id=${current.food_id}">Remove</a></td></tr>
                                        </table>
                                <h3 class="fh5co-drinks"><c:out value="${current.food_name}" /></h3>
                               
                                <ul>
                                    <li>
                                        <div class="fh5co-food-desc">
                                            <figure>
                                                <img src="${pageContext.servletContext.contextPath }/photoServlet?food_id=${current.food_id}" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
                                            </figure>
                                            <div>
                                                <h4><c:out value="${current.category}" /></h4>
                                                
                                            </div>
                                        </div>
                                        <div class="fh5co-food-pricing">
                                            <c:out value="${current.price}" />									
                                        </div>
                                  </li>     
                                </ul>
                              
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="fh5co-food-menu to-animate-2">
                            <c:forEach items="${foodlist}"  var="current" begin="${((fn:length(foodlist)-1)/2)+1}" end="${fn:length(foodlist)}">
                              
                                        <table>
                                            <tr>
                                                <td>  <a href="${pageContext.servletContext.contextPath }/GetMenutoUpdateServlet?food_id=${current.food_id}">Edit</a></td>
                                                <td><a href="${pageContext.servletContext.contextPath }/RemoveItem?food_id=${current.food_id}">Remove</a></td></tr>
                                        </table>
                                <h3 class="fh5co-drinks"><c:out value="${current.food_name}" /></h3>
                                <ul>
                                    <li>
                                        <div class="fh5co-food-desc">
                                            <figure>
                                                <img src="${pageContext.servletContext.contextPath }/photoServlet?food_id=${current.food_id}" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
                                            </figure>
                                            <div>
                                                <h4><c:out value="${current.category}" /></h4>
                                                <p><c:out value="${current.description}" /></p>
                                            </div>
                                        </div>
                                        <div class="fh5co-food-pricing">
                                            <c:out value="${current.price}" />									
                                        </div>

                                    </li>
                                </ul>
                            </c:forEach>
                                
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

    </body></html>