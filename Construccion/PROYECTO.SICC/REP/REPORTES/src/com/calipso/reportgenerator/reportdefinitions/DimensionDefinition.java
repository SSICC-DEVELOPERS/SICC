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

import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
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
 * Class DimensionDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionDefinition implements java.io.Serializable {


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
     * Field _location
     */
    private com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType _location;

    /**
     * Field _groups
     */
    private boolean _groups;

    /**
     * keeps track of state for field: _groups
     */
    private boolean _has_groups;

    /**
     * Field _groupFooterCaption
     */
    private java.lang.String _groupFooterCaption;

    /**
     * Field _order
     */
    private com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType _order;

    /**
     * Field _rankMetricName
     */
    private java.lang.String _rankMetricName;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteGroups
     */
    public void deleteGroups()
    {
        this._has_groups= false;
    } //-- void deleteGroups() 

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
     * Method getGroupFooterCaptionReturns the value of field
     * 'groupFooterCaption'.
     * 
     * @return the value of field 'groupFooterCaption'.
     */
    public java.lang.String getGroupFooterCaption()
    {
        return this._groupFooterCaption;
    } //-- java.lang.String getGroupFooterCaption() 

    /**
     * Method getGroupsReturns the value of field 'groups'.
     * 
     * @return the value of field 'groups'.
     */
    public boolean getGroups()
    {
        return this._groups;
    } //-- boolean getGroups() 

    /**
     * Method getLocationReturns the value of field 'location'.
     * 
     * @return the value of field 'location'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType getLocation()
    {
        return this._location;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType getLocation() 

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
     * Method getOrderReturns the value of field 'order'.
     * 
     * @return the value of field 'order'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType getOrder()
    {
        return this._order;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType getOrder() 

    /**
     * Method getRankMetricNameReturns the value of field
     * 'rankMetricName'.
     * 
     * @return the value of field 'rankMetricName'.
     */
    public java.lang.String getRankMetricName()
    {
        return this._rankMetricName;
    } //-- java.lang.String getRankMetricName() 

    /**
     * Method hasGroups
     */
    public boolean hasGroups()
    {
        return this._has_groups;
    } //-- boolean hasGroups() 

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
     * Method setGroupFooterCaptionSets the value of field
     * 'groupFooterCaption'.
     * 
     * @param groupFooterCaption the value of field
     * 'groupFooterCaption'.
     */
    public void setGroupFooterCaption(java.lang.String groupFooterCaption)
    {
        this._groupFooterCaption = groupFooterCaption;
    } //-- void setGroupFooterCaption(java.lang.String) 

    /**
     * Method setGroupsSets the value of field 'groups'.
     * 
     * @param groups the value of field 'groups'.
     */
    public void setGroups(boolean groups)
    {
        this._groups = groups;
        this._has_groups = true;
    } //-- void setGroups(boolean) 

    /**
     * Method setLocationSets the value of field 'location'.
     * 
     * @param location the value of field 'location'.
     */
    public void setLocation(com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType location)
    {
        this._location = location;
    } //-- void setLocation(com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType) 

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
     * Method setOrderSets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType order)
    {
        this._order = order;
    } //-- void setOrder(com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType) 

    /**
     * Method setRankMetricNameSets the value of field
     * 'rankMetricName'.
     * 
     * @param rankMetricName the value of field 'rankMetricName'.
     */
    public void setRankMetricName(java.lang.String rankMetricName)
    {
        this._rankMetricName = rankMetricName;
    } //-- void setRankMetricName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DimensionDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionDefinition unmarshal(java.io.Reader) 

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
