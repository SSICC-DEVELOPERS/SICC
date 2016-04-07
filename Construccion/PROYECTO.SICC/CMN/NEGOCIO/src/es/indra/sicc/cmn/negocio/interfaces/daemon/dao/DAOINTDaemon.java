package es.indra.sicc.cmn.negocio.interfaces.daemon.dao;

import es.indra.sicc.cmn.negocio.interfaces.daemon.FileFolder;
import es.indra.sicc.cmn.negocio.interfaces.daemon.dao.FileInfo;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.ConfigFactory;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DAOINTDaemon 
{
  private static final String CREATE_TABLES = 
    "CREATE TABLE files (interface VARCHAR(10), "+
                          "file VARCHAR(256), " +
                          "state INTEGER NOT NULL, " + 
                          "inDate DATE NOT NULL, " + 
                          "notifDate DATE, " + 
                          "outDate DATE )";
    
  private static final String CREATE_INDEX = 
    "CREATE UNIQUE INDEX intIndex ON files(interface,file)";

  private static final String LOAD_FILES = 
    "SELECT VAL_INTE_NAME,VAL_FILE_NAME,COD_STAT,FEC_IN,FEC_NOTI,FEC_OUT " +
    "FROM gen_files " +
    "WHERE VAL_INTE_NAME = ? AND COD_STAT <> " + FileFolder.ESTADO_IMPORTADO +
    " AND COD_STAT <> " + FileFolder.ESTADO_ERROR;

  private static final String INSERT_FILE = 
    "INSERT INTO gen_files(VAL_INTE_NAME, VAL_FILE_NAME, COD_STAT, FEC_IN) VALUES( ?, ?, ?, ? )";
    
  private static final String REMOVE_FILE = 
    "DELETE FROM gen_files WHERE VAL_INTE_NAME = ? AND VAL_FILE_NAME = ?";
    
  private static final String SET_NOTIFIED = 
    "UPDATE gen_files SET COD_STAT = ?, FEC_NOTI = ? WHERE VAL_INTE_NAME = ? AND VAL_FILE_NAME = ?";
    
  private static final String SET_IMPORTED = 
    "UPDATE gen_files SET COD_STAT = ?, FEC_OUT = ? WHERE VAL_INTE_NAME = ? AND VAL_FILE_NAME = ?";
    
  private static final String SET_ERROR = 
    "UPDATE gen_files SET COD_STAT = ? WHERE VAL_INTE_NAME = ? AND VAL_FILE_NAME = ?";


  static
  {
    try
    {
      Class.forName( ConfigFactory.getINTDaemonConfig().getDBDriver() );
      //checkDB();
    } catch( Exception ex )
    {
      Util.getLog().error( "Error al obtener driver de BD", ex );
    }
  }
  
  public static synchronized final Connection getDBConnection()
  {
    Connection con = null;

    try {
      //Class.forName( ConfigFactory.getINTDaemonConfig().getDBDriver() );
      con = DriverManager.getConnection 
        ( ConfigFactory.getINTDaemonConfig().getDBURL(), 
          ConfigFactory.getINTDaemonConfig().getDBUser(), 
          ConfigFactory.getINTDaemonConfig().getDBPassword() );
          //"" );

    }
    catch( Exception ex ) 
    {
      Util.getLog().error( "Error al obtener conexión con BD", ex );
      //System.exit(0);
    }
    
    return con;
  }
  
  private static final void checkDB()
  {
    Connection con = getDBConnection();
    ResultSet rs = null;
    PreparedStatement st = null;
    
    try
    {
      st = con.prepareStatement( CREATE_TABLES );
      st.executeUpdate();
      Util.getLog().info( "Creada tabla INTERFACES" );
      //st = con.prepareStatement( CREATE_INDEX );
      //st.executeUpdate();
      //Util.getLog().info( "Creado índice en tabla INTERFACES" );
      con.commit();
    } catch( SQLException ex ) {}
		finally {
			try {
				if( rs != null ) rs.close();
				if( st != null ) st.close();
				if( con != null )con.close();
			} catch( SQLException ex ) {
				Util.getLog().error( "Error al cerrar conexión con BD", ex );
			}
		}
  }
  
  public static List loadFiles( String folder )
  {
    Connection con = getDBConnection();
    ResultSet rs = null;
    PreparedStatement st = null;
    
    List files = new ArrayList();
    try
    {
      st = con.prepareStatement( LOAD_FILES );
      st.setString( 1, folder );
    
      rs = st.executeQuery();
    
      FileInfo info = null;
      while( rs.next() )
      {
        info = new FileInfo();
        info.setInterfaz( rs.getString("VAL_INTE_NAME") );
        info.setFile( rs.getString("VAL_FILE_NAME") );
        info.setState( new Integer( rs.getInt("COD_STAT") ) );
        info.setInDate( rs.getDate("FEC_IN") );
        info.setNotifDate( rs.getDate("FEC_NOTI") );
        info.setOutDate( rs.getDate("FEC_OUT") );
        
        files.add( info );
      }
    } catch( SQLException sqlex )
    {
      sqlex.printStackTrace();
      Util.getLog().info( "Error al recuperar ficheros", sqlex );
    } finally
    {
      try
      {
        if( rs != null ) rs.close();
        if( st != null ) st.close();
        if( con != null && !con.isClosed() ) con.close();
      } catch( Exception ex )
      {
        Util.getLog().error( "Error al cerrar conexión con BD", ex );
      }
    }
    
    return files;
  }
  
  public static void insertFile( FileInfo info )
  {
    Connection con = getDBConnection();
    PreparedStatement st = null;
    
    try
    {
      st = con.prepareStatement( INSERT_FILE );
      st.setString( 1, info.getInterfaz() );
      st.setString( 2, info.getFile() );
      st.setInt( 3, info.getState().intValue() );
      st.setDate( 4, info.getInDate() );
      Util.getLog().info( st );
      int i = st.executeUpdate();
      if( i == -1 )
        throw new SQLException();
        
    } catch( SQLException sqlex )
    {
      sqlex.printStackTrace();
      Util.getLog().error( "Error al insertar registro", sqlex );

    } finally
    {
      try
      {
			  if( st != null ) st.close();
			  if( con != null && !con.isClosed() ) con.close();
			} catch( Exception e )
      {
        Util.getLog().error( "Error al cerrar conexión BD", e );
      }
    }
    
  }
  
  public static void setNotified( FileInfo info )
  {
    Util.getLog().info( "[INTDaemon] setNotified" );
  
    Connection con = getDBConnection();
    PreparedStatement st = null;
    
    try
    {
      st = con.prepareStatement( SET_NOTIFIED );
      st.setInt( 1, info.getState().intValue() );
      st.setDate( 2, info.getNotifDate() );
      st.setString( 3, info.getInterfaz() );
      st.setString( 4, info.getFile() );
      Util.getLog().info( st );
      int i = st.executeUpdate();
      if( i == -1 )
        throw new SQLException();

    } catch( SQLException sqlex )
    {
      sqlex.printStackTrace();
      Util.getLog().error( "Error al actualizar registro", sqlex );
    } finally
    {
      try
      {
			  if( st != null ) st.close();
			  if( con != null && !con.isClosed() ) con.close();
			} catch( Exception e )
      {
        Util.getLog().error( "Error al cerrar conexión BD", e );
      }
    }
  }
  
  public static void setImported( FileInfo info )
  {
    Util.getLog().info( "[INTDaemon] setImported" );
    Connection con = getDBConnection();
    PreparedStatement st = null;
    
    try
    {
      st = con.prepareStatement( SET_IMPORTED );
      st.setInt( 1, info.getState().intValue() );
      st.setDate( 2, info.getOutDate() );
      st.setString( 3, info.getInterfaz() );
      st.setString( 4, info.getFile() );
      Util.getLog().info( st );
      int i = st.executeUpdate();
      if( i == -1 )
        throw new SQLException();

    } catch( SQLException sqlex )
    {
      sqlex.printStackTrace();
      Util.getLog().error( "Error al actualizar registro", sqlex );
    } finally
    {
      try
      {
			  if( st != null ) st.close();
			  if( con != null && !con.isClosed() ) con.close();
			} catch( Exception e )
      {
        Util.getLog().error( "Error al cerrar conexión BD", e );
      }
    }
    
    Util.getLog().info( "Fichero " + info.getFile() + " importado" );
  }
  
  public static void setError( FileInfo info )
  {
    Util.getLog().info( "[INTDaemon] setError" );
    Connection con = getDBConnection();
    PreparedStatement st = null;
    
    try
    {
      st = con.prepareStatement( SET_ERROR );
      st.setInt( 1, info.getState().intValue() );
      st.setString( 2, info.getInterfaz() );
      st.setString( 3, info.getFile() );
      int i = st.executeUpdate();
      if( i == -1 )
        throw new SQLException();

    } catch( SQLException sqlex )
    {
      sqlex.printStackTrace();
      Util.getLog().error( "Error al actualizar registro", sqlex );
    } finally
    {
      try
      {
			  if( st != null ) st.close();
			  if( con != null && !con.isClosed() ) con.close();
			} catch( Exception e )
      {
        Util.getLog().error( "Error al cerrar conexión BD", e );
      }
    }
    
    Util.getLog().info( "Fichero " + info.getFile() + " importado" );
  }
  
  
  public static void removeFile( String interfaz )
  {
    Connection con = getDBConnection();
  }
  
  public static void shutdown() throws SQLException
  {

  }
  

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    //DAOINTDaemon.insertFile( "LAR-1", "prueba2.txt" );
    //DAOINTDaemon.insertFile( "LAR-1", "pepe.csv" );
    //List files = DAOINTDaemon.loadFiles( "LAR-1" );
    //UtilidadesLog.debug( files );
  }
}