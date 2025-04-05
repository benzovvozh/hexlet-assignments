package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookMapper mapper;

    public List<BookDTO> findAll() {
        var list = repository.findAll();
        return list.stream()
                .map(mapper::map)
                .toList();
    }

    public BookDTO create(BookCreateDTO data) {
        var book = mapper.map(data);
        repository.save(book);
        return mapper.map(book);
    }

    public BookDTO findById(Long id) {
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        var bookDTO = mapper.map(book);
        bookDTO.setAuthorFirstName(book.getAuthor().getFirstName());
        bookDTO.setAuthorLastName(book.getAuthor().getLastName());
        return bookDTO;
    }
    public BookDTO update(Long id, BookUpdateDTO data){
        var book = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        mapper.update(data,book);
        repository.save(book);
        return mapper.map(book);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    // END
}
