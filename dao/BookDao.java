package cn.wp.cloud_note.dao;

import java.util.List;

import cn.wp.cloud_note.entity.Book;

public interface BookDao {
	public List<Book> findByUserId(String userId);
	public int save(Book book);
}
