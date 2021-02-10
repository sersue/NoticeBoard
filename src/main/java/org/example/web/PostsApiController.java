package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.services.PostsService;
import org.example.web.dto.PostsResponseDto;
import org.example.web.dto.PostsSaveRequestDto;
import org.example.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/posts/save")
    public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto){
        return postsService.save(postsSaveRequestDto);
    }
    @PutMapping("api/posts/update/{index}")
    public Long update(@PathVariable Long index, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return postsService.update(index, postsUpdateRequestDto);
    }
    @GetMapping("api/posts/update/{index}")
    public PostsResponseDto findById(@PathVariable Long index){
        return postsService.findById(index);
    }

}
