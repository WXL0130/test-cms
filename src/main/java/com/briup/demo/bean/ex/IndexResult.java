package com.briup.demo.bean.ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Link;

/**
 * 
* @ClassName: IndexResult  
* @Description:  保存首页的所有数据
* @author WXL
* @date 2020年2月28日
 */
public class IndexResult implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private List<CategoryEx> categoryExs;
	private List<Link> links;
	
	
	public List<CategoryEx> getCategoryExs() {
		return categoryExs;
	}
	public void setCategoryExs(List<CategoryEx> categoryExs) {
		this.categoryExs = categoryExs;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public IndexResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IndexResult(List<CategoryEx> categoryExs, List<Link> links) {
		super();
		this.categoryExs = categoryExs;
		this.links = links;
	}
	
	
}
