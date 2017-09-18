package com.platform.marketplaces.database;

import com.platform.marketplaces.models.Review;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Products {
    public static int productId;
    public static int reviewId;
    public static int correlationId;
    public static double score;
    public static String comments;

    public LambdaLogger logger;
    private static String GET_ALL_REVIEWS_BY_PRODUCT_ID = "Select r from reviews where r.reviewID = :reviewId";
    private static String GET_REVIEW_BY_REVIEW_ID = "Select r.productId, r.avg(score) from reviews where r.productId = :productId";
    private static String SET_REVIEW_BY_PRODUCT_ID = "insert into reviews (:productId, :reviewId, :correlationId, :score, :comments)";


    private Statement createConnection(Context context) {
        logger = context.getLogger();
        try {
            String url = "jdbc:mysql://HOSTNAME:3306";
            String username = "USERNAME";
            String password = "PASSWORD";

            Connection conn = DriverManager.getConnection(url, username, password);
            return conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Caught exception: " + e.getMessage());
        }
        return null;
    }

    public void reviews(String reviewId, Context context) {
        // Select * from 'reviews' where reviewID=reviewId
        logger.log("Invoked review by reviewId select query");
        try {
            Statement stmt = createConnection(context);
            ResultSet resultSet = stmt.executeQuery(GET_ALL_REVIEWS_BY_PRODUCT_ID);
            if (resultSet.next()) {
                Review review = (Review) resultSet.getObject(1);
            }
            logger.log("Successfully executed review by reviewId query.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Caught exception: " + e.getMessage());
        }
    }
    public void review(String productId, Context context) {
        // Select productId, avg(score) from 'reviews' where productId=productId
        logger.log("Invoked reviews by productId select query");
        try {
            Statement stmt = createConnection(context);
            ResultSet resultSet = stmt.executeQuery(GET_REVIEW_BY_REVIEW_ID);
            if (resultSet.next()) {
                Review review = (Review) resultSet.getObject(1);
            }
            logger.log("Successfully executed reviews by productId query.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Caught exception: " + e.getMessage());
        }
    }
    public void postReviews(String reviewId, Context context) {
        // insert into 'reviews'(productId, reviewId, correlationId, score, comments)
        logger.log("Invoked set review query");
        try {
            Statement stmt = createConnection(context);
            ResultSet resultSet = stmt.executeQuery(SET_REVIEW_BY_PRODUCT_ID);
            if (resultSet.next()) {
                Review review = (Review) resultSet.getObject(1);
            }
            logger.log("Successfully executed  set review query.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.log("Caught exception: " + e.getMessage());
        }
    }

}
