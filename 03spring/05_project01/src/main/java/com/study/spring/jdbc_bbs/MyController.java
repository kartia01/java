package com.study.spring.jdbc_bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
 
	@Autowired
	IBbsDAO dao;
	
	@RequestMapping("/")
	public String index() {
	return "index"; 
 }
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists", dao.listDAO());
		model.addAttribute("count", dao.countDAO());
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		String num = request.getParameter("id");
		model.addAttribute("dataView", dao.viewDAO(num));
		return "view";
	}
}
