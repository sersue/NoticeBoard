package org.example.web.dto;

import lombok.Getter;
import org.example.domain.posts.Posts;

@Getter
public class PostsUpdateRequestDto {

    private String tag;
    private String url;
    private String explain;

    public PostsUpdateRequestDto(String tag,String url,String explain){
        this.tag=tag;
        this.url=url;
        this.explain=explain;

    }

    public Posts toEntity(){
        return Posts.builder()
                .tag(tag)
                .url(url)
                .explain(explain)
                .build();
    }
}
