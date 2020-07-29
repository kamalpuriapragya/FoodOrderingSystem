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

/**
 *
 * @author Rishi
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
         HttpSession session=request.getSession();
    
      int orderid=(int) session.getAttribute("currentorderid");
      System.out.print("orderid in payment servlet"+orderid); 
       try {
      
           Order orderdetail=CommonDao.getOrderRecordById(orderid);
          
        session.setAttribute("myorder",orderdetail);
  
           String page = "/paymentindex.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);   
 
            }
            catch (ServletException | IOException ex) {
            throw new ServletException(ex);
        }
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        doPost(request, response);
    }

}
