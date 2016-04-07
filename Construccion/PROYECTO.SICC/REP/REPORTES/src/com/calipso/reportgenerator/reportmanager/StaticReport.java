package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.common.ReportQuery;
import com.calipso.reportgenerator.common.StaticReportResult;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ReportSpec;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.ReportResult;
import com.calipso.reportgenerator.reportcalculator.DataTree;
import es.indra.mare.common.info.InfoException;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: Dec 15, 2003
 * Time: 5:03:14 PM
 * To change this template use Options | File Templates.
 */

public class StaticReport extends Report {

  private DataTree dataTree;

  public StaticReport() {
  }

  public StaticReport(ReportSpec reportSpec, ReportSource reportSource, ReportGeneratorConfiguration configuration) throws InfoException {
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
       setReportData(new StaticReportData(getReportSpec()));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("48"), e);
    }
  }

  public String getXml() throws InfoException {
    ReportXmlWriter resultWriter = new StaticReportXmlWriter(getReportData(), getReportSpec(), getQuery().getParamValues());
    return resultWriter.getXml().toString();
  }

  public ReportResult ExecQuery(ReportQuery query) throws InfoException {
    if (query == null) {
      throw new InfoException(LanguageTraslator.traslate("49"));
    } else {
      if(!getRankingFilters(query).isEmpty()){
        fillEnumeration(query);
      }
      if(query.isValid()) {
        getReportData().setQuery(query, getPivot());
        dataTree = ((StaticReportData)getReportData()).getDataTree();
      } else {
        throw new InfoException(LanguageTraslator.traslate("50"));
      }
    }
    return new StaticReportResult(getReportSpec(), query, dataTree);
  }

}
