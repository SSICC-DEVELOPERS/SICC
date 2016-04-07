package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class FileScanner implements Job
{
  FileFolder folder = null;

  public FileScanner()
  {
  }
  
  public void execute(JobExecutionContext context) 
    throws JobExecutionException
  {
    folder = (FileFolder)context.getJobDetail().getJobDataMap().get(FileFolder.INTERFAZ);
		//Util.getLog().info( "[INTDaemon] método execute interfaz " + folder.getCodigo() );
    try
    {
      folder.checkFiles();
    } catch( MareException mex )
    {
      Util.getLog().error( "[INTDaemon] Error al procesar ficheros", mex );
    }
  }

}