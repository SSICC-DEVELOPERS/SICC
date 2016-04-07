package com.calipso.reportgenerator.services;

import es.indra.mare.common.info.InfoException;
import es.indra.sicc.rep.service.CalipsoService;
import es.indra.sicc.util.BelcorpService;
import java.sql.ResultSet;

/**  
 * Resuelve el vinculo con Mare para ejecutar SQL
 */
public class MareSQLDataSourceResolver extends SQLDataSourceResolver{
  private CalipsoService serv;

  
  protected ResultSet getResultSet(String sqlText) throws InfoException {
    try {
      serv = BelcorpService.getInstance().calipsoService;
      ResultSet rs;
    //  System.out.println(sqlText);
      if (getReportGeneratorConfiguration() == null)
          rs = serv.executeStaticQuery(sqlText, 500);
      else
          rs = serv.executeStaticQuery(sqlText, getReportGeneratorConfiguration().getFetchSize());
          
      return rs;
    }catch (Exception e){
      throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("156"),e);
    }
  }

  public void close() throws Exception{
    if(serv!=null){
      serv.close();
    }
  };

}
