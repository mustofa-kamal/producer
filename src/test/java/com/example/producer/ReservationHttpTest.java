package com.example.producer;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;


@Import(ReservationHttpConfiguration.class)
@WebFluxTest
@RunWith(SpringRunner.class)
public class ReservationHttpTest {


    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ReservationRepository reservationRepository;

    @Test
    public void get() throws Exception {

        Mockito.when(this.reservationRepository.findAll())
                .thenReturn(Flux.just(new Reservation("1", "sohel")));

        this.webTestClient.get()
                .uri("http://localhost:8080/reservations")
                .exchange()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("@.[0].name", "sohel")
                .exists();

    }
}
