
package com.insonix.wsdltest;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PersonService", targetNamespace = "http://cxf.insonix.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addPerson", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.AddPerson")
    @ResponseWrapper(localName = "addPersonResponse", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.AddPersonResponse")
    public void addPerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Person arg0);

    /**
     * 
     * @return
     *     returns java.util.List<com.insonix.wsdltest.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.GetAllResponse")
    public List<Person> getAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns com.insonix.wsdltest.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPerson", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.GetPerson")
    @ResponseWrapper(localName = "getPersonResponse", targetNamespace = "http://cxf.insonix.com/", className = "com.insonix.wsdltest.GetPersonResponse")
    public Person getPerson(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

}