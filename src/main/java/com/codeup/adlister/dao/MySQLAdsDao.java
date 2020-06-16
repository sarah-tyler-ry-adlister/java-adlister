package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    private List<Ad> ads = new ArrayList<>();


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Ad findOne(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? LIMIT 1");
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return extractAd(rs);
            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    public List<Ad> searchAd(String keyword) {
        List<Ad> adList = new ArrayList<>();
        try {

//            String sql = "SELECT * FROM products WHERE name LIKE ?";
//            String searchTermWithWildcards = "%" + searchTerm + "%";

            String searchQuery = "SELECT * FROM ads WHERE description LIKE ?";
            String searchTermWithWildcards = "%" + keyword + "%";
            PreparedStatement stmt = connection.prepareStatement(searchQuery);
            stmt.setString(1, searchTermWithWildcards);
//            stmt.setString(2, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                adList.add(findOne(rs.getInt("id")));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error in searching the ad", e);
        }
        return adList;
    }



    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
