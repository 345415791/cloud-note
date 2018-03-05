package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.service.BookService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class AddBookController {
	@Resource(name="bookService")
	private BookService service;
	@RequestMapping("/book/add.do")
	@ResponseBody
	public NoteResult<Book> execute(String userId,String bookName) {
		//System.out.println(userId+"ABC15ÐÐ"+bookName);
		//NoteResult<Book> result=null;
		NoteResult<Book> result=service.addBokk(userId, bookName);
		//System.out.println(result);
		return result;
		
	}
}
