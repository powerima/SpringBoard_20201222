package com.springboard.myapp.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboard.myapp.member.MemberDao;
import com.springboard.myapp.member.MemberService;
import com.springboard.myapp.member.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	// 회원 등록
	@Override
	public void insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
	}

	// 회원 삭제
	@Override
	public void deleteMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(vo);
	}

	// 회원 수정
	@Override
	public void updateMember(MemberVo vo) {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}

	// 회원 조회
	@Override
	public MemberVo getMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.getMember(vo);
	}

	// 회원 목록 조회
	@Override
	public List<MemberVo> getMemberList(MemberVo vo) {
		// TODO Auto-generated method stub
		return memberDao.getMemberList(vo);
	}

}
