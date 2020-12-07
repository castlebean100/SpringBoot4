package com.iu.s4.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.iu.sb4.util.Pager;

@SpringBootTest
class PagerTest {

	@Test
	void test() {
		Pager pager = new Pager();
		pager.setCurPage(1);
		pager.makePage(102);
	}

}
