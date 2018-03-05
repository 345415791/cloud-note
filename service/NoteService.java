package cn.wp.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.util.NoteResult;

public interface NoteService {//���з�װ����,ͨ��dao���صĲ�ѯ��Ϣ,�ٷ�װ��NoteResult��
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	public NoteResult<Note> loadNote(String noteId);
	public NoteResult<Note> updateNote(Note note);
	public NoteResult<Note> addNote(String userId,String bookId,String noteName);
	public NoteResult<Object> deleteNote(String noteId);
	
	//String... ��ʾ��̬����,����String[]����
	public void deleteNoteSSH1(String ...ids);
}
