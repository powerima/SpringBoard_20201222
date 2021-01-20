package com.springboard.myapp.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboard.myapp.member.MemberDao;
import com.springboard.myapp.member.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate mybatis; 
	
	
	// 회원 등록
	@Override
	public void insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		mybatis.insert("MemberDao.insertMember", vo);
	}

	// 회원 삭제
	@Override
	public void deleteMember(MemberVo vo) {
		// TODO Auto-generated method stub
		mybatis.delete("MemberDao.deleteMember", vo);
	}

	// 회원 수정
	@Override
	public void updateMember(MemberVo vo) {
		// TODO Auto-generated method stub
		mybatis.update("MemberDao.updateMember", vo);
	}

	// 회원 조회
	@Override
	public MemberVo getMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("MemberDao.getMember", vo);
	}

	// 회원 목록 조회
	@Override
	public List<MemberVo> getMemberList(MemberVo vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("MemberDao.getMemberList");
	}
}
