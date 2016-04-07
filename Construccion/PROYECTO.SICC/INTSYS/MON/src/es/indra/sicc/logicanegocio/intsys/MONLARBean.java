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
package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.dtos.intsys.DTOINTCargaInicialLarissa;
import es.indra.sicc.dtos.intsys.DTOINTClaseTipoSolicitud;
import es.indra.sicc.dtos.intsys.DTOINTDatosImpresionGuias;
import es.indra.sicc.dtos.intsys.DTOINTDatosMaestro;
import es.indra.sicc.dtos.intsys.DTOINTDatosMaestroTerritorio;
import es.indra.sicc.dtos.intsys.DTOINTDestinosClientes;
import es.indra.sicc.dtos.intsys.DTOINTDocumento;
import es.indra.sicc.dtos.intsys.DTOINTCabeceraDocumento;

import es.indra.sicc.dtos.intsys.DTOINTDocumentoIdendidad;
import es.indra.sicc.dtos.intsys.DTOINTPosicionesDocumento;
import es.indra.sicc.dtos.intsys.DTOINTProductoEstimado;
import es.indra.sicc.dtos.intsys.DTOINTProductoVentaReal;
import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;
import es.indra.sicc.dtos.intsys.DTOINTSecuenciaPedido;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOColeccion;
import java.math.BigDecimal;
import java.util.Collection;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONLARBean implements SessionBean 
{
	public void ejbCreate()
	{
	}

	public void ejbActivate()
	{
	}

	public void ejbPassivate()
	{
	}

	public void ejbRemove()
	{
	}

	public void setSessionContext(SessionContext ctx)
	{
	}

	public DTOSalidaBatch enviarClasesTipoSolicitud(DTOBatch dto) throws MareException
	{
        UtilidadesLog.info("MONLARBean.enviarClasesTipoSolicitud(DTOBatch dto): Entrada");
		
		DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
		
		DAOINTLAR dao = new DAOINTLAR();
		
		ArrayList listaClasesTipos = dao.obtenerClasesTiposSolicitud(dtoL.getOidPais(),dtoL.getOidIdioma(),dtoL.getMarca(),dtoL.getCanal());
		
		MONGestorInterfaces gi = this.getMONGestorInterfaces();
		
		InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR5,
												dtoL.getNumeroLote(),
												dtoL.getOidPais());
		info.setObservaciones(dtoL.getObservaciones());
		info.setDescripcionLote(dtoL.getDescripcionLote());
		
		try{
			InterfazInfo interfaz = gi.crearInterfaz(info);
		}catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
			return new DTOSalidaBatch(0,"Interfaz LAR-5 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
		
		RegistroSicc registro = new RegistroSicc();
		DTOINTClaseTipoSolicitud dtoClaseTipo = null;
		int i = listaClasesTipos.size();
        int contador=0;
        if (listaClasesTipos == null || listaClasesTipos.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR5" );
        }
		while(contador < i){
			dtoClaseTipo = (DTOINTClaseTipoSolicitud)listaClasesTipos.get(contador);
			try{
				
				registro.anyadirCampo(ILarissa.LAR5_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
				registro.anyadirCampo(ILarissa.LAR5_FECHA_PROCESO,new Date(System.currentTimeMillis()));
				registro.anyadirCampo(ILarissa.LAR5_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
				registro.anyadirCampo(ILarissa.LAR5_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
				registro.anyadirCampo(ILarissa.LAR5_PERIODO,dtoL.getCodigoPeriodo());
				registro.anyadirCampo(ILarissa.LAR5_CLASE_SOLICITUD,dtoClaseTipo.getCodigoClaseSolicitud());
				registro.anyadirCampo(ILarissa.LAR5_DESCRIPCION_CLASE,dtoClaseTipo.getDescripcionClaseSolicitud());
				registro.anyadirCampo(ILarissa.LAR5_TIPO_SOLICITUD,dtoClaseTipo.getCodigoTipoSolicitud());
				registro.anyadirCampo(ILarissa.LAR5_DESCRIPCION_TIPO,dtoClaseTipo.getDescripcionTipoSolicitud());
					
			}catch(InterfacesException ie) {
				UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
				continue;
			}
			
			//se añade el registro al fichero de la interfaz
			try{	
				gi.anyadirRegistro(info,registro);
			}catch(InterfacesException ie) {
				UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
			}catch(RemoteException ne){				
				UtilidadesLog.debug("error RemoteException");
				throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
			
			registro.vaciar();
			contador++;
		}
		
		try{
			gi.enviarInterfaz(info);	
		}catch(InterfacesException ie) {
			UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
		}catch(RemoteException ne){			
			UtilidadesLog.debug("error RemoteException");
			throw new MareException(ne,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		
        UtilidadesLog.info("MONLARBean.enviarClasesTipoSolicitud(DTOBatch dto): Salida");
		return new DTOSalidaBatch(0,"Interfaz LAR-5 procesada");
	}

    public DTOSalidaBatch enviarMaestroDestinosClientes(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarMaestroDestinosClientes(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarMaestroDestinosClientes");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerDestinosClientes");
        ArrayList destinosClientes = dao.obtenerDestinosClientes(dtoL.getOidPais(),dtoL.getPeriodo(), dtoL.getOidIdioma());
        Cronometrador.endTransaction("dao.obtenerDestinosClientes");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR6, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-6 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDestinosClientes dtoDC;
            
        Iterator iter = destinosClientes.iterator();
        while(iter.hasNext()){
            dtoDC = (DTOINTDestinosClientes)iter.next();
            try{              
                registro.anyadirCampo(ILarissa.LAR6_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR6_FECHA_PROCESADO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR6_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR6_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR6_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR6_CODIGO_CLIENTE,dtoDC.getCodigoCliente());
                registro.anyadirCampo(ILarissa.LAR6_TRATAMIENTO,dtoDC.getTratamiento());
                registro.anyadirCampo(ILarissa.LAR6_APELLIDO_PATERNO,dtoDC.getApellidoPaterno());
                registro.anyadirCampo(ILarissa.LAR6_APELLIDO_MATERNO,dtoDC.getApellidoMaterno());
                registro.anyadirCampo(ILarissa.LAR6_APELLIDO_CASADA,dtoDC.getApellidoCasada());
                registro.anyadirCampo(ILarissa.LAR6_NOMBRE1,dtoDC.getNombre1());
                registro.anyadirCampo(ILarissa.LAR6_NOMBRE2,dtoDC.getNombre2());
                registro.anyadirCampo(ILarissa.LAR6_TIPO_VIA,dtoDC.getCodigoTipoVia());
                registro.anyadirCampo(ILarissa.LAR6_NOMBRE_VIA,dtoDC.getNombreVia());
                registro.anyadirCampo(ILarissa.LAR6_NUMERO_PRINCIPAL,dtoDC.getNumeroPrincipal());
                registro.anyadirCampo(ILarissa.LAR6_NUMERO_INTERIOR,dtoDC.getNumeroInterior());
                registro.anyadirCampo(ILarissa.LAR6_MANZANA,dtoDC.getManzana());
                registro.anyadirCampo(ILarissa.LAR6_LOTE,dtoDC.getLote());
                registro.anyadirCampo(ILarissa.LAR6_KM,dtoDC.getKm());
                registro.anyadirCampo(ILarissa.LAR6_BLOCK,dtoDC.getManzana());
                registro.anyadirCampo(ILarissa.LAR6_REFERENCIA,dtoDC.getReferencia());
                registro.anyadirCampo(ILarissa.LAR6_ZONA,dtoDC.getCodigoZona());
                registro.anyadirCampo(ILarissa.LAR6_TERRITORIO,new Integer(dtoDC.getCodigoTerritorio()));
                if (dtoDC.getIndicadorVIP().booleanValue()){
                    registro.anyadirCampo(ILarissa.LAR6_INDICADOR_VIP,"1");
                }else{
                    registro.anyadirCampo(ILarissa.LAR6_INDICADOR_VIP,"0");
                }
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO1,dtoDC.getUbigeo1());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO2,dtoDC.getUbigeo2());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO3,dtoDC.getUbigeo3());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO4,dtoDC.getUbigeo4());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO5,dtoDC.getUbigeo5());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO6,dtoDC.getUbigeo6());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO7,dtoDC.getUbigeo7());
                registro.anyadirCampo(ILarissa.LAR6_UBIGEO8,dtoDC.getUbigeo8());                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }            
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException");
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONLARBean.enviarMaestroDestinosClientes(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarMaestroDestinosClientes");
        return new DTOSalidaBatch(0,"Interfaz LAR-6 procesada");
    }


    public DTOSalidaBatch enviarCabeceraDetalleDocumentos(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarCabeceraDetalleDocumentos(DTOBatch dto): Entrada");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
		
        /* 21877 - dmorello, 07/06/2006: Se reemplazan las 2 sig. llamadas... */
            //this.generarCabeceraDocumentos(dtoL,null);
        //this.generarDetalleDocumentos(dtoL,null);
        this.generarDocumento(dtoL);
        /* Fin 21877 */
		
        UtilidadesLog.info("MONLARBean.enviarCabeceraDetalleDocumentos(DTOBatch dto): Salida");
    		return new DTOSalidaBatch(0, "enviarCabeceraDetalleDocumentos procesado");
    }

	/**
     * Modificado por incidencia 21877 - dmorello, 07/06/2006
     * Se agrega el parámetro de entrada listaCabeceras
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoL
     * @param listaCabeceras
     */
    public void generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaCabeceras) throws MareException{
        UtilidadesLog.info("MONLARBean.generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaCabeceras): Entrada");
        Cronometrador.startTransaction("MONLARBean.generarCabeceraDocumentos");
		
        /* 21877 - dmorello, 07/06/2006: Se elimina el DAO ya que no hace falta obtener la lista */
        //DAOINTLAR dao = new DAOINTLAR();
		
        //ArrayList listaClasesTipos = null;
        /* 21877 - dmorello, 07/06/2006: la nueva listaCabeceras reemplaza a listaDetalles */
        //ArrayList listaDetalles = dao.obtenerCabeceraDocumento(dtoL.getPeriodo());
		
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR7C, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDocumento dtoDoc = null;
        int i = listaCabeceras.size();
        int contador=0;
        if (listaCabeceras == null || listaCabeceras.size() == 0){
            UtilidadesLog.debug("No hay datos para generar la interfaz LAR7C");
            return;
            //return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR7C" );
        }
        while(contador < i){
            dtoDoc = (DTOINTDocumento)listaCabeceras.get(contador);
            try{
                //Modificado por incidencia 14391
                registro.anyadirCampo(ILarissa.LAR7_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR7_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR7_TIPO_PERIODO,dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_EMPRESA,dtoDoc.getCodigoEmpresa());
                //registro.anyadirCampo(ILarissa.LAR7_COMPANIA,dtoDoc.getCodigoEmpresa()); Sustituido por linea anterior en 14391
                registro.anyadirCampo(ILarissa.LAR7_NUMERO_PEDIDO,dtoDoc.getNumeroPedido());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_CLIENTE,dtoDoc.getCodigoCliente());
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PEDIDO,dtoDoc.getFechaPedido());//Añadido posterior por 14391
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_PEDIDO_A_CHEQUEAR,dtoDoc.getIndicadorPedidoAChequear());
                registro.anyadirCampo(ILarissa.LAR7_TOTAL_ITEMS_POR_PEDIDO,dtoDoc.getTotalItemsPedido());
                registro.anyadirCampo(ILarissa.LAR7_TOTAL_UNIDADES_POR_PEDIDO,dtoDoc.getTotalUnidadesPedido());
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_PEDIDO_EXPRESS,dtoDoc.getIndicadorPedidoExpress());
                registro.anyadirCampo(ILarissa.LAR7_FECHA_CITA,dtoDoc.getFechaCita());
                registro.anyadirCampo(ILarissa.LAR7_HORA_CITA,dtoDoc.getHoraCita());
                registro.anyadirCampo(ILarissa.LAR7_CLASE_SOLICITUD,dtoDoc.getClaseSolicitud());
                registro.anyadirCampo(ILarissa.LAR7_TIPO_SOLICITUD, dtoDoc.getTipoSolicitud());                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }          
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Cronometrador.endTransaction("MONLARBean.generarCabeceraDocumentos");
        UtilidadesLog.info("MONLARBean.generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaCabeceras): Salida");
    }

	/**
     * Modificado por incidencia 21877 - dmorello, 07/06/2006
     * Se agrega el parámetro de entrada listaDetalles
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoL
     * @param listaDetalles
     */
    public void generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaDetalles) throws MareException{
        UtilidadesLog.info("MONLARBean.generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaDetalles): Entrada");		
        Cronometrador.startTransaction("MONLARBean.generarDetalleDocumentos");
        //DAOINTLAR dao = new DAOINTLAR();
        
        //ArrayList listaClasesTipos = null;
            /* 21887 - dmorello, 07/06/2006: El nuevo parametro listaDetalles reemplaza a la sig. lista */
        //ArrayList listaDetalles = dao.obtenerDetallesDocumento(dtoL.getPeriodo());
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR7D, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            //return new DTOSalidaBatch(0,"Interfaz LAR-7D procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDocumento dtoDoc = null;
        int i = listaDetalles.size();
        int contador=0;
        if (listaDetalles == null || listaDetalles.size() == 0){
            UtilidadesLog.debug("No hay datos para generar la interfaz LAR7D");
            return;
        }
        while(contador < i){
            dtoDoc = (DTOINTDocumento)listaDetalles.get(contador);
            try{              
                registro.anyadirCampo(ILarissa.LAR7_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR7_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR7_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_EMPRESA,dtoDoc.getCodigoEmpresa());
                registro.anyadirCampo(ILarissa.LAR7_NUMERO_PEDIDO,dtoDoc.getNumeroPedido());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_ITEM,dtoDoc.getCodigoItem());
                if(dtoDoc.getUnidadesPorAtender()!=null){                
                    registro.anyadirCampo(ILarissa.LAR7_UNIDADES_POR_ATENDER,new Integer(dtoDoc.getUnidadesPorAtender()));
                }else{                
                    registro.anyadirCampo(ILarissa.LAR7_UNIDADES_POR_ATENDER,null);
                }
                
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_DENTRO_FUERA_CAJA,dtoDoc.getIndicadorDentroFueraCaja());
                registro.anyadirCampo(ILarissa.LAR7_CLASE_SOLICITUD,dtoDoc.getClaseSolicitud());
                registro.anyadirCampo(ILarissa.LAR7_TIPO_SOLICITUD,dtoDoc.getTipoSolicitud());
                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Cronometrador.endTransaction("MONLARBean.generarDetalleDocumentos");
        UtilidadesLog.info("MONLARBean.generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, ArrayList listaDetalles): Salida");
	}
 /*Se modifica por cambios de FAC-001 Alorenzo */
 /*   public DTOSalidaBatch enviarDatosImpresionGuias(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarDatosImpresionGuias(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarDatosImpresionGuias");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        
        ArrayList listaDatos = dao.obtenerDatosImpresionGuias(dtoL.getPeriodo());
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR8, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-8 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDatosImpresionGuias dtoDatos = null;
        int i = listaDatos.size();
        int contador=0;
        if (listaDatos == null || listaDatos.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR8" );
        }
        while(contador < i){
            dtoDatos = (DTOINTDatosImpresionGuias)listaDatos.get(contador);
            try{
              
                registro.anyadirCampo(ILarissa.LAR8_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR8_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR8_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR8_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR8_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR8_TIPO_CODIGO_EMPRESA,dtoDatos.getCodigoEmpresa());
                registro.anyadirCampo(ILarissa.LAR8_NUMERO_PEDIDO,dtoDatos.getNumeroPedido());
                //modificado por Cnoziglia inc. 21132 
                if(dtoDatos.getTipoFormulario()!=null){
                    if(dtoDatos.getTipoFormulario().equals(ILarissa.LAR8_TIPOFORMULARIOGU)){
                        registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIOESGU);
                    }else{
                        registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIONOESGU);
                    }
                }else{
                    registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIONOESGU);
                }
                registro.anyadirCampo(ILarissa.LAR8_NUMERO_FORMULARIO,dtoDatos.getNumeroFormulario());
                registro.anyadirCampo(ILarissa.LAR8_CLASE_SOLICITUD,dtoDatos.getClaseSolicitud());
                registro.anyadirCampo(ILarissa.LAR8_TIPO_SOLICITUD,dtoDatos.getTipoSolicitud());                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        
        //MODIFICADO BELC300024162 pzerbino 18/9/2006
        //Cronometrador.startTransaction("dao.obtieneCabeceras");
        //ArrayList listaOIDs = dao.obtieneCabeceras(dtoL.getPeriodo());
        //Cronometrador.endTransaction("dao.obtieneCabeceras");        
        //Cronometrador.startTransaction("dao.actualizarCabecerasDocumento");
        //dao.actualizarCabecerasDocumento(listaOIDs);
       // Cronometrador.endTransaction("dao.actualizarCabecerasDocumento");
        
        UtilidadesLog.info("MONLARBean.enviarDatosImpresionGuias(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarDatosImpresionGuias");
        return new DTOSalidaBatch(0,"Interfaz LAR-8 procesada");
    }*/
    
    public DTOSalidaBatch enviarDatosImpresionGuias(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarDatosImpresionGuias(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarDatosImpresionGuias");
        DTOFACReasignarNumeroDocContable dtoL = (DTOFACReasignarNumeroDocContable)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        
        ArrayList listaDatos = dao.obtenerDatosImpresionGuias(dtoL);
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        String numLote = null;
        InterfazInfo info = null;
        try{
            numLote = gi.obtenerNumeroLote();
            
            info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR8, numLote, dtoL.getOidPais());
            info.setObservaciones("LAR-8");
            info.setDescripcionLote("LAR-8");
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-8 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDatosImpresionGuias dtoDatos = null;
        int i = listaDatos.size();
        int contador=0;
        if (listaDatos == null || listaDatos.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR8" );
        }
        while(contador < i){
            dtoDatos = (DTOINTDatosImpresionGuias)listaDatos.get(contador);
            try{
              
                registro.anyadirCampo(ILarissa.LAR8_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR8_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR8_LOTE_ENVIO_DIA,new Long(numLote));
                registro.anyadirCampo(ILarissa.LAR8_NUMERO_PEDIDO,dtoDatos.getNumeroPedido());
                //modificado por Cnoziglia inc. 21132 
                if(dtoDatos.getTipoFormulario()!=null){
                    if(dtoDatos.getTipoFormulario().equals(ILarissa.LAR8_TIPOFORMULARIOGU)){
                        registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIOESGU);
                    }else{
                        registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIONOESGU);
                    }
                }else{
                    registro.anyadirCampo(ILarissa.LAR8_TIPO_FORMULARIO,ILarissa.LAR8_TIPOFORMULARIONOESGU);
                }
                registro.anyadirCampo(ILarissa.LAR8_NUMERO_FORMULARIO,dtoDatos.getNumeroFormulario());
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        
        //MODIFICADO BELC300024162 pzerbino 18/9/2006
        /*Cronometrador.startTransaction("dao.obtieneCabeceras");
        ArrayList listaOIDs = dao.obtieneCabeceras(dtoL.getPeriodo());
        Cronometrador.endTransaction("dao.obtieneCabeceras");        
        Cronometrador.startTransaction("dao.actualizarCabecerasDocumento");
        dao.actualizarCabecerasDocumento(listaOIDs);
        Cronometrador.endTransaction("dao.actualizarCabecerasDocumento");
        */
        UtilidadesLog.info("MONLARBean.enviarDatosImpresionGuias(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarDatosImpresionGuias");
        return new DTOSalidaBatch(0,"Interfaz LAR-8 procesada");
    }

    public DTOSalidaBatch enviarMatrizProductosEstimados(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarMatrizProductosEstimados(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarMatrizProductosEstimados");
		
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        
        ArrayList listaProductos = dao.obtenerProductosEstimados(dtoL.getPeriodo());
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR1,
                            dtoL.getNumeroLote(),
                            dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
          InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
          return new DTOSalidaBatch(0,"Interfaz LAR-1 procesada con error");
            }catch(RemoteException ne){            
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTProductoEstimado dtoProducto = null;
        int i = listaProductos.size();
            UtilidadesLog.debug("El número de registros es: "+i);
            int contador=0;
            if (listaProductos == null || listaProductos.size() == 0){
                return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR1" );
            }
        while(contador < i){
          //dtoProducto = (DTOINTProductoEstimado)listaProductos.get(i-1);
                UtilidadesLog.debug("Contador es: "+contador);
                dtoProducto = (DTOINTProductoEstimado)listaProductos.get(contador);
          try{
            UtilidadesLog.debug("El producto es: "+dtoProducto.getCodigoSAP());
            registro.anyadirCampo(ILarissa.LAR1_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
            registro.anyadirCampo(ILarissa.LAR1_FECHA_PROCESO,new Date(System.currentTimeMillis()));
            registro.anyadirCampo(ILarissa.LAR1_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
            registro.anyadirCampo(ILarissa.LAR1_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
            registro.anyadirCampo(ILarissa.LAR1_PERIODO,dtoL.getCodigoPeriodo());
            registro.anyadirCampo(ILarissa.LAR1_CODIGO_ITEM,dtoProducto.getCodigoSAP());
            registro.anyadirCampo(ILarissa.LAR1_DESCRIPCION_ITEM,dtoProducto.getDescripcionProducto());
            registro.anyadirCampo(ILarissa.LAR1_MARCA,dtoProducto.getMarca());
            registro.anyadirCampo(ILarissa.LAR1_UNIDAD_NEGOCIO,dtoProducto.getUnidadNegocio());
            registro.anyadirCampo(ILarissa.LAR1_NEGOCIO,dtoProducto.getNegocio());
            registro.anyadirCampo(ILarissa.LAR1_ESTATUS_PRODUCTO,dtoProducto.getEstatusProducto());
            registro.anyadirCampo(ILarissa.LAR1_TOTAL_UNIDADES_PRODUCTO,dtoProducto.getTotalUnidadesProducto());
            registro.anyadirCampo(ILarissa.LAR1_INDICADOR_DENTRO_FUERA_CAJA,dtoProducto.getIndicadorDentroFueraCaja());
                    if (dtoProducto.getLargoCentimetros()!=null)
                    {
                        registro.anyadirCampo(ILarissa.LAR1_LARGO_CENTIMETROS,dtoProducto.getLargoCentimetros().toString());   
                    } else 
                    {
                        registro.anyadirCampo(ILarissa.LAR1_LARGO_CENTIMETROS,null);
                    }
                    if (dtoProducto.getAnchoCentimetros()!=null) 
                    {
                        registro.anyadirCampo(ILarissa.LAR1_ANCHO_CENTIMETROS,dtoProducto.getAnchoCentimetros().toString());
                    }else
                    {
                        registro.anyadirCampo(ILarissa.LAR1_ANCHO_CENTIMETROS,null);
                    }
            if(dtoProducto.getAltoCentimetros()!=null) 
                    {
                        registro.anyadirCampo(ILarissa.LAR1_ALTO_CENTIMETROS,dtoProducto.getAltoCentimetros().toString());
                    }else
                    {
                        registro.anyadirCampo(ILarissa.LAR1_ALTO_CENTIMETROS,null);
                    }
            
                    if(dtoProducto.getPesoBrutoGramos()!=null)
                    {
                        registro.anyadirCampo(ILarissa.LAR1_PESO_BRUTO_GRAMOS,dtoProducto.getPesoBrutoGramos());
                    }else
                    {
                        registro.anyadirCampo(ILarissa.LAR1_PESO_BRUTO_GRAMOS,null);
                    }
            
              
          }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            continue;
          }
          
          //se añade el registro al fichero de la interfaz
          try{	
            gi.anyadirRegistro(info,registro);
          }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
          }catch(RemoteException ne){				
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
          
          registro.vaciar();
          //i--;
                contador++;
        }
        
        try{
          gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
          UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
          UtilidadesLog.debug("error RemoteException");
          throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONLARBean.enviarMatrizProductosEstimados(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarMatrizProductosEstimados");
        return new DTOSalidaBatch(0,"Interfaz LAR-1 procesada");
    }

    public DTOSalidaBatch enviarMatrizProductosVentaReal(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarMatrizProductosVentaReal(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarMatrizProductosVentaReal");
		
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerProductosVentaReal");
        ArrayList productos = dao.obtenerProductosVentaReal( dtoL) ;
        Cronometrador.endTransaction("dao.obtenerProductosVentaReal");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR2, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-2 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTProductoVentaReal dtoProducto = null;
        int i = productos.size();
        int contador=0;
        if (productos == null || productos.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR2" );
        }		
        while(contador < i){
            dtoProducto = (DTOINTProductoVentaReal)productos.get(contador);
            try{              
                registro.anyadirCampo(ILarissa.LAR2_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR2_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR2_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR2_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR2_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR2_CODIGO_ITEM,dtoProducto.getCodigoSAP());
                registro.anyadirCampo(ILarissa.LAR2_DESCRIPCION_ITEM,dtoProducto.getDescripcionSAP());
                registro.anyadirCampo(ILarissa.LAR2_MARCA,dtoProducto.getCodigoMarca());
                registro.anyadirCampo(ILarissa.LAR2_UNIDAD_NEGOCIO,dtoProducto.getCodigoUnidadNegocio());
                registro.anyadirCampo(ILarissa.LAR2_NEGOCIO,dtoProducto.getCodigoNegocio());
                registro.anyadirCampo(ILarissa.LAR2_ESTATUS_PRODUCTO,dtoProducto.getEstatusProducto());
                registro.anyadirCampo(ILarissa.LAR2_TOTAL_UNIDADES_PRODUCTO,dtoProducto.getTotalUnidades());
                registro.anyadirCampo(ILarissa.LAR2_INDICADOR_DENTRO_FUERA_BOLSA,dtoProducto.getIndicadorDentroFueraCajaBolsa());
                if (dtoProducto.getLargoCentimetros()!=null){
                    registro.anyadirCampo(ILarissa.LAR2_LARGO_CENTIMETROS,dtoProducto.getLargoCentimetros().toString());
                }else{
                    registro.anyadirCampo(ILarissa.LAR2_LARGO_CENTIMETROS,null);
                }                        
                if (dtoProducto.getAnchoCentimetros()!=null){
                    registro.anyadirCampo(ILarissa.LAR2_ANCHO_CENTIMETROS,dtoProducto.getAnchoCentimetros().toString());
                }else{
                    registro.anyadirCampo(ILarissa.LAR2_ANCHO_CENTIMETROS,null);
                }        
                if (dtoProducto.getAltoCentimetros()!=null) {
                    registro.anyadirCampo(ILarissa.LAR2_ALTO_CENTIMETROS,dtoProducto.getAltoCentimetros().toString());
                }else{
                    registro.anyadirCampo(ILarissa.LAR2_ALTO_CENTIMETROS,null);
                }                
                if(dtoProducto.getPesoBrutoGramos()!=null){
                    registro.anyadirCampo(ILarissa.LAR2_PESO_BRUTO_GRAMOS,dtoProducto.getPesoBrutoGramos());
                }else{
                    registro.anyadirCampo(ILarissa.LAR2_PESO_BRUTO_GRAMOS,null);
                }
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){			
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONLARBean.enviarMatrizProductosVentaReal(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarMatrizProductosVentaReal");
        return new DTOSalidaBatch(0,"Interfaz LAR-2 procesada");
    }

    public DTOSalidaBatch enviarMaestroZonas(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarMaestroZonas(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarMaestroZonas");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerZonas");
        ArrayList listaZona = dao.obtenerZonas(dtoL.getPeriodo(), dtoL.getOidPais());
        Cronometrador.endTransaction("dao.obtenerZonas");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR3, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-3 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDatosMaestro dtoZona = null;
        int i = listaZona.size();
        int contador=0;
        if (listaZona == null || listaZona.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR3" );
        }
        while(contador < i){
            dtoZona = (DTOINTDatosMaestro)listaZona.get(contador);
            try{              
                registro.anyadirCampo(ILarissa.LAR3_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR3_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR3_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR3_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR3_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR3_CODIGO_ZONA,dtoZona.getCodigo());
                registro.anyadirCampo(ILarissa.LAR3_DESCRIPCION_ZONA,dtoZona.getDescripcion());                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONLARBean.enviarMaestroZonas(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarMaestroZonas");
        return new DTOSalidaBatch(0,"Interfaz LAR-3 procesada");
    }

    public DTOSalidaBatch enviarMaestroTerritorios(DTOBatch dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarMaestroTerritorios(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarMaestroTerritorios");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerTerritorios");
        ArrayList listaTerritorios = dao.obtenerTerritorios(dtoL.getPeriodo(), dtoL.getOidPais());
        Cronometrador.endTransaction("dao.obtenerTerritorios");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR4, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-4 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        //MODIFICADO BELC300024162  pzerbino 18/9/2006
        //DTOINTDatosMaestro dtoTerritorio = null;
        DTOINTDatosMaestroTerritorio dtoTerritorio = null;
        int i = listaTerritorios.size();
        int contador=0;
        if (listaTerritorios == null || listaTerritorios.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR4" );
        }		
        while(contador < i){
            //dtoTerritorio = (DTOINTDatosMaestro)listaTerritorios.get(contador);
            dtoTerritorio = (DTOINTDatosMaestroTerritorio)listaTerritorios.get(contador);
            try{              
                registro.anyadirCampo(ILarissa.LAR4_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR4_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR4_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR4_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR4_PERIODO,dtoL.getCodigoPeriodo());
                //registro.anyadirCampo(ILarissa.LAR4_CODIGO_TERRITORIO,dtoTerritorio.getCodigo());                
                //MODIFICADO BELC300024162  pzerbino 18/9/2006
                registro.anyadirCampo(ILarissa.LAR4_CODIGO_TERRITORIO, new Integer(dtoTerritorio.getCodigoTerritorio()));
                registro.anyadirCampo(ILarissa.LAR4_CODIGO_ZONA,dtoTerritorio.getCodigoZona());                
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }            
            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONLARBean.enviarMaestroTerritorios(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarMaestroTerritorios");
        return new DTOSalidaBatch(0,"Interfaz LAR-4 procesada");
    }

    public DTOSalidaBatch enviarInterfaces(DTOINTCargaInicialLarissa dto) throws MareException{
        UtilidadesLog.info("MONLARBean.enviarInterfaces(DTOINTCargaInicialLarissa dto): Entrada");
		
        /**
         * PeriodoCorporativo periodo = PeriodoCorporativoHome.findByPrimaryKey( dtoe.periodo ) 
         * dtoe.tipoPeriodo = periodo.tipoPeriodoCorporativo 
         * dtoe.codigoPeriodo = periodo.codigoPeriodoCorporativo 
         */
        UtilidadesLog.debug ("DTOINTCargaInicialLarissa: "+dto);
        PeriodoCorporativoLocalHome periodoCorporativoLocalHome = null;
        PeriodoCorporativoLocal periodoCorporativoLocal = null;
        PeriodoLocalHome periodoLocalHome = null;
        PeriodoLocal periodoLocal=null;
        
        //añadido por incidencia 20300
        periodoLocalHome = this.getPeriodoLocalHome();
        
        periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
        try{
            periodoLocal = periodoLocalHome.findByPrimaryKey(dto.getPeriodo());
        }catch (NoResultException ex){        
            UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -Periodo-",ex);
            return null;       
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        try{
            periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        }catch (NoResultException ex){        
            UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -PeriodoCorporativo-",ex);
            return null;
            /*Eliminado por incidencia 14522
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));*/            
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        dto.setTipoPeriodo(periodoCorporativoLocal.getOidTipoPeriodo());
        dto.setCodigoPeriodo(periodoCorporativoLocal.getCodigoPeriodo());
        UtilidadesLog.debug("periodoCorporativoLocal.TipooPeriodo: "+periodoCorporativoLocal.getOidTipoPeriodo());
        UtilidadesLog.debug("periodoCorporativoLocal.CodigoPeriodo: "+periodoCorporativoLocal.getCodigoPeriodo());
        /*
         * TipoPeriodoCorporativo tipoPeriodo = TipoPeriodoCorporativoHome.findByPrimaryKey( periodo.tipoPeriodoCorporativo ) 
         * dtoe.codigoTipoPeriodo = tipoPeriodo.codigoTipoPeriodo
         */
         
        TipoPeriodoCorporativoLocalHome tipoPeriodoCorporativoLocalHome = null;
        TipoPeriodoCorporativoLocal tipoPeriodoCorporativoLocal = null;
        
        tipoPeriodoCorporativoLocalHome = this.getTipoPeriodoCorporativoLocalHome();
        try{
            //tipoPeriodoCorporativoLocal = tipoPeriodoCorporativoLocalHome.findByPrimaryKey(dto.getPeriodo());
            tipoPeriodoCorporativoLocal = tipoPeriodoCorporativoLocalHome.findByPrimaryKey(periodoCorporativoLocal.getOidTipoPeriodo());

        }catch (NoResultException ex){        
            UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -TipoPeriodoCorporativo-",ex);
            return null;
            /*Eliminado por incidencia 14522
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));*/
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        dto.setCodigoTipoPeriodo(tipoPeriodoCorporativoLocal.getCodigoTipoPeriodo());
        UtilidadesLog.debug("tipoPeriodoCorporativoLocal.CodigoPeriodo: "+tipoPeriodoCorporativoLocal.getCodigoTipoPeriodo());
		
        DTOBatch dtoBatch = null;
        /*
         * Si( dtoe.enviarEstimados ) 
         * { 
         *      DTOBatch dtoBatch = new DTOBatch( "enviarMatrizProductosEstimados", 
         *      new MareBusinessID( "INTEnviarMatrizProductosEstimados" ), dtoe ) 
         *      BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 
         * }
         */
         
        UtilidadesLog.debug("Empieza a encolar las interfaces del combo");
        if (dto.getEnviarEstimados().booleanValue()){
            UtilidadesLog.debug("Interfaz enviarMatrizProductosEstimados activada");
            dtoBatch = new DTOBatch ("enviarMatrizProductosEstimados",new MareBusinessID("INTEnviarMatrizProductosEstimados"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
            }
        }
        
        //Se lanzan todas las interfaces cargadas desde el listado de la pagina
        UtilidadesLog.debug("Encolamos enviarMatrizProductosVentaReal");
        dtoBatch = new DTOBatch ("enviarMatrizProductosVentaReal",new MareBusinessID("INTEnviarMatrizProductosVentaReal"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        
        //Añadido segun incidencia 16916
        UtilidadesLog.debug("Encolamos enviarMaestroZonas");
        dtoBatch = new DTOBatch ("enviarMaestroZonas",new MareBusinessID("INTEnviarMaestroZonasLAR"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }        
        
        UtilidadesLog.debug("Encolamos enviarMaestroTerritorios");
        dtoBatch = new DTOBatch ("enviarMaestroTerritorios",new MareBusinessID("INTEnviarMaestroTerritorios"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        
        UtilidadesLog.debug("Encolamos enviarClasesTipoSolicitud");
        dtoBatch = new DTOBatch ("enviarClasesTipoSolicitud",new MareBusinessID("INTEnviarClasesTipoSolicitud"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        
        UtilidadesLog.debug("Encolamos enviarMaestroDestinosClientes");
        dtoBatch = new DTOBatch ("enviarMaestroDestinosClientes",new MareBusinessID("INTEnviarMaestroDestinosClientes"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }

        //añadido por Sapaza, fecha 28/04/2008, nuevas interfaces LAR9 y LAR10
        UtilidadesLog.debug("Encolamos enviarSecuenciaPedidos");
        dtoBatch = new DTOBatch ("enviarSecuenciaPedidos",new MareBusinessID("INTEnviarSecuenciaPedidos"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }

        UtilidadesLog.debug("Encolamos enviarDocumentoIdentidadClientes");
        dtoBatch = new DTOBatch ("enviarDocumentoIdentidadClientes",new MareBusinessID("INTEnviarDocumentoIdentidadClientes"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        
        UtilidadesLog.debug("Encolamos enviarCabeceraDetalleDocumentos");
        dtoBatch = new DTOBatch ("enviarCabeceraDetalleDocumentos",new MareBusinessID("INTEnviarCabeceraDetalleDocumentos"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        //Se quita por cambio FAC-001
        //Autor jpbosnjak
        /*UtilidadesLog.debug("Encolamos enviarDatosImpresionGuias");
        dtoBatch = new DTOBatch ("enviarDatosImpresionGuias",new MareBusinessID("INTEnviarDatosImpresionGuias"),dto);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }*/
        
        //return newDTOSalidaBatch( 0, "enviarInterfaces Larissa procesado" )
        UtilidadesLog.info("MONLARBean.enviarInterfaces(DTOINTCargaInicialLarissa dto): Salida");
        return new DTOSalidaBatch( 0, "enviarInterfaces Larissa procesado" );
	}

    public DTOColeccion cargaInicial(DTOBelcorp dtoe) throws MareException
    {
        UtilidadesLog.info("MONLARBean.cargaInicial(DTOBelcorp dtoe): Entrada");
		DAOINTLAR dao = new DAOINTLAR();
        DTOColeccion dtoSalida = dao.obtenerInterfacesParametrizadas(dtoe.getOidIdioma());
        UtilidadesLog.info("MONLARBean.cargaInicial(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }    
	
    
    /**
     * Creado por incidencia 21887
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @author dmorello
     * @date 07/06/2006
     */
 /*     public void generarDocumento(DTOINTCargaInicialLarissa dtoe) throws MareException {    
        UtilidadesLog.info("MONLARBean.generarDocumento(DTOINTCargaInicialLarissa dtoe): Entrada");
        Cronometrador.startTransaction("MONLARBean.generarDocumento");
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerDocumento");
        ArrayList listaDocumentos = dao.obtenerDocumento(dtoe.getPeriodo(),dtoe.getOidPais());
        Cronometrador.endTransaction("dao.obtenerDocumento");
        ArrayList listaCabeceras = new ArrayList();
        ArrayList listaDetalles = (ArrayList)listaDocumentos.clone();
        
        DTOINTDocumento dtoDoc;
        while (! listaDocumentos.isEmpty()) {
            dtoDoc = this.obtenerCabecera(listaDocumentos);
            listaCabeceras.add(dtoDoc);
        }
        
        this.generarCabeceraDocumentos(dtoe,listaCabeceras);
        this.generarDetalleDocumentos(dtoe,listaDetalles);
        
        //MODIFICAOD BELC300024162 pzerbino 18/9/2006
        ArrayList listaOIDs = dao.obtieneCabeceras(dtoe.getPeriodo());        
        if (!listaOIDs.isEmpty()){
            dao.actualizarCabecerasDocumento(listaOIDs);
        }

        Cronometrador.endTransaction("MONLARBean.generarDocumento");
        UtilidadesLog.info("MONLARBean.generarDocumento(DTOINTCargaInicialLarissa dtoe): Salida");
    }*/

    /**
     * CHANGELOG
     * ---------
     * 14/05/2009 - dmorello, Cambio 20090891
     *    - Se obtiene por separado la info de cabeceras y detalles a enviar en la interfaz
     */
    public void generarDocumento(DTOINTCargaInicialLarissa dtoe) throws MareException {    
        UtilidadesLog.info("MONLARBean.generarDocumento(DTOINTCargaInicialLarissa dtoe): Entrada");
        Cronometrador.startTransaction("MONLARBean.generarDocumento");
        
        DAOINTLAR dao = new DAOINTLAR();

        RecordSet rsCabeceras = dao.obtenerCabecerasDocumentosLAR7(dtoe.getPeriodo());
        this.generarCabeceraDocumentos(dtoe, rsCabeceras);
        rsCabeceras = null;
        
        RecordSet rsDetalles = dao.obtenerDetallesDocumentosLAR7(dtoe.getPeriodo());
        this.generarDetalleDocumentos(dtoe, rsDetalles);
        rsDetalles = null;
        
        this.actualizarCabecerasDocumento(dtoe.getPeriodo());
        
        Cronometrador.endTransaction("MONLARBean.generarDocumento");
        UtilidadesLog.info("MONLARBean.generarDocumento(DTOINTCargaInicialLarissa dtoe): Salida");
    }

    /**
     * Creado por incidencia 21887
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param listaDocs
     * @author dmorello
     * @date 07/06/2006
     */
    public DTOINTDocumento obtenerCabecera(ArrayList listaDocs) throws MareException {
        UtilidadesLog.info("MONLARBean.obtenerCabecera(ArrayList listaDocs): Entrada");
        Cronometrador.startTransaction("MONLARBean.obtenerCabecera");
        
        /*
         * Recorremos la listaDocs y guardamos en una segunda lista, listaCabe,
         * todos los elementos con igual número de pedido.
         * Eliminamos de listaDocs todos los objetos que ahora están en listaCabe
         */
         
        ArrayList listaCabe = new ArrayList();
        
        // Tomaremos el nº de pedido del primer elemento
        // Por lo tanto, corresponde agregarlo a listaCabe (y quitarlo de listaDocs)
        String numeroPedido = ((DTOINTDocumento)listaDocs.get(0)).getNumeroPedido();
        listaCabe.add(listaDocs.get(0));
        listaDocs.remove(listaDocs.get(0));

        for (int i = 0; i < listaDocs.size(); ) {
            DTOINTDocumento dtoDoc = (DTOINTDocumento)listaDocs.get(i);
            
            // Vamos haciendo la eliminación a medida que recorremos la lista
            if (dtoDoc.getNumeroPedido().equals(numeroPedido)) {
                listaCabe.add(dtoDoc);
                listaDocs.remove(dtoDoc);
            } else {
                // Si no coincide el número, paso al siguiente elemento
                i++;
            }
        }
        
        DTOINTDocumento cabecera = new DTOINTDocumento();
        int totalUnidades = 0;
        int size = listaCabe.size();
        for (int i = 0; i < size; i++) {
            DTOINTDocumento dtoDoc = (DTOINTDocumento)listaCabe.get(i);
            totalUnidades += dtoDoc.getTotalUnidadesPedido().intValue();
        }
        //MODIFICADO BELC300024162 pzerbino 18/9/2006
        cabecera = (DTOINTDocumento) listaCabe.get(0);
        
        cabecera.setTotalUnidadesPedido(new Integer(totalUnidades));
        cabecera.setTotalItemsPedido(new Integer(size));
        
        UtilidadesLog.info("MONLARBean.obtenerCabecera(ArrayList listaDocs): Salida");
        Cronometrador.endTransaction("MONLARBean.obtenerCabecera");
        return cabecera;
    }
    
	private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONLARBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONMantenimientoSEG",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        UtilidadesLog.info("MONLARBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinesFacadeBATCH");
    }


    private HashMap obtenerDocumento(Long periodo, Long pais) throws MareException {    
        UtilidadesLog.info("MONLARBean.obtenerDocumento(Long periodo): Entrada");
        long comienzo = System.currentTimeMillis();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append("     SOC2.OID_SOLI_CABE OIDCABECERA, ");
        
        query.append("     emp.cod_soci codigoempresa, soc2.val_nume_soli numeropedido, ");
        query.append("     cli.cod_clie codigocliente, soc.fec_fact fechapedido, ");
        query.append("     rev.cod_indi_revi indicadorpedidoachequear, ");
        //query.append("     sop.num_unid_dema totalunidadespedido, ");
        query.append("     DECODE (td.cod_tipo_desp, 'EX', 1, 0) indicadorpedidoexpress, ");
        query.append("     pro.cod_sap codigoitem, sop.num_unid_aten unidadesporatender, ");
        query.append("     pro.cod_ind_dent_caja indicadordentrofueracaja, ");
        query.append("     clas.cod_clas_soli clasesolicitud, ");
        query.append("     ts.cod_tipo_soli codigotiposolicitud, ");
        query.append(" 		 sum (sop.num_unid_aten) over (partition by soc2.val_nume_soli order by 1) totalunixpedido, ");
        query.append("     count (sop.OID_SOLI_POSI) over (partition by soc2.val_nume_soli order by 1) totalitemxpedido ");
        query.append(" FROM ");
        query.append("     ped_solic_posic sop, ");
        query.append("     ped_solic_cabec soc, ");
        query.append("     ped_solic_cabec soc2, ");
        query.append("     mae_clien cli, ");
        query.append("     ped_indic_revis rev, ");
        query.append("     ped_clase_solic clas, ");
        query.append("     ped_tipo_despa td, ");
        query.append("     seg_socie emp, ");
        query.append("     ped_tipo_solic_pais tsp, ");
        query.append("     mae_produ pro, ");
        query.append("     ped_tipo_solic ts, ");
        //MODIFCICADO BELC300024162 pzerbino 18/9/2006
        query.append("     INT_LAR_TIPO_SOLICI_PEDIDO_DIS TSPD ");
        
        query.append(" WHERE soc2.clso_oid_clas_soli = clas.oid_clas_soli ");
        query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
        query.append("   AND soc2.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("   AND soc2.soci_oid_soci = emp.oid_soci ");
        query.append("   AND td.oid_tipo_desp = soc.tids_oid_tipo_desp ");
        //Gacevedo 29/12/2006. El indicador debe tomarse del consolidado
        //segun incidencia V-INTLAR-001.
        query.append("   AND soc2.inre_oid_indi_revi = rev.oid_indi_revi(+) ");
        query.append("   AND soc.clie_oid_clie = cli.oid_clie ");
        query.append("   AND sop.soca_oid_soli_cabe = soc.oid_soli_cabe ");
        query.append("   AND soc.soca_oid_soli_cabe = soc2.oid_soli_cabe ");
        query.append("   AND soc2.perd_oid_peri = " + periodo);
        query.append("   AND soc2.ind_inte_lari_gene = 0 ");
        query.append("   AND soc2.fec_fact IS NOT NULL ");
        query.append("   AND soc2.ind_ts_no_conso = 0 ");
        query.append("   AND (soc2.ind_pedi_prue = 0 OR SOC2.IND_PEDI_PRUE IS NULL)");
        query.append("   AND sop.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        query.append("   AND sop.prod_oid_prod = pro.oid_prod ");
        //MODIFCICADO BELC300024162 pzerbino 18/9/2006
        query.append("   AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSPD.TSPA_OID_TIPO_SOLI_PAIS ");
        query.append("    AND SOC2.PAIS_OID_PAIS = " + pais);  
         query.append("    AND sop.num_unid_aten > 0 ");
        query.append(" ORDER BY soc2.val_nume_soli ");

        
        rs = this.executeQuery(query.toString());
        UtilidadesLog.warn("QUERY: "+(System.currentTimeMillis()-comienzo));
        UtilidadesLog.debug("rs: " + rs);
        
        int size = rs.getRowCount();
        HashMap hashDocumentos = new HashMap();
        comienzo = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            
            Object numPed = rs.getValueAt(i,"NUMEROPEDIDO");
            
            if (hashDocumentos.containsKey(numPed.toString())) {
                 DTOINTCabeceraDocumento dtoDocumentos = (DTOINTCabeceraDocumento)hashDocumentos.get(numPed.toString());  
                 ArrayList arrayPosiciones = (ArrayList)dtoDocumentos.getListaPosiciones();
                 
                 DTOINTPosicionesDocumento dtoPosicionDocumento = new DTOINTPosicionesDocumento();
                 
                 dtoPosicionDocumento.setCodigoItem((String)rs.getValueAt(i,"CODIGOITEM"));
                 Object unidPorAt = rs.getValueAt(i,"UNIDADESPORATENDER");
                 dtoPosicionDocumento.setUnidadesPorAtender((unidPorAt != null)? unidPorAt.toString() : null);
                 dtoPosicionDocumento.setIndicadorDentroFueraCaja((String)rs.getValueAt(i,"INDICADORDENTROFUERACAJA"));
                 arrayPosiciones.add(dtoPosicionDocumento);  
                 dtoDocumentos.setListaPosiciones(arrayPosiciones);
                 hashDocumentos.put(numPed.toString(), dtoDocumentos);
            } else {
                 DTOINTCabeceraDocumento dtoDocumentos = new DTOINTCabeceraDocumento();
                 dtoDocumentos.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGOEMPRESA"));           
                 dtoDocumentos.setNumeroPedido((numPed != null)? numPed.toString() : null);
                 dtoDocumentos.setCodigoCliente((String)rs.getValueAt(i,"CODIGOCLIENTE"));
                 java.util.Date fechaPed = (Date)rs.getValueAt(i,"FECHAPEDIDO");
                 dtoDocumentos.setFechaPedido((fechaPed != null)? new java.util.Date(fechaPed.getTime()) : null);
                 dtoDocumentos.setIndicadorPedidoAChequear((String)rs.getValueAt(i,"INDICADORPEDIDOACHEQUEAR"));
                 BigDecimal totalUniPed = (BigDecimal)rs.getValueAt(i,"TOTALUNIXPEDIDO");
                 Integer totUni = (totalUniPed != null)? new Integer(totalUniPed.intValue()) : null;
                 dtoDocumentos.setTotalUnidadesPedido(totUni);
                 BigDecimal totalItemsPed = (BigDecimal)rs.getValueAt(i,"TOTALITEMXPEDIDO");
                 Integer totItem = (totalItemsPed != null)? new Integer(totalItemsPed.intValue()) : null;
                 dtoDocumentos.setTotalItemsPedido(totItem);                 
                 Object indPedExp = rs.getValueAt(i,"INDICADORPEDIDOEXPRESS");
                 dtoDocumentos.setIndicadorPedidoExpress(indPedExp != null? indPedExp.toString() : null);
                 
                 dtoDocumentos.setClaseSolicitud((String)rs.getValueAt(i,"CLASESOLICITUD"));
                 dtoDocumentos.setTipoSolicitud((String)rs.getValueAt(i,"CODIGOTIPOSOLICITUD"));

                 ArrayList arrayPosiciones = new ArrayList();
                 
                 DTOINTPosicionesDocumento dtoPosicionDocumento = new DTOINTPosicionesDocumento();
                 
                 dtoPosicionDocumento.setCodigoItem((String)rs.getValueAt(i,"CODIGOITEM"));
                 Object unidPorAt = rs.getValueAt(i,"UNIDADESPORATENDER");
                 dtoPosicionDocumento.setUnidadesPorAtender((unidPorAt != null)? unidPorAt.toString() : null);
                 dtoPosicionDocumento.setIndicadorDentroFueraCaja((String)rs.getValueAt(i,"INDICADORDENTROFUERACAJA"));
                 arrayPosiciones.add(dtoPosicionDocumento); 
                 dtoDocumentos.setListaPosiciones(arrayPosiciones);
                 hashDocumentos.put(numPed.toString(), dtoDocumentos);                  
            }
        }
        UtilidadesLog.warn("ARMADO HASH: "+(System.currentTimeMillis()-comienzo));
                
        UtilidadesLog.info("MONLARBean.obtenerDocumento(Long periodo): Salida");
        return hashDocumentos;
    }
     
   private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONCuentasCorrientesPerfBean.executeQuery(String query): Salida");  
    return rs;
  } 
   
  /**
   * CHANGELOG
   * ---------
   * 14/05/2009 - dmorello, Cambio 20090891 - Cambio tipo de parametro de HashMap a RecordSet
   */
  private void generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, RecordSet rsDocumentos) throws MareException{
        UtilidadesLog.info("MONLARBean.generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, HashMap hashDocumentos): Entrada");
        long comienzo = System.currentTimeMillis();
		
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR7C, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();        
        
        //Iterator it = (Iterator)((Collection)hashDocumentos.values()).iterator();
        int size = rsDocumentos.getRowCount();
        
        //while (it.hasNext()){
        for (int i = 0; i < size; i++) {
            
            String codigoEmpresa = rsDocumentos.getValueAt(i, "CODIGOEMPRESA").toString();
            String numeroPedido = rsDocumentos.getValueAt(i, "NUMEROPEDIDO").toString();
            String codigoCliente = rsDocumentos.getValueAt(i, "CODIGOCLIENTE").toString();
            java.util.Date fechaPedido = (java.util.Date)rsDocumentos.getValueAt(i, "FECHAPEDIDO");
            String indPedidoAChequear = (String)rsDocumentos.getValueAt(i, "INDICADORPEDIDOACHEQUEAR");
            Integer totalItemsPedido = new Integer(((BigDecimal)rsDocumentos.getValueAt(i, "TOTALITEMXPEDIDO")).intValue());
            Integer totalUnidadesPedido = new Integer(((BigDecimal)rsDocumentos.getValueAt(i, "TOTALUNIXPEDIDO")).intValue());
            String indPedidoExpress = rsDocumentos.getValueAt(i, "INDICADORPEDIDOEXPRESS").toString();
            String claseSolicitud = (String)rsDocumentos.getValueAt(i, "CLASESOLICITUD");
            String tipoSolicitud = (String)rsDocumentos.getValueAt(i, "CODIGOTIPOSOLICITUD");
            
            try{
                //Modificado por incidencia 14391
                registro.anyadirCampo(ILarissa.LAR7_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR7_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR7_TIPO_PERIODO,dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_EMPRESA,codigoEmpresa);
                registro.anyadirCampo(ILarissa.LAR7_NUMERO_PEDIDO,numeroPedido);
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_CLIENTE,codigoCliente);
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PEDIDO,fechaPedido);//Añadido posterior por 14391
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_PEDIDO_A_CHEQUEAR,indPedidoAChequear);
                registro.anyadirCampo(ILarissa.LAR7_TOTAL_ITEMS_POR_PEDIDO,totalItemsPedido);
                registro.anyadirCampo(ILarissa.LAR7_TOTAL_UNIDADES_POR_PEDIDO,totalUnidadesPedido);
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_PEDIDO_EXPRESS,indPedidoExpress);
                // Los siguientes dos campos ya venian en null, por lo cual se seteara asi
                registro.anyadirCampo(ILarissa.LAR7_FECHA_CITA,null);
                registro.anyadirCampo(ILarissa.LAR7_HORA_CITA,null);
                registro.anyadirCampo(ILarissa.LAR7_CLASE_SOLICITUD,claseSolicitud);
                registro.anyadirCampo(ILarissa.LAR7_TIPO_SOLICITUD, tipoSolicitud);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }
            
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }          
            registro.vaciar();        
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.warn("MONLARBean.generarCabeceraDocumentos: "+(System.currentTimeMillis()-comienzo));
        UtilidadesLog.info("MONLARBean.generarCabeceraDocumentos(DTOINTCargaInicialLarissa dtoL, HashMap hashDocumentos): Salida");
    } 
    
    /**
     * CHANGELOG
     * ---------
     * 14/05/2009 - dmorello, Cambio 20090891 - Cambio tipo de parametro de HashMap a RecordSet
     */
    private void generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, RecordSet rsDetalles) throws MareException{
        UtilidadesLog.info("MONLARBean.generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, HashMap hashDocumentos): Entrada");		
        long comienzo = System.currentTimeMillis();
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR7D, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            //return new DTOSalidaBatch(0,"Interfaz LAR-7D procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        
        int size = rsDetalles.getRowCount();
        
        for (int i = 0; i < size; i++) {
              
              String codigoEmpresa = rsDetalles.getValueAt(i, "CODIGOEMPRESA").toString();
              String numeroPedido = rsDetalles.getValueAt(i, "NUMEROPEDIDO").toString();
              String codigoItem = (String)rsDetalles.getValueAt(i, "CODIGOITEM");
              Object unidadesPorAtender = rsDetalles.getValueAt(i, "UNIDADESPORATENDER");
              String indDentroFueraCaja = (String)rsDetalles.getValueAt(i, "INDICADORDENTROFUERACAJA");
              String claseSolicitud = (String)rsDetalles.getValueAt(i, "CLASESOLICITUD");
              String tipoSolicitud = (String)rsDetalles.getValueAt(i, "CODIGOTIPOSOLICITUD");
              
              try{              
                registro.anyadirCampo(ILarissa.LAR7_COMPANIA,ConstantesINT.CODIGO_COMPANIA_PERU);
                registro.anyadirCampo(ILarissa.LAR7_FECHA_PROCESO,new Date(System.currentTimeMillis()));
                registro.anyadirCampo(ILarissa.LAR7_LOTE_ENVIO_DIA,new Long(dtoL.getNumeroLote()));
                registro.anyadirCampo(ILarissa.LAR7_TIPO_PERIODO, dtoL.getCodigoTipoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_PERIODO,dtoL.getCodigoPeriodo());
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_EMPRESA,codigoEmpresa);
                registro.anyadirCampo(ILarissa.LAR7_NUMERO_PEDIDO,numeroPedido);
                registro.anyadirCampo(ILarissa.LAR7_CODIGO_ITEM,codigoItem);
                if(unidadesPorAtender!=null){                
                    registro.anyadirCampo(ILarissa.LAR7_UNIDADES_POR_ATENDER,new Integer(((BigDecimal)unidadesPorAtender).intValue()));
                }else{                
                    registro.anyadirCampo(ILarissa.LAR7_UNIDADES_POR_ATENDER,null);
                }                
                registro.anyadirCampo(ILarissa.LAR7_INDICADOR_DENTRO_FUERA_CAJA,indDentroFueraCaja);
                registro.anyadirCampo(ILarissa.LAR7_CLASE_SOLICITUD,claseSolicitud);
                registro.anyadirCampo(ILarissa.LAR7_TIPO_SOLICITUD,tipoSolicitud);
                
              }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
              }
            
              //se añade el registro al fichero de la interfaz
              try{	
                  gi.anyadirRegistro(info,registro);
              }catch(InterfacesException ie) {
                  UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
              }catch(RemoteException ne){				
                  UtilidadesLog.error("error RemoteException",ne);
                  throw new MareException(ne,
                        UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }
              
              registro.vaciar();
        }    
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.warn("MONLARBean.generarDetalleDocumentos: "+(System.currentTimeMillis()-comienzo));
        UtilidadesLog.info("MONLARBean.generarDetalleDocumentos(DTOINTCargaInicialLarissa dtoL, HashMap hashDocumentos): Salida");
	}

	private void actualizarCabecerasDocumento (Long periodo) throws MareException {
		UtilidadesLog.info("DAOINTLAR.actualizarCabecerasDocumento(ArrayList listaOIDs): Entrada");
        long comienzo = System.currentTimeMillis();
		StringBuffer consulta = new StringBuffer();
    
		consulta.append("UPDATE PED_SOLIC_CABEC ");
		consulta.append("SET IND_INTE_LARI_GENE = 1 ");
        consulta.append("WHERE OID_SOLI_CABE IN (");
		consulta.append(" SELECT SOC.OID_SOLI_CABE OIDCABECERA ");
		consulta.append(" FROM PED_SOLIC_CABEC SOC, SEG_SOCIE EMP,  ");
        consulta.append(" FAC_TIPO_DOCUM DOC, PED_CLASE_SOLIC CLAS,  ");
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS, ");
        consulta.append(" FAC_DOCUM_CONTA_CABEC DOCC ");
        consulta.append(" WHERE SOC.SOCI_OID_SOCI = EMP.OID_SOCI(+) ");
        consulta.append(" AND DOCC.SOCA_OID_SOLI_CABE(+) = SOC.OID_SOLI_CABE ");
        consulta.append(" AND SOC.TIDO_OID_TIPO_DOCU = DOC.OID_TIPO_DOCU(+) ");
        consulta.append(" AND SOC.CLSO_OID_CLAS_SOLI = CLAS.OID_CLAS_SOLI(+) ");
        consulta.append(" AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS(+) ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND SOC.IND_TS_NO_CONSO = 0 "); 
        consulta.append(" AND (SOC.IND_PEDI_PRUE = 0 OR SOC.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOC.PERD_OID_PERI = " + periodo);        
        consulta.append(" AND SOC.IND_INTE_LARI_GENE = 0 )");
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try{
              bs.dbService.executeUpdate(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        UtilidadesLog.warn("DAOINTLAR.actualizarCabecerasDocumento: "+(System.currentTimeMillis()-comienzo));
        UtilidadesLog.info("DAOINTLAR.actualizarCabecerasDocumento(ArrayList listaOIDs): Salida");
    }

    //Agregado por Sapaza, fecha 29-04-2008, Nueva Interface LAR-9
    public DTOSalidaBatch enviarSecuenciaPedidos(DTOBatch dto) throws MareException {
        UtilidadesLog.info("MONLARBean.enviarSecuenciaPedidos(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarSecuenciaPedidos");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerSecuenciaPedidos");
        ArrayList listaSecuenciaPedidos = dao.obtenerSecuenciaPedidos(dtoL.getPeriodo());
        Cronometrador.endTransaction("dao.obtenerSecuenciaPedidos");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR9, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-9 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTSecuenciaPedido dtoSecuenciaPedido = null;
        int i = listaSecuenciaPedidos.size();
        int contador=0;
        if (listaSecuenciaPedidos == null || listaSecuenciaPedidos.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR9" );
        }		
        
        while(contador < i){
            dtoSecuenciaPedido = (DTOINTSecuenciaPedido)listaSecuenciaPedidos.get(contador);
            
            try{              
                registro.anyadirCampo(ILarissa.LAR9_CODIGO_ZONA, dtoSecuenciaPedido.getCodigoZona());
                registro.anyadirCampo(ILarissa.LAR9_RUTA, dtoSecuenciaPedido.getRuta());
                registro.anyadirCampo(ILarissa.LAR9_CODIGO_TERRITORIO, dtoSecuenciaPedido.getCodigoTerritorio());
                registro.anyadirCampo(ILarissa.LAR9_NUMERO_PEDIDO, dtoSecuenciaPedido.getNumeroPedido());
                registro.anyadirCampo(ILarissa.LAR9_SECUENCIA_TERRITORIO, dtoSecuenciaPedido.getSecuenciaTerritorio());
                registro.anyadirCampo(ILarissa.LAR9_INDICADOR_PEDIDO_SERVICIO, dtoSecuenciaPedido.getIndicadorPedidoServicio());
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }            

            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONLARBean.enviarSecuenciaPedidos(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarSecuenciaPedidos");
        
        return new DTOSalidaBatch(0,"Interfaz LAR-9 procesada");
    }

    //Agregado por Sapaza, fecha 29-04-2008, Nueva Interface LAR-10
    public DTOSalidaBatch enviarDocumentoIdentidadClientes(DTOBatch dto) throws MareException {
        UtilidadesLog.info("MONLARBean.enviarDocumentoIdentidadClientes(DTOBatch dto): Entrada");
        Cronometrador.startTransaction("MONLARBean.enviarDocumentoIdentidadClientes");
        DTOINTCargaInicialLarissa dtoL = (DTOINTCargaInicialLarissa)dto.getDTOOnline();
        
        DAOINTLAR dao = new DAOINTLAR();
        Cronometrador.startTransaction("dao.obtenerDocumentoIdentidadClientes");
        ArrayList listaIdentidadesClientes = dao.obtenerDocumentoIdentidadClientes(dtoL.getOidPais(), dtoL.getPeriodo());
        Cronometrador.endTransaction("dao.obtenerDocumentoIdentidadClientes");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_LAR10, dtoL.getNumeroLote(), dtoL.getOidPais());
        info.setObservaciones(dtoL.getObservaciones());
        info.setDescripcionLote(dtoL.getDescripcionLote());
        
        try{
            InterfazInfo interfaz = gi.crearInterfaz(info);
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            return new DTOSalidaBatch(0,"Interfaz LAR-10 procesada con error");
        }catch(RemoteException ne){            
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        RegistroSicc registro = new RegistroSicc();
        DTOINTDocumentoIdendidad dtoIdentidadCliente = null;
        int i = listaIdentidadesClientes.size();
        int contador=0;
        if (listaIdentidadesClientes == null || listaIdentidadesClientes.size() == 0){
            return new DTOSalidaBatch( 0, "No hay datos para generar la interfaz LAR10" );
        }		

        while(contador < i){
            dtoIdentidadCliente = (DTOINTDocumentoIdendidad)listaIdentidadesClientes.get(contador);
            
            try{              
                registro.anyadirCampo(ILarissa.LAR10_CODIGO_CLIENTE, dtoIdentidadCliente.getCodigoCliente());
                registro.anyadirCampo(ILarissa.LAR10_NUMERO_DOCUMENTO_IDENTIDAD, dtoIdentidadCliente.getNumeroDocumentoIdentidad());
                registro.anyadirCampo(ILarissa.LAR10_CODIGO_UNIDAD_GEOGRAFICA1, dtoIdentidadCliente.getCodigoUnidadGeografica1());
                registro.anyadirCampo(ILarissa.LAR10_CODIGO_UNIDAD_GEOGRAFICA2, dtoIdentidadCliente.getCodigoUnidadGeografica2());
                registro.anyadirCampo(ILarissa.LAR10_CODIGO_UNIDAD_GEOGRAFICA3, dtoIdentidadCliente.getCodigoUnidadGeografica3());
                registro.anyadirCampo(ILarissa.LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA1, dtoIdentidadCliente.getDescripcionUnidadGeografica1());
                registro.anyadirCampo(ILarissa.LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA2, dtoIdentidadCliente.getDescripcionUnidadGeografica2());
                registro.anyadirCampo(ILarissa.LAR10_DESCRIPCION_UNIDAD_GEOGRAFICA3, dtoIdentidadCliente.getDescripcionUnidadGeografica3());
                registro.anyadirCampo(ILarissa.LAR10_TELEFONO, dtoIdentidadCliente.getTelefono());
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
                continue;
            }            

            //se añade el registro al fichero de la interfaz
            try{	
                gi.anyadirRegistro(info,registro);
            }catch(InterfacesException ie) {
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            }catch(RemoteException ne){				
                UtilidadesLog.error("error RemoteException",ne);
                throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
            registro.vaciar();
            contador++;
        }
        
        try{
            gi.enviarInterfaz(info);	
        }catch(InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
        }catch(RemoteException ne){			
            UtilidadesLog.error("error RemoteException",ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONLARBean.enviarDocumentoIdentidadClientes(DTOBatch dto): Salida");
        Cronometrador.endTransaction("MONLARBean.enviarDocumentoIdentidadClientes");
        
        return new DTOSalidaBatch(0,"Interfaz LAR-10 procesada");
    }
    
    private PeriodoLocalHome getPeriodoLocalHome() {
            return new PeriodoLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
            return new PeriodoCorporativoLocalHome();
    }

    private TipoPeriodoCorporativoLocalHome getTipoPeriodoCorporativoLocalHome() {
            return new TipoPeriodoCorporativoLocalHome();
    }

    

}
