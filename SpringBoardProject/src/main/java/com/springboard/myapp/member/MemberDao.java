package com.springboard.myapp.member;

import java.util.List;

public interface MemberDao {
	public void insertMember(MemberVo vo);		// 회원 등록
	public void deleteMember(MemberVo vo);		// 회원 삭제
	public void updateMember(MemberVo vo);		// 회원 수정
	public MemberVo getMember(MemberVo vo);		// 회원 조회
	public List<MemberVo> getMemberList(MemberVo vo);	// 회원 목록 조회
}
