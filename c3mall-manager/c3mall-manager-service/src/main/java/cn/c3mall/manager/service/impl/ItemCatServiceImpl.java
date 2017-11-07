package cn.c3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.c3mall.manager.service.ItemCatService;
import cn.c3mall.mapper.TbItemCatMapper;
import cn.c3mall.pojo.TbItemCat;
import cn.c3mall.pojo.TbItemCatExample;
import cn.c3mall.pojo.TbItemCatExample.Criteria;
import cn.c3mall.utils.TreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	/**
	 * 需求:查询商品类别生成树 根据parent_id查询
	 * 参数:parent_id
	 * 返回值:List<TreeNode>
	 * 发布服务
	 */
	public List<TreeNode> findItemCatByParentId(Long parentid) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		for (TbItemCat tbItemCat : list) {
			TreeNode node = new TreeNode();
			node.setId(tbItemCat.getId());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			node.setText(tbItemCat.getName());
			treeNodes.add(node);
		}
		return treeNodes;
	}

}
