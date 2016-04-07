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
 * Class MetricSourceDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class MetricSourceDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metricSourceDefinitionList
     */
    private java.util.Vector _metricSourceDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricSourceDefinitions() {
        super();
        _metricSourceDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMetricSourceDefinition
     * 
     * @param vMetricSourceDefinition
     */
    public void addMetricSourceDefinition(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition vMetricSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricSourceDefinitionList.addElement(vMetricSourceDefinition);
    } //-- void addMetricSourceDefinition(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) 

    /**
     * Method addMetricSourceDefinition
     * 
     * @param index
     * @param vMetricSourceDefinition
     */
    public void addMetricSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition vMetricSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _metricSourceDefinitionList.insertElementAt(vMetricSourceDefinition, index);
    } //-- void addMetricSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) 

    /**
     * Method enumerateMetricSourceDefinition
     */
    public java.util.Enumeration enumerateMetricSourceDefinition()
    {
        return _metricSourceDefinitionList.elements();
    } //-- java.util.Enumeration enumerateMetricSourceDefinition() 

    /**
     * Method getMetricSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition getMetricSourceDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) _metricSourceDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition getMetricSourceDefinition(int) 

    /**
     * Method getMetricSourceDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition[] getMetricSourceDefinition()
    {
        int size = _metricSourceDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) _metricSourceDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition[] getMetricSourceDefinition() 

    /**
     * Method getMetricSourceDefinitionCount
     */
    public int getMetricSourceDefinitionCount()
    {
        return _metricSourceDefinitionList.size();
    } //-- int getMetricSourceDefinitionCount() 

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
     * Method removeAllMetricSourceDefinition
     */
    public void removeAllMetricSourceDefinition()
    {
        _metricSourceDefinitionList.removeAllElements();
    } //-- void removeAllMetricSourceDefinition() 

    /**
     * Method removeMetricSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition removeMetricSourceDefinition(int index)
    {
        java.lang.Object obj = _metricSourceDefinitionList.elementAt(index);
        _metricSourceDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition removeMetricSourceDefinition(int) 

    /**
     * Method setMetricSourceDefinition
     * 
     * @param index
     * @param vMetricSourceDefinition
     */
    public void setMetricSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition vMetricSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _metricSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _metricSourceDefinitionList.setElementAt(vMetricSourceDefinition, index);
    } //-- void setMetricSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) 

    /**
     * Method setMetricSourceDefinition
     * 
     * @param metricSourceDefinitionArray
     */
    public void setMetricSourceDefinition(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition[] metricSourceDefinitionArray)
    {
        //-- copy array
        _metricSourceDefinitionList.removeAllElements();
        for (int i = 0; i < metricSourceDefinitionArray.length; i++) {
            _metricSourceDefinitionList.addElement(metricSourceDefinitionArray[i]);
        }
    } //-- void setMetricSourceDefinition(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions unmarshal(java.io.Reader) 

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
