package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.Context;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Response;

public class ReviewEngine {
    public Response reviewHandler(Review review, Context context) {
        ReviewEngineHandler reviewEngineHandler = new ReviewEngineHandler();
        Response response = new Response();
        if(review.getHttpMethod() != null) {
            if(review.getHttpMethod().equals(Constants.GET)) {
                if(review.getProductId() != null) {
                    if(review.getReviewId() != null) {
                        return reviewEngineHandler.getReviewByReviewId(review.getReviewId(), response);
                    } else {
                        return reviewEngineHandler.getReviewsByProductId(review.getProductId(),response);
                    }
                }
            } else if (review.getHttpMethod().equals(Constants.POST)) {
                return reviewEngineHandler.setReviewForProduct(review, response);
            }
        }
        return reviewEngineHandler.constructInvalidResponse(response);
    }
}

