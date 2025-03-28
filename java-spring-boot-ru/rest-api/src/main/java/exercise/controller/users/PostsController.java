package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();
    @GetMapping("/users/{userId}/posts")
    public List<Post> showPosts(@PathVariable Integer userId) {
        var posts1 = posts.stream()
                .filter(p -> p.getUserId() == userId)
                .toList();
        return posts1;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/{userId}/posts")
    public Post create(@PathVariable Integer userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post);
        return post;
    }
}
// END
