package edu.icet.blogpostApp.dto;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
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
