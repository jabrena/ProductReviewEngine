package com.platform.marketplaces.service;
import com.platform.marketplaces.models.Response;
import com.platform.marketplaces.models.Review;
import com.platform.marketplaces.util.PojoConvertor;
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
}
