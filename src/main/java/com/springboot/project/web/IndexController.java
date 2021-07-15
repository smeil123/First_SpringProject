package com.springboot.project.web;

import com.springboot.project.service.PostsService;
import com.springboot.project.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    //페이지에 관련된 컨트롤러는 모두 여기에
    private final PostsService postsService;

    //로깅
     private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index(Model model){
        //머스테치 스타터를 compile했기 때문에 자동으로 /src/main/resources/index.mustache 가 붙어서 찾아간다고 보면됨
        model.addAttribute("posts",postsService.findAllDesc());
        logger.trace("Trace");
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        //posts-save.mustache를 호출
        //but mustache에는 API를 호출하는 건 없고 index.js에서 호출해줌
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto); //반환받은 dto를 post에 담아서 전달?

        return "posts-view";
    }
}
