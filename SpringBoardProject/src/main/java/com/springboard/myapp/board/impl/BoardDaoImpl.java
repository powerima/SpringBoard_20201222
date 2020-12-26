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
	
	// 게시글 당 댓글 수 조회 
	@Override
	public int getCommentCnt(BoardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDao.getCommentCnt", vo);
	}
	
	// 전체 레코드 수 조회
	@Override
	public int getRecordCnt(BoardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDao.getRecordCnt", vo);
	}

	
	// 댓글 등록
	@Override
	public void insertCommnet(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDao.insertComment", vo);
	}

	// 게시 글 등록
	@Override
	public void insertArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.insert("BoardDao.insertArticle", vo);
	}

	// 게시 글 수정
	@Override
	public void updateArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDao.updateArticle", vo);
	}
	
	// 조회수 갱신
	@Override
	public void updateReadcnt(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDao.updateReadcnt", vo);
	}
	
	// 게시 글에 달린 댓글 수 갱신
	@Override
	public void updateCommenctcnt(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.update("BoardDao.updateCommentcnt", vo); 
	}
	
	@Override
	public void deleteBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		mybatis.delete("BoardDao.deleteBoard", vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	// 게시 글 상세 조회
	@Override
	public BoardVo getArticle(BoardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("BoardDao.getArticle", vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	// 글 목록 조회
	@Override
	public List<BoardVo> getArticleList(BoardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardDao.getArticleList", vo);
	}

	@Override
	public List<BoardVo> getCommentList(BoardVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("BoardDao.getCommentList", vo);
	}

}
