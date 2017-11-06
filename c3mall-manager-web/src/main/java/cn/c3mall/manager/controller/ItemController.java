package cn.c3mall.manager.controller;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.c3mall.manager.service.ItemService;
import cn.c3mall.pojo.TbItem;
import cn.c3mall.utils.PageBeanResult;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId){
		//调用service服务方法
		TbItem item = itemService.findItemById(itemId);
		return item;
	}
	
	/**
	 * 显示商品列表
	 * 请求:item/list
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public PageBeanResult itemList(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="20") Integer row) {
		return itemService.findItemByPage(page, row);
	}
}
