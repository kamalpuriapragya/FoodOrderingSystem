/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.FoodMenu;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RemoveCart", urlPatterns = {"/RemoveCart"})
public class RemoveCart extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
      HttpSession session=request.getSession();
      
      int id=Integer.parseInt(request.getParameter("id"));
      String getindex=request.getParameter("index");
       
            int index=Integer.parseInt(getindex);
            out.print(index);
         
          FoodMenu foodmenu = CommonDao.getFoodItemById(id);
      
      ArrayList list =(ArrayList)session.getAttribute("cart");
            
          list.remove(index);
            System.out.println(">>>>>>>>>>"+list);
         request.setAttribute("food", list);
       String page = "/showCart.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
      }
}
