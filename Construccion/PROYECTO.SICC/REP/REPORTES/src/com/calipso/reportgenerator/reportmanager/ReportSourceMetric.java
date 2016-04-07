package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportdefinitions.MetricSourceDefinition;
import com.calipso.reportgenerator.reportmanager.IRDataSource;


/**
 * Esta clase se utliza para llenar la <code>Matix</code> del <code>ReportSource</code> a partir del <IRDataSource> entregado
 * por los <ReportDataSource>.
 * En las columnas comunes se encarga del obtener el valor a partir del índice del campo en el registro
 * En las columnas calculadas se encarga de ejecutar las operaciones necesarias para obtener el valor
 */

public class ReportSourceMetric extends Object {

  private int index;
  private int dataIndex;
  private MetricSourceDefinition metricSourceDefinition;

  /**
   * Contruye e inicializa un report source metric
   * @param metricSourceDefinition
   * @param index Indice de la matriz del pivot
   * @param dataIndex Indice del data source
   */
  public ReportSourceMetric(MetricSourceDefinition metricSourceDefinition, int index, int dataIndex) {
    this.metricSourceDefinition = metricSourceDefinition;
    this.index = index;
    this.dataIndex = dataIndex;
  }

  /**
   * Devuelve el índice de la matriz del pivot
   * @return
   */
  public int getIndex() {
    return index;
  }

  /**
   * Devuelve el índice del data source
   * @return
   */
  public int getDataIndex() {
    return dataIndex;
  }

  /**
   * Devuelve el metric source definition
   * @see MetricSourceDefinition
   * @return
   */
  public MetricSourceDefinition getMetricSourceDefinition() {
    return metricSourceDefinition;
  }

  /**
   * Devuelve el valor de la métrica
   * @param dataSource
   * @param index
   * @return
   */
  public Object getValue(IRDataSource dataSource, int index) {
    if (getMetricSourceDefinition().getCalculated()) {
      return new Float(0); //hacer
    }
    else {
      //return new Float(dataSource.getValueAt(index, this.metricSourceDefinition.getName()).toString());
      return new Float(dataSource.getValueAt(index, this.dataIndex).toString());
    }
  }


}
