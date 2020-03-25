package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.service.IArticleService;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.service.impl.ArticleServiceImpl;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与栏目相关的和前端交互的web层
 * @author Administrator
 *
 */
@RestController
@Api(description = "栏目相关接口")
public class CategoryController {
	
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;
	/**
	 * 查询所有栏目信息
	 * @return
	 */
	
	@GetMapping("/getAllCategory")
	@ApiOperation("查询所有栏目")
	public Message<List<Category>> selectAllCategory(){
		
		return MessageUtil.success(categoryService.findAllCategorys());
	}
	/**
	 * 新增栏目信息
	 * @param category
	 * @return
	 */
	@PostMapping("/addCategory")
	@ApiOperation("添加栏目信息")
	public Message<String> addCategory(Category category) {
		
		
		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.CANNOTEXECUTE_CODE, "系统错误: "+e.getMessage());
		}
	}
	/**
	 * 修改栏目
	 * @param category
	 * @return
	 */
	@PostMapping("/updateCategory")
	@ApiOperation("修改栏目信息")
	public Message<String> updateCategory(Category category) {
		
		

		try {
			categoryService.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "警告,系统错误: "+e.getMessage());
		}
		
	}
	/**
	 * 根据id删除栏目
	 */
	@GetMapping("/deleteCategoryById")
	@ApiOperation("删除指定id栏目")
	public Message<String> deleteCategory(int id) {
	
		categoryService.deleteCategoryById(id);
		return MessageUtil.success();
	}
	/**
	 * 根据id查找栏目信息
	 * @param id
	 * @return
	 */
	@GetMapping("/findCategoryById")
	@ApiOperation("通过id查找栏目")
	public Message<Category> findCategoryById(int id) {
		return MessageUtil.success(categoryService.findCategoryById(id));
	}
	/**
	 * 通过name查询栏目
	 */
	@GetMapping("/getCategoryByName")
	@ApiOperation("查询指定栏目")
	public Message<List<Category>> findCategoryByName(String name) {
		
		try {
			List<Category> list = categoryService.findCategoryByName(name);
			
			
			return MessageUtil.success(list);
			
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.NOFOUND_CODE, "系统错误"+e.getMessage());
		}
	}
	
	@GetMapping("/findAllArticle")
	@ApiOperation("通过栏目找所有文章")
	public Message<List<Article>> findArticleByCategoryId(int id){
		
		 List<Article> list = categoryService.findAllArticleByCategory(id);
		
		return MessageUtil.success(list);
		
	}
	
	/**
	 * 根据id查找栏目及其包含的所有文章信息
	 */

	@GetMapping("/findCategoryExById")
	@ApiOperation("根据栏目id查找栏目以及包含的文章信息")
	public Message<CategoryEx> findCategoryExById(int id){
		return MessageUtil.success(categoryService.findCategoryExById(id));
	}
	
	
}
