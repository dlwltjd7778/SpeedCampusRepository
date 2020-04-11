package com.sc.speedcampus.user.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sc.speedcampus.user.member.service.GetUserService;
import com.sc.speedcampus.user.member.vo.UserVO;



@Controller
public class LoginController {
	
	@Autowired
	private GetUserService getUserService;

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ�� ȣ��");
		return "member/login";
	}
	
	
	@RequestMapping("loginCheck.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("�α��� ó��");
		UserVO user = getUserService.getUser(vo);
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:userHome.do";
		} else {// 
			return "member/login";
		}

	}
	
	
	}
