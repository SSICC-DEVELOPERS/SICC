/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.print.SpoolManager;
import es.indra.sicc.cmn.negocio.print.SpoolManagerHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.app.DTOSolicCabecSecu;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraSalida;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosSalida;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACListaConsolidados;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.fac.DTOFACSecuenciaProcesos;
import es.indra.sicc.dtos.fac.DTOFACValoresDefecto;
import es.indra.sicc.dtos.fac.DTOImpuestosGenerales;
import es.indra.sicc.dtos.fac.DTOIndicadoresImpuestos;
import es.indra.sicc.dtos.fac.DTOTiposSolicitudPais;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.ped.SolicitudAcumuladoImpuestosLocal;
import es.indra.sicc.entidades.ped.SolicitudAcumuladoImpuestosLocalHome;
import es.indra.sicc.logicanegocio.app.MONSecuYMarcasChequeoLocal;
import es.indra.sicc.logicanegocio.app.MONSecuYMarcasChequeoLocalHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAODocuContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACVisualizarDoc;
import es.indra.sicc.logicanegocio.mae.DAOMAEProductos;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.ped.MegaProcesadorGPs;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamos;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoLocalHome;

import es.indra.sicc.util.UtilidadesBD;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONProcesosFacturacionBean implements SessionBean  {

	private SessionContext ctx;
	private Boolean indicadorImpuestosIncluidos;             
	private Long moneda;                            
	private Integer numeroDecimalesRedondeo;        
	private Long indicadorImpuestos;                
	private Boolean indicadorTasaUnica;             
	private Float tasaImpuesto;   
    /* Agregado por FAC-002 ------ AL */  
    private	Long indicadorImpuestosAnterior;                
    private	Float tasaImpuestoAnterior;                     
    private Float tasaImpuestoFleteAnterior;                     
    /* Agregado por FAC-002 ------ AL */  

    private UtilidadesLog log = new UtilidadesLog();

	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
				this.ctx = ctx;	
	}

