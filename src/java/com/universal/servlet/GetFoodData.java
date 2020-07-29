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

@WebServlet(name = "GetFoodData", urlPatterns = {"/GetFoodData"})
public class GetFoodData extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
response.setContentType("text/html");

        PrintWriter out = response.getWriter();
 
       try{
                 
             ArrayList<FoodMenu> food;
    food =   (ArrayList<FoodMenu>) CommonDao.displaymenu();
             System.out.println(food);
            request.setAttribute("food", food);
             
            String page = "/dispalyMenu.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
         
       }catch(IOException | ServletException e){
       out.print(e);}
    }
}

