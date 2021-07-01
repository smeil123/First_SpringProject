package com.springboot.project.domain.posts;

import com.springboot.project.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가, public Posts() {}와 같은 효과
@Entity
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙
    private Long id;

    // 테이블의 컬럼, 굳이 안써도되지만 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    private Integer readCount;

    // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더
    // 생성자나 빌더나 생성 시점에 값을 채워주는 역할은 똑같으나,
    // 생성자의 경우 지금 채워야할 필드가 무엇인지 지정할 수가 없다
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.readCount = 0;
    }

    // 쿼리를 날리지 않고 update가능 -> JPA 영속성 컨텍스트 때문에
    // 트랜젝션이 끝나는 시점에 해당 테이블에 변경분을 반영함여 쿼리를 날릴 필요 없음
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void readCount(){
        this.readCount = this.readCount + 1;
    }
}
