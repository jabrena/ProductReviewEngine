package com.platform.marketplaces.database;

import com.platform.marketplaces.models.Review;

public class Products {
    public static int productId;
    public static int reviewId;
    public static int correlationId;
    public static double score;
    public static String comments;

    public void review(String reviewId) {
        // Select * from 'reviews' where reviewID=reviewId
    }
    public void reviews(String productId) {
        // Select productId, avg(score) from 'reviews' where productId=productId
    }
    public void postReviews(String reviewId) {
        // insert into 'reviews'(productId, reviewId, correlationId, score, comments)
    }

}
