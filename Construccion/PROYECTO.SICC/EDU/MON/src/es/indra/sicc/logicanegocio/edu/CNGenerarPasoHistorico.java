/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.edu;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.edu.DTOParticipante;
import es.indra.sicc.dtos.edu.DTORegistrarHistorico;
import es.indra.sicc.entidades.edu.AptasACursosLocal;
import es.indra.sicc.entidades.edu.AptasACursosLocalHome;
import es.indra.sicc.entidades.edu.HistoricoCursosLocal;
import es.indra.sicc.entidades.edu.HistoricoCursosLocalHome;
import es.indra.sicc.logicanegocio.edu.DAOPasoHistorico;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Date;

import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class CNGenerarPasoHistorico  {

	private SessionContext ctx;

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}
/*Se crea DAOPasoHistorico 

Se invoca el método consultaAptasCursoRealizado(oid) de DAOPasoHistorico, donde oid es el identificador único del curso recibido como parámetro de entrada 

Por cada uno de los elementos del RecordSet (registro) retornado por el método, se realizan las siguientes operaciones: 
1- Se elimina el objeto AptasACurso (EJB Entity) cuyo oid es registro.oid 
2- Se crea un nuevo objeto HistoricoCursos (EJB Entity) con la siguiente información: 
HistoricoCurso.apta = registro.apta 
HistoricoCurso.invitadaCurso = registro.invitada 
HistoricoCurso.fechaAsistencia = registro.fechaAsistencia 
HistoricoCurso.asistenciaCurso = registro.asistencia 
HistoricoCurso.numConvocatoria = registro.numconvocatoria 
HistoricoCurso.curso = oid (parámetro de entrada) 
HistoricoCurso.cliente = registro.cliente 
HistoricoCurso.subtipo = registro.subtipo*/

	public void generarPasoHistorico (Long oid) throws MareException {
		UtilidadesLog.info("CNGenerarPasoHistorico.generarPasoHistorico(oid): Entrada");

	  try{
		AptasACursosLocal  aptasACurso = null;
		AptasACursosLocalHome aptasACursoHome=null;
	
		String usuario = ctx.getCallerPrincipal().getName();
		//String usuario="USUARIO1";
		DAOPasoHistorico daoPasoHistorico = new DAOPasoHistorico(usuario);
		RecordSet rs = daoPasoHistorico.consultaAptasCursoRealizado(oid);
		
		if(!rs.esVacio()){
			for(int i=0;i<rs.getRowCount();i++){
				Long oidrs = new Long(rs.getValueAt(i,0).toString());
				aptasACursoHome = new AptasACursosLocalHome();
								
				aptasACurso = aptasACursoHome.findByPrimaryKey(oidrs);//Creo que esta mal Find by curso
				aptasACursoHome.remove(aptasACurso);
				
				//HistoricoCurso.cliente = registro.cliente 
				Long cliente = new Long(rs.getValueAt(i,1).toString());
				//HistoricoCurso.subtipo = registro.subtipo
				Long subtipo = new Long(rs.getValueAt(i,2).toString());
				Boolean apta=null;
				Boolean invitada=null;
				//HistoricoCurso.apta = registro.apta 
				if(rs.getValueAt(i,3)!=null){//campos nulables
					 Long prueba=new Long(rs.getValueAt(i,3).toString());
					 if(prueba.intValue()==1){
						 apta=Boolean.TRUE;
					 }else{apta=Boolean.FALSE;}
				}
				//HistoricoCurso.invitadaCurso = registro.invitada 
				if(rs.getValueAt(i,4)!=null){
					 Long prueba1=new Long(rs.getValueAt(i,4).toString());
					 if(prueba1.intValue()==1){
						 invitada=Boolean.TRUE;
					 }else{invitada=Boolean.FALSE;}
				}
				//HistoricoCurso.curso = oid (parámetro de entrada) 
				Long curso = oid;
				//HistoricoCurso.fechaAsistencia = registro.fechaAsistencia
				Date fechaAsistente= null;
				fechaAsistente=(Date)rs.getValueAt(0,5);
				//HistoricoCurso.numConvocatoria = registro.numconvocatoria
				Integer numConvocatoria = new Integer(rs.getValueAt(i,6).toString());
				//HistoricoCurso.asistenciaCurso = registro.asistencia 
				Integer asistenciaCurso = new Integer(rs.getValueAt(i,7).toString());
				HistoricoCursosLocalHome historicoCursosHome = new HistoricoCursosLocalHome();
				HistoricoCursosLocal historicoCursosLocal = null;//no tiene secuenciador
				//Long oid, Long curso, Integer numConvocatoria, Long cliente, Long subtipo, Date fechaAsistencia, Integer asistenciaCurso, Boolean apta, Boolean invitadaCurso)
                UtilidadesLog.debug("oidrs,  " + oidrs);
                UtilidadesLog.debug("curso,  " + curso);
                UtilidadesLog.debug("numConvocatoria, " + numConvocatoria);
                UtilidadesLog.debug("cliente,  " + cliente);
                UtilidadesLog.debug("subtipo  " + subtipo);
                UtilidadesLog.debug("fechaAsistente  " + fechaAsistente);
                UtilidadesLog.debug("asistenciaCurso  " + asistenciaCurso);
                UtilidadesLog.debug("apta  " + apta);
                UtilidadesLog.debug("invitada  " + invitada);

				historicoCursosLocal = historicoCursosHome.create(oidrs,curso,numConvocatoria,cliente,subtipo,fechaAsistente,asistenciaCurso,apta,invitada);
			
			}//for
		}//rsVacio?

	} catch (NoResultException e) {
			UtilidadesLog.error("generarPasoHistorico1: FinderException",e);
			ctx.setRollbackOnly();
			throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
	} catch (PersistenceException e) {
			UtilidadesLog.error("generarPasoHistorico1: RemoveException",e);
			ctx.setRollbackOnly();
			throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
	}
    UtilidadesLog.info("CNGenerarPasoHistorico.generarPasoHistorico(oid): Salida");
	}	
  
  
  /**
   * @author: ssantana, 9/12/2005
   * @throws es.indra.mare.common.exception.MareException
   * @param 
   */
  public void generaPasoHistoricoExtemporaneas(DTORegistrarHistorico dto) throws MareException {
    UtilidadesLog.info("CNGenerarPasoHistorico.generaPasoHistoricoExtemporaneas" +
                       "(Long oid):Entrada");
    AptasACursosLocalHome aptasLH = new AptasACursosLocalHome();
    AptasACursosLocal aptasL = null;
    UtilidadesLog.debug("MAD - PASO 1");
       
       DTOParticipante[] participante = dto.getValidos();
       UtilidadesLog.debug("MAD - PASO 2");
          
       HistoricoCursosLocalHome historicoLH = new HistoricoCursosLocalHome();
       UtilidadesLog.debug("MAD - PASO 3");
       //HistoricoCursosLocal historicoL = null;
       UtilidadesLog.debug("MAD - PASO 4");
       String sUsuario = ctx.getCallerPrincipal().getName();
       UtilidadesLog.debug("MAD - PASO 5");
       RecordSet r = null; 
       UtilidadesLog.debug("MAD - PASO 6");
       DAOPasoHistorico daoPaso = new DAOPasoHistorico(sUsuario);
       UtilidadesLog.debug("MAD - PASO 7 " + dto.getOidCurso());
       
       Long oidCurso   = dto.getOidCurso();
       
       UtilidadesLog.debug("MAD - PASO 8");
       
       /*recorro la lista para enviar los clientes concatenados*/
       String clientes = new String();
       for (int i = 0; i < participante.length; i++) {    
          clientes += participante[i].getOidCliente() + ",";
       }
       UtilidadesLog.warn("MAD Los clientes a eliminar son " + clientes);
       
       clientes = clientes.substring(0, clientes.length() - 1);
       
       r = daoPaso.consultarAptasExtemporaneas(dto.getOidTipoCurso(), clientes);
       UtilidadesLog.debug("r: " + r);
       
       //int nSize = r.getRowCount();
       try {
         for (int i = 0; i < r.getRowCount(); i++) {  
                   
            Long oidABorrar = Long.valueOf(r.getValueAt(i,0).toString());
            aptasL = aptasLH.findByPrimaryKey(oidABorrar);
            UtilidadesLog.debug("Borra aptas...");
            aptasLH.remove(aptasL);
            UtilidadesLog.debug("Borro Aptas");
            
            
            Integer numConvocatoria = 
                                 Integer.valueOf(r.getValueAt(i,5).toString());
            UtilidadesLog.debug("MAD Desp NUM CONVOCATORIA");                                 
            Long oidCliente = Long.valueOf(r.getValueAt(i,1).toString());
            Integer asisCurso  = Integer.valueOf(r.getValueAt(i,6).toString());
            
            Integer aptas = Integer.valueOf(r.getValueAt(i,3).toString());
            Boolean bAptas = null;
            if (aptas.longValue() == 1)  {
               bAptas = Boolean.TRUE;
            } else {
               bAptas = Boolean.FALSE;
            }
            
            //Long invitada = Long.valueOf(r.getValueAt(i,4).toString());
            Boolean bInvitada = null;
            if ( aptas.longValue() == 1 ) {
              bInvitada = Boolean.TRUE;
            } else {
              bInvitada = Boolean.FALSE;
            }
            
            Long oidCursoParaHisto = Long.valueOf(r.getValueAt(i,7).toString());
            
            Long oidSubtipoCliente = Long.valueOf((r.getValueAt(i,2)).toString());
            UtilidadesLog.debug(" CREATE CON LOS SIGUIENTES PARAMETROS: ");
            UtilidadesLog.debug("Oid: " + oidCurso);
            UtilidadesLog.debug("numConvocatoria: " + numConvocatoria);
            UtilidadesLog.debug("oidCliente: " + oidCliente);
            UtilidadesLog.debug("oidSubtipoCliente: " + oidSubtipoCliente);
            UtilidadesLog.debug("Fecha Asistencia Null");
            UtilidadesLog.debug("asisCurso: " + asisCurso);
            UtilidadesLog.debug("bAptas: " + bAptas);
            UtilidadesLog.debug("bInvitada: " + bInvitada);
            // Obtengo Oid de secuencia
            //Long oidSiguiente = SecuenciadorOID.obtenerSiguienteValor("EDU_HICU_SEQ");
            UtilidadesLog.debug("Create en Historico...");
            historicoLH.create(oidCursoParaHisto, // Curso 
                               numConvocatoria, // NumConvocatoria
                               oidCliente, // OidCliente
                               oidSubtipoCliente, // Subtipo 
                               null, // FechaAsistencia
                               asisCurso, // AsistenciaCurso
                               bAptas, // Aptas
                               bInvitada); // Invitada
         }
       } catch (NoResultException ex) {
          String sCodigoError = 
                             CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             UtilidadesLog.error("generarPasoHistorico1: FinderException",ex);
             ctx.setRollbackOnly();
             throw new MareException(ex,
                                  UtilidadesError.armarCodigoError(sCodigoError));
          
       } catch (PersistenceException ex) {
          String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
             UtilidadesLog.error("generarPasoHistorico1: RemoveException",ex);
             ctx.setRollbackOnly();
             throw new MareException(ex,
                                  UtilidadesError.armarCodigoError(sCodigoError));
       } 
    UtilidadesLog.info("CNGenerarPasoHistorico.generaPasoHistoricoExtemporaneas" +
                       "(Long oid):Salida");
    
  }
  
    /**
     * @author Rafael Romero
     * @date 17/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     */
    public void generaPasoHistorico(DTORegistrarHistorico dtoe) throws MareException {
        /*
         * Metodo basado en
         * public void generaPasoHistoricoExtemporaneas(DTORegistrarHistorico dto) throws MareException 
         * 
         * En principio para realizar el paso a historico para el "registro de nuevas"
         */
        UtilidadesLog.info("CNGenerarPasoHistorico.generaPasoHistorico(DTORegistrarHistorico): Entrada");
        AptasACursosLocalHome aptasLH = new AptasACursosLocalHome();
        AptasACursosLocal aptasL = null;
        DTOParticipante[] participante = dtoe.getValidos();
          
        HistoricoCursosLocalHome historicoLH = new HistoricoCursosLocalHome();
        HistoricoCursosLocal historicoL = null;
        String sUsuario = ctx.getCallerPrincipal().getName();
       
        RecordSet r = null; 
        DAOPasoHistorico daoPaso = new DAOPasoHistorico(sUsuario);
       
        //Long oidCurso = dtoe.getOidCurso();
       
        String clientes = new String();
        for (int i = 0; i < participante.length; i++) {    
            clientes += (participante[i].getOidCliente() + ",");
        }
        clientes = clientes.substring(0, clientes.length() - 1);
       
        r = daoPaso.consultarClientes(dtoe.getOidTipoCurso(), clientes);
        
        if(r!=null){
            UtilidadesLog.debug("Se moveran al historico ["+r.getRowCount()+"] registros");
        }else{
            UtilidadesLog.debug("No hay registros para mover a historico");
        }
        
        Long oidABorrar = null;
        try {
            for (int i = 0; i < r.getRowCount(); i++) {
                // Eliminar de Aptas a Cursos
                oidABorrar = Long.valueOf(r.getValueAt(i,0).toString());
                aptasL = aptasLH.findByPrimaryKey(oidABorrar);
                aptasLH.remove(aptasL);
                // Insertar en Historico
                Integer numConvocatoria = Integer.valueOf(r.getValueAt(i,5).toString());
                Long oidCliente = Long.valueOf(r.getValueAt(i,1).toString());
                Integer asisCurso  = Integer.valueOf(r.getValueAt(i,6).toString());
                Integer aptas = Integer.valueOf(r.getValueAt(i,3).toString());
                Boolean bAptas = null;
                if (aptas.longValue() == 1)  {
                    bAptas = Boolean.TRUE;
                } else {
                    bAptas = Boolean.FALSE;
                }
                //Long invitada = Long.valueOf(r.getValueAt(i,4).toString());
                Boolean bInvitada = null;
                if ( aptas.longValue() == 1 ) {
                    bInvitada = Boolean.TRUE;
                } else {
                    bInvitada = Boolean.FALSE;
                }
                Long oidCursoParaHisto = Long.valueOf(r.getValueAt(i,7).toString());
                Long oidSubtipoCliente = Long.valueOf((r.getValueAt(i,2)).toString());
                
                historicoL = historicoLH.create(oidCursoParaHisto, // Curso 
                               numConvocatoria, // NumConvocatoria
                               oidCliente, // OidCliente
                               oidSubtipoCliente, // Subtipo 
                               null, // FechaAsistencia
                               asisCurso, // AsistenciaCurso
                               bAptas, // Aptas
                               bInvitada); // Invitada
                
                UtilidadesLog.debug("Insertado EDU_HISTO_CURSO[oid="+historicoL.getOid()+"]");
            }
        } catch (NoResultException ex) {
            UtilidadesLog.error("FinderException al mover EDU_APTAS_CURSO[oid="+oidABorrar+"]");
            UtilidadesLog.error("generarPasoHistorico1: FinderException",ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
            UtilidadesLog.error("RemoveException al mover EDU_APTAS_CURSO[oid="+oidABorrar+"]");
            UtilidadesLog.error("generarPasoHistorico1: RemoveException",ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("CNGenerarPasoHistorico.generaPasoHistorico(DTORegistrarHistorico):Salida");
    }
}