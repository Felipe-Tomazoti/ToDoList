package br.com.felipecesar.desafio_todolist;

import br.com.felipecesar.desafio_todolist.domains.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class DesafioTodolistApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("todo 1", "desc todo 1", false, 2);

        webClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].nome").isEqualTo(todo.getNome())
                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
    }

    @Test
    void testCreateTodoFailure() {

        webClient
                .post()
                .uri("/todos")
                .bodyValue(
                        new Todo("", "",false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }
}
