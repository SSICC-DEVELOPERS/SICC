
package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportcalculator.SharedInteger;
import com.calipso.reportgenerator.reportcalculator.Pivot;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.reportdefinitions.types.DimensionDefinitionOrderType;
import com.calipso.reportgenerator.reportdefinitions.types.FilterDefinitionFilterTypeType;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.common.ReportFilterSpec;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.DimensionValueNode;
import com.calipso.reportgenerator.common.QueryDimension;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportDimensionSpec;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.LanguageTraslator;
import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;
import java.util.Vector;
import java.util.TreeSet;
import java.io.Serializable;
import es.indra.mare.common.info.InfoException;

/**
 * Esta clase es la representación de un reporte que se ejecuta, se encarga de obtener los datos solicitados del origen,
 * resolver los cálculos y devolver el resultado de acuerdo con la query ejecutada
 */

public abstract class Report implements Serializable{

  private ReportSource reportSource;
  private Pivot pivot;
  private ReportData reportData;
  private ReportSpec reportSpec;
  private ReportQuery query;
  private ReportGeneratorConfiguration configuration;

  /**
   * Constructor por defecto
   */
  public Report() {
  }


  /** Inicializa una instancia de <code>Report</code> a partir de una Definición de Reporte y un origen de datos
   *
   //* @param reportDefinition
   * @param reportSource
   * @throws InfoException
   */
  public Report(ReportSpec reportSpec, ReportSource reportSource, ReportGeneratorConfiguration configuration) throws InfoException {
    if ((reportSpec == null) || (reportSource == null)) {
      throw new InfoException(LanguageTraslator.traslate("47"));
    }
    else {
      this.configuration = configuration;
      this.reportSpec = reportSpec;
      this.reportSource = reportSource;
      pivot = new Pivot();
      pivot.setMatrix(getReportSource().getMatrix());
    }
  }

  public ReportSpec getReportSpec() {
    return reportSpec;
  }

  /**
   * Devuelve el Origen del Reporte
   * @return devuelve el Origen del Reporte correspondiente
   */
  public ReportSource getReportSource() {
    return reportSource;
  }

  /**
   * Devuelve el Pivot del Reporte, que se encarga de leer la información y llenar la estructura calculada
   * <code>ReportData</code>
   * @return
   */

  protected Pivot getPivot() {
    return pivot;
  }

  /**
   * Devuelve la estructura que contiene toda la información calculada a partir de una query
   * @return
   */
  protected ReportData getReportData() {
    return reportData;
  }

  protected void setReportData(ReportData reportData) {
    this.reportData = reportData;
  }

  protected DataVectorBuilder getDataVectorBuilder(DimensionValueNode rowsRoot,DimensionValueNode columnsRoot) throws InfoException {
    return new DataVectorBuilder(rowsRoot, columnsRoot,getReportData().getQuery(),getReportData(),getReportData().getQuery().isVisibleTotals());
  }

  /**
   * Ejecuta la consulta <code>ReportQuery</code> por defecto segun la información contenida en <code>ReportDefinition</code>
   * @return
   */

  public ReportResult ExecQuery(Map paramValues) throws InfoException {
    return ExecQuery(getDefaultQuery(paramValues));
  }

  public ReportGeneratorConfiguration getConfiguration() {
    return configuration;
  }

  /**
   * Devuelve la consulta <code>ReportQuery</code> por defecto segun la información contenida en <code>ReportDefinition</code>
   * @return
   * @throws InfoException
   */
  protected ReportQuery getDefaultQuery() throws InfoException {
    ReportQuery query = new ReportQuery(getReportSpec());
    return query;
  }

  /**
   * Devuelve la consulta <code>ReportQuery</code> por defecto segun la información contenida en <code>ReportDefinition</code>
   * agregándole los valores de parámetros recibidos.
   * @return
   * @throws InfoException
   */
  protected ReportQuery getDefaultQuery(Map paramValues) throws InfoException {
    ReportQuery query = new ReportQuery(getReportSpec());
    query.setParamValues(paramValues);
    return query;
  }

  /**
   * Devuelve la consulta <code>ReportQuery</code> por defecto segun la información contenida en <code>ReportDefinition</code>
   * agregándole los valores de parámetros recibidos.
   * @return
   * @throws InfoException
   */
  protected ReportQuery getDefaultQuery(ReportView reportView) throws InfoException {
    return new ReportQuery(getReportSpec(),reportView);
  }

  /**
   * Devuelve una Consulta <code>ReportQuery</code> sin métricas visibles y sin dimensiones que agrupan.
   * @return
   * @throws InfoException
   */
  protected ReportQuery getQuery() throws InfoException {
    if (query==null){
      query = new ReportQuery(getReportSpec(), false);
    }
    return query;
  }

  protected void setReportQuery(ReportQuery query) {
    this.query = query;
  }

