package edu.icet.blogpostApp.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String nanme;
    private String username;
    private String password;
}
