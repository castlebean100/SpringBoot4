package com.iu.s4.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.iu.sb4.member.MemberFileVO;
import com.iu.sb4.member.MemberMapper;
import com.iu.sb4.member.MemberVO;


// @Rollback(value=true)
@SpringBootTest
class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void setInsertTest() throws Exception{
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test1");
		memberVO.setPw("test");
		memberVO.setName("test");
		memberVO.setAge(20);
		memberVO.setEmail("test@email.com");
		
		int result = memberMapper.setInsert(memberVO);
		
		assertEquals(1, result);
	}	


	void setInsertFileTest() throws Exception{
		MemberFileVO memberFileVO = new MemberFileVO();
		memberFileVO.setId("test1");
		memberFileVO.setFileName("filename");
		memberFileVO.setOriName("oriName");
		int result = memberMapper.setInsertFile(memberFileVO);
		
		assertEquals(1, result);
	
	}
}
