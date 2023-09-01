package org.example.jdbc.userpostreaction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Reaction {
    private Integer id;
    private Integer postId;
    private Integer userId;
    private ReactType reactType;

    @Override
    public String toString() {
        return "Reaction{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId=" + userId +
                ", reactType=" + reactType +
                '}';
    }
}

