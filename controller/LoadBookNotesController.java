package cn.wp.cloud_note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.service.NoteService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class LoadBookNotesController {
@Resource(name="noteService")
	private NoteService noteService;
	
@RequestMapping("/note/loadnotes.do")
@ResponseBody
	public NoteResult<List<Map>> execute(String bookId) {
	//System.out.println("LBNC23≤‚ ‘bookId÷µ:==="+bookId);
		NoteResult<List<Map>> result=new NoteResult<List<Map>>();
		result=noteService.loadBookNotes(bookId);
	
		//System.out.println("LBNC24≤‚ ‘result"+result);
		
		return result;
	}

}
