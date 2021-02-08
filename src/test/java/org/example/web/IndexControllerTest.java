package org.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
//@WebMvcTest와 차이점은 @SpringBootTest는 slicing을 하지 않아 전체를 디버깅 하는 것과 똑같음
//@WebMvcTest는 controller만 로딩해줌
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    //스프링 부트 테스트에서는 Mock Test 뿐만 아니라 RestTestTemplate을 이용한 테스트 또한 제공한다.
    //Mock Test 과의 차이는 실제 서블릿 컨테이너 실행 여부이며 RestTestTemplate은 컨테이너를 직접 실행한다.


    @Test
    public void 제목을_리턴한다() {
        String body = this.restTemplate.getForObject("/", String.class);
        //testRestTemplate의 getForObject(URL, Return Type) 으로 요청
        assertThat(body).contains("Notice Board 1.0");

    }
}
