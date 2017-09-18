package com.platform.marketplaces.service;

import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.util.PojoConvertor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockResponseBuilder {
    public static Reviews reviewsResponse() {
        Reviews reviews = new Reviews();
        List<Review> reviewList = new ArrayList<Review>();
        reviews.setProductId(17);
        reviews.setAverageScore(4.5);

        Review review = new Review();
        review.setComment("good");
        review.setScore(3);
        review.setProductId("17");
        review.setReviewId("30");

        Review review1 = new Review();
        review1.setComment("great");
        review1.setScore(5);
        review.setProductId("17");
        review.setReviewId("31");

        reviewList.add(review);
        reviewList.add(review1);
        reviews.setReview(reviewList);
        return reviews;
    }

    public static Review reviewResponse() {
        Review review = new Review();
        review.setComment("Not a good product");
        review.setScore(1);
        review.setProductId("12");
        review.setReviewId("23");
        return review;
    }
}
