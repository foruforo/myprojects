/**
 * 
 */
package com.netsol.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.netsol.api.exceptionhandler.InvalidRequestException;
import com.netsol.entities.User;

/**
 * @author Harmeet Singh(Taara)
 *
 */

@Controller
@RequestMapping(value = "/api")
public class UserApi {

	Logger logger = Logger.getLogger(UserApi.class);

	List<User> users = new ArrayList<User>();

	public UserApi() {
		User user = new User();
		user.setId(13);
		user.setFirstName("Harmeet");
		user.setLastName("Singh");
		user.setUsername("harmeet.singh@netsolutionsindia.com");
		user.setPassword("password");
		user.setEnabled("1");

		users.add(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@Valid User user, BindingResult result) {
		logger.info("In User Login Service...... ");

		User tempUser = users.get(0);
		if (user.getUsername().equalsIgnoreCase(tempUser.getUsername())
				&& user.getPassword().equals(tempUser.getPassword())) {
			String key = UUID.randomUUID() + "" + System.currentTimeMillis();
			tempUser.setKey(key);
			users.add(0, tempUser);
			return tempUser;
		}
		throw new InvalidRequestException("Invalid Username or Password", result);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public User logout(
			@RequestParam(value = "key", defaultValue = "") String key) {
		logger.info("In User Logout Service...... ");

		if (!key.isEmpty()) {
			User user = users.get(0);
			if (key.equals(user.getKey())) {
				user.setKey("");
				users.add(0, user);
				return user;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/message", method=RequestMethod.POST)
	public String message() {
		logger.info("In User message Service...... ");
		return "Hello Rest SPring";
	}
}
