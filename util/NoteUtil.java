package cn.wp.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	
	public static String createId(){
		//����UUid�㷨��������id
		UUID uuid = UUID.randomUUID();//����ȫ��Ψһ��ʾ��,
		/*
		 * UUID����һ��ʮ��λ���������,���ֳ�������ʽ���� 
			550E8400-E29B-11D4-A716-446655440000  
		 */
		return uuid.toString().replace("-", "");//�����������ݿ������id�ǳ�������
	}
	
	/**
	 * �������src���ܴ���
	 * @param src �����ַ���
	 * @return ���ܺ���ַ������
	 * @throws Exception 
	 */
	public static String md5(String src) {
		try {
			//���ַ�����Ϣ����MD5����
			MessageDigest md = 
				MessageDigest.getInstance("MD5");//ʵ������ժ
			byte[] output = md.digest(src.getBytes());
			//��MD5����������Base64ת���ַ���
			String ret = 
			  Base64.encodeBase64String(output);
			return ret;
		}catch (Exception e) {
			throw new NoteException("�������ʧ��",e);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("����md5��"+md5("123456"));//4QrcOUm6Wau+VuBX8g+IPg==
//		System.out.println(md5("12354654676dfdfdfdf"));
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(md5(createId()));
	}
	
}
