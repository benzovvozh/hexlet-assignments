package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::postToDto)
                .toList();
        return result;
    }
    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable("id") long id){
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        var postDto = postToDto(post);
        return postDto;
    }

    private PostDTO postToDto(Post post) {
        var postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setBody(post.getBody());
        postDTO.setTitle(post.getTitle());
        var comments = commentRepository.findByPostId(post.getId());
        var commentsDto = new ArrayList<CommentDTO>();
        for (var comment : comments) {
            commentsDto.add(comToDto(comment));
        }
        postDTO.setComments(commentsDto);
        return postDTO;
    }

    private CommentDTO comToDto(Comment comment) {
        var commentDto = new CommentDTO();
        commentDto.setBody(comment.getBody());
        commentDto.setId(comment.getId());
        return commentDto;
    }
}
// END
