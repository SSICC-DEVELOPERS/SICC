package com.calipso.reportgenerator.common;

import com.calipso.reportgenerator.reportdefinitions.ParameterBind;

import java.io.Serializable;

/**
 * Representa al mapeo para drill down desde parametros
 */
public class ParameterBindSpec implements Serializable{
  private String sourceFilterName;
  private String sourceParameterName;
  private String targetFilterName;
  private String targetParameterName;

  public void fillFrom(ParameterBind parameterBind) {
    sourceFilterName = parameterBind.getSourceFilterName();
    sourceParameterName = parameterBind.getSourceParameterName();
    targetFilterName = parameterBind.getTargetFilterName();
    targetParameterName = parameterBind.getTargetParameterName();
  }

  public String getSourceFilterName() {
    return sourceFilterName;
  }

  public String getSourceParameterName() {
    return sourceParameterName;
  }

  public String getTargetFilterName() {
    return targetFilterName;
  }

  public String getTargetParameterName() {
    return targetParameterName;
  }
}
