package dev.ldk.crud.post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller//
@ResponseBody //클래스안에 있는 메소드의 형태가 ResponseBody 형태를 가진다.
@RequestMapping("post")
public class PostController {
   private  static  final Logger logger = LoggerFactory.getLogger(PostController.class);
   private  final List<PostDto> postlist;// interface

    public PostController() {
        postlist = new ArrayList<>();// 구현체

    }
    @PostMapping("create")
    public void createPost(@RequestBody PostDto postdto){
        logger.info(postdto.toString());
        this.postlist.add(postdto);

    }
    @GetMapping("read-all")
    public  List<PostDto> readPostAll(){
        logger.info("in read all.");
        return this.postlist;
    }
    @GetMapping("read-one")
    public  PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postlist.get(id);
    }
    @PostMapping("update")
    public void updatePost(@RequestParam("id")int id,
                           @RequestBody PostDto postdto){  //업데이트 할 데이터
         PostDto targetPost= this.postlist.get(id);// 기존 리스트에서 업데이트할 인덱스의 값을 targetPost 저장
         if (postdto.getTitle()!= null){
             targetPost.setTitle(postdto.getTitle());// 업데이트를 할 데이터의 제목이 null 값이 아니면 targetPost title 변경
         }
         if (postdto.getContent() != null){
             targetPost.setContent(postdto.getContent());// 업데이트를 할 데이터의 컨텐츠가 null 값이 아니면 targetPost content 변경
         }
         this.postlist.set(id,targetPost);// post list 업데이트
    }
    @DeleteMapping("delete")
    public void delete(@RequestParam("id") int id){
        this.postlist.remove(id);
    }
}
