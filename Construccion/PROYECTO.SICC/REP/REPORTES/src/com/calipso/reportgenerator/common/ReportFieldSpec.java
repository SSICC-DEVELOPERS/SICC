package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportcalculator.DataDefinition;

import java.io.Serializable;
import java.util.Map;

/**
 * Esta clase representa a un campo que tendrá un valor en la matrix que sirve
 * de origen de datos al motor de cálculo para la ejecución de un
 * ReportDefinition dado (y su ReportSourceDefinition asociado). Puede que
 * existan o no en el DataSource, en dicho caso el valor se obtiene evaluando
 * expresiones a partir de valores campos conocidos.
 */
public class ReportFieldSpec implements DataDefinition, Serializable {

	public static final String externalFunctionConstant = "EXTERNAL_FUNCTION";

	private boolean calculated;

	private String caption;

	private int dataSourceIndex;

	private Map dataSourceIndexes;

	private String externalData;

	private boolean inReportDefinition;

	private String name;

	private int reportIndex;

	private int reportSourceIndex;

	/**
	 * Construcutor por defecto para cumplir con la Serialización
	 */

	public ReportFieldSpec() {
	}

	/**
	 * Constructor que recibe el nombre que es el identificador de este tipo de
	 * objetos
	 * 
	 * @param name
	 */
	public ReportFieldSpec(String name) {
		this.name = name;
	}

	/**
	 * Especifica si el valor del campo se obtiene directamente del valor de un
	 * campo del <code>IRDataSource</code>(false) o si se calcula a través de
	 * una expresión (true)
	 * 
	 * @return
	 */
	public boolean getCalculated() {
		return calculated;
	}

	/**
	 * Devuelve la descripción o texto legible del campo
	 * 
	 * @return
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * Devuelve el indice del campo en el DataSource, esto quiere decir que los
	 * campos que tengan el atributo <code>calculated</code> en
	 * <code>true</code> tendrán este indice con valor -1.
	 * 
	 * @return
	 */
	public int getDataSourceIndex() {
		return dataSourceIndex;
	}

	/**
	 * Diccionario que asocia los nombres de los campos con sus
	 * ReportSourceIndex
	 * 
	 * @return
	 */

	public Map getDataSourceIndexes() {
		return dataSourceIndexes;
	}

	/**
	 * Devuelve el indice de otro campo a partir del nombre, se utiliza para la
	 * evaluación de expresiones de campos calculados
	 * 
	 * @param referencedName
	 * @return
	 */
	protected int getDataSourceIndexFromName(String referencedName) {
		return ((Integer) getDataSourceIndexes().get(referencedName))
				.intValue();
	}

	/**
	 * Devuelve la información asiciada al campo que será utilizada por el
	 * sistema externo que devuelva el <code>IRDataSource</code>
	 * 
	 * @return
	 */

	public String getExternalData() {
		return externalData;
	}

	/**
	 * Indice respecto a los campos de la del Matix Implementación de la
	 * interface <code>DataDefinition</code>
	 * 
	 * @return
	 */
	public int getIndex() {
		return getReportSourceIndex();
	}

	/**
	 * Se utiliza para saber si un campo se encuentra incluido en el
	 * ReportDefinition, debido a que un mismo ReportSourceDefinition puede ser
	 * compartido por varios ReportDefinition, puede haber campos que no deban
	 * ser tenidos en cuanta para la resoución de un reporte
	 * 
	 * @return
	 */
	public boolean getInReportDefinition() {
		return inReportDefinition;
	}

	/**
	 * Devuelve el nombre del campo
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Devuelve el indice respecto a los campos de la de la ReportDefinition
	 * 
	 * @return
	 */
	public int getReportIndex() {
		return reportIndex;
	}

	/**
	 * Devuelve el indice respecto a los campos de la de la Matix
	 */

	public int getReportSourceIndex() {
		return reportSourceIndex;
	}

	/**
	 * Resuelve el texto visible de la descripción de un campo según la
	 * localización
	 * 
	 * @param multilanguaje
	 * @param localization
	 * @param caption
	 * @return
	 */
	protected String resolveCaption(boolean multilanguaje, Map localization,
			String caption) {
		if (multilanguaje && (localization != null) && (caption != null)
				&& localization.containsKey(caption)) {
			return localization.get(caption).toString();
		} else if ((localization != null)
				&& (caption!=null)
				&& (localization.containsKey(caption))) {
			return localization.get(caption).toString();
		} else {
			return caption;
		}
	}

	/**
	 * Asigna el valor de la propiedad Calculated
	 * 
	 * @param calculated
	 */
	public void setCalculated(boolean calculated) {
		this.calculated = calculated;
	}

	/**
	 * Asigna la descripción o text legible del campo
	 * 
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * Asigna el valor de la propiedad DataSourceIndex
	 * 
	 * @param dataSourceIndex
	 */

	public void setDataSourceIndex(int dataSourceIndex) {
		this.dataSourceIndex = dataSourceIndex;
	}

	/**
	 * Asigna el diccionario que asocia los nombres de los campos con sus
	 * ReportSourceIndex Se para a todos los campos una referencia a la misma
	 * lista.
	 * 
	 * @param values
	 */
	public void setDataSourceIndexes(Map values) {
		dataSourceIndexes = values;
	}

	/**
	 * Asigna el valor de la propiedad ExternalData
	 * 
	 * @param externalData
	 */

	public void setExternalData(String externalData) {
		this.externalData = externalData;
	}

	/**
	 * Asigna el verdadero si el campo está incluido en el ReportDefinition del
	 * reporte que se está ejecutando
	 * 
	 * @param inReportDefinition
	 */
	public void setInReportDefinition(boolean inReportDefinition) {
		this.inReportDefinition = inReportDefinition;
	}

	/**
	 * Asigna el nombre del campo
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Asigna el indice respecto a los campos de la de la ReportDefinition
	 * 
	 * @param reportIndex
	 */
	public void setReportIndex(int reportIndex) {
		this.reportIndex = reportIndex;
	}

	/**
	 * Asigna el indice respecto de los campos de la Matrix
	 * 
	 * @param reportSourceIndex
	 */

	public void setReportSourceIndex(int reportSourceIndex) {
		this.reportSourceIndex = reportSourceIndex;
	}

}
