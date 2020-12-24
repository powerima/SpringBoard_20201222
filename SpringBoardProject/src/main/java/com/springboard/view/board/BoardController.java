package com.springboard.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboard.myapp.board.BoardService;
import com.springboard.myapp.board.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService bs;
	
	// 글 등록
	@RequestMapping(value="insertArticle")
	public String insertArticle(BoardVo vo, HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());
		bs.insertArticle(vo);
		return "getArticleList.do";
	}
	
	
	// 글 목록
	@RequestMapping(value="getArticleList")
	public String getArticleList(BoardVo vo) {
		vo.setStartRow(1);
		vo.setEndRow(10);
		return "getBoardList.jsp";
	}
		
}
