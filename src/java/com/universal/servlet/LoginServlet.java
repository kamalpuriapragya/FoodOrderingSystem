/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.servlet;
import com.universal.dao.CommonDao;
import com.universal.dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

   
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html");

        PrintWriter out = response.getWriter();
   
        String emailaddress=request.getParameter("email");
        String password=request.getParameter("password");
        
        if(emailaddress.equals("admin@gmail.com") && password.equals("admin")){
            response.sendRedirect("Dashboard.jsp");
        }
        else{
            User user=new User();
        
        user.setEmail(emailaddress);
         user.setPassword(password);
  
       
        int dbid =CommonDao.loginUser(user);
        if(dbid!=0){
            
            
            out.println("Login successful");
            HttpSession session = request.getSession(true);
  String loggedemail = request.getParameter("username");
  session.setAttribute("loggedemail",emailaddress );
  session.setAttribute("loggedid",dbid);
  session.setMaxInactiveInterval(10*60);
  
  session.setAttribute("useridis", dbid);
    String page = "/index.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);  
        }
        else
        {
            
                String message = "Invalid email/password";
                request.setAttribute("message1", message);
                String page = "/login.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
           
        }
        

        }
}
}
