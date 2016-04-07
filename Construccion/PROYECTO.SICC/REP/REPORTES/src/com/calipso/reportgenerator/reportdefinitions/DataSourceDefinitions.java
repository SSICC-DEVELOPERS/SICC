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
 * Class DataSourceDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class DataSourceDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dataSourceDefinitionList
     */
    private java.util.Vector _dataSourceDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataSourceDefinitions() {
        super();
        _dataSourceDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDataSourceDefinition
     * 
     * @param vDataSourceDefinition
     */
    public void addDataSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition vDataSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dataSourceDefinitionList.addElement(vDataSourceDefinition);
    } //-- void addDataSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) 

    /**
     * Method addDataSourceDefinition
     * 
     * @param index
     * @param vDataSourceDefinition
     */
    public void addDataSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition vDataSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dataSourceDefinitionList.insertElementAt(vDataSourceDefinition, index);
    } //-- void addDataSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) 

    /**
     * Method enumerateDataSourceDefinition
     */
    public java.util.Enumeration enumerateDataSourceDefinition()
    {
        return _dataSourceDefinitionList.elements();
    } //-- java.util.Enumeration enumerateDataSourceDefinition() 

    /**
     * Method getDataSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition getDataSourceDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dataSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) _dataSourceDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition getDataSourceDefinition(int) 

    /**
     * Method getDataSourceDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition[] getDataSourceDefinition()
    {
        int size = _dataSourceDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) _dataSourceDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition[] getDataSourceDefinition() 

    /**
     * Method getDataSourceDefinitionCount
     */
    public int getDataSourceDefinitionCount()
    {
        return _dataSourceDefinitionList.size();
    } //-- int getDataSourceDefinitionCount() 

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
     * Method removeAllDataSourceDefinition
     */
    public void removeAllDataSourceDefinition()
    {
        _dataSourceDefinitionList.removeAllElements();
    } //-- void removeAllDataSourceDefinition() 

    /**
     * Method removeDataSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition removeDataSourceDefinition(int index)
    {
        java.lang.Object obj = _dataSourceDefinitionList.elementAt(index);
        _dataSourceDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition removeDataSourceDefinition(int) 

    /**
     * Method setDataSourceDefinition
     * 
     * @param index
     * @param vDataSourceDefinition
     */
    public void setDataSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition vDataSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dataSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _dataSourceDefinitionList.setElementAt(vDataSourceDefinition, index);
    } //-- void setDataSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) 

    /**
     * Method setDataSourceDefinition
     * 
     * @param dataSourceDefinitionArray
     */
    public void setDataSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition[] dataSourceDefinitionArray)
    {
        //-- copy array
        _dataSourceDefinitionList.removeAllElements();
        for (int i = 0; i < dataSourceDefinitionArray.length; i++) {
            _dataSourceDefinitionList.addElement(dataSourceDefinitionArray[i]);
        }
    } //-- void setDataSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions unmarshal(java.io.Reader) 

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
