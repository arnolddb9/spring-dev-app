package com.pfcti.spring.dev.app.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoFluxTest {
    @Test
    public void givenMonoPublisher_whenSubscribeThenReturnSingleValue() {
        Mono<String> helloMono = Mono.just("Hello");
        StepVerifier.create(helloMono)
                .expectNext("Hello").expectComplete().verify();
    }

    @Test
    public void givenFluxPublisher_whenSubscribedThenReturnMultipleValues() {
        Flux<String> stringFlux = Flux.just("Hello", "Spring Course");
        StepVerifier.create(stringFlux)
                .expectNext("Hello").expectNext("Spring Course").expectComplete()
                .verify();
    }

    @Test
    public void givenFluxPublisher_whenSubscribedThenReturnMultipleValuesIntegers() {
        Flux<Integer> stringFlux = Flux.just(1, 2,3,4,5);
        StepVerifier.create(stringFlux)
                .expectNext(1).expectNext(2)
                .expectNext(3).expectNext(4)
                .expectNext(5)
                .expectComplete()
                .verify();
    }

    @Test
    public void givenFluxPublisher_whenSubscribeThenReturnMultipleValuesWithError() {
        Flux<String> stringFlux = Flux.just("Hello", "Spring course", "Error").map(str -> {
            if (str.equals("Error"))
                throw new RuntimeException("Throwing Error");
            return str;
        });
        StepVerifier.create(stringFlux).expectNext("Hello").expectNext("Spring course").expectError()
                .verify();
    }

}
