/**
 * 
 */
package com.the13star.dao;

import java.util.List;

import com.the13star.dbmetadata.tables.records.UserDetailRecord;


/**
 * @author Programmers
 *
 */
public interface UserDetailDao {

	public void insertNewUser(UserDetailRecord userDetailRecord);

	public List<UserDetailRecord> getAllUsers();

	public UserDetailRecord getUserByID(int id);

	public int updateUserById(UserDetailRecord userDetailRecord);

	public int deleteUserById(int id);
}
