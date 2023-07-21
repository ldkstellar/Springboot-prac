package dev.ldk.crud.post;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger= LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;
    public PostRestController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postdto){
        logger.info(postdto.toString());
        this.postService.createPost(postdto);
    }

    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("Post all");
       return postService.readAll();

    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return postService.readPost(id);

    }

    //Put/post/0/
    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") int id,@RequestBody PostDto postdto){
        logger.info("target id: " + id);
        logger.info("update content" + postdto);
        postService.updatePost(id,postdto);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id")int id){
        logger.info(id + "is Delete");
        postService.deletePost(id);
    }
}
