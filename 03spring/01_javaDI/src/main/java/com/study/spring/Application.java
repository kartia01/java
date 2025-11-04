package com.study.spring;

import java.lang.annotation.Annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring.bean.Config;
import com.study.spring.bean.Member;
import com.study.spring.bean.Printer;

//@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		
		Member member1 = (Member) context.getBean("member1");
		member1.print();
		
		Member member2 = context.getBean("hello", Member.class);
		member2.print();
		
		Printer printer = (Printer) context.getBean("printerB", Printer.class);
		member1.setPrinter(printer);
		member1.print();
	}

}
