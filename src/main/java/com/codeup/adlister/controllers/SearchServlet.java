package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns="/ads/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchInput = request.getParameter("search");
        try {
            List<Ad> adList = DaoFactory.getAdsDao().searchAd(searchInput);
            request.setAttribute("ad", adList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
