
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>  
<%
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(1000000);
%>
<%@page import="java.util.ArrayList"%>  


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

        <script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script> 

        <style> 
            table{

                border-collapse: collapse;
                width: 100%;
            }

            th,td{
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th{
                background-color: #4CAF50;
                color: white;


            }
        </style>
    </head>

    <body>

        <div class="panel-heading">
            <div class="panel-title"><h1>User Payment Page</h1></div>
        </div>

        <form method="post" action="pgRedirect.jsp" >
            <table border="1"> 
                <tbody>
                    <tr>
                    <tr>
                        <th>S.No</th>
                        <th>Label</th>
                        <th>Value</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td><label>ORDER_ID::*</label></td>
                        <td><input id="ORDER_ID" tabindex="1" maxlength="20" size="20"
                                   name="ORDER_ID" autocomplete="off"
                                   value="ORDS_<%= randomInt%>">
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><label>CUSTID ::*</label></td>
                        <td><input id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001"></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td><label>INDUSTRY_TYPE_ID ::*</label></td>
                        <td><input id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail"></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td><label>Channel ::*</label></td>
                        <td><input id="CHANNEL_ID" tabindex="4" maxlength="12"
                                   size="12" name="CHANNEL_ID" autocomplete="off" value="WEB">
                        </td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td><label>Total AMount *</label></td>
                        <td><input title="Total Amout" tabindex="10"
                                   type="text" name="TXN_AMOUNT"
                                   value=${myorder.totalcost}>  


                        </td>
                    </tr>
                    <tr> 
                        <td></td>
                        <td></td>
                        <td><input type="submit" class="btn btn-success" value="pay" onclick=""></td>
                    </tr>
                </tbody>
            </table>
            * - Mandatory Fields
        </form>


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
