package com.springboard.myapp.board;

import java.util.List;

public interface BoardDao {
	public void insertCommnet(BoardVo vo);	// 댓글 등록
	public void insertArticle(BoardVo vo);	// 글 등록
	public void insertBoard(BoardVo vo);	// 등록
	public void updateBoard(BoardVo vo);	// 수정
	public void deleteBoard(BoardVo vo);	// 삭제
	public BoardVo getBoard(BoardVo vo);	// 조회
	public List<BoardVo> getBoardList(BoardVo vo); // 목록 조회	
}
