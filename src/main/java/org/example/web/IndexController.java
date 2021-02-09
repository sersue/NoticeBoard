package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.PostsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsRepository postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsave(){
        return "posts-save";
    }
}
