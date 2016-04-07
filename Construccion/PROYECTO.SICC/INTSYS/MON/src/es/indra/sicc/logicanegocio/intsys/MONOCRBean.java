package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTOCargaIncialOCR;
import es.indra.sicc.dtos.intsys.DTOCargarOrdenesDeCompra;
import es.indra.sicc.dtos.intsys.DTODatosClientesOCR;
import es.indra.sicc.dtos.intsys.DTODatosTipoSolicitudOCR;
import es.indra.sicc.dtos.intsys.DTOEntradaConsultaDatosCampana;
import es.indra.sicc.dtos.intsys.DTOEntradaGenerarFicheroMatrizPrecios;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroDeEnviarConsultoras;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroRangoCampanya;
import es.indra.sicc.dtos.intsys.DTOInterfaz;
import es.indra.sicc.dtos.intsys.DTOOCRCadenasInsercionSolicitudes;
import es.indra.sicc.dtos.intsys.DTOFormasPago;
import es.indra.sicc.dtos.intsys.DTOCodProducto;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitudAcumulados;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;
import es.indra.sicc.logicanegocio.men.MONUsuariosLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ped.ConstantesValoresDefecto;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONMonitor;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.util.SecuenciadorOID;


import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.logicanegocio.men.MONUsuariosLocal;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.ped.MONMonitorHome;
import es.indra.sicc.util.UtilidadesBD;




public class MONOCRBean implements SessionBean  {
    SessionContext ctx=null;
    private String Paquete = " [INT-OCR] ";
    private String CU = " [Cargar Ordenes de Compra] ";

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
    
    private Long tamanioSegmentoOCR = null;
    private Long numeroMaximoSegmentosOCR = null;
    
    private String IDProc = null;
    
    private HashMap hashMarcasCliente;
    private ArrayList arrayEstatusClientes;
    private HashMap hashSubtiposClientes;
    private HashMap hashUnidadAdminClientes;
    private HashMap hashUbigeoClientes;
    private HashMap hashMoneda;
    private HashMap hashIndicadoresDespacho;
    private HashMap hashTiposSolicitudIncentivos;
    
    private static UtilidadesLog logAux = new UtilidadesLog();
  
    public void cargarOrdenesDeCompra(DTOCargarOrdenesDeCompra dto) throws MareException {   
        UtilidadesLog.info("MONOCRBean.cargarOrdenesDeCompra(DTOCargarOrdenesDeCompra dto): Entrada");
        DTOArranqueGP dtoAGP = new DTOArranqueGP();        
        dtoAGP.setDtoCargarOrdenesDeCompraOCR(dto);

        MareBusinessID id = new MareBusinessID(new String("OCRCargarPadre"));
        DTOBatch dtoB = new DTOBatch(new String("OCRPADRE"), id, dtoAGP, ctx.getCallerPrincipal().getName());

        try {
            BatchUtil batch = new BatchUtil();
            batch.executeMLN(dtoB, "PEDSecuenciaProcesos"); 
        } catch (RemoteException re) {
            throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }       
        UtilidadesLog.info("MONOCRBean.cargarOrdenesDeCompra(DTOCargarOrdenesDeCompra dto): Salida");
    }
  
