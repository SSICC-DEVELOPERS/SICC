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

import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
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
 * Class ReportDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class ReportDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _description
     */
    private java.lang.String _description;

    /**
     * Field _reportSource
     */
    private java.lang.String _reportSource;

    /**
     * Field _entity
     */
    private java.lang.String _entity;

    /**
     * Field _isTransient
     */
    private boolean _isTransient;

    /**
     * keeps track of state for field: _isTransient
     */
    private boolean _has_isTransient;

    /**
     * Field _reportType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType _reportType;

    /**
     * Field _title
     */
    private java.lang.String _title;

    /**
     * Field _pageHeding
     */
    private java.lang.String _pageHeding;

    /**
     * Field _pageFooter
     */
    private java.lang.String _pageFooter;

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
     * Field _visibleTotals
     */
    private boolean _visibleTotals = true;

    /**
     * keeps track of state for field: _visibleTotals
     */
    private boolean _has_visibleTotals;

    /**
     * Field _layoutDesign
     */
    private java.lang.String _layoutDesign;

    /**
     * Field _roles
     */
    private com.calipso.reportgenerator.reportdefinitions.Roles _roles;

    /**
     * Field _dimensionDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions _dimensionDefinitions;

    /**
     * Field _metricDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.MetricDefinitions _metricDefinitions;

    /**
     * Field _actionDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.ActionDefinitions _actionDefinitions;

    /**
     * Field _filterDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.FilterDefinitions _filterDefinitions;

    /**
     * Field _parameterValues
     */
    private com.calipso.reportgenerator.reportdefinitions.ParameterValues _parameterValues;

    /**
     * Field _localizations
     */
    private com.calipso.reportgenerator.reportdefinitions.Localizations _localizations;

    /**
     * Field _drillDownDefinitions
     */
    private com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions _drillDownDefinitions;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReportDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportDefinition()


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
     * Method deleteVisibleTotals
     */
    public void deleteVisibleTotals()
    {
        this._has_visibleTotals= false;
    } //-- void deleteVisibleTotals() 

    /**
     * Method getActionDefinitionsReturns the value of field
     * 'actionDefinitions'.
     * 
     * @return the value of field 'actionDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.ActionDefinitions getActionDefinitions()
    {
        return this._actionDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.ActionDefinitions getActionDefinitions() 

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
     * Method getDimensionDefinitionsReturns the value of field
     * 'dimensionDefinitions'.
     * 
     * @return the value of field 'dimensionDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions getDimensionDefinitions()
    {
        return this._dimensionDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions getDimensionDefinitions() 

    /**
     * Method getDrillDownDefinitionsReturns the value of field
     * 'drillDownDefinitions'.
     * 
     * @return the value of field 'drillDownDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions getDrillDownDefinitions()
    {
        return this._drillDownDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions getDrillDownDefinitions() 

    /**
     * Method getEntityReturns the value of field 'entity'.
     * 
     * @return the value of field 'entity'.
     */
    public java.lang.String getEntity()
    {
        return this._entity;
    } //-- java.lang.String getEntity() 

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
     * Method getIsTransientReturns the value of field
     * 'isTransient'.
     * 
     * @return the value of field 'isTransient'.
     */
    public boolean getIsTransient()
    {
        return this._isTransient;
    } //-- boolean getIsTransient() 

    /**
     * Method getLayoutDesignReturns the value of field
     * 'layoutDesign'.
     * 
     * @return the value of field 'layoutDesign'.
     */
    public java.lang.String getLayoutDesign()
    {
        return this._layoutDesign;
    } //-- java.lang.String getLayoutDesign() 

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
     * Method getMetricDefinitionsReturns the value of field
     * 'metricDefinitions'.
     * 
     * @return the value of field 'metricDefinitions'.
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricDefinitions getMetricDefinitions()
    {
        return this._metricDefinitions;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricDefinitions getMetricDefinitions() 

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
     * Method getPageFooterReturns the value of field 'pageFooter'.
     * 
     * @return the value of field 'pageFooter'.
     */
    public java.lang.String getPageFooter()
    {
        return this._pageFooter;
    } //-- java.lang.String getPageFooter() 

    /**
     * Method getPageHedingReturns the value of field 'pageHeding'.
     * 
     * @return the value of field 'pageHeding'.
     */
    public java.lang.String getPageHeding()
    {
        return this._pageHeding;
    } //-- java.lang.String getPageHeding() 

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
     * Method getReportSourceReturns the value of field
     * 'reportSource'.
     * 
     * @return the value of field 'reportSource'.
     */
    public java.lang.String getReportSource()
    {
        return this._reportSource;
    } //-- java.lang.String getReportSource() 

    /**
     * Method getReportTypeReturns the value of field 'reportType'.
     * 
     * @return the value of field 'reportType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType getReportType()
    {
        return this._reportType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType getReportType() 

    /**
     * Method getRolesReturns the value of field 'roles'.
     * 
     * @return the value of field 'roles'.
     */
    public com.calipso.reportgenerator.reportdefinitions.Roles getRoles()
    {
        return this._roles;
    } //-- com.calipso.reportgenerator.reportdefinitions.Roles getRoles() 

    /**
     * Method getTitleReturns the value of field 'title'.
     * 
     * @return the value of field 'title'.
     */
    public java.lang.String getTitle()
    {
        return this._title;
    } //-- java.lang.String getTitle() 

    /**
     * Method getVisibleTotalsReturns the value of field
     * 'visibleTotals'.
     * 
     * @return the value of field 'visibleTotals'.
     */
    public boolean getVisibleTotals()
    {
        return this._visibleTotals;
    } //-- boolean getVisibleTotals() 

    /**
     * Method hasIsTransient
     */
    public boolean hasIsTransient()
    {
        return this._has_isTransient;
    } //-- boolean hasIsTransient() 

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
     * Method hasVisibleTotals
     */
    public boolean hasVisibleTotals()
    {
        return this._has_visibleTotals;
    } //-- boolean hasVisibleTotals() 

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
     * Method setActionDefinitionsSets the value of field
     * 'actionDefinitions'.
     * 
     * @param actionDefinitions the value of field
     * 'actionDefinitions'.
     */
    public void setActionDefinitions(com.calipso.reportgenerator.reportdefinitions.ActionDefinitions actionDefinitions)
    {
        this._actionDefinitions = actionDefinitions;
    } //-- void setActionDefinitions(com.calipso.reportgenerator.reportdefinitions.ActionDefinitions) 

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
     * Method setDimensionDefinitionsSets the value of field
     * 'dimensionDefinitions'.
     * 
     * @param dimensionDefinitions the value of field
     * 'dimensionDefinitions'.
     */
    public void setDimensionDefinitions(com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions dimensionDefinitions)
    {
        this._dimensionDefinitions = dimensionDefinitions;
    } //-- void setDimensionDefinitions(com.calipso.reportgenerator.reportdefinitions.DimensionDefinitions) 

    /**
     * Method setDrillDownDefinitionsSets the value of field
     * 'drillDownDefinitions'.
     * 
     * @param drillDownDefinitions the value of field
     * 'drillDownDefinitions'.
     */
    public void setDrillDownDefinitions(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions drillDownDefinitions)
    {
        this._drillDownDefinitions = drillDownDefinitions;
    } //-- void setDrillDownDefinitions(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinitions) 

    /**
     * Method setEntitySets the value of field 'entity'.
     * 
     * @param entity the value of field 'entity'.
     */
    public void setEntity(java.lang.String entity)
    {
        this._entity = entity;
    } //-- void setEntity(java.lang.String) 

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
     * Method setIsTransientSets the value of field 'isTransient'.
     * 
     * @param isTransient the value of field 'isTransient'.
     */
    public void setIsTransient(boolean isTransient)
    {
        this._isTransient = isTransient;
        this._has_isTransient = true;
    } //-- void setIsTransient(boolean) 

    /**
     * Method setLayoutDesignSets the value of field
     * 'layoutDesign'.
     * 
     * @param layoutDesign the value of field 'layoutDesign'.
     */
    public void setLayoutDesign(java.lang.String layoutDesign)
    {
        this._layoutDesign = layoutDesign;
    } //-- void setLayoutDesign(java.lang.String) 

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
     * Method setMetricDefinitionsSets the value of field
     * 'metricDefinitions'.
     * 
     * @param metricDefinitions the value of field
     * 'metricDefinitions'.
     */
    public void setMetricDefinitions(com.calipso.reportgenerator.reportdefinitions.MetricDefinitions metricDefinitions)
    {
        this._metricDefinitions = metricDefinitions;
    } //-- void setMetricDefinitions(com.calipso.reportgenerator.reportdefinitions.MetricDefinitions) 

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
     * Method setPageFooterSets the value of field 'pageFooter'.
     * 
     * @param pageFooter the value of field 'pageFooter'.
     */
    public void setPageFooter(java.lang.String pageFooter)
    {
        this._pageFooter = pageFooter;
    } //-- void setPageFooter(java.lang.String) 

    /**
     * Method setPageHedingSets the value of field 'pageHeding'.
     * 
     * @param pageHeding the value of field 'pageHeding'.
     */
    public void setPageHeding(java.lang.String pageHeding)
    {
        this._pageHeding = pageHeding;
    } //-- void setPageHeding(java.lang.String) 

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
     * Method setReportSourceSets the value of field
     * 'reportSource'.
     * 
     * @param reportSource the value of field 'reportSource'.
     */
    public void setReportSource(java.lang.String reportSource)
    {
        this._reportSource = reportSource;
    } //-- void setReportSource(java.lang.String) 

    /**
     * Method setReportTypeSets the value of field 'reportType'.
     * 
     * @param reportType the value of field 'reportType'.
     */
    public void setReportType(com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType reportType)
    {
        this._reportType = reportType;
    } //-- void setReportType(com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType) 

    /**
     * Method setRolesSets the value of field 'roles'.
     * 
     * @param roles the value of field 'roles'.
     */
    public void setRoles(com.calipso.reportgenerator.reportdefinitions.Roles roles)
    {
        this._roles = roles;
    } //-- void setRoles(com.calipso.reportgenerator.reportdefinitions.Roles) 

    /**
     * Method setTitleSets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.String title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.String) 

    /**
     * Method setVisibleTotalsSets the value of field
     * 'visibleTotals'.
     * 
     * @param visibleTotals the value of field 'visibleTotals'.
     */
    public void setVisibleTotals(boolean visibleTotals)
    {
        this._visibleTotals = visibleTotals;
        this._has_visibleTotals = true;
    } //-- void setVisibleTotals(boolean) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.ReportDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ReportDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ReportDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportDefinition unmarshal(java.io.Reader) 

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
