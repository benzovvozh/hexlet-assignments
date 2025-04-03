package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import exercise.repository.ProductRepository;
import exercise.dto.ProductDTO;
import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    // BEGIN
    @GetMapping(path = "")
    public List<ProductDTO> index() {
        var list = productRepository.findAll();
        var result = new ArrayList<ProductDTO>();
        for (var value : list) {
            result.add(mapper.map(value));
        }
        return result;
    }

    @GetMapping(path = "/{id}")
    public ProductDTO show(@PathVariable("id") long id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        return mapper.map(product);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductCreateDTO model) {
        var product = mapper.map(model);
        productRepository.save(product);
        return mapper.map(product);
    }

    @PutMapping(path = "/{id}")
    public ProductDTO update(@PathVariable("id") long id, @RequestBody ProductUpdateDTO model) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        mapper.update(model, product);
        productRepository.save(product);
        return mapper.map(product);
    }
    // END
}
