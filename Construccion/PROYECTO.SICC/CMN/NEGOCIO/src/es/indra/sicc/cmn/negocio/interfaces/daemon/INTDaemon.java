package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

public class INTDaemon 
{
  private static List interfaces;
  private Scheduler sched = null;

  public INTDaemon() throws MareException
  {
    interfaces = Util.getInterfaces();
  }
  
  public void run()
  {
    SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
    JobDetail jobDetail = null;
    CronTrigger cronTrigger = null;
    
    FileFolder folder = null;
    try
    {
      sched = schedFact.getScheduler();
      sched.start();
  
      Iterator it = interfaces.iterator();
      String jobName = null;
      String cronName = null;
      while( it.hasNext() )
      {
        folder = (FileFolder)it.next();
        jobName = "interfaceJob(" + folder.getCodigo() + ")";
        cronName = "cronTrigger(" + folder.getCodigo() + ")";
        jobDetail = new JobDetail( jobName,
                                   sched.DEFAULT_GROUP,
                                   FileScanner.class );
        jobDetail.getJobDataMap().put( FileFolder.INTERFAZ, folder );
        //jobDetail.setDurability(false);
        try
        {
          cronTrigger = new CronTrigger(  cronName, 
                                          "group1", 
                                          jobName,
                                          sched.DEFAULT_GROUP, 
                                          folder.getPeriodoMuestreo() );
        }
        catch( ParseException e )
        {
          Util.getLog().error( "Error al parsear expresión: " + folder.getPeriodoMuestreo() );
          continue;
        }
        
        sched.scheduleJob( jobDetail, cronTrigger );
      }
    }
    catch( SchedulerException e )
    {
      Util.getLog().error( "Error al inicializar planificador", e );
			try
			{
				if( !sched.isShutdown() ) sched.shutdown();
			} catch( SchedulerException schex ){
				Util.getLog().error( "Fallo al detener el planificador", schex );
			}
    }
  }
	
	public void stop() {
		try
    {
      if( !sched.isShutdown() ) sched.shutdown();
    } catch( SchedulerException schex )
    {
      Util.getLog().error( "Fallo al detener el planificador", schex );
      schex.printStackTrace();
    }
	}
  
  /**
  public void finalize()
  {
    try
    {
      if( !sched.isShutdown() ) sched.shutdown();
    } catch( SchedulerException schex )
    {
      Util.getLog().error( "Fallo al detener el planificador", schex );
      schex.printStackTrace();
    }
  }
  **/

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {

    try
    {
      (new INTDaemon()).run();
    } catch( MareException mex )
    {
      Util.getLog().error( "Error al arrancar INTDaemon", mex );
      mex.printStackTrace();
      System.exit(1);
    }
  }
}