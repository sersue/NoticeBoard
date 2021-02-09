package org.example.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String tag;
    private String url;
    private String writer;
    private String explain;



    @Builder
    public PostsSaveRequestDto(String tag, String url, String writer, String explain){
        this.tag = tag;
        this.url=url;
        this.writer =writer;
        this.explain= explain;

    }

    public Posts toEntity(){
        return Posts.builder()
                .tag(tag)
                .url(url)
                .writer(writer)
                .explain(explain)
                .build();
    }
}
