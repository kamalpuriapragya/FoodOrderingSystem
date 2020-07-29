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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = {"/UpdateProfileServlet"})
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);
            int id = (int) session.getAttribute("useridis");
            System.out.print("user id in update profile is"+id);
            User user = new User();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");

            String email = request.getParameter("email");

            String contact = request.getParameter("contact");
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setEmail(email);
            user.setContact(contact);
            user.setId(id);

            CommonDao.updateUser(user);

            RequestDispatcher dispatcher = request.getRequestDispatcher("updateprofilesuccess.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
