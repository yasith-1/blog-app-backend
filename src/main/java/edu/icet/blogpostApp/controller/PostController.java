package edu.icet.blogpostApp.controller;

import edu.icet.blogpostApp.dto.Post;
import edu.icet.blogpostApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/blogpost")
public class PostController {
    @Autowired
    PostService service;

    @GetMapping("/get-all")
    public <T> T getAll() {
        if (service.getAllPosts() == null) {
            return (T) (String) "No Post Available Right Now ⁉️";
        }
        return (T) service.getAllPosts();
    }

    @PostMapping("/add-post")
    public String addPost(@RequestBody Post post) {
        return service.addPost(post);
    }
}
