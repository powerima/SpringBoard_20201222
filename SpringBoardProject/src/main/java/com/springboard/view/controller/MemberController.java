package com.springboard.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboard.myapp.member.MemberService;
import com.springboard.myapp.member.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	// 회원 가입
	@RequestMapping(value="join.do")
	public String join(MemberVo vo) {
		ms.insertMember(vo);
		return null;
	}
	
	// 회원 로그인
	@RequestMapping(value="login.do")
	public String login(MemberVo vo) {
		ms.getMember(vo);
		return null;
	}
	
	// 회원 로그아웃
	@RequestMapping(value="logout.do")
	public String logout(MemberVo vo) {
		return null;
	}
	
	// 회원 수정
	@RequestMapping(value="updateMember.do")
	public String updateMember(MemberVo vo) {
		ms.updateMember(vo);
		return null;
	}
	
	// 회원 삭제
	@RequestMapping(value="deleteMember.do")
	public String deleteMember(MemberVo vo) {
		ms.deleteMember(vo);
		return null;
	}
	
	// 회원 목록 조회
	@RequestMapping(value="getMemberList.do")
	public String getMemberList(MemberVo vo) {
		ms.getMemberList(vo);
		return null;
	}
	
			
}
