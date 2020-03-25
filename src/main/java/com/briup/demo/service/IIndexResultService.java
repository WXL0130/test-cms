package com.briup.demo.service;
/**
 * 
* @ClassName: IIndexResultService  
* @Description:  首页数据管理的service层接口
* @author WXL
* @date 2020年3月2日
 */

import com.briup.demo.bean.ex.CategoryEx;
import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.utils.CustomerException;

public interface IIndexResultService {

	/**
	 * 查询首页需要的所有数据
	 * @return
	 * @throws CustomerException
	 */
	IndexResult findIndexAllResult() throws CustomerException;
	
	
}
