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
		//System.out.println("NSI22bookIdֵ:"+bookId);
		NoteResult<List<Map>> result=new NoteResult<List<Map>>();
		List<Map> notes=dao.findByBookIdMap(bookId);
		result.setMsg("��ȡ�ʼ����ɹ�");
		result.setStatus(0);
		result.setData(notes);
		for(Map note:notes) {
			//System.out.println("NSI24��noteֵ:"+note);
		}
		return result;
	}
	
	@ResponseBody
	public NoteResult<Note> loadNote(String noteId) {
		NoteResult<Note> result=new NoteResult<Note>();
		 Note note=dao.findByNoteId(noteId);
		if(!note.equals(null)) {
			result.setData(note);
			result.setMsg("��ѯnote�ɹ�!");
			result.setStatus(0);
		}else {
			result.setStatus(1);
			result.setMsg("��ѯ�ʼ�ʧ��");
		}
		return result;
	}
	
@ResponseBody
	public NoteResult<Note> updateNote(Note note) {
	NoteResult<Note> result=new NoteResult<Note>();
	//System.out.println("NSI53");
	
	int n=dao.updateNote(note);//�������ݿ�!!!!!
	
	//System.out.println("NSI54,��dao�Ƿ�ɹ��������ݿ�"+n);
	if(n==1) {//��ʾ���ݿ���һ�и���
		String noteId=note.getCn_note_id();
		
		Note noteReturn=new Note();
		noteReturn=dao.findByNoteId(noteId);
		
		result.setMsg("�������!");
		result.setData(noteReturn);
		result.setStatus(0);
		//System.out.println("NSI62�в�ѯ�ʼ�:"+result.getData());
		return result;
	}else {
		result.setMsg("�������ݿ�ʧ��!");
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
	//�Լ�����:1-normal,2-delete
	note.setCn_note_status_id("1");
	//�Լ�����;1-normal,2-favor,3-share
	note.setCn_note_type_id("1");//??
	note.setCn_note_body("");
	
	int n=dao.save(note);
	if(n==1) {
		result.setStatus(0);
		result.setMsg("�½��ʼ����ɹ�!!!");
		result.setData(note);
		//System.out.println("NSI90��"+result);
		return result;
	}else {
		result.setStatus(1);
		result.setMsg("�½��ʼ���ʧ��!!!");
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
		result.setMsg("ɾ��������վ�ɹ�!!!");
		result.setStatus(0);
		return result;
	}else {
		result.setMsg("ɾ��������վʧ��!!!");
		result.setStatus(1);
		return result;
	}
}
@Transactional//�����������(����AOPԭ��)
public void deleteNoteSSH1(String... ids) {
	//String...����String[]����
	for (String id:ids) {
		int n =dao.deleteNoteSHH1(id);
		if(n!=1) {//��ʾĳ��ɾ��������
			//�׳��쳣,��������Ļع�
			throw new RuntimeException("ɾ����!!");
		}
	}
	
}
	

}
