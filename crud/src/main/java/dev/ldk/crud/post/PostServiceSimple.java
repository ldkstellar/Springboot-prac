package dev.ldk.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceSimple implements PostService{
    private static final Logger looger = LoggerFactory.getLogger(PostServiceSimple.class);// 정적
    private final PostRepository postRepository;
    public PostServiceSimple(
            @Autowired PostRepository postRepository
    ) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        //Todo
        if(!this.postRepository.save(dto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readAll() {
            return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findByID(id);
    }

    @Override
    public void updatePost(int id, PostDto dto) {
         this.postRepository.update(id, dto);

    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);
    }
}
