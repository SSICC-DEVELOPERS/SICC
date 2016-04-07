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

import com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class DataSourceDefinition.
 * 
 * @version $Revision$ $Date$
 */
public class DataSourceDefinition implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _sourceType
     */
    private com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType _sourceType;

    /**
     * Field _expression
     */
    private java.lang.String _expression;

    /**
     * Field _externalClassName
     */
    private java.lang.String _externalClassName;

    /**
     * Field _externalSourceData
     */
    private java.lang.String _externalSourceData;

    /**
     * Field _externalConnectionString
     */
    private java.lang.String _externalConnectionString;

    /**
     * Field _externalConnectionClassName
     */
    private java.lang.String _externalConnectionClassName;

    /**
     * Field _externalConnectionLocalUrl
     */
    private java.lang.String _externalConnectionLocalUrl;

    /**
     * Field _externalConnectionDistributedUrl
     */
    private java.lang.String _externalConnectionDistributedUrl;

    /**
     * Field _externalConnectionUser
     */
    private java.lang.String _externalConnectionUser;

    /**
     * Field _externalConnectionPassword
     */
    private java.lang.String _externalConnectionPassword;

    /**
     * Field _datePattern
     */
    private java.lang.String _datePattern;

    /**
     * Fiels _floatPattern
     */
    private String _floatPattern;
    
    /**
     * Field _dateTimePattern
     */
    private java.lang.String _dateTimePattern;

    /**
     * Field _sheetName
     */
    private java.lang.String _sheetName;

    /**
     * Field _dataInitialCell
     */
    private java.lang.String _dataInitialCell;

    /**
     * Field _dataEndingCell
     */
    private java.lang.String _dataEndingCell;


      //----------------/
     //- Constructors -/
    //----------------/

    public DataSourceDefinition() {
        super();
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getDataEndingCellReturns the value of field
     * 'dataEndingCell'.
     * 
     * @return the value of field 'dataEndingCell'.
     */
    public java.lang.String getDataEndingCell()
    {
        return this._dataEndingCell;
    } //-- java.lang.String getDataEndingCell() 

    /**
     * Method getDataInitialCellReturns the value of field
     * 'dataInitialCell'.
     * 
     * @return the value of field 'dataInitialCell'.
     */
    public java.lang.String getDataInitialCell()
    {
        return this._dataInitialCell;
    } //-- java.lang.String getDataInitialCell() 

    /**
     * Method getDatePatternReturns the value of field
     * 'datePattern'.
     * 
     * @return the value of field 'datePattern'.
     */
    public java.lang.String getDatePattern()
    {
        return this._datePattern;
    } //-- java.lang.String getDatePattern() 

    /**
     * Method getFloatPattern Returns the value of field
     * 'floatPattern'.
     * 
     * @return the value of field 'floatPattern'. 
     */
    public String getFloatPattern() {
		return _floatPattern;
	}//-- java.lang.String getFloatPattern()
    
    /**
     * Method getDateTimePatternReturns the value of field
     * 'dateTimePattern'.
     * 
     * @return the value of field 'dateTimePattern'.
     */
    public java.lang.String getDateTimePattern()
    {
        return this._dateTimePattern;
    } //-- java.lang.String getDateTimePattern() 

    /**
     * Method getExpressionReturns the value of field 'expression'.
     * 
     * @return the value of field 'expression'.
     */
    public java.lang.String getExpression()
    {
        return this._expression;
    } //-- java.lang.String getExpression() 

    /**
     * Method getExternalClassNameReturns the value of field
     * 'externalClassName'.
     * 
     * @return the value of field 'externalClassName'.
     */
    public java.lang.String getExternalClassName()
    {
        return this._externalClassName;
    } //-- java.lang.String getExternalClassName() 

    /**
     * Method getExternalConnectionClassNameReturns the value of
     * field 'externalConnectionClassName'.
     * 
     * @return the value of field 'externalConnectionClassName'.
     */
    public java.lang.String getExternalConnectionClassName()
    {
        return this._externalConnectionClassName;
    } //-- java.lang.String getExternalConnectionClassName() 

    /**
     * Method getExternalConnectionDistributedUrlReturns the value
     * of field 'externalConnectionDistributedUrl'.
     * 
     * @return the value of field 'externalConnectionDistributedUrl'
     */
    public java.lang.String getExternalConnectionDistributedUrl()
    {
        return this._externalConnectionDistributedUrl;
    } //-- java.lang.String getExternalConnectionDistributedUrl() 

    /**
     * Method getExternalConnectionLocalUrlReturns the value of
     * field 'externalConnectionLocalUrl'.
     * 
     * @return the value of field 'externalConnectionLocalUrl'.
     */
    public java.lang.String getExternalConnectionLocalUrl()
    {
        return this._externalConnectionLocalUrl;
    } //-- java.lang.String getExternalConnectionLocalUrl() 

    /**
     * Method getExternalConnectionPasswordReturns the value of
     * field 'externalConnectionPassword'.
     * 
     * @return the value of field 'externalConnectionPassword'.
     */
    public java.lang.String getExternalConnectionPassword()
    {
        return this._externalConnectionPassword;
    } //-- java.lang.String getExternalConnectionPassword() 

    /**
     * Method getExternalConnectionStringReturns the value of field
     * 'externalConnectionString'.
     * 
     * @return the value of field 'externalConnectionString'.
     */
    public java.lang.String getExternalConnectionString()
    {
        return this._externalConnectionString;
    } //-- java.lang.String getExternalConnectionString() 

    /**
     * Method getExternalConnectionUserReturns the value of field
     * 'externalConnectionUser'.
     * 
     * @return the value of field 'externalConnectionUser'.
     */
    public java.lang.String getExternalConnectionUser()
    {
        return this._externalConnectionUser;
    } //-- java.lang.String getExternalConnectionUser() 

    /**
     * Method getExternalSourceDataReturns the value of field
     * 'externalSourceData'.
     * 
     * @return the value of field 'externalSourceData'.
     */
    public java.lang.String getExternalSourceData()
    {
        return this._externalSourceData;
    } //-- java.lang.String getExternalSourceData() 

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
     * Method getSheetNameReturns the value of field 'sheetName'.
     * 
     * @return the value of field 'sheetName'.
     */
    public java.lang.String getSheetName()
    {
        return this._sheetName;
    } //-- java.lang.String getSheetName() 

    /**
     * Method getSourceTypeReturns the value of field 'sourceType'.
     * 
     * @return the value of field 'sourceType'.
     */
    public com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType getSourceType()
    {
        return this._sourceType;
    } //-- com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType getSourceType() 

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
     * Method setDataEndingCellSets the value of field
     * 'dataEndingCell'.
     * 
     * @param dataEndingCell the value of field 'dataEndingCell'.
     */
    public void setDataEndingCell(java.lang.String dataEndingCell)
    {
        this._dataEndingCell = dataEndingCell;
    } //-- void setDataEndingCell(java.lang.String) 

    /**
     * Method setDataInitialCellSets the value of field
     * 'dataInitialCell'.
     * 
     * @param dataInitialCell the value of field 'dataInitialCell'.
     */
    public void setDataInitialCell(java.lang.String dataInitialCell)
    {
        this._dataInitialCell = dataInitialCell;
    } //-- void setDataInitialCell(java.lang.String) 

    /**
     * Method setDatePatternSets the value of field 'datePattern'.
     * 
     * @param datePattern the value of field 'datePattern'.
     */
    public void setDatePattern(java.lang.String datePattern)
    {
        this._datePattern = datePattern;
    } //-- void setDatePattern(java.lang.String) 

    /**
     * Method setFloatPattern Sets the value of field 'floatPattern'.
     * 
     * @param floatPattern the value of field 'floatPattern'.
     */
	public void setFloatPattern(String pattern) {
		_floatPattern = pattern;
	}//-- void setFloatPattern(java.lang.String)
    
    /**
     * Method setDateTimePatternSets the value of field
     * 'dateTimePattern'.
     * 
     * @param dateTimePattern the value of field 'dateTimePattern'.
     */
    public void setDateTimePattern(java.lang.String dateTimePattern)
    {
        this._dateTimePattern = dateTimePattern;
    } //-- void setDateTimePattern(java.lang.String) 

    /**
     * Method setExpressionSets the value of field 'expression'.
     * 
     * @param expression the value of field 'expression'.
     */
    public void setExpression(java.lang.String expression)
    {
        this._expression = expression;
    } //-- void setExpression(java.lang.String) 

    /**
     * Method setExternalClassNameSets the value of field
     * 'externalClassName'.
     * 
     * @param externalClassName the value of field
     * 'externalClassName'.
     */
    public void setExternalClassName(java.lang.String externalClassName)
    {
        this._externalClassName = externalClassName;
    } //-- void setExternalClassName(java.lang.String) 

    /**
     * Method setExternalConnectionClassNameSets the value of field
     * 'externalConnectionClassName'.
     * 
     * @param externalConnectionClassName the value of field
     * 'externalConnectionClassName'.
     */
    public void setExternalConnectionClassName(java.lang.String externalConnectionClassName)
    {
        this._externalConnectionClassName = externalConnectionClassName;
    } //-- void setExternalConnectionClassName(java.lang.String) 

    /**
     * Method setExternalConnectionDistributedUrlSets the value of
     * field 'externalConnectionDistributedUrl'.
     * 
     * @param externalConnectionDistributedUrl the value of field
     * 'externalConnectionDistributedUrl'.
     */
    public void setExternalConnectionDistributedUrl(java.lang.String externalConnectionDistributedUrl)
    {
        this._externalConnectionDistributedUrl = externalConnectionDistributedUrl;
    } //-- void setExternalConnectionDistributedUrl(java.lang.String) 

    /**
     * Method setExternalConnectionLocalUrlSets the value of field
     * 'externalConnectionLocalUrl'.
     * 
     * @param externalConnectionLocalUrl the value of field
     * 'externalConnectionLocalUrl'.
     */
    public void setExternalConnectionLocalUrl(java.lang.String externalConnectionLocalUrl)
    {
        this._externalConnectionLocalUrl = externalConnectionLocalUrl;
    } //-- void setExternalConnectionLocalUrl(java.lang.String) 

    /**
     * Method setExternalConnectionPasswordSets the value of field
     * 'externalConnectionPassword'.
     * 
     * @param externalConnectionPassword the value of field
     * 'externalConnectionPassword'.
     */
    public void setExternalConnectionPassword(java.lang.String externalConnectionPassword)
    {
        this._externalConnectionPassword = externalConnectionPassword;
    } //-- void setExternalConnectionPassword(java.lang.String) 

    /**
     * Method setExternalConnectionStringSets the value of field
     * 'externalConnectionString'.
     * 
     * @param externalConnectionString the value of field
     * 'externalConnectionString'.
     */
    public void setExternalConnectionString(java.lang.String externalConnectionString)
    {
        this._externalConnectionString = externalConnectionString;
    } //-- void setExternalConnectionString(java.lang.String) 

    /**
     * Method setExternalConnectionUserSets the value of field
     * 'externalConnectionUser'.
     * 
     * @param externalConnectionUser the value of field
     * 'externalConnectionUser'.
     */
    public void setExternalConnectionUser(java.lang.String externalConnectionUser)
    {
        this._externalConnectionUser = externalConnectionUser;
    } //-- void setExternalConnectionUser(java.lang.String) 

    /**
     * Method setExternalSourceDataSets the value of field
     * 'externalSourceData'.
     * 
     * @param externalSourceData the value of field
     * 'externalSourceData'.
     */
    public void setExternalSourceData(java.lang.String externalSourceData)
    {
        this._externalSourceData = externalSourceData;
    } //-- void setExternalSourceData(java.lang.String) 

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
     * Method setSheetNameSets the value of field 'sheetName'.
     * 
     * @param sheetName the value of field 'sheetName'.
     */
    public void setSheetName(java.lang.String sheetName)
    {
        this._sheetName = sheetName;
    } //-- void setSheetName(java.lang.String) 

    /**
     * Method setSourceTypeSets the value of field 'sourceType'.
     * 
     * @param sourceType the value of field 'sourceType'.
     */
    public void setSourceType(com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType sourceType)
    {
        this._sourceType = sourceType;
    } //-- void setSourceType(com.calipso.reportgenerator.reportdefinitions.types.DataSourceDefinitionSourceTypeType) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition) Unmarshaller.unmarshal(com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition.class, reader);
    } //-- com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition unmarshal(java.io.Reader) 

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
