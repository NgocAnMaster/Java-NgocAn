package org.example.jdbc.userpostreaction;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Post {
    private Integer id;
    private Integer userId;
    private LocalDateTime publishedAt;
    private String content;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                '}';
    }
}
