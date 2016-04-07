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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Localizations.
 * 
 * @version $Revision$ $Date$
 */
public class Localizations implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _localizationList
     */
    private java.util.Vector _localizationList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Localizations() {
        super();
        _localizationList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.Localizations()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLocalization
     * 
     * @param vLocalization
     */
    public void addLocalization(com.calipso.reportgenerator.reportdefinitions.Localization vLocalization)
        throws java.lang.IndexOutOfBoundsException
    {
        _localizationList.addElement(vLocalization);
    } //-- void addLocalization(com.calipso.reportgenerator.reportdefinitions.Localization) 

    /**
     * Method addLocalization
     * 
     * @param index
     * @param vLocalization
     */
    public void addLocalization(int index, com.calipso.reportgenerator.reportdefinitions.Localization vLocalization)
        throws java.lang.IndexOutOfBoundsException
    {
        _localizationList.insertElementAt(vLocalization, index);
    } //-- void addLocalization(int, com.calipso.reportgenerator.reportdefinitions.Localization) 

    /**
     * Method enumerateLocalization
     */
    public java.util.Enumeration enumerateLocalization()
    {
        return _localizationList.elements();
    } //-- java.util.Enumeration enumerateLocalization() 

    /**
     * Method getLocalization
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Localization getLocalization(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _localizationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.Localization) _localizationList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.Localization getLocalization(int) 

    /**
     * Method getLocalization
     */
    public com.calipso.reportgenerator.reportdefinitions.Localization[] getLocalization()
    {
        int size = _localizationList.size();
        com.calipso.reportgenerator.reportdefinitions.Localization[] mArray = new com.calipso.reportgenerator.reportdefinitions.Localization[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.Localization) _localizationList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.Localization[] getLocalization() 

    /**
     * Method getLocalizationCount
     */
    public int getLocalizationCount()
    {
        return _localizationList.size();
    } //-- int getLocalizationCount() 

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
     * Method removeAllLocalization
     */
    public void removeAllLocalization()
    {
        _localizationList.removeAllElements();
    } //-- void removeAllLocalization() 

    /**
     * Method removeLocalization
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Localization removeLocalization(int index)
    {
        java.lang.Object obj = _localizationList.elementAt(index);
        _localizationList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.Localization) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.Localization removeLocalization(int) 

    /**
     * Method setLocalization
     * 
     * @param index
     * @param vLocalization
     */
    public void setLocalization(int index, com.calipso.reportgenerator.reportdefinitions.Localization vLocalization)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _localizationList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _localizationList.setElementAt(vLocalization, index);
    } //-- void setLocalization(int, com.calipso.reportgenerator.reportdefinitions.Localization) 

    /**
     * Method setLocalization
     * 
     * @param localizationArray
     */
    public void setLocalization(com.calipso.reportgenerator.reportdefinitions.Localization[] localizationArray)
    {
        //-- copy array
        _localizationList.removeAllElements();
        for (int i = 0; i < localizationArray.length; i++) {
            _localizationList.addElement(localizationArray[i]);
        }
    } //-- void setLocalization(com.calipso.reportgenerator.reportdefinitions.Localization) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.Localizations unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.Localizations) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.Localizations.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.Localizations unmarshal(java.io.Reader) 

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
