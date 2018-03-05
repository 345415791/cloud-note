package cn.wp.cloud_note.dao;

import java.util.List;

import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.entity.User;

public interface RelationDao {
	//�����������
	public User findUserAndBooks(String UserId);
	public User findUserAndBooks1(String UserId);
	
	//������������
	public List<Book> findBookAndUser();
	public List<Book> findBookAndUser1();
}
