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

@Controller
@SessionAttributes("member")
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	
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
		if(vo.getRole().equals("ROLE_ADMIN")) {
			model.addAttribute("memberList", ms.getMemberList(vo));
			return "../admin/getMemberList.jsp";
		}
		
		return "redirect:../system/login.do";
	}
	
}
