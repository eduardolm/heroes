package one.digitalinnovation.heroesapi.controller;

import one.digitalinnovation.heroesapi.document.Heroes;
import one.digitalinnovation.heroesapi.service.HeroesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static one.digitalinnovation.heroesapi.constants.HeroesConstant.HEROES_LOCAL_ENDPOINT;

@RestController
@RequestMapping(HEROES_LOCAL_ENDPOINT)
public class HeroesController {

    private static final Logger logger = LoggerFactory.getLogger(HeroesController.class);

    private final HeroesService heroesService;

    public HeroesController(HeroesService heroesService) {
        this.heroesService = heroesService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Heroes> create(Heroes heroes) {
        logger.info("A new hero has been created!");
        return heroesService.create(heroes);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAll() {
        logger.info("Requesting heroes list...");
        return heroesService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Heroes>> getById(@PathVariable("id") String id) {
        logger.info("Requesting hero by id: " + id);
        return heroesService.findByIdHero(id)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteById(@PathVariable("id") String id) {
        logger.info("Deleting hero with id: " + id);
        heroesService.deleteByIdHero(id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
