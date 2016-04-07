/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.batch;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.mare.common.mre.ExternalMessage;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.batch.engine.BatchBusinessDefinition;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class MONBatchEJBBean implements SessionBean {
    
    private static final String INSERT_SUBPROCESS_SQL = "insert into GEN_PROCE_BATCH " +
        "(COD_PROC, VAL_USUA, VAL_ESTA, PRBT_COD_PROC_PADR, FEC_ENCO)" +
        "values (?,?,?,?,sysdate)";
	
    private static final String DELETE_ALL_SQL = "delete GEN_PROCE_BATCH";
 
	private static final String INSERT_PROCESS_SQL = "insert into GEN_PROCE_BATCH " +
		"(COD_PROC, VAL_USUA, VAL_ESTA, FEC_ENCO)" +
		"values (?,?,?,sysdate)";
   
    private static final String	GET_SUBPROCESES_SQL =
        "select COD_PROC, VAL_ESTA from GEN_PROCE_BATCH where PRBT_COD_PROC_PADR = ?";

	private static final String GET_PROCESES_SQL = "select COD_PROC, VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
        "VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH";

	private static final String GET_PROCESS_SQL = "select VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
        "VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH where COD_PROC = ?";

	private static final String UPDATE_FIN_SQL = "update GEN_PROCE_BATCH set VAL_ESTA = ?, FEC_FIN = SYSDATE, VAL_CODI_FINA=?, VAL_MENS_FINA=?" +
        " where COD_PROC = ?";
    
	private static final String UPDATE_FIN_SINMENSAJE_SQL = "update GEN_PROCE_BATCH set VAL_ESTA = ?, FEC_FIN = SYSDATE where COD_PROC = ?";
	
    private static final String UPDATE_EJE_SQL = "update GEN_PROCE_BATCH set VAL_ESTA = ?, VAL_SERV = ?, VAL_THRE = ?, FEC_INIC = SYSDATE where COD_PROC = ?";
    
	private static final String RECOVER_PROCESSES_SQL = "update GEN_PROCE_BATCH set VAL_ESTA = ? where VAL_SERV = ? and VAL_ESTA = ?";
	
	private static final String RECOVER_ALL_PROCESSES_SQL = "update GEN_PROCE_BATCH set VAL_ESTA = ? where (VAL_SERV = ? and VAL_ESTA = ?) or VAL_ESTA = ?";

	private static final String GET_PROCESES_USER_SQL = "select COD_PROC, VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
        "VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH where VAL_USUA = ?";
	    
    private SessionContext ctx;
    private static UtilidadesLog logAux = new UtilidadesLog();
    
    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void ejbRemove(){
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;
    }

    public void registrarProcesoBatch(String codigo, String usuario, String padre) throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.registrarProcesosBatch("+codigo+", "+usuario+", "+padre+"): Entrada");
	  
        Vector params = new Vector(3);
        params.add(codigo);
        params.add(usuario);
        params.add(Proceso.PROCESO_ENCOLADO);
	  
        String sql=null;
        if (padre != null) {
            params.add(padre);
            sql = INSERT_SUBPROCESS_SQL;
        } else
            sql = INSERT_PROCESS_SQL;
    
        try {
            getDBService().executePreparedUpdate(sql, params);
        } catch (Exception e) {
            throw new MareException ("[BATCH] MONBatch.registrarProcesosBatch() Error intentando insertar proceso", e);
        }
        UtilidadesLog.info("[BATCH] MONBatch.registrarProcesosBatch: Salida ***");
    
    }



    private DBService getDBService () throws MareMiiServiceNotFoundException, MareException {
        DBService dbService=null;
        if (dbService == null) {
            dbService = ((DBService)MareMii.getService(new MareTopic (ConfigFactory.getBatchConfig().getDBService(), null)));	
        }
    
        return dbService;
    }

    public Proceso getProcesoBatch(String codigo) throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.recuperarProcesosBatch()");
   
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
    
		Proceso proceso=null;    
		try {
			connection = getDBService().getConnection();
			statement = connection.prepareStatement(GET_PROCESS_SQL);
			statement.setString(1, codigo);
      
			UtilidadesLog.info("[BATCH] Ejecutando: " + GET_PROCESS_SQL);
			UtilidadesLog.info("[BATCH]   1: " + proceso);
			resultSet = statement.executeQuery();
	    
			if (resultSet.next()) {
				proceso = new Proceso(
					codigo,
					resultSet.getString("VAL_THRE"),
					resultSet.getString("VAL_USUA"), 
					new Integer(resultSet.getInt("VAL_ESTA")),
					resultSet.getDate("FEC_ENCO"), 
					resultSet.getDate("FEC_INIC"), 
					resultSet.getDate("FEC_FIN"),
					new Integer(resultSet.getInt("VAL_CODI_FINA")),
					resultSet.getString("VAL_MENS_FINA")
				);
			}
		} catch (Exception e) {
			throw new MareException ("MONBatch.recuperarProcesosBatch() Error recuperando de BD.", e);
		} finally {
			try {
				if (resultSet != null)  resultSet.close();
				if (statement != null) statement.close();
				if (connection != null && !connection.isClosed()) connection.close();
			} catch(Exception e) {}
		}
    
		UtilidadesLog.info("[BATCH] MONBatch.recuperarProcesosBatch(): " + proceso);
		return proceso;
    }

    public void esperarHijos(String codProceso) throws  InterruptedException, MareException{
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isInfoEnabled()) 
            UtilidadesLog.info("[BATCH] MONBatch.esperarHijos("+codProceso+")");
	  
		boolean hijosAcabados=false;
		while (!hijosAcabados) {
			hijosAcabados = hijosAcabados(codProceso);
			Thread.sleep (ConfigFactory.getBatchConfig().getWaitPoollingTime());
		}
	  	//UtilidadesLog.info("[BATCH] MONBatch.esperarHijos:");
    }
    private boolean hijosAcabados (String codProceso) throws MareException {

		//UtilidadesLog.info("*** hijosAcabados Entrada ***");
	    Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
    
		List procesos = new ArrayList();
		boolean todosAcabados = true;    
		try {
		    connection = getDBService().getConnection();;
				
			statement = connection.prepareStatement(GET_SUBPROCESES_SQL);
			statement.setString(1, codProceso);
			UtilidadesLog.info("[BATCH] Ejecutando: " + GET_SUBPROCESES_SQL);
			UtilidadesLog.info("[BATCH]   1: " + codProceso);
			resultSet = statement.executeQuery();
	
			int estado;
			while (resultSet.next()) {
				estado = resultSet.getInt("VAL_ESTA");
				//UtilidadesLog.info("*** estado ="+estado);
				//UtilidadesLog.info("*** COD_PROC = "+resultSet.getString("COD_PROC"));
				if (Proceso.estadoEnEjecucion(estado)){
					//UtilidadesLog.info("*** todosAcabados = false ***");
					todosAcabados = false;
				}
				if (Proceso.estadoErroneo(estado)){
					procesos.add(resultSet.getString("COD_PROC"));
				}
			}
		  
		} catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
			throw new MareException ("MONBatchEJB.recuperarProcesosBatch() Error recuperando de BD.", e);
		} finally {
			try {
				if (resultSet != null)  resultSet.close();
				if (statement != null) statement.close();
				 if (connection != null && !connection.isClosed()) connection.close();
			} catch(Exception e) {}
		}
		//UtilidadesLog.info("*** hijosAcabados Salida ***");
		if (todosAcabados) {
		  if (procesos.size()!=0)
			  throw new SubprocesoException(procesos);
			else
			  return true;
		} else
	    return false;
	}

    public void setEstadoFinBatch(String codigo, boolean error, Integer codigoFin, String msgFin) throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.setEstadoFinBatch("+codigo+", "+error+", "+codigoFin+", "+msgFin+")");
	  
        String sql;
        Vector params = new Vector(1);
        params.add( error ? Proceso.PROCESO_ERRONEO : Proceso.PROCESO_FINALIZADO);
	  
        if (codigoFin != null) {
            sql = UPDATE_FIN_SQL;
            params.add(codigoFin);
            params.add(msgFin);
        } else {
            sql = UPDATE_FIN_SINMENSAJE_SQL;
        }	    
	    
        params.add(codigo);
    
        try {
            getDBService().executePreparedUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException ("[BATCH] MONBatch.setEstadoFinBatch() Error intentando modificar proceso", e);
        }
        UtilidadesLog.info("[BATCH] MONBatch.setEstadoFinBatch.");
    }

    public void setEstadoFinBatch(String codigo) throws MareException{
        setEstadoFinBatch(codigo, false, null, null);
    }

    public void setEstadoEjecucionBatch(String codigo, String servidor, String thread) throws MareException{
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(logAux.isInfoEnabled()) { 
            UtilidadesLog.info("[BATCH] MONBatch.setEstadoEjecucionBatch("+codigo+")");
	}  
        Vector params = new Vector(4);
        params.add(Proceso.PROCESO_EJECUTANDO);
        params.add(servidor);
        params.add(thread);
        params.add(codigo);	  
                  
        try {
            int rowsModified = getDBService().executePreparedUpdate(UPDATE_EJE_SQL, params);
            if ( rowsModified != 1)
                throw new MareException ("Error al actualizar el estado del proceso ("+rowsModified+" filas modificadas)");
        } catch (Exception e) {
            throw new MareException ("[BATCH] MONBatch.setEstadoEjecucionBatch() Error intentando modificar proceso", e);
        }
        UtilidadesLog.info("[BATCH] MONBatch.setEstadoEjecucionBatch.");
    }

    public int recuperarCaida(String servidor) throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.recuperarCaida("+servidor+")");
	  
        String sql;
	  
	    Vector params = new Vector(4);
		params.add(Proceso.PROCESO_ABORTADO);
        params.add(servidor);
		params.add(Proceso.PROCESO_EJECUTANDO);
	  
        if (ConfigFactory.getBatchConfig().getRecorverQueued()) {
            sql = RECOVER_ALL_PROCESSES_SQL;
            params.add(Proceso.PROCESO_ENCOLADO);
        } else {
            sql = RECOVER_PROCESSES_SQL;
        }	  
	  
        int procesosRecuperados;
		try {
            procesosRecuperados = getDBService().executePreparedUpdate(sql, params);
		} catch (Exception e) {
            throw new MareException ("[BATCH] MONBatch.recuperarCaida() Error intentando recuperar procesos.", e);
        }
		UtilidadesLog.info("[BATCH] MONBatch.recuperarCaida:"+procesosRecuperados+" procesos recuperados.");
		
		return procesosRecuperados;
    }

    public int recuperarCaida() throws MareException{
        return recuperarCaida(ConfigFactory.getBatchConfig().getServer());
    }

    public List getProcesosBatch(String usuario) throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.getProcesosBatch()");
   
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
    
        List procesos = new ArrayList();    
        try {
            connection = getDBService().getConnection();;
            if (usuario != null) {
                statement = connection.prepareStatement(GET_PROCESES_SQL);
                UtilidadesLog.info("[BATCH] Ejecutando: " + GET_PROCESES_SQL);
            } else {
                statement = connection.prepareStatement(GET_PROCESES_USER_SQL);
                statement.setString(1, usuario);
                UtilidadesLog.info("[BATCH] Ejecutando: " + GET_PROCESES_SQL);
                UtilidadesLog.info("[BATCH]   1: " + usuario);
            }		  
		  
            resultSet = statement.executeQuery();
            Proceso proceso;
            while (resultSet.next()) {
                proceso = new Proceso(
                resultSet.getString("COD_PROC"),
                resultSet.getString("VAL_THRE"),
                resultSet.getString("VAL_USUA"), 
                new Integer(resultSet.getInt("VAL_ESTA")),
                resultSet.getDate("FEC_ENCO"), 
                resultSet.getDate("FEC_INIC"), 
                resultSet.getDate("FEC_FIN"),
                new Integer(resultSet.getInt("VAL_CODI_FINA")),
                resultSet.getString("VAL_MENS_FINA")
                );
                procesos.add(proceso);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException ("MONBatch.getProcesosBatch() Error recuperando de BD.", e);
        } finally {
            try {
                if (resultSet != null)  resultSet.close();
                if (statement != null) statement.close();
                if (connection != null && !connection.isClosed()) connection.close();
            } catch(Exception e) {}
        }
  	
        UtilidadesLog.info("[BATCH] MONBatch.getProcesosBatch(): " + procesos);
        return procesos;
    }

    public List getProcesosBatch() throws MareException{
        return getProcesosBatch(null);
    }

    public void purgarBD() throws MareException{
        UtilidadesLog.info("[BATCH] MONBatch.purgarBD()");
		try {
			getDBService().executeUpdate(DELETE_ALL_SQL);
		} catch (Exception e) {
			throw new MareException ("[BATCH] MONBatch.purgarBD() Error intentando purgar base de datos.", e);
		}
		UtilidadesLog.info("[BATCH] MONBatch.purgarBD.");
    }

    public void enviaJMS(DTOBatch dtoBatch, BatchBusinessDefinition batchBusinessDefinition) throws Exception{
        UtilidadesLog.info("**** MONBatchEJB.enviaJMS: Entrada ***");
				
		Context jndiContext = new InitialContext();
		QueueConnectionFactory queueCF = (QueueConnectionFactory)jndiContext.lookup (batchBusinessDefinition.getQueueFactory());
		Queue queue = (Queue)jndiContext.lookup(batchBusinessDefinition.getQueue());
		QueueConnection queueConnection = queueCF.createQueueConnection();
		queueConnection.start();
    
		QueueSession queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
		QueueSender sender = queueSession.createSender(queue);
            
    
		ObjectMessage message = queueSession.createObjectMessage(new ExternalMessage(dtoBatch, dtoBatch.getIDOnline()));
                        
		sender.send(message);
    
		queueConnection.close();
		queueSession.close();
		UtilidadesLog.info("**** MONBatchEJB.enviaJMS: Salida ***");
    }

    public void esperarHijosFacturacion(String codProceso) throws  InterruptedException, MareException{
        boolean hijosAcabados=false;
		while (!hijosAcabados) {
			hijosAcabados = hijosAcabadosFacturacion(codProceso);
			Thread.sleep (ConfigFactory.getBatchConfig().getWaitPoollingTime());
		}
    }
    
    private boolean hijosAcabadosFacturacion (String codProceso) throws MareException {

		//UtilidadesLog.info("*** hijosAcabados Entrada ***");
	    Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
    
		List procesos = new ArrayList();
		boolean todosAcabados = true;    
		try {
		    connection = getDBService().getConnection();;
				
			statement = connection.prepareStatement(GET_SUBPROCESES_SQL);
			statement.setString(1, codProceso);
			UtilidadesLog.info("[BATCH] Ejecutando: " + GET_SUBPROCESES_SQL);
			UtilidadesLog.info("[BATCH]   1: " + codProceso);
			resultSet = statement.executeQuery();
	
			int estado;
			while (resultSet.next()) {
				estado = resultSet.getInt("VAL_ESTA");
				//UtilidadesLog.info("*** estado ="+estado);
				//UtilidadesLog.info("*** COD_PROC = "+resultSet.getString("COD_PROC"));
				if (Proceso.estadoEnEjecucion(estado)){
					//UtilidadesLog.info("*** todosAcabados = false ***");
					todosAcabados = false;
				}
				/*if (Proceso.estadoErroneo(estado)){
					procesos.add(resultSet.getString("COD_PROC"));
				}*/
			}
		  
		} catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
			throw new MareException ("MONBatchEJB.recuperarProcesosBatch() Error recuperando de BD.", e);
		} finally {
			try {
				if (resultSet != null)  resultSet.close();
				if (statement != null) statement.close();
				 if (connection != null && !connection.isClosed()) connection.close();
			} catch(Exception e) {}
		}
		//UtilidadesLog.info("*** hijosAcabados Salida ***");
		if (todosAcabados) {
            /*if (procesos.size()!=0){
                return true;
            }else{
                return true;
            }*/
            return true;
		}else{
            return false;
        }
	}
}