package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportdefinitions.DimensionSourceDefinition;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.DateExpressionResolver;
import com.calipso.reportgenerator.common.DateExpressionParser;
import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;

/**
 * Esta clase se utliza para llenar la <code>Matix</code> del <code>ReportSource</code> a partir del <IRDataSource> entregado
 * por los <ReportDataSource>.
 * En las columnas comunes se encarga del obtener el valor a partir del índice del campo en el registro
 * En las columnas calculadas se encarga de ejecutar las operaciones necesarias para obtener el valor
 */

public class ReportSourceDimension {

  private int index;
  private int dataIndex;
  private DimensionSourceDefinition dimensionSourceDefinition;
  private DateExpressionParser expressionParser;
  private String datePattern;

  /**
   * Constructor que inicializa
   * @param dimensionSourceDefinition
   * @param index Indice de la matriz del pivot
   * @param dataIndex Indice del data source
   */
  public ReportSourceDimension(DimensionSourceDefinition dimensionSourceDefinition, int index, int dataIndex) {
    this.dimensionSourceDefinition = dimensionSourceDefinition;
    this.index = index;
    if (dimensionSourceDefinition.getCalculated()) {
      this.dataIndex = -1;
    }
    else {
      this.dataIndex = dataIndex;
    }
  }

  /**
   * Constructor que inicializa el el formato de fecha
   * @param dimensionSourceDefinition
   * @param index
   * @param dataIndex
   * @param datePattern
   */
  public ReportSourceDimension(DimensionSourceDefinition dimensionSourceDefinition, int index, int dataIndex, String datePattern) {
    this(dimensionSourceDefinition, index, dataIndex);
    this.datePattern = datePattern;
  }

  /**
   * Devuelve un date expression parser
   * @see com.calipso.reportgenerator.common.DateExpressionParser
   * @return
   */
  protected DateExpressionParser getExpressionParser() {
    if (expressionParser == null) {
      expressionParser = new DateExpressionParser();
    }
    return expressionParser;
  }

  /**
   * Indice que se utiliza para buscar en la matrix de datos para calcular
   * @return
   */
  public int getIndex() {
    return index;
  }


  /**
   * Indice que se utiliza para buscar en el IRDataSource
   * Este indice es distinto porque en el IRDataSource no están las columnas calculadas
   * @return
   */
  public int getDataIndex() {
    return dataIndex;
  }

  /**
   * Devuelve el dimension source definition
   * @return
   */
  public DimensionSourceDefinition getDimensionSourceDefinition() {
    return dimensionSourceDefinition;
  }

  private int getCalculatedDataIndex(String name, IRDataSource dataSource) {
    if (dataIndex == -1) {
      for (int i = 0; i < dataSource.getColumCount(); i++) {
        String colName = dataSource.getColumName(i);
        if (colName.equals(name)) {
          return i;
        }
      }
    }
    return dataIndex;
  }

  /**
   * Devuelve el valor de la dimensión
   * @param dataSource
   * @param index
   * @return
   * @throws InfoException
   */
  public Object getValue(IRDataSource dataSource, int index) throws InfoException {
    try {
      if (getDimensionSourceDefinition().getCalculated()) {
        String expression = getDimensionSourceDefinition().getExpression();
        getExpressionParser().setExpression(expression);
        String refDimensionName = getExpressionParser().getFieldName();
        int calcDataIndex = getCalculatedDataIndex(refDimensionName, dataSource);
        String dateString = dataSource.getValueAt(index, calcDataIndex).toString();
        String resultValue = DateExpressionResolver.Resolve(getExpressionParser().getDateFunction(), dateString, getDatePattern());
        return resultValue;
      }
      else {
        return dataSource.getValueAt(index, this.dataIndex).toString();
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("90"), e);
    }
  }

  /**
   * Devuelve el formato de fecha
   * @return
   */
  public String getDatePattern() {
    return datePattern;
  }

  /**
   * Asigna el formato de fecha
   * @param pattern
   */
  public void setDatePattern(String pattern) {
    datePattern = pattern;
  }
}
