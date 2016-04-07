package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.ExternalFunctionResolver;

import com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.DimensionDefinition;

import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDataType;

import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.reportcalculator.SharedInteger;

import com.calipso.reportgenerator.common.LanguageTraslator;

import com.calipso.reportgenerator.reportcalculator.SharedFloat;

import com.calipso.common.DateEx;

import com.calipso.reportgenerator.reportmanager.IRDataSource;

import es.indra.mare.common.info.InfoException;

import java.util.Date;
import java.util.Map;

/**
 * Representa a una Dimensión de un reporte conteniendo la información del
 * ReportDefinition y su ReportSourceDefinition asociado para la ejecución de un
 * reporte.
 */
public class ReportDimensionSpec extends ReportFieldSpec {

	/**
	 * Representa la consulta SQL, OQL o el Path de un archivo xml 
	 * o excel dependiendo del valor tipo de fuente de datos 
	 * ( atributo "dataType" )
	 */
	private String expression;

	private String groupFooterCaption;

	private DimensionDefinitionLocationType location;

	private DimensionDefinitionOrderType order;

	/**
	 * Indica el tipo de funte de datos SQL, OQL, EXCEL, XML
	 */
	private ReportDataType dataType;

	private boolean groups;

	private String datePattern;

	private String referencedDimensionName;

	private int referencedDataIndex;

	private String dateFunction;

	private String rankMetricName;

	private String dateTimePattern;

	/**
	 * Constructor de la super clase, que además asigna los valores por defecto
	 * específicos de esta clase
	 * 
	 * @param name
	 */
	public ReportDimensionSpec(String name) {
		super(name);
		referencedDataIndex = -1;
		referencedDimensionName = null;
		dateFunction = null;
	}

	/**
	 * Inicializa los valores de los atributos a partir de un
	 * DimensionSourceDefinition
	 * 
	 * @param dimensionSourceDefinition
	 * @param isMultilanguaje
	 * @param localization
	 */
	public void fillFrom(DimensionSourceDefinition dimensionSourceDefinition, boolean isMultilanguaje, Map localization) {
		
		setCaption(resolveCaption(isMultilanguaje, localization, dimensionSourceDefinition.getDescription()));
		
		setCalculated(dimensionSourceDefinition.getCalculated());
		
		setExpression(dimensionSourceDefinition.getExpression());
		
		setExternalData(dimensionSourceDefinition.getExternalData());
		
		setDataType(dimensionSourceDefinition.getDataType());
		
		// setQueryConvertToStringPattern(dimensionSourceDefinition.getQueryConvertToStringPattern());
	}

	/**
	 * Inicializa los valores de los atributos a partir de un
	 * DimensionDefinition
	 * 
	 * @param dimensionDefinition
	 * @param isMultilanguaje
	 * @param localization
	 */
	public void fillFrom(DimensionDefinition dimensionDefinition,
			boolean isMultilanguaje, Map localization) {
		if ((dimensionDefinition.getDescription() != null)
				&& !("").equals(dimensionDefinition.getDescription())) {
			setCaption(resolveCaption(isMultilanguaje, localization,
					dimensionDefinition.getDescription()));
		}
		setGroupFooterCaption(resolveCaption(isMultilanguaje, localization,
				dimensionDefinition.getGroupFooterCaption()));
		setLocation(dimensionDefinition.getLocation());
		setOrder(dimensionDefinition.getOrder());
		setGroups(dimensionDefinition.getGroups());
		setInReportDefinition(true);
		setRankMetricName(dimensionDefinition.getRankMetricName());
	}

	/**
	 * Espresión que se utiliza para resolver la dimensión calculada
	 * 
	 * @return
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Asigna la expresion que se utiliza para resolver las dimensión calculada
	 * 
	 * @param expression
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

	/**
	 * Título del pie del grupo
	 * 
	 * @return
	 */
	public String getGroupFooterCaption() {
		return groupFooterCaption;
	}

	/**
	 * Asigna Título del pie del grupo
	 * 
	 * @param groupFooterCaption
	 */

	public void setGroupFooterCaption(String groupFooterCaption) {
		this.groupFooterCaption = groupFooterCaption;
	}

	/**
	 * Asigna el tipo de ordenamiento por defecto para la dimension
	 * 
	 * @return
	 */
	public DimensionDefinitionOrderType getOrder() {
		if (order == null) {
			return DimensionDefinitionOrderType.A;
		}
		return order;
	}

	/**
	 * Asigna el tipo de ordenamiento por defecto para la dimension
	 * 
	 * @param order
	 */
	public void setOrder(DimensionDefinitionOrderType order) {
		this.order = order;
	}

