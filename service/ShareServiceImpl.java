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
	String shareId=NoteUtil.createId();//��ȡ����
	share.setCn_note_id(noteId);
	share.setCn_share_body(shareBody);
	share.setCn_share_id(shareId);
	share.setCn_share_title(shareTitle);
	int n=shareDao.addShareNote(share);//����ʼ�
	//ģ���쳣
	//String str=null;
	//str.length();
	if(n==1) {
		result.setMsg("����ʼǳɹ�!");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("����ʼ�ʧ��!!");
		result.setStatus(1);
		return result;
	}
}
public NoteResult<List<Share>> searchShareNote(String keyword,int page) {
	int maxShow=3;//����ÿҳ��ʾ�����
	
	NoteResult<List<Share>> result =new NoteResult<List<Share>>();
	String fuzzyWord="%"+keyword+"%";//ƴ�������ݿ��ͨ���%,ʵ��ģ����ѯ
	int begin=(page-1)*maxShow;//����ץȡ��¼�����
	
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
		result.setMsg("������"+n+"�����");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("�����޽��");
		result.setStatus(1);
		return result;
	}
	
}

}
