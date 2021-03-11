package com.example.demo.Controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.AaaaApplication;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(AaaaApplication.class);
	
	@RequestMapping(value = "/{input:.+}", method = RequestMethod.GET)
	public ModelAndView getDomain(@PathVariable("input") String input) {
		
		ModelAndView modelandView = new ModelAndView("result");
		
		modelandView.addObject("user-agent", getUserAgent());
		modelandView.addObject("headers", getHeadersInfo());
		
		return null;
		
	}

	private Map<String, String> getHeadersInfo() {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
            logger.info("test " +map);
        }
		
		//logger.info("test " +map);
		return map;
	}

	private String getUserAgent() {
		// TODO Auto-generated method stub
		return request.getHeader("user-agent");
	}
	
}
