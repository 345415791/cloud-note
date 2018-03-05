package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.service.NoteService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class UpdateNoteController {
	@Resource(name="noteService")
	private NoteService service;

@RequestMapping("/note/update.do")
@ResponseBody
public NoteResult<Note> execute(String noteId,String noteTitle,String noteBody) {
	NoteResult<Note> result=new NoteResult<Note>();
	//System.out.println("UNC22≤‚ ‘Ω” ‹÷µ"+noteId+noteTitle+noteBody);
	
	Note note =new Note();
	note.setCn_note_body(noteBody);
	note.setCn_note_id(noteId);
	note.setCn_note_title(noteTitle);
	Long time=System.currentTimeMillis();
	note.setCn_note_last_modify_time(time);
	
	//System.out.println("UNC27"+note.getCn_note_title());
	result=service.updateNote(note);
	
	return result;
}
	
}
