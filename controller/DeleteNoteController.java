package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.service.NoteService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class DeleteNoteController {
@Resource(name="noteService")
public NoteService service;
@RequestMapping("/delete/deleteNote.do")
@ResponseBody
public NoteResult<Object> execute(String noteId){
	
	System.out.println("DNC14ÐÐ"+noteId);
	NoteResult<Object> result=service.deleteNote(noteId);
	
	return result;
}

}
