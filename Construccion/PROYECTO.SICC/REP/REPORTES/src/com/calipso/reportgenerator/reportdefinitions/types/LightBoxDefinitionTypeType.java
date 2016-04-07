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
 * Class LightBoxDefinitionTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class LightBoxDefinitionTypeType implements java.io.Serializable {


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
    public static final LightBoxDefinitionTypeType RANGE = new LightBoxDefinitionTypeType(RANGE_TYPE, "RANGE");

    /**
     * The GREATERTHAN type
     */
    public static final int GREATERTHAN_TYPE = 1;

    /**
     * The instance of the GREATERTHAN type
     */
    public static final LightBoxDefinitionTypeType GREATERTHAN = new LightBoxDefinitionTypeType(GREATERTHAN_TYPE, "GREATERTHAN");

    /**
     * The GREATEREQUALTHAN type
     */
    public static final int GREATEREQUALTHAN_TYPE = 2;

    /**
     * The instance of the GREATEREQUALTHAN type
     */
    public static final LightBoxDefinitionTypeType GREATEREQUALTHAN = new LightBoxDefinitionTypeType(GREATEREQUALTHAN_TYPE, "GREATEREQUALTHAN");

    /**
     * The LESSTHAN type
     */
    public static final int LESSTHAN_TYPE = 3;

    /**
     * The instance of the LESSTHAN type
     */
    public static final LightBoxDefinitionTypeType LESSTHAN = new LightBoxDefinitionTypeType(LESSTHAN_TYPE, "LESSTHAN");

    /**
     * The LESSEQUALTHAN type
     */
    public static final int LESSEQUALTHAN_TYPE = 4;

    /**
     * The instance of the LESSEQUALTHAN type
     */
    public static final LightBoxDefinitionTypeType LESSEQUALTHAN = new LightBoxDefinitionTypeType(LESSEQUALTHAN_TYPE, "LESSEQUALTHAN");

    /**
     * The EQUAL type
     */
    public static final int EQUAL_TYPE = 5;

    /**
     * The instance of the EQUAL type
     */
    public static final LightBoxDefinitionTypeType EQUAL = new LightBoxDefinitionTypeType(EQUAL_TYPE, "EQUAL");

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

    private LightBoxDefinitionTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of LightBoxDefinitionTypeType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * LightBoxDefinitionTypeType
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
        members.put("GREATEREQUALTHAN", GREATEREQUALTHAN);
        members.put("LESSTHAN", LESSTHAN);
        members.put("LESSEQUALTHAN", LESSEQUALTHAN);
        members.put("EQUAL", EQUAL);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * LightBoxDefinitionTypeType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new LightBoxDefinitionTypeType based
     * on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid LightBoxDefinitionTypeType";
            throw new IllegalArgumentException(err);
        }
        return (LightBoxDefinitionTypeType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionTypeType valueOf(java.lang.String) 

}
