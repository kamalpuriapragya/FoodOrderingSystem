/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.FoodMenu;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GetMenutoUpdateServlet", urlPatterns = {"/GetMenutoUpdateServlet"})
public class GetMenutoUpdateServlet extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html");
      
        PrintWriter out = response.getWriter();
       int foodid= Integer.parseInt(request.getParameter("food_id"));
      
          FoodMenu foodmenu =CommonDao.getFoodItemById(foodid);
         
          request.setAttribute("menu",foodmenu);
          RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateMenu.jsp");
           dispatcher.forward(request, response);
            
    }

}
