package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ShowAdServlet", urlPatterns = "/ad")
public class ShowAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        User adCreator = null;

        //        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user.getUsername());
//        User adCreator = (User) request.getSession().getAttribute("sessionScope.user.username");
//        System.out.println(adCreator);
//         adCreator = (User) request.getSession().getAttribute("adCreator");
//        System.out.println(adCreator.getUsername());
//        boolean userIsCreator = user.getUsername().equalsIgnoreCase(adCreator.getUsername());
//
//        if (!userIsCreator ) {
//            response.sendRedirect("/ads");
//            return;
//        }


        try {
            Ad ad = DaoFactory.getAdsDao().findOne(id);
            adCreator = DaoFactory.getUsersDao().findUserById(ad.getUserId());
            request.setAttribute("ad", ad);
            request.setAttribute("adCreator", adCreator);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
    }
}
