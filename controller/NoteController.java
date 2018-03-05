package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.service.NoteService;
import cn.wp.cloud_note.util.NoteResult;
@Controller
public class NoteController {
	@Resource(name="noteService")
	private NoteService service;
	
	@RequestMapping("/note/load.do")
	@ResponseBody
	public NoteResult<Note> execute(String noteId){
		
		//System.out.println("≤‚ ‘NC20"+noteId);
		NoteResult<Note> result =service.loadNote(noteId);
		return result;
	}
}
