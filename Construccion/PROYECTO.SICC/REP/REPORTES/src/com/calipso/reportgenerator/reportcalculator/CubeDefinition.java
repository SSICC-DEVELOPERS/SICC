package com.calipso.reportgenerator.reportcalculator;

/**
 * Es la especificación del Cube, contiene información acerca de las dimensiones y métricas que contiene la matriz
 * del pivot
 */

public interface CubeDefinition {
    public Object[] getDimensions();
    public Object[] getMetrics();
}

/*private class CubeDefinition2 implements TestCubeDefinition, Serializable {
  private Object[] dimensions;
  private Object[] metrics;

  public CubeDefinition2() {
  }

  public Object[] getDimensionSpecs() {
    return dimensions;
  }

  public void setDimensions(Object[] dimensions) {
    this.dimensions = dimensions;
  }

  public Object[] getMetricSpecs() {
    return metrics;
  }

  public void setMetrics(Object[] metrics) {
    this.metrics = metrics;
  }


  public DimensionDataDefinition getDimensionFromName(String name){
    for (int i = 0; i < dimensions.length; i++) {
      DimensionDataDefinition dimension = (DimensionDataDefinition) dimensions[i];
      if (dimension.getName().equalsIgnoreCase(name)){
        return dimension;
      }
    }
    return null;
  }

  public MetricDataDefinition getMetricFromName(String name){
    for (int i = 0; i < metrics.length; i++) {
      MetricDataDefinition metric = (MetricDataDefinition) metrics[i];
      if (metric.getName().equalsIgnoreCase(name)){
        return metric;
      }
    }
    return null;
  }
}  */
