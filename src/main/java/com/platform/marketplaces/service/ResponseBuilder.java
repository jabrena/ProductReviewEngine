package com.platform.marketplaces.service;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.util.PojoConvertor;

import java.util.UUID;

public class ResponseBuilder {

    public static Response statusOkayResponse(Response response, Review review) {
        response.setCorrelation(UUID.randomUUID().toString());
        response.setResponse("POST request successful");
        response.setBody(PojoConvertor.reviewConvertor(review));
        return response;
    }

    public static Response statusReviewsResponse(String reviewId, Response response) {
        Reviews reviews = MockResponseBuilder.reviewsResponse();
        UUID id = UUID.randomUUID();
        response.setCorrelation(id.toString());
        response.setResponse("GET request successful");
        response.setBody(PojoConvertor.reviewsConvertor(reviews));
        return response;
    }

    public static Response statusReviewResponse(String productId, Response response) {
        Review review = MockResponseBuilder.reviewResponse();
        UUID id = UUID.randomUUID();
        response.setCorrelation(id.toString());
        response.setResponse("GET request successful");
        response.setBody(PojoConvertor.reviewConvertor(review));
        return response;
    }

    public static Response statusInvalidResponse(Response response) {
        response.setResponse("Invalid Input");
        response.setBody("Invalid Input/Unsupported HTTP Method");
        response.setCorrelation(UUID.randomUUID().toString());
        return response;
    }
}