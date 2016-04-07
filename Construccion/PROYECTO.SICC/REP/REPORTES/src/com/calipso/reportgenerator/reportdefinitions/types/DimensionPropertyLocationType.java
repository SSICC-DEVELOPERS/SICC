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
 * Class DimensionPropertyLocationType.
 * 
 * @version $Revision$ $Date$
 */
public class DimensionPropertyLocationType implements java.io.Serializable {


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
    public static final DimensionPropertyLocationType PAGE = new DimensionPropertyLocationType(PAGE_TYPE, "PAGE");

    /**
     * The COLUMN type
     */
    public static final int COLUMN_TYPE = 1;

    /**
     * The instance of the COLUMN type
     */
    public static final DimensionPropertyLocationType COLUMN = new DimensionPropertyLocationType(COLUMN_TYPE, "COLUMN");

    /**
     * The ROW type
     */
    public static final int ROW_TYPE = 2;

    /**
     * The instance of the ROW type
     */
    public static final DimensionPropertyLocationType ROW = new DimensionPropertyLocationType(ROW_TYPE, "ROW");

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

    private DimensionPropertyLocationType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DimensionPropertyLocationType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * DimensionPropertyLocationType
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
        members.put("COLUMN", COLUMN);
        members.put("ROW", ROW);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DimensionPropertyLocationType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new DimensionPropertyLocationType
     * based on the given String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DimensionPropertyLocationType";
            throw new IllegalArgumentException(err);
        }
        return (DimensionPropertyLocationType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DimensionPropertyLocationType valueOf(java.lang.String) 

}
