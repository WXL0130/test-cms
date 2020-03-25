package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.utils.CustomerException;

/**
 * 栏目相关的 service层
 * @author Administrator
 *
 */
public interface ICategoryService {

	
	/**
	 * 查询所有的栏目
	 */
	
	public List<Category> findAllCategorys() throws CustomerException;
	
	/**
	 * 添加或修改栏目信息
	 * 
	 */
	 
	public void saveOrUpdateCategory(Category category) throws CustomerException;
	
	/**
	 * 根据id删除栏目
	 */
	
	public void deleteCategoryById(int id) throws CustomerException;
	
	
	/**
	 * 根据id 查找指定栏目信息
	 */
	
	
	public Category findCategoryById(int id) throws CustomerException;
	
	/**
	 * 根据名字,查找指定栏目
	 */
	
	public List<Category> findCategoryByName(String name) throws CustomerException;
	
	
	/**
	 * 查询栏目信息并且级联查询包含所有的文章信息
	 */
	
	public List<CategoryEx> findAllCategoryEx() throws CustomerException;
	
	public List<Article> findAllArticleByCategory(int id)throws CustomerException;
	
	
	
	/**
	 * 查询栏目及其包含文章的所有数据
	 * 
	 */
	
	CategoryEx findCategoryExById(Integer id)throws CustomerException;
	
}
