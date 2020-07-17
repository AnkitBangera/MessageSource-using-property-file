package org.Spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component//this annotation is used to declare this class as a bean instead of defining this class as bean in spring.xml
public class Circle implements Shape {
	private Point center;
	private MessageSource messageSource;


	public Point getCenter() {
		return center;
	}

	//if the name parameter not mentioned in the @Resource then 
	@Resource (name="pointA")
	public void setCenter(Point center) {
		this.center = center;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println(this.messageSource.getMessage("points",new Object[]{center.getX(),center.getY()},"Default points",null));
		//System.out.println("Circle [centre=" + center + "]");
		//System.out.println(this.messageSource.getMessage("name",null,"Default greeting",null));
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Initialized circle");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed circle");
	}
	
}
