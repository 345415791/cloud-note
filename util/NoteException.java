package cn.wp.cloud_note.util;

/**
 * �Զ����쳣
 * @author liangjq
 */
public class NoteException extends RuntimeException{
	public NoteException(
		String msg,Throwable t){
		super(msg,t);
	}
}
