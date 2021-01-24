package com.springboard.view.controller;

import org.mindrot.jbcrypt.BCrypt;
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
	@RequestMapping(value="/system/join.do", method=RequestMethod.GET)
	public String joinView() {
		return "join.jsp";
	}
	
	// 회원 가입
	@RequestMapping(value="/system/join.do", method=RequestMethod.POST)
	public String join(MemberVo vo) {
		String hashPwd = BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt());
		
		vo.setPassword(hashPwd);
		vo.setRole("ROLE_MEMBER");
		ms.insertMember(vo);
		return "forward:../index.jsp";
	}
	
	// 로그인 화면으로 이동
	@RequestMapping(value="/system/login.do", method=RequestMethod.GET)
	public String loginView() {
		return "login.jsp";
	}
	
	// 회원 로그인
	@RequestMapping(value="/system/login.do", method=RequestMethod.POST)
	public String login(MemberVo vo, Model model) {
		MemberVo findMember = ms.getMember(vo);
		
		if(findMember != null) {
			if(BCrypt.checkpw(vo.getPassword(), findMember.getPassword())) {
				model.addAttribute("member", findMember);
				
				return "forward:../index.jsp";
			}
		}
		return "redirect:/system/login.do";
	}
	
	// 회원 로그아웃
	@RequestMapping(value="/system/logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "forward:../index.jsp";
	}
	

			
}
