package com.universal.servlet;

import com.universal.dao.CommonDao;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "photoServlet", urlPatterns = {"/photoServlet"})
public class photoServlet extends HttpServlet {
    
    
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    try {
       Blob blob= CommonDao.getPhoto(Integer.parseInt(request.getParameter("food_id")));
        byte byteArray[] = blob.getBytes(1, (int)blob.length());
        response.setContentType("image/gif");
        try (OutputStream os = response.getOutputStream()) {
            os.write(byteArray);
            os.flush();
        }
          
  } catch (NumberFormatException | IOException | SQLException e) {
      
 
        PrintWriter out=response.getWriter();
  response.setContentType("text/html");
  out.println("<html><head><title>Unable To Display image</title></head>");
  out.println("<body><h4><font color='red'>Image Display Error=" + e.getMessage() +
   "</font></h4></body></html>");
  }
    }

    
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    
    {
        doPost(request, response);
    }


}
