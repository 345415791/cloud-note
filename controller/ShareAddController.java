package cn.wp.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Share;
import cn.wp.cloud_note.service.ShareService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class ShareAddController {
@Resource(name="shareService")
private ShareService service;
@RequestMapping("/share/add.do")
@ResponseBody
	public NoteResult<Share>  execute(String noteId) {
		System.out.println("SAC18ÐÐ"+noteId);
		NoteResult<Share> result=new NoteResult<Share>();
		result=service.shareNoteById(noteId);
		return result;
	}

}
