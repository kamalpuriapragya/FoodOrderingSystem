/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universal.email;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ResetPasswordServlet", urlPatterns = {"/ResetPasswordServlet"})
public class ResetPasswordServlet extends HttpServlet {
      private static final long serialVersionUID = 1L;
 
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
 
      @Override
    public void init() {
        // reads SMTP server setting from web.xml file
      host = "smtp.gmail.com";
port = "587";
email= "pragyakamalpuria@gmail.com";
pass = "Pragya@1052000";
        name = "Food Ordering System";
        
    }
 
    public ResetPasswordServlet() {
    }
 
      @Override
    protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
    
              String recipient = request.getParameter("recipient");
        
        String subject = "Your Password has been reset";
 
        CustomerServices customerServices = new CustomerServices(request, response);
        String newPassword = customerServices.resetCustomerPassword(recipient);
       
        String content = "Hi, this is your new password: " + newPassword;
        content += "\nNote: for security reason, "
                + "you must change your password after logging in.";
 
        String message = "";
 
        try {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            
            message = "Your password has been reset. Please check your e-mail.";
            request.setAttribute("flag", "true");
            HttpSession session =request.getSession();
            session.setAttribute("recipientemail",recipient);
            session.setAttribute("newpassword", newPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }

}
