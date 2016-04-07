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

import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
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
 * Class FilterDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class FilterDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _dimensionName
     */
    private java.lang.String _dimensionName;

    /**
     * Field _dataType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.ReportDataType _dataType;

    /**
     * Field _filterType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType _filterType;

    /**
     * Field _visual
     */
    private boolean _visual;

    /**
     * keeps track of state for field: _visual
     */
    private boolean _has_visual;


      //----------------/
     //- Constructors -/
    //----------------/

    public FilterDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinition()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method getDimensionNameReturns the value of field
     * 'dimensionName'.
     * 
     * @return the value of field 'dimensionName'.
     */
    public java.lang.String getDimensionName()
    {
        return this._dimensionName;
    } //-- java.lang.String getDimensionName() 

    /**
     * Method getFilterTypeReturns the value of field 'filterType'.
     * 
     * @return the value of field 'filterType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType getFilterType()
    {
        return this._filterType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType getFilterType() 

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
     * Method getVisualReturns the value of field 'visual'.
     * 
     * @return the value of field 'visual'.
     */
    public boolean getVisual()
    {
        return this._visual;
    } //-- boolean getVisual() 

    /**
     * Method hasVisual
     */
    public boolean hasVisual()
    {
        return this._has_visual;
    } //-- boolean hasVisual() 

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
     * Method setDataTypeSets the value of field 'dataType'.
     * 
     * @param dataType the value of field 'dataType'.
     */
    public void setDataType(com.calipso.reportgenerator.reportdefinitions.types.ReportDataType dataType)
    {
        this._dataType = dataType;
    } //-- void setDataType(com.calipso.reportgenerator.reportdefinitions.types.ReportDataType) 

    /**
     * Method setDimensionNameSets the value of field
     * 'dimensionName'.
     * 
     * @param dimensionName the value of field 'dimensionName'.
     */
    public void setDimensionName(java.lang.String dimensionName)
    {
        this._dimensionName = dimensionName;
    } //-- void setDimensionName(java.lang.String) 

    /**
     * Method setFilterTypeSets the value of field 'filterType'.
     * 
     * @param filterType the value of field 'filterType'.
     */
    public void setFilterType(com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType filterType)
    {
        this._filterType = filterType;
    } //-- void setFilterType(com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType) 

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
     * Method setVisualSets the value of field 'visual'.
     * 
     * @param visual the value of field 'visual'.
     */
    public void setVisual(boolean visual)
    {
        this._visual = visual;
        this._has_visual = true;
    } //-- void setVisual(boolean) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.FilterDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.FilterDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.FilterDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinition unmarshal(java.io.Reader) 

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
