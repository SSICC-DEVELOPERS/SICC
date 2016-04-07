package es.indra.sicc.cmn.start.beans;

import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.interfaces.daemon.INTDaemonStartup;

import es.indra.sicc.util.UtilidadesLog;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import oracle.j2ee.ejb.StatelessDeployment;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@StatelessDeployment(
    minInstances=1,
    maxInstances=1
)
public class DaemonStarterBean implements IDaemonStarterRemote {
    public DaemonStarterBean() {
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
        public void stop(){
            UtilidadesLog.info("[BelcorpStarter] - stop() --> Entrada");
             try{
                INTDaemonStartup.getInstance().stop();
            } catch( Exception mex ){
                UtilidadesLog.error("[BelcorpStarter] - ERROR AL FINALIZAR DAEMON",mex);
            }
            UtilidadesLog.info("[BelcorpStarter] - stop() --> Salida");
        }
        
        @TransactionAttribute(TransactionAttributeType.SUPPORTS)
        public void start(){
            UtilidadesLog.info("[BelcorpStarter] - start() --> Entrada");
            try{
                INTDaemonStartup.getInstance().start();
            } catch( Exception mex ){
                UtilidadesLog.error("[BelcorpStarter] - ERROR AL INICIALIZAR DAEMON",mex);
                mex.printStackTrace();
            }
            try{
                UtilidadesLog.info("[BelcorpStarter] - Recuperando el subsistema Batch de anteriores caidas...");
                MONBatch mon = new MONBatch();
                int procesosRecuperados = mon.recuperarCaida();
                if (procesosRecuperados != 0){
                  UtilidadesLog.info("[BelcorpStarter] - " + procesosRecuperados + " procesos recuperados.");
                }else{
                  UtilidadesLog.info("[BelcorpStarter] - No hay procesos para recuperar.");
                }
            }catch(Exception e){
                UtilidadesLog.error("[BelcorpStarter] - Error al recuperar procesos mal terminados de batch",e);
            }
            
        }
        
        
        @PostConstruct
        private void init(){
            start();
        }
               
        @PreDestroy
        private void shutdown(){
            stop();
        }
}
