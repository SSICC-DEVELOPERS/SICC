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
 * Class Localization.
 * 
 * @version $Revision$ $Date$
 */
public class Localization implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _locale
     */
    private java.lang.String _locale;

    /**
     * Field _literalsList
     */
    private java.util.Vector _literalsList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Localization() {
        super();
        _literalsList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.Localization()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addLiterals
     * 
     * @param vLiterals
     */
    public void addLiterals(com.calipso.reportgenerator.reportdefinitions.Literals vLiterals)
        throws java.lang.IndexOutOfBoundsException
    {
        _literalsList.addElement(vLiterals);
    } //-- void addLiterals(com.calipso.reportgenerator.reportdefinitions.Literals) 

    /**
     * Method addLiterals
     * 
     * @param index
     * @param vLiterals
     */
    public void addLiterals(int index, com.calipso.reportgenerator.reportdefinitions.Literals vLiterals)
        throws java.lang.IndexOutOfBoundsException
    {
        _literalsList.insertElementAt(vLiterals, index);
    } //-- void addLiterals(int, com.calipso.reportgenerator.reportdefinitions.Literals) 

    /**
     * Method enumerateLiterals
     */
    public java.util.Enumeration enumerateLiterals()
    {
        return _literalsList.elements();
    } //-- java.util.Enumeration enumerateLiterals() 

    /**
     * Method getLiterals
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Literals getLiterals(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _literalsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.Literals) _literalsList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.Literals getLiterals(int) 

    /**
     * Method getLiterals
     */
    public com.calipso.reportgenerator.reportdefinitions.Literals[] getLiterals()
    {
        int size = _literalsList.size();
        com.calipso.reportgenerator.reportdefinitions.Literals[] mArray = new com.calipso.reportgenerator.reportdefinitions.Literals[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.Literals) _literalsList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.Literals[] getLiterals() 

    /**
     * Method getLiteralsCount
     */
    public int getLiteralsCount()
    {
        return _literalsList.size();
    } //-- int getLiteralsCount() 

    /**
     * Method getLocaleReturns the value of field 'locale'.
     * 
     * @return the value of field 'locale'.
     */
    public java.lang.String getLocale()
    {
        return this._locale;
    } //-- java.lang.String getLocale() 

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
     * Method removeAllLiterals
     */
    public void removeAllLiterals()
    {
        _literalsList.removeAllElements();
    } //-- void removeAllLiterals() 

    /**
     * Method removeLiterals
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.Literals removeLiterals(int index)
    {
        java.lang.Object obj = _literalsList.elementAt(index);
        _literalsList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.Literals) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.Literals removeLiterals(int) 

    /**
     * Method setLiterals
     * 
     * @param index
     * @param vLiterals
     */
    public void setLiterals(int index, com.calipso.reportgenerator.reportdefinitions.Literals vLiterals)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _literalsList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _literalsList.setElementAt(vLiterals, index);
    } //-- void setLiterals(int, com.calipso.reportgenerator.reportdefinitions.Literals) 

    /**
     * Method setLiterals
     * 
     * @param literalsArray
     */
    public void setLiterals(com.calipso.reportgenerator.reportdefinitions.Literals[] literalsArray)
    {
        //-- copy array
        _literalsList.removeAllElements();
        for (int i = 0; i < literalsArray.length; i++) {
            _literalsList.addElement(literalsArray[i]);
        }
    } //-- void setLiterals(com.calipso.reportgenerator.reportdefinitions.Literals) 

    /**
     * Method setLocaleSets the value of field 'locale'.
     * 
     * @param locale the value of field 'locale'.
     */
    public void setLocale(java.lang.String locale)
    {
        this._locale = locale;
    } //-- void setLocale(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.Localization unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.Localization) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.Localization.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.Localization unmarshal(java.io.Reader) 

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
