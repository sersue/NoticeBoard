package org.example.web;

import lombok.Builder;
import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void clenup(){
        postsRepository.deleteAll();
    }
    @Test
    public void repository에_저장된다(){
        String tag = "Controller";
        String url = "https://";
        postsRepository.save(Posts.builder()
                .tag(tag)
                .url(url)
                .writer("suelym")
                .explain("about @Controller")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts =postsList.get(0);
        assertThat(posts.getTag()).isEqualTo(tag);
        assertThat(posts.getUrl()).isEqualTo(url);

    }

}
