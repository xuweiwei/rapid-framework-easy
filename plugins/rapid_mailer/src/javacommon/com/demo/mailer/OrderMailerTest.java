package com.demo.mailer;

import java.io.IOException;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.org.rapid_framework.util.concurrent.async.AsyncToken;
import freemarker.template.TemplateException;

/**
 * 本类为演示邮件发送,请删除本类.
 * 
 * @author badqiu
 *
 */
public class OrderMailerTest extends TestCase {
	OrderMailer orderMailer;
	
	public void setUp()throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-mail.xml");
		orderMailer = (OrderMailer)context.getBean("orderMailer");
	}
	
	public void testSendFromOrderMailer() throws TemplateException, IOException, Exception {
		AsyncToken token = orderMailer.sendConfirmOrder("badqiu");
		
		token.waitForResult();
	}
	
}
