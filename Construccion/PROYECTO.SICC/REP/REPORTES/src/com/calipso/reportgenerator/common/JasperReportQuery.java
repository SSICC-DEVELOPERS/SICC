package com.calipso.reportgenerator.common;


import dori.jasper.engine.JRQuery;
import dori.jasper.engine.JRQueryChunk;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 01/06/2004
 * Time: 14:20:41
 * To change this template use Options | File Templates.
 */
public class JasperReportQuery implements JRQuery {

  private String sqlText = "";

  public JasperReportQuery(String queryText) {
    sqlText = queryText;
  }

  public JRQueryChunk[] getChunks() {
    return new JRQueryChunk[0];
  }

  public String getText() {
    return sqlText;
  }

  public void setText(String sqlQuery){
    sqlText = sqlQuery;
  }
}
