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

package es.indra.sicc.cmn.negocio.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MONBatch {
	
	private static final String DELETE_ALL_SQL =
	  "delete GEN_PROCE_BATCH";
	
	private static final String GET_PROCESES_SQL = 
    "select COD_PROC, VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
    "VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH";
    
	private static final String GET_PROCESES_USER_SQL = 
		"select COD_PROC, VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
		"VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH where VAL_USUA = ?";
    
	private static final String GET_PROCESS_SQL = 
		"select VAL_THRE, VAL_USUA, VAL_ESTA, FEC_ENCO, FEC_INIC, FEC_FIN, " +
		"VAL_CODI_FINA, VAL_MENS_FINA from GEN_PROCE_BATCH where COD_PROC = ?";
	
	private static final String	GET_SUBPROCESES_SQL =
	  "select COD_PROC, VAL_ESTA from GEN_PROCE_BATCH where PRBT_COD_PROC_PADR = ?";
	  
	private static final String INSERT_SUBPROCESS_SQL =
	  "insert into GEN_PROCE_BATCH " +
	    "(COD_PROC, VAL_USUA, VAL_ESTA, PRBT_COD_PROC_PADR, FEC_ENCO)" +
      "values (?,?,?,?,sysdate)";
      
	private static final String INSERT_PROCESS_SQL =
		  "insert into GEN_PROCE_BATCH " +
			"(COD_PROC, VAL_USUA, VAL_ESTA, FEC_ENCO)" +
		  "values (?,?,?,sysdate)";
      
  private static final String UPDATE_EJE_SQL =
    "update GEN_PROCE_BATCH set VAL_ESTA = ?, VAL_SERV = ?, VAL_THRE = ?, FEC_INIC = SYSDATE where COD_PROC = ?";
    
	private static final String UPDATE_FIN_SQL =
		"update GEN_PROCE_BATCH set VAL_ESTA = ?, FEC_FIN = SYSDATE, VAL_CODI_FINA=?, VAL_MENS_FINA=?" +
    " where COD_PROC = ?";
    
	private static final String UPDATE_FIN_SINMENSAJE_SQL =
			"update GEN_PROCE_BATCH set VAL_ESTA = ?, FEC_FIN = SYSDATE where COD_PROC = ?";
	  
	private static final String RECOVER_PROCESSES_SQL =
	  "update GEN_PROCE_BATCH set VAL_ESTA = ? where VAL_SERV = ? and VAL_ESTA = ?";
	
	private static final String RECOVER_ALL_PROCESSES_SQL = 
	  "update GEN_PROCE_BATCH set VAL_ESTA = ? where (VAL_SERV = ? and VAL_ESTA = ?) or VAL_ESTA = ?";
	
  //private DBService dbService;
  private static DBService dbService=null;
  
  private static DBService getDBService () throws MareMiiServiceNotFoundException, MareException {
  	
    if (dbService == null) {
      dbService = ((DBService)MareMii.getService(new MareTopic (ConfigFactory.getBatchConfig().getDBService(), null)));	
    }
    
    return dbService;
  }
  
  public void registrarProcesoBatch(String codigo, String usuario, String padre) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.registrarProcesosBatch("+codigo+", "+usuario+", "+padre+")");
	  
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
        BatchUtil.getLog().error("ERROR",e);
	    throw new MareException ("[BATCH] MONBatch.registrarProcesosBatch() Error intentando insertar proceso", e);
	  }
	  BatchUtil.getLog().debug("[BATCH] MONBatch.registrarProcesosBatch.");
  }
  
  public void setEstadoEjecucionBatch(String codigo, String servidor, String thread) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.setEstadoEjecucionBatch("+codigo+")");
	  
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
        BatchUtil.getLog().error("ERROR",e);
	    throw new MareException ("[BATCH] MONBatch.setEstadoEjecucionBatch() Error intentando modificar proceso", e);
	  }
	  BatchUtil.getLog().debug("[BATCH] MONBatch.setEstadoEjecucionBatch.");
  }
  
  public void setEstadoFinBatch(String codigo, boolean error, Integer codigoFin, String msgFin) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.setEstadoFinBatch("+codigo+", "+error+", "+codigoFin+", "+msgFin+")");
	  
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
		  BatchUtil.getLog().error("ERROR",e);
		  throw new MareException ("[BATCH] MONBatch.setEstadoFinBatch() Error intentando modificar proceso", e);
	  }
	  BatchUtil.getLog().debug("[BATCH] MONBatch.setEstadoFinBatch.");
  }
  
  public void setEstadoFinBatch(String codigo) throws MareException {
    setEstadoFinBatch(codigo, false, null, null);
  }
  
  private boolean hijosAcabados (String codProceso) throws MareException {
	  Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
    
		List procesos = new ArrayList();
		boolean todosAcabados = true;    
		try {
		  connection = getDBService().getConnection();;
				
			statement = connection.prepareStatement(GET_SUBPROCESES_SQL);
			statement.setString(1, codProceso);
			BatchUtil.getLog().debug("[BATCH] Ejecutando: " + GET_SUBPROCESES_SQL);
			BatchUtil.getLog().debug("[BATCH]   1: " + codProceso);
			resultSet = statement.executeQuery();
	
			int estado;
			while (resultSet.next()) {
			estado = resultSet.getInt("VAL_ESTA");
			if (Proceso.estadoEnEjecucion(estado))
          todosAcabados = false;
			if (Proceso.estadoErroneo(estado))
          procesos.add(resultSet.getString("COD_PROC"));
			 }
		  
		} catch (Exception e) {
        BatchUtil.getLog().error("MONBatch.recuperarProcesosBatch() Error recuperando de BD",e);
        throw new MareException ("MONBatch.recuperarProcesosBatch() Error recuperando de BD.", e);
		} finally {
			try {
			if (resultSet != null)  resultSet.close();
			  if (statement != null) statement.close();
			  if (connection != null && !connection.isClosed()) connection.close();
			} catch(Exception e) {}
		}
		
		if (todosAcabados) {
		  if (procesos.size()!=0)
			  throw new SubprocesoException(procesos);
			else
			  return true;
		} else
	    return false;
  }
  
  public void esperarHijos(String codProceso) throws InterruptedException, MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.esperarHijos("+codProceso+")");
	  
	  boolean hijosAcabados=false;
	  while (!hijosAcabados) {
	  	hijosAcabados = hijosAcabados(codProceso);
      Thread.sleep (ConfigFactory.getBatchConfig().getWaitPoollingTime());
	  }
	  	
	  BatchUtil.getLog().debug("[BATCH] MONBatch.esperarHijos:");
  }
  
  
  public Proceso getProcesoBatch(String codigo) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarProcesosBatch()");
   
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;
    
    Proceso proceso=null;    
    try {
	    connection = getDBService().getConnection();
	    statement = connection.prepareStatement(GET_PROCESS_SQL);
	    statement.setString(1, codigo);
      
		  BatchUtil.getLog().debug("[BATCH] Ejecutando: " + GET_PROCESS_SQL);
		  BatchUtil.getLog().debug("[BATCH]   1: " + proceso);
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
        BatchUtil.getLog().error("ERROR",e);
	    throw new MareException ("MONBatch.recuperarProcesosBatch() Error recuperando de BD.", e);
    } finally {
	    try {
	      if (resultSet != null)  resultSet.close();
	      if (statement != null) statement.close();
	      if (connection != null && !connection.isClosed()) connection.close();
	    } catch(Exception e) {}
    }
    
  	BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarProcesosBatch(): " + proceso);
    return proceso;
  }
  
  public List getProcesosBatch(String usuario) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarProcesosBatch()");
   
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;
    
    List procesos = new ArrayList();    
    try {
	    connection = getDBService().getConnection();;
	    if (usuario != null) {
	      statement = connection.prepareStatement(GET_PROCESES_SQL);
		    BatchUtil.getLog().debug("[BATCH] Ejecutando: " + GET_PROCESES_SQL);
	    } else {
			  statement = connection.prepareStatement(GET_PROCESES_USER_SQL);
			  statement.setString(1, usuario);
				BatchUtil.getLog().debug("[BATCH] Ejecutando: " + GET_PROCESES_SQL);
			  BatchUtil.getLog().debug("[BATCH]   1: " + usuario);
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
    	BatchUtil.getLog().error("ERROR",e);
	    throw new MareException ("MONBatch.recuperarProcesosBatch() Error recuperando de BD.", e);
    } finally {
	    try {
        if (resultSet != null)  resultSet.close();
	      if (statement != null) statement.close();
	      if (connection != null && !connection.isClosed()) connection.close();
	    } catch(Exception e) {}
    }
  	
	  BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarProcesosBatch(): " + procesos);
 	  return procesos;
  }
  
  public List getProcesosBatch() throws MareException {
	  return getProcesosBatch(null);
  }
  
  public void purgarBD() throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.purgarBD()");
	  try {
		  getDBService().executeUpdate(DELETE_ALL_SQL);
		} catch (Exception e) {
        BatchUtil.getLog().error("ERROR",e);
		  throw new MareException ("[BATCH] MONBatch.purgarBD() Error intentando purgar base de datos.", e);
		}
	  BatchUtil.getLog().debug("[BATCH] MONBatch.purgarBD.");
  }
  
  public int recuperarCaida(String servidor) throws MareException {
	  BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarCaida("+servidor+")");
	  
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
        BatchUtil.getLog().error("ERROR",e);
		  throw new MareException ("[BATCH] MONBatch.recuperarCaida() Error intentando recuperar procesos.", e);
	  }
		BatchUtil.getLog().debug("[BATCH] MONBatch.recuperarCaida:"+procesosRecuperados+" procesos recuperados.");
		
		return procesosRecuperados;
  }
  
  public int recuperarCaida () throws MareException {
  	return recuperarCaida(ConfigFactory.getBatchConfig().getServer());
  }

}
