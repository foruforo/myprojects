/**
 * 
 */
package com.springjavaconfig.web;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springjavaconfig.entity.User;
import com.springjavaconfig.service.UserService;

/**
 * @author Programmers
 *
 */
@Controller
public class FirstController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public String saveUser(String name, int age){
		User user = new User();
		System.out.println("name : "+name+" ******** age : "+age);
		user.setName(name);
		user.setAge(age);
		System.out.println(userService.save(user));
		return "helloworld";
	}
	
	@RequestMapping(value="/getallusers", method=RequestMethod.GET)
	public String getAllUser() {
		List<User> users = userService.findAll();
		for(User user : users){
			System.out.println(user.toString());
		}
		return "helloworld";
	}
}
