package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.Context;
import com.platform.marketplaces.models.Product;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Response;

public class ReviewEngine {
    public Product reviewHandler(Review review, Context context) {
        ReviewEngineHandler reviewEngineHandler = new ReviewEngineHandler();
        if(review.getHttpMethod() != null) {
            if(review.getHttpMethod().equals(Constants.GET)) {
                if(review.getProductId() != null) {
                    if(review.getReviewId() != null) {
                        return reviewEngineHandler.getReviewByReviewId(review.getProductId(), review.getReviewId());
                    } else {
                        return reviewEngineHandler.getReviewsByProductId(review.getProductId());
                    }
                }
            } else if (review.getHttpMethod().equals(Constants.POST)) {
                return reviewEngineHandler.setReviewForProduct(review);
            }
        }
        return reviewEngineHandler.constructInvalidResponse();
    }
}

