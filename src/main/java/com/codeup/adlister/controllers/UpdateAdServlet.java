package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateAdServlet", urlPatterns = "/ads/update")
public class UpdateAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ads adToUpdateDao = DaoFactory.getAdsDao();
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        try{
            User user = (User) request.getSession().getAttribute("user");
            Ad upDatedAd = adToUpdateDao.findOne(id);
            adToUpdateDao.updateAd(upDatedAd, new Ad(user.getId(), title, description));
        } catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Ads adToUpdateDao = DaoFactory.getAdsDao();

        try{
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = adToUpdateDao.findOne(id);
            if(ad.getUserId() != user.getId()){
                response.sendRedirect("/error");
                return;
            }
            request.setAttribute("ad", ad);

        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/ads/update.jsp").forward(request, response);
    }

}
