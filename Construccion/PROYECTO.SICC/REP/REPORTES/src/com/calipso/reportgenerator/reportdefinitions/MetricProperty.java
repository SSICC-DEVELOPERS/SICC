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
 * Class MetricProperty.
 * 
 * @version $Revision$ $Date$
 */
public class MetricProperty implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _metricName
     */
    private java.lang.String _metricName;

    /**
     * Field _visible
     */
    private boolean _visible = true;

    /**
     * keeps track of state for field: _visible
     */
    private boolean _has_visible;


      //----------------/
     //- Constructors -/
    //----------------/

    public MetricProperty() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperty()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteVisible
     */
    public void deleteVisible()
    {
        this._has_visible= false;
    } //-- void deleteVisible() 

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
     * Method getVisibleReturns the value of field 'visible'.
     * 
     * @return the value of field 'visible'.
     */
    public boolean getVisible()
    {
        return this._visible;
    } //-- boolean getVisible() 

    /**
     * Method hasVisible
     */
    public boolean hasVisible()
    {
        return this._has_visible;
    } //-- boolean hasVisible() 

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
     * Method setMetricNameSets the value of field 'metricName'.
     * 
     * @param metricName the value of field 'metricName'.
     */
    public void setMetricName(java.lang.String metricName)
    {
        this._metricName = metricName;
    } //-- void setMetricName(java.lang.String) 

    /**
     * Method setVisibleSets the value of field 'visible'.
     * 
     * @param visible the value of field 'visible'.
     */
    public void setVisible(boolean visible)
    {
        this._visible = visible;
        this._has_visible = true;
    } //-- void setVisible(boolean) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.MetricProperty unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.MetricProperty) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.MetricProperty.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.MetricProperty unmarshal(java.io.Reader) 

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
