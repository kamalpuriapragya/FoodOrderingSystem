

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
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

        <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            .main {
                width: 50%;
                margin: 50px auto;
            }


            /* Bootstrap 4 text input with search icon */

            #menufood{
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 35%;
            }

            #menufood td, #menufood th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #menufood tr:nth-child(even){background-color: #f2f2f2;}

            #menufood tr:hover {background-color: #ddd;}

            #menufood th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #4CAF50;
                color: white;
            }

            .has-search .form-control {
                padding-left: 2.375rem;
            }

            .has-search .form-control-feedback {
                position: absolute;
                z-index: 2;
                display: block;
                width: 2.375rem;
                height: 2.375rem;
                line-height: 2.375rem;
                text-align: center;
                pointer-events: none;
                color: #aaa;
            }           

        </style>

        <script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script> 


    </head>




    <body>

        <%@include file="navigation.jsp" %>
      
        <div class="col-sm">
            
                <div id="loginbox" style="margin-top: 50px;"
                     class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

                    <div class="panel panel-info">

                        <div class="panel-heading">
                            <div class="panel-title">Your Address Details</div>
                        </div>

                        <div style="padding-top: 30px" class="panel-body">

                            <!-- Address Form -->
                            <form action="${pageContext.request.contextPath}/CancelOrder?cancelid=${myorder.orderid}" method="POST" class="form-horizontal">




                                <div style="margin-bottom: 25px" class="input-group">


                                    Flat No.:${myorder.flatno}
                                </div>


                                <div style="margin-bottom: 25px" class="input-group">


                                    Street Name :${myorder.streetName}
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    Area :${myorder.area}
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    City :${myorder.city}
                                </div>
                                <div style="margin-bottom: 25px" class="input-group">


                                    Landmark :${myorder.landmark}
                                </div>

                                <div  >						

                                    <input type="submit" class="btn btn-success" value="cancel Order" name="cancelorder"/>

                                </div>
                            
                            </form>
                            

                        </div>

                    </div>

                </div>

            
        </div>

        <div id="fh5co-menus" data-section="menu">
            <div class="container">
                <div class="row text-center fh5co-heading row-padded">

                    <div class="col-md-8 col-md-offset-2">
                        <h2 class="heading to-animate">Order Detail</h2>
                      
                    </div>

                </div>	




                <br/><br/>
                
              
                   
                <div class="row row-padded">
                   
                    <div class="col-md-6">
                        <div class="fh5co-food-menu to-animate-2">
                         
                                <c:forEach items="${orderedfood}"  var="current" begin="0" end="${(fn:length(orderedfood)-1)/2}" varStatus="loop">
                                    <h3 class="fh5co-drinks"><c:out value="${current.food_name}" /></h3>
                                    <ul>
                                        <li>
                                            <div class="fh5co-food-desc">
                                                <figure>
                                                    <img src="${pageContext.servletContext.contextPath }/photoServlet?food_id=${current.food_id}" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
                                                </figure>
                                                <div>
                                                    <h4><c:out value="${current.category}" /></h4>
                                                    <h5><c:out value="${myorder.orderdate}" /></h5>
                                                    <p><c:out value="${current.description}" /></p>
                                                </div>
                                            </div>
                                            <div class="fh5co-food-pricing">
                                                <c:out value="${current.price}" />									
                                            </div>

                                            <div style="margin-bottom: 25px" class="input-group">

                                                   <c:out value="${current.quantity}"/> pieces		

                                            </div>  

                                        </li>
                                    </ul>
                                </c:forEach>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="fh5co-food-menu to-animate-2">
                            <c:forEach items="${orderedfood}"  var="current" begin="${((fn:length(orderedfood)-1)/2)+1}" end="${fn:length(orderedfood)}" varStatus="loop">
                                <h3 class="fh5co-drinks"><c:out value="${current.food_name}" /></h3>
                                <ul>
                                    <li>
                                        <div class="fh5co-food-desc">
                                            <figure>
                                                <img src="${pageContext.servletContext.contextPath }/photoServlet?food_id=${current.food_id}" class="img-responsive" alt="Free HTML5 Templates by FREEHTML5.co">
                                            </figure>
                                            <div>
                                                <h4><c:out value="${current.category}" /></h4>
                                                 <h5><c:out value="${myorder.orderdate}" /></h5>
                                                <p><c:out value="${current.description}" /></p>
                                            </div>
                                        </div>
                                        <div class="fh5co-food-pricing">
                                            <c:out value="${current.price}" />									
                                        </div>
                                       <div style="margin-bottom: 25px" class="input-group">

                                            <c:out value="${current.quantity}"/> pieces	

                                        </div>    
                                    </li>
                                </ul>
                                

                            </c:forEach>
                           
                        </div>
                    </div>


                </div>

                <div  >						
         <h2 class="fh5co-drinks"> Total cost : Rs ${myorder.totalcost}</h2>
        <h3><a href="paymentindex.jsp">Proceed To Payment</a><h3>         
                    
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
            