package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.FoodMenu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManageCart", urlPatterns = {"/ManageCart"})
public class ManageCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
               
        
         String foodid=request.getParameter("id");
         int id = Integer.parseInt(foodid);
         HttpSession session = request.getSession();
          FoodMenu foodmenu = CommonDao.getFoodItemById(id);
       
            ArrayList list = (ArrayList)session.getAttribute("cart"); 
            System.out.print("manage cart list"+list);
            if(list==null){
                list  = new ArrayList();
        }
        if(request.getParameter("cart").equals("order"))
          {
       list.add(foodmenu);}
                 
                        
            session.setAttribute("cart", list);
            
            response.sendRedirect("GetFoodData");
      
    }
}
