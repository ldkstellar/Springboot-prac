package dev.ldkstellar.mybatis.mapper;

import dev.ldkstellar.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);

}
