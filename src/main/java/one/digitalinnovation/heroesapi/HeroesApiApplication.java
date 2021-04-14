package one.digitalinnovation.heroesapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroesApiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HeroesApiApplication.class, args);
        System.out.println("\nSuper poderes com WebFlux\n");
    }

}
