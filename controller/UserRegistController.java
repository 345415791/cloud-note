package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.service.UserService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String name, String password,String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		result=service.add(name, password, nick);
		return result;
		
	}
}
