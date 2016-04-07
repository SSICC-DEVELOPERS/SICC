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
 * Class ActionDefinitions.
 * 
 * @version $Revision$ $Date$
 */
public class ActionDefinitions implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _actionDefinitionList
     */
    private java.util.Vector _actionDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ActionDefinitions() {
        super();
        _actionDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinitions()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addActionDefinition
     * 
     * @param vActionDefinition
     */
    public void addActionDefinition(com.calipso.reportgenerator.reportdefinitions.ActionDefinition vActionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _actionDefinitionList.addElement(vActionDefinition);
    } //-- void addActionDefinition(com.calipso.reportgenerator.reportdefinitions.ActionDefinition) 

    /**
     * Method addActionDefinition
     * 
     * @param index
     * @param vActionDefinition
     */
    public void addActionDefinition(int index, com.calipso.reportgenerator.reportdefinitions.ActionDefinition vActionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _actionDefinitionList.insertElementAt(vActionDefinition, index);
    } //-- void addActionDefinition(int, com.calipso.reportgenerator.reportdefinitions.ActionDefinition) 

    /**
     * Method enumerateActionDefinition
     */
    public java.util.Enumeration enumerateActionDefinition()
    {
        return _actionDefinitionList.elements();
    } //-- java.util.Enumeration enumerateActionDefinition() 

    /**
     * Method getActionDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ActionDefinition getActionDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _actionDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.ActionDefinition) _actionDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinition getActionDefinition(int) 

    /**
     * Method getActionDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.ActionDefinition[] getActionDefinition()
    {
        int size = _actionDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.ActionDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.ActionDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.ActionDefinition) _actionDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinition[] getActionDefinition() 

    /**
     * Method getActionDefinitionCount
     */
    public int getActionDefinitionCount()
    {
        return _actionDefinitionList.size();
    } //-- int getActionDefinitionCount() 

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
     * Method removeActionDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ActionDefinition removeActionDefinition(int index)
    {
        java.lang.Object obj = _actionDefinitionList.elementAt(index);
        _actionDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.ActionDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinition removeActionDefinition(int) 

    /**
     * Method removeAllActionDefinition
     */
    public void removeAllActionDefinition()
    {
        _actionDefinitionList.removeAllElements();
    } //-- void removeAllActionDefinition() 

    /**
     * Method setActionDefinition
     * 
     * @param index
     * @param vActionDefinition
     */
    public void setActionDefinition(int index, com.calipso.reportgenerator.reportdefinitions.ActionDefinition vActionDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _actionDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _actionDefinitionList.setElementAt(vActionDefinition, index);
    } //-- void setActionDefinition(int, com.calipso.reportgenerator.reportdefinitions.ActionDefinition) 

    /**
     * Method setActionDefinition
     * 
     * @param actionDefinitionArray
     */
    public void setActionDefinition(com.calipso.reportgenerator.reportdefinitions.ActionDefinition[] actionDefinitionArray)
    {
        //-- copy array
        _actionDefinitionList.removeAllElements();
        for (int i = 0; i < actionDefinitionArray.length; i++) {
            _actionDefinitionList.addElement(actionDefinitionArray[i]);
        }
    } //-- void setActionDefinition(com.calipso.reportgenerator.reportdefinitions.ActionDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ActionDefinitions unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ActionDefinitions) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ActionDefinitions.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinitions unmarshal(java.io.Reader) 

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
