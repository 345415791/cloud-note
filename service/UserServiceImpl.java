package cn.wp.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wp.cloud_note.dao.UserDao;
import cn.wp.cloud_note.entity.User;
import cn.wp.cloud_note.util.NoteResult;
import cn.wp.cloud_note.util.NoteUtil;
@Service("userService")//ɨ�赽Spring����
@Transactional
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//���ս������
		NoteResult<User> result=new NoteResult<User>();
		
		User user=userDao.findByName(name);//���û������name��ѯ���ݿ�
		if(user==null) {
			result.setStatus(1);//�Լ�����,1��ʾ�û�������
			result.setMsg("�û�������!");
			return result;
		}
		//�������
		String md5Password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);//2��ʾ�������
			result.setMsg("�������!");
			return result;
		}
		//�û���,������ȷ
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}
	
	public NoteResult<Object> add(String name, String password, String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		User hasUser=userDao.findByName(name);
		if(hasUser!=null) {
			result.setStatus(1);//�Լ�����,1��ʾ�û�����ռ��
			result.setMsg("�û����Ѵ���");
			System.out.println("USI.add45�û����Ѵ���"+name);
			return result;
		}
		//User user=null;//����,Ҫ����newһ������
		User user=new User();//Ҫ����newһ���µ�user;
		System.out.println(NoteUtil.createId());
		user.setCn_user_id(NoteUtil.createId());//��������id
		user.setCn_user_password(NoteUtil.md5(password));//������md5���ܴ���
		user.setCn_user_name(name);
		user.setCn_user_nick(nick);
		System.out.println(user);
		userDao.save(user);
		
		//�������ؽ��
		result.setMsg("ע��ɹ�!");
		result.setStatus(0);
		return result;
	}

}
