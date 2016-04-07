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
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.print.SpoolManager;
import es.indra.sicc.cmn.negocio.print.SpoolManagerHome;
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
import es.indra.sicc.dtos.fac.DTOGenerarConsolidado;
import es.indra.sicc.dtos.fac.DTOSolicitudCabeceraSecuenciaAcum;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.ape.MONAPE;
import es.indra.sicc.logicanegocio.ape.MONAPEHome;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoLocal;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoLocalHome;
import es.indra.sicc.logicanegocio.ape.MONProcesoFueraPedidoLocal;
import es.indra.sicc.logicanegocio.ape.MONProcesoFueraPedidoLocalHome;
import es.indra.sicc.logicanegocio.app.MONSecuYMarcasChequeoLocal;
import es.indra.sicc.logicanegocio.app.MONSecuYMarcasChequeoLocalHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.CuponDePagoPeru;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.FactoriaSerializador;
import es.indra.sicc.logicanegocio.intsys.MONINTPTLLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.lang.CloneNotSupportedException;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;


public class MONFacturacionBean implements SessionBean  {

	private SessionContext ctx;

	private Hashtable consolidadosAgrupados;      
	private Character indicadorBalanceoAreaChequeo;      
	private Boolean indicadorImpuestosIncluidos;      
	private Character indicadorSecuenciacion;      
	private ArrayList listaConsolidados;      
	private Hashtable listaTiposSolicitud;      
	private Integer numeroDecimalesRedondeo;      
	private ArrayList secuenciaProcesos;     
	private Integer tamanioSegmento;      
	private String numeroLote;     
	private Integer numeroMaximoSegmentos;      
	private ArrayList impuestosGenerales;     
	private ArrayList indicadoresImpuestos;     
	private ArrayList valoresPorDefecto;     
	private ArrayList impuestosUbigeo;  
	private DTOGenerarConsolidado dtoGenerarConsolidado;
	private SpoolManager spoolManager;
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

    public void arrancarFacturacion(DTOArranqueGP dtoE) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.arrancarFacturacion(DTOArranqueGP dtoE): Entrada");
        DTONumeroSolicitud dtoNS = new DTONumeroSolicitud();
        DTOSolicitudValidacion dtoSV = (DTOSolicitudValidacion)dtoE.getListaSolicitudes().get(0);
        dtoNS.setOidPais(dtoSV.getOidPais());
        dtoNS.setOperacion("FAC001");
         
        MONProcesosPED mONProcesosPED = this.getMONProcesosPED(); 
        
