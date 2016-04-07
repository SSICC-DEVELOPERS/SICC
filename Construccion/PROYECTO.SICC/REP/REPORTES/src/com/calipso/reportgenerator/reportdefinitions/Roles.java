/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.calipso.reportgenerator.reportdefinitions;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Roles.
 * 
 * @version $Revision$ $Date$
 */
public class Roles implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rolList
     */
    private java.util.Vector _rolList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Roles() {
        super();
        _rolList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.Roles()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRol
     * 
     * @param vRol
     */
    public void addRol(com.calipso.reportgenerator.reportdefinitions.Rol vRol)
        throws java.lang.IndexOutOfBoundsException
    {
        _rolList.addElement(vRol);
    } //-- void addRol(com.calipso.reportgenerator.reportdefinitions.Rol) 

    /**
     * Method addRol
     * 
     * @param index
     * @param vRol
     */
    public void addRol(int index, com.calipso.reportgenerator.reportdefinitions.Rol vRol)
        throws java.lang.IndexOutOfBoundsException
    {
        _rolList.insertElementAt(vRol, index);
    } //-- void addRol(int, com.calipso.reportgenerator.reportdefinitions.Rol) 

    /**
     * Method enumerateRol
     */
    public java.util.Enumeration enumerateRol()
    {
        return _rolList.elements();
    } //-- java.util.Enumeration enumerateRol() 

    /**
     * Method getRol
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Rol getRol(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rolList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.Rol) _rolList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.Rol getRol(int) 

    /**
     * Method getRol
     */
    public com.calipso.reportgenerator.reportdefinitions.Rol[] getRol()
    {
        int size = _rolList.size();
        com.calipso.reportgenerator.reportdefinitions.Rol[] mArray = new com.calipso.reportgenerator.reportdefinitions.Rol[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.Rol) _rolList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.Rol[] getRol() 

    /**
     * Method getRolCount
     */
    public int getRolCount()
    {
        return _rolList.size();
    } //-- int getRolCount() 

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllRol
     */
    public void removeAllRol()
    {
        _rolList.removeAllElements();
    } //-- void removeAllRol() 

    /**
     * Method removeRol
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Rol removeRol(int index)
    {
        java.lang.Object obj = _rolList.elementAt(index);
        _rolList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.Rol) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.Rol removeRol(int) 

    /**
     * Method setRol
     * 
     * @param index
     * @param vRol
     */
    public void setRol(int index, com.calipso.reportgenerator.reportdefinitions.Rol vRol)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rolList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _rolList.setElementAt(vRol, index);
    } //-- void setRol(int, com.calipso.reportgenerator.reportdefinitions.Rol) 

    /**
     * Method setRol
     * 
     * @param rolArray
     */
    public void setRol(com.calipso.reportgenerator.reportdefinitions.Rol[] rolArray)
    {
        //-- copy array
        _rolList.removeAllElements();
        for (int i = 0; i < rolArray.length; i++) {
            _rolList.addElement(rolArray[i]);
        }
    } //-- void setRol(com.calipso.reportgenerator.reportdefinitions.Rol) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.Roles unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.Roles) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.Roles.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.Roles unmarshal(java.io.Reader) 

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
