package es.indra.sicc.cmn.negocio.interfaces.daemon.test;

/*
 * Copyright James House (c) 2001-2004
 * 
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 1.
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *  
 */
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.helpers.TriggerUtils;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * @author James House
 */
public class SchedTest {

    public static void schedTest(SchedulerFactory sf) throws Exception {
        Log lg = LogFactory.getLog(SchedTest.class);

        lg.info("------- Initializing -------------------");

        Scheduler sched = sf.getScheduler();

        lg.info("------- Initializing 2 -------------------");

        // remove job/trigger entries that may be lingering in a JDBCJobStore
        // from
        // previous run of this example... (obviously this doesn't matter for
        // RAMJobStore -- but is necessary for JDBCJobStore because this
        // example
        // program is 'dumb' - it blindly inserts the same jobs every time it
        // executes - even though they may still be in the JobStore)
        String[] groups = sched.getTriggerGroupNames();
        for (int i = 0; i < groups.length; i++) {
            String[] names = sched.getTriggerNames(groups[i]);
            for (int j = 0; j < names.length; j++)
                sched.unscheduleJob(names[j], groups[i]);
        }
        groups = sched.getJobGroupNames();
        for (int i = 0; i < groups.length; i++) {
            String[] names = sched.getJobNames(groups[i]);
            for (int j = 0; j < names.length; j++)
                sched.deleteJob(names[j], groups[i]);
        }

        lg.info("------- Initialization Complete -----------");

        lg.info("------- Scheduling Jobs -----------");

        // jobs can be scheduled before start() has been called

        long ts = TriggerUtils.getNextGivenSecondDate(null, 15).getTime(); // get
                                                                           // a
                                                                           // 'nice
                                                                           // round'
                                                                           // time
                                                                           // a
                                                                           // few
                                                                           // seconds
                                                                           // in
                                                                           // the
                                                                           // future...

        JobDetail job = new JobDetail("job1", "group1", DumbJob.class);
        SimpleTrigger trigger = new SimpleTrigger("trigg1", "group1", new Date(
                ts));
        Date ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());

        job = new JobDetail("job2", "group1", DumbJob.class);
        trigger = new SimpleTrigger("trigg2", "group1", "job2", "group1",
                new Date(ts), null, 0, 0);
        ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());

        job = new JobDetail("job3", "group1", DumbJob.class);
        trigger = new SimpleTrigger("trigg3", "group1", "job3", "group1",
                new Date(ts), null, 10, 10000l);
        ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());
        // schedule a second trigger for the same job...
        trigger = new SimpleTrigger("trigg3", "group2", "job3", "group1",
                new Date(ts), null, 2, 7000l);
        ft = sched.scheduleJob(trigger);
        lg.info(job.getFullName() + " will [also] run at: " + ft
                + " & repeat: " + trigger.getRepeatCount() + "/"
                + trigger.getRepeatInterval());

        job = new JobDetail("job4", "group1", DumbJob.class);
        trigger = new SimpleTrigger("trigg4", "group1", "job4", "group1",
                new Date(ts), null, 5, 20000l);
        ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());

        job = new JobDetail("job5", "group1", DumbJob.class);
        trigger = new SimpleTrigger("trigg5", "group1", "job5", "group1",
                new Date(ts + 30000l), null, 0, 0);
        ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());

        job = new JobDetail("job6", "group1", DumbJob.class);
        trigger = new SimpleTrigger("trigg6", "group1", "job6", "group1",
                new Date(ts), null, SimpleTrigger.REPEAT_INDEFINITELY, 5000l);
        ft = sched.scheduleJob(job, trigger);
        lg.info(job.getFullName() + " will run at: " + ft + " & repeat: "
                + trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());

        // CronTrigger example
        job = new JobDetail("job10", "group10", DumbJob.class);
        CronTrigger cTrigger = new CronTrigger("trigg10", "group10", "job10",
                "group10", "0/15 * * * * ?");
        ft = sched.scheduleJob(job, cTrigger);
        lg.info(job.getFullName() + " will run at: " + ft
                + " & repeat based on expression: "
                + cTrigger.getCronExpression());

        lg.info("------- Starting Scheduler ----------------");

        // jobs don't start firing until start() has been called...

        sched.start();

        lg.info("------- Started Scheduler -----------------");

        // jobs can also be scheduled after start() has been called

        job = new JobDetail("job11", "group10", DumbJob.class);
        cTrigger = new CronTrigger("trigg11", "group10", "job11", "group10",
                "0/2 * * * * ?");
        ft = sched.scheduleJob(job, cTrigger);
        lg.info(job.getFullName() + " will run at: " + ft
                + " & repeat based on expression: "
                + cTrigger.getCronExpression());

        // jobs can be fired directly... (rather than waiting for a trigger)

        job = new JobDetail("job20", "group20", DumbJob.class);
        job.setDurability(true);
        sched.addJob(job, true);
        lg.info("'Manually' triggering job20...");
        sched.triggerJob("job20", "group20");

        lg.info("------- Waiting... -----------------------");

        try {
            Thread.sleep(30L * 1000L); // wait 30 seconds to show jobs
                                        // executing...
        } catch (Exception e) {
        }

        // jobs can be re-scheduled...
        /**
        cTrigger = new CronTrigger("trigg11", "group10", "job11", "group10",
        "0/1 * * * * ?");
        ft = sched.rescheduleJob("trigg11", "group10", cTrigger);
        lg.info(job.getFullName() + " has been re-scheduled to run at: " + ft
                + " & repeat based on expression: "
                + cTrigger.getCronExpression());
        **/
        try {
            Thread.sleep(300L * 1000L); // wait five minutes to show jobs
            // executing...
        } catch (Exception e) {
        }
        
        lg.info("------- Shutting Down ---------------------");

        sched.shutdown(true);

        lg.info("------- Shutdown Complete -----------------");

        SchedulerMetaData metaData = sched.getMetaData();
        lg.info("Executed " + metaData.numJobsExecuted() + " jobs.");

    }

    public static void main(String[] args) throws Exception {

        // Configure Log4J
        //DOMConfigurator.configure(System.getProperty("log4jConfigFile", "log4j.xml;"));

        try {
            schedTest(new org.quartz.impl.StdSchedulerFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}