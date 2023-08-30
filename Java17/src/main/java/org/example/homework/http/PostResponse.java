package org.example.homework.http;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private List<Post> posts;
    private Integer total;
    private Integer skip;
    private Integer limit;
}
