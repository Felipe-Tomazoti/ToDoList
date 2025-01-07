package br.com.felipecesar.desafio_todolist.service;

import br.com.felipecesar.desafio_todolist.domain.Todo;
import br.com.felipecesar.desafio_todolist.resource.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> listAll(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending()
        );

        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long Id, Todo todo) {
        todoRepository.findById(Id).ifPresentOrElse((existingTodo) -> {
            todo.setId(Id);
            todoRepository.save(todo);
        }, () -> {
        });

        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return listAll();
    }

}

