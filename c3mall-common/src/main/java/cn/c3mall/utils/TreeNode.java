package cn.c3mall.utils;

import java.io.Serializable;

public class TreeNode implements Serializable {
/**数据格式
 * [{    
    "id": 1,    
    "text": "Node 1",    
    "state": "closed",    
},{    
    "id": 2,    
    "text": "Node 2",    
    "state": "closed"   
}]  
 */
	private Long id;
	private String text;
	//state=1 表示有子节点 状态close
	//state=0 状态 open
	private String  state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
