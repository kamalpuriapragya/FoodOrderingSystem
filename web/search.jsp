
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
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

#menufood th 
{
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #fb6e14;
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
        
    
        <form action="${pageContext.servletContext.contextPath }/SearchServlet">  
        <div class="main">         
  <!-- Actual search box -->
 
  <div class="form-group has-search">
    <span class="fa fa-search form-control-feedback"></span>
    <input type="text" name="search" class="form-control" placeholder="Search">
  </div></div></form>
           
        <table id="menufood" align="center">   
            
            <thead>   <tr><th>Food Categories</th></tr></thead>
      
            <tbody>
                <tr class='clickable-row' data-href='${pageContext.servletContext.contextPath }/SearchServlet?search=Drinks'>
                    
                    <td>Drinks</td></tr>
                <tr  class='clickable-row' data-href='${pageContext.servletContext.contextPath }/SearchServlet?search=Curry'>
                    
                    
                    <td >Curry</td>
                </tr>
                <tr  class='clickable-row' data-href='${pageContext.servletContext.contextPath }/SearchServlet?search=Roti'>
                    
       
                    <td>Roti</td>
                </tr>
                <tr  class='clickable-row' data-href='${pageContext.servletContext.contextPath }/SearchServlet?search=Sweets'>
                    
                   
                    <td >Sweets</td>
                </tr>
                <tr  class='clickable-row' data-href='${pageContext.servletContext.contextPath }/SearchServlet?search=Indian Special'>
                    
                    
                  <td>Indian Special</td>
                </tr>


            </tbody>
        </table>

      
      <script>
          jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
      </script>           

    </body></html>         
                  
