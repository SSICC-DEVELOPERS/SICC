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
 * Class LightBoxDefinitionParameterType.
 * 
 * @version $Revision$ $Date$
 */
public class LightBoxDefinitionParameterType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The FROM type
     */
    public static final int FROM_TYPE = 0;

    /**
     * The instance of the FROM type
     */
    public static final LightBoxDefinitionParameterType FROM = new LightBoxDefinitionParameterType(FROM_TYPE, "FROM");

    /**
     * The TO type
     */
    public static final int TO_TYPE = 1;

    /**
     * The instance of the TO type
     */
    public static final LightBoxDefinitionParameterType TO = new LightBoxDefinitionParameterType(TO_TYPE, "TO");

    /**
     * The VALUE type
     */
    public static final int VALUE_TYPE = 2;

    /**
     * The instance of the VALUE type
     */
    public static final LightBoxDefinitionParameterType VALUE = new LightBoxDefinitionParameterType(VALUE_TYPE, "VALUE");

    /**
     * The VALUES type
     */
    public static final int VALUES_TYPE = 3;

    /**
     * The instance of the VALUES type
     */
    public static final LightBoxDefinitionParameterType VALUES = new LightBoxDefinitionParameterType(VALUES_TYPE, "VALUES");

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

    private LightBoxDefinitionParameterType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of LightBoxDefinitionParameterType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * LightBoxDefinitionParameterType
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
        members.put("FROM", FROM);
        members.put("TO", TO);
        members.put("VALUE", VALUE);
        members.put("VALUES", VALUES);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * LightBoxDefinitionParameterType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new LightBoxDefinitionParameterType
     * based on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid LightBoxDefinitionParameterType";
            throw new IllegalArgumentException(err);
        }
        return (LightBoxDefinitionParameterType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.LightBoxDefinitionParameterType valueOf(java.lang.String) 

}
