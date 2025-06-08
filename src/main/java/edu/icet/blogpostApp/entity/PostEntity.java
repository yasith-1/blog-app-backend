package edu.icet.blogpostApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity()
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String tag;
    private String category;
    private Integer commentCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imageUrl;
}
