package cn.wp.cloud_note.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.dao.UserDao;
import cn.wp.cloud_note.entity.User;
import cn.wp.cloud_note.service.UserService;
import cn.wp.cloud_note.util.NoteResult;


@Controller
@RequestMapping("/user")//ƥ������·��
public class UserLoginController {
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/login.do")//ƥ������
	@ResponseBody//����jackson,ʹ��json���
	public NoteResult<User> execute(String name, String password) {
		System.out.println("ULC27���:"+name+","+password);
		
		NoteResult<User> result=service.checkLogin(name,password);
		
		//System.out.println("UC29ִ��Login():"+result.getData().getCn_user_id());
		
		return result;
	}
//	@RequestMapping("/add.do")//ƥ������
//	@ResponseBody//����jackson,ʹ��json���
//	public NoteResult<Object> execute(String name, String password,String nick) {
//		//System.out.print(name+","+password);
//		NoteResult<Object> result=service.add(name, password, nick);
//		System.out.println("UC37ִ��add()");
//		return result;
//	}

}
