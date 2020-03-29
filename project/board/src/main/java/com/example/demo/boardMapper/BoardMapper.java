package com.example.demo.boardMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.boardDto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	List<BoardDto> insertBoard(BoardDto board) throws Exception;
//	��ȸ�� ������ ���� ����
	void uptadeHitCount(int boardIdx) throws Exception;
	
//	selectBoardDetail�޼ҵ�� int boardIdx ���·� db��  ������ ���ϰ��� BoardDto���·� �ްڴ�.
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;
	
	void deleteBoard(int boardIdx) throws Exception;
}
