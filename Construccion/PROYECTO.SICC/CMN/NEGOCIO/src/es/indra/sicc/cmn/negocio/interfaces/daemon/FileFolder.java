package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.daemon.dao.DAOINTDaemon;
import es.indra.sicc.cmn.negocio.interfaces.daemon.dao.FileInfo;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.impl.DefaultFileMonitor;

public class FileFolder
{ 
  public static final String INTERFAZ = "Interfaz";

  public static final Integer ESTADO_PENDIENTE  = new Integer(1);
  public static final Integer ESTADO_NOTIFICADO = new Integer(2);
  public static final Integer ESTADO_IMPORTADO  = new Integer(3);
  public static final Integer ESTADO_ERROR      = new Integer(4);

  private String pais;
  private String codigo;
  private String url;
  private String periodoMuestreo;
  private String patronNombres;
  private String IDBusiness;
  
  private FileObject buzon = null;
  private FileObject[] files;
  private DefaultFileMonitor monitor = null;
  
  public FileFolder() throws MareException
  {
  }

  public void checkFiles() throws MareException
  {
    files = null;
  
    //Util.getLog().info( "[INTDaemon] Procesando ficheros de interfaz " + getCodigo() );
    
    final List dbFiles = DAOINTDaemon.loadFiles( getCodigo() );

    try
    {
      if( buzon == null )
        //Util.getLog().info("Se va a buscar un file con la url: "+url);
        buzon = Util.getFSM().resolveFile( url );
        monitor = new DefaultFileMonitor( null );
        //Util.getLog().info("El objeto buzon es: "+buzon);
        monitor.addFile( buzon );
				// Comentado pues su creación de threads se solapa con Quartz
        //monitor.start();
    } catch( FileSystemException fsex )
    {
      throw new MareException( "Error al abrir carpeta: " + url, fsex );
    } catch (Exception e){
        Util.getLog().error( "Error inesperado al chequear los files", e );
    }
    
    try
    {
      files = Util.filterFiles( buzon.getChildren(), getPatronNombres() );
    } catch( FileSystemException fsex )
    {
      Util.getLog().error( "Error al obtener ficheros de carpeta " + buzon, fsex );
      fsex.printStackTrace();
    }
    
    FileObject file;
    FileInfo info;
    for( int i = 0; i < files.length; i++ ) 
    {
      file = files[i];
      info = isRegistered( file.getName().getBaseName(), dbFiles );
      if( info == null ) // El fichero no estaba registrado en BD
      {
				Util.getLog().info( "[INTDaemon] Fichero nuevo: " + file.getName().getBaseName() );
        info = new FileInfo(  getCodigo(),
                              file.getName().getBaseName(), 
                              FileFolder.ESTADO_PENDIENTE, 
                              new java.sql.Date( System.currentTimeMillis() ) );
        DAOINTDaemon.insertFile( info );
        if( SICCGateway.notifyFile( getIDBusiness(), getPais() ) )
        {
          info.setState( FileFolder.ESTADO_NOTIFICADO );
          info.setNotifDate( new java.sql.Date( System.currentTimeMillis() ) );
          DAOINTDaemon.setNotified( info );
        }
        //dbFiles.add( info );
      }
      else
      {
				// El fichero ya estaba registrado en BD
				// Hay que comprobar su estado
        if( info.getState().equals( FileFolder.ESTADO_PENDIENTE ) )
        {
          // Si el estado es PENDIENTE, es porque el intento de
          // notificación falló; se intenta de nuevo
          if( SICCGateway.notifyFile( getIDBusiness(), getPais() ) )
          {
            info.setState( FileFolder.ESTADO_NOTIFICADO );
            info.setNotifDate( new java.sql.Date( System.currentTimeMillis() ) );
            DAOINTDaemon.setNotified( info );
          }
        }
        else if( info.getState().equals( FileFolder.ESTADO_NOTIFICADO ) )
        {
          // Se notificó y aún no ha sido importado, no se hace nada
        }
      }
    }
    
    Iterator it = dbFiles.iterator();
    while( it.hasNext() )
    {
      info = (FileInfo)it.next();
      if( isInFolder( info.getFile(), files ) )
      {
        if( info.getState().equals( FileFolder.ESTADO_PENDIENTE ) )
        {
          info.setState( FileFolder.ESTADO_NOTIFICADO );
          info.setNotifDate( new java.sql.Date( System.currentTimeMillis() ) );
          DAOINTDaemon.setNotified( info );
        }
      }
      else
      {
        if( info.getState().equals( FileFolder.ESTADO_PENDIENTE ) )
        {
          Util.getLog().error( "Interfaz sin notificar eliminada: " + info );
          info.setState( FileFolder.ESTADO_ERROR );
          DAOINTDaemon.setError( info );
        }
        else if( info.getState().equals( FileFolder.ESTADO_NOTIFICADO ) )
        {
          info.setState( FileFolder.ESTADO_IMPORTADO );
					info.setOutDate( new java.sql.Date( System.currentTimeMillis() ) );
          DAOINTDaemon.setImported( info );
        }
      }
    }
  }
  

  private FileInfo isRegistered( String file, List dbFiles )
  {
    FileInfo info;
    Iterator it = dbFiles.iterator();
    while( it.hasNext() )
    {
      info = (FileInfo)it.next();
      if( info.getFile().equals( file ) )
        return info;
    }
    return null;
  }
  
  private boolean isInFolder( String file, FileObject[] folderFiles )
  {
    int len = folderFiles.length;
    FileObject fo;
    for( int i = 0; i < len; i++ )
    {
      fo = folderFiles[i];
      if( file.equals( fo.getName().getBaseName() ) )
        return true;
    }
    
    return false;
  }
  
	
  public String toString()
  {
    return getCodigo();
  }

  public String getPais()
  {
    return pais;
  }

  public void setPais(String pais)
  {
    this.pais = pais;
  }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getPeriodoMuestreo()
  {
    return periodoMuestreo;
  }

  public void setPeriodoMuestreo(String periodoMuestreo)
  {
    this.periodoMuestreo = periodoMuestreo;
  }

  public String getPatronNombres()
  {
    return patronNombres;
  }

  public void setPatronNombres(String patronNombres)
  {
    this.patronNombres = patronNombres;
  }



  public String getIDBusiness()
  {
    return IDBusiness;
  }

  public void setIDBusiness(String IDBusiness)
  {
    this.IDBusiness = IDBusiness;
  }

}