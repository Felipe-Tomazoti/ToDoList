package br.com.felipecesar.desafio_todolist.resource;

import br.com.felipecesar.desafio_todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
