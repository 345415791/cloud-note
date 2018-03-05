package cn.wp.cloud_note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//���뵽Spring������,�൱��������һ��bean

@Aspect//�����������������
public class LoggerBean {
	
@Before("within(cn.wp.cloud_note.controller..*)")//֪ͨ������,�����,�����ĸ��ط��������
	public void logController() {
		System.out.println("AOP����Controllerע��!");
	}

@Before("within(cn.wp.cloud_note.service..*)")//ʵ�����������б��@service����ʱ,����
	public void logService() {
	System.out.println("AOPʵ��Serviceע��");
}
@Before("within(cn.wp.cloud_note.dao..*)")//��������,��Ϊû����Ӧ��Dao���
	public void logDao() {
		System.out.println("AOP��DAOǰע��!");
	}
}