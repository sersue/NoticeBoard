package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.domain.posts.PostsRepository;
import org.example.web.dto.PostsListReponseDto;
import org.example.web.dto.PostsResponseDto;
import org.example.web.dto.PostsSaveRequestDto;
import org.example.web.dto.PostsUpdateRequestDto;
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
    @Transactional
    public Long update(Long index,PostsUpdateRequestDto postsUpdateRequestDto){
        Posts posts = postsRepository.findById(index)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id:"+index));

        posts.update(postsUpdateRequestDto.getTag(),postsUpdateRequestDto.getUrl(),postsUpdateRequestDto.getExplain());
        return index;

    }

    public PostsResponseDto findById(Long index){
        Posts entity = postsRepository.findById(index)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+index));

        return new PostsResponseDto(entity);
    }
}
