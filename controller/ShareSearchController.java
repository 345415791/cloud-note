package cn.wp.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wp.cloud_note.entity.Share;
import cn.wp.cloud_note.service.ShareService;
import cn.wp.cloud_note.util.NoteResult;

@Controller
public class ShareSearchController {
@Resource(name="shareService")
private ShareService service;
@RequestMapping("/share/search.do")
@ResponseBody
public NoteResult<List<Share>> execute(String keyword,int page){
	System.out.println("SSC18ÐÐ:"+keyword);
	NoteResult<List<Share>> result=service.searchShareNote(keyword,page);
	return result;
	
}
}
