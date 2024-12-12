package airlines;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AirlineVerify extends AirlineAPIs{

    private static String id;
    @Test
    public void createAirlineAndVerifyResponse() throws IOException {

        pojos.Airline payLoad=new pojos.Airline();
        Response response= createAirline(payLoad);


        //first way
        Assert.assertEquals(response.jsonPath().getString("name"),payLoad.getName());

        id=response.jsonPath().getString("_id");
//        //second way as deseriliaze
//        ObjectMapper objectMapper=new ObjectMapper();
//
//        pojos.Airline createAirlineResponse=objectMapper.readValue(response.getBody().asString(), pojos.Airline.class);
//        Assert.assertEquals(createAirlineResponse,payLoad);





    }

    @Test(dependsOnMethods="createAirlineAndVerifyResponse")
    public void getAllAirlinesData(){


        //get request
        //String id="b523331d-1e9f-46ea-a674-92259d9f1a3b";

        Response response=  getAirline(id);
       System.out.println(response.jsonPath().getString("country"));
        Assert.assertEquals(response.statusCode(),200);

     //Assert.assertEquals(response.jsonPath().getString("country"),"Azerbaijan");
      //Assert.assertEquals(response.jsonPath().getString("established"),"1987");
    }

}
