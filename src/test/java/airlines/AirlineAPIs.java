package airlines;

import io.restassured.response.Response;
import pojos.Airline;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirline(Map<String,Object> Payload){
     String endPoint= (String) Base.dataFromJsonFile.get("createAirlineEndPoint");
        return RestUtils.performPost(endPoint,Payload,new HashMap<>());
    }

    public Response createAirline(Airline Payload ){
        String endPoint= (String) Base.dataFromJsonFile.get("createAirlineEndPoint");
        return RestUtils.performPost(endPoint,Payload,new HashMap<>());
    }

    public Response getAirline(String id){
        String endPoint= (String) Base.dataFromJsonFile.get("getAirlineEndPoint");
        return RestUtils.performGet(endPoint,id,new HashMap<>());
    }
}
