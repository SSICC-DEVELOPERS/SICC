/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.calipso.reportgenerator.reportdefinitions;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class DrillDownDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class DrillDownDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _description
     */
    private java.lang.String _description;

    /**
     * Field _targetReportDefinitionID
     */
    private java.lang.String _targetReportDefinitionID;

    /**
     * Field _parameterBindList
     */
    private java.util.Vector _parameterBindList;

    /**
     * Field _dimensionBindList
     */
    private java.util.Vector _dimensionBindList;


      //----------------/
     //- Constructors -/
    //----------------/

    public DrillDownDefinition() {
        super();
        _parameterBindList = new Vector();
        _dimensionBindList = new Vector();
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDimensionBind
     * 
     * @param vDimensionBind
     */
    public void addDimensionBind(com.calipso.reportgenerator.reportdefinitions.DimensionBind vDimensionBind)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionBindList.addElement(vDimensionBind);
    } //-- void addDimensionBind(com.calipso.reportgenerator.reportdefinitions.DimensionBind) 

    /**
     * Method addDimensionBind
     * 
     * @param index
     * @param vDimensionBind
     */
    public void addDimensionBind(int index, com.calipso.reportgenerator.reportdefinitions.DimensionBind vDimensionBind)
        throws java.lang.IndexOutOfBoundsException
    {
        _dimensionBindList.insertElementAt(vDimensionBind, index);
    } //-- void addDimensionBind(int, com.calipso.reportgenerator.reportdefinitions.DimensionBind) 

    /**
     * Method addParameterBind
     * 
     * @param vParameterBind
     */
    public void addParameterBind(com.calipso.reportgenerator.reportdefinitions.ParameterBind vParameterBind)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterBindList.addElement(vParameterBind);
    } //-- void addParameterBind(com.calipso.reportgenerator.reportdefinitions.ParameterBind) 

    /**
     * Method addParameterBind
     * 
     * @param index
     * @param vParameterBind
     */
    public void addParameterBind(int index, com.calipso.reportgenerator.reportdefinitions.ParameterBind vParameterBind)
        throws java.lang.IndexOutOfBoundsException
    {
        _parameterBindList.insertElementAt(vParameterBind, index);
    } //-- void addParameterBind(int, com.calipso.reportgenerator.reportdefinitions.ParameterBind) 

    /**
     * Method enumerateDimensionBind
     */
    public java.util.Enumeration enumerateDimensionBind()
    {
        return _dimensionBindList.elements();
    } //-- java.util.Enumeration enumerateDimensionBind() 

    /**
     * Method enumerateParameterBind
     */
    public java.util.Enumeration enumerateParameterBind()
    {
        return _parameterBindList.elements();
    } //-- java.util.Enumeration enumerateParameterBind() 

    /**
     * Method getDescriptionReturns the value of field
     * 'description'.
     * 
     * @return the value of field 'description'.
     */
    public java.lang.String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Method getDimensionBind
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionBind getDimensionBind(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionBindList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.DimensionBind) _dimensionBindList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionBind getDimensionBind(int) 

    /**
     * Method getDimensionBind
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionBind[] getDimensionBind()
    {
        int size = _dimensionBindList.size();
        com.calipso.reportgenerator.reportdefinitions.DimensionBind[] mArray = new com.calipso.reportgenerator.reportdefinitions.DimensionBind[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.DimensionBind) _dimensionBindList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionBind[] getDimensionBind() 

    /**
     * Method getDimensionBindCount
     */
    public int getDimensionBindCount()
    {
        return _dimensionBindList.size();
    } //-- int getDimensionBindCount() 

    /**
     * Method getNameReturns the value of field 'name'.
     * 
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Method getParameterBind
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterBind getParameterBind(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterBindList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.calipso.reportgenerator.reportdefinitions.ParameterBind) _parameterBindList.elementAt(index);
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterBind getParameterBind(int) 

    /**
     * Method getParameterBind
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterBind[] getParameterBind()
    {
        int size = _parameterBindList.size();
        com.calipso.reportgenerator.reportdefinitions.ParameterBind[] mArray = new com.calipso.reportgenerator.reportdefinitions.ParameterBind[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.calipso.reportgenerator.reportdefinitions.ParameterBind) _parameterBindList.elementAt(index);
        }
        return mArray;
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterBind[] getParameterBind() 

    /**
     * Method getParameterBindCount
     */
    public int getParameterBindCount()
    {
        return _parameterBindList.size();
    } //-- int getParameterBindCount() 

    /**
     * Method getTargetReportDefinitionIDReturns the value of field
     * 'targetReportDefinitionID'.
     * 
     * @return the value of field 'targetReportDefinitionID'.
     */
    public java.lang.String getTargetReportDefinitionID()
    {
        return this._targetReportDefinitionID;
    } //-- java.lang.String getTargetReportDefinitionID() 

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllDimensionBind
     */
    public void removeAllDimensionBind()
    {
        _dimensionBindList.removeAllElements();
    } //-- void removeAllDimensionBind() 

    /**
     * Method removeAllParameterBind
     */
    public void removeAllParameterBind()
    {
        _parameterBindList.removeAllElements();
    } //-- void removeAllParameterBind() 

    /**
     * Method removeDimensionBind
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.DimensionBind removeDimensionBind(int index)
    {
        java.lang.Object obj = _dimensionBindList.elementAt(index);
        _dimensionBindList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.DimensionBind) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.DimensionBind removeDimensionBind(int) 

    /**
     * Method removeParameterBind
     * 
     * @param index
     */
    public com.calipso.reportgenerator.reportdefinitions.ParameterBind removeParameterBind(int index)
    {
        java.lang.Object obj = _parameterBindList.elementAt(index);
        _parameterBindList.removeElementAt(index);
        return (com.calipso.reportgenerator.reportdefinitions.ParameterBind) obj;
    } //-- com.calipso.reportgenerator.reportdefinitions.ParameterBind removeParameterBind(int) 

    /**
     * Method setDescriptionSets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(java.lang.String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Method setDimensionBind
     * 
     * @param index
     * @param vDimensionBind
     */
    public void setDimensionBind(int index, com.calipso.reportgenerator.reportdefinitions.DimensionBind vDimensionBind)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _dimensionBindList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _dimensionBindList.setElementAt(vDimensionBind, index);
    } //-- void setDimensionBind(int, com.calipso.reportgenerator.reportdefinitions.DimensionBind) 

    /**
     * Method setDimensionBind
     * 
     * @param dimensionBindArray
     */
    public void setDimensionBind(com.calipso.reportgenerator.reportdefinitions.DimensionBind[] dimensionBindArray)
    {
        //-- copy array
        _dimensionBindList.removeAllElements();
        for (int i = 0; i < dimensionBindArray.length; i++) {
            _dimensionBindList.addElement(dimensionBindArray[i]);
        }
    } //-- void setDimensionBind(com.calipso.reportgenerator.reportdefinitions.DimensionBind) 

    /**
     * Method setNameSets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Method setParameterBind
     * 
     * @param index
     * @param vParameterBind
     */
    public void setParameterBind(int index, com.calipso.reportgenerator.reportdefinitions.ParameterBind vParameterBind)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _parameterBindList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _parameterBindList.setElementAt(vParameterBind, index);
    } //-- void setParameterBind(int, com.calipso.reportgenerator.reportdefinitions.ParameterBind) 

    /**
     * Method setParameterBind
     * 
     * @param parameterBindArray
     */
    public void setParameterBind(com.calipso.reportgenerator.reportdefinitions.ParameterBind[] parameterBindArray)
    {
        //-- copy array
        _parameterBindList.removeAllElements();
        for (int i = 0; i < parameterBindArray.length; i++) {
            _parameterBindList.addElement(parameterBindArray[i]);
        }
    } //-- void setParameterBind(com.calipso.reportgenerator.reportdefinitions.ParameterBind) 

    /**
     * Method setTargetReportDefinitionIDSets the value of field
     * 'targetReportDefinitionID'.
     * 
     * @param targetReportDefinitionID the value of field
     * 'targetReportDefinitionID'.
     */
    public void setTargetReportDefinitionID(java.lang.String targetReportDefinitionID)
    {
        this._targetReportDefinitionID = targetReportDefinitionID;
    } //-- void setTargetReportDefinitionID(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition unmarshal(java.io.Reader) 

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
