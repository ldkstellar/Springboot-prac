package dev.ldkstellar.mybatis.mapper;

import dev.ldkstellar.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    int updatePost (PostDto dto);
    int deletePost (int id);
    PostDto readPostQuery(PostDto dto);
    int createPostAll(List<PostDto> dtoList);
}
