package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Post show(@PathVariable("id") long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return post;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        var post1 = post;
        postRepository.save(post1);
        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public Post update(@PathVariable("id") long id, @RequestBody Post newPost) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        post.setTitle(newPost.getTitle());
        post.setBody(newPost.getBody());
        postRepository.save(post);
        return post;
    }
}
// END
