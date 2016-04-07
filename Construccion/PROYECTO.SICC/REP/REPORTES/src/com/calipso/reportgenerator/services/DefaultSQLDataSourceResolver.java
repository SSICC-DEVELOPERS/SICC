package com.calipso.reportgenerator.services;

import es.indra.mare.common.info.InfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 * Devuelve un ejecutor de SQL por defecto
 */
public class DefaultSQLDataSourceResolver extends SQLDataSourceResolver{
  private Statement st;
  private Connection connection;

  protected ResultSet getResultSet(String sqlText) throws InfoException {
    try {
      Statement st = null;
      connection = getConnection();
      st = connection.createStatement();
      ResultSet rs = null;

   //   System.out.println("Antes de ejecutar el SQL"+(new Date()).toString());
      st.setFetchSize( getReportGeneratorConfiguration().getFetchSize());
      rs = st.executeQuery(sqlText);
      return rs;
    } catch (SQLException e) {
      throw new InfoException();   
    }
  }

  
  /**
   * Retorna una connection de base de dato dependiendo del contexto donde se ejecuta. Local o distribuido.
   * @return
   * @throws InfoException
   */
  protected Connection getConnection() throws InfoException {
    Connection con = null;
/*    if(!getReportGeneratorConfiguration().getIsDistributed()) {*/
      try {
        Class.forName(getDataSourceDefinitionConnectionString().getValue("DatabaseConfigurationClassName"));
        con = DriverManager.getConnection(getDataSourceDefinitionConnectionString().getValue("DatabaseConfigurationLocalUrl"), getDataSourceDefinitionConnectionString().getValue("DatabaseConfigurationUser"), getDataSourceDefinitionConnectionString().getValue("DatabaseConfigurationPassword"));
      } catch (Exception e) {
        throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("95"), e);
      }
/*    } else {
      try {
        Context jndiCntx = new InitialContext();
        javax.sql.DataSource ds = (javax.sql.DataSource)jndiCntx.lookup(getDataSourceDefinitionConnectionString().getValue("DatabaseConfigurationDistributedUrl"));
        con = ds.getConnection();
      } catch(Exception e) {
        throw new InfoException(com.calipso.reportgenerator.common.LanguageTraslator.traslate("362"), e);
      }
    }
*/    return con;
  }
  
  public void close() throws Exception
  {
    if (st!= null)
     {
       st.close();       
     }
     if (connection!= null)
     {
       connection.close();
     }    
  }
}
