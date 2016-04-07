package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportmanager.IRDataSource;
import es.indra.mare.common.info.InfoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;
import com.calipso.reportgenerator.reportcalculator.SharedString;
import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.services.DataSourceDefinitionConnectionString;

/**
 * Esta clase genera un data source(IRDataSource) a partir de un SQL
 */
public class SQLDataSourceResolve {
  private ReportGeneratorConfiguration reportGeneratorConfiguration;
  private DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString;


  /**
   * Constructor que inicializa el string de connection a la base de datos
   * @param reportGeneratorConfiguration
   * @param dataSourceDefinitionConnectionString
   */

  public SQLDataSourceResolve(ReportGeneratorConfiguration reportGeneratorConfiguration, DataSourceDefinitionConnectionString dataSourceDefinitionConnectionString) {
    this.reportGeneratorConfiguration = reportGeneratorConfiguration;
    this.dataSourceDefinitionConnectionString = dataSourceDefinitionConnectionString;
  }

  /**
   * Ejecuta la query, construye el datasource y lo devuelve
   * @throws InfoException
   */
  public IRDataSource getDataSource(String SQLText, int colNum) throws InfoException {
    RDataSource dataSource = null;
  //  System.out.println("despues de jdbc,getConnection");
    Statement stmt = null;
    Connection con = null;
    try {
      con = getConnection();
      stmt = con.createStatement();
      ResultSet rs = null;
      rs = stmt.executeQuery(SQLText);
      dataSource = new RDataSource(colNum);
      while (rs.next()) {
        Collection collection = new Vector();
        for (int i = 1; i < (colNum + 1); i++) {
          collection.add(SharedString.newFrom(rs.getString(i)));
        }
        dataSource.addRow(collection);
      }
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("95"), e);
    } finally {
      try{
        if(con != null){
          con.close();
        }
      }catch (Exception e){
        throw new InfoException(LanguageTraslator.traslate("95"), e);        
      }
    }
    return dataSource;
  }

  /**
   * Retorna una connection de base de dato dependiendo del contexto donde se ejecuta. Local o distribuido.
   * @return
   * @throws InfoException
   */
  protected Connection getConnection() throws InfoException {
    Connection con = null;
    try {
      Class.forName(dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationClassName"));
      con = DriverManager.getConnection(dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationLocalUrl"), dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationUser"), dataSourceDefinitionConnectionString.getValue("DatabaseConfigurationPassword"));
    } catch (Exception e) {
      throw new InfoException(LanguageTraslator.traslate("97"), e);
    }
    return con;
  }
}
