/**
 * 
 */
package com.springjavaconfig.service;

import java.util.List;

import com.springjavaconfig.entity.User;

/**
 * @author Harmeet SIngh
 *
 */
public interface UserService {

	public User save(User user);
	public List<User> findAll();
}
