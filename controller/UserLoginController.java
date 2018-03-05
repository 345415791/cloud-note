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
@RequestMapping("/user")//匹配请求路径
public class UserLoginController {
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/login.do")//匹配请求
	@ResponseBody//调用jackson,使用json输出
	public NoteResult<User> execute(String name, String password) {
		System.out.println("ULC27输出:"+name+","+password);
		
		NoteResult<User> result=service.checkLogin(name,password);
		
		//System.out.println("UC29执行Login():"+result.getData().getCn_user_id());
		
		return result;
	}
//	@RequestMapping("/add.do")//匹配请求
//	@ResponseBody//调用jackson,使用json输出
//	public NoteResult<Object> execute(String name, String password,String nick) {
//		//System.out.print(name+","+password);
//		NoteResult<Object> result=service.add(name, password, nick);
//		System.out.println("UC37执行add()");
//		return result;
//	}

}
