package com.the13star.service;

import java.util.List;

import com.the13star.dbmetadata.tables.records.UserDetailRecord;

public interface UserDetailService {
	public void saveUserDetail(int id, String name, int age);

	public List<UserDetailRecord> getAllUsers();

	public UserDetailRecord getUserByID(int i);

	public int updateUserById(UserDetailRecord userDetailRecord);

	public int deleteUserById(int id);
}
