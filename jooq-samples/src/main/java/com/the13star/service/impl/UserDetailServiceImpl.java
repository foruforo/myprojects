/**
 * 
 */
package com.the13star.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the13star.dao.UserDetailDao;
import com.the13star.dbmetadata.tables.records.UserDetailRecord;
import com.the13star.service.UserDetailService;

/**
 * @author Programmers
 *
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserDetailDao userDetailDao;

	/* (non-Javadoc)
	 * @see com.the13star.service.UserDetailService#saveUserDetail(int, java.lang.String, int)
	 */
	@Override
	public void saveUserDetail(int id, String name, int age) {
		UserDetailRecord record = new UserDetailRecord();
		record.setId(id);
		record.setName(name);
		record.setAge(age);
		
		userDetailDao.insertNewUser(record);
	}

	@Override
	public List<UserDetailRecord> getAllUsers() {
		return userDetailDao.getAllUsers();
	}

	@Override
	public UserDetailRecord getUserByID(int id) {
		return userDetailDao.getUserByID(id);
	}

	@Override
	public int updateUserById(UserDetailRecord userDetailRecord) {
		return userDetailDao.updateUserById(userDetailRecord);
	}

	@Override
	public int deleteUserById(int id) {
		return userDetailDao.deleteUserById(id);
	}

}
