/**
 * 
 */
package com.the13star.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteWhereStep;
import org.jooq.InsertValuesStep3;
import org.jooq.Result;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.the13star.dao.UserDetailDao;
import com.the13star.dbmetadata.tables.UserDetail;
import com.the13star.dbmetadata.tables.records.UserDetailRecord;

/**
 * @author Programmers
 *
 */
@Repository
public class UserDetailDaoImpl implements UserDetailDao {

	@Autowired
	DSLContext dslContext;

	public void insertNewUser(UserDetailRecord userDetailRecord) {
		InsertValuesStep3<UserDetailRecord, Integer, String, Integer> userdetails = dslContext
				.insertInto(UserDetail.USER_DETAIL, UserDetail.USER_DETAIL.ID,
						UserDetail.USER_DETAIL.NAME, UserDetail.USER_DETAIL.AGE);
		userdetails.values(userDetailRecord.getId(),
				userDetailRecord.getName(), userDetailRecord.getAge());
		userdetails.execute();
	}

	@Override
	public List<UserDetailRecord> getAllUsers() {
		Result<UserDetailRecord> userDetails = dslContext
				.fetch(UserDetail.USER_DETAIL);
		return new ArrayList<>(userDetails);
	}

	@Override
	public UserDetailRecord getUserByID(int id) {
		return dslContext.fetchOne(UserDetail.USER_DETAIL,
				UserDetail.USER_DETAIL.ID.equal(id));
	}

	@Override
	public int updateUserById(UserDetailRecord userDetailRecord) {
		UpdateSetFirstStep<UserDetailRecord> updateSetFirstStep = dslContext
				.update(UserDetail.USER_DETAIL);
		UpdateSetMoreStep<UserDetailRecord> updateSetMoreStep = updateSetFirstStep
				.set(UserDetail.USER_DETAIL.NAME, userDetailRecord.getName())
				.set(UserDetail.USER_DETAIL.AGE, userDetailRecord.getAge());
		UpdateConditionStep<UserDetailRecord> updateConditionStep = updateSetMoreStep
				.where(UserDetail.USER_DETAIL.ID.equal(userDetailRecord.getId()));
		return updateConditionStep.execute();
	}

	@Override
	public int deleteUserById(int id) {
		DeleteWhereStep<UserDetailRecord> deleteWhereStep =	dslContext.delete(UserDetail.USER_DETAIL);
		DeleteConditionStep<UserDetailRecord> deleteConditionStep =	deleteWhereStep.where(UserDetail.USER_DETAIL.ID.equal(id));
		return deleteConditionStep.execute();
	}

}
