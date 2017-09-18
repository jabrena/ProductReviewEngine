package com.platform.marketplaces.util;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.marketplaces.models.Review;

import java.io.IOException;

public class PojoConvertor {
    public static String reviewConvertor(Review review) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(review) ;
            return jsonInString;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String contextConvertor(Context context) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonInStrings = mapper.writeValueAsString(context) ;
            return jsonInStrings;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
