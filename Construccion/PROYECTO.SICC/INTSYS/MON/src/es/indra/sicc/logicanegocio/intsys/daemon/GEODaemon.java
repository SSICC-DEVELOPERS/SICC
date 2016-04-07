package es.indra.sicc.logicanegocio.intsys.daemon;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.util.UtilidadesLog;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;

public class GEODaemon 
{
    private Scheduler sched = null;
    private static String intervalo = null;
    private static String pais = null;
    private static String bID = null;
    
    public GEODaemon(){
    }
    public void run(){
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
        JobDetail jobDetail = null;
        CronTrigger cronTrigger = null;
        
        initConfiguration();
        
        try{
            sched = schedFact.getScheduler();
            sched.start();
        
            jobDetail = new JobDetail( "INTERFAZGEOREFERENCIADOR",
                                       sched.DEFAULT_GROUP,
                                       GEOEjecutor.class );
            jobDetail.getJobDataMap().put( "BUSINESSID", bID );
            jobDetail.getJobDataMap().put( "PAIS", pais );
            cronTrigger = new CronTrigger(  "INTERFAZGEOREFERENCIADOR", 
                                            "group1", 
                                            "INTERFAZGEOREFERENCIADOR",
                                            sched.DEFAULT_GROUP, 
                                            intervalo );
            
            
            sched.scheduleJob( jobDetail, cronTrigger );
        }catch( Exception e ){
            UtilidadesLog.error( "Error al ejecutar el planificador", e );
            try{
                if( !sched.isShutdown() ) sched.shutdown();
            } catch( SchedulerException schex ){
                UtilidadesLog.error( "Fallo al detener el planificador", schex );
            }
        }
    }
	
    public void stop() {
        try{
            if( !sched.isShutdown() ) sched.shutdown();
        } catch( SchedulerException schex ){
            UtilidadesLog.error( "Fallo al detener el planificador", schex );
            schex.printStackTrace();
        }
    }
    
    private static void initConfiguration(){
        if (bID == null || intervalo == null){
            try{
                MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
                bID= (String) mgc.getProperty("BusinessIDGEO");
                intervalo = (String) mgc.getProperty("IntervaloEjecucionGEO");
                pais = (String) mgc.getProperty("PaisGEO");
                UtilidadesLog.debug("BusinessID: "+bID);
                UtilidadesLog.debug("IntervaloEjecucionGEO: "+intervalo);
            }catch(Exception e){
                UtilidadesLog.error("NO Se pudo iniciar la configuracion del demonio del GEOReferenciador",e);
            }
        }
    }
}