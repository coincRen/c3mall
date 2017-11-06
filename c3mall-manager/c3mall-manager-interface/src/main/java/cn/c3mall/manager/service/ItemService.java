package cn.c3mall.manager.service;

import cn.c3mall.pojo.TbItem;
import cn.c3mall.utils.PageBeanResult;

public interface ItemService {

	/**
	 * 691300根据id查询
	 */
	public TbItem findItemById(Long id);
	/**
	 * 
	 * @param page
	 * @param row
	 * @return
	 */
	public PageBeanResult findItemByPage(Integer page ,Integer row); 
}
