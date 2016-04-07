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
 * Class DimensionDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dimensionDefinitionList
     */
    private java.util.Vector _dimensionDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionDefinitions() {
        super();
        _dimensionDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDimensionDefinition
     * 
     * @param vDimensionDefinition
     */
    public void addDimensionDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionDefinition vDimensionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionDefinitionList.addElement(vDimensionDefinition);
    } //-- void addDimensionDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) 

    /**
     * Method addDimensionDefinition
     * 
     * @param index
     * @param vDimensionDefinition
     */
    public void addDimensionDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DimensionDefinition vDimensionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionDefinitionList.insertElementAt(vDimensionDefinition, index);
    } //-- void addDimensionDefinition(int, com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) 

    /**
     * Method enumerateDimensionDefinition
     */
    public java.util.Enumeration enumerateDimensionDefinition()
    {
        return _dimensionDefinitionList.elements();
    } //-- java.util.Enumeration enumerateDimensionDefinition() 

    /**
     * Method getDimensionDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionDefinition getDimensionDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) _dimensionDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinition getDimensionDefinition(int) 

    /**
     * Method getDimensionDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionDefinition[] getDimensionDefinition()
    {
        int size = _dimensionDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.DimensionDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.DimensionDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) _dimensionDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinition[] getDimensionDefinition() 

    /**
     * Method getDimensionDefinitionCount
     */
    public int getDimensionDefinitionCount()
    {
        return _dimensionDefinitionList.size();
    } //-- int getDimensionDefinitionCount() 

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
     * Method removeAllDimensionDefinition
     */
    public void removeAllDimensionDefinition()
    {
        _dimensionDefinitionList.removeAllElements();
    } //-- void removeAllDimensionDefinition() 

    /**
     * Method removeDimensionDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionDefinition removeDimensionDefinition(int index)
    {
        java.lang.Object obj = _dimensionDefinitionList.elementAt(index);
        _dimensionDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinition removeDimensionDefinition(int) 

    /**
     * Method setDimensionDefinition
     * 
     * @param index
     * @param vDimensionDefinition
     */
    public void setDimensionDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DimensionDefinition vDimensionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _dimensionDefinitionList.setElementAt(vDimensionDefinition, index);
    } //-- void setDimensionDefinition(int, com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) 

    /**
     * Method setDimensionDefinition
     * 
     * @param dimensionDefinitionArray
     */
    public void setDimensionDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionDefinition[] dimensionDefinitionArray)
    {
        //-- copy array
        _dimensionDefinitionList.removeAllElements();
        for (int i = 0; i < dimensionDefinitionArray.length; i++) {
            _dimensionDefinitionList.addElement(dimensionDefinitionArray[i]);
        }
    } //-- void setDimensionDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions unmarshal(java.io.Reader) 

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