    public DTOSalidaBatch segmentarCargaSolicitudes(DTOBatch dtoin) throws Exception{
        UtilidadesLog.info("MONOCRBean.segmentarCargaSolicitudes(DTOBatch dtoin): Entrada");
        DTOArranqueGP dtoA = (DTOArranqueGP)dtoin.getDTOOnline();
        this.IDProc = dtoin.getProcessID();
        DTOCargarOrdenesDeCompra dto = (DTOCargarOrdenesDeCompra)dtoA.getDtoCargarOrdenesDeCompraOCR();
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(logAux.isInfoEnabled()) { 
            UtilidadesLog.info("el dto que entra, es: " + dto);
        }
        this.obtenerTamanioSegmentoOCR();

        InterfazInfo info = null;
        MONGestorInterfacesHome monGestorInterfacesHome = null;
        MONGestorInterfaces monGestorInterfaces = null;
        String pais;
        String periodo;
        String codClie;
        String tipoPos;
        String codVenta;
        Integer unidades;
        String codigoProd = null;
        String codFormPag = null;
        BigDecimal precioCatalago;
        Long docuOriPos;   
        String entero;
        String decimal;
        String total;
        
        HashMap hashPosiciones = new HashMap();       
        try {
          monGestorInterfacesHome = this.getMONGestorInterfacesHome();
          monGestorInterfaces = monGestorInterfacesHome.create();
          info = monGestorInterfaces.importarInterfaz( ConstantesOCR.NDG_INTERFAZ_POSICION, dto.getOidPais() );
        } catch(Exception exception){
          UtilidadesLog.debug("Error al obtener o importar las interfaces NDG_INTERFAZ_POSICION ");        
          throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
      
        try{              
          HashMap tipoPosicion = new HashMap();
          tipoPosicion = this.obtenerOIDTipoPosicion();          
          for(IRegistroSicc registro = monGestorInterfaces.cargarRegistro(info);
            registro != null;
            registro = monGestorInterfaces.cargarRegistro(info, false)){
            
            pais = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_PAIS );  
            periodo = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_PERIO ); 
            codClie = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_CLIENTE ); 
            tipoPos = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_TIPO_POSI ); 
            codVenta = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_COD_VENTA ); 
            unidades = (Integer)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_UNIDADES ); 
              
            if(ConstantesOCR.INDICADOR_INTERFAZ_OCR_MONETARIO.equals(dto.getIndInterfaz())){
              codigoProd = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_COD_PROD ); 
              codFormPag = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_FORM_PAG ); 
            }
            total  = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_PREC_CATA );            
            entero =  (total).substring(1,10);
            decimal = (total).substring(10,12);
            precioCatalago = new BigDecimal(entero.concat(".").concat(decimal));
            docuOriPos = (Long)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_POSIC_DOCU_ORIGEN );   
    
            String keyHash;
            keyHash = pais+"-"+periodo+"-"+codClie+"-"+docuOriPos;
              
            if (hashPosiciones.get(keyHash) == null){
              ArrayList arrayPosiciones = new ArrayList();
              DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud(); 
              dtoPosicion.setTipoPosicion(this.objectToLong(tipoPosicion.get(tipoPos)));
                 
              if (codVenta.toString().trim().length()>0)
                dtoPosicion.setCodigoVenta(codVenta.toString().trim());
              else
                dtoPosicion.setCodigoVenta(null);

              dtoPosicion.setUnidadesDemandadas(new Long(((Integer)unidades).intValue()));        
              dtoPosicion.setCodigoProducto(codigoProd);
              dtoPosicion.setCodFormaPago(codFormPag);
              dtoPosicion.setPrecioCatalogo(precioCatalago);
              
              arrayPosiciones.add(dtoPosicion);
              hashPosiciones.put(keyHash,arrayPosiciones);
            } else {
              ArrayList arrayPos = (ArrayList)hashPosiciones.get(keyHash);
              DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud(); 
              dtoPosicion.setTipoPosicion(this.objectToLong(tipoPosicion.get(tipoPos)));
                 
              if (codVenta.toString().trim().length()>0)
                dtoPosicion.setCodigoVenta(codVenta.toString().trim());
              else
                dtoPosicion.setCodigoVenta(null);
                  
              dtoPosicion.setUnidadesDemandadas(new Long(((Integer)unidades).intValue()));                    
              dtoPosicion.setCodigoProducto(codigoProd);
              dtoPosicion.setCodFormaPago(codFormPag);
              dtoPosicion.setPrecioCatalogo(precioCatalago);

              arrayPos.add(dtoPosicion);        
              hashPosiciones.put(keyHash,arrayPos);
            }
          }   
        } catch (Exception exception){      
           throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));        
        }
        monGestorInterfaces.cerrarInterfaz(info);

        try {
           info = monGestorInterfaces.importarInterfaz(ConstantesOCR.NDG_INTERFAZ_ORDEN_COMPRA, dto.getOidPais() );
        } catch ( Exception exception ) {
          UtilidadesLog.debug("Error al obtener o importar las interfaces NDG_INTERFAZ_ORDEN_COMPRA ");      
          throw new MareException(exception, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
        
        HashMap oidsOperacion = new HashMap();
        HashMap oidsModulo = new HashMap();
        ArrayList codsPais = new ArrayList();
        HashMap hashTipoSolic = new HashMap();
        HashMap hashDespacho = new HashMap();
        HashMap hashClientes = new HashMap();
        String tipoSoli;
        String tipoDes;
        String proceso;
        String subacceso;
        Date fecha;
        Integer numClie;
        Integer acceFisi;
        HashMap hashSolicCabec = new HashMap();
        HashMap hashObtenerValoresReferencia = new HashMap();
        ArrayList arrayKeysDatosReferencia = new ArrayList();
        
        Long docuOri = null;   
        String codCana = null;         
        String codAcc = null;         
        String codSubacc = null;      
        Long docuRefe = null;
        
        try {
          oidsOperacion = this.obtenerOIDOperacion(ConstantesOCR.OPERACION_OCR,ConstantesOCR.OPERACION_NDG,ConstantesOCR.OPERACION_OCR_MONETARIO);
          oidsModulo = this.obtenerOidsModulos(ConstantesOCR.MODULO_ORIGEN_OCR, ConstantesOCR.MODULO_ORIGEN_NDG);
          
          for(IRegistroSicc registro = monGestorInterfaces.cargarRegistro(info);
            registro != null;
            registro = monGestorInterfaces.cargarRegistro(info, false )) {             
              
            pais = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_PAIS );  
            periodo = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_PERIO );  
            codClie = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_CLIENTE );  
            numClie = ((Integer)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_NUM_CLIE ));
            tipoSoli =  (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_TIPO_SOLI );  
            subacceso = (String)registro.obtenerCampo(ConstantesOCR.PED_SOLIC_CABEC_SUBAC ) ;
            acceFisi =  (Integer)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_ACCE_FISI );  
            tipoDes =   (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_TIPO_DES );  
            fecha =     (Date)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_FECHA );  
            proceso =   (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_PROCE ); 
            docuOri =   (Long)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_DOCU_ORIGEN );   

            if(ConstantesOCR.INDICADOR_INTERFAZ_OCR_MONETARIO.equals(dto.getIndInterfaz())){
              codCana =   (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_CANAL );         
              codAcc =    (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_ACCESO );         
              codSubacc = (String)registro.obtenerCampo( ConstantesOCR.PED_SOLIC_CABEC_SUBACCESO );      
              docuRefe =  (Long)registro.obtenerCampo(ConstantesOCR.PED_SOLIC_CABEC_DOCU_REFERENCIA);
              if (docuRefe.longValue() == 0) {
                  docuRefe = null;
              }
            }                  
            DTOCargaIncialOCR dtoCargaInicial = new DTOCargaIncialOCR();
            dtoCargaInicial.setCodPais(pais);
            dtoCargaInicial.setCodPeriodo(periodo);
            dtoCargaInicial.setCodCliente(codClie);
            dtoCargaInicial.setTipoSolicitud(tipoSoli);
            dtoCargaInicial.setTipoDespacho(tipoDes);
            dtoCargaInicial.setNumClie(numClie);
            dtoCargaInicial.setAcceFisi(acceFisi);
            dtoCargaInicial.setFecha(fecha);
            dtoCargaInicial.setProceso(proceso);
            dtoCargaInicial.setCodSubacceso(subacceso);
            dtoCargaInicial.setDocuOri(docuOri); 
            dtoCargaInicial.setCodCana(codCana); 
            dtoCargaInicial.setCodAcc(codAcc); 
            dtoCargaInicial.setCodSubacc(codSubacc);             
            dtoCargaInicial.setDocuRefe(docuRefe); 
              
            String keyHash;
            keyHash = pais+"-"+periodo+"-"+codClie+"-"+docuOri;
            hashSolicCabec.put(keyHash, dtoCargaInicial);

            if (!codsPais.contains(pais)) {
              codsPais.add(pais);                  
            } 
            String keyTipoSolic;
            keyTipoSolic = pais +"-" + tipoSoli + "-" + periodo + "-" + subacceso;
            if (!hashTipoSolic.containsKey(keyTipoSolic)){
              hashTipoSolic.put(keyTipoSolic, dtoCargaInicial);
            }
              
            String keyHashObtenerDatosDeReferencia;
            if (codCana!=null&&codAcc!=null&&codSubacc!=null&&docuRefe!=null){
              ArrayList arrayDocumentosRefe;
              keyHashObtenerDatosDeReferencia = codCana+"-"+codAcc+"-"+codSubacc;
              if (!arrayKeysDatosReferencia.contains(keyHashObtenerDatosDeReferencia)){
                arrayKeysDatosReferencia.add(keyHashObtenerDatosDeReferencia);
              }
              if (hashObtenerValoresReferencia.containsKey(keyHashObtenerDatosDeReferencia)) {
                arrayDocumentosRefe = (ArrayList)hashObtenerValoresReferencia.get(keyHashObtenerDatosDeReferencia);                 
              } else {
                arrayDocumentosRefe = new ArrayList();                
              }
              arrayDocumentosRefe.add(dtoCargaInicial); 
              hashObtenerValoresReferencia.put(keyHashObtenerDatosDeReferencia, arrayDocumentosRefe);
            }
            
            ArrayList arrayClientes;  
            if (!hashClientes.containsKey(pais)){
              arrayClientes = new ArrayList();
              arrayClientes.add(codClie);
            } else {
              arrayClientes = (ArrayList)hashClientes.get(pais);
              if (!arrayClientes.contains(codClie)){
                arrayClientes.add(codClie);                
              }
            }            
            hashClientes.put(pais, arrayClientes);

            ArrayList arrayDespacho;
            if (hashDespacho.containsKey(pais)){
              arrayDespacho = (ArrayList)hashDespacho.get(pais);
              if (!arrayDespacho.contains(tipoDes)){
                arrayDespacho.add(tipoDes);                
              }
            } else {
              arrayDespacho = new ArrayList();
              arrayDespacho.add(tipoDes);
            } 
            hashDespacho.put(pais, arrayDespacho);
          }
        }catch (Exception exception){      
          throw new MareException(exception, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));        
        }
        
        try{
          HashMap oidsPais = this.obtenerOidPais(codsPais);          
          HashMap hashDatosTipoSolic = this.obtenerDatosTipoSolicitud(hashTipoSolic);
          HashMap hashDatosValoresDeReferencia = this.obtenerDatosValoresDeReferencia(hashObtenerValoresReferencia, arrayKeysDatosReferencia); 
          HashMap hashOidsClientes = this.obtenerOidsClientes(hashClientes, codsPais);
          HashMap hashOidsDespacho = this.obtenerOIDTipoDespacho(hashDespacho,codsPais);
          HashMap hashTiposDocumento = this.obtenerTiposDocumentos(oidsPais);
        
          Long oidPais;
          Long oidCliente;
          ArrayList arrayCabeceras = new ArrayList();
              
          ArrayList array = new ArrayList((Collection)hashSolicCabec.values());
          Iterator it = array.iterator();
          int count = 0;
          int segmentosEjecutandoSimultaneamente = 0;

          while (it.hasNext()){
            DTOCargaIncialOCR dtoCargaInicial = (DTOCargaIncialOCR)it.next();
                      
            if (oidsPais.containsKey(dtoCargaInicial.getCodPais())) {
               oidPais = (Long)oidsPais.get(dtoCargaInicial.getCodPais());
               
               if (hashOidsClientes.containsKey(""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getCodCliente())){
                 DTODatosClientesOCR dtoDatosCliente = (DTODatosClientesOCR)hashOidsClientes.get((""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getCodCliente()));
                 oidCliente = dtoDatosCliente.getOidCliente();
                 
                 if (hashDatosTipoSolic.containsKey(""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getTipoSolicitud()+"-"+dtoCargaInicial.getCodPeriodo()+"-"+dtoCargaInicial.getCodSubacceso())){
                    DTODatosTipoSolicitudOCR dtoDatosTipoSolicitud = (DTODatosTipoSolicitudOCR)hashDatosTipoSolic.get((
                    ""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getTipoSolicitud()+"-"+dtoCargaInicial.getCodPeriodo()+"-"+dtoCargaInicial.getCodSubacceso()));
                    
                    if (hashOidsDespacho.containsKey(""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getTipoDespacho())){
                      Long oidDespacho = (Long)hashOidsDespacho.get((""+dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getTipoDespacho()));
                      
                      ArrayList arrayTipoCliente = (ArrayList) dtoDatosCliente.getListaOidTipoCliente();

                      if (arrayTipoCliente.contains(dtoDatosTipoSolicitud.getOidTipoCliente())){
                         Boolean solOK = Boolean.TRUE;
                         Long oidDocuRefe = null;
                         if (dtoCargaInicial.getCodCana() != null && dtoCargaInicial.getCodAcc() != null && dtoCargaInicial.getCodSubacc() != null && dtoCargaInicial.getDocuRefe() != null){
                             DTODatosTipoSolicitudOCR dtoDatosDeRefe;
                             dtoDatosDeRefe = (DTODatosTipoSolicitudOCR)hashDatosValoresDeReferencia.get((""+dtoCargaInicial.getCodCana()
                             +"-"+dtoCargaInicial.getCodAcc()+"-"+dtoCargaInicial.getCodSubacc()+"-"+dtoCargaInicial.getDocuRefe()));
                             if (dtoDatosDeRefe == null){
                               solOK = Boolean.FALSE;
                             } else {
                               oidDocuRefe = dtoDatosDeRefe.getOidSolicitudReferenciada();
                             }
                         } 
                         
                         if (solOK.booleanValue()){
                           DTOCabeceraSolicitud dtoCabecera = new DTOCabeceraSolicitud();
                             
                           dtoCabecera.setIndMonetariasOCR(Boolean.FALSE);
                           dtoCabecera.setVerificacion(Boolean.FALSE);
                           dtoCabecera.setOidIdioma(new Long(1));
                           dtoCabecera.setOidPais(oidPais);
                           dtoCabecera.setOidCliente(oidCliente);
                           dtoCabecera.setCliente(dtoCargaInicial.getCodCliente());
                           dtoCabecera.setNumeroClientes(dtoCargaInicial.getNumClie());                  
                           dtoCabecera.setTipoSolicitud(dtoDatosTipoSolicitud.getOidTipoSolicitudPais());
                           dtoCabecera.setOidTipoSolicitud(dtoDatosTipoSolicitud.getOidTipoSolicitud());
                           dtoCabecera.setOidTipoSolicitudPais(dtoDatosTipoSolicitud.getOidTipoSolicitudPais());
                           dtoCabecera.setAccesoFisico(new Long(((Integer)dtoCargaInicial.getAcceFisi()).intValue()));
                           dtoCabecera.setTipoDespacho(oidDespacho);
                           dtoCabecera.setFecha(this.completarFecha(dtoCargaInicial.getFecha()));
                           dtoCabecera.setMoneda(dtoDatosTipoSolicitud.getOidMoneda());
                           if (dtoDatosTipoSolicitud.getOidTipoDocumento() == null) {
                              if (dtoDatosCliente.getOidTipoDocumento() == null) {
                                LogAPP.error("La cabecera no tiene tipo documento legal. Cliente: "+dtoCabecera.getOidCliente()+" - Tipo solicitud: "+dtoCabecera.getTipoSolicitud());  
                                solOK = Boolean.FALSE;
                              } else {
                                if (hashTiposDocumento.containsKey(oidPais.toString()+"-"+dtoDatosCliente.getOidTipoDocumento().toString())){
                                  dtoCabecera.setTipoDocumentoLegal((Long)hashTiposDocumento.get(oidPais.toString()+"-"+dtoDatosCliente.getOidTipoDocumento().toString()));                                                                    
                                } else {
                                  LogAPP.error("La cabecera no tiene tipo documento legal. Cliente: "+dtoCabecera.getOidCliente()+" - Tipo solicitud: "+dtoCabecera.getTipoSolicitud());  
                                  solOK = Boolean.FALSE;
                                }
                              }
                           } else {
                              dtoCabecera.setTipoDocumentoLegal(dtoDatosTipoSolicitud.getOidTipoDocumento());
                           }
                           dtoCabecera.setObservaciones(dtoDatosTipoSolicitud.getValGlosa());
                           dtoCabecera.setDestinatario(oidCliente);
                           dtoCabecera.setOidPagadorFactura(oidCliente);
                           dtoCabecera.setOidReceptorFactura(oidCliente);
                           dtoCabecera.setFormaPago(dtoDatosTipoSolicitud.getOidFormaPago());
                           dtoCabecera.setClaseSolicitud(dtoDatosTipoSolicitud.getOidClaseSolicitud());
                           dtoCabecera.setOrdenCompra(dtoDatosTipoSolicitud.getIndOrdenCompra());
                           dtoCabecera.setPermiteUnionSolicitudes(dtoDatosTipoSolicitud.getIndPermiteUnion());
                           dtoCabecera.setIndPedidoPrueba(dtoDatosTipoSolicitud.getIndPedidoPrueba());
                           dtoCabecera.setTipoConsolidado(dtoDatosTipoSolicitud.getOidTipoConsolidado());
                           dtoCabecera.setSociedad(dtoDatosTipoSolicitud.getOidSociedad());
                           dtoCabecera.setAlmacen(dtoDatosTipoSolicitud.getOidAlmacen());
                           dtoCabecera.setDestino(dtoDatosCliente.getOidDestino()); 
                           dtoCabecera.setTipoDocumento(dtoDatosCliente.getOidTipoDocumento());
                                      
                           if("O".equals(dto.getIndInterfaz())){ 
                             dtoCabecera.setOperacion(this.objectToLong(oidsOperacion.get(ConstantesOCR.OPERACION_OCR)));
                             dtoCabecera.setModulo(this.objectToLong(oidsModulo.get((ConstantesOCR.MODULO_ORIGEN_OCR).toString())));
                           } else if ("N".equals(dto.getIndInterfaz())) { 
                             dtoCabecera.setOperacion(this.objectToLong(oidsOperacion.get(ConstantesOCR.OPERACION_NDG)));
                             dtoCabecera.setModulo(this.objectToLong(oidsModulo.get((ConstantesOCR.MODULO_ORIGEN_NDG).toString())));
                           } else if ("M".equals(dto.getIndInterfaz())) {
                             dtoCabecera.setOperacion(this.objectToLong(oidsOperacion.get(ConstantesOCR.OPERACION_OCR_MONETARIO)));
                             dtoCabecera.setModulo(this.objectToLong(oidsModulo.get((ConstantesOCR.MODULO_ORIGEN_OCR_MONETARIO).toString())));
                             dtoCabecera.setIndMonetariasOCR(Boolean.TRUE);
                           }
                                        
                           dtoCabecera.setIndInterfaz(dto.getIndInterfaz());
                                        
                           dtoCabecera.setMarca(dtoDatosTipoSolicitud.getOidMarca());
                           dtoCabecera.setAcceso(dtoDatosTipoSolicitud.getOidAcceso());
                           dtoCabecera.setCanal(dtoDatosTipoSolicitud.getOidCanal());
                           dtoCabecera.setPeriodo(dtoDatosTipoSolicitud.getOidPeriodo());
                           dtoCabecera.setTipoCliente(dtoDatosTipoSolicitud.getOidTipoCliente());
                           dtoCabecera.setSubacceso(dtoDatosTipoSolicitud.getOidSubacceso());
                           dtoCabecera.setNumeroDocumentoOrigen(dtoCargaInicial.getDocuOri());
                           dtoCabecera.setProceso(dtoDatosTipoSolicitud.getOidProceso());
                           dtoCabecera.setCodPeriodoCorpo(dtoCargaInicial.getCodPeriodo());
                           dtoCabecera.setPais(dtoCargaInicial.getCodPais());
                           dtoCabecera.setOidDocumentoReferencia(oidDocuRefe);
                           dtoCabecera.setIndOnLineOCR(dtoDatosTipoSolicitud.getIndOnLine());
                           dtoCabecera.setCodigoSubacceso(dtoDatosTipoSolicitud.getCodigoSubacceso());
                           dtoCabecera.setPosiciones((ArrayList)hashPosiciones.get(dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getCodPeriodo()+"-"+
                                                      dtoCargaInicial.getCodCliente()+"-"+dtoCargaInicial.getDocuOri()));
                           if (solOK.booleanValue()){
                             if (dtoCabecera.getPosiciones() != null){                              
                                arrayCabeceras.add(dtoCabecera); 
                                count++;
                             }
                           }
                           hashPosiciones.remove(dtoCargaInicial.getCodPais()+"-"+dtoCargaInicial.getCodPeriodo()+"-"+
                                                 dtoCargaInicial.getCodCliente()+"-"+dtoCargaInicial.getDocuOri());

                           if (this.tamanioSegmentoOCR.longValue() == count || (!(it.hasNext()))){
                             ejecutarGrupo(arrayCabeceras, dtoin.getUser());
                             count = 0;
                             arrayCabeceras.clear();
                             segmentosEjecutandoSimultaneamente++;
                             if(this.numeroMaximoSegmentosOCR.intValue() == segmentosEjecutandoSimultaneamente){
                                UtilidadesLog.debug("*** Se espera el procesamiento en Batch de los Segmentos de OCR***");                                    
                                this.esperarProcesamiento();
                                segmentosEjecutandoSimultaneamente= 0;
                             }
                           } 
                         } else {
                          LogAPP.info("[OCR] La Solicitud no es Valida (No Existe la Solicitud de Referencia) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString() + " Cliente: " + dtoCargaInicial.getCodCliente().toString() + " Solicitud de Referencia : " + dtoCargaInicial.getDocuRefe()); 
                         }  
                      } else {
                        LogAPP.info("[OCR] La Solicitud no es Valida (Tipo de solicitud.tipo de cliente <> datos cliente.Tipo de cliente) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString() + " Cliente: " + dtoCargaInicial.getCodCliente().toString());
                      }               
                    } else {
                      LogAPP.info("[OCR] La Solicitud no es Valida (No se recuperaron datos para el Despacho) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString()+ " Cliente: " + dtoCargaInicial.getCodCliente().toString());
                    }
                 } else {
                   LogAPP.info("[OCR] La Solicitud no es Valida (No se recuperaron datos para el tipo de solicitud) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString()+ " Cliente: " + dtoCargaInicial.getCodCliente().toString());
                 }                          
               } else {
                 LogAPP.info("[OCR] La Solicitud no es Valida(No existe el cliente) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString() + " Cliente: " + dtoCargaInicial.getCodCliente().toString() );          
               }
            } else {
              LogAPP.info("[OCR] La Solicitud no es Valida (Pais nulo) ---> Pais: " + dtoCargaInicial.getCodPais().toString() + " Periodo: " + dtoCargaInicial.getCodPeriodo().toString() + " Cliente: " + dtoCargaInicial.getCodCliente().toString());
            }  
          }   

            
          if (arrayCabeceras.size()>0)
              ejecutarGrupo(arrayCabeceras, dtoin.getUser());
        
          Cronometrador.endTransaction("Cargar Ordenes de Compras");
          esperarProcesamiento();
          monGestorInterfaces.cerrarInterfaz(info);
          UtilidadesLog.info("MONOCRBean.segmentarCargaSolicitudes(DTOBatch dtoin): Salida");
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        this.ejecutarSolicitudesOnLine(dto.getIndInterfaz());
        return new DTOSalidaBatch(0, "Ejecucion Segmentos OCR completa");  
    }
  
    private MareDTO ejecutarGrupo(ArrayList lista, String user)throws Exception{
        UtilidadesLog.info("MONOCRBean.ejecutarGrupo(ArrayList lista): Entrada");
        MareDTO mDTOResu = new MareDTO();
        DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
        dtoEP.setListaSolicitudes(lista);
        MareBusinessID mBI = new MareBusinessID("OCRCargarPedidos");
        
        DTOSubBatch dtoSB = new DTOSubBatch(new String("SEGMENTO_CARGA_"), this.IDProc,user,mBI,dtoEP); 
        BatchUtil batch = new BatchUtil();
        mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");
        UtilidadesLog.info("MONOCRBean.ejecutarGrupo(ArrayList lista): Salida");
        return mDTOResu;        
    }
    
    protected Long obtenerTamanioSubSegmento() throws MareException{
        Long tamanioSubSegmentoOCR = null;
        MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String tamanioSubSegmento = (String) mgc.getProperty("application.TamanioSubSegmentoOCR");
        if ((tamanioSubSegmento == null) || (tamanioSubSegmento.equals(""))) {
            UtilidadesLog.debug("MONOCR.obtenerTamanioSubSegmentoOCR(): null!!! (application.properties no existe la linea: TamanioSubSegmentoOCR) ");
            throw new RuntimeException("Error Grave");
        } else {
            tamanioSubSegmentoOCR = new Long(tamanioSubSegmento);
        }            
        return tamanioSubSegmentoOCR;    
    }
    
    
    public DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException{
        UtilidadesLog.info("MONOCRBean.procesarSegmento(DTOBatch dtoin): Entrada");
        Long tamanioSubSegmentoOCR = null;
        tamanioSubSegmentoOCR = (Long)this.obtenerTamanioSubSegmento();
        try {
          DTOEjecucionProcesos dto = (DTOEjecucionProcesos) dtoin.getDTOOnline();
          ArrayList list = dto.getListaSolicitudes();
          
          Iterator it = list.iterator();        
          ArrayList arraySolicitudes = new ArrayList();
          int count = 0;
          while(it.hasNext()){
              DTOCabeceraSolicitud dtoS = (DTOCabeceraSolicitud)it.next();
              arraySolicitudes.add(dtoS);
              if (count == tamanioSubSegmentoOCR.intValue()){
                ejecutarSubSegmento(arraySolicitudes, dtoin.getProcessID());
                arraySolicitudes = new ArrayList();              
                count = 0;
              } else {
                if (!it.hasNext()) {
                  ejecutarSubSegmento(arraySolicitudes, dtoin.getProcessID());
                }
                count++;
              }            
          }        
          this.esperarProcesamientoSubSegmentos(dtoin.getProcessID());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        UtilidadesLog.info("MONOCRBean.procesarSegmento(DTOBatch dtoin): Salida");
        return new DTOSalidaBatch(0,"Ejecucion Segmento OCR completa");  
    }
   
    
    private void ejecutarSubSegmento(ArrayList arraySolicitudes, String IDProceso) throws Exception{
        DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
        dtoEP.setListaSolicitudes(arraySolicitudes);
        MareBusinessID mBI = new MareBusinessID("OCRCargarPedidosSubSegmentos");
        
        DTOSubBatch dtoSubBatch = new DTOSubBatch("SUB_SEGMENTO_CARGA", IDProceso, ctx.getCallerPrincipal().getName(),mBI, dtoEP);
        BatchUtil batch = new BatchUtil();
        batch.executeMLN(dtoSubBatch, "PEDSegmentosProcesos");
    }
    
    protected void esperarProcesamientoSubSegmentos(String codigoProceso) throws MareException {
        UtilidadesLog.info("MONOCRBean.esperarProcesamientoSubSegmentos(String codigoProceso): Entrada");
        try{          
            MONBatch mb = new MONBatch();
            mb.esperarHijos(codigoProceso);
        } catch (InterruptedException ie) {
            UtilidadesLog.info("MONGrupoProceso.esperarProcesamiento(): Salida ");
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        } 
        UtilidadesLog.info("MONOCRBean.esperarProcesamientoSubSegmentos(String codigoProceso): Salida");
    }


    protected void esperarProcesamiento() throws MareException {
        UtilidadesLog.info("MONOCRBean.esperarProcesamiento(): Entrada");
        try {
            if (this.IDProc != null) {
                MONBatch mb = new MONBatch();
                mb.esperarHijos(this.IDProc);
            }  
        } catch (InterruptedException ie) {
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        }  
        UtilidadesLog.info("MONOCRBean.esperarProcesamiento(): Salida");
    }
  
    protected void obtenerTamanioSegmentoOCR() throws MareException {
        UtilidadesLog.info("MONOCR.obtenerTamanioSegmentoOCR(): Entrada ");
        if (this.tamanioSegmentoOCR==null){
            MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String tamanio = (String) mgc.getProperty("application.TamanioSegmentoOCR");
            if ((tamanio == null) || (tamanio.equals(""))) {
                UtilidadesLog.warn("MONOCR.obtenerTamanioSegmentoOCR(): null!!! (application.properties no existe la linea: TamanioSegmentoOCR) ");
                this.tamanioSegmentoOCR = null;
            } else {
                this.tamanioSegmentoOCR = new Long(tamanio);
            }
            String nmaximo = (String) mgc.getProperty("application.NumeroMaximoSegmentosOCR");
            if ((nmaximo == null) || (nmaximo.equals(""))) {
                UtilidadesLog.warn("MONOCR.NumeroMaximoSegmentosOCR es null!!! (application.properties no existe la linea: NumeroMaximoSegmentosOCR) se tomara 8.");
                this.numeroMaximoSegmentosOCR = new Long(8);
            } else {
                this.numeroMaximoSegmentosOCR = new Long(nmaximo);
            } 
        }
        UtilidadesLog.info("MONOCR.obtenerTamanioSegmentoOCR(): Salida ");	
    }

    private HashMap obtenerOidProc() throws MareException {
        UtilidadesLog.info("MONOCRBean.obtenerOidProc(String codProceso): Entrada");
        HashMap oids = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append( "SELECT OID_PROC, COD_PROC FROM PED_PROCE");
        RecordSet rs = null;
        rs = this.executeQuery(stringBuffer.toString());
        if (!rs.esVacio()){
          for (int i=0;i < rs.getRowCount();i++){
              oids.put((String)rs.getValueAt(i,"COD_PROC"), bigDecimalToLong(rs.getValueAt(i,"OID_PROC")));
          }
        }
        UtilidadesLog.info("MONOCRBean.obtenerOidProc(String codProceso): Salida");
        return oids;    
    }
 
  

    private HashMap obtenerOIDTipoDespacho(Long oidPais) throws MareException {
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoDespacho(String cod): Entrada");
        HashMap oids = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT OID_TIPO_DESP, COD_TIPO_DESP FROM PED_TIPO_DESPA  ");
        stringBuffer.append("WHERE PAIS_OID_PAIS = ").append(oidPais);
        RecordSet rs = null;
        rs = this.executeQuery(stringBuffer.toString());
        if (!rs.esVacio()){
          for (int i=0;i < rs.getRowCount();i++){
             oids.put((String)rs.getValueAt(i,"COD_TIPO_DESP"),bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_DESP"))); 
          }
        }
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoDespacho(String cod): Salida");
        return oids;
    }

    private HashMap obtenerOIDTipoPosicion() throws MareException {
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoPosicion(String codTipoPos): Entrada");
        HashMap oids = new HashMap();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT OID_TIPO_POSI, COD_TIPO_POSI FROM PED_TIPO_POSIC ");        
        RecordSet rs = null;
        rs = this.executeQuery(stringBuffer.toString());        
        if (!rs.esVacio()){
          for (int i=0;i < rs.getRowCount();i++){
            oids.put((String)rs.getValueAt(i,"COD_TIPO_POSI"),bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_POSI")));
          }
        }    
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoPosicion(String codTipoPos): Salida");
        return oids;
    }


 

  private HashMap obtenerOIDOperacion (String codOper1, String codOper2, String codOper3) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerOIDOperacion(String cod): Entrada");
    HashMap oids = new HashMap();
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append( "SELECT OID_OPER, COD_OPER FROM BEL_OPERA WHERE COD_OPER IN ('").append(codOper1.toString()).append("', ");
    stringBuffer.append( "'").append(codOper2.toString()).append("','").append(codOper3.toString()).append("')");
    RecordSet rs = null;
    rs = this.executeQuery(stringBuffer.toString());
    if (!rs.esVacio()){
      for (int i=0;i < rs.getRowCount();i++){
          oids.put((String)rs.getValueAt(i,"COD_OPER"), bigDecimalToLong(rs.getValueAt(i,"OID_OPER")));
      }
    }
    UtilidadesLog.info("MONOCRBean.obtenerOIDOperacion(String cod): Salida");
    return oids;
  }
 
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }       
    UtilidadesLog.info("MONOCRBean.executeQuery(String query): Salida");  
    return rs;
  }

  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
		final InitialContext context = new InitialContext();
		return (MONGestorInterfacesHome)PortableRemoteObject.narrow(
              context.lookup("MONGestorInterfaces"), 
              MONGestorInterfacesHome.class);
	}

  private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGenerarSolicitudModulosExternosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarSolicitudModulosExternos"), MONGenerarSolicitudModulosExternosHome.class);
  }



  private Long bigDecimalToLong(Object numero) {    
    if (numero != null) {
      return new Long(((BigDecimal) numero).longValue());
    } else {
      return null;
    }
  }

  private Long objectToLong(Object numero) {
    if (numero != null) {
      return (Long) numero;
    } else {
      return null;
    }
  }
    
  private String objectToString(Object ob) {
    if (ob != null) {
      return (String) ob;
    } else {
      return null;
    }
  }
    
  private MONOCRLocal getMONOCRLocal() throws NamingException, MareException {
    final InitialContext context = new InitialContext();
    MONOCRLocalHome localHome = this.getMONOCRLocalHome();
    MONOCRLocal ejb = null;
    try {
      ejb = localHome.create();
    } catch (Exception e) {
      UtilidadesLog.error("*** Error en getMONOCRLocal",e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    } 
    return ejb;
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

  private MONOCRLocalHome getMONOCRLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONOCRLocalHome)context.lookup("java:comp/env/MONOCR");
  }
  
  private DTOOCRCadenasInsercionSolicitudes generaSolicitud(DTOCabeceraSolicitud dto) throws MareException {
        UtilidadesLog.info("MONOCRBean.generaSolicitud(DTOCabeceraSolicitud dto): Entrada ");        
        dto = completarPosicionesSolicitud(dto);
        dto.setIndicadorDigitacion(Boolean.FALSE);
        this.validarSolicitud(dto);
        this.asociarTipoProgramaIncentivos(dto);
        
        DTOOCRCadenasInsercionSolicitudes dtoOCRCadenasInsercionSolicitudes = new DTOOCRCadenasInsercionSolicitudes();
        
        if (dto.getOK().equals(new Boolean(true))) {
            dto.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO); 
            dtoOCRCadenasInsercionSolicitudes = this.grabarSolicitud(dto);
            if (dto.getOK().booleanValue()==false){
                LogAPP.error("[OCR] Error al generar las posiciones de la solicitud ---> Pais: " + dto.getPais().toString() + " Periodo: " + dto.getCodPeriodoCorpo().toString() + " Cliente: " + dto.getCliente().toString());                    
             }
        } else {
            LogAPP.error("[OCR] La validación de la cabecera de la solicitud no es correcta ---> Pais: " + dto.getPais().toString() + " Periodo: " + dto.getCodPeriodoCorpo().toString() + " Cliente: " + dto.getCliente().toString());                
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED + ErroresNegocio.PED_016));
        }
        UtilidadesLog.info("MONOCRBean..generaSolicitud(DTOCabeceraSolicitud dto): Salida ");            
        return dtoOCRCadenasInsercionSolicitudes;
   }
   
    private Date completarFecha (Date fecha) {
      if (fecha == null) {
          return new Date();
      } else {
          return fecha;
      }
    }  
    
    private Long completarDestino(Long oidClie) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarDestino(Long oidClie): Entrada ");
        Long oidTipoDirec = null;
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT MCD.OID_CLIE_DIRE ");
        query.append(" FROM MAE_CLIEN_DIREC MCD ");
        query.append(" WHERE MCD.CLIE_OID_CLIE = " + oidClie );
	 	query.append("    	AND MCD.IND_DIRE_PPAL = 1");
        query.append("    	AND MCD.IND_ELIM = 0");  

        RecordSet rs = null;
        
        rs = this.executeQuery(query.toString());
        
        if (!(rs == null) && !(rs.esVacio())){
          oidTipoDirec = this.bigDecimalToLong(rs.getValueAt(0,"OID_CLIE_DIRE"));
        }        
        UtilidadesLog.info("MONOCRBean.completarDestino(Long oidClie): Salida ");
        return oidTipoDirec;
    }
    
    private Long completarTipoDocumento(Long oidClie) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarTipoDocumento(Long oidClie): Entrada ");
        Long oidTipoDocu = null;
        StringBuffer query = new StringBuffer();
        
      	query.append(" SELECT MCI.TDOC_OID_TIPO_DOCU ");
	    query.append(" FROM MAE_CLIEN_IDENT MCI ");
	    query.append(" WHERE MCI.CLIE_OID_CLIE = " + oidClie);
	  	query.append("	 AND MCI.VAL_IDEN_DOCU_PRIN = 1");

        RecordSet rs = null;

        rs = this.executeQuery(query.toString());

        if (!(rs == null) && !(rs.esVacio())){
          oidTipoDocu = this.bigDecimalToLong(rs.getValueAt(0, "TDOC_OID_TIPO_DOCU"));        
        }
        UtilidadesLog.info("MONOCRBean.completarTipoDocumento(Long oidClie): Salida ");
        return oidTipoDocu; 
    }
    
    
     private Long completarTipoDespacho(Long oidPais) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarTipoDespacho(Long oidPais): Entrada ");
        Long oidTipoDespacho = null;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT OID_TIPO_DESP ");
        query.append(" FROM PED_TIPO_DESPA ");
        query.append(" WHERE IND_CRON = 1 ");
        query.append("   AND PAIS_OID_PAIS = " + oidPais);

        RecordSet rs = null;
        
        rs = this.executeQuery(query.toString());
        
        if (!(rs == null) && !(rs.esVacio())){
          oidTipoDespacho = this.bigDecimalToLong(rs.getValueAt(0, "OID_TIPO_DESP"));        
        }
        
        UtilidadesLog.info("MONOCRBean.completarTipoDespacho(Long oidPais): Salida ");
        return oidTipoDespacho;
    }

    private Long completarProceso(Long oidGrupoProceso, Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarProceso(Long oidGrupoProceso, Long oidTipoSolicitudPais): Entrada ");
        Long oidProceso = null;
        StringBuffer query = new StringBuffer();        
        
        query.append(" SELECT PROC_OID_PROC FROM ");
        query.append(" (SELECT S.PROC_OID_PROC FROM PED_SECUE_PROCE S ");
        query.append(" WHERE S.GRPR_OID_GRUP_PROC = " + oidGrupoProceso);
        query.append(" AND S.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais);
        query.append(" ORDER BY COD_SECU DESC) ");
        query.append(" WHERE ROWNUM = 1");

        RecordSet rs = null;
        
        rs = this.executeQuery(query.toString());
        
        if (!(rs == null) && !(rs.esVacio())){
            oidProceso = this.bigDecimalToLong(rs.getValueAt(0,"PROC_OID_PROC"));
        }
        UtilidadesLog.info("MONOCRBean.completarProceso(Long oidGrupoProceso, Long oidTipoSolicitudPais): Salida ");
        return oidProceso;
    }
    
    
    private DTOCabeceraSolicitud completarPosicionesSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionesSolicitud(DTOCabeceraSolicitud dtoe): Entrada ");
        Long posicion, oidTipoPosicion, oidSubtipoPosicion, oidProducto;
        Boolean indProducto;
        ArrayList miArray = new ArrayList((ArrayList)dtoCabecera.getPosiciones());
        int count = 0;
        RecordSet rs = this.obtenerTipoSubtipoPosicion(dtoCabecera.getOperacion(), dtoCabecera.getOidTipoSolicitudPais());
        if (!(rs == null) && !(rs.esVacio())){
            oidTipoPosicion = this.bigDecimalToLong(rs.getValueAt(0,"TPOS_OID_TIPO_POSI"));
            oidSubtipoPosicion = this.bigDecimalToLong(rs.getValueAt(0,"STPO_OID_SUBT_POSI"));
            indProducto = this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PROD"));
            oidProducto = this.bigDecimalToLong(rs.getValueAt(0,"PROD_OID_PROD"));

            Iterator it = miArray.iterator();
      
            while (it.hasNext()) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud) it.next();
                dtoPosicion.setTipoPosicion(oidTipoPosicion);
                dtoPosicion.setSubtipoPosicion(oidSubtipoPosicion);
                dtoPosicion = completarPosicionSolicitud(dtoPosicion, indProducto, oidProducto);
                dtoCabecera.getPosiciones().set(count, dtoPosicion);
                count++;
            }
        } else { 
            UtilidadesLog.debug("No existe Tipo de Posicion y Subtipo de Posicion");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionesSolicitud(DTOCabeceraSolicitud dtoe): Salida ");
        return dtoCabecera;
    }
    
      private DTOPosicionSolicitud completarPosicionSolicitud(DTOPosicionSolicitud dtoPosicion, Boolean indProducto, Long oidProducto) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarPosicionSolicitud(DTOPosicionSolicitud dtoPosicion, Long indProducto, Long oidProducto): Entrada ");

        dtoPosicion = completarTipoPosicionyCodigoProducto(dtoPosicion, indProducto, oidProducto);
        dtoPosicion = completarUnidadesAtender(dtoPosicion);
        dtoPosicion = completarUnidadesDemandaReal(dtoPosicion);
        
        UtilidadesLog.info("MONOCRBean.completarPosicionSolicitud(DTOPosicionSolicitud dtoPosicion, Long indProducto, Long oidProducto): Salida ");
        return dtoPosicion;
    }
    
    private RecordSet obtenerTipoSubtipoPosicion(Long oidOperacion, Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("MONOCRBean.obtenerTipoSubtipoPosicion(Long oidOperacion, Long oidTipoSolicitud): Entrada ");
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT TSP.TPOS_OID_TIPO_POSI, ");
        query.append("        TSP.STPO_OID_SUBT_POSI, ");
        query.append("	      TSP.IND_PROD,           ");
        query.append("        TSP.PROD_OID_PROD       ");
        query.append(" FROM PED_TIPO_SOLIC_PROCE TSP ");
        query.append(" WHERE TSP.OPER_OID_OPER = " + oidOperacion);
        query.append("   AND TSP.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais);

        rs = this.executeQuery(query.toString());
        
        UtilidadesLog.info("MONOCRBean.obtenerTipoSubtipoPosicion(Long oidOperacion, Long oidTipoSolicitud): Salida ");
        return rs;
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
    
    private DTOPosicionSolicitud completarTipoPosicionyCodigoProducto(DTOPosicionSolicitud dtoPosicion, Boolean indProducto, Long oidProducto) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarTipoPosicionyCodigoProducto(DTOPosicionSolicitud dtoPosicion, Boolean indProducto, Long oidProducto): Entrada ");
        //UtilidadesLog.debug("recibo: " + dtoPosicion);
        if ((dtoPosicion.getProducto() == null) && (dtoPosicion.getCodigoVenta() == null)) {           
            if (indProducto.equals(new Boolean(true))) {
                dtoPosicion.setProducto(oidProducto);
                //UtilidadesLog.debug("Se ha completado elcódigo de producto");
            } else {
                LogAPP.error(Paquete + CU + " Error en código de venta o código producto ");
                //UtilidadesLog.debug("Error: no se pudo completar el código de producto...");
            }
        }
        UtilidadesLog.info("MONOCRBean.completarTipoPosicionyCodigoProducto(DTOPosicionSolicitud dtoPosicion, Boolean indProducto, Long oidProducto): Salida ");        
        return dtoPosicion;
    }
  
    private DTOPosicionSolicitud completarUnidadesAtender(DTOPosicionSolicitud dtoPosicion) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarUnidadesAtender(DTOPosicionSolicitud dtoPosicion): Entrada ");

        if( dtoPosicion != null && dtoPosicion.getUnidadesDemandadas() != null && !dtoPosicion.getUnidadesDemandadas().equals(new Long(0)) && dtoPosicion.getUnidadesPorAtender() != null && dtoPosicion.getUnidadesPorAtender().equals(new Long(0))) {
            dtoPosicion.setUnidadesPorAtender(dtoPosicion.getUnidadesDemandadas());
        }

        UtilidadesLog.info("MONOCRBean.completarUnidadesAtender(DTOPosicionSolicitud dtoPosicion): Salida ");
        return dtoPosicion;
    }
    
    private DTOPosicionSolicitud completarUnidadesDemandaReal(DTOPosicionSolicitud dtoPosicion) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarUnidadesDemandaReal(DTOPosicionSolicitud dtoPosicion): Entrada ");
        dtoPosicion.setUnidadesDemandaReal(dtoPosicion.getUnidadesPorAtender());
        UtilidadesLog.info("MONOCRBean.completarUnidadesDemandaReal(DTOPosicionSolicitud dtoPosicion): Salida ");
        return dtoPosicion;
    }
    
    
    private DTOCabeceraSolicitud validarSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Entrada ");

        dtoCabecera = validacionOK(dtoCabecera);

        UtilidadesLog.debug("CLIENTE ");
        dtoCabecera = this.validarCliente(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false){
            UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			  return dtoCabecera;
		    }

        UtilidadesLog.debug("MONEDA ");
        dtoCabecera = this.validarMoneda(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false ){
          UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
          return dtoCabecera;
        }

        UtilidadesLog.debug("CRONOGRAMA ");
        dtoCabecera = this.validarCronograma(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
         	return dtoCabecera;
	    }
        
        UtilidadesLog.debug("FORMA PAGO ");
        dtoCabecera = this.validarFormaPago(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
   			return dtoCabecera;
        }

        UtilidadesLog.debug("TIPO SOLICITUD ");
        dtoCabecera = this.validarTipoSolicitud(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
            return dtoCabecera;
        }
        
        UtilidadesLog.debug("ALMACEN");
        dtoCabecera = this.validarAlmacen(dtoCabecera);
        if (dtoCabecera.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
            return dtoCabecera;
        }        

        UtilidadesLog.debug("USUARIO");
        dtoCabecera.setUsuario( ctx.getCallerPrincipal().getName() );
        UtilidadesLog.info("MONOCRBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
        return dtoCabecera;
    }

    private DTOCabeceraSolicitud validacionOK(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.validacionOK(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        dtoCabecera.setOK(new Boolean(true));
        UtilidadesLog.info("MONOCRBean.validacionOK(DTOCabeceraSolicitud dtoCabecera): Salida ");
        return dtoCabecera;
    }
   
    private DTOCabeceraSolicitud validacionKO(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.validacionKO(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        dtoCabecera.setOK(new Boolean(false));
        UtilidadesLog.info("MONOCRBean.validacionKO(DTOCabeceraSolicitud dtoCabecera): Salida ");
        return dtoCabecera;        
    }


    private DTOCabeceraSolicitud validarCliente(DTOCabeceraSolicitud dtoCabecera) 
		throws MareException {
        UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Entrada ");
        Long oidCliente = dtoCabecera.getOidCliente();
        RecordSet rs = null;
        
        if (!(this.validarMarcaCliente(oidCliente, dtoCabecera.getMarca()).booleanValue())) {
            dtoCabecera = validacionKO(dtoCabecera);            
            UtilidadesLog.info("Marca no Valida");
            UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
    				return dtoCabecera;
        }
        
        if (!dtoCabecera.getIndMonetariasOCR().booleanValue()){
            if (this.validarEstatusCliente(oidCliente).booleanValue()) {
                dtoCabecera = validacionKO(dtoCabecera);            
                UtilidadesLog.info("Estatus no Valido");
                UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
                return dtoCabecera;
            }
        }
        
        if (this.hashSubtiposClientes.containsKey(oidCliente)) {
          dtoCabecera.setSubtipoCliente((Long)this.hashSubtiposClientes.get(oidCliente));
        } else {
            dtoCabecera = validacionKO(dtoCabecera);            
            UtilidadesLog.info("No existe el Subtipo de Cliente");
            UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
			return dtoCabecera; 
        }
        
        if (this.hashUnidadAdminClientes.containsKey(oidCliente+"-"+dtoCabecera.getPeriodo())) {
          DTOUnidadAdministrativa dtoUAdm = (DTOUnidadAdministrativa)this.hashUnidadAdminClientes.get(oidCliente+"-"+dtoCabecera.getPeriodo());        
          dtoCabecera.setSubgerencia( dtoUAdm.getOidSGV() ); 
          dtoCabecera.setRegion( dtoUAdm.getOidRegion() ); 
          dtoCabecera.setZona( dtoUAdm.getOidZona() ); 
          dtoCabecera.setSeccion( dtoUAdm.getOidSeccion() ); 
          dtoCabecera.setTerritorio( dtoUAdm.getOidTerritorio() ); 
          dtoCabecera.setOidTerritorioAdministrativo(dtoUAdm.getOidTerritorioAdministrativo());
        } else {
          dtoCabecera = validacionKO(dtoCabecera);          
          UtilidadesLog.info("No existe Unidad Administrativa");
          UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
          return dtoCabecera;
        }
        

        if (this.hashUbigeoClientes.containsKey(oidCliente)) {
          Long ubigeo = (Long)this.hashUbigeoClientes.get(oidCliente);
          if (ubigeo != null) {
             dtoCabecera.setUbigeo(ubigeo);
          } else {
            dtoCabecera = validacionKO(dtoCabecera);          
            UtilidadesLog.info("No existe Ubigeo");
            UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
            return dtoCabecera;
          }
        } else {          
          dtoCabecera = validacionKO(dtoCabecera);          
          UtilidadesLog.info("No existe Ubigeo");
          UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
          return dtoCabecera;
        }

        UtilidadesLog.info("MONOCRBean.validarCliente(DTOCabeceraSolicitud dtoCabecera) : Salida ");
        return dtoCabecera;
   }
    
    
    private Boolean validarMarcaCliente (Long oidCliente, Long oidMarca) throws MareException{
      UtilidadesLog.info("MONOCRBean.validarMarcaCliente(Long oidCliente, Long oidMarca) : Entrada ");
      
      if (this.hashMarcasCliente.containsKey(oidCliente)) {
        if (((Long)this.hashMarcasCliente.get(oidCliente)).longValue() == oidMarca.longValue()){
          UtilidadesLog.info("MONOCRBean.validarMarcaCliente(Long oidCliente, Long oidMarca) : Salida ");
          return Boolean.TRUE;    
        } else {
          UtilidadesLog.info("MONOCRBean.validarMarcaCliente(Long oidCliente, Long oidMarca) : Salida ");
          return Boolean.FALSE;    
        }
      } else {
        UtilidadesLog.info("MONOCRBean.validarMarcaCliente(Long oidCliente, Long oidMarca) : Salida ");
        return Boolean.TRUE;    
      }
    }

    private Boolean validarEstatusCliente(Long oidCliente) throws MareException{
      UtilidadesLog.info("MONOCRBean.validarEstatusCliente(Long oidCliente) : Entrada ");
      
      if (this.arrayEstatusClientes.contains(oidCliente)){
        UtilidadesLog.info("MONOCRBean.validarEstatusCliente(Long oidCliente) : Salida ");
        return Boolean.TRUE;
      } else {
        UtilidadesLog.info("MONOCRBean.validarEstatusCliente(Long oidCliente) : Salida ");
        return Boolean.FALSE;
      }
    }
    
    private DTOCabeceraSolicitud validarMoneda (DTOCabeceraSolicitud dtoCabecera) throws MareException {
      UtilidadesLog.info("MONOCRBean.validarMoneda(DTOCabeceraSolicitud dtoCabecera): Entrada ");
      Long oidMoneda = null;
      Double tipoCambio = null;

      if (this.hashMoneda.containsKey(dtoCabecera.getPeriodo())) {
         HashMap hashM = (HashMap)this.hashMoneda.get(dtoCabecera.getPeriodo());
         oidMoneda = (Long)hashM.get("MONE_OID_MONE");
         tipoCambio = (Double)hashM.get("VAL_TIPO_CAMB");
      }     
      
      
      if (dtoCabecera.getMoneda() == null ){
          if (oidMoneda == null){
              dtoCabecera.setTipoCambio(new Double(1));
          } else {
              dtoCabecera = validacionKO(dtoCabecera);
              UtilidadesLog.debug("La Moneda del Tipo de Solicitud no coincide con la de Matriz de Facturacion");
              UtilidadesLog.info("MONOCRBean.validarMoneda(DTOCabeceraSolicitud dtoCabecera): Salida ");
              return dtoCabecera;
          }
      } else {
          if (oidMoneda != null && oidMoneda.longValue() == dtoCabecera.getMoneda().longValue()) {
              dtoCabecera.setTipoCambio(tipoCambio);
          } else {
              dtoCabecera = validacionKO(dtoCabecera);
              UtilidadesLog.debug("La Moneda del Tipo de Solicitud no coincide con la de Matriz de Facturacion");
              UtilidadesLog.info("MONOCRBean.validarMoneda(DTOCabeceraSolicitud dtoCabecera): Salida ");
              return dtoCabecera;            
          }
      
      }
      UtilidadesLog.info("MONOCRBean.validarMoneda(DTOCabeceraSolicitud dtoCabecera): Salida ");
      return dtoCabecera;
    }

    private Double longToDouble(Object numero) {    
        if (numero != null) {
            return new Double(((Long) numero).doubleValue());
        } else {
            return null;
        }
    }
    
    
    private DTOCabeceraSolicitud validarCronograma(DTOCabeceraSolicitud dtoCabecera) throws MareException {
      UtilidadesLog.info("MONOCRBean.validarCronograma(DTOCabeceraSolicitud dtoCabecera): Entrada ");
      Boolean cronogramaActivo = Boolean.FALSE;
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
      String fechaCabecera = formato.format(dtoCabecera.getFecha());
      
      Long oidPeriodo = this.validarPeriodo(fechaCabecera, dtoCabecera.getPeriodo());
      if (oidPeriodo == null){
 					UtilidadesLog.debug("validarCronograma ...1 (periodo nulo!)");						
          dtoCabecera = validacionKO(dtoCabecera);
          return dtoCabecera;
      }
      
      UtilidadesLog.debug("Establece la fecha prevista de facturación ");
      if ( dtoCabecera.getFechaPrevistaFacturacion() == null ){ 
   		  UtilidadesLog.debug("validarCronograma ...2 ");						
          Boolean indicadorCronograma = Boolean.FALSE;
          if (dtoCabecera.getTipoDespacho() != null)  {
  			UtilidadesLog.debug("validarCronograma ...3 ");
            if (this.hashIndicadoresDespacho.containsKey(dtoCabecera.getTipoDespacho())){
              indicadorCronograma = (Boolean)this.hashIndicadoresDespacho.get(dtoCabecera.getTipoDespacho()); 
            }
            UtilidadesLog.debug("validarCronograma ...4 ");						           
            if (indicadorCronograma.booleanValue() == true) {
              UtilidadesLog.debug("validarCronograma ...5 ");						
              cronogramaActivo = Boolean.TRUE;
            } else {
              UtilidadesLog.debug("validarCronograma ...6 ");						              
              dtoCabecera.setFechaPrevistaFacturacion( new Timestamp(dtoCabecera.getFecha().getTime())); 
            } 
          } else {
              UtilidadesLog.debug("validarCronograma ...7 ");						
              cronogramaActivo = Boolean.TRUE;
          }
          if (cronogramaActivo.booleanValue()) {
            UtilidadesLog.debug("validarCronograma ...8 ");						
            Timestamp fechaIni = null;
            fechaIni = this.obtenerFechaInicioCronograma( dtoCabecera.getZona(), dtoCabecera.getPeriodo(), dtoCabecera.getOidTipoSolicitudPais()); 
            if ( fechaIni == null ) {
              UtilidadesLog.debug("validarCronograma ...9 ");						
              dtoCabecera = validacionKO(dtoCabecera);
              return dtoCabecera;
            } else { 
              UtilidadesLog.debug("validarCronograma ...10 ");						
              dtoCabecera.setFechaPrevistaFacturacion(fechaIni); 
            } 
          }
        }    
     return dtoCabecera;
  }
  
  private Long validarPeriodo(String fechaCabecera, Long oidPeriodo) throws MareException{
    UtilidadesLog.info("MONOCRBean.validarPeriodo(String fechaCabecera, Long oidPeriodo): Entrada ");
    Long oid = null;
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT PER.OID_PERI ");
    query.append(" FROM CRA_PERIO PER ");
    query.append(" WHERE PER.OID_PERI = " + oidPeriodo);
    query.append("   AND PER.FEC_INIC <= TO_DATE ('" + fechaCabecera + "','YYYY-MM-DD') ");
    query.append("   AND PER.FEC_FINA >= TO_DATE ('" + fechaCabecera + "','YYYY-MM-DD') ");	 
    query.append("   AND PER.VAL_ESTA = 1 ");
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
            
    if (!(rs == null) && !(rs.esVacio())){
      oid = this.bigDecimalToLong(rs.getValueAt(0,"OID_PERI"));
    } 
    
    UtilidadesLog.info("MONOCRBean.validarPeriodo(String fechaCabecera, Long oidPeriodo): Salida ");
    return oid;
  }
  
  private Boolean obtenerIndicadorDespacho (Long oidDepacho) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerDatosDespacho(Long oidDepacho): Entrada ");
    Boolean indicador = Boolean.FALSE;
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT PTD.IND_CRON ");
    query.append(" FROM PED_TIPO_DESPA PTD ");
    query.append(" WHERE PTD.OID_TIPO_DESP = " + oidDepacho);
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
            
    if (!(rs == null) && !(rs.esVacio())){
      indicador = this.bigDecimalToBoolean(rs.getValueAt(0,"IND_CRON"));
    } 
    
    UtilidadesLog.info("MONOCRBean.obtenerDatosDespacho(Long oidDepacho): Salida");
    return indicador;
  } 
  
  private Timestamp obtenerFechaInicioCronograma (Long oidZona, Long oidPeriodo, Long oidTipoSolicitudPais) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerFechaInicioCronograma(Long oidZona, Long oidPeriodo, Long oidTipoSolicitudPais): Entrada ");
    java.util.Date fechaIni = null;    
    Timestamp tmstmp = null;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Date dia = new java.sql.Date( System.currentTimeMillis());
    String sDia = sdf.format(dia);
    
    StringBuffer query = new StringBuffer();
    query.append(" SELECT CRONO.FEC_INIC ");
    query.append(" FROM CRA_CRONO CRONO ");
    query.append(" WHERE 1=1 ");
    query.append("    AND CRONO.PERD_OID_PERI = " + oidPeriodo );
    query.append("    AND CRONO.ZZON_OID_ZONA = " + oidZona );
    query.append("       AND CASE WHEN  ((SELECT TSP.CACT_OID_ACTI ");
    query.append("  FROM PED_TIPO_SOLIC_PAIS TSP ");
    query.append(" WHERE TSP.OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais + ") IS NULL) THEN ");
    query.append("		 1 ");
    query.append(" ELSE ");
    query.append("       CRONO.CACT_OID_ACTI ");
    query.append(" END = ");
    query.append(" CASE WHEN  ((SELECT TSP.CACT_OID_ACTI ");
    query.append(" FROM PED_TIPO_SOLIC_PAIS TSP ");
    query.append(" WHERE TSP.OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais + ") IS NULL) THEN ");
    query.append(" 		 1 ");
    query.append(" ELSE ");
    query.append("      (SELECT TSP.CACT_OID_ACTI ");
    query.append(" FROM PED_TIPO_SOLIC_PAIS TSP ");
    query.append(" WHERE TSP.OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais + ") ");
    query.append(" END");
    query.append(" AND (CRONO.FEC_INIC >= TO_DATE('" + sDia +"','YYYY-MM-DD'))  ");
    query.append(" ORDER BY CRONO.FEC_INIC ");
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    
    if (!(rs == null) && !(rs.esVacio())){
        fechaIni = (Date)rs.getValueAt(0,"FECHAINI");
        tmstmp = this.obtenerTimestamp(fechaIni);
    }
   
   
    UtilidadesLog.info("MONOCRBean.obtenerFechaInicioCronograma(Long oidZona, Long oidPeriodo, Long oidTipoSolicitudPais): Salida ");
    return tmstmp;
  }
  
  
  private Timestamp obtenerTimestamp( java.util.Date fecha ){
      UtilidadesLog.info("MONOCRBean.obtenerTimestamp( java.util.Date fecha ):Entrada");
      GregorianCalendar gc = new GregorianCalendar();
      Timestamp tmstmp = null;
      String anio = null;
      String mes = null;
      String dia = null;
      String sDate = null;
  
      if (fecha != null) {
        gc.setTime( fecha );
        anio = ( new Integer( gc.get( GregorianCalendar.YEAR ) ) ).toString();
  
        if( gc.get( GregorianCalendar.MONTH ) < 10 ){
          mes = "0" + ( new Integer( gc.get( GregorianCalendar.MONTH ) + 1 ) ).toString();
        } else{
          mes = ( new Integer( gc.get( GregorianCalendar.MONTH ) + 1 ) ).toString();
        }
  
        if( gc.get( GregorianCalendar.DAY_OF_MONTH ) < 10 ){
          dia = "0" + ( new Integer( gc.get( GregorianCalendar.DAY_OF_MONTH ) ) ).toString();
        } else{
          dia = ( new Integer( gc.get( GregorianCalendar.DAY_OF_MONTH ) ) ).toString();
        }
              
        sDate = anio + "-" + mes + "-" + dia + " 00:00:00";
        tmstmp = Timestamp.valueOf( sDate );
      }
      UtilidadesLog.info("MONOCRBean.obtenerTimestamp( java.util.Date fecha ):Salida");
      return tmstmp;
   }
   
   private DTOCabeceraSolicitud validarFormaPago(DTOCabeceraSolicitud dtoCabecera) throws MareException {
     UtilidadesLog.info("MONOCRBean.validarFormaPago(DTOCabeceraSolicitud dtoCabecera): Entrada ");
     
     if (dtoCabecera.getFormaPago() == null) {
        Long oidFormaPago = null;
        oidFormaPago = this.obtenerFormaPagoCliente(dtoCabecera.getOidCliente());
        if (oidFormaPago != null) {
          dtoCabecera.setFormaPago(oidFormaPago);          
        } else {
          oidFormaPago = this.obtenerFormaPagoPais(dtoCabecera.getOidPais());  
          if (oidFormaPago != null) {
            dtoCabecera.setFormaPago(oidFormaPago);          
          }
        }
     }
     UtilidadesLog.info("MONOCRBean.validarFormaPago(DTOCabeceraSolicitud dtoCabecera): Salida ");
     return dtoCabecera;
  }

    private Long obtenerFormaPagoCliente (Long oidCliente) throws MareException {
      UtilidadesLog.info("MONOCRBean.obtenerFormaPagoCliente(Long oidCliente): Entrada ");
      Long oid = null;
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT FOPA_OID_FORM_PAGO ");
      query.append(" FROM MAE_CLIEN ");
      query.append(" WHERE OID_CLIE = " + oidCliente );
      
      RecordSet rs = null;
    
      rs = this.executeQuery(query.toString());
    
      if (!(rs == null) && !(rs.esVacio())){
          oid = this.bigDecimalToLong(rs.getValueAt(0,"FOPA_OID_FORM_PAGO"));
      }
      UtilidadesLog.info("MONOCRBean.obtenerFormaPagoCliente(Long oidCliente): Salida ");
      return oid;
    }
    
    private Long obtenerFormaPagoPais (Long oidPais) throws MareException {
      UtilidadesLog.info("MONOCRBean.obtenerFormaPagoPais (Long oidPais): Entrada ");
      Long oid = null;
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT FOPA_OID_FORM_PAGO ");
      query.append(" FROM SEG_PAIS ");
      query.append(" WHERE OID_PAIS = " + oidPais );
      
      RecordSet rs = null;
    
      rs = this.executeQuery(query.toString());
    
      if (!(rs == null) && !(rs.esVacio())){
          oid = this.bigDecimalToLong(rs.getValueAt(0,"FOPA_OID_FORM_PAGO"));
      }
      UtilidadesLog.info("MONOCRBean.obtenerFormaPagoPais (Long oidPais): Salida ");
      return oid;
    }
    
    private DTOCabeceraSolicitud validarTipoSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException {
     UtilidadesLog.info("MONOCRBean.validarTipoSolicitud(DTOCabeceraSolicitud dtoCabecera): Entrada ");

     if (dtoCabecera.getSociedad()==null){
       StringBuffer query = new StringBuffer();
          
       query.append(" SELECT VDTS.VAL_DEFE_OID ");
       query.append(" FROM PED_VALOR_DEFEC_TIPO_SOLIC VDTS, ");
       query.append("      PED_ATRIB_ESPEC PAE ");
       query.append(" WHERE PAE.OID_ATRI_ESPE = VDTS.ATRE_OID_ATRI_ESPE ");
	   query.append("   AND PAE.COD_ATRI = '" + ConstantesValoresDefecto.SOCIEDAD + "'");
       query.append("   AND VDTS.TSPA_OID_TIPO_SOLI_PAIS = " + dtoCabecera.getOidTipoSolicitudPais());  
 
       RecordSet rs = null;
            
       rs = this.executeQuery(query.toString());
        
       if (!(rs == null) && !(rs.esVacio())){
         dtoCabecera.setSociedad(this.bigDecimalToLong(rs.getValueAt(0,"VAL_DEFE_OID")));
       } else {
         try{
           UtilidadesLog.debug("Se obtiene el valor correspondiente al usuario");

           MONUsuariosLocal monUsuarios = this.getMONUsuariosLocalHome().create();
           HashMap propiedades = monUsuarios.getProperties(new UserIDImpl(ctx.getCallerPrincipal().getName()));

           UtilidadesLog.debug(" Sociedad por defecto del usuario: ");
           UtilidadesLog.debug((String) ((Property) propiedades.get(ConstantesPED.SOCIEDAD_DEFECTO)).getValue());
        
           UtilidadesLog.debug(" Se setea en el DTO. ");
           dtoCabecera.setSociedad( new Long( (String) ((Property) propiedades.get(ConstantesPED.SOCIEDAD_DEFECTO)).getValue() )  );
         }catch(Exception ex){
           UtilidadesLog.error("ERROR AL OBTENER EL VALOR POR DEFECTO DEL USUARIO: "+ctx.getCallerPrincipal().getName(), ex);
         }          
      }       
    }

    dtoCabecera.setIndTSNoConsolidado( Boolean.TRUE );
    UtilidadesLog.info("MONOCRBean.validarTipoSolicitud(DTOCabeceraSolicitud dtoCabecera): Salida ");
    return dtoCabecera;
 }
    
    
       private DTOOCRCadenasInsercionSolicitudes grabarSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        Boolean errorPosicion = new Boolean(false);  
    
        HashMap hashCodigosVenta = new HashMap();
        HashMap hashFormasDePago = null;
        HashMap hashCodigosDeProducto = null;
        
        if(ConstantesOCR.INDICADOR_INTERFAZ_OCR_MONETARIO.equals(dtoCabecera.getIndInterfaz())){
            hashFormasDePago = this.obtenerFormasDePago(dtoCabecera); 
            hashCodigosDeProducto = this.obtenerCodigosDeProducto(dtoCabecera); 
        }else{
            hashCodigosVenta = this.obtenerCodigosVenta(dtoCabecera); 
        }
        
        
        for (int numeroPosicion=0; numeroPosicion < dtoCabecera.getPosiciones().size(); numeroPosicion++){ 
            dtoCabecera = this.generarPosicion(dtoCabecera, new Long(numeroPosicion), Boolean.FALSE, hashCodigosVenta, hashFormasDePago, hashCodigosDeProducto);
            /*if (!dtoCabecera.getOK().booleanValue()){
                errorPosicion = new Boolean(true);
            }*/
        }
        
        //dtoCabecera.setOK(new Boolean(!errorPosicion.booleanValue()));
            boolean verificacion = false;
            
            if (dtoCabecera.getVerificacion() != null)
                verificacion = dtoCabecera.getVerificacion().booleanValue();
    
        DTOOCRCadenasInsercionSolicitudes dtoOCRCadenasInsercionSolicitudes = new DTOOCRCadenasInsercionSolicitudes();        

        if (verificacion == false){ 
          dtoOCRCadenasInsercionSolicitudes = this.generarStringInsercionSolicitud(dtoCabecera);		
        }
    
        return dtoOCRCadenasInsercionSolicitudes;
      }
      
      private HashMap obtenerCodigosDeProducto(DTOCabeceraSolicitud dtoCabecera) throws MareException{
          UtilidadesLog.info("MONOCRBean.obtenerCodigosDeProducto(DTOCabeceraSolicitud dtoCabecera): Entrada");
          HashMap hashCodigosProd = new HashMap();
          ArrayList arrayPosiciones = dtoCabecera.getPosiciones();
          Iterator it = arrayPosiciones.iterator();
          String keyCodsProd;
          StringBuffer codigosProducto = null;
          StringBuffer query = null;
          
          while (it.hasNext()){
              DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) it.next();
              keyCodsProd = dtoPos.getCodigoProducto();
              if (hashCodigosProd.get(keyCodsProd)==null)
                  hashCodigosProd.put(keyCodsProd, dtoPos.getCodigoProducto());
          }
          
          if (hashCodigosProd.size()>0) {
              query = new StringBuffer();
              query.append("SELECT mp.oid_prod, mp.cod_sap ");
              query.append("from mae_produ mp ");
              query.append("WHERE pais_oid_pais = " + dtoCabecera.getOidPais().longValue());

              ArrayList array = new ArrayList((Collection)hashCodigosProd.values());
              Iterator it1 = array.iterator();
              int count1 = 0;
              codigosProducto = new StringBuffer();
              String codProdNoRepetida;
              while (it1.hasNext()){     
                  codProdNoRepetida = (String)it1.next();
                  if (codProdNoRepetida != null){
                     codigosProducto.append("'" + codProdNoRepetida + "', ");
                     count1++;            
                  }                      
                  if (count1 > 900 ){
                      count1 = 0; 
                      if (codigosProducto.length()>0 && it1.hasNext()){
                           codigosProducto = new StringBuffer(codigosProducto.substring(0, codigosProducto.length()-2));
                           codigosProducto.append(") OR mp.cod_sap IN( ");
                      }                    
                  } 
              }   
             
              if(codigosProducto.length()>0){
                 query.append(" AND ( mp.cod_sap IN (");
                 codigosProducto = new StringBuffer(codigosProducto.substring(0, codigosProducto.length()-2));
                 query.append(codigosProducto).append("))");
                 
              }
              UtilidadesLog.debug("query: " + query.toString());
              RecordSet rs = null;
              rs = this.executeQuery(query.toString());
              if (!rs.esVacio()){
                   DTOCodProducto dtoCP = null;
                   HashMap hashProductos = new HashMap();
                   for (int f=0;f < rs.getRowCount();f++){
                       dtoCP = new DTOCodProducto();
                       
                       dtoCP.setOidProd(this.bigDecimalToLong(rs.getValueAt(f,"OID_PROD"))); 
                       dtoCP.setCodProd(rs.getValueAt(f,"COD_SAP").toString());
                       hashProductos.put(rs.getValueAt(f,"COD_SAP").toString().trim(), dtoCP);
                   }
                   UtilidadesLog.info("MONOCRBean.obtenerCodigosDeProducto(DTOCabeceraSolicitud dtoCabecera): Salida");        
                   return hashProductos;
              } else {
                UtilidadesLog.info("MONOCRBean.obtenerCodigosDeProducto(DTOCabeceraSolicitud dtoCabecera): Salida");        
                return null;
              }
          } else {
              UtilidadesLog.info("MONOCRBean.obtenerCodigosDeProducto(DTOCabeceraSolicitud dtoCabecera): Salida");        
              return null;
          }
      }
      
      private HashMap obtenerFormasDePago(DTOCabeceraSolicitud dtoCabecera) throws MareException{
          UtilidadesLog.info("MONOCRBean.obtenerFormasDePago(DTOCabeceraSolicitud dtoCabecera): Entrada");
          ArrayList arrayPosiciones = dtoCabecera.getPosiciones();
          Iterator it = arrayPosiciones.iterator();
          int i=0;
          String keyCodsFmaPag;
          StringBuffer codigosFmasPago = null;
          HashMap hashCodigosFmaPago = new HashMap();
          StringBuffer query = null;
          
          while (it.hasNext()){
              DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) it.next();
              keyCodsFmaPag = dtoPos.getCodFormaPago();
              if (hashCodigosFmaPago.get(keyCodsFmaPag)==null)
                  hashCodigosFmaPago.put(keyCodsFmaPag, dtoPos.getCodFormaPago());
          }
          
          if (hashCodigosFmaPago.size()>0) {
              query = new StringBuffer();
              query.append("SELECT fp.oid_form_pago, fp.cod_form_pago ");
              query.append("from bel_forma_pago fp ");
              query.append("WHERE fp.pais_oid_pais = " + dtoCabecera.getOidPais().longValue());
                
              ArrayList array = new ArrayList((Collection)hashCodigosFmaPago.values());
              Iterator it1 = array.iterator();
              int count1 = 0;
              codigosFmasPago = new StringBuffer();
              String formaPagoNoRepetida;
              while (it1.hasNext()){     
                  formaPagoNoRepetida = (String)it1.next();
                  if (formaPagoNoRepetida != null){
                     codigosFmasPago.append("'" + formaPagoNoRepetida + "', ");
                     count1++;
                  }                      
                  if (count1 > 900 )  {
                      count1 = 0; 
                      if (codigosFmasPago.length()>0 && it1.hasNext()){
                           //SACO LA COMA DEL FINAL Y CIERRO EL "IN"
                           codigosFmasPago = new StringBuffer(codigosFmasPago.substring(0, codigosFmasPago.length()-2));
                           codigosFmasPago.append(") OR fp.cod_form_pago IN( ");
                      }                    
                  } 
              }

              if(codigosFmasPago.length()>0){
                 query.append(" AND ( fp.cod_form_pago IN (");
                 codigosFmasPago = new StringBuffer(codigosFmasPago.substring(0, codigosFmasPago.length()-2));
                 query.append(codigosFmasPago).append("))");
              }

              UtilidadesLog.debug("query: " + query.toString());
              RecordSet rs = null;
              rs = this.executeQuery(query.toString());
              
              if (!rs.esVacio()){
                   DTOFormasPago dtoFP = null;
                   HashMap hashFormasPago = new HashMap();
                   for (int f=0;f < rs.getRowCount();f++){
                       dtoFP = new DTOFormasPago();
                       
                       dtoFP.setOidFP(this.bigDecimalToLong(rs.getValueAt(f,"OID_FORM_PAGO")));
                       dtoFP.setCodFP(rs.getValueAt(f,"COD_FORM_PAGO").toString());
                       hashFormasPago.put(rs.getValueAt(f,"COD_FORM_PAGO").toString().trim(), dtoFP);
                   }
                   UtilidadesLog.info("MONOCRBean.obtenerFormasDePago(DTOCabeceraSolicitud dtoCabecera): Salida");        
                   return hashFormasPago;
              } else {
                UtilidadesLog.info("MONOCRBean.obtenerFormasDePago(DTOCabeceraSolicitud dtoCabecera): Salida");        
                return null;
              }
          } else {
              UtilidadesLog.info("MONOCRBean.obtenerFormasDePago(DTOCabeceraSolicitud dtoCabecera): Salida");        
              return null;
          }
      }
  
       private HashMap obtenerCodigosVenta(DTOCabeceraSolicitud dtoCabecera) throws MareException{
        UtilidadesLog.info("MONOCRBean.obtenerCodigoVenta(DTOCabeceraSolicitud dtoCabecera): Entrada");
        int count = 0;
        int x = 0;
        String codigosVenta = "";        
        ArrayList arrayPosiciones = dtoCabecera.getPosiciones();       
        StringBuffer query = null;
        
        if (this.verificarCodigosVentaEnPosiciones(arrayPosiciones).booleanValue()){
            query = new StringBuffer();
            query.append("SELECT POD.VAL_CODI_VENT, POD.OID_DETA_OFER, POD.PROD_OID_PROD, POD.IND_DIGI, POD.FOPA_OID_FORM_PAGO ");
            query.append("  FROM PRE_OFERT_DETAL POD, PRE_OFERT PO, PRE_ESTRA PE, PRE_MATRI_FACTU_CABEC PMF ");
            query.append("  WHERE POD.OFER_OID_OFER = PO.OID_OFER ");
            Iterator it = arrayPosiciones.iterator();
            query.append("  AND (");
            
            while (it.hasNext()){
                DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) it.next();
                
                if (dtoPos.getCodigoVenta() != null){
                    if (count == 0) {
                        codigosVenta = "'" + dtoPos.getCodigoVenta().toString() + "'";
                    } else { 
                        codigosVenta += ",'" + dtoPos.getCodigoVenta().toString() + "'";
                    }
                }                    
                if (count == 999)  {
                    query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");                     
                    if (it.hasNext()){
                        query.append("  OR ");
                    }                    
                    count = 0;
                    codigosVenta = "";
                    x++;                
                } else {
                    if (!it.hasNext()){
                        query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");        
                    }                    
                    count++;            
                } 
                
                if (!it.hasNext()){              
                  query.append(")");
                }
            }
            
            if (dtoCabecera.getAcceso() != null) {
                query.append("  AND ( PO.ACCE_OID_ACCE  =  " + dtoCabecera.getAcceso());
                query.append(" 	   	OR PO.ACCE_OID_ACCE IS NULL) ");
            }
            if (dtoCabecera.getSubacceso() != null) {
                query.append("   AND (PO.SBAC_OID_SBAC =  " + dtoCabecera.getSubacceso());
                query.append("   	    OR PO.SBAC_OID_SBAC IS NULL)");  
            }
            query.append(" AND PO.MFCA_OID_CABE = PMF.OID_CABE ");
            query.append(" AND PO.COES_OID_ESTR = PE.OID_ESTR ");
            query.append(" AND PMF.PERD_OID_PERI = " + dtoCabecera.getPeriodo());
            RecordSet rs = null;
            
            UtilidadesLog.debug("query: " + query.toString());
            
            rs = this.executeQuery(query.toString());
            
            if (!rs.esVacio()){
                 DTOSValidarCodigoVenta dtoVCV = null;
                 HashMap hashCodigosVenta = new HashMap();
                 for (int i=0;i < rs.getRowCount();i++){
                     dtoVCV = new DTOSValidarCodigoVenta();
                     dtoVCV.setOidDetalleOferta(this.bigDecimalToLong(rs.getValueAt(i,"OID_DETA_OFER")));
                     dtoVCV.setProducto(this.bigDecimalToLong(rs.getValueAt(i,"PROD_OID_PROD")));
                     dtoVCV.setIndicadorDigitableGP(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_DIGI")));
                     dtoVCV.setOidFormaPago(this.bigDecimalToLong(rs.getValueAt(i,"FOPA_OID_FORM_PAGO")));
                     hashCodigosVenta.put((String)rs.getValueAt(i,"VAL_CODI_VENT"),dtoVCV);
                 }
                 UtilidadesLog.info("MONOCRBean.obtenerCodigoVenta(DTOCabeceraSolicitud dtoCabecera): Salida");        
                 return hashCodigosVenta;
            } else {
              UtilidadesLog.info("MONOCRBean.obtenerCodigoVenta(DTOCabeceraSolicitud dtoCabecera): Salida");        
              return null;
            }
        
        } else {
        
            UtilidadesLog.info("MONOCRBean.obtenerCodigoVenta(DTOCabeceraSolicitud dtoCabecera): Salida");        
            return null;
        
        }
        
    }
    
    private Boolean verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones){
        UtilidadesLog.info("MONOCRBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Entrada");        
       
        DTOPosicionSolicitud dtoPos = null;
        Iterator it = arrayPosiciones.iterator();
        
        while (it.hasNext()){
            dtoPos = (DTOPosicionSolicitud) it.next();        
            if (dtoPos.getCodigoVenta() != null && dtoPos.getCodigoVenta().trim().length() > 0){            
                UtilidadesLog.info("MONOCRBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Salida");
                return Boolean.TRUE;
            }
        }
        
        UtilidadesLog.info("MONOCRBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Salida");        
        return Boolean.FALSE;
    }
    
    private DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta
                                                 , HashMap hashFormasDePago, HashMap hashCodigosDeProducto) throws MareException {
        UtilidadesLog.info("MONOCRBean.generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Entrada ");
        validacionOK(dtoCabecera);

        DTOPosicionSolicitud pos = null;
        ArrayList sacar = dtoCabecera.getPosiciones();
        
        pos = (DTOPosicionSolicitud) sacar.get(linea.intValue());

        if (hashCodigosVenta != null){
          if (pos.getCodigoVenta() != null) {
              if ( (dtoCabecera.getModulo() == null) || (dtoCabecera.getModulo().longValue() != ConstantesPED.MODULO_RECLAMOS.longValue())) {
                  dtoCabecera = this.validarCodigoVenta(dtoCabecera, new Long(linea.longValue()), hashCodigosVenta);
                  if (dtoCabecera.getOK().booleanValue() == false) {
                      UtilidadesLog.info("MONOCRBean.generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
                      return dtoCabecera;
                  }
              }
          } else {
            if(!dtoCabecera.getIndMonetariasOCR().booleanValue()){
                UtilidadesLog.info("MONOCRBean.generarPosicion  pos.getCodigoVenta() = null");
                pos.setOK(new Boolean(false));
                LogAPP.info("La posicion no tiene codigo de venta, se invalida.");
            }
          }
        } else {
            if(!dtoCabecera.getIndMonetariasOCR().booleanValue()){
              dtoCabecera.setOK(new Boolean(false));
              LogAPP.info("No se encontraron los codigos de venta, se invalida la cabecera.");
              UtilidadesLog.info("MONOCRBean.generarPosicion Hash Codigos Venta  = null");
            }
        }
        //UtilidadesLog.info("MONOCRBean.generarPosicion  dtoCabecera:"+dtoCabecera);
        //UtilidadesLog.info("MONOCRBean.generarPosicion  pos:"+pos);
        if((dtoCabecera.getOK()==null || (dtoCabecera.getOK()!=null && dtoCabecera.getOK().booleanValue())) &&  
            (pos.getOK()==null || (pos.getOK()!=null && pos.getOK().booleanValue()))){
            dtoCabecera = validarNumeroUnidades(dtoCabecera, new Integer(linea.intValue()));
        }        
        if((dtoCabecera.getOK()==null || (dtoCabecera.getOK()!=null && dtoCabecera.getOK().booleanValue())) &&  
            (pos.getOK()==null || (pos.getOK()!=null && pos.getOK().booleanValue()))){
            dtoCabecera = validarSolicitudNegativa(dtoCabecera, new Integer(linea.intValue()));
        }
        if((dtoCabecera.getOK()==null || (dtoCabecera.getOK()!=null && dtoCabecera.getOK().booleanValue())) &&  
            (pos.getOK()==null || (pos.getOK()!=null && pos.getOK().booleanValue()))){
            dtoCabecera = completarPosicion(dtoCabecera, new Long(linea.longValue()), hashCodigosVenta, hashFormasDePago, hashCodigosDeProducto);
        }
        UtilidadesLog.info("MONOCRBean.generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
        return dtoCabecera;
  }
  
  
  private DTOCabeceraSolicitud validarCodigoVenta(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta) throws MareException {
        UtilidadesLog.info("MONOCRBean.validarCodigoVenta(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta): Entrada ");
        DTOPosicionSolicitud dtop = (DTOPosicionSolicitud) dtoCabecera.getPosiciones().get(linea.intValue());
        //UtilidadesLog.debug("plp: " + linea.intValue());
        
        //UtilidadesLog.debug("plp validarCodigoVenta: " + dtop);
        
        //UtilidadesLog.debug("hashCodigosVenta:  " + hashCodigosVenta);
        
        DTOSValidarCodigoVenta dtosvcv = null;
        dtosvcv = (DTOSValidarCodigoVenta)hashCodigosVenta.get(dtop.getCodigoVenta().toString());
        
        //UtilidadesLog.debug("plp dtosvcv: " + dtosvcv);
        
        if (dtosvcv != null) {
			  if (dtosvcv.getIndicadorDigitableGP() == null)
				    dtosvcv.setIndicadorDigitableGP(new Boolean(false));
            
        if ((dtoCabecera.getIndicadorDigitacion().booleanValue()) && (!dtosvcv.getIndicadorDigitableGP().booleanValue())) {
                dtoCabecera = codigoVentaKO(dtoCabecera, linea);
                LogAPP.info("El indicador de digitable de la cabecera difiere del indicador de digitable de la posicion.");
                UtilidadesLog.info("MONOCRBean.validarCodigoVenta(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta): Salida ");
                return dtoCabecera;
            } else {
                if (dtosvcv.getProducto() != null){
                  UtilidadesLog.info("MONOCRBean.validarCodigoVenta: getProducto() != nul");
                  dtop.setProducto(dtosvcv.getProducto());
                  dtop.setOidDetalleOferta(dtosvcv.getOidDetalleOferta());    
                  dtop.setOK(new Boolean(true));
                  dtoCabecera.getPosiciones().set(linea.intValue(), dtop);
                } else {
                  //dtoCabecera = codigoVentaKO(dtoCabecera, linea);
                  //UtilidadesLog.info("MONOCRBean.validarCodigoVenta(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta): Salida ");
                  //return dtoCabecera;
                  dtop.setOK(new Boolean(false));
                  LogAPP.info("El codigo de producto es nulo.");
                  dtoCabecera.getPosiciones().set(linea.intValue(), dtop);
                }
            }
        } else {
            //dtoCabecera = codigoVentaKO(dtoCabecera, linea);
            dtop.setOK(new Boolean(false));
            dtoCabecera.getPosiciones().set(linea.intValue(), dtop);
            LogAPP.info("El codigo de venta: "+dtop.getCodigoVenta().toString()+" no existe.");
            //return dtoCabecera;
        }
        UtilidadesLog.info("MONOCRBean.validarCodigoVenta(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta): Salida ");
        return dtoCabecera;
    }

    private DTOCabeceraSolicitud codigoVentaKO(DTOCabeceraSolicitud dtoCabecera, Long linea) throws MareException {
        UtilidadesLog.info("MONOCRBean.codigoVentaKO(DTOCabeceraSolicitud dtoCabecera, Long linea): Entrada ");
        
        //dtoCabecera.setOK(Boolean.FALSE);

        DTOPosicionSolicitud dtop = (DTOPosicionSolicitud) dtoCabecera.getPosiciones().get(linea.intValue());

        dtop.setOK(Boolean.FALSE);
        dtop.setCvOK(Boolean.FALSE);

        dtop.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_012 ); //Inc. 7494
        dtoCabecera.getPosiciones().set(linea.intValue(), dtop);
        UtilidadesLog.info("MONOCRBean.codigoVentaKO(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
        return dtoCabecera;
    }
    
    private DTOCabeceraSolicitud validarNumeroUnidades(DTOCabeceraSolicitud dtoCabecera, Integer linea) throws MareException {
        UtilidadesLog.info("MONOCRBean.validarNumeroUnidades(DTOCabeceraSolicitud dtoCabecera, Integer linea): Entrada ");
        
        DTOPosicionSolicitud solicitud = null;
        long unidades = 0;
        long alarma = 0;
            if (dtoCabecera.getAlarmaNumUnidades() != null) {
                alarma = dtoCabecera.getAlarmaNumUnidades().longValue();
            }
            
            solicitud = (DTOPosicionSolicitud) dtoCabecera.getPosiciones().get(linea.intValue());
            unidades = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0); //REC-12 10/01/06
            //doliva -- cambio Optimizacion Logs -- 24/03/2010
            if(logAux.isDebugEnabled()) { 
                UtilidadesLog.debug("unidades, es: " + unidades);
            }
            if (alarma != 0) {
                if (Math.abs(unidades) > alarma) {
                    Long lin = new Long(linea.longValue());
                    UtilidadesLog.debug("voy a....this.numeroUnidadesKO(..........");
                    dtoCabecera = this.numeroUnidadesKO(dtoCabecera, lin, new Long(alarma));
                }
            }
      
        UtilidadesLog.info("MONOCRBean.validarNumeroUnidades(DTOCabeceraSolicitud dtoCabecera, Integer linea): Salida ");
        return dtoCabecera;
    }   
    
    private DTOCabeceraSolicitud validarSolicitudNegativa(DTOCabeceraSolicitud dtoCabecera, Integer linea) throws MareException {
        UtilidadesLog.info("MONOCRBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoCabecera, Integer linea): Entrada ");
        
        DTOPosicionSolicitud solicitud = null;
        
        long unidades_demand = 0;
        boolean solicitud_neg = true;
        
        if (!(dtoCabecera.getIndSolNegativa() == null)){
            solicitud_neg = dtoCabecera.getIndSolNegativa().booleanValue();
                
            solicitud = (DTOPosicionSolicitud) dtoCabecera.getPosiciones().get(linea.intValue());
            unidades_demand = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0);
            UtilidadesLog.info("unidades_demand " + unidades_demand );
            if (solicitud_neg == false) {
                 if (unidades_demand < 0) {
                     UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand < 0 - soliNeg = false");
                     dtoCabecera = solicitudNegativaKO(dtoCabecera, new Long(linea.longValue()));
                     UtilidadesLog.info("MONOCRBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoCabecera, Integer linea): Salida ");
                     return dtoCabecera;
                 }
            } else {
                 if (unidades_demand > 0) {
                     UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand > 0 - soliNeg = true");
                     dtoCabecera = solicitudNegativaKO(dtoCabecera, new Long(linea.longValue()));
                 }
            }
        }
        UtilidadesLog.info("MONOCRBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoCabecera, Integer linea): Salida ");
        return dtoCabecera;
    }
    
    private DTOCabeceraSolicitud numeroUnidadesKO(DTOCabeceraSolicitud dtoCabecera, Long linea, Long unidadesMaximas) throws MareException {
        UtilidadesLog.info("MONOCRBean.numeroUnidadesKO(DTOCabeceraSolicitud dtoCabecera, Long linea, Long unidadesMaximas): Entrada ");    
        //dtoCabecera.setOK(Boolean.FALSE);
       
        DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) dtoCabecera.getPosiciones().get(linea.intValue());
        UtilidadesLog.debug("la posic. de la sol. recuperada es: " + dtoPos);

        dtoPos.setOK(Boolean.FALSE);
        dtoPos.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_020); //inc. 7494
        dtoPos.setUnidadesMaximas( unidadesMaximas ); //inc. 7494

        dtoCabecera.getPosiciones().set(linea.intValue(), dtoPos);        
        UtilidadesLog.info("MONOCRBean.numeroUnidadesKO(DTOCabeceraSolicitud dtoCabecera, Long linea, Long unidadesMaximas): Salida ");    
        return dtoCabecera;
    }

    private DTOCabeceraSolicitud solicitudNegativaKO(DTOCabeceraSolicitud dtoCabecera, Long linea) throws MareException {
        UtilidadesLog.info("MONOCRBean.solicitudNegativaKO(DTOCabeceraSolicitud dtoCabecera, Long linea): Entrada ");
        //dtoCabecera.setOK(new Boolean(false));

        ArrayList arr = dtoCabecera.getPosiciones();
        DTOPosicionSolicitud pos = (DTOPosicionSolicitud) arr.get(linea.intValue());
        pos.setOK(new Boolean(false));        
        pos.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_026);
        arr.set(linea.intValue(), pos);
        dtoCabecera.setPosiciones(arr);
        UtilidadesLog.info("MONOCRBean.solicitudNegativaKO(DTOCabeceraSolicitud dtoCabecera, Long linea): Salida ");
        return dtoCabecera;
    }
    
    private DTOCabeceraSolicitud completarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, HashMap hashCodigosVenta, 
                                                   HashMap hashFormasDePago, HashMap hashCodigosDeProducto) throws MareException {
        UtilidadesLog.info("MONOCRBean.completarPosicion(completarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, " +
                           "HashMap hashCodigosVenta, HashMap hashFormasDePago, HashMap hashCodigosDeProducto): Entrada ");
        
        DTOPosicionSolicitud posicion = null;
        DTOPosicionSolicitud posicionAnterior = null;

        ArrayList pos = dtoCabecera.getPosiciones();
        posicion = (DTOPosicionSolicitud) pos.get(linea.intValue());
        if (posicion.getNumeroPosicion() == null) 
           {
                //UtilidadesLog.debug("linea: " + linea);
                //if (linea.longValue() > 0) {
                    /*posicionAnterior = (DTOPosicionSolicitud) pos.get(linea.intValue()-1);
                    UtilidadesLog.debug("posicionAnterior  " + posicionAnterior);
                    UtilidadesLog.debug("NumeroPosicion  " + posicionAnterior.getNumeroPosicion());
                    if (posicionAnterior.getNumeroPosicion()==null){
                        UtilidadesLog.info("MONOCRBean.completarPosicion(completarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, " +
                                           "HashMap hashCodigosVenta, HashMap hashFormasDePago, HashMap hashCodigosDeProducto): Salida 0 ");
                        
                        return dtoCabecera;
                    }*/
                    
                    if ( (dtoCabecera.getIndicadorDigitacion() != null) && (dtoCabecera.getIndicadorDigitacion().booleanValue())) {
                        posicion.setNumeroPosicion(new Long(obtenerSiguienteNumeroPosicion(dtoCabecera, linea).longValue() + 10));
                    } else {
                        posicion.setNumeroPosicion(new Long(obtenerSiguienteNumeroPosicion(dtoCabecera, linea).longValue() + 1));
                    } 
                /*} else {
                    posicion.setNumeroPosicion(new Long(0));
                }*/
           }
        
        //doliva -- cambio Optimizacion Logs -- 24/03/2010
        if(logAux.isDebugEnabled()) { 
            UtilidadesLog.debug("posicion.getNumeroPosicion" + posicion.getNumeroPosicion());
        }

        if (posicion.getEstadoPosicion() == null) {
            posicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
        }

        UtilidadesLog.debug("unidades por atender");
        if (posicion.getUnidadesPorAtender()==null)
            posicion.setUnidadesPorAtender(new Long(0));

        UtilidadesLog.debug("unidades demanda real");
        if (posicion.getUnidadesDemandaReal()==null)
            posicion.setUnidadesDemandaReal(new Long(0));

        UtilidadesLog.debug("unidades demandadas");
        if (posicion.getUnidadesDemandadas()==null)
            posicion.setUnidadesDemandadas(new Long(0));

        UtilidadesLog.debug("unidades demandadas 2");
        if ((posicion.getUnidadesDemandadas() == null || posicion.getUnidadesDemandadas().longValue() == 0) && 
                (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
            posicion.setUnidadesDemandadas(posicion.getUnidadesPorAtender());
        }

        UtilidadesLog.debug("unidades por atender 2");
        if ((posicion.getUnidadesDemandadas() != null && posicion.getUnidadesDemandadas().longValue() != 0) && 
                (posicion.getUnidadesPorAtender() == null || posicion.getUnidadesPorAtender().longValue() == 0)) {
            posicion.setUnidadesPorAtender(posicion.getUnidadesDemandadas());
        }

        UtilidadesLog.debug("unidades demanda real 2");
        if ((posicion.getUnidadesDemandaReal() == null || posicion.getUnidadesDemandaReal().longValue() == 0) && 
                (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
            posicion.setUnidadesDemandaReal(posicion.getUnidadesPorAtender());
        }
        
        UtilidadesLog.debug("unidades comprometidas");
        posicion.setUnidadesComprometidas(posicion.getUnidadesDemandaReal());

        UtilidadesLog.debug("precio catalogo unitario");
        if (posicion.getPrecioCatalogo() != null)
            posicion.setPrecioCatalogoUnitarioLocal(posicion.getPrecioCatalogo());
        else    
          posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal("0"));
    
            UtilidadesLog.debug("precio contable unitario");
        if (posicion.getPrecioContableUnitarioLocal() == null)
          posicion.setPrecioContableUnitarioLocal(new BigDecimal("0"));
    
            UtilidadesLog.debug("precio catalogo unitario documento");
        if (posicion.getPrecioCatalogoUnitarioDocumento() == null)
          posicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal("0"));
    
            UtilidadesLog.debug("precio contable unitario documento");
        if (posicion.getPrecioContableUnitarioDocumento() == null)
          posicion.setPrecioContableUnitarioDocumento(new BigDecimal("0"));

        UtilidadesLog.debug("if forma pago");
        if (posicion.getFormaPago() == null) {
        
            UtilidadesLog.debug("forma pago es null");
        
            String codigoVenta = posicion.getCodigoVenta();
            DTOSValidarCodigoVenta dtoSVCV = null;

            UtilidadesLog.debug("antes de hashCodigosVenta.get");
            
            if (hashCodigosVenta != null){
                dtoSVCV = (DTOSValidarCodigoVenta)hashCodigosVenta.get(codigoVenta != null ? codigoVenta.toString() : null);
            }

            UtilidadesLog.debug("despues de hashCodigosVenta.get");
            
            if (dtoSVCV != null){
                posicion.setFormaPago(dtoSVCV.getOidFormaPago());
            }
        } 
        UtilidadesLog.debug("antes de pos.set");
        
        DTOFormasPago dtoFP = null;
        
        if (!(posicion.getCodFormaPago() == null)) {
            if (hashFormasDePago != null){
                UtilidadesLog.debug("busco fp: " + posicion.getCodFormaPago().trim().toString());
                dtoFP = (DTOFormasPago)hashFormasDePago.get(posicion.getCodFormaPago().trim().toString());
                if (dtoFP != null){
                    posicion.setFormaPago(dtoFP.getOidFP());
                }else{
                    UtilidadesLog.debug("NO, forma de pago!");
                    LogAPP.info("La posicion tiene una forma de pago no existente, se invalida.");
                    posicion.setOK(Boolean.FALSE);
                }    
            }
            
        }
        DTOCodProducto dtoCP = null;
        
        if (!(posicion.getCodigoProducto() == null)) {
            if (hashCodigosDeProducto != null){
                UtilidadesLog.debug("busco cp: " + posicion.getCodigoProducto().trim().toString());
                dtoCP = (DTOCodProducto)hashCodigosDeProducto.get(posicion.getCodigoProducto().trim().toString());
                if (dtoCP != null){
                    posicion.setProducto(dtoCP.getOidProd());
                    posicion.setOidProducto(dtoCP.getOidProd());
                }else{
                    UtilidadesLog.debug("NO, codigo de producto!");
                    LogAPP.info("La posicion tiene un codigo de producto inexistente, se invalida.");
                    posicion.setOK(Boolean.FALSE);
                }    
            }
        }
        pos.set(linea.intValue(), posicion);
        
        UtilidadesLog.debug("despues de pos.set");
        
        dtoCabecera.setPosiciones(pos);
        UtilidadesLog.info("MONOCRBean.completarPosicion(completarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, " +
                           "HashMap hashCodigosVenta, HashMap hashFormasDePago, HashMap hashCodigosDeProducto): Salida 1 ");
        return dtoCabecera;
    }
    
    
    private Long obtenerSiguienteNumeroPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea){
     Long salida = new Long("-1");
     //buscamos el ultimo numero de linea de la solicitud, recorriendo las posiciones validas
     //a partir del numero de linea indicado y hacia atras.
     
     ArrayList pos = dtoCabecera.getPosiciones();
     DTOPosicionSolicitud posicion = null;
     int lineaActual = linea.intValue()-1;

     //doliva -- cambio Optimizacion Logs -- 24/03/2010
     if(logAux.isInfoEnabled()) {
         UtilidadesLog.info("MONOCRBean.obtenerSiguienteNumeroPosicion, linea : " + linea);
         UtilidadesLog.info("MONOCRBean.obtenerSiguienteNumeroPosicion, lineaActual : " + lineaActual);
     }
    
     while(lineaActual >= 0){
        posicion = (DTOPosicionSolicitud) pos.get(lineaActual);
         if(posicion.getNumeroPosicion()!=null){
             salida = posicion.getNumeroPosicion();
             lineaActual=-1;
         }else{
           lineaActual-=1;  
         }
     }
     //doliva -- cambio Optimizacion Logs -- 24/03/2010
     if(logAux.isInfoEnabled()) {
        UtilidadesLog.info("MONOCRBean.obtenerSiguienteNumeroPosicion, salida : " + salida);
     }
     return salida;
    }
    
    private DTOOCRCadenasInsercionSolicitudes generarStringInsercionSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.generarStringInsercionSolicitud(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        DTOOCRCadenasInsercionSolicitudes dtoOCRCadenasInsercionSolicitudes = new DTOOCRCadenasInsercionSolicitudes();
        if (!dtoCabecera.getOK().booleanValue()){
            boolean algunaValida = false;
            for(int i = 0 ; i < dtoCabecera.getPosiciones().size(); i++){
                DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud)dtoCabecera.getPosiciones().get(i);
                if (dtoPos.getOK()==null || dtoPos.getOK().booleanValue()){
                    algunaValida = true;
                }
            }
            if (!algunaValida){
                return dtoOCRCadenasInsercionSolicitudes;
            }
        }
      
      if (dtoCabecera.getNumeroSolicitud() == null || dtoCabecera.getNumeroSolicitud().equals("")) {      
        try {
            dtoCabecera = this.getMONOCRLocal().generaNumeroSolicitudCabecera(dtoCabecera);
        } catch(Exception e){
            UtilidadesLog.error("ERROR", e);
            UtilidadesLog.debug("Error al Recuperar el Numero de Solicitud");            
        }   
      } 

      dtoCabecera.setGrupoProcesos( ConstantesPED.GP1 ); 
  
      StringBuffer cadenaInsercionSolicitudCabecera = new StringBuffer();
      
      StringBuffer buff = this.generarStringInsercionSolicitudCabecera(dtoCabecera);
      if(buff.length()==0){
         dtoOCRCadenasInsercionSolicitudes.setCadenaInsercionSolicitudCabecera(null);
         return dtoOCRCadenasInsercionSolicitudes;
      }      
      cadenaInsercionSolicitudCabecera.append(buff);
      cadenaInsercionSolicitudCabecera.append(this.generarStringInsercionValoresDefectoCabecera(dtoCabecera.getOidCabeceraSolicitud(),
                              dtoCabecera.getTipoSolicitud(), dtoCabecera.getModulo()));
                              

      buff = this.generarStringInsercionSolicitudPosicion(dtoCabecera);
      if(buff.length()==0){
         dtoOCRCadenasInsercionSolicitudes.setCadenaInsercionSolicitudCabecera(null); 
         return dtoOCRCadenasInsercionSolicitudes;
      }
      
      RecordSet valoresDefectoPosicion;
      valoresDefectoPosicion = this.recuperarValoresDefectoPosicion(dtoCabecera.getTipoSolicitud(), dtoCabecera.getModulo());
      cadenaInsercionSolicitudCabecera.append(buff);       
      
      cadenaInsercionSolicitudCabecera.append(this.generarStringInsercionValoresDefectoPosicion(dtoCabecera.getOidCabeceraSolicitud(), valoresDefectoPosicion));                 
      dtoOCRCadenasInsercionSolicitudes.setCadenaInsercionSolicitudCabecera(cadenaInsercionSolicitudCabecera);
     
      UtilidadesLog.info("MONOCRBean.generarStringInsercionSolicitud(DTOCabeceraSolicitud dtoCabecera): Salida ");
      return dtoOCRCadenasInsercionSolicitudes;
    }
    
    
