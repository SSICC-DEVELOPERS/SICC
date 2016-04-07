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

import com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType;
import com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType;
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
 * Class LightBoxDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class LightBoxDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metricName
     */
    private java.lang.String _metricName;

    /**
     * Field _type
     */
    private com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType _type;

    /**
     * Field _parameter
     */
    private com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType _parameter;

    /**
     * Field _colorRed
     */
    private int _colorRed;

    /**
     * keeps track of state for field: _colorRed
     */
    private boolean _has_colorRed;

    /**
     * Field _colorGreen
     */
    private int _colorGreen;

    /**
     * keeps track of state for field: _colorGreen
     */
    private boolean _has_colorGreen;

    /**
     * Field _colorBlue
     */
    private int _colorBlue;

    /**
     * keeps track of state for field: _colorBlue
     */
    private boolean _has_colorBlue;

    /**
     * Field _value
     */
    private java.lang.String _value;


      //----------------/
     //- Constructors -/
    //----------------/

    public LightBoxDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getColorBlueReturns the value of field 'colorBlue'.
     * 
     * @return the value of field 'colorBlue'.
     */
    public int getColorBlue()
    {
        return this._colorBlue;
    } //-- int getColorBlue() 

    /**
     * Method getColorGreenReturns the value of field 'colorGreen'.
     * 
     * @return the value of field 'colorGreen'.
     */
    public int getColorGreen()
    {
        return this._colorGreen;
    } //-- int getColorGreen() 

    /**
     * Method getColorRedReturns the value of field 'colorRed'.
     * 
     * @return the value of field 'colorRed'.
     */
    public int getColorRed()
    {
        return this._colorRed;
    } //-- int getColorRed() 

    /**
     * Method getMetricNameReturns the value of field 'metricName'.
     * 
     * @return the value of field 'metricName'.
     */
    public java.lang.String getMetricName()
    {
        return this._metricName;
    } //-- java.lang.String getMetricName() 

    /**
     * Method getParameterReturns the value of field 'parameter'.
     * 
     * @return the value of field 'parameter'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType getParameter()
    {
        return this._parameter;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType getParameter() 

    /**
     * Method getTypeReturns the value of field 'type'.
     * 
     * @return the value of field 'type'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType getType()
    {
        return this._type;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType getType() 

    /**
     * Method getValueReturns the value of field 'value'.
     * 
     * @return the value of field 'value'.
     */
    public java.lang.String getValue()
    {
        return this._value;
    } //-- java.lang.String getValue() 

    /**
     * Method hasColorBlue
     */
    public boolean hasColorBlue()
    {
        return this._has_colorBlue;
    } //-- boolean hasColorBlue() 

    /**
     * Method hasColorGreen
     */
    public boolean hasColorGreen()
    {
        return this._has_colorGreen;
    } //-- boolean hasColorGreen() 

    /**
     * Method hasColorRed
     */
    public boolean hasColorRed()
    {
        return this._has_colorRed;
    } //-- boolean hasColorRed() 

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
     * Method setColorBlueSets the value of field 'colorBlue'.
     * 
     * @param colorBlue the value of field 'colorBlue'.
     */
    public void setColorBlue(int colorBlue)
    {
        this._colorBlue = colorBlue;
        this._has_colorBlue = true;
    } //-- void setColorBlue(int) 

    /**
     * Method setColorGreenSets the value of field 'colorGreen'.
     * 
     * @param colorGreen the value of field 'colorGreen'.
     */
    public void setColorGreen(int colorGreen)
    {
        this._colorGreen = colorGreen;
        this._has_colorGreen = true;
    } //-- void setColorGreen(int) 

    /**
     * Method setColorRedSets the value of field 'colorRed'.
     * 
     * @param colorRed the value of field 'colorRed'.
     */
    public void setColorRed(int colorRed)
    {
        this._colorRed = colorRed;
        this._has_colorRed = true;
    } //-- void setColorRed(int) 

    /**
     * Method setMetricNameSets the value of field 'metricName'.
     * 
     * @param metricName the value of field 'metricName'.
     */
    public void setMetricName(java.lang.String metricName)
    {
        this._metricName = metricName;
    } //-- void setMetricName(java.lang.String) 

    /**
     * Method setParameterSets the value of field 'parameter'.
     * 
     * @param parameter the value of field 'parameter'.
     */
    public void setParameter(com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType parameter)
    {
        this._parameter = parameter;
    } //-- void setParameter(com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType) 

    /**
     * Method setTypeSets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType type)
    {
        this._type = type;
    } //-- void setType(com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType) 

    /**
     * Method setValueSets the value of field 'value'.
     * 
     * @param value the value of field 'value'.
     */
    public void setValue(java.lang.String value)
    {
        this._value = value;
    } //-- void setValue(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxDefinition unmarshal(java.io.Reader) 

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
