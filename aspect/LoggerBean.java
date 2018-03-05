package cn.wp.cloud_note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//纳入到Spring容器里,相当于配置了一个bean

@Aspect//下面的类就是切面代码
public class LoggerBean {
	
@Before("within(cn.wp.cloud_note.controller..*)")//通知的内容,切入点,具体哪个地方加入代码
	public void logController() {
		System.out.println("AOP功能Controller注入!");
	}

@Before("within(cn.wp.cloud_note.service..*)")//实际上是运行有标记@service的类时,触发
	public void logService() {
	System.out.println("AOP实现Service注入");
}
@Before("within(cn.wp.cloud_note.dao..*)")//触发不了,因为没有相应的Dao标记
	public void logDao() {
		System.out.println("AOP在DAO前注入!");
	}
}