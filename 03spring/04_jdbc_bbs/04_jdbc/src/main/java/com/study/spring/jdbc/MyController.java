package com.study.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@Autowired
	MyDao myDao;
	
	@RequestMapping("/")
	@ResponseBody
	public String root() {
		return "jdbc 입니다.";
	}
	
	@GetMapping("/list")
	public String index(Model model) {
//						↑약한 결합  강한결합 : new를 사용
		model.addAttribute("lists",myDao.list());
		return "index";
	}
}
