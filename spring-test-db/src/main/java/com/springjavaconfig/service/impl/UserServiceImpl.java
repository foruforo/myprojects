/**
 * 
 */
package com.springjavaconfig.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.springjavaconfig.entity.User;
import com.springjavaconfig.repository.UserRepo;
import com.springjavaconfig.service.UserService;

/**
 * @author Harmeet Singh
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepo userRepo;
	
	@Override
	@Transactional
	public User save(User user) {
		return userRepo.save(user);
	}

	
	@Override
	@Transactional
	public List<User> findAll() {
		return Lists.newArrayList( userRepo.findAll());
	}

}
