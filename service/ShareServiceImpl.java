package cn.wp.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wp.cloud_note.dao.NoteDao;
import cn.wp.cloud_note.dao.ShareDao;
import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.entity.Share;
import cn.wp.cloud_note.util.NoteResult;
import cn.wp.cloud_note.util.NoteUtil;

@Service("shareService")
@Transactional
public class ShareServiceImpl implements ShareService{
@Resource(name="shareDao")
private ShareDao shareDao;
@Resource(name="noteDao")
private NoteDao noteDao;

public NoteResult<Share> shareNoteById(String noteId) {
	Share share=new Share();
	NoteResult<Share> result=new NoteResult<Share>();
	
	Note note=noteDao.findByNoteId(noteId);
	String shareBody=note.getCn_note_body();
	String shareTitle=note.getCn_note_title();
	String shareId=NoteUtil.createId();//获取主键
	share.setCn_note_id(noteId);
	share.setCn_share_body(shareBody);
	share.setCn_share_id(shareId);
	share.setCn_share_title(shareTitle);
	int n=shareDao.addShareNote(share);//分享笔记
	//模拟异常
	//String str=null;
	//str.length();
	if(n==1) {
		result.setMsg("分享笔记成功!");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("分享笔记失败!!");
		result.setStatus(1);
		return result;
	}
}
public NoteResult<List<Share>> searchShareNote(String keyword,int page) {
	int maxShow=3;//设置每页显示最大数
	
	NoteResult<List<Share>> result =new NoteResult<List<Share>>();
	String fuzzyWord="%"+keyword+"%";//拼接上数据库的通配符%,实行模糊查询
	int begin=(page-1)*maxShow;//计算抓取记录的起点
	
	Map<String,Object> params=new HashMap();
	params.put("begin", begin);
	params.put("fuzzyWord", fuzzyWord);
	
	List<Share> lists=shareDao.searchShareNote(params);
	int n=0;
	if(lists!=null) {
		for(Share list:lists) {
			result.setData(lists);
			n++;
		}
		result.setMsg("搜索出"+n+"条结果");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("搜索无结果");
		result.setStatus(1);
		return result;
	}
	
}

}
