/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.servlet;

import com.universal.dao.CommonDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewFoodOrders", urlPatterns = {"/ViewFoodOrders"})
public class ViewFoodOrders extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try{
                     
       ArrayList<Integer> Orderlist =   CommonDao.viewFoodOrders();
           
       request.setAttribute("totalorder", Orderlist);
       RequestDispatcher dispatcher = request.getRequestDispatcher("viewtotalorders.jsp");
       dispatcher.forward(request, response);


}catch(Exception e){out.print(e);}
  
}
}
