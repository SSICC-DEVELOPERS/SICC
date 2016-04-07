package es.indra.sicc.cmn.negocio.interfaces.daemon.test;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;

public class TestQuartz 
{
  public TestQuartz() throws SchedulerException
  {
    SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

    Scheduler sched = schedFact.getScheduler();

    sched.start();
    

    JobDetail jobDetail = new JobDetail("myJob",
                                        sched.DEFAULT_GROUP,
                                         TestJob.class);
                                         
    SimpleTrigger trigger = new SimpleTrigger("myTrigger",
                                            sched.DEFAULT_GROUP,
                                            new Date(),
                                            null,
                                            10,
                                            1000L);
          
    CronTrigger cTrigger = null;                                 
    try
    {
      cTrigger = new CronTrigger("myCrtonTrigger", "group10", "myJob",
                  sched.DEFAULT_GROUP, "0/5 * * ? * *");
    } catch( ParseException pex )
    {
      pex.toString();
    }

    sched.scheduleJob(jobDetail, cTrigger);
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
      TestQuartz testQuartz = new TestQuartz();
    } catch( Exception ex )
    {
      ex.printStackTrace();
    }
  }
}
