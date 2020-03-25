package com.briup.demo.service.impl;
/**
 * 
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.ArticleExample.Criteria;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.mapper.ex.CategoryExMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;
/**
 * 
* @ClassName: CategoryServiceImpl  
* @Description: 操作栏目的service功能类
* @author WXL
* @date 2020年2月27日
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

	//栏目 的dao
	@Autowired
	private CategoryMapper categoryMapper;
	
	//栏目的拓展dao
	@Autowired
	private CategoryExMapper categoryExMapper;
	
	//文章的dao
	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public List<Category> findAllCategorys() throws CustomerException {
		return categoryMapper.selectByExample(new CategoryExample());
	}
	
	
	

	@Override
	public void saveOrUpdateCategory(Category category) throws CustomerException {
		
		if(category == null)
		{
			throw new CustomerException(StatusCodeUtil.ERROR_CODE, "参数为空!");
		}
		//没有输入id,插入数据
		if(category.getId()==null) {
			String name = category.getName();
			//如果数据库存在名字相同的栏目,则不保存,同时抛出异常405
			if(findAllCategorys().toString().contains(name))
			
			{
				throw new CustomerException(StatusCodeUtil.CANNOTEXECUTE_CODE, "系统已经存在该栏目名!");
			
			}
			else {
				categoryMapper.insert(category);
			}
				
			
		}else {
			categoryMapper.updateByPrimaryKey(category);
		}
	}

	@Override
	public void deleteCategoryById(int id) throws CustomerException {

		//sh删除栏目同时,要删除栏目包含的文章信息
		ArticleExample example = new ArticleExample();
		 example.createCriteria().andCategoryIdEqualTo(id);
		
		articleMapper.deleteByExample(example);
		categoryMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Category findCategoryById(int id) throws CustomerException {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(id);
		
	}




	@Override
	public List<Category> findCategoryByName(String name) throws CustomerException {
		CategoryExample example = new CategoryExample();
		example.createCriteria().andNameEqualTo(name);
		  List<Category> list = categoryMapper.selectByExample(example);
		  if(list == null) {
			  throw new CustomerException(StatusCodeUtil.NOFOUND_CODE, "没有查询到指定栏目!");
		  }
		  else {
			  
			  return list;
		  }
		
	}




	@Override
	public List<CategoryEx> findAllCategoryEx() throws CustomerException {

		return categoryExMapper.findAllCategoryExs();
		
		
		
	}




	@Override
	public List<Article> findAllArticleByCategory(int id) throws CustomerException {
		
		  ArticleExample example = new ArticleExample();
		  example.createCriteria().andCategoryIdEqualTo(id);
		
		
		return articleMapper.selectByExample(example);
	}




	@Override
	public CategoryEx findCategoryExById(Integer id) throws CustomerException {

		
		return categoryExMapper.findCategoryExById(id);
	}




}
