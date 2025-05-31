package edu.icet.blogpostApp.entity;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    private Integer id;
    private String title;
    private String content;
    private String tags;
    private String category;
    private Integer commentCount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imageUrl;
}
