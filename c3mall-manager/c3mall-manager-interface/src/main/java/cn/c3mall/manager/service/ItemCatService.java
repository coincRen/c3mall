package cn.c3mall.manager.service;

import java.util.List;

import cn.c3mall.utils.TreeNode;

public interface ItemCatService {

	/**
	 * 查询商品类别生成树
	 * 根据parent_id查询
	 */
	public List<TreeNode> findItemCatByParentId(Long parentid);
}
