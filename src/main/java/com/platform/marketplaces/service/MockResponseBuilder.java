package com.platform.marketplaces.service;

import com.platform.marketplaces.models.Product;
import com.platform.marketplaces.models.Review;

import java.util.ArrayList;
import java.util.List;

public class MockResponseBuilder {

    public static Product submitReview(Review review) {
        Product product = new Product();
        product.setProductId(Integer.parseInt(review.getProductId()));
        List<Review> reviewList = new ArrayList<Review>();
        Review rvw = new Review();
        rvw.setComment(review.getComment());
        rvw.setScore(review.getScore());
        rvw.setReviewId("30");
        reviewList.add(rvw);
        product.setReview(reviewList);
        return product;
    }

    public static Product reviewsResponse(String productId) {
        Product reviews = new Product();
        List<Review> reviewList = new ArrayList<Review>();
        reviews.setProductId(Integer.parseInt(productId));
        reviews.setAverageScore(4.0);

        Review review = new Review();
        review.setComment("good");
        review.setScore(3);
        review.setReviewId("30");

        Review review1 = new Review();
        review1.setComment("great");
        review1.setScore(5);
        review.setReviewId("31");

        reviewList.add(review);
        reviewList.add(review1);
        reviews.setReview(reviewList);
        return reviews;
    }

    public static Product reviewResponse(String productId, String reviewId) {
        Product reviews = new Product();
        reviews.setProductId(Integer.parseInt(productId));

        List<Review> reviewList = new ArrayList<Review>();
        Review review = new Review();
        review.setComment("Not a good product");
        review.setScore(1);
        review.setReviewId(reviewId);
        reviewList.add(review);
        reviews.setReview(reviewList);

        return reviews;
    }
}
