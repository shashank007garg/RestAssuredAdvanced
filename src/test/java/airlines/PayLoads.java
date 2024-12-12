package airlines;


import pojos.Airline;
import net.datafaker.Faker;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomTypeNames;

import java.util.HashMap;
import java.util.Map;

public class PayLoads {

    public static String getCreateAirlinePayloadFromString(String id, String name,String country,String logo,String slogan,
                                                 String head_quaters,String website,String established){

        String payLoad="{\n" +
                "    \"_id\": \""+id+"\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return payLoad;
    }

    public static Map<String, Object> getCreateAirlinePayloadFromMap(String id, String name, String country, String logo, String slogan,
                                                                     String head_quaters, String website, String established){

        Map<String,Object> payLoad=new HashMap<>();
        payLoad.put("id",id);
        payLoad.put("name",name);
        payLoad.put("country",country);
        payLoad.put("logo",logo);
        payLoad.put("slogan",slogan);
        payLoad.put("head_quaters",head_quaters);
        payLoad.put("website",website);
        payLoad.put("established",established);


        return payLoad;
    }

    public static Map<String, Object> getCreateAirlinePayloadFromMap(){

        Map<String,Object> payLoad=new HashMap<>();
        Faker faker=new Faker();
        payLoad.put("id",RandomDataGenerator.getRandomNumber(10));
        payLoad.put("name", RandomDataGenerator.getRandomDataFor(RandomTypeNames.FIRSTNAME));
        payLoad.put("country",RandomDataGenerator.getRandomDataFor(RandomTypeNames.COUNTRY));
        payLoad.put("logo", RandomDataGenerator.getRandomAlphabets(25));
        payLoad.put("slogan",RandomDataGenerator.getRandomAlphabets(20));
        payLoad.put("head_quaters",RandomDataGenerator.getRandomDataFor(RandomTypeNames.CITYNAME));
        payLoad.put("website",RandomDataGenerator.getRandomWebsiteName(10));
        payLoad.put("established", DateUtils.getCurrentYear());


        return payLoad;
    }

   public static Airline getCreateAirlinePayloadFromPojo(){

      return Airline
              .builder()
               .id(Integer.parseInt(RandomDataGenerator.getRandomNumber(6)))
               .name(RandomDataGenerator.getRandomDataFor(RandomTypeNames.FIRSTNAME))
               .country(RandomDataGenerator.getRandomDataFor(RandomTypeNames.COUNTRY))
               .logo(RandomDataGenerator.getRandomAlphabets(25))
               .slogan(RandomDataGenerator.getRandomAlphabets(20))
               .head_quaters(RandomDataGenerator.getRandomDataFor(RandomTypeNames.CITYNAME))
               .website(RandomDataGenerator.getRandomWebsiteName(10))
               .established(String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear())))
               .build();

   }
}
