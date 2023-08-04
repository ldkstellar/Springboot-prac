package dev.ldkstellar.mybatis;

import dev.ldkstellar.mybatis.dao.BoardDao;
import dev.ldkstellar.mybatis.dao.PostDao;
import dev.ldkstellar.mybatis.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;

    public TestComponent(
            @Autowired PostDao postDao,
            @Autowired BoardDao boardDao
    ) {
        this.postDao = postDao;
        this.boardDao = boardDao;
        BoardDto boardDto = new BoardDto();
        boardDto.setName("newboard");
        this.boardDao.createBoard(boardDto);
        System.out.println(boardDto.getId());

//        PostDto newPost = new PostDto();
//        newPost.setTitle("해바라기");
//        newPost.setContent("그림");
//        newPost.setWriter("빈센트반고흐");
//        newPost.setId(1);
//        this.postDao.createPost(newPost);
//        List<PostDto> postDtoList = this.postDao.readPostAll();
//
//        System.out.println(postDtoList.get(postDtoList.size()-1));
//
//        PostDto firstPost = postDtoList.get(0);
//        firstPost.setContent("유화그림");
//        postDao.updatePost(firstPost);
//        System.out.println(this.postDao.readPost(firstPost.getId()));
    }
}
