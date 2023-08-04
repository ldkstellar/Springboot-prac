package dev.ldkstellar.mybatis.dao;
import dev.ldkstellar.mybatis.dto.PostDto;
import dev.ldkstellar.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;
    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    )
    {
        this.sessionFactory = sessionFactory;

    }
    public int createPost(PostDto dto){
        try( SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
    }
    public PostDto readPost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll(){
        try(SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }

    }
    public  int updatePost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }
    public int deletePost(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }

    public PostDto readPostQuery(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostQuery(dto);
        }

    }

    public int createPostAll(List<PostDto> dtoList){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPostAll(dtoList);
        }
    }
}
