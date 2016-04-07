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
 * Class MetricDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class MetricDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metricDefinitionList
     */
    private java.util.Vector _metricDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricDefinitions() {
        super();
        _metricDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMetricDefinition
     * 
     * @param vMetricDefinition
     */
    public void addMetricDefinition(com.calipso.reportgenerator.reportdefinitions.MetricDefinition vMetricDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricDefinitionList.addElement(vMetricDefinition);
    } //-- void addMetricDefinition(com.calipso.reportgenerator.reportdefinitions.MetricDefinition) 

    /**
     * Method addMetricDefinition
     * 
     * @param index
     * @param vMetricDefinition
     */
    public void addMetricDefinition(int index, com.calipso.reportgenerator.reportdefinitions.MetricDefinition vMetricDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricDefinitionList.insertElementAt(vMetricDefinition, index);
    } //-- void addMetricDefinition(int, com.calipso.reportgenerator.reportdefinitions.MetricDefinition) 

    /**
     * Method enumerateMetricDefinition
     */
    public java.util.Enumeration enumerateMetricDefinition()
    {
        return _metricDefinitionList.elements();
    } //-- java.util.Enumeration enumerateMetricDefinition() 

    /**
     * Method getMetricDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricDefinition getMetricDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.MetricDefinition) _metricDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinition getMetricDefinition(int) 

    /**
     * Method getMetricDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricDefinition[] getMetricDefinition()
    {
        int size = _metricDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.MetricDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.MetricDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.MetricDefinition) _metricDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinition[] getMetricDefinition() 

    /**
     * Method getMetricDefinitionCount
     */
    public int getMetricDefinitionCount()
    {
        return _metricDefinitionList.size();
    } //-- int getMetricDefinitionCount() 

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
     * Method removeAllMetricDefinition
     */
    public void removeAllMetricDefinition()
    {
        _metricDefinitionList.removeAllElements();
    } //-- void removeAllMetricDefinition() 

    /**
     * Method removeMetricDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricDefinition removeMetricDefinition(int index)
    {
        java.lang.Object obj = _metricDefinitionList.elementAt(index);
        _metricDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.MetricDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinition removeMetricDefinition(int) 

    /**
     * Method setMetricDefinition
     * 
     * @param index
     * @param vMetricDefinition
     */
    public void setMetricDefinition(int index, com.calipso.reportgenerator.reportdefinitions.MetricDefinition vMetricDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metricDefinitionList.setElementAt(vMetricDefinition, index);
    } //-- void setMetricDefinition(int, com.calipso.reportgenerator.reportdefinitions.MetricDefinition) 

    /**
     * Method setMetricDefinition
     * 
     * @param metricDefinitionArray
     */
    public void setMetricDefinition(com.calipso.reportgenerator.reportdefinitions.MetricDefinition[] metricDefinitionArray)
    {
        //-- copy array
        _metricDefinitionList.removeAllElements();
        for (int i = 0; i < metricDefinitionArray.length; i++) {
            _metricDefinitionList.addElement(metricDefinitionArray[i]);
        }
    } //-- void setMetricDefinition(com.calipso.reportgenerator.reportdefinitions.MetricDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.MetricDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinitions unmarshal(java.io.Reader) 

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
