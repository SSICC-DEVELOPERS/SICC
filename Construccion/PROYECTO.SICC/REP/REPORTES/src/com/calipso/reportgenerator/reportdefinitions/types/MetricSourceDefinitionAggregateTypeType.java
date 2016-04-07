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
 * Class MetricSourceDefinitionAggregateTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class MetricSourceDefinitionAggregateTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The SUM type
     */
    public static final int SUM_TYPE = 0;

    /**
     * The instance of the SUM type
     */
    public static final MetricSourceDefinitionAggregateTypeType SUM = new MetricSourceDefinitionAggregateTypeType(SUM_TYPE, "SUM");

    /**
     * The COUNT type
     */
    public static final int COUNT_TYPE = 1;

    /**
     * The instance of the COUNT type
     */
    public static final MetricSourceDefinitionAggregateTypeType COUNT = new MetricSourceDefinitionAggregateTypeType(COUNT_TYPE, "COUNT");

    /**
     * The AVERAGE type
     */
    public static final int AVERAGE_TYPE = 2;

    /**
     * The instance of the AVERAGE type
     */
    public static final MetricSourceDefinitionAggregateTypeType AVERAGE = new MetricSourceDefinitionAggregateTypeType(AVERAGE_TYPE, "AVERAGE");

    /**
     * The MAX type
     */
    public static final int MAX_TYPE = 3;

    /**
     * The instance of the MAX type
     */
    public static final MetricSourceDefinitionAggregateTypeType MAX = new MetricSourceDefinitionAggregateTypeType(MAX_TYPE, "MAX");

    /**
     * The MIN type
     */
    public static final int MIN_TYPE = 4;

    /**
     * The instance of the MIN type
     */
    public static final MetricSourceDefinitionAggregateTypeType MIN = new MetricSourceDefinitionAggregateTypeType(MIN_TYPE, "MIN");

    /**
     * The CALCULATED type
     */
    public static final int CALCULATED_TYPE = 5;

    /**
     * The instance of the CALCULATED type
     */
    public static final MetricSourceDefinitionAggregateTypeType CALCULATED = new MetricSourceDefinitionAggregateTypeType(CALCULATED_TYPE, "CALCULATED");

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

    private MetricSourceDefinitionAggregateTypeType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionAggregateTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of MetricSourceDefinitionAggregateTypeType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this
     * MetricSourceDefinitionAggregateTypeType
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
        members.put("SUM", SUM);
        members.put("COUNT", COUNT);
        members.put("AVERAGE", AVERAGE);
        members.put("MAX", MAX);
        members.put("MIN", MIN);
        members.put("CALCULATED", CALCULATED);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * MetricSourceDefinitionAggregateTypeType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new
     * MetricSourceDefinitionAggregateTypeType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionAggregateTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid MetricSourceDefinitionAggregateTypeType";
            throw new IllegalArgumentException(err);
        }
        return (MetricSourceDefinitionAggregateTypeType) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.MetricSourceDefinitionAggregateTypeType valueOf(java.lang.String) 

}
