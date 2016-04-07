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
 * Class ParameterValues.
 * 
 * @version $Revision$ $Date$
 */
public class ParameterValues implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameterValueList
     */
    private java.util.Vector _parameterValueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterValues() {
        super();
        _parameterValueList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValues()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addParameterValue
     * 
     * @param vParameterValue
     */
    public void addParameterValue(com.calipso.reportgenerator.reportdefinitions.ParameterValue vParameterValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterValueList.addElement(vParameterValue);
    } //-- void addParameterValue(com.calipso.reportgenerator.reportdefinitions.ParameterValue) 

    /**
     * Method addParameterValue
     * 
     * @param index
     * @param vParameterValue
     */
    public void addParameterValue(int index, com.calipso.reportgenerator.reportdefinitions.ParameterValue vParameterValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterValueList.insertElementAt(vParameterValue, index);
    } //-- void addParameterValue(int, com.calipso.reportgenerator.reportdefinitions.ParameterValue) 

    /**
     * Method enumerateParameterValue
     */
    public java.util.Enumeration enumerateParameterValue()
    {
        return _parameterValueList.elements();
    } //-- java.util.Enumeration enumerateParameterValue() 

    /**
     * Method getParameterValue
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterValue getParameterValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.ParameterValue) _parameterValueList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValue getParameterValue(int) 

    /**
     * Method getParameterValue
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterValue[] getParameterValue()
    {
        int size = _parameterValueList.size();
        com.calipso.reportgenerator.reportdefinitions.ParameterValue[] mArray = new com.calipso.reportgenerator.reportdefinitions.ParameterValue[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.ParameterValue) _parameterValueList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValue[] getParameterValue() 

    /**
     * Method getParameterValueCount
     */
    public int getParameterValueCount()
    {
        return _parameterValueList.size();
    } //-- int getParameterValueCount() 

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
     * Method removeAllParameterValue
     */
    public void removeAllParameterValue()
    {
        _parameterValueList.removeAllElements();
    } //-- void removeAllParameterValue() 

    /**
     * Method removeParameterValue
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterValue removeParameterValue(int index)
    {
        java.lang.Object obj = _parameterValueList.elementAt(index);
        _parameterValueList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.ParameterValue) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValue removeParameterValue(int) 

    /**
     * Method setParameterValue
     * 
     * @param index
     * @param vParameterValue
     */
    public void setParameterValue(int index, com.calipso.reportgenerator.reportdefinitions.ParameterValue vParameterValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameterValueList.setElementAt(vParameterValue, index);
    } //-- void setParameterValue(int, com.calipso.reportgenerator.reportdefinitions.ParameterValue) 

    /**
     * Method setParameterValue
     * 
     * @param parameterValueArray
     */
    public void setParameterValue(com.calipso.reportgenerator.reportdefinitions.ParameterValue[] parameterValueArray)
    {
        //-- copy array
        _parameterValueList.removeAllElements();
        for (int i = 0; i < parameterValueArray.length; i++) {
            _parameterValueList.addElement(parameterValueArray[i]);
        }
    } //-- void setParameterValue(com.calipso.reportgenerator.reportdefinitions.ParameterValue) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ParameterValues unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ParameterValues) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ParameterValues.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValues unmarshal(java.io.Reader) 

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
