package dev.ldk.crud.post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController // Controller = ResponseBody
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger= LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postlist;// Final: 초기화된 후 변수를 할당 할수 없다.즉 참조값을 변경 하지 않도록 한다.
    public PostRestController() {
        this.postlist = new ArrayList<>();
    }
    //http://localhost:8080/post
    // Post/post
    //Request_body

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)// Client 가 더 구체적인 상태를 확인 할수 있다.
    public void createPost(@RequestBody PostDto postdto){
        logger.info(postdto.toString());
        this.postlist.add(postdto);

    }
    //http://localhost:8080/post
    //Get/post

    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("Post all");
        return this.postlist;
    }

    //Get/post/0/
    //Get/post?id=0
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postlist.get(id);
    }

    //Put/post/0/
    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") int id,@RequestBody PostDto postdto){
        logger.info(id+"is changed");
        PostDto targetPost= this.postlist.get(id);// 기존 리스트에서 업데이트할 인덱스의 값을 targetPost 저장
        if (postdto.getTitle()!= null){
            targetPost.setTitle(postdto.getTitle());// 업데이트를 할 데이터의 제목이 null 값이 아니면 targetPost title 변경
        }
        if (postdto.getContent() != null){
            targetPost.setContent(postdto.getContent());// 업데이트를 할 데이터의 컨텐츠가 null 값이 아니면 targetPost content 변경
        }
        this.postlist.set(id,targetPost);// post list 업데이트
    }

    //Delete/post/0
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id")int id){
        logger.info(id + "is Delete");
        this.postlist.remove(id);

    }
}
