package cn.wp.cloud_note.service;

import cn.wp.cloud_note.entity.User;
import cn.wp.cloud_note.util.NoteResult;

public interface UserService {
	public NoteResult<User> checkLogin(String name,String password);
	public NoteResult<Object> add(String name,String password,String nick);
}
