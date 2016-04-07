package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.ReportManagerLogger;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.HeaderTableModel;
import com.calipso.reportgenerator.common.DimensionValueNode;
import com.calipso.reportgenerator.common.CubeReportResult;
import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.reportdefinitions.types.ReportDefinitionReportTypeType;
import es.indra.mare.common.info.InfoException;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Dec 15, 2003
 * Time: 5:03:27 PM
 * To change this template use Options | File Templates.
 */

public class CubeReport extends Report {

  private transient ExecutedQueryCollection queryCollection;
  private HeaderTableModel rowsModel;
  private HeaderTableModel columnsModel;
  private Vector dataVector;
  private ReportQuery query;

  public CubeReport() {
  }

  public CubeReport(ReportSpec reportSpec, ReportSource reportSource, ReportGeneratorConfiguration configuration) throws InfoException {
    super(reportSpec, reportSource, configuration);
    initialize();
  }

  /**
   * Ejecuta la inicialización, recolecta toda la información que necesita de la definición del reporte, inicializa
   * los objetos encargados de resolver los cálculos y obtiene los valores de parámetros por defecto.
   * @throws InfoException
   */
  private void initialize() throws InfoException {
    try {
       setReportData(new CubeReportData(getReportSpec()));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("48"), e);
    }
  }

  public String getXml() throws InfoException {
    ReportXmlWriter resultWriter = new CubeReportXmlWriter(getReportData(), getReportSpec(), getQuery().getParamValues(), query);
    return resultWriter.getXml().toString();
  }

  public ReportResult ExecQuery(ReportQuery query) throws InfoException {
    if (query == null) {
      throw new InfoException(LanguageTraslator.traslate("49"));
    }
    if(!getRankingFilters(query).isEmpty()){
      fillEnumeration(query);
    }
      if (query.isValid()) {
        System.gc();
        this.query = query;
        setReportQuery(query);
        ReportManagerLogger.debug(LanguageTraslator.traslate("200"));
        getReportData().setQuery(query, getPivot());
        DataVectorBuilder dataVectorBuilder=null;
        if (!(getExecutedQueryCollection().alreadyExists(query, getConfiguration().queryCacheEnabled()))){
          DimensionValueTreeBuilder dimensionValueTreeBuilder = new DimensionValueTreeBuilder(getReportData());
          DimensionValueNode rowsRoot = dimensionValueTreeBuilder.getRowsRoot();
          DimensionValueNode columnsRoot = dimensionValueTreeBuilder.getColumnsRoot();
          dataVectorBuilder = getDataVectorBuilder(rowsRoot,columnsRoot);
          rowsModel = HeaderTableModel.newRowHeaderTableModel(rowsRoot,getQuery().isVisibleTotals(), dataVectorBuilder.getRowCount(), getQuery(), getReportSpec());
          columnsModel = HeaderTableModel.newColumnHeaderTableModel(columnsRoot, getQuery().isVisibleTotals(), dataVectorBuilder.getColCount(), getQuery(), getReportSpec());
          dataVector = dataVectorBuilder.getDataVector();
          registerReportQuery(query, rowsModel, columnsModel, dataVector);
        //  System.out.println("Se ejecuto uno nuevo");
        } else if((getReportSpec().getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CUBE.toString()))||(getReportSpec().getReportType().toString().equalsIgnoreCase(ReportDefinitionReportTypeType.CHARTCUBE.toString()))) {
          ExecutedQuery executedQuery = getExecutedQueryCollection().getExecutedQuery(query);
          //Para recuperar del disco
          //ExecutedQuery executedQuery = getExecutedQueryCollection().getExecutedQueryFromDisk(query);
          rowsModel = executedQuery.getRowsModel();
          columnsModel = executedQuery.getColumnsModel();
          dataVector = executedQuery.getDataVector();
        //  System.out.println("Se ejecuto un cacheado");
        }
      } else {
        throw new InfoException(LanguageTraslator.traslate("50"));
      }
      return new CubeReportResult(getReportSpec(), query, rowsModel, columnsModel, dataVector);
  }


  private ExecutedQueryCollection getExecutedQueryCollection() {
    if(queryCollection == null) {
      queryCollection = new ExecutedQueryCollection();
    }
    return queryCollection;
  }

  private void registerReportQuery(ReportQuery query, HeaderTableModel rowsModel,
                                 HeaderTableModel columnsModel, Vector dataVector) {
    if(getConfiguration().queryCacheEnabled()) {
      ExecutedQuery executedQuery = null;
      if(getExecutedQueryCollection().getCollectionSize() == 0) {
        executedQuery = new ExecutedQuery(query, rowsModel, columnsModel, dataVector, true);
      } else {
        executedQuery = new ExecutedQuery(query, rowsModel, columnsModel, dataVector, false);
      }
      getExecutedQueryCollection().addExecutedQuery(query, executedQuery);
      //Para disco
      //getExecutedQueryCollection().addExecutedQueryToDisk(query, executedQuery);
    }
  }

  public Vector getUpdatedDataModel(int mode, int row, int col, boolean isDistributed) throws InfoException {
    try {
      boolean changed;
      if (isDistributed){
        changed = false;
        if (mode == HeaderTableModel.MODE_ROW) {
          changed = rowsModel.changeNodeState(row,col);
        } else {
          changed = columnsModel.changeNodeState(row, col);
        }
      }else{
        changed = true;
      }
      if (changed) {
          DataVectorBuilder dataVectorBuilder = getDataVectorBuilder(rowsModel.getDimensionValueNode(), columnsModel.getDimensionValueNode());
          return dataVectorBuilder.getDataVector();
      }
      else {
        return null;
      }
    } catch (InfoException e) {
      throw new InfoException(LanguageTraslator.traslate("327"));
    }
  }

}
