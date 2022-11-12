package gdsc.blog.service;

import gdsc.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 해당 클래스를 Spring Container 에 빈으로 등록 후 , Spring MVC 서비스로 표시
@RequiredArgsConstructor // final 또는 @NotNull 이 붙은 필드의 생성자를 자동으로 생성해준다.
public class PostService {
    private final PostRepository postRepository;
}
