package com.springboot.project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    //페이지에 관련된 컨트롤러는 모두 여기에
    @GetMapping("/")
    public String index(){
        //머스테치 스타터를 compile했기 때문에 자동으로 /src/main/resources/index.mustache 가 붙어서 찾아간다고 보면됨
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        //posts-save.mustache를 호출
        //but mustache에는 API를 호출하는 건 없고 index.js에서 호출해줌
        return "posts-save";
    }
}
