package com.example.demo.boardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.boardDto.BoardDto;
import com.example.demo.boardMapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		System.out.println("!!!!!!!!!"+boardMapper.selectBoardList());
		return boardMapper.selectBoardList();
	}
	
	@Override
	public void insertBoard(BoardDto board) throws Exception{
		boardMapper.insertBoard(board);
	}
	
	@Override
	public BoardDto SelectBoardDetail(int boardIdx) throws Exception{
		boardMapper.uptadeHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) throws Exception{
		boardMapper.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(int boardIdx) throws Exception{
		boardMapper.deleteBoard(boardIdx);
	}
}
