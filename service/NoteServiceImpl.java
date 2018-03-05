package cn.wp.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.dao.NoteDao;
import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.util.NoteResult;
import cn.wp.cloud_note.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource(name="noteDao")
	private NoteDao dao;
	
	//@RequestMapping
	@ResponseBody
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		//System.out.println("NSI22bookId值:"+bookId);
		NoteResult<List<Map>> result=new NoteResult<List<Map>>();
		List<Map> notes=dao.findByBookIdMap(bookId);
		result.setMsg("获取笔记名成功");
		result.setStatus(0);
		result.setData(notes);
		for(Map note:notes) {
			//System.out.println("NSI24的note值:"+note);
		}
		return result;
	}
	
	@ResponseBody
	public NoteResult<Note> loadNote(String noteId) {
		NoteResult<Note> result=new NoteResult<Note>();
		 Note note=dao.findByNoteId(noteId);
		if(!note.equals(null)) {
			result.setData(note);
			result.setMsg("查询note成功!");
			result.setStatus(0);
		}else {
			result.setStatus(1);
			result.setMsg("查询笔记失败");
		}
		return result;
	}
	
@ResponseBody
	public NoteResult<Note> updateNote(Note note) {
	NoteResult<Note> result=new NoteResult<Note>();
	//System.out.println("NSI53");
	
	int n=dao.updateNote(note);//更新数据库!!!!!
	
	//System.out.println("NSI54,看dao是否成功更新数据库"+n);
	if(n==1) {//表示数据库有一行更新
		String noteId=note.getCn_note_id();
		
		Note noteReturn=new Note();
		noteReturn=dao.findByNoteId(noteId);
		
		result.setMsg("保存完毕!");
		result.setData(noteReturn);
		result.setStatus(0);
		//System.out.println("NSI62行查询笔记:"+result.getData());
		return result;
	}else {
		result.setMsg("更新数据库失败!");
		result.setStatus(1);
		return result;
	}
	
	}
@ResponseBody
public NoteResult<Note> addNote(String userId,String bookId,String noteName) {
	NoteResult<Note> result=new NoteResult<Note>();
	Note note=new Note();
	note.setCn_note_id(NoteUtil.createId());
	note.setCn_note_title(noteName);
	note.setCn_notebook_id(bookId);
	note.setCn_user_id(userId);
	note.setCn_note_last_modify_time(System.currentTimeMillis());
	note.setCn_note_create_time(System.currentTimeMillis());
	//自己定义:1-normal,2-delete
	note.setCn_note_status_id("1");
	//自己定义;1-normal,2-favor,3-share
	note.setCn_note_type_id("1");//??
	note.setCn_note_body("");
	
	int n=dao.save(note);
	if(n==1) {
		result.setStatus(0);
		result.setMsg("新建笔记名成功!!!");
		result.setData(note);
		//System.out.println("NSI90行"+result);
		return result;
	}else {
		result.setStatus(1);
		result.setMsg("新建笔记名失败!!!");
		return result;
	}
	
}
//	public static void main(String[] args) {
//		System.out.println(System.currentTimeMillis());
//	}

public NoteResult<Object> deleteNote(String noteId) {
	NoteResult<Object> result=new NoteResult<Object>();
	int n=dao.deleteNote(noteId);
	if(n==1) {
		result.setMsg("删除至回收站成功!!!");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("删除至回收站失败!!!");
		result.setStatus(1);
		return result;
	}
}
@Transactional//引入事务管理(基于AOP原理)
public void deleteNoteSSH1(String... ids) {
	//String...就是String[]数组
	for (String id:ids) {
		int n =dao.deleteNoteSHH1(id);
		if(n!=1) {//表示某条删除语句出错
			//抛出异常,触发事物的回滚
			throw new RuntimeException("删错了!!");
		}
	}
	
}
	

}
