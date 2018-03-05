package cn.wp.cloud_note.service;

import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import cn.wp.cloud_note.dao.BookDao;
import cn.wp.cloud_note.entity.Book;
import cn.wp.cloud_note.util.NoteResult;
import cn.wp.cloud_note.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Resource
	private BookDao dao;
	//controllor才写的
	//@ResponseBody
	//@RequestMapping()
	public NoteResult<List<Book>> LoadUserService(String userId) {
		NoteResult<List<Book>> result=new NoteResult<List<Book>>();//返回的是Book类型的List集合
		List<Book> books=dao.findByUserId(userId);
		
		//System.out.println("BSI27"+userId);
		
		List<Book> books11=dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
//		for(Book book:books11) {
//			System.out.println(book);
//		}
		
		//if(!books.equals(null)) {
			result.setStatus(0);
			result.setMsg("啊查询到笔记名称成功!");
			result.setData(books);
			
			//System.out.println(books+"31");
//			for(Book book:books) {
//				System.out.println(book);
//			}
		//}
		return result;
	}
	public NoteResult<Book> addBokk(String userId, String bookName) {
		Book book=new Book();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		String createTime=sdf.format(date);
		
		NoteResult<Book> result=new NoteResult<Book>();
		book.setCn_notebook_id(NoteUtil.createId());
		book.setCn_notebook_name(bookName);
		book.setCn_user_id(userId);
		//book.setCn_notebook_createtime(createTime);
		
			//System.out.println("BSI54行调用dao"+book);
			int n=dao.save(book);
			if(n==1) {
			result.setMsg("创建笔记名成功!");
			result.setStatus(0);
			result.setData(book);
			return result;
		}else {
			result.setMsg("创建笔记失败!");
			result.setStatus(1);
			return result;
		}
		
	}
	
	public static void main(String[] args) {
//		Date date=new Date();
//		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
//		String time=sdf.format(date);
//		System.out.println(time);
		
//		String dateStr = "2010/05/04 12:34:23";
//		Date date = new Date();
//		//注意format的格式要与日期String的格式相匹配
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		try {
//			date = sdf.parse(dateStr);
//			System.out.println(date.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		Timestamp ts = new Timestamp(0);
		String tsStr = "2011-05-09 11:49:45";
		try {
			//ts = Timestamp.valueOf(tsStr);
			System.out.println(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
