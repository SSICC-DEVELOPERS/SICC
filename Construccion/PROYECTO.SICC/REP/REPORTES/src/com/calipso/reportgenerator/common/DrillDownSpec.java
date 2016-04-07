package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.DrillDownDefinition;
import com.calipso.reportgenerator.reportdefinitions.DimensionBind;
import com.calipso.reportgenerator.reportdefinitions.ParameterBind;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.Serializable;


/**
 * Explota informacion para visualizarla de forma mas detallada
 */

public class DrillDownSpec implements Serializable {
  private String description;
  private String name;
  private String targetReportDefinitionID;
  private List dimensionBindSpecs;
  private List parameterBindSpecs;


  /**
   * Llena los parametros.
   * @param drillDownDefinition
   */
  public void fillFrom(DrillDownDefinition drillDownDefinition){
    description = drillDownDefinition.getDescription();
    name = drillDownDefinition.getName();
    targetReportDefinitionID = drillDownDefinition.getTargetReportDefinitionID();
    dimensionBindSpecs = new ArrayList();
    Enumeration dimensionBindEnum = drillDownDefinition.enumerateDimensionBind();
    while (dimensionBindEnum.hasMoreElements()) {
      DimensionBind dimensionBind = (DimensionBind) dimensionBindEnum.nextElement();
      DimensionBindSpec dimensionBindSpec = new DimensionBindSpec();
      dimensionBindSpec.fillFrom(dimensionBind);
      dimensionBindSpecs.add(dimensionBindSpec);
    }
    parameterBindSpecs = new ArrayList();
    Enumeration parameterBindEnum = drillDownDefinition.enumerateParameterBind();
    while (parameterBindEnum.hasMoreElements()) {
      ParameterBind parameterBind = (ParameterBind) parameterBindEnum.nextElement();
      ParameterBindSpec parameterBindSpec = new ParameterBindSpec();
      parameterBindSpec.fillFrom(parameterBind);
      parameterBindSpecs.add(parameterBindSpec);
    }
  }

  /**
   * Retorna la descripcion
   * @return
   */
  public String getDescription() {
    return description;
  }

  /**
   * Retorna el nombre.
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna el id del <code>ReportDefinition</code> target.
   * @return
   */
  public String getTargetReportDefinitionID() {
    return targetReportDefinitionID;
  }

  /**
   * Retorna una lista con las instancias de <code>DimensionBindSpecs</code>
   * @return
   */
  public List getDimensionBindSpecs() {
    return dimensionBindSpecs;
  }
  /**
   * * Retorna una lista con las instancias de <code>ParameterBindSpecs</code>
   * @return
   */
  public List getParameterBindSpecs() {
    return parameterBindSpecs;
  }
}
