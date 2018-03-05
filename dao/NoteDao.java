package cn.wp.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.wp.cloud_note.entity.Note;

public interface NoteDao {
	public List<Note> findByBookId(String bookId);
	public List<Map> findByBookIdMap(String bookId);//也可以只返回部分属性
	public Note findByNoteId (String  noteId);
	public int updateNote(Note note);
	public int updateNoteByMap(Map<String,Object> map);
	
	public int save(Note note);
	public int deleteNote(String noteId);
	/**
	 * map中需要添加两个参数:
	 * map={ids:[id1,id2,id3,...],status:2}
	 * ids:代表被删除笔记的ID列表
	 * status代表被删除笔记的状态属性
	 * @param map
	 * @return
	 */
	public int deleteNotesByMap(Map<String,Object> map);
	
	int deleteNoteSHH1(String id);
}
