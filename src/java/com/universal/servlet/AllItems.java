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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AllItems", urlPatterns = {"/AllItems"})
public class AllItems extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html");

        PrintWriter out = response.getWriter();
 
       try{
                 
             ArrayList<FoodMenu> foodlist;
             foodlist = (ArrayList<FoodMenu>) CommonDao.manageFoodMenu();
            request.setAttribute("foodlist", foodlist);
             
            String page = "/manageFoodMenu.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
         

}catch(IOException | ServletException e){out.print(e);}
    }
}