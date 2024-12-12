package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomTypeNames;

import java.util.stream.Stream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(toBuilder = true)
public class Airline {
    //private String gender= Stream.of("male","female","others").findAny().get();
    private int id=Integer.parseInt(RandomDataGenerator.getRandomNumber(6));
    private String name=RandomDataGenerator.getRandomDataFor(RandomTypeNames.FIRSTNAME);
    private String country=RandomDataGenerator.getRandomDataFor(RandomTypeNames.COUNTRY);
    private String logo=RandomDataGenerator.getRandomAlphabets(25);
    private String slogan=RandomDataGenerator.getRandomAlphabets(20);
    private String head_quaters=RandomDataGenerator.getRandomDataFor(RandomTypeNames.CITYNAME);
    private String website=RandomDataGenerator.getRandomWebsiteName(10);
    private String established=String.valueOf(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentYear()));

}
