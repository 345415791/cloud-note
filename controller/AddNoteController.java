package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.service.NoteService;
import cn.wp.cloud_note.util.NoteResult;
@Controller
public class AddNoteController {
@Resource(name="noteService")
private NoteService service; 
	
@RequestMapping("/note/add.do")
@ResponseBody
	public NoteResult<Note> execute(String userId,String bookId,String noteName) {
		System.out.println("ANC13ÐÐ"+userId+bookId+noteName);
		//NoteResult<Note> result=new NoteResult<Note>();
		
		NoteResult<Note> result=service.addNote(userId, bookId, noteName);
		System.out.println("ANC24ÐÐ"+result);
		return result;
	}
}
