package com.springboard.myapp.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.myapp.board.BoardDao;
import com.springboard.myapp.board.BoardService;
import com.springboard.myapp.board.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	// 댓글 등록
	@Override
	public void insertCommnet(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.insertCommnet(vo);
	}

	// 글 등록
	@Override
	public void insertArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.insertArticle(vo);
	}
	
	@Override
	public void insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(vo);
	}

}
