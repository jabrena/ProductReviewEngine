package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.service.ResponseBuilder;

import java.util.UUID;

public class ReviewEngineHandler {

    // GET Reviews/{ReviewId}
    public static Response getReviewByReviewId(String reviewId, Response response) {
        Reviews reviews = ResponseBuilder.reviewResponse();
        return ResponseBuilder.statusReviewsResponse();
    }

    // GET Product/{ProductId}
    public static Response getReviewsByProductId(String productId, Response response) {
        Reviews reviews = ResponseBuilder.reviewResponse();
        return ResponseBuilder.statusReviewsResponse();
    }

    // POST Product/{ProductId}
    public static Response setReviewForProduct(Review review, Response response) {
        response = ResponseBuilder.statusOkayResponse(review);
        return response;
    }

    // POST Product/{ProductId}
    public static Response constructInvalidResponse(Response response) {
        response.setResponse("Invalid Input");
        response.setBody("Invalid Input/Unsupported HTTP Method");
        response.setCorrelation(UUID.randomUUID().toString());
        return response;
    }
}