  /**
   * Retorna un iterador a partir del nombre de una dimension
   * @param name nombre de la dimension
   * @return
   */
  public Set getDimensionValues(String name) throws InfoException {
    try {
      QueryDimension dimension = getQuery().getQueryDimensionFromName(name);
      int index = dimension.getIndex();

      return getReportData().getDimensionValues()[index];
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("89"), e);
    }
  }

  /**
   * Devuelvel el xml generado para el cubo
   * @return
   * @throws InfoException
   */
  public abstract String getXml() throws InfoException;

  /**
   * Ejecuta una consulta <code>ReportQuery</code> y devuelve un objeto <code>ReportResult</code> que contiene toda la
   * información involucrada, tanto la que dió como resultado, como la query y los valores de los parámetros que lo
   * determinaron/
   * @return
   * @throws InfoException
   */
  public abstract ReportResult ExecQuery(ReportQuery query) throws InfoException;

  /**
   *   Rellena los valores que debe tener el filtro ranking. Para ello, setea una query que solo
   * contiene la dimension especificada por el filtro y la metrica que utiliza dicha dimension para
   * efectuar su ranking (en caso de no haber ninguna especificada ordenara segun lo correspondiente
   * al tipo de la dimension). Luego ejecuta la query sobre el reporte, tomando todos los filtros
   * menos los de ranking.
   *   Setea los mejores valores al filtro.
   * @throws InfoException
   */
  protected void fillEnumeration(ReportQuery reportQuery) throws InfoException{
    //Obtiene los filtros ranking
    Collection ranking = getRankingFilters(reportQuery);
    Iterator iterator = ranking.iterator();
    while(iterator.hasNext()){
      Set includes = new TreeSet();
      //Construye una query por cada filtro ranking
      ReportQuery query = new ReportQuery(reportQuery.getReportSpec());
      ReportFilterSpec filter = (ReportFilterSpec)iterator.next();
      ReportDimensionSpec dimension = reportQuery.getReportSpec().getDimensionFromName(filter.getDimensionName());
      //Setea la query con la dimension y metrica correspondiente al filtro
      query.setUniqueDimension(dimension);
      query.setUniqueMetricVisible(dimension.getRankMetricName());
      query.setDimensionRankMetricName(filter.getDimensionName(), dimension.getRankMetricName());
      //Remueve los filtros ranking del report spec (y por ende de la query)
      query.removeFilters(ranking);
      //Ejecuta la query
      ReportResult result = ExecQuery(query);
      Collection values = result.getValuesCollection(dimension.getOrder()==DimensionDefinitionOrderType.A);
      if(!values.isEmpty()){
        //Agrega al set los mejores valores
        includes.addAll(getTopFor(reportQuery, values, filter));
      }
      //Vuelve a introducir los filtros ranking en el report spec (y la query)
      query.addFilters(ranking);
      //Le llena al filtro los valores a incluir para la dimension
      reportQuery.getEnumerationFilter().addTo(includes, dimension.getIndex());
    }
  }

  /**
   * Toma los primeros valores de la coleccion. El tope esta especificado por el parametro
   * correspondiente al filtro.
   * @param values
   * @param filter
   * @return
   */
  private Collection getTopFor(ReportQuery reportQuery, Collection values, ReportFilterSpec filter) throws InfoException{
    Collection result = new Vector();
    int max;
    Object o = reportQuery.getParamValues().get(filter.getParamNames().get(0));
    if(o instanceof SharedInteger){
      max = ((SharedInteger)o).intValue();
    }else if(o instanceof SharedString){
      max = Integer.getInteger(((SharedString)o).value()).intValue();
    }else{
      try{
        max = new Integer(o.toString().trim()).intValue();
      }catch (Exception e){
        throw new InfoException(e);
      }
    }
    Iterator iter = values.iterator();
    for(int i=0; i < max && iter.hasNext(); i++){
      Object ob = iter.next();
      if(ob instanceof DimensionValueNode){
        result.add(((DimensionValueNode)ob).getValue());
      }else if(ob instanceof Map.Entry){
        result.add(((Map.Entry)((Map.Entry)ob).getValue()).getKey());
      }
    }
    return result;
  }

  /**
   * Devuelve una coleccion con los filtros de tipo RANKING del report spec
   * @return filtros tipo ranking
   * @throws InfoException
   */
  protected Collection getRankingFilters(ReportQuery reportQuery) throws InfoException{
    Collection result = new Vector();
    Iterator iterator = reportQuery.getReportSpec().getFilterSpecs().iterator();
    while(iterator.hasNext()){
      ReportFilterSpec current = (ReportFilterSpec)iterator.next();
      if(current.getFilterType()==FilterDefinitionFilterTypeType.RANKING){
        result.add(current);
      }
    }
    return result;
  }


}
