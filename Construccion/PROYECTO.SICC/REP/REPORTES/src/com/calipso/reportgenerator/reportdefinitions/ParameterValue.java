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

import com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType;
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
 * Class ParameterValue.
 * 
 * @version $Revision$ $Date$
 */
public class ParameterValue implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _defaultValue
     */
    private java.lang.String _defaultValue;

    /**
     * Field _filterDefinitionName
     */
    private java.lang.String _filterDefinitionName;

    /**
     * Field _filterParameter
     */
    private com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType _filterParameter;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterValue() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValue()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getDefaultValueReturns the value of field
     * 'defaultValue'.
     * 
     * @return the value of field 'defaultValue'.
     */
    public java.lang.String getDefaultValue()
    {
        return this._defaultValue;
    } //-- java.lang.String getDefaultValue() 

    /**
     * Method getFilterDefinitionNameReturns the value of field
     * 'filterDefinitionName'.
     * 
     * @return the value of field 'filterDefinitionName'.
     */
    public java.lang.String getFilterDefinitionName()
    {
        return this._filterDefinitionName;
    } //-- java.lang.String getFilterDefinitionName() 

    /**
     * Method getFilterParameterReturns the value of field
     * 'filterParameter'.
     * 
     * @return the value of field 'filterParameter'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType getFilterParameter()
    {
        return this._filterParameter;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType getFilterParameter() 

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
     * Method setDefaultValueSets the value of field
     * 'defaultValue'.
     * 
     * @param defaultValue the value of field 'defaultValue'.
     */
    public void setDefaultValue(java.lang.String defaultValue)
    {
        this._defaultValue = defaultValue;
    } //-- void setDefaultValue(java.lang.String) 

    /**
     * Method setFilterDefinitionNameSets the value of field
     * 'filterDefinitionName'.
     * 
     * @param filterDefinitionName the value of field
     * 'filterDefinitionName'.
     */
    public void setFilterDefinitionName(java.lang.String filterDefinitionName)
    {
        this._filterDefinitionName = filterDefinitionName;
    } //-- void setFilterDefinitionName(java.lang.String) 

    /**
     * Method setFilterParameterSets the value of field
     * 'filterParameter'.
     * 
     * @param filterParameter the value of field 'filterParameter'.
     */
    public void setFilterParameter(com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType filterParameter)
    {
        this._filterParameter = filterParameter;
    } //-- void setFilterParameter(com.calipso.reportgenerator.reportdefinitions.types.ParameterValueFilterParameterType) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ParameterValue unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ParameterValue) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ParameterValue.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValue unmarshal(java.io.Reader) 

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
