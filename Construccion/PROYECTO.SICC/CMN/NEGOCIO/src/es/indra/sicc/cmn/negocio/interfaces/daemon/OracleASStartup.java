package es.indra.sicc.cmn.negocio.interfaces.daemon;
import com.evermind.server.OC4JStartup;

import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocal;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;

import javax.naming.Context;


public class OracleASStartup implements OC4JStartup
{ 
    /**
     * This method is called before any applications have been deployed
     *
     * @param args - contains the parameters that have been specified for
     * this operation in the OC4J configuration file.
     * @param context - the JNDI context for the server.
     * @return An arbitrary string value
     */
    public String preDeploy(Hashtable args, Context context) throws Exception 
    {
      return null;
    }
  
    /**
     * This method is called after any applications have been deployed.
     *
     * @param args - contains the parameters that have been specified for
     * this operation in the OC4J configuration file.
     * @param context - the JNDI context for the server.
     * @return An arbitrary string value
     */
    public String postDeploy(Hashtable args, Context context) throws Exception 
    {
        UtilidadesLog.info("Se llamo al postdeploy");
        try{
            INTDaemonStartup.getInstance().start();
        } catch( Exception mex ){
            UtilidadesLog.error("ERROR AL INICIALIZAR DAEMON",mex);
            //Util.getLog().error( "Error al arrancar INTDaemon", mex );
            mex.printStackTrace();
        }
        try{
            UtilidadesLog.info("Recuperando el subsistema Batch de anteriores caidas...");
            //MONBatchEJBLocal mon = BatchUtil.getMonBatch();
            MONBatch mon = new MONBatch();
            int procesosRecuperados;
//            if (args.length != 1) {
              procesosRecuperados = mon.recuperarCaida();
//            } else {
//              procesosRecuperados = mon.recuperarCaida(args[0]);
//            }
            
            if (procesosRecuperados != 0){
              UtilidadesLog.info("  " + procesosRecuperados + " procesos recuperados.");
            }else{
              UtilidadesLog.info("No hay procesos para recuperar.");
            }
        }catch(Exception e){
            UtilidadesLog.error("Error al recuperar procesos mal terminados de batch",e);
            e.printStackTrace();
        }          
        return null;
    }
}