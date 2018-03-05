package cn.wp.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
	@Around("within(cn.wp.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) throws Throwable {//�̶�д��.�������÷���,��service
		//System.out.println("AOP���service");
		Object obj=null;
		try {
			System.out.println("��ʼִ��Service");
			long timeStart=System.currentTimeMillis();
			//��֮ǰ,֮��ֱ����˼�ʱ
			obj=point.proceed();//ģ�����service����,
			
			long timeEnd=System.currentTimeMillis();
			String str=point.getSignature().toString();//��ʾ����service������
			System.out.println(str+"��ʱ:"+(timeEnd-timeStart));
		}catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return obj;
	}
}
