package com.briup.demo.mapper.ex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

@Service
public interface CustomerByJpa extends JpaRepository<Customer,Integer> {
	
	Customer findByUsernameAndPassword(String username,String password)throws CustomerException;

}
