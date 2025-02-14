package web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.member.entity.Member;
import web.member.service.MemberService;

// 配合12-3實作

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("manage")
	 public String manage(Model model) {
	 List<Member> memberList = service.findAll();
	 model.addAttribute("memberList", memberList);
	 return "member/manage";
	 }
}
