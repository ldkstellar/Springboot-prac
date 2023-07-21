package dev.ldk.crud.post;

import java.util.List;

public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readAll ();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);
}
