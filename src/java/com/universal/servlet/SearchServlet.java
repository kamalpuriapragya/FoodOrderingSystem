package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.FoodMenu;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    
        
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     try{
        
         String search=request.getParameter("search");
         System.out.println(">>>>"+search);
         List <FoodMenu> food= CommonDao.searchFood(search);
    
         System.out.println(">>>"+food);
         request.setAttribute("food", food);
                
             
            String page = "/dispalyMenu.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response); 
      } catch (ServletException | IOException e) 
      {
      }
 }

   }
