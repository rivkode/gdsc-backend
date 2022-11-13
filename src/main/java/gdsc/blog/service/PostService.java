package gdsc.blog.service;

import gdsc.blog.domain.Post;
import gdsc.blog.dto.post.WritePostReq;
import gdsc.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service // 해당 클래스를 Spring Container 에 빈으로 등록 후 , Spring MVC 서비스로 표시
@RequiredArgsConstructor // final 또는 @NotNull 이 붙은 필드의 생성자를 자동으로 생성해준다.
public class PostService {
    private final PostRepository postRepository;

    @Transactional // 해당 함수 종료시, commit 또는 Rollback 수행 (트랜잭션 관리)
    public Post save(WritePostReq writePostReq) {
        return postRepository.save(writePostReqToPost(writePostReq));

//        Post post = Post.builder()
//                .title(writePostReq.getTitle())
//                .content(writePostReq.getContent()).build();
//        return postRepository.save(post);
    }

    private Post writePostReqToPost(WritePostReq writePostReq) {
        return Post.builder()
                .title(writePostReq.getTitle())
                .content(writePostReq.getContent()).build();
    }

    @Transactional(readOnly = true) // JPA 변경감지(Database의 객체 필드값의 변경을 감지하는 내부 기능) off
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id를 확인해주세요 !!"));
    }

    // 해당 서비스 함수 종료 시 -> 트랜잭션 종료 시 -> 영속화 되어있는 데이터를 DB로 갱신 (flush) ->
    // DB 에 commit / DB에 commit이 어떤의미일까 ?
    @Transactional
    public Post updateById(Long id, WritePostReq writePostReq) {
        Post postEntity = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("id를 확인해주세요 !!"));

        postEntity.setTitle(writePostReq.getTitle());
        postEntity.setContent(writePostReq.getContent());

        return postEntity;
    }

    public String deleteByID(Long id) {
        try {
            postRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("id 를 확인해주세요 !");
        }

        return "ok";
    }
}
