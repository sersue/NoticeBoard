package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.example.web.dto.PostsResponseDto;
import org.example.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

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

    @GetMapping("/posts/update/{index}")
    public String postUpdate(@PathVariable Long index, Model model) {
        PostsResponseDto dto = postsService.findById(index);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
