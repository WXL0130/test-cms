package com.briup.demo.mapper.ex;

import java.util.List;

import com.briup.demo.bean.ex.CategoryEx;

/**
 * 
* @ClassName: CategoryExMapper  
* @Description:  处理 查询栏目及其包含的文章信息
* @author WXL
* @date 2020年3月2日
 */
public interface CategoryExMapper {

	/**
	 * 实现查询所有栏目及其包含的文章信息
	 * @return
	 */
  List<CategoryEx>	findAllCategoryExs();
  
  /**
   * tong通过id查询对应栏目以及其包含的文章信息
   */
  CategoryEx findCategoryExById(Integer id);
  
}
