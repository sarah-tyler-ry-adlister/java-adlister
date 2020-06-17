package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    //get a list of all the ads associated with a user
    List<Ad> all(int id);

    //get one ad
    Ad findOne(long id);

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    //search for an ad
    List<Ad> searchAd(String keyword);

    //update an ad
    Long updateAd(Ad ad, Ad updateAd);

}