	/**
	 * Especifica la ubicación en el reporte de la dimension, solo se utiliza en
	 * los reportes tupo Cubo, para especificar si la dimension agrupa por fila,
	 * por columna o no interviene en la agrupación
	 * 
	 * @return
	 */
	public DimensionDefinitionLocationType getLocation() {
		return location;
	}

	/**
	 * Asigna la ubicación de agrupación
	 * 
	 * @param location
	 */
	public void setLocation(DimensionDefinitionLocationType location) {
		this.location = location;
	}

	/**
	 * Tipo de dato de los valores de la dimensión
	 * 
	 * @return
	 */
	public ReportDataType getDataType() {
		return dataType;
	}

	/**
	 * Asigna el tipo de dato de los valores de la dimension
	 * 
	 * @param dataType
	 */
	public void setDataType(ReportDataType dataType) {
		this.dataType = dataType;
	}

	/**
	 * Devuelve verdadero si el atributo agrupa (genera grupos en el reporte),
	 * sirve para los reportes estáticos y sumarizados
	 * 
	 * @return
	 */
	public boolean getGroups() {
		return groups;
	}

	/**
	 * Espefica si la dimensión intervine en la agrupación
	 * 
	 * @param groups
	 */
	public void setGroups(boolean groups) {
		this.groups = groups;
	}

	/**
	 * Se utiliaza para resolver la dimensión en base a la que se calculará una
	 * dimension Calculada
	 * 
	 * @param referencedName
	 * @return
	 */
	protected int getReferencedDataIndex(String referencedName) {
		if (referencedDataIndex == -1) {
			referencedDataIndex = getDataSourceIndexFromName(referencedName);
		}
		return referencedDataIndex;
	}

	/**
	 * Obtiene el nombre de la dimensión en base a la que se calcula, parseando
	 * la expresión de cálculo
	 * 
	 * @return
	 */
	protected String getReferencedDimensionName() {
		if (referencedDimensionName == null) {
			DateExpressionParser expressionParser = new DateExpressionParser();
			expressionParser.setExpression(getExpression());
			referencedDimensionName = expressionParser.getFieldName();
		}
		return referencedDimensionName;
	}

	/**
	 * Devuelve la función de fecha que se debe utilizar para calcular,
	 * parseando la expresión de cálculo
	 * 
	 * @return
	 */
	protected String getDateFunction() {
		if (dateFunction == null) {
			DateExpressionParser expressionParser = new DateExpressionParser();
			expressionParser.setExpression(getExpression());
			dateFunction = expressionParser.getDateFunction();
		}
		return dateFunction;
	}

	/**
	 * Devuelve el pattern para tratar el tipo de datos DATE
	 * 
	 * @return
	 * 
	 * public String getDatePattern() { return datePattern; }
	 * 
	 * /** Asigna el pattern para tratar el tipo de datos DATE
	 * @param datePattern
	 * 
	 * public void setDatePattern(String datePattern) { this.datePattern =
	 * datePattern; }
	 * 
	 * /** Devuelve el pattern para tratar el tipo de datos DATETIME
	 * @return
	 * 
	 * public String getDateTimePattern() { return dateTimePattern; }
	 * 
	 * /** Asigna el pattern para tratar el tipo de datos DATETIME
	 * @param dateTimePattern
	 * 
	 * public void setDateTimePattern(String dateTimePattern) {
	 * this.dateTimePattern = dateTimePattern; }
	 */

	/**
	 * En caso que la dimensión se ordene en base al valor de una métrica, en
	 * este atributo se especifica el nombre de dicha métrica. Si este valor no
	 * está asignado, el ordenamiento se realiza en base a los valores de la
	 * dimensión
	 * 
	 * @return
	 */
	public String getRankMetricName() {
		return rankMetricName;
	}

	/**
	 * Asigna el nombre de la métrica en base a cuyos valores se debe ordenar
	 * 
	 * @param rankMetricName
	 */
	public void setRankMetricName(String rankMetricName) {
		this.rankMetricName = rankMetricName;
	}

