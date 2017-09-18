package com.platform.marketplaces.service;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.util.PojoConvertor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResponseBuilder {

    public static Response statusOkayResponse(Review review) {
        UUID id = UUID.randomUUID();
        Response response = new Response();
        response.setCorrelation(id.toString());
        response.setResponse("POST request successful");
        response.setBody(PojoConvertor.reviewConvertor(review));
        return response;
    }
    public static Reviews reviewResponse() {
        Reviews reviews = new Reviews();
        List<Review> reviewList = new ArrayList<Review>();
        reviews.setId(121);
        reviews.setAverageScore(4.5);
        Review review = new Review();
        review.setComment("good");
        review.setScore(3);
        Review review1 = new Review();
        review1.setComment("great");
        review1.setScore(5);
        reviewList.add(review);
        reviewList.add(review1);
        reviews.setReview(reviewList);
        return reviews;
    }
}
