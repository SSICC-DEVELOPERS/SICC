/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.calipso.reportgenerator.reportdefinitions.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ReportDataType.
 * 
 * @version $Revision$ $Date$
 */
public class ReportDataType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The DATE type
     */
    public static final int DATE_TYPE = 0;

    /**
     * The instance of the DATE type
     */
    public static final ReportDataType DATE = new ReportDataType(DATE_TYPE, "DATE");

    /**
     * The DATETIME type
     */
    public static final int DATETIME_TYPE = 1;

    /**
     * The instance of the DATETIME type
     */
    public static final ReportDataType DATETIME = new ReportDataType(DATETIME_TYPE, "DATETIME");

    /**
     * The STRING type
     */
    public static final int STRING_TYPE = 2;

    /**
     * The instance of the STRING type
     */
    public static final ReportDataType STRING = new ReportDataType(STRING_TYPE, "STRING");

    /**
     * The FLOAT type
     */
    public static final int FLOAT_TYPE = 3;

    /**
     * The instance of the FLOAT type
     */
    public static final ReportDataType FLOAT = new ReportDataType(FLOAT_TYPE, "FLOAT");

    /**
     * The INTEGER type
     */
    public static final int INTEGER_TYPE = 4;

    /**
     * The instance of the INTEGER type
     */
    public static final ReportDataType INTEGER = new ReportDataType(INTEGER_TYPE, "INTEGER");

    /**
     * The BOOLEAN type
     */
    public static final int BOOLEAN_TYPE = 5;

    /**
     * The instance of the BOOLEAN type
     */
    public static final ReportDataType BOOLEAN = new ReportDataType(BOOLEAN_TYPE, "BOOLEAN");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ReportDataType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.ReportDataType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of ReportDataType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this ReportDataType
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("DATE", DATE);
        members.put("DATETIME", DATETIME);
        members.put("STRING", STRING);
        members.put("FLOAT", FLOAT);
        members.put("INTEGER", INTEGER);
        members.put("BOOLEAN", BOOLEAN);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * ReportDataType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new ReportDataType based on the
     * given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.ReportDataType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ReportDataType";
            throw new IllegalArgumentException(err);
        }
        return (ReportDataType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.ReportDataType valueOf(java.lang.String) 

}
