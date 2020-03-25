package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Customer;
import com.briup.demo.bean.CustomerExample;
import com.briup.demo.bean.CustomerExample.Criteria;
import com.briup.demo.mapper.CustomerMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 
* @ClassName: CustomerServiceImpl  
* @Description:  
* @author WXL
* @date 2020年3月2日
 */
@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<Customer> login(String username, String password) throws CustomerException {

		CustomerExample example = new CustomerExample();
	
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
	    List<Customer> list = customerMapper.selectByExample(example);
	   
	    if(list.size()==0) {
	    	throw new CustomerException(StatusCodeUtil.ERROR_CODE, "账号或密码不存在,请重试");
	    }else {
	    	
	    	
	    	return list;
	    }
	}
	
	

}
