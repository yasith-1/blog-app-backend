package edu.icet.blogpostApp.service.impl;

import edu.icet.blogpostApp.dto.Post;
import edu.icet.blogpostApp.entity.PostEntity;
import edu.icet.blogpostApp.repository.PostRepository;
import edu.icet.blogpostApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    //    Post repository reference
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        if (postRepository.findAll().isEmpty()) {
            return null;
        } else {
            List<PostEntity> postEntityList = postRepository.findAll();

            //    Post list
            List<Post> postList = new ArrayList<>();

            for (PostEntity postEntity : postEntityList) {
                Post post = new Post(
                        postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getTag(),
                        postEntity.getCategory(),
                        postEntity.getCommentCount(),
                        postEntity.getCreatedAt(),
                        postEntity.getUpdatedAt(),
                        postEntity.getImageUrl());

                postList.add(post);
            }

            return postList;
        }
    }

    @Override
    public String addPost(Post post) {
//      Posting time stamp
        Timestamp postAddingTimeStamp = Timestamp.valueOf(LocalDateTime.now());
        PostEntity postEntity = new PostEntity(
                null,
                post.getTitle(),
                post.getContent(),
                post.getTag(),
                post.getCategory(),
                post.getCommentCount(),
                postAddingTimeStamp,
                postAddingTimeStamp,
                post.getImageUrl());

        PostEntity save = postRepository.save(postEntity);

        if (save.getId() != null) {
            return "Post saved successfully";
        } else {
            return "Failed to save post.";
        }
    }

    @Override
    public Post getSpecifyPost(Integer id) {

        boolean isPresent = postRepository.findById(id).isPresent();

        if (isPresent) {
            PostEntity postEntity = postRepository.findById(id).get();

            Post post = new Post(postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getTag(),
                    postEntity.getCategory(),
                    postEntity.getCommentCount(),
                    postEntity.getCreatedAt(),
                    postEntity.getUpdatedAt(),
                    postEntity.getImageUrl());

            return post;
        }
        return null;
    }

    @Override
    public Boolean updatePost(Post post) {
//        Post updating date and time
        Timestamp postUpdatingTimeStamp = Timestamp.valueOf(LocalDateTime.now());
        if (postRepository.findById(post.getId()).isPresent()) {
            PostEntity postEntity = new PostEntity(post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getTag(),
                    post.getCategory(),
                    post.getCommentCount(),
                    post.getCreatedAt(),
                    postUpdatingTimeStamp,
                    post.getImageUrl());

            postRepository.save(postEntity);

            return true;
        }
        return false;
    }
}
