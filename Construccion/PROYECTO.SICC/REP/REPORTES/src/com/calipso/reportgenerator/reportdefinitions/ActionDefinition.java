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
 * Class ActionDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ActionDefinition implements java.io.Serializable {


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
     * Field _expression
     */
    private java.lang.String _expression;

    /**
     * Field _metric
     */
    private java.lang.String _metric;


      //----------------/
     //- Constructors -/
    //----------------/

    public ActionDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinition()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method getExpressionReturns the value of field 'expression'.
     * 
     * @return the value of field 'expression'.
     */
    public java.lang.String getExpression()
    {
        return this._expression;
    } //-- java.lang.String getExpression() 

    /**
     * Method getMetricReturns the value of field 'metric'.
     * 
     * @return the value of field 'metric'.
     */
    public java.lang.String getMetric()
    {
        return this._metric;
    } //-- java.lang.String getMetric() 

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
     * Method setDescriptionSets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Method setExpressionSets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(java.lang.String expression)
    {
        this._expression = expression;
    } //-- void setExpression(java.lang.String) 

    /**
     * Method setMetricSets the value of field 'metric'.
     * 
     * @param metric the value of field 'metric'.
     */
    public void setMetric(java.lang.String metric)
    {
        this._metric = metric;
    } //-- void setMetric(java.lang.String) 

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
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ActionDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ActionDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ActionDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinition unmarshal(java.io.Reader) 

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
