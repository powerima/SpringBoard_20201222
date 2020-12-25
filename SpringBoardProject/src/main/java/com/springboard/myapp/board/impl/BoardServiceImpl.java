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

	// 
	@Override
	public void updateArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.updateArticle(vo);
	}
	
	// 조회수 갱신
	@Override
	public void updateReadcnt(BoardVo vo) {
		// TODO Auto-generated method stub
		boardDao.updateReadcnt(vo);
	}
	
	// 글 삭제
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

	// 게시 글 상세 조회
	@Override
	public BoardVo getArticle(BoardVo Vo) {
		// TODO Auto-generated method stub
		return boardDao.getArticle(Vo);
	}
	
	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDao.getBoardList(vo);
	}

	// 글 목록 조회
	@Override
	public List<BoardVo> getArticleList(BoardVo vo) {
		// TODO Auto-generated method stub
		return boardDao.getArticleList(vo);
	}

	// 전체 레코드 수 조회
	@Override
	public int getRecordCnt() {
		// TODO Auto-generated method stub
		return boardDao.getRecordCnt();
	}
}
