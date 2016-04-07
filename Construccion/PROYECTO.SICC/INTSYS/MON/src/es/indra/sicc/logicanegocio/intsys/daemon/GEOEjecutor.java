package es.indra.sicc.logicanegocio.intsys.daemon;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.ConfigFactory;
import es.indra.sicc.cra.util.Actividad;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.util.Hashtable;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GEOEjecutor implements Job
{
    String bID = null;
    String pais = null;
  
    public GEOEjecutor()
    {
    }
  
    public void execute(JobExecutionContext context) 
      throws JobExecutionException{
        UtilidadesLog.info("GEOEjecutor.execute(JobExecutionContext context):Entrada");
        bID = (String)context.getJobDetail().getJobDataMap().get("BUSINESSID");
        pais = (String)context.getJobDetail().getJobDataMap().get("PAIS");
        UtilidadesLog.debug("BusinessID a ejecutar: "+bID);

        DTOString dto = new DTOString();
        dto.setCadena( pais);
        Context ctx;
        BusinessFacadeHome businessFacadeHome;
        BusinessFacade businessFacade;

        try {
            ctx = getInitialContext();
            businessFacadeHome = (BusinessFacadeHome)PortableRemoteObject.narrow(ctx.lookup("mare.mln.BusinessFacade"), BusinessFacadeHome.class);
            businessFacade = businessFacadeHome.create();
        } catch(RemoteException e) {
            UtilidadesLog.error("ERROR",e);
            return;
        } catch(NamingException e) {
            UtilidadesLog.error("ERROR",e);
            return;
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            return;
        }
        try{
            DTOBatch dtoBatch = new DTOBatch( "{INTDaemon] notifyFile", 
																				new MareBusinessID( bID ),
																				dto );
            businessFacade.execute( dtoBatch, new MareBusinessID( ConfigFactory.getINTDaemonConfig().getQueueingIDBusiness() ) );
        } catch(MareException ex) {
            UtilidadesLog.error("ERROR",ex);
        } catch(RemoteException e) {
            UtilidadesLog.error(e);
        } catch(Throwable e) {
            UtilidadesLog.error("ERROR",e);
        }
        UtilidadesLog.info("GEOEjecutor.execute(JobExecutionContext context):Salida");
    }


    private static Context getInitialContext() throws NamingException {
        UtilidadesLog.info("GEOEjecutor.getInitialContext():Entrada");
        Hashtable env = new Hashtable();
        try {
            PropertiesConfiguration properties = new PropertiesConfiguration(System.getProperty("MareConfigurationRoot") + "/services/quartz.properties");
            String rmi = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.factory.initial");
            String url = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.provider.url");
            String usr = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.security.principal");
            String password = (String)properties.getProperty("org.quartz.dataSource.myDS.java.naming.security.credentials");
            UtilidadesLog.debug("rmi " + rmi);
            UtilidadesLog.debug("url " + url);
            UtilidadesLog.debug("usr " + usr);
            UtilidadesLog.debug("password " + password);
                   
            env.put(Context.INITIAL_CONTEXT_FACTORY, rmi);
            env.put(Context.SECURITY_PRINCIPAL, usr);
            env.put(Context.SECURITY_CREDENTIALS, password);
            env.put(Context.PROVIDER_URL, url);
        } catch (Exception e) {
            UtilidadesLog.error(e);
        }
        UtilidadesLog.info("GEOEjecutor.getInitialContext():Salida");
        return new InitialContext(env);
    }
}