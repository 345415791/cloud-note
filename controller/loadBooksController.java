package cn.wp.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.service.BookService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class loadBooksController {
	@Resource(name="bookService")
	private BookService service;
	
	@ResponseBody
	@RequestMapping("/book/loadBooks.do")
	public NoteResult<List<Book>> execute(String userId) {
		NoteResult<List<Book>> result=new NoteResult<List<Book>>();
		//System.out.println("lbc≤‚ ‘24––userId:"+userId);
		result=service.LoadUserService(userId);
		//System.out.println(result.getMsg()+result.getData().size());
		return result;
	}
}
