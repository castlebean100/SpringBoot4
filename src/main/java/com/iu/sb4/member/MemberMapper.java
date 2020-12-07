package com.iu.sb4.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int setInsert(MemberVO memberVO) throws Exception;
	
	public int setInsertFile(MemberFileVO memberFileVO) throws Exception;
	
	// 메서드이름은 mapper.xml에서 준 id랑 같게하면됨
	public MemberVO getMemberLogin(MemberVO memberVO) throws Exception;
	
	
		

}

