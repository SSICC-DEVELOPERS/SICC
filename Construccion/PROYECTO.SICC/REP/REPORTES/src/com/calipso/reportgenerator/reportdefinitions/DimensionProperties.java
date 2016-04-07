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
 * Class DimensionProperties.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dimensionPropertyList
     */
    private java.util.Vector _dimensionPropertyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionProperties() {
        super();
        _dimensionPropertyList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperties()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDimensionProperty
     * 
     * @param vDimensionProperty
     */
    public void addDimensionProperty(com.calipso.reportgenerator.reportdefinitions.DimensionProperty vDimensionProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionPropertyList.addElement(vDimensionProperty);
    } //-- void addDimensionProperty(com.calipso.reportgenerator.reportdefinitions.DimensionProperty) 

    /**
     * Method addDimensionProperty
     * 
     * @param index
     * @param vDimensionProperty
     */
    public void addDimensionProperty(int index, com.calipso.reportgenerator.reportdefinitions.DimensionProperty vDimensionProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionPropertyList.insertElementAt(vDimensionProperty, index);
    } //-- void addDimensionProperty(int, com.calipso.reportgenerator.reportdefinitions.DimensionProperty) 

    /**
     * Method enumerateDimensionProperty
     */
    public java.util.Enumeration enumerateDimensionProperty()
    {
        return _dimensionPropertyList.elements();
    } //-- java.util.Enumeration enumerateDimensionProperty() 

    /**
     * Method getDimensionProperty
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionProperty getDimensionProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DimensionProperty) _dimensionPropertyList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperty getDimensionProperty(int) 

    /**
     * Method getDimensionProperty
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionProperty[] getDimensionProperty()
    {
        int size = _dimensionPropertyList.size();
        com.calipso.reportgenerator.reportdefinitions.DimensionProperty[] mArray = new com.calipso.reportgenerator.reportdefinitions.DimensionProperty[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DimensionProperty) _dimensionPropertyList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperty[] getDimensionProperty() 

    /**
     * Method getDimensionPropertyCount
     */
    public int getDimensionPropertyCount()
    {
        return _dimensionPropertyList.size();
    } //-- int getDimensionPropertyCount() 

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
     * Method removeAllDimensionProperty
     */
    public void removeAllDimensionProperty()
    {
        _dimensionPropertyList.removeAllElements();
    } //-- void removeAllDimensionProperty() 

    /**
     * Method removeDimensionProperty
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionProperty removeDimensionProperty(int index)
    {
        java.lang.Object obj = _dimensionPropertyList.elementAt(index);
        _dimensionPropertyList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DimensionProperty) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperty removeDimensionProperty(int) 

    /**
     * Method setDimensionProperty
     * 
     * @param index
     * @param vDimensionProperty
     */
    public void setDimensionProperty(int index, com.calipso.reportgenerator.reportdefinitions.DimensionProperty vDimensionProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _dimensionPropertyList.setElementAt(vDimensionProperty, index);
    } //-- void setDimensionProperty(int, com.calipso.reportgenerator.reportdefinitions.DimensionProperty) 

    /**
     * Method setDimensionProperty
     * 
     * @param dimensionPropertyArray
     */
    public void setDimensionProperty(com.calipso.reportgenerator.reportdefinitions.DimensionProperty[] dimensionPropertyArray)
    {
        //-- copy array
        _dimensionPropertyList.removeAllElements();
        for (int i = 0; i < dimensionPropertyArray.length; i++) {
            _dimensionPropertyList.addElement(dimensionPropertyArray[i]);
        }
    } //-- void setDimensionProperty(com.calipso.reportgenerator.reportdefinitions.DimensionProperty) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DimensionProperties unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionProperties) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionProperties.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperties unmarshal(java.io.Reader) 

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
