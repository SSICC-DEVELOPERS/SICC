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
 * Class DataSourceDefinitionSourceTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class DataSourceDefinitionSourceTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The SQL type
     */
    public static final int SQL_TYPE = 0;

    /**
     * The instance of the SQL type
     */
    public static final DataSourceDefinitionSourceTypeType SQL = new DataSourceDefinitionSourceTypeType(SQL_TYPE, "SQL");

    /**
     * The XML type
     */
    public static final int XML_TYPE = 1;

    /**
     * The instance of the XML type
     */
    public static final DataSourceDefinitionSourceTypeType XML = new DataSourceDefinitionSourceTypeType(XML_TYPE, "XML");

    /**
     * The BDLQL type
     */
    public static final int BDLQL_TYPE = 2;

    /**
     * The instance of the BDLQL type
     */
    public static final DataSourceDefinitionSourceTypeType BDLQL = new DataSourceDefinitionSourceTypeType(BDLQL_TYPE, "BDLQL");

    /**
     * The EXT type
     */
    public static final int EXT_TYPE = 3;

    /**
     * The instance of the EXT type
     */
    public static final DataSourceDefinitionSourceTypeType EXT = new DataSourceDefinitionSourceTypeType(EXT_TYPE, "EXT");

    /**
     * The OQL type
     */
    public static final int OQL_TYPE = 4;

    /**
     * The instance of the OQL type
     */
    public static final DataSourceDefinitionSourceTypeType OQL = new DataSourceDefinitionSourceTypeType(OQL_TYPE, "OQL");

    /**
     * The CALC type
     */
    public static final int CALC_TYPE = 5;

    /**
     * The instance of the CALC type
     */
    public static final DataSourceDefinitionSourceTypeType CALC = new DataSourceDefinitionSourceTypeType(CALC_TYPE, "CALC");

    /**
     * The EXCEL type
     */
    public static final int EXCEL_TYPE = 6;

    /**
     * The instance of the EXCEL type
     */
    public static final DataSourceDefinitionSourceTypeType EXCEL = new DataSourceDefinitionSourceTypeType(EXCEL_TYPE, "EXCEL");

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

    private DataSourceDefinitionSourceTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DataSourceDefinitionSourceTypeType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * DataSourceDefinitionSourceTypeType
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
        members.put("SQL", SQL);
        members.put("XML", XML);
        members.put("BDLQL", BDLQL);
        members.put("EXT", EXT);
        members.put("OQL", OQL);
        members.put("CALC", CALC);
        members.put("EXCEL", EXCEL);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DataSourceDefinitionSourceTypeType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new
     * DataSourceDefinitionSourceTypeType based on the given String
     * value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DataSourceDefinitionSourceTypeType";
            throw new IllegalArgumentException(err);
        }
        return (DataSourceDefinitionSourceTypeType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType valueOf(java.lang.String) 

}
