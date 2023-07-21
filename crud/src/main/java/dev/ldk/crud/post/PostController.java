package dev.ldk.crud.post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody

public class PostController {
   private  static  final Logger logger = LoggerFactory.getLogger(PostController.class);
   private  final PostService postService;

    public PostController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postdto){
        logger.info(postdto.toString());
        this.postService.createPost(postdto);

    }

    @GetMapping("read-all")
    public  List<PostDto> readPostAll(){
        logger.info("in read all.");
        return this.postService.readAll();
    }

    @GetMapping("read-one")
    public  PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void updatePost(@RequestParam("id")int id,
                           @RequestBody PostDto postdto) {
        logger.info("target id: " + id);
        logger.info("update content" + postdto);
        this.postService.updatePost(id, postdto);

    }
    @DeleteMapping("delete")
    public void delete(@RequestParam("id") int id){
        this.postService.deletePost(id);
    }
}
