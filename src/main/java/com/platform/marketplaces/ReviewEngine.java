package com.platform.marketplaces;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.models.Reviews;
import com.platform.marketplaces.service.ResponseBuilder;
import com.platform.marketplaces.models.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ReviewEngine {
    public Response reviewHandler(Review review, Context context) {
        LambdaLogger logger = context.getLogger();
        Response response = ResponseBuilder.statusOkayResponse(review);
        return response;
    }
    public Reviews reviewsHandler(Context context) {
        LambdaLogger logger = context.getLogger();
        return ResponseBuilder.reviewResponse();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Hello world!";
    }

    @GET
    @Path("aws/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAwsMessage() {
        return "Hello from AWS!";
    }
}