/*Cambio de nombre en las variables: 
	 * 
	 * 			DT 								CONSTRUCCI�N
	 *  _____________________________________________________________
	 * 		listaConsolidados				dtoListaConsolidados (parametro del m�todo)
	 *      listaConsolidados				listaConsolidados (lista contenida en dtoListaConsolidados)
	 *      dtoContenedor					dtoConsolidado
	 *      dtoConsolidado					dtoCabeceraConsolidado
	 *      dtoSolicitud					dtoCabeceraSolicitud
	 */	

	public ArrayList procesar(DTOFACListaConsolidados dtoListaConsolidados) throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.procesar(DTOFACListaConsolidados dtoListaConsolidados): Entrada");
        int longitud2 = 0; //longitud listaSolicitudes
        int j = 0;

        /* Modificado por FAC-002 ------ AL */  
      	this.indicadorImpuestosAnterior = null;                
    	this.tasaImpuestoAnterior = null;                     
        this.tasaImpuestoFleteAnterior = null;                     
        /* Modificado por FAC-002 ------ AL */  

        DTOFACConsolidado dtoConsolidado = null;
        DTOFACCabeceraSolicitud dtoCabeceraConsolidado = null;
        DTOFACCabeceraSolicitud solicitudTrabajo = null;
        DTOFACCabeceraSolicitud dtoCabeceraSolicitud = null;
        DTOImpuestosGenerales dtoIG = null;
        DTOFACCabeceraSolicitud solicitudTemp = null;
        DTOFACValoresDefecto dtoValores = null;
        DTONumeroSolicitud dtoNS = null;
        DTOFACCalculosImpuestosEntrada dtoCie = null;
        DTOFACCalculosImpuestosSalida dtoCis = null;
        DTOFACCalculosCabeceraEntrada dtoCce = null;
        DTOFACCalculosCabeceraSalida dtoCcs = null;
		
        ArrayList listaConsolidados = null;
        ArrayList secuenciaProcesos = new ArrayList();
        ArrayList listaSolicitudes = null;
        ArrayList listaOIDs = null; 
		
        Boolean indicadorEstadisticable = null;
        Boolean indicadorGeneraCC = null;
        BigDecimal tipoCambio = null;
        StringBuffer temp = null;
        Long indicadorImpuestosFlete = null;
        Long numeroConsolidado = null;
        Long oidPais = null;
        Long oidIdioma = null;
		    
        DAOProcesos daoProcesos = new DAOProcesos();

        listaConsolidados = dtoListaConsolidados.getListaConsolidados();
        this.numeroDecimalesRedondeo = ((DTOFACConsolidado) listaConsolidados.get(0)).getDtoCabecera().getNumeroDecimalesRedondeo();
        if (this.numeroDecimalesRedondeo == null) {
            this.numeroDecimalesRedondeo = new Integer(2);
        }

        oidPais = ((DTOFACConsolidado) listaConsolidados.get(0)).getDtoCabecera().getOidPais();
        oidIdioma = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
        
        //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
        ProcesoFacturacionHelper helper = ProcesoFacturacionHelper.getInstance(oidPais, oidIdioma);

        Long modulo = new Long(ConstantesSEG.MODULO_REC);
        //*** INICIO DEL BUCLE DE CONSOLIDADOS ***

        ArrayList arrayOidsCabecera = new ArrayList();        
        int lcM = listaConsolidados.size();
        HashMap hashPosiciones = new HashMap();
        
        for(int i=0;i<lcM;i++) {
            dtoConsolidado = (DTOFACConsolidado) listaConsolidados.get(i);
            listaSolicitudes = dtoConsolidado.getListaSolicitudes();
            int lsM= listaSolicitudes.size();
            for (j = 0; j<lsM;j++){
              dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud) listaSolicitudes.get(j);
              
              //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
              //arrayOidsCabecera.add(dtoCabeceraSolicitud.getOidCabeceraSolicitud());    
              HashMap hashPosicionesAux =  this.obtenerPosicionesCabeceras(dtoCabeceraSolicitud.getOidCabeceraSolicitud(), oidIdioma);
              hashPosiciones.putAll(hashPosicionesAux);
            }
        }    
        
        //HashMap hashPosiciones = new HashMap();
        //hashPosiciones =  this.obtenerPosicionesCabeceras(arrayOidsCabecera, oidIdioma);
        
        this.indicadorImpuestosIncluidos = ((DTOFACConsolidado)listaConsolidados.get(0)).getIndicadorImpuestosIncluidos();
        
        arrayOidsCabecera.clear();
        
        int lstCM = listaConsolidados.size();
        for(int i=0;i<lstCM;i++) {            
            dtoConsolidado = (DTOFACConsolidado) listaConsolidados.get(i);
            dtoCabeceraConsolidado = dtoConsolidado.getDtoCabecera();
            listaSolicitudes = dtoConsolidado.getListaSolicitudes();
            ArrayList listaPosiciones = new ArrayList();
          
            longitud2 = 0;

            if (listaSolicitudes != null) {
                longitud2 = listaSolicitudes.size();
            }
            j = 0;

            while ((j < longitud2) ) {
                solicitudTrabajo = (DTOFACCabeceraSolicitud) listaSolicitudes.get(j);
                if (solicitudTrabajo.getIndicadorOrdenCompra().booleanValue() == true) {
                    break;
                }
                ++j;
            }

            if(dtoCabeceraConsolidado.getMoneda()!=null){
              if(dtoCabeceraConsolidado.getMoneda().longValue() == 0){ 
                this.moneda = null;
                dtoCabeceraConsolidado.setMoneda(null);
              }else{
            	   this.moneda = dtoCabeceraConsolidado.getMoneda();              }   
            }else{
              this.moneda = null;
            }

            if (this.moneda != null) {
              tipoCambio = dtoCabeceraConsolidado.getTipoCambio();
            } else {
              tipoCambio = null;
            }
            
            DTOTiposSolicitudPais tipoSolicitudTemp = (DTOTiposSolicitudPais)helper.getTipoSolicitud().get(dtoCabeceraConsolidado.getTipoSolicitud());
            dtoCabeceraConsolidado.setAcceso(tipoSolicitudTemp.getAcceso());
            
            if (tipoSolicitudTemp.getSubacceso() == null) {
                if(tipoSolicitudTemp.getCodAcceso().equals(ConstantesSEG.ACCESO_BELCENTER)){
                    dtoCabeceraConsolidado.setSubacceso(solicitudTrabajo.getSubacceso());
                }else{
                    UtilidadesLog.error("*** El tipo de solicitud consolidado "+dtoCabeceraConsolidado.getTipoSolicitud() +" no tiene parametrizado el subacceso ***");
                    UtilidadesLog.error("*** Se termina la ejecucion ***");
                    ctx.setRollbackOnly();
                    return null;
                }
            } else {
                dtoCabeceraConsolidado.setSubacceso(tipoSolicitudTemp.getSubacceso());
            }

            if (solicitudTrabajo != null) {
              dtoCabeceraConsolidado.setFechaPrevistaFacturacion(solicitudTrabajo.getFechaPrevistaFacturacion());
            }

            //6. obtener lista de oids correspondientes a las cabeceras del consolidado
            //y 12. rellenar el atributo observaciones
            listaOIDs = new ArrayList();
            temp = new StringBuffer();
            
            for (int k=0; k < longitud2; k++) {
                dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud) listaSolicitudes.get(k);
                listaOIDs.add(dtoCabeceraSolicitud.getOidCabeceraSolicitud());                
                if(dtoCabeceraSolicitud.getObservaciones() != null)
                    temp.append(dtoCabeceraSolicitud.getObservaciones() + " ");
            }
           
            int oidsMide = listaOIDs.size();
            for (int x=0; x<oidsMide; x++){
                if (hashPosiciones.get(listaOIDs.get(x).toString()) != null){                  
                  listaPosiciones.addAll((ArrayList)hashPosiciones.get(listaOIDs.get(x).toString()));    
                  hashPosiciones.remove(listaOIDs.get(x).toString());
                }                
            }
            
            dtoConsolidado.setListaPosiciones(listaPosiciones);            
            listaOIDs.clear();
            
            if (temp != null) {
                if (temp.length() > 80) {
                    temp.setLength(80);
                }
            }
            dtoCabeceraConsolidado.setObservaciones(temp.toString()); //punto 12 de procesar()
      
            //8. obtener los valores del flete
            solicitudTemp = this.buscarMAXImporteFleteTotalLocal(listaSolicitudes);
      
            if (solicitudTemp != null) {
                dtoCabeceraConsolidado.setIndicadorExentoFlete(solicitudTemp.getIndicadorExentoFlete());
                dtoCabeceraConsolidado.setBaseFleteLocal(solicitudTemp.getBaseFleteLocal());
                dtoCabeceraConsolidado.setImporteFleteLocal(solicitudTemp.getImporteFleteLocal());
                dtoCabeceraConsolidado.setRecargoFleteLocal(solicitudTemp.getRecargoFleteLocal());
                dtoCabeceraConsolidado.setOtrosRecargosLocal(solicitudTemp.getOtrosRecargosLocal());
                dtoCabeceraConsolidado.setTotalFleteLocal(solicitudTemp.getTotalFleteLocal());
                dtoCabeceraConsolidado.setImporteFleteTotalLocal(solicitudTemp.getImporteFleteTotalLocal());
                dtoCabeceraConsolidado.setBaseFleteDocumento(solicitudTemp.getBaseFleteDocumento());
                dtoCabeceraConsolidado.setImporteFleteDocumento(solicitudTemp.getImporteFleteDocumento());
                dtoCabeceraConsolidado.setRecargoFleteDocumento(solicitudTemp.getRecargoFleteDocumento());
                dtoCabeceraConsolidado.setOtrosRecargosDocumento(solicitudTemp.getOtrosRecargosDocumento());
                dtoCabeceraConsolidado.setTotalFleteDocumento(solicitudTemp.getTotalFleteDocumento());
                dtoCabeceraConsolidado.setImporteFleteTotalDocumento(solicitudTemp.getImporteFleteTotalDocumento());
            }
            
            
            //9. c�lculo de los impuestos
            Float tasaImpuestoFlete = null;            
            UtilidadesLog.debug("Buscando TipoSoliPais del Consolidado: " + dtoCabeceraConsolidado.getTipoSolicitud() );
            if (helper.getTiposSoliPaisCCC().containsKey(dtoCabeceraConsolidado.getTipoSolicitud())) {
                DTOIndicadoresImpuestos dtoIndiImpu = (DTOIndicadoresImpuestos)helper.getIndicadoresImpuestosPorCodigo().get( ConstantesFAC.CODIGO_IMPUESTO_EXP );
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("dtoII-EXP: " + dtoIndiImpu);
                    
                this.indicadorImpuestos = dtoIndiImpu.getOidTasaImpuesto();
                this.tasaImpuesto = dtoIndiImpu.getTasaImpuesto();
                this.indicadorTasaUnica = this.longToBoolean(ConstantesFAC.INDICADOR_ACTIVO);
            }
            else    {
                dtoIG = (DTOImpuestosGenerales)helper.getImpuestosGenerales().get(dtoCabeceraConsolidado.getSubacceso()); 
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("dtoIG: " + dtoIG);
                
                if (dtoIG != null) {					
                    indicadorImpuestosFlete = dtoIG.getIndicadorImpuestoFlete(); //9135                
                    UtilidadesLog.debug("indicadorImpuestosFlete: " + indicadorImpuestosFlete);                
                    if(indicadorImpuestosFlete != null) {
                        this.indicadorTasaUnica=dtoIG.getIndicadorTasaUnica();
                        this.indicadorImpuestos=dtoIG.getIndicadorImpuesto();
       
                        if (helper.getIndicadoresImpuestos().get(this.indicadorImpuestos) != null){
                          this.tasaImpuesto = (Float)helper.getIndicadoresImpuestos().get(indicadorImpuestos);
                        }
                        if (helper.getIndicadoresImpuestos().get(indicadorImpuestosFlete) != null){
                          tasaImpuestoFlete = (Float)helper.getIndicadoresImpuestos().get(indicadorImpuestosFlete);
                        }
                    } else {
                        UtilidadesLog.error("TasaImpuestoFlete es igual a NULL ");
                        ctx.setRollbackOnly();
                        throw new MareException("*** No se encontro el indicador de impuestos para la solicitud = "+dtoCabeceraConsolidado.getOidCabeceraSolicitud());
                    }
                    dtoCabeceraConsolidado.setIndicadorImpuestosFlete(dtoIG.getIndicadorImpuestoFlete());
                }else{
                    UtilidadesLog.error("*** No se encontro el indicador de impuestos para la solicitud = "+dtoCabeceraConsolidado.getOidCabeceraSolicitud() );
                    LogAPP.error("FAC-0006 No parametrizado el Indicador de Impuesto de Flete");
                    throw new MareException("*** No se encontro el indicador de impuestos para la solicitud = "+dtoCabeceraConsolidado.getOidCabeceraSolicitud());
                }
            }
            /* Agregado por Brecha PED-006 ------ AL */
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("Tasa de Impuesto antes preguntar Ubigeo " + this.tasaImpuesto);            
                UtilidadesLog.debug("Tasa de Impuesto en el consolidado " + this.tasaImpuesto);              
            }   
            if (dtoCabeceraConsolidado.getTasaImpuestoUbigeo() != null) {
              tasaImpuestoAnterior = this.tasaImpuesto;
              indicadorImpuestosAnterior = this.indicadorImpuestos;
              tasaImpuestoFleteAnterior = tasaImpuestoFlete;
              this.tasaImpuesto = (Float)dtoCabeceraConsolidado.getTasaImpuestoUbigeo();
              this.indicadorImpuestos = (Long)dtoCabeceraConsolidado.getOidTasaImpuestoUbigeo();
              tasaImpuestoFlete = (Float)dtoCabeceraConsolidado.getTasaImpuestoUbigeo();
            }
            UtilidadesLog.debug("Tasa de Impuesto despues de verificar ubigeo " + this.tasaImpuesto);            
            /* Agregado por Brecha PED-006 ------ AL */
            if (tasaImpuesto == null){
              tasaImpuesto = new Float(0);
            }
            if (tasaImpuestoFlete == null){
              tasaImpuestoFlete = new Float(0);
            }
      		            
            DTOFACCabeceraSolicitud solicitudReferencia = null;
            int lsM1= listaSolicitudes.size();
            for(int k = 0; k< lsM1;k++){
                solicitudReferencia = (DTOFACCabeceraSolicitud)listaSolicitudes.get(k); 
                if (solicitudReferencia.getModulo() == modulo){
                    break;
                }
            }
            if(solicitudReferencia != null){
                for(int k = 0; k< lsM1;k++){
                    DTOFACCabeceraSolicitud aux = (DTOFACCabeceraSolicitud)listaSolicitudes.get(k); 
                    if (aux.getOidDocumentoReferencia() != null){
                        solicitudReferencia = aux; 
                        break;
                    }
                }
            }

            if(solicitudReferencia != null){
                dtoCabeceraConsolidado.setOidDocumentoReferencia(solicitudReferencia.getOidDocumentoReferencia());
            }                       
                            
            if (dtoCabeceraConsolidado.getOidDocumentoReferencia() != null) {
                Integer indicadorSN = obtenerIndicadorSolicitudNegativo(dtoCabeceraConsolidado.getOidCabeceraSolicitud());
                
                if(indicadorSN.intValue() == 1) {
                    Float tasaRefe =  recuperarTasaImpuestoReferencia(dtoCabeceraConsolidado.getOidDocumentoReferencia());
                    Float tasaRefeFlet =  recuperarTasaImpuestoReferenciaFlete(dtoCabeceraConsolidado.getOidDocumentoReferencia());
                    
                    tasaImpuesto = tasaRefe;
                    tasaImpuestoFlete = tasaRefeFlet;                    
                    tasaImpuestoFleteAnterior = tasaRefeFlet;  
                }       
                
            }

            //actualizando con la tasa de impuesto de flete anterior            
            // Update ped_solic_cabec set val_tasa_flet= tasaImpuestoFleteAnterior where oid_soli_cabe= dtoCabeceraConsolidado..getOidCabeceraSolicitud()
             actualizarTasaImpuestoReferenciaFlete(dtoCabeceraConsolidado.getOidCabeceraSolicitud(),tasaImpuestoFleteAnterior==null?tasaImpuestoFlete:tasaImpuestoFleteAnterior);
                            
      		if(dtoCabeceraConsolidado.getImporteFleteLocal().longValue()!=0) {
                /* Agregado por FAC-002 ------ AL */
                if (this.indicadorImpuestosIncluidos.booleanValue() && dtoCabeceraConsolidado.getTasaImpuestoUbigeo() != null && tasaImpuestoFlete.floatValue() == 0) {
                   if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                       UtilidadesLog.debug("Tasa Impuesto Flete Anterior ---> " + tasaImpuestoFleteAnterior);
                       UtilidadesLog.debug("Importe Flete Total Local (Antes de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getImporteFleteTotalLocal());
                   }    
                   BigDecimal auxTasa = new BigDecimal(1 + tasaImpuestoFleteAnterior.doubleValue() / 100);
                   BigDecimal calculo = new BigDecimal(dtoCabeceraConsolidado.getImporteFleteTotalLocal().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                   calculo = calculo.divide(auxTasa, BigDecimal.ROUND_HALF_EVEN); 
                   dtoCabeceraConsolidado.setImporteFleteTotalLocal(new Float(calculo.toString()));                      
                   if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                       UtilidadesLog.debug("Importe Flete Total Local (Despues de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getImporteFleteTotalLocal());
                       UtilidadesLog.debug("Base Flete Local (Antes de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getBaseFleteLocal());
                   }    
                   calculo = new BigDecimal(dtoCabeceraConsolidado.getBaseFleteLocal().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                   calculo = calculo.divide(auxTasa, BigDecimal.ROUND_HALF_EVEN);                    
                   dtoCabeceraConsolidado.setBaseFleteLocal(new Float(calculo.toString()));
                   UtilidadesLog.debug("Base Flete Local (Despues de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getBaseFleteLocal());
                }
                /* Agregado por FAC-002 ------ AL */            
                
        		if (this.indicadorImpuestosIncluidos.booleanValue()) {
                    BigDecimal importe = new BigDecimal(dtoCabeceraConsolidado.getImporteFleteTotalLocal().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                    UtilidadesLog.debug("Calculo Flete Local ---- Importe Flete Total Local " + importe);            
                    double tasaAux = tasaImpuestoFlete.doubleValue();
                    BigDecimal aux = new BigDecimal(1 + tasaAux / 100);
                     UtilidadesLog.debug("Calculo Flete Local ---- AUX (1+ tasa/100)" + aux); 
                    BigDecimal importeSinImp = importe.divide(aux, BigDecimal.ROUND_HALF_EVEN);
                    dtoCabeceraConsolidado.setImporteFleteSinImpuestosTotalLocal(new Float(importeSinImp.toString()));
                } else {
                    dtoCabeceraConsolidado.setImporteFleteSinImpuestosTotalLocal(dtoCabeceraConsolidado.getImporteFleteTotalLocal());
                }
        		if(dtoCabeceraConsolidado.getMoneda()!=null) {
                    /* Agregado por FAC-002 ------ AL */
                    if (this.indicadorImpuestosIncluidos.booleanValue() && dtoCabeceraConsolidado.getTasaImpuestoUbigeo() != null && tasaImpuestoFlete.floatValue() == 0) {
                       if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                           UtilidadesLog.debug("Tasa Impuesto Flete Anterior ---> " + tasaImpuestoFleteAnterior);
                           UtilidadesLog.debug("Importe Flete Total Documento (Antes de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getImporteFleteTotalDocumento());
                       }    
                       BigDecimal auxTasa = new BigDecimal(1 + tasaImpuestoFleteAnterior.doubleValue() / 100);
                       BigDecimal calculo = new BigDecimal(dtoCabeceraConsolidado.getImporteFleteTotalDocumento().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                       calculo = calculo.divide(auxTasa, BigDecimal.ROUND_HALF_EVEN); 
                       dtoCabeceraConsolidado.setImporteFleteTotalDocumento(new Float(calculo.toString()));                      
                       if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                           UtilidadesLog.debug("Importe Flete Total Documento (Despues de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getImporteFleteTotalDocumento());
                           UtilidadesLog.debug("Base Flete Documento (Antes de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getBaseFleteDocumento());
                       }    
                       calculo = new BigDecimal(dtoCabeceraConsolidado.getBaseFleteDocumento().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                       calculo = calculo.divide(auxTasa, BigDecimal.ROUND_HALF_EVEN);                    
                       dtoCabeceraConsolidado.setBaseFleteDocumento(new Float(calculo.toString()));
                       UtilidadesLog.debug("Base Flete Documento (Despues de Recalculo con Tasa Flete Anterior) -----> " + dtoCabeceraConsolidado.getBaseFleteDocumento());
                    }
                    /* Agregado por FAC-002 ------ AL */            

          			if(this.indicadorImpuestosIncluidos.booleanValue()){
                        BigDecimal importe = new BigDecimal(dtoCabeceraConsolidado.getImporteFleteTotalDocumento().toString()).setScale(this.numeroDecimalesRedondeo.intValue(),  BigDecimal.ROUND_HALF_EVEN);
                        double tasaAux = tasaImpuestoFlete.doubleValue();
                        BigDecimal aux = new BigDecimal(1 + tasaAux / 100);
                        
                        BigDecimal importeSinImp = importe.divide(aux, BigDecimal.ROUND_HALF_EVEN);
                        dtoCabeceraConsolidado.setImporteFleteSinImpuestosTotalDocumento(new Float(importeSinImp.toString()));
                    }else{
                        dtoCabeceraConsolidado.setImporteFleteSinImpuestosTotalDocumento(dtoCabeceraConsolidado.getImporteFleteTotalDocumento());						
                    }
                }else{  //se asigna a documento el mismo valor que local
                    dtoCabeceraConsolidado.setImporteFleteSinImpuestosTotalDocumento(dtoCabeceraConsolidado.getImporteFleteSinImpuestosTotalLocal());
                }
            }
            if (solicitudTrabajo != null) {
              dtoCabeceraConsolidado.setDestinatario(solicitudTrabajo.getDestinatario());
              dtoCabeceraConsolidado.setTipoDocumento(solicitudTrabajo.getTipoDocumento());
              dtoCabeceraConsolidado.setTipoDespacho(solicitudTrabajo.getTipoDespacho());
              dtoCabeceraConsolidado.setAccesoFisico(solicitudTrabajo.getAccesoFisico());
              dtoCabeceraConsolidado.setAlmacen(solicitudTrabajo.getAlmacen());
              dtoCabeceraConsolidado.setEstadoCredito(solicitudTrabajo.getEstadoCredito());
              dtoCabeceraConsolidado.setNumeroDocumentoOrigen(solicitudTrabajo.getNumeroDocumentoOrigen());
            }
      
      		//(11) - obtener indicador estadisticable
            dtoValores = null;
            if (helper.getValoresDefecto().get(dtoCabeceraConsolidado.getTipoSolicitud()) != null ){
               dtoValores = (DTOFACValoresDefecto)helper.getValoresDefecto().get(dtoCabeceraConsolidado.getTipoSolicitud());
            }
            indicadorEstadisticable = new Boolean(false);
            if (dtoValores != null){
                if (dtoValores.getValorPorDefecto() != null) { 
                    if(dtoValores.getValorPorDefecto().equals("1")) {
                        indicadorEstadisticable = new Boolean(true); 
                    }
                }
            }
 			dtoCabeceraConsolidado.setIndicadorEstadisticable(indicadorEstadisticable);
			
            //(13)se guarda en una variable el indicador de generaci�n de cuenta corriente
            //incidencia 9004
            indicadorGeneraCC = new Boolean((daoProcesos.obtenerIndicadorGeneraCC(dtoCabeceraConsolidado.getTipoSolicitud(),ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC)).booleanValue());	
            dtoCabeceraConsolidado.setIndicadorGeneraCuentaCorriente(new Boolean(indicadorGeneraCC.booleanValue()));
            
            //15. obtener numero consolidado a traves de 'generarNumeroDocumento' de PED
             StringBuffer query = new StringBuffer();
             
             query.append("SELECT ("); 
             query.append(" SELECT COD_PAIS"); 
             query.append(" FROM SEG_PAIS"); 
             query.append(" WHERE OID_PAIS = ").append(dtoCabeceraConsolidado.getOidPais());
             query.append(" ) COD_PAIS,"); 
             query.append(" ("); 
             query.append(" SELECT COD_SBAC"); 
             query.append(" FROM SEG_SUBAC"); 
             query.append(" WHERE OID_SBAC = ").append(dtoCabeceraConsolidado.getSubacceso());
             query.append(" ) COD_SBAC"); 
             query.append(" FROM DUAL");
             
             RecordSet rs = null;
             
             rs = UtilidadesBD.executeQuery(query.toString());
             ArrayList arrayParametros = new ArrayList();
             
             if (rs != null && !rs.esVacio()){
                 arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));    
                 arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SBAC")));    
             }
             
             arrayParametros.add(ConstantesFAC.COD_OP_SOLICITUD_CONSOLIDADO_PEDIDO);
             SimpleDateFormat sdf = new SimpleDateFormat("yy");
             Date currentYear = new Date( System.currentTimeMillis());
             String yy = sdf.format(currentYear);   
             arrayParametros.add(new Integer(yy)); 
             
             String numeroSolicitud = null;
             try {
                numeroSolicitud = this.getMONProcesosFacturacionLocal().ejecutarFuncionGeneraNumeros(arrayParametros);
             } catch (Exception ne) {
                UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
                throw new MareException(ne);
             }
             
             StringBuffer numeroFormateado = new StringBuffer();
             numeroFormateado.append(cerosIzq(yy.toString(), 2));
             numeroFormateado.append(cerosIzq(numeroSolicitud, 8));         
             dtoCabeceraConsolidado.setNumeroSolicitud(new Long(numeroFormateado.toString()));
                  
            //17. actualizarPosicion para cada posici�n del consolidado, contenida en dtoContenedor.listaPosiciones: 
            
            DTOFACPosicionSolicitud dtoPosicion = null;
            int lpM = listaPosiciones.size();
            for(int k=0;k < lpM;k++){
                dtoPosicion = (DTOFACPosicionSolicitud)listaPosiciones.get(k);
                dtoPosicion = this.actualizarPosicion(dtoPosicion, listaSolicitudes, helper.getImpuestoUbigeo(), helper.getIndicadoresImpuestos(), helper.getImpuestoNegocio());
            }
                  
            //18. realizar calculos de impuestos
            MONFacturacionLocal mONFacturacion = this.getMONFacturacionLocal();
            dtoCabeceraConsolidado.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
      
            dtoCie = new DTOFACCalculosImpuestosEntrada(); 
            dtoCie.setDtoConsolidado(dtoCabeceraConsolidado); 
            dtoCie.setListaPosiciones(listaPosiciones);
            dtoCie.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_SOLICITUD.charAt(0)));
            if(moneda!=null){
                dtoCie.setMoneda(new Long(moneda.longValue()));	
            }
            
            if (tipoCambio != null) {
                dtoCie.setTipoCambio(new Float(tipoCambio.floatValue()));
            }
            dtoCie.setIndicadorImpuestosIncluidos(new Boolean(indicadorImpuestosIncluidos.booleanValue()));
            if (dtoCabeceraConsolidado.getImporteFleteSinImpuestosTotalLocal() != null){
                dtoCie.setImporteFleteSinImpuestosTotalLocal(new Float(dtoCabeceraConsolidado.getImporteFleteSinImpuestosTotalLocal().floatValue()));
            }
            if (dtoCabeceraConsolidado.getImporteFleteSinImpuestosTotalDocumento() != null)  {
                dtoCie.setImporteFleteSinImpuestosTotalDocumento(new Float(dtoCabeceraConsolidado.getImporteFleteSinImpuestosTotalDocumento().floatValue()));
            }
            if (dtoCabeceraConsolidado.getIndicadorImpuestosFlete() != null) {
                dtoCie.setIndicadorImpuestoFlete(new Long(dtoCabeceraConsolidado.getIndicadorImpuestosFlete().longValue())); //9181
            }
            dtoCie.setTasaImpuestoFlete(tasaImpuestoFlete); 
            
            dtoCis = mONFacturacion.realizarCalculosImpuestos(dtoCie);
            dtoConsolidado.setDatosAcumuladosImpuestos(dtoCis.getDatosAcumuladosImpuestos());
            
            dtoCce = new DTOFACCalculosCabeceraEntrada();
            dtoCce.setDtoConsolidado(dtoCabeceraConsolidado);
            dtoCce.setListaPosiciones(listaPosiciones);
            dtoCce.setIndicadorCalculo(new Character(ConstantesFAC.IND_CALCULO_SOLICITUD.charAt(0)));
            if(moneda!=null){
                dtoCce.setMoneda(new Long(moneda.longValue()));	 
            }
            if (tipoCambio != null) {
                dtoCce.setTipoCambio(new Float(tipoCambio.floatValue()));
            }
            dtoCce.setIndicadorImpuestosIncluidos(new Boolean(indicadorImpuestosIncluidos.booleanValue()));
           
            dtoCce.setBaseImponibleDescuento3Documento(new Float(dtoCis.getBaseImponibleDescuento3Documento().floatValue()));
            dtoCce.setBaseImponibleDescuento3Local(new Float(dtoCis.getBaseImponibleDescuento3Local().floatValue()));
            dtoCce.setBaseImponiblePrecioContableDocumento(new Float(dtoCis.getBaseImponiblePrecioContableDocumento().floatValue()));
            dtoCce.setBaseImponiblePrecioContableLocal(new Float(dtoCis.getBaseImponiblePrecioContableLocal().floatValue()));
            dtoCce.setTotalBaseImponibleDocumento(new Float(dtoCis.getTotalBaseImponibleDocumento().floatValue()));
            dtoCce.setTotalBaseImponibleLocal(new Float(dtoCis.getTotalBaseImponibleLocal().floatValue()));
            dtoCce.setTotalImporteDocumento(new Float(dtoCis.getTotalImporteDocumento().floatValue()));
            dtoCce.setTotalImporteLocal(new Float(dtoCis.getTotalImporteLocal().floatValue()));
            dtoCce.setTotalImpuestosDocumento(new Float(dtoCis.getTotalImpuestosDocumento().floatValue()));
            dtoCce.setTotalImpuestosLocal(new Float(dtoCis.getTotalImpuestosLocal().floatValue()));
            
            dtoCcs = mONFacturacion.realizarCalculosCabecera(dtoCce);
            
            dtoCabeceraConsolidado.setImporteDescuento1SinImpuestoTotalDocumento(new Float(dtoCcs.getImporteDescuento1SinImpuestoTotalDocumento().floatValue())); 
            dtoCabeceraConsolidado.setImporteDescuento1SinImpuestoTotalLocal(new Float(dtoCcs.getImporteDescuento1SinImpuestoTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteDescuento1TotalDocumento(new Float(dtoCcs.getImporteDescuento1TotalDocumento().floatValue()));			
            dtoCabeceraConsolidado.setImporteDescuento1TotalLocal(new Float(dtoCcs.getImporteDescuento1TotalLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteDescuento3SinImpuestosTotalDocumento(new Float(dtoCcs.getImporteDescuento3SinImpuestoTotalDocumento().floatValue()));
            dtoCabeceraConsolidado.setImporteDescuento3SinImpuestosTotalLocal(new Float(dtoCcs.getImporteDescuento3SinImpuestoTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteDescuentoTotalDocumento(new Float(dtoCcs.getImporteDescuentoTotalDocumento().floatValue())); 
            dtoCabeceraConsolidado.setImporteDescuentoTotalLocal(new Float(dtoCcs.getImporteDescuentoTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteImpuestosTotalDocumento(new Float(dtoCcs.getImporteImpuestosTotalDocumento().floatValue()));
            dtoCabeceraConsolidado.setImporteImpuestosTotalLocal(new Float(dtoCcs.getImporteImpuestosTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteRedondeoConsolidadoDocumento(new Float(dtoCcs.getImporteRedondeoConsolidadoDocumento().floatValue())); 
            dtoCabeceraConsolidado.setImporteRedondeoConsolidadoLocal(new Float(dtoCcs.getImporteRedondeoConsolidadoLocal().floatValue()));
            dtoCabeceraConsolidado.setImporteRedondeoDocumento(new Float(dtoCcs.getImporteRedondeoDocumento().floatValue()));
            dtoCabeceraConsolidado.setImporteRedondeoLocal(new Float(dtoCcs.getImporteRedondeoLocal().floatValue()));
            dtoCabeceraConsolidado.setPrecioCatalogoSinImpuestoTotalDocumento(new Float(dtoCcs.getPrecioCatalogoSinImpuestoTotalDocumento().floatValue())); 
            dtoCabeceraConsolidado.setPrecioCatalogoSinImpuestoTotalLocal(new Float(dtoCcs.getPrecioCatalogoSinImpuestoTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setPrecioCatalogoTotalDocumento(new Float(dtoCcs.getPrecioCatalogoTotalDocumento().floatValue()));
            dtoCabeceraConsolidado.setPrecioCatalogoTotalDocumentoUnidadesPorAtender(new Float(dtoCcs.getPrecioCatalogoTotalDocumentoUnidadesPorAtender().floatValue())); 
            dtoCabeceraConsolidado.setPrecioCatalogoTotalLocal(new Float(dtoCcs.getPrecioCatalogoTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setPrecioCatalogoTotalLocalUnidadesPorAtender(new Float(dtoCcs.getPrecioCatalogoTotalLocalUnidadesPorAtender().floatValue()));
            dtoCabeceraConsolidado.setPrecioContableSinImpuestosTotalDocumento(new Float(dtoCcs.getPrecioContableSinImpuestoTotalDocumento().floatValue()));
            dtoCabeceraConsolidado.setPrecioContableSinImpuestosTotalLocal(new Float(dtoCcs.getPrecioContableSinImpuestoTotalLocal().floatValue()));			
            dtoCabeceraConsolidado.setPrecioContableTotalDocumento(new Float(dtoCcs.getPrecioContableTotalDocumento().floatValue()));			
            dtoCabeceraConsolidado.setPrecioContableTotalLocal(new Float(dtoCcs.getPrecioContableTotalLocal().floatValue()));
            dtoCabeceraConsolidado.setPrecioFacturaTotalDocumento(new Float(dtoCcs.getPrecioFacturaTotalDocumento().floatValue())); 
            dtoCabeceraConsolidado.setPrecioFacturaTotalLocal(new Float(dtoCcs.getPrecioFacturaTotalLocal().floatValue())); 
            dtoCabeceraConsolidado.setPrecioNetoTotalDocumento(new Float(dtoCcs.getPrecioNetoTotalDocumento().floatValue()));			
            dtoCabeceraConsolidado.setPrecioNetoTotalLocal(new Float(dtoCcs.getPrecioNetoTotalLocal().floatValue())); 
            dtoCabeceraConsolidado.setPrecioTotalTotalDocumento(new Float(dtoCcs.getPrecioTotalTotalDocumento().floatValue()));
            dtoCabeceraConsolidado.setPrecioTotalTotalLocal(new Float(dtoCcs.getPrecioTotalTotalLocal().floatValue())); 
            dtoCabeceraConsolidado.setTotalAPagarDocumento(new Float(dtoCcs.getTotalAPagarDocumento().floatValue())); 
            dtoCabeceraConsolidado.setTotalAPagarLocal(new Float(dtoCcs.getTotalAPagarLocal().floatValue()));
            dtoCabeceraConsolidado.setUnidadesAtendidasTotal(new Integer(dtoCcs.getUnidadesAtendidasTotal().intValue())); 
            dtoCabeceraConsolidado.setUnidadesDemandaRealTotal(new Integer(dtoCcs.getUnidadesDemandaRealTotal().intValue())); 
            dtoCabeceraConsolidado.setUnidadesPorAtenderTotal(new Integer(dtoCcs.getUnidadesPorAtenderTotal().intValue()));
            dtoCabeceraConsolidado.setTasaImpuesto(tasaImpuesto);
            dtoCabeceraConsolidado.setTasaImpuestoFlete(tasaImpuestoFlete);
            
            Iterator iteradorSecuenciaCabecera = secuenciaProcesos.iterator();
            
        
            while(iteradorSecuenciaCabecera.hasNext()){				
                DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteradorSecuenciaCabecera.next();                
                if((dtoCabeceraConsolidado.getTipoSolicitud().longValue() == dtoFACSecuenciaProcesos.getTipoSolicitud().longValue()) 
                  &&(dtoFACSecuenciaProcesos.getGrupoProcesos().equals(ConstantesFAC.COD_GP5))){      
                    dtoCabeceraConsolidado.setGrupoProcesos(new Long(dtoFACSecuenciaProcesos.getOidGrupoProcesos().longValue()));
                }
                if((dtoCabeceraConsolidado.getTipoSolicitud().longValue() == dtoFACSecuenciaProcesos.getTipoSolicitud().longValue()) 
                  &&(dtoFACSecuenciaProcesos.getCodigoProceso().equals(ConstantesFAC.COD_PROC_NULO))){	
                    dtoCabeceraConsolidado.setProceso(new Long(dtoFACSecuenciaProcesos.getOidProceso().longValue()));
                }				
            }//fin del while
            
            
            int lsM = listaSolicitudes.size();
            for (int k = 0; k < lsM ;k++) {
                dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)listaSolicitudes.get(k);
                dtoCabeceraSolicitud.setCanal(new Long(dtoCabeceraConsolidado.getCanal().longValue()));
                dtoCabeceraSolicitud.setAcceso(new Long(dtoCabeceraConsolidado.getAcceso().longValue()));
                dtoCabeceraSolicitud.setSubacceso(new Long(dtoCabeceraConsolidado.getSubacceso().longValue()));
                if (dtoCabeceraConsolidado.getNumeroSolicitud() != null) {
                    dtoCabeceraSolicitud.setNumeroConsolidado(new Long(dtoCabeceraConsolidado.getNumeroSolicitud().longValue()));
                }
               if (helper.getEstadosSolicitud().get(ConstantesFAC.COD_ESTADO_SOLICITUD_OK) != null) {
                  dtoCabeceraSolicitud.setEstado((Long)helper.getEstadosSolicitud().get(ConstantesFAC.COD_ESTADO_SOLICITUD_OK));
               }
            }
        }
        
        UtilidadesLog.info("MONProcesosFacturacionBean.procesar(DTOFACListaConsolidados dtoListaConsolidados): Salida");
        return listaConsolidados;
    }
    
    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        UtilidadesLog.info("MONProcesosFacturacionBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Entrada ");
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        UtilidadesLog.info("MONProcesosFacturacionBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Salida ");
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }    

	public Hashtable obtenerValoresTipoSolicitud() throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.obtenerValoresTipoSolicitud()");
		return null;
	}
  
  /**
   * CHANGELOG
   * ---------
   * 20/07/2009 - dmorello, Cambio 20090998
   *     Se recupera SEG_PARAM_INTER_PAIS.IND_REDO_IMPU para el pais tratado
   *     Si es 1, no se redondean precioNetoUL e importeImpuestoUL
   *     Si es 0 o nulo, se redondean dichos valores a la cant de decimales del pais
   * 29/07/2009 - dmorello, Cambio 20090998
   *     Se realiza lo anterior tambien para precioNetoUD e importeImpuestoUD
   */
  public DTOFACPosicionSolicitud actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion, ArrayList listaSolicitudes, HashMap hashImpuestosUbigeo, HashMap hashIndicadoresImpuestos, HashMap hashImpuestosNegocio) throws MareException {
    UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion, ArrayList listaSolicitudes): Entrada");
    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
        UtilidadesLog.debug("*** DTOPosicion = "+dtoPosicion);
        
    DTOFACCabeceraSolicitud cabecera = null;
	Float tasaTemp = null;
	Long indImpuestosTemp = null;
	Iterator ite = null;
        
    // 0. Busco el indicador redondear impuestos para el pais
    
    Long oidPais = dtoPosicion.getOidPais();
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT IND_REDO_IMPU FROM SEG_PARAM_INTER_PAIS ");
    query.append(" WHERE PAIS_OID_PAIS = ").append(oidPais);
    
    RecordSet rs = null;
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
        String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(e, UtilidadesError.armarCodigoError(error));
    }
    
    Boolean indRedoImpu = UtilidadesBD.convertirABoolean(rs.getValueAt(0,0));
    UtilidadesLog.debug("indRedoImpu: " + indRedoImpu);
    UtilidadesLog.debug("indicadorImpuestosIncluidos: " + indicadorImpuestosIncluidos);
    UtilidadesLog.debug("numeroDecimalesRedondeo: " + numeroDecimalesRedondeo);
          
	//1. se actualizan los impuestos de la posicion

    ite = listaSolicitudes.iterator();
    while (ite.hasNext()){
      DTOFACCabeceraSolicitud dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)ite.next();
      if(dtoCabeceraSolicitud.getOidCabeceraSolicitud().equals(dtoPosicion.getOidCabecera())) {
	    cabecera = dtoCabeceraSolicitud;
         break;
	  }
	}


	if (indicadorTasaUnica.booleanValue() == true) {
      dtoPosicion.setIndicadorImpuestos(this.indicadorImpuestos); 
      dtoPosicion.setTasaImpuesto(this.tasaImpuesto);
      tasaTemp = this.tasaImpuesto;
	  indImpuestosTemp = this.indicadorImpuestos;
	} else {	      
      
      String subAcceso = "";
      String negocioProducto = "";
      String producto = "";
      if (cabecera.getSubacceso() != null) {
        subAcceso = cabecera.getSubacceso().toString();
      }
      if (dtoPosicion.getProducto() != null ) {
        producto = dtoPosicion.getProducto().toString();
      }
      if (dtoPosicion.getNegocioProducto() != null ) {
        negocioProducto = dtoPosicion.getNegocioProducto().toString();
      }
            //  PRIMERO buscamos la tasa impuestos de MAE_IMPUE_UBIGE
      if (hashImpuestosUbigeo.get(subAcceso+producto) != null) {
        indImpuestosTemp = (Long)hashImpuestosUbigeo.get(subAcceso+producto);
      }
	  if(indImpuestosTemp != null) {
        if (hashIndicadoresImpuestos.get(indImpuestosTemp) != null){
          tasaTemp = (Float)hashIndicadoresImpuestos.get(indImpuestosTemp);
          UtilidadesLog.debug("***** tasaTemp (1)= "+tasaTemp.toString());
        }
      } else {
        if (hashImpuestosNegocio.get(subAcceso+negocioProducto) != null) {
          indImpuestosTemp = new Long(((Float)hashImpuestosNegocio.get(subAcceso+negocioProducto)).longValue());
        }
	    if(indImpuestosTemp!=null) {
          if (hashIndicadoresImpuestos.get(indImpuestosTemp) != null) {
            tasaTemp = (Float)hashIndicadoresImpuestos.get(indImpuestosTemp);
            UtilidadesLog.debug("***** tasaTemp (2)= "+tasaTemp.toString());
          }
	    } else {
		  indImpuestosTemp = this.indicadorImpuestos;
          tasaTemp = this.tasaImpuesto;
          UtilidadesLog.debug("***** tasaTemp (3)= "+tasaTemp.toString());
	    }
	  }
            
	  dtoPosicion.setIndicadorImpuestos(indImpuestosTemp);
	  if (tasaTemp==null) {
        tasaTemp = new Float(0);
      }
      dtoPosicion.setTasaImpuesto(tasaTemp);
      UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosicion: El indicador de impuestos es: " +indImpuestosTemp);
      UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosicion: La tasa de impuesto es: " +tasaTemp);
    }
        
    float precioSinImpuestosUL = 0,
          precioSinImpuestosUD = 0,
          importeDescuentoSinImpuestosUL = 0,
          importeDescuentoSinImpuestosUD = 0,
          precioFacturaUL = 0,
          precioFacturaUD = 0,
          precioNetoUL = 0,
          precioNetoUD = 0,
          importeImpuestoUL = 0,
          importeImpuestoUD = 0,
          precioTotalUL = 0,
          precioTotalUD = 0,
          temporalSumas = 0;
    //2. se actualizan importes y precios de la posicion      
    
    /* Agregado por Cambio FAC-003 ------ AL */      
    if (cabecera.getOidTipoConcursoPrograma() != null && (dtoPosicion.getPrecioContableUL() == null || dtoPosicion.getPrecioContableUL().floatValue() == 0)) {
      if (indicadorImpuestosIncluidos.booleanValue()) {
        dtoPosicion.setPrecioContableUL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCosteEstandar().floatValue()*(1+ (tasaTemp.floatValue()/100))), this.numeroDecimalesRedondeo));  
      } else {
        dtoPosicion.setPrecioContableUL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCosteEstandar().floatValue()), this.numeroDecimalesRedondeo));
      }
    } 
    if (dtoPosicion.getPrecioContableUL() != null) {
        dtoPosicion.setPrecioContableULAnterior(new Float(dtoPosicion.getPrecioContableUL().floatValue()));
    }
    /* Agregado por Cambio FAC-003 ------ AL */
    
        /* Agregado por FAC-002 ------ AL */
      if (indicadorImpuestosIncluidos.booleanValue() && this.tasaImpuestoAnterior != null && tasaTemp.floatValue() == 0) {
         UtilidadesLog.debug("Tasa Impuesto Actual ---> " + tasaTemp);
         UtilidadesLog.debug("Tasa Impuesto Anterior ---> " + this.tasaImpuestoAnterior);
         if (dtoPosicion.getPrecioContableUL() != null) {
            UtilidadesLog.debug("Precio Contable Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioContableUL());
            dtoPosicion.setPrecioContableUL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioContableUL().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));  
            UtilidadesLog.debug("Precio Contable Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioContableUL());
         }
         if (dtoPosicion.getPrecioCatalogoUL() != null ) {
            UtilidadesLog.debug("Precio Catalogo Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioCatalogoUL());
            dtoPosicion.setPrecioCatalogoUL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCatalogoUL().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));  
            UtilidadesLog.debug("Precio Catalogo Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioCatalogoUL());
         }
         if (dtoPosicion.getImporteDescuentoUL() != null) {
            UtilidadesLog.debug("Importe Descuento Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getImporteDescuentoUL());
            dtoPosicion.setImporteDescuentoUL(Redondear.redondearFloat(new Float(dtoPosicion.getImporteDescuentoUL().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));           
            UtilidadesLog.debug("Importe Descuento Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getImporteDescuentoUL());
         }
      }      
    /* Agregado por FAC-002 ------ AL */

	
    if(indicadorImpuestosIncluidos.booleanValue()) {
      if(dtoPosicion.getPrecioCatalogoUL()!=null && dtoPosicion.getPrecioContableUL()!=null && tasaTemp!=null){
         precioSinImpuestosUL = (Redondear.redondearFloat(new Float((dtoPosicion.getPrecioCatalogoUL().floatValue() 
                + dtoPosicion.getPrecioContableUL().floatValue()) / (1 + (tasaTemp.floatValue()/100))),this.numeroDecimalesRedondeo)).floatValue();
         precioSinImpuestosUL = (Redondear.redondearFloat(new Float(precioSinImpuestosUL),this.numeroDecimalesRedondeo)).floatValue();
      }
    } else {
      if(dtoPosicion.getPrecioCatalogoUL()!=null && dtoPosicion.getPrecioContableUL()!=null){
        precioSinImpuestosUL = (Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCatalogoUL().floatValue() + dtoPosicion.getPrecioContableUL().floatValue()),this.numeroDecimalesRedondeo)).floatValue();
      }
    }
    if(indicadorImpuestosIncluidos.booleanValue()) {
      if(dtoPosicion.getImporteDescuentoUL()!=null && tasaTemp!=null){
        temporalSumas = importeDescuentoSinImpuestosUL + dtoPosicion.getImporteDescuentoUL().floatValue();
        UtilidadesLog.debug("Importe Descuento Sin Impuestos Unitario Local ----> " + temporalSumas);
        UtilidadesLog.debug("Tasa ----> " + tasaTemp);
        temporalSumas = temporalSumas / (1+(tasaTemp.floatValue()/100));        
        importeDescuentoSinImpuestosUL= (Redondear.redondearFloat(new Float(temporalSumas),this.numeroDecimalesRedondeo)).floatValue();
        UtilidadesLog.debug("Calculo Importe Descuento Sin Impuestos Unitario Local ----> " + importeDescuentoSinImpuestosUL);
        temporalSumas = 0;
      }
    } else {
      if(dtoPosicion.getImporteDescuentoUL()!=null){
        importeDescuentoSinImpuestosUL = dtoPosicion.getImporteDescuentoUL().floatValue();
      }
    }

    /* Agregado por Cambio FAC-003 ------ AL */  
    if (cabecera.getOidTipoConcursoPrograma() == null || (cabecera.getCodigoTipoProgramaConcu() != null && !cabecera.getCodigoTipoProgramaConcu().equalsIgnoreCase("B"))) {
    /* Agregado por Cambio FAC-003 ------ AL */      
      if(dtoPosicion.getPrecioCatalogoUL() != null && dtoPosicion.getPrecioContableUL() != null && dtoPosicion.getImporteDescuentoUL() != null){
        precioFacturaUL = dtoPosicion.getPrecioCatalogoUL().floatValue() + dtoPosicion.getPrecioContableUL().floatValue() - dtoPosicion.getImporteDescuentoUL().floatValue();
      }
    
      if(indicadorImpuestosIncluidos.booleanValue()) {
        temporalSumas = precioFacturaUL / (1 + (tasaTemp.floatValue()/100));
        UtilidadesLog.debug("temporalSumas: " + temporalSumas);
        if (Boolean.TRUE.equals(indRedoImpu)) {
            precioNetoUL = temporalSumas;
        } else {
            precioNetoUL = (Redondear.redondearFloat(new Float(temporalSumas),this.numeroDecimalesRedondeo)).floatValue();
        }
        UtilidadesLog.debug("precioNetoUL: " + precioNetoUL);
        temporalSumas=0;
      } else {
        precioNetoUL = precioFacturaUL;
      }      
    /* Agregado por Cambio FAC-003 ------ AL */  
      dtoPosicion.setPrecioContableTL(new Float(0));
    }
    /* Agregado por Cambio FAC-003 ------ AL */  
        
    if(indicadorImpuestosIncluidos.booleanValue()) {
        UtilidadesLog.debug("precioFacturaUL - precioNetoUL: " + (precioFacturaUL - precioNetoUL));
        if (Boolean.TRUE.equals(indRedoImpu)) {
            importeImpuestoUL = precioFacturaUL - precioNetoUL;
        } else {
            importeImpuestoUL = Redondear.redondearFloat(new Float(precioFacturaUL - precioNetoUL),this.numeroDecimalesRedondeo).floatValue();
        }
        UtilidadesLog.debug("importeImpuestoUL: " + importeImpuestoUL);
    } else {
       importeImpuestoUL = (Redondear.redondearFloat(new Float(precioNetoUL * (tasaTemp.floatValue() / 100)),this.numeroDecimalesRedondeo)).floatValue();
       UtilidadesLog.debug("importeImpuestoUL-2 es: "+importeImpuestoUL);
    }
        
    precioTotalUL = precioNetoUL + importeImpuestoUL;
    
    if(dtoPosicion.getPrecioContableUL() != null) {
      /* Agregado por Cambio FAC-003 ------ AL */ 
      if (cabecera.getOidTipoConcursoPrograma() == null || (cabecera.getCodigoTipoProgramaConcu() != null && !cabecera.getCodigoTipoProgramaConcu().equalsIgnoreCase("B"))) {
      /* Agregado por Cambio FAC-003 ------ AL */   

        dtoPosicion.setPrecioContableTL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioContableUL().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue()), this.numeroDecimalesRedondeo));

      /* Agregado por Cambio FAC-003 ------ AL */ 
      } else {
        dtoPosicion.setPrecioContableTL(new Float(0));
      }
      /* Agregado por Cambio FAC-003 ------ AL */ 
    }
    if(dtoPosicion.getPrecioCatalogoUL() != null){
      dtoPosicion.setPrecioCatalogoTL(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCatalogoUL().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue()), this.numeroDecimalesRedondeo));
    }
    if(dtoPosicion.getPrecioCatalogoUL() != null){
      dtoPosicion.setPrecioCatalogoTLUnidadesDemandaReal(Redondear.redondearFloat(new Float (dtoPosicion.getPrecioCatalogoUL().floatValue() * dtoPosicion.getUnidadesDemandaReal().floatValue()),this.numeroDecimalesRedondeo));
    }
    dtoPosicion.setPrecioFacturaTL(Redondear.redondearFloat(new Float(precioFacturaUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioSinImpuestosTL(Redondear.redondearFloat(new Float(precioSinImpuestosUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
        
    if(dtoPosicion.getImporteDescuentoUL()!=null ){
      dtoPosicion.setImporteDescuentoTL(Redondear.redondearFloat(new Float(dtoPosicion.getImporteDescuentoUL().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
    }
    dtoPosicion.setImporteDescuentoSinImpuestosTL(Redondear.redondearFloat(new Float(importeDescuentoSinImpuestosUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioNetoTL(Redondear.redondearFloat(new Float(precioNetoUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
    dtoPosicion.setImporteImpuestoTL(Redondear.redondearFloat(new Float(importeImpuestoUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioTotalTL(Redondear.redondearFloat(new Float(precioTotalUL * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
        
    if (this.moneda != null) {
    
      /* Agregado por Cambio FAC-003 ------ AL */      
      if (cabecera.getOidTipoConcursoPrograma() != null && (dtoPosicion.getPrecioContableUD() == null || dtoPosicion.getPrecioContableUD().floatValue() == 0)) {
        if (indicadorImpuestosIncluidos.booleanValue()) {
          dtoPosicion.setPrecioContableUD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCosteEstandar().floatValue()/(1+ (tasaTemp.floatValue()/100))), this.numeroDecimalesRedondeo));  
        } else {
          dtoPosicion.setPrecioContableUD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCosteEstandar().floatValue()), this.numeroDecimalesRedondeo));
        }        
      }       
      if (dtoPosicion.getPrecioContableUD() != null) {
        dtoPosicion.setPrecioContableUDAnterior(new Float(dtoPosicion.getPrecioContableUD().floatValue()));
      }
      /* Agregado por Cambio FAC-003 ------ AL */    
    
    
        /* Agregado por FAC-002 ------ AL */
      if (indicadorImpuestosIncluidos.booleanValue() && this.tasaImpuestoAnterior != null && tasaTemp.floatValue() == 0) {
         UtilidadesLog.debug("Tasa Impuesto Actual ---> " + tasaTemp);
         UtilidadesLog.debug("Tasa Impuesto Anterior ---> " + this.tasaImpuestoAnterior);
         UtilidadesLog.debug("-AL- Parte Calculos Documentos ");
         if (dtoPosicion.getPrecioContableUD() != null) {
            UtilidadesLog.debug("Precio Contable Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioContableUL());
            dtoPosicion.setPrecioContableUD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioContableUD().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));  
            UtilidadesLog.debug("Precio Contable Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioContableUL());
         }
         if (dtoPosicion.getPrecioCatalogoUD() != null ) {
            UtilidadesLog.debug("Precio Catalogo Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioCatalogoUL());
            dtoPosicion.setPrecioCatalogoUD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCatalogoUD().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));  
            UtilidadesLog.debug("Precio Catalogo Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getPrecioCatalogoUL());
         }
         if (dtoPosicion.getImporteDescuentoUD() != null) {
            UtilidadesLog.debug("Importe Descuento Unitario Local (Antes del recalculo con Tasa Anterior)---> " + dtoPosicion.getImporteDescuentoUL());
            dtoPosicion.setImporteDescuentoUD(Redondear.redondearFloat(new Float(dtoPosicion.getImporteDescuentoUD().floatValue()/(1+ (this.tasaImpuestoAnterior.floatValue()/100))), this.numeroDecimalesRedondeo));           
            UtilidadesLog.debug("Importe Descuento Unitario Local (Despues del recalculo con Tasa Anterior)---> " + dtoPosicion.getImporteDescuentoUL());
         }
      }      
    /* Agregado por FAC-002 ------ AL */
    
    
	  if(indicadorImpuestosIncluidos.booleanValue()) {
		if(dtoPosicion.getPrecioCatalogoUD()!=null && dtoPosicion.getPrecioContableUD()!=null && tasaTemp!=null) {
		  temporalSumas = dtoPosicion.getPrecioCatalogoUD().floatValue() + dtoPosicion.getPrecioContableUD().floatValue();
          temporalSumas = temporalSumas/(1+(tasaTemp.floatValue()/100));
          precioSinImpuestosUD = (Redondear.redondearFloat(new Float(temporalSumas),this.numeroDecimalesRedondeo)).floatValue();
          temporalSumas = 0;
    	}
	  } else {
		if(dtoPosicion.getPrecioCatalogoUD()!=null && dtoPosicion.getPrecioContableUD()!=null) {
		  precioSinImpuestosUD = dtoPosicion.getPrecioCatalogoUD().floatValue() + dtoPosicion.getPrecioContableUD().floatValue();
        }
	  }
	  if(indicadorImpuestosIncluidos.booleanValue()) {
	    if(dtoPosicion.getImporteDescuentoUD()!=null && tasaTemp!=null){
          temporalSumas = dtoPosicion.getImporteDescuentoUD().floatValue();
          temporalSumas = temporalSumas/(1+(tasaTemp.floatValue()/100));
          importeDescuentoSinImpuestosUD=(Redondear.redondearFloat(new Float(temporalSumas),this.numeroDecimalesRedondeo)).floatValue();
          temporalSumas =0;
        }
	  } else {
		if(dtoPosicion.getImporteDescuentoUD()!=null){
		  importeDescuentoSinImpuestosUD = dtoPosicion.getImporteDescuentoUD().floatValue();
        }
	  }


      /* Agregado por Cambio FAC-003 ------ AL */  
      if (cabecera.getOidTipoConcursoPrograma() == null || (cabecera.getCodigoTipoProgramaConcu() != null && !cabecera.getCodigoTipoProgramaConcu().equalsIgnoreCase("B"))) {
      /* Agregado por Cambio FAC-003 ------ AL */      
        if(dtoPosicion.getPrecioCatalogoUD()!=null && dtoPosicion.getPrecioContableUD()!=null && dtoPosicion.getImporteDescuentoUD()!=null){
	      precioFacturaUD = dtoPosicion.getPrecioCatalogoUD().floatValue() + dtoPosicion.getPrecioContableUD().floatValue() - dtoPosicion.getImporteDescuentoUD().floatValue();	
  	    }
	    if(indicadorImpuestosIncluidos.booleanValue()) {
	      if(tasaTemp!=null) {
            temporalSumas = precioFacturaUD;
            temporalSumas = temporalSumas/(1+(tasaTemp.floatValue() / 100));
            if (Boolean.TRUE.equals(indRedoImpu)) {
                precioNetoUD = temporalSumas;
            } else {
                precioNetoUD = (Redondear.redondearFloat(new Float(temporalSumas),this.numeroDecimalesRedondeo)).floatValue();
            }
            temporalSumas =0 ;
    	  }
	    } else {
		  precioNetoUD = precioFacturaUD;
	    }        
      /* Agregado por Cambio FAC-003 ------ AL */  
      }
      /* Agregado por Cambio FAC-003 ------ AL */  
      
      if (indicadorImpuestosIncluidos.booleanValue()) {
          if (Boolean.TRUE.equals(indRedoImpu)) {
              importeImpuestoUD = precioFacturaUD - precioNetoUD;
          } else {
              importeImpuestoUD = Redondear.redondearFloat(new Float(precioFacturaUD - precioNetoUD),this.numeroDecimalesRedondeo).floatValue();
          }
      } else {
          if(tasaTemp!=null){
              importeImpuestoUD = (Redondear.redondearFloat(new Float(precioNetoUD * tasaTemp.floatValue() / 100), this.numeroDecimalesRedondeo)).floatValue();
          }
      }
        
	  precioTotalUD = precioNetoUD + importeImpuestoUD;	
			
	  if(dtoPosicion.getPrecioContableUD()!=null ) {
        /* Agregado por Cambio FAC-003 ------ AL */ 
        if (cabecera.getOidTipoConcursoPrograma() == null || (cabecera.getCodigoTipoProgramaConcu() != null && !cabecera.getCodigoTipoProgramaConcu().equalsIgnoreCase("B"))) {
        /* Agregado por Cambio FAC-003 ------ AL */   

		  dtoPosicion.setPrecioContableTD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioContableUD().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue() ),this.numeroDecimalesRedondeo));

        /* Agregado por Cambio FAC-003 ------ AL */ 
        } else {
          dtoPosicion.setPrecioContableTD(new Float(0));
        }
        /* Agregado por Cambio FAC-003 ------ AL */ 
	  }
	  if(dtoPosicion.getPrecioCatalogoUD()!=null ) {
		dtoPosicion.setPrecioCatalogoTD(Redondear.redondearFloat(new Float(dtoPosicion.getPrecioCatalogoUD().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
	  }
	  if(dtoPosicion.getPrecioCatalogoUD()!=null ){
	    dtoPosicion.setPrecioCatalogoTDUnidadesDemandaReal(Redondear.redondearFloat(new Float (dtoPosicion.getPrecioCatalogoUD().floatValue() * dtoPosicion.getUnidadesDemandaReal().floatValue()),this.numeroDecimalesRedondeo));
	  }
	  dtoPosicion.setPrecioFacturaTD(Redondear.redondearFloat(new Float(precioFacturaUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
	  dtoPosicion.setPrecioSinImpuestosTD(Redondear.redondearFloat(new Float(precioSinImpuestosUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
      dtoPosicion.setImporteDescuentoTD(Redondear.redondearFloat(new Float(dtoPosicion.getImporteDescuentoUD().floatValue() * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
	  dtoPosicion.setImporteDescuentoSinImpuestosTD(Redondear.redondearFloat(new Float(importeDescuentoSinImpuestosUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
      dtoPosicion.setPrecioNetoTD(Redondear.redondearFloat(new Float(precioNetoUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
      dtoPosicion.setImporteImpuestoTD(Redondear.redondearFloat(new Float(importeImpuestoUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
	  dtoPosicion.setPrecioTotalTD(Redondear.redondearFloat(new Float(precioTotalUD * dtoPosicion.getUnidadesComprometidas().floatValue()),this.numeroDecimalesRedondeo));
	} else { // se asignan a los valores de documento los mismos que los de local
      
      /* AL -- Agregado por incidencia SiCC 20080659 -- 14/07/2008 */
      dtoPosicion.setPrecioContableUDAnterior(new Float(dtoPosicion.getPrecioContableULAnterior().floatValue()));
      dtoPosicion.setPrecioContableUD(dtoPosicion.getPrecioContableUL());
      dtoPosicion.setPrecioCatalogoUD(dtoPosicion.getPrecioCatalogoUL());
      dtoPosicion.setImporteDescuentoUD(dtoPosicion.getImporteDescuentoUL()); 
      /* AL -- Agregado por incidencia SiCC 20080659 -- 14/07/2008 */
      
      
      precioSinImpuestosUD = precioSinImpuestosUL;
      importeDescuentoSinImpuestosUD = importeDescuentoSinImpuestosUL;
      precioFacturaUD = precioFacturaUL;
      precioNetoUD = precioNetoUL;
      importeImpuestoUD = importeImpuestoUL;
      precioTotalUD = precioTotalUL;
      
      dtoPosicion.setPrecioContableTD(dtoPosicion.getPrecioContableTL());
      dtoPosicion.setPrecioCatalogoTD(dtoPosicion.getPrecioCatalogoTL());
      dtoPosicion.setPrecioCatalogoTDUnidadesDemandaReal(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal());
      dtoPosicion.setPrecioFacturaTD(dtoPosicion.getPrecioFacturaTL());
      dtoPosicion.setPrecioSinImpuestosTD(dtoPosicion.getPrecioSinImpuestosTL());
      dtoPosicion.setImporteDescuentoTD(dtoPosicion.getImporteDescuentoTL());
      dtoPosicion.setImporteDescuentoSinImpuestosTD(dtoPosicion.getImporteDescuentoSinImpuestosTL());
      dtoPosicion.setPrecioNetoTD(dtoPosicion.getPrecioNetoTL());
      dtoPosicion.setImporteImpuestoTD(dtoPosicion.getImporteImpuestoTL());
      dtoPosicion.setPrecioTotalTD(dtoPosicion.getPrecioTotalTL());
    } 
        // se redondean los valores unitarios
    dtoPosicion.setPrecioSinImpuestosUL(Redondear.redondearFloat(new Float(precioSinImpuestosUL),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioSinImpuestosUD(Redondear.redondearFloat(new Float(precioSinImpuestosUD),this.numeroDecimalesRedondeo));
    dtoPosicion.setImporteDescuentoSinImpuestosUL(Redondear.redondearFloat(new Float(importeDescuentoSinImpuestosUL),this.numeroDecimalesRedondeo));
    dtoPosicion.setImporteDescuentoSinImpuestosUD(Redondear.redondearFloat(new Float(importeDescuentoSinImpuestosUD),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioFacturaUL(Redondear.redondearFloat(new Float(precioFacturaUL),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioFacturaUD(Redondear.redondearFloat(new Float(precioFacturaUD),this.numeroDecimalesRedondeo));
    
    // Cambio 20090998 - dmorello, 21/07/2009
    if (Boolean.TRUE.equals(indRedoImpu)) {
        dtoPosicion.setPrecioNetoUL(new Float(precioNetoUL));
    } else {
        dtoPosicion.setPrecioNetoUL(Redondear.redondearFloat(new Float(precioNetoUL),this.numeroDecimalesRedondeo));
    }
    UtilidadesLog.debug("dtoPosicion.getPrecioNetoUL(): " + dtoPosicion.getPrecioNetoUL());
    
    dtoPosicion.setPrecioNetoUD(Redondear.redondearFloat(new Float(precioNetoUD),this.numeroDecimalesRedondeo));
    
    // Cambio 20090998 - dmorello, 21/07/2009
    if (Boolean.TRUE.equals(indRedoImpu)) {
        dtoPosicion.setImporteImpuestoUL(new Float(importeImpuestoUL));
    } else {
        dtoPosicion.setImporteImpuestoUL(Redondear.redondearFloat(new Float(importeImpuestoUL),this.numeroDecimalesRedondeo));
    }
    UtilidadesLog.debug("dtoPosicion.getImporteImpuestoUL(): " + dtoPosicion.getImporteImpuestoUL());
    
    dtoPosicion.setImporteImpuestoUD(Redondear.redondearFloat(new Float(importeImpuestoUD),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioTotalUL(Redondear.redondearFloat(new Float(precioTotalUL),this.numeroDecimalesRedondeo));
    dtoPosicion.setPrecioTotalUD(Redondear.redondearFloat(new Float(precioTotalUD),this.numeroDecimalesRedondeo));
    
    UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion, ArrayList listaSolicitudes): Salida");
	return dtoPosicion;
  }


	public ArrayList actualizarPosiciones(DTOFACConsolidado dtoConsolidado) throws MareException {
		UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosiciones(DTOFACConsolidado dtoConsolidado): Entrada");
		DTOFACCabeceraSolicitud dtoCabeceraConsolidado = dtoConsolidado.getDtoCabecera();
		ArrayList listaPosiciones = dtoConsolidado.getListaPosiciones();
		Iterator listaIte = listaPosiciones.iterator();
		ArrayList listaPosicionesActualizada = new ArrayList();
		
		DTOFACPosicionSolicitud posicion;
        StringBuffer cadenaUpdatePosiciones = new StringBuffer();
		while(listaIte.hasNext()){
			posicion = (DTOFACPosicionSolicitud)listaIte.next();
			posicion.setUnidadesAtendidas(posicion.getUnidadesComprometidas());

			DAOFAC daoFac = new DAOFAC();
			Integer numRegs = daoFac.obtenerTiposOfertaExcluidos(posicion.getOidPais(), posicion.getTipoOferta(),posicion.getFecha());
			if( numRegs.equals( new Integer(1)) && 
                (posicion.getPrecioCatalogoUL().floatValue()==0.0 || 
                posicion.getPrecioContableUL().floatValue()==0.0)) {
                    posicion.setIndicadorNoImprimible(new Boolean (true)); 
			} else 
            {
                posicion.setIndicadorNoImprimible(new Boolean(false));
            }
          DAOMAEProductos daoMAEProductos = new DAOMAEProductos();
          RecordSet r = daoMAEProductos.obtenerDatosProductoFacturacion(posicion.getProducto());
          
          posicion.setProducto(Long.valueOf(r.getValueAt(0,"OID").toString()));
          if (r.getValueAt(0,"CODIGO") != null){
              posicion.setDescripcionSAP(r.getValueAt(0,"CODIGO").toString());
          }
          if (r.getValueAt(0,"INDICADOR") != null){
              posicion.setIndicadorDentroFueraCajaBolsa(r.getValueAt(0,"INDICADOR").toString());
          }
				
				
			posicion.setNumeroConsolidado(new Long(dtoCabeceraConsolidado.getNumeroSolicitud().longValue()));
			DAOSolicitudCabecera daoSolicitudCabecera = new DAOSolicitudCabecera();
            cadenaUpdatePosiciones.append(daoSolicitudCabecera.actualizarPosicionPerf(posicion).toString());
			listaPosicionesActualizada.add(posicion);
		}//fin del bucle while
    
     BelcorpService bs = BelcorpService.getInstance();
     try {
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", cadenaUpdatePosiciones.toString());
     } catch (Exception e) {
       throw new MareException(e,UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }
    
		UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosiciones(DTOFACConsolidado dtoConsolidado): Salida");
		return listaPosicionesActualizada;
	}
    
    public StringBuffer generaActualizarPosiciones(DTOFACConsolidado dtoConsolidado) throws MareException {
		DTOFACCabeceraSolicitud dtoCabeceraConsolidado = dtoConsolidado.getDtoCabecera();
		ArrayList listaPosiciones = dtoConsolidado.getListaPosiciones();
		Iterator listaIte = listaPosiciones.iterator();
		
		DTOFACPosicionSolicitud posicion;
        StringBuffer cadenaUpdatePosiciones = new StringBuffer();
		while(listaIte.hasNext()){
			posicion = (DTOFACPosicionSolicitud)listaIte.next();
			posicion.setUnidadesAtendidas(posicion.getUnidadesComprometidas());
			
			posicion.setNumeroConsolidado(new Long(dtoCabeceraConsolidado.getNumeroSolicitud().longValue()));
			DAOSolicitudCabecera daoSolicitudCabecera = new DAOSolicitudCabecera();
            cadenaUpdatePosiciones.append(daoSolicitudCabecera.actualizarPosicionPerf(posicion).toString());
        }
    
    
		UtilidadesLog.info("MONProcesosFacturacionBean.actualizarPosiciones(DTOFACConsolidado dtoConsolidado): Salida");
		return cadenaUpdatePosiciones;
	}

	//buscar de la lista de solicitudes la que tenga el valor m�ximo en 'importeFleteTotalLocal'
	private DTOFACCabeceraSolicitud buscarMAXImporteFleteTotalLocal(ArrayList listaSolicitudes) 
		throws MareException {
		
		UtilidadesLog.info("MONProcesosFacturacionBean.buscarMAXImporteFleteTotalLocal(ArrayList listaSolicitudes): Entrada");
		
		DTOFACCabeceraSolicitud solicitudTemp = null;
		DTOFACCabeceraSolicitud solicitudTempAux = null;
		int longitud = 0;
		float maxImporteFleteTotalLocal = 0;

		if (listaSolicitudes != null) {
			longitud = listaSolicitudes.size();
		}

		for (int i = 0; i < longitud; i++) {
			solicitudTempAux = (DTOFACCabeceraSolicitud) listaSolicitudes.get(i);
			if (solicitudTempAux.getImporteFleteTotalLocal() != null) {
				if(Math.abs(solicitudTempAux.getImporteFleteTotalLocal().floatValue()) > maxImporteFleteTotalLocal ) {
					solicitudTemp = solicitudTempAux;
					maxImporteFleteTotalLocal = Math.abs(solicitudTemp.getImporteFleteTotalLocal().floatValue());
				}
			}	
		}
				
		UtilidadesLog.info("MONProcesosFacturacionBean.buscarMAXImporteFleteTotalLocal(ArrayList listaSolicitudes): Salida");
		return solicitudTemp;
	}

	//De la lista de solicitudes se seleciona la que tenga el numeroSecuenciaZonaRuta menor
	private Long minimoSecuencia(ArrayList listaSolicitudes, ArrayList secuencia) throws MareException {

		UtilidadesLog.info("MONProcesosFacturacionBean.minimoSecuencia(ArrayList listaSolicitudes, ArrayList secuencia): Entrada");
		DTOSecuenciaSolicitudes dtoSecuencia=null;
		Long secuenciaMinima = null;
		DTOFACCabeceraSolicitud solicitud = null;

		
		for(int i=0;i< listaSolicitudes.size(); i++ ){
			secuenciaMinima = ((DTOSecuenciaSolicitudes)secuencia.get(0)).getSecuencia();
			solicitud = (DTOFACCabeceraSolicitud)listaSolicitudes.get(i);
			for(int j=1;j < secuencia.size(); j++){
				dtoSecuencia = (DTOSecuenciaSolicitudes)secuencia.get(j);
				if(dtoSecuencia.getOidZona().longValue() == solicitud.getZona().longValue() &&
					dtoSecuencia.getOidTipoSolicitud().longValue() == solicitud.getTipoSolicitud().longValue() ){
						if(dtoSecuencia.getSecuencia().longValue() < secuenciaMinima.longValue()){
							secuenciaMinima = dtoSecuencia.getSecuencia();
						}
				
				}
			}
		}
					
		UtilidadesLog.info("MONProcesosFacturacionBean.minimoSecuencia(ArrayList listaSolicitudes, ArrayList secuencia): Salida");
		return secuenciaMinima;
	}
	
	// Validaciones
    private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
		
        UtilidadesLog.info("MONProcesosFacturacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(rExc);
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAcceso: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONProcesosFacturacionBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }

	private MONProcesosPED getMONProcesosPED() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosPED(): Entrada");
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
        "MONProcesosPED", MONProcesosPEDHome.class);
        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosPED(): Salida");
        return ejb;
	}

	private MONFacturacionLocal getMONFacturacionLocal() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONFacturacionLocal(): Entrada");
        MONFacturacionLocalHome localHome = (MONFacturacionLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONFacturacion");
       
        // Se obtiene el interfaz remoto
        MONFacturacionLocal ejb = null;
        try {
			ejb = localHome.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONFacturacionLocal(): Salida");
        return ejb;
	}

	private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONValidacion(): Salida");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONProcesosFacturacionBean.getMONValidacion(): Salida");

        return ejb;
    }

    public DTOSalidaBatch ejecutarProcesosFacturacionBatch(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacionBatch(DTOBatch dtoin): Entrada");
        DTOFACListaConsolidados segmento = (DTOFACListaConsolidados)dtoin.getDTOOnline();          
        this.ejecutarProcesosFacturacion(segmento, Boolean.FALSE); //modificado 
       	DTOSalidaBatch dtoS = new DTOSalidaBatch( 0, "Proceso 'ejecutarProcesosFacturacionBatch' finalizado" );
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacionBatch(DTOBatch dtoin): Salida");
        return dtoS;
    }

    public DTOSalidaBatch ejecutarProcesosFacturacion(DTOFACListaConsolidados segmentoConsolidados, Boolean online) throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacion(DTOFACListaConsolidados segmentoConsolidados, Boolean online): Entrada");
        DAOFACPrecargas dao = new DAOFACPrecargas();
        
        ArrayList secuenciaProcesos = dao.cargarSecuenciaProcesos(ConstantesPED.GP5, null, null);
        
        DAODocuContable daoDC = new DAODocuContable();
        Long pais = ((DTOFACConsolidado)segmentoConsolidados.getListaConsolidados().get(0)).getDtoCabecera().getOidPais();
        Float tasaImpuestoPercepcion = daoDC.obtenerImpuestoPercepcion(pais);
                
        Iterator it = segmentoConsolidados.getListaConsolidados().iterator();
        DTOFACConsolidado consolidado = null;

        MONProcesosFacturacionLocal procesosFacturacionLocal = this.getMONProcesosFacturacionLocal();         
    	while (it.hasNext()){ 
          consolidado = (DTOFACConsolidado)it.next();
          consolidado.setTasaImpuestoPercepcion(tasaImpuestoPercepcion);
            
          if(online.booleanValue() == true){
             UtilidadesLog.debug("*** Es ejecucion online *** ");
             this.ejecutarProcesosFacturacionOnline(consolidado,secuenciaProcesos);
          } else {
             try {
               long comienzo = System.currentTimeMillis();
               consolidado = procesosFacturacionLocal.ejecutarProcesosFacturacion(consolidado, secuenciaProcesos);
               
               if(log.isWarnEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                   UtilidadesLog.warn("Procesamiento Total consolidado: " + consolidado.getDtoCabecera().getOidCabeceraSolicitud() + "  ->>>> " + (System.currentTimeMillis()-comienzo));
             } catch (Exception re) {
               UtilidadesLog.error("*** Error en ejecutarProcesosFacturacion para el consolidado con oid de cabecera ="+consolidado.getDtoCabecera().getOidCabeceraSolicitud(),re);
               UtilidadesLog.error("*** Se continua con el siguiente consolidado ***");
             }
          }
          consolidado = null;
        }
        DTOSalidaBatch dto = new DTOSalidaBatch(0, "Ejecucion MONProcesosFacturacion.ejecutarProcesosFacturacion completado");
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacion(DTOFACListaConsolidados segmentoConsolidados, Boolean online): Salida");
        return dto;
    }
    
    public DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws MareException{
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        String IDPROC = dtoin.getProcessID();
        
        this.obtenerTamanioSubSegmento();
        if (dtoonline instanceof DTOFACListaConsolidados) {
            DTOFACListaConsolidados segmento = (DTOFACListaConsolidados)dtoonline;
            ListIterator it = segmento.getListaConsolidados().listIterator();
            boolean continua = true;
            ArrayList miVector = new ArrayList();
            DTOFACConsolidado elemLista;
            MareDTO Mdto = null;
            int contador = 0;
            while (continua){
                while (it.hasNext()){
                    elemLista = (DTOFACConsolidado)it.next();
                    if (contador < tamanioSubSegmento.longValue()){
                        miVector.add(elemLista);
                        contador++;
                    }else if (contador == tamanioSubSegmento.longValue()){
                        contador = 0;
                        it.previous();
                        break;
                    }else{
                        UtilidadesLog.error("ERROR AL RESEGMENTAR");
                        throw new RuntimeException("Error grave");
                    }                    
                }
                ejecucionBatch(miVector, IDPROC);
                miVector = new ArrayList();
                this.esperarProcesamiento(IDPROC);
                if (!it.hasNext()) {
                    continua = false;
                }
            }
            ProcesoFacturacionHelper.getInstance().finalizarHelper();
            return new DTOSalidaBatch(0,"Ejecucion MONProcesoFacturacion:reSegmentar completada");  
        } else {
            ProcesoFacturacionHelper.getInstance().finalizarHelper();
            throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_025));
        } 
    }
    
    public void esperarProcesamiento(String codigoProceso) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.esperarProcesamiento(String codigoProceso): Entrada");
		//MONBatch monBatch = new MONBatch();
		//UtilidadesLog.debug("*** Se llama a BatchUtil.esperarHijos() con = "+codigoProceso);
        try{
            BatchUtil.esperarHijos(codigoProceso);	
        } catch (InterruptedException ie) {
            UtilidadesLog.info("MONGrupoProceso.esperarProcesamiento(): Salida ");
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        } 
		UtilidadesLog.info("MONFacturacionBean.esperarProcesamiento(String codigoProceso): Salida");
	}
    
    public void ejecucionBatch(ArrayList listaSegmentos, String IDProceso) throws MareException {
        UtilidadesLog.debug(" tamanio de segmento = "+listaSegmentos.size());
        DTOFACListaConsolidados dtoSegmento = new DTOFACListaConsolidados();
        dtoSegmento.setListaConsolidados(listaSegmentos);
        IMareDTO DTOSegmento = dtoSegmento;
        MareBusinessID idMare = new MareBusinessID("FACProcesosFacturacion");
        DTOSubBatch dtoSubBatch = new DTOSubBatch("SUB_SEGMENTO_FAC_", IDProceso, ctx.getCallerPrincipal().getName(), idMare, DTOSegmento);
        try{
            BatchUtil.executeMLN( dtoSubBatch, new MareBusinessID("FACProcesosGP5"));
        }catch(RemoteException re){
            UtilidadesLog.error(re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
        }
        UtilidadesLog.info("MONFacturacionBean.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Salida");
    }
    
    private Long tamanioSubSegmento = null;
    
    protected void obtenerTamanioSubSegmento() throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmento(): Entrada ");
        if (this.tamanioSubSegmento == null){
            MareMGC mgc = new MareMGC();
            mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String salida = (String) mgc.getProperty("application.TamanioSubSegmentoFAC");
            if ((salida == null) || (salida.equals(""))) {
                this.tamanioSubSegmento = null;
            } else {
                this.tamanioSubSegmento = new Long(salida);
            }
        }
        UtilidadesLog.info("MONSecuenciaProcesosBean.obtenerTamanioSegmento(): Salida ");	
    }

	private MONTratamientosContablesLocal getMONTratamientosContablesLocal() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONTratamientosContablesLocal(): Entrada");
       MONTratamientosContablesLocalHome localHome = (MONTratamientosContablesLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONTratamientosContables");
       
        // Se obtiene el interfaz remoto
        MONTratamientosContablesLocal ejb = null;
        try {
			ejb = localHome.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONProcesosFacturacionBean.getMONTratamientosContablesLocal(): Salida");
        return ejb;
	}


    private BusinessFacade getBusinessFacade() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getBusinessFacade(): Entrada");
        BusinessFacadeHome home = (BusinessFacadeHome)UtilidadesEJB.getHome(
          "java:comp/env/BusinessFacade", BusinessFacadeHome.class);
        // Se obtiene el interfaz remoto
        BusinessFacade ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONProcesosFacturacionBean.getBusinessFacade(): Salida");
        return ejb;
    }


    public DTODocumento visualizarDocumentoFacturacion(DTOFACVisualizarDoc dtoEntrada) {
      UtilidadesLog.info("MONProcesosFacturacionBean.visualizarDocumentoFacturacion(DTOFACVisualizarDoc dtoEntrada)");
      return null;
    }

    private BusinessFacadeHome getBusinessFacadeHome() throws NamingException {
        UtilidadesLog.info("MONProcesosFacturacionBean.getBusinessFacadeHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONProcesosFacturacionBean.getBusinessFacadeHome(): Salida");
        return (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/BusinessFacade"), BusinessFacadeHome.class);
    }

    private DTOFACConsolidado actualizacionTablas(DTOFACConsolidado consolidado) throws MareException{
        UtilidadesLog.info("MONProcesosFacturacionBean.actualizacionTablas(DTOFACConsolidado consolidado): Entrada");
      
        DTOFACCabeceraSolicitud dtoConsolidado = consolidado.getDtoCabecera();
        ArrayList listaSolicitudes = consolidado.getListaSolicitudes();
    
        DAOSolicitudCabecera daoSolicitudCabecera=new DAOSolicitudCabecera();
        ArrayList l = daoSolicitudCabecera.generaInsertarConsolidado(dtoConsolidado);
        Long oidConsolidado = (Long)l.get(0);
        StringBuffer cadenaInsert = (StringBuffer)l.get(1);
        l = null;
        dtoConsolidado.setOidCabeceraSolicitud(oidConsolidado);
        consolidado.setDtoCabecera(dtoConsolidado);
        
        cadenaInsert.append(this.actualizarAcumuladosImpuestos(consolidado));
        
        
        DTOSolicCabecSecu dtoSolicSecu = new DTOSolicCabecSecu();
        dtoSolicSecu.setOid(consolidado.getDtoCabecera().getOidCabeceraSolicitud());
        if (consolidado.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria() != null) {
            dtoSolicSecu.setNumSecuenciaFacturacionDiaria(new Long(consolidado.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria().longValue()));
        }
        if (consolidado.getDtoCabecera().getNumeroSecuenciaZonaRuta() != null) {
            dtoSolicSecu.setNumSecuenciaZonasRutas(new Long(consolidado.getDtoCabecera().getNumeroSecuenciaZonaRuta().longValue()));
        }
        dtoSolicSecu.setOidRuta(consolidado.getDtoCabecera().getOidRuta());
        dtoSolicSecu.setSecuenciaRutaTerritorio(consolidado.getDtoCabecera().getSecuenciaRutaTerritorio());
        cadenaInsert.append(actualizarSolicitudCabeceraSecuencia(dtoSolicSecu));

        cadenaInsert.append(daoSolicitudCabecera.generaActualizarCabeceras(consolidado));

        cadenaInsert.append(this.generaActualizarPosiciones(consolidado));
        
        try {
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",cadenaInsert.toString());
        }catch (Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error En el PL: "+cadenaInsert.toString());
            UtilidadesLog.error("*** Error al actualizar el consolidado con oid de cabecera ="+dtoConsolidado.getOidCabeceraSolicitud(),e);
            throw new MareException(e, UtilidadesError.armarCodigoError(e.getMessage()));
        } 
        cadenaInsert = null;
        
        DTOFACCabeceraSolicitud dtoCabeceraSolicitud=null;
        Iterator itLista = listaSolicitudes.iterator();
        MONActualizarEstadoReclamos monReclamosHome = this.getMONActualizarEstadoReclamos();
        try{ 
           while(itLista.hasNext()){
                dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)itLista.next();
                if (dtoCabeceraSolicitud.getModulo().equals(new Long(ConstantesSEG.MODULO_REC))){
                    /* Agregado por REC-001 jrivas */
                    dtoCabeceraSolicitud.setFechaFacturacion(consolidado.getDtoCabecera().getFechaFacturacion());
                    /* Agregado por REC-001 jrivas */
                    monReclamosHome.actualizarEstadoReclamosFacturacion(dtoCabeceraSolicitud);
                }
            }
        }catch(Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error al actualizar los reclamos del consolidado con oid de cabecera ="+dtoConsolidado.getOidCabeceraSolicitud(),e);
            throw new MareException(e, UtilidadesError.armarCodigoError(e.getMessage()));
        } 
        
               
        int cant = listaSolicitudes.size();        
        ArrayList arr = null;
        for (int i=0; i<cant ; i++)  {           
            dtoCabeceraSolicitud  = (DTOFACCabeceraSolicitud) listaSolicitudes.get(i);
            if (dtoCabeceraSolicitud.getIndTSNoConsolidado().booleanValue() &&
                    dtoCabeceraSolicitud.getIndicadorOrdenCompra().booleanValue() &&
                    (dtoCabeceraSolicitud.getIndPedidoPrueba() == null || !dtoCabeceraSolicitud.getIndPedidoPrueba().booleanValue()))  {
                
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                try {
                    arr = new ArrayList();
                    arr.add(dtoCabeceraSolicitud.getOidCabeceraSolicitud().toString());
                    arr.add(dtoCabeceraSolicitud.getTipoSolicitud().toString());
                    arr.add(dtoCabeceraSolicitud.getOidCliente().toString());
                    arr.add(dtoCabeceraSolicitud.getPeriodo().toString());                    
                    bs.dbService.executeProcedure("PQ_PLANI.PED_CARGA_ACUMU_CLIEN_PERI",arr);
                } catch (Exception e) {
                    UtilidadesLog.error("actualizarPosicion: Exception",e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }

    
        UtilidadesLog.info("MONProcesosFacturacionBean.actualizacionTablas(DTOFACConsolidado consolidado): Salida");
        return consolidado;
    }
    
    private StringBuffer actualizarSolicitudCabeceraSecuencia (DTOSolicCabecSecu dtoSolicSecu) throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append("select count(1) from PED_SOLIC_CABEC_SECUE where soca_oid_soli_cabe = "+dtoSolicSecu.getOid());
        
        RecordSet r = null;
        try{
            BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        sb = new StringBuffer();
        if (r== null || r.esVacio() || r.getValueAt(0,0).toString().equals("0")){
            sb.append("INSERT INTO PED_SOLIC_CABEC_SECUE ( SOCA_OID_SOLI_CABE, RUTR_OID_RUTA_TRAN, NUM_SECU_FACT_DIAR,");
            sb.append(" VAL_SECU_RUTA_TERR, NUM_SECU_ZONA_RUTA ) VALUES ( ");
            sb.append(dtoSolicSecu.getOid()).append(" , ");
            sb.append(dtoSolicSecu.getOidRuta()).append(" , ");
            sb.append(dtoSolicSecu.getNumSecuenciaFacturacionDiaria()).append(" , ");
            sb.append("'"+dtoSolicSecu.getSecuenciaRutaTerritorio()+"'").append(" , ");
            sb.append(dtoSolicSecu.getNumSecuenciaZonasRutas()).append(" );");
        }else{
            sb.append("UPDATE PED_SOLIC_CABEC_SECUE SET RUTR_OID_RUTA_TRAN = "+dtoSolicSecu.getOidRuta());
            sb.append(", NUM_SECU_FACT_DIAR = "+dtoSolicSecu.getNumSecuenciaFacturacionDiaria());
            sb.append(", VAL_SECU_RUTA_TERR = '"+dtoSolicSecu.getSecuenciaRutaTerritorio()+"'");
            sb.append(", NUM_SECU_ZONA_RUTA = "+dtoSolicSecu.getNumSecuenciaZonasRutas());
            sb.append(" WHERE SOCA_OID_SOLI_CABE = "+dtoSolicSecu.getOid());
            sb.append(";");
        }        
        return sb;
    }
    
    public void revertirActualizarTablas(DTOFACConsolidado consolidado) throws MareException{
        try{
            revertirActualizarPosiciones(consolidado);
            revertirActualizarEstadoReclamos(consolidado);
            revertirActualizarCabeceras(consolidado);
            reversarActualizarSolicitudCabeceraSecuencia(consolidado);
            reversarActualizarAcumuladosImpuestos(consolidado);
            revertirInsertarConsolidado(consolidado);
        }catch(MareException e){
            UtilidadesLog.error("error al revertirActualizarTablas", e);
            ctx.setRollbackOnly();
            throw e;
        }catch (Exception e){
            UtilidadesLog.error("error al revertirActualizarTablas", e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }
    
    private void revertirInsertarConsolidado(DTOFACConsolidado consolidado) throws MareException{
        StringBuffer consulta = new StringBuffer();
        consulta.append(" DELETE   "); 
        consulta.append(" FROM  ");
        consulta.append(" PED_SOLIC_CABEC_SECUE ");
        consulta.append(" WHERE ");
        consulta.append(" SOCA_OID_SOLI_CABE = "+consolidado.getDtoCabecera().getOidCabeceraSolicitud());
        StringBuffer consulta2 = new StringBuffer();
        consulta2.append(" DELETE   "); 
        consulta2.append(" FROM  ");
        consulta2.append(" PED_SOLIC_CABEC ");
        consulta2.append(" WHERE ");
        consulta2.append(" OID_SOLI_CABE = "+consolidado.getDtoCabecera().getOidCabeceraSolicitud());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
            bs.dbService.executeUpdate(consulta.toString());
            bs.dbService.executeUpdate(consulta2.toString());
        } catch (Exception e) {
            UtilidadesLog.error("actualizarPosicion: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }
    
    private void revertirActualizarPosiciones(DTOFACConsolidado consolidado) throws MareException{
        ArrayList listaPosiciones = consolidado.getListaPosiciones();
        Iterator listaIte = listaPosiciones.iterator();
        DTOFACPosicionSolicitud posicion;
    
        while(listaIte.hasNext()){
            posicion = (DTOFACPosicionSolicitud)listaIte.next();
            StringBuffer consulta = new StringBuffer();
            consulta.append("UPDATE PED_SOLIC_POSIC "); 
            consulta.append(" SET  ");
            consulta.append(" IND_DENT_FUER_CAJA_BOLS   =  NULL, ");
            consulta.append(" PROD_OID_PROD   = NULL  ,");
            consulta.append("  NUM_CONS   = NULL  ,");
            consulta.append(" IND_NO_IMPR   = NULL  ");
            consulta.append(" WHERE OID_SOLI_POSI =  "+posicion.getOidPosicion());
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            try {
                bs.dbService.executeUpdate(consulta.toString());
            } catch (Exception e) {
                UtilidadesLog.error("actualizarPosicion: Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }
    private void revertirActualizarEstadoReclamos(DTOFACConsolidado dtoConsolidado) throws MareException {
        DTOFACCabeceraSolicitud dtoCabeceraSolicitud=null;
        Iterator itLista = dtoConsolidado.getListaSolicitudes().iterator();
        MONActualizarEstadoReclamos monReclamosHome = this.getMONActualizarEstadoReclamos();
        try{ 
           while(itLista.hasNext()){
                dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)itLista.next();
                UtilidadesLog.debug("El modulo origen es: "+dtoCabeceraSolicitud.getModulo());
                if (dtoCabeceraSolicitud.getModulo().equals(new Long(ConstantesSEG.MODULO_REC))){
                    monReclamosHome.actualizarEstadoReclamosRevertirFacturacion(dtoCabeceraSolicitud);
                }
            }
        }catch(Exception e){
            UtilidadesLog.error("*** Error al actualizar los reclamos del consolidado con oid de cabecera ="+dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud(),e);
            throw new MareException(e, UtilidadesError.armarCodigoError(e.getMessage()));
        } 
    }
    
    private void revertirActualizarCabeceras(DTOFACConsolidado dtoConsolidado) throws MareException {
        ArrayList listaCabeceraSolicitud = dtoConsolidado.getListaSolicitudes();

        //crear listaOIDs 
        ArrayList listaOIDs = new ArrayList();
        for (int i = 0; i < listaCabeceraSolicitud.size(); i++) {
            listaOIDs.add(((DTOFACCabeceraSolicitud) listaCabeceraSolicitud.get(i)).getOidCabeceraSolicitud());
        }
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();
         
         consulta.append(" UPDATE ped_solic_cabec "); 
         consulta.append(" SET soca_oid_soli_cabe = NULL,"); 
         consulta.append(" grpr_oid_grup_proc = "+ConstantesPED.GP4+","); 
         consulta.append(" proc_oid_proc ="); 
         consulta.append(" (SELECT proc_oid_proc"); 
         consulta.append(" FROM (SELECT proc_oid_proc"); 
         consulta.append(" FROM ped_secue_proce c,");
         consulta.append(" ped_tipo_solic_pais p, ");
         consulta.append(" ped_tipo_solic_pais p2 ");
         consulta.append(" WHERE p.oid_tipo_soli_pais = "+dtoConsolidado.getDtoCabecera().getTipoSolicitud());
         consulta.append(" AND p2.tsol_oid_tipo_cons = p.oid_tipo_soli_pais ");
         consulta.append(" AND c.tspa_oid_tipo_soli_pais = p2.oid_tipo_soli_pais ");
         consulta.append(" AND c.grpr_oid_grup_proc = "+ConstantesPED.GP4); 
         consulta.append(" ORDER BY cod_secu DESC) a"); 
         consulta.append(" WHERE ROWNUM = 1),"); 
         consulta.append(" FEC_FACT = NULL "); 
         consulta.append(" WHERE oid_soli_cabe IN ("+convertirArrayToString(listaOIDs) +" ) ");

         for(int i=0;i<listaOIDs.size();i++){
            if(listaOIDs.get(i)!=null){
               parametros.add(listaOIDs.get(i));
            }
         }
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         try {
            bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
         } catch (Exception e) {
             UtilidadesLog.error("actualizarCabeceras: Exception",e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
    }
    
    private void reversarActualizarSolicitudCabeceraSecuencia(DTOFACConsolidado dtoConsolidado) throws MareException {
        DTOSolicCabecSecu dtoSolicSecu = new DTOSolicCabecSecu();
        dtoSolicSecu.setOid(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
        dtoSolicSecu.setNumSecuenciaFacturacionDiaria(new Long(dtoConsolidado.getDtoCabecera().getNumeroSecuenciaFacturacionDiaria().longValue()));
        dtoSolicSecu.setNumSecuenciaZonasRutas(new Long(dtoConsolidado.getDtoCabecera().getNumeroSecuenciaZonaRuta().longValue()));
        dtoSolicSecu.setOidRuta(dtoConsolidado.getDtoCabecera().getOidRuta());
        dtoSolicSecu.setSecuenciaRutaTerritorio(dtoConsolidado.getDtoCabecera().getSecuenciaRutaTerritorio());
        
        MONSecuYMarcasChequeoLocal mONSecuYMarcasChequeo = this.getMONSecuYMarcasChequeoLocal();
        mONSecuYMarcasChequeo.reversarActualizarSolicitudCabeceraSecuencia(dtoSolicSecu);
    }
    
    private void reversarActualizarAcumuladosImpuestos (DTOFACConsolidado dtoConsolidado) throws MareException {        
        DTOFACCabeceraSolicitud dtoCabecera = dtoConsolidado.getDtoCabecera();
        ArrayList array = dtoConsolidado.getDatosAcumuladosImpuestos();
        CalculosImporteMoneda calculosImporteMoneda=null;
        SolicitudAcumuladoImpuestosLocalHome solicitudAcumImpHome = this.getSolicitudAcumuladoImpuestosLocalHome();
        SolicitudAcumuladoImpuestosLocal registroSolicitud = null;
        Long clave=null;
        for(int i=0;i<array.size();i++) {
            calculosImporteMoneda = (CalculosImporteMoneda)array.get(i);
            clave = calculosImporteMoneda.getClaveIndicadorImpuestos();
            UtilidadesLog.debug("La clave es: "+clave);
            UtilidadesLog.debug("CalculosImporteMoneda a insertar es: "+calculosImporteMoneda);
            try{
                registroSolicitud = solicitudAcumImpHome.findByUK(dtoCabecera.getOidCabeceraSolicitud(), clave);
                solicitudAcumImpHome.remove(registroSolicitud);                
            } catch (NoResultException fe){
                // si se recibe una FinderException se realiza el create:
            } catch (PersistenceException re){
                UtilidadesLog.error("ERROR AL BORRAR Los acumulados de impuestos para la solicitud "+dtoCabecera.getOidCabeceraSolicitud(), re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }//fin for        
    }
    
    private  String convertirArrayToString(ArrayList array){
        UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Entrada"); 
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
        	StringBuffer sentencia = new StringBuffer("");
			boolean eliminarComa = false;
			for(int i=0;i<array.size();i++){
            		UtilidadesLog.debug("\n array[ ]=" + array.get(i));
            		if(array.get(i)!=null){
            		      	sentencia.append(" ?, ");
							eliminarComa = true;
                	}
           	}
            	//Quitamos la coma y el espacio del final
				if(eliminarComa) {
	                retorno= sentencia.substring(0,sentencia.length()-2);
				}
				UtilidadesLog.debug(retorno);
         
        }else{
            UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Salida 1");
			return "";
			}
        UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Salida 2"); 			
		return retorno;
	}//metodo

    public void ejecutarProcesosFacturacionOnline(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos) throws MareException{    
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacionOnline(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos): Entrada");
        UtilidadesLog.debug("****Metodo MONProcesosFacturacion.ejecutarProcesosFacturacion: Entrada***");
        UtilidadesLog.debug("*** DTOFACConsolidado = "+consolidado);
		
        try{
            DTOFACListaConsolidados auxListaUnConso = new DTOFACListaConsolidados();
            ArrayList auxArrConsols = new ArrayList();
            auxArrConsols.add(consolidado);
            auxListaUnConso.setListaConsolidados(auxArrConsols);
            
            DTOFACConsolidado registro = new DTOFACConsolidado();
            registro = (DTOFACConsolidado)(this.procesar(auxListaUnConso)).get(0);
            this.actualizacionTablas(registro);
        }catch(MareException me){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en la actualizacion de las tablas para el consolidado con oid de cabecera ="+consolidado.getDtoCabecera().getOidCabeceraSolicitud());
            UtilidadesLog.error(me);
            me.printStackTrace();  
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw me;
        }

        // sapaza -- PER-SiCC-2011-0215 -- 11/04/2011                    
        /*DAOSolicitudCabecera daoSolicitudCabecera = new DAOSolicitudCabecera();
        MONTratamientosContablesLocal mONTratamientosContables ;
        try{
            mONTratamientosContables = this.getMONTratamientosContablesLocal();
            mONTratamientosContables.actualizarStockSeguimiento(consolidado);
        } catch(Exception re){
			UtilidadesLog.error("*** Error en mONTratamientosContables.actualizarStockSeguimiento",re);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }*/
			
         DTOProceso dtoProceso;		
        DTOFACCabeceraSolicitud dtoFCS = consolidado.getDtoCabecera();
          
        TreeMap listaProcesosOrdenados = new TreeMap();
    
        Iterator it2 = secuenciaProcesos.iterator();
        while (it2.hasNext()){
            DTOFACSecuenciaProcesos dtoSecuencia = (DTOFACSecuenciaProcesos)it2.next();
            if ( dtoSecuencia.getTipoSolicitud().equals( dtoFCS.getTipoSolicitud()) &&
                      dtoSecuencia.getGrupoProcesos().equals(ConstantesFAC.COD_GP5 )&&
                dtoSecuencia.getCodigoProceso().compareTo(ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE) >=0  ){
                     
                dtoProceso = new DTOProceso();
                //Se recuperan los atributos 'secuencia' y 'oidProceso' 
                dtoProceso.setSecuencia(dtoSecuencia.getSecuencia());
                dtoProceso.setOidProceso(dtoSecuencia.getOidProceso());
                dtoProceso.setBusinessID(dtoSecuencia.getBusinessID()); //anadido incidencia 10119
        
                // Se inserta en un TreeMap para ordenar por secuancia
                listaProcesosOrdenados.put(dtoProceso.getSecuencia(),dtoProceso);
            }
        }
        try{
            MegaProcesadorGPs procesador = new MegaProcesadorGPs();
            procesador.ejecutarGP5(consolidado, listaProcesosOrdenados, Boolean.TRUE);
        }catch(Exception e){
            UtilidadesLog.error("*** Error ejecutando la llamada ejecutarGP5",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("****TERMINA LA TRANSACCION DE UN CONSOLIDADO");
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacionOnline(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos): Salida");    
    }
    
    public DTOFACConsolidado ejecutarProcesosFacturacion(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos) throws MareException{    
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacion(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos): Entrada");
        try{
            DTOFACListaConsolidados auxListaUnConso = new DTOFACListaConsolidados();
            ArrayList auxArrConsols = new ArrayList();
            auxArrConsols.add(consolidado);
            auxListaUnConso.setListaConsolidados(auxArrConsols);
            
            DTOFACConsolidado registro = new DTOFACConsolidado();
            registro = (DTOFACConsolidado)(this.procesar(auxListaUnConso)).get(0);
            consolidado = this.actualizacionTablas(registro);
        }catch(MareException me){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en la actualizacion de las tablas para el consolidado con oid de cabecera ="+consolidado.getDtoCabecera().getOidCabeceraSolicitud());
            UtilidadesLog.error("ERROR",me);
            throw me;
        }
       
        // sapaza -- PER-SiCC-2011-0215 -- 11/04/2011
        /*MONTratamientosContablesLocal mONTratamientosContables ;
        try{
            mONTratamientosContables = this.getMONTratamientosContablesLocal();
            mONTratamientosContables.actualizarStockSeguimiento(consolidado);
        } catch(Exception re){
            UtilidadesLog.error("*** Error en mONTratamientosContables.actualizarStockSeguimiento",re);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }*/
			
        DTOProceso dtoProceso;		
        DTOFACCabeceraSolicitud dtoFCS = consolidado.getDtoCabecera();

        TreeMap listaProcesosOrdenados = new TreeMap();

        Iterator it2 = secuenciaProcesos.iterator();
        while (it2.hasNext()){
            DTOFACSecuenciaProcesos dtoSecuencia = (DTOFACSecuenciaProcesos)it2.next();
            if ( dtoSecuencia.getTipoSolicitud().equals( dtoFCS.getTipoSolicitud()) &&
                      dtoSecuencia.getGrupoProcesos().equals(ConstantesFAC.COD_GP5 )&&
                dtoSecuencia.getCodigoProceso().compareTo(ConstantesFAC.COD_PROC_GENERAR_MARCAS_CHEQUEO) >=0  ){
                     
                dtoProceso = new DTOProceso();
                dtoProceso.setSecuencia(dtoSecuencia.getSecuencia());
                dtoProceso.setOidProceso(dtoSecuencia.getOidProceso());
                dtoProceso.setBusinessID(dtoSecuencia.getBusinessID()); //anadido incidencia 10119
        
                listaProcesosOrdenados.put(dtoProceso.getSecuencia(),dtoProceso);
            }
        }
        try{
            MegaProcesadorGPs procesador = new MegaProcesadorGPs();
            procesador.ejecutarGP5(consolidado, listaProcesosOrdenados, Boolean.FALSE);
        }catch(Exception e){
            UtilidadesLog.error("*** Error ejecutando la llamada ejecutarGP5",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("****TERMINA LA TRANSACCION DE UN CONSOLIDADO");
        UtilidadesLog.info("MONProcesosFacturacionBean.ejecutarProcesosFacturacion(DTOFACConsolidado consolidado, ArrayList secuenciaProcesos): Salida");    
        return consolidado;
    }
    
    private MONProcesosFacturacionLocal getMONProcesosFacturacionLocal() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosFacturacionLocal(): Entrada");
        MONProcesosFacturacionLocalHome localHome = (MONProcesosFacturacionLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONProcesosFacturacion");
        // Se obtiene el interfaz remoto
        MONProcesosFacturacionLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONProcesosFacturacionLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosFacturacionLocal(): Salida");
        return ejb;
    }
    
    // a�adido por incidencia 13532
    public void continuarFacturacion(Long oidSolicitud, Boolean estado) throws MareException{
        UtilidadesLog.info("MONProcesosFacturacionBean.continuarFacturacion(Long oidSolicitud, Boolean estado): Entrada");
        ArrayList listaOIDs = new ArrayList();
        listaOIDs.add(oidSolicitud);
        DAOSolicitudCabecera daoSC =  new DAOSolicitudCabecera();
        ArrayList cabeceras = daoSC.obtenerCabecerasSolicitud(listaOIDs);
        DTOFACCabeceraSolicitud cabeceraConsolidado = (DTOFACCabeceraSolicitud)cabeceras.get(0);
        DTOSolicitudValidacion dtoSolicitud = new DTOSolicitudValidacion();
        dtoSolicitud.setOidSolicitud(oidSolicitud);
        DAOFACReversion daoR = new DAOFACReversion();
        ArrayList solicitudes = daoR.obtenerSolicitudesOrigen(dtoSolicitud);
        Iterator itSolicitudes = solicitudes.iterator();
        listaOIDs.clear();
        DTOFACCabeceraSolicitud cabecera = null;
        while(itSolicitudes.hasNext()){
            cabecera = (DTOFACCabeceraSolicitud)itSolicitudes.next();
            listaOIDs.add(cabecera.getOidCabeceraSolicitud());
        }
        ArrayList posiciones = daoSC.obtenerPosicionesCabeceras(listaOIDs);
        DTOFACConsolidado consolidado = new DTOFACConsolidado();
        consolidado.setSubaccesoUsuario(cabeceraConsolidado.getSubacceso());  //se necesita para la impresion
        consolidado.setDtoCabecera(cabeceraConsolidado);
        consolidado.setListaSolicitudes(solicitudes);
        consolidado.setListaPosiciones(posiciones);
        
        if(estado.booleanValue() == false){
            MONReversionFACLocal monReversionFAC = this.getMONReversionFACLocal(); 
            monReversionFAC.revertirFacturacion(cabeceraConsolidado);
        }else{
                
            DAOFACPrecargas daoFP = new DAOFACPrecargas();
            
            ArrayList secuenciaProcesos = daoFP.cargarSecuenciaProcesos(ConstantesPED.GP5,ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC,consolidado.getDtoCabecera().getTipoSolicitud());
                        
            if(secuenciaProcesos.size() != 0){
                DTOProceso dtoProceso;		
                DAOSolicitudCabecera daoSolicitudCabecera = new DAOSolicitudCabecera();
                TreeMap listaProcesosOrdenados = new TreeMap();
                
                Iterator it = secuenciaProcesos.iterator();
                while (it.hasNext()){
                    DTOFACSecuenciaProcesos dtoSecuencia = (DTOFACSecuenciaProcesos)it.next();
                    dtoProceso = new DTOProceso();
                    dtoProceso.setSecuencia(dtoSecuencia.getSecuencia());
                    dtoProceso.setOidProceso(dtoSecuencia.getOidProceso());
                    dtoProceso.setBusinessID(dtoSecuencia.getBusinessID()); 
                    listaProcesosOrdenados.put(dtoProceso.getSecuencia(),dtoProceso);
                }
                BusinessFacade businesFacade;
                try{
                     businesFacade = this.getBusinessFacade();
                }catch(Exception e){
                    UtilidadesLog.error("*** Error al obtener el BusinessFacade",e);
                    ctx.setRollbackOnly();
                    return;	
                }       
                Iterator itOrdenado = listaProcesosOrdenados.values().iterator();
                while (itOrdenado.hasNext()){
                    dtoProceso = (DTOProceso)itOrdenado.next(); 
                    try{
                        UtilidadesLog.debug("*** Se ejecuta el IDBUSINESS: "+ dtoProceso.getBusinessID());
                        consolidado.setIndOnline(Boolean.TRUE);
                        businesFacade.execute(consolidado,new MareBusinessID(dtoProceso.getBusinessID()));    
                        consolidado.getDtoCabecera().setProceso(dtoProceso.getOidProceso());
                        consolidado.getDtoCabecera().setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
                        daoSolicitudCabecera.actualizarProcesoEstado(consolidado.getDtoCabecera());
                    }catch (Exception e){
                        UtilidadesLog.error("*** Error ejecutando la llamada con businesFacade.execute: " + dtoProceso.getBusinessID(),e);
                        ctx.setRollbackOnly();
                        return ;
                    }		
                }
            } //fin del if secuenciaProcesos.size != 0
        }        
        UtilidadesLog.info("MONProcesosFacturacionBean.continuarFacturacion(Long oidSolicitud, Boolean estado): Salida");
    }
    
    
    private StringBuffer actualizarAcumuladosImpuestos (DTOFACConsolidado dtoConsolidado) throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.actualizarAcumuladosImpuestos(DTOFACConsolidado dtoConsolidado): Entrada");
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("El dtoConsolidado que llega es: "+dtoConsolidado);
        
        DTOFACCabeceraSolicitud dtoCabecera = dtoConsolidado.getDtoCabecera();
        ArrayList array = dtoConsolidado.getDatosAcumuladosImpuestos();
        CalculosImporteMoneda calculosImporteMoneda=null;
        StringBuffer acumulado = new StringBuffer();
        Long clave=null;    
        Float baseImponible = new Float(0);
        Long oidTasaImpuesto = null;

        for(int i=0;i<array.size();i++) {
            calculosImporteMoneda = (CalculosImporteMoneda)array.get(i);
            clave = calculosImporteMoneda.getClaveIndicadorImpuestos();
            if (calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue() > baseImponible.floatValue()) {
               baseImponible = new Float(calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue());
               oidTasaImpuesto = new Long(calculosImporteMoneda.getClaveIndicadorImpuestos().longValue());
            }
            if (existeAcumulado(dtoCabecera.getOidCabeceraSolicitud(),clave)){
                acumulado.append(generarUpdateAcumulado(calculosImporteMoneda, dtoCabecera.getOidCabeceraSolicitud(),clave));
            }else{
                acumulado.append(generarInsertAcumulado(calculosImporteMoneda, dtoCabecera.getOidCabeceraSolicitud(),clave));
            }
        }
        /* Agregado por Cambio FAC-001 ------ AL */
        acumulado.append(this.calcularIVAasumidoEmpresa(dtoConsolidado, oidTasaImpuesto, dtoConsolidado.getDtoCabecera().getNumeroDecimalesRedondeo()).toString());
        /* Agregado por Cambio FAC-001 ------ AL */

        return acumulado;
    }
    
    private boolean existeAcumulado (Long cabecera, Long tasaImpuesto) throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append(" select count(1) from ped_solic_acumu_impue where soca_oid_soli_cabe = "+cabecera+" and taim_oid_tasa_impu = "+tasaImpuesto);
        RecordSet r = null;
        try{
            r = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        if (r == null || r.esVacio() || r.getValueAt(0,0).toString().equals("0")){
            return false;
        }else{
            return true;
        }    
    }
    
    private StringBuffer generarInsertAcumulado (CalculosImporteMoneda c , Long cabecera, Long tasaImpuesto){
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ped_solic_acumu_impue ");
        sb.append(" (oid_acum, taim_oid_tasa_impu, soca_oid_soli_cabe, ");
        sb.append(" val_base_impo_posi_loca, val_tota_prec_posi_loca, ");
        sb.append(" val_tota_desc_cabe_loca, val_base_impo_desc_cabe, ");
        sb.append(" val_base_impo_prec_cont, val_base_impo_flet_loca, ");
        sb.append(" val_tota_base_impo_loca, val_tota_impu_loca, ");
        sb.append(" val_base_impo_posi_docu, val_tota_impo_loca, ");
        sb.append(" val_tota_prec_posi_docu, val_tota_desc_cabe_docu, ");
        sb.append(" val_base_impo_desc_cabe_docu, val_base_impo_prec_cont_docu, ");
        sb.append(" val_base_impo_flet_docu, val_tota_base_impo_docu, ");
        sb.append(" val_tota_impu_docu, val_tota_impo_docu ");
        sb.append(" ) ");
        sb.append(" VALUES ( PED_PSAI_SEQ.nextVal ");
        sb.append(" , "+tasaImpuesto);
        sb.append(" , "+cabecera);        
        sb.append(" , "+c.getBaseImponiblePosicionLocal());
        sb.append(" , "+c.getTotalPreciosPosicionLocal());
        sb.append(" , "+c.getTotalDescuentoCabeceraLocal());
        sb.append(" , "+c.getBaseImponibleDescuento3Local()); 
        sb.append(" , "+c.getBaseImponiblePrecioContableLocal());
        sb.append(" , "+c.getBaseImponibleFleteLocal());
        sb.append(" , "+c.getTotalBaseImponibleLocal());
        sb.append(" , "+c.getTotalImpuestosLocal());
        sb.append(" , "+c.getBaseImponiblePosicionesDocumento());        
        sb.append(" , "+c.getTotalImporteLocal());
        sb.append(" , "+c.getTotalPreciosPosicionDocumento());
        sb.append(" , "+c.getTotalDescuentoCabeceraDocumento());
        sb.append(" , "+c.getBaseImponibleDescuento3Documento()); 
        sb.append(" , "+c.getBaseImponiblePrecioContableDocumento());
        sb.append(" , "+c.getBaseImponibleFleteDocumento());
        sb.append(" , "+c.getTotalBaseImponibleDocumento());
        sb.append(" , "+c.getTotalImpuestosDocumento());
        sb.append(" , "+c.getTotalImporteDocumento());        
        sb.append(");");
        
        return sb;
    }
    
    private StringBuffer generarUpdateAcumulado (CalculosImporteMoneda c , Long cabecera, Long tasaImpuesto){
        StringBuffer sb = new StringBuffer();
        sb.append("update ped_solic_acumu_impue set ");
        sb.append(" val_base_impo_posi_loca= "+c.getBaseImponiblePosicionLocal());
        sb.append(" , val_tota_prec_posi_loca= "+c.getTotalPreciosPosicionLocal());
        sb.append(" , val_tota_desc_cabe_loca=  "+c.getTotalDescuentoCabeceraLocal());
        sb.append(" ,val_base_impo_desc_cabe_loca= "+c.getBaseImponibleDescuento3Local()); 
        sb.append(" , val_base_impo_prec_cont_loca=  "+c.getBaseImponiblePrecioContableLocal());
        sb.append(" ,val_base_impo_flet_loca=  "+c.getBaseImponibleFleteLocal());
        sb.append(" , val_base_impo_tota_loca=  "+c.getTotalBaseImponibleLocal());
        sb.append(" ,val_tota_impu_loca=  "+c.getTotalImpuestosLocal());
        sb.append(" , val_tota_impo_loca=  "+c.getTotalImporteLocal());
        sb.append(" , val_base_impo_posi_docu="+c.getBaseImponiblePosicionesDocumento());  
        sb.append(" ,val_tota_prec_posi_docu=  "+c.getTotalPreciosPosicionDocumento());
        sb.append(" , val_tota_desc_cabe_docu=  "+c.getTotalDescuentoCabeceraDocumento());
        sb.append(" ,val_base_impo_desc_cabe_docu= "+c.getBaseImponibleDescuento3Documento()); 
        sb.append(" , val_base_impo_prec_cont_docu=  "+c.getBaseImponiblePrecioContableDocumento());
        sb.append(" ,val_base_impo_flet_docu=  "+c.getBaseImponibleFleteDocumento());
        sb.append(" , val_base_impo_tota_docu=  "+c.getTotalBaseImponibleDocumento());
        sb.append(" ,val_tota_impu_docu=  "+c.getTotalImpuestosDocumento());
        sb.append(" , val_tota_impo_docu = "+c.getTotalImporteDocumento());
        sb.append(" where soca_oid_soli_cabe = "+cabecera);
        sb.append(" and taim_oid_tasa_impu = "+tasaImpuesto);
        sb.append(";");
        return sb;
    }
    
    private MONImpresionSICC getMONImpresionSICC() throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONImpresionSICC(): Entrada");
        // Se obtiene el interfaz home
        MONImpresionSICCHome home = (MONImpresionSICCHome)UtilidadesEJB.getHome(
            "MONImpresionSICC", MONImpresionSICCHome.class);            
        // Se obtiene el interfaz remoto
        MONImpresionSICC ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMOMONImpresionSICC",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONImpresionSICC(): Salida");
        return ejb;
    }
        
    private MONReversionFACLocal getMONReversionFACLocal() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONReversionFACLocal(): Entrada");
        MONReversionFACLocalHome localHome = (MONReversionFACLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONReversionFAC");
       
        // Se obtiene el interfaz remoto
        MONReversionFACLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {		
            UtilidadesLog.error("*** Error en getMONReversionFACLocal",e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONReversionFACLocal(): Salida");
        return ejb;
    }

    private MONFacturacionLocalHome getMONFacturacionLocalHome() throws NamingException{
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONFacturacionLocalHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONFacturacionLocalHome(): Salida");
        return (MONFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONFacturacion");
    }

    private MONTratamientosContablesLocalHome getMONTratamientosContablesLocalHome() throws NamingException{
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONTratamientosContablesLocalHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONTratamientosContablesLocalHome(): Salida");
        return (MONTratamientosContablesLocalHome)context.lookup("java:comp/env/ejb/local/MONTratamientosContables");
    }

    private MONProcesosFacturacionLocalHome getMONProcesosFacturacionLocalHome() throws NamingException{
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosFacturacionLocalHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONProcesosFacturacionLocalHome(): Salida");
        return (MONProcesosFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONProcesosFacturacion");
    }
    
    private SpoolManager getSpoolManager() throws MareException {
        UtilidadesLog.info("MONProcesosFacturacionBean.getSpoolManager(): Entrada");        
        SpoolManagerHome home = (SpoolManagerHome) UtilidadesEJB.getHome("SpoolManager",SpoolManagerHome.class);
        SpoolManager ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getSpoolManager", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONProcesosFacturacionBean.getSpoolManager(): Salida");
        return ejb;
    }
    
    private MONActualizarEstadoReclamos getMONActualizarEstadoReclamos() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONActualizarEstadoReclamos(): Entrada");
        MONActualizarEstadoReclamosHome home = (MONActualizarEstadoReclamosHome)UtilidadesEJB.getHome(
                  "MONActualizarEstadoReclamos", MONActualizarEstadoReclamosHome.class);
        // Se obtiene el interfaz remoto
        MONActualizarEstadoReclamos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {		
            UtilidadesLog.error("*** Error en getMONActualizarEstadoReclamos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONActualizarEstadoReclamos(): Salida");
        return ejb;
    }
    
    private MONSecuYMarcasChequeoLocal getMONSecuYMarcasChequeoLocal() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONSecuYMarcasChequeoLocal(): Entrada");
        MONSecuYMarcasChequeoLocalHome localHome = (MONSecuYMarcasChequeoLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONSecuYMarcasChequeo");
        // Se obtiene el interfaz remoto
        MONSecuYMarcasChequeoLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
      			UtilidadesLog.error("*** Error en getMONSecuYMarcasChequeo",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONProcesosFacturacionBean.getMONSecuYMarcasChequeoLocal(): Salida");
        return ejb;
    }

    private static String SELECTSOLICCABECACUM = "SELECT OID_ACUM, VAL_ACUM_GP4, VAL_ACUM_GP5 FROM PED_SOLIC_CABEC_ACUM WHERE TSPA_OID_TIPO_SOLI_PAIS = ? AND  ZZON_OID_ZONA = ? AND  SBAC_OID_SBAC = ? AND  FEC_PROC = TRUNC(TO_DATE(?,'dd/MM/yyyy')) FOR UPDATE";
    
    private void actualizarAcumuladosSolicitudes(DTOFACConsolidado consolidado) throws MareException{
        try{
            ArrayList solicitudes = consolidado.getListaSolicitudes();
            DTOFACCabeceraSolicitud cabeceraSol = consolidado.getDtoCabecera();
            BelcorpService bs = BelcorpService.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            StringBuffer sb1 = new StringBuffer();
            for (int i = 0; i < solicitudes.size(); i++){
                DTOFACCabeceraSolicitud dto = (DTOFACCabeceraSolicitud)solicitudes.get(i);
                sb1.append(armaQueryUpdate(dto.getTipoSolicitud(), dto.getSubacceso(), dto.getZona(), dto.getFechaPrevistaFacturacion())).append(";");
            }
            
            Vector vec = new Vector();
            vec.add(cabeceraSol.getTipoSolicitud());
            vec.add(cabeceraSol.getZona());
            vec.add(cabeceraSol.getSubacceso());
            vec.add(df.format(cabeceraSol.getFechaPrevistaFacturacion()));
            RecordSet rc = bs.dbService.executePreparedQuery(SELECTSOLICCABECACUM, vec);
            StringBuffer sb = new StringBuffer();
            if (rc.esVacio()){
                UtilidadesLog.debug("VOY A INSERTAR");
                //inserto en este caso
                //throw new MareException("No puede no existir datos en PED_SOLIC_CABEC_ACUM");
                sb.append(" INSERT INTO PED_SOLIC_CABEC_ACUM (OID_ACUM, TSPA_OID_TIPO_SOLI_PAIS, ZZON_OID_ZONA, SBAC_OID_SBAC, FEC_PROC, VAL_ACUM_GP1, VAL_ACUM_GP2, VAL_ACUM_GP3, VAL_ACUM_GP4, VAL_ACUM_GP5)");
                sb.append(" VALUES (ped_scaa_seq.NEXTVAL,");
                sb.append(cabeceraSol.getTipoSolicitud()).append(" , ").append(cabeceraSol.getZona()).append(" , ");
                sb.append(cabeceraSol.getSubacceso()).append(" , to_date('");
                sb.append(df.format(cabeceraSol.getFechaPrevistaFacturacion())).append("', 'dd/MM/yyyy'), 0, 0, 0, 0, 1) ");
            }else{
                UtilidadesLog.debug("VOY A UPDATE");
                long gp5 = Long.valueOf(rc.getValueAt(0,"VAL_ACUM_GP5").toString()).longValue();
                sb.append("UPDATE PED_SOLIC_CABEC_ACUM SET  VAL_ACUM_GP5= ");
                sb.append((gp5+1));
                sb.append("  WHERE OID_ACUM = ");
                sb.append(rc.getValueAt(0,"OID_ACUM").toString());
            }
            sb1.append(sb).append(";");
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb1.toString());
            //bs.dbService.executeUpdate(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            ctx.setRollbackOnly();
            if (e instanceof MareException) throw (MareException)e;                        
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private String armaQueryUpdate(Long tipoSolic, Long subacceso, Long zona, java.util.Date fecha){
        StringBuffer sb = new StringBuffer(" UPDATE ped_solic_cabec_acum ");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        sb.append(" SET val_acum_gp4 = (SELECT VAL_ACUM_GP4-1 ");
        sb.append(" FROM ped_solic_cabec_acum ");
        sb.append(" WHERE tspa_oid_tipo_soli_pais = "+tipoSolic);
        sb.append(" AND zzon_oid_zona = "+zona);
        sb.append(" AND sbac_oid_sbac = "+subacceso);
        sb.append(" AND FEC_PROC = TRUNC(TO_DATE('"+df.format(fecha)+"','dd/MM/yyyy'))),");
        sb.append(" val_acum_gp5 = (SELECT VAL_ACUM_GP5+1");
        sb.append(" FROM ped_solic_cabec_acum ");
        sb.append(" WHERE tspa_oid_tipo_soli_pais = "+tipoSolic);
        sb.append(" AND zzon_oid_zona = "+zona);
        sb.append(" AND sbac_oid_sbac = "+subacceso);
        sb.append(" AND FEC_PROC = TRUNC(TO_DATE('"+df.format(fecha)+"','dd/MM/yyyy'))) ");
        sb.append(" WHERE oid_acum = ");
        sb.append(" (SELECT oid_acum ");
        sb.append(" FROM ped_solic_cabec_acum ");
        sb.append(" WHERE tspa_oid_tipo_soli_pais = "+tipoSolic);
        sb.append(" AND zzon_oid_zona = "+zona);
        sb.append(" AND sbac_oid_sbac = "+subacceso);
        sb.append(" AND FEC_PROC = TRUNC(TO_DATE('"+df.format(fecha)+"','dd/MM/yyyy')))");
        return sb.toString();
    }


    public void actualizacionTablasNuevo(DTOFACConsolidado consolidado) throws MareException{
        try{
            this.actualizarAcumuladosSolicitudes(consolidado);
        }catch (MareException e){
            UtilidadesLog.error("ERROR al actualizar tablas",e);
            ctx.setRollbackOnly();
            throw e;
        }        
    }

  private MONImpresionSICCHome getMONImpresionSICCHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONImpresionSICCHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONImpresionSICC"), MONImpresionSICCHome.class);
  }

  private MONTratamientosContablesHome getMONTratamientosContablesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONTratamientosContablesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONTratamientosContables"), MONTratamientosContablesHome.class);
  }
  
  
  public HashMap obtenerPosicionesCabeceras (ArrayList listaOIDs, Long oidIdioma) throws MareException {
    UtilidadesLog.info("MONProcesosFacturacion.obtenerPosicionesCabeceras (ArrayList listaOIDs, Long oidIdioma): Entrada");
    
    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
    Vector params = new Vector();
    params.add(listaOIDs.get(0)); //oidConsolidado
    params.add(oidIdioma); //oidIdioma
    RecordSet rs = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.FAC_PR_OBTIE_POSIC_CABEC", params);
    /*StringBuffer query = (StringBuffer)this.generarQueryPosiciones(listaOIDs, oidIdioma);
    RecordSet rs = (RecordSet)this.executeQuery(query.toString());*/
    
    HashMap hashPosiciones = (HashMap)this.armarHashPosiciones(rs);  
    UtilidadesLog.info("MONProcesosFacturacion.obtenerPosicionesCabeceras (ArrayList listaOIDs, Long oidIdioma): Salida");
    return hashPosiciones;
  }//metodo
  
   //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
   public HashMap obtenerPosicionesCabeceras (Long oidCabeceraSolicitud, Long oidIdioma) throws MareException {
     UtilidadesLog.info("MONProcesosFacturacion.obtenerPosicionesCabeceras (Long oidCabeceraSolicitud, Long oidIdioma): Entrada");
     
     Vector params = new Vector();
     params.add(oidCabeceraSolicitud); //oidConsolidado
     params.add(oidIdioma); //oidIdioma
     RecordSet rs = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.FAC_PR_OBTIE_POSIC_CABEC", params);
     
     HashMap hashPosiciones = (HashMap)this.armarHashPosiciones(rs);  
     UtilidadesLog.info("MONProcesosFacturacion.obtenerPosicionesCabeceras (Long oidCabeceraSolicitud, Long oidIdioma): Salida");
     return hashPosiciones;
   }
   
  /**
   * CHANGELOG
   * ---------
   * 03/07/2009 - dmorello, Cambio 20090908
   *     Se recupera el OID del documento legal de referencia
   *     en caso de que la solicitud tratada sea un reclamo
   * 15/07/2009 - dmorello, Incidencia 20091008
   *     Se modifica la forma de recuperar el OID del documento legal de referencia
   *     usando ROWNUM = 1 en lugar de DISTINCT
   * 17/07/2009 - dmorello, Incidencia 20091032
   *     Se agrega como condicion para recuperar el OID del documento legal de referencia
   *     que la solicitud en cuestion sea negativa
   * 24/07/2009 - dmorello, Cambio 20091019
   *     El OID del doc legal de referencia se toma de la primera linea de documento hallada
   *     cuyo codigo de venta (obtenido de PED_SOLIC_POSIC) sea igual al de la posicion tratada
   */
  public StringBuffer generarQueryPosiciones(ArrayList listaOIDs, Long oidIdioma) {
    UtilidadesLog.info("MONProcesosFacturacion.generarQueryPosiciones (ArrayList listaOIDs, Long oidIdioma): Entrada");
    StringBuffer sql = new StringBuffer();
    
    sql.append("SELECT POD.OCAT_OID_CATAL CATALOGO, PED.VAL_CODI_VENT AS CODIGOVENTA, ");
    sql.append("MP.DES_CORT DESCRIPCIONSAP,");
    sql.append("PED.VAL_IMPO_DES_SIN_IMP_TOTA_DOCU AS IMPORTEDESCUENTOSINIMPUESTOSTD,");
    sql.append("PED.VAL_IMPO_DES_SIN_IMP_TOTA AS IMPORTEDESCUENTOSINIMPUESTOSTL,");
    sql.append("PED.VAL_IMPO_DES_SIN_IMP_UNIT_LOCA AS IMPORTEDESCUENTOSINIMPUESTOSUL,");
    sql.append("PED.VAL_IMPO_DES_SIN_IMP_UNIT_DOCU AS IMPORTEDESCUENTOSINIMPUESTOSUD,");
    sql.append("PED.VAL_IMPO_DESC_TOTA_DOCU AS IMPORTEDESCUENTOTD,");
    sql.append("PED.VAL_IMPO_DESC_TOTA_LOCA AS IMPORTEDESCUENTOTL,");
    sql.append("PED.VAL_IMPO_DESC_UNIT_DOCU AS IMPORTEDESCUENTOUD,");
    sql.append("PED.VAL_IMPO_DESC_UNIT_LOCA AS IMPORTEDESCUENTOUL,");
    sql.append("PED.VAL_IMPO_IMPU_TOTA_DOCU AS IMPORTEIMPUESTOTD,");
    sql.append("PED.VAL_IMPO_IMPU_TOTA_LOCA AS IMPORTEIMPUESTOTL,");
    sql.append("PED.VAL_IMPO_IMPU_UNIT_DOCU AS IMPORTEIMPUESTOUD,");
    sql.append("PED.VAL_IMPO_IMPU_UNIT_LOCA AS IMPORTEIMPUESTOUL,");
    sql.append("MP.COD_IND_DENT_CAJA AS INDICADORDENTROFUERACAJABOLSA,");
    
    // vbongiov -- RI 20080679 --3/09/2008
    sql.append("MP.IND_PROD_SERV AS INDICADORDPRODSERVICIO,");
    
    sql.append("PED.TAIM_OID_TASA_IMPU AS INDICADORIMPUESTOS, ");
    sql.append("(SELECT case when COUNT(*) > 0 then 1 else 0 end "); 
    sql.append("FROM FAC_TIPO_OFERT_EXCLU TOE ");
    sql.append("WHERE TOE.TOFE_OID_TIPO_OFER(+) = TOF.OID_TIPO_OFER  ");
    sql.append("AND TOE.PAIS_OID_PAIS = PSC.PAIS_OID_PAIS ");
    sql.append("AND ped.VAL_PREC_CATA_UNIT_LOCA = 0 ");
    sql.append("AND ped.VAL_PREC_CONT_UNIT_LOCA = 0 ");
    sql.append("and nvl(pod.TOFE_OID_TIPO_OFER, -1) = (case when pod.TOFE_OID_TIPO_OFER is not null then TOE.TOFE_OID_TIPO_OFER else -1 end) ");
    sql.append("AND TOE.FEC_DESD <= psc.FEC_CRON ");
    sql.append("AND TOE.FEC_HAST >= psc.FEC_CRON) as INDICADORNOIMPRIMIBLE, ");
    sql.append("MP.NEGO_OID_NEGO NEGOCIOPRODUCTO, PED.NUM_CONS AS NUMEROCONSOLIDADO,");
    sql.append("PED.COD_POSI AS NUMEROPOSICION, PED.SOCA_OID_SOLI_CABE AS OIDCABECERA,");
    sql.append("PED.FOPA_OID_FORM_PAGO AS OIDFORMAPAGO,");
    sql.append("PED.OID_SOLI_POSI AS OIDPOSICION, POD.NUM_PAGI_CATA PAGINA,");
    sql.append("PED.VAL_PREC_CATA_TOTA_DOCU AS PRECIOCATALOGOTD,");
    sql.append("PED.VAL_PREC_CATA_TOTA_LOCA_UNID AS PRECATALTLUNIDADESDEMANDAREAL,");
    sql.append("PED.VAL_PREC_CATA_TOTA_LOCA AS PRECIOCATALOGOTL,");
    sql.append("PED.VAL_PREC_CATA_UNIT_DOCU AS PRECIOCATALOGOUD,");
    sql.append("PED.VAL_PREC_CATA_UNIT_LOCA AS PRECIOCATALOGOUL,");
    sql.append("PED.VAL_PREC_SIN_IMPU_UNIT_DOCU AS PRECIOCONTABLESINIMPUESTOSUD,");
    sql.append("PED.VAL_PREC_SIN_IMPU_UNIT_LOCA AS PRECIOCONTABLESINIMPUESTOSUL,");
    sql.append("PED.VAL_PREC_CONT_TOTA_DOCU AS PRECIOCONTABLETD,");
    sql.append("PED.VAL_PREC_CONT_TOTA_LOCA AS PRECIOCONTABLETL,");
    sql.append("PED.VAL_PREC_CONTA_UNIT_DOCU AS PRECIOCONTABLEUD,");
    sql.append("PED.VAL_PREC_CONT_UNIT_LOCA AS PRECIOCONTABLEUL,");
    sql.append("PED.VAL_PREC_FACT_TOTA_DOCU AS PRECIOFACTURATD,");
    sql.append("PED.VAL_PREC_FACT_TOTA_LOCA AS PRECIOFACTURATL,");
    sql.append("PED.VAL_PREC_FACT_UNIT_DOCU AS PRECIOFACTURAUD,");
    sql.append("PED.VAL_PREC_FACT_UNIT_LOCA AS PRECIOFACTURAUL,");
    sql.append("PED.VAL_PREC_NETO_TOTA_DOCU AS PRECIONETOTD,");
    sql.append("PED.VAL_PREC_NETO_TOTA_LOCA AS PRECIONETOTL,");
    sql.append("PED.VAL_PREC_NETO_UNIT_DOCU AS PRECIONETOUD,");
    sql.append("PED.VAL_PREC_NETO_UNIT_LOCA AS PRECIONETOUL,");
    sql.append("PED.VAL_PREC_SIN_IMPU_TOTA_DOCU AS PRECIOSINIMPUESTOSTD,");
    sql.append("PED.VAL_PREC_SIN_IMPU_TOTA_LOCA AS PRECIOSINIMPUESTOSTL,");
    sql.append("PED.VAL_PREC_SIN_IMPU_UNIT_DOCU AS PRECIOSINIMPUESTOSUD,");
    sql.append("PED.VAL_PREC_SIN_IMPU_UNIT_LOCA AS PRECIOSINIMPUESTOSUL,");
    sql.append("PED.VAL_PREC_TOTA_TOTA_DOCU AS PRECIOTOTALTD,");
    sql.append("PED.VAL_PREC_TOTA_TOTA_LOCA AS PRECIOTOTALTL,");
    sql.append("PED.VAL_PREC_TOTA_UNIT_DOCU AS PRECIOTOTALUD,");
    sql.append("PED.VAL_PREC_TOTA_UNIT_LOCA AS PRECIOTOTALUL,");
    sql.append("PED.PROD_OID_PROD AS PRODUCTO, PTI.VAL_TASA_IMPU TASAIMPUESTO,");
    sql.append("POD.TOFE_OID_TIPO_OFER TIPOOFERTA,");
    sql.append("PED.NUM_UNID_ATEN AS UNIDADESATENDIDAS,");
    sql.append("PED.NUM_UNID_COMPR AS UNIDADESCOMPROMETIDAS,");
    sql.append("PED.NUM_UNID_DEMA_REAL AS UNIDADESDEMANDAREAL,");
    sql.append("PED.NUM_UNID_POR_ATEN AS UNIDADESPORATENDER, PSC.PAIS_OID_PAIS PAIS,");
    sql.append("PSC.FEC_CRON FECHA, PED.VAL_PORC_DESC AS PORCENTAJEDESCUENTO,");
    sql.append("TOF.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
    sql.append("PED.ESPO_OID_ESTA_POSI AS ESTADO, ");
    sql.append("PED.TPOS_OID_TIPO_POSI AS TIPOPOSICION, ");
    sql.append("  PED.STPO_OID_SUBT_POSI AS SUBTIPOPOSICION,");
    sql.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ", MP.OID_PROD,'MAE_PRODU') DESC_PROD_I18N");
    sql.append(" , ped.ofde_oid_deta_ofer OIDDETAOFER ");   // HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353       
    /* Agregado por Cambio FAC-003 ------ AL */
    sql.append(",MP.VAL_COST_ESTD ");
    /* Agregado por Cambio FAC-003 ------ AL */
    // Cambio 20090908 - dmorello, 29/06/2009
    sql.append(",CASE WHEN psc.soca_oid_docu_refe IS NOT NULL AND psc.modu_oid_modu = ").append(ConstantesSEG.MODULO_REC);
    sql.append("       AND TS.IND_SOLI_NEGA = 1 ");
    sql.append("     THEN (SELECT dcca.oid_cabe ");
    sql.append("             FROM fac_docum_conta_cabec dcca, fac_docum_conta_linea dcla ");
    sql.append("                , ped_solic_posic pos ");
    sql.append("            WHERE psc.soca_oid_docu_refe = dcca.soca_oid_soli_cabe ");
    sql.append("              AND dcca.oid_cabe = dcla.dcca_oid_cabe ");
    sql.append("              AND dcla.prod_oid_prod = ped.prod_oid_prod ");
    sql.append("              AND dcla.sopo_oid_soli_posi = pos.oid_soli_posi ");
    sql.append("              AND (   ");
    sql.append("                      (pos.val_codi_vent IS NULL AND ped.val_codi_vent IS NULL)");
    sql.append("                   OR (pos.val_codi_vent = ped.val_codi_vent)");
    sql.append("              )");
    sql.append("              AND ROWNUM = 1) ");
    sql.append("     ELSE 0 ");
    sql.append(" END documentolegalreferencia ");
    // Fin Cambio 20090908 - dmorello, 29/06/2009
    sql.append(" FROM PED_SOLIC_POSIC ped, ");
    sql.append(" PRE_OFERT_DETAL POD, ");
    sql.append(" MAE_PRODU MP, ");
    sql.append(" PED_SOLIC_CABEC PSC, ");
    sql.append(" PED_TASA_IMPUE PTI, ");
    sql.append(" PRE_TIPO_OFERT TOF ");
    sql.append(",PED_TIPO_SOLIC_PAIS TSP ");
    sql.append(",PED_TIPO_SOLIC TS ");
    
    sql.append(" WHERE POD.OID_DETA_OFER(+) = PED.OFDE_OID_DETA_OFER ");
    sql.append(" AND MP.OID_PROD = PED.PROD_OID_PROD  ");
    sql.append(" AND PED.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
    sql.append(" AND PTI.OID_TASA_IMPU(+) = PED.TAIM_OID_TASA_IMPU ");
    sql.append(" AND TOF.OID_TIPO_OFER(+) = POD.TOFE_OID_TIPO_OFER ");		 
    sql.append(" AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
    sql.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
    
    Iterator it = listaOIDs.iterator();
    sql.append("  AND (");
    int count = 0;
    String oids = "";
    while (it.hasNext()){
      if (count == 0) {
        oids = "'" + ((Long)it.next()).toString() + "'";
      } else { 
        oids += ",'" + ((Long)it.next()).toString() + "'";
      }
      if (count == 999)  {
        sql.append(" PSC.OID_SOLI_CABE IN (" + oids.toString() + ") ");                     
        if (it.hasNext()){
          sql.append("  OR ");
        }                    
        count = 0;
        oids = "";
      } else {
        if (!it.hasNext()){
          sql.append(" PSC.OID_SOLI_CABE IN (" + oids.toString() + ") ");        
        }                    
        count++;            
      } 
        
      if (!it.hasNext()){              
        sql.append(")");
      }
    }
    UtilidadesLog.info("MONProcesosFacturacion.generarQueryPosiciones (ArrayList listaOIDs, Long oidIdioma): Salida");
    return sql;
  }
  
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONProcesosFacturacion.executeQuery(String query): Entrada");
    RecordSet rs = null;    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONProcesosFacturacion.executeQuery(String query): Salida");  
    return rs;
  }

  private HashMap armarHashPosiciones(RecordSet rs) {
    UtilidadesLog.info("MONProcesosFacturacion.armarHashPosiciones (RecordSet rs): Entrada");
    HashMap hashPosiciones = new HashMap();
  	if(!rs.esVacio()){
      int rc = rs.getRowCount();
	  for(int i=0;i<rc;i++){
		DTOFACPosicionSolicitud dtoPS= new DTOFACPosicionSolicitud();

	    dtoPS.setCatalogo(this.bigDecimalToInteger(rs.getValueAt(i,"CATALOGO")));
		dtoPS.setCodigoVenta(this.bigDecimalToString(rs.getValueAt(i,"CODIGOVENTA")));
		dtoPS.setDescripcionSAP(this.bigDecimalToString(rs.getValueAt(i,"DESCRIPCIONSAP")));
		dtoPS.setImporteDescuentoSinImpuestosTD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOSTD")));
        dtoPS.setImporteDescuentoSinImpuestosTL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOSTL")));
		dtoPS.setImporteDescuentoSinImpuestosUL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOSUL")));
		dtoPS.setImporteDescuentoSinImpuestosUD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOSINIMPUESTOSUD")));
		dtoPS.setImporteDescuentoTD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTD")));
		dtoPS.setImporteDescuentoTL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTL")));
		dtoPS.setImporteDescuentoUD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOUD")));
        if (dtoPS.getImporteDescuentoUD() == null) {        
          dtoPS.setImporteDescuentoUD(new Float("0"));
        }
		dtoPS.setImporteDescuentoUL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOUL")));
		if (dtoPS.getImporteDescuentoUL() == null) {
          dtoPS.setImporteDescuentoUL(new Float("0"));
        }
		dtoPS.setImporteImpuestoTD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEIMPUESTOTD")));
		dtoPS.setImporteImpuestoTL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEIMPUESTOTL")));
		dtoPS.setImporteImpuestoUD(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEIMPUESTOUD")));
		dtoPS.setImporteImpuestoUL(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEIMPUESTOUL")));
		dtoPS.setIndicadorDentroFueraCajaBolsa(this.bigDecimalToString(rs.getValueAt(i,"INDICADORDENTROFUERACAJABOLSA")));
        
        // vbongiov -- RI 20080679 --3/09/2008
        dtoPS.setIndicadorProductoServicio(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORDPRODSERVICIO")));
        
		dtoPS.setIndicadorImpuestos(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORIMPUESTOS")));
        dtoPS.setIndicadorNoImprimible(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORNOIMPRIMIBLE")));	
		dtoPS.setNegocioProducto(this.bigDecimalToLong(rs.getValueAt(i,"NEGOCIOPRODUCTO")));
		dtoPS.setNumeroConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"NUMEROCONSOLIDADO")));
		dtoPS.setNumeroPosicion(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROPOSICION")));        
		dtoPS.setOidCabecera(this.bigDecimalToLong(rs.getValueAt(i,"OIDCABECERA")));
		dtoPS.setOidFormaPago(this.bigDecimalToLong(rs.getValueAt(i,"OIDFORMAPAGO")));
		dtoPS.setOidPosicion(this.bigDecimalToLong(rs.getValueAt(i,"OIDPOSICION")));
		dtoPS.setPagina(this.bigDecimalToInteger(rs.getValueAt(i,"PAGINA")));
		dtoPS.setPrecioCatalogoTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCATALOGOTD")));
		dtoPS.setPrecioCatalogoTLUnidadesDemandaReal(this.bigDecimalToFloat(rs.getValueAt(i,"PRECATALTLUNIDADESDEMANDAREAL")));
		dtoPS.setPrecioCatalogoTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCATALOGOTL")));
		dtoPS.setPrecioCatalogoUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCATALOGOUD")));
		dtoPS.setPrecioCatalogoUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCATALOGOUL")));
		dtoPS.setPrecioContableSinImpuestosUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLESINIMPUESTOSUD")));
		dtoPS.setPrecioContableSinImpuestosUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLESINIMPUESTOSUL")));
		dtoPS.setPrecioContableTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLETD")));
		dtoPS.setPrecioContableTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLETL")));
		dtoPS.setPrecioContableUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLEUD")));
		dtoPS.setPrecioContableUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLEUL")));
		dtoPS.setPrecioFacturaTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOFACTURATD")));
		dtoPS.setPrecioFacturaTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOFACTURATL")));
		dtoPS.setPrecioFacturaUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOFACTURAUD")));
		dtoPS.setPrecioFacturaUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOFACTURAUL")));
		dtoPS.setPrecioNetoTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIONETOTD")));
		dtoPS.setPrecioNetoTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIONETOTL")));
		dtoPS.setPrecioNetoUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIONETOUD")));
		dtoPS.setPrecioNetoUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIONETOUL")));
		dtoPS.setPrecioSinImpuestosTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOSINIMPUESTOSTD")));
		dtoPS.setPrecioSinImpuestosTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOSINIMPUESTOSTL")));
		dtoPS.setPrecioSinImpuestosUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOSINIMPUESTOSUD")));
		dtoPS.setPrecioSinImpuestosUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOSINIMPUESTOSUL")));
		dtoPS.setPrecioTotalTD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTD")));
		dtoPS.setPrecioTotalTL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTL")));
		dtoPS.setPrecioTotalUD(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALUD")));
		dtoPS.setPrecioTotalUL(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALUL")));
        dtoPS.setProducto(this.bigDecimalToLong(rs.getValueAt(i,"PRODUCTO")));
		dtoPS.setTasaImpuesto(this.bigDecimalToFloat(rs.getValueAt(i,"TASAIMPUESTO")));
		dtoPS.setTipoOferta(this.bigDecimalToLong(rs.getValueAt(i,"TIPOOFERTA")));
		dtoPS.setUnidadesAtendidas(this.bigDecimalToInteger(rs.getValueAt(i,"UNIDADESATENDIDAS")));
		dtoPS.setUnidadesComprometidas(this.bigDecimalToInteger(rs.getValueAt(i,"UNIDADESCOMPROMETIDAS")));
		if (dtoPS.getUnidadesComprometidas() == null) {
           dtoPS.setUnidadesComprometidas(new Integer("0"));    
        }
		dtoPS.setUnidadesDemandaReal(this.bigDecimalToInteger(rs.getValueAt(i,"UNIDADESDEMANDAREAL")));
		dtoPS.setUnidadesPorAtender(this.bigDecimalToInteger(rs.getValueAt(i,"UNIDADESPORATENDER")));
		dtoPS.setOidPais(this.bigDecimalToLong(rs.getValueAt(i,"PAIS")));
        if (rs.getValueAt(i,"FECHA")!=null) {
		  dtoPS.setFecha(new Date(((java.sql.Date)rs.getValueAt(i,"FECHA")).getTime()));
        }
		dtoPS.setPorcentajeDescuento(this.bigDecimalToFloat(rs.getValueAt(i,"PORCENTAJEDESCUENTO")));
        dtoPS.setCodigoTipoOferta(this.bigDecimalToString(rs.getValueAt(i,"CODIGOTIPOOFERTA")));
        dtoPS.setEstado(this.bigDecimalToLong(rs.getValueAt(i,"ESTADO")));
        dtoPS.setOidTipoPosicion(this.bigDecimalToLong(rs.getValueAt(i,"TIPOPOSICION")));                 
        dtoPS.setOidSubtipoPosicion(this.bigDecimalToLong(rs.getValueAt(i,"SUBTIPOPOSICION")));  
        dtoPS.setDecripcionSAPI18N(this.bigDecimalToString(rs.getValueAt(i, "DESC_PROD_I18N")));
        //Agregado por HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353
        dtoPS.setOidDetaOferta(this.bigDecimalToLong(rs.getValueAt(i,"OIDDETAOFER")));
        /* Agregado por Cambio FAC-003 ------ AL */
        dtoPS.setPrecioCosteEstandar(this.bigDecimalToFloat(rs.getValueAt(i,"VAL_COST_ESTD")));
        if (dtoPS.getPrecioCosteEstandar() == null ) {
          dtoPS.setPrecioCosteEstandar(new Float(0));    
        }
        /* Agregado por Cambio FAC-003 ------ AL */
                
         // sapaza -- PER-SiCC-2011-0597 -- 05/09/2011                
         dtoPS.setOidConcursoSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"OIDCONCURSO")));
         
		if (hashPosiciones.get(dtoPS.getOidCabecera().toString()) == null) {
          ArrayList listaDtos = new ArrayList();
          listaDtos.add(dtoPS);
          hashPosiciones.put(dtoPS.getOidCabecera().toString(),listaDtos);
        } else {
          ArrayList listaDtos = (ArrayList)hashPosiciones.get(dtoPS.getOidCabecera().toString());
          listaDtos.add(dtoPS);
          hashPosiciones.put(dtoPS.getOidCabecera().toString(),listaDtos);
        }
        
        // Cambio 20090908 - dmorello, 29/06/2009
        dtoPS.setOidDocumentoLegalReferencia(this.bigDecimalToLong(rs.getValueAt(i, "DOCUMENTOLEGALREFERENCIA")));
        
	  }//for	
	}//if(rs.esvacio)	
    UtilidadesLog.info("MONProcesosFacturacion.armarHashPosiciones (RecordSet rs): Salida");
    return hashPosiciones;
   }
  
  
  
   private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
   }
   
   private Float bigDecimalToFloat(Object numero) {
        if (numero != null) {
            return new Float(numero.toString());
        } else {
            return null;
        }
   }
   
   private Integer bigDecimalToInteger(Object numero) {
        if (numero != null) {
            return new Integer(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
   }
   
   private String bigDecimalToString(Object ob) {
        if (ob != null) {
            return ob.toString();
        } else {
            return null;
        }
    } 
    
    private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }
    
    private Boolean longToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((Long) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }

    private MONCrearListaPicadoLocalHome getMONCrearListaPicadoLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCrearListaPicadoLocalHome)context.lookup("java:comp/env/ejb/local/MONCrearListaPicado");
    }
 
 
    /* Agregado por Cambio FAC-001 ------ AL */
    private StringBuffer calcularIVAasumidoEmpresa (DTOFACConsolidado dtoConsolidado, Long oidTasaImpuesto, Integer numeroDecimales) throws MareException{
        UtilidadesLog.info("MONProcesosFacturacion.calcularIVAasumidoEmpresa (DTOFACConsolidado dtoConsolidado, Long oidTasaImpuesto): Entrada");
        if (numeroDecimales == null) {
            numeroDecimales = new Integer(0);
        }
        StringBuffer query = new StringBuffer();
        if (dtoConsolidado.getIndicadorIVAasumido().booleanValue()) {
            BigDecimal nuevoTotal = new BigDecimal((dtoConsolidado.getDtoCabecera().getPrecioCatalogoTotalLocal().floatValue() + dtoConsolidado.getDtoCabecera().getPrecioContableTotalLocal().floatValue())
                                    * dtoConsolidado.getPorcIVAasumido().floatValue() / 100);
            Float baseIvaAsumido = new Float(dtoConsolidado.getDtoCabecera().getImporteDescuentoTotalLocal().floatValue() - nuevoTotal.setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).floatValue());
            if (baseIvaAsumido.floatValue() > 0) {                
                if (oidTasaImpuesto == null) {
                    oidTasaImpuesto = this.recuperarOidTasaImpuestoParaIva(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
                }
                query.append("UPDATE PED_SOLIC_CABEC SET VAL_IMPO_IVA_ASUM_EMPR = ROUND(((").append(baseIvaAsumido.floatValue()).append(" / ( 1 + ((SELECT VAL_TASA_IMPU FROM PED_TASA_IMPUE  WHERE OID_TASA_IMPU =").append(oidTasaImpuesto).append(") / 100))) * ");
                query.append("(SELECT VAL_TASA_IMPU FROM PED_TASA_IMPUE  WHERE OID_TASA_IMPU = ").append(oidTasaImpuesto).append(") / 100), ").append(numeroDecimales.intValue()).append(")");
                query.append(" WHERE OID_SOLI_CABE = ").append(dtoConsolidado.getDtoCabecera().getOidCabeceraSolicitud()).append(";");
            }
        }
        UtilidadesLog.info("MONProcesosFacturacion.calcularIVAasumidoEmpresa (DTOFACConsolidado dtoConsolidado, Long oidTasaImpuesto): Salida");
        return query;
    }
                
                
    private Long recuperarOidTasaImpuestoParaIva(Long oidSolicitudCabecera) throws MareException {
        StringBuffer query = new StringBuffer();
        Long oidTasaImpuesto = null;
                
        query.append("SELECT PSA.TAIM_OID_TASA_IMPU ");
        query.append("FROM PED_SOLIC_ACUMU_IMPUE PSA ");
        query.append("WHERE PSA.SOCA_OID_SOLI_CABE = ").append(oidSolicitudCabecera);
        query.append(" ORDER BY PSA.VAL_TOTA_BASE_IMPO_LOCA ");
                
        RecordSet rs = null;
                
        rs = UtilidadesBD.executeQuery(query.toString());

        if (rs != null && !rs.esVacio()) {
            oidTasaImpuesto = UtilidadesBD.convertirALong(rs.getValueAt(0, "TAIM_OID_TASA_IMPU"));
        }
        return oidTasaImpuesto;
    }
    /* Agregado por Cambio FAC-001 ------ AL */
    

     private SolicitudAcumuladoImpuestosLocalHome getSolicitudAcumuladoImpuestosLocalHome() throws MareException{
         return new SolicitudAcumuladoImpuestosLocalHome();
     }


    public String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException {
        String numeroSolicitud = null;
        try {       
          numeroSolicitud = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_NUM_SOL_OCR", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        return numeroSolicitud;
    }
    
    // sapaza -- PER-SiCC-2011-0137 -- 20/10/2010
    private Float recuperarTasaImpuestoReferencia(Long oidSolicitudCabecera) throws MareException {
        StringBuffer query = new StringBuffer();
        Float tasaImpuesto = null;
                
        query.append("SELECT VAL_TASA_IMPU ");
        query.append("FROM PED_SOLIC_CABEC ");
        query.append("WHERE OID_SOLI_CABE = ").append(oidSolicitudCabecera);
                
        RecordSet rs = null;
                
        rs = UtilidadesBD.executeQuery(query.toString());

        if (rs != null && !rs.esVacio()) {
            tasaImpuesto =  this.bigDecimalToFloat(rs.getValueAt(0, "VAL_TASA_IMPU"));
        }
        
        return tasaImpuesto;
    }   

    // sapaza -- PER-SiCC-2011-0137 -- 03/11/2010
    private Integer obtenerIndicadorSolicitudNegativo(Long numeroSolicitud) throws MareException {
       UtilidadesLog.info("MONProcesosFacturacion.obtenerIndicadorSolicitudNegativo(Long numeroSolicitud): Entrada");         
       StringBuffer query = new StringBuffer();     
       Integer indicador = null; 
        
       query.append(" SELECT IND_SOLI_NEGA ");
       query.append("   FROM PED_TIPO_SOLIC a, PED_TIPO_SOLIC_PAIS b, PED_SOLIC_CABEC c  ");
       query.append("  WHERE c.OID_SOLI_CABE = " + numeroSolicitud);
       query.append("    AND c.TSPA_OID_TIPO_SOLI_PAIS = b.OID_TIPO_SOLI_PAIS ");
       query.append("    AND b.TSOL_OID_TIPO_SOLI = a.OID_TIPO_SOLI ");
                                 
       RecordSet rs = UtilidadesBD.executeQuery(query.toString());
       
       if (rs != null && !rs.esVacio()) {
         indicador = UtilidadesBD.convertirAInteger(rs.getValueAt(0, 0));
       }

       UtilidadesLog.info("MONProcesosFacturacion.obtenerIndicadorSolicitudNegativo(Long numeroSolicitud): Salida");         
       return indicador;
    }
    
    // sbuchelli -- ECU-SiCC-2011-0072 -- 18/11/2011
    private Float recuperarTasaImpuestoReferenciaFlete(Long oidSolicitudCabecera) throws MareException {
        StringBuffer query = new StringBuffer();
        Float tasaImpuesto = new Float("0");
                
        query.append("SELECT VAL_TASA_FLET ");
        query.append("FROM PED_SOLIC_CABEC ");
        query.append("WHERE VAL_TASA_FLET IS NOT NULL AND SOCA_OID_SOLI_CABE = ").append(oidSolicitudCabecera);
                
        RecordSet rs = null;
                
        rs = UtilidadesBD.executeQuery(query.toString());

        if (rs != null && !rs.esVacio()) {
            tasaImpuesto =  this.bigDecimalToFloat(rs.getValueAt(0, "VAL_TASA_FLET"));
        }
        
        return tasaImpuesto;
    }   
    
    //sbuchelli
     
    private void actualizarTasaImpuestoReferenciaFlete(Long oidSolicitudCabecera,Float tasaImpuestoFlete) throws MareException {
        StringBuffer query = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
                
        query.append("UPDATE PED_SOLIC_CABEC SET VAL_TASA_FLET= ");
        query.append(tasaImpuestoFlete);
        query.append(" WHERE OID_SOLI_CABE = ").append(oidSolicitudCabecera);
                
                
         
        try {
            UtilidadesLog.info("actualizarTasaImpuestoReferenciaFlete");        
            bs.dbService.executeUpdate(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }                 
    }   
}
