package com.remind.bpf.test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class UrlTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String name = "D:/DATA/spring//bpf/src/main/webapp/WEB-INF/web.xml";
		Resource res1 = new FileSystemResource(name);
		Resource res2 = new ClassPathResource("web.xml");
		
		System.out.println(res1.getFilename());
		System.out.println(res2.getFilename());
	}

}
