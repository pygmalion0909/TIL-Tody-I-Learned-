package com.example.demo.boardMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.boardDto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	List<BoardDto> insertBoard(BoardDto board) throws Exception;
//	조회수 증가를 위한 로직
	void uptadeHitCount(int boardIdx) throws Exception;
	
//	selectBoardDetail메소드는 int boardIdx 형태로 db에  보내고 리턴값은 BoardDto형태로 받겠다.
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}
