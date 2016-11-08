package com.niit.test;

import java.util.Date;

import javax.ejb.EJB;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.TestDAO;
import com.niit.model.Test;
import com.niit.utility.EmailSender;
import com.sun.jmx.snmp.Timestamp;

public class TestTest {
	
	@EJB
	EmailSender emailSender;
	
	public static void main(String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit");
		context.refresh();
		
		TestDAO testd= (TestDAO) context.getBean("testDAO");
		Test test = (Test)context.getBean("test");
		Date date= new Date();
		long time1=date.getTime();
		Timestamp time =new Timestamp(time1);
		test.setTestId("T002");
		test.setTestName("Updated name");
		//test.setTestDate(time);
		
		testd.saveOrUpdateTest(test);
		
		testd.delete("T002");
	
		
		
	}
}
