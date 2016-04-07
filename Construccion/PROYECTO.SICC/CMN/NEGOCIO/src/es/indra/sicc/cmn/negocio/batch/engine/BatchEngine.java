/*
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.cmn.negocio.batch.engine;

import javax.ejb.SessionContext;
/*import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
*/
import es.indra.mare.common.dts.IMareDTS;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.exception.MareSystemLevelException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mln.businessdefinition.BusinessDefinition;
import es.indra.mare.common.mln.engine.Engine;
//import es.indra.mare.common.mre.ExternalMessage;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.util.UtilidadesLog;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class BatchEngine extends Engine {

  private BatchBusinessDefinition batchBusinessDefinition;
  
  public BatchEngine(BusinessDefinition businessDefinition) throws MareMiiServiceNotFoundException {
	  super(businessDefinition);
    batchBusinessDefinition = (BatchBusinessDefinition)businessDefinition;    
  }
 
    
  private void enviaJMS (DTOBatch dtoBatch) throws Exception {
   
    UtilidadesLog.debug("*** BatchEngine.enviaJMS: Entrada ***");
    BatchUtil.getMonBatch().enviaJMS(dtoBatch,batchBusinessDefinition);
	UtilidadesLog.debug("*** BatchEngine.enviaJMS: Salida ***");
    
    // Se llama al metodo del MONBatchEJB
    /*Context jndiContext = new InitialContext();
    QueueConnectionFactory queueCF = (QueueConnectionFactory)jndiContext.lookup (batchBusinessDefinition.getQueueFactory());
    Queue queue = (Queue)jndiContext.lookup(batchBusinessDefinition.getQueue());
    QueueConnection queueConnection = queueCF.createQueueConnection();
    queueConnection.start();
    
    QueueSession queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
    QueueSender sender = queueSession.createSender(queue);
            
    
    ObjectMessage message = queueSession.createObjectMessage(new ExternalMessage(dtoBatch, dtoBatch.getIDOnline()));
                        
    sender.send(message);
    
    queueConnection.close();
    queueSession.close(); */
    //queueSession.commit();
  }
  
  private String getUser(IMareDTS context) {
  	return ((SessionContext)(context.getProperty(IMareDTS.SESSION_FACADE_CONTEXT_KEY))).getCallerPrincipal().toString(); 
  }

  private void registrarProceso (IMareDTS context, DTOBatch dtoBatch) throws Exception {
	  BatchUtil.getMonBatch().registrarProcesoBatch(
	    dtoBatch.getProcessID(),
	    dtoBatch.getUser(),
	    (dtoBatch instanceof DTOSubBatch)?((DTOSubBatch)dtoBatch).getParentID():null
    );
    BatchUtil.getLog().debug("[BATCH] BatchEngine.encolaProceso() Proceso registrado");
  }
  

	public void execute(MareBusinessID mareBusinessID, IMareDTS context) throws MareException, MareSystemLevelException {
		BatchUtil.getLog().debug("[BATCH] BatchEngine.execute()");
		
		DTOBatch dtoBatch = (DTOBatch)context.getProperty(IMareDTS.DTO_INPUT_KEY);
				
		if (dtoBatch.getUser() == null)
		  dtoBatch.setUser(getUser(context));
	  
	  try {
      registrarProceso(context, dtoBatch);
	    enviaJMS(dtoBatch);
	  } catch (Exception e) {
		  BatchUtil.getLog().error("[BATCH] ERROR", e);
			throw new MareSystemLevelException("No se pudo encolar el negocio", e);
	  }
	 
	  // Devolver el ID generado
		context.addProperty(IMareDTS.DTO_OUTPUT_KEY, new DTOSalidaBatch(dtoBatch.getProcessID())); 
	  BatchUtil.getLog().debug("[BATCH] BatchEngine.execute.");
	}
}
