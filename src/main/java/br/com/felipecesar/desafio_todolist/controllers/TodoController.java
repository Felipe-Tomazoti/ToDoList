package br.com.felipecesar.desafio_todolist.controller;

import br.com.felipecesar.desafio_todolist.domain.Todo;
import br.com.felipecesar.desafio_todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> listAll(){
        return todoService.listAll();
    }

    @PutMapping("{id}")
    public List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("{id}")
    public List<Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }
}
