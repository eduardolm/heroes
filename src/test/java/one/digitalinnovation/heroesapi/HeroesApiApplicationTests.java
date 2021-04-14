package one.digitalinnovation.heroesapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import static one.digitalinnovation.heroesapi.constants.HeroesConstant.HEROES_LOCAL_ENDPOINT;

@SpringBootTest
@DirtiesContext
@AutoConfigureWebTestClient
class HeroesApiApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void getOneHeroeById(){

        webTestClient.get().uri(HEROES_LOCAL_ENDPOINT.concat("/{id}"),"1")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

    @Test
    public void getOneHeronotFound(){

        webTestClient.get().uri(HEROES_LOCAL_ENDPOINT.concat("/{id}"),"10")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    public void deleteHero(){

        webTestClient.delete().uri(HEROES_LOCAL_ENDPOINT.concat("/{id}"),"1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }
}
