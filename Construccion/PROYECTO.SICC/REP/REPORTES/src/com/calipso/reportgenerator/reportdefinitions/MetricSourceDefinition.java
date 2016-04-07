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

import com.calipso.reportgenerator.reportdefinitions.types.CalculationType;
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
 * Class MetricSourceDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class MetricSourceDefinition implements java.io.Serializable {


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
     * Field _aggregateType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.CalculationType _aggregateType;

    /**
     * Field _groupFooterType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.CalculationType _groupFooterType;

    /**
     * Field _calculated
     */
    private boolean _calculated;

    /**
     * keeps track of state for field: _calculated
     */
    private boolean _has_calculated;

    /**
     * Field _aggregateFunction
     */
    private java.lang.String _aggregateFunction;

    /**
     * Field _groupFooterFunction
     */
    private java.lang.String _groupFooterFunction;

    /**
     * Field _externalData
     */
    private java.lang.String _externalData;

    /**
     * Field _externalCalculated
     */
    private boolean _externalCalculated;

    /**
     * keeps track of state for field: _externalCalculated
     */
    private boolean _has_externalCalculated;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricSourceDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition()


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
     * Method deleteExternalCalculated
     */
    public void deleteExternalCalculated()
    {
        this._has_externalCalculated= false;
    } //-- void deleteExternalCalculated() 

    /**
     * Method getAggregateFunctionReturns the value of field
     * 'aggregateFunction'.
     * 
     * @return the value of field 'aggregateFunction'.
     */
    public java.lang.String getAggregateFunction()
    {
        return this._aggregateFunction;
    } //-- java.lang.String getAggregateFunction() 

    /**
     * Method getAggregateTypeReturns the value of field
     * 'aggregateType'.
     * 
     * @return the value of field 'aggregateType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.CalculationType getAggregateType()
    {
        return this._aggregateType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.CalculationType getAggregateType() 

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
     * Method getExternalCalculatedReturns the value of field
     * 'externalCalculated'.
     * 
     * @return the value of field 'externalCalculated'.
     */
    public boolean getExternalCalculated()
    {
        return this._externalCalculated;
    } //-- boolean getExternalCalculated() 

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
     * Method getGroupFooterFunctionReturns the value of field
     * 'groupFooterFunction'.
     * 
     * @return the value of field 'groupFooterFunction'.
     */
    public java.lang.String getGroupFooterFunction()
    {
        return this._groupFooterFunction;
    } //-- java.lang.String getGroupFooterFunction() 

    /**
     * Method getGroupFooterTypeReturns the value of field
     * 'groupFooterType'.
     * 
     * @return the value of field 'groupFooterType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.CalculationType getGroupFooterType()
    {
        return this._groupFooterType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.CalculationType getGroupFooterType() 

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
     * Method hasExternalCalculated
     */
    public boolean hasExternalCalculated()
    {
        return this._has_externalCalculated;
    } //-- boolean hasExternalCalculated() 

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
     * Method setAggregateFunctionSets the value of field
     * 'aggregateFunction'.
     * 
     * @param aggregateFunction the value of field
     * 'aggregateFunction'.
     */
    public void setAggregateFunction(java.lang.String aggregateFunction)
    {
        this._aggregateFunction = aggregateFunction;
    } //-- void setAggregateFunction(java.lang.String) 

    /**
     * Method setAggregateTypeSets the value of field
     * 'aggregateType'.
     * 
     * @param aggregateType the value of field 'aggregateType'.
     */
    public void setAggregateType(com.calipso.reportgenerator.reportdefinitions.types.CalculationType aggregateType)
    {
        this._aggregateType = aggregateType;
    } //-- void setAggregateType(com.calipso.reportgenerator.reportdefinitions.types.CalculationType) 

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
     * Method setDescriptionSets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Method setExternalCalculatedSets the value of field
     * 'externalCalculated'.
     * 
     * @param externalCalculated the value of field
     * 'externalCalculated'.
     */
    public void setExternalCalculated(boolean externalCalculated)
    {
        this._externalCalculated = externalCalculated;
        this._has_externalCalculated = true;
    } //-- void setExternalCalculated(boolean) 

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
     * Method setGroupFooterFunctionSets the value of field
     * 'groupFooterFunction'.
     * 
     * @param groupFooterFunction the value of field
     * 'groupFooterFunction'.
     */
    public void setGroupFooterFunction(java.lang.String groupFooterFunction)
    {
        this._groupFooterFunction = groupFooterFunction;
    } //-- void setGroupFooterFunction(java.lang.String) 

    /**
     * Method setGroupFooterTypeSets the value of field
     * 'groupFooterType'.
     * 
     * @param groupFooterType the value of field 'groupFooterType'.
     */
    public void setGroupFooterType(com.calipso.reportgenerator.reportdefinitions.types.CalculationType groupFooterType)
    {
        this._groupFooterType = groupFooterType;
    } //-- void setGroupFooterType(com.calipso.reportgenerator.reportdefinitions.types.CalculationType) 

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
    public static com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition unmarshal(java.io.Reader) 

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
