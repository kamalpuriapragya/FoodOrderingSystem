package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.FoodMenu;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize=16177216)
public class AddFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String foodcategory=request.getParameter("category");
        String food_name=request.getParameter("food_name");
        String description=request.getParameter("description");
        

       int price=Integer.parseInt(request.getParameter("price"));
       int quantity=Integer.parseInt(request.getParameter("quantity"));
       Part image=request.getPart("image");
       InputStream inputStream =  image.getInputStream();
       

      FoodMenu foodmenu=new FoodMenu();
      foodmenu.setCategory(foodcategory);
      foodmenu.setFood_name(food_name);
    
      foodmenu.setDescription(description);
      foodmenu.setPrice(price);
      foodmenu.setQuantity(quantity);
      foodmenu.setImage(inputStream);
     
        boolean flag =CommonDao.addFoodRecord(foodmenu);
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("additemsuccess.jsp");
            dispatcher.forward(request, response);
        }
    
  
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        doPost(request, response);
    }
    }



    




