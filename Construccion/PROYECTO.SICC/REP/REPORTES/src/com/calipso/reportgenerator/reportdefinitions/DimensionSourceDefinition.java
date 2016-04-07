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

import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;
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
 * Class DimensionSourceDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionSourceDefinition implements java.io.Serializable {


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
     * Field _dataType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.ReportDataType _dataType;

    /**
     * Field _calculated
     */
    private boolean _calculated;

    /**
     * keeps track of state for field: _calculated
     */
    private boolean _has_calculated;

    /**
     * Field _expression
     */
    private java.lang.String _expression;

    /**
     * Field _externalData
     */
    private java.lang.String _externalData;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionSourceDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteCalculated
     */
    public void deleteCalculated()
    {
        this._has_calculated= false;
    } //-- void deleteCalculated() 

    /**
     * Method getCalculatedReturns the value of field 'calculated'.
     * 
     * @return the value of field 'calculated'.
     */
    public boolean getCalculated()
    {
        return this._calculated;
    } //-- boolean getCalculated() 

    /**
     * Method getDataTypeReturns the value of field 'dataType'.
     * 
     * @return the value of field 'dataType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.ReportDataType getDataType()
    {
        return this._dataType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.ReportDataType getDataType() 

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
     * Method getExternalDataReturns the value of field
     * 'externalData'.
     * 
     * @return the value of field 'externalData'.
     */
    public java.lang.String getExternalData()
    {
        return this._externalData;
    } //-- java.lang.String getExternalData() 

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
     * Method hasCalculated
     */
    public boolean hasCalculated()
    {
        return this._has_calculated;
    } //-- boolean hasCalculated() 

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
     * Method setCalculatedSets the value of field 'calculated'.
     * 
     * @param calculated the value of field 'calculated'.
     */
    public void setCalculated(boolean calculated)
    {
        this._calculated = calculated;
        this._has_calculated = true;
    } //-- void setCalculated(boolean) 

    /**
     * Method setDataTypeSets the value of field 'dataType'.
     * 
     * @param dataType the value of field 'dataType'.
     */
    public void setDataType(com.calipso.reportgenerator.reportdefinitions.types.ReportDataType dataType)
    {
        this._dataType = dataType;
    } //-- void setDataType(com.calipso.reportgenerator.reportdefinitions.types.ReportDataType) 

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
     * Method setExternalDataSets the value of field
     * 'externalData'.
     * 
     * @param externalData the value of field 'externalData'.
     */
    public void setExternalData(java.lang.String externalData)
    {
        this._externalData = externalData;
    } //-- void setExternalData(java.lang.String) 

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
    public static com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition unmarshal(java.io.Reader) 

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
