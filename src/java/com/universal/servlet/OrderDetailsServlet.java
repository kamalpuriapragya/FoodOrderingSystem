/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.Order;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderDetailsServlet", urlPatterns = {"/OrderDetailsServlet"})
public class OrderDetailsServlet extends HttpServlet {

   @Override
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
       
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
            try {
               
      HttpSession session=request.getSession();
      String s1= request.getParameter("orderid");
      
      int orderid=Integer.parseInt(s1);
      Order orderdetail=CommonDao.getOrderRecordById(orderid);

      session.setAttribute("orderedfood",orderdetail.getFoodList());
      session.setAttribute("myorder",orderdetail);
              
      String page = "/orderdetails.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);   
            
            }
            catch (NumberFormatException | ServletException | IOException ex) {
            throw new ServletException(ex);
        }
         
    }
    
}
