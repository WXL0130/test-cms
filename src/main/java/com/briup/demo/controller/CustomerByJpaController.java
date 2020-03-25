package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.mapper.ex.CustomerByJpa;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@Api(description = "jpa写的controller")
public class CustomerByJpaController {
	
	@Autowired
	private CustomerByJpa customerByJpa;
	
	@PostMapping("/jpaLogin")
	@ApiOperation("jpaaa")
	public Message<Customer> test(String username,String password) {
		Customer customer = customerByJpa.findByUsernameAndPassword(username, password);
		if(customer==null) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "账号或密码错误" );
		}else {
		return MessageUtil.success(customer);
		}
		
	}

}
