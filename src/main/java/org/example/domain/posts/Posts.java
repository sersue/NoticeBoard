package org.example.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.BaseTimeEntity;

import javax.persistence.*;

@Entity
@NoArgsConstructor //entity는 기본 생성자 꼭 필요
@Getter
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;
    //태그
    @Column(length = 500, nullable = false)
    private String Tag;
    //url
    @Column(length = 500, nullable = false)
    private String Url;
    //작성자
    @Column(length = 50, nullable = false)
    private String writer;
    //구체적인설명란
    @Column(columnDefinition = "TEXT", nullable = false)
    private String explain;

    @Builder
    public Posts(String tag, String url, String writer,String explain){
        this.Tag= tag;
        this.Url = url;
        this.writer =writer;
        this.explain = explain;
    }
}
