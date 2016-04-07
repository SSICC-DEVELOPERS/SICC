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
 * Class FilterDefinitionFilterTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class FilterDefinitionFilterTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The RANGE type
     */
    public static final int RANGE_TYPE = 0;

    /**
     * The instance of the RANGE type
     */
    public static final FilterDefinitionFilterTypeType RANGE = new FilterDefinitionFilterTypeType(RANGE_TYPE, "RANGE");

    /**
     * The GREATERTHAN type
     */
    public static final int GREATERTHAN_TYPE = 1;

    /**
     * The instance of the GREATERTHAN type
     */
    public static final FilterDefinitionFilterTypeType GREATERTHAN = new FilterDefinitionFilterTypeType(GREATERTHAN_TYPE, "GREATERTHAN");

    /**
     * The LESSTHAN type
     */
    public static final int LESSTHAN_TYPE = 2;

    /**
     * The instance of the LESSTHAN type
     */
    public static final FilterDefinitionFilterTypeType LESSTHAN = new FilterDefinitionFilterTypeType(LESSTHAN_TYPE, "LESSTHAN");

    /**
     * The EQUALTO type
     */
    public static final int EQUALTO_TYPE = 3;

    /**
     * The instance of the EQUALTO type
     */
    public static final FilterDefinitionFilterTypeType EQUALTO = new FilterDefinitionFilterTypeType(EQUALTO_TYPE, "EQUALTO");

    /**
     * The BEGINWITH type
     */
    public static final int BEGINWITH_TYPE = 4;

    /**
     * The instance of the BEGINWITH type
     */
    public static final FilterDefinitionFilterTypeType BEGINWITH = new FilterDefinitionFilterTypeType(BEGINWITH_TYPE, "BEGINWITH");

    /**
     * The ENDWITH type
     */
    public static final int ENDWITH_TYPE = 5;

    /**
     * The instance of the ENDWITH type
     */
    public static final FilterDefinitionFilterTypeType ENDWITH = new FilterDefinitionFilterTypeType(ENDWITH_TYPE, "ENDWITH");

    /**
     * The INCLUDES type
     */
    public static final int INCLUDES_TYPE = 6;

    /**
     * The instance of the INCLUDES type
     */
    public static final FilterDefinitionFilterTypeType INCLUDES = new FilterDefinitionFilterTypeType(INCLUDES_TYPE, "INCLUDES");

    /**
     * The RANKING type
     */
    public static final int RANKING_TYPE = 7;

    /**
     * The instance of the RANKING type
     */
    public static final FilterDefinitionFilterTypeType RANKING = new FilterDefinitionFilterTypeType(RANKING_TYPE, "RANKING");

    /**
     * The IN type
     */
    public static final int IN_TYPE = 8;

    /**
     * The instance of the IN type
     */
    public static final FilterDefinitionFilterTypeType IN = new FilterDefinitionFilterTypeType(IN_TYPE, "IN");

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

    private FilterDefinitionFilterTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of FilterDefinitionFilterTypeType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * FilterDefinitionFilterTypeType
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
        members.put("RANGE", RANGE);
        members.put("GREATERTHAN", GREATERTHAN);
        members.put("LESSTHAN", LESSTHAN);
        members.put("EQUALTO", EQUALTO);
        members.put("BEGINWITH", BEGINWITH);
        members.put("ENDWITH", ENDWITH);
        members.put("INCLUDES", INCLUDES);
        members.put("RANKING", RANKING);
        members.put("IN", IN);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * FilterDefinitionFilterTypeType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new FilterDefinitionFilterTypeType
     * based on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid FilterDefinitionFilterTypeType";
            throw new IllegalArgumentException(err);
        }
        return (FilterDefinitionFilterTypeType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType valueOf(java.lang.String) 

}
