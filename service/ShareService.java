package cn.wp.cloud_note.service;

import java.util.List;

import cn.wp.cloud_note.entity.Share;
import cn.wp.cloud_note.util.NoteResult;

public interface ShareService {
	public NoteResult<Share> shareNoteById(String noteId);
	public NoteResult<List<Share>> searchShareNote(String keyword,int page);
}
