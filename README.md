# ProductReviewEngine
### About the Product
A Product Review Engine for a product catalogue with following features :  

1. Reviewer submits a review score and comments for catalog item
2. Review Engine computes the aggregated review score for the catalog item
3. Users able to read reviews submitted by other users for the item
4. Review Engine functionality exposed as REST APIs  

### Tech Stack
An API app built on top of AWS API Gateway, Aurora, Lambda and a few more things AWS

### Deployment details
API is deployed on AWS API gateway at  https://bmtoknhurh.execute-api.us-east-1.amazonaws.com/ The engine uses AWS, Amazon API Gateway, Amazon Lambda function Java (instead of traditional Jax RS Java implementation)

### Steps to deploy
Step 1: Create Lambda Function
This function will implement the Lambda handler function.
More details: http://docs.aws.amazon.com/lambda/latest/dg/java-programming-model-handler-types.html

Step 2: Create Deployment Package
Deployment package is a standalone .jar . Requires Maven shade plugin installation. 
```
<plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-shade-plugin</artifactId>
      <version>2.3</version>
      <configuration>
          <createDependencyReducedPom>false</createDependencyReducedPom>
      </configuration>
      <executions>
          <execution>   
              <phase>package</phase>
              <goals>
                  <goal>shade</goal>
              </goals>
          </execution>
      </executions>
</plugin>

```
Package creation instructions: http://docs.aws.amazon.com/lambda/latest/dg/java-create-jar-pkg-maven-no-ide.html

Step 3: 
Create Lambda function through the AWS console. <br/>

Instructions:
  * Sign into the AWS Management Console
  * Open the AWS Lambda console and choose the region. 
  * Configure function, name the function reviewEngineHandler
  * In Handler, specify package.class-name::handler 
 
Step 4: API Gateway
  * Create an API : Sign into the API Gateway console at https://console.aws.amazon.com/apigateway.
  * Create a Resource : Multiple resources created including products/reviews etc.
  * Deploy the API : In the Resources pane, choose Deploy API to production stage.

Step 5: Test via POSTMAN
<br/>
sample curl: <br/>
    ```
    curl -X POST \
      https://bmtoknhurh.execute-api.us-east-1.amazonaws.com/production/catalog/products/5/reviews \
      -d '{
        "comment":"okay",
        "review":4
    }'
    ```

Note: AWS API Gateway config added as screenshots at src/main/java/resources/api-gateway
Note: Swagger JSON can be exported from the API Gateway at stage editor.  

