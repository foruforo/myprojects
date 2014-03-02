/**
 * 
 */
package com.springjavaconfig.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Programmers
 *
 */
@Controller
public class FirstController {

	@RequestMapping("/helloworld")
	public String helloWOrld(){
		System.out.println("In Controller ******* ");
		return "helloworld";
	}
}
