package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.service.ResponseBuilder;
import com.platform.marketplaces.models.Response;

public class ReviewEngine {
    public Response reviewHandler(Review review, Context context) {
        LambdaLogger logger = context.getLogger();
        StringBuilder result = new StringBuilder("");
        result.append("context " + context.toString() + " is ");
        logger.log(result.toString());
        Response response = ResponseBuilder.statusOkayResponse(review);
        return response;
    }
}

