package cn.wp.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	
	public static String createId(){
		//利用UUid算法生成主键id
		UUID uuid = UUID.randomUUID();//生成全局唯一标示符,
		/*
		 * UUID是由一个十六位的数字组成,表现出来的形式例如 
			550E8400-E29B-11D4-A716-446655440000  
		 */
		return uuid.toString().replace("-", "");//用来生成数据库的主键id非常不错。。
	}
	
	/**
	 * 将传入的src加密处理
	 * @param src 明文字符串
	 * @return 加密后的字符串结果
	 * @throws Exception 
	 */
	public static String md5(String src) {
		try {
			//将字符串信息采用MD5处理
			MessageDigest md = 
				MessageDigest.getInstance("MD5");//实例化文摘
			byte[] output = md.digest(src.getBytes());
			//将MD5处理结果利用Base64转成字符串
			String ret = 
			  Base64.encodeBase64String(output);
			return ret;
		}catch (Exception e) {
			throw new NoteException("密码加密失败",e);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.out.println("生成md5码"+md5("123456"));//4QrcOUm6Wau+VuBX8g+IPg==
//		System.out.println(md5("12354654676dfdfdfdf"));
		System.out.println(createId());
		System.out.println(createId());
		System.out.println(md5(createId()));
	}
	
}