        try{
            this.numeroLote = mONProcesosPED.generaNumeroDocumento(dtoNS); 
        } catch(RemoteException re){
            UtilidadesLog.error(re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        this.arrancarFacturacionReal(dtoE);
        
        UtilidadesLog.info("MONFacturacionBean.arrancarFacturacion(DTOArranqueGP dtoE): Salida");
    }

    public void balancearAreaChequeo() throws MareException {
        UtilidadesLog.info("MONFacturacionBean.balancearAreaChequeo(): Entrada");
        
        // eiraola - Para caso de uso de APE Balanceo area de chequeo - 23/07/2007 - INICIO
        if (this.indicadorBalanceoAreaChequeo.equals(new Character(ConstantesFAC.COD_BALANCEO_COLOMBIA.charAt(0)))) {
            UtilidadesLog.debug(" --- Balanceo colombia!");
            ArrayList tiposSolicitudParaBalanceo = new ArrayList();
            ArrayList consolidadosParaBalanceo = new ArrayList();
            ArrayList consolidadosSinBalanceo = new ArrayList();
            
            // Buscamos los tipos de solicitud para los cuales debemos ejecutar el CU APE "Balanceo area chequeo".
            UtilidadesLog.debug("    -> Buscando Tipos de Solicitud que tienen configurado en GP5 el 'P505':");
            Iterator iteSecuenciaProcesos = this.secuenciaProcesos.iterator();
            
            while (iteSecuenciaProcesos.hasNext()) {
                DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteSecuenciaProcesos.next();
                
                if (dtoFACSecuenciaProcesos.getGrupoProcesos().equals(ConstantesFAC.COD_GP5) 
                        && dtoFACSecuenciaProcesos.getCodigoProceso().equals(ConstantesFAC.COD_PROC_BALANCEO_AREA_CHEQUEO)) {
                    
                    UtilidadesLog.debug("       tipoSolicitud (oid): " + dtoFACSecuenciaProcesos.getTipoSolicitud());
                    tiposSolicitudParaBalanceo.add(dtoFACSecuenciaProcesos.getTipoSolicitud());
                }
            }
            
            
            // Creamos una lista con todos los consolidados de todos los tipos de solicitud 
            // encontrados para 'P505'.
            Enumeration listaKeys = this.consolidadosAgrupados.keys();
            ArrayList consolidadosDeTipoSolicitud;
            
            while (listaKeys.hasMoreElements()) {
                Long oidTipoSolicitud = (Long)listaKeys.nextElement();
                consolidadosDeTipoSolicitud = (ArrayList)consolidadosAgrupados.get(oidTipoSolicitud);
                
                if (tiposSolicitudParaBalanceo.contains(oidTipoSolicitud)) {
                    UtilidadesLog.debug("    -> Agregando "+ consolidadosDeTipoSolicitud.size() +" consolidados para balancear,"
                                        + " del tipoSolicitud (oid): " + oidTipoSolicitud);
                    consolidadosParaBalanceo.addAll(consolidadosDeTipoSolicitud);
                } else {
                    consolidadosSinBalanceo.addAll(consolidadosDeTipoSolicitud);
                }
            }
            
            
            // Lanzamos CU APE "Balanceo area chequeo" para todos los consolidados pertenecientes
            // a los tipos de solicitudes que tienen configurado el proceso de GP5 'P505' (Balanceo area de chequeo).
            UtilidadesLog.debug("******* FAC invoca a APE Balancear Area Chequeo *******");
            MONAPE monApe = this.getMONAPE();
            DTOFACConsolidado[] listaConsolidadosABalancear = (DTOFACConsolidado[])consolidadosParaBalanceo.toArray(
                                                    new DTOFACConsolidado[consolidadosParaBalanceo.size()]);
                                                    
            DTOFACConsolidado[] consolidadosBalanceados;
            try {
                consolidadosBalanceados = monApe.balancearAreaChequeo(listaConsolidadosABalancear);
            } catch (RemoteException re) {
                UtilidadesLog.error(" *** APE Balancear area de chequeo finalizo con error");
                throw new MareException("Factuacion abortada por APE Bal.area cheq.", re);
            }
            
            
            // Los consolidados con tipos de solicitud que no tenian el 'P505' configurado los
            // agrego al final (sin ejecutarse el Balanceo area de chequeo).
            int cantConsolidadosBalanceados = consolidadosBalanceados.length;
            int cantConsolidadosNoBalanceados = consolidadosSinBalanceo.size();
            UtilidadesLog.debug("    -> Se devuelven " + cantConsolidadosBalanceados + " consolidados Balanceados por area de chequeo");
            UtilidadesLog.debug("    -> Se devuelven " + cantConsolidadosNoBalanceados + " consolidados no Balanceados");
            
            ArrayList listaConsolidadosAuxiliar = new ArrayList();
            
            for (int i = 0; i < cantConsolidadosBalanceados; i++) {
                listaConsolidadosAuxiliar.add(consolidadosBalanceados[i]);
            }
            
            listaConsolidadosAuxiliar.addAll(consolidadosSinBalanceo);
            
            this.listaConsolidados = listaConsolidadosAuxiliar;
        }
        // eiraola - Para caso de uso de APE Balanceo area de chequeo - 23/07/2007 - FIN

        // eiraola - se comenta completo el codigo antiguo del metodo debido a que:
        // (a) Para Colombia se redefinio al comienzo
        // (b) Para Peru ya no se utiliza pues se esta realizando el balanceo en "MegaProcesadorGPs.ejecutarGP5"
        /*Enumeration listaKeys = this.consolidadosAgrupados.keys();

        DTOFACConsolidado[] consolidadosBalanceados = null;//variable con los consolidados ya balanceados			
        DTOFACConsolidado[] consolidadosGenerados = null;//variable con los consolidados despu�s de generarMarcasChequeo
        ArrayList consolidadosAgrupadosActualizados = new ArrayList();
			
      if(this.indicadorBalanceoAreaChequeo.equals(new Character(ConstantesFAC.COD_BALANCEO_COLOMBIA.charAt(0)))){
        UtilidadesLog.debug("balanceo colombia!, listaKeys: " + listaKeys);
        
        while (listaKeys.hasMoreElements()){
          Long solicitud = (Long) listaKeys.nextElement();
          ArrayList arrayListConsolidadosAgrupados  = (ArrayList)consolidadosAgrupados.get(solicitud);
          
          String grupoProcesos = ConstantesFAC.COD_GP5;
          String codigoProceso = ConstantesFAC.COD_PROC_BALANCEO_AREA_CHEQUEO;
          
          Iterator iteSecuenciaProcesos = this.secuenciaProcesos.iterator();
  
          while(iteSecuenciaProcesos.hasNext()){
            DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteSecuenciaProcesos.next();
  
            if(solicitud.equals(dtoFACSecuenciaProcesos.getTipoSolicitud()) 
              && grupoProcesos.equals(dtoFACSecuenciaProcesos.getGrupoProcesos())
                && codigoProceso.equals(dtoFACSecuenciaProcesos.getCodigoProceso())){
                  TaponAPE tapon = new TaponAPE();
                  DTOFACConsolidado[] listaConsolidados = (DTOFACConsolidado[])arrayListConsolidadosAgrupados.toArray(new DTOFACConsolidado[arrayListConsolidadosAgrupados.size()]);
                  consolidadosBalanceados = tapon.balancearAreaChequeo(listaConsolidados);
                  for (int i = 0; i<consolidadosBalanceados.length;i++){
                    consolidadosAgrupadosActualizados.add(consolidadosBalanceados[i]);
                  }
                  this.consolidadosAgrupados.put(solicitud,consolidadosAgrupadosActualizados.clone());
                  consolidadosAgrupadosActualizados.clear();
            }//if
          }//fin del bucle interno
        }//fin del bucle externo
      }//fin del if(indicadorBalanceoAreaChequeo.equals(ConstantesFAC.COD_BALANCEO_COLOMBIA)
		
      else if(indicadorBalanceoAreaChequeo.equals(new Character(ConstantesFAC.COD_BALANCEO_PERU.charAt(0)))){
              MONSecuYMarcasChequeoLocal mONSecuYMarcasChequeo = this.getMONSecuYMarcasChequeoLocal();

        while (listaKeys.hasMoreElements()){
          Long solicitud = (Long) listaKeys.nextElement();
          ArrayList arrayListConsolidadosAgrupados  = (ArrayList)consolidadosAgrupados.get(solicitud);
          String grupoProcesos = ConstantesFAC.COD_GP5;
          String codigoProceso = ConstantesFAC.COD_PROC_GENERAR_MARCAS_CHEQUEO;
          
          Iterator iteSecuenciaProcesos = this.secuenciaProcesos.iterator();
  
          while(iteSecuenciaProcesos.hasNext()){
            DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteSecuenciaProcesos.next();
  
            if(solicitud.equals(dtoFACSecuenciaProcesos.getTipoSolicitud()) 
              && grupoProcesos.equals(dtoFACSecuenciaProcesos.getGrupoProcesos())
                && codigoProceso.equals(dtoFACSecuenciaProcesos.getCodigoProceso())){
                  DTOFACConsolidado[] listaConsolidados = (DTOFACConsolidado[])arrayListConsolidadosAgrupados.toArray(new DTOFACConsolidado[arrayListConsolidadosAgrupados.size()]);
                  consolidadosGenerados= mONSecuYMarcasChequeo.generarMarcasChequeo(listaConsolidados);
                  for (int i = 0; i<consolidadosGenerados.length;i++){
                    consolidadosAgrupadosActualizados.add(consolidadosGenerados[i]);
                  }
                  this.consolidadosAgrupados.put(solicitud,consolidadosAgrupadosActualizados);
            }//if
          }//fin del bucle interno
        }//fin del bucle externo
  
      }*/
              
      UtilidadesLog.info("MONFacturacionBean.balancearAreaChequeo(): Salida");
    }
    
    public void balancearAreaChequeo(DTOFACConsolidado consolidado, Character indicadorAreaChequeo) throws MareException {
        /** eiraola - 23/07/2007 - Se elimina el flujo para el indicadorAreaChequeo == 'C'olombia
         * 
        if(indicadorAreaChequeo.equals(new Character(ConstantesFAC.COD_BALANCEO_COLOMBIA.charAt(0)))){
            TaponAPE tapon = new TaponAPE();
            DTOFACConsolidado[] dto = new DTOFACConsolidado[1];
            dto[0] = consolidado;
            tapon.balancearAreaChequeo(dto);
        }//fin del if(indicadorBalanceoAreaChequeo.equals(ConstantesFAC.COD_BALANCEO_COLOMBIA)
        else*/
        if(indicadorAreaChequeo.equals(new Character(ConstantesFAC.COD_BALANCEO_PERU.charAt(0)))){
            MONSecuYMarcasChequeoLocal mONSecuYMarcasChequeo = this.getMONSecuYMarcasChequeoLocal();
            mONSecuYMarcasChequeo.generarMarcasChequeo(consolidado);
        }              
        UtilidadesLog.info("MONFacturacionBean.balancearAreaChequeo(): Salida");
    }
	
    private void obtenerSegmentosFacturacion() throws MareException{
        MareMGC mgc = new MareMGC();
        mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String tamanio= (String) mgc.getProperty("application.TamanioSegmentoFAC");
        String numero = (String) mgc.getProperty("application.NumeroMaximoSegmentosFAC");
        if ((tamanio == null) || (tamanio.equals(""))) {
            this.tamanioSegmento = new Integer(10);
        } else {
            this.tamanioSegmento = new Integer(tamanio);
        }
        if ((numero == null) || (numero.equals(""))) {
            this.numeroMaximoSegmentos = new Integer(8);
        } else {
            this.numeroMaximoSegmentos = new Integer(numero);
        }
    }
    
    /**
     * CHANGELOG
     * ---------
     * scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
     * Cambio RI 20080528 - dmorello, 08/10/2008
     *   - Si esta parametrizado P523, se eliminan registros de APE_ANAQU_POST_VENTA
     * Incidencia RI 20080820 - dmorello, 11/03/2009
     *   - Al final de la facturacion se escriben las listas de picado AFP a partir
     *     de los registros temporales en APE_LISTA_PICAD_DETAL_TEMP, que luego se eliminan
     * Cambio 20090839 - dmorello, 16/10/2009
     *   - Se agregan llamadas a metodos para generar numeros de secuencia de etiquetas
     *     y para colocar esos numeros en las listas de picado en GEN_DOCUM_IMPRI
     */
    public void lanzarProcesosFacturacion(ArrayList listaConsolidados, DTOParametroMonitor parametros, Integer numDecimales) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.lanzarProcesosFacturacion(ArrayList listaConsolidados, DTOParametroMonitor parametros): Entrada");
        this.obtenerSegmentosFacturacion();
        ArrayList segmento= new ArrayList();
        ListIterator iteConsolidados = listaConsolidados.listIterator();
        Boolean indicadorEjecucionOnLine = null;
        int count = 0;
        Long IDSpool = null;
        
        String IDProceso = parametros.getIDProc(); 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFacturacion = sdf.format(parametros.getFechaFacturacion());
        UtilidadesLog.debug("*** fechaFacturacion *** " + fechaFacturacion);
        
        /* Agregado para V4 ------- AL */
             /* dmorello, 25/07/2007 */
              Long oidPais = ((DTOFACConsolidado)listaConsolidados.get(0)).getOidPais();

              // dmorello, 22/11/2007
              UtilidadesLog.debug("*** A punto de verificar si se corre PTL-1 ***");
              boolean ejecutarAPE = false;
              int cantCons = listaConsolidados.size();
              int cantProc = this.secuenciaProcesos.size();
              for (int i = 0; i < cantCons && !ejecutarAPE; i++) {
                  DTOFACConsolidado dtoCons = (DTOFACConsolidado)listaConsolidados.get(i);
                  
                  if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("****** listaConsolidados[" + i + "]: " + dtoCons);
                  
                  Long tipoSol = dtoCons.getDtoCabecera().getTipoSolicitud();
                  for (int j = 0; j < cantProc && !ejecutarAPE; j++) {
                      DTOFACSecuenciaProcesos dtoFSP = (DTOFACSecuenciaProcesos)this.secuenciaProcesos.get(j);
                      
                      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                        UtilidadesLog.debug("********* secuenciaProcesos[" + j + "]: " + dtoFSP);
                        
                      if (dtoFSP.getCodigoProceso().equals(ConstantesFAC.COD_PROC_CERRAR_ARMADO)
                              && dtoFSP.getTipoSolicitud().equals(tipoSol)) {
                          UtilidadesLog.debug("************ Debo correr PTL-1 ************");
                          ejecutarAPE = true;
                      }
                  }
              }
              // Fin dmorello, 22/11/2007
        /* Agregado para V4 ------- AL */
         if (ejecutarAPE) {
             try {
                 UtilidadesLog.debug("A punto de eliminar Anaqueles PostVenta");
                 MONCrearListaPicadoLocalHome home = this.getMONCrearListaPicadoLocalHome();
                 MONCrearListaPicadoLocal local = home.create();
                 DTOBelcorp dto = new DTOBelcorp();
                 dto.setOidPais(oidPais);
                 local.eliminarAnaquelesPostVenta(dto);
             } catch (NamingException e) {
                 String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                 throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));      
             } catch (CreateException e) {
                 String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                 throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));      
             }
         }
            
       	this.consolidadosAgrupados = null;      
        this.indicadorBalanceoAreaChequeo = null;      
        this.indicadorImpuestosIncluidos = null;      
        this.indicadorSecuenciacion = null;              
        this.listaTiposSolicitud = null;      
        this.numeroDecimalesRedondeo = null;                        
        this.impuestosGenerales = null;     
        this.indicadoresImpuestos = null;     
        this.valoresPorDefecto = null;     
        this.impuestosUbigeo = null;          
        boolean spoolAbierto = false;
        boolean ejecuta = false;
        int segmentosEjecutandoSimultaneamente = 0;
        DTOFACConsolidado consolidado;
        Long tipoSolicitudTemp = ((DTOFACConsolidado)listaConsolidados.get(0)).getDtoCabecera().getTipoSolicitud();
        boolean continua = true;
        while (continua){     
          MareBusinessID mBI = new MareBusinessID();
          mBI.setBusinessID(new String("PEDEjecutarSegmentosCacheEntidades")); 
             
          DTOSubBatch dtoSB = new DTOSubBatch(new String("SEGMENTO_FAC_"), IDProceso, ctx.getCallerPrincipal().getName(), mBI, new DTOEjecucionProcesos());
          try {
            BatchUtil.executeMLN(dtoSB, "FACProcesosGP5");
          } catch(RemoteException re){
            UtilidadesLog.error(re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                         
          }
          
          segmentosEjecutandoSimultaneamente++;
          if (segmentosEjecutandoSimultaneamente == (numeroMaximoSegmentos.intValue()*2)) {
               try {
                   this.esperarProcesamiento(IDProceso);
               } catch(InterruptedException ie) {
                  UtilidadesLog.error(ie);
                  String codigoError = ie.getMessage();
                  throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
               }   
               segmentosEjecutandoSimultaneamente = 0;
               continua = false;
          }      
        }     
        
        
        while (iteConsolidados.hasNext()){
            consolidado = (DTOFACConsolidado)iteConsolidados.next();
            if (indicadorEjecucionOnLine == null){
                Long oidTipoSolicitud = consolidado.getDtoCabecera().getTipoSolicitud();
                Iterator iteSecuencia = this.secuenciaProcesos.iterator();  
                while(iteSecuencia.hasNext()){
                    DTOFACSecuenciaProcesos dtoFSP = (DTOFACSecuenciaProcesos)iteSecuencia.next();
                    if(dtoFSP.getTipoSolicitud().equals(oidTipoSolicitud)){
                        indicadorEjecucionOnLine = dtoFSP.getIndicadorEjecucionEnLinea();
                        break;
                    }
                }
            }
            
            
            ///SCS
            UtilidadesLog.debug("numDecimales (SCS): " + numDecimales);
            consolidado.getDtoCabecera().setNumeroDecimalesRedondeo(numDecimales);
            ///SCS    
            
            
            if (indicadorEjecucionOnLine.booleanValue()){
                  segmento.add(consolidado);
            }else{     
                if (!spoolAbierto){
                    IDSpool = abrirSpool();
                    spoolAbierto = true;
                }
                consolidado.setIDSpool(IDSpool);
                
                //sapaza -- cambio x Demora GP4-GP5 PEES -- 21/06/2010
                /*if (consolidado.getDtoCabecera().getTipoSolicitud().longValue() != tipoSolicitudTemp.longValue()){
                    count = 0;
                    ejecuta = true;
                    iteConsolidados.previous();
                }*/
                
                if (count == this.tamanioSegmento.intValue()){
                    count = 0;
                    ejecuta = true;
                    iteConsolidados.previous();
                }else{
                    segmento.add(consolidado);
                    iteConsolidados.remove();
                    count++;
                }
            }
            tipoSolicitudTemp = consolidado.getDtoCabecera().getTipoSolicitud();
            if (ejecuta){
                ejecucionBatch(segmento, IDProceso);
                ejecuta = false;
                segmento= new ArrayList();
                segmentosEjecutandoSimultaneamente++;
            }
            if (segmentosEjecutandoSimultaneamente == numeroMaximoSegmentos.intValue()){
                try{
                    UtilidadesLog.debug("*** Se espera el procesamiento en Batch ***");
                    UtilidadesLog.debug("*** El IDProceso es = "+IDProceso);
                    this.esperarProcesamiento(IDProceso);
                }catch(InterruptedException ie){
                    UtilidadesLog.error(ie);
                    String codigoError = ie.getMessage();
                    throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
                }    
                segmentosEjecutandoSimultaneamente= 0;
                count = 0;
            }
        }
        
        if (segmento.size()>0){
            if (indicadorEjecucionOnLine.booleanValue()){
                ejecucionOnline(segmento);
                segmento= new ArrayList();
            }else{
                ejecucionBatch(segmento, IDProceso);
                segmento= new ArrayList();
            }
        }

        if (!indicadorEjecucionOnLine.booleanValue()){
            try{
                this.esperarProcesamiento(IDProceso);
            }catch(InterruptedException ie){
                UtilidadesLog.error(ie);
                String codigoError = ie.getMessage();
                throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
            }          
        }
    
        try {
          MONFacturacionLocalHome facturacionLocalHome = this.getMONFacturacionLocalHome();        
          MONFacturacionLocal facturacionLocal = facturacionLocalHome.create();
          facturacionLocal.generarNumerosDocumentoInternos(indicadorEjecucionOnLine, IDSpool); 
          
          // sapaza -- PER-SiCC-2012-0088 -- 08/02/2012
          facturacionLocal.procesarGastosAdministrativos(indicadorEjecucionOnLine, oidPais);
            
          /* Agregado para V4 - dmorello, 30/10/2007 */

              // dmorello, 22/11/2007
              if (ejecutarAPE) {
                  
                  MONProcesoFueraPedidoLocalHome pfpLocalHome = this.getMONProcesoFueraPedidoLocalHome();
                  MONProcesoFueraPedidoLocal pfpLocal = pfpLocalHome.create();
                  pfpLocal.crearListasAFPDefinitivas(oidPais);
              
                  facturacionLocal.generarCodigosListasPicado(indicadorEjecucionOnLine, oidPais);
                  facturacionLocal.generarNumerosEtiquetas(indicadorEjecucionOnLine, oidPais);
                  facturacionLocal.generarNumerosSecuenciaEtiquetas(indicadorEjecucionOnLine, oidPais);
                  facturacionLocal.asignarNroUnicoCajaListasPicado(indicadorEjecucionOnLine, IDSpool);
                  
                  // sapaza -- Cambios para WCS y MUO -- 22/09/2010
                  facturacionLocal.actualizarProductosCampana(indicadorEjecucionOnLine, fechaFacturacion);
                  //facturacionLocal.generarOlas(indicadorEjecucionOnLine, oidPais);
                  
                  // sapaza -- Cambios para WCS y MUO -- 22/09/2010
                  // BELC400000226 - dmorello
                  //MONINTPTLLocal monPTL = this.getMONINTPTLLocalHome().create();
                  //DTOOID dtoOidPais = new DTOOID();
                  //dtoOidPais.setOid(oidPais);
                  //monPTL.enviarPedidosFacturadosAPicar(dtoOidPais);
                  // Fin BELC400000226
                  
              }
              // Fin dmorello 22/11/2007

          /* Fin agregado para V4 - dmorello, 30/10/2007 */

        } catch (NamingException ne) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));	
        } catch (CreateException ce ) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));	
        }

        if (!indicadorEjecucionOnLine.booleanValue()){
            try {
                if (this.validarTipoSpool(oidPais)) {
                    this.spoolManager.closeSpoolColombia(IDSpool);
                } else {
                    this.spoolManager.closeSpool(IDSpool);
                }
            } catch(Exception e) {
                UtilidadesLog.error("ERROR",e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	
            }
        }
        UtilidadesLog.info("MONFacturacionBean.lanzarProcesosFacturacion(ArrayList listaConsolidados, DTOParametroMonitor parametros): Salida");
    }
    
    private Long abrirSpool() {
        Long spool = null;
        try{
            MareMGC mgc = new MareMGC();
            mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String subaccesoUsuario = (String) mgc.getProperty("application.subaccesoImpresion");  
            this.spoolManager = this.getSpoolManager();	
            spool = getSpoolManager().openSpool(new Long(subaccesoUsuario));
            FactoriaSerializador factoriaSerializador = FactoriaSerializador.getFactoriaSerializador();
            factoriaSerializador.inicializarListaSerializador();
        }catch (Exception e){
            UtilidadesLog.error("ERROR AL ABRIR EL SPOOL",e);
        }
        return spool;
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

    private MONProcesosPED getMONProcesosPED() throws MareException {
        UtilidadesLog.info("MONFacturacionBean.getMONProcesosPED(): Entrada");
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
        MONProcesosPED ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONFacturacionBean.getMONProcesosPED(): Salida");
        return ejb;
    }


    public DTOFACCalculosCabeceraSalida realizarCalculosCabecera(DTOFACCalculosCabeceraEntrada dtoe) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.realizarCalculosCabecera(DTOFACCalculosCabeceraEntrada dtoe): Entrada");
        DTOFACCabeceraSolicitud dtoConsolidado = (DTOFACCabeceraSolicitud)dtoe.getDtoConsolidado();
        this.numeroDecimalesRedondeo = dtoConsolidado.getNumeroDecimalesRedondeo();
        ArrayList listaPosiciones = dtoe.getListaPosiciones();
        Character indicadorCalculo = dtoe.getIndicadorCalculo();                                                                                                                                  
        Long moneda = dtoe.getMoneda();                                                                                                                                                           


        int unidadesDemandaRealTotal=0,                                                                                                                                                           
          unidadesPorAtenderTotal=0,                                                                                                                                                        
          unidadesAtendidasTotal=0;				                                                                                                                          
                                                                                                                                                                                                          
        float	precioCatalogoTotalDocumento=0,                                                                                                                                                   
            precioCatalogoTotalDocumentoUnidadesPorAtender=0,                                                                                                                         
            precioCatalogoSinImpuestoTotalDocumento=0,                                                                                                                                
            precioContableTotalDocumento=0,                                                                                                                                           
            importeDescuento1TotalDocumento=0,                                                                                                                                        
            importeDescuento1SinImpuestoTotalDocumento=0,                                                                                                                             
            precioFacturaTotalDocumento=0,                                                                                                                                            
            precioTotalTotalDocumento=0,                                                                                                                                              
            precioCatalogoTotalLocal=0,                                                                                                                                               
            precioCatalogoTotalLocalUnidadesPorAtender=0,                                                                                                                             
            precioCatalogoSinImpuestoTotalLocal=0,                                                                                                                                    
            precioContableTotalLocal=0,                                                                                                                                               
            importeDescuento1TotalLocal=0,                                                                                                                                            
            importeDescuento1SinImpuestoTotalLocal=0,                                                                                                                                 
            precioFacturaTotalLocal=0,                                                                                                                                                
            precioTotalTotalLocal=0,                                                                                                                                                  
            importeRedondeoConsolidadoLocal=0,
            importeDescuentoTotalLocal=0,
            importeDescuentoTotalDocumento=0,
            totalAPagarLocal=0,
            totalAPagarDocumento=0,
            precioContableSinImpuestoTotalLocal=0,
            importeRedondeoLocal=0,
            importeRedondeoDocumento=0,
            precioContableSinImpuestoTotalDocumento=0,
            importeDescuento3SinImpuestoTotalLocal=0,
            importeDescuento3SinImpuestoTotalDocumento=0,
            precioNetoTotalLocal=0,
            precioNetoTotalDocumento=0,
            importeImpuestosTotalLocal =0,
            importeDescuento3TotalLocal=0,
            importeImpuestosTotalDocumento=0,
            importeDescuento3TotalDocumento=0,
            importeRedondeoConsolidadoDocumento=0,
	    importeDescuentoSinImpuestosTotalLocal = 0,
	    importeDescuentoSinImpuestosTotalDocumento = 0,
	    sumatoriaPrecioNetoTotalLocal=0,
	    sumatoriaPrecioNetoTotalDocumento=0,
	    sumatoriaPrecioCatalogoSinImpuestoTotalLocal = 0,
	    sumatoriaPrecioCatalogoSinImpuestoTotalDocumento = 0;
                                                                                                                                                                                                                                                                                                                    
        Iterator it = listaPosiciones.iterator();                                                                                                                                                 
        DTOFACPosicionSolicitud posicion = null;                                                                                                                                                                                                          
        while (it.hasNext()){                                                                                                                                                                     
            posicion = (DTOFACPosicionSolicitud)it.next(); 
            if(posicion.getEstado()==null){
                UtilidadesLog.debug("El estado de la posicion es null y se lanza una excepcion");
                throw new MareException("El estado de la posici�n es null");
            }
            if(posicion.getEstado().longValue()!=ConstantesPED.ESTADO_POSICION_ANULADO.longValue()){
                //calculo de unidades
                 if (posicion.getImporteDescuentoSinImpuestosTL() != null) {
                     importeDescuentoSinImpuestosTotalLocal += posicion.getImporteDescuentoSinImpuestosTL().floatValue();
                 }
                if (indicadorCalculo!=null){
                    if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_SOLICITUD.charAt(0)))){ // Solicitudes     
                        if (posicion.getUnidadesDemandaReal() !=null){
                            unidadesDemandaRealTotal += posicion.getUnidadesDemandaReal().intValue();                                                                                                 
                        }
                        if (posicion.getUnidadesPorAtender() !=null){				
                            unidadesPorAtenderTotal += posicion.getUnidadesPorAtender().intValue();           
                        }
                        
                       // boolean existe= validarTipoOferta(posicion.getTipoOferta());
                        //&& !existe
                        if (posicion.getUnidadesComprometidas() !=null){
                            unidadesAtendidasTotal += posicion.getUnidadesComprometidas().intValue();				                                                                  
                        }
                    }else {
                        if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))){ // Documentos Contables                                                                                                     
                            if(!posicion.getIndicadorNoImprimible().booleanValue() && posicion.getUnidadesAtendidas()!=null){  
                                unidadesAtendidasTotal += posicion.getUnidadesAtendidas().intValue();                                                                                                
                            }                                                                                                                                                              
                        }                                                                                                                                                                        
                    }                    
                }    
            }//Fin if estado
            
             /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
             if (posicion.getPrecioNetoTL() != null) {
                 sumatoriaPrecioNetoTotalLocal += posicion.getPrecioNetoTL().floatValue();
             }
             if (posicion.getPrecioSinImpuestosTL() != null) {
                 sumatoriaPrecioCatalogoSinImpuestoTotalLocal += posicion.getPrecioSinImpuestosTL().floatValue();
             }
             /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
            if (posicion.getPrecioCatalogoTL()!=null){			
                precioCatalogoTotalLocal += posicion.getPrecioCatalogoTL().floatValue();                                                                                                  
            }
            if (posicion.getPrecioCatalogoTLUnidadesDemandaReal()!=null){
                precioCatalogoTotalLocalUnidadesPorAtender += posicion.getPrecioCatalogoTLUnidadesDemandaReal().floatValue();                                                                                  
            }
            
            if ((posicion.getPrecioCatalogoUL()!=null)&&(posicion.getPrecioCatalogoUL().floatValue() != 0)){                                                                                                                              
                if (posicion.getPrecioSinImpuestosTL()!=null){
                    precioCatalogoSinImpuestoTotalLocal += posicion.getPrecioSinImpuestosTL().floatValue();                                                                   
                }
            }
            
            if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))) {
              if (dtoe.getCodigoTipoProgramaConcurso() != null && (dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("C") || dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("R"))) {
                UtilidadesLog.debug("No se suma este importe Por Cambio FAC-003, el Codigo de Programa es:" + dtoe.getCodigoTipoProgramaConcurso());
              } else {
                if (posicion.getPrecioContableTL()!=null){
                    precioContableTotalLocal += posicion.getPrecioContableTL().floatValue();                                                                             
                }
              }                  
            } else {
                if (posicion.getPrecioContableTL()!=null){
                    precioContableTotalLocal += posicion.getPrecioContableTL().floatValue();                                                                             
                }
            }
            if (posicion.getImporteDescuentoTL()!=null){
                importeDescuento1TotalLocal += posicion.getImporteDescuentoTL().floatValue();                                                                             
            }
            if (posicion.getImporteDescuentoSinImpuestosTL()!=null){
                importeDescuento1SinImpuestoTotalLocal += posicion.getImporteDescuentoSinImpuestosTL().floatValue();                                                      
            }
            if (posicion.getPrecioFacturaTL()!=null){
                precioFacturaTotalLocal += posicion.getPrecioFacturaTL().floatValue();                                                                                    
            }
            if (posicion.getPrecioTotalTL()!=null){
                precioTotalTotalLocal += posicion.getPrecioTotalTL().floatValue();                                                                                        
            }
            
            if (moneda!=null){
                if (posicion.getPrecioCatalogoTD()!=null){
                    precioCatalogoTotalDocumento += posicion.getPrecioCatalogoTD().floatValue();                                                                                              
                }
                if (posicion.getPrecioCatalogoTDUnidadesDemandaReal()!=null){				
                    precioCatalogoTotalDocumentoUnidadesPorAtender += posicion.getPrecioCatalogoTDUnidadesDemandaReal().floatValue(); //incidencia 8723, ya contemplado en SICC-DMCO-FAC-201-364-N005-2                                                                              
                }
                if ((posicion.getPrecioCatalogoUD() !=null) && (posicion.getPrecioCatalogoUD().floatValue() != 0)){                                                                                                                                
                    if (posicion.getPrecioSinImpuestosTD()!=null){
                        precioCatalogoSinImpuestoTotalDocumento += posicion.getPrecioSinImpuestosTD().floatValue();                                                                       
                    }
                }
                /* Agregado por Cambio FAC-003 ------ AL */
                if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))) {
                  if (dtoe.getCodigoTipoProgramaConcurso() != null && (dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("C") || dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("R"))) {
                    UtilidadesLog.debug("No se suma este importe Por Cambio FAC-003, el Codigo de Programa es:" + dtoe.getCodigoTipoProgramaConcurso());
                  } else {
                    if (posicion.getPrecioContableTD()!=null){
                      precioContableTotalDocumento += posicion.getPrecioContableTD().floatValue();                                                                             
                    }
                  }                  
                } else {
                  if (posicion.getPrecioContableTD()!=null){
                    precioContableTotalDocumento += posicion.getPrecioContableTD().floatValue();                                                                             
                  }
                }
                /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
                if (posicion.getPrecioNetoTD() != null) {
                    sumatoriaPrecioNetoTotalDocumento += posicion.getPrecioNetoTD().floatValue();
                }
                if (posicion.getImporteDescuentoSinImpuestosTD() != null) {
                    importeDescuentoSinImpuestosTotalDocumento += posicion.getImporteDescuentoSinImpuestosTD().floatValue();
                }
                if (posicion.getPrecioSinImpuestosTD() != null) {
                    sumatoriaPrecioCatalogoSinImpuestoTotalDocumento += posicion.getPrecioSinImpuestosTD().floatValue();
                }
                /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
                if (posicion.getImporteDescuentoTD()!=null){
                    importeDescuento1TotalDocumento += posicion.getImporteDescuentoTD().floatValue();                                                                                 
                }
                if (posicion.getImporteDescuentoSinImpuestosTD()!=null){
                    importeDescuento1SinImpuestoTotalDocumento += posicion.getImporteDescuentoSinImpuestosTD().floatValue();                                                          
                }
                if (posicion.getPrecioFacturaTD()!=null){
                    precioFacturaTotalDocumento += posicion.getPrecioFacturaTD().floatValue();                                                                                    
                }
                if (posicion.getPrecioTotalTD()!=null){
                    precioTotalTotalDocumento += posicion.getPrecioTotalTD().floatValue();                                                                                            
                }
                //fin if moneda != null
            }else{
                if(!it.hasNext()){ //es la ultima posicion
                    precioCatalogoTotalDocumento = precioCatalogoTotalLocal;                                                                                              
                    precioCatalogoTotalDocumentoUnidadesPorAtender = precioCatalogoTotalLocalUnidadesPorAtender; 
                    precioCatalogoSinImpuestoTotalDocumento = precioCatalogoSinImpuestoTotalLocal;                                                                       
                    precioContableTotalDocumento = precioContableTotalLocal;                                                                                 
                    importeDescuento1TotalDocumento = importeDescuento1TotalLocal;                                                                                 
                    importeDescuento1SinImpuestoTotalDocumento = importeDescuento1SinImpuestoTotalLocal; 
                    precioFacturaTotalDocumento = precioFacturaTotalLocal;                                                                                    
                    precioTotalTotalDocumento = precioTotalTotalLocal; 
                    importeDescuentoSinImpuestosTotalDocumento = importeDescuentoSinImpuestosTotalLocal;
                    sumatoriaPrecioNetoTotalDocumento = sumatoriaPrecioNetoTotalLocal;
                    sumatoriaPrecioCatalogoSinImpuestoTotalDocumento = sumatoriaPrecioCatalogoSinImpuestoTotalLocal;
                }
            }			                                                                                                                                                   	                                                                                                                                                                                 
        }  // fin while de posiciones          
        if (dtoe.getBaseImponiblePrecioContableLocal()!=null){		
            precioContableSinImpuestoTotalLocal = dtoe.getBaseImponiblePrecioContableLocal().floatValue();                                                                                                 
        }
        if (dtoe.getBaseImponiblePrecioContableDocumento()!=null){		
            precioContableSinImpuestoTotalDocumento = dtoe.getBaseImponiblePrecioContableDocumento().floatValue();                                                                                         
        }
        if ((dtoConsolidado !=null) && (dtoConsolidado.getImporteDescuento3TotalLocal()!=null)){		
            importeDescuento3TotalLocal = dtoConsolidado.getImporteDescuento3TotalLocal().floatValue();
        }
        if ((dtoConsolidado !=null) && (dtoConsolidado.getImporteDescuento3TotalDocumento()!=null)){		
            importeDescuento3TotalDocumento = dtoConsolidado.getImporteDescuento3TotalDocumento().floatValue();
        }
        if (dtoe.getBaseImponibleDescuento3Local()!=null){		
            importeDescuento3SinImpuestoTotalLocal = dtoe.getBaseImponibleDescuento3Local().floatValue();                                                                                             
        }
        if (dtoe.getBaseImponibleDescuento3Documento()!=null){		
            importeDescuento3SinImpuestoTotalDocumento = dtoe.getBaseImponibleDescuento3Documento().floatValue();                                                                                     
        }
    
        importeDescuentoTotalLocal = importeDescuento1TotalLocal + precioContableTotalLocal + importeDescuento3TotalLocal;
        importeDescuentoTotalDocumento = importeDescuento1TotalDocumento + precioContableTotalDocumento + importeDescuento3TotalDocumento;
    
        if (dtoe.getTotalBaseImponibleLocal()!=null){		
            precioNetoTotalLocal = dtoe.getTotalBaseImponibleLocal().floatValue();                                                                                                                         
        }
        if (dtoe.getTotalBaseImponibleDocumento()!=null){		
            precioNetoTotalDocumento = dtoe.getTotalBaseImponibleDocumento().floatValue();
        }
        if (dtoe.getTotalImpuestosLocal()!=null){		
            importeImpuestosTotalLocal = dtoe.getTotalImpuestosLocal().floatValue();                                                                                                                       
        }
        if (dtoe.getTotalImpuestosDocumento()!=null){		
            importeImpuestosTotalDocumento = dtoe.getTotalImpuestosDocumento().floatValue();
        }
        if (dtoe.getTotalImporteLocal()!=null){		
            totalAPagarLocal = dtoe.getTotalImporteLocal().floatValue();
        }
        if (dtoe.getTotalImporteLocal()!=null){		
            totalAPagarDocumento = dtoe.getTotalImporteDocumento().floatValue();
        }

        if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))) {
           if (dtoe.getCodigoTipoProgramaConcurso() != null) {
                importeRedondeoLocal = 0;                        
           } else {
                /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
                importeRedondeoLocal = sumatoriaPrecioCatalogoSinImpuestoTotalLocal - sumatoriaPrecioNetoTotalLocal - importeDescuentoSinImpuestosTotalLocal;
                importeRedondeoDocumento = sumatoriaPrecioCatalogoSinImpuestoTotalDocumento - sumatoriaPrecioNetoTotalDocumento - importeDescuentoSinImpuestosTotalDocumento;
                /* Agregado por Cambio SiCC20090847 ---- AL - 03/03/2009 */
                /* Eliminado por Cambio SiCC20090847 ---- AL - 03/03/2009 
                importeRedondeoLocal = precioCatalogoSinImpuestoTotalLocal - precioNetoTotalLocal - importeDescuentoSinImpuestosTotalLocal;
                importeRedondeoDocumento = precioCatalogoSinImpuestoTotalDocumento - precioNetoTotalDocumento - importeDescuentoSinImpuestosTotalDocumento;
                */
           }
        } else {
            if (dtoe.getIndicadorImpuestosIncluidos().booleanValue()) {
                importeRedondeoLocal = totalAPagarLocal + precioContableTotalLocal - precioTotalTotalLocal - dtoConsolidado.getImporteFleteTotalLocal().floatValue() + importeDescuento3TotalLocal;
                importeRedondeoDocumento = totalAPagarDocumento + precioContableTotalDocumento  - precioTotalTotalDocumento - dtoConsolidado.getImporteFleteTotalDocumento().floatValue() + importeDescuento3TotalDocumento;
            } else {
                importeRedondeoLocal = 0;        
            }
        }        

        importeRedondeoConsolidadoLocal = 0;                                                                                                                                              
        importeRedondeoConsolidadoDocumento = 0;                                                                                                                                          
                                                                                                                                                                                                        
        DTOFACCalculosCabeceraSalida dtos = new DTOFACCalculosCabeceraSalida();                                                                                                                   

        dtos.setUnidadesDemandaRealTotal(new Integer(unidadesDemandaRealTotal));                                                                                                                  
        dtos.setUnidadesPorAtenderTotal(new Integer(unidadesPorAtenderTotal));                                                                                                                    
        dtos.setUnidadesAtendidasTotal(new Integer(unidadesAtendidasTotal));
        dtos.setPrecioContableSinImpuestoTotalDocumento(new Float(precioContableSinImpuestoTotalDocumento));
        dtos.setPrecioContableSinImpuestoTotalLocal(new Float(precioContableSinImpuestoTotalLocal));
        dtos.setImporteDescuento3SinImpuestoTotalDocumento(new Float(importeDescuento3SinImpuestoTotalDocumento));
        dtos.setImporteDescuento3SinImpuestoTotalLocal(new Float(importeDescuento3SinImpuestoTotalLocal));
        dtos.setImporteDescuentoTotalLocal(Redondear.redondearFloat(new Float(importeDescuentoTotalLocal),this.numeroDecimalesRedondeo));
        dtos.setImporteDescuentoTotalDocumento(Redondear.redondearFloat(new Float(importeDescuentoTotalDocumento),this.numeroDecimalesRedondeo));
        dtos.setPrecioNetoTotalLocal(Redondear.redondearFloat(new Float(precioNetoTotalLocal),this.numeroDecimalesRedondeo));
        dtos.setPrecioNetoTotalDocumento(Redondear.redondearFloat(new Float(precioNetoTotalDocumento),this.numeroDecimalesRedondeo));
        dtos.setImporteImpuestosTotalLocal(new Float(importeImpuestosTotalLocal));
        dtos.setImporteImpuestosTotalDocumento(new Float(importeImpuestosTotalDocumento));
        dtos.setTotalAPagarLocal(new Float(totalAPagarLocal));
        dtos.setTotalAPagarDocumento(new Float(totalAPagarDocumento));
        dtos.setImporteRedondeoLocal(Redondear.redondearFloat(new Float(importeRedondeoLocal),this.numeroDecimalesRedondeo));
        dtos.setImporteRedondeoDocumento(Redondear.redondearFloat(new Float(importeRedondeoDocumento),this.numeroDecimalesRedondeo));
        dtos.setImporteRedondeoConsolidadoLocal(new Float(importeRedondeoConsolidadoLocal));
        dtos.setImporteRedondeoConsolidadoDocumento(new Float(importeRedondeoConsolidadoDocumento));
        dtos.setPrecioCatalogoTotalLocal(Redondear.redondearFloat(new Float(precioCatalogoTotalLocal),this.numeroDecimalesRedondeo));                                                                       
        dtos.setPrecioCatalogoTotalLocalUnidadesPorAtender(Redondear.redondearFloat(new Float(precioCatalogoTotalLocalUnidadesPorAtender),this.numeroDecimalesRedondeo));                                   
        dtos.setPrecioCatalogoSinImpuestoTotalLocal(Redondear.redondearFloat(new Float(precioCatalogoSinImpuestoTotalLocal),this.numeroDecimalesRedondeo));                                                 
        dtos.setPrecioContableTotalLocal(Redondear.redondearFloat(new Float(precioContableTotalLocal),this.numeroDecimalesRedondeo));                                                                       
        dtos.setImporteDescuento1TotalLocal(Redondear.redondearFloat(new Float(importeDescuento1TotalLocal),this.numeroDecimalesRedondeo));                                                                 
        dtos.setImporteDescuento1SinImpuestoTotalLocal(Redondear.redondearFloat(new Float(importeDescuento1SinImpuestoTotalLocal),this.numeroDecimalesRedondeo));                                           
        dtos.setPrecioFacturaTotalLocal(Redondear.redondearFloat(new Float(precioFacturaTotalLocal),this.numeroDecimalesRedondeo));                                                                         
        dtos.setPrecioCatalogoTotalDocumento(Redondear.redondearFloat(new Float(precioCatalogoTotalDocumento),this.numeroDecimalesRedondeo));                                                               
        dtos.setPrecioCatalogoTotalDocumentoUnidadesPorAtender(Redondear.redondearFloat(new Float(precioCatalogoTotalDocumentoUnidadesPorAtender),this.numeroDecimalesRedondeo));                           
        dtos.setPrecioCatalogoSinImpuestoTotalDocumento(Redondear.redondearFloat(new Float(precioCatalogoSinImpuestoTotalDocumento),this.numeroDecimalesRedondeo));                                         
        dtos.setPrecioContableTotalDocumento(Redondear.redondearFloat(new Float(precioContableTotalDocumento),this.numeroDecimalesRedondeo));                                                               
        dtos.setImporteDescuento1TotalDocumento(Redondear.redondearFloat(new Float(importeDescuento1TotalDocumento),this.numeroDecimalesRedondeo));                                                         
        dtos.setImporteDescuento1SinImpuestoTotalDocumento(Redondear.redondearFloat(new Float(importeDescuento1SinImpuestoTotalDocumento),this.numeroDecimalesRedondeo));                                   
        dtos.setPrecioFacturaTotalDocumento(Redondear.redondearFloat(new Float(precioFacturaTotalDocumento),this.numeroDecimalesRedondeo));                                                                 
        dtos.setPrecioTotalTotalLocal(Redondear.redondearFloat(new Float(precioTotalTotalLocal),this.numeroDecimalesRedondeo));                                                                             
        dtos.setPrecioTotalTotalDocumento(Redondear.redondearFloat(new Float(precioTotalTotalDocumento),this.numeroDecimalesRedondeo));                                                                     

        UtilidadesLog.info("MONFacturacionBean.realizarCalculosCabecera(DTOFACCalculosCabeceraEntrada dtoe): Salida");
        return dtos;     
	}

    public DTOFACCalculosImpuestosSalida realizarCalculosImpuestos (DTOFACCalculosImpuestosEntrada dtoe) throws MareException {
      UtilidadesLog.info("MONFacturacionBean.realizarCalculosImpuestos (DTOFACCalculosImpuestosEntrada dtoe): Entrada");
      DTOFACCabeceraSolicitud dtoConsolidado  = new DTOFACCabeceraSolicitud();
      DTOFACCalculosImpuestosSalida dtos = new DTOFACCalculosImpuestosSalida();
      ArrayList listaPosicionesConsolidados  = null;
      if(dtoe.getListaPosiciones() != null) {
        listaPosicionesConsolidados  = (ArrayList)dtoe.getListaPosiciones().clone();
      } else {
        listaPosicionesConsolidados  = new ArrayList();
      }
        
      Character indicadorCalculo = dtoe.getIndicadorCalculo();
      float tempDescuentoCabeceraLocalAcumulado = 0;
      float tempDescuentoCabeceraDocumentoAcumulado = 0;
      float baseImponibleDescuento3LocalT = 0;
      float baseImponibleDescuento3DocumentoT = 0;
      float baseImponiblePrecioContableLocalT = 0;
      float baseImponiblePrecioContableDocumentoT = 0;
      float totalBaseImponibleLocalT = 0;
      float totalBaseImponibleDocumentoT = 0;
      float totalImpuestosLocalT = 0;
      float totalImpuestosDocumentoT = 0;
      float totalImporteLocalT = 0;
      float totalImporteDocumentoT = 0;
		
		
      dtoConsolidado = dtoe.getDtoConsolidado();

      Hashtable hashtable = new Hashtable();
      this.numeroDecimalesRedondeo = dtoConsolidado.getNumeroDecimalesRedondeo();

      Long indicador=null;
      ArrayList arrayListTemp = new ArrayList();
      DTOFACPosicionSolicitud dtoPosAux = new DTOFACPosicionSolicitud();
			
      for (int i = 0;i<listaPosicionesConsolidados.size();i++) {
        CalculosImporteMoneda calculosImporteMoneda = new CalculosImporteMoneda();
        indicador = ((DTOFACPosicionSolicitud)listaPosicionesConsolidados.get(i)).getIndicadorImpuestos();
        if(indicador == null) {
          indicador = new Long(Long.MAX_VALUE);
        }
        arrayListTemp.add((DTOFACPosicionSolicitud)listaPosicionesConsolidados.get(i));
        for (int j=i+1;j<listaPosicionesConsolidados.size();j++) {
          Long indicador2 = ((DTOFACPosicionSolicitud)listaPosicionesConsolidados.get(j)).getIndicadorImpuestos();
          if (indicador2 == null) {
            indicador2 = new Long(Long.MAX_VALUE);
          }
          if(indicador.longValue()== indicador2.longValue()) {
            arrayListTemp.add((DTOFACPosicionSolicitud)listaPosicionesConsolidados.get(j));
            listaPosicionesConsolidados.remove(j);
            j-=1;
          }
        }
        calculosImporteMoneda.setListaPosiciones(arrayListTemp);
        hashtable.put(indicador,calculosImporteMoneda);
      }
      Enumeration listaKeys = hashtable.keys();
      ArrayList calImporMoneda=new ArrayList(); //va a contener objetos del tipo CalculosImporteMoneda
      StringBuffer acumulado = new StringBuffer();
      while (listaKeys.hasMoreElements()) {
        Long clave = new Long(listaKeys.nextElement().toString()); // indicadorImpuestos
        CalculosImporteMoneda  calculosImporteMoneda = null;
        ArrayList listaPosicionesTemp = null;

      	calculosImporteMoneda = (CalculosImporteMoneda)hashtable.get(clave);

        if (calculosImporteMoneda != null) {
          listaPosicionesTemp = calculosImporteMoneda.getListaPosiciones();                 
          float sumatorioBaseImponibleLocal = 0;
          BigDecimal sumatorioBaseImponibleLocalRedondeado = new BigDecimal(0);
          float sumatorioBaseImponibleDocumento = 0;
          float sumatorioTotalPreciosPosicionLocal = 0;
          float sumatorioTotalPreciosPosicionDocumento = 0;
          float sumatorioTotalDescuentoCabeceraLocal = 0;
          float sumatorioTotalDescuentoCabeceraDocumento = 0;
          float sumatorioPrecioSinImpuestosTL =0;
          float sumatorioPrecioSinImpuestosTD =0;
          Iterator itListatemp = listaPosicionesTemp.iterator();
				
          while (itListatemp.hasNext()) {
            dtoPosAux = (DTOFACPosicionSolicitud)itListatemp.next();
            sumatorioBaseImponibleLocal += dtoPosAux.getPrecioNetoTL().floatValue();
            sumatorioBaseImponibleLocalRedondeado = sumatorioBaseImponibleLocalRedondeado.add(new BigDecimal(dtoPosAux.getPrecioNetoTL().floatValue()).setScale(this.numeroDecimalesRedondeo.intValue(), BigDecimal.ROUND_HALF_EVEN));
          
            if(dtoPosAux.getPrecioContableTL().floatValue() != 0 ){ //incidencia 10370
              sumatorioPrecioSinImpuestosTL += dtoPosAux.getPrecioSinImpuestosTL().floatValue();
            }
										 
            if( dtoConsolidado.getImporteDescuento3TotalLocal().floatValue() != 0){
              sumatorioTotalPreciosPosicionLocal += dtoPosAux.getPrecioCatalogoTL().floatValue() + dtoPosAux.getPrecioContableTL().floatValue(); 	
              sumatorioTotalDescuentoCabeceraLocal += dtoPosAux.getPrecioTotalTL().floatValue();
            }
				 
            if(dtoe.getMoneda() != null) {
              sumatorioBaseImponibleDocumento += dtoPosAux.getPrecioNetoTD().floatValue();
              if (dtoPosAux.getPrecioContableTD().floatValue() != 0 ) {
                sumatorioPrecioSinImpuestosTD += dtoPosAux.getPrecioSinImpuestosTD().floatValue();
              }
                                              
              if ( dtoConsolidado.getImporteDescuento3TotalDocumento().floatValue() != 0 ) {
                sumatorioTotalPreciosPosicionDocumento += dtoPosAux.getPrecioCatalogoTD().floatValue() + dtoPosAux.getPrecioContableTD().floatValue();
                sumatorioTotalDescuentoCabeceraDocumento += dtoPosAux.getPrecioTotalTD().floatValue();
              }
            } else {
              if (!itListatemp.hasNext()) { // es la ultima posicion
                sumatorioBaseImponibleDocumento = sumatorioBaseImponibleLocal;
                sumatorioPrecioSinImpuestosTD = sumatorioPrecioSinImpuestosTL;
                sumatorioTotalPreciosPosicionDocumento = sumatorioTotalPreciosPosicionLocal;    
                sumatorioTotalDescuentoCabeceraDocumento = sumatorioTotalDescuentoCabeceraLocal;
              }
            }
          }//***** fin while itListatemp
           /* Modificado por SiCC20080562 --- AL --- 11/11/2008 */
           UtilidadesLog.debug("[MONFacturacionBean.realizarCalculosImpuestos] - Sumatorio BIL --> " +  sumatorioBaseImponibleLocalRedondeado);
           calculosImporteMoneda.setBaseImponiblePosicionLocal(new Float(sumatorioBaseImponibleLocalRedondeado.floatValue()));                    
           //calculosImporteMoneda.setBaseImponiblePosicionLocal(Redondear.redondearFloat(new Float(sumatorioBaseImponibleLocal), this.numeroDecimalesRedondeo));
           /* Modificado por SiCC20080562 --- AL --- 11/11/2008 */
          if( dtoConsolidado.getImporteDescuento3TotalLocal().floatValue() != 0){
            calculosImporteMoneda.setTotalPreciosPosicionLocal(Redondear.redondearFloat(new Float(sumatorioTotalPreciosPosicionLocal),numeroDecimalesRedondeo));
            if(!listaKeys.hasMoreElements()) {  // Si( Hash{indicadorImpuestos} es el �ltimo o �nico elemento del hash 
              calculosImporteMoneda.setTotalDescuentoCabeceraLocal(Redondear.redondearFloat(new Float((dtoConsolidado.getImporteDescuento3TotalLocal().floatValue() - tempDescuentoCabeceraLocalAcumulado)),numeroDecimalesRedondeo)); 
            } else {
              if(dtoPosAux.getTasaImpuesto().floatValue() != 0) { //Modificado por incidencia BELC300010556
                calculosImporteMoneda.setTotalDescuentoCabeceraLocal(Redondear.redondearFloat(new Float(dtoConsolidado.getImporteDescuento3TotalLocal().floatValue()/sumatorioTotalDescuentoCabeceraLocal*dtoPosAux.getTasaImpuesto().floatValue()), this.numeroDecimalesRedondeo));
                tempDescuentoCabeceraLocalAcumulado += calculosImporteMoneda.getTotalDescuentoCabeceraLocal().floatValue();
              } else {
                calculosImporteMoneda.setTotalDescuentoCabeceraLocal(new Float(0));
              }
            } 
            if(dtoe.getIndicadorImpuestosIncluidos().booleanValue()) {
              calculosImporteMoneda.setBaseImponibleDescuento3Local(Redondear.redondearFloat(new Float((calculosImporteMoneda.getTotalDescuentoCabeceraLocal().floatValue())/(1 + dtoPosAux.getTasaImpuesto().floatValue()/100)),this.numeroDecimalesRedondeo));
            } else {
              calculosImporteMoneda.setBaseImponibleDescuento3Local(calculosImporteMoneda.getTotalDescuentoCabeceraLocal());
            }
          } else {
            calculosImporteMoneda.setTotalPreciosPosicionLocal(Redondear.redondearFloat(new Float(sumatorioTotalPreciosPosicionLocal),numeroDecimalesRedondeo));
            calculosImporteMoneda.setTotalDescuentoCabeceraLocal(new Float(0));
            calculosImporteMoneda.setBaseImponibleDescuento3Local(new Float(0));  
          }
          /* Agregado por Cambio FAC-003 ------ AL */
          if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))) {            
            if (dtoe.getCodigoTipoProgramaConcurso() != null && (dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("C") || dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("R"))) {              
              UtilidadesLog.debug("No se suma este importe Por Cambio FAC-003, el Codigo de Programa es:" + dtoe.getCodigoTipoProgramaConcurso());
              calculosImporteMoneda.setBaseImponiblePrecioContableLocal(new Float(0));
            } else {
              calculosImporteMoneda.setBaseImponiblePrecioContableLocal(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTL), this.numeroDecimalesRedondeo));
            }
          } else {
            calculosImporteMoneda.setBaseImponiblePrecioContableLocal(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTL), this.numeroDecimalesRedondeo));
          }
          /* Agregado por Cambio FAC-003 ------ AL */
          
          /* Eliminado por Cambio FAC-003 ------ AL  
          calculosImporteMoneda.setBaseImponiblePrecioContableLocal(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTL), this.numeroDecimalesRedondeo));
          Eliminado por Cambio FAC-003 ------ AL  */


         
        if (dtoe.getIndicadorImpuestoFlete() != null) {
          if (dtoe.getImporteFleteSinImpuestosTotalLocal()!=null){
            calculosImporteMoneda.setBaseImponibleFleteLocal(dtoe.getImporteFleteSinImpuestosTotalLocal());
          } else {
            calculosImporteMoneda.setBaseImponibleFleteLocal(new Float(0));
          }                
        } else {
          calculosImporteMoneda.setBaseImponibleFleteLocal(new Float(0));
        }        
        calculosImporteMoneda.setTotalBaseImponibleLocal(Redondear.redondearFloat(new Float(calculosImporteMoneda.getBaseImponibleFleteLocal().floatValue() 
                  - calculosImporteMoneda.getBaseImponiblePrecioContableLocal().floatValue() - calculosImporteMoneda.getBaseImponibleDescuento3Local().floatValue()
                  + calculosImporteMoneda.getBaseImponiblePosicionLocal().floatValue()), this.numeroDecimalesRedondeo));
       
        if (dtoe.getIndicadorImpuestoFlete() == null) {
          calculosImporteMoneda.setTotalImpuestosLocal(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue() * dtoPosAux.getTasaImpuesto().floatValue() / 100),this.numeroDecimalesRedondeo));    
        } else if (false && dtoe.getIndicadorImpuestoFlete().longValue() == clave.longValue()) { 
           //se omite esta linea
          calculosImporteMoneda.setTotalImpuestosLocal(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue() * dtoPosAux.getTasaImpuesto().floatValue() / 100),this.numeroDecimalesRedondeo));
        } else {
          UtilidadesLog.debug("-AL- getBaseImponiblePosicionLocal ---> " + calculosImporteMoneda.getBaseImponiblePosicionLocal().floatValue());
          UtilidadesLog.debug("-AL- getBaseImponiblePrecioContableLocal ---> " + calculosImporteMoneda.getBaseImponiblePrecioContableLocal().floatValue());
          UtilidadesLog.debug("-AL- getBaseImponibleDescuento3Local ---> " + calculosImporteMoneda.getBaseImponibleDescuento3Local().floatValue());
          UtilidadesLog.debug("-AL- dtoPosAux.getTasaImpuesto() ---> " + dtoPosAux.getTasaImpuesto().floatValue());
          UtilidadesLog.debug("-AL- getBaseImponibleFleteLocal ---> " + calculosImporteMoneda.getBaseImponibleFleteLocal().floatValue());
          UtilidadesLog.debug("-AL- dtoe.getIndicadorImpuestoFlete() ---> " + dtoe.getTasaImpuestoFlete().floatValue());
          
          
          Float aux1 = new Float((calculosImporteMoneda.getBaseImponiblePosicionLocal().floatValue() - calculosImporteMoneda.getBaseImponiblePrecioContableLocal().floatValue() - calculosImporteMoneda.getBaseImponibleDescuento3Local().floatValue()) * dtoPosAux.getTasaImpuesto().floatValue());
          Float aux2 = new Float((calculosImporteMoneda.getBaseImponibleFleteLocal().floatValue() * dtoe.getTasaImpuestoFlete().floatValue()));
          
          calculosImporteMoneda.setTotalImpuestosLocal(Redondear.redondearFloat(new Float((aux2.floatValue() + aux1.floatValue()) /100),this.numeroDecimalesRedondeo));
          UtilidadesLog.debug("-AL- setTotalImpuestosLocal ---> " + calculosImporteMoneda.getTotalImpuestosLocal().floatValue());
        }                  
        
        calculosImporteMoneda.setTotalImporteLocal(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue() 
                    + calculosImporteMoneda.getTotalImpuestosLocal().floatValue()),this.numeroDecimalesRedondeo));						
        baseImponibleDescuento3LocalT += calculosImporteMoneda.getBaseImponibleDescuento3Local().floatValue();        
        baseImponiblePrecioContableLocalT += calculosImporteMoneda.getBaseImponiblePrecioContableLocal().floatValue();
        totalBaseImponibleLocalT += calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue();				
        totalImpuestosLocalT += calculosImporteMoneda.getTotalImpuestosLocal().floatValue();
        totalImporteLocalT += calculosImporteMoneda.getTotalImporteLocal().floatValue();
        if (dtoe.getMoneda() != null) {
          calculosImporteMoneda.setBaseImponiblePosicionesDocumento(Redondear.redondearFloat(new Float(sumatorioBaseImponibleDocumento), this.numeroDecimalesRedondeo));
          if( dtoConsolidado.getImporteDescuento3TotalDocumento().floatValue() != 0){
            calculosImporteMoneda.setTotalPreciosPosicionDocumento(Redondear.redondearFloat(new Float(sumatorioTotalPreciosPosicionDocumento),numeroDecimalesRedondeo));
            if(!listaKeys.hasMoreElements()) {  // Si( Hash{indicadorImpuestos} es el �ltimo o �nico elemento del hash 
              calculosImporteMoneda.setTotalDescuentoCabeceraDocumento(Redondear.redondearFloat(new Float((dtoConsolidado.getImporteDescuento3TotalDocumento().floatValue() -
                            tempDescuentoCabeceraDocumentoAcumulado)),numeroDecimalesRedondeo)); 
            } else {
              if(dtoPosAux.getTasaImpuesto().floatValue() != 0) {
                calculosImporteMoneda.setTotalDescuentoCabeceraDocumento(Redondear.redondearFloat( new Float(dtoConsolidado
                                  .getImporteDescuento3SinImpuestosTotalDocumento().floatValue()/sumatorioTotalDescuentoCabeceraDocumento*dtoPosAux.getTasaImpuesto().floatValue()), this.numeroDecimalesRedondeo));
                              
                tempDescuentoCabeceraDocumentoAcumulado += calculosImporteMoneda.getTotalDescuentoCabeceraDocumento().floatValue();
              } else {
                calculosImporteMoneda.setTotalDescuentoCabeceraDocumento(new Float(0));
              }
            }                        
            if (dtoe.getIndicadorImpuestosIncluidos().booleanValue()) {
              calculosImporteMoneda.setBaseImponibleDescuento3Documento(Redondear.redondearFloat(new Float((calculosImporteMoneda.getTotalDescuentoCabeceraDocumento().floatValue())/1 + dtoPosAux.getTasaImpuesto().floatValue()/100),this.numeroDecimalesRedondeo));	
            } else {
              calculosImporteMoneda.setBaseImponibleDescuento3Documento(calculosImporteMoneda.getTotalDescuentoCabeceraDocumento());
            }
          } else {
            calculosImporteMoneda.setTotalPreciosPosicionDocumento(Redondear.redondearFloat(new Float(sumatorioTotalPreciosPosicionDocumento),numeroDecimalesRedondeo));
            calculosImporteMoneda.setTotalDescuentoCabeceraDocumento(new Float(0));
            calculosImporteMoneda.setBaseImponibleDescuento3Documento(new Float(0)); 
          }
          /* Agregado por Cambio FAC-003 ------ AL */
          if (indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)))) {            
            if (dtoe.getCodigoTipoProgramaConcurso() != null && (dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("C") || dtoe.getCodigoTipoProgramaConcurso().equalsIgnoreCase("R"))) {              
              UtilidadesLog.debug("No se suma este importe Por Cambio FAC-003, el Codigo de Programa es:" + dtoe.getCodigoTipoProgramaConcurso());
              calculosImporteMoneda.setBaseImponiblePrecioContableDocumento(new Float(0));
            } else {
              calculosImporteMoneda.setBaseImponiblePrecioContableDocumento(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTD), this.numeroDecimalesRedondeo));
            }
          } else {
            calculosImporteMoneda.setBaseImponiblePrecioContableDocumento(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTD), this.numeroDecimalesRedondeo));
          }
          /* Agregado por Cambio FAC-003 ------ AL */
          
          /* Eliminado por Cambio FAC-003 ------ AL  
          calculosImporteMoneda.setBaseImponiblePrecioContableDocumento(Redondear.redondearFloat(new Float(sumatorioPrecioSinImpuestosTD), this.numeroDecimalesRedondeo));
          Eliminado por Cambio FAC-003 ------ AL  */

          if (dtoe.getIndicadorImpuestoFlete() != null) {
            calculosImporteMoneda.setBaseImponibleFleteDocumento(dtoe.getImporteFleteSinImpuestosTotalDocumento());
          } else {
            calculosImporteMoneda.setBaseImponibleFleteDocumento(new Float(0));
          }                              
          calculosImporteMoneda.setTotalBaseImponibleDocumento(Redondear.redondearFloat(new Float(
                      (calculosImporteMoneda.getBaseImponibleFleteDocumento() != null ? calculosImporteMoneda.getBaseImponibleFleteDocumento().floatValue() : 0)
                      - (calculosImporteMoneda.getBaseImponiblePrecioContableDocumento() != null ? calculosImporteMoneda.getBaseImponiblePrecioContableDocumento().floatValue() : 0 )
                      - (calculosImporteMoneda.getBaseImponibleDescuento3Documento() != null ? calculosImporteMoneda.getBaseImponibleDescuento3Documento().floatValue() : 0 )
                      + (calculosImporteMoneda.getBaseImponiblePosicionesDocumento() != null ? calculosImporteMoneda.getBaseImponiblePosicionesDocumento().floatValue() : 0))
                                  , this.numeroDecimalesRedondeo));
          

          if  (dtoe.getIndicadorImpuestoFlete() == null) {
            calculosImporteMoneda.setTotalImpuestosDocumento(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleDocumento().floatValue() * dtoPosAux.getTasaImpuesto().floatValue() / 100),this.numeroDecimalesRedondeo));          
          } else if (dtoe.getIndicadorImpuestoFlete().longValue() == clave.longValue()) {
            calculosImporteMoneda.setTotalImpuestosDocumento(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleDocumento().floatValue() * dtoPosAux.getTasaImpuesto().floatValue() / 100),this.numeroDecimalesRedondeo));
          } else {
            Float aux1 = new Float(((calculosImporteMoneda.getBaseImponiblePosicionesDocumento() != null ? calculosImporteMoneda.getBaseImponiblePosicionesDocumento().floatValue() : 0)
                           - (calculosImporteMoneda.getBaseImponiblePrecioContableDocumento() != null ? calculosImporteMoneda.getBaseImponiblePrecioContableDocumento().floatValue() : 0 )
                           - (calculosImporteMoneda.getBaseImponibleDescuento3Documento() != null ? calculosImporteMoneda.getBaseImponibleDescuento3Documento().floatValue() : 0 )) * dtoPosAux.getTasaImpuesto().floatValue());
            Float aux2 = new Float(((calculosImporteMoneda.getBaseImponibleFleteDocumento() != null ? calculosImporteMoneda.getBaseImponibleFleteDocumento().floatValue() : 0) * dtoe.getTasaImpuestoFlete().floatValue()));
          
            calculosImporteMoneda.setTotalImpuestosDocumento(Redondear.redondearFloat(new Float((aux2.floatValue() + aux1.floatValue()) /100),this.numeroDecimalesRedondeo));
          }
          
          
          calculosImporteMoneda.setTotalImporteDocumento(Redondear.redondearFloat(new Float(calculosImporteMoneda.getTotalBaseImponibleDocumento().floatValue() 
                        + calculosImporteMoneda.getTotalImpuestosDocumento().floatValue()),this.numeroDecimalesRedondeo));						
                    
          baseImponibleDescuento3DocumentoT += calculosImporteMoneda.getBaseImponibleDescuento3Documento().floatValue();
          baseImponiblePrecioContableDocumentoT += calculosImporteMoneda.getBaseImponiblePrecioContableDocumento().floatValue();
          totalBaseImponibleDocumentoT += calculosImporteMoneda.getTotalBaseImponibleDocumento().floatValue();
          totalImpuestosDocumentoT += calculosImporteMoneda.getTotalImpuestosDocumento().floatValue();
          totalImporteDocumentoT += calculosImporteMoneda.getTotalImporteDocumento().floatValue();
					
        } else {
          baseImponibleDescuento3DocumentoT += baseImponibleDescuento3LocalT;
          baseImponiblePrecioContableDocumentoT += baseImponiblePrecioContableLocalT;
          totalBaseImponibleDocumentoT += totalBaseImponibleLocalT;
          totalImpuestosDocumentoT += totalImpuestosLocalT;
          totalImporteDocumentoT += totalImporteLocalT;
          calculosImporteMoneda.setBaseImponibleDescuento3Documento(new Float(calculosImporteMoneda.getBaseImponibleDescuento3Local().floatValue()));
          calculosImporteMoneda.setBaseImponibleFleteDocumento(new Float(calculosImporteMoneda.getBaseImponibleFleteLocal().floatValue()));
          calculosImporteMoneda.setBaseImponiblePosicionesDocumento(new Float(calculosImporteMoneda.getBaseImponiblePosicionLocal().floatValue()));
          calculosImporteMoneda.setBaseImponiblePrecioContableDocumento(new Float(calculosImporteMoneda.getBaseImponiblePrecioContableLocal().floatValue()));
          calculosImporteMoneda.setTotalBaseImponibleDocumento(new Float(calculosImporteMoneda.getTotalBaseImponibleLocal().floatValue()));
          calculosImporteMoneda.setTotalDescuentoCabeceraDocumento(new Float(calculosImporteMoneda.getTotalDescuentoCabeceraLocal().floatValue()));
          calculosImporteMoneda.setTotalImporteDocumento(new Float(calculosImporteMoneda.getTotalImporteLocal().floatValue()));
          calculosImporteMoneda.setTotalImpuestosDocumento(new Float(calculosImporteMoneda.getTotalImpuestosLocal().floatValue()));
          calculosImporteMoneda.setTotalPreciosPosicionDocumento(new Float(calculosImporteMoneda.getTotalPreciosPosicionLocal().floatValue()));
        } // fin de calculos de moneda	
      } //fin if calculosImporteMoneda != null                
      calculosImporteMoneda.setClaveIndicadorImpuestos(clave);
            
      if((new Character(ConstantesFAC.IND_CALCULO_SOLICITUD.charAt(0))).equals(indicadorCalculo) ){
        calImporMoneda.add(calculosImporteMoneda);
      }
      if(indicadorCalculo.equals(new Character(ConstantesFAC.IND_CALCULO_DOC_CONTABLE.charAt(0)) )){
        if (existeAcumulado(dtoConsolidado.getOidCabeceraSolicitud(),clave)){
          acumulado.append(generarUpdateAcumulado(calculosImporteMoneda, dtoConsolidado.getOidCabeceraSolicitud(),clave));
        } else {
          acumulado.append(generarInsertAcumulado(calculosImporteMoneda, dtoConsolidado.getOidCabeceraSolicitud(),clave));
        }                
      }
    }//final del bucle hash
        
    if (acumulado.length()>0){
      try {
        BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",acumulado.toString());
      } catch (Exception e) {
        UtilidadesLog.error("ERROR",e);
        throw new MareException(e);
      }
    }
    dtos.setBaseImponibleDescuento3Local(Redondear.redondearFloat(new Float(baseImponibleDescuento3LocalT),numeroDecimalesRedondeo));
    dtos.setBaseImponibleDescuento3Documento(Redondear.redondearFloat(new Float(baseImponibleDescuento3DocumentoT), numeroDecimalesRedondeo));

    dtos.setBaseImponiblePrecioContableLocal(Redondear.redondearFloat(new Float(baseImponiblePrecioContableLocalT),numeroDecimalesRedondeo));
    dtos.setBaseImponiblePrecioContableDocumento(Redondear.redondearFloat(new Float(baseImponiblePrecioContableDocumentoT),numeroDecimalesRedondeo));

    dtos.setTotalBaseImponibleLocal(Redondear.redondearFloat(new Float(totalBaseImponibleLocalT),numeroDecimalesRedondeo)) ;
    dtos.setTotalBaseImponibleDocumento(Redondear.redondearFloat(new Float(totalBaseImponibleDocumentoT),numeroDecimalesRedondeo)) ;
			
    dtos.setTotalImpuestosLocal(Redondear.redondearFloat(new Float(totalImpuestosLocalT),numeroDecimalesRedondeo)) ;
    dtos.setTotalImpuestosDocumento(Redondear.redondearFloat(new Float(totalImpuestosDocumentoT),numeroDecimalesRedondeo));

    dtos.setTotalImporteLocal(Redondear.redondearFloat(new Float(totalImporteLocalT),numeroDecimalesRedondeo));
    dtos.setTotalImporteDocumento(Redondear.redondearFloat(new Float(totalImporteDocumentoT),numeroDecimalesRedondeo));
           
    dtos.setDatosAcumuladosImpuestos(calImporMoneda);          
    UtilidadesLog.info("MONFacturacionBean.realizarCalculosImpuestos (DTOFACCalculosImpuestosEntrada dtoe): Salida");        
    return dtos;
  }
    
    private boolean existeAcumulado (Long cabecera, Long tasaImpuesto) throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append(" select count(*) from fac_docum_conta_acumu_impue where dcca_oid_cabe = "+cabecera+" and taim_oid_tasa_impu = "+tasaImpuesto);
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
        sb.append("INSERT INTO fac_docum_conta_acumu_impue ");
        sb.append(" (oid_doc_cont_acum_impu, num_base_impo_posi_loca, ");
        sb.append(" num_tota_prec_posi_loca, num_tota_desc_cabe_loca, ");
        sb.append(" num_base_impo_desc_cabe_loca, num_base_impo_prec_cont_loca, ");
        sb.append(" num_base_impo_flet_loca, num_base_impo_tota_loca, ");
        sb.append(" num_tota_impu_loca, num_tota_impo_loca, num_base_impo_posi_docu, ");
        sb.append(" num_tota_prec_posi_docu, num_tota_desc_cabe_docu, ");
        sb.append(" num_base_impo_desc_cabe_docu, num_base_impo_prec_cont_docu, ");
        sb.append(" num_base_impo_flet_docu, num_base_impo_tota_docu, ");
        sb.append(" num_tota_impu_docu, num_tota_impo_docu, taim_oid_tasa_impu, ");
        sb.append(" dcca_oid_cabe ");
        sb.append(" ) ");
        sb.append(" VALUES ( FAC_DCAI_SEQ.nextVal ");
        sb.append(" , "+c.getBaseImponiblePosicionLocal());
        sb.append(" , "+c.getTotalPreciosPosicionLocal());
        sb.append(" , "+c.getTotalDescuentoCabeceraLocal());
        sb.append(" , "+c.getBaseImponibleDescuento3Local()); 
        sb.append(" , "+c.getBaseImponiblePrecioContableLocal());
        sb.append(" , "+c.getBaseImponibleFleteLocal());
        sb.append(" , "+c.getTotalBaseImponibleLocal());
        sb.append(" , "+c.getTotalImpuestosLocal());
        sb.append(" , "+c.getTotalImporteLocal());
        sb.append(" , "+c.getBaseImponiblePosicionesDocumento());  
        sb.append(" , "+c.getTotalPreciosPosicionDocumento());
        sb.append(" , "+c.getTotalDescuentoCabeceraDocumento());
        sb.append(" , "+c.getBaseImponibleDescuento3Documento()); 
        sb.append(" , "+c.getBaseImponiblePrecioContableDocumento());
        sb.append(" , "+c.getBaseImponibleFleteDocumento());
        sb.append(" , "+c.getTotalBaseImponibleDocumento());
        sb.append(" , "+c.getTotalImpuestosDocumento());
        sb.append(" , "+c.getTotalImporteDocumento());
        sb.append(" , "+tasaImpuesto);
        sb.append(" , "+cabecera);        
        sb.append(");");
        
        return sb;
    }
    
    private StringBuffer generarUpdateAcumulado (CalculosImporteMoneda c , Long cabecera, Long tasaImpuesto){
        StringBuffer sb = new StringBuffer();
        sb.append("update fac_docum_conta_acumu_impue set ");
        sb.append(" num_base_impo_posi_loca= "+c.getBaseImponiblePosicionLocal());
        sb.append(" , num_tota_prec_posi_loca= "+c.getTotalPreciosPosicionLocal());
        sb.append(" , num_tota_desc_cabe_loca=  "+c.getTotalDescuentoCabeceraLocal());
        sb.append(" ,num_base_impo_desc_cabe_loca= "+c.getBaseImponibleDescuento3Local()); 
        sb.append(" , num_base_impo_prec_cont_loca=  "+c.getBaseImponiblePrecioContableLocal());
        sb.append(" ,num_base_impo_flet_loca=  "+c.getBaseImponibleFleteLocal());
        sb.append(" , num_base_impo_tota_loca=  "+c.getTotalBaseImponibleLocal());
        sb.append(" ,num_tota_impu_loca=  "+c.getTotalImpuestosLocal());
        sb.append(" , num_tota_impo_loca=  "+c.getTotalImporteLocal());
        sb.append(" , num_base_impo_posi_docu="+c.getBaseImponiblePosicionesDocumento());  
        sb.append(" ,num_tota_prec_posi_docu=  "+c.getTotalPreciosPosicionDocumento());
        sb.append(" , num_tota_desc_cabe_docu=  "+c.getTotalDescuentoCabeceraDocumento());
        sb.append(" ,num_base_impo_desc_cabe_docu= "+c.getBaseImponibleDescuento3Documento()); 
        sb.append(" , num_base_impo_prec_cont_docu=  "+c.getBaseImponiblePrecioContableDocumento());
        sb.append(" ,num_base_impo_flet_docu=  "+c.getBaseImponibleFleteDocumento());
        sb.append(" , num_base_impo_tota_docu=  "+c.getTotalBaseImponibleDocumento());
        sb.append(" ,num_tota_impu_docu=  "+c.getTotalImpuestosDocumento());
        sb.append(" , num_tota_impo_docu = "+c.getTotalImporteDocumento());
        sb.append(" where dcca_oid_cabe = "+cabecera);
        sb.append(" and taim_oid_tasa_impu = "+tasaImpuesto);
        sb.append(";");
        return sb;
    }

	public void realizarProyeccionDemandaReal(ArrayList listaSolicitudes) {
		UtilidadesLog.info("Proceso de Proyecci�n Demanda Real no implementado");
	}

	public void realizarDemandaAnticipada(ArrayList listaSolicitudes) {
		UtilidadesLog.info("Proceso de Demanda Anticipada no implementado");
	}

	public void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException {
        UtilidadesLog.info("MONFacturacionBean.esperarProcesamiento(String codigoProceso): Entrada");
        BatchUtil.esperarHijosFacturacion(codigoProceso);	
		UtilidadesLog.info("MONFacturacionBean.esperarProcesamiento(String codigoProceso): Salida");
	}
  
      /* Agregado por Brecha PED-006 ------ AL */ 
    private void refrescarMVImpuestosUbigeo() throws MareException{
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          belcorpService.dbService.executeProcedure("FAC_REFRE_ARBOL_IMPUESTOS", new String(" "));
        } catch ( Exception ex ) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }  
    } 
    /* Agregado por Brecha PED-006 ------ AL */

  
	public void arrancarFacturacionReal(DTOArranqueGP dtoE) throws MareException {
      UtilidadesLog.info("MONFacturacionBean.arrancarFacturacionReal(DTOArranqueGP dtoE): Entrada");
      Date date1 = new Date();
  		String codigoError = null;
	  	DTOSolicitudValidacion dtoSV = (DTOSolicitudValidacion)dtoE.getListaSolicitudes().get(0);

      Long oidPais = dtoSV.getOidPais();
      if (dtoSV.getNumDecimales() != null) {
        this.numeroDecimalesRedondeo = dtoSV.getNumDecimales() ; 
      } 
      Long oidMoneda = dtoSV.getOidMoneda();
    
      UtilidadesLog.info("MONFacturacionBean.arrancarFacturacionReal, numeroDecimalesRedondeo (1): " + this.numeroDecimalesRedondeo);
      this.obtenerDatosPais(oidPais, oidMoneda);
      UtilidadesLog.info("MONFacturacionBean.arrancarFacturacionReal, numeroDecimalesRedondeo (2): " + this.numeroDecimalesRedondeo);
      if (this.numeroDecimalesRedondeo == null) {
          this.numeroDecimalesRedondeo = new Integer(2);
      }

      if(dtoE.getListaSolicitudes().size() != 0){
          /* Agregado por Brecha PED-006 ------ AL */
          this.refrescarMVImpuestosUbigeo();
          /* Agregado por Brecha PED-006 ------ AL */

          DTOGenerarConsolidado dtoGN = new DTOGenerarConsolidado();
          dtoGN.setListaSolicitudes(dtoE.getListaSolicitudes());
          dtoGN.setSecuencia(dtoE.getParametros().getSecuencia());
          dtoGN.setFechaFacturacion(dtoE.getParametros().getFechaFacturacion()); 
          dtoGN.setNumeroLoteFacturacion(this.numeroLote);
          dtoGN.setIndicadorSecuenciacion(this.indicadorSecuenciacion); 
          dtoGN.setIDProceso(dtoE.getParametros().getIDProc());
          dtoGN.setCodCaja(dtoE.getParametros().getCodCaja()); 
          dtoGN.setindicadorImpuestosIncluidos(this.indicadorImpuestosIncluidos);
          this.listaConsolidados = this.generarConsolidados(dtoGN); 

          if(this.listaConsolidados == null){
              ctx.setRollbackOnly();
              return;
          }else{
                DAOFACPrecargas daoFP = new DAOFACPrecargas();

                this.secuenciaProcesos = daoFP.cargarSecuenciaProcesos(ConstantesPED.GP5,null,null);
    
                DTOFACConsolidado consolidado = null;
                DTOFACCabeceraSolicitud cabecera = null;
                if(this.indicadorSecuenciacion != null){

                    MONSecuYMarcasChequeoLocal mONSecuYMarcasChequeo = this.getMONSecuYMarcasChequeoLocal();
                    DTOFACCabeceraSolicitud listaCabeceras[] = new DTOFACCabeceraSolicitud[this.listaConsolidados.size()];
                   
                    int i=0;
                    Iterator itConsolidados = this.listaConsolidados.iterator();
                
                    while(itConsolidados.hasNext()){
                        consolidado = (DTOFACConsolidado)itConsolidados.next();
                        consolidado.setOidPais(oidPais);
                        listaCabeceras[i] = new DTOFACCabeceraSolicitud();
                        listaCabeceras[i] = consolidado.getDtoCabecera();
                        listaCabeceras[i].setFechaFacturacion(dtoE.getParametros().getFechaFacturacion());
                        i++;
                    }
                
                    if(this.indicadorSecuenciacion.equals(new Character(ConstantesFAC.COD_SECUENCIA_MONITOR.charAt(0))) ){
                          listaCabeceras = mONSecuYMarcasChequeo.generarSecuenciacionPorMonitor(listaCabeceras);
                    } else if(this.indicadorSecuenciacion.equals(new Character(ConstantesFAC.COD_SECUENCIA_TRANSPORTE.charAt(0))) ){
                          listaCabeceras = this.generarSecuenciacionPorRutas(listaCabeceras);                        
                    } else if (this.indicadorSecuenciacion.equals(new Character('I')) || this.indicadorSecuenciacion.equals(new Character('F'))) {
                          listaCabeceras = mONSecuYMarcasChequeo.generarSecuenciacionPorCliente(listaCabeceras, this.indicadorSecuenciacion);      
                    }
                    
                    
                    
                    itConsolidados = this.listaConsolidados.iterator();
                    int mide = listaCabeceras.length;
                    for( int j=0; j<mide; j++ ){
                        cabecera = listaCabeceras[j];
                        while( itConsolidados.hasNext() ){
                            consolidado = (DTOFACConsolidado)itConsolidados.next();
                            if( consolidado.getDtoCabecera().getOidCabeceraSolicitud().equals(cabecera.getOidCabeceraSolicitud()) ){
                                consolidado.setDtoCabecera(cabecera);
                            }
                        }
                    }
                }
                
                Iterator iterator = this.listaConsolidados.iterator();
                this.consolidadosAgrupados = new Hashtable();
                ArrayList arrayListTemp = null;
                while(iterator.hasNext()){
                    consolidado = (DTOFACConsolidado)iterator.next();
                    
                    cabecera = consolidado.getDtoCabecera(); 
    
                    if(!this.consolidadosAgrupados.containsKey(cabecera.getTipoSolicitud()) ){			
                        this.consolidadosAgrupados.put(cabecera.getTipoSolicitud(),new ArrayList());
                    }
                    arrayListTemp = (ArrayList)this.consolidadosAgrupados.get(cabecera.getTipoSolicitud());
                    arrayListTemp.add(consolidado);
                    this.consolidadosAgrupados.put(cabecera.getTipoSolicitud(),arrayListTemp);
                    
                }
                UtilidadesLog.debug("this.indicadorBalanceoAreaChequeo: "+this.indicadorBalanceoAreaChequeo);
                if (this.indicadorBalanceoAreaChequeo != null) {
                    this.balancearAreaChequeo();
                }
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                    UtilidadesLog.debug("Lista de Consolidados es: "+this.listaConsolidados);
                Long IDSpool = ((DTOFACConsolidado)listaConsolidados.get(0)).getIDSpool();
                Date date2 = new Date();
                UtilidadesLog.warn("TIEMPO Generacion Consolidados (P510) ---> "+(date2.getTime()-date1.getTime()));
                try{
                     //scs - 10/07/2008; RI20080645, tema: generacion de Cta.Cte con 0 decimales.
                     this.lanzarProcesosFacturacion(this.listaConsolidados,dtoE.getParametros(), this.numeroDecimalesRedondeo);
                }catch(Exception ex){
                    UtilidadesLog.error("ERROR arrancarFacturacionReal", ex);
                    UtilidadesLog.debug("*** Se cierra el Spool ***");
                    try{
                    
                        this.spoolManager.closeSpool(IDSpool);
                    
                    } catch(RemoteException re) {
                        UtilidadesLog.error(re);
                        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));	
                    }
                    codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));	 
                }
            }
        }
        UtilidadesLog.info("MONFacturacionBean.arrancarFacturacionReal(DTOArranqueGP dtoE): Salida");
    }
 
 public ArrayList crearConsolidados(ArrayList listaCabecerasSolicitud) throws MareException { 
        MareMGC mgc = new MareMGC(); 
        mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC)); 
        String subaccesoUsuario = (String) mgc.getProperty("application.subaccesoImpresion");                                
        
        ArrayList listaConsolidados = new ArrayList(); 
        HashMap hashCabeceras = new HashMap();
        ArrayList arraySubAcceso = new ArrayList();
        int longCabeceras = listaCabecerasSolicitud.size();
        for(int i=0; i<longCabeceras; i++){ 
            DTOFACCabeceraSolicitud dtoCS1 = (DTOFACCabeceraSolicitud)listaCabecerasSolicitud.get(i); 
            if(dtoCS1.getTipoSolicitudConsolidado() == null){ 
                continue;   
            }else{ 
                if(dtoCS1.getOidDireccionCliente() == null){ 
                    dtoCS1.setOidDireccionCliente(new Long(0)); 
                } 
                if(dtoCS1.getDestinatario() == null){ 
                    dtoCS1.setDestinatario(new Long(0)); 
                } 
                if(dtoCS1.getMoneda()==null){ 
                    dtoCS1.setMoneda(new Long(0)); 
                } 
                if(dtoCS1.getTipoCambio() == null){ 
                    dtoCS1.setTipoCambio(new BigDecimal("1")); 
                } 
                if(dtoCS1.getFormaPago() == null){ 
                    dtoCS1.setFormaPago(new Long(0)); 
                } 
                if(dtoCS1.getUbigeo() == null){ 
                    dtoCS1.setUbigeo(new Long(0)); 
                } 
                if(dtoCS1.getImporteDescuento3TotalLocal() == null){ 
                    dtoCS1.setImporteDescuento3TotalLocal(new Float("0")); 
                } 
                if(dtoCS1.getImporteDescuento3TotalDocumento() == null){ 
                    dtoCS1.setImporteDescuento3TotalDocumento(new Float("0")); 
                }   
                String keyConsolidado = "";
                keyConsolidado = dtoCS1.getOidPais() + "-" + dtoCS1.getCanal() + "-" + dtoCS1.getMarca() + "-" + dtoCS1.getTipoSolicitudConsolidado() +
                                 "-" + dtoCS1.getPeriodo() + "-" + dtoCS1.getOidCliente() + "-" + dtoCS1.getTipoCliente() + "-" + dtoCS1.getSubtipoCliente() +
                                 "-" + dtoCS1.getOidPagadorFactura() + "-" + dtoCS1.getReceptorFactura() + "-" + dtoCS1.getOidDireccionCliente() +
                                 "-" + dtoCS1.getZona() + "-" + dtoCS1.getTerritorioCliente() + "-" +  dtoCS1.getUbigeo() + "-" + dtoCS1.getMoneda() + 
                                 "-" + dtoCS1.getTipoCambio() + "-" + dtoCS1.getFormaPago() + "-" + dtoCS1.getSociedad()
                                 /* Agregado por Cambio SiCC20090857 ------ jrivas */
                                 + "-" + dtoCS1.getIndicadorAgrupReclamos();
                                 /* Agregado por Cambio SiCC20090857 ------ jrivas */
              
                if (hashCabeceras.containsKey(keyConsolidado)){
                    ArrayList agrupados = (ArrayList)hashCabeceras.get(keyConsolidado);
                    agrupados.add(dtoCS1);
                } else {
                    ArrayList agrup = new ArrayList();
                    agrup.add(dtoCS1);
                    hashCabeceras.put(keyConsolidado, agrup);
                    if (!arraySubAcceso.contains(dtoCS1.getSubacceso())){
                        arraySubAcceso.add(dtoCS1.getSubacceso());
                    }
                }
          } 
      }
      HashMap hashSubAcceso = this.obtenerSubAccesos(arraySubAcceso);
      
      Iterator it = (Iterator)((Collection)hashCabeceras.values()).iterator();
      
      while (it.hasNext()){
          ArrayList arrayCabeceras = (ArrayList)it.next();
          DTOFACCabeceraSolicitud dtoCabecera =null;
          DTOFACConsolidado dtoConsolidado = new DTOFACConsolidado(); 
          
          try{ 
             dtoCabecera = (DTOFACCabeceraSolicitud)((DTOFACCabeceraSolicitud)arrayCabeceras.get(0)).clone(); 
          }catch(CloneNotSupportedException cle){ 
              String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE; 
              throw new MareException(cle,UtilidadesError.armarCodigoError(codigoError)); 

          } 
            dtoCabecera.setTipoSolicitud( ((DTOFACCabeceraSolicitud)arrayCabeceras.get(0)).getTipoSolicitudConsolidado()); 
            dtoCabecera.setTipoSolicitudConsolidado(null); 
            
            float importeDescuentoLocal = 0; 
            float importeDescuentoDocumento = 0; 
            int tipoDocumento = 0; 

            int longCabecerasAgrup = arrayCabeceras.size();
            for(int k=0; k<longCabecerasAgrup; k++){ 
                    importeDescuentoLocal = importeDescuentoLocal + ((DTOFACCabeceraSolicitud)arrayCabeceras.get(k)).getImporteDescuento3TotalLocal().floatValue(); 
                    importeDescuentoDocumento = importeDescuentoDocumento + ((DTOFACCabeceraSolicitud)arrayCabeceras.get(k)).getImporteDescuento3TotalDocumento().floatValue(); 
                    if(dtoCabecera.getTipoDocumentoLegal() == null || !dtoCabecera.getTipoDocumentoLegal().equals( ((DTOFACCabeceraSolicitud)arrayCabeceras.get(k)).getTipoDocumentoLegal()) ){ 
                            tipoDocumento =1; 
                            break; 
                    } 
            } 
            dtoCabecera.setImporteDescuento3TotalLocal(new Float(importeDescuentoLocal)); 
            dtoCabecera.setImporteDescuento3TotalDocumento(new Float(importeDescuentoDocumento)); 
            if(tipoDocumento != 0){ 
                    dtoCabecera.setTipoDocumentoLegal(null); 
            } 
            dtoCabecera.setNumeroDecimalesRedondeo(this.numeroDecimalesRedondeo); 
            if (this.dtoGenerarConsolidado.getCodCaja()!=null) 
            { 
                dtoCabecera.setPuntoEmision(this.dtoGenerarConsolidado.getCodCaja()); 
            }else{
                if (hashSubAcceso.containsKey(dtoCabecera.getSubacceso())){
                    dtoCabecera.setPuntoEmision((String)hashSubAcceso.get(dtoCabecera.getSubacceso()));
                }                 
            } 
            dtoConsolidado.setDtoCabecera(dtoCabecera); 
            dtoConsolidado.setListaSolicitudes(arrayCabeceras); 
            dtoConsolidado.setListaPosiciones(null); 
            dtoConsolidado.setSubaccesoUsuario(new Long(subaccesoUsuario)); 
            /* Agregado por Brecha PED-006 ------ AL */
            dtoConsolidado.setTasaImpuestoUbigeo(dtoCabecera.getTasaImpuestoUbigeo());
            dtoConsolidado.setOidTasaImpuestoUbigeo(dtoCabecera.getOidTasaImpuestoUbigeo());
            /* Agregado por Brecha PED-006 ------ AL */
            /* Agregado por Cambio FAC-001 ------ AL */
            dtoConsolidado.setIndicadorIVAasumido(dtoCabecera.getIndicadorIVAasumido());
            dtoConsolidado.setPorcIVAasumido(dtoCabecera.getPorcIVAasumido());
            dtoConsolidado.setIndicadorDireccionSeparada(dtoCabecera.getIndicadorDireccionSeparada());
            /* Agregado por Cambio FAC-001 ------ AL */
            Long idiomaPorDefecto= RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
            UtilidadesLog.info("*** idiomaPorDefecto = "+idiomaPorDefecto); 
            dtoConsolidado.setOidIdioma(idiomaPorDefecto); 
            listaConsolidados.add(dtoConsolidado); 
        }
          
        if(listaConsolidados.size() == 0){ 
            ctx.setRollbackOnly(); 
            return null; 
        } 
        return listaConsolidados; 
 }

