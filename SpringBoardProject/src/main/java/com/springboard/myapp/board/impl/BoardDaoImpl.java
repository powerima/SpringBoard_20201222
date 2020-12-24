package com.springboard.myapp.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboard.myapp.board.BoardDao;
import com.springboard.myapp.board.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 댓글 등록
	@Override
	public void insertCommnet(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDao.insertComment", vo);
	}

	// 글 등록
	@Override
	public void insertArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDao.insertArticle", vo);
	}
	
	@Override
	public void insertBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}


}
