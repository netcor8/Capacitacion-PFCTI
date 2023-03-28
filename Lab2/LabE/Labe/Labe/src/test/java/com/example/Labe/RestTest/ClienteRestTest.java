package com.example.Labe.RestTest;


import com.example.Labe.springData.dto.ClienteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteRestTest {

    @LocalServerPort
    private int port = 0;

    private WebTestClient webTestClient = null;

    private String BASEURL = "http://localhost";
    private static final  String BASERESTURL = "/v1/api/cliente";

    @BeforeEach
    void setUp(){
     // BASEURL = BASEURL.concat(":").concat(port.t) concat(port. toString()).concat(BASERESTURL);
      BASEURL = BASEURL + ":" + port + BASERESTURL;
      webTestClient = WebTestClient.bindToServer().
              baseUrl(BASEURL)
              .responseTimeout(Duration.ofSeconds(3600))
              .build();

    }


    @Test
    void obtenerTodoslosClientes(){
        List<ClienteDto> clienteDtoList = this .webTestClient.get()
                .uri("/all")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(ClienteDto.class)
                .returnResult()
                .getResponseBody();
                    System.out.println("Clientes: " + clienteDtoList);

                    assertFalse(clienteDtoList.isEmpty());


               // assertTrue(clienteDtoList.get(0).getNombre()!= null);

    }

}