private HashMap obtenerSubAccesos(ArrayList arraySubAcceso) throws MareException {
  StringBuffer query = new StringBuffer();
  HashMap hashSubAcceso = new HashMap();
  if (arraySubAcceso.size() > 0) {
    query.append("SELECT SA.OID_SBAC, ");
    query.append("       SA.COD_SBAC ");
    query.append(" FROM SEG_SUBAC SA ");
    query.append(" WHERE ( ");
  
    Iterator it = arraySubAcceso.iterator();
    int count = 0;
    String oids = "";
    while (it.hasNext()){
       if (count == 0) {
          oids = ((Long)it.next()).toString();
       } else { 
          oids += "," + ((Long)it.next()).toString();
       }
       if (count == 999)  {
            query.append(" SA.OID_SBAC IN (" + oids.toString() + ") ");                     
            if (it.hasNext()){
                query.append("  OR ");
            }                    
            count = 0;
            oids = "";
        } else {
            if (!it.hasNext()){
                query.append(" SA.OID_SBAC IN (" + oids.toString() + ") ");        
            }                    
            count++;            
        }            
        if (!it.hasNext()){              
          query.append(")");
        }
    }
    
    RecordSet rs= null;
    
    rs = this.executeQuery(query.toString());
    
    if(rs != null && !rs.esVacio()){
        int longRs = rs.getRowCount();
        for (int i =0;i<longRs;i++){
          Long oidSubAcceso = this.bigDecimalToLong(rs.getValueAt(i,"OID_SBAC"));
          String codSubAcceso = (String) rs.getValueAt(i,"COD_SBAC");
          hashSubAcceso.put(oidSubAcceso,codSubAcceso);
        }
    }    
  }
  return hashSubAcceso;
}
        
	public ArrayList filtrarSolicitudesPermitenUnion(ArrayList listaSolicitudes) throws MareException {
      UtilidadesLog.info("MONFacturacionBean.filtrarSolicitudesPermitenUnion(ArrayList listaSolicitudes): Entrada");
      Iterator ite = listaSolicitudes.iterator();
      ArrayList resultado = new ArrayList();
        
      while(ite.hasNext()){
          DTOSolicitudValidacion solicitud =(DTOSolicitudValidacion)ite.next();
          if(solicitud!=null && solicitud.getIndUnionSolicitud()!=null){
              if(solicitud.getIndUnionSolicitud().booleanValue()){
                  resultado.add(solicitud);				
              }
          }
      }  
      UtilidadesLog.info("MONFacturacionBean.filtrarSolicitudesPermitenUnion(ArrayList listaSolicitudes): Salida");
      return resultado;
	}
  
  public ArrayList generarConsolidados(DTOGenerarConsolidado dtoE) throws MareException {
      UtilidadesLog.info("MONFacturacionBean.generarConsolidados(DTOGenerarConsolidado dtoE): Entrada");
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("*** DTOGenerarConsolidado = "+dtoE);
    
      ArrayList listaOIDs = new ArrayList();
      ArrayList listaSol = new ArrayList();
      Iterator itListaSolic = dtoE.getListaSolicitudes().iterator(); 
      while(itListaSolic.hasNext()){
        DTOSolicitudValidacion dtoSolicitudValidacion = (DTOSolicitudValidacion)itListaSolic.next();
        if(dtoSolicitudValidacion !=null && dtoSolicitudValidacion.getIndUnionSolicitud()!=null){
              if(dtoSolicitudValidacion.getIndUnionSolicitud().booleanValue()){
                  listaSol.add(dtoSolicitudValidacion);   
                  listaOIDs.add(dtoSolicitudValidacion.getOidSolicitud());
              }
          }        
      }
      
      dtoE.setListaSolicitudes(listaSol);
      this.dtoGenerarConsolidado = dtoE; 
    
      ArrayList listaCabecerasSolicitud = new ArrayList();

      listaCabecerasSolicitud.addAll(this.obtenerCabecerasSolicitud(listaOIDs));
      listaCabecerasSolicitud.addAll(this.obtenerSolicitudesNoPrevistasYServicios(listaCabecerasSolicitud));
    
		  this.listaConsolidados = this.crearConsolidados(listaCabecerasSolicitud);
      if(this.listaConsolidados == null){
           UtilidadesLog.error("listaConsolidados == null, se termina ejecucion");
           ctx.setRollbackOnly();
           return null;
       }
		   this.listaConsolidados = this.completarDatosConsolidados();

	
		UtilidadesLog.info("MONFacturacionBean.generarConsolidados(DTOGenerarConsolidado dtoE): Salida"); 
		return this.listaConsolidados;
	}

  private void insertarTemporalCabeceras(ArrayList listaCabecerasSolicitud) throws Exception {
    UtilidadesLog.info("MONFacturacionBean.insertarTemporalCabeceras(ArrayList listaCabecerasSolicitud): Entrada");
    BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
    long comienzo = System.currentTimeMillis();
    bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", armarInsertPED_SOLIC_CABEC_TEMP(listaCabecerasSolicitud).toString());
    UtilidadesLog.warn("INSERT TEMPORAL: "+(System.currentTimeMillis()-comienzo));
    UtilidadesLog.info("MONFacturacionBean.insertarTemporalCabeceras(ArrayList listaCabecerasSolicitud): Salida");
  }


    /* 
     * CHANGELOG
     * PER-SiCC-2009-0586 - 02-12-2009 - Dennys Oliva Iriarte 
     */     
  private RecordSet generarQueryNoPrevistasYServicios(ArrayList listaCabecerasSolicitud) throws Exception {
    UtilidadesLog.info("MONFacturacionBean.generarQueryNoPrevistasYServicios(ArrayList listaCabecerasSolicitud): Entrada");
    StringBuffer sql = new StringBuffer(); 
    Date fechaFacturacion = this.dtoGenerarConsolidado.getFechaFacturacion();
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    Date fecha = null;
    String sFecha = "";

    if (fechaFacturacion != null) {
	  fecha =  new java.sql.Date(fechaFacturacion.getTime()); 
	  sFecha = sdf.format(fecha);     
    }

    
    sql.append("SELECT SC.ACFI_OID_ACCE_FISI AS ACCESOFISICO, ");
	sql.append("   SC.ALMC_OID_ALMA AS ALMACEN,  ");
	sql.append("   SC.CLSO_OID_CLAS_SOLI AS CLASESOLICITUD, ");
	sql.append("   SC.CLAS_OID_CLAS_FLET AS CLASIFICACION, ");
	sql.append("   SC.CLIE_OID_CLIE AS OIDCLIENTE, ");
	sql.append("   SC.CLIE_OID_CONS_ASOC AS CONSULTORAASOCIADA, ");
	sql.append("   SC.TCCL_OID_TCCL_FLET AS TIPOCLASIFICACION, ");
	sql.append("   SC.ESSO_OID_ESTA_SOLI AS ESTADO, ");
	sql.append("   SC.CLIE_OID_CLIE_DEST AS DESTINATARIO, ");
	sql.append("   SC.FEC_CRON AS FECHA, ");
	sql.append("   SC.FEC_FACT AS FECHAFACTURACION, ");
	sql.append("   SC.FEC_PROG_FACT AS FECHAPREVISTAFACTURACION, ");
	sql.append("   SC.FOPA_OID_FORM_PAGO AS FORMAPAGO, ");
	sql.append("   SC.GRPR_OID_GRUP_PROC AS GRUPOPROCESOS, ");      
	sql.append("   SC.IND_APLI_MANU AS INDICADORAPLICACIONMANUAL, ");
	sql.append("   SC.IND_ESTA AS INDICADORESTADISTICABLE, ");
	sql.append("   SC.IND_EXEN_FLET AS INDICADOREXENTOFLETE, ");
	sql.append("   SC.IND_GENE_CC AS INDICADORGENERACUENTACORRIENTE, ");
	sql.append("   SC.IND_IMPR AS INDICADORIMPRESION, ");
	sql.append("   SC.TAIM_OID_TASA_IMPU AS INDICADORIMPUESTOSFLETE, ");
	sql.append("   SC.IND_OC AS INDICADORORDENCOMPRA, ");
	sql.append("   SC.IND_PEDI_PRUE AS INDICADORPEDIDOPRUEBA, ");
	sql.append("   SC.IND_PERM_UNIO_SOL AS PERMITEUNIONSOLICITUDES, ");
	sql.append("   SC.IND_TS_NO_CONSO AS INDICADORTSNOCONSOLIDADO, ");
	sql.append("   SC.INRE_OID_INDI_REVI AS INDICADORREVISION, ");
	sql.append("   P.MARC_OID_MARC AS MARCA, ");
	sql.append("   SC.MODU_OID_MODU AS MODULO, ");
	sql.append("   SC.MONE_OID_MONE AS MONEDA, ");
	sql.append("   SC.NUM_CLIEN AS NUMEROCLIENTES, "); 
	sql.append("   TO_NUMBER(DECODE (SC.SOCA_OID_SOLI_CABE,NULL, NULL,(SELECT VAL_NUME_SOLI ");
	sql.append("                                                       FROM PED_SOLIC_CABEC SCA ");
	sql.append("												       WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ");
	sql.append("		)) AS NUMEROCONSOLIDADO, ");
	sql.append("   SC.NUM_DOCU_ORIG AS NUMERODOCUMENTOORIGEN, ");
	sql.append("   SC.NUM_PREM AS NUMEROPREMIO, ");
	sql.append("   SCS.NUM_SECU_FACT_DIAR AS NUMEROSECUENCIAFACTDIARIA, ");
	sql.append("   SCS.NUM_SECU_ZONA_RUTA AS NUMEROSECUENCIAZONARUTA, ");
	sql.append("   SC.OID_SOLI_CABE AS OIDCABECERASOLICITUD, ");
	sql.append("   SC.SOCA_OID_SOLI_CABE AS OIDCONSOLIDADO, ");
	sql.append("   SC.CLDI_OID_CLIE_DIRE AS OIDDIRECCIONCLIENTE, ");
	sql.append("   SC.CLIE_OID_CLIE_PAGA AS OIDPAGADORFACTURA, ");
	sql.append("   SC.OPER_OID_OPER AS OPERACION, ");
	sql.append("   SC.PAIS_OID_PAIS AS PAIS, ");
	sql.append("   SC.PERD_OID_PERI AS PERIODO, ");
	sql.append("   SC.PROC_OID_PROC AS PROCESO, ");
	sql.append("   SC.VAL_PREC_NETO_TOTA_LOCA AS PRECIOTOTALTOTALLOCAL, ");
	sql.append("   SC.VAL_PREC_NETO_TOTA_DOCU AS PRECIOTOTALTOTALDOCUMENTO, ");
	sql.append("   SC.VAL_PUNT_EMIS AS PUNTOEMISION, ");
	sql.append("   SC.CLIE_OID_CLIE_RECE_FACT AS RECEPTORFACTURA, ");
	sql.append("   REG.ZSGV_OID_SUBG_VENT OIDSUBGVENTAS, ");
	sql.append("   Z.ZORG_OID_REGI AS REGION, ");
	sql.append("   TA.ZSCC_OID_SECC AS SECCION, ");
	sql.append("   SCS.VAL_SECU_RUTA_TERR AS SECUENCIARUTATERRITORIO, ");
	sql.append("   SC.SBAC_OID_SBAC AS SUBACCESO, ");
	sql.append("   SC.SBTI_OID_SUBT_CLIE AS SUBTIPOCLIENTE, ");
	sql.append("   SC.ZTAD_OID_TERR_ADMI AS TERRITORIOCLIENTE, ");
	sql.append("   SC.SOCA_OID_DOCU_REFE AS OIDDOCUMENTOREFERENCIA,  ");
	sql.append("   SC.SOCI_OID_SOCI AS SOCIEDAD, ");
	sql.append("   SC.TDOC_OID_TIPO_DOCU AS TIPODOCUMENTO, ");
	sql.append("   SC.TIDO_OID_TIPO_DOCU AS TIPODOCUMENTOLEGAL, ");
	sql.append("   SC.TERR_OID_TERR AS TERRITORIO, ");
	sql.append("   SC.TICL_OID_TIPO_CLIE AS TIPOCLIENTE, ");
	sql.append("   SC.TIDS_OID_TIPO_DESP AS TIPODESPACHO, ");
	sql.append("   SC.TSPA_OID_TIPO_SOLI_PAIS AS TIPOSOLICITUD, ");
	sql.append("   SC.TSPA_OID_TIPO_SOLI_PAIS_CONS AS TIPOSOLICITUDCONSOLIDADO, ");
	sql.append("   SC.VAL_BASE_FLET_DOCU AS BASEFLETEDOCUMENTO, ");
	sql.append("   SC.VAL_BASE_FLET_LOCA AS BASEFLETELOCAL, ");
	sql.append("   SC.VAL_GLOS_OBSE AS OBSERVACIONES, ");
	sql.append("   SC.VAL_IMPO_DESC_1_TOTA_DOCU AS IMPORTEDESCUENTO1TD, ");
	sql.append("   SC.VAL_IMPO_DESC_1_TOTA_LOCA AS IMPORTEDESCUENTO1TL, ");
	sql.append("   SC.VAL_IMPO_DESC_3_TOTA_DOCU AS IMPORTEDESCUENTO3TD, ");
	sql.append("   SC.VAL_IMPO_DESC_3_TOTA_LOCA AS IMPORTEDESCUENTO3TL, ");
	sql.append("   SC.VAL_IMPO_DESC_TOTA_DOCU AS IMPORTEDESCUENTOTD, ");
	sql.append("   SC.VAL_IMPO_DESC_TOTA_LOCA AS IMPORTEDESCUENTOTL, ");
	sql.append("   SC.VAL_IMPO_FLET_DOCU AS IMPORTEFLETEDOCUMENTO, ");
	sql.append("   SC.VAL_IMPO_FLET_LOCA AS IMPORTEFLETELOCAL, ");
	sql.append("   SC.VAL_IMPO_FLET_SIN_IMPU_TOTA AS IMPORTEFLETESINIMPUESTOSTL, ");
	sql.append("   SC.VAL_IMPO_FLET_SIN_IMPU_DOCU AS IMPORTEFLETESINIMPUESTOSTD, ");
	sql.append("   SC.VAL_IMPO_FLET_TOTA_DOCU AS IMPORTEFLETETD, ");
	sql.append("   SC.VAL_IMPO_FLET_TOTA_LOCA AS IMPORTEFLETETL,"); 
	sql.append("   SC.VAL_NUME_SOLI AS NUMEROSOLICITUD, ");
	sql.append("   SC.VAL_OTRO_RECA_DOCU AS OTROSRECARGOSDOCUMENTO,"); 
	sql.append("   SC.VAL_OTRO_RECA_LOCA AS OTROSRECARGOSLOCAL, ");
	sql.append("   SC.VAL_PREC_CONT_TOTA_LOCA AS PRECIOCONTABLETL, ");
	sql.append("   SC.VAL_RECA_FLET_DOCU AS RECARGOFLETEDOCUMENTO, ");
	sql.append("   SC.VAL_RECA_FLET_LOCA AS RECARGOFLETELOCAL, ");
	sql.append("   SC.VAL_TIPO_CAMB AS TIPOCAMBIO, ");
	sql.append("   SC.VAL_TOTA_FLET_DOCU AS TOTALFLETEDOCUMENTO, ");
	sql.append("   SC.VAL_TOTA_FLET_LOCA AS TOTALFLETELOCAL, ");
	sql.append("   SC.VAL_TOTA_PAGA_DOCU AS TOTALAPAGARDOCUMENTO, ");
	sql.append("   SC.VAL_TOTA_PAGA_LOCA AS TOTALAPAGARLOCAL, ");
	sql.append("   SC.VAL_USUA AS USUARIO, ");
	sql.append("   SC.ZZON_OID_ZONA AS ZONA, ");
	sql.append("   P.CANA_OID_CANA AS CANAL, ");
	sql.append("   SC.VEPO_OID_VALO_ESTR_GEOP AS UBIGEO, ");
	sql.append("   TS.ACCE_OID_ACCE AS ACCESO, ");
    /* Agregado por Cambio FAC-003 ------ AL */
    sql.append("   SC.ICTP_OID_TIPO_PROG, ");
    sql.append("   (SELECT CTP.COD_TIPO_PROG ");
    sql.append("   FROM INC_CONCU_TIPO_PROG CTP ");
    sql.append("   WHERE CTP.OID_TIPO_PROG = SC.ICTP_OID_TIPO_PROG) COD_TIPO_PROG ");
    /* Agregado por Cambio FAC-003 ------ AL */
    /* Agregado por 20070333 ------ AL */
    sql.append(", (SELECT SUM(PSP.NUM_UNID_COMPR) ");
    sql.append("  FROM PED_SOLIC_POSIC PSP");
    sql.append("  WHERE PSP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE) UNID_ATEN_TOTA ");
    //cambio 27/03/2012 sb se revirtio
    //sql.append("  WHERE PSP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND NOT EXISTS (select 1 from pre_ofert_detal x, fac_tipo_ofert_exclu y where x.tofe_oid_tipo_ofer=y.tofe_oid_tipo_ofer and x.oid_deta_ofer=psp.ofde_oid_deta_ofer)) UNID_ATEN_TOTA ");
    
    /* Agregado por 20070333 ------ AL */
    /* Agregado por Brecha PED-006 ------ AL */
    sql.append(", (SELECT VAL_TASA_IMPU ");
    sql.append(" FROM MV_ARBOL_IMPUE_UBIGE MV");
    sql.append(" WHERE MV.OID_VALO_ESTR_GEOP = SC.VEPO_OID_VALO_ESTR_GEOP) TASA_UBIGEO ");
    sql.append(", (SELECT OID_TASA_IMPU ");
    sql.append(" FROM MV_ARBOL_IMPUE_UBIGE MV");
    sql.append(" WHERE MV.OID_VALO_ESTR_GEOP = SC.VEPO_OID_VALO_ESTR_GEOP) OID_TASA_UBIGEO ");
    /* Agregado por Brecha PED-006 ------ AL */
    /* jrivas REC-001 */
    sql.append(" , OBTENER_FECHA_ENTREGA(SC.ZZON_OID_ZONA, SC.PERD_OID_PERI, SC.PAIS_OID_PAIS, '" + sFecha + "') FECHAENTREGA, ");
    sql.append(" CASE ");
    sql.append(" WHEN (SC.MODU_OID_MODU = " + ConstantesSEG.MODULO_REC + ") ");
    sql.append(" THEN (CASE ");
    sql.append(" WHEN ((SELECT COUNT (*) ");
    sql.append(" FROM PED_SOLIC_CABEC PSC ");
    sql.append(" WHERE PSC.CLIE_OID_CLIE = sc.clie_OID_CLIE ");
    sql.append(" AND PSC.FEC_FACT = TO_DATE ('" + sFecha + "', 'YYYY-MM-DD') ");
    sql.append(" AND PSC.IND_OC = 1) > 1 ");
    sql.append(" ) ");
    sql.append(" THEN 0 ");
    sql.append(" ELSE 1 ");
    sql.append(" END ");
    sql.append(" ) ");
    sql.append(" ELSE 1 ");
    sql.append(" END INDICADORPEDIDOSEVICIO ");
    /* jrivas REC-001 */    
    /* Agregado por Cambio FAC-001 ------ AL */
    sql.append(", (SELECT IND_IVA_ASUM_EMPR FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) IND_IVA_ASUM_EMPR ");
    sql.append(", (SELECT VAL_PORC_IVA_ASUM_EMPR FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) VAL_PORC_IVA_ASUM_EMPR ");
    sql.append(", (SELECT IND_DIRE_SEPA FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) IND_DIRE_SEPA ");
    /* Agregado por Cambio FAC-001 ------ AL */
    /* Agregado por Cambio SiCC20090857 ------ jrivas */
    sql.append(", CASE WHEN (SC.MODU_OID_MODU = " + ConstantesSEG.MODULO_REC + " AND TS.IND_SOLI_NEGA = 1) THEN ");
    sql.append("    SC.OID_SOLI_CABE ");
    sql.append(" ELSE 0 END CRIT_AGRUP_RECLAMOS");
    /* Agregado por Cambio SiCC20090857 ------ jrivas */
    sql.append(" FROM PED_SOLIC_CABEC SC, ");
	sql.append("      PED_TIPO_SOLIC_PAIS TSP, ");
	sql.append("      PED_TIPO_SOLIC TS, ");
	sql.append("      CRA_PERIO P, ");
	sql.append("      ZON_REGIO REG, ");
	sql.append("      PED_SOLIC_CABEC_SECUE SCS, ");
	sql.append("      ZON_ZONA Z, ");
	sql.append("      ZON_TERRI_ADMIN TA ");
    sql.append(" WHERE P.OID_PERI = SC.PERD_OID_PERI ");
    sql.append("   AND SCS.SOCA_OID_SOLI_CABE(+) = SC.OID_SOLI_CABE ");
    sql.append("   AND Z.OID_ZONA = SC.ZZON_OID_ZONA ");
    sql.append("   AND Z.ZORG_OID_REGI = REG.OID_REGI ");
    sql.append("   AND TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI ");
    sql.append("   AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
    sql.append("   AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
    sql.append("   AND SC.OID_SOLI_CABE IN (");
    sql.append("      ( ");
    sql.append("      SELECT SC.OID_SOLI_CABE");
    sql.append("      FROM PED_SOLIC_CABEC SC,");
	sql.append("           PED_TIPO_SOLIC_PAIS TSP, ");
	sql.append("           PED_TIPO_SOLIC TS, ");
	sql.append("          ( ");
	sql.append("          SELECT * ");
	sql.append("          FROM PED_SOLIC_CABEC_TEMP ");
	sql.append("          WHERE IND_CLAS_OC = 1 ");
	sql.append("          ) TEMP_SOLI_OC");
    sql.append("      WHERE SC.FEC_FACT IS NULL ");
	sql.append("        AND SC.IND_OC = 0  ");
	sql.append("        AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
	sql.append("        AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
	sql.append("        AND SC.GRPR_OID_GRUP_PROC = " + ConstantesPED.GP4);
	sql.append("        AND SC.PERD_OID_PERI = TEMP_SOLI_OC.PERD_OID_PERI ");
	sql.append("        AND SC.CLIE_OID_CLIE = TEMP_SOLI_OC.CLIE_OID_CLIE ");
	sql.append("        AND TS.ACCE_OID_ACCE = TEMP_SOLI_OC.ACCE_OID_ACCE ");
	if (fechaFacturacion != null) { 
	  sql.append(" AND (SC.FEC_PROG_FACT  >=  TO_DATE( '"+sFecha+"' ,'YYYY-MM-DD') ");
	  sql.append(" OR SC.FEC_PROG_FACT IS NULL)   ");
     }
    sql.append("	      AND SC.OID_SOLI_CABE NOT IN (SELECT OID_SOLI_CABE FROM PED_SOLIC_CABEC_TEMP)  ");
    sql.append("    ) ");
    sql.append("    UNION ALL ");
    sql.append("    (  ");
    sql.append("      SELECT SC.OID_SOLI_CABE ");
    sql.append("      FROM PED_SOLIC_CABEC SC, ");
	sql.append("           PED_TIPO_SOLIC_PAIS TSP, ");
	sql.append("           PED_TIPO_SOLIC TS, ");
	sql.append("        ( ");
	sql.append("        SELECT DISTINCT PERD_OID_PERI ");
	sql.append("        FROM PED_SOLIC_CABEC_TEMP ");
	sql.append("        ) TEMP_SOLI_OC ");
    sql.append("     WHERE SC.FEC_FACT IS NULL "); 
	sql.append("       AND SC.IND_OC = 0  ");
	sql.append("       AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
	sql.append("       AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
	sql.append("       AND SC.GRPR_OID_GRUP_PROC = " + ConstantesPED.GP4);
    sql.append("       AND SC.PERD_OID_PERI = TEMP_SOLI_OC.PERD_OID_PERI ");
	sql.append("       AND SC.CLIE_OID_CLIE NOT IN (SELECT CLIE_OID_CLIE FROM PED_SOLIC_CABEC_TEMP WHERE IND_CLAS_OC = 1) ");
    //    Agregado por HRCS - Fecha 04/07/2007 - Incidencia Sicc20070343
    sql.append("       AND exists (SELECT CLIE_OID_CLIE FROM PED_SOLIC_CABEC_TEMP WHERE IND_CLAS_OC = 1) ");
	sql.append("       AND SC.OID_SOLI_CABE NOT IN (SELECT OID_SOLI_CABE FROM PED_SOLIC_CABEC_TEMP) ");
    sql.append("       AND TSP.OID_TIPO_SOLI_PAIS IN (SELECT TSPA_OID_TIPO_SOLI_PAIS FROM PED_TIPO_SOLIC_SERVI) ");
	sql.append("       AND SC.ZZON_OID_ZONA IN ( ");
	sql.append("          SELECT ZZON_OID_ZONA ");
	sql.append("          FROM FAC_CONTR_CIERR FCC ");
	sql.append("          WHERE FCC.TCIE_OID_TIPO_CIER = 2 ");
        //Modificado: PER-SiCC-2009-0586 - 02-12-2009 - Dennys Oliva Iriarte
        sql.append("            AND FCC.FEC_CIER <= TRUNC(SYSDATE) ");
        //----------------------------------------------------------
	sql.append("            AND FCC.PERD_OID_PERI IN ( ");
	sql.append("                SELECT DISTINCT PERD_OID_PERI ");
    sql.append("                FROM PED_SOLIC_CABEC_TEMP ");
    sql.append("            ) ");
	sql.append("    ) ");
    if (fechaFacturacion != null) { 
      sql.append(" AND (SC.FEC_PROG_FACT  >=  TO_DATE( '"+sFecha+"' ,'YYYY-MM-DD')    ");
      sql.append(" OR SC.FEC_PROG_FACT IS NULL)   ");
    }								
    sql.append(") ");
    sql.append(") ");    
    
    RecordSet rs = null;
    long comienzo = System.currentTimeMillis();
    rs = this.executeQuery(sql.toString()); 
    UtilidadesLog.warn("QUERY NO PREVISTAS: "+(System.currentTimeMillis()-comienzo));
    UtilidadesLog.info("MONFacturacionBean.generarQueryNoPrevistasYServicios(ArrayList listaCabecerasSolicitud): Salida");
    return rs;
  }
  
   private void deleteTemporalCabeceras() throws Exception {
    UtilidadesLog.info("MONFacturacionBean.deleteTemporalCabeceras(): Entrada");
    BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
    long comienzo = System.currentTimeMillis();
    bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", DELETE_PED_SOLIC_CABEC_TEMP);
    UtilidadesLog.warn("DELETE TEMPORAL: "+(System.currentTimeMillis()-comienzo));
    UtilidadesLog.info("MONFacturacionBean.deleteTemporalCabeceras(): Salida");
  }
 
  private ArrayList armarDTONoPrevistasYServicios(RecordSet rs) {
    UtilidadesLog.info("MONFacturacion.armarDTONoPrevistasYServicios (RecordSet rs): Entrada");
    ArrayList listaDtos=new ArrayList(); 
                        
    if(!rs.esVacio()){ 
      int numReg = rs.getRowCount();
      for(int i = 0; i < numReg; i++){ 
        DTOFACCabeceraSolicitud dtoCabSolic= new DTOFACCabeceraSolicitud(); 
        
        dtoCabSolic.setUbigeo(this.bigDecimalToLong(rs.getValueAt(i,"UBIGEO"))); 
        dtoCabSolic.setCanal(this.bigDecimalToLong(rs.getValueAt(i,"CANAL")));
        dtoCabSolic.setAcceso(this.bigDecimalToLong(rs.getValueAt(i,"ACCESO")));
        dtoCabSolic.setAccesoFisico(this.bigDecimalToLong(rs.getValueAt(i,"ACCESOFISICO"))); 
        dtoCabSolic.setAlmacen(this.bigDecimalToLong(rs.getValueAt(i,"ALMACEN"))); 
        dtoCabSolic.setClaseSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"CLASESOLICITUD"))); 
        dtoCabSolic.setClasificacion(this.bigDecimalToLong(rs.getValueAt(i,"CLASIFICACION"))); 
        dtoCabSolic.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDCLIENTE"))); 
        dtoCabSolic.setConsultoraAsociada(this.bigDecimalToLong(rs.getValueAt(i,"CONSULTORAASOCIADA"))); 
        dtoCabSolic.setTipoClasificacion(this.bigDecimalToLong(rs.getValueAt(i,"TIPOCLASIFICACION"))); 
        dtoCabSolic.setEstado(this.bigDecimalToLong(rs.getValueAt(i,"ESTADO"))); 
        dtoCabSolic.setDestinatario(this.bigDecimalToLong(rs.getValueAt(i,"DESTINATARIO"))); 
        dtoCabSolic.setFecha(this.objectToDate(rs.getValueAt(i,"FECHA"))); 
        dtoCabSolic.setFecha(this.objectToDate(rs.getValueAt(i,"FECHAFACTURACION"))); 
        dtoCabSolic.setFechaPrevistaFacturacion(this.objectToDate(rs.getValueAt(i,"FECHAPREVISTAFACTURACION"))); 
        dtoCabSolic.setFormaPago(this.bigDecimalToLong(rs.getValueAt(i,"FORMAPAGO"))); 
        dtoCabSolic.setGrupoProcesos(this.bigDecimalToLong(rs.getValueAt(i,"GRUPOPROCESOS"))); 
        dtoCabSolic.setIndicadorAplicacionManual(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORAPLICACIONMANUAL"))); 
        dtoCabSolic.setIndicadorEstadisticable(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORESTADISTICABLE"))); 
        dtoCabSolic.setIndicadorExentoFlete(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADOREXENTOFLETE"))); 
        dtoCabSolic.setIndicadorGeneraCuentaCorriente(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORGENERACUENTACORRIENTE"))); 
        dtoCabSolic.setIndicadorImpresion(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORIMPRESION"))); 
        dtoCabSolic.setIndicadorImpuestosFlete(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORIMPUESTOSFLETE"))); 
        dtoCabSolic.setIndicadorOrdenCompra(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORORDENCOMPRA"))); 
        dtoCabSolic.setIndicadorPedidoPrueba(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORPEDIDOPRUEBA"))); 
        dtoCabSolic.setPermiteUnionSolicitudes(this.bigDecimalToBoolean(rs.getValueAt(i,"PERMITEUNIONSOLICITUDES"))); 
        dtoCabSolic.setIndTSNoConsolidado(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORTSNOCONSOLIDADO"))); 
        dtoCabSolic.setIndicadorRevision(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORREVISION"))); 
        dtoCabSolic.setMarca(this.bigDecimalToLong(rs.getValueAt(i,"MARCA"))); 
        dtoCabSolic.setModulo(this.bigDecimalToLong(rs.getValueAt(i,"MODULO"))); 
        dtoCabSolic.setMoneda(this.bigDecimalToLong(rs.getValueAt(i,"MONEDA"))); 
        dtoCabSolic.setNumeroClientes(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROCLIENTES"))); 
        dtoCabSolic.setNumeroConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"NUMEROCONSOLIDADO"))); 
        dtoCabSolic.setNumeroDocumentoOrigen(this.bigDecimalToLong(rs.getValueAt(i,"NUMERODOCUMENTOORIGEN"))); 
        dtoCabSolic.setNumeroPremio(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROPREMIO"))); 
        dtoCabSolic.setNumeroSecuenciaFacturacionDiaria(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA"))); 
        dtoCabSolic.setNumeroSecuenciaZonaRuta(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA"))); 
        dtoCabSolic.setOidCabeceraSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"OIDCABECERASOLICITUD"))); 
        dtoCabSolic.setOidConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"OIDCONSOLIDADO"))); 
        dtoCabSolic.setOidDireccionCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDDIRECCIONCLIENTE"))); 
        dtoCabSolic.setOidPagadorFactura(this.bigDecimalToLong(rs.getValueAt(i,"OIDPAGADORFACTURA"))); 
        dtoCabSolic.setOperacion(this.bigDecimalToLong(rs.getValueAt(i,"OPERACION"))); 
        dtoCabSolic.setOidPais(this.bigDecimalToLong(rs.getValueAt(i,"PAIS"))); 
        dtoCabSolic.setPeriodo(this.bigDecimalToLong(rs.getValueAt(i,"PERIODO"))); 
        dtoCabSolic.setProceso(this.bigDecimalToLong(rs.getValueAt(i,"PROCESO"))); 
        dtoCabSolic.setPrecioTotalTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL"))); 
        dtoCabSolic.setPrecioTotalTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO"))); 
        dtoCabSolic.setPuntoEmision(this.objectToString(rs.getValueAt(i,"PUNTOEMISION")));
        dtoCabSolic.setReceptorFactura(this.bigDecimalToLong(rs.getValueAt(i,"RECEPTORFACTURA"))); 
        dtoCabSolic.setOidSubgVentas(this.bigDecimalToLong(rs.getValueAt(i,"OIDSUBGVENTAS"))); 
        dtoCabSolic.setRegion(this.bigDecimalToLong(rs.getValueAt(i,"REGION"))); 
        dtoCabSolic.setSeccion(this.bigDecimalToLong(rs.getValueAt(i,"SECCION"))); 
        dtoCabSolic.setSecuenciaRutaTerritorio(this.objectToString(rs.getValueAt(i,"SECUENCIARUTATERRITORIO"))); 
        dtoCabSolic.setSubacceso(this.bigDecimalToLong(rs.getValueAt(i,"SUBACCESO"))); 
        dtoCabSolic.setSubtipoCliente(this.bigDecimalToLong(rs.getValueAt(i,"SUBTIPOCLIENTE"))); 
        dtoCabSolic.setTerritorioCliente(this.bigDecimalToLong(rs.getValueAt(i,"TERRITORIOCLIENTE"))); 
        dtoCabSolic.setOidDocumentoReferencia(this.bigDecimalToLong(rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA"))); 
        dtoCabSolic.setSociedad(this.bigDecimalToLong(rs.getValueAt(i,"SOCIEDAD"))); 
        dtoCabSolic.setTipoDocumento(this.bigDecimalToLong(rs.getValueAt(i,"TIPODOCUMENTO"))); 
        dtoCabSolic.setTipoDocumentoLegal(this.bigDecimalToLong(rs.getValueAt(i,"TIPODOCUMENTOLEGAL"))); 
        dtoCabSolic.setTerritorio(this.bigDecimalToLong(rs.getValueAt(i,"TERRITORIO"))); 
        dtoCabSolic.setTipoCliente(this.bigDecimalToLong(rs.getValueAt(i,"TIPOCLIENTE"))); 
        dtoCabSolic.setTipoDespacho(this.bigDecimalToLong(rs.getValueAt(i,"TIPODESPACHO"))); 
        dtoCabSolic.setTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"TIPOSOLICITUD"))); 
        dtoCabSolic.setTipoSolicitudConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO"))); 
        dtoCabSolic.setBaseFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"BASEFLETEDOCUMENTO"))); 
        dtoCabSolic.setBaseFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"BASEFLETELOCAL"))); 
        dtoCabSolic.setObservaciones(this.objectToString(rs.getValueAt(i,"OBSERVACIONES"))); 
        dtoCabSolic.setImporteDescuento1TotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO1TD"))); 
        dtoCabSolic.setImporteDescuento1TotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO1TL"))); 
        dtoCabSolic.setImporteDescuento3TotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO3TD"))); 
        dtoCabSolic.setImporteDescuento3TotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO3TL"))); 
        dtoCabSolic.setImporteDescuentoTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTD"))); 
        dtoCabSolic.setImporteDescuentoTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTL"))); 
        dtoCabSolic.setImporteFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO"))); 
        dtoCabSolic.setImporteFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETELOCAL"))); 
        dtoCabSolic.setImporteFleteSinImpuestosTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTL"))); 
        dtoCabSolic.setImporteFleteTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD"))); 
        dtoCabSolic.setImporteFleteTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETETD"))); 
        dtoCabSolic.setImporteFleteTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETETL"))); 
        dtoCabSolic.setNumeroSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"NUMEROSOLICITUD"))); 
        dtoCabSolic.setOtrosRecargosDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO"))); 
        dtoCabSolic.setOtrosRecargosLocal(this.bigDecimalToFloat(rs.getValueAt(i,"OTROSRECARGOSLOCAL"))); 
        dtoCabSolic.setPrecioContableTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLETL"))); 
        dtoCabSolic.setRecargoFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"RECARGOFLETEDOCUMENTO"))); 
        dtoCabSolic.setRecargoFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"RECARGOFLETELOCAL"))); 
        if(rs.getValueAt(i,"TIPOCAMBIO")!=null){ 
          dtoCabSolic.setTipoCambio((BigDecimal)rs.getValueAt(i,"TIPOCAMBIO")); 
        } 
        dtoCabSolic.setTotalFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALFLETEDOCUMENTO"))); 
        dtoCabSolic.setTotalFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALFLETELOCAL"))); 
        dtoCabSolic.setTotalAPagarDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALAPAGARDOCUMENTO"))); 
        dtoCabSolic.setTotalAPagarLocal(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALAPAGARLOCAL"))); 
        dtoCabSolic.setUsuario(this.objectToString(rs.getValueAt(i,"USUARIO"))); 
        dtoCabSolic.setZona(this.bigDecimalToLong(rs.getValueAt(i,"ZONA"))); 
        /* Agregado por Cambio FAC-003 ------ AL */
        dtoCabSolic.setOidTipoConcursoPrograma(this.bigDecimalToLong(rs.getValueAt(i, "ICTP_OID_TIPO_PROG")));
        dtoCabSolic.setCodigoTipoProgramaConcu(this.bigDecimalToString(rs.getValueAt(i, "COD_TIPO_PROG")));        
        if (dtoCabSolic.getOidTipoConcursoPrograma() != null) {
          dtoCabSolic.setImporteDescuento3TotalDocumento(new Float(0));
  		  dtoCabSolic.setImporteDescuento3TotalLocal(new Float(0));  
        }
        /* Agregado por Cambio FAC-003 ------ AL */
        /* Agregado por 20070333 ------ AL */
        dtoCabSolic.setNumeroUnidadesAtendidasTotal(this.bigDecimalToLong(rs.getValueAt(i, "UNID_ATEN_TOTA")));
        /* Agregado por 20070333 ------ AL */
        /* Agregado por Brecha PED-006 ------ AL */
        dtoCabSolic.setTasaImpuestoUbigeo(this.bigDecimalToFloat(rs.getValueAt(i, "TASA_UBIGEO")));  
        dtoCabSolic.setOidTasaImpuestoUbigeo(this.bigDecimalToLong(rs.getValueAt(i, "OID_TASA_UBIGEO")));
        /* Agregado por Brecha PED-006 ------ AL */
        /* jrivas REC-001 */    
        dtoCabSolic.setFechaEntrega(this.objectToDate(rs.getValueAt(i,"FECHAENTREGA")));
        dtoCabSolic.setIndPedidoServicio(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORPEDIDOSEVICIO"))); 
        /* jrivas REC-001 */    
        /* Agregado por Cambio FAC-001 ------ AL */
        dtoCabSolic.setIndicadorIVAasumido(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_IVA_ASUM_EMPR")));
        dtoCabSolic.setPorcIVAasumido(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_PORC_IVA_ASUM_EMPR")));
        dtoCabSolic.setIndicadorDireccionSeparada(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_DIRE_SEPA")));
        /* Agregado por Cambio FAC-001 ------ AL */
        /* Agregado por Cambio SiCC20090857 ------ jrivas */
        dtoCabSolic.setIndicadorAgrupReclamos(UtilidadesBD.convertirALong(rs.getValueAt(i, "CRIT_AGRUP_RECLAMOS")));                
        /* Agregado por Cambio SiCC20090857 ------ jrivas */        
        listaDtos.add(dtoCabSolic);         
      }      //for 
    }//if rs.vacio 
    UtilidadesLog.info("MONFacturacion.armarDTONoPrevistasYServicios (RecordSet rs): Salida");
    return listaDtos; 
  }

	public ArrayList obtenerSolicitudesNoPrevistasYServicios(ArrayList listaCabecerasSolicitud) throws MareException {
		UtilidadesLog.info("MONFacturacionBean.obtenerSolicitudesNoPrevistasYServicios(ArrayList listaCabecerasSolicitud): Entrada");

		ArrayList listaAux = new ArrayList();		
		if (listaCabecerasSolicitud != null && listaCabecerasSolicitud.size()!=0){
        try {
          this.insertarTemporalCabeceras(listaCabecerasSolicitud);
          RecordSet rs = null; 
          rs = this.generarQueryNoPrevistasYServicios(listaCabecerasSolicitud);
          this.deleteTemporalCabeceras();
          listaAux = this.armarDTONoPrevistasYServicios(rs);
        } catch (Exception e){
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerSolicitudesNoPrevistasYServicios: Exception",e); 
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
        }
  	}
    UtilidadesLog.debug(" Se obtiene "+listaAux.size()+" solicitudes no previstas ");

		UtilidadesLog.info("MONFacturacionBean.obtenerSolicitudesNoPrevistasYServicios(ArrayList listaCabecerasSolicitud): Salida");    
		return listaAux;		
	}


	public ArrayList completarDatosConsolidados() throws MareException {
        UtilidadesLog.info("MONFacturacionBean.completarDatosConsolidados(): Entrada");
        
        DTOFACListaConsolidados dtoFACLC = new DTOFACListaConsolidados();
        dtoFACLC.setDtoGenerarConsolidado(this.dtoGenerarConsolidado);
        dtoFACLC.setListaConsolidados(this.listaConsolidados);
        ArrayList lista = null;
        lista = this.procesarMINI(dtoFACLC);
        UtilidadesLog.info("MONFacturacionBean.completarDatosConsolidados(): Salida");
        return lista;
	}


    public MareDTO ejecucionOnline(ArrayList listaSegmentos) throws MareException {
		UtilidadesLog.info("MONFacturacionBean.ejecucionOnline(ArrayList listaSegmentos): Entrada");
		UtilidadesLog.debug(" Tamanio listaSegmentos = "+listaSegmentos.size());
		MONProcesosFacturacionLocal monProcesosFacturacion = this.getMONProcesosFacturacionLocal();
		
		DTOFACListaConsolidados dtoLC = new DTOFACListaConsolidados();
		MareDTO dto=null;
		Long IDSpool = ((DTOFACConsolidado)listaConsolidados.get(0)).getIDSpool();
		try{
            dtoLC.setListaConsolidados(listaSegmentos);	
            dto = monProcesosFacturacion.ejecutarProcesosFacturacion(dtoLC,Boolean.TRUE); //modificado 			
        }catch(Exception e){
            try{
                if (this.validarTipoSpool(((DTOFACConsolidado)listaConsolidados.get(0)).getOidPais())) {
                    this.spoolManager.closeSpoolColombia(IDSpool);
                } else {
                    this.spoolManager.closeSpool(IDSpool);
                }

            }catch (Exception ex){
                UtilidadesLog.error("NO SE CERRO EL SPOOL", e);
            }
            if (e instanceof MareException)
                throw (MareException)e;
            UtilidadesLog.error("Error en la ejecucion de Facturacion Online ",e);
            throw new MareException(e);
        }
		UtilidadesLog.info("MONFacturacionBean.ejecucionOnline(ArrayList listaSegmentos): Salida");
		return dto;
	}
    
    private MONProcesosFacturacionLocal getMONProcesosFacturacionLocal() throws MareException {
        UtilidadesLog.info("MONFacturacionBean.getMONProcesosFacturacionLocal(): Entrada");
        MONProcesosFacturacionLocalHome localHome = (MONProcesosFacturacionLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONProcesosFacturacion");
        MONProcesosFacturacionLocal ejb = null;
        try {
			ejb = localHome.create();
		} catch (Exception e) {
        UtilidadesLog.error(e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONFacturacionBean.getMONProcesosFacturacionLocal(): Salida");
        return ejb;
    }

    public void ejecucionBatch(ArrayList listaSegmentos, String IDProceso) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Entrada");
        UtilidadesLog.debug(" tamanio de segmento = " + listaSegmentos.size());
        DTOFACListaConsolidados dtoSegmento = new DTOFACListaConsolidados();
        dtoSegmento.setListaConsolidados(listaSegmentos);
        IMareDTO DTOSegmento = dtoSegmento;
        MareBusinessID idMare = new MareBusinessID("FACResegmentarProcesosFacturacion");
        DTOSubBatch dtoSubBatch = new DTOSubBatch("SEGMENTO_FAC_", IDProceso, ctx.getCallerPrincipal().getName(), idMare, DTOSegmento);
        try{
            BatchUtil.executeMLN(dtoSubBatch, new MareBusinessID("FACProcesosGP5"));
        }catch(RemoteException re){
            UtilidadesLog.error(re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
        }
        UtilidadesLog.info("MONFacturacionBean.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Salida");
    }

	private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        UtilidadesLog.info("MONFacturacionBean.getSpoolManager(): Entrada");
		final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONFacturacionBean.getSpoolManager(): Salida");
		return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
	}

    private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException
    {
        UtilidadesLog.info("MONFacturacionBean.getMONBatchEJBLocalHome(): Entrada");
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONFacturacionBean.getMONBatchEJBLocalHome(): Salida");
        return (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");
    }

    private MONSecuYMarcasChequeoLocal getMONSecuYMarcasChequeoLocal() throws MareException {
		UtilidadesLog.info("MONFacturacionBean.getMONSecuYMarcasChequeoLocal(): Entrada");
        MONSecuYMarcasChequeoLocalHome localHome = (MONSecuYMarcasChequeoLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONSecuYMarcasChequeo");
        MONSecuYMarcasChequeoLocal ejb = null;
        try {
			ejb = localHome.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONFacturacionBean.getMONSecuYMarcasChequeoLocal(): Salida");
        return ejb;
	}


    private void obtenerDatosPais(Long oidPais, Long oidMoneda) throws MareException{
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT PAIS.IND_SECU, ");
	    query.append("        PAIS.IND_BALA_AREA_CHEQ, ");
	    query.append("        PAIS.IND_IMPU_INCL, ");
      if (oidMoneda != null){
        query.append("        MON.NUM_DECI NUM_DECI, ");
      }
	    query.append("        MON_PAI.NUM_DECI NUM_DECI_PAIS	   ");
      query.append(" FROM SEG_PAIS PAIS, ");
      if (oidMoneda != null){
        query.append("      SEG_MONED MON, ");
      }
      query.append("      SEG_MONED MON_PAI ");	 
      query.append(" WHERE PAIS.OID_PAIS = " + oidPais);
      query.append("   AND PAIS.MONE_OID_MONE = MON_PAI.OID_MONE ");
      if (oidMoneda != null){
        query.append("   AND MON.OID_MONE = " + oidMoneda);
      }
      
      RecordSet rs = null;     
      rs = this.executeQuery(query.toString());
      
      if (!(rs == null) && !(rs.esVacio())){
          this.indicadorSecuenciacion = this.objectToCharacter(rs.getValueAt(0,"IND_SECU"));
          this.indicadorBalanceoAreaChequeo = this.objectToCharacter(rs.getValueAt(0,"IND_BALA_AREA_CHEQ"));
          this.indicadorImpuestosIncluidos = this.bigDecimalToBoolean(rs.getValueAt(0,"IND_IMPU_INCL"));
          
      		if(this.numeroDecimalesRedondeo == null){
            UtilidadesLog.debug("obtenerDatosPais, oidMoneda: " + oidMoneda);
          	if( oidMoneda != null){
        			this.numeroDecimalesRedondeo = new Integer(this.bigDecimalToLong(rs.getValueAt(0,"NUM_DECI")).intValue());
          	} else{
              this.numeroDecimalesRedondeo = new Integer(this.bigDecimalToLong(rs.getValueAt(0,"NUM_DECI_PAIS")).intValue());
            }
            UtilidadesLog.debug("obtenerDatosPais, numeroDecimalesRedondeo: " + this.numeroDecimalesRedondeo);
          }
      }      
    }   
    
    
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Salida");  
    return rs;
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
            return new Float(((BigDecimal) numero).floatValue());
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
   
    private Character objectToCharacter(Object ob) {
        if (ob != null) {
            return new Character(((String) ob).charAt(0));
        } else {
            return null;
        }
    }

    private Date objectToDate(Object ob) {
        if (ob != null) {
            return (Date) ob;
        } else {
            return null;
        }
    }
    
    private String objectToString(Object ob) {
        if (ob != null) {
            return (String) ob.toString();
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
     private String bigDecimalToString(Object ob) {
        if (ob != null) {
            return ob.toString();
        } else {
            return null;
        }
    }
    
    
 	/**
         * CHANGELOG
         * ---------
         * 21/08/2009 - dmorello, Cambio 20080765 - El metodo pasa a ser publico
         * 17/09/2009 - dmorello, Cambio 20080765 - Se considera el caso de que this.dtoGenerarConsolidado
         *                                          sea null (invocacion desde REC) y se usa la fecha del sistema
         *                                          como fecha de facturacion en la query.
         */
        public ArrayList obtenerCabecerasSolicitud (ArrayList listaOIDs) throws MareException {

		UtilidadesLog.info("MONFacturacion.obtenerCabecerasSolicitud (ArrayList listaOIDs): Entrada");
		Vector parametros = new Vector();
		StringBuffer sql=new StringBuffer();
        ArrayList listaSol = new ArrayList();
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fecha;
        
        if (this.dtoGenerarConsolidado != null && this.dtoGenerarConsolidado.getFechaFacturacion() != null) {
            fecha =  new java.sql.Date(this.dtoGenerarConsolidado.getFechaFacturacion().getTime());
        } else {
            fecha = new java.sql.Date(System.currentTimeMillis());
        }
        
        String sFecha = sdf.format(fecha);

	    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
	     try {
	         this.insertarTemporalOids(listaOIDs);
	     } catch (Exception e) {
	       String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
	       throw new MareException(e, UtilidadesError.armarCodigoError(error));
	     }            
	    long comienzo = System.currentTimeMillis();
            
		sql.append(" SELECT ");
		sql.append(" SC.ACFI_OID_ACCE_FISI as ACCESOFISICO, ");
		sql.append(" SC.ALMC_OID_ALMA as ALMACEN, ");
		sql.append(" SC.CLSO_OID_CLAS_SOLI as CLASESOLICITUD, ");
		sql.append(" SC.CLAS_OID_CLAS_FLET as CLASIFICACION, ");
		sql.append(" SC.CLIE_OID_CLIE as OIDCLIENTE, ");
		sql.append(" SC.CLIE_OID_CONS_ASOC as CONSULTORAASOCIADA, ");
		sql.append(" SC.TCCL_OID_TCCL_FLET as TIPOCLASIFICACION, ");
		sql.append(" SC.ESSO_OID_ESTA_SOLI as ESTADO, ");
		sql.append(" SC.CLIE_OID_CLIE_DEST as DESTINATARIO, ");
		sql.append(" SC.FEC_CRON as FECHA, ");
		sql.append(" SC.FEC_FACT as FECHAFACTURACION, ");
		sql.append(" SC.FEC_PROG_FACT as FECHAPREVISTAFACTURACION, ");
		sql.append(" SC.FOPA_OID_FORM_PAGO as FORMAPAGO, ");
		sql.append(" SC.GRPR_OID_GRUP_PROC as GRUPOPROCESOS, ");
		sql.append(" SC.IND_APLI_MANU as INDICADORAPLICACIONMANUAL, ");
		sql.append(" SC.IND_ESTA as INDICADORESTADISTICABLE, ");
		sql.append(" SC.IND_EXEN_FLET as INDICADOREXENTOFLETE, ");
		sql.append(" SC.IND_GENE_CC as INDICADORGENERACUENTACORRIENTE, ");
		sql.append(" SC.IND_IMPR as INDICADORIMPRESION, ");
		sql.append(" SC.TAIM_OID_TASA_IMPU as INDICADORIMPUESTOSFLETE, ");
		sql.append(" SC.IND_OC as INDICADORORDENCOMPRA, ");
		sql.append(" SC.IND_PEDI_PRUE as INDICADORPEDIDOPRUEBA, ");
		sql.append(" SC.IND_PERM_UNIO_SOL as PERMITEUNIONSOLICITUDES, ");
		sql.append(" SC.IND_TS_NO_CONSO as INDICADORTSNOCONSOLIDADO, ");
		sql.append(" SC.INRE_OID_INDI_REVI as INDICADORREVISION, ");  
		sql.append(" P.MARC_OID_MARC as MARCA, ");
		sql.append(" SC.MODU_OID_MODU as MODULO, ");
		sql.append(" SC.MONE_OID_MONE as MONEDA, ");
		sql.append(" SC.NUM_CLIEN as NUMEROCLIENTES, ");
		sql.append(" TO_NUMBER(DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE))) as NUMEROCONSOLIDADO, ");
		sql.append(" SC.NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, ");
		sql.append(" SC.NUM_PREM as NUMEROPREMIO, ");
		sql.append(" SCS.NUM_SECU_FACT_DIAR as NUMEROSECUENCIAFACTDIARIA, ");
		sql.append(" SCS.NUM_SECU_ZONA_RUTA as NUMEROSECUENCIAZONARUTA, ");
		sql.append(" SC.OID_SOLI_CABE as OIDCABECERASOLICITUD, ");
		sql.append(" SC.SOCA_OID_SOLI_CABE as OIDCONSOLIDADO, ");
		sql.append(" SC.CLDI_OID_CLIE_DIRE as OIDDIRECCIONCLIENTE, ");
		sql.append(" SC.CLIE_OID_CLIE_PAGA as OIDPAGADORFACTURA, ");
		sql.append(" SC.OPER_OID_OPER as OPERACION, ");
		sql.append(" SC.PAIS_OID_PAIS as PAIS, ");
		sql.append(" SC.PERD_OID_PERI as PERIODO, ");
		sql.append(" SC.PROC_OID_PROC as PROCESO, ");
		sql.append(" SC.VAL_PREC_NETO_TOTA_LOCA as PRECIOTOTALTOTALLOCAL, ");
		sql.append(" SC.VAL_PREC_NETO_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO, ");
		sql.append(" SC.VAL_PUNT_EMIS as PUNTOEMISION, ");
		sql.append(" SC.CLIE_OID_CLIE_RECE_FACT as RECEPTORFACTURA, ");
                sql.append(" REG.ZSGV_OID_SUBG_VENT OIDSUBGVENTAS, ");
		sql.append(" Z.ZORG_OID_REGI as REGION, ");
		sql.append(" TA.ZSCC_OID_SECC as SECCION, ");
		sql.append(" SCS.VAL_SECU_RUTA_TERR as SECUENCIARUTATERRITORIO, ");
		sql.append(" SC.SBAC_OID_SBAC as SUBACCESO, ");
		sql.append(" SC.SBTI_OID_SUBT_CLIE as SUBTIPOCLIENTE, ");
		sql.append(" SC.ZTAD_OID_TERR_ADMI as TERRITORIOCLIENTE, ");
		sql.append(" SC.SOCA_OID_DOCU_REFE as OIDDOCUMENTOREFERENCIA, ");
		sql.append(" SC.SOCI_OID_SOCI as SOCIEDAD, ");
		sql.append(" SC.TDOC_OID_TIPO_DOCU as TIPODOCUMENTO, ");
		sql.append(" SC.TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, ");
		sql.append(" SC.TERR_OID_TERR as TERRITORIO, ");
		sql.append(" SC.TICL_OID_TIPO_CLIE as TIPOCLIENTE, ");
		sql.append(" SC.TIDS_OID_TIPO_DESP as TIPODESPACHO, ");
		sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS as TIPOSOLICITUD, ");
		sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS_CONS as TIPOSOLICITUDCONSOLIDADO, ");
		sql.append(" SC.VAL_BASE_FLET_DOCU as BASEFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_BASE_FLET_LOCA as BASEFLETELOCAL, ");
		sql.append(" SC.VAL_GLOS_OBSE as OBSERVACIONES, ");
		sql.append(" SC.VAL_IMPO_DESC_1_TOTA_DOCU as IMPORTEDESCUENTO1TD, ");
		sql.append(" SC.VAL_IMPO_DESC_1_TOTA_LOCA as IMPORTEDESCUENTO1TL, ");
		sql.append(" SC.VAL_IMPO_DESC_3_TOTA_DOCU as IMPORTEDESCUENTO3TD, ");
		sql.append(" SC.VAL_IMPO_DESC_3_TOTA_LOCA as IMPORTEDESCUENTO3TL, ");
		sql.append(" SC.VAL_IMPO_DESC_TOTA_DOCU as IMPORTEDESCUENTOTD, ");
		sql.append(" SC.VAL_IMPO_DESC_TOTA_LOCA as IMPORTEDESCUENTOTL, ");
		sql.append(" SC.VAL_IMPO_FLET_DOCU as IMPORTEFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_IMPO_FLET_LOCA as IMPORTEFLETELOCAL, ");
		sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_TOTA as IMPORTEFLETESINIMPUESTOSTL, ");
		sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_DOCU as IMPORTEFLETESINIMPUESTOSTD, ");
		sql.append(" SC.VAL_IMPO_FLET_TOTA_DOCU as IMPORTEFLETETD, ");
		sql.append(" SC.VAL_IMPO_FLET_TOTA_LOCA as IMPORTEFLETETL, ");
		sql.append(" SC.VAL_NUME_SOLI as NUMEROSOLICITUD, ");
		sql.append(" SC.VAL_OTRO_RECA_DOCU as OTROSRECARGOSDOCUMENTO, ");
		sql.append(" SC.VAL_OTRO_RECA_LOCA as OTROSRECARGOSLOCAL, ");
		sql.append(" SC.VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETL, ");
		sql.append(" SC.VAL_RECA_FLET_DOCU as RECARGOFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_RECA_FLET_LOCA as RECARGOFLETELOCAL, ");
		sql.append(" SC.VAL_TIPO_CAMB as TIPOCAMBIO, ");
		sql.append(" SC.VAL_TOTA_FLET_DOCU as TOTALFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_TOTA_FLET_LOCA as TOTALFLETELOCAL, ");
		sql.append(" SC.VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO, ");
		sql.append(" SC.VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL, ");
		sql.append(" SC.VAL_USUA as USUARIO, ");
		sql.append(" SC.ZZON_OID_ZONA as ZONA, ");
		sql.append(" P.CANA_OID_CANA as CANAL, "); // a�adido
		sql.append(" SC.VEPO_OID_VALO_ESTR_GEOP as UBIGEO, "); // a�adido por incidencia 10301
		sql.append(" SC.NUM_DOCU_CONT_INTE as NUMERODOCUMENTOCONTABLEINTERNO, "); //cambios paquete n21(FAC)
        sql.append(" SA.ACCE_OID_ACCE as ACCESO, "); //a�adido
        sql.append(" CASE WHEN ((SELECT PCS.OID_CLAS_SOLI ");
	    sql.append(" FROM PED_CLASE_SOLIC PCS ");
	    sql.append(" WHERE PCS.COD_CLAS_SOLI = 'O1' ");
	    sql.append("		 AND PCS.OID_CLAS_SOLI = PTS.CLSO_OID_CLAS_SOLI ");
	    sql.append(" ) IS NULL ) THEN ");
	    sql.append("	 0 ");
	    sql.append(" ELSE ");
	    sql.append("	 1 ");
	    sql.append(" END IND_CLASE_OC, ");
        /* Agregado por Cambio FAC-003 ------ AL */
        sql.append(" SC.ICTP_OID_TIPO_PROG, ");
        sql.append(" (SELECT CTP.COD_TIPO_PROG ");
        sql.append(" FROM INC_CONCU_TIPO_PROG CTP ");
        sql.append(" WHERE CTP.OID_TIPO_PROG = SC.ICTP_OID_TIPO_PROG) COD_TIPO_PROG, ");
        sql.append(" (SELECT CTP.IMP_TIPO_PROG ");
        sql.append(" FROM INC_CONCU_TIPO_PROG CTP ");
        sql.append(" WHERE CTP.OID_TIPO_PROG = SC.ICTP_OID_TIPO_PROG) IMP_TIPO_PROG ");
        /* Agregado por Cambio FAC-003 ------ AL */
        /* Agregado por 20070333 ------ AL */
        sql.append(", (SELECT SUM(PSP.NUM_UNID_COMPR) ");
        sql.append("  FROM PED_SOLIC_POSIC PSP");
        sql.append("  WHERE PSP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE) UNID_ATEN_TOTA ");
         //cambio 27/03/2012 sb se revertio
        // sql.append("  WHERE PSP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND NOT EXISTS (select 1 from pre_ofert_detal x, fac_tipo_ofert_exclu y where x.tofe_oid_tipo_ofer=y.tofe_oid_tipo_ofer and x.oid_deta_ofer=psp.ofde_oid_deta_ofer)) UNID_ATEN_TOTA ");        
        /* Agregado por 20070333 ------ AL */
        /* Agregado por Brecha PED-006 ------ AL */
        sql.append(", (SELECT VAL_TASA_IMPU ");
        sql.append(" FROM MV_ARBOL_IMPUE_UBIGE MV");
        sql.append(" WHERE MV.OID_VALO_ESTR_GEOP = SC.VEPO_OID_VALO_ESTR_GEOP) TASA_UBIGEO ");
        sql.append(", (SELECT OID_TASA_IMPU ");
        sql.append(" FROM MV_ARBOL_IMPUE_UBIGE MV");
        sql.append(" WHERE MV.OID_VALO_ESTR_GEOP = SC.VEPO_OID_VALO_ESTR_GEOP) OID_TASA_UBIGEO ");
        /* Agregado por Brecha PED-006 ------ AL */
        /* jrivas REC-001 */
        sql.append(" , OBTENER_FECHA_ENTREGA(SC.ZZON_OID_ZONA, SC.PERD_OID_PERI, SC.PAIS_OID_PAIS, '" + sFecha + "') FECHAENTREGA, ");
        sql.append(" CASE ");
        sql.append(" WHEN (SC.MODU_OID_MODU = " + ConstantesSEG.MODULO_REC + ") ");
        sql.append(" THEN (CASE ");
        sql.append(" WHEN ((SELECT COUNT (*) ");
        sql.append(" FROM PED_SOLIC_CABEC PSC ");
        sql.append(" WHERE PSC.CLIE_OID_CLIE = sc.clie_OID_CLIE ");
        sql.append(" AND PSC.FEC_FACT = TO_DATE ('" + sFecha + "', 'YYYY-MM-DD') ");
        sql.append(" AND PSC.IND_OC = 1) > 1 ");
        sql.append(" ) ");
        sql.append(" THEN 0 ");
        sql.append(" ELSE 1 ");
        sql.append(" END ");
        sql.append(" ) ");
        sql.append(" ELSE 1 ");
        sql.append(" END INDICADORPEDIDOSEVICIO ");
        /* jrivas REC-001 */
        /* Agregado por Cambio FAC-001 ------ AL */
        sql.append(", (SELECT IND_IVA_ASUM_EMPR FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) IND_IVA_ASUM_EMPR ");
        sql.append(", (SELECT VAL_PORC_IVA_ASUM_EMPR FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) VAL_PORC_IVA_ASUM_EMPR ");
        sql.append(", (SELECT IND_DIRE_SEPA FROM SEG_PARAM_INTER_PAIS WHERE PAIS_OID_PAIS = SC.PAIS_OID_PAIS) IND_DIRE_SEPA ");
        /* Agregado por Cambio FAC-001 ------ AL */
        /* Agregado por Cambio SiCC20090857 ------ jrivas */
        sql.append(", CASE WHEN (SC.MODU_OID_MODU = " + ConstantesSEG.MODULO_REC + " AND PTS.IND_SOLI_NEGA = 1) THEN ");
        sql.append("    SC.OID_SOLI_CABE ");
        sql.append(" ELSE 0 END CRIT_AGRUP_RECLAMOS");
        /* Agregado por Cambio SiCC20090857 ------ jrivas */
		sql.append(" FROM PED_SOLIC_CABEC SC, SEG_SUBAC SA, CRA_PERIO P, ");
		sql.append(" PED_SOLIC_CABEC_SECUE SCS, ZON_ZONA Z, ZON_TERRI_ADMIN TA,	  ZON_REGIO REG, ");
        sql.append(" PED_TIPO_SOLIC_PAIS TSP, ");
	    sql.append(" PED_TIPO_SOLIC PTS ");
	    sql.append(" ,PED_SOLIC_CABEC_TEMP2 TMP ");   //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
		sql.append(" WHERE P.OID_PERI = SC.PERD_OID_PERI ");
		sql.append(" AND SC.SBAC_OID_SBAC = SA.OID_SBAC ");
		sql.append(" AND SCS.SOCA_OID_SOLI_CABE (+)= SC.OID_SOLI_CABE ");
		sql.append(" AND Z.OID_ZONA = SC.ZZON_OID_ZONA ");
        sql.append(" AND TSP.OID_TIPO_SOLI_PAIS = SC.TSPA_OID_TIPO_SOLI_PAIS ");
        sql.append(" AND TSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
		sql.append(" AND TA.OID_TERR_ADMI (+)= SC.ZTAD_OID_TERR_ADMI 		 AND Z.ZORG_OID_REGI = REG.OID_REGI ");
	    
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
             sql.append(" AND SC.OID_SOLI_CABE = TMP.OID_SOLI_CABE ");
             int size = listaOIDs.size();
            
       /*      	int x = 0;
        int y = 0;
        sql.append(" AND (  ");
        boolean cerre = false;
        int size = listaOIDs.size();
        while (x < size){
         if (y == 0){
            if (x != 0){
                sql.append(" OR ");
            }
            sql.append(" SC.OID_SOLI_CABE in ( ");
        }
        if (y < 999){
            Long oidSolicitud = (Long) listaOIDs.get(x);
            sql.append(oidSolicitud).append(" ,");
            y++;
            cerre = false;
        }else{
            y = 0;
            cerre = true;
            Long oidSolicitud = (Long) listaOIDs.get(x);
            sql.append(oidSolicitud).append(" ) ");
        }
        x++;        
        if (x == size && !cerre){
            sql.deleteCharAt(sql.length()-1);
            sql.append(" ) ");	
        }
    }
		sql.append(" ) ");*/

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {   
			rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerCabecerasSolicitud: Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
		DTOFACCabeceraSolicitud dtoCabSolic=null;

		if(!rs.esVacio()){
			Vector vector=new Vector();
            size = rs.getRowCount();            
			for(int i=0;i<size;i++){
				dtoCabSolic= new DTOFACCabeceraSolicitud();
				dtoCabSolic.setUbigeo(this.bigDecimalToLong(rs.getValueAt(i,"UBIGEO")));
                dtoCabSolic.setAcceso(this.bigDecimalToLong(rs.getValueAt(i,"ACCESO")));
				dtoCabSolic.setCanal(this.bigDecimalToLong(rs.getValueAt(i,"CANAL")));
                dtoCabSolic.setAccesoFisico(this.bigDecimalToLong(rs.getValueAt(i,"ACCESOFISICO")));
				dtoCabSolic.setNumeroDocumentoContableInterno(this.bigDecimalToLong(rs.getValueAt(i,"NUMERODOCUMENTOCONTABLEINTERNO")));
				dtoCabSolic.setAlmacen(this.bigDecimalToLong(rs.getValueAt(i,"ALMACEN")));
				dtoCabSolic.setClaseSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"CLASESOLICITUD")));
				dtoCabSolic.setClasificacion(this.bigDecimalToLong(rs.getValueAt(i,"CLASIFICACION")));
				dtoCabSolic.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDCLIENTE")));
				dtoCabSolic.setConsultoraAsociada(this.bigDecimalToLong(rs.getValueAt(i,"CONSULTORAASOCIADA")));
				dtoCabSolic.setTipoClasificacion(this.bigDecimalToLong(rs.getValueAt(i,"TIPOCLASIFICACION")));
				dtoCabSolic.setEstado(this.bigDecimalToLong(rs.getValueAt(i,"ESTADO")));
				dtoCabSolic.setDestinatario(this.bigDecimalToLong(rs.getValueAt(i,"DESTINATARIO")));
				dtoCabSolic.setFecha(this.objectToDate(rs.getValueAt(i,"FECHA")));
				dtoCabSolic.setFechaFacturacion(this.objectToDate(rs.getValueAt(i,"FECHAFACTURACION")));
				dtoCabSolic.setFechaPrevistaFacturacion(this.objectToDate(rs.getValueAt(i,"FECHAPREVISTAFACTURACION")));
				dtoCabSolic.setFormaPago(this.bigDecimalToLong(rs.getValueAt(i,"FORMAPAGO")));
                dtoCabSolic.setGrupoProcesos(this.bigDecimalToLong(rs.getValueAt(i,"GRUPOPROCESOS")));
				dtoCabSolic.setIndicadorAplicacionManual(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORAPLICACIONMANUAL")));
				dtoCabSolic.setIndicadorEstadisticable(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORESTADISTICABLE")));
				dtoCabSolic.setIndicadorExentoFlete(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADOREXENTOFLETE")));
				dtoCabSolic.setIndicadorGeneraCuentaCorriente(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORGENERACUENTACORRIENTE")));
				dtoCabSolic.setIndicadorImpresion(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORIMPRESION")));
				dtoCabSolic.setIndicadorImpuestosFlete(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORIMPUESTOSFLETE")));
				dtoCabSolic.setIndicadorOrdenCompra(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORORDENCOMPRA")));
				dtoCabSolic.setIndicadorPedidoPrueba(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORPEDIDOPRUEBA")));
                dtoCabSolic.setPermiteUnionSolicitudes(this.bigDecimalToBoolean(rs.getValueAt(i,"PERMITEUNIONSOLICITUDES")));
				dtoCabSolic.setIndTSNoConsolidado(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORTSNOCONSOLIDADO")));
				dtoCabSolic.setIndicadorRevision(this.bigDecimalToLong(rs.getValueAt(i,"INDICADORREVISION")));
				dtoCabSolic.setMarca(this.bigDecimalToLong(rs.getValueAt(i,"MARCA")));
                dtoCabSolic.setModulo(this.bigDecimalToLong(rs.getValueAt(i,"MODULO")));
				dtoCabSolic.setMoneda(this.bigDecimalToLong(rs.getValueAt(i,"MONEDA")));
				dtoCabSolic.setNumeroClientes(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROCLIENTES")));
				dtoCabSolic.setNumeroConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"NUMEROCONSOLIDADO")));
				dtoCabSolic.setNumeroDocumentoOrigen(this.bigDecimalToLong(rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")));
				dtoCabSolic.setNumeroPremio(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROPREMIO")));
				dtoCabSolic.setNumeroSecuenciaFacturacionDiaria(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA")));
				dtoCabSolic.setNumeroSecuenciaZonaRuta(this.bigDecimalToInteger(rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")));
				dtoCabSolic.setOidCabeceraSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"OIDCABECERASOLICITUD")));
				dtoCabSolic.setOidConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"OIDCONSOLIDADO")));
				dtoCabSolic.setOidDireccionCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDDIRECCIONCLIENTE")));
                dtoCabSolic.setOidPagadorFactura(this.bigDecimalToLong(rs.getValueAt(i,"OIDPAGADORFACTURA")));
				dtoCabSolic.setOperacion(this.bigDecimalToLong(rs.getValueAt(i,"OPERACION")));
				dtoCabSolic.setOidPais(this.bigDecimalToLong(rs.getValueAt(i,"PAIS")));
				dtoCabSolic.setPeriodo(this.bigDecimalToLong(rs.getValueAt(i,"PERIODO")));
				dtoCabSolic.setProceso(this.bigDecimalToLong(rs.getValueAt(i,"PROCESO")));
				dtoCabSolic.setPrecioTotalTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")));
				dtoCabSolic.setPrecioTotalTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")));
				dtoCabSolic.setPuntoEmision(this.bigDecimalToString(rs.getValueAt(i,"PUNTOEMISION")));
				dtoCabSolic.setReceptorFactura(this.bigDecimalToLong(rs.getValueAt(i,"RECEPTORFACTURA")));
				dtoCabSolic.setOidSubgVentas(this.bigDecimalToLong(rs.getValueAt(i,"OIDSUBGVENTAS")));
				dtoCabSolic.setRegion(this.bigDecimalToLong(rs.getValueAt(i,"REGION")));
				dtoCabSolic.setSeccion(this.bigDecimalToLong(rs.getValueAt(i,"SECCION")));
				dtoCabSolic.setSecuenciaRutaTerritorio(this.bigDecimalToString(rs.getValueAt(i,"SECUENCIARUTATERRITORIO")));
                dtoCabSolic.setSubacceso(this.bigDecimalToLong(rs.getValueAt(i,"SUBACCESO")));
                dtoCabSolic.setSubtipoCliente(this.bigDecimalToLong(rs.getValueAt(i,"SUBTIPOCLIENTE")));
                dtoCabSolic.setTerritorioCliente(this.bigDecimalToLong(rs.getValueAt(i,"TERRITORIOCLIENTE")));
				dtoCabSolic.setOidDocumentoReferencia(this.bigDecimalToLong(rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")));
				dtoCabSolic.setSociedad(this.bigDecimalToLong(rs.getValueAt(i,"SOCIEDAD")));
				dtoCabSolic.setTipoDocumento(this.bigDecimalToLong(rs.getValueAt(i,"TIPODOCUMENTO")));
				dtoCabSolic.setTipoDocumentoLegal(this.bigDecimalToLong(rs.getValueAt(i,"TIPODOCUMENTOLEGAL")));
				dtoCabSolic.setTerritorio(this.bigDecimalToLong(rs.getValueAt(i,"TERRITORIO")));
				dtoCabSolic.setTipoCliente(this.bigDecimalToLong(rs.getValueAt(i,"TIPOCLIENTE")));
				dtoCabSolic.setTipoDespacho(this.bigDecimalToLong(rs.getValueAt(i,"TIPODESPACHO")));
				dtoCabSolic.setTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"TIPOSOLICITUD")));
				dtoCabSolic.setTipoSolicitudConsolidado(this.bigDecimalToLong(rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")));
				dtoCabSolic.setBaseFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"BASEFLETEDOCUMENTO")));
				dtoCabSolic.setBaseFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"BASEFLETELOCAL")));
				dtoCabSolic.setObservaciones(this.bigDecimalToString(rs.getValueAt(i,"OBSERVACIONES")));
                dtoCabSolic.setImporteDescuento1TotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO1TD")));
                dtoCabSolic.setImporteDescuento1TotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO1TL")));
                dtoCabSolic.setImporteDescuento3TotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO3TD")));
				dtoCabSolic.setImporteDescuento3TotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTO3TL")));
				dtoCabSolic.setImporteDescuentoTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTD")));
				dtoCabSolic.setImporteDescuentoTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEDESCUENTOTL")));
				dtoCabSolic.setImporteFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")));
				dtoCabSolic.setImporteFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETELOCAL")));
				dtoCabSolic.setImporteFleteSinImpuestosTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTL")));
				dtoCabSolic.setImporteFleteSinImpuestosTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")));
				dtoCabSolic.setImporteFleteTotalDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETETD")));
				dtoCabSolic.setImporteFleteTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"IMPORTEFLETETL")));
				dtoCabSolic.setNumeroSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"NUMEROSOLICITUD")));
				dtoCabSolic.setOtrosRecargosDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")));
				dtoCabSolic.setOtrosRecargosLocal(this.bigDecimalToFloat(rs.getValueAt(i,"OTROSRECARGOSLOCAL")));
				dtoCabSolic.setPrecioContableTotalLocal(this.bigDecimalToFloat(rs.getValueAt(i,"PRECIOCONTABLETL")));
				dtoCabSolic.setRecargoFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")));
				dtoCabSolic.setRecargoFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"RECARGOFLETELOCAL")));
				dtoCabSolic.setTotalFleteDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALFLETEDOCUMENTO")));
				dtoCabSolic.setTotalFleteLocal(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALFLETELOCAL")));
				dtoCabSolic.setTotalAPagarDocumento(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")));
				dtoCabSolic.setTotalAPagarLocal(this.bigDecimalToFloat(rs.getValueAt(i,"TOTALAPAGARLOCAL")));
				dtoCabSolic.setUsuario(this.bigDecimalToString(rs.getValueAt(i,"USUARIO")));
				dtoCabSolic.setZona(this.bigDecimalToLong(rs.getValueAt(i,"ZONA")));
				if(rs.getValueAt(i,"TIPOCAMBIO")!=null){
						dtoCabSolic.setTipoCambio((BigDecimal)rs.getValueAt(i,"TIPOCAMBIO"));
				}		
                dtoCabSolic.setIndClaseOC(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_CLASE_OC")));
                /* Agregado por Cambio FAC-003 ------ AL */
                dtoCabSolic.setOidTipoConcursoPrograma(this.bigDecimalToLong(rs.getValueAt(i, "ICTP_OID_TIPO_PROG")));
                dtoCabSolic.setCodigoTipoProgramaConcu(this.bigDecimalToString(rs.getValueAt(i, "COD_TIPO_PROG")));
                if (dtoCabSolic.getOidTipoConcursoPrograma() != null) {
                   dtoCabSolic.setImporteDescuento3TotalDocumento(new Float(0));
           		   dtoCabSolic.setImporteDescuento3TotalLocal(new Float(0));  
                }
                /* Agregado por Cambio FAC-003 ------ AL */
                /* Agregado por 20070333 ------ AL */                
                dtoCabSolic.setNumeroUnidadesAtendidasTotal(this.bigDecimalToLong(rs.getValueAt(i, "UNID_ATEN_TOTA")) );
                /* Agregado por 20070333 ------ AL */
                /* Agregado por Brecha PED-006 ------ AL */
                dtoCabSolic.setTasaImpuestoUbigeo(this.bigDecimalToFloat(rs.getValueAt(i, "TASA_UBIGEO")));  
                dtoCabSolic.setOidTasaImpuestoUbigeo(this.bigDecimalToLong(rs.getValueAt(i, "OID_TASA_UBIGEO")));
                /* Agregado por Brecha PED-006 ------ AL */
                /* jrivas REC-001 */    
                dtoCabSolic.setFechaEntrega(this.objectToDate(rs.getValueAt(i,"FECHAENTREGA")));
                dtoCabSolic.setIndPedidoServicio(this.bigDecimalToBoolean(rs.getValueAt(i,"INDICADORPEDIDOSEVICIO"))); 
                /* jrivas REC-001  */    
                /* Agregado por Cambio FAC-001 ------ AL */
                dtoCabSolic.setIndicadorIVAasumido(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_IVA_ASUM_EMPR")));
                dtoCabSolic.setPorcIVAasumido(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_PORC_IVA_ASUM_EMPR")));
                dtoCabSolic.setIndicadorDireccionSeparada(UtilidadesBD.convertirABoolean(rs.getValueAt(i, "IND_DIRE_SEPA")));
                /* Agregado por Cambio FAC-001 ------ AL */
                /* Agregado por Cambio SiCC20090857 ------ jrivas */
                dtoCabSolic.setIndicadorAgrupReclamos(UtilidadesBD.convertirALong(rs.getValueAt(i, "CRIT_AGRUP_RECLAMOS")));                
                /* Agregado por Cambio SiCC20090857 ------ jrivas */                
                listaSol.add(dtoCabSolic);
			}	//for
		}//if rs.vacio		
                
		//sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
		UtilidadesLog.warn("QUERY OIDs: "+(System.currentTimeMillis()-comienzo));
                
		UtilidadesLog.info("MONFacturacion.obtenerCabecerasSolicitud (ArrayList listaOIDs): Salida");
		return listaSol;
	}//metodo
  
  
    private static String INSERT_PED_SOLIC_CABEC_TEMP = "INSERT INTO PED_SOLIC_CABEC_TEMP ( OID_SOLI_CABE, PERD_OID_PERI, CLIE_OID_CLIE, ACCE_OID_ACCE, IND_CLAS_OC ) VALUES ( ";
    
    private static String DELETE_PED_SOLIC_CABEC_TEMP = "DELETE PED_SOLIC_CABEC_TEMP;";
    
    private StringBuffer armarInsertPED_SOLIC_CABEC_TEMP (ArrayList dtoe){
        StringBuffer salida = new StringBuffer();
        salida.append(DELETE_PED_SOLIC_CABEC_TEMP);
        for (int j=0;j<dtoe.size();j++){ 
            DTOFACCabeceraSolicitud dto = (DTOFACCabeceraSolicitud)dtoe.get(j);
            salida.append(INSERT_PED_SOLIC_CABEC_TEMP).append(dto.getOidCabeceraSolicitud()).append(" , ").append(dto.getPeriodo()).append(" , ")
            .append(dto.getOidCliente()).append(" , ").append(dto.getAcceso()).append(",");            
            if (dto.getIndClaseOC().booleanValue()) {
              salida.append("1);");            
            } else {
              salida.append("0);");
            }
        }
        if (dtoe.size() > 0) {
            salida.append("Analyze Table PED_SOLIC_CABEC_TEMP Compute Statistics;");
        }
        return salida;
    }
  
  private ArrayList obtenerTiposSolicitud() throws MareException {
    UtilidadesLog.info("MONFacturacion.obtenerTiposSolicitud(): Entrada");
    ArrayList array = new ArrayList();
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT TSP.TSPA_OID_TIPO_SOLI_PAIS ");
    query.append("FROM INT_LAR_TIPO_SOLICI_PEDIDO_DIS TSP "); 

    RecordSet rs = null;
    rs = this.executeQuery(query.toString());
    
    if(rs != null && !rs.esVacio()){
      int size = rs.getRowCount();
	  for (int i=0;i<size;i++) {
        array.add(this.bigDecimalToLong(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")));
      }
    }
    UtilidadesLog.info("MONFacturacion.obtenerTiposSolicitud(): Salida");
    return array;
  }
  
  
  private DTOFACCabeceraSolicitud[] generarSecuenciacionPorRutas (DTOFACCabeceraSolicitud[] dtoE) throws MareException {
        try{
            UtilidadesLog.info("MONFacturacion.generarSecuenciacionPorRutas(DTOFACCabeceraSolicitud[] dtoE): Entrada");
            
            /* Agregado por 20070333 ------ AL */
            ArrayList arrayTiposSolicitud = (ArrayList)this.obtenerTiposSolicitud();
            /* Agregado por 20070333 ------ AL */
            ArrayList arrayTerritorios = new ArrayList();
            ArrayList arrayClientes = new ArrayList();
            Long oidPais = dtoE[0].getOidPais();
            int mide = dtoE.length;
          
            for (int i = 0; i < mide; i++) {
                if (!arrayTerritorios.contains(dtoE[i].getTerritorio())){
                    arrayTerritorios.add(dtoE[i].getTerritorio());
                }            
                if (!arrayClientes.contains(dtoE[i].getOidCliente())){
                  arrayClientes.add(dtoE[i].getOidCliente());
                }
            }
            
            HashMap hashRutaYSecuencia = this.obtenerRutaYSecuencias(oidPais,  arrayTerritorios);
            HashMap hashCodClientes = this.obtenerCodigosClientes(arrayClientes);
            arrayTerritorios.clear();
            arrayClientes.clear();
            
            int dtoEmide = dtoE.length;
            ArrayList arrayRutasClientes = new ArrayList();
            for (int i = 0; i < dtoEmide; i++) {  
                dtoE[i].setCodigoCliente((String)hashCodClientes.get(dtoE[i].getOidCliente()));
                if (hashRutaYSecuencia.containsKey(dtoE[i].getTerritorio())){
                    DTOSolicCabecSecu dtoSCS = (DTOSolicCabecSecu)hashRutaYSecuencia.get(dtoE[i].getTerritorio());
                    dtoE[i].setNumeroSecuenciaZonaRuta(new Integer(dtoSCS.getNumSecuenciaZonasRutas().intValue()));
                    dtoE[i].setSecuenciaRutaTerritorio(dtoSCS.getSecuenciaRutaTerritorio()); 
                    dtoE[i].setOidRuta(dtoSCS.getOidRuta());
                } else {
                    dtoE[i].setNumeroSecuenciaZonaRuta(new Integer(0));
                    dtoE[i].setSecuenciaRutaTerritorio("0");                
                }      
                arrayRutasClientes.add(dtoE[i]);
            }
            
            hashCodClientes.clear();
            hashRutaYSecuencia.clear();
            Collections.sort(arrayRutasClientes, new RutasComparator());            
            
            HashMap hashFechaRuta = new HashMap();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int arrayRutasClientesLon = arrayRutasClientes.size();
            for (int i = 0; i < arrayRutasClientesLon; i++) {
                DTOFACCabeceraSolicitud dtoFACCa = (DTOFACCabeceraSolicitud)arrayRutasClientes.get(i);
                if (dtoFACCa.getFechaFacturacion()==null){
                    dtoFACCa.setFechaFacturacion(new Date(System.currentTimeMillis()));
                }
                if (dtoFACCa.getFechaPrevistaFacturacion()==null){
                    dtoFACCa.setFechaPrevistaFacturacion(new Date(System.currentTimeMillis()));
                }
                if (dtoFACCa.getFecha()==null){
                    dtoFACCa.setFecha(new Date(System.currentTimeMillis()));
                }
                Date fecha = new Date(dtoFACCa.getFechaFacturacion().getTime());
                Long ruta = new Long(dtoFACCa.getNumeroSecuenciaZonaRuta().longValue());
                if (!hashFechaRuta.containsKey(sdf.format(fecha).toString()+ruta.toString())){
                    DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = new DTOSolicitudCabeceraSecuenciaAcum();
                    dtoSolCabSecAcum.setOidPais(dtoFACCa.getOidPais());               
                    dtoSolCabSecAcum.setFechaFacturacion(fecha);
                    dtoSolCabSecAcum.setNumSecuenciaZonaRuta(ruta);
                    dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(new Long(0));
                    hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(), dtoSolCabSecAcum);
                }            
            }
            
            hashFechaRuta = this.obtenerMaximaSecuFactuDiariaPaisRutaFecha(hashFechaRuta, oidPais);
            
            DTOFACCabeceraSolicitud[] dtoConsolidadosF = new DTOFACCabeceraSolicitud[arrayRutasClientesLon];
            
            for (int i = 0; i < arrayRutasClientesLon; i++) {
                DTOFACCabeceraSolicitud dtoFACCa = (DTOFACCabeceraSolicitud)arrayRutasClientes.get(i);
                Date fecha = new Date(dtoFACCa.getFechaFacturacion().getTime());
                Long ruta = new Long(dtoFACCa.getNumeroSecuenciaZonaRuta().longValue());
                DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)hashFechaRuta.get(sdf.format(fecha).toString()+ruta.toString());
                Integer numSecu = new Integer(dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum().intValue());
                /* Agregado por 20070333 ------ AL */
                if (arrayTiposSolicitud.contains(dtoFACCa.getTipoSolicitud()) && dtoFACCa.getNumeroUnidadesAtendidasTotal() != null && dtoFACCa.getNumeroUnidadesAtendidasTotal().longValue() > 0) {
                  numSecu = new Integer(numSecu.intValue() + 1);
                  dtoFACCa.setNumeroSecuenciaFacturacionDiaria(numSecu);
                } else {
                  dtoFACCa.setNumeroSecuenciaFacturacionDiaria(new Integer(0));
                }                             
                /* Agregado por 20070333 ------ AL */
                dtoFACCa.setNumeroSecuenciaImpresion(new Integer(i+1)); 
                dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(new Long(numSecu.longValue()));
                hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(),dtoSolCabSecAcum);    
                dtoConsolidadosF[i] = dtoFACCa;
            }
            
            this.actualizarSecuenciaAcumulada(hashFechaRuta);
      
            UtilidadesLog.info("MONFacturacion.generarSecuenciacionPorRutas(DTOFACCabeceraSolicitud[] dtoE): Salida");     
            return dtoConsolidadosF;
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }
 
    
  
    private DTOFACCabeceraSolicitud[] borrarElementoLista(
        DTOFACCabeceraSolicitud[] dtoE, Integer indice)
        throws MareException {
        UtilidadesLog.info("MONFacturacion.borrarElementoLista(DTOFACCabeceraSolicitud[] dtoE, Integer indice): Entrada");
        DTOFACCabeceraSolicitud[] dtoFinal = new DTOFACCabeceraSolicitud[dtoE.length - 1];
        int j = 0;

        for (int i = 0; i < dtoE.length; i++) {
            if (i != indice.intValue()) {
                dtoFinal[j] = dtoE[i];
                j++;
            }
        }

        UtilidadesLog.info("MONFacturacion.borrarElementoLista(DTOFACCabeceraSolicitud[] dtoE, Integer indice): Salida ");

        return dtoFinal;
    }


  private HashMap obtenerRutaYSecuencias(Long oidPais, ArrayList arrayTerritorios) throws MareException {
        UtilidadesLog.info("MONFacturacion.obtenerRutaYSecuencias(DTOTerritorioRuta DTOE): Entrada ");
        
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT A.RUTR_OID_RUTA_TRAN, LPAD(B.NUM_SECU,6,'0') || LPAD(A.NUM_SECU,6,'0') SECUENCIARUTA, ");
        consulta.append(" B.NUM_SECU , A.TERR_OID_TERR");
        consulta.append(" FROM APP_RUTAS_TERRI A, APP_RUTAS_TRANS B ");
        consulta.append(" WHERE A.RUTR_OID_RUTA_TRAN = B.OID_RUTA_TRAN ");
        consulta.append(" AND B.PAIS_OID_PAIS = " + oidPais);        

        int count = 0;
        String oidsTerritorio = "";
        Iterator it = arrayTerritorios.iterator();
        consulta.append("  AND (");
        
        while (it.hasNext()){
            Long oidTerritorio = (Long) it.next();
            
            if (oidTerritorio != null){
                if (count == 0) {
                    oidsTerritorio = "'" + oidTerritorio.toString() + "'";
                } else { 
                    oidsTerritorio += ",'" + oidTerritorio.toString() + "'";
                }
            }                    
            if (count == 999)  {
                consulta.append("  A.TERR_OID_TERR IN (" + oidsTerritorio.toString() + ") ");                     
                if (it.hasNext()){
                    consulta.append("  OR ");
                }                    
                count = 0;
                oidsTerritorio = "";                           
            } else {
                if (!it.hasNext()){
                    consulta.append(" A.TERR_OID_TERR IN (" + oidsTerritorio.toString() + ") ");        
                }                    
                count++;            
            }             
            if (!it.hasNext()){              
              consulta.append(")");
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerRutaYSecuencias: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
     HashMap hashRutas = new HashMap();

		 if(!rs.esVacio()){
          int records = rs.getRowCount();
          for (int i = 0;i < records;i++){
            DTOSolicCabecSecu dtoResultado = new DTOSolicCabecSecu();
            dtoResultado.setOidRuta(this.bigDecimalToLong(rs.getValueAt(i, "RUTR_OID_RUTA_TRAN")));
            dtoResultado.setSecuenciaRutaTerritorio(this.bigDecimalToString(rs.getValueAt(i, "SECUENCIARUTA")));
            dtoResultado.setNumSecuenciaZonasRutas(this.bigDecimalToLong(rs.getValueAt(i, "NUM_SECU")));
            hashRutas.put(this.bigDecimalToLong(rs.getValueAt(i, "TERR_OID_TERR")),dtoResultado);
          }   
		 }
     UtilidadesLog.info("MONFacturacion.obtenerRutaYSecuencias(DTOTerritorioRuta DTOE): Salida ");
     return hashRutas;
    }
    
     private HashMap obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta, Long oidPais) throws MareException {
        UtilidadesLog.info("MONFacturacion.obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta): Entrada ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT P.FEC_FACT, ");
        consulta.append("        P.NUM_SECU_ZONA_RUTA, ");
        consulta.append("        P.NUM_SECU_FACT_DIAR_ACUM ");
        consulta.append(" FROM PED_SOLIC_CABEC_SECUE_ACUMU P ");
        consulta.append(" WHERE P.PAIS_OID_PAIS = " + oidPais);
        consulta.append(" AND ( ");
        Iterator it = ((Collection)hashFechaRuta.values()).iterator();
        int count = 0;
        while (it.hasNext()){
            DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)it.next();
            Date fecha = dtoSolCabSecAcum.getFechaFacturacion();
            Long ruta = dtoSolCabSecAcum.getNumSecuenciaZonaRuta();
            if (count != 0){
                consulta.append(" OR ");
            }
            
            consulta.append("   (FEC_FACT = TO_DATE('" + sdf.format(fecha) + "','YYYY-MM-DD') ");
            consulta.append("   AND NUM_SECU_ZONA_RUTA = " + ruta + " ) ");
            count++;
        }
        consulta.append(")");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerMaximaSecuFactuDiariaPaisRutaFecha: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
       
        if(!rs.esVacio()){
          int rsMide = rs.getRowCount();
          for (int i = 0;i < rsMide;i++){
              Date fecha = this.objectToDate(rs.getValueAt(i,"FEC_FACT"));
              Long ruta = this.bigDecimalToLong(rs.getValueAt(i,"NUM_SECU_ZONA_RUTA"));
              DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)hashFechaRuta.get(sdf.format(fecha).toString()+ruta.toString());                       
              dtoSolCabSecAcum.setNumSecuenciaFacturacionDiariaAcum(this.bigDecimalToLong(rs.getValueAt(i,"NUM_SECU_FACT_DIAR_ACUM")));
              dtoSolCabSecAcum.setIndicadorUpdate(Boolean.TRUE);
              hashFechaRuta.put(sdf.format(fecha).toString()+ruta.toString(),dtoSolCabSecAcum);
          }
        }

        UtilidadesLog.info("MONFacturacion.obtenerMaximaSecuFactuDiariaPaisRutaFecha(HashMap hashFechaRuta): Salida ");
        return hashFechaRuta;
    }
    
      private DTOFACCabeceraSolicitud[] copiaDto(DTOFACCabeceraSolicitud[] dtoE) {
        UtilidadesLog.info("MONSecuYMarcasChequeoBean.copiaDto(DTOFACCabeceraSolicitud[] dtoE): Entrada ");
        DTOFACCabeceraSolicitud[] dtoCopia = new DTOFACCabeceraSolicitud[dtoE.length];

        for (int i = 0; i < dtoE.length; i++) {
    			dtoCopia[i] = dtoE[i];			
        }

        UtilidadesLog.info("MONSecuYMarcasChequeoBean.copiaDto(DTOFACCabeceraSolicitud[] dtoE): Salida ");
        return dtoCopia;
    }
    
    
   private void actualizarSecuenciaAcumulada (HashMap hashFechaRuta) throws MareException {
        UtilidadesLog.info("MONFacturacion.actualizarSecuenciaAcumulada(HashMap hashFechaRuta): Entrada ");

        Iterator it = ((Collection)hashFechaRuta.values()).iterator();
        StringBuffer cadena = new StringBuffer();
        while (it.hasNext()){
            DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum = (DTOSolicitudCabeceraSecuenciaAcum)it.next();
            if (dtoSolCabSecAcum.getIndicadorUpdate() != null){
              if (dtoSolCabSecAcum.getIndicadorUpdate().booleanValue()){
                 cadena.append(this.generarCadenaUpdateAcum(dtoSolCabSecAcum));
              } else {
                cadena.append(this.generarCadenaInsercionAcum(dtoSolCabSecAcum));
              }
            } else {
               cadena.append(this.generarCadenaInsercionAcum(dtoSolCabSecAcum));
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;

        try {            
             bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",cadena.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("actualizarSecuenciaAcumulada: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
      
        UtilidadesLog.info("MONFacturacion.actualizarSecuenciaAcumulada(HashMap hashFechaRuta): Salida ");        
    }
    
    private StringBuffer generarCadenaUpdateAcum(DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum) {
      StringBuffer cadena = new StringBuffer();
      cadena.append("UPDATE PED_SOLIC_CABEC_SECUE_ACUMU SET NUM_SECU_FACT_DIAR_ACUM = " + dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum());
      cadena.append(" WHERE PAIS_OID_PAIS = " + dtoSolCabSecAcum.getOidPais());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
      cadena.append("  AND FEC_FACT = TO_DATE('" + sdf.format(dtoSolCabSecAcum.getFechaFacturacion()) + "','YYYY-MM-DD')");
      cadena.append("  AND NUM_SECU_ZONA_RUTA = " + dtoSolCabSecAcum.getNumSecuenciaZonaRuta() + ";");      
      return cadena;
    }


    private StringBuffer generarCadenaInsercionAcum(DTOSolicitudCabeceraSecuenciaAcum dtoSolCabSecAcum) {
      StringBuffer cadena = new StringBuffer();
      cadena.append("INSERT INTO PED_SOLIC_CABEC_SECUE_ACUMU (OID_SOLI_CABE_SECU_ACUM,PAIS_OID_PAIS,FEC_FACT,NUM_SECU_ZONA_RUTA, NUM_SECU_FACT_DIAR_ACUM) VALUES (");
      cadena.append("PED_SCSA_SEQ.NEXTVAL,");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
      cadena.append( dtoSolCabSecAcum.getOidPais() + "," + "TO_DATE('" + sdf.format(dtoSolCabSecAcum.getFechaFacturacion()) + "','yyyy-MM-dd'),");
      cadena.append(dtoSolCabSecAcum.getNumSecuenciaZonaRuta() + "," + dtoSolCabSecAcum.getNumSecuenciaFacturacionDiariaAcum() + ");");
      return cadena;
    }

	private ArrayList procesarMINI(DTOFACListaConsolidados dtoListaConsolidados) throws MareException {
    UtilidadesLog.info("MONProcesosFacturacionBean.procesarMINI(DTOFACListaConsolidados dtoListaConsolidados): Entrada");
    int longitud2 = 0; //longitud listaSolicitudes
    int j = 0;

    DTOGenerarConsolidado dtoGenerarConsolidados = null;
    DTOFACConsolidado dtoConsolidado = null;
    DTOFACCabeceraSolicitud dtoCabeceraConsolidado = null;
    DTOFACCabeceraSolicitud solicitudTrabajo = null;
    DTOFACCabeceraSolicitud dtoCabeceraSolicitud = null;

    ArrayList listaConsolidados = null;
    ArrayList listaSolicitudes = null;
    ArrayList secuenciaProcesos = new ArrayList();
       
    Long oidPais = null;

    HashMap hashEstadosSolicitud = new HashMap();
        
    DAOFACPrecargas daoFACPrecargas = new DAOFACPrecargas();

    listaConsolidados = dtoListaConsolidados.getListaConsolidados();
    dtoGenerarConsolidados = dtoListaConsolidados.getDtoGenerarConsolidado();

    this.indicadorImpuestosIncluidos = dtoGenerarConsolidados.getIndicadorImpuestosIncluidos(); 
    secuenciaProcesos = daoFACPrecargas.cargarSecuenciaProcesos(ConstantesPED.GP5, null,null);

    oidPais = ((DTOFACConsolidado) listaConsolidados.get(0)).getDtoCabecera().getOidPais();
    int lstCM = listaConsolidados.size();
    for(int i=0;i<lstCM;i++) {
            
        dtoConsolidado = (DTOFACConsolidado) listaConsolidados.get(i);
        dtoCabeceraConsolidado = dtoConsolidado.getDtoCabecera();
        /* Agregado por 20070333 ------ AL */
        dtoCabeceraConsolidado.setNumeroUnidadesAtendidasTotal(new Long(0)); 
        /* Agregado por 20070333 ------ AL */
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("-GA- dtoCabeceraConsolidado: "+dtoCabeceraConsolidado);
        
        listaSolicitudes = dtoConsolidado.getListaSolicitudes();
      
        dtoConsolidado.setIDSpool(dtoGenerarConsolidados.getIDSpool());
        dtoConsolidado.setIndicadorImpuestosIncluidos(dtoGenerarConsolidados.getIndicadorImpuestosIncluidos());

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


        dtoCabeceraConsolidado.setNumeroLoteFacturacion(new Long(dtoGenerarConsolidados.getNumeroLoteFacturacion()));
        
  
         if(dtoGenerarConsolidados.getIndicadorSecuenciacion() != null){
            if((dtoGenerarConsolidados.getIndicadorSecuenciacion().charValue() == 
                ConstantesFAC.COD_SECUENCIA_MONITOR.charAt(0))&&(dtoGenerarConsolidados.getSecuencia() != null)) {
                dtoCabeceraConsolidado.setNumeroSecuenciaZonaRuta(new Integer((this.minimoSecuenciaAUX(listaSolicitudes,dtoGenerarConsolidados.getSecuencia())).intValue()));
            }
        }
        dtoCabeceraConsolidado.setFecha(dtoGenerarConsolidados.getFechaFacturacion());
        dtoCabeceraConsolidado.setFechaFacturacion(dtoGenerarConsolidados.getFechaFacturacion());
        
        Iterator iteradorSecuenciaCabecera = secuenciaProcesos.iterator();
            
        while(iteradorSecuenciaCabecera.hasNext()) {				
            DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteradorSecuenciaCabecera.next();                
            if((dtoCabeceraConsolidado.getTipoSolicitud().longValue() == dtoFACSecuenciaProcesos.getTipoSolicitud().longValue()) && (dtoFACSecuenciaProcesos.getGrupoProcesos().equals(ConstantesFAC.COD_GP5))){      
                dtoCabeceraConsolidado.setGrupoProcesos(new Long(dtoFACSecuenciaProcesos.getOidGrupoProcesos().longValue()));
            }
            if((dtoCabeceraConsolidado.getTipoSolicitud().longValue() == dtoFACSecuenciaProcesos.getTipoSolicitud().longValue()) && (ConstantesFAC.COD_PROC_NULO.equals(dtoFACSecuenciaProcesos.getCodigoProceso()))){	
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
            if (hashEstadosSolicitud.get(ConstantesFAC.COD_ESTADO_SOLICITUD_OK) != null) {
              dtoCabeceraSolicitud.setEstado((Long)hashEstadosSolicitud.get(ConstantesFAC.COD_ESTADO_SOLICITUD_OK));
            }
            /* Agregado por 20070333 ------ AL */
            if (dtoCabeceraSolicitud.getNumeroUnidadesAtendidasTotal() != null) {
              dtoCabeceraConsolidado.setNumeroUnidadesAtendidasTotal(new Long(dtoCabeceraConsolidado.getNumeroUnidadesAtendidasTotal().longValue() + dtoCabeceraSolicitud.getNumeroUnidadesAtendidasTotal().longValue()) );
            }
            /* Agregado por 20070333 ------ AL */
        }           
    }

    UtilidadesLog.info("MONProcesosFacturacionBean.procesarMINI(DTOFACListaConsolidados dtoListaConsolidados): Salida");
    return listaConsolidados;
  }

	private Long minimoSecuenciaAUX(ArrayList listaSolicitudes, ArrayList secuencia) throws MareException {
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

  public void generarNumerosDocumentoInternos(Boolean indicadorOnLine, Long idSpool) throws MareException {
     if (!indicadorOnLine.booleanValue()){
           try {
              BelcorpService belcorpService = BelcorpService.getInstance();
              Date beginT = new Date();
              belcorpService.dbService.executeProcedure("FAC_GENE_NUME_DOCU_INTE",idSpool.toString());
              Date endT = new Date();
              UtilidadesLog.warn("Procedimiento Generacion Numero Documento Interno (y Legales Colombia) ----->" + (endT.getTime() - beginT.getTime()));
              CuponDePagoPeru.borrarVariablesStaticas();
              beginT = new Date();
              belcorpService.dbService.executeProcedure("FAC_GENER_NL_DOCUM_COLOM_NL", idSpool.toString());
              endT = new Date();
              UtilidadesLog.warn("Procedimiento Generacion Numero Documento Legales en Documentos Colombia No Legales-----> " + (endT.getTime() - beginT.getTime()));
           } catch ( Exception ex ) {
              throw new MareException( ex, 
                  UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
           }    
        }
  }

    private MONFacturacionLocalHome getMONFacturacionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONFacturacion");
    }


   private HashMap obtenerCodigosClientes(ArrayList arrayClientes) throws MareException {
        UtilidadesLog.info("MONFacturacion.obtenerCodigosClientes(ArrayList arrayClientes): Entrada ");
        
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT OID_CLIE, COD_CLIE ");
        consulta.append(" FROM MAE_CLIEN ");
        consulta.append(" WHERE (");

        int count = 0;
        String oidsClientes = "";
        Iterator it = arrayClientes.iterator();        
        
        while (it.hasNext()){
            Long oidCliente = (Long) it.next();
            
            if (oidCliente != null){
                if (count == 0) {
                    oidsClientes = oidCliente.toString();
                } else { 
                    oidsClientes += "," + oidCliente.toString();
                }
            }                    
            if (count == 999)  {
                consulta.append("  OID_CLIE IN (" + oidsClientes.toString() + ") ");                     
                if (it.hasNext()){
                    consulta.append("  OR ");
                }                    
                count = 0;
                oidsClientes = "";                           
            } else {
                if (!it.hasNext()){
                    consulta.append(" OID_CLIE IN (" + oidsClientes.toString() + ") ");        
                }                    
                count++;            
            }             
            if (!it.hasNext()){              
              consulta.append(")");
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerRutaYSecuencias: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
     HashMap hashCodigosClientes = new HashMap();

		 if(!rs.esVacio()){
          int records = rs.getRowCount();
          for (int i = 0;i < records;i++){
            Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"OID_CLIE"));
            String codCliente = this.bigDecimalToString(rs.getValueAt(i, "COD_CLIE"));
            hashCodigosClientes.put(oidCliente,codCliente.toString());
          }   
		 }
     UtilidadesLog.info("MONFacturacion.obtenerCodigosClientes(ArrayList arrayClientes): Salida ");
     return hashCodigosClientes;
    }

    private MONAPE getMONAPE() throws MareException {
        UtilidadesLog.info("MONFacturacion.getMONAPE(): Entrada");
        // Se obtiene el interfaz home
        MONAPEHome home = (MONAPEHome) UtilidadesEJB.getHome("MONAPE", MONAPEHome.class);
        // Se obtiene el interfaz remoto
        MONAPE ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONAPE", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONFacturacion.getMONAPE(): Salida");
        return ejb;
    }

  /* Agregado para V4 - dmorello, 30/10/2007 */
  public void generarCodigosListasPicado(Boolean indOnline, Long oidPais) throws MareException  {
      UtilidadesLog.info("MONFacturacionBean.generarCodigosListasPicado(Boolean indOnline, Long oidPais): Entrada");
      UtilidadesLog.debug("indOnline: " + indOnline);
      UtilidadesLog.debug("oidPais: " + oidPais);
      
      if (! indOnline.booleanValue()) {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          bs.dbService.executeProcedure("APE_GENE_CODI_LIST_PICA", oidPais.toString());
        } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
      }
      
      UtilidadesLog.info("MONFacturacionBean.generarCodigosListasPicado(Boolean indOnline, Long oidPais): Salida");
  }

  public void generarNumerosEtiquetas(Boolean indOnline, Long oidPais) throws MareException  {
      UtilidadesLog.info("MONFacturacionBean.generarNumerosEtiquetas(Boolean indOnline, Long oidPais): Entrada");
      UtilidadesLog.debug("indOnline: " + indOnline);
      UtilidadesLog.debug("oidPais: " + oidPais);
      
      if (! indOnline.booleanValue()) {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          bs.dbService.executeProcedure("APE_GENE_NUME_ETIQ", oidPais.toString());
        } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
      }
      
      UtilidadesLog.info("MONFacturacionBean.generarNumerosEtiquetas(Boolean indOnline, Long oidPais): Salida");
  }
  
  /**
   * Cambio 20090839
   * Rellena el campo NUM_SECU de todos los registros de APE_ETIQU que lo tengan nulo.
   * Para ello, utiliza una secuencia distinta por cada linea de armado.
   * @author dmorello
   * @since 29-09-2009
   */
  public void generarNumerosSecuenciaEtiquetas(Boolean indOnline, Long oidPais) throws MareException  {
      UtilidadesLog.info("MONFacturacionBean.generarNumerosSecuenciaEtiquetas(Boolean indOnline, Long oidPais): Entrada");
      UtilidadesLog.debug("indOnline: " + indOnline);
      UtilidadesLog.debug("oidPais: " + oidPais);
      
      if (! indOnline.booleanValue()) {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          bs.dbService.executeProcedure("APE_GENE_SECU_ETIQ", oidPais.toString());
        } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
      }
      
      UtilidadesLog.info("MONFacturacionBean.generarNumerosSecuenciaEtiquetas(Boolean indOnline, Long oidPais): Salida");
  }


  /**
   * Cambio 20090839
   * Actualiza los documentos imprimibles que contengan listas de picado
   * reemplazando los signos $$$$ por el numero de secuencia de la etiqueta
   * correspondiente a la caja (dicho numero tambien se conoce como numero unico
   * de caja)
   * @author dmorello
   * @since 16-10-2009
   */
  public void asignarNroUnicoCajaListasPicado(Boolean indOnline, Long idSpool) throws MareException {
      UtilidadesLog.info("MONFacturacionBean.asignarNroUnicoCajaListasPicado(Boolean indOnline, Long idSpool): Entrada");
      UtilidadesLog.debug("indOnline: " + indOnline);
      UtilidadesLog.debug("idSpool: " + idSpool);
      
      if (! indOnline.booleanValue()) {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          bs.dbService.executeProcedure("FAC_ASIGNA_NRO_UNICO_CAJA_LP", idSpool.toString());
        } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
      }
      
      UtilidadesLog.info("MONFacturacionBean.asignarNroUnicoCajaListasPicado(Boolean indOnline, Long idSpool): Salida");
  }
  

  private MONINTPTLLocalHome getMONINTPTLLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONINTPTLLocalHome)context.lookup("java:comp/env/MONINTPTL");
  }
  /* Fin agregado para V4 - dmorello, 30/10/2007 */
  
  private boolean validarTipoSpool(Long oidPais) throws MareException {
    UtilidadesLog.info("MONFacturacionBean.validarTipoSpool(Long oidPais): Entrada");
    Boolean indicadorTipoSpool = new Boolean(false);
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT IND_SPOO_SIN_PRE_IMPR ");
    query.append("FROM SEG_PARAM_INTER_PAIS ");
    query.append("WHERE PAIS_OID_PAIS = ").append(oidPais);
    
    RecordSet rs = null;
    rs = UtilidadesBD.executeQuery(query.toString());
    

    if (rs != null && !rs.esVacio()) {          
      indicadorTipoSpool = UtilidadesBD.convertirABoolean(rs.getValueAt(0, "IND_SPOO_SIN_PRE_IMPR"));          
    }

    UtilidadesLog.info("MONFacturacionBean.validarTipoSpool(Long oidPais): Salida");
    return indicadorTipoSpool.booleanValue();
  }
  
    private MONCrearListaPicadoLocalHome getMONCrearListaPicadoLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCrearListaPicadoLocalHome)context.lookup("java:comp/env/ejb/local/MONCrearListaPicado");
    }

    private MONProcesoFueraPedidoLocalHome getMONProcesoFueraPedidoLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONProcesoFueraPedidoLocalHome)context.lookup("java:comp/env/ejb/local/MONProcesoFueraPedido");
    }

    // sapaza -- Cambios para WCS y MUO -- 22/09/2010
    public void actualizarProductosCampana(Boolean indOnline, String fechaFacturacion) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.actualizarProductosCampana(Boolean indOnline, String fechaFacturacion): Entrada");
        UtilidadesLog.debug("indOnline: " + indOnline);
        UtilidadesLog.debug("fechaFacturacion: " + fechaFacturacion);
        
        if (! indOnline.booleanValue()) {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          try {
            bs.dbService.executeProcedure("APE_PR_ACTUA_PRODU_CAMPANA", fechaFacturacion);
          } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
        }
        
        UtilidadesLog.info("MONFacturacionBean.actualizarProductosCampana(Boolean indOnline, String fechaFacturacion): Salida");
    }

    // sapaza -- Cambios para WCS y MUO -- 22/09/2010
    public void generarOlas(Boolean indOnline, Long oidPais) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.generarOlas(Boolean indOnline, Long oidPais): Entrada");
        UtilidadesLog.debug("indOnline: " + indOnline);
        UtilidadesLog.debug("oidPais: " + oidPais);
        
        if (! indOnline.booleanValue()) {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          try {
            bs.dbService.executeProcedure("APE_PR_GENER_OLAS", oidPais.toString());
          } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
        }
        
        UtilidadesLog.info("MONFacturacionBean.generarOlas(Boolean indOnline, Long oidPais): Salida");
    }

    //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
    private void insertarTemporalOids(ArrayList listaOIDs) throws Exception {
      UtilidadesLog.info("MONFacturacionBean.insertarTemporalOids(ArrayList listaOIDs): Entrada");
      BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
      long comienzo = System.currentTimeMillis();
      bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", armarInsertPED_SOLIC_CABEC_OID_TEMP(listaOIDs).toString());
      UtilidadesLog.warn("INSERT OIDs TEMPORAL: "+(System.currentTimeMillis()-comienzo));
      UtilidadesLog.info("MONFacturacionBean.insertarTemporalOids(ArrayList listaOIDs): Salida");
    }

    private static String INSERT_PED_SOLIC_CABEC_OID_TEMP = "INSERT INTO PED_SOLIC_CABEC_TEMP2 (OID_SOLI_CABE) VALUES (";
    private static String DELETE_PED_SOLIC_CABEC_OID_TEMP = "DELETE PED_SOLIC_CABEC_TEMP2;";
    
    private StringBuffer armarInsertPED_SOLIC_CABEC_OID_TEMP (ArrayList dtoe){
        StringBuffer salida = new StringBuffer();
        salida.append(DELETE_PED_SOLIC_CABEC_OID_TEMP);
        for (int j=0;j<dtoe.size();j++){ 
            Long oidSolicitud = (Long) dtoe.get(j);
            salida.append(INSERT_PED_SOLIC_CABEC_OID_TEMP).append(oidSolicitud).append(");");
        }
        if (dtoe.size() > 0) {
            salida.append("Analyze Table PED_SOLIC_CABEC_TEMP2 Compute Statistics;");
        }
        return salida;
    }

    // sapaza -- PER-SiCC-2012-0088 -- 08/02/2012
    public void procesarGastosAdministrativos(Boolean indOnline, Long oidPais) throws MareException {
        UtilidadesLog.info("MONFacturacionBean.procesarGastosAdministrativos(Boolean indOnline, Long oidPais): Entrada");
        UtilidadesLog.debug("indOnline: " + indOnline);
        UtilidadesLog.debug("oidPais: " + oidPais);
        
        if (! indOnline.booleanValue()) {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          try {
            bs.dbService.executeProcedure("PQ_PLANI.FAC_PR_GASTOS_ADMI_SICC", oidPais.toString());
          } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
        }
        
        UtilidadesLog.info("MONFacturacionBean.procesarGastosAdministrativos(Boolean indOnline, Long oidPais): Salida");
    }
    
    //sbuchelli  29/03/2012
    //valida si existe el tipo de oferta
     private boolean validarTipoOferta(Long oidTipoOferta) throws MareException {
       UtilidadesLog.info("MONFacturacionBean.validarTipoOferta(Long oidTipoOferta): Entrada");
       Boolean indicadorTipoOferta = new Boolean(false);
       StringBuffer query = new StringBuffer();
       
       query.append("SELECT 1 ");
       query.append("FROM fac_tipo_ofert_exclu ");
       query.append("WHERE tofe_oid_tipo_ofer = ").append(oidTipoOferta);
       
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());
       

       if (rs != null && !rs.esVacio()) {          
         indicadorTipoOferta = new Boolean(true);
       }

       UtilidadesLog.info("MONFacturacionBean.validarTipoOferta(Long oidTipoOferta): Salida");
       return indicadorTipoOferta.booleanValue();
     }

}
