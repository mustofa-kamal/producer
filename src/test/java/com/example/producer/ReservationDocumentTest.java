package com.example.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@WebFluxTest
@RunWith(SpringRunner.class)
public class ReservationDocumentTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void persist() throws Exception {
        Reservation p = new Reservation(null, "sohe;");

        Mono<Reservation> mono = reservationRepository.save(p);

        StepVerifier.create(mono).expectNextMatches(r -> r.getId() != null && r.getName().equalsIgnoreCase("sohel"))
                .verifyComplete();
    }
}
