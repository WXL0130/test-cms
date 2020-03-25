package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.ex.IndexResult;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: IndexResultController  
* @Description:  
* @author WXL
* @date 2020年3月2日
 */
@RestController
@Api(description = "首页需要的所有数据")
public class IndexResultController {
	
	@Autowired
	private IIndexResultService indexResultService;
	@GetMapping("/getIndeResult")
	@ApiOperation("首页展示的所有数据")
	public Message<IndexResult> getIndexResult() {
		
		return MessageUtil.success(indexResultService.findIndexAllResult());
	}

}
