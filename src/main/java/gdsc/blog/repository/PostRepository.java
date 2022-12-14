package gdsc.blog.repository;

import gdsc.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository  적어야 스프링 IOC에 빈으로 등록이 되는데,
// JpaRepository 를 extends 하면 생략 가능 (자동으로 빈에 등록 됨)
// JpaRepository 는 CRUD 함수를 들고 있음
public interface PostRepository extends JpaRepository<Post, Long> {

}
