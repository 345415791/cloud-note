package cn.wp.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.wp.cloud_note.entity.Share;

public interface ShareDao {
	public int addShareNote(Share share);
	public List<Share> searchShareNote(Map params);
}
