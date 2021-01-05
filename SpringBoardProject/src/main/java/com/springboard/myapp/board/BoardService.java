package com.springboard.myapp.board;

import java.util.List;

public interface BoardService {
	public int getSeq(BoardVo vo);					// 댓글의 글 번호 가져오기
	public int getCommentCnt(BoardVo vo);			// 게시글 당 댓글 수 조회
	public int getRecordCnt(BoardVo vo);			// 전체 레코드 수 조회
	public void insertCommnet(BoardVo vo);			// 댓글 등록
	public void insertArticle(BoardVo vo);			// 글 등록
	public void updateArticle(BoardVo vo);			// 게시 글 수정
	public void updateReadcnt(BoardVo vo);			// 조회수 갱신
	public void updateCommenctcnt(BoardVo vo);		// 게시 글에 달린 댓글 수 증가
	public void discountCommenctcnt(BoardVo vo);	// 게시 글에 달린 댓글 수 감소
	public void deleteBoard(BoardVo vo);			// 글그룹 삭제
	public void deleteComment(BoardVo vo);			// 댓글 삭제
	public BoardVo getBoard(BoardVo vo);			// 조회
	public BoardVo getArticle(BoardVo Vo);			// 게시글 상세 조회	
	public List<BoardVo> getBoardList(BoardVo vo); 		// 목록 조회
	public List<BoardVo> getCommentList(BoardVo vo);	// 댓글 목록 조회
	public List<BoardVo> getArticleList(BoardVo vo); 	// 게시글 목록 조회
	
	
}
