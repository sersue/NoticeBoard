package org.example.web;

import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.example.web.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private TestRestTemplate restTemplate;



    @After
    public void teardown() throws Exception
    {
        postsRepository.deleteAll();
    }

    @Test
    public void Post가_등록된다() throws Exception{

        String tag = "#Controller";
        String url = "https://";

        PostsSaveRequestDto postsSaveRequestDto = PostsSaveRequestDto.builder()
                .tag(tag)
                .url(url)
                .writer("suelym")
                .explain("api")
                .build();

        String url1 = "http://localhost:"+port+"/api/posts/save";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url1,postsSaveRequestDto,Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList.get(0).getUrl()).isEqualTo(url);
        assertThat(postsList.get(0).getTag()).isEqualTo(tag);


    }
}
