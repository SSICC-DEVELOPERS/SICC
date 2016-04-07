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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class MetricDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class MetricDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _description
     */
    private java.lang.String _description;

    /**
     * Field _visible
     */
    private boolean _visible;

    /**
     * keeps track of state for field: _visible
     */
    private boolean _has_visible;

    /**
     * Field _accumulable
     */
    private boolean _accumulable;

    /**
     * keeps track of state for field: _accumulable
     */
    private boolean _has_accumulable;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteAccumulable
     */
    public void deleteAccumulable()
    {
        this._has_accumulable= false;
    } //-- void deleteAccumulable() 

    /**
     * Method getAccumulableReturns the value of field
     * 'accumulable'.
     * 
     * @return the value of field 'accumulable'.
     */
    public boolean getAccumulable()
    {
        return this._accumulable;
    } //-- boolean getAccumulable() 

    /**
     * Method getDescriptionReturns the value of field
     * 'description'.
     * 
     * @return the value of field 'description'.
     */
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Method getNameReturns the value of field 'name'.
     * 
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getVisibleReturns the value of field 'visible'.
     * 
     * @return the value of field 'visible'.
     */
    public boolean getVisible()
    {
        return this._visible;
    } //-- boolean getVisible() 

    /**
     * Method hasAccumulable
     */
    public boolean hasAccumulable()
    {
        return this._has_accumulable;
    } //-- boolean hasAccumulable() 

    /**
     * Method hasVisible
     */
    public boolean hasVisible()
    {
        return this._has_visible;
    } //-- boolean hasVisible() 

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
     * Method setAccumulableSets the value of field 'accumulable'.
     * 
     * @param accumulable the value of field 'accumulable'.
     */
    public void setAccumulable(boolean accumulable)
    {
        this._accumulable = accumulable;
        this._has_accumulable = true;
    } //-- void setAccumulable(boolean) 

    /**
     * Method setDescriptionSets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Method setNameSets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method setVisibleSets the value of field 'visible'.
     * 
     * @param visible the value of field 'visible'.
     */
    public void setVisible(boolean visible)
    {
        this._visible = visible;
        this._has_visible = true;
    } //-- void setVisible(boolean) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.MetricDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinition unmarshal(java.io.Reader) 

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
