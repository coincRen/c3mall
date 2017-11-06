package cn.c3mall.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.c3mall.manager.service.ItemService;
import cn.c3mall.mapper.TbItemMapper;
import cn.c3mall.pojo.TbItem;
import cn.c3mall.pojo.TbItemExample;
import cn.c3mall.utils.PageBeanResult;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem findItemById(Long id) {
		
		return tbItemMapper.selectByPrimaryKey(id);
	}
	/**
	 * 需求:分页查询商品列表
	 * 参数:Integer page,Integer rows
	 * 返回值:PageBeanResult
	 * 分页方法:使用pageHelper插件分页
	 * 习惯:检查服务是否发布?
	 */
	@Override
	public PageBeanResult findItemByPage(Integer page, Integer row) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, row);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		PageBeanResult beanResult = new PageBeanResult();
		beanResult.setTotal(pageInfo.getTotal());
		beanResult.setRows(list);
		return beanResult;
	}

}
