package com.springboard.view.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	// 댓글 등록
	@RequestMapping(value="insertComment.do")
	public void insertComment(BoardVo vo, HttpServletRequest request, 
					HttpServletResponse response, Model model) {
		vo.setIp(request.getRemoteAddr());
		bs.insertCommnet(vo);
		bs.updateCommenctcnt(vo);
		model.addAttribute("commentList", bs.getCommentList(vo));
		try {
			PrintWriter out = response.getWriter();
			out.println("insertComment");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
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
		// 페이지 나누기
		if(vo.getPageNum() == 0 ) vo.setPageNum(1);
		int currentPage = vo.getPageNum();
		int pageSize = 10;
		int startRow = ( currentPage - 1 ) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = bs.getRecordCnt(vo);
		
		if(count > 0) {
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			int pageBlock = 10;
			
			if (currentPage % pageBlock != 0) { 
				startPage = (int)(currentPage/pageBlock) * pageBlock + 1;			
			} else { 
				startPage = (int)(currentPage/pageBlock-1) * pageBlock + 1;
			}
			int endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount) endPage = pageCount;
			
			vo.setStartRow(startRow);
			vo.setEndRow(endRow);
			
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pageBlock", pageBlock);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("pageNum", currentPage);
			model.addAttribute("searchCondition", vo.getSearchCondition());
			model.addAttribute("searchKeyword", vo.getSearchKeyword());
			
			model.addAttribute("recordCnt", bs.getRecordCnt(vo));
			model.addAttribute("boardList", bs.getArticleList(vo));
		}

		return "getBoardList.jsp";
	}
	
	// 댓글 목록 조회
	@RequestMapping(value="getCommentList.do")
	public String getCommentList(BoardVo vo, Model model) {
		model.addAttribute("commentList", bs.getCommentList(vo));
		return "getCommentList.jsp";
	}
		
	// testBoard insert big data
	@RequestMapping(value="testInsertBoard.do")
	public void testInsertBoard(HttpServletRequest request) {
		BoardVo vo = new BoardVo(); 
		String content = "test";
		
		for(int i = 1; i < 100; i++) {
			content = content + i + " ";
		}
		
		
		for(int i = 1; i < 255; i++) {
			vo.setWriter("test" + i);
			vo.setContent(content);
			vo.setSubject("board Test" + i);
			vo.setPasswd("1234");
			vo.setIp(request.getRemoteAddr());
			bs.insertArticle(vo);
		}
	}
		
}
