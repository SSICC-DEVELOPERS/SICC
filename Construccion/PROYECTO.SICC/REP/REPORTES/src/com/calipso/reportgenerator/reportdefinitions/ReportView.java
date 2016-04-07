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
 * Class ReportView.
 * 
 * @version $Revision$ $Date$
 */
public class ReportView implements java.io.Serializable {


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
     * Field _reportDefinitionId
     */
    private java.lang.String _reportDefinitionId;

    /**
     * Field _userID
     */
    private java.lang.String _userID;

    /**
     * Field _userName
     */
    private java.lang.String _userName;

    /**
     * Field _reportLayout
     */
    private java.lang.String _reportLayout;

    /**
     * Field _visibleTotals
     */
    private boolean _visibleTotals = true;

    /**
     * keeps track of state for field: _visibleTotals
     */
    private boolean _has_visibleTotals;

    /**
     * Field _default
     */
    private boolean _default = false;

    /**
     * keeps track of state for field: _default
     */
    private boolean _has_default;

    /**
     * Field _dimensionProperties
     */
    private com.calipso.reportgenerator.reportdefinitions.DimensionProperties _dimensionProperties;

    /**
     * Field _metricProperties
     */
    private com.calipso.reportgenerator.reportdefinitions.MetricProperties _metricProperties;

    /**
     * Field _lightBoxer
     */
    private com.calipso.reportgenerator.reportdefinitions.LightBoxer _lightBoxer;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReportView() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportView()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteDefault
     */
    public void deleteDefault()
    {
        this._has_default= false;
    } //-- void deleteDefault() 

    /**
     * Method deleteVisibleTotals
     */
    public void deleteVisibleTotals()
    {
        this._has_visibleTotals= false;
    } //-- void deleteVisibleTotals() 

    /**
     * Method getDefaultReturns the value of field 'default'.
     * 
     * @return the value of field 'default'.
     */
    public boolean getDefault()
    {
        return this._default;
    } //-- boolean getDefault() 

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
     * Method getDimensionPropertiesReturns the value of field
     * 'dimensionProperties'.
     * 
     * @return the value of field 'dimensionProperties'.
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionProperties getDimensionProperties()
    {
        return this._dimensionProperties;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperties getDimensionProperties() 

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
     * Method getLightBoxerReturns the value of field 'lightBoxer'.
     * 
     * @return the value of field 'lightBoxer'.
     */
    public com.calipso.reportgenerator.reportdefinitions.LightBoxer getLightBoxer()
    {
        return this._lightBoxer;
    } //-- com.calipso.reportgenerator.reportdefinitions.LightBoxer getLightBoxer() 

    /**
     * Method getMetricPropertiesReturns the value of field
     * 'metricProperties'.
     * 
     * @return the value of field 'metricProperties'.
     */
    public com.calipso.reportgenerator.reportdefinitions.MetricProperties getMetricProperties()
    {
        return this._metricProperties;
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperties getMetricProperties() 

    /**
     * Method getReportDefinitionIdReturns the value of field
     * 'reportDefinitionId'.
     * 
     * @return the value of field 'reportDefinitionId'.
     */
    public java.lang.String getReportDefinitionId()
    {
        return this._reportDefinitionId;
    } //-- java.lang.String getReportDefinitionId() 

    /**
     * Method getReportLayoutReturns the value of field
     * 'reportLayout'.
     * 
     * @return the value of field 'reportLayout'.
     */
    public java.lang.String getReportLayout()
    {
        return this._reportLayout;
    } //-- java.lang.String getReportLayout() 

    /**
     * Method getUserIDReturns the value of field 'userID'.
     * 
     * @return the value of field 'userID'.
     */
    public java.lang.String getUserID()
    {
        return this._userID;
    } //-- java.lang.String getUserID() 

    /**
     * Method getUserNameReturns the value of field 'userName'.
     * 
     * @return the value of field 'userName'.
     */
    public java.lang.String getUserName()
    {
        return this._userName;
    } //-- java.lang.String getUserName() 

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
     * Method hasDefault
     */
    public boolean hasDefault()
    {
        return this._has_default;
    } //-- boolean hasDefault() 

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
     * Method setDefaultSets the value of field 'default'.
     * 
     * @param _default
     * @param default the value of field 'default'.
     */
    public void setDefault(boolean _default)
    {
        this._default = _default;
        this._has_default = true;
    } //-- void setDefault(boolean) 

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
     * Method setDimensionPropertiesSets the value of field
     * 'dimensionProperties'.
     * 
     * @param dimensionProperties the value of field
     * 'dimensionProperties'.
     */
    public void setDimensionProperties(com.calipso.reportgenerator.reportdefinitions.DimensionProperties dimensionProperties)
    {
        this._dimensionProperties = dimensionProperties;
    } //-- void setDimensionProperties(com.calipso.reportgenerator.reportdefinitions.DimensionProperties) 

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
     * Method setLightBoxerSets the value of field 'lightBoxer'.
     * 
     * @param lightBoxer the value of field 'lightBoxer'.
     */
    public void setLightBoxer(com.calipso.reportgenerator.reportdefinitions.LightBoxer lightBoxer)
    {
        this._lightBoxer = lightBoxer;
    } //-- void setLightBoxer(com.calipso.reportgenerator.reportdefinitions.LightBoxer) 

    /**
     * Method setMetricPropertiesSets the value of field
     * 'metricProperties'.
     * 
     * @param metricProperties the value of field 'metricProperties'
     */
    public void setMetricProperties(com.calipso.reportgenerator.reportdefinitions.MetricProperties metricProperties)
    {
        this._metricProperties = metricProperties;
    } //-- void setMetricProperties(com.calipso.reportgenerator.reportdefinitions.MetricProperties) 

    /**
     * Method setReportDefinitionIdSets the value of field
     * 'reportDefinitionId'.
     * 
     * @param reportDefinitionId the value of field
     * 'reportDefinitionId'.
     */
    public void setReportDefinitionId(java.lang.String reportDefinitionId)
    {
        this._reportDefinitionId = reportDefinitionId;
    } //-- void setReportDefinitionId(java.lang.String) 

    /**
     * Method setReportLayoutSets the value of field
     * 'reportLayout'.
     * 
     * @param reportLayout the value of field 'reportLayout'.
     */
    public void setReportLayout(java.lang.String reportLayout)
    {
        this._reportLayout = reportLayout;
    } //-- void setReportLayout(java.lang.String) 

    /**
     * Method setUserIDSets the value of field 'userID'.
     * 
     * @param userID the value of field 'userID'.
     */
    public void setUserID(java.lang.String userID)
    {
        this._userID = userID;
    } //-- void setUserID(java.lang.String) 

    /**
     * Method setUserNameSets the value of field 'userName'.
     * 
     * @param userName the value of field 'userName'.
     */
    public void setUserName(java.lang.String userName)
    {
        this._userName = userName;
    } //-- void setUserName(java.lang.String) 

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
    public static com.calipso.reportgenerator.reportdefinitions.ReportView unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.ReportView) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.ReportView.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.ReportView unmarshal(java.io.Reader) 

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
