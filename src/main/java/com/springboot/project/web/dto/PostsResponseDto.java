package com.springboot.project.web.dto;

import com.springboot.project.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private Integer readCount;

    public PostsResponseDto(Posts entity){
        // Entity의 필드 중 일부만 사용하니까 생성자로 entity를 받아 필드에 값을 넣음
        // 굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 entity를 받아서 처리
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.readCount = entity.getReadCount();
    }
}
