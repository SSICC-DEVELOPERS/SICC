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
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.edu.DTOPedido;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOP;
import es.indra.sicc.entidades.edu.AptasACursosLocal;
import es.indra.sicc.entidades.edu.AptasACursosLocalHome;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;
import es.indra.sicc.entidades.edu.MatrizCursosLocalHome;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocal;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.logicanegocio.edu.DAORegalos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPais;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPaisHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;

import javax.ejb.FinderException;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class CNRegistrarAsistencia  {

	private SessionContext ctx;

	public void setSessionContext(SessionContext ctx) {
			this.ctx = ctx;
	}

	public CNRegistrarAsistencia() {
	}
	
	public void registrarAsistencia (DTORegistrarAsistencia dto)throws MareException{

		UtilidadesLog.info(" CNRegistrarAsistencia.registrarAsistencia(DTORegistrarAsistencia) : Entrada");
        UtilidadesLog.debug("dto:"+dto);
        
		String codigoError = null;
		
		MatrizCursosLocal matrizCursosLocal = null;
		AptasACursosLocal aptasACursosLocal = null;
        AptasACursosLocal aptasACursosLocalInsert = null;
		
		//Se obtiene el objeto MatrizCursos (EJB Entity) cuyo oid es dtoe.oidCurso
		MatrizCursosLocalHome matrizCursosLocalHome = this.getMatrizCursosLocalHome();
		try{
			matrizCursosLocal=matrizCursosLocalHome.findByPrimaryKey(dto.getOidCurso());
		} catch (FinderException fe) {		
			UtilidadesLog.error("registrarAsistencia: FinderException al buscar CURSO",fe);
			codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
		}	
		//Por cada elemento en el array dtoe.participantes()			
		if (dto.getParticipantes()!=null && dto.getParticipantes().length>0) {
            // Estructura SWITCH agregada para manejar el registro de asistencia de nuevas
            // Incidencia SiCC 20070187 - Rafael Romero - 16/04/2007
            switch(dto.getOperacion().intValue()){
                case 2: // Valor de ConstantesEDU.REG_NUEV.intValue();
                    AptasACursosLocalHome aptasACursosLH = new AptasACursosLocalHome();
                    ClientePrimerContactoLocalHome clienteLH = new ClientePrimerContactoLocalHome();
                    ClientePrimerContactoLocal clienteL = null;
                    boolean insertaEnAptasACurso = false;
                    // Se accde a DAO CRA para obtener periodos anteriores
                    DAOCRA daoCra = new DAOCRA();
                    // Se accede al DAORegistrarNuevas para obtener el subtipo principal
                    DAORegistrarNuevas daoRN = new DAORegistrarNuevas(this.ctx.getCallerPrincipal().getName());
                    for (int i = 0; i < dto.getParticipantes().length; i++){
                        Long oidCliente_i = dto.getParticipantes()[i].getOidCliente();
                        Integer indicadorAsistencia_i = ConstantesEDU.ASIS_OTRO;
                        Integer numeroConvocatoria_i = ConstantesEDU.SEG_CONV;
                        //Boolean indicadorApta = Boolean.FALSE; // Siempre sera TRUE - Rafael Romero - 08/05/2007 - SiCC 20070187
                        
                        // Buscamos ocurrencia de curso cliente en Aptas A Cursos
                        try{
                            aptasACursosLocal = aptasACursosLH.findByUK(matrizCursosLocal.getOid(),oidCliente_i);
                            // Si encuentra actualiza
                            insertaEnAptasACurso = false;
                        }catch(NoResultException fe){
                            // Si NO encuentra inserta
                            insertaEnAptasACurso = true;
                        }
                        // Determinar indicador de asistencia y numero de convocatoria
                        // en funcion a Periodo de Contacto de Consultora
                        // Traer Periodo de Ingreso de la Consultora desde MAEClientePrimerContacto
                        try{
                            clienteL = clienteLH.findByCliente(oidCliente_i);
                            if(clienteL.getPerd_oid_peri()!=null && matrizCursosLocal.getPeriodoIngreso()!=null
                                    && (clienteL.getPerd_oid_peri().longValue()==matrizCursosLocal.getPeriodoIngreso().longValue()
                                            || clienteL.getPerd_oid_peri().longValue()==daoCra.obtienePeriodoAnterior(matrizCursosLocal.getPeriodoIngreso()).longValue())){
                                if(clienteL.getPerd_oid_peri().longValue()==matrizCursosLocal.getPeriodoIngreso().longValue()){
                                    // Si los periodos de coinciden 
                                    // el numero de convocatoria sera ConstantesEDU.PRIM_CONV
                                    // y el indicador de Apta ira en VERDADERO
                                    numeroConvocatoria_i = ConstantesEDU.PRIM_CONV;
                                    // indicadorApta = Boolean.TRUE; // Siempre sera TRUE - Rafael Romero - 08/05/2007 - SiCC 20070187
                                }
                                // Si periodo de ingreso de consultora 
                                // coniciden con el periodo de ingreso exigido en el curso o el anterior
                                // Se indica la asistencia como APTA
                                indicadorAsistencia_i = ConstantesEDU.ASIS_APTA;
                            }else{
                                indicadorAsistencia_i = ConstantesEDU.ASIS_OTRO;
                            }
                        }catch(NoResultException fe){
                            // Si no hay periodo de ingreso para el cliente
                            UtilidadesLog.info("Cliente[oid="+oidCliente_i+"] NO se pudo obtener PeriodoContacto");
                            UtilidadesLog.debug("Cliente[oid="+oidCliente_i+"]", fe);
                            indicadorAsistencia_i = ConstantesEDU.ASIS_OTRO;
                        }

                        if(insertaEnAptasACurso){
                            // INSERT
                            // Se obtiene Subtipo de cliente principal 
                            try {
                                aptasACursosLocalInsert = aptasACursosLH.create(
                                                            dto.getOidCurso(), 
                                                            numeroConvocatoria_i,
                                                            oidCliente_i,
                                                            daoRN.obtenerTipoSubtipoPpalPorCliente(oidCliente_i)
                                                            );
                            }
                            catch (PersistenceException ce) {
                                UtilidadesLog.error("registrarAsistencia: CreateException al Insertar registro Nuevo en AptasACursos",ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                            }
                            aptasACursosLocalInsert.setAsistenciaCurso(indicadorAsistencia_i);
                            aptasACursosLocalInsert.setFechaAsistencia(new Date(dto.getParticipantes()[i].getFecAsistencia().getTime()));
                            aptasACursosLocalInsert.setDataMart(Boolean.FALSE);
                            aptasACursosLocalInsert.setInvitadaCurso(Boolean.FALSE);
                            aptasACursosLocalInsert.setApta(Boolean.TRUE);
                            aptasACursosLocalInsert.setPruebas(Boolean.FALSE);
                            aptasACursosLocalInsert.setEnvio(Boolean.TRUE);
                            aptasACursosLH.merge(aptasACursosLocalInsert);
                            UtilidadesLog.debug("Insertado EDU_APTAS_CURSO[oid="+aptasACursosLocalInsert.getOid()+"]");
                        }else{
                            // UPDATE
                            // Fecha de asistencia
                            aptasACursosLocal.setFechaAsistencia(new Date(dto.getParticipantes()[i].getFecAsistencia().getTime()));
                            // Indicador de asistencia
                            aptasACursosLocal.setAsistenciaCurso(indicadorAsistencia_i);
                            UtilidadesLog.debug("Actualizado EDU_APTAS_CURSO[oid="+aptasACursosLocal.getOid()+"]");
                            aptasACursosLH.merge(aptasACursosLocal);
                        }
                        
                    }
                    break;
                default:
                    for (int i = 0; i < dto.getParticipantes().length; i++){
                        //Se obtiene el objeto AptasACurso (EJBEntity) cuyo oid es dtoe.participantes(i).oidParticipante 
                        AptasACursosLocalHome aptasACursosLocalHome = new AptasACursosLocalHome();
                        AptasACursosLocalHome aptasACursosLocalHomeInsert = new AptasACursosLocalHome();	
                              
                        try{
                            aptasACursosLocal = aptasACursosLocalHome.findByPrimaryKey(dto.getParticipantes()[i].getOidParticipante());
                        } catch (NoResultException fe) {
                            UtilidadesLog.error("registrarAsistencia: FinderException al buscar registro en APTAS a CURSOS",fe);
                            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                        }
                        
                        if (dto.getOperacion().intValue() == ConstantesEDU.REG_ASIS.intValue()){//(caso de uso Registrar Asistencia a Curso)
                            aptasACursosLocal.setFechaAsistencia(new Date(dto.getParticipantes()[i].getFecAsistencia().getTime()));
                          
                            if (aptasACursosLocal.getApta().booleanValue()) {//(Participante apto)
                                aptasACursosLocal.setAsistenciaCurso(ConstantesEDU.ASIS_APTA);
                            }else{//(Participante invitado)
                                aptasACursosLocal.setAsistenciaCurso(ConstantesEDU.ASIS_OTRO);
                            }
                            aptasACursosLocalHome.merge(aptasACursosLocal);
                        }else{//Si no (caso de uso Registrar Extemporaneas a Cursos) 
                        /*mdolce 25/01/2007 en el caso de extemporaneas, no se debe updatear el registro, sino insertar uno nuevo*/
                            try{
                                UtilidadesLog.debug("MAD Va a insertar con curso " + dto.getOidCurso());
                                UtilidadesLog.debug("MAD Va a insertar con convocatoria " + aptasACursosLocal.getNumConvocatoria());
                                UtilidadesLog.debug("MAD Va a insertar con cliente " + dto.getParticipantes()[i].getOidCliente());
                                UtilidadesLog.debug("MAD Va a insertar con subtipo " + aptasACursosLocal.getSubtipo());
                                
                                aptasACursosLocalInsert = aptasACursosLocalHomeInsert.create(dto.getOidCurso(), 
                                                                aptasACursosLocal.getNumConvocatoria(),dto.getParticipantes()[i].getOidCliente(),aptasACursosLocal.getSubtipo() );
                            } catch (PersistenceException fe) {		
                                UtilidadesLog.error("registrarAsistencia: CReateException",fe);
                                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                            }
                            aptasACursosLocalInsert.setAsistenciaCurso(ConstantesEDU.ASIS_OTRO);
                            aptasACursosLocalInsert.setFechaAsistencia(new Date(dto.getParticipantes()[i].getFecAsistencia().getTime()));
                            aptasACursosLocalInsert.setDataMart(Boolean.FALSE);
                            aptasACursosLocalInsert.setInvitadaCurso(Boolean.FALSE);
                            aptasACursosLocalInsert.setApta(Boolean.TRUE);
                            aptasACursosLocalInsert.setPruebas(Boolean.FALSE);
                            aptasACursosLocalHomeInsert.merge(aptasACursosLocalInsert);
                        }
                        
                        //Se crea un objeto de la clase DTOPedido (dtoPed) y se carga con los siguientes valores: 
                        DTOPedido dtoPed = new DTOPedido();
                        dtoPed.setOperacion(dto.getOperacion());
                        dtoPed.setRegalo(matrizCursosLocal.getRegalo());
                        if (matrizCursosLocal.getMomentoEntrega() != null) {
                            dtoPed.setMomento(new Integer(matrizCursosLocal.getMomentoEntrega().toString()));
                        } else {
                            dtoPed.setMomento(null);
                        }
                        dtoPed.setUnidades(matrizCursosLocal.getNumeroUnidades());
                        dtoPed.setPais(dto.getOidPais());
                        dtoPed.setMarca(matrizCursosLocal.getMarca());
                        dtoPed.setCanal(matrizCursosLocal.getCanal());
                        dtoPed.setAcceso(matrizCursosLocal.getAcceso());
                        dtoPed.setOidCliente(dto.getParticipantes()[i].getOidCliente());
                    
                        System.out.println("MAD " + dto.getParticipantes()[i].getOidTipoCliente());
                        dtoPed.setOidTipoCliente(dto.getParticipantes()[i].getOidTipoCliente());
                        dtoPed.setOidIdioma(dto.getParticipantes()[i].getOidIdioma());
                        dtoPed.setOidPais(dto.getOidPais());
                        //Se llama al método generarPedido pasándole como parámetros de entrada: dtoPed 
                        generarPedido (dtoPed);
                    }	// fin for
            }
		}	// fin if			
		UtilidadesLog.info(" CNRegistrarAsistencia.registrarAsistencia(DTORegistrarAsistencia) : Salida");
	}


	private void generarPedido (DTOPedido dto) throws MareException {
		UtilidadesLog.info(" CNRegistrarAsistencia.generarPedido(DTOPedido) : Entrada");

		DTOPeriodo dtoP = new DTOPeriodo();
        if (dto.getRegalo()!=null){
            if (dto.getMomento()!=null){
                if (dto.getMomento().intValue()== ConstantesEDU.VIA_PEDIDO.intValue()){
                    //llamada obtienePeriodoActual de la interface IPeriodos - parámetros: dtoe.pais, dtoe.marca y dtoe.canal. El método retorna DTOPeriodo (dtoP). 
                    MONPeriodos monPeriodos = null;
                    MONTiposSolicitudPais monTiposSolicitudPais = null;
                    MONGenerarSolicitudModulosExternos monGenerarSolicitud = null;
                    try  {
                        monPeriodos = this.getMONPeriodos();					
                            dtoP = monPeriodos.obtienePeriodoActual(dto.getPais(),dto.getMarca(),dto.getCanal());
                      
                        DTOTipoSolicitudOP dtoOP = new DTOTipoSolicitudOP(); 
                        dtoOP.setOidMarca(dto.getMarca());
                        dtoOP.setOidAcceso(dto.getAcceso());
                        if(dto.getOidPais() != null && dto.getPais() == dto.getOidPais()){
                            dtoOP.setOidPais(dto.getOidPais() );
                        }
                        dtoOP.setOidTipoCliente(dto.getOidTipoCliente());				
                        //incidencia 22966 - Si operacion = ConstantesEDU.REG_ASIS (caso de uso Registrar Asistencia a Curso) 
                        if (dto.getOperacion().equals(ConstantesEDU.REG_ASIS)) {
                            dtoOP.setOidOperacion(ConstantesBEL.EDU001);
                        } else{ //Si no (caso de uso Registrar Extemporáneas a Curso)
                            dtoOP.setOidOperacion(ConstantesBEL.EDU002);				
                        }
                        
                        monTiposSolicitudPais = this.getMONTiposSolicitudPais();
                        DTOTipoSolicitudOP dtoOPS = null;
                        try{
                            UtilidadesLog.debug("****aNTES DE LLAMAR A..... dtoP ="+dtoP);
                            UtilidadesLog.debug("****  dtoOPS = monTiposSolicitudPais.obtieneTipoSolicitudporProceso");	
                             dtoOPS = monTiposSolicitudPais.obtieneTipoSolicitudporProceso(dtoOP);
                             
                             UtilidadesLog.debug("****dtoOPS ="+dtoOPS);	
                        }catch (MareException me)  {
                                UtilidadesLog.error("generarPedido: MareException",me);
                                //throw new MareException(me, UtilidadesError.armarCodigoError(""));
                                throw new MareException(null, new Exception(), 
                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_EDU, "", 
                                                                        ErroresNegocio.TIPO_SOLICITUD_NO_ENCONTRADO));
                        }
    
                        //Se crea DTOCabeceraSolicitud (dtoSol) y se carga con los siguientes datos: 
                        DTOCabeceraSolicitud dtoSol = new DTOCabeceraSolicitud();
    
                        // incidencia 22966 - Si operacion = ConstantesEDU.REG_ASIS (caso de uso Registrar Asistencia a Curso) 
                        if(dto.getOperacion().equals(ConstantesEDU.REG_ASIS)){
                            dtoSol.setOperacion(ConstantesBEL.EDU001);
                        }else{ //Si no (caso de uso Registrar Extemporáneas a Curso)
                            dtoSol.setOperacion(ConstantesBEL.EDU002);				
                        }
                    
                        dtoSol.setModulo(new Long(ConstantesSEG.MODULO_EDU));  
                        dtoSol.setOidPais(dto.getOidPais());
                        dtoSol.setMarca(dto.getMarca());
                        dtoSol.setCanal(dto.getCanal()); 
                        dtoSol.setAcceso(dto.getAcceso());
                        dtoSol.setTipoSolicitud(dtoOPS.getOidTipoSolicitud()); 
                        dtoSol.setOidCliente(dto.getOidCliente());
                        dtoSol.setPeriodo(dtoP.getOid());
                        dtoSol.setFecha(new Date(System.currentTimeMillis()));
                        dtoSol.setOidIdioma(dto.getOidIdioma());				
    
                        //Se crea DAORegalos y se llama al método obtieneProductos pasándole como parámetro de entrada el parámetro dtoe.regalo recibido. 
                        RecordSet registro = null;
                        DAORegalos daoRegalos = new DAORegalos(ctx.getCallerPrincipal().getName());
                    
                        registro = daoRegalos.obtieneProductos(dto.getRegalo(),dto.getOidIdioma());					
                        UtilidadesLog.debug("registro = daoRegalos.obtieneProductos");
                        UtilidadesLog.debug("registro = " +registro);
                            
                        //Por cada uno de los elementos del RecordSet (registro) retornado por el método, se realizan las siguientes operaciones: 
                        if(!registro.esVacio()){
                            ArrayList array = new ArrayList();
                            for(int i=0; i<registro.getRowCount();i++){
                            //Se añade un nuevo elemento al array list dtoSol.posiciones() 
                                DTOPosicionSolicitud dtoPS = new DTOPosicionSolicitud();
                                dtoPS.setTipoPosicion(dtoOPS.getOidTipoPosicion());
                                dtoPS.setSubtipoPosicion(dtoOPS.getOidSubtipoPosicion());
                                Long oid = new Long(registro.getValueAt(i,0).toString());
                                dtoPS.setProducto(oid);
                                dtoPS.setUnidadesDemandadas(new Long(dto.getUnidades().longValue()));
                                array.add(dtoPS);
                            }		
                            dtoSol.setPosiciones(array);
                            //Se llama al método generaSolicitud de la interface
                            //IPEDGenerarSolicitudesExternas pasándole como parámetro de entrada dtoSol.
                            //MONGenerarSolicitudModulosExternos.generaSolicitud.
                            UtilidadesLog.debug("****monGenerarSolicitud.generaSolicitud(dtoSol) dtosol=  "+dtoSol);
                            monGenerarSolicitud = this.getMONGenerarSolicitudModulosExternos();
                            
                            DTOOID dtooid = monGenerarSolicitud.generaSolicitud(dtoSol);
                            UtilidadesLog.debug("****DTOOID dtooid = moGenerarSolicitud.generaSolicitud(dtoSol) dtooid=  "+dtooid);
                            
                        }
                    } catch (RemoteException re)  {
                        UtilidadesLog.error("generarPedido: Exception",re);
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            }
		}
		UtilidadesLog.info(" CNRegistrarAsistencia.generarPedido(DTOPedido) : Salida");
	}

	
    private MatrizCursosLocalHome getMatrizCursosLocalHome() throws MareException {
	     MatrizCursosLocalHome matrizCursosLocalHome = (MatrizCursosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MatrizCursos");
	     return matrizCursosLocalHome;
    }
	
     private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info(" CNRegistrarAsistencia.getMONPeriodos() : Entrada");			
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos",
		MONPeriodosHome.class);
        
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			      UtilidadesLog.error("*** Error en getMONPeriodos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		   UtilidadesLog.info(" CNRegistrarAsistencia.getMONPeriodos() : Sallida");			
        return ejb;
	}   


    private MONTiposSolicitudPais getMONTiposSolicitudPais() throws MareException {
        // Se obtiene el interfaz home
		    UtilidadesLog.info(" CNRegistrarAsistencia.getMONTiposSolicitudPais() : Entrada");					
        MONTiposSolicitudPaisHome home = (MONTiposSolicitudPaisHome)UtilidadesEJB.getHome(
            "MONTiposSolicitudPais", MONTiposSolicitudPaisHome.class);
            
        // Se obtiene el interfaz remoto
        MONTiposSolicitudPais ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			  UtilidadesLog.error("*** Error en getMONTiposSolicitudPais",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		    UtilidadesLog.info(" CNRegistrarAsistencia.getMONTiposSolicitudPais() : Salida");						        
        return ejb;
	}   


    private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
        // Se obtiene el interfaz home
		  UtilidadesLog.info(" CNRegistrarAsistencia.getMONGenerarSolicitudModulosExternos() : Entrada");								
      MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome)UtilidadesEJB.getHome(
            "MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
            
        // Se obtiene el interfaz remoto
        MONGenerarSolicitudModulosExternos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONGenerarSolicitudModulosExternos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		    UtilidadesLog.info(" CNRegistrarAsistencia.getMONGenerarSolicitudModulosExternos() : Salida");								
        return ejb;
	}   
}