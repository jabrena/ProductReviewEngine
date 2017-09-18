package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.service.ResponseBuilder;

import java.util.UUID;

public class ReviewEngineHandler {

    // GET Reviews/{ReviewId}
    public Response getReviewByReviewId(String reviewId, Response response) {
        return ResponseBuilder.statusReviewsResponse(reviewId, response);
    }
    // GET Product/{ProductId}
    public Response getReviewsByProductId(String productId, Response response) {
        return ResponseBuilder.statusReviewsResponse(productId, response);
    }

    // POST Product/{ProductId}
    public Response setReviewForProduct(Review review, Response response) {
        return ResponseBuilder.statusOkayResponse(response, review);
    }

    // PUT/PATCH/DELETE Product/{ProductId}
    public Response constructInvalidResponse(Response response) {
        return ResponseBuilder.statusInvalidResponse(response);
    }
}
