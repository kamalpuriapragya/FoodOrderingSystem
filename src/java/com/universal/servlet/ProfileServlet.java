package com.universal.servlet;

import com.universal.dao.CommonDao;
import com.universal.dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try{
            
       HttpSession session = request.getSession(true);
      
       int id=(int) session.getAttribute("loggedid");
       
       User user=CommonDao.getUser(id);
            
       request.setAttribute("User", user);
       RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
       dispatcher.forward(request, response);

}catch(ServletException | IOException e){}
  
}


}
