package com.springboard.view.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springboard.myapp.board.BoardService;
import com.springboard.myapp.board.BoardVo;
import com.springboard.myapp.member.MemberVo;

@Controller
@SessionAttributes({"board", "member"})
@RequestMapping("/board/")
public class BoardController {
	@Autowired
	private BoardService bs;
	private static final String REALPATH = "files/";
	
	@ModelAttribute("member")
	public MemberVo setMemberVo() {
		return new MemberVo();
	}
	
	// 댓글 등록
	@RequestMapping(value="insertComment.do")
	public void insertComment(@ModelAttribute("member") MemberVo member, BoardVo vo, 
				HttpServletRequest request,	HttpServletResponse response, Model model) {
		if(member.getId() == null) {
			return;
		}
		
		
		vo.setIp(request.getRemoteAddr());
		bs.insertCommnet(vo);			// 댓글 등록
		bs.updateCommenctcnt(vo);		// 댓글 수 증가
		
		model.addAttribute("commentList", bs.getCommentList(vo));
		try {
			PrintWriter out = response.getWriter();
			out.println("insertComment");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 글 등록 화면 이동
	@RequestMapping(value="insertArticle.do", method=RequestMethod.GET)
	public String insertArticleView(@ModelAttribute("member") MemberVo member, Model model) {
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		model.addAttribute("member", member);		
		return "insertBoard.jsp";
	}
	
	
	// 글 등록
	@RequestMapping(value="insertArticle.do", method=RequestMethod.POST)
	public String insertArticle(@ModelAttribute("member") MemberVo member,
				BoardVo vo, HttpServletRequest request) throws IOException {
		
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		
		String realPath = request.getSession().getServletContext().getRealPath(REALPATH);	// 실제 경로
		String fileName = "";	// 수정된 실제 파일 이름
			
		MultipartFile uploadFile = vo.getUploadFile();
		
		
		if(uploadFile != null && !uploadFile.isEmpty()) {	// 업로드된 파일 존재 여부 확인
			
			
			String originalFileName = uploadFile.getOriginalFilename();	// 파일이름 추출
			File f = new File(realPath + originalFileName);
			
			if (f.exists()) {	// 파일 이름 중복을 피하기 위한
				// 연월일시분초 문자열로 추출
				String time = new SimpleDateFormat("yyyyMMddhhmmss").format(System.currentTimeMillis());
				
				// 파일이름 중복을 피하기 위한 연월일시분초 문자 연결
				fileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + time 
							+ originalFileName.substring(originalFileName.lastIndexOf("."));				
			} else {	// 중복된 파일이 없는 경우
				fileName = originalFileName;
			}

			uploadFile.transferTo(new File(realPath + fileName));	// 파일 업로드			
		} 
			
		else {	// 업로드 된 파일이 없을 경우 
			fileName = "empty.jpg";
		}
		
		vo.setFilename(fileName);
		vo.setIp(request.getRemoteAddr());
		
		bs.insertArticle(vo);
		
		return "redirect:getArticleList.do";
	}
	
	// 글 수정 화면 이동
	@RequestMapping(value="updateArticle.do", method=RequestMethod.GET)
	public String updateArticleView(BoardVo vo, Model model) {
		model.addAttribute("board", bs.getArticle(vo));
		return "updateBoard.jsp";
	}
	
	
	
	// 글 수정
	@RequestMapping(value="updateArticle.do", method=RequestMethod.POST)
	public String updateArticle(@ModelAttribute("member") MemberVo member,
				@ModelAttribute("board") BoardVo vo, HttpServletRequest request) throws IOException {
		
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		
		String realPath = request.getSession().getServletContext().getRealPath(REALPATH);	// 실제 경로
		String preFileName = vo.getFilename();
		String fileName = "";	// 수정된 실제 파일 이름
		
		MultipartFile uploadFile = vo.getUploadFile();	// 실제 파일
		
		if(uploadFile != null && !uploadFile.isEmpty()) {	// 업로드된 파일 존재 여부 확인
			
			// 기존 파일 삭제
			if(!preFileName.equals("empty.jpg")) {
				File pref = new File(realPath + preFileName);
				if(pref.exists()) {
					pref.delete();
				}
			}			
			
			// 새로운 파일 업로드
			String originalFileName = uploadFile.getOriginalFilename();	// 파일이름 추출
			File f = new File(realPath + originalFileName);
			
			if (f.exists()) {	// 파일 이름 중복을 피하기 위한
				// 연월일시분초 문자열로 추출
				String time = new SimpleDateFormat("yyyyMMddhhmmss").format(System.currentTimeMillis());
				
				// 파일이름 중복을 피하기 위한 연월일시분초 문자 연결
				fileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + time 
							+ originalFileName.substring(originalFileName.lastIndexOf("."));				
			} else {	// 중복된 파일이 없는 경우
				fileName = originalFileName;
			}

			uploadFile.transferTo(new File(realPath + fileName));	// 파일 업로드
			
		} 
		
		else {	// 새로 업로드된 파일이 없으면 기존 파일을 유지
			fileName = preFileName;
		}
		
		vo.setFilename(fileName);
		bs.updateArticle(vo);
		
		return "redirect:getArticleList.do";
	}
	
	// 글 삭제
	@RequestMapping(value="deleteArticle.do")
	public String deleteArticle(@ModelAttribute("member") MemberVo member,
						BoardVo vo, HttpServletRequest request) {
		// 로그인 여부 검사
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		
		vo = bs.getBoard(vo);
		
		// 권한 여부 검사
		if(member.getRole().equals("ROLE_ADMIN") || member.getId().equals(vo.getMember_id())) {
			String realPath = request.getSession().getServletContext().getRealPath(REALPATH);	// 실제 경로
			String fileName = vo.getFilename();	// 수정된 실제 파일 이름
			
			// 업로드된 파일 삭제
			if(fileName != null && !fileName.equals("empty.jpg")) {	// 업로드된 파일 존재 여부 확인
				File f = new File(realPath + fileName);
				f.delete();			// 파일 삭제
			}

			bs.deleteBoard(vo);
			return "redirect:getArticleList.do";
		}
		
		return "../system/accessDenied.jsp";
	}

	// 댓글 삭제
	@RequestMapping(value="deleteComment.do")
	public String deleteComment(@ModelAttribute("member") MemberVo member, BoardVo vo) {
		if(member.getId() == null) {
			return "redirect:/system/login.do";
		}
		
		vo = bs.getBoard(vo);
		
		// 권한 여부 검사
		if(member.getRole().equals("ROLE_ADMIN") || member.getId().equals(vo.getMember_id())) {
			bs.discountCommenctcnt(vo);			// 댓글 수 감소
			bs.deleteComment(vo);				// 글 삭제
			return "redirect:getArticleList.do";
		}
		
		return "../system/accessDenied.jsp";
	}
	
	// 게시 글 상세 조회
	@RequestMapping(value="getArticle.do")
	public String getArticle(@ModelAttribute("member") MemberVo member, 
					BoardVo vo, Model model, HttpServletRequest request) {
		
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
				
		bs.updateReadcnt(vo);	// 조회수 증가
		model.addAttribute("board", bs.getArticle(vo));
				
		return "getBoard.jsp";
	}
	
	// 글 목록 조회
	@RequestMapping(value="getArticleList.do")
	public String getArticleList(@ModelAttribute("member") MemberVo member,
							BoardVo vo, Model model) {
		
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		
		
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
	public String getCommentList(@ModelAttribute("member") MemberVo member,
						BoardVo vo, Model model) {
		if(member.getId() == null) {
			return "redirect:../system/login.do";
		}
		
		model.addAttribute("commentList", bs.getCommentList(vo));
		return "getCommentList.jsp";
	}
		
	// testBoard insert big data
	@RequestMapping(value="testInsertBoard.do")
	public String testInsertBoard(HttpServletRequest request) {
		BoardVo vo = new BoardVo(); 
		String content = "test";
		
		for(int i = 1; i < 100; i++) {
			content = content + i + " ";
		}
		
		
		for(int i = 1; i < 255; i++) {
			vo.setMember_id("admin");
			vo.setContent(content);
			vo.setSubject("board Test" + i);
			vo.setIp(request.getRemoteAddr());
			vo.setFilename("empty.jpg");
			bs.insertArticle(vo);
		}
		
		return "../index.jsp";
	}
		
}
