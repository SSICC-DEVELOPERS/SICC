package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.DimensionDefinition;
import com.calipso.reportgenerator.reportdefinitions.Localization;
import com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition;
import com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.Localizations;
import com.calipso.reportgenerator.reportdefinitions.FilterDefinitions;
import com.calipso.reportgenerator.reportdefinitions.MetricDefinition;
import com.calipso.reportgenerator.reportdefinitions.DataSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.FilterDefinition;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionLocationType;
import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.reportcalculator.CubeDefinition;
import com.calipso.reportgenerator.reportcalculator.DataTreeDefinition;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se utiliza para consilidar toda la información proveniente de un
 * ReportDefinition y su ReportSourceDefinition asiciado.
 */
public class ReportSpec implements CubeDefinition, DataTreeDefinition,
		Serializable {

	private Map dimensionSpecs;

	private List dimensionsByIndex;

	private Map metricSpecs;

	private Map accumulableMetricSpecs;

	private List metricsByIndex;

	private List accumulableMetricsByIndex;

	private Map posParamValues;

	private Object[] dimensions;

	private Object[] groupingDimensions;

	private Object[] nonGroupingDimensions;

	private Object[] metrics;

	private Object[] accumulableMetrics;

	private String description;

	private String title;

	private String pageHeader;

	private String pageFooter;

	private ReportDefinitionReportTypeType reportType;

	private Collection preFilterSpecs;

	private Collection filterSpecs;

	private Collection dataSourceSpecs;

	// private String datePattern = "";
	private boolean cached;

	private String incrementalDimension;

	private BigDecimal expiration;

	private String sourceId;

	private String definitionId;

	private Map dataSourceIndexes;

	private String localeLanguage;

	private Map localizationMap;

	private List drillDownSpecs;

	private int sourceMaxRowCount;

	private String sourceMaxRowsDimension = "";

	private int maxRowCount;

	private String maxRowsDimension = "";

	private boolean visibleTotals;

	private Map preParamValues;

	private String LayoutDesign;

	private ReportGeneratorConfiguration reportGeneratorConfiguration;

	private final static String datePattern = "FORMATOFECHAVALUE";

	// private String dateTimePattern = "";

	/**
	 * Constructor con un ReportGeneratorConfiguration
	 */
	public ReportSpec(ReportGeneratorConfiguration reportGeneratorConfiguration) {
		// datePattern = "yyyyMMdd";
		setLocale(reportGeneratorConfiguration.getLocaleLanguage());
		setReportGeneratorConfiguration(reportGeneratorConfiguration);
		// setDatePattern(reportGeneratorConfiguration.getDatePattern());
	}

	/**
	 * Devuelve un array que contiene todas las dimensiones del reporte
	 * Implementación de la interface DataDefinition
	 * 
	 * @return
	 */
	public Object[] getDimensions() {
		if (dimensions == null) {
			dimensions = getDimensionsByIndex().toArray();
		}
		return dimensions;
	}

	/**
	 * Devuelve un array que contiene todas las métricas del reporte
	 * Implementación de la interface DataDefinition
	 * 
	 * @return
	 */

	public Object[] getMetrics() {
		if (metrics == null) {
			metrics = getMetricsByIndex().toArray();
		}
		return metrics;
	}

	/**
	 * Devuelve un array que contiene todas las métricas acumulables del reporte
	 * Implementación de la interface DataDefinition
	 * 
	 * @return
	 */

	public Object[] getAccumulableMetrics() {
		if (accumulableMetrics == null) {
			accumulableMetrics = getAccumulableMetricsByIndex().toArray();
		}
		return accumulableMetrics;
	}

	/**
	 * Devuelve un Diccionario que asocia los nombres de los campos con sus
	 * indices
	 * 
	 * @return
	 */

	public Map getDataSourceIndexes() {
		if (dataSourceIndexes == null) {
			dataSourceIndexes = new HashMap();
		}
		return dataSourceIndexes;
	}

	/**
	 * Devuelve un array que contiene las dimensiones según su rol en la
	 * agrupación
	 * 
	 * @param dimensions
	 * @param grouping
	 * @return
	 */
	private Object[] getDimensionsByGrouping(List dimensions, boolean grouping) {
		List dims = new ArrayList();
		Iterator iter = dimensions.iterator();
		while (iter.hasNext()) {
			ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) iter
					.next();
			if (dimensionSpec.getReportIndex() >= 0
					&& dimensionSpec.getGroups() == grouping) {
				dims.add(dimensionSpec);
			}
		}
		return dims.toArray();
	}

	/**
	 * Devuelve un array que contiene las dimensiones que intervienen en la
	 * agrupación
	 * 
	 * @return
	 */
	public Object[] getGroupingDimensions() {
		if (groupingDimensions == null) {
			groupingDimensions = getDimensionsByGrouping(
					getDimensionsByIndex(), true);
		}
		return groupingDimensions;
	}

	/**
	 * Devuelve un array que contiene las dimensiones que NO intervienen en la
	 * agrupación
	 * 
	 * @return
	 */
	public Object[] getNonGroupingDimensions() {
		if (nonGroupingDimensions == null) {
			nonGroupingDimensions = getDimensionsByGrouping(
					getDimensionsByIndex(), false);
		}
		return nonGroupingDimensions;
	}

	/**
	 * Devuelve un Diccionario que contiene las especificaciones de las
	 * dimensiones (la clave es el nombre)
	 * 
	 * @return
	 */
	public Map getDimensionSpecs() {
		if (dimensionSpecs == null) {
			dimensionSpecs = new HashMap();
		}
		return dimensionSpecs;
	}

	/**
	 * Devuelve una lista indexada de las dimensions donde el indice corresponde
	 * al indice de las dimensiones en el ReportSourceDefinition (y la Matrix)
	 * 
	 * @return
	 */
	public List getDimensionsByIndex() {
		if (dimensionsByIndex == null) {
			dimensionsByIndex = new ArrayList();
		}
		return dimensionsByIndex;
	}

	/**
	 * Devuelve un Diccionario que contiene las especificaciones de las métricas
	 * (la clave es el nombre)
	 * 
	 * @return
	 */
	public Map getMetricSpecs() {
		if (metricSpecs == null) {
			metricSpecs = new HashMap();
		}
		return metricSpecs;
	}

	/**
	 * Devuelve un Diccionario que contiene las especificaciones de las métricas
	 * acumulables (la clave es el nombre)
	 * 
	 * @return
	 */
	public Map getAccumulableMetricSpecs() {
		if (accumulableMetricSpecs == null) {
			accumulableMetricSpecs = new HashMap();
		}
		return accumulableMetricSpecs;
	}

	/**
	 * Devuelve una lista indexada de las métricas donde el indice corresponde
	 * al indice de las métricas en el ReportSourceDefinition (y la Matrix)
	 */

	public List getMetricsByIndex() {
		if (metricsByIndex == null) {
			metricsByIndex = new ArrayList();
		}
		return metricsByIndex;
	}

	/**
	 * Devuelve una lista indexada de las métricas acumulables donde el indice
	 * corresponde al indice de las métricas en el ReportSourceDefinition (y la
	 * Matrix)
	 */

	public List getAccumulableMetricsByIndex() {
		if (accumulableMetricsByIndex == null) {
			accumulableMetricsByIndex = new ArrayList();
		}
		return accumulableMetricsByIndex;
	}

	/**
	 * Inicializa los valores de los atributos a partir de un
	 * ReportSourceDefinition
	 * 
	 * @param reportSourceDefinition
	 */
	public void fillFrom(ReportSourceDefinition reportSourceDefinition)
			throws InfoException {
		int dataSourceIndex = 0;
		int reportSourceIndex = 0;
		cached = reportSourceDefinition.getCached();
		incrementalDimension = reportSourceDefinition.getIncrementalDimension();
		expiration = reportSourceDefinition.getExpiration();
		sourceId = reportSourceDefinition.getId();
		sourceMaxRowCount = reportSourceDefinition.getMaxRowCount();
		if (reportSourceDefinition.getMaxRowsDimensionReference() != null) {
			sourceMaxRowsDimension = reportSourceDefinition
					.getMaxRowsDimensionReference();
		}

		/**
		 * Obtiene las Dimension Source Definitions sobre las que se van a
		 * realizar agrupaciones
		 */
		Enumeration dimEnum = reportSourceDefinition
				.getDimensionSourceDefinitions()
				.enumerateDimensionSourceDefinition();
		while (dimEnum.hasMoreElements()) {
			DimensionSourceDefinition dimensionSourceDefinition = (DimensionSourceDefinition) dimEnum
					.nextElement();
			String name = dimensionSourceDefinition.getName();
			ReportDimensionSpec dimensionSpec = new ReportDimensionSpec(name);
			dimensionSpec.setReportSourceIndex(reportSourceIndex);
			// dimensionSpec.setDatePattern(getDatePattern());
			// dimensionSpec.setDateTimePattern(getDateTimePattern());
			dimensionSpec.setDataSourceIndexes(getDataSourceIndexes());
			reportSourceIndex++;
			if (!dimensionSourceDefinition.getCalculated()) {
				dimensionSpec.setDataSourceIndex(dataSourceIndex);
				getDataSourceIndexes().put(name, new Integer(dataSourceIndex));
				dataSourceIndex++;
			}
			dimensionSpec.fillFrom(dimensionSourceDefinition,
					reportSourceDefinition.getMultilanguage(),
					getLocalizacionMap(reportSourceDefinition));
			addDimension(dimensionSpec);
		}

		/**
		 * 
		 */
		Enumeration metEnum = reportSourceDefinition
				.getMetricSourceDefinitions().enumerateMetricSourceDefinition();
		while (metEnum.hasMoreElements()) {
			MetricSourceDefinition metricSourceDefinition = (MetricSourceDefinition) metEnum
					.nextElement();
			String name = metricSourceDefinition.getName();
			ReportMetricSpec metricSpec = new ReportMetricSpec(name);
			metricSpec.setReportSourceIndex(reportSourceIndex);
			metricSpec.setDataSourceIndexes(getDataSourceIndexes());
			reportSourceIndex++;
			if (!metricSourceDefinition.getCalculated()) {
				metricSpec.setDataSourceIndex(dataSourceIndex);
				getDataSourceIndexes().put(name, new Integer(dataSourceIndex));
				dataSourceIndex++;
			}
			metricSpec.fillFrom(metricSourceDefinition, reportSourceDefinition
					.getMultilanguage(),
					getLocalizacionMap(reportSourceDefinition));
			addMetric(metricSpec);
		}
		preFilterSpecs = new ArrayList();
		fillReportFilters(reportSourceDefinition.getFilterDefinitions(),
				(List) preFilterSpecs);
		preParamValues = ReportFilterBuilder.mergeParamValues(
				getPreParamValues(), reportSourceDefinition
						.getParameterValues());
		translateParamValues(preParamValues);

		dataSourceSpecs = new ArrayList();
		Enumeration dataSourcesEnum = reportSourceDefinition
				.getDataSourceDefinitions().enumerateDataSourceDefinition();
		
		/**
		 * 
		 */
		while (dataSourcesEnum.hasMoreElements()) {
			DataSourceDefinition dataSourceDefinition = (DataSourceDefinition) dataSourcesEnum
					.nextElement();
			ReportDataSourceSpec dataSourceSpec = new ReportDataSourceSpec();
			dataSourceSpec.fillFrom(dataSourceDefinition);
			dataSourceSpecs.add(dataSourceSpec);
		}
	}

	private void translateParamValues(Map paramValues) throws InfoException {
		Iterator params = paramValues.entrySet().iterator();
		while (params.hasNext()) {
			Map.Entry current = (Map.Entry) params.next();
			ReportFilterSpec filter = getFilterSpecFromParamName(current
					.getKey().toString());
			String pattern = (String) paramValues.get(datePattern);
			if ((filter != null)
					&& (filter.getFilterType() != FilterDefinitionFilterTypeType.IN)) {
				ReportDimensionSpec dimension = getDimensionFromName(filter
						.getDimensionName());
				if (dimension != null) {
					Object obj = dimension.getValueFor(current.getValue());
					current.setValue(obj);
				} else {
					Object obj = ReportDimensionSpec.getValueFor(current
							.getValue(), filter.getDataType().getType(),
							pattern);
					current.setValue(obj);
					// throw new
					// InfoException(LanguageTraslator.traslate("365"));
				}
			}
		}
	}

	public void setPosParamValues(Map paramValues) {
		if (paramValues != null) {
			this.posParamValues = paramValues;
		}
	}

	/**
	 * Agrega una métrica a al diccionario que asocia por nombre y a la lista
	 * que se utiliza para buscar por indice
	 * 
	 * @param metricSpec
	 */
	private void addMetric(ReportMetricSpec metricSpec) {
		getMetricSpecs().put(metricSpec.getName().toUpperCase(), metricSpec);
		getMetricsByIndex().add(metricSpec);
	}

	/**
	 * Agrega una dimensión a al diccionario que asocia por nombre y a la lista
	 * que se utiliza para buscar por indice
	 * 
	 * @param dimensionSpec
	 */

	private void addDimension(ReportDimensionSpec dimensionSpec) {
		getDimensionSpecs().put(dimensionSpec.getName().toUpperCase(),
				dimensionSpec);
		getDimensionsByIndex().add(dimensionSpec);
	}

	/**
	 * Inicializa los valores de los atributos a partir de un ReportDefinition
	 * 
	 * @param reportDefinition
	 */

	public void fillFrom(ReportDefinition reportDefinition)
			throws InfoException {
		definitionId = reportDefinition.getId();
		boolean isMultilanguege = reportDefinition.getMultilanguage();
		Map localizationMap = getLocalizacionMap(reportDefinition);
		setDescription(traslate(isMultilanguege, localizationMap,
				reportDefinition.getDescription()));
		setPageHeader(traslate(isMultilanguege, localizationMap,
				reportDefinition.getPageHeding()));
		setPageFooter(traslate(isMultilanguege, localizationMap,
				reportDefinition.getPageFooter()));
		setTitle(traslate(isMultilanguege, localizationMap, reportDefinition
				.getTitle()));
		setReportType(reportDefinition.getReportType());
		maxRowCount = reportDefinition.getMaxRowCount();
		visibleTotals = reportDefinition.getVisibleTotals();
		setLayoutDesign(reportDefinition.getLayoutDesign());
		if (reportDefinition.getMaxRowsDimensionReference() != null) {
			maxRowsDimension = reportDefinition.getMaxRowsDimensionReference();
		}

		int reportIndex = 0;
		Enumeration dimEnum = reportDefinition.getDimensionDefinitions()
				.enumerateDimensionDefinition();
		while (dimEnum.hasMoreElements()) {
			DimensionDefinition dimensionDefinition = (DimensionDefinition) dimEnum
					.nextElement();
			ReportDimensionSpec dimensionSpec = getDimensionFromName(dimensionDefinition
					.getName().toUpperCase());
			dimensionSpec.setReportIndex(reportIndex);
			reportIndex++;
			dimensionSpec.fillFrom(dimensionDefinition, reportDefinition
					.getMultilanguage(), getLocalizacionMap(reportDefinition));
		}

		Enumeration metEnum = reportDefinition.getMetricDefinitions()
				.enumerateMetricDefinition();
		while (metEnum.hasMoreElements()) {
			MetricDefinition metricDefinition = (MetricDefinition) metEnum
					.nextElement();
			ReportMetricSpec metricSpec = getMetricFromName(metricDefinition
					.getName().toUpperCase());
			metricSpec.setReportIndex(reportIndex);
			reportIndex++;
			metricSpec.fillFrom(metricDefinition, reportDefinition
					.getMultilanguage(), getLocalizacionMap(reportDefinition));
			if (metricSpec.getAccumulable()) {
				getAccumulableMetricSpecs().put(metricSpec.getName(),
						metricSpec);
				getAccumulableMetricsByIndex().add(metricSpec);
			}
		}

		filterSpecs = new ArrayList();
		fillReportFilters(reportDefinition.getFilterDefinitions(),
				(List) filterSpecs);
		posParamValues = ReportFilterBuilder.mergeParamValues(
				getPosParamValues(), reportDefinition.getParameterValues());
		translateParamValues(posParamValues);

		drillDownSpecs = new ArrayList();
		if (reportDefinition.getDrillDownDefinitions() != null) {
			Enumeration drillDownEnum = reportDefinition
					.getDrillDownDefinitions().enumerateDrillDownDefinition();
			while (drillDownEnum.hasMoreElements()) {
				DrillDownDefinition drillDownDefinition = (DrillDownDefinition) drillDownEnum
						.nextElement();
				DrillDownSpec drillDownSpec = new DrillDownSpec();
				drillDownSpec.fillFrom(drillDownDefinition);
				drillDownSpecs.add(drillDownSpec);
			}
		}
	}

	/**
	 * Obtiene la lista de las conversiones para la ubicación del
	 * ReportDefinition
	 * 
	 * @param reportDefinition
	 * @return
	 */
	private Map getLocalizacionMap(ReportDefinition reportDefinition) {
		if (localizationMap == null) {
			Localization localization = getLocalizationFromLocale(reportDefinition
					.getLocalizations());
			if (localization != null) {
				localizationMap = createMapLocazation(localization);
			}
		}
		return localizationMap;
	}

	/**
	 * Obtiene la lista de las conversiones para la ubicación del
	 * ReportSourceDefinition
	 * 
	 * @param reportSourceDefinition
	 * @return
	 */
	private Map getLocalizacionMap(ReportSourceDefinition reportSourceDefinition) {
		Localization localization = getLocalizationFromLocale(reportSourceDefinition
				.getLocalizations());
		if (localization != null) {
			return createMapLocazation(localization);
		} else {
			if (reportGeneratorConfiguration.getReportLayoutStyle()
					.equalsIgnoreCase("BELCORP")) {
				return reportGeneratorConfiguration.getLanguageTraslator()
						.getDictionary();
			}
		}
		return null;
	}

	/**
	 * Crea un Map con la lista de los literales para las conversiones
	 * 
	 * @param localization
	 * @return
	 */
	private Map createMapLocazation(Localization localization) {
		Map localeMap = new Hashtable();
		for (int i = 0; i < localization.getLiteralsCount(); i++) {
			localeMap.put(localization.getLiterals()[i].getCode(), localization
					.getLiterals()[i].getValue());
		}
		return localeMap;
	}

	/**
	 * Obtiene el localization para el locale corespondiente
	 * 
	 * @param localizations
	 * @return
	 */
	private Localization getLocalizationFromLocale(Localizations localizations) {
		Localization localization;
		if (localizations != null) {
			for (int i = 0; i < localizations.getLocalizationCount(); i++) {
				localization = localizations.getLocalization()[i];
				if (localization.getLocale().equalsIgnoreCase(
						getLocaleLanguage())) {
					return localization;
				}
				//;
			}
		}
		return null;
	}

	/**
	 * Crea las especificaciones de los filtros a partir de las definitiones de
	 * filtros. Este método se utiliza tanto para los pre-filtros como para los
	 * post-filtros
	 * 
	 * @param filterDefinitions
	 * @param filters
	 */
	private void fillReportFilters(FilterDefinitions filterDefinitions,
			List filters) {
		if (filterDefinitions != null) {
			for (int i = 0; i < filterDefinitions.getFilterDefinitionCount(); i++) {
				FilterDefinition filterDefinition = filterDefinitions
						.getFilterDefinition(i);
				ReportFilterSpec reportFilterSpec = new ReportFilterSpec();
				reportFilterSpec.fillFrom(filterDefinition);
				filters.add(reportFilterSpec);
			}
		}
	}

	/**
	 * Busca una métrica a partir de su nombre
	 * 
	 * @param name
	 * @return
	 */
	public ReportMetricSpec getMetricFromName(String name) {
		return (ReportMetricSpec) getMetricSpecs().get(name.toUpperCase());
	}

	/**
	 * Busca una métrica a partir de su indice
	 * 
	 * @param index
	 * @return
	 */
	public ReportMetricSpec getMetricFromIndex(int index) {
		return (ReportMetricSpec) getMetricsByIndex().get(index);
	}

	/**
	 * Busca una Dimensión a partir de su nombre
	 * 
	 * @param name
	 * @return
	 */
	public ReportDimensionSpec getDimensionFromName(String name) {
		if (name == null || name.equalsIgnoreCase("")) {
			return null;
		}
		return (ReportDimensionSpec) getDimensionSpecs()
				.get(name.toUpperCase());
	}

	/**
	 * Busca una Dimensión a partir de su indice
	 * 
	 * @param index
	 * @return
	 */
	public ReportDimensionSpec getDimensionFromIndex(int index) {
		return (ReportDimensionSpec) getDimensionsByIndex().get(index);
	}

	/**
	 * Devuelve la descripción del reporte
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Asigna la descripción del reporte
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Devuelve el título del reporte
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Asigna el título del reporte
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Devuelve el texto del encabezado de página
	 * 
	 * @return
	 */
	public String getPageHeader() {
		return pageHeader;
	}

	/**
	 * Asigna el texto del encabezado de página
	 */
	public void setPageHeader(String pageHeader) {
		this.pageHeader = pageHeader;
	}

	/**
	 * Devuelve el texto del pie de página
	 * 
	 * @return
	 */

	public String getPageFooter() {
		return pageFooter;
	}

	/**
	 * Asigna el texto del pie de pégina
	 * 
	 * @param pageFooter
	 */
	public void setPageFooter(String pageFooter) {
		this.pageFooter = pageFooter;
	}

	/**
	 * Devulve el tipo de Reporte (CUBE, SUM, ACCUM)
	 * 
	 * @see com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType
	 * @return
	 */
	public ReportDefinitionReportTypeType getReportType() {
		return reportType;
	}

	/**
	 * Asigna el tipo de Reporte
	 * 
	 * @param reportType
	 */
	public void setReportType(ReportDefinitionReportTypeType reportType) {
		this.reportType = reportType;
	}

	/**
	 * Devuelve un diccionario que contiene los valores de los parámetros que se
	 * utilizan para evaluar los filtros
	 * 
	 * @param sourceOnly
	 *            Indica si se obtienen solo los prefiltros
	 * @return
	 */
	public Map getParamValues(boolean sourceOnly) {
		Map param = new HashMap();
		param = ReportFilterBuilder
				.mergeParamValues(param, getPreParamValues());
		if (!sourceOnly || !getCached()) {
			param = ReportFilterBuilder.mergeParamValues(param,
					getPosParamValues());
		}
		return param;
	}

	/**
	 * Debuelve un campo (Dimensión o Métrica) a aprtir de su nombre
	 * 
	 * @param name
	 * @return
	 */
	public ReportFieldSpec getFieldFromName(String name) {
		ReportFieldSpec fieldSpec;
		fieldSpec = getDimensionFromName(name);
		if (fieldSpec == null) {
			fieldSpec = getMetricFromName(name);
		}
		return fieldSpec;
	}

	/**
	 * Devuelve una lista de dimensiones segun su ubicación de agrupación (se
	 * utiliza para reportes cube donde las ubicaciones pueden ser ROW, COLUMN o
	 * PAGE)
	 * 
	 * @param location
	 * @return
	 */
	public Collection getDimensionsByLocation(
			DimensionDefinitionLocationType location) {
		Iterator iter = getDimensionSpecs().values().iterator();
		ArrayList result = new ArrayList();
		while (iter.hasNext()) {
			ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) iter
					.next();
			if (dimensionSpec.getLocation() != null
					&& dimensionSpec.getLocation().getType() == location
							.getType()) {
				result.add(dimensionSpec);
			}
		}
		return result;
	}

	/**
	 * Devuelve una lista con todas las definiciones de post-filtros
	 * 
	 * @return
	 */
	public Collection getFilterSpecs() {
		return filterSpecs;
	}

	/**
	 * Devuelve una lista con todas las definiciones de pre-filtros
	 * 
	 * @return
	 */
	public Collection getPreFilterSpecs() {
		return preFilterSpecs;
	}

	/**
	 * Devuelve una lista con las especificaciones de los DataSource
	 * 
	 * @return
	 */
	public Collection getDataSourceSpecs() {
		return dataSourceSpecs;
	}

	/*
	 * Devuelve el pattern para tratar el tipo de dato date @return
	 * 
	 * public String getDatePattern() { return datePattern; }
	 */

	/*
	 * Especifica el pattern para tratar el tipo de dato date @param datePattern
	 * 
	 * public void setDatePattern(String datePattern) { if(datePattern != null &&
	 * !datePattern.equals("")){ this.datePattern = datePattern; } }
	 */

	/*
	 * Devuelve el pattern para tratar el tipo de dato datetime @return
	 * 
	 * private String getDateTimePattern() { return dateTimePattern; }
	 *  /* Especifica el pattern para tratar el tipo de dato datetime @param
	 * dateTimePattern
	 * 
	 * private void setDateTimePattern(String dateTimePattern){
	 * this.dateTimePattern = dateTimePattern; }
	 */

	/**
	 * Se utiliza para saber si el origen del reporte (Matrix) se guarda en el
	 * repositorio de DataSource
	 * 
	 * @return
	 */
	public boolean getCached() {
		return cached;
	}

	/**
	 * Devuel el nombre de la dimensión (de tipo fecha) que se utiliza para
	 * resolver los origenes de datos incrementales
	 * 
	 * @return
	 */
	public String getIncrementalDimension() {
		return incrementalDimension;
	}

	/**
	 * Devuelve le período de tiempo para el que es vigente un ReportSource
	 * cacheado
	 * 
	 * @return
	 */
	public BigDecimal getExpiration() {
		return expiration;
	}

	/**
	 * Devuelve el identificador del ReportSourceDefinition
	 * 
	 * @return
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * Devuelve el identificador del ReportDefinition
	 * 
	 * @return
	 */
	public String getDefinitionId() {
		return definitionId;
	}

	/**
	 * Devuelve una lista de dimensiones dependiendo de su rol en la agrupación
	 * Se utliza para los reportes estáticos y para la impresión
	 * 
	 * @param groups
	 * @return
	 */
	public Collection getDimensionsByGrouping(boolean groups) {
		// Iterator iter = getDimensionSpecs().values().iterator();
		Iterator iter = getDimensionsByIndex().iterator();
		ArrayList result = new ArrayList();
		while (iter.hasNext()) {
			ReportDimensionSpec dimensionSpec = (ReportDimensionSpec) iter
					.next();
			if (dimensionSpec.getGroups() == groups) {
				result.add(dimensionSpec);
			}
		}
		return result;
	}

	/**
	 * Se utiliza para saber si un reporte es del tipo ACCUM
	 * 
	 * @return
	 */
	public boolean getAccumulable() {
		return getReportType().getType() == ReportDefinitionReportTypeType.ACCUM_TYPE;
	}

	/**
	 * Asigna la infomación de localización (idioma)
	 * 
	 * @param localeLanguage
	 */
	public void setLocale(String localeLanguage) {
		this.localeLanguage = localeLanguage;
	}

	/**
	 * Devuelve la infomación de localización (idioma)
	 * 
	 * @return
	 */
	public String getLocaleLanguage() {
		return localeLanguage;
	}

	/**
	 * Traduce el string al lenguaje correspondiente
	 * 
	 * @param multilanguaje
	 *            Indica si debe traducirse
	 * @param localization
	 *            lenguaje destino
	 * @param value
	 * @return
	 */
	protected String traslate(boolean multilanguaje, Map localization,
			String value) {
		if (multilanguaje && (localization != null) && (value != null)
				&& localization.containsKey(value)) {
			return localization.get(value).toString();
		} else {
			return value;
		}
	}

	/**
	 * Devuelve las definiciones de drill down
	 * 
	 * @return
	 */
	public List getDrillDownSpecs() {
		return drillDownSpecs;
	}

	/**
	 * Retorna un filterspec a partir del nombre
	 * 
	 * @param name
	 * @return
	 */
	public ReportFilterSpec getFilterSpecFromName(String name) {
		ReportFilterSpec result = doGetFilterSpecFromName(getFilterSpecs(),
				name);
		if (result == null) {
			result = doGetFilterSpecFromName(getPreFilterSpecs(), name);
		}
		return result;
	}

	protected ReportFilterSpec doGetFilterSpecFromName(Collection filters,
			String name) {
		Iterator iterator = filters.iterator();
		while (iterator.hasNext()) {
			ReportFilterSpec reportFilterSpec = (ReportFilterSpec) iterator
					.next();
			if (reportFilterSpec.getName().equalsIgnoreCase(name)) {
				return reportFilterSpec;
			}
		}
		return null;
	}

	/**
	 * Devuelva la cantidad máxima de Row que se incluirán en la matriz, se
	 * utiliza para limitar la cantidad de rows o para obtener la información
	 * dividida en lotes
	 * 
	 * @return
	 */
	public int getSourceMaxRowCount() {
		return sourceMaxRowCount;
	}

	/**
	 * Devuelve el nombre de la dimensión que se utilizará como criterio para
	 * dividir la información de la matriz en lotes
	 * 
	 * @return
	 */
	public String getSourceMaxRowsDimension() {
		return sourceMaxRowsDimension;
	}

	/**
	 * Se utiliza para limitar la cantidad de row que se recuperan de la matriz
	 * 
	 * @return
	 */
	public int getMaxRowCount() {
		return maxRowCount;
	}

	/**
	 * Devuelve el nombre de la dimension que se utilizará como criterio para
	 * obtener una cantidad máxima de rows de la matriz
	 * 
	 * @return
	 */
	public String getMaxRowsDimension() {
		return maxRowsDimension;
	}

	/**
	 * Devuelve el filtro para llenar un ReportSource de forma incremental, con
	 * solo la información que le falta
	 * 
	 * @param lastExecution
	 * @return
	 */
	public ReportFilterSpec getIncrementalFilterSpec(Date lastExecution) {
		ReportFilterSpec filterSpec = null;
		String incDim = getIncrementalDimension();
		if (!incDim.equals("") && lastExecution != null) {
			filterSpec = new ReportFilterSpec();
			filterSpec.setName("INCREMENTAL");
			filterSpec
					.setFilterType(FilterDefinitionFilterTypeType.GREATERTHAN);
			filterSpec.setVisual(false);
			filterSpec.setDimensionName(incDim);
		}
		return filterSpec;
	}

	/**
	 * Deveulve un filtro que se utiliza para llenar una cantidad máxima de rows
	 * en la matriz
	 * 
	 * @return
	 */
	public ReportFilterSpec getSourceMaxRowsFilterSpec() {
		ReportFilterSpec filterSpec = null;
		String mxDim = getSourceMaxRowsDimension();
		if (!mxDim.equals("")) {
			filterSpec = new ReportFilterSpec();
			filterSpec.setName("SOURCEMAXROWS");
			filterSpec
					.setFilterType(FilterDefinitionFilterTypeType.GREATERTHAN);
			filterSpec.setVisual(true);
			filterSpec.setDimensionName(mxDim);
		}
		return filterSpec;
	}

	/**
	 * Deveulve un filtro que se utiliza para llenar una cantidad máxima de rows
	 * de la matriz
	 */

	public ReportFilterSpec getMaxRowsFilterSpec() {
		ReportFilterSpec filterSpec = null;
		String mxDim = getMaxRowsDimension();
		if (!mxDim.equals("")) {
			filterSpec = new ReportFilterSpec();
			filterSpec.setName("MAXROWS");
			filterSpec
					.setFilterType(FilterDefinitionFilterTypeType.GREATERTHAN);
			filterSpec.setVisual(true);
			filterSpec.setDimensionName(mxDim);
		}
		return filterSpec;
	}

	private void collectEditFilterSpecs(Collection filterSpecs, List result) {
		Iterator iterator = filterSpecs.iterator();
		while (iterator.hasNext()) {
			ReportFilterSpec filterSpec = (ReportFilterSpec) iterator.next();
			if (filterSpec.getVisual()) {
				result.add(filterSpec);
			}
		}
	}

	public Collection getEditFilterSpecs() {
		List collection = new ArrayList();
		collectEditFilterSpecs(getFilterSpecs(), collection);
		if (!getCached()) {
			collectEditFilterSpecs(getPreFilterSpecs(), collection);
		}
		return collection;
	}

	public Collection getNotCalculatedDimensions() {
		List notCalculatedDimensions = new ArrayList();
		/*
		 * for (Iterator iterator = dimensionSpecs.keySet().iterator();
		 * iterator.hasNext();) { ReportDimensionSpec dimensionSpec =
		 * (ReportDimensionSpec) dimensionSpecs.get(iterator.next()); if
		 * (!dimensionSpec.getCalculated()) {
		 * notCalculatedDimensions.add(dimensionSpec); } }
		 */
		Iterator iterator = getDimensionsByIndex().iterator();
		while (iterator.hasNext()) {
			ReportDimensionSpec dim = (ReportDimensionSpec) iterator.next();
			if (!dim.getCalculated()) {
				notCalculatedDimensions.add(dim);
			}
		}
		return notCalculatedDimensions;
	}

	/**
	 * Indica si se deben incluir los totales de cada grupo de datos
	 * 
	 * @return
	 */
	public boolean isVisibleTotals() {
		return visibleTotals;
	}

	/**
	 * Devuelve una lista con las todas las columnas(Dimensiones y métricas) int
	 * DATETIME_TYPE = 0; int STRING_TYPE = 1; int FLOAT_TYPE = 2; int
	 * INTEGER_TYPE = 3; int BOOLEAN_TYPE = 4;
	 * 
	 * @return
	 */
	public List getColumnByIndex() {
		List column = new ArrayList();
		column.addAll(getDimensionsByIndex());
		column.addAll(getMetricsByIndex());
		return column;
	}

	/**
	 * Retorna una lista con las columnas ordenadas con el tipo de dato da cada
	 * una de ellas int DATETIME_TYPE = 0; int STRING_TYPE = 1; int FLOAT_TYPE =
	 * 2; int INTEGER_TYPE = 3; int BOOLEAN_TYPE = 4;
	 */
	public List getColumnTypesByIndex() {
		List columnTypes = new ArrayList();
		Iterator itDimensions = getDimensionsByIndex().iterator();
		Iterator itMetrics = getMetricsByIndex().iterator();

		while (itDimensions.hasNext()) {
			ReportDimensionSpec reportDimensionSpec = (ReportDimensionSpec) itDimensions
					.next();
			if (!reportDimensionSpec.getCalculated()) {
				columnTypes.add(new Integer(reportDimensionSpec.getDataType()
						.getType()));
			}
		}
		while (itMetrics.hasNext()) {
			ReportMetricSpec reportMetricSpec = (ReportMetricSpec) itMetrics
					.next();
			if (!(reportMetricSpec.getCalculated())) {
				columnTypes.add(new Integer(2));
			}
		}
		return columnTypes;
	}

	/**
	 * Retorna un diccionario con los nombres de las columnas y los tipos de
	 * datos de cada una int DATETIME_TYPE = 0; int STRING_TYPE = 1; int
	 * FLOAT_TYPE = 2; int INTEGER_TYPE = 3; int BOOLEAN_TYPE = 4;
	 */
	public Map getColumnTypesByName() {
		Map columnTypes = new HashMap();
		Iterator itDimensions = getDimensionsByIndex().iterator();
		Iterator itMetrics = getMetricsByIndex().iterator();

		while (itDimensions.hasNext()) {
			ReportDimensionSpec reportDimensionSpec = (ReportDimensionSpec) itDimensions
					.next();
			if (!reportDimensionSpec.getCalculated()) {
				columnTypes.put(reportDimensionSpec.getName(), new Integer(
						reportDimensionSpec.getDataType().getType()));
			}
		}
		while (itMetrics.hasNext()) {
			ReportMetricSpec reportMetricSpec = (ReportMetricSpec) itMetrics
					.next();
			if (!(reportMetricSpec.getCalculated())) {
				columnTypes.put(reportMetricSpec.getName(), new Integer(2));
			}
		}
		return columnTypes;
	}

	public Map getPosParamValues() {
		if (posParamValues == null) {
			posParamValues = new HashMap();
		}
		return posParamValues;
	}

	public Map getPreParamValues() {
		if (preParamValues == null) {
			preParamValues = new HashMap();
		}
		return preParamValues;

	}

	/**
	 * Devuelve una coleccion conm las metricas no calculadas considerando el
	 * indice de las mismas.
	 * 
	 * @return
	 */
	public Collection getNotCalculatedMetrics() {
		List notCalculatedMetrics = new ArrayList();
		for (Iterator iterator = getMetricsByIndex().iterator(); iterator
				.hasNext();) {
			ReportMetricSpec metricSpec = (ReportMetricSpec) iterator.next();
			if (!metricSpec.getCalculated()) {
				notCalculatedMetrics.add(metricSpec);
			}
		}
		return notCalculatedMetrics;
	}

	/**
	 * Devuelve el nombre de la dimención según el indice sin contemplar las
	 * columnas calculadas
	 * 
	 * @param index
	 * @return
	 */
	public String getDataSourceIndexNameByIndex(int index) {
		Iterator iter = getDataSourceIndexes().entrySet().iterator();
		boolean find = false;
		String returnValue = "";
		while (iter.hasNext() && !find) {
			Map.Entry entry = (Map.Entry) iter.next();
			if (((Integer) entry.getValue()).intValue() == index) {
				returnValue = entry.getKey().toString();
				find = true;
			}
		}
		return returnValue;
	}

	public void setLayoutDesign(String layoutDesign) {
		LayoutDesign = layoutDesign;
	}

	public String getLayoutDesign() {
		return LayoutDesign;
	}

	public ReportFilterSpec getFilterSpecFromParamName(String paramName) {
		ReportFilterSpec filterSpec = doGetFilterSpecFromParamName(
				getFilterSpecs(), paramName);
		if (filterSpec == null) {
			filterSpec = doGetFilterSpecFromParamName(getPreFilterSpecs(),
					paramName);
		}
		return filterSpec;
	}

	protected ReportFilterSpec doGetFilterSpecFromParamName(Collection filters,
			String paramName) {
		if (filters != null) {
			Iterator iterator = filters.iterator();
			while (iterator.hasNext()) {
				ReportFilterSpec reportFilterSpec = (ReportFilterSpec) iterator
						.next();
				if (reportFilterSpec.includesParam(paramName)) {
					return reportFilterSpec;
				}
			}
		}
		return null;
	}

	public Object[] getVisibleDimensionsByGrouping(boolean grouping) {
		Collection result = new Vector();
		Object[] dims;
		if (grouping) {
			dims = getGroupingDimensions();
		} else {
			dims = getNonGroupingDimensions();
		}
		for (int i = 0; i < dims.length; i++) {
			if (((ReportDimensionSpec) dims[i]).getLocation() != null) {
				result.add(dims[i]);
			}
		}
		return result.toArray();
	}

	public void setReportGeneratorConfiguration(
			ReportGeneratorConfiguration reportGeneratorConfiguration) {
		this.reportGeneratorConfiguration = reportGeneratorConfiguration;
	}

	public ReportGeneratorConfiguration getReportGeneratorConfiguration() {
		return reportGeneratorConfiguration;
	}

}
