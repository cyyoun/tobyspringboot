package tobyspring.newhelloboot;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class HelloApiTest {

    @Test
    void helloApi(){
        //http localhost:8080/hello?name=Spring
        //httpie[에이치티티파이]

        TestRestTemplate rest = new TestRestTemplate();

        //응답 가져오기
        // {name} : 파라미터로 받음 , String.class : 응답값의 타입 정보, "Spring":{name} 의 치환자 (실제 들어가는 값)
        ResponseEntity<String> res = rest.getForEntity("http://localhost:8080/hello?name={name}", String.class, "Spring");


        //응답 검증
        //status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        //header(content-type) text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);

        //body Hello Spring
        assertThat(res.getBody()).isEqualTo("Hello Spring");

    }
}
