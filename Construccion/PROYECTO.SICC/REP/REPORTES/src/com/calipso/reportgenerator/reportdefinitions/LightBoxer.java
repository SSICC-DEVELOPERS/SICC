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
 * Class LightBoxer.
 * 
 * @version $Revision$ $Date$
 */
public class LightBoxer implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _lightBoxDefinitionList
     */
    private java.util.Vector _lightBoxDefinitionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LightBoxer() {
        super();
        _lightBoxDefinitionList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxer()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLightBoxDefinition
     * 
     * @param vLightBoxDefinition
     */
    public void addLightBoxDefinition(com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition vLightBoxDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _lightBoxDefinitionList.addElement(vLightBoxDefinition);
    } //-- void addLightBoxDefinition(com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) 

    /**
     * Method addLightBoxDefinition
     * 
     * @param index
     * @param vLightBoxDefinition
     */
    public void addLightBoxDefinition(int index, com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition vLightBoxDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        _lightBoxDefinitionList.insertElementAt(vLightBoxDefinition, index);
    } //-- void addLightBoxDefinition(int, com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) 

    /**
     * Method enumerateLightBoxDefinition
     */
    public java.util.Enumeration enumerateLightBoxDefinition()
    {
        return _lightBoxDefinitionList.elements();
    } //-- java.util.Enumeration enumerateLightBoxDefinition() 

    /**
     * Method getLightBoxDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition getLightBoxDefinition(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _lightBoxDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) _lightBoxDefinitionList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition getLightBoxDefinition(int) 

    /**
     * Method getLightBoxDefinition
     */
    public com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition[] getLightBoxDefinition()
    {
        int size = _lightBoxDefinitionList.size();
        com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition[] mArray = new com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) _lightBoxDefinitionList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition[] getLightBoxDefinition() 

    /**
     * Method getLightBoxDefinitionCount
     */
    public int getLightBoxDefinitionCount()
    {
        return _lightBoxDefinitionList.size();
    } //-- int getLightBoxDefinitionCount() 

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
     * Method removeAllLightBoxDefinition
     */
    public void removeAllLightBoxDefinition()
    {
        _lightBoxDefinitionList.removeAllElements();
    } //-- void removeAllLightBoxDefinition() 

    /**
     * Method removeLightBoxDefinition
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition removeLightBoxDefinition(int index)
    {
        java.lang.Object obj = _lightBoxDefinitionList.elementAt(index);
        _lightBoxDefinitionList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition removeLightBoxDefinition(int) 

    /**
     * Method setLightBoxDefinition
     * 
     * @param index
     * @param vLightBoxDefinition
     */
    public void setLightBoxDefinition(int index, com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition vLightBoxDefinition)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _lightBoxDefinitionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _lightBoxDefinitionList.setElementAt(vLightBoxDefinition, index);
    } //-- void setLightBoxDefinition(int, com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) 

    /**
     * Method setLightBoxDefinition
     * 
     * @param lightBoxDefinitionArray
     */
    public void setLightBoxDefinition(com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition[] lightBoxDefinitionArray)
    {
        //-- copy array
        _lightBoxDefinitionList.removeAllElements();
        for (int i = 0; i < lightBoxDefinitionArray.length; i++) {
            _lightBoxDefinitionList.addElement(lightBoxDefinitionArray[i]);
        }
    } //-- void setLightBoxDefinition(com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.LightBoxer unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.LightBoxer) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.LightBoxer.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxer unmarshal(java.io.Reader) 

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
