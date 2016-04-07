package es.indra.sicc.cmn.negocio.interfaces.daemon.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job
{
  private int x;

  public TestJob()
  {
    
  }
  
  public void execute(JobExecutionContext context)
      throws JobExecutionException
    {
      System.err.println("TestJob en ejecución: ");
    }

}