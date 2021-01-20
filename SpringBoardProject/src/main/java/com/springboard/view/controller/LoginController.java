package com.springboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springboard.myapp.member.MemberService;
import com.springboard.myapp.member.MemberVo;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	@Autowired
	private MemberService ms;
	
	
	@ModelAttribute("member")
	public MemberVo setMemberVo() {
		return new MemberVo();
	}
	
	// 회원 가입 화면으로 이동
	@RequestMapping(value="join.do", method=RequestMethod.GET)
	public String joinView() {
		return "join.jsp";
	}
	
	// 회원 가입
	@RequestMapping(value="join.do", method=RequestMethod.POST)
	public String join(MemberVo vo) {
		vo.setRole("ROLE_MEMBER");
		ms.insertMember(vo);
		return "redirect:login.do";
	}
	
	// 로그인 화면으로 이동
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String loginView() {
		return "login.jsp";
	}
	
	// 회원 로그인
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(MemberVo vo, Model model) {
		MemberVo findMember = ms.getMember(vo);
		
		if(findMember != null 
				&& findMember.getPassword().equals(vo.getPassword())) {
			model.addAttribute("member", findMember);
			
			return "forward:getArticleList.do";
		}
		return "redirect:login.do";
	}
	
	// 회원 로그아웃
	@RequestMapping(value="logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:login.do";
	}
	
	// 회원 정보 수정 화면으로 이동
	@RequestMapping(value="updateMember.do", method=RequestMethod.GET)
	public String updateMemberView(@ModelAttribute("member") MemberVo vo, Model model) {
		if(vo.getId() == null) {
			return "redirect:login.do";
		}
		model.addAttribute("member", ms.getMember(vo));
		return "updateMember.jsp";
	}
	
	// 회원 수정
	@RequestMapping(value="updateMember.do", method=RequestMethod.POST)
	public String updateMember(@ModelAttribute("member") MemberVo vo) {
		if(vo.getId() == null) {
			return "redirect:login.do";
		}
		
		ms.updateMember(vo);
		return "redirect:getMember.do";
	}
	
	// 회원 삭제
	@RequestMapping(value="deleteMember.do")
	public String deleteMember(@ModelAttribute("member") MemberVo vo, SessionStatus status) {		
		if(vo.getId() == null) {
			return "redirect:login.do";
		}
		
		ms.deleteMember(vo);
		status.setComplete();
		return "redirect:login.do";
	}
	
	// 회원 조회
	@RequestMapping(value="getMember.do")
	public String getMember(@ModelAttribute("member") MemberVo vo, Model model) {
		if(vo.getId() == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("member", ms.getMember(vo));		
		return "getMember.jsp";
	}
	
	// 회원 목록 조회
	@RequestMapping(value="getMemberList.do")
	public String getMemberList(@ModelAttribute("member") MemberVo vo, Model model) {
		if(vo.getId() == null) {
			return "redirect:login.do";
		}
		
		model.addAttribute("memberList", ms.getMemberList(vo));
		return "getMemberList.jsp";
	}
	
			
}
