package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

/**
 * 
* @ClassName: ICustomerService  
* @Description:  关于顾客登陆验证的方法
* @author WXL
* @date 2020年3月2日
 */
public interface ICustomerService {

	List<Customer> login(String username,String password)throws CustomerException;
}
