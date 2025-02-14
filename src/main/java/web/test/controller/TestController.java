package web.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.member.entity.Member;
import web.member.service.MemberService;

// 實作6-5
@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	private MemberService	service;
	
	
	@GetMapping("t1")
	public String t1(Model model) {
		List<Member> list  = service.findAll();
		model.addAttribute("memberList", list);
		return "member/manage";
		
	}
	
	// 查詢全部
	@GetMapping("t2")
	public	List<Member> t2() {
		return service.findAll();
	}
}
