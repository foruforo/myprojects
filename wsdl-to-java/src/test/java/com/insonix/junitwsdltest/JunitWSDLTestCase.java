/**
 * 
 */
package com.insonix.junitwsdltest;

import org.junit.Test;

import com.insonix.wsdltest.PersonService;
import com.insonix.wsdltest.PersonService_Service;

/**
 * @author Programmers
 *
 */
public class JunitWSDLTestCase {

	@Test
	public void test() {
		PersonService_Service personService = new PersonService_Service();
		PersonService service = personService.getPersonServiceImplPort();
		System.out.println("Person : "+service.getPerson(2));
	}

}
