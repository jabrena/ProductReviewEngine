package com.platform.marketplaces.service;
import com.platform.marketplaces.models.Product;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.util.PojoConvertor;

import java.util.UUID;

public class ResponseBuilder {
    public static Product statusOkayResponse(Review review) {
        return MockResponseBuilder.submitReview(review);
    }

    public static Product statusReviewsResponse(String productId) {
        return MockResponseBuilder.reviewsResponse(productId);
    }

    public static Product statusReviewResponse(String productId, String reviewId) {
        return MockResponseBuilder.reviewResponse(productId, reviewId);

    }

    public static Product statusInvalidResponse() {
        Product product = new Product();
        product.setProductId(0);
        product.setAverageScore(0);
        return product;
    }
}