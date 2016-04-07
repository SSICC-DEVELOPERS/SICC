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
 * Class MetricSourceDefinitionGroupFooterTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class MetricSourceDefinitionGroupFooterTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The NONE type
     */
    public static final int NONE_TYPE = 0;

    /**
     * The instance of the NONE type
     */
    public static final MetricSourceDefinitionGroupFooterTypeType NONE = new MetricSourceDefinitionGroupFooterTypeType(NONE_TYPE, "NONE");

    /**
     * The SUM type
     */
    public static final int SUM_TYPE = 1;

    /**
     * The instance of the SUM type
     */
    public static final MetricSourceDefinitionGroupFooterTypeType SUM = new MetricSourceDefinitionGroupFooterTypeType(SUM_TYPE, "SUM");

    /**
     * The AVERAGE type
     */
    public static final int AVERAGE_TYPE = 2;

    /**
     * The instance of the AVERAGE type
     */
    public static final MetricSourceDefinitionGroupFooterTypeType AVERAGE = new MetricSourceDefinitionGroupFooterTypeType(AVERAGE_TYPE, "AVERAGE");

    /**
     * The COUNT type
     */
    public static final int COUNT_TYPE = 3;

    /**
     * The instance of the COUNT type
     */
    public static final MetricSourceDefinitionGroupFooterTypeType COUNT = new MetricSourceDefinitionGroupFooterTypeType(COUNT_TYPE, "COUNT");

    /**
     * The CALCULATED type
     */
    public static final int CALCULATED_TYPE = 4;

    /**
     * The instance of the CALCULATED type
     */
    public static final MetricSourceDefinitionGroupFooterTypeType CALCULATED = new MetricSourceDefinitionGroupFooterTypeType(CALCULATED_TYPE, "CALCULATED");

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

    private MetricSourceDefinitionGroupFooterTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionGroupFooterTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of MetricSourceDefinitionGroupFooterTypeType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * MetricSourceDefinitionGroupFooterTypeType
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
        members.put("NONE", NONE);
        members.put("SUM", SUM);
        members.put("AVERAGE", AVERAGE);
        members.put("COUNT", COUNT);
        members.put("CALCULATED", CALCULATED);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * MetricSourceDefinitionGroupFooterTypeType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new
     * MetricSourceDefinitionGroupFooterTypeType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionGroupFooterTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MetricSourceDefinitionGroupFooterTypeType";
            throw new IllegalArgumentException(err);
        }
        return (MetricSourceDefinitionGroupFooterTypeType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionGroupFooterTypeType valueOf(java.lang.String) 

}
