package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
* @ClassName: CustomerController  
* @Description: 与登陆相关的web层
* @author WXL
* @date 2020年3月2日
 */
@RestController
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@PostMapping("/login")
	@ApiOperation("用户登陆验证")
	public Message<List<Customer>> login(String username,String password){
		
		
		try {
			List<Customer> list = customerService.login(username, password);
			return MessageUtil.success(list);
			
		} catch (CustomerException e) {
			
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, e.getMessage());
			
		}
		
	}
	
}
