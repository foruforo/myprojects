/**
 * 
 */
package com.insonix.testcase;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

//import com.insonix.cxf.PersonService;

/**
 * @author Programmers
 *
 */
public class JUnitTestCase {

	private static JaxWsProxyFactoryBean factory;
	//private static PersonService service;
		
	@Test
	public void test() {
		/*factory = new JaxWsProxyFactoryBean();
	    factory.getInInterceptors().add(new LoggingInInterceptor());
	    factory.getOutInterceptors().add(new LoggingOutInterceptor());
	    factory.setServiceClass(com.insonix.cxf.PersonService.class);
	    factory.setAddress(com.insonix.cxf.impl.PersonService.WSDL_LOCATION.toString());
	    service = (PersonService) factory.create();
		System.out.println("Service: "+service.getPerson(2));*/
	}

}