/*     private DTOCabeceraSolicitud generarNumeroSolicitud(DTOCabeceraSolicitud dtoCabecera) throws MareException{
      UtilidadesLog.info("MONOCRBean.generarNumeroSolicitud(DTOCabeceraSolicitud dtoCabecera): Entrada ");
      
      DTONumeroSolicitud dtoNSolicitud = new DTONumeroSolicitud();
      dtoNSolicitud.setOidCanal( dtoCabecera.getCanal() );
      dtoNSolicitud.setOidAcceso( dtoCabecera.getAcceso() );
      dtoNSolicitud.setOidSubacceso( dtoCabecera.getSubacceso() );
      dtoNSolicitud.setOperacion( ConstantesBEL.COD_PED001 );
      dtoNSolicitud.setOidPais(dtoCabecera.getOidPais());
      dtoNSolicitud.setOidIdioma(dtoCabecera.getOidIdioma());
      
      dtoCabecera.setNumeroSolicitud( this.generaNumeroDocumento(dtoNSolicitud) );
      UtilidadesLog.warn("Numero Solicitud Generado por Viejo Proc ---> " + dtoCabecera.getNumeroSolicitud());
      UtilidadesLog.info("MONOCRBean.generarNumeroSolicitud(DTOCabeceraSolicitud dtoCabecera): Salida ");
      return dtoCabecera;	
    }
*/    
    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        UtilidadesLog.info("MONOCRBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Entrada ");
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        UtilidadesLog.info("MONOCRBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Salida ");
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }
/*
    private String generaNumeroDocumento(DTONumeroSolicitud dto) throws MareException {
      UtilidadesLog.info("MONOCRBean.generaNumeroDocumento(DTONumeroSolicitud dto): Entrada ");
     	try{
            MONProcesosPEDHome mpPEDHome = (MONProcesosPEDHome) UtilidadesEJB.getHome("MONProcesosPED",	MONProcesosPEDHome.class);
            MONProcesosPED mpPED = mpPEDHome.create();
            return  mpPED.generaNumeroDocumento(dto) ;
      }catch(CreateException ce){
        UtilidadesLog.debug(ce);
        throw new MareException(ce,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(RemoteException re){
        UtilidadesLog.debug(re);
        throw new MareException(re,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(Exception e){
        UtilidadesLog.debug(e);
        throw new MareException(e,
      UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
   }
*/  
    private Boolean validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso) throws MareException {
      UtilidadesLog.info("MONOCRBean.validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Entrada ");
      RecordSet respuesta;
      StringBuffer query = new StringBuffer();
        
      query.append(" SELECT proc_oid_proc  ");   
      query.append(" FROM (SELECT   s.proc_oid_proc  ");   
      query.append("         FROM ped_secue_proce s  ");   
      query.append("        WHERE s.grpr_oid_grup_proc = "  + grupoProcesos);   
      query.append("          AND s.tspa_oid_tipo_soli_pais = " + tipoSolicitud);   
      query.append("     ORDER BY cod_secu DESC)  ");   
      query.append(" WHERE ROWNUM = 1        ");   
        
      respuesta = this.executeQuery(query.toString());
  
      UtilidadesLog.info("MONOCRBean.validarUltimoProceso(Long tipoSolicitud, Long grupoProcesos, Long proceso): Salida ");
      if (respuesta.esVacio())  
          return new Boolean(false);    
      else
        if (((BigDecimal)respuesta.getValueAt(0,0)).intValue() == proceso.intValue()) 
            return new Boolean(true);
        else
            return new Boolean(false);
   }
   
     private StringBuffer generarStringInsercionSolicitudCabecera (DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.guardarCabecera(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        
        dtoCabecera.setOidCabeceraSolicitud(SecuenciadorOID.obtenerSiguienteValor("PED_SOCA_SEQ"));
        
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");        

        StringBuffer query = new StringBuffer();
                
        query.append("INSERT INTO PED_SOLIC_CABEC ( ");
        query.append(" ACFI_OID_ACCE_FISI, ");
        query.append(" ALMC_OID_ALMA, ");
        query.append(" CLDI_OID_CLIE_DIRE, ");
        query.append(" CLIE_OID_CLIE, ");
        query.append(" CLIE_OID_CLIE_DEST, ");
        query.append(" CLIE_OID_CLIE_PAGA, ");
        query.append(" CLIE_OID_CLIE_RECE_FACT, ");
        query.append(" CLIE_OID_CONS_ASOC, ");
        query.append(" CLSO_OID_CLAS_SOLI, ");
        query.append(" COPA_OID_PARA_GENE, ");
        query.append(" ESSO_OID_ESTA_SOLI, ");
        query.append(" FEC_CRON, ");
        query.append(" FEC_PROG_FACT, ");
        query.append(" FOPA_OID_FORM_PAGO, ");
        query.append(" GRPR_OID_GRUP_PROC, ");
        query.append(" IND_OC, ");
        query.append(" IND_PEDI_PRUE, ");
        query.append(" IND_PERM_UNIO_SOL, ");
        query.append(" IND_TS_NO_CONSO, ");
        query.append(" MODU_OID_MODU, ");
        query.append(" MONE_OID_MONE, ");
        query.append(" NUM_CLIEN, ");
        query.append(" NUM_DOCU_ORIG, ");
        query.append(" NUM_PREM, ");
        query.append(" OID_SOLI_CABE, ");
        query.append(" OPER_OID_OPER, ");
        query.append(" PAIS_OID_PAIS, ");
        query.append(" PERD_OID_PERI, ");
        query.append(" PROC_OID_PROC, ");
        query.append(" SBAC_OID_SBAC, ");
        query.append(" SBTI_OID_SUBT_CLIE, ");
        query.append(" SOCA_OID_DOCU_REFE, ");
        query.append(" SOCI_OID_SOCI, ");
        query.append(" TDOC_OID_TIPO_DOCU, ");
        query.append(" TERR_OID_TERR, ");
        query.append(" TICL_OID_TIPO_CLIE, ");
        query.append(" TIDO_OID_TIPO_DOCU, ");
        query.append(" TIDS_OID_TIPO_DESP, ");
        query.append(" TSPA_OID_TIPO_SOLI_PAIS, ");
        query.append(" TSPA_OID_TIPO_SOLI_PAIS_CONS, ");
        query.append(" VAL_GLOS_OBSE, ");
        query.append(" VAL_NUME_SOLI, ");
        query.append(" VAL_USUA, ");
        query.append(" VEPO_OID_VALO_ESTR_GEOP, ");
        query.append(" VAL_TIPO_CAMB, ");
        query.append(" ZZON_OID_ZONA, ");
        query.append(" ZTAD_OID_TERR_ADMI, ");            
        query.append(" ICTP_OID_TIPO_PROG ");
        query.append(" ) VALUES ( ");
        query.append(dtoCabecera.getAccesoFisico() + ", ");
        query.append(dtoCabecera.getAlmacen() + ", ");
        query.append(dtoCabecera.getDestino() + ", ");
        query.append(dtoCabecera.getOidCliente() + ", ");
        query.append(dtoCabecera.getDestinatario() + ", ");
        query.append(dtoCabecera.getOidPagadorFactura() + ", ");
        query.append(dtoCabecera.getOidReceptorFactura() + ", ");
        query.append(dtoCabecera.getConsultoraAsociada() + ", ");
        query.append(dtoCabecera.getClaseSolicitud() + ", ");
        query.append(dtoCabecera.getOidConcursoParametros() + ", ");
        query.append(dtoCabecera.getEstado() + ", ");
        query.append(" TO_Date( '" + simpledateformat.format(dtoCabecera.getFecha()) + "', 'DD-MM-YYYY'), ");
        query.append(" TRUNC(TO_DATE (substr('" + dtoCabecera.getFechaPrevistaFacturacion() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')),  ");
        query.append(dtoCabecera.getFormaPago() + ", ");
        if (dtoCabecera.getIndMonetariasOCR().booleanValue()) {
          query.append(ConstantesPED.GP4 + ", ");
        } else {
          query.append(ConstantesPED.GP1 + ", ");
        }
        query.append(this.booleanToLong(dtoCabecera.getOrdenCompra()) + ", ");
        query.append(this.booleanToLong(dtoCabecera.getIndPedidoPrueba()) + ", ");
        query.append(this.booleanToLong(dtoCabecera.getPermiteUnionSolicitudes()) + ", ");
        query.append(this.booleanToLong(dtoCabecera.getIndTSNoConsolidado()) + ", ");
        query.append(dtoCabecera.getModulo() + ", ");
        query.append(dtoCabecera.getMoneda() + ", ");
        query.append(dtoCabecera.getNumeroClientes() + ", ");
        query.append(dtoCabecera.getNumeroDocumentoOrigen() + ", ");
        query.append(dtoCabecera.getNumeroPremio() + ", ");
        query.append(dtoCabecera.getOidCabeceraSolicitud() + ", ");
        query.append(dtoCabecera.getOperacion() + ", ");
        query.append(dtoCabecera.getOidPais() + ", ");
        query.append(dtoCabecera.getPeriodo() + ", ");
        query.append(dtoCabecera.getProceso() + ", ");
        query.append(dtoCabecera.getSubacceso() + ", ");
        query.append(dtoCabecera.getSubtipoCliente() + ", ");
        query.append(dtoCabecera.getOidDocumentoReferencia() + ", ");
        query.append(dtoCabecera.getSociedad() + ", ");
        query.append(dtoCabecera.getTipoDocumento() + ", ");
        query.append(dtoCabecera.getTerritorio() + ", ");
        query.append(dtoCabecera.getTipoCliente() + ", ");
        query.append(dtoCabecera.getTipoDocumentoLegal() + ", ");
        query.append(dtoCabecera.getTipoDespacho() + ", ");
        query.append(dtoCabecera.getTipoSolicitud() + ", ");
        query.append(dtoCabecera.getTipoConsolidado() + ", ");
        query.append("'" + dtoCabecera.getObservaciones() + "', ");
        query.append(dtoCabecera.getNumeroSolicitud() + ", ");
        query.append("'" + dtoCabecera.getUsuario() + "', ");
        query.append(dtoCabecera.getUbigeo() + ", ");
        query.append(dtoCabecera.getTipoCambio() + ", ");
        query.append(dtoCabecera.getZona() + ", ");
        query.append(dtoCabecera.getOidTerritorioAdministrativo() + ",");
        query.append(dtoCabecera.getOidTipoProgramaIncentivos());
        query.append(");");        

        UtilidadesLog.info("DAOSolicitud.guardarCabecera(DTOCabeceraSolicitud DTOE): Salida ");
        return query;
    }

    private Long booleanToLong(Boolean valor) {
        if (valor != null) {
            if (valor.booleanValue()) {
                return new Long(1);
            } else {
                return new Long(0);
            }
        }
        return null;
    }

    private StringBuffer generarStringInsercionValoresDefectoCabecera(Long oidCabeceraSolicitud, Long oidTipoSolicitud, Long oidModulo) throws MareException {
        UtilidadesLog.info("MONOCRBean.generarStringInsercionValoresDefectoCabecera(Long oidCabeceraSolicitud, Long oidTipoSolicitud, Long oidModulo): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        StringBuffer cadenaUpdate = new StringBuffer();
        ArrayList campos = new ArrayList();

        query.append(" SELECT ate.cod_atri, vd.val_defe_oid, vd.val_valo_defe      ");
        query.append("   FROM ped_atrib_espec ate, ped_valor_defec_tipo_solic vd   ");
        query.append("  WHERE ate.modu_oid_modu = " + oidModulo);
        query.append("    AND ate.val_form = 'PED_SOLIC_CABEC' ");
        query.append("    AND vd.tspa_oid_tipo_soli_pais = " + oidTipoSolicitud);
        query.append("    AND vd.atre_oid_atri_espe = ate.oid_atri_espe ");

        respuesta = this.executeQuery(query.toString());

        if (!respuesta.esVacio()) {
            ArrayList PK = new ArrayList();
            PK.add(new String("OID_SOLI_CABE"));
            PK.add(new String(oidCabeceraSolicitud.toString()));
            campos.add(PK);

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArrayList atributo = new ArrayList();
                atributo.add((String) respuesta.getValueAt(i, 0));

                if (respuesta.getValueAt(i, 1) != null) {
                    String oidValor = ((BigDecimal) respuesta.getValueAt(i, 1)).toString();
                    atributo.add(oidValor);
                } else if (respuesta.getValueAt(i, 2) != null) {
                    String valor = (String) respuesta.getValueAt(i, 2);
                    atributo.add(valor);
                }

                campos.add(atributo);
            }

            HashSet camposFecha = obtenerCamposFechaCabeceraSolicitud();
            cadenaUpdate = this.generarStringActualizacionValoresDefectoBBDD("PED_SOLIC_CABEC", campos, camposFecha);
        }
        UtilidadesLog.info("MONOCRBean.generarStringInsercionValoresDefectoCabecera(Long oidCabeceraSolicitud, Long oidTipoSolicitud, Long oidModulo): Salida ");
        return cadenaUpdate;
    }
    
    private HashSet obtenerCamposFechaCabeceraSolicitud() {
        UtilidadesLog.info("MONOCRBean.obtenerCamposFechaCabeceraSolicitud(): Entrada ");
        HashSet camposFecha = new HashSet();
        camposFecha.add("FEC_PROG_FACT");
        camposFecha.add("FEC_FACT");
        camposFecha.add("FEC_CRON");
        camposFecha.add("FEC_REPO_FALT");
        UtilidadesLog.info("MONOCRBean.obtenerCamposFechaCabeceraSolicitud(): Salida ");
        return camposFecha;
    }
    
    private StringBuffer generarStringActualizacionValoresDefectoBBDD(String entidad, ArrayList campos,
        HashSet camposFecha) throws MareException {        
        UtilidadesLog.info("MONOCRBean.generarStringActualizacionValoresDefectoBBDD(String entidad, ArrayList campos, HashSet camposFecha): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet rsSolicitudOidPeriodo;

        query.append("UPDATE " + entidad);
        query.append("   SET  ");

        for (int i = 1; i < campos.size(); i++) {
            ArrayList atributo = (ArrayList) campos.get(i);
            String nombreCampo = (String) atributo.get(0);
            String valor = (String) atributo.get(1);

            if ((camposFecha != null) && (camposFecha.contains(nombreCampo))) {
                query.append("  " + nombreCampo + "  = TO_DATE('" + valor +"','dd/MM/yyyy'),");
            } else {
                query.append("  " + nombreCampo + "  = '" + valor + "',");
            }
        }

        query.deleteCharAt(query.length() - 1);

        ArrayList PK = (ArrayList) campos.get(0);
        String oidCampo = (String) PK.get(0);
        String oidValor = (String) PK.get(1);
        query.append("   WHERE " + oidCampo + " = " + oidValor);
        query.append(";");
        
        UtilidadesLog.info("MONOCRBean.generarStringActualizacionValoresDefectoBBDD(String entidad, ArrayList campos, HashSet camposFecha): Salida ");
        return query;
    }

    private RecordSet recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo) throws MareException {
      UtilidadesLog.info("MONOCRBean.recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo): Entrada ");
      RecordSet respuesta;
      StringBuffer query = new StringBuffer();
      ArrayList campos = new ArrayList();

      query.append(" SELECT ate.cod_atri, vd.val_defe_oid, vd.val_valo_defe      ");
      query.append("   FROM ped_atrib_espec ate, ped_valor_defec_tipo_solic vd   ");
      query.append("  WHERE ate.modu_oid_modu = " + oidModulo);
      query.append("    AND ate.val_form = 'PED_SOLIC_POSIC' ");
      query.append("    AND vd.tspa_oid_tipo_soli_pais = " + oidTipoSolicitud);
      query.append("    AND vd.atre_oid_atri_espe = ate.oid_atri_espe ");

      respuesta = this.executeQuery(query.toString());

      UtilidadesLog.info("MONOCRBean.recuperarValoresDefectoPosicion(Long oidTipoSolicitud, Long oidModulo): Salida ");
      return respuesta;
    }
    
    
    private StringBuffer generarStringInsercionSolicitudPosicion(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOCabeceraSolicitud dtoCabecera): Entrada ");
        StringBuffer query = new StringBuffer();        
        ArrayList posiciones = dtoCabecera.getPosiciones();
        for (int linea=0; linea < posiciones.size(); linea++){ 
            DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) posiciones.get(linea);            
            if(( dtoPos.getOK()!=null && !dtoPos.getOK().booleanValue() )){
               LogAPP.info("[OCR] La Posicion de la solicitud no es Valida(No existe producto/codigo de venta) ---> codigo de venta: " 
                  + dtoPos.getCodigoVenta() + " Oid producto: " + dtoPos.getProducto()
                  + " Solicitud: " + dtoCabecera.getOidCabeceraSolicitud() );
               continue;
            }
            query.append("INSERT INTO PED_SOLIC_POSIC ( ");
            query.append(" OID_SOLI_POSI, ");
            query.append(" SOCA_OID_SOLI_CABE, ");
            query.append(" COD_POSI, ");
            query.append(" NUM_UNID_DEMA, ");
            query.append(" NUM_UNID_POR_ATEN, ");
            query.append(" TPOS_OID_TIPO_POSI, ");
            query.append(" PROD_OID_PROD, ");
            query.append(" FOPA_OID_FORM_PAGO, ");
            query.append(" VAL_CODI_VENT, ");
            query.append(" ESPO_OID_ESTA_POSI, ");
            query.append(" STPO_OID_SUBT_POSI, ");
            query.append(" VAL_CODI_VENT_FICT, ");
            query.append(" NUM_UNID_DEMA_REAL, ");
            query.append(" VAL_PREC_CATA_UNIT_LOCA, ");
            query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
            query.append(" VAL_PREC_CATA_UNIT_DOCU, ");
            query.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
            query.append(" VAL_PORC_DESC, ");
            query.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
            query.append(" OFDE_OID_DETA_OFER, ");
            query.append(" SOPO_OID_SOLI_POSI, ");
            query.append(" NUM_UNID_COMPR, ");
            query.append(" IND_NO_IMPR ");
            query.append(" ) VALUES ( ");
            query.append("PED_SOPO_SEQ.NEXTVAL, ");
            query.append(dtoCabecera.getOidCabeceraSolicitud() + ", ");
            query.append(dtoPos.getNumeroPosicion() + ", ");
            query.append(dtoPos.getUnidadesDemandadas() + ", ");
            query.append(dtoPos.getUnidadesPorAtender() + ", ");
            query.append(dtoPos.getTipoPosicion() + ", ");
            query.append(dtoPos.getProducto() + ", ");
            query.append(dtoPos.getFormaPago() + ", ");
            query.append( ((dtoPos.getCodigoVenta() != null) ? ("'" + dtoPos.getCodigoVenta() + "'") : null) + ", " );
            query.append(dtoPos.getEstadoPosicion() + ", ");
            query.append(dtoPos.getSubtipoPosicion() + ", ");
            query.append(dtoPos.getCodigoVentaFicticio() + ", ");
            query.append(dtoPos.getUnidadesDemandaReal() + ", ");
            query.append(dtoPos.getPrecioCatalogoUnitarioLocal() + ", ");
            query.append(dtoPos.getPrecioContableUnitarioLocal() + ", ");
            query.append(dtoPos.getPrecioCatalogoUnitarioDocumento() + ", ");
            query.append(dtoPos.getPrecioContableUnitarioDocumento() + ", ");
            query.append(dtoPos.getPorcentajeDescuento() + ", ");
            query.append(dtoPos.getImporteDescuentoUnitarioDocumento() + ", ");
            query.append(dtoPos.getOidDetalleOferta() + ", ");
            query.append(dtoPos.getPosicionRecuperacion() + ", ");
            query.append(dtoPos.getUnidadesComprometidas());
            query.append(", (select count(*) from	FAC_TIPO_OFERT_EXCLU f, pre_ofert_detal d ");
            query.append("	where d.OID_DETA_OFER = "+dtoPos.getOidDetalleOferta()+" AND	d.TOFE_OID_TIPO_OFER = f.TOFE_OID_TIPO_OFER AND ");
            query.append("	ROWNUM = 1)");
            query.append(");");
       
        } 
        UtilidadesLog.info("DAOSolicitud.guardarPosicion(DTOCabeceraSolicitud dtoCabecera): Salida ");
        return query;
    }

    private StringBuffer generarStringInsercionValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta) throws MareException {
        UtilidadesLog.info("MONOCRBean.asignarValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta): Entrada ");
        ArrayList campos = new ArrayList();
        StringBuffer cadenaUpdate = new StringBuffer();

        if (!respuesta.esVacio()) {
            ArrayList PK = new ArrayList();
            PK.add(new String("SOCA_OID_SOLI_CABE"));
            PK.add(new String(oidCabeceraSolicitud.toString()));
            campos.add(PK);

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArrayList atributo = new ArrayList();
                atributo.add((String) respuesta.getValueAt(i, 0));

                if (respuesta.getValueAt(i, 1) != null) {
                    String oidValor = ((BigDecimal) respuesta.getValueAt(i, 1)).toString();
                    atributo.add(oidValor);
                } else if (respuesta.getValueAt(i, 2) != null) {
                    String valor = (String) respuesta.getValueAt(i, 2);
                    atributo.add(valor);
                }
                campos.add(atributo);
            }
            cadenaUpdate = this.generarStringActualizacionValoresDefectoBBDD("PED_SOLIC_POSIC", campos, null);
        }
        UtilidadesLog.info("MONOCRBean.asignarValoresDefectoPosicion(Long oidCabeceraSolicitud, RecordSet respuesta): Salida ");        
        return cadenaUpdate;
    }

  public DTOOCRCadenasInsercionSolicitudes cargarSolicitud(DTOCabeceraSolicitud dtoS) throws MareException {
    UtilidadesLog.info("MONOCRBean.cargarSolicitud(DTOCabeceraSolicitud dtoS): Entrada");        
        DTOOCRCadenasInsercionSolicitudes dtoOCRCadenasInsercionSolicitudes = new DTOOCRCadenasInsercionSolicitudes();
        long beginT = System.currentTimeMillis();
        dtoOCRCadenasInsercionSolicitudes = this.generaSolicitud(dtoS);
        long endT = System.currentTimeMillis();
        //UtilidadesLog.warn("Genera Solicitud -------------------> " + (endT - beginT));
        UtilidadesLog.info("MONOCRBean.cargarSolicitud(DTOCabeceraSolicitud dtoS): Salida");
        return dtoOCRCadenasInsercionSolicitudes;
  }

  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }
  
  private DTOCabeceraSolicitud validarAlmacen(DTOCabeceraSolicitud dtoCabecera) 
		throws MareException {
      UtilidadesLog.info("MONOCRBean.validarAlmacen(DTOCabeceraSolicitud DTOE) : Entrada ");
      Long oidAlmacen = dtoCabecera.getAlmacen();              
        
        if (oidAlmacen == null){
     				dtoCabecera = validacionKO(dtoCabecera);
            UtilidadesLog.info("No existe Almacen en Tipo de Solicitus Pais");
            UtilidadesLog.info("MONOCRBean.validarAlmacen(DTOCabeceraSolicitud DTOE) : Salida ");
    				return dtoCabecera;
        }
      UtilidadesLog.info("MONOCRBean.validarAlmacen(DTOCabeceraSolicitud DTOE) : Salida ");
      return dtoCabecera;
  }
  
  private HashMap obtenerOidsModulos ( Long codModuloOCR, Long codModuloNDG) throws MareException {
    StringBuffer query = new StringBuffer();
    query.append(" SELECT OID_MODU, COD_MODU ");
    query.append(" FROM SEG_MODUL ");
    query.append(" WHERE COD_MODU IN ('" + codModuloOCR + "','" + codModuloNDG + "')");
    
    RecordSet rs = null;
    HashMap oidsModulo = new HashMap();
    
    rs = this.executeQuery(query.toString());
    
    if (!(rs == null) && !(rs.esVacio())){
      for (int i = 0; i < rs.getRowCount(); i++) {
        oidsModulo.put((String)(rs.getValueAt(i,"COD_MODU")), this.bigDecimalToLong(rs.getValueAt(i,"OID_MODU")));
      }
    }
    return oidsModulo;  
  }




 private HashMap obtenerOidPais(ArrayList codPais) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerOidPais(String codPais): Entrada");
    RecordSet rs = null;
    StringBuffer query = new StringBuffer();
    query.append( "SELECT PAIS.OID_PAIS, PAIS.COD_PAIS  ");
    query.append( " FROM SEG_PAIS PAIS ");        
    query.append( "WHERE UPPER(COD_PAIS) IN ('");
    Iterator it = codPais.iterator();
    while (it.hasNext()){      
      query.append(((String)it.next()).toString().toUpperCase());
      if (it.hasNext()){
        query.append("','");
      }
    }   
    query.append("')"); 
    
    rs = this.executeQuery(query.toString());   
    
    HashMap oidPais = new HashMap();    
    if (!(rs == null) && !(rs.esVacio())){
      for (int i=0;i<rs.getRowCount();i++){
        oidPais.put((String)rs.getValueAt(i,"COD_PAIS"),this.bigDecimalToLong(rs.getValueAt(i,"OID_PAIS")));
      }
    }
    UtilidadesLog.info("MONOCRBean.obtenerOisPais(String codPais): Salida");
    return oidPais;    
  }
  
  private HashMap obtenerDatosValoresDeReferencia(HashMap hashSolicCabecDatosReferencia, ArrayList arrayKeysDatosReferencia) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerDatosValoresDeReferencia(HashMap hashSolicCabecDatosReferencia): Entrada"); 
    StringBuffer query = new StringBuffer();
    RecordSet rs = null;
    HashMap hashDatos = new HashMap();
    if (!hashSolicCabecDatosReferencia.isEmpty()){
        query.append(" SELECT CAN.OID_CANA, ");
        query.append("        ACC.OID_ACCE, ");
        query.append("        SUB.OID_SBAC, ");
        query.append("        can.COD_CANA, ");
        query.append("        acc.COD_ACCE, ");
        query.append("        sub.COD_SBAC,  ");       
        query.append("        psc.OID_SOLI_CABE, ");
        query.append("        psc.val_nume_soli ");
        query.append(" FROM SEG_CANAL CAN, SEG_ACCES ACC, SEG_SUBAC SUB, PED_SOLIC_CABEC PSC ");
        query.append(" WHERE acc.CANA_OID_CANA = can.OID_CANA AND ");
        query.append(" sub.ACCE_OID_ACCE = acc.OID_ACCE AND ");
        query.append(" PSC.SBAC_OID_SBAC = SUB.OID_SBAC and (");      
        query.append(this.generarFiltroTipoSolicitudPorValoresDeReferncia(hashSolicCabecDatosReferencia, arrayKeysDatosReferencia).toString());
        query.append(")");
        
        rs = this.executeQuery(query.toString());   
        
        if (!(rs == null) && !(rs.esVacio())){
           for (int i=0;i<rs.getRowCount();i++){
             String keyHash;
             keyHash = (String)rs.getValueAt(i,"COD_CANA") + "-" + (String)rs.getValueAt(i,"COD_ACCE") + "-" +
                       (String)rs.getValueAt(i,"COD_SBAC") + "-" + UtilidadesBD.convertirALong(rs.getValueAt(i,"VAL_NUME_SOLI"));             
             DTODatosTipoSolicitudOCR dtoDatos = new DTODatosTipoSolicitudOCR();
             dtoDatos.setOidCanal(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_CANA")));
             dtoDatos.setOidAcceso(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_ACCE")));
             dtoDatos.setOidSubacceso(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_SBAC")));
             dtoDatos.setOidSolicitudReferenciada(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_SOLI_CABE")));
             dtoDatos.setCodigoSubacceso(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_SBAC") ) );
             hashDatos.put(keyHash,dtoDatos);             
           }
        }
    }
    
    UtilidadesLog.info("MONOCRBean.obtenerDatosValoresDeReferencia(HashMap hashSolicCabecDatosReferencia): Salida"); 
    return hashDatos;   
  }   
  
  private StringBuffer generarFiltroTipoSolicitudPorValoresDeReferncia(HashMap hashSolicCabecDatosReferencia, ArrayList arrayKeysDatosReferencia) {
    StringBuffer filtro = new StringBuffer();
    Iterator itKeys = arrayKeysDatosReferencia.iterator();
    boolean primerCiclo=true;
    while (itKeys.hasNext()) {
      String keyDatosRefe = (String)itKeys.next();
      ArrayList arrayDatosReferencia = (ArrayList)hashSolicCabecDatosReferencia.get(keyDatosRefe);
      DTOCargaIncialOCR dtoCargaInicial;
      dtoCargaInicial = (DTOCargaIncialOCR)arrayDatosReferencia.get(0);
      if(primerCiclo){
        filtro.append(" (");    
        primerCiclo=false;
      }else{
        filtro.append(" OR (");      
      }
      
      filtro.append(" CAN.cod_cana = '"     + dtoCargaInicial.getCodCana().toString() +"' ");
      filtro.append(" AND ACC.cod_acce = '" + dtoCargaInicial.getCodAcc().toString() +"' ");
	    filtro.append(" AND SUB.cod_sbac = '" + dtoCargaInicial.getCodSubacc().toString() +"' ");
      filtro.append(" AND (");
      Iterator itDatosRefe = arrayDatosReferencia.iterator();
      int count = 0;
      String docuRefe = "";
      while (itDatosRefe.hasNext()){
        dtoCargaInicial = (DTOCargaIncialOCR)itDatosRefe.next(); 
        if (count == 0) {
           docuRefe = dtoCargaInicial.getDocuRefe().toString();
        } else { 
           docuRefe += "," +  dtoCargaInicial.getDocuRefe().toString() + "";
        }
        if (count == 999)  {
           filtro.append(" PSC.VAL_NUME_SOLI IN ( " + docuRefe.toString() + ")  ");                     
           if (itDatosRefe.hasNext()){
             filtro.append("  OR ");
           }                    
           count = 0;
           docuRefe = "";
        } else {
           if (!itDatosRefe.hasNext()){
             filtro.append(" PSC.VAL_NUME_SOLI IN ( " + docuRefe.toString() + ") ");        
           }                    
           count++;            
        }           
        if (!itDatosRefe.hasNext()){              
          filtro.append(")");
        }
      } 
      filtro.append(")");      
    }
    return filtro;    
  }

  private HashMap obtenerDatosTipoSolicitud(HashMap hashTipoSolic) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerDatosTipoSolicitud(HashMap hashTipoSolic): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = null;
    HashMap hashDatos = new HashMap();
    
    if (!hashTipoSolic.isEmpty()){
        query.append(" SELECT PAIS.COD_PAIS, ");
        query.append("        PTS.COD_TIPO_SOLI, ");
        query.append("        PC.COD_PERI, ");
        query.append("        SUB.COD_SBAC, ");        
        query.append("        PTS.OID_TIPO_SOLI, ");
        query.append("        PTSP.OID_TIPO_SOLI_PAIS, ");
        query.append("        PTS.MARC_OID_MARC, ");
        query.append("        PTS.ACCE_OID_ACCE, ");
        query.append("        ACC.CANA_OID_CANA,  ");
        query.append("        PTS.TICL_OID_TIPO_CLIE,  ");
        query.append("        PER.OID_PERI,  ");
        query.append("        PTSP.MONE_OID_MONE, ");
        query.append("        PTSP.VAL_GLOS, ");
        query.append("        PTSP.TIDO_OID_TIPO_DOCU, ");
        query.append("        PTSP.FOPA_OID_FORM_PAGO, ");
        query.append("        PTS.CLSO_OID_CLAS_SOLI, ");
        query.append("        PCS.IND_ORDE_COMP, ");
        query.append("        PTSP.IND_PERM_UNIO, ");
        query.append("        PTSP.IND_PEDI_PRUE, ");
        query.append("        PTSP.TSOL_OID_TIPO_CONS,"); 
        query.append("        PTSP.SOCI_OID_SOCI, "); 
        query.append("        SUB.OID_SBAC, ");
        query.append("        PTSP.NUM_UNID_ALAR, ");
        query.append("        PTS.IND_SOLI_NEGA, ");
        query.append("        PTSP.ALMC_OID_ALMA, ");
        query.append("				( SELECT PROC_OID_PROC FROM ");
        query.append("         (SELECT S.PROC_OID_PROC, S.TSPA_OID_TIPO_SOLI_PAIS  FROM PED_SECUE_PROCE S ");
        query.append("        WHERE S.GRPR_OID_GRUP_PROC = 1");
        query.append("        ORDER BY COD_SECU DESC) ");
        query.append("        WHERE TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS");
  	    query.append("        AND ROWNUM = 1)  PROC, ");
        query.append("        (SELECT IND_EJEC_ONLI ");
        query.append("         FROM (SELECT S.IND_EJEC_ONLI, S.TSPA_OID_TIPO_SOLI_PAIS ");
        query.append("               FROM PED_SECUE_PROCE S ");
        query.append("               WHERE S.GRPR_OID_GRUP_PROC = 1 ");
        query.append("               ORDER BY COD_SECU) ");
        query.append("         WHERE TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
        query.append("         AND ROWNUM = 1) IND_ONLI ");      
        query.append(" FROM PED_TIPO_SOLIC PTS, ");
        query.append("      PED_TIPO_SOLIC_PAIS PTSP,"); 
        query.append("      SEG_ACCES ACC, ");
        query.append("      CRA_PERIO PER, ");
        query.append("      SEG_PERIO_CORPO PC, ");
        query.append("      PED_CLASE_SOLIC PCS,");
        query.append("      SEG_SUBAC SUB, ");
        query.append("      SEG_PAIS PAIS ");
        query.append(" WHERE PTS.OID_TIPO_SOLI = PTSP.TSOL_OID_TIPO_SOLI ");
        query.append("    AND PTS.ACCE_OID_ACCE = ACC.OID_ACCE ");
        query.append("    AND PER.PAIS_OID_PAIS = PTSP.PAIS_OID_PAIS ");
        query.append("    AND PER.MARC_OID_MARC = PTS.MARC_OID_MARC ");
        query.append("    AND PER.CANA_OID_CANA = ACC.CANA_OID_CANA ");
        query.append("    AND PC.OID_PERI = PER.PERI_OID_PERI     ");
        query.append("    AND PCS.OID_CLAS_SOLI = PTS.CLSO_OID_CLAS_SOLI");
        query.append("    AND SUB.ACCE_OID_ACCE = PTS.ACCE_OID_ACCE ");
        query.append("    AND PAIS.OID_PAIS = PTSP.PAIS_OID_PAIS ");
	      query.append(" AND (");
        query.append(this.generarFiltroTipoSolicitud(hashTipoSolic).toString());
    	  query.append(")"); 
 
        rs = this.executeQuery(query.toString());   
        
        if (!(rs == null) && !(rs.esVacio())){
           for (int i=0;i<rs.getRowCount();i++){
             String keyHash;
             keyHash = (String)rs.getValueAt(i,"COD_PAIS")+"-"+ (String)rs.getValueAt(i,"COD_TIPO_SOLI")+"-"+
                       (String)rs.getValueAt(i,"COD_PERI")+"-"+(String)rs.getValueAt(i,"COD_SBAC");             
             DTODatosTipoSolicitudOCR dtoDatos = new DTODatosTipoSolicitudOCR();
             dtoDatos.setOidTipoSolicitud(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_TIPO_SOLI")));
             dtoDatos.setOidTipoSolicitudPais(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_TIPO_SOLI_PAIS")));
             dtoDatos.setOidMarca(UtilidadesBD.convertirALong(rs.getValueAt(i,"MARC_OID_MARC")));
             dtoDatos.setOidAcceso(UtilidadesBD.convertirALong(rs.getValueAt(i,"ACCE_OID_ACCE")));
             dtoDatos.setOidCanal(UtilidadesBD.convertirALong(rs.getValueAt(i,"CANA_OID_CANA")));
             dtoDatos.setOidTipoCliente(UtilidadesBD.convertirALong(rs.getValueAt(i,"TICL_OID_TIPO_CLIE")));
             dtoDatos.setOidPeriodo(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_PERI")));
             dtoDatos.setOidMoneda(UtilidadesBD.convertirALong(rs.getValueAt(i,"MONE_OID_MONE")));
             dtoDatos.setOidTipoDocumento(UtilidadesBD.convertirALong(rs.getValueAt(i,"TIDO_OID_TIPO_DOCU")));
             dtoDatos.setOidFormaPago(UtilidadesBD.convertirALong(rs.getValueAt(i,"FOPA_OID_FORM_PAGO")));
             dtoDatos.setOidClaseSolicitud(UtilidadesBD.convertirALong(rs.getValueAt(i,"CLSO_OID_CLAS_SOLI")));
             dtoDatos.setOidTipoConsolidado(UtilidadesBD.convertirALong(rs.getValueAt(i,"TSOL_OID_TIPO_CONS")));
             dtoDatos.setOidSociedad(UtilidadesBD.convertirALong(rs.getValueAt(i,"SOCI_OID_SOCI")));
             dtoDatos.setOidSubacceso(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_SBAC")));
             dtoDatos.setNumUnidadesAlarma(UtilidadesBD.convertirALong(rs.getValueAt(i,"NUM_UNID_ALAR")));
             dtoDatos.setOidAlmacen(UtilidadesBD.convertirALong(rs.getValueAt(i,"ALMC_OID_ALMA")));
             dtoDatos.setValGlosa((String)rs.getValueAt(i,"VAL_GLOS"));
             dtoDatos.setIndOrdenCompra(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_ORDE_COMP")));
             dtoDatos.setIndPedidoPrueba(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_PEDI_PRUE")));
             dtoDatos.setIndPermiteUnion(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_PERM_UNIO")));
             dtoDatos.setIndSolicitudNega(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_SOLI_NEGA")));          
             dtoDatos.setOidProceso(UtilidadesBD.convertirALong(rs.getValueAt(i,"PROC")));
             dtoDatos.setIndOnLine(this.bigDecimalToBoolean(rs.getValueAt(i, "IND_ONLI")));
             dtoDatos.setCodigoSubacceso(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_SBAC")));
             hashDatos.put(keyHash,dtoDatos);             
           }
        }
    }     
    UtilidadesLog.info("MONOCRBean.obtenerDatosTipoSolicitud(HashMap hashTipoSolic): Salida");
    return hashDatos;   
  }
  
  private StringBuffer generarFiltroTipoSolicitud(HashMap hashTipoSolic){
    StringBuffer filtro = new StringBuffer();
    ArrayList array = new ArrayList((Collection)hashTipoSolic.values());
    Iterator it = array.iterator();
    while (it.hasNext()){
      DTOCargaIncialOCR dtoCargaInicial = (DTOCargaIncialOCR)it.next();    
      filtro.append(" (");
      filtro.append(" PTS.COD_TIPO_SOLI = '"+ dtoCargaInicial.getTipoSolicitud() +"' ");
      filtro.append(" AND PAIS.COD_PAIS = '"+ dtoCargaInicial.getCodPais() +"' ");
		  filtro.append(" AND PC.COD_PERI = '"+ dtoCargaInicial.getCodPeriodo() +"' ");
		  filtro.append(" AND SUB.COD_SBAC = '"+ dtoCargaInicial.getCodSubacceso() +"' ");
		  filtro.append(" )");
      if (it.hasNext()){
        filtro.append(" OR ");
      }
    }
    return filtro;    
  }
  
  
  private HashMap obtenerOidsClientes(HashMap hashClientes, ArrayList codsPais) throws MareException {
      UtilidadesLog.info("MONOCRBean.obtenerOidsClientes(HashMap hashClientes): Entrada");
      HashMap hashOidsClientes = new HashMap();
      RecordSet rs = null;
      StringBuffer query = new StringBuffer();
      insertClienteTemp(hashClientes, codsPais);
      if (!hashClientes.isEmpty()){
        query.append(" SELECT PAIS.COD_PAIS, ");
        query.append("        CLI.COD_CLIE, ");
        query.append("        CLI.OID_CLIE, ");
        query.append("        CTS.TICL_OID_TIPO_CLIE, ");
        query.append("        CTS.IND_PPAL, ");
        query.append(" (SELECT MCD.OID_CLIE_DIRE ");
	    query.append(" FROM MAE_CLIEN_DIREC MCD ");
		query.append(" WHERE MCD.CLIE_OID_CLIE = CLI.OID_CLIE " );
        query.append("    	AND MCD.IND_ELIM = 0 ");  //agregado por Sapaza, incidencia V_MAE_08               
		query.append("    	AND MCD.IND_DIRE_PPAL = 1 AND ROWNUM = 1) CLI_DIR,");        
        query.append(" (SELECT MCI.TDOC_OID_TIPO_DOCU ");
        query.append("  FROM MAE_CLIEN_IDENT MCI ");
        query.append("  WHERE MCI.CLIE_OID_CLIE = CLI.OID_CLIE ");
        query.append("  AND MCI.VAL_IDEN_DOCU_PRIN = 1 AND ROWNUM = 1) TIPO_DOC ");
        query.append(" FROM SEG_PAIS PAIS, ");
        query.append("      MAE_CLIEN CLI, ");
        query.append("      MAE_CLIEN_TIPO_SUBTI CTS, INT_OCR_CLIEN_TEMP ");
        query.append(" WHERE CTS.CLIE_OID_CLIE = CLI.OID_CLIE ");
        query.append("   AND PAIS.OID_PAIS = CLI.PAIS_OID_PAIS ");
        query.append("   AND INT_OCR_CLIEN_TEMP.COD_PAIS = PAIS.COD_PAIS ");
        query.append("   AND INT_OCR_CLIEN_TEMP.COD_CLIE = CLI.COD_CLIE ");
        DTODatosClientesOCR dtoDatos;
        rs = this.executeQuery(query.toString());   
          
        if (!(rs == null) && !(rs.esVacio())){
           for (int i=0;i<rs.getRowCount();i++){
              String keyHash;
              keyHash =(String)rs.getValueAt(i,"COD_PAIS")+"-"+(String)rs.getValueAt(i,"COD_CLIE");
              
              if (hashOidsClientes.containsKey(keyHash)) {
                dtoDatos = (DTODatosClientesOCR)hashOidsClientes.get(keyHash); 
                ArrayList array = (ArrayList) dtoDatos.getListaOidTipoCliente();
                array.add(this.bigDecimalToLong(rs.getValueAt(i,"TICL_OID_TIPO_CLIE")));
                dtoDatos.setListaOidTipoCliente(array);
                hashOidsClientes.put(keyHash, dtoDatos);      
              } else {
                dtoDatos = new DTODatosClientesOCR();
                dtoDatos.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i,"OID_CLIE")));               
                ArrayList array = new ArrayList();
                array.add(this.bigDecimalToLong(rs.getValueAt(i,"TICL_OID_TIPO_CLIE")));
                dtoDatos.setListaOidTipoCliente(array);
                dtoDatos.setCodPais((String)rs.getValueAt(i,"COD_PAIS"));
                dtoDatos.setCodClte((String)rs.getValueAt(i,"COD_CLIE"));
                dtoDatos.setOidDestino(this.bigDecimalToLong(rs.getValueAt(i,"CLI_DIR")));
                dtoDatos.setOidTipoDocumento(this.bigDecimalToLong(rs.getValueAt(i,"TIPO_DOC")));
                hashOidsClientes.put(keyHash, dtoDatos);               
              }
           }
        }
        deleteClienteTemp();
      }      
      UtilidadesLog.info("MONOCRBean.obtenerOidsClientes(HashMap hashClientes): Salida");
      return hashOidsClientes;
  }
  
  
    private void insertClienteTemp (HashMap hashClientes, ArrayList codsPais) throws MareException{
        StringBuffer sb = new StringBuffer();
        Iterator it1 = codsPais.iterator();    
        while (it1.hasNext()){
            String codPais = (String)it1.next();      
            ArrayList array = new ArrayList((ArrayList)hashClientes.get(codPais));
            Iterator it = array.iterator();
            while (it.hasNext()){        
                String codClientes = "'" + (String)it.next() + "'";
                sb.append("INSERT INTO INT_OCR_CLIEN_TEMP ( COD_PAIS, COD_CLIE ) VALUES ( ");
                sb.append("'"+codPais+"' , ").append(codClientes).append(");");
            }
        }
        sb.append("Analyze Table INT_OCR_CLIEN_TEMP Compute Statistics;");
        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }    
    }
    
    private void deleteClienteTemp() throws MareException{
        StringBuffer sb = new StringBuffer("truncate table INT_OCR_CLIEN_TEMP;");
       try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }  
    }
  
  private StringBuffer generarFiltroClientes(HashMap hashClientes, ArrayList codsPais){
    StringBuffer filtro = new StringBuffer();    
    Iterator it1 = codsPais.iterator();    
    while (it1.hasNext()){
      String codPais = (String)it1.next();      
      ArrayList array = new ArrayList((ArrayList)hashClientes.get(codPais));
      Iterator it = array.iterator();
      filtro.append(" (");
      filtro.append(" PAIS.COD_PAIS = '"+ codPais +"' ");
      filtro.append(" AND ( ");          
      String codClientes = "";
      int count = 0;
      while (it.hasNext()){        
          if (count == 0) {
              codClientes = "'" + (String)it.next() + "'";
          } else { 
              codClientes += ",'" + (String)it.next() + "'";
          }
          if (count == 999)  {
              filtro.append(" CLI.COD_CLIE IN ( " + codClientes.toString() + ")  ");                     
              if (it.hasNext()){
                  filtro.append("  OR ");
              }                    
              count = 0;
              codClientes = "";
          } else {
              if (!it.hasNext()){
                  filtro.append(" CLI.COD_CLIE IN ( " + codClientes.toString() + ") ");        
              }                    
              count++;            
          }           
          if (!it.hasNext()){              
            filtro.append(")");
          }
      }
      filtro.append(" )");
      if (it1.hasNext()) {
        filtro.append(" OR ");
      }
    }
    return filtro;    
  }

  private HashMap obtenerOIDTipoDespacho(HashMap hashDespacho, ArrayList codsPais) throws MareException {
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoDespacho(HashMap hashDespacho, ArrayList codsPais): Entrada");
        HashMap oidsDespacho = new HashMap();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        
        if (!hashDespacho.isEmpty()){
          query.append(" SELECT PTD.OID_TIPO_DESP, "); 
          query.append("        PTD.COD_TIPO_DESP, ");
          query.append("        PAIS.COD_PAIS ");
          query.append(" FROM PED_TIPO_DESPA PTD, ");
          query.append("      SEG_PAIS PAIS ");
          query.append(" WHERE PAIS.OID_PAIS = PTD.PAIS_OID_PAIS ");
          query.append(" AND (");
          query.append(this.generarFiltroDespacho(hashDespacho,codsPais));
          query.append(")");       
         
          rs = this.executeQuery(query.toString());
          
          if (!rs.esVacio()){
            for (int i=0;i < rs.getRowCount();i++){
               String keyHash;
               keyHash = (String)rs.getValueAt(i,"COD_PAIS") +"-"+(String)rs.getValueAt(i,"COD_TIPO_DESP");
               oidsDespacho.put(keyHash, this.bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_DESP"))); 
            }
          }
        }
        UtilidadesLog.info("MONOCRBean.obtenerOIDTipoDespacho(HashMap hashDespacho, ArrayList codsPais): Salida");
        return oidsDespacho;
  }
  
  private StringBuffer generarFiltroDespacho(HashMap hashDespacho, ArrayList codsPais){
    StringBuffer filtro = new StringBuffer();
    Iterator it1 = codsPais.iterator();
    while (it1.hasNext()){
      String codPais = (String)it1.next();      
      ArrayList array = new ArrayList((ArrayList)hashDespacho.get(codPais));
      Iterator it = array.iterator();
      while (it.hasNext()){
        filtro.append(" (");
        filtro.append(" PAIS.COD_PAIS = '"+ codPais +"' ");
        filtro.append(" AND PTD.COD_TIPO_DESP = '"+ (String)it.next() +"' ");
        filtro.append(" )");
        if (it.hasNext()){
          filtro.append(" OR ");
        } 
      }
      if (it1.hasNext()) {
        filtro.append(" OR ");
      }
    }
    return filtro;    
  }

  public void ejecutarInsercionSolicitudes(StringBuffer cadenasInsercionSolicitudes) throws MareException {
      BelcorpService bs = BelcorpService.getInstance();
      try {
          Cronometrador.startTransaction("Insertar Solicitudes");
          
          int maximo = 30000;
          StringBuffer buff = new StringBuffer(cadenasInsercionSolicitudes.toString());
          StringBuffer temp;   
         while(buff.length()> maximo){
            temp = new StringBuffer(buff.substring(0,maximo));
            int puntoYcoma = temp.lastIndexOf(";")+1;
            temp = new StringBuffer(temp.substring(0,puntoYcoma));
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",temp.toString());
            buff = new StringBuffer(buff.substring(puntoYcoma));
        }
        if(!buff.toString().trim().equals("")) {
          bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",buff.toString());
        }            
          Cronometrador.endTransaction("Insertar Solicitudes");
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
  }
  
  private HashMap guardarAcumulados(HashMap hashAcumulados, DTOCabeceraSolicitud dtoCab){
    if (!(dtoCab.getZona()==null) && !(dtoCab.getOidTipoSolicitudPais() == null) && !(dtoCab.getSubacceso() == null) && !(dtoCab.getFecha() == null)){
      if (hashAcumulados.get(dtoCab.getZona().toString() + dtoCab.getOidTipoSolicitudPais().toString() + dtoCab.getSubacceso().toString() + dtoCab.getFecha().toString()) == null){
          DTOCabeceraSolicitudAcumulados dtoCabeceraAcum = new DTOCabeceraSolicitudAcumulados();
          dtoCabeceraAcum.setOidZona(dtoCab.getZona());
          dtoCabeceraAcum.setOidTipoSolicitusPais(dtoCab.getOidTipoSolicitudPais());
          dtoCabeceraAcum.setOidSubacceso(dtoCab.getSubacceso());
          dtoCabeceraAcum.setFechaProceso(dtoCab.getFechaPrevistaFacturacion());
          dtoCabeceraAcum.setValGP1(new Long(1));       
          hashAcumulados.put(dtoCab.getZona().toString() + dtoCab.getOidTipoSolicitudPais().toString() + dtoCab.getSubacceso().toString() + dtoCab.getFecha().toString(),dtoCabeceraAcum);
      } else {
          DTOCabeceraSolicitudAcumulados dtoCabeceraAcum = (DTOCabeceraSolicitudAcumulados)hashAcumulados.get(dtoCab.getZona().toString() + dtoCab.getOidTipoSolicitudPais().toString() + dtoCab.getSubacceso().toString() + dtoCab.getFecha().toString());
          dtoCabeceraAcum.setValGP1(new Long(dtoCabeceraAcum.getValGP1().longValue() + 1));
          hashAcumulados.put(dtoCab.getZona().toString() + dtoCab.getOidTipoSolicitudPais().toString() + dtoCab.getSubacceso().toString() + dtoCab.getFecha().toString(),dtoCabeceraAcum);
      }   
   }
   return hashAcumulados;
  }
  
  private StringBuffer generarStringUpdateAcumulados(HashMap hashAcu) throws MareException {
     StringBuffer query = new StringBuffer();
     SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");  
     Iterator it = ((Collection)hashAcu.values()).iterator();
     while (it.hasNext()){
        DTOCabeceraSolicitudAcumulados dtoCabeceraAcum = (DTOCabeceraSolicitudAcumulados)it.next();
        StringBuffer query2 = new StringBuffer();        
        query2.append(" SELECT SCA.OID_ACUM ");
        query2.append(" FROM PED_SOLIC_CABEC_ACUM SCA ");
        query2.append(" WHERE SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dtoCabeceraAcum.getOidTipoSolicitusPais());
        query2.append("   AND SCA.ZZON_OID_ZONA = " + dtoCabeceraAcum.getOidZona());
        query2.append("   AND SCA.SBAC_OID_SBAC = " + dtoCabeceraAcum.getOidSubacceso());
        query2.append("   AND SCA.FEC_PROC = TO_DATE('" + simpledateformat.format(dtoCabeceraAcum.getFechaProceso()) + "','DD/MM/YYYY') ");
        RecordSet rs = null;
        
        rs = this.executeQuery(query2.toString());
        
        if (!(rs == null) && !(rs.esVacio())){
          query.append("UPDATE PED_SOLIC_CABEC_ACUM SET VAL_ACUM_GP1 = VAL_ACUM_GP1 + " + dtoCabeceraAcum.getValGP1());
          query.append(" WHERE OID_ACUM = " + this.bigDecimalToLong(rs.getValueAt(0,"OID_ACUM"))+";");
        } else { 
          query.append("INSERT INTO PED_SOLIC_CABEC_ACUM VALUES (PED_SCAA_SEQ.NEXTVAL,");
          query.append(dtoCabeceraAcum.getOidTipoSolicitusPais() + ",");
          query.append(dtoCabeceraAcum.getOidZona() + ",");
          query.append(dtoCabeceraAcum.getOidSubacceso() + ",");
          query.append("TO_DATE('" + simpledateformat.format(dtoCabeceraAcum.getFechaProceso()) + "','DD/MM/YYYY'),");
          query.append(dtoCabeceraAcum.getValGP1() + ",0,0,0,0);");         
       }
     }
     return query;
  }
  
    private boolean algunoCoincide(long datosTipoSolicitudOidTipoCliente, HashMap hashOidsClientes, DTODatosClientesOCR dtoDatosClte) {
     UtilidadesLog.info("MONOCRBean.algunoCoincide(long datosTipoSolicitudOidTipoCliente, HashMap hashOidsClientes, DTODatosClientesOCR dtoDatosClte): Entrada"); 
     Iterator it = (hashOidsClientes.values()).iterator();
     boolean retorno = false;
     while (it.hasNext()){
         DTODatosClientesOCR registro = (DTODatosClientesOCR)it.next();
         if (registro.getOidTipoCliente().longValue() == datosTipoSolicitudOidTipoCliente) {
             dtoDatosClte.setOidTipoCliente(registro.getOidTipoCliente());
             UtilidadesLog.info("MONOCRBean.algunoCoincide(long datosTipoSolicitudOidTipoCliente, HashMap hashOidsClientes, DTODatosClientesOCR dtoDatosClte): Salida1"); 
             return true;    
         }    
     }
     UtilidadesLog.info("MONOCRBean.algunoCoincide(long datosTipoSolicitudOidTipoCliente, HashMap hashOidsClientes, DTODatosClientesOCR dtoDatosClte): Salida2"); 
     return retorno;
  }
  
  
  private DTODatosClientesOCR algunoCoincide(String cPais, String cClte, HashMap hashOidsClientes) {
     UtilidadesLog.info("MONOCRBean.algunoCoincide(String cPais, String cClte, HashMap hashOidsClientes): Entrada"); 
     Iterator it = ((Collection)hashOidsClientes.values()).iterator();
     while (it.hasNext()){
         DTODatosClientesOCR registro = (DTODatosClientesOCR)it.next();
         if ( (registro.getCodPais().equals(cPais)) && (registro.getCodClte().equals(cClte)) ) {
             return registro;
         }    
     }
     UtilidadesLog.info("MONOCRBean.algunoCoincide(String cPais, String cClte, HashMap hashOidsClientes): Salida"); 
     return null;
  
  }
  
  private HashMap obtenerTiposDocumentos (HashMap hashOidsPais) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerTiposDocumentos(HashMap hashOidsPais): Entrada"); 
    HashMap hashTiposDocumento = new HashMap();
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT MTD.OID_TIPO_DOCU, ");
    query.append(" MTD.PAIS_OID_PAIS, ");
    query.append(" MTD.TIDO_OID_TIPO_DOCU "); 
    query.append(" FROM MAE_TIPO_DOCUM MTD ");
    query.append(" WHERE MTD.PAIS_OID_PAIS IN (");
    
    Iterator it = ((Collection)hashOidsPais.values()).iterator();
    int count = 0;
    while (it.hasNext()) {
      if (count == 0){
        query.append((Long)it.next());  
      } else {
        query.append("," + (Long)it.next());        
      }
      count++;
    }
    query.append(")");
    
    RecordSet rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()){
       int longRS = rs.getRowCount();
       for (int i=0;i < longRS;i++){
         String keyHash = "";
         Long oidPais = this.bigDecimalToLong(rs.getValueAt(i,"PAIS_OID_PAIS"));
         Long oidTipoDocu = this.bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_DOCU"));
         keyHash = oidPais.toString() + "-" + oidTipoDocu.toString();
         hashTiposDocumento.put(keyHash, this.bigDecimalToLong(rs.getValueAt(i,"TIDO_OID_TIPO_DOCU")));
       }
    }
    
    UtilidadesLog.info("MONOCRBean.obtenerTiposDocumentos(HashMap hashOidsPais): Salida"); 
    return hashTiposDocumento;
  }
  
  private void recuperarDatosClientesValidacion(ArrayList listaSol) throws MareException{
    UtilidadesLog.info("MONOCRBean.recuperarDatosClientesValidacion(ArrayList listaSol): Entrada");
    StringBuffer buffer = new StringBuffer();
    StringBuffer buffer2;
    StringBuffer buffer3;
    Long oidPais = null;
    int count = 0;
    Iterator it = listaSol.iterator();
    HashMap hashClienteTipoCliente = new HashMap(); 
    ArrayList arrayTiposCliente = new ArrayList();
    HashMap hashUnidadAdmin = new HashMap();
    ArrayList arrayPeriodos = new ArrayList();
    ArrayList arrayTipoDespacho = new ArrayList();
        
    while (it.hasNext()){
        DTOCabeceraSolicitud dtoS = (DTOCabeceraSolicitud)it.next();        
        if (count == 0){
          oidPais = new Long(dtoS.getOidPais().longValue());  
          buffer.append("(" + dtoS.getOidCliente());
        } else {
          buffer.append("," + dtoS.getOidCliente());
        }  
        if (!(arrayTiposCliente.contains(dtoS.getTipoCliente()))){
          arrayTiposCliente.add(dtoS.getTipoCliente());
        }        
        if (hashClienteTipoCliente.containsKey(dtoS.getTipoCliente())){
            buffer2 = (StringBuffer)hashClienteTipoCliente.get(dtoS.getTipoCliente());
            buffer2.append("," + dtoS.getOidCliente());
        } else {
            buffer2 = new StringBuffer();
            buffer2.append("(" + dtoS.getOidCliente());
        }        
        hashClienteTipoCliente.put(dtoS.getTipoCliente(), buffer2);
        
        if (!(arrayPeriodos.contains(dtoS.getPeriodo()))){
          arrayPeriodos.add(dtoS.getPeriodo());
        }
        if (hashUnidadAdmin.containsKey(dtoS.getPeriodo())){
            buffer3 = (StringBuffer)hashUnidadAdmin.get(dtoS.getPeriodo());
            buffer3.append("," + dtoS.getOidCliente());
        } else {
            buffer3 = new StringBuffer();
            buffer3.append("(" + dtoS.getOidCliente());
        }        
        hashUnidadAdmin.put(dtoS.getPeriodo(), buffer3);
        if (!arrayTipoDespacho.contains(dtoS.getTipoDespacho())){
          arrayTipoDespacho.add(dtoS.getTipoDespacho());
        }
        count++;
    }
    buffer.append(")");
    
    this.recuperarMarcasClientes(buffer);
    this.recuperarEstatusCliente(buffer);
    this.recuperarSubtiposClientes(hashClienteTipoCliente, arrayTiposCliente);
    this.recuperarUnidadAdminClientes(hashUnidadAdmin, arrayPeriodos);
    this.obtenerUbigeoClientes(buffer);
    this.obtenerMonedasMatrizPeriodos(arrayPeriodos);
    this.obtenerIndicadoresDespacho(arrayTipoDespacho);
    this.recuperarTiposSolicitudIncentivos(oidPais);
    
    UtilidadesLog.info("MONOCRBean.recuperarDatosClientesValidacion(ArrayList listaSol): Salida");  
  }
  
  private void recuperarMarcasClientes(StringBuffer buffer) throws MareException{
    UtilidadesLog.info("MONOCRBean.recuperarMarcasClientes(StringBuffer buffer): Entrada");    
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT MCM.CLIE_OID_CLIE, MCM.MARC_OID_MARC ");
    query.append(" FROM MAE_CLIEN_MARCA MCM	 ");
    query.append(" WHERE MCM.CLIE_OID_CLIE IN ");
    query.append(buffer.toString());
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    this.hashMarcasCliente = new HashMap();
    
    if (!rs.esVacio()){
       int longRS = rs.getRowCount();
       for (int i = 0; i < longRS;i++){ 
         Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
         Long oidMarca = this.bigDecimalToLong(rs.getValueAt(i,"MARC_OID_MARC"));
         this.hashMarcasCliente.put(oidCliente, oidMarca);
       }
    }    
    UtilidadesLog.info("MONOCRBean.recuperarMarcasClientes(StringBuffer buffer): Salida");    
  }
  
  private void recuperarEstatusCliente (StringBuffer buffer) throws MareException{
      UtilidadesLog.info("MONOCRBean.recuperarEstatusCliente(StringBuffer buffer): Entrada ");
      StringBuffer query = new StringBuffer();
      
      /* AL - Modificado por SICC 20080674 22/07/2008 
      query.append(" SELECT MDA.CLIE_OID_CLIE ");
      */
      query.append(" SELECT DISTINCT MDA.CLIE_OID_CLIE ");
      query.append(" FROM MAE_CLIEN_DATOS_ADICI MDA, ");
      query.append("      MAE_CLIEN_BLOQU MCB ");
      query.append(" WHERE MDA.CLIE_OID_CLIE IN ");
      query.append(buffer.toString());
      query.append("   AND MDA.IND_ACTI = 1");
      query.append("   AND MCB.CLIE_OID_CLIE = MDA.CLIE_OID_CLIE");
      /* AL - Agregado por SICC 20080674 22/07/2008 */  
      query.append("   AND MCB.FEC_DESB IS NULL ");
      /* AL - Agregado por SICC 20080674 22/07/2008 */
      
      /* AL - Eliminado por SICC 20080674 22/07/2008 
      query.append("   AND MCB.TIBQ_OID_TIPO_BLOQ IN (SELECT MTB.OID_TIPO_BLOQ");
      query.append("                                  FROM MAE_TIPO_BLOQU MTB");
	  query.append("                                  WHERE MTB.COD_TIPO_BLOQ IN ('" + ConstantesMAE.BLOQUEO_FINANCIERO +"','" + ConstantesMAE.BLOQUEO_ADMINISTRATIVO + "')");								
	  query.append("  )");
      */
      
      RecordSet rs = null;
      
      rs = this.executeQuery(query.toString());
      this.arrayEstatusClientes = new ArrayList();
      
      if (!rs.esVacio()){
       int longRS = rs.getRowCount();
       for (int i = 0; i < longRS;i++){ 
         Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
         this.arrayEstatusClientes.add(oidCliente);
         }
      }    
      UtilidadesLog.info("MONOCRBean.recuperarEstatusCliente(StringBuffer buffer): Salida ");      
  }

  private void recuperarSubtiposClientes(HashMap hashClienteTipoCliente, ArrayList arrayTiposCliente) throws MareException{
    UtilidadesLog.info("MONOCRBean.recuperarSubtiposClientes(HashMap hashClienteTipoCliente, ArrayList arrayTiposCliente): Entrada ");      
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT CLIE_OID_CLIE, ");
    query.append(" CTS.SBTI_OID_SUBT_CLIE ");
    query.append("FROM MAE_CLIEN_TIPO_SUBTI CTS ");
    query.append("WHERE ");
    
    int longArray = arrayTiposCliente.size();
    
    for (int i =0; i< longArray;i++) {
       Long oidTipoCliente = (Long)arrayTiposCliente.get(i);
       if (i != 0) {
          query.append(" OR ");
       }
       query.append("(CTS.TICL_OID_TIPO_CLIE = " + oidTipoCliente);
       query.append(" AND CTS.CLIE_OID_CLIE IN " + hashClienteTipoCliente.get(oidTipoCliente).toString() + " )) ");
    }

    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    this.hashSubtiposClientes = new HashMap();
    
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i = 0; i < longRS;i++){
        Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
        Long oidSubtipoCliente = this.bigDecimalToLong(rs.getValueAt(i,"SBTI_OID_SUBT_CLIE"));
        this.hashSubtiposClientes.put(oidCliente,oidSubtipoCliente);
      }
    }
    
    UtilidadesLog.info("MONOCRBean.recuperarSubtiposClientes(HashMap hashClienteTipoCliente, ArrayList arrayTiposCliente): Salida ");      
  }
  
  private void recuperarUnidadAdminClientes(HashMap hashUnidadAdmin, ArrayList arrayPeriodos) throws MareException{
    UtilidadesLog.info("MONOCRBean.recuperarUnidadAdminClientes(HashMap hashUnidadAdmin, ArrayList arrayPeriodos): Entrada ");      
    StringBuffer query;
    DTOUnidadAdministrativa dtoUAdm;
    this.hashUnidadAdminClientes = new HashMap();
    
    int longArray = arrayPeriodos.size();
    
    for (int i =0; i< longArray;i++) {
       Long oidPeriodo = (Long)arrayPeriodos.get(i);
      
       query = new StringBuffer(); 
       query.append(" SELECT SGV.OID_SUBG_VENT, ");
	   query.append("        REG.OID_REGI, ");
	   query.append("        ZON.OID_ZONA, ");
	   query.append("        SEC.OID_SECC, ");
	   query.append("        ZTA.OID_TERR_ADMI, ");
	   query.append("        TER.OID_TERR, ");
       query.append("        CUA.CLIE_OID_CLIE ");
       query.append(" FROM MAE_CLIEN_UNIDA_ADMIN CUA, ");
       query.append("      CRA_PERIO PER_INI, ");
       query.append("      ( ");
	   query.append("        SELECT FEC_INIC, FEC_FINA ");
       query.append("        FROM CRA_PERIO PE ");
       query.append("        WHERE PE.OID_PERI = " + oidPeriodo);
       query.append("      ) PER_PAR, ");
       query.append("      ZON_SUB_GEREN_VENTA SGV, ");
       query.append("      ZON_REGIO REG, ");
       query.append("      ZON_ZONA ZON, ");
       query.append("      ZON_SECCI SEC, ");
       query.append("      ZON_TERRI_ADMIN ZTA, ");
       query.append("      ZON_TERRI TER ");
       query.append(" WHERE CUA.CLIE_OID_CLIE IN " + hashUnidadAdmin.get(oidPeriodo).toString() + ")");
       query.append("   AND SGV.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
       query.append("   AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
       query.append("   AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
       query.append("   AND SEC.OID_SECC = ZTA.ZSCC_OID_SECC ");
       query.append("   AND TER.OID_TERR = ZTA.TERR_OID_TERR ");
       query.append("   AND CUA.IND_ACTI = 1 ");
       query.append("   AND CUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
       query.append("	 AND ZON.IND_ACTI = 1 ");
       query.append("   AND CUA.PERD_OID_PERI_INI = PER_INI.OID_PERI ");
       query.append("   AND PER_PAR.FEC_INIC >= PER_INI.FEC_INIC	  ");
       query.append("   AND (CASE WHEN (CUA.PERD_OID_PERI_FIN IS NULL) THEN ");
       query.append("         SYSDATE ");
	   query.append("       ELSE ");
	   query.append("          ( ");
	   query.append("          SELECT FEC_FINA ");
	   query.append("          FROM CRA_PERIO PE ");
 	   query.append("          WHERE PE.OID_PERI = CUA.PERD_OID_PERI_FIN ");
	   query.append("          ) ");
	   query.append("      END) >= (CASE WHEN (CUA.PERD_OID_PERI_FIN IS NULL) THEN ");
	   query.append("           SYSDATE ");
	   query.append("          ELSE ");
	   query.append("           PER_PAR.FEC_FINA ");
	   query.append("      END) ");
            
       RecordSet rs = null;
       
       rs = this.executeQuery(query.toString());
       
            
       if (!(rs == null) && !(rs.esVacio())){
          
          int longRS = rs.getRowCount();
          for (int j = 0;j<longRS;j++) {
            Long oidClie = this.bigDecimalToLong(rs.getValueAt(j,"CLIE_OID_CLIE"));
            dtoUAdm = new DTOUnidadAdministrativa();
            dtoUAdm.setOidSGV(this.bigDecimalToLong(rs.getValueAt(j,"OID_SUBG_VENT")));
            dtoUAdm.setOidRegion(this.bigDecimalToLong(rs.getValueAt(j,"OID_REGI")));
            dtoUAdm.setOidZona(this.bigDecimalToLong(rs.getValueAt(j,"OID_ZONA")));
            dtoUAdm.setOidSeccion(this.bigDecimalToLong(rs.getValueAt(j,"OID_SECC")));
            dtoUAdm.setOidTerritorioAdministrativo(this.bigDecimalToLong(rs.getValueAt(j,"OID_TERR_ADMI")));
            dtoUAdm.setOidTerritorio(this.bigDecimalToLong(rs.getValueAt(j,"OID_TERR"))); 
            this.hashUnidadAdminClientes.put(oidClie + "-" + oidPeriodo, dtoUAdm);          
          }          
       }
    }
    UtilidadesLog.info("MONOCRBean.recuperarUnidadAdminClientes(HashMap hashUnidadAdmin, ArrayList arrayPeriodos): Salida ");      
  }
  
  
  private void obtenerUbigeoClientes (StringBuffer buffer) throws MareException {
      UtilidadesLog.info("MONOCRBean.obtenerUbigeoClientes(StringBuffer buffer): Entrada ");
      StringBuffer query = new StringBuffer();
      this.hashUbigeoClientes = new HashMap();
      
      query.append(" SELECT CASE WHEN (SUBSTR(MCD.COD_UNID_GEOG,19,6) IS NULL) THEN ");
      query.append("			 (");
 	  query.append("        SELECT VEG.OID_VALO_ESTR_GEOP");
	  query.append("        FROM ZON_VALOR_ESTRU_GEOPO VEG");
	  query.append("        WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6)");
	  query.append("          AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6)");
	  query.append("          AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6)");
	  query.append("          AND VEG.ORDE_4 IS NULL					 						  ");
  	  query.append("       )  ");
	  query.append("      ELSE ");
	  query.append("        (");
	  query.append("          SELECT VEG.OID_VALO_ESTR_GEOP");
	  query.append("          FROM ZON_VALOR_ESTRU_GEOPO VEG");
	  query.append("          WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6)");
	  query.append("            AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6)");
	  query.append("            AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6)");
	  query.append("            AND VEG.ORDE_4 = SUBSTR(MCD.COD_UNID_GEOG,19,6)		");		 						  
  	  query.append("        )  ");
	  query.append("      END VEPO_OID_VALO_ESTR_GEOP, ");
	  query.append("      MCD.CLIE_OID_CLIE ");
      query.append(" FROM MAE_CLIEN_DIREC MCD ");
      query.append(" WHERE MCD.IND_DIRE_PPAL = 1 "); 
      query.append("  AND MCD.IND_ELIM = 0 ");
	  query.append("  AND MCD.CLIE_OID_CLIE IN " + buffer.toString());
     
      RecordSet rs = null;

      rs = this.executeQuery(query.toString());
            
      if (!(rs == null) && !(rs.esVacio())){
        int longRS = rs.getRowCount();
        for (int i = 0;i<longRS;i++) {
          Long oidUbigeo = this.bigDecimalToLong(rs.getValueAt(i,"VEPO_OID_VALO_ESTR_GEOP"));  
          Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));  
          this.hashUbigeoClientes.put(oidCliente, oidUbigeo);
        }          
      }
      UtilidadesLog.info("MONOCRBean.obtenerUbigeoClientes(StringBuffer buffer): Salida ");      
    }
    
  private void obtenerMonedasMatrizPeriodos(ArrayList arrayPeriodos) throws MareException{
    UtilidadesLog.info("MONOCRBean.obtenerMonedasMatrizPeriodos(StringBuffer buffer): Entrada ");      
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT MTC.MONE_OID_MONE,");
    query.append("        MTC.VAL_TIPO_CAMB,");
    query.append("        MTC.PERD_OID_PERI ");
    query.append(" FROM PRE_MATRI_FACTU_CABEC MTC");
    query.append(" WHERE MTC.PERD_OID_PERI IN (");
    int longArray = arrayPeriodos.size();
    for (int i=0;i<longArray;i++){
      if (i == 0){
        query.append(arrayPeriodos.get(i));
      } else {
        query.append("," + arrayPeriodos.get(i));
      }    
    }
    query.append(")");    
    
    RecordSet rs = null;

    rs = this.executeQuery(query.toString());
    
    this.hashMoneda = new HashMap();
    
    if (!(rs == null) && !(rs.esVacio())){
      int longRS = rs.getRowCount();
      for (int i = 0;i<longRS;i++) {        
        Long oidMoneda = this.bigDecimalToLong(rs.getValueAt(i,"MONE_OID_MONE"));
        Double tipoCambio = new Double(rs.getValueAt(i,"VAL_TIPO_CAMB").toString());
        HashMap hashM = new HashMap();
        hashM.put("MONE_OID_MONE", oidMoneda);
        hashM.put("VAL_TIPO_CAMB", tipoCambio);
        Long oidPeriodo = this.bigDecimalToLong(rs.getValueAt(i,"PERD_OID_PERI"));
        this.hashMoneda.put(oidPeriodo, hashM);
      }
    }
    
    UtilidadesLog.info("MONOCRBean.obtenerMonedasMatrizPeriodos(StringBuffer buffer): Salida ");      
  } 
  
  
  private void obtenerIndicadoresDespacho (ArrayList arrayTipoDespacho) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerIndicadoresDespacho(ArrayList arrayTipoDespacho): Entrada ");    
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT PTD.IND_CRON, OID_TIPO_DESP ");
    query.append(" FROM PED_TIPO_DESPA PTD ");
    query.append(" WHERE PTD.OID_TIPO_DESP IN (");
    
    int longArray = arrayTipoDespacho.size();
    for (int i =0;i<longArray;i++) {
      if (i==0) {
        query.append(arrayTipoDespacho.get(i)); 
      } else {
        query.append("," + arrayTipoDespacho.get(i));
      }
    }
    query.append(")");
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
    this.hashIndicadoresDespacho = new HashMap();
           
    if (!(rs == null) && !(rs.esVacio())){
      int longRS = rs.getRowCount();
      for (int i =0; i<longRS;i++){
        Boolean indicador = this.bigDecimalToBoolean(rs.getValueAt(i,"IND_CRON"));
        Long oidDespacho = this.bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_DESP"));
        this.hashIndicadoresDespacho.put(oidDespacho, indicador);
      }
    } 
    
    UtilidadesLog.info("MONOCRBean.obtenerIndicadoresDespacho(ArrayList arrayTipoDespacho): Salida");
  }

  public DTOSalidaBatch procesarSubSegmentos(DTOBatch dtoin) throws MareException
  {
        UtilidadesLog.info("MONOCRBean.procesarSubSegmento(DTOBatch dtoin): Entrada");
        DTOEjecucionProcesos dto = (DTOEjecucionProcesos) dtoin.getDTOOnline();
        ArrayList list = dto.getListaSolicitudes();
        
        this.recuperarDatosClientesValidacion(list);
       
        Iterator it = list.iterator();        
        StringBuffer cadenaInsercionSolicitudCabecera = new StringBuffer(); 
        HashMap hashOnLine = new HashMap();
      
        while(it.hasNext()){
          DTOCabeceraSolicitud dtoS = (DTOCabeceraSolicitud)it.next();          
          try{
            DTOOCRCadenasInsercionSolicitudes dtoOCRCadenasInsercionSolicitudes = new DTOOCRCadenasInsercionSolicitudes();
            dtoOCRCadenasInsercionSolicitudes = this.cargarSolicitud(dtoS);
            if(dtoOCRCadenasInsercionSolicitudes.getCadenaInsercionSolicitudCabecera()==null){
               continue;
            }
            cadenaInsercionSolicitudCabecera.append(dtoOCRCadenasInsercionSolicitudes.getCadenaInsercionSolicitudCabecera());                
          } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            UtilidadesLog.debug("Se continua con la proxima solicitud");
            continue;
          }
          if (dtoS.getIndOnLineOCR().booleanValue() && dtoS.getIndMonetariasOCR().booleanValue()){
            String key = new String(dtoS.getZona().toString() + "-" + dtoS.getOidTipoSolicitudPais().toString());
            if (!hashOnLine.containsKey(key)) {
                hashOnLine.put(key, dtoS);
            }
          }
        }        
        try {                
          this.getMONOCRLocal().ejecutarInsercionSolicitudes(cadenaInsercionSolicitudCabecera);          
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            UtilidadesLog.debug("Error al Insertar las Solicitudes");            
        }          
        try {
            this.getMONOCRLocal().insertarSolicitudesOnLine(hashOnLine);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            UtilidadesLog.debug("Error al Insertar las Solicitudes OnLine en la Tabla Temporal");                      
        }
        UtilidadesLog.info("MONOCRBean.procesarSubSegmento(DTOBatch dtoin): Salida");
        return new DTOSalidaBatch(0,"Ejecucion Sub-Segmento OCR completa");  
    }

  public void insertarSolicitudesOnLine(HashMap hashOnLine) throws Exception
  {
    UtilidadesLog.info("MONOCRBean.insertarSolicitudesOnLine(HashMap hashOnLine): Entrada");
    Iterator it = (hashOnLine.values()).iterator();
    StringBuffer query;
    while (it.hasNext()){
      DTOCabeceraSolicitud dtoS = (DTOCabeceraSolicitud)it.next();
      query = new StringBuffer();
      query.append("INSERT INTO INT_SOLIC_ONLIN_TEMP (OID_SOLI_ONLI_TEMP, OID_ZONA, OID_TIPO_SOLI_PAIS) VALUES (INT_ISOT_SEQ.NEXTVAL,");
      query.append(dtoS.getZona().toString() + ",");
      query.append(dtoS.getOidTipoSolicitudPais().toString() + ")");
      try {
        BelcorpService bs = BelcorpService.getInstance();
        bs.dbService.executeUpdate(query.toString());
      } catch (Exception e) {
        continue;
      }
    }    
    UtilidadesLog.info("MONOCRBean.insertarSolicitudesOnLine(HashMap hashOnLine): Salida");  
  }
  
  private void ejecutarSolicitudesOnLine(String indInterfaz) throws MareException{
    UtilidadesLog.info("MONOCRBean.ejecutarSolicitudesOnLine(): Entrada");  
    StringBuffer query = new StringBuffer();
    query.append("SELECT OID_ZONA, ");
	  query.append(" OID_TIPO_SOLI_PAIS ");	   
    query.append("FROM INT_SOLIC_ONLIN_TEMP ");

    RecordSet rs;
    rs = this.executeQuery(query.toString());
    ArrayList array = new ArrayList();
    
    if (!(rs == null) && !(rs.esVacio())){
      int longRS = rs.getRowCount();
      for (int i =0; i<longRS;i++){
        DTOSecuenciaSolicitudes dtoSecue = new DTOSecuenciaSolicitudes();
        dtoSecue.setOidTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(i,"OID_TIPO_SOLI_PAIS")));
        dtoSecue.setOidZona(this.bigDecimalToLong(rs.getValueAt(i,"OID_ZONA")));
        dtoSecue.setSecuencia(new Long(i));
        array.add(dtoSecue);
      }    
    }
    if (array.size() > 0 ) {
      query = new StringBuffer();
      query.append("DELETE INT_SOLIC_ONLIN_TEMP");
      
      try {
        BelcorpService belcorpService = BelcorpService.getInstance();
        belcorpService.dbService.executeUpdate(query.toString());
      } catch (Exception ex) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }       
    
      DTOInfoMonitor dtoIM = new DTOInfoMonitor();
      dtoIM.setSecuencia(array);
      if(ConstantesOCR.INDICADOR_INTERFAZ_OCR_MONETARIO.equals(indInterfaz)){
        dtoIM.setGP(ConstantesPED.GP4);        
      } else {
        dtoIM.setGP(ConstantesPED.GP1);        
      }
      Date fecha = new Date();    
      java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
      dtoIM.setFechaInicio(fechaSQL);
      dtoIM.setFechaFin(fechaSQL); 
      dtoIM.setIndPreFacturacion(Boolean.FALSE);
      try {
        MONMonitor monitor = this.getMONMonitorHome().create();
        monitor.procesarSolicitudes(dtoIM);
      } catch (NamingException ne) {
        throw new MareException(ne);
      } catch (CreateException ce) {
        throw new MareException(ce);
      } catch (RemoteException re) {
        throw new MareException(re);
      }
    }
    UtilidadesLog.info("MONOCRBean.ejecutarSolicitudesOnLine(): Salida");    
  }

  private MONMonitorHome getMONMonitorHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONMonitorHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMonitor"), MONMonitorHome.class);
  }
  
  private void recuperarTiposSolicitudIncentivos(Long oidPais) throws MareException {
    UtilidadesLog.info("MONOCRBean.recuperarTiposSolicitudIncentivos(Long oidPais): Entrada");  
    this.hashTiposSolicitudIncentivos = new HashMap();
    StringBuffer query = new StringBuffer();
    query.append("SELECT TSPI.TSPA_OID_TIPO_SOLI_PAIS, ");
    query.append("       TSPI.ICTP_OID_TIPO_PROG ");
    query.append("FROM PED_TIPOS_SOLIC_PROGR_INCEN TSPI ");
    query.append("WHERE TSPI.PAIS_OID_PAIS = ").append(oidPais);
   
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    
    if (rs != null && !rs.esVacio()) {
       int cantReg = rs.getRowCount();
       for (int i = 0; i< cantReg; i++) {
         Long oidTipoSolicPais = this.bigDecimalToLong(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS"));   
         Long oidTipoProg = this.bigDecimalToLong(rs.getValueAt(i, "ICTP_OID_TIPO_PROG"));
         this.hashTiposSolicitudIncentivos.put(oidTipoSolicPais, oidTipoProg);
       }
    }
    
    UtilidadesLog.info("MONOCRBean.recuperarTiposSolicitudIncentivos(Long oidPais): Salida");    
  }
  
  
  private void asociarTipoProgramaIncentivos(DTOCabeceraSolicitud dtoS) {
    if (this.hashTiposSolicitudIncentivos.containsKey(dtoS.getOidTipoSolicitudPais())) {
      dtoS.setOidTipoProgramaIncentivos((Long)this.hashTiposSolicitudIncentivos.get(dtoS.getOidTipoSolicitudPais())); 
    }  
  }
  
  
    public void generarFicheroDeEnviarConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras) throws MareException {
    UtilidadesLog.info("MONOCRBean.generarFicheroDeEnviarConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras): Entrada");
    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;
    InterfazInfo infoConsultora = null;
    UtilidadesLog.debug("generarFicheroDeEnviarConsultoras " + dtoGenerarFicheroDeEnviarConsultoras);
    RecordSet rs = this.obtenerInformacionConsultoras( dtoGenerarFicheroDeEnviarConsultoras );
    
    
    try {
      monGIH = this.getMONGestorInterfacesHome();
      monGI = monGIH.create();
      UtilidadesLog.debug("se viene el DTO");
      UtilidadesLog.debug("El numero de interfaz es: " + dtoGenerarFicheroDeEnviarConsultoras.getNumeroLote());
      if (dtoGenerarFicheroDeEnviarConsultoras.getNumeroLote() != null) {
        infoConsultora = new InterfazInfo(ConstantesOCR.OCR_INTERFAZ_CONSULTORAS, 
                              dtoGenerarFicheroDeEnviarConsultoras.getNumeroLote().toString(),
                              dtoGenerarFicheroDeEnviarConsultoras.getOidPais() );
        infoConsultora = monGI.crearInterfaz( infoConsultora );
      } else {
        infoConsultora = monGI.crearInterfaz(ConstantesOCR.OCR_INTERFAZ_CONSULTORAS,
                              dtoGenerarFicheroDeEnviarConsultoras.getOidPais());
      }
    } catch ( Exception exception ) {
      UtilidadesLog.debug("Error al obtener o importar las interfaces OCR_INTERFAZ_CONSULTORAS ");      
      throw new MareException(exception,
          UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
    }

    try {
      for ( int i = 0; i < rs.getRowCount(); i++ ) { 
        RegistroSicc registro = new RegistroSicc(); 

        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_PAIS , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_PAIS) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_PAIS).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_CLIE , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_CLIE) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_CLIE).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_APE1 , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_APE1) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_APE1).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_APE2 , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_APE2) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_APE2).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_NOM1 , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_NOM1) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_NOM1).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_NOM2 , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_NOM2) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_VAL_NOM2).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_SUBG_VENT , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_SUBG_VENT) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_SUBG_VENT).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_REGI , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_REGI) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_REGI).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_ZONA , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_ZONA) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_ZONA).toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_TERR , (rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_TERR) != null ? rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_TERR).toString() : "") ); 
      
        monGI.anyadirRegistro( infoConsultora, registro );
      }
    }catch(Exception e){      
      throw new MareException(
          CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ,
          e);
    }  

    //infoConsultora.setDescripcion(dtoGenerarFicheroDeEnviarConsultoras.getDescripcion());
