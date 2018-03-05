package cn.wp.cloud_note.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
	@Around("within(cn.wp.cloud_note.service..*)")
	public Object audit(ProceedingJoinPoint point) throws Throwable {//固定写法.用来调用方法,如service
		//System.out.println("AOP输出service");
		Object obj=null;
		try {
			System.out.println("开始执行Service");
			long timeStart=System.currentTimeMillis();
			//在之前,之后分别定义了计时
			obj=point.proceed();//模拟调用service过程,
			
			long timeEnd=System.currentTimeMillis();
			String str=point.getSignature().toString();//显示调用service的名字
			System.out.println(str+"耗时:"+(timeEnd-timeStart));
		}catch(Throwable e) {
			e.printStackTrace();
			throw e;
		}
		return obj;
	}
}
