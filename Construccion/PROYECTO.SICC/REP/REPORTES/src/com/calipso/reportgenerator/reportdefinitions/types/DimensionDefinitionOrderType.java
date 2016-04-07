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
 * Class DimensionDefinitionOrderType.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionDefinitionOrderType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The A type
     */
    public static final int A_TYPE = 0;

    /**
     * The instance of the A type
     */
    public static final DimensionDefinitionOrderType A = new DimensionDefinitionOrderType(A_TYPE, "A");

    /**
     * The D type
     */
    public static final int D_TYPE = 1;

    /**
     * The instance of the D type
     */
    public static final DimensionDefinitionOrderType D = new DimensionDefinitionOrderType(D_TYPE, "D");

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

    private DimensionDefinitionOrderType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DimensionDefinitionOrderType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * DimensionDefinitionOrderType
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
        members.put("A", A);
        members.put("D", D);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DimensionDefinitionOrderType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new DimensionDefinitionOrderType
     * based on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DimensionDefinitionOrderType";
            throw new IllegalArgumentException(err);
        }
        return (DimensionDefinitionOrderType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType valueOf(java.lang.String) 

}
