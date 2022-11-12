package gdsc.blog.dto.post;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode // 왜 사용되지 ?
/**
 * EqualsAndHashCode 가 사용되는 이유는
 * 컴파일 시점에 자동으로 equals 메소드와 hashCode 메소드 오버라이딩이 됩니다.
 * 클래스에 있는 모든 필드들에 대한 비교를 수행합니다.
 * 위 어노테이션을 사용하게 되면 자바 bean에서 동등성 비교를 위해
 * equals와 hashcode 메소드를 오버라이딩하는 것과 동일합니다
  */
public class WritePostReq {

    @ApiModelProperty(example = "게시글 제목") // Swagger 문서에 명시하기 위한 Anntation
    private String title;

    @ApiModelProperty(example = "게시글 내용")
    private String content;

    @Builder
    public WritePostReq(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
