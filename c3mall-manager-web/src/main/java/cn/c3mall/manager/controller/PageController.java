package cn.c3mall.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 跳转页面
	 * localhost:8083/index
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page) {
		
		return page;
	}
}