//TODO esto se esta seteando pero no perdura el valor, tiene que ser una incidencia    
    infoConsultora.setObservaciones(dtoGenerarFicheroDeEnviarConsultoras.getObservaciones());
    if(dtoGenerarFicheroDeEnviarConsultoras.getNumeroLote() != null) {
      infoConsultora.setNumeroLote(dtoGenerarFicheroDeEnviarConsultoras.getNumeroLote().toString());
    }

      try{
        monGI.enviarInterfaz( infoConsultora );
      }catch(Exception e){        
        throw new MareException(
          CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ,
          e);
      }
      
      UtilidadesLog.info("MONOCRBean.generarFicheroDeEnviarConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras): Salida");
  }

  /**
   * Autor: Cortgaberria
   * Fecha: 02/12/04
   * @cambio OCR-5 solicitado por el cliente en produccion. Se eliminan las validaciones sobre la tabla INT-HISTO-LOTES.
   * @autor gdmarzi(in situ)
   */
  public RecordSet obtenerInformacionConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerInformacionConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras): Entrada");
    StringBuffer query = new StringBuffer();

    query.append("SELECT DISTINCT sp.COD_PAIS , clien.COD_CLIE, clien.VAL_APE1 , clien.VAL_APE2, "); 
    query.append("clien.VAL_NOM1 , clien.VAL_NOM2, sgv.COD_SUBG_VENT, r.COD_REGI, ");
    query.append("z.COD_ZONA , t.COD_TERR ");

    query.append("FROM SEG_PAIS sp , MAE_CLIEN_DATOS_ADICI datosAdici, ");
    query.append("MAE_CLIEN clien , MAE_CLIEN_UNIDA_ADMIN cua, "); 
    query.append("ZON_TERRI_ADMIN ta, ZON_TERRI t, ");
    query.append("ZON_SECCI secc , ZON_ZONA z, ");
    query.append("ZON_REGIO r , ZON_SUB_GEREN_VENTA sgv ");

    query.append("WHERE sp.OID_PAIS = ").append((dtoGenerarFicheroDeEnviarConsultoras.getOidPais() != null ? dtoGenerarFicheroDeEnviarConsultoras.getOidPais() : null)).append(" "); 
    query.append("AND sp.OID_PAIS = datosAdici.NSEP_OID_NSEP "); 
    query.append("AND datosAdici.IND_ACTI = 1 ");
    query.append("AND datosAdici.CLIE_OID_CLIE = clien.OID_CLIE "); 
    query.append("AND clien.OID_CLIE = cua.CLIE_OID_CLIE ");
    query.append("AND cua.ZTAD_OID_TERR_ADMI = ta.OID_TERR_ADMI "); 
    query.append("AND ta.TERR_OID_TERR = t.OID_TERR ");
    query.append("AND ta.ZSCC_OID_SECC = secc.OID_SECC ");
    query.append("AND secc.ZZON_OID_ZONA = z.OID_ZONA ");
    query.append("AND z.ZORG_OID_REGI = r.OID_REGI ");
    query.append("AND r.ZSGV_OID_SUBG_VENT = sgv.OID_SUBG_VENT "); 
    query.append("AND sgv.PAIS_OID_PAIS = sp.OID_PAIS "); 
  
    UtilidadesLog.info("MONOCRBean.obtenerInformacionConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras): Salida");
    return this.executeQuery(query.toString());
  }

  /**
   * Autor: Cortgaberria
   * Fecha: 02/12/04
   */
  /**
   * Autor: Cortgaberria
   * Fecha: 02/12/04
   * Se agrega el parametro para que funciones para todas las interfaces
   */   
  public DTOSalida obtenerValoresPorDefecto(DTOInterfaz dtoNumLote) throws MareException {
    UtilidadesLog.info("MONOCRBean.obtenerValoresPorDefecto(DTOInterfaz dtoNumLote): Entrada");
    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;
    InterfazInfo infoValoresPorDefecto = null;

    RecordSet rs = new RecordSet(); 
    Vector vRow = new Vector(); 

    try {
      monGIH = this.getMONGestorInterfacesHome();
      monGI = monGIH.create();
         
      infoValoresPorDefecto = monGI.obtenerInterfazInfo( dtoNumLote.getCodInterfaz(),dtoNumLote.getOidPais() );
    } catch ( Exception exception ) {
      UtilidadesLog.debug("Error al obtener o importar las interfaces " + dtoNumLote.getCodInterfaz());      
      throw new MareException(exception,
          UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
    }

    Long numeroLote = new Long(infoValoresPorDefecto.getNumeroLote()); 
    String descripcion = infoValoresPorDefecto.getDescripcionLote();

    rs.addColumn("Numero_Lote"); 
    rs.addColumn("Descripcion"); 
    vRow.add( numeroLote ); 
    vRow.add( descripcion ); 
    rs.addRow( vRow ); 

    DTOSalida dto = new DTOSalida(); 
    dto.setResultado( rs ); 
    UtilidadesLog.info("MONOCRBean.obtenerValoresPorDefecto(DTOInterfaz dtoNumLote): Salida");
    return dto;
  }

   public DTOSalida obtenerDatosDeCampana(DTOEntradaConsultaDatosCampana dtoEntradaConsultaDatosCampana) throws MareException {
      UtilidadesLog.info("MONOCRBean.obtenerDatosDeCampana(DTOEntradaConsultaDatosCampana dtoEntradaConsultaDatosCampana): Entrada");
      StringBuffer            textSql      = new StringBuffer();
      DTOSalida               dtoSalida    = null;
      RecordSet               rs           = null;
      
      textSql.append(" SELECT m.OID_MARC ,m.COD_MARC ,c.OID_CANA ,c.COD_CANA ,a.OID_ACCE ,a.COD_ACCE ,cp.PERI_OID_PERI ,cp.VAL_NOMB_PERI   ");
      textSql.append(" FROM VCA_SEG_PAIS p, VCA_SEG_MARCA m, VCA_SEG_CANAL c, VCA_SEG_ACCES a, CRA_PERIO cp ");
      textSql.append(" WHERE p.OID_PAIS = " + dtoEntradaConsultaDatosCampana.getOidPais() );
      textSql.append(" AND p.COD_USUA = " + "'" + dtoEntradaConsultaDatosCampana.getIdUsuario().toUpperCase() + "'");
      textSql.append(" AND p.COD_USUA = m.COD_USUA  ");
      textSql.append(" AND p.COD_USUA = c.COD_USUA "); 
      textSql.append(" AND p.COD_USUA = a.COD_USUA  ");
      textSql.append(" AND c.OID_CANA = a.CANA_OID_CANA ");
      textSql.append(" AND cp.MARC_OID_MARC = m.OID_MARC ");
      textSql.append(" AND cp.CANA_OID_CANA = c.OID_CANA ");
      textSql.append(" AND cp.ACCE_OID_ACCE = a.OID_ACCE ");
      textSql.append(" AND cp.PAIS_OID_PAIS = p.OID_PAIS ");

      rs = this.executeQuery( textSql.toString() );

      dtoSalida = new DTOSalida();
      dtoSalida.setResultado( rs );
      UtilidadesLog.info("MONOCRBean.obtenerDatosDeCampana(DTOEntradaConsultaDatosCampana dtoEntradaConsultaDatosCampana): Salida");
      return dtoSalida;
   }

    public RecordSet obtenerInformacionMatrizPrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios) throws  RemoteException, MareException {
        UtilidadesLog.info("MONOCRBean.obtenerInformacionMatrizPrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios): Entrada");
        StringBuffer textSql = new StringBuffer();
  
        textSql.append(" SELECT DISTINCT g.cod_pais, a.val_codi_vent, periocorpo.cod_peri ");
        textSql.append(" FROM cra_perio p, ");
        textSql.append(" pre_matri_factu_cabec c, ");
        textSql.append(" pre_ofert b, ");
        textSql.append(" pre_ofert_detal a, ");
        textSql.append(" seg_pais g, ");
        textSql.append(" seg_perio_corpo periocorpo ");
        textSql.append(" WHERE p.oid_peri IN ( ");
        textSql.append(" SELECT p.oid_peri ");
        textSql.append(" FROM cra_perio p, cra_perio pini, cra_perio pfin ");
        textSql.append(" WHERE pini.oid_peri = "+dtoEntradaGenerarFicheroMatrizPrecios.getOidPeriodoDesde());
        if (dtoEntradaGenerarFicheroMatrizPrecios.getOidPeriodoHasta()!=null){
            textSql.append(" AND pfin.oid_peri = "+dtoEntradaGenerarFicheroMatrizPrecios.getOidPeriodoHasta());  
        }else{
            textSql.append(" AND pfin.oid_peri = "+dtoEntradaGenerarFicheroMatrizPrecios.getOidPeriodoDesde());  
        }
        textSql.append(" AND p.pais_oid_pais = pfin.pais_oid_pais ");
        textSql.append(" AND p.marc_oid_marc = pfin.marc_oid_marc ");
        textSql.append(" AND p.cana_oid_cana = pfin.cana_oid_cana ");
        textSql.append(" AND p.fec_inic >= pini.fec_inic ");
        textSql.append(" AND p.fec_fina <= pfin.fec_fina) ");
        textSql.append(" AND c.perd_oid_peri = p.oid_peri ");
        textSql.append(" AND b.mfca_oid_cabe = c.oid_cabe ");
        textSql.append(" AND a.ofer_oid_ofer = b.oid_ofer ");
        textSql.append(" AND a.IND_DIGI = 1 ");
        textSql.append(" AND g.oid_pais = p.pais_oid_pais ");
        textSql.append(" AND p.peri_oid_peri = periocorpo.oid_peri ");
  
        RecordSet rs  = this.executeQuery( textSql.toString() );
        UtilidadesLog.info("MONOCRBean.obtenerInformacionMatrizPrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios): Salida");
        return rs;
    }

    public void generarFicheroEnviarMatrizDePrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios) throws  RemoteException, MareException {
        UtilidadesLog.info("MONOCRBean.generarFicheroEnviarMatrizDePrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios): Entrada");
        Cronometrador.startTransaction("MONOCRBean.generarFicheroEnviarMatrizDePrecios");
        MONGestorInterfacesHome monGIH; 
        MONGestorInterfaces     monGI; 
        InterfazInfo            interfazInfo =null; 
        RecordSet rs  = this.obtenerInformacionMatrizPrecios( dtoEntradaGenerarFicheroMatrizPrecios );
  
        try {
            monGIH = this.getMONGestorInterfacesHome();
            monGI  = monGIH.create();

            if (dtoEntradaGenerarFicheroMatrizPrecios.getNumeroLote() != null) {
                interfazInfo = new InterfazInfo(ConstantesOCR.OCR_INTERFAZ_MATRIZ_PRECIOS, 
                dtoEntradaGenerarFicheroMatrizPrecios.getNumeroLote().toString(),
                dtoEntradaGenerarFicheroMatrizPrecios.getOidPais() );
                interfazInfo = monGI.crearInterfaz( interfazInfo );
            } else {
                interfazInfo = monGI.crearInterfaz(ConstantesOCR.OCR_INTERFAZ_MATRIZ_PRECIOS,
                dtoEntradaGenerarFicheroMatrizPrecios.getOidPais());
            }
            for ( int i = 0; i < rs.getRowCount(); i++ ) {
                RegistroSicc registro = new RegistroSicc();
                
                if ( rs != null && rs.getValueAt( i, ConstantesOCR.OCR_REGISTRO_COD_PAIS ) != null ) {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_PAIS, rs.getValueAt(i, ConstantesOCR.OCR_REGISTRO_COD_PAIS) );
                } else {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_PAIS, new String("") );
                }
                
                if ( rs != null && rs.getValueAt(i, ConstantesOCR.OCR_REGISTRO_COD_PERI ) != null ) {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_PERI, rs.getValueAt(i, ConstantesOCR.OCR_REGISTRO_COD_PERI ) );
                } else {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_COD_PERI, new String("") );
                }
                
                if ( rs != null && rs.getValueAt(i, ConstantesOCR.OCR_REGISTRO_VAL_CODI_VENT ) != null ) {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_CODI_VENT, rs.getValueAt(i, ConstantesOCR.OCR_REGISTRO_VAL_CODI_VENT ) );
                } else {
                    registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_VAL_CODI_VENT, new String("") );
                }
                
                monGI.anyadirRegistro( interfazInfo, registro );
            }
        } catch ( Exception e ) {
            UtilidadesLog.error("generarFicheroEnviarMatrizDePrecios: Error 1 ",e);      
            throw new MareException ( CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ, e );
        }
  
        try {
            monGI.enviarInterfaz( interfazInfo );
        } catch ( Exception exception ) {
            UtilidadesLog.error("generarFicheroEnviarMatrizDePrecios: error 3 ",  exception);
            throw new MareException ( CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ, exception );
        }
        Cronometrador.endTransaction("MONOCRBean.generarFicheroEnviarMatrizDePrecios");
        UtilidadesLog.info("MONOCRBean.generarFicheroEnviarMatrizDePrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios): Salida");      
    }

  /**
   * Autor: Cortgaberria
   * Fecha: 07/12/04
   */
  public void generarFicheroRangoCompanya(DTOGenerarFicheroRangoCampanya dtoe) throws MareException {
    UtilidadesLog.info("MONOCRBean.generarFicheroRangoCompanya(DTOGenerarFicheroRangoCampanya dtoe): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = null;
    query.append("SELECT DISTINCT spc.cod_peri, cpini.fec_inic, sp.cod_pais");
    query.append(" FROM cra_perio cpini,");
    query.append(" cra_perio cpfin,");
    query.append(" seg_perio_corpo spc,");
    query.append(" seg_perio_corpo spcini,");
    query.append(" seg_perio_corpo spcfin,");
    query.append(" seg_pais sp");
    query.append(" WHERE");
    query.append(" sp.oid_pais = ").append(dtoe.getOidPais());
    query.append(" AND cpini.pais_oid_pais = ").append(dtoe.getOidPais()); 
    query.append(" AND cpini.marc_oid_marc = ").append(dtoe.getMarca());
    query.append(" AND cpini.cana_oid_cana = ").append(dtoe.getCanal());
    query.append(" AND cpini.val_esta = 1");

    query.append(" AND cpfin.pais_oid_pais = ").append(dtoe.getOidPais()); 
    query.append(" AND cpfin.marc_oid_marc = ").append(dtoe.getMarca());
    query.append(" AND cpfin.cana_oid_cana = ").append(dtoe.getCanal());
    query.append(" AND cpfin.val_esta = 1");

    /*para la fecha INIC*/
    query.append(" AND cpini.oid_peri = ").append(dtoe.getOidPeriodoDesde());
    query.append(" AND cpini.oid_peri = spcini.oid_peri");

    /*para la fecha FIN*/
    query.append(" AND cpfin.oid_peri = ").append(dtoe.getOidPeriodoHasta());
    query.append(" AND cpfin.oid_peri = spcfin.oid_peri");

    /*Union con la tabla seg_perio_corpo*/
    query.append(" AND ( cpini.peri_oid_peri = spc.oid_peri");
    query.append(" OR cpfin.peri_oid_peri = spc.oid_peri )");
    query.append(" AND spc.cod_peri >= spcini.cod_peri"); //desde
    query.append(" AND spc.cod_peri <= spcfin.cod_peri");//hasta
    query.append(" AND cpini.fec_inic =");
    query.append(" (SELECT MAX (cra_crono.fec_inic)");
    query.append(" FROM cra_crono, cra_activ, cra_clase_activ");
    query.append(" WHERE cra_clase_activ.cod_clas_acti LIKE 'FAC'");
    query.append(" AND cra_crono.cact_oid_acti = cra_activ.oid_acti");
    query.append(" AND cra_activ.clac_oid_clas_acti = cra_clase_activ.oid_clas_acti");
    query.append(" AND cra_crono.perd_oid_peri = cpini.oid_peri");
    query.append(" )");

    rs = this.executeQuery(query.toString());
    
    MONGestorInterfacesHome monGIH = null;
    MONGestorInterfaces monGI = null;
    InterfazInfo infoConsultora =null;

    try {
      //Se invoca al Gestor de Interfaces para procesar el fichero de Cabecera 
      monGIH = this.getMONGestorInterfacesHome();
      monGI = monGIH.create();
         
      //infoConsultora = monGI.crearInterfaz( ConstantesOCR.OCR_INTERFAZ_RANGO_CAMPANYA, dtoe.getOidPais() );
      if (dtoe.getNumLote() != null) {
        infoConsultora = new InterfazInfo(ConstantesOCR.OCR_INTERFAZ_RANGO_CAMPANYA, 
                              dtoe.getNumLote().toString(),
                              dtoe.getOidPais() );
        infoConsultora = monGI.crearInterfaz( infoConsultora );
      } else {
        infoConsultora = monGI.crearInterfaz(ConstantesOCR.OCR_INTERFAZ_RANGO_CAMPANYA,
                              dtoe.getOidPais());
      }
    } catch ( Exception exception ) {
      UtilidadesLog.debug("Error al obtener o importar las interfaces OCR_INTERFAZ_RANGO_CAMPANYA ");      
      throw new MareException(exception,
          UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
    }

    try {
      for ( int i = 0; i < rs.getRowCount(); i++ ) { 
        RegistroSicc registro = new RegistroSicc(); 

        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_PAIS , (rs.getValueAt( i, "COD_PAIS") != null ? rs.getValueAt( i, "COD_PAIS").toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_CODIGO_INICIAL , (rs.getValueAt( i, "COD_PERI") != null ? rs.getValueAt( i, "COD_PERI").toString() : "") ); 
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_CODIGO_FINAL , (rs.getValueAt( i, "COD_PERI") != null ? rs.getValueAt( i, "COD_PERI").toString() : "") );
        
        java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        
        java.util.Date date = df.parse(rs.getValueAt( i, "FEC_INIC").toString());
        registro.anyadirCampo( ConstantesOCR.OCR_REGISTRO_FECHA_FACTURACION , date ); 
      
        monGI.anyadirRegistro( infoConsultora, registro );
      }
    }catch(Exception e){      
      throw new MareException(
          CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ,
          e);
    }  

    try{
      //monGI.cerrarInterfaz( infoConsultora );
      }catch(Exception e){
        throw new MareException(
          CodigosError.ERROR_DE_CIERRE_DE_INTERFAZ,
          e);
      }
      try{
      monGI.enviarInterfaz( infoConsultora );
      }catch(Exception e){
        throw new MareException(
          CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ,
          e);
      }
  
  UtilidadesLog.info("MONOCRBean.generarFicheroRangoCompanya(DTOGenerarFicheroRangoCampanya dtoe): Salida");  
  
  }


    private MONUsuariosLocalHome getMONUsuariosLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUsuariosLocalHome) context.lookup( "java:comp/env/MONUsuarios" );
    }

    public DTOCabeceraSolicitud generaNumeroSolicitudCabecera(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONOCRBean.generaNumeroSolicitudCabecera(DTOCabeceraSolicitud dtoCabecera): Entrada");  
        
        ArrayList arrayParametros = new ArrayList();
        arrayParametros.add(dtoCabecera.getPais());
        arrayParametros.add(dtoCabecera.getCodigoSubacceso());
        arrayParametros.add(ConstantesBEL.COD_PED001);
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date currentYear = new Date( System.currentTimeMillis());
        String yy = sdf.format(currentYear);   
        arrayParametros.add(new Integer(yy)); 
        
        String numeroSolicitud = null;
        try {       
          numeroSolicitud = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_NUM_SOL_OCR", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        
        StringBuffer numeroFormateado = new StringBuffer();
        numeroFormateado.append(cerosIzq(yy.toString(), 2));
        numeroFormateado.append(cerosIzq(numeroSolicitud, 8));         
        dtoCabecera.setNumeroSolicitud(numeroFormateado.toString());
        UtilidadesLog.info("MONOCRBean.generaNumeroSolicitudCabecera(DTOCabeceraSolicitud dtoCabecera): Salida");  
        return dtoCabecera;
    }
}
