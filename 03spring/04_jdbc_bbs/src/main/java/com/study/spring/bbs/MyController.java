package com.study.spring.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
//	컨트롤러는 DAO를 자동으로 받아 사용한다.
	@Autowired
	IBbsDAO dao;

//	@RequestMapping("/")<-매핑 (연결)
//	@ResponseBody
//	public String root() {
//		return "redirect : index";
//	}
	
//  첫 페이지를 보여주는 메서드
	@RequestMapping("/")
	@ResponseBody
	// 
	public String index() {
		return "index";
	}
	
//	사용자가 /list 주소로 get 방식 요청을 보냈을 때 실행됨
//	DB에서 모든 게시글 목록을 조회해서 리스트 페이지에 전달
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("lists", dao.listDAO());
		model.addAttribute("count", dao.countDAO());
		return "list";
	}
	
		
	// localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		
		String num = request.getParameter("id");
		model.addAttribute("dataView",dao.viewDAO(num));
		return "view";
	}
	
//  HttpServletrequest : 클라이언트가 서버로 보낸 요청 정보를 모두 담고 있는 객체
//	getParameter() : HttpServletRequest 안에 있는 name, value 값을 꺼내는 메서드
	
	// 글 작성 form
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	// 글 작성 action write?name = &title = &content
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
//		request.getParameter("writer");
		
		dao.writeDAO(
				request.getParameter("writer"),
				request.getParameter("title"),
				request.getParameter("content")
				);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
		int deleteNum = dao.deleteDAO(request.getParameter("id"));
		log.info("delete : " + deleteNum);
		return "redirect:list";
	}
}

