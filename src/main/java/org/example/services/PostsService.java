package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.example.web.dto.PostsListReponseDto;
import org.example.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return postsRepository.save(postsSaveRequestDto.toEntity()).getIndex();
    }

    @Transactional
    public List<PostsListReponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListReponseDto(posts))
                .collect(Collectors.toList());
    }
}
