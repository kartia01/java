package com.study.spring.bbstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.bbs.Bbs;
import com.study.spring.bbs.BbsRepository;

@SpringBootTest
public class BbsTest {

	@Autowired
	public BbsRepository bbsReop;

	@Test
	public void bbsInsert() {
		for (int i = 1; i <= 3; i++) {
			Bbs bbs = new Bbs();
			bbs.setName("이름"+i);
			bbs.setTitle("안녕하세요"+i);
			bbs.setContent("안녕, 만나서 반가워");

			bbsReop.save(bbs);
		}
//		Bbs bbs = new Bbs(null,"han","test1","test",null,null);
//		bbsReop.save(bbs);
//		Bbs bbs1 = Bbs.builder().name("이순신").title("asdf").content("qwerqwer").build();
//		bbsReop.save(bbs1);
	}
}
