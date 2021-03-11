package com.example.demo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@RequestMapping("/demo")
public class AaaaApplication {	
	private static final Logger logger = LoggerFactory.getLogger(AaaaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AaaaApplication.class, args);
	      logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	}
	   @ResponseBody
	   @RequestMapping(method = GET, produces = "application/json")
	   public String demo() {
	       return "{\"hello\":\"world\"}";
	   }
}

