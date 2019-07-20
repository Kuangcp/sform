package com.stackfing.sform.Main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 * @Author: fing
 * @Description:
 * @Date: 上午11:25 19-7-14
 */
public class Main {
	public static void main(String[] args) {
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		String[] beanNamesForAnnotation = xmlBeanFactory.getBeanNamesForAnnotation(Component.class);
		System.out.println(beanNamesForAnnotation.length);
	}
}
