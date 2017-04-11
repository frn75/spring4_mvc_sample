package com.mkyong.datastat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);

	public static final String SERVER_NAME = "ecsd0010005e.epam.com:1521:DB1";

	public String getDesc() {
		return "Gradle + Spring MVC Example";
	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "Server stat.: " + SERVER_NAME;
		}else{
			return "Hello " + name;
		}
	}

}