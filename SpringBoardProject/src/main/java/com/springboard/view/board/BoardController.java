package com.springboard.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboard.myapp.board.BoardService;
import com.springboard.myapp.board.BoardVo;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	// 글 등록
	@RequestMapping(value="insertArticle.do")
	public String insertArticle(BoardVo vo, HttpServletRequest request) {
		vo.setIp(request.getRemoteAddr());
		bs.insertArticle(vo);
		return "getArticleList.do";
	}
	
	// 글 수정
	@RequestMapping(value="updateArticle.do")
	public String updateArticle(@ModelAttribute("board") BoardVo vo) {
		bs.updateArticle(vo);
		return "getArticleList.do";
	}
	
	// 글 삭제
	@RequestMapping(value="deleteBoard.do")
	public String deleteBoard(BoardVo vo) {
		bs.deleteBoard(vo);
		return "getArticleList.do";
	}

	// 게시 글 상세 조회
	@RequestMapping(value="getArticle.do")
	public String getArticle(BoardVo vo, Model model) {
		String next = "";
		bs.updateReadcnt(vo);
		model.addAttribute("board", bs.getArticle(vo));
		if(vo.getState().equals("getBoard")) {
			next = "getBoard.jsp";	
		} else if(vo.getState().equals("updateBoard")) {
			next = "updateBoard.jsp";
		}
		
		return next;
	}
	
	// 글 목록 조회
	@RequestMapping(value="getArticleList.do")
	public String getArticleList(BoardVo vo, Model model) {
		vo.setStartRow(1);
		vo.setEndRow(10);
		model.addAttribute("recordCnt", bs.getRecordCnt());
		model.addAttribute("boardList", bs.getArticleList(vo));
		return "getBoardList.jsp";
	}
		
}
