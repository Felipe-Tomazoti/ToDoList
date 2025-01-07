package br.com.felipecesar.desafio_todolist.resources;

import br.com.felipecesar.desafio_todolist.domains.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
