
package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DisplayOrderServlet", urlPatterns = {"/DisplayOrderServlet"})
public class DisplayOrderServlet extends HttpServlet {

    

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
      HttpSession session=request.getSession();
            if(session.getAttribute("currentorderid")==null){
              response.sendRedirect("emptycart.jsp");
            }else{
      int orderid=(int) session.getAttribute("currentorderid");
      System.out.print("orderid in display servlet"+orderid); 
      try {
      
           Order orderdetail=CommonDao.getOrderRecord(orderid);
           int totalcost=orderdetail.getTotalcost();
           int id = orderdetail.getUserid();
          out.print("orderdetail"+orderdetail);
       session.setAttribute("orderedfood",orderdetail.getFoodList());
        session.setAttribute("myorder",orderdetail);
        session.setAttribute("paymentprice",totalcost);
       session.setAttribute("custid", id);
  
           String page = "/myorders.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);   
 
            }
            catch (ServletException | IOException ex) {
            throw new ServletException(ex);
        }}
         
    }
    
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        doPost(request, response);
    }

}
