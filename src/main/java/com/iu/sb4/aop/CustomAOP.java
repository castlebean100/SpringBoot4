package com.iu.sb4.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
	
	@Before("execution(* com.iu.sb4.board.notice.*Service.get*(..))")
	public void noticeBefore() throws Exception {
		System.out.println("Point Cout 실행 전 -------");
	}

	  
	//notcieAfter
	//NoticeService get으로 시작하는 모든 메스드들을 실행 후 작동하는 advice 메서드 생성


	@After("execution(* com.iu.sb4.board.notice.NoticeService.get*(..))")
	public void noticeAfter() throws Exception {
		System.out.println("Point cut 실행 후 -------");
	}

	//noticeAround
	//NoticeService set으로 시작하는 모든 메서드들이 실행 전, 후 advice
	@Around("execution(* com.iu.s4.board..*Service.set*(..))")
	public Object noticeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Point cut 실행 전");
		Object obj = null;
		obj = joinPoint.proceed(); // point cut
		System.out.println("Point cut 실행 후");
		
		return obj;
	}

}
