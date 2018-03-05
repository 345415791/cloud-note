package cn.wp.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.wp.cloud_note.entity.Note;

public interface NoteDao {
	public List<Note> findByBookId(String bookId);
	public List<Map> findByBookIdMap(String bookId);//Ҳ����ֻ���ز�������
	public Note findByNoteId (String  noteId);
	public int updateNote(Note note);
	public int updateNoteByMap(Map<String,Object> map);
	
	public int save(Note note);
	public int deleteNote(String noteId);
	/**
	 * map����Ҫ�����������:
	 * map={ids:[id1,id2,id3,...],status:2}
	 * ids:����ɾ���ʼǵ�ID�б�
	 * status����ɾ���ʼǵ�״̬����
	 * @param map
	 * @return
	 */
	public int deleteNotesByMap(Map<String,Object> map);
	
	int deleteNoteSHH1(String id);
}
