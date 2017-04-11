package com.mkyong.datastat.web;

import java.util.Map;

import com.mkyong.datastat.service.TablespaceInfoService;
import com.mkyong.datastat.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.datastat.service.HelloWorldService;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private HelloWorldService helloWorldService;

	@Autowired
	private TablespaceInfoService tablespaceInfoService;

	@Autowired
	private UserInfoService userInfoService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		
		return "index";
	}

	@RequestMapping(value = "schemas", method = RequestMethod.GET)
	public ModelAndView usersList() {

		ModelAndView model = new ModelAndView();
		model.setViewName("schemas");
		model.addObject("userList", userInfoService.getUsers());

		return model;
	}

	@RequestMapping(value = "data_usage", method = RequestMethod.GET)
	public ModelAndView dataUsage() {

		ModelAndView model = new ModelAndView();
		model.setViewName("data_usage");
		model.addObject("tablespaceList", tablespaceInfoService.getTablespaces());

		return model;
	}

	@RequestMapping("home")
	public String home(Model model) {
		return "index";
	}


	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

}