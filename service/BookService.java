package cn.wp.cloud_note.service;

import java.util.List;

import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.util.NoteResult;

public interface BookService {
	public NoteResult<List<Book>>  LoadUserService( String userId);
	public NoteResult<Book> addBokk(String userId,String bookName);
}
