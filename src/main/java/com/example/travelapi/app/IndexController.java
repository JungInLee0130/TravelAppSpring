package com.example.travelapi.app;

import com.example.travelapi.app.dto.PostsResponseDto;
import com.example.travelapi.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 모든 페이지 관련 컨트롤러
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // src/main/resources/templates/index.mustache로 자동 지정
    }

    // 글 등록. posts-save.mustache를 호출
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    // 글 수정.
    @GetMapping("/posts/update/{id}")
    public String postsUpdate (@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return  "posts-update";
    }
}
