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
 * Class FilterDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class FilterDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _filterDefinitionList
     */
    private java.util.Vector _filterDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FilterDefinitions() {
        super();
        _filterDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFilterDefinition
     * 
     * @param vFilterDefinition
     */
    public void addFilterDefinition(com.calipso.reportgenerator.reportdefinitions.FilterDefinition vFilterDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _filterDefinitionList.addElement(vFilterDefinition);
    } //-- void addFilterDefinition(com.calipso.reportgenerator.reportdefinitions.FilterDefinition) 

    /**
     * Method addFilterDefinition
     * 
     * @param index
     * @param vFilterDefinition
     */
    public void addFilterDefinition(int index, com.calipso.reportgenerator.reportdefinitions.FilterDefinition vFilterDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _filterDefinitionList.insertElementAt(vFilterDefinition, index);
    } //-- void addFilterDefinition(int, com.calipso.reportgenerator.reportdefinitions.FilterDefinition) 

    /**
     * Method enumerateFilterDefinition
     */
    public java.util.Enumeration enumerateFilterDefinition()
    {
        return _filterDefinitionList.elements();
    } //-- java.util.Enumeration enumerateFilterDefinition() 

    /**
     * Method getFilterDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.FilterDefinition getFilterDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _filterDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.FilterDefinition) _filterDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinition getFilterDefinition(int) 

    /**
     * Method getFilterDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.FilterDefinition[] getFilterDefinition()
    {
        int size = _filterDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.FilterDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.FilterDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.FilterDefinition) _filterDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinition[] getFilterDefinition() 

    /**
     * Method getFilterDefinitionCount
     */
    public int getFilterDefinitionCount()
    {
        return _filterDefinitionList.size();
    } //-- int getFilterDefinitionCount() 

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
     * Method removeAllFilterDefinition
     */
    public void removeAllFilterDefinition()
    {
        _filterDefinitionList.removeAllElements();
    } //-- void removeAllFilterDefinition() 

    /**
     * Method removeFilterDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.FilterDefinition removeFilterDefinition(int index)
    {
        java.lang.Object obj = _filterDefinitionList.elementAt(index);
        _filterDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.FilterDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinition removeFilterDefinition(int) 

    /**
     * Method setFilterDefinition
     * 
     * @param index
     * @param vFilterDefinition
     */
    public void setFilterDefinition(int index, com.calipso.reportgenerator.reportdefinitions.FilterDefinition vFilterDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _filterDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _filterDefinitionList.setElementAt(vFilterDefinition, index);
    } //-- void setFilterDefinition(int, com.calipso.reportgenerator.reportdefinitions.FilterDefinition) 

    /**
     * Method setFilterDefinition
     * 
     * @param filterDefinitionArray
     */
    public void setFilterDefinition(com.calipso.reportgenerator.reportdefinitions.FilterDefinition[] filterDefinitionArray)
    {
        //-- copy array
        _filterDefinitionList.removeAllElements();
        for (int i = 0; i < filterDefinitionArray.length; i++) {
            _filterDefinitionList.addElement(filterDefinitionArray[i]);
        }
    } //-- void setFilterDefinition(com.calipso.reportgenerator.reportdefinitions.FilterDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.FilterDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.FilterDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.FilterDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinitions unmarshal(java.io.Reader) 

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
