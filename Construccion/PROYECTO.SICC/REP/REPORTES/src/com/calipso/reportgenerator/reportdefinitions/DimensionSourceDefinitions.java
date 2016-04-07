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
 * Class DimensionSourceDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionSourceDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dimensionSourceDefinitionList
     */
    private java.util.Vector _dimensionSourceDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionSourceDefinitions() {
        super();
        _dimensionSourceDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDimensionSourceDefinition
     * 
     * @param vDimensionSourceDefinition
     */
    public void addDimensionSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition vDimensionSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionSourceDefinitionList.addElement(vDimensionSourceDefinition);
    } //-- void addDimensionSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) 

    /**
     * Method addDimensionSourceDefinition
     * 
     * @param index
     * @param vDimensionSourceDefinition
     */
    public void addDimensionSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition vDimensionSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionSourceDefinitionList.insertElementAt(vDimensionSourceDefinition, index);
    } //-- void addDimensionSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) 

    /**
     * Method enumerateDimensionSourceDefinition
     */
    public java.util.Enumeration enumerateDimensionSourceDefinition()
    {
        return _dimensionSourceDefinitionList.elements();
    } //-- java.util.Enumeration enumerateDimensionSourceDefinition() 

    /**
     * Method getDimensionSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition getDimensionSourceDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) _dimensionSourceDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition getDimensionSourceDefinition(int) 

    /**
     * Method getDimensionSourceDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition[] getDimensionSourceDefinition()
    {
        int size = _dimensionSourceDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) _dimensionSourceDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition[] getDimensionSourceDefinition() 

    /**
     * Method getDimensionSourceDefinitionCount
     */
    public int getDimensionSourceDefinitionCount()
    {
        return _dimensionSourceDefinitionList.size();
    } //-- int getDimensionSourceDefinitionCount() 

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
     * Method removeAllDimensionSourceDefinition
     */
    public void removeAllDimensionSourceDefinition()
    {
        _dimensionSourceDefinitionList.removeAllElements();
    } //-- void removeAllDimensionSourceDefinition() 

    /**
     * Method removeDimensionSourceDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition removeDimensionSourceDefinition(int index)
    {
        java.lang.Object obj = _dimensionSourceDefinitionList.elementAt(index);
        _dimensionSourceDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition removeDimensionSourceDefinition(int) 

    /**
     * Method setDimensionSourceDefinition
     * 
     * @param index
     * @param vDimensionSourceDefinition
     */
    public void setDimensionSourceDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition vDimensionSourceDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionSourceDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _dimensionSourceDefinitionList.setElementAt(vDimensionSourceDefinition, index);
    } //-- void setDimensionSourceDefinition(int, com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) 

    /**
     * Method setDimensionSourceDefinition
     * 
     * @param dimensionSourceDefinitionArray
     */
    public void setDimensionSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition[] dimensionSourceDefinitionArray)
    {
        //-- copy array
        _dimensionSourceDefinitionList.removeAllElements();
        for (int i = 0; i < dimensionSourceDefinitionArray.length; i++) {
            _dimensionSourceDefinitionList.addElement(dimensionSourceDefinitionArray[i]);
        }
    } //-- void setDimensionSourceDefinition(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions unmarshal(java.io.Reader) 

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