	/**
	 * Resulve la obtención del valor proveniente del IRDataSource, obteniendo
	 * el valor directo en las dimensiones simples y aplicando la expresión de
	 * cálculo en las dimensiones calculadas
	 * 
	 * @param dataSource
	 * @param index
	 * @param dataSourceSpec
	 * @return
	 * @throws es.indra.mare.common.info.InfoException
	 */
	public Object getValue(Map paramValues, IRDataSource dataSource, int index,
			ReportDataSourceSpec dataSourceSpec) throws InfoException {
		try {
			if (getCalculated()) {
				if (getExpression().startsWith(this.externalFunctionConstant)) {
					return ExternalFunctionResolver.getInstance().resolveValue(
							paramValues, getExpression(),
							dataSource.getRowValues(index));
				}
				String refDimensionName = getReferencedDimensionName();
				int calcDataIndex = getReferencedDataIndex(refDimensionName);
				Object date = dataSource.getValueAt(index, calcDataIndex);
				if ((date instanceof SharedDate)) {
					String resultValue = DateExpressionResolver.Resolve(
							getDateFunction(), ((SharedDate) date).getDateEx()
									.getDate());
					return resultValue;
				} else if (date instanceof Date) {
					String resultValue = DateExpressionResolver.Resolve(
							getDateFunction(), ((Date) date));
					return resultValue;
				} else {
					String dateString = date.toString();
					String resultValue = DateExpressionResolver.Resolve(
							getDateFunction(), dateString, dataSourceSpec
									.getPattern(this.getDataType().getType()));
					return resultValue;
				}
			} else {
				return convertValue(dataSource.getValueAt(index,
						getDataSourceIndex()), dataSourceSpec.getPattern(this
						.getDataType().getType()));
			}
		} catch (Exception e) {
			throw new InfoException(LanguageTraslator.traslate("80"), e);
		}
	}

	/*
	 * public String getPattern(int type) { switch(type){ case
	 * DimensionSourceDefinitionDataTypeType.DATE_TYPE: return getDatePattern();
	 * case DimensionSourceDefinitionDataTypeType.DATETIME_TYPE: return
	 * getDateTimePattern(); default: return ""; } }
	 */

	/**
	 * Convierte los datos de entrada al tipo de dato real definido
	 * 
	 * @return
	 */
	private Object convertValue(Object value, String datePattern)
			throws InfoException {
		if (getDataType().getType() == ReportDataType.DATETIME_TYPE
				|| getDataType().getType() == ReportDataType.DATE_TYPE) {
			if (value instanceof SharedDate) {
				return value;
			} else if (value instanceof DateEx) {
				return SharedDate.newFrom((DateEx) value);
			} else {
				return SharedDate.newFrom(new DateEx(value, datePattern));
			}
		} else {
			return value;
		}
	}

	/*
	 * Retorna el valor para mostrar formateado @param currentValue @return
	 * 
	 * public Object getVisualValue(Object currentValue) { if
	 * (getDataType().getType() ==
	 * DimensionSourceDefinitionDataTypeType.DATETIME_TYPE){ SimpleDateFormat
	 * dateFormat = new SimpleDateFormat(getDatePattern()); return new
	 * String(dateFormat.format(((Date)currentValue))); } else { return
	 * currentValue; } }
	 */

	/*
	 * public String getQueryConvertToStringPattern() { return
	 * queryConvertToStringPattern; }
	 * 
	 * public void setQueryConvertToStringPattern(String
	 * queryConvertToStringPattern) { this.queryConvertToStringPattern =
	 * queryConvertToStringPattern; }
	 */

	/**
	 * Convierte un valor a el tipo de dato correspondiente a esta dimension
	 * 
	 * @param value
	 * @return
	 * @throws InfoException
	 */
	public Object getValueFor(Object value) throws InfoException {
		return getValueFor(value, dataType.getType(), "");
	}

	public static Object getValueFor(Object value, int dataType,
			String datePattern) throws InfoException {
		if (value instanceof String) {
			try {
				String strValue = value.toString();
				switch (dataType) {
				case ReportDataType.BOOLEAN_TYPE:
					return new Boolean(strValue);
				case ReportDataType.FLOAT_TYPE:
					return SharedFloat.newFrom(new Float(strValue));
				case ReportDataType.STRING_TYPE:
					return strValue;
				case ReportDataType.INTEGER_TYPE:
					return SharedInteger.newFrom(new Integer(strValue));
				case ReportDataType.DATETIME_TYPE:
				case ReportDataType.DATE_TYPE:
					return SharedDate.newFrom(new DateEx(value, datePattern));
				}
			} catch (Exception e) {
				throw new InfoException(LanguageTraslator.traslate("361"), e);
			}
		} else if (value instanceof Date) {
			if (dataType == ReportDataType.DATETIME_TYPE
					|| dataType == ReportDataType.DATE_TYPE) {
				return SharedDate.newFrom(new DateEx((Date) value));
			} else {
				throw new InfoException(LanguageTraslator.traslate("361"));
			}
		}
		return value;
	}

	public Class getBaseJavaType() {
		switch (this.dataType.getType()) {
		case ReportDataType.BOOLEAN_TYPE:
			return Boolean.class;
		case ReportDataType.DATE_TYPE:
		case ReportDataType.DATETIME_TYPE:
			return Date.class;
		case ReportDataType.FLOAT_TYPE:
			return Float.class;
		case ReportDataType.INTEGER_TYPE:
			return Integer.class;
		case ReportDataType.STRING_TYPE:
		default:
			return String.class;
		}
	}

}
