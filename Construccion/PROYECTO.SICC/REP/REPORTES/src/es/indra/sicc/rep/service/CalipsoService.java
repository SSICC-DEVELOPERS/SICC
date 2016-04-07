package es.indra.sicc.rep.service;

import com.bitmechanic.sql.ConnectionPoolManager;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.IMareService;
import es.indra.mare.common.mii.MareTopic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Hashtable;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import org.apache.commons.configuration.Configuration;
import es.indra.sicc.util.UtilidadesLog;

public class CalipsoService implements IMareService{

   public CalipsoService() {
       pool = null;
       dataSource = null;
       locked = false;
       conf = null;
   }

   public void init(Configuration conf, MareTopic topic) throws MareException {        
       this.conf = conf;

       Hashtable ht = new Hashtable();
       ht.put("java.naming.factory.initial", conf.getString("initial"));
       ht.put("java.naming.provider.url", conf.getString("url"));
       ht.put("java.naming.security.principal", conf.getString("principal"));
       ht.put("java.naming.security.credentials", conf.getString("credential"));

       try {
           InitialContext ic = new InitialContext(ht);
           dataSource = (DataSource)ic.lookup(conf.getString("datasource"));
       } catch(NamingException nex) {
            nex.printStackTrace();
           throw new MareException("NamingException al crear el initialContext del jms");
       }
   }

   public void shutdown()
   {        locked = true;
       dataSource = null;
   }
   public boolean isInitialized()
   {
       return !locked;
   }

   public DataSource getDataSource()
       throws Exception
   {
       return dataSource;
   }




   public Connection getConnection() throws Exception {
       Connection connection = null;

       if (new String("TRUE").equalsIgnoreCase(conf.getString("db.pool"))) {
           if(conf.getString("db.alias") != null)
           {
               if(pool == null)
               {
                   pool = new ConnectionPoolManager(Integer.parseInt(conf.getString("db.poolTimeOut")));

                   pool.addAlias(conf.getString("db.alias"), conf.getString("db.driver"), conf.getString("db.url"), conf.getString("db.user"), conf.getString("db.password"), Integer.parseInt(conf.getString("db.maxConnection")), Integer.parseInt(conf.getString("db.idleTimeOut")), Integer.parseInt(conf.getString("db.checkOutTimeOut")), Integer.parseInt(conf.getString("db.maxCheckOut")));
               }

               connection = DriverManager.getConnection("jdbc:bitmechanic:pool:" + conf.getString("db.alias"), null, null);

           } else
           {

               if(dataSource == null)
                   dataSource = getDataSource();
               connection = dataSource.getConnection();

           }
       } else
       {

           Class.forName(conf.getString("db.driver"));
           connection = DriverManager.getConnection(conf.getString("db.url"), conf.getString("db.user"), conf.getString("db.password"));
       }


       return connection;
   }

   public ResultSet executeStaticQuery(String sql, int fetchSize)
       throws Exception{

      //System.out.println("Consulta SQL: " + sql);
      UtilidadesLog.debug("Consulta SQL: " + sql);
      ResultSet rs;
 

       try                {
           connection = getConnection();
           st = connection.createStatement();
      	   st.setFetchSize( fetchSize );
           rs = st.executeQuery(sql);
       }
       finally
       {
           //if(rs != null)
           //    rs.close();
       //    if(st != null)
         //      st.close();
           //if(connection != null)
             //  connection.close();
       }
       return rs;
   }

   public ResultSet executeStaticQuery(String sql, int pageCount, int pageSize)
       throws Exception
   {
       //System.out.println("Consulta SQL: " + sql);
       UtilidadesLog.debug("Consulta SQL: " + sql);
     //  System.out.println("pageCount: " + pageCount);
     //  System.out.println("pageSize: " + pageSize);
       Connection connection = null;
       ResultSet rs = null;
       PreparedStatement st = null;
       try
       {
           connection = getConnection();
           st = connection.prepareStatement(sql);
           st.setMaxRows(pageSize * pageCount);
           rs = st.executeQuery();
       }
       finally
       {
           if(rs != null)
               rs.close();
           if(st != null)
               st.close();
           if(connection != null)
               connection.close();
       }
       return rs;
   }

