package utils;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static Faker faker=new Faker();


   public static String getRandomDataFor(RandomTypeNames dataTypeNames){
        switch (dataTypeNames){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.address().country();
            case CITYNAME:
                return faker.address().cityName();

            default:
                throw new IllegalStateException("Unexpected value: " + dataTypeNames);
        }
   }

   public static String getRandomNumber(int count){
       return faker.number().digits(count);
   }

    public static int getRandomNumber(int min,int max){
        return faker.number().numberBetween(min,max);
    }

    public static String getRandomAlphabets(int count){
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static String getRandomWebsiteName(int count){
        return "https://"+RandomStringUtils.randomAlphabetic(count)+".com";
    }
}
