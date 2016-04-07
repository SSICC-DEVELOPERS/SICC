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

import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class DimensionProperty.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionProperty implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _dimensionName
     */
    private java.lang.String _dimensionName;

    /**
     * Field _width
     */
    private int _width;

    /**
     * keeps track of state for field: _width
     */
    private boolean _has_width;

    /**
     * Field _location
     */
    private com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType _location;

    /**
     * Field _order
     */
    private com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType _order;

    /**
     * Field _ubication
     */
    private int _ubication;

    /**
     * keeps track of state for field: _ubication
     */
    private boolean _has_ubication;

    /**
     * Field _rankMetricName
     */
    private java.lang.String _rankMetricName;

    /**
     * Field _excludeValueList
     */
    private java.util.Vector _excludeValueList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DimensionProperty() {
        super();
        _excludeValueList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperty()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExcludeValue
     * 
     * @param vExcludeValue
     */
    public void addExcludeValue(com.calipso.reportgenerator.reportdefinitions.ExcludeValue vExcludeValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _excludeValueList.addElement(vExcludeValue);
    } //-- void addExcludeValue(com.calipso.reportgenerator.reportdefinitions.ExcludeValue) 

    /**
     * Method addExcludeValue
     * 
     * @param index
     * @param vExcludeValue
     */
    public void addExcludeValue(int index, com.calipso.reportgenerator.reportdefinitions.ExcludeValue vExcludeValue)
        throws java.lang.IndexOutOfBoundsException
    {
        _excludeValueList.insertElementAt(vExcludeValue, index);
    } //-- void addExcludeValue(int, com.calipso.reportgenerator.reportdefinitions.ExcludeValue) 

    /**
     * Method deleteUbication
     */
    public void deleteUbication()
    {
        this._has_ubication= false;
    } //-- void deleteUbication() 

    /**
     * Method deleteWidth
     */
    public void deleteWidth()
    {
        this._has_width= false;
    } //-- void deleteWidth() 

    /**
     * Method enumerateExcludeValue
     */
    public java.util.Enumeration enumerateExcludeValue()
    {
        return _excludeValueList.elements();
    } //-- java.util.Enumeration enumerateExcludeValue() 

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
     * Method getExcludeValue
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ExcludeValue getExcludeValue(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _excludeValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.ExcludeValue) _excludeValueList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.ExcludeValue getExcludeValue(int) 

    /**
     * Method getExcludeValue
     */
    public com.calipso.reportgenerator.reportdefinitions.ExcludeValue[] getExcludeValue()
    {
        int size = _excludeValueList.size();
        com.calipso.reportgenerator.reportdefinitions.ExcludeValue[] mArray = new com.calipso.reportgenerator.reportdefinitions.ExcludeValue[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.ExcludeValue) _excludeValueList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.ExcludeValue[] getExcludeValue() 

    /**
     * Method getExcludeValueCount
     */
    public int getExcludeValueCount()
    {
        return _excludeValueList.size();
    } //-- int getExcludeValueCount() 

    /**
     * Method getLocationReturns the value of field 'location'.
     * 
     * @return the value of field 'location'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType getLocation()
    {
        return this._location;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType getLocation() 

    /**
     * Method getOrderReturns the value of field 'order'.
     * 
     * @return the value of field 'order'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType getOrder()
    {
        return this._order;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType getOrder() 

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
     * Method getUbicationReturns the value of field 'ubication'.
     * 
     * @return the value of field 'ubication'.
     */
    public int getUbication()
    {
        return this._ubication;
    } //-- int getUbication() 

    /**
     * Method getWidthReturns the value of field 'width'.
     * 
     * @return the value of field 'width'.
     */
    public int getWidth()
    {
        return this._width;
    } //-- int getWidth() 

    /**
     * Method hasUbication
     */
    public boolean hasUbication()
    {
        return this._has_ubication;
    } //-- boolean hasUbication() 

    /**
     * Method hasWidth
     */
    public boolean hasWidth()
    {
        return this._has_width;
    } //-- boolean hasWidth() 

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
     * Method removeAllExcludeValue
     */
    public void removeAllExcludeValue()
    {
        _excludeValueList.removeAllElements();
    } //-- void removeAllExcludeValue() 

    /**
     * Method removeExcludeValue
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ExcludeValue removeExcludeValue(int index)
    {
        java.lang.Object obj = _excludeValueList.elementAt(index);
        _excludeValueList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.ExcludeValue) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.ExcludeValue removeExcludeValue(int) 

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
     * Method setExcludeValue
     * 
     * @param index
     * @param vExcludeValue
     */
    public void setExcludeValue(int index, com.calipso.reportgenerator.reportdefinitions.ExcludeValue vExcludeValue)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _excludeValueList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _excludeValueList.setElementAt(vExcludeValue, index);
    } //-- void setExcludeValue(int, com.calipso.reportgenerator.reportdefinitions.ExcludeValue) 

    /**
     * Method setExcludeValue
     * 
     * @param excludeValueArray
     */
    public void setExcludeValue(com.calipso.reportgenerator.reportdefinitions.ExcludeValue[] excludeValueArray)
    {
        //-- copy array
        _excludeValueList.removeAllElements();
        for (int i = 0; i < excludeValueArray.length; i++) {
            _excludeValueList.addElement(excludeValueArray[i]);
        }
    } //-- void setExcludeValue(com.calipso.reportgenerator.reportdefinitions.ExcludeValue) 

    /**
     * Method setLocationSets the value of field 'location'.
     * 
     * @param location the value of field 'location'.
     */
    public void setLocation(com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType location)
    {
        this._location = location;
    } //-- void setLocation(com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType) 

    /**
     * Method setOrderSets the value of field 'order'.
     * 
     * @param order the value of field 'order'.
     */
    public void setOrder(com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType order)
    {
        this._order = order;
    } //-- void setOrder(com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyOrderType) 

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
     * Method setUbicationSets the value of field 'ubication'.
     * 
     * @param ubication the value of field 'ubication'.
     */
    public void setUbication(int ubication)
    {
        this._ubication = ubication;
        this._has_ubication = true;
    } //-- void setUbication(int) 

    /**
     * Method setWidthSets the value of field 'width'.
     * 
     * @param width the value of field 'width'.
     */
    public void setWidth(int width)
    {
        this._width = width;
        this._has_width = true;
    } //-- void setWidth(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DimensionProperty unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DimensionProperty) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DimensionProperty.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionProperty unmarshal(java.io.Reader) 

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
