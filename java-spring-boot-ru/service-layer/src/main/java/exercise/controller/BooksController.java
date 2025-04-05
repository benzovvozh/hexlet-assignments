package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping(path = "")
    public List<BookDTO> index() {
        var list = bookService.findAll();
        return list;
    }

    @GetMapping(path = "/{id}")
    public BookDTO show(@PathVariable("id") long id) {
        var book = bookService.findById(id);
        return book;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody @Valid BookCreateDTO data) {
        var book = bookService.create(data);
        return book;
    }

    @PutMapping(path = "/{id}")
    public BookDTO update(@PathVariable("id") long id, @RequestBody @Valid BookUpdateDTO data) {
        return bookService.update(id, data);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable("id") long id) {
        bookService.delete(id);
    }
    // END
}
