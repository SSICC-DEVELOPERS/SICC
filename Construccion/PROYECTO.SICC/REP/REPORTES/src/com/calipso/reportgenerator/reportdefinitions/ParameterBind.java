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
 * Class ParameterBind.
 * 
 * @version $Revision$ $Date$
 */
public class ParameterBind implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sourceFilterName
     */
    private java.lang.String _sourceFilterName;

    /**
     * Field _sourceParameterName
     */
    private java.lang.String _sourceParameterName;

    /**
     * Field _targetFilterName
     */
    private java.lang.String _targetFilterName;

    /**
     * Field _targetParameterName
     */
    private java.lang.String _targetParameterName;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParameterBind() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterBind()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getSourceFilterNameReturns the value of field
     * 'sourceFilterName'.
     * 
     * @return the value of field 'sourceFilterName'.
     */
    public java.lang.String getSourceFilterName()
    {
        return this._sourceFilterName;
    } //-- java.lang.String getSourceFilterName() 

    /**
     * Method getSourceParameterNameReturns the value of field
     * 'sourceParameterName'.
     * 
     * @return the value of field 'sourceParameterName'.
     */
    public java.lang.String getSourceParameterName()
    {
        return this._sourceParameterName;
    } //-- java.lang.String getSourceParameterName() 

    /**
     * Method getTargetFilterNameReturns the value of field
     * 'targetFilterName'.
     * 
     * @return the value of field 'targetFilterName'.
     */
    public java.lang.String getTargetFilterName()
    {
        return this._targetFilterName;
    } //-- java.lang.String getTargetFilterName() 

    /**
     * Method getTargetParameterNameReturns the value of field
     * 'targetParameterName'.
     * 
     * @return the value of field 'targetParameterName'.
     */
    public java.lang.String getTargetParameterName()
    {
        return this._targetParameterName;
    } //-- java.lang.String getTargetParameterName() 

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
     * Method setSourceFilterNameSets the value of field
     * 'sourceFilterName'.
     * 
     * @param sourceFilterName the value of field 'sourceFilterName'
     */
    public void setSourceFilterName(java.lang.String sourceFilterName)
    {
        this._sourceFilterName = sourceFilterName;
    } //-- void setSourceFilterName(java.lang.String) 

    /**
     * Method setSourceParameterNameSets the value of field
     * 'sourceParameterName'.
     * 
     * @param sourceParameterName the value of field
     * 'sourceParameterName'.
     */
    public void setSourceParameterName(java.lang.String sourceParameterName)
    {
        this._sourceParameterName = sourceParameterName;
    } //-- void setSourceParameterName(java.lang.String) 

    /**
     * Method setTargetFilterNameSets the value of field
     * 'targetFilterName'.
     * 
     * @param targetFilterName the value of field 'targetFilterName'
     */
    public void setTargetFilterName(java.lang.String targetFilterName)
    {
        this._targetFilterName = targetFilterName;
    } //-- void setTargetFilterName(java.lang.String) 

    /**
     * Method setTargetParameterNameSets the value of field
     * 'targetParameterName'.
     * 
     * @param targetParameterName the value of field
     * 'targetParameterName'.
     */
    public void setTargetParameterName(java.lang.String targetParameterName)
    {
        this._targetParameterName = targetParameterName;
    } //-- void setTargetParameterName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ParameterBind unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ParameterBind) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ParameterBind.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterBind unmarshal(java.io.Reader) 

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
