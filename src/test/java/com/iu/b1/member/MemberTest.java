package com.iu.b1.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MemberTest {

	@Autowired
	private MemberMapper memberMapper;
	
	
	//@Test
	void test()throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu");
		memberVO.setPw("iu");
		memberVO.setName("iu");
		memberVO.setEmail("iu@iu");
		int result = memberMapper.memberJoin(memberVO);
		assertEquals(1, result);
	}

	@Test
	void LoginTest()throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu");
		memberVO.setPw("iu");
		
		memberVO =memberMapper.memberLogin(memberVO);
		assertNotNull(memberVO.getEmail());
	
	}
	
}
