package cn.wp.cloud_note.dao;

import java.util.List;

import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.entity.User;

public interface RelationDao {
	//关联多个对象
	public User findUserAndBooks(String UserId);
	public User findUserAndBooks1(String UserId);
	
	//关联单个对象
	public List<Book> findBookAndUser();
	public List<Book> findBookAndUser1();
}
