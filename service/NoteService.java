package cn.wp.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.wp.cloud_note.entity.Note;
import cn.wp.cloud_note.util.NoteResult;

public interface NoteService {//进行封装处理,通过dao返回的查询信息,再封装到NoteResult中
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	public NoteResult<Note> loadNote(String noteId);
	public NoteResult<Note> updateNote(Note note);
	public NoteResult<Note> addNote(String userId,String bookId,String noteName);
	public NoteResult<Object> deleteNote(String noteId);
	
	//String... 表示动态参数,就是String[]数组
	public void deleteNoteSSH1(String ...ids);
}
