/**
 * 
 */
package com.the13star.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.the13star.configurations.PersistenceContext;
import com.the13star.dbmetadata.tables.records.UserDetailRecord;
import com.the13star.service.UserDetailService;

/**
 * @author Programmers
 *
 */
@Component
public class UserDetailTest {
	
	@Autowired
	private UserDetailService userDetailService;
	/**
	 * @param args
	 */ 
	
	private void start() {
		//userDetailService.saveUserDetail(3, "MICKY", 21);
		List<UserDetailRecord> userDetails = userDetailService.getAllUsers();
		for(UserDetailRecord record : userDetails){
			System.out.println(record);
		}
		/*
		UserDetailRecord record = userDetailService.getUserByID(1);
		System.out.println(record);*/
		/*
		UserDetailRecord userDetailRecord = new UserDetailRecord();
		userDetailRecord.setId(3);
		userDetailRecord.setName("Micky");
		userDetailRecord.setAge(26);
		int result = userDetailService.updateUserById(userDetailRecord);*/
		/*
		int result = userDetailService.deleteUserById(2);
		System.out.println("Result : "+result);*/
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
		UserDetailTest userDetailTest = applicationContext.getBean(UserDetailTest.class);
		userDetailTest.start();
		applicationContext.close();
	}

}
