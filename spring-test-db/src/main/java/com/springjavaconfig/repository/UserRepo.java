/**
 * 
 */
package com.springjavaconfig.repository;

import org.springframework.data.repository.CrudRepository;

import com.springjavaconfig.entity.User;

/**
 * @author Harmeet Singh
 *
 */
public interface UserRepo extends CrudRepository<User, Integer> {
}
