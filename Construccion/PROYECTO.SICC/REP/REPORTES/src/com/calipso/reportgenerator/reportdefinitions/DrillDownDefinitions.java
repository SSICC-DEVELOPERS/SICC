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
 * Class DrillDownDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class DrillDownDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _drillDownDefinitionList
     */
    private java.util.Vector _drillDownDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DrillDownDefinitions() {
        super();
        _drillDownDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDrillDownDefinition
     * 
     * @param vDrillDownDefinition
     */
    public void addDrillDownDefinition(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition vDrillDownDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _drillDownDefinitionList.addElement(vDrillDownDefinition);
    } //-- void addDrillDownDefinition(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) 

    /**
     * Method addDrillDownDefinition
     * 
     * @param index
     * @param vDrillDownDefinition
     */
    public void addDrillDownDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition vDrillDownDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _drillDownDefinitionList.insertElementAt(vDrillDownDefinition, index);
    } //-- void addDrillDownDefinition(int, com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) 

    /**
     * Method enumerateDrillDownDefinition
     */
    public java.util.Enumeration enumerateDrillDownDefinition()
    {
        return _drillDownDefinitionList.elements();
    } //-- java.util.Enumeration enumerateDrillDownDefinition() 

    /**
     * Method getDrillDownDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition getDrillDownDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _drillDownDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) _drillDownDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition getDrillDownDefinition(int) 

    /**
     * Method getDrillDownDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition[] getDrillDownDefinition()
    {
        int size = _drillDownDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) _drillDownDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition[] getDrillDownDefinition() 

    /**
     * Method getDrillDownDefinitionCount
     */
    public int getDrillDownDefinitionCount()
    {
        return _drillDownDefinitionList.size();
    } //-- int getDrillDownDefinitionCount() 

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
     * Method removeAllDrillDownDefinition
     */
    public void removeAllDrillDownDefinition()
    {
        _drillDownDefinitionList.removeAllElements();
    } //-- void removeAllDrillDownDefinition() 

    /**
     * Method removeDrillDownDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition removeDrillDownDefinition(int index)
    {
        java.lang.Object obj = _drillDownDefinitionList.elementAt(index);
        _drillDownDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition removeDrillDownDefinition(int) 

    /**
     * Method setDrillDownDefinition
     * 
     * @param index
     * @param vDrillDownDefinition
     */
    public void setDrillDownDefinition(int index, com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition vDrillDownDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _drillDownDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _drillDownDefinitionList.setElementAt(vDrillDownDefinition, index);
    } //-- void setDrillDownDefinition(int, com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) 

    /**
     * Method setDrillDownDefinition
     * 
     * @param drillDownDefinitionArray
     */
    public void setDrillDownDefinition(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition[] drillDownDefinitionArray)
    {
        //-- copy array
        _drillDownDefinitionList.removeAllElements();
        for (int i = 0; i < drillDownDefinitionArray.length; i++) {
            _drillDownDefinitionList.addElement(drillDownDefinitionArray[i]);
        }
    } //-- void setDrillDownDefinition(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions unmarshal(java.io.Reader) 

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
