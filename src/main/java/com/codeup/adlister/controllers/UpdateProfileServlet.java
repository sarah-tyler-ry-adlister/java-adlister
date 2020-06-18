package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", urlPatterns = "/updateUser")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users userUpdateDao = DaoFactory.getUsersDao();
//        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User oldUser = (User) request.getSession().getAttribute("user");
        try{
            User newUser = new User(oldUser.getId(), oldUser.getUsername(), email, oldUser.getPassword());
            request.getSession().setAttribute("user", newUser);
            userUpdateDao.updateProfile(oldUser, newUser);
        }catch(Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Users usersSqlDao = DaoFactory.getUsersDao();
        request.setAttribute("user", usersSqlDao.findByUsername(username));
        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
    }
}
