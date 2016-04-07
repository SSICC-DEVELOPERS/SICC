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
import java.math.BigDecimal;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class ReportSourceDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ReportSourceDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _cached
     */
    private boolean _cached;

    /**
     * keeps track of state for field: _cached
     */
    private boolean _has_cached;

    /**
     * Field _expiration
     */
    private java.math.BigDecimal _expiration;

    /**
     * Field _incrementalDimension
     */
    private java.lang.String _incrementalDimension;

    /**
     * Field _multilanguage
     */
    private boolean _multilanguage = false;

    /**
     * keeps track of state for field: _multilanguage
     */
    private boolean _has_multilanguage;

    /**
     * Field _maxRowsDimensionReference
     */
    private java.lang.String _maxRowsDimensionReference;

    /**
     * Field _maxRowCount
     */
    private int _maxRowCount;

    /**
     * keeps track of state for field: _maxRowCount
     */
    private boolean _has_maxRowCount;

    /**
     * Field _dimensionSourceDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions _dimensionSourceDefinitions;

    /**
     * Field _metricSourceDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions _metricSourceDefinitions;

    /**
     * Field _filterDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.FilterDefinitions _filterDefinitions;

    /**
     * Field _dataSourceDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions _dataSourceDefinitions;

    /**
     * Field _parameterValues
     */
    private com.calipso.reportgenerator.reportdefinitions.ParameterValues _parameterValues;

    /**
     * Field _localizations
     */
    private com.calipso.reportgenerator.reportdefinitions.Localizations _localizations;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReportSourceDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteMaxRowCount
     */
    public void deleteMaxRowCount()
    {
        this._has_maxRowCount= false;
    } //-- void deleteMaxRowCount() 

    /**
     * Method deleteMultilanguage
     */
    public void deleteMultilanguage()
    {
        this._has_multilanguage= false;
    } //-- void deleteMultilanguage() 

    /**
     * Method getCachedReturns the value of field 'cached'.
     * 
     * @return the value of field 'cached'.
     */
    public boolean getCached()
    {
        return this._cached;
    } //-- boolean getCached() 

    /**
     * Method getDataSourceDefinitionsReturns the value of field
     * 'dataSourceDefinitions'.
     * 
     * @return the value of field 'dataSourceDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions getDataSourceDefinitions()
    {
        return this._dataSourceDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions getDataSourceDefinitions() 

    /**
     * Method getDimensionSourceDefinitionsReturns the value of
     * field 'dimensionSourceDefinitions'.
     * 
     * @return the value of field 'dimensionSourceDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions getDimensionSourceDefinitions()
    {
        return this._dimensionSourceDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions getDimensionSourceDefinitions() 

    /**
     * Method getExpirationReturns the value of field 'expiration'.
     * 
     * @return the value of field 'expiration'.
     */
    public java.math.BigDecimal getExpiration()
    {
        return this._expiration;
    } //-- java.math.BigDecimal getExpiration() 

    /**
     * Method getFilterDefinitionsReturns the value of field
     * 'filterDefinitions'.
     * 
     * @return the value of field 'filterDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.FilterDefinitions getFilterDefinitions()
    {
        return this._filterDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.FilterDefinitions getFilterDefinitions() 

    /**
     * Method getIdReturns the value of field 'id'.
     * 
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Method getIncrementalDimensionReturns the value of field
     * 'incrementalDimension'.
     * 
     * @return the value of field 'incrementalDimension'.
     */
    public java.lang.String getIncrementalDimension()
    {
        return this._incrementalDimension;
    } //-- java.lang.String getIncrementalDimension() 

    /**
     * Method getLocalizationsReturns the value of field
     * 'localizations'.
     * 
     * @return the value of field 'localizations'.
     */
    public com.calipso.reportgenerator.reportdefinitions.Localizations getLocalizations()
    {
        return this._localizations;
    } //-- com.calipso.reportgenerator.reportdefinitions.Localizations getLocalizations() 

    /**
     * Method getMaxRowCountReturns the value of field
     * 'maxRowCount'.
     * 
     * @return the value of field 'maxRowCount'.
     */
    public int getMaxRowCount()
    {
        return this._maxRowCount;
    } //-- int getMaxRowCount() 

    /**
     * Method getMaxRowsDimensionReferenceReturns the value of
     * field 'maxRowsDimensionReference'.
     * 
     * @return the value of field 'maxRowsDimensionReference'.
     */
    public java.lang.String getMaxRowsDimensionReference()
    {
        return this._maxRowsDimensionReference;
    } //-- java.lang.String getMaxRowsDimensionReference() 

    /**
     * Method getMetricSourceDefinitionsReturns the value of field
     * 'metricSourceDefinitions'.
     * 
     * @return the value of field 'metricSourceDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions getMetricSourceDefinitions()
    {
        return this._metricSourceDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions getMetricSourceDefinitions() 

    /**
     * Method getMultilanguageReturns the value of field
     * 'multilanguage'.
     * 
     * @return the value of field 'multilanguage'.
     */
    public boolean getMultilanguage()
    {
        return this._multilanguage;
    } //-- boolean getMultilanguage() 

    /**
     * Method getParameterValuesReturns the value of field
     * 'parameterValues'.
     * 
     * @return the value of field 'parameterValues'.
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterValues getParameterValues()
    {
        return this._parameterValues;
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterValues getParameterValues() 

    /**
     * Method hasCached
     */
    public boolean hasCached()
    {
        return this._has_cached;
    } //-- boolean hasCached() 

    /**
     * Method hasMaxRowCount
     */
    public boolean hasMaxRowCount()
    {
        return this._has_maxRowCount;
    } //-- boolean hasMaxRowCount() 

    /**
     * Method hasMultilanguage
     */
    public boolean hasMultilanguage()
    {
        return this._has_multilanguage;
    } //-- boolean hasMultilanguage() 

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
     * Method setCachedSets the value of field 'cached'.
     * 
     * @param cached the value of field 'cached'.
     */
    public void setCached(boolean cached)
    {
        this._cached = cached;
        this._has_cached = true;
    } //-- void setCached(boolean) 

    /**
     * Method setDataSourceDefinitionsSets the value of field
     * 'dataSourceDefinitions'.
     * 
     * @param dataSourceDefinitions the value of field
     * 'dataSourceDefinitions'.
     */
    public void setDataSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions dataSourceDefinitions)
    {
        this._dataSourceDefinitions = dataSourceDefinitions;
    } //-- void setDataSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinitions) 

    /**
     * Method setDimensionSourceDefinitionsSets the value of field
     * 'dimensionSourceDefinitions'.
     * 
     * @param dimensionSourceDefinitions the value of field
     * 'dimensionSourceDefinitions'.
     */
    public void setDimensionSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions dimensionSourceDefinitions)
    {
        this._dimensionSourceDefinitions = dimensionSourceDefinitions;
    } //-- void setDimensionSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinitions) 

    /**
     * Method setExpirationSets the value of field 'expiration'.
     * 
     * @param expiration the value of field 'expiration'.
     */
    public void setExpiration(java.math.BigDecimal expiration)
    {
        this._expiration = expiration;
    } //-- void setExpiration(java.math.BigDecimal) 

    /**
     * Method setFilterDefinitionsSets the value of field
     * 'filterDefinitions'.
     * 
     * @param filterDefinitions the value of field
     * 'filterDefinitions'.
     */
    public void setFilterDefinitions(com.calipso.reportgenerator.reportdefinitions.FilterDefinitions filterDefinitions)
    {
        this._filterDefinitions = filterDefinitions;
    } //-- void setFilterDefinitions(com.calipso.reportgenerator.reportdefinitions.FilterDefinitions) 

    /**
     * Method setIdSets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Method setIncrementalDimensionSets the value of field
     * 'incrementalDimension'.
     * 
     * @param incrementalDimension the value of field
     * 'incrementalDimension'.
     */
    public void setIncrementalDimension(java.lang.String incrementalDimension)
    {
        this._incrementalDimension = incrementalDimension;
    } //-- void setIncrementalDimension(java.lang.String) 

    /**
     * Method setLocalizationsSets the value of field
     * 'localizations'.
     * 
     * @param localizations the value of field 'localizations'.
     */
    public void setLocalizations(com.calipso.reportgenerator.reportdefinitions.Localizations localizations)
    {
        this._localizations = localizations;
    } //-- void setLocalizations(com.calipso.reportgenerator.reportdefinitions.Localizations) 

    /**
     * Method setMaxRowCountSets the value of field 'maxRowCount'.
     * 
     * @param maxRowCount the value of field 'maxRowCount'.
     */
    public void setMaxRowCount(int maxRowCount)
    {
        this._maxRowCount = maxRowCount;
        this._has_maxRowCount = true;
    } //-- void setMaxRowCount(int) 

    /**
     * Method setMaxRowsDimensionReferenceSets the value of field
     * 'maxRowsDimensionReference'.
     * 
     * @param maxRowsDimensionReference the value of field
     * 'maxRowsDimensionReference'.
     */
    public void setMaxRowsDimensionReference(java.lang.String maxRowsDimensionReference)
    {
        this._maxRowsDimensionReference = maxRowsDimensionReference;
    } //-- void setMaxRowsDimensionReference(java.lang.String) 

    /**
     * Method setMetricSourceDefinitionsSets the value of field
     * 'metricSourceDefinitions'.
     * 
     * @param metricSourceDefinitions the value of field
     * 'metricSourceDefinitions'.
     */
    public void setMetricSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions metricSourceDefinitions)
    {
        this._metricSourceDefinitions = metricSourceDefinitions;
    } //-- void setMetricSourceDefinitions(com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinitions) 

    /**
     * Method setMultilanguageSets the value of field
     * 'multilanguage'.
     * 
     * @param multilanguage the value of field 'multilanguage'.
     */
    public void setMultilanguage(boolean multilanguage)
    {
        this._multilanguage = multilanguage;
        this._has_multilanguage = true;
    } //-- void setMultilanguage(boolean) 

    /**
     * Method setParameterValuesSets the value of field
     * 'parameterValues'.
     * 
     * @param parameterValues the value of field 'parameterValues'.
     */
    public void setParameterValues(com.calipso.reportgenerator.reportdefinitions.ParameterValues parameterValues)
    {
        this._parameterValues = parameterValues;
    } //-- void setParameterValues(com.calipso.reportgenerator.reportdefinitions.ParameterValues) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition unmarshal(java.io.Reader) 

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
