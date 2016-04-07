package com.calipso.reportgenerator.reportcalculator;

/**
 * Interface que publica los metodos a implementar por la
 * clase <code>DataTree</code>
 */

public interface DataTreeDefinition {
    public Object[] getGroupingDimensions();
    public Object[] getNonGroupingDimensions();
    public Object[] getMetrics();
    public Object[] getAccumulableMetrics();
    public boolean getAccumulable();
}