   public ResultSet executePreparedQuery(String sql, Vector parameters)
       throws Exception
   {
       //System.out.println("Consulta SQL: " + sql);
       UtilidadesLog.debug("Consulta SQL: " + sql);
       Connection connection = null;
       ResultSet rs = null;
       PreparedStatement st = null;
       try
       {
           connection = getConnection();
           st = connection.prepareStatement(sql);
           for(int i = 0; i < parameters.size(); i++)
           {
         //      System.out.println("par\341metro " + i + ": " + parameters.elementAt(i));
               st.setObject(i + 1, parameters.elementAt(i));
           }

           rs = st.executeQuery();
       }
       finally
       {
   /*        if(rs != null)
               rs.close();
           if(st != null)
               st.close();
           if(connection != null)
               connection.close();*/
       }
       return rs;
   }

   public ResultSet executePreparedQuery(String sql, Vector parameters, int pageCount, int pageSize)
       throws Exception
   {
       //System.out.println("Consulta SQL: " + sql);
       UtilidadesLog.debug("Consulta SQL: " + sql);
     //  System.out.println("pageCount: " + pageCount);
     //  System.out.println("pageSize: " + pageSize);
       Connection connection = null;
       ResultSet rs = null;
       PreparedStatement st = null;
       try
       {
           connection = getConnection();
           st = connection.prepareStatement(sql);
           st.setMaxRows(pageSize * pageCount);
           for(int i = 0; i < parameters.size(); i++)
           {
            //   System.out.println("par\341metro " + i + ": " + parameters.elementAt(i));
               st.setObject(i + 1, parameters.elementAt(i));
           }

           rs = st.executeQuery();
       }
       finally
       {
           /*if(rs != null)
               rs.close();
           if(st != null)
               st.close();
           if(connection != null)
               connection.close();*/
       }
       return rs;
   }

   public int executeUpdate(String sql)
       throws Exception
   {
       //System.out.println("Sentencia SQL: " + sql);
       UtilidadesLog.debug("Sentencia SQL: " + sql);
       Connection connection = null;
       Statement st = null;
       int rowCount = 0;
       try
       {
           connection = getConnection();
           st = connection.createStatement();
           rowCount = st.executeUpdate(sql);
       }
       finally
       {
           /*if(st != null)
               st.close();
           if(connection != null)
               connection.close();*/
       }
       return rowCount;
   }

   public int executePreparedUpdate(String sql, Vector parameters)
       throws Exception
   {
       //System.out.println("Sentencia SQL: " + sql);
       UtilidadesLog.debug("Sentencia SQL: " + sql);

       Connection connection = null;
       PreparedStatement st = null;
       int rowCount = 0;



       try{
          connection = getConnection();
          st = connection.prepareStatement(sql);

          for(int i = 0; i < parameters.size(); i++)
           {
            //   System.out.println("par\341metro " + i + ": " + parameters.elementAt(i));
               st.setObject(i + 1, parameters.elementAt(i));
           }
           rowCount = st.executeUpdate();
       }


       finally{            
          /*if(st != null)
              st.close();
          if(connection != null)                
              connection.close();*/
       }
       
       return rowCount;
   }

   public Statement getStatement()
   {
     return st;
   }
   
   public void close () throws Exception
   {
     if (getStatement()!= null)
     {
       getStatement().close();       
     }
     if (connection!= null)
     {
       connection.close();
     }
   }
   private Connection connection = null;
   private Statement st = null;
   ConnectionPoolManager pool;
   DataSource dataSource;
   protected boolean locked;
   protected Configuration conf;
}
