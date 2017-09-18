package com.platform.marketplaces;

import com.platform.marketplaces.models.Product;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.service.ResponseBuilder;

public class ReviewEngineHandler {

    // GET Product/{ReviewId}
    public Product getReviewByReviewId(String productId, String reviewId) {
        return ResponseBuilder.statusReviewResponse(productId, reviewId);
    }
    // GET Product/{ProductId}
    public Product getReviewsByProductId(String productId) {
        return ResponseBuilder.statusReviewsResponse(productId);
    }

    // POST Product/{ProductId}
    public Product setReviewForProduct(Review review) {
        return ResponseBuilder.statusOkayResponse(review);
    }

    // PUT/PATCH/DELETE Product/{ProductId}
    public Product constructInvalidResponse() {
        return ResponseBuilder.statusInvalidResponse();
    }
}
