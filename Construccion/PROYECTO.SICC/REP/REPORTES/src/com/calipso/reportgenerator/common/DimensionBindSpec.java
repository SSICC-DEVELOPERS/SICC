package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.DimensionBind;

import java.io.Serializable;

/**
  * Representa al mapeo para drill down desde dimensiones
 */
public class DimensionBindSpec implements Serializable{
  private String sourceDimensionName;
  private String targetFilterName;
  private String targetParameterName;

  public void fillFrom(DimensionBind dimensionBind) {
    sourceDimensionName = dimensionBind.getSourceDimensionName();
    targetFilterName = dimensionBind.getTargetFilterName();
    targetParameterName = dimensionBind.getTargetParameterName();
  }

  public String getSourceDimensionName() {
    return sourceDimensionName;
  }

  public String getTargetFilterName() {
    return targetFilterName;
  }

  public String getTargetParameterName() {
    return targetParameterName;
  }
}
