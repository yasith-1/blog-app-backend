package edu.icet.blogpostApp.repository;

import edu.icet.blogpostApp.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Integer> {
}
