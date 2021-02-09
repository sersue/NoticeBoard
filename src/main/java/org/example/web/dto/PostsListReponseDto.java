package org.example.web.dto;

import lombok.Getter;
import org.example.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListReponseDto {
    private Long index;
    private String url;
    private String tag;
    private String explain;
    private String writer;
    private LocalDateTime modifiedDate;

    public PostsListReponseDto(Posts entity){
        this.index = entity.getIndex();
        this.url = entity.getUrl();
        this.tag = entity.getTag();
        this.explain = entity.getExplain();
        this.writer = entity.getWriter();
        this.modifiedDate = entity.getModifiedDate();
    }
}
