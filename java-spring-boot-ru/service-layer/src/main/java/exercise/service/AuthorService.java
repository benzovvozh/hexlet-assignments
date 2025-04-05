package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository repository;
    @Autowired
    private AuthorMapper mapper;

    public List<AuthorDTO> findAll() {
        var list = repository.findAll();
        return list.stream()
                .map(mapper::map)
                .toList();
    }

    public AuthorDTO create(AuthorCreateDTO data) {
        var author = mapper.map(data);
        repository.save(author);
        return mapper.map(author);
    }

    public AuthorDTO findById(Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        return mapper.map(author);
    }
    public AuthorDTO update (Long id, AuthorUpdateDTO data){
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        mapper.update(data,author);
        repository.save(author);
        return mapper.map(author);
    }
    public void delete (Long id){
        repository.deleteById(id);
    }
    // END
}
