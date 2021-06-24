package com.springboot.project.service;

import com.springboot.project.domain.posts.Posts;
import com.springboot.project.domain.posts.PostsRepository;
import com.springboot.project.web.dto.PostsListResponseDto;
import com.springboot.project.web.dto.PostsResponseDto;
import com.springboot.project.web.dto.PostsSaveRequestDto;
import com.springboot.project.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//final이 선언된 모든 필드를 인자값으로 하는 생성자를 만듦
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    //readOnly를 쓰면 조회 속도가 개선됨됨
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
        //postsRepository 결과롤 넘어온 Posts의 Stream을 map을 통해
        //PostsListResponseDto 로 변환 -> List로 반환하는 메소드
    }
}
