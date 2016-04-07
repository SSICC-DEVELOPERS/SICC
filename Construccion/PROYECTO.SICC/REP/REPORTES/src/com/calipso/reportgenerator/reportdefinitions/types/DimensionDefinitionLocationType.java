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
 * Class DimensionDefinitionLocationType.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionDefinitionLocationType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The PAGE type
     */
    public static final int PAGE_TYPE = 0;

    /**
     * The instance of the PAGE type
     */
    public static final DimensionDefinitionLocationType PAGE = new DimensionDefinitionLocationType(PAGE_TYPE, "PAGE");

    /**
     * The ROW type
     */
    public static final int ROW_TYPE = 1;

    /**
     * The instance of the ROW type
     */
    public static final DimensionDefinitionLocationType ROW = new DimensionDefinitionLocationType(ROW_TYPE, "ROW");

    /**
     * The COLUMN type
     */
    public static final int COLUMN_TYPE = 2;

    /**
     * The instance of the COLUMN type
     */
    public static final DimensionDefinitionLocationType COLUMN = new DimensionDefinitionLocationType(COLUMN_TYPE, "COLUMN");

    /**
     * The HIDDEN type
     */
    public static final int HIDDEN_TYPE = 3;

    /**
     * The instance of the HIDDEN type
     */
    public static final DimensionDefinitionLocationType HIDDEN = new DimensionDefinitionLocationType(HIDDEN_TYPE, "HIDDEN");

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

    private DimensionDefinitionLocationType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DimensionDefinitionLocationType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * DimensionDefinitionLocationType
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
        members.put("PAGE", PAGE);
        members.put("ROW", ROW);
        members.put("COLUMN", COLUMN);
        members.put("HIDDEN", HIDDEN);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DimensionDefinitionLocationType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new DimensionDefinitionLocationType
     * based on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DimensionDefinitionLocationType";
            throw new IllegalArgumentException(err);
        }
        return (DimensionDefinitionLocationType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType valueOf(java.lang.String) 

}
