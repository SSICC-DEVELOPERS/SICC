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
 * Class MetricProperties.
 * 
 * @version $Revision$ $Date$
 */
public class MetricProperties implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metricPropertyList
     */
    private java.util.Vector _metricPropertyList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricProperties() {
        super();
        _metricPropertyList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperties()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMetricProperty
     * 
     * @param vMetricProperty
     */
    public void addMetricProperty(com.calipso.reportgenerator.reportdefinitions.MetricProperty vMetricProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricPropertyList.addElement(vMetricProperty);
    } //-- void addMetricProperty(com.calipso.reportgenerator.reportdefinitions.MetricProperty) 

    /**
     * Method addMetricProperty
     * 
     * @param index
     * @param vMetricProperty
     */
    public void addMetricProperty(int index, com.calipso.reportgenerator.reportdefinitions.MetricProperty vMetricProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricPropertyList.insertElementAt(vMetricProperty, index);
    } //-- void addMetricProperty(int, com.calipso.reportgenerator.reportdefinitions.MetricProperty) 

    /**
     * Method enumerateMetricProperty
     */
    public java.util.Enumeration enumerateMetricProperty()
    {
        return _metricPropertyList.elements();
    } //-- java.util.Enumeration enumerateMetricProperty() 

    /**
     * Method getMetricProperty
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricProperty getMetricProperty(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.MetricProperty) _metricPropertyList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperty getMetricProperty(int) 

    /**
     * Method getMetricProperty
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricProperty[] getMetricProperty()
    {
        int size = _metricPropertyList.size();
        com.calipso.reportgenerator.reportdefinitions.MetricProperty[] mArray = new com.calipso.reportgenerator.reportdefinitions.MetricProperty[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.MetricProperty) _metricPropertyList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperty[] getMetricProperty() 

    /**
     * Method getMetricPropertyCount
     */
    public int getMetricPropertyCount()
    {
        return _metricPropertyList.size();
    } //-- int getMetricPropertyCount() 

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
     * Method removeAllMetricProperty
     */
    public void removeAllMetricProperty()
    {
        _metricPropertyList.removeAllElements();
    } //-- void removeAllMetricProperty() 

    /**
     * Method removeMetricProperty
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricProperty removeMetricProperty(int index)
    {
        java.lang.Object obj = _metricPropertyList.elementAt(index);
        _metricPropertyList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.MetricProperty) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperty removeMetricProperty(int) 

    /**
     * Method setMetricProperty
     * 
     * @param index
     * @param vMetricProperty
     */
    public void setMetricProperty(int index, com.calipso.reportgenerator.reportdefinitions.MetricProperty vMetricProperty)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricPropertyList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metricPropertyList.setElementAt(vMetricProperty, index);
    } //-- void setMetricProperty(int, com.calipso.reportgenerator.reportdefinitions.MetricProperty) 

    /**
     * Method setMetricProperty
     * 
     * @param metricPropertyArray
     */
    public void setMetricProperty(com.calipso.reportgenerator.reportdefinitions.MetricProperty[] metricPropertyArray)
    {
        //-- copy array
        _metricPropertyList.removeAllElements();
        for (int i = 0; i < metricPropertyArray.length; i++) {
            _metricPropertyList.addElement(metricPropertyArray[i]);
        }
    } //-- void setMetricProperty(com.calipso.reportgenerator.reportdefinitions.MetricProperty) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.MetricProperties unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricProperties) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricProperties.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperties unmarshal(java.io.Reader) 

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
