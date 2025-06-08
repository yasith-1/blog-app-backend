package edu.icet.blogpostApp.service;

import edu.icet.blogpostApp.dto.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    String addPost(Post post);
    Post getSpecifyPost(Integer id);
    Boolean updatePost(Post post);
}
