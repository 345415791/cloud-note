package cn.wp.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wp.cloud_note.dao.UserDao;
import cn.wp.cloud_note.entity.User;
import cn.wp.cloud_note.util.NoteResult;
import cn.wp.cloud_note.util.NoteUtil;
@Service("userService")//扫描到Spring容器
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//接收结果数据
		NoteResult<User> result=new NoteResult<User>();
		
		User user=userDao.findByName(name);//按用户输入的name查询数据库
		if(user==null) {
			result.setStatus(1);//自己设置,1表示用户名不对
			result.setMsg("用户名错误!");
			return result;
		}
		//检测密码
		String md5Password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);//2表示密码错误
			result.setMsg("密码错误!");
			return result;
		}
		//用户名,密码正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}
	
	public NoteResult<Object> add(String name, String password, String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		User hasUser=userDao.findByName(name);
		if(hasUser!=null) {
			result.setStatus(1);//自己设置,1表示用户名已占用
			result.setMsg("用户名已存在");
			System.out.println("USI.add45用户名已存在"+name);
			return result;
		}
		//User user=null;//不行,要重新new一个对象
		User user=new User();//要重新new一个新的user;
		System.out.println(NoteUtil.createId());
		user.setCn_user_id(NoteUtil.createId());//生成主键id
		user.setCn_user_password(NoteUtil.md5(password));//对密码md5加密处理
		user.setCn_user_name(name);
		user.setCn_user_nick(nick);
		System.out.println(user);
		userDao.save(user);
		
		//构建返回结果
		result.setMsg("注册成功!");
		result.setStatus(0);
		return result;
	}

}
