package airlines;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    // A static Map to hold data loaded from the JSON file
    public static Map<String, Object> dataFromJsonFile;

    // Static block to initialize the Map
    static {
        // Determine the environment, defaulting to "qa" if not provided
        String env = System.getProperty("env", "qa");

        try {
            // Load the JSON data as a Map using a utility function
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("/" + env + "/airlineAPIData.json");
        } catch (IOException e) {
            // Wrap checked exception in an unchecked exception
            throw new RuntimeException("Error loading JSON data for environment: " + env, e);
        }
    }
}
//public static Map<String, Object> dataFromJsonFile;
//static {
//    String env=System.getProperty("env") == null ? "qa" : System.getProperty("env");
//
//    try {
//        dataFromJsonFile= JsonUtils.getJsonDataAsMap("/"+env+"/airlineAPIData.json");
//    } catch (IOException e) {
//        throw new RuntimeException(e);
//    }
//}


