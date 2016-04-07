package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.util.DTOOID;
import java.util.GregorianCalendar;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesBean;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTDatosCliente;
import es.indra.sicc.dtos.intsys.DTOINTMovimientosCC;
import es.indra.sicc.dtos.intsys.DTOINTEnviarConsultorasDeuda;
import es.indra.sicc.dtos.intsys.DTOINTRecepcionarBancosRegistro;
import es.indra.sicc.dtos.intsys.DTORecepcionarMovimientos;
import es.indra.sicc.dtos.intsys.DTOINTCtaCteEmpresa;
import es.indra.sicc.entidades.ccc.MovimientosBancariosBean;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocal;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;
import es.indra.sicc.entidades.ccc.ProcesosLocalHome;
import es.indra.sicc.entidades.ccc.ProcesosLocal;
import es.indra.sicc.entidades.ccc.SubprocesosLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoLocal;
import es.indra.sicc.entidades.ccc.SubprocesosLocal;
import es.indra.sicc.entidades.ccc.TiposErrorLocalHome;
import es.indra.sicc.entidades.ccc.TiposErrorLocal;
import es.indra.sicc.entidades.mae.*;
import es.indra.sicc.entidades.zon.ViaLocal;
import es.indra.sicc.entidades.zon.ViaLocalHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.mae.IMaestroClientes;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.IServicioSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.util.CCCEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.Cronometrador;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.dtos.zon.DTOUnidadesAdministrativas;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialConsultorasDeudas;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONINTBean implements SessionBean {
private SessionContext sessionContext;
private final static int cantidadInsercionesRegistrosBancos = 2000; 
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }

    /**
     * 17/02/05 - fcoronel: 
     *                      Se actualizan las modificaciones debidas a los 
     *                      cambios en el Gestor de Intefaces, enviados por DT.
     * 19-07-2005 - rgiorgi: inc. 19905
     */
    public void recepcionarVia(DTOINT dto) throws MareException {
        UtilidadesLog.info("MONINTBean.recepcionarVia(DTOINT dto): Entrada");
        
        ViaLocalHome viaH = null;
        ViaLocal viaL =null;
        IRegistroSicc registro=null;
        Long oidTipoVia = null;
        MONGestorInterfacesHome gint;
        MONGestorInterfaces g = null; 
        InterfazInfo info = null;
        try {
            UtilidadesLog.debug("Entro a RecepcionarVia !!!");
            UtilidadesLog.debug(" dtoi.descripcionLote: " + dto.getDescripcionLote());
            UtilidadesLog.debug(" dtoi.observaciones: " + dto.getObservaciones());
            UtilidadesLog.debug("crea el objeto MONGestorInterfacesHome()");
            gint = this.getMONGestorInterfacesHome();            
            g = gint.create();
            UtilidadesLog.debug("Importa la interfaz");
            info = new InterfazInfo
                      ( IGestorInterfaces.COD_INTERFAZ_GIS3
                      , dto.getNumeroLote().toString()
                      ,  dto.getOidPais()); 
            // Inc. 13001
            info = g.importarInterfaz(info);
            
            UtilidadesLog.debug("Crea el objeto MONMantenimientoSEG");                                        
            MONMantenimientoSEG manSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            
            //Inc. 7367
            for (   registro = g.cargarRegistro(info); 
                    registro != null;      
                    registro = g.cargarRegistro(info))
            {
                String codPais = (String)registro.obtenerCampo(IRegistroSicc.GIS3_CODIGO_PAIS);
                Long oidPais = null;
                try{
                    oidPais = manSeg.obtenerOidPais(codPais);  
                    if (oidPais == null) {
                        DTOINTError dtoError = new DTOINTError
                            ( info
                            , (RegistroSicc) registro
                            , "No existe País: " + codPais);
                        g.registrarError(dtoError );
                        continue;
                    }
                }catch (Exception e){
                     DTOINTError dtoError = new DTOINTError
                            ( info
                            , (RegistroSicc) registro
                            , "No existe País: " + codPais);
                        g.registrarError(dtoError );
                        continue;
                }
                
                
                String codTipoVia = (String) registro.obtenerCampo(IRegistroSicc.GIS3_CODIGO_TIPO_VIA);
                oidTipoVia = manSeg.obtenerOidTipoVia(codTipoVia);
                UtilidadesLog.debug("Tipo de Via: " + oidTipoVia );
                if (oidTipoVia == null) {
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "No existe Tipo de Vía: " + codTipoVia);
                    g.registrarError(dtoError );
                    continue;
                }
                
                
                Integer codigoVia = new Integer((String)registro.obtenerCampo(IRegistroSicc.GIS3_CODIGO_VIA));
                
                viaH =  this.getViaLocalHome();
                try {
                    UtilidadesLog.debug("Busco una Via con 'oidPais'= " + oidPais + ", 'codigoVia'=" + codigoVia);                    
                     UtilidadesLog.debug("IRegistroSicc.GIS3_ACTIVO = " + 
                        ((String)registro.obtenerCampo(IRegistroSicc.GIS3_ACTIVO)));
                    
                    
                    
                    //inc. 19905
                    viaL = viaH.findByPaisSecuencial(oidPais, codigoVia);
                    UtilidadesLog.debug("despues de tirar el finder");
                    //actualizacion de via
                    
                    
                    boolean activo = ((String)registro.obtenerCampo(IRegistroSicc.GIS3_ACTIVO)).equals("1");
                    UtilidadesLog.debug("Activo : " + activo );
                    UtilidadesLog.debug("Creo la Via :" + registro.obtenerCampo(IRegistroSicc.GIS3_NOMBRE_VIA) );
                    viaL.setActivo(activo?Boolean.TRUE:Boolean.FALSE);
                    viaL.setOidTipoVia(oidTipoVia);
                    viaL.setNombre((String)registro.obtenerCampo(IRegistroSicc.GIS3_NOMBRE_VIA));
                    viaH.merge(viaL);
                    UtilidadesLog.debug("Actualizo la Via !!");
                } catch(NoResultException fe) {            
                    try{
                        UtilidadesLog.debug("   En el try de CREACION...");
                        UtilidadesLog.debug("IRegistroSicc.GIS3_ACTIVO = " + 
                            ((String)registro.obtenerCampo(IRegistroSicc.GIS3_ACTIVO)));
                    
                    
                        
                        //creacion de via
                        boolean activo = ((String)registro.obtenerCampo(IRegistroSicc.GIS3_ACTIVO)).equals("1");
                        UtilidadesLog.debug("__ Activo =" + activo );
                        UtilidadesLog.debug("__ Creo la Via =" + registro.obtenerCampo(IRegistroSicc.GIS3_NOMBRE_VIA) );
                        viaL = viaH.create
                            ( activo?Boolean.TRUE:Boolean.FALSE
                            , oidPais
                            , (String)registro.obtenerCampo(IRegistroSicc.GIS3_NOMBRE_VIA)
                            , codigoVia);  
                            
                       viaL.setOidTipoVia(oidTipoVia);  
                       viaH.merge(viaL);
                    } catch (PersistenceException ne) {
                        UtilidadesLog.error(ne);
                        throw new MareException 
                          ( ne
                          , UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }             
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
           
            }//while
            
            UtilidadesLog.debug( "INT   paso el while " + dto );
            UtilidadesLog.debug("==   ii.numeroLote " + info.getNumeroLote() );
            UtilidadesLog.info("MONINTBean.recepcionarVia(DTOINT dto): Salida");
    
        }catch (NamingException Ne) {
            UtilidadesLog.error(Ne);            
            throw new MareException(Ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } catch (CreateException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {            
            UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
            throw new MareException(ie.getMotivo(), ie);
        } catch ( Exception e ) {
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        }
    }
    
    public DTOSalidaBatch recepcionarMovimientosBatch(DTOBatch dtoBtch) throws MareException {
        UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTOBatch dtoBtch): Entrada");
        Cronometrador.startTransaction("MONINTBean.recepcionarMovimientosBatch");
        Date lanzado = new Date(System.currentTimeMillis());
        UtilidadesLog.warn("lanzado a las: " + lanzado);
        try {
            UtilidadesLog.debug("*** dtoBtch.getDTOOnline(): " + dtoBtch.getDTOOnline());
            DTORecepcionarMovimientos dto = (DTORecepcionarMovimientos) dtoBtch.getDTOOnline();
            MovimientosBancariosLocal movBanL;

            //Inc 12466 - obtenemos una referencia al subsistema de interfaces:
            MONGestorInterfacesHome gint = getMONGestorInterfacesHome();            
            MONGestorInterfaces g = gint.create();
            //UtilidadesLog.debug("==   crea el objeto MONGestorInterfaces : " + ( g == null ? "null" : g.getClass().getName()) );

            //Inc 12466 - InterfazInfo info = gi.importarInterfaz( IGestorInterfaces.INTERFAZ_BAN_MOVIMIENTOS ) 
            //Inc 12466 - Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto             
            InterfazInfo info = new InterfazInfo
                    ( IGestorInterfaces.COD_INTERFAZ_BAN1
                    , dto.getNumeroLote().toString()
                    ,  dto.getOidPais());
            info.setDescripcionLote(dto.getDescripcionLote());
            info.setObservaciones(dto.getObservaciones());
            // Inc. 13001 

            info = g.importarInterfaz(info);
            // UtilidadesLog.debug("EL NUMERO DE LOTE A PROCESAR ES : " + info.getNumeroLote());
            
            UtilidadesLog.debug("crea el objeto MONGestorInterfacesHome()");
            UtilidadesLog.debug("==   Comienzo a recorrer los registros ");
            
            ArrayList listaRegistros = new ArrayList();
            ArrayList listaCodigosBancosSicc = new ArrayList();
            ArrayList listaTipoTransaccion = new ArrayList();
            ArrayList listaConsultoras = new ArrayList();
            
            //proceso y demas
            ProcesosLocal     proceso  = this.getProcesosLocalHome().findByUk
                                                ( dto.getOidPais()
                                                , CCCConstantes.RECAUDO_MANUAL_NO_APLICADO) ;
            //Inc 12466 -   subproceso = findByUk(proceso.oidProceso, COD_SUBP=1) de la entidad SubProcesos de CCC 
            SubprocesosLocal     subproceso = this.getSubprocesosLocalHome().findByUk
                                                ( proceso.getOid()
                                                , new Long(1));
            //Inc 12466 -   tipoAbonoSubprocesos = findBySubproceso (subproceso.oidSubproceso) de la entidad TipoAbonoSubProceso de CCC
            Collection tipoAbonoSubprocesos = this.getTiposAbonoSubprocesoLocalHome().findBySubproceso
                                                ( subproceso.getOid());

            //Inc 12466 -   Obtenemos el primer registro de la colección tipoAbonoSubproceso 
            //Inc 12466 -   tipoAbonoSubpr = tipoAbonoSubprocesos[0].oidTipoCargoAbono 
            TiposAbonoSubprocesoLocal tipoAbonoSubpr = (TiposAbonoSubprocesoLocal)tipoAbonoSubprocesos.iterator().next();
            //Inc 12466 -   tipoAbono = findByPk(tipoAbonoSubpr) de la entidad TiposAbono 
            TiposAbonoLocal tipoAbono  = this.getTiposAbonoLocalHome().findByPrimaryKey
                                                  (tipoAbonoSubpr.getTipoAbono());            
            //
            UtilidadesLog.debug("==   cargue data ");
            
            for (   IRegistroSicc registro = g.cargarRegistro(info, false);
                    registro != null;
                    registro = g.cargarRegistro(info, false)){
                    
                DTOINTRecepcionarBancosRegistro dtoRegistro = new DTOINTRecepcionarBancosRegistro();        
                
                UtilidadesLog.debug("recorriendo interfaz");
    
                dtoRegistro.setFechaPago((String)registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PAGO));
                dtoRegistro.setCodigoBancoSicc((String)registro.obtenerCampo(IRegistroSicc.BAN1_CODIGO_BANCO_SICC));
                dtoRegistro.setTipoTransaccion((String)registro.obtenerCampo(IRegistroSicc.BAN1_TIPO_TRANSACCION));
                dtoRegistro.setCodConsultora((String)registro.obtenerCampo(IRegistroSicc.BAN1_CODIGO_CONSULTORA));
                
                if (registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_FACTURA_BOLETA)!=null)
                    dtoRegistro.setNumeroFacturaBoleta(new Long(((Integer)registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_FACTURA_BOLETA)).longValue()));                
                
                if (registro.obtenerCampo(IRegistroSicc.BAN1_VALOR_PAGO)!=null)
                    dtoRegistro.setImportePago(new BigDecimal(objectToFloat(registro.obtenerCampo(IRegistroSicc.BAN1_VALOR_PAGO)).toString()));
                    
                if (registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_CUPON)!=null)    
                    dtoRegistro.setNumeroCupon(new Long(((Integer)registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_CUPON)).longValue()));
                
                if ((String)registro.obtenerCampo(IRegistroSicc.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA) == null ||
                    ((String)registro.obtenerCampo(IRegistroSicc.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA)).equals(""))
                {
                      //gPineda - V-CCC040 - 26/01/2007
                      //dtoRegistro.setDigitoChequeoFactura(new Integer(0));
                      dtoRegistro.setDigitoChequeoFactura(null);
                }else{
                      dtoRegistro.setDigitoChequeoFactura(Integer.valueOf((String)registro.obtenerCampo(IRegistroSicc.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA)));                         
                }
                dtoRegistro.setDigCheqNumFact((String)registro.obtenerCampo(IRegistroSicc.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA));
                
                dtoRegistro.setOficinaRecaudadora((String)registro.obtenerCampo(IRegistroSicc.BAN1_OFICINA_RECAUDADORA));
                dtoRegistro.setNombreOficina(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_NOMBRE_OFICINA)));
                dtoRegistro.setNumeroDocumento(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_DOCUMENTO)));
                dtoRegistro.setHorarioNormalAdicional(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_HORARIO_NORMAL_ADICIONAL)));
                dtoRegistro.setUsuarioProceso(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_USUARIO_PROCESO)));
                dtoRegistro.setFechaProceso(toDate(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PROCESO))));
                dtoRegistro.setEnvioFecha1(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PROCESO)));
                dtoRegistro.setEnvioFecha2((String)(registro.obtenerCampo(IRegistroSicc.BAN1_HORA_PROCESO)));
                dtoRegistro.setEnvioFecha(toTimestamp(dtoRegistro.getEnvioFecha1() + " " + dtoRegistro.getEnvioFecha2()));
                dtoRegistro.setConsecutivoTransaccion(new Long(((String)registro.obtenerCampo(IRegistroSicc.BAN1_CONSECUTIVO_TRANSACCION))));

                if (registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_LOTE)!=null)
                    dtoRegistro.setNumeroLoteExterno(Long.valueOf(registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_LOTE).toString()));
                
                listaCodigosBancosSicc.add(dtoRegistro.getCodigoBancoSicc());
                listaTipoTransaccion.add(dtoRegistro.getTipoTransaccion());
                listaConsultoras.add(dtoRegistro.getCodConsultora());
                
                UtilidadesLog.debug("adh. en lista de regs.: " + dtoRegistro);
                listaRegistros.add(dtoRegistro);
    
            }
            
            UtilidadesLog.debug("voy a cargar hashes");
            HashMap hashCodBancos = this.obtenerDatosBancos(listaCodigosBancosSicc);
            HashMap hashTipoTransaccion = this.obtenerDatosTransacciones(listaTipoTransaccion, dto.getOidPais());
            HashMap hashClientes = this.obtenerDatosClientes(listaConsultoras, dto.getOidPais());
            UtilidadesLog.debug("cargue hashes");
            
            HashMap hashMovimientosBancos = new HashMap();
            
            //Long oidBanco = null;
            Long oidTipoTrn = null;
            Long oidClie = null;
            TiposErrorLocal error = null;
            boolean adhEnHas = false;
            String idenProceso = null;
            
            int contClieDummy = 0;
            Integer numeroHistoria = new Integer(0);
            
            for (int i=0;i<listaRegistros.size();i++){
                adhEnHas = false;
                error = null;
                DTOINTRecepcionarBancosRegistro dtoBancos = (DTOINTRecepcionarBancosRegistro)listaRegistros.get(i);
                
                UtilidadesLog.debug("miro registro: " + dtoBancos);
                
                java.sql.Date fechaPago  = toDate(dtoBancos.getFechaPago());
                if(fechaPago.compareTo(dto.getFechaGenerar())>0){
                    IRegistroSicc registro = new RegistroSicc();
                    
                    registro.anyadirCampo(registro.BAN1_FECHA_PAGO, dtoBancos.getFechaPago());
                    registro.anyadirCampo(registro.BAN1_CODIGO_BANCO_SICC, dtoBancos.getCodigoBancoSicc());
                    registro.anyadirCampo(registro.BAN1_TIPO_TRANSACCION, dtoBancos.getTipoTransaccion());
                    registro.anyadirCampo(registro.BAN1_CODIGO_CONSULTORA, dtoBancos.getCodConsultora());
                    if (dtoBancos.getNumeroFacturaBoleta()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, new Integer(dtoBancos.getNumeroFacturaBoleta().toString()));
                    else
                        registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, null);
                    
                    if (dtoBancos.getImportePago()!=null)    
                        registro.anyadirCampo(registro.BAN1_VALOR_PAGO, new Float(dtoBancos.getImportePago().floatValue()));
                    else
                        registro.anyadirCampo(registro.BAN1_VALOR_PAGO, null);
                        
                    if (dtoBancos.getNumeroCupon()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, new Integer(dtoBancos.getNumeroCupon().intValue()));
                    else
                        registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, null);
                        
                    registro.anyadirCampo(registro.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA, dtoBancos.getDigCheqNumFact());
                    registro.anyadirCampo(registro.BAN1_OFICINA_RECAUDADORA, dtoBancos.getOficinaRecaudadora());
                    registro.anyadirCampo(registro.BAN1_NOMBRE_OFICINA, dtoBancos.getNombreOficina());
                    registro.anyadirCampo(registro.BAN1_NUMERO_DOCUMENTO, dtoBancos.getNumeroDocumento());
                    registro.anyadirCampo(registro.BAN1_HORARIO_NORMAL_ADICIONAL, dtoBancos.getHorarioNormalAdicional());
                    registro.anyadirCampo(registro.BAN1_USUARIO_PROCESO, dtoBancos.getUsuarioProceso());
                    registro.anyadirCampo(registro.BAN1_FECHA_PROCESO, dtoBancos.getFechaProceso().toString());
                    registro.anyadirCampo(registro.BAN1_HORA_PROCESO, dtoBancos.getEnvioFecha2());
                    
                    if (dtoBancos.getConsecutivoTransaccion()!=null)
                        registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, dtoBancos.getConsecutivoTransaccion().toString());
                    else
                        registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, null);
                    
                    if (dtoBancos.getNumeroLoteExterno()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, new Integer(dtoBancos.getNumeroLoteExterno().toString()));
                    else    
                        registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, null);
                        
                    UtilidadesLog.info("La fecha de pago no es correcta");
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La fecha de pago no es correcta: " + dtoBancos.getFechaPago());
                    g.registrarError(dtoError);
                    continue;
                } 
                
                UtilidadesLog.info("busco en hash ban. el codigo de banco sicc: " + dtoBancos.getCodigoBancoSicc());
                DTOINTCtaCteEmpresa dtoCtaCteEmpresa = (DTOINTCtaCteEmpresa)hashCodBancos.get(dtoBancos.getCodigoBancoSicc().toString());
                UtilidadesLog.info("recup. datos banco: " + dtoCtaCteEmpresa);
                
                if (dtoCtaCteEmpresa!=null){
                    dtoBancos.setEmpresa(dtoCtaCteEmpresa.getSociedad());
                    dtoBancos.setOidCtaCte(dtoCtaCteEmpresa.getOidCtaCteBanc());
                    
                    UtilidadesLog.info("busco en hash tipo de tran.: " + dtoBancos.getTipoTransaccion());
                    oidTipoTrn = (Long)hashTipoTransaccion.get(dtoBancos.getTipoTransaccion().toString());  
                    UtilidadesLog.info("oid de tipo de tran. recup.: " + oidTipoTrn);
                    dtoBancos.setOidTipoTransaccion(oidTipoTrn);
                    if (oidTipoTrn!=null){
                    
                        UtilidadesLog.info("busco en hash clie, el cod.: " + dtoBancos.getCodConsultora());
                        oidClie = (Long)hashClientes.get(dtoBancos.getCodConsultora().toString());  
                        UtilidadesLog.info("oid de clie, recup: " + oidClie);
                        
                        if (oidClie!=null){
                            dtoBancos.setOidCliente(oidClie);
                            adhEnHas = true;
                            //idenProceso = CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO;
                        }else{
                            //oid dummy de cliente para meter dentro de la hash, sino se pisan por el null
                            contClieDummy++;
                            oidClie = new Long(contClieDummy); 
                            IRegistroSicc registro = new RegistroSicc();  
                            
                            registro.anyadirCampo(registro.BAN1_FECHA_PAGO, dtoBancos.getFechaPago());
                            registro.anyadirCampo(registro.BAN1_CODIGO_BANCO_SICC, dtoBancos.getCodigoBancoSicc());
                            registro.anyadirCampo(registro.BAN1_TIPO_TRANSACCION, dtoBancos.getTipoTransaccion());
                            registro.anyadirCampo(registro.BAN1_CODIGO_CONSULTORA, dtoBancos.getCodConsultora());
                            if (dtoBancos.getNumeroFacturaBoleta()!=null)
                                registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, new Integer(dtoBancos.getNumeroFacturaBoleta().toString()));
                            else
                                registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, null);
                                
                            if (dtoBancos.getImportePago()!=null)    
                                registro.anyadirCampo(registro.BAN1_VALOR_PAGO, new Float(dtoBancos.getImportePago().floatValue()));
                            else
                                registro.anyadirCampo(registro.BAN1_VALOR_PAGO, null);
                            
                            if (dtoBancos.getNumeroCupon()!=null)
                                registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, new Integer(dtoBancos.getNumeroCupon().intValue()));
                            else
                                registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, null);
                                
                            registro.anyadirCampo(registro.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA, dtoBancos.getDigCheqNumFact());
                            registro.anyadirCampo(registro.BAN1_OFICINA_RECAUDADORA, dtoBancos.getOficinaRecaudadora());
                            registro.anyadirCampo(registro.BAN1_NOMBRE_OFICINA, dtoBancos.getNombreOficina());
                            registro.anyadirCampo(registro.BAN1_NUMERO_DOCUMENTO, dtoBancos.getNumeroDocumento());
                            registro.anyadirCampo(registro.BAN1_HORARIO_NORMAL_ADICIONAL, dtoBancos.getHorarioNormalAdicional());
                            registro.anyadirCampo(registro.BAN1_USUARIO_PROCESO, dtoBancos.getUsuarioProceso());
                            registro.anyadirCampo(registro.BAN1_FECHA_PROCESO, dtoBancos.getFechaProceso().toString());
                            registro.anyadirCampo(registro.BAN1_HORA_PROCESO, dtoBancos.getEnvioFecha2());
                            
                            if (dtoBancos.getConsecutivoTransaccion()!=null)
                                registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, dtoBancos.getConsecutivoTransaccion().toString());
                            else
                                registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, null);
                            
                            if (dtoBancos.getNumeroLoteExterno()!=null)
                                registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, new Integer(dtoBancos.getNumeroLoteExterno().toString()));
                            else    
                                registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, null);
                                
                            DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La consultora no existe: " + dtoBancos.getCodConsultora());
                            g.registrarError(dtoError);
                            //Se modifica por la incidencia DBLG400000602 pzerbino 27/03/2006 
                            error  = this.getTiposErrorLocalHome().findByUK
                                                    (CCCConstantes.TIPOERROR_CLIENTE_NO_EXISTE);   
                            //idenProceso = CCCConstantes.MOVIMIENTO_BANCARIO_INCORRECTO;      
                            adhEnHas = true;
                        }
                        // gPineda - V-CCC040 - 26/01/2007
                        dtoBancos.setIdenProceso(CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO); 
                        //dtoBancos.setIdenProceso(idenProceso);
                    }else{
                        IRegistroSicc registro = new RegistroSicc();  
                        
                        registro.anyadirCampo(registro.BAN1_FECHA_PAGO, dtoBancos.getFechaPago());
                        registro.anyadirCampo(registro.BAN1_CODIGO_BANCO_SICC, dtoBancos.getCodigoBancoSicc());
                        registro.anyadirCampo(registro.BAN1_TIPO_TRANSACCION, dtoBancos.getTipoTransaccion());
                        registro.anyadirCampo(registro.BAN1_CODIGO_CONSULTORA, dtoBancos.getCodConsultora());
                        if (dtoBancos.getNumeroFacturaBoleta()!=null)
                            registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, new Integer(dtoBancos.getNumeroFacturaBoleta().toString()));
                        else
                            registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, null);
                            
                        if (dtoBancos.getImportePago()!=null)    
                            registro.anyadirCampo(registro.BAN1_VALOR_PAGO, new Float(dtoBancos.getImportePago().floatValue()));
                        else
                            registro.anyadirCampo(registro.BAN1_VALOR_PAGO, null);
                        
                        if (dtoBancos.getNumeroCupon()!=null)
                            registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, new Integer(dtoBancos.getNumeroCupon().intValue()));
                        else
                            registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, null);
                            
                        registro.anyadirCampo(registro.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA, dtoBancos.getDigCheqNumFact());
                        registro.anyadirCampo(registro.BAN1_OFICINA_RECAUDADORA, dtoBancos.getOficinaRecaudadora());
                        registro.anyadirCampo(registro.BAN1_NOMBRE_OFICINA, dtoBancos.getNombreOficina());
                        registro.anyadirCampo(registro.BAN1_NUMERO_DOCUMENTO, dtoBancos.getNumeroDocumento());
                        registro.anyadirCampo(registro.BAN1_HORARIO_NORMAL_ADICIONAL, dtoBancos.getHorarioNormalAdicional());
                        registro.anyadirCampo(registro.BAN1_USUARIO_PROCESO, dtoBancos.getUsuarioProceso());
                        registro.anyadirCampo(registro.BAN1_FECHA_PROCESO, dtoBancos.getFechaProceso().toString());
                        registro.anyadirCampo(registro.BAN1_HORA_PROCESO, dtoBancos.getEnvioFecha2());
                        
                        if (dtoBancos.getConsecutivoTransaccion()!=null)
                            registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, dtoBancos.getConsecutivoTransaccion().toString());
                        else
                            registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, null);
                        
                        if (dtoBancos.getNumeroLoteExterno()!=null)
                            registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, new Integer(dtoBancos.getNumeroLoteExterno().toString()));
                        else    
                            registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, null);
                    
                        DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "El tipo de transaccion no existe: " + dtoBancos.getTipoTransaccion());
                        g.registrarError(dtoError );
                        continue;                    
                    }
                }else{
                    IRegistroSicc registro = new RegistroSicc();  
                    
                    registro.anyadirCampo(registro.BAN1_FECHA_PAGO, dtoBancos.getFechaPago());
                    registro.anyadirCampo(registro.BAN1_CODIGO_BANCO_SICC, dtoBancos.getCodigoBancoSicc());
                    registro.anyadirCampo(registro.BAN1_TIPO_TRANSACCION, dtoBancos.getTipoTransaccion());
                    registro.anyadirCampo(registro.BAN1_CODIGO_CONSULTORA, dtoBancos.getCodConsultora());
                    if (dtoBancos.getNumeroFacturaBoleta()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, new Integer(dtoBancos.getNumeroFacturaBoleta().toString()));
                    else
                        registro.anyadirCampo(registro.BAN1_NUMERO_FACTURA_BOLETA, null);
                        
                    if (dtoBancos.getImportePago()!=null)    
                        registro.anyadirCampo(registro.BAN1_VALOR_PAGO, new Float(dtoBancos.getImportePago().floatValue()));
                    else
                        registro.anyadirCampo(registro.BAN1_VALOR_PAGO, null);
                    
                    if (dtoBancos.getNumeroCupon()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, new Integer(dtoBancos.getNumeroCupon().intValue()));
                    else
                        registro.anyadirCampo(registro.BAN1_NUMERO_CUPON, null);
                        
                    registro.anyadirCampo(registro.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA, dtoBancos.getDigCheqNumFact());
                    registro.anyadirCampo(registro.BAN1_OFICINA_RECAUDADORA, dtoBancos.getOficinaRecaudadora());
                    registro.anyadirCampo(registro.BAN1_NOMBRE_OFICINA, dtoBancos.getNombreOficina());
                    registro.anyadirCampo(registro.BAN1_NUMERO_DOCUMENTO, dtoBancos.getNumeroDocumento());
                    registro.anyadirCampo(registro.BAN1_HORARIO_NORMAL_ADICIONAL, dtoBancos.getHorarioNormalAdicional());
                    registro.anyadirCampo(registro.BAN1_USUARIO_PROCESO, dtoBancos.getUsuarioProceso());
                    registro.anyadirCampo(registro.BAN1_FECHA_PROCESO, dtoBancos.getFechaProceso().toString());
                    registro.anyadirCampo(registro.BAN1_HORA_PROCESO, dtoBancos.getEnvioFecha2());
                    
                    if (dtoBancos.getConsecutivoTransaccion()!=null)
                        registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, dtoBancos.getConsecutivoTransaccion().toString());
                    else
                        registro.anyadirCampo(registro.BAN1_CONSECUTIVO_TRANSACCION, null);
                    
                    if (dtoBancos.getNumeroLoteExterno()!=null)
                        registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, new Integer(dtoBancos.getNumeroLoteExterno().toString()));
                    else    
                        registro.anyadirCampo(registro.BAN1_NUMERO_LOTE, null);
                    
                    UtilidadesLog.info("La cuenta bancaria especificada no existe");
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La cuenta bancaria especificada no existe " + dtoBancos.getCodigoBancoSicc());
                    g.registrarError(dtoError);
                    continue;
                }
                String codigoError = "00";
                Long errorOid = null;
                if (error != null){
                     codigoError = error.getCodigo();
                     errorOid = error.getOid();
                }              
                dtoBancos.setCodigoError(codigoError);
                dtoBancos.setErrorOid(errorOid);
                if (adhEnHas) {
                    UtilidadesLog.debug("adh. en hash de mov. brios.: " + dtoBancos);
                    
                    //Modificado por cvalenzu - 19/12/2006
                    //Incidencia: V-CCC-016
                    //Comentario: la interfaz no funcionaba cuando se usaba
                    //un fichero que tenia un mismo cliente en el registro 1 y 3
                    //porque se pisaba el dato al utilizar el mismo oid de cliente
                    //como clave en el Hashmap, ahora se utiliza como clave: i 
                    //que es el contador del for principal
                    Integer clave = new Integer(i);
                    hashMovimientosBancos.put(clave, dtoBancos);  
                    //hashMovimientosBancos.put(oidClie, dtoBancos);  
                    //FIN - Modificado por cvalenzu - 19/12/2006
                }    
                
            }
            
            try {
              g.cerrarInterfaz(info);
            } catch (InterfacesException ix){
                    UtilidadesLog.debug("***MONINT.recepcionarMovimientosBatch: error InterfacesException del g.registrarError");            
            } catch(RemoteException re){              
                UtilidadesLog.error("***MONINT.recepcionarMovimientosBatch: error RemoteException del g.registrarError");
                throw new MareException(re,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }                 
            
            this.grabarMovimientoBancario(hashMovimientosBancos, subproceso.getOid(), dto.getOidPais(), 
                                          dto.getNumeroLote(), tipoAbono.getOid(), numeroHistoria);
            
        }catch (NamingException Ne) {
            UtilidadesLog.error(Ne);
            throw new MareException(Ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ne) {
            if ( ne.detail != null && (ne.detail instanceof InterfacesException ) ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                
                throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } catch (CreateException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {
            //Inc.6993
            //Inc 12466 - Si se recibe una InterfacesException, se registra un error mediante MareLogging y finaliza el método. 
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
        }  catch (Exception e) {
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        }
        
        String mensaje = new String();
        mensaje = "recepcionarMovimientosBatch procesado - ";
        
        UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTOBatch dtoBtch): Salida");
        Cronometrador.endTransaction("MONINTBean.recepcionarMovimientosBatch");
        
        UtilidadesLog.warn("finalizado a las: " + System.currentTimeMillis());
        UtilidadesLog.warn("tardo: " + (System.currentTimeMillis() - lanzado.getTime()));
        
        return new DTOSalidaBatch(0, mensaje);    
      }
    
     /**
     * Autor: SCS
     * Fecha: 18/09/2006
     * se hace Batch la ejecucion de la interfaz
     */
      public DTOSalidaBatch recepcionarMovimientosBatchOLD(DTOBatch dtoBtch) throws MareException
      {
          UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTOBatch dtoBtch): Entrada");
          try {
            DTORecepcionarMovimientos dto = (DTORecepcionarMovimientos) dtoBtch.getDTOOnline();
            MovimientosBancariosLocal movBanL;

            //Inc 12466 - obtenemos una referencia al subsistema de interfaces:
            MONGestorInterfacesHome gint = getMONGestorInterfacesHome();            
            MONGestorInterfaces g = gint.create();
            //UtilidadesLog.debug("==   crea el objeto MONGestorInterfaces : " + ( g == null ? "null" : g.getClass().getName()) );

            //Inc 12466 - InterfazInfo info = gi.importarInterfaz( IGestorInterfaces.INTERFAZ_BAN_MOVIMIENTOS ) 
            //Inc 12466 - Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto             
            InterfazInfo info = new InterfazInfo
                    ( IGestorInterfaces.COD_INTERFAZ_BAN1
                    , dto.getNumeroLote().toString()
                    ,  dto.getOidPais());
            info.setDescripcionLote(dto.getDescripcionLote());
            info.setObservaciones(dto.getObservaciones());
            // Inc. 13001 

            info = g.importarInterfaz(info);
            // UtilidadesLog.debug("EL NUMERO DE LOTE A PROCESAR ES : " + info.getNumeroLote());
            
            UtilidadesLog.debug("crea el objeto MONGestorInterfacesHome()");
            UtilidadesLog.debug("==   Comienzo a recorrer los registros ");
            for (   IRegistroSicc registro = g.cargarRegistro(info);
                    registro != null;
                    registro = g.cargarRegistro(info))
            {
                UtilidadesLog.debug("==   Recupero un registro    ");
                //Inc. 12466 -  Primero hacemos varias validaciones sobre el IRegistroSicc obtenido de llamar a cargarRegistro 
                String sFechaPago = (String)registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PAGO);
                java.sql.Date fechaPago  = toDate(sFechaPago);
                UtilidadesLog.debug("== fechaPagoI : " + fechaPago );
                if(fechaPago.compareTo(dto.getFechaGenerar())>0){
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La fecha de pago no es correcta: " + sFechaPago);
                    g.registrarError(dtoError );
                    continue;
                }               

                DAOCCC daoCC = new DAOCCC();
                String sCodigoBancoSicc = (String)registro.obtenerCampo(IRegistroSicc.BAN1_CODIGO_BANCO_SICC);
                Long oidCC = daoCC.obtenerOidCC(sCodigoBancoSicc);
                if( oidCC==null ){
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La cuenta bancaria especificada no existe " + sCodigoBancoSicc);
                    g.registrarError(dtoError );
                    continue;
                }
                UtilidadesLog.debug("oidCC = " + oidCC );
                
                String sTipoTransaccion = (String)registro.obtenerCampo(IRegistroSicc.BAN1_TIPO_TRANSACCION);
                Long oidTipoTransaccion  = daoCC.obtenerOidTipoTransaccion
                                                  ( sTipoTransaccion
                                                  , dto.getOidPais());
                if(oidTipoTransaccion==null){
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "El tipo de transaccion no existe: " + sTipoTransaccion);
                    g.registrarError(dtoError );
                    continue;
                }

                //Inc. 12466 -  Llamamos a IMaestroClientes.obtenerOidCliente con el resultado de llamar al metodo obtenerCampo con la constante 
                UtilidadesLog.debug("==   Traigo un MONClientes ");
                MONClientes im = MAEEjbLocators.getMONClientesHome().create();
                String codConsultora = (String)registro.obtenerCampo(IRegistroSicc.BAN1_CODIGO_CONSULTORA);
                Long oidCliente = im.obtenerOidCliente(dto.getOidPais(), codConsultora);
                TiposErrorLocal error = null;
                if(oidCliente == null){
                    DTOINTError dtoError = new DTOINTError(info, (RegistroSicc) registro, "La consultora no existe: " + codConsultora);
                    g.registrarError(dtoError );
                    //Se modifica por la incidencia DBLG400000602 pzerbino 27/03/2006 
                    error  = this.getTiposErrorLocalHome().findByUK
                                            (CCCConstantes.TIPOERROR_CLIENTE_NO_EXISTE);         
                }
                
               
                
                //Inc 12466 -   proceso = findByUk(pais,CODPROC=CCCConstantes.PROCESO_MOVIMIENTO_AUTOMATICO) de la entidad Procesos de CCC 
               //proceso = findByUk(pais,CODPROC=CCCConstantes.RECAUDO_MANUAL_NO_APLICADO)  inc 21792
                ProcesosLocal     proceso  = this.getProcesosLocalHome().findByUk
                                                    ( dto.getOidPais()
                                                    , CCCConstantes.RECAUDO_MANUAL_NO_APLICADO) ;
                //Inc 12466 -   subproceso = findByUk(proceso.oidProceso, COD_SUBP=1) de la entidad SubProcesos de CCC 
                SubprocesosLocal     subproceso = this.getSubprocesosLocalHome().findByUk
                                                    ( proceso.getOid()
                                                    , new Long(1));
                //Inc 12466 -   tipoAbonoSubprocesos = findBySubproceso (subproceso.oidSubproceso) de la entidad TipoAbonoSubProceso de CCC
                Collection tipoAbonoSubprocesos = this.getTiposAbonoSubprocesoLocalHome().findBySubproceso
                                                    ( subproceso.getOid());

                //Inc 12466 -   Obtenemos el primer registro de la colección tipoAbonoSubproceso 
                //Inc 12466 -   tipoAbonoSubpr = tipoAbonoSubprocesos[0].oidTipoCargoAbono 
                TiposAbonoSubprocesoLocal tipoAbonoSubpr = (TiposAbonoSubprocesoLocal)tipoAbonoSubprocesos.iterator().next();
                //Inc 12466 -   tipoAbono = findByPk(tipoAbonoSubpr) de la entidad TiposAbono 
                TiposAbonoLocal tipoAbono  = this.getTiposAbonoLocalHome().findByPrimaryKey
                                                      (tipoAbonoSubpr.getTipoAbono());
                
                //Inc 12466 -   error = findByUk(COD_ERROR=CCCCONSTANTES_TIPOERROR_CLIENTE_NO_EXISTE) de la entidad TiposError de CCC 
                /*TiposErrorLocal error  = this.getTiposErrorLocalHome().findByUK
                                            (CCCConstantes.TIPOERROR_CLIENTE_NO_EXISTE);             
                */                            
                UtilidadesLog.debug("==   Traigo un MovimientosBancariosLocalHome ");
                MovimientosBancariosLocalHome movBanLH = CCCEjbLocators.getMovimientosBancariosLocalHome();
                String idenProceso = null;
                if(oidCliente == null){
                   idenProceso = CCCConstantes.MOVIMIENTO_BANCARIO_INCORRECTO;   
                }else{
                   idenProceso = CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO;   
                }
                Long oidEmpresa = daoCC.obtenerEmpresaCC(oidCC);

                /*
                 * LLamamos al create() de MovimientosBancarios pasandole los siguientes atributos. --> incidencia 19961 - 17604
                 */
                 /*BELC300021792
                 -subprocesoMarcaCreacion= subproceso.oidSubproceso
                 -subprocesoMarcaUltimo= null
                 -tipoAbonoCreacion= tipoAbono
                 -tipoAbonoUltimo= null 
                 /**********************************************/

                UtilidadesLog.debug(" Obtenemos valores pare crear un MovimientosBancario ");
                Long pais = dto.getOidPais();
                String codigoConsultora = (String)registro.obtenerCampo(IRegistroSicc.BAN1_CODIGO_CONSULTORA);
                Long consultoraReal = oidCliente;
                String identificadorProceso = idenProceso;
                Long numeroLote =  dto.getNumeroLote();
                Long numeroFacturaBoleta = new Long(((Integer)registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_FACTURA_BOLETA)).longValue());
                java.sql.Date fechaPagoDate = toDate(sFechaPago);
                BigDecimal importePago = new BigDecimal(objectToFloat(registro.obtenerCampo(IRegistroSicc.BAN1_VALOR_PAGO)).floatValue());
                Long cuentaCorriente = oidCC;
                Long numeroCupon = new Long( ( (Integer)registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_CUPON)).longValue());
                
                // Se modifica por la incidencia BELC300023066 gPineda 28/04/2006
                Integer digitoChequeoFactura;
                String digitoChequeoFacturaLectura = (String)registro.obtenerCampo(IRegistroSicc.BAN1_DIGITO_CHEQUEO_NUMERO_FACTURA);
                if( digitoChequeoFacturaLectura == null || digitoChequeoFacturaLectura.equals("") )
                {
                  digitoChequeoFactura = new Integer(0); //Pedido por DP
                } else {
                  digitoChequeoFactura = Integer.valueOf( digitoChequeoFacturaLectura );
                }
                // FIN - BELC300023066
                
                String oficinaRecaudadora = (String)registro.obtenerCampo(IRegistroSicc.BAN1_OFICINA_RECAUDADORA);
                String nombreOficina = objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_NOMBRE_OFICINA));
                Long tipoTransaccion = oidTipoTransaccion;
                String numeroDocumento = objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_DOCUMENTO));
                String horarioNormalAdicional = objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_HORARIO_NORMAL_ADICIONAL));
                String usuarioProceso = objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_USUARIO_PROCESO));
                java.sql.Date fechaProceso = toDate(objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PROCESO)));
                //Se modifica por la incidencia DBLG400000602 pzerbino 27/03/2006
                String envioFecha1 = objectToString(registro.obtenerCampo(IRegistroSicc.BAN1_FECHA_PROCESO));
                String envioFecha2 = (String)(registro.obtenerCampo(IRegistroSicc.BAN1_HORA_PROCESO));
                String envioFecha = envioFecha1 + " " + envioFecha2 ;
                Timestamp horaProceso = toTimestamp(envioFecha);
                //Timestamp horaProceso = toTimestamp((String)registro.obtenerCampo(IRegistroSicc.BAN1_HORA_PROCESO));
                Long consecutivoTransaccion = new Long(((String)registro.obtenerCampo(IRegistroSicc.BAN1_CONSECUTIVO_TRANSACCION)));
                Long empresa = oidEmpresa;
                Long numeroLoteExterno = Long.valueOf(registro.obtenerCampo(IRegistroSicc.BAN1_NUMERO_LOTE).toString());
                Long subacceso =  null; /// de donde sale el valor???
                Long movimientoCajaCabecera = null; 
                Long subprocesoMarcaCreacion = subproceso.getOid();
                Long tipoAbonoCreacion= tipoAbono.getOid();
                Integer numeroHistoria = new Integer(0);
                BigDecimal importeAplicado = new BigDecimal(0);
                BigDecimal importeMovimiento = new BigDecimal(importePago.floatValue());
                BigDecimal saldoPendiente = importePago;
                
                String codigoError = "00";
                Long errorOid = null;
                if (error != null){
                     codigoError = error.getCodigo();
                     errorOid = error.getOid();
                }
                
                String codigoUsuario = sessionContext.getCallerPrincipal().getName();
                String estatusMovimientoPendiente = CCCConstantes.MOVIMIENTO_BANCARIO_PENDIENTE;
                UtilidadesLog.debug(" Creo un MovimientosBancariosLocal ");
                               //Se modifica el create incidencia 21734
                movBanL = movBanLH.create( empresa,// Long empresa,
                                           subprocesoMarcaCreacion, //Long subprocesoMarcaCreacion,
                                           cuentaCorriente, //Long oidCuentaCorriente, 
                                           pais, ///Long pais,
                                           consultoraReal,
                                           tipoAbonoCreacion, //Long tipoAbonoCreacion,
                                           consecutivoTransaccion, //Long consecutivoTransaccion,
                                           numeroLote //Long numeroLote
                                           ); 
                                           
                //se setean los campos NOT NULL
                movBanL.setEmpresa(empresa);
                movBanL.setSubprocesoMarcaCreacion(subprocesoMarcaCreacion);
                movBanL.setCuentaCorriente(cuentaCorriente);
                movBanL.setPais(pais);
                movBanL.setTipoAbonoCreacion(tipoAbonoCreacion);
                movBanL.setConsecutivoTransaccion(consecutivoTransaccion); //Long consecutivoTransaccion,
                movBanL.setNumeroLote(numeroLote);
                
                //y los demas
                movBanL.setCodigoConsultora(codigoConsultora);  //String codigoConsultora, 
                movBanL.setConsultoraReal(consultoraReal); // Long consultoraReal,
                movBanL.setCodigoError(codigoError); // String codigoError,
                //movBanL.setConsecutivoTransaccion(consecutivoTransaccion); //Long consecutivoTransaccion,
                movBanL.setDigitoChequeoFactura(digitoChequeoFactura);//Integer digitoChequeoFactura,
                //null, //String documentoAplicacionAnyo,
                //null, //String documentoAplicacionMesSerie,
                //null, //Integer documentoAplicacionNumero,
                //null, //String documentoCreacionAnyo,
                //null, //String documentoCreacionMesSerie,
                //null, //Integer documentoCreacionNumero, 
                movBanL.setEstatusMovimientoPendienteAplicado(estatusMovimientoPendiente); // String estatusMovimientoPendienteAplicado, 
                //null, //Date fechaContabilizacion,
                //null, //Timestamp fechaMovimientoAplicacion, 
                movBanL.setFechaPago(fechaPagoDate); //Date fechaPago, 
                movBanL.setFechaProceso(fechaProceso); //Date fechaProceso, 
                movBanL.setHoraProceso(horaProceso); //Timestamp horaProceso,
                movBanL.setHorarioNormalAdicional(horarioNormalAdicional); //String horarioNormalAdicional,
                movBanL.setIdentificadorProceso(identificadorProceso);  //String identificadorProceso, 
                movBanL.setImportePago(importePago);//BigDecimal importePago,
                movBanL.setNombreOficina(nombreOficina); // String nombreOficina,
                movBanL.setNumeroDocumento(numeroDocumento); //String numeroDocumento,
                movBanL.setNumeroFacturaBoleta(numeroFacturaBoleta); //Long numeroFacturaBoleta,
               // movBanL.setNumeroLote(numeroLote); //Long numeroLote, 
                //null, //String numeroLoteContabilizacion,
                //null, //String observaciones, 
                movBanL.setOficinaRecaudadora(oficinaRecaudadora);//String oficinaRecaudadora,
                movBanL.setUsuarioProceso(usuarioProceso); //String usuarioProceso,
                movBanL.setNumeroCupon(numeroCupon);//Long numeroCupon,
                //null,//Long tipoAbonoUltimo,
                movBanL.setTipoTransaccion(tipoTransaccion); //Long tipoTransaccion,
                
                /* splatas - INC.22714 - 02/03/2006 
                 * Se asigna a 'SubprocesoMarcasUltimo' y 'TipoAbonoUltimo' los mismos valores
                 * de Creación
                 */
                movBanL.setSubprocesoMarcasUltimo(subprocesoMarcaCreacion);
                movBanL.setTipoAbonoUltimo(tipoAbonoCreacion);
                
                movBanL.setNumeroLoteExterno(numeroLoteExterno); //Long numeroLoteExterno,
                movBanL.setNMovimientoCaja(movimientoCajaCabecera); //Long nMovimientoCaja,
                movBanL.setSaldoPendiente(saldoPendiente);//BigDecimal saldoPendiente,
                movBanL.setCodigoUsuario(codigoUsuario); //String codigoUsuario,
                movBanL.setNumeroHistoria(numeroHistoria); // Integer numeroHistoria, 
                movBanL.setImporteAplicado(importeAplicado);//BigDecimal importeAplicado,
                movBanL.setError(errorOid); //Long error, 
                movBanL.setSubacceso(subacceso);//Long subacceso*/
                //Se modifica por la incidencia DBLG400000602 pzerbino 27/03/2006 
                //movBanL.setImporteMovimiento(importeMovimiento);
                //es el mismo que saldo, asi que se pone el mismo
                movBanL.setImporteMovimiento(importePago);
            } //fin while

            UtilidadesLog.debug("==   ii.numeroLote " + info.getNumeroLote() );
        }catch (NamingException Ne) {
            UtilidadesLog.error(Ne);
            throw new MareException(Ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ne) {
            if ( ne.detail != null && (ne.detail instanceof InterfacesException ) ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                
                throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } catch (CreateException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {
            //Inc.6993
            //Inc 12466 - Si se recibe una InterfacesException, se registra un error mediante MareLogging y finaliza el método. 
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
        }  catch (Exception e) {
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        }
        
        String mensaje = new String();
        mensaje = "recepcionarMovimientosBatch procesado - ";
        
        UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTOBatch dtoBtch): Salida");
        return new DTOSalidaBatch(0, mensaje);    
      }

     /**
     * Autor: Cortaberria
     * Fecha: 14/12/04
     * Se agregó el tipo de abono y se modificaron setters de MovimientosBancariosLocal, por estar compilado este MON
     * con un jar viejo. El código del tipo de abono fue hecho por Cabrera.
     */
    /**
     * Autor: fcoronel
     * Fecha: 17/02/05
     * Se actualizan las modificaciones debidas a los cambios en el Gestor de Intefaces, enviados por DT
     * 
     * 18/09/2006, SCS; se hace Batch la ejecucion de la interfaz
     */
    public DTOSalidaBatch recepcionarMovimientos(DTORecepcionarMovimientos dto) throws MareException {
        DTOSalidaBatch dtoSalidaBatch = null;
        try {
            UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTORecepcionarMovimientos dto): Entrada");
            UtilidadesLog.debug("DTO : " + dto );
            
            MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarMovimientosBatch");
            
            String mensaje = null;    
            String nombre = "Recepcionar Movimientos Bancarios";
            
            IMareDTO DTOOnline = (IMareDTO)dto;
            DTOBatch dtoBach = new DTOBatch(nombre,IDOnline,DTOOnline);   
            
            MareBusinessID IDProceso = new MareBusinessID("INTProcesoInterfaces");
            
            UtilidadesLog.debug("Antes de BatchUtil.executeMLN"); 
            BatchUtil.executeMLN(dtoBach,IDProceso);
    
            mensaje += "Recepcionar Movimientos Bancarios - ";
            UtilidadesLog.debug("Luego de BatchUtil.executeMLN");
    
            dtoSalidaBatch = new DTOSalidaBatch(0, mensaje);
            UtilidadesLog.debug("dtoSalidaBatch: " + dtoSalidaBatch);                
            
        }catch (RemoteException e){
         UtilidadesLog.error(e);
        }

        UtilidadesLog.info("MONINTBean.recepcionarMovimientosBatch(DTORecepcionarMovimientos dto): Salida");
        return dtoSalidaBatch;           
    }


    /**
     * Autor: fcoronel
     * Fecha: 17/02/05
     * Se actualizan las modificaciones debidas a los cambios en el Gestor de Intefaces, enviados por DT
     */
    public DTOCargaInicialInterfaz cargaInicial(DTOString dto)
        throws MareException {
        UtilidadesLog.info("MONINTBean.cargaInicial(DTOString dto): Entrada");
        DTOCargaInicialInterfaz dtoI = null;
        try{
            UtilidadesLog.debug("Metodo carga inicializaa la Interfaz");
            dtoI = new DTOCargaInicialInterfaz();
            MONGestorInterfacesHome gI = this.getMONGestorInterfacesHome();            
            MONGestorInterfaces g = gI.create(); 
            UtilidadesLog.debug("antes de llamar al metodo obtenerInterfazInfo");
            UtilidadesLog.debug("MONGestorInterfaces "+ (g==null));
            InterfazInfo ii = g.obtenerInterfazInfo(dto.getCadena(), dto.getOidPais());
            UtilidadesLog.debug("InterfazInfo "+ (ii==null));
            dtoI.setDescripcion(ii.getDescripcionLote());
            dtoI.setNumeroLote(new Long(ii.getNumeroLote()));    
            
        }catch (NamingException ne) {            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ne) {            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ne) {            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {
            //Inc.6993            
            UtilidadesLog.error("Excepcion de la Interfaz "+ ie.getMotivo(), ie.getEx() != null? ie.getEx(): ie);
            throw new MareException( ie );
        }  catch (Exception e) {            
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        }

        UtilidadesLog.debug("antes de devolver dtoI " + dtoI);  
        UtilidadesLog.info("MONINTBean.cargaInicial(DTOString dto): Salida");
        return dtoI;
    }


     /*******************FECHA****************************/
    private java.sql.Date toDate(String sFecha) throws Exception{
        UtilidadesLog.info("MONINTBean.toDate(String sFecha): Entrada");
        String formatoFecha = "yyyyMMdd";       
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);      
        Date d = miFecha.parse(sFecha);
        java.sql.Date sqlDate = new java.sql.Date(d.getTime()); 
        UtilidadesLog.info("MONINTBean.toDate(String sFecha): Salida");
        return sqlDate;
    }

    private Timestamp toTimestamp(String sHora) throws Exception {
        UtilidadesLog.info("MONINTBean.toTimestamp(String sHora): Entrada");
        //String formatoHora = "hh:mm:ss";
        String formatoHora = "yyyyMMdd hh:mm:ss";
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoHora);       
        UtilidadesLog.info("MONINTBean.toTimestamp(String sHora): Salida");
        return new Timestamp(miFecha.parse(sHora).getTime());
    }


    private Long objectToLong(Object oBigDecimal){
      UtilidadesLog.info("MONINTBean.objectToLong(Object oBigDecimal): Entrada");
      if (oBigDecimal != null) {
        UtilidadesLog.info("MONINTBean.objectToLong(Object oBigDecimal): Salida");    
        return new Long(((BigDecimal)oBigDecimal).longValue());
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToLong(Object oBigDecimal): Salida");    
        return null;
      }          
  }
  
  private Integer objectToInteger(Object oBigDecimal){
      UtilidadesLog.info("MONINTBean.objectToInteger(Object oBigDecimal): Entrada");
      if (oBigDecimal != null) {
          UtilidadesLog.info("MONINTBean.objectToInteger(Object oBigDecimal): Salida");
          return new Integer(((BigDecimal)oBigDecimal).intValue());
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToInteger(Object oBigDecimal): Salida");
        return null;
      }          
  }

  private java.sql.Date objectToDate(Object oDate){
      UtilidadesLog.info("MONINTBean.objectToDate(Object oDate): Entrada");
      if (oDate != null) {
        UtilidadesLog.info("MONINTBean.objectToDate(Object oDate): Salida");          
        return (java.sql.Date)oDate;
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToDate(Object oDate): Salida");          
        return null;
      }          
  }
  
  private String objectToString(Object oString){
      UtilidadesLog.info("MONINTBean.objectToString(): Entrada");
      if (oString != null) {
          UtilidadesLog.info("MONINTBean.objectToString(): Salida");
          return  oString.toString();
          }          
      else {
        UtilidadesLog.info("MONINTBean.objectToString(): Salida (mal)");
        return null;  
      }
  }
  
  private BigDecimal objectToBigDecimal(Object oBigDecimal){
      UtilidadesLog.info("MONINTBean.objectToBigDecimal(Object oBigDecimal): Entrada");
      if (oBigDecimal != null) {
        UtilidadesLog.info("MONINTBean.objectToBigDecimal(Object oBigDecimal): Salida");
        return (BigDecimal) oBigDecimal;
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToBigDecimal(Object oBigDecimal): Salida");
        return null;  
      }
  }

  private Timestamp objectToTimestamp(Object oTimestamp){
      UtilidadesLog.info("MONINTBean.objectToTimestamp(): Entrada");
      if (oTimestamp != null) {
          UtilidadesLog.info("MONINTBean.objectToTimestamp(): Salida");
          return (Timestamp) oTimestamp;
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToTimestamp(): Salida");
        return null;  
      }
  }
  
  private Float objectToFloat(Object oFloat){
      UtilidadesLog.info("MONINTBean.objectToFloat(Object oFloat): Entrada");
      if (oFloat != null) {
          UtilidadesLog.info("MONINTBean.objectToFloat(Object oFloat): Salida");
          return (Float) oFloat;
      }          
      else {
        UtilidadesLog.info("MONINTBean.objectToFloat(Object oFloat): Salida");
        return null;
      }
  }

    public DTOSalidaBatch enviarConsultorasDeudasMovsDeudaPdte(DTOINTEnviarConsultorasDeuda dtoE) throws MareException{
        UtilidadesLog.info("MONINTBean.enviarConsultorasDeudasMovsDeudaPdte(DTOINTEnviarConsultorasDeuda dtoE): Entrada");
        
        String mensaje = null;
        IMareDTO  DTOOnline = dtoE;
        if ( dtoE.getEnviarConsultoras().equals(Boolean.TRUE) ) { 
            UtilidadesLog.debug(" *** Entra en el if de enviarConsultoras ***");
            // Se invoca al caso de uso "Enviar Consultoras y Deudas", en modo batch 
    
            MareBusinessID IDOnline =  new MareBusinessID("INTEnviarConsultoras");
            DTOBatch dtoBatch = new DTOBatch("BAN-2", IDOnline , DTOOnline ); // modificado por incidencia BELC300012778
            try{
                UtilidadesLog.debug(" **** Antes de BatchUtil ***");
                BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
            } catch(RemoteException e){
                UtilidadesLog.error(e);                
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
            }
            mensaje += "Enviar Consultoras y Deudas procesado - ";
            UtilidadesLog.debug(" *** Sale del if de consultoras ***");
        } 

        if ( dtoE.getEnviarMovimientos().equals(Boolean.TRUE)) {
            // Se invoca al caso de uso "Enviar Movimientos de Deuda Pendiente", en modo batch 
            UtilidadesLog.debug("*** Entra en el if de enviar Movimientos ***");
            MareBusinessID IDOnline =  new MareBusinessID("INTEnviarMovimientos");
            DTOBatch dtoBatch = new DTOBatch("BAN-3", IDOnline , DTOOnline); // modificado por incidencia BELC300012778
            try {
                BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces") );
            } catch(RemoteException e){
                UtilidadesLog.error(e);                
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));      
            }
            mensaje += "Enviar Movimientos Deuda Pendiente procesado"; 
            UtilidadesLog.debug("*** Sale del if de movimientos **");
        } 
        
        UtilidadesLog.info("MONINTBean.enviarConsultorasDeudasMovsDeudaPdte(DTOINTEnviarConsultorasDeuda dtoE): Salida");
        return  new DTOSalidaBatch( 0, mensaje );
    }

  public DTOSalidaBatch enviarConsultorasYDeudas(DTOBatch dtoBatch) throws MareException {
      //Código modificado por incidencia 12392
      UtilidadesLog.info("MONINTBean.enviarConsultorasYDeudas(DTOBatch dtoBatch): Entrada");
      // Se toma el dto con los datos necesarios extrayéndolo del DTOBatch que se recibe: 
      DTOINTEnviarConsultorasDeuda dtoe = (DTOINTEnviarConsultorasDeuda)dtoBatch.getDTOOnline(); 

      // Obtenemos una referencia al sistema gestor de interfaces, y creamos la interfaz BAN2: 
      MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",MONGestorInterfacesHome.class);                  
      MONGestorInterfaces gestor = null;
      try {
          gestor = home.create(); 
      } catch(Exception e) {
          UtilidadesLog.error(e);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      // Cambia por incidencia 13002
      InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_BAN2,
                                            dtoe.getNumeroLote(),
                                            dtoe.getOidPais());
      InterfazInfo interfaz = null;
      try {
          interfaz = gestor.crearInterfaz(info);
          interfaz.setObservaciones(dtoe.getObservaciones());
          interfaz.setDescripcionLote(dtoe.getDescripcionLote());
          
          RegistroSicc registro = new RegistroSicc();
          DAOINT dao = new DAOINT();
          /* DTOOIDs listaMarcas = dao.obtenerMarcas( codigoProceso = ConstantesCCC.PROCESO_CON006, 
          codigoSubproceso = "1", 
          indicadorES = CCCConstantes.MARCA_ENTRADA ) */
          DTOOIDs listaMarcas = dao.obtenerMarcas( CCCConstantes.PROCESO_CON006, "1", 
                                                   CCCConstantes.MARCA_ENTRADA );     

         ArrayList listaClientes = dao.obtenerClientes(dtoe, listaMarcas ); 
    
          // de listaClientes se extrae la lista de los atributos 'oidCliente', y
          // se almacenan en 'listaOIDClientes'
          DTOOIDs listaOidClientes = new DTOOIDs();
          int cantClientes = listaClientes.size();
          //Long[] oids = new Long[cantClientes];
          
          //for(int i = 0; i < cantClientes; i++) {
          //    DTOINTDatosCliente dto = (DTOINTDatosCliente)listaClientes.get(i);
          //    oids[i] = dto.getOidCliente();
          //}
          //listaOidClientes.setOids(oids);
          //ArrayList listaMovs = dao.obtenerMovimientosCCAgrupados(dtoe, listaOidClientes, listaMarcas);
          /*if (listaMovs.size()==0) {
              String mensaje = "Método enviarConsultorasYDeudas finalizado sin registros";
              UtilidadesLog.debug(mensaje);
              gestor.enviarInterfaz(interfaz);   // DBLG500001016 - Que no quede en temporal cuando está vacia.
              return new DTOSalidaBatch( 0, mensaje );
          } */     
          // DTOINTMovimientosCC dtoMov 
          //mientras( listaMovs.tieneElementos ) 
          DTOINTDatosCliente dtoCliente = null;
          for(int j = 0; j < cantClientes; j++) {
              dtoCliente = (DTOINTDatosCliente)listaClientes.get(j);
/*              it = listaMovs.iterator();
              tieneDeuda = false;
          
              while (it.hasNext()) {
                  DTOINTMovimientosCC dto = (DTOINTMovimientosCC) it.next();
                  if((dto.getCliente()).equals(dtoCliente.getOidCliente()) && (dto.getImportePendiente().doubleValue() > 0)) {                    
                      UtilidadesLog.debug("cliente con movim " + dtoCliente.getOidCliente());
                      deuda = dto.getImportePendiente();
                      tieneDeuda = true;
                  }
              }*/
                registro.anyadirCampo(IRegistroSicc.BAN2_CODIGO_CONSULTORA,dtoCliente.getCodigoCliente());
                registro.anyadirCampo(IRegistroSicc.BAN2_DIGITO_CHEQUEO_CLIENTE,dtoCliente.getDigitoControlDocumento());
                registro.anyadirCampo(IRegistroSicc.BAN2_TIPO_DOCUMENTO,dtoCliente.getTipoDocumento());
                registro.anyadirCampo(IRegistroSicc.BAN2_NUMERO_DOCUMENTO_IDENTIDAD,dtoCliente.getNumeroDocumento());
                registro.anyadirCampo(IRegistroSicc.BAN2_DIGITO_CONTROL_DOCUMENTO_IDENTIDAD,dtoCliente.getDigitoControlDocumento());
                registro.anyadirCampo(IRegistroSicc.BAN2_APELLIDO1,dtoCliente.getApellido1());
                registro.anyadirCampo(IRegistroSicc.BAN2_APELLIDO2,dtoCliente.getApellido2());
                registro.anyadirCampo(IRegistroSicc.BAN2_NOMBRE1,dtoCliente.getNombre1());
                registro.anyadirCampo(IRegistroSicc.BAN2_NOMBRE2,dtoCliente.getNombre2());
                registro.anyadirCampo(IRegistroSicc.BAN2_ZONA_CONSULTORA,dtoCliente.getZonaConsultora());
                registro.anyadirCampo(IRegistroSicc.BAN2_CODIGO_TIPO_CLIENTE,dtoCliente.getTipoCliente());
                registro.anyadirCampo(IRegistroSicc.BAN2_CODIGO_SUBTIPO_CLIENTE,dtoCliente.getSubtipoCliente());
                registro.anyadirCampo(IRegistroSicc.BAN2_TIPO_CLASIFICACION,dtoCliente.getTipoClasificacion());
                registro.anyadirCampo(IRegistroSicc.BAN2_CLASIFICACION,dtoCliente.getClasificacion());
                registro.anyadirCampo(IRegistroSicc.BAN2_DEUDA,new BigDecimal(dtoCliente.getImportePendiente().doubleValue()));
                gestor.anyadirRegistro(interfaz,registro);      
                registro.vaciar();
          }
    
          gestor.enviarInterfaz(interfaz);
      } catch (RemoteException ne) {
          if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
              UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
          } else {                                
              throw new MareException(ne.detail != null? ne.detail: ne,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      } catch (InterfacesException ie) {            
          UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
      }
      UtilidadesLog.info("MONINTBean.enviarConsultorasYDeudas(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch(0,"enviarConsultorasYDeudas finalizado");
  }

  public DTOSalidaBatch enviarMovimientosDeudaPendiente(DTOBatch dtoBatch) throws MareException {
      //Código modificado por incidencia 12392
      UtilidadesLog.info("MONINTBean.enviarMovimientosDeudaPendiente(DTOBatch dtoBatch): Entrada");
      // Se toma el dto con los datos necesarios extrayéndolo del DTOBatch que se recibe: 
      DTOINTEnviarConsultorasDeuda dtoe = (DTOINTEnviarConsultorasDeuda)dtoBatch.getDTOOnline(); 

      // Obtenemos una referencia al sistema gestor de interfaces, y creamos la interfaz BAN2: 
      MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",MONGestorInterfacesHome.class);                  
      MONGestorInterfaces gestor = null;
      try {
          gestor = home.create(); 
      } catch(Exception e) {
          UtilidadesLog.error(e);      
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      // Cambia por incidencia 13002
      InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_BAN3,
                                            dtoe.getNumeroLote(),
                                            dtoe.getOidPais());
      InterfazInfo interfaz = null;
      try {
          interfaz = gestor.crearInterfaz(info);
          interfaz.setObservaciones(dtoe.getObservaciones());
          interfaz.setDescripcionLote(dtoe.getDescripcionLote());
          
          RegistroSicc registro = new RegistroSicc();
          DAOINT dao = new DAOINT();
          ArrayList listaClientes = dao.obtenerClientes( dtoe ); 
          /* DTOOIDs listaMarcas = dao.obtenerMarcas( codigoProceso = ConstantesCCC.PROCESO_CON006, 
          codigoSubproceso = "1", 
          indicadorES = CCCConstantes.MARCA_ENTRADA ) */
          DTOOIDs listaMarcas = dao.obtenerMarcas( CCCConstantes.PROCESO_CON006, "1", 
                                                   CCCConstantes.MARCA_ENTRADA );     
    
          // de listaClientes se extrae la lista de los atributos 'oidCliente', y
          // se almacenan en 'listaOIDClientes'
          DTOOIDs listaOidClientes = new DTOOIDs();
          int cantClientes = listaClientes.size();
          
          ArrayList listaMovs =new ArrayList();
          
          int bloques =0;
          bloques = ((cantClientes-1)/1000)+1;
          /*if(cantClientes%1000 == 0)
            bloques = cantClientes/1000;
          else
            bloques = ((cantClientes - (cantClientes%1000)) /1000) +1;*/
          
          UtilidadesLog.debug("cantClientes :" + cantClientes);
          UtilidadesLog.debug("bloques :" + bloques);
          
          int pos=0;
          for (int j = 0; j < bloques; j++) {
              Long[] oids = null;
              if((j+1) == bloques)  
                oids = new Long[listaClientes.size() - (j*1000)];
              else  
                oids = new Long[1000];
              
              for (int i = (1000*j), l=0; (i < cantClientes && i<(1000*(j+1))); i++,l++) {
                  DTOINTDatosCliente dto = (DTOINTDatosCliente)listaClientes.get(i);
                  oids[l] = dto.getOidCliente();
              }
              
              listaOidClientes.setOids(oids);
              
              listaMovs.addAll(dao.obtenerMovimientosCC( dtoe, listaOidClientes, listaMarcas ));
          }
          
          int cantMovimientos = listaMovs.size();
          if (cantMovimientos == 0) {
              String mensaje = "Método enviarMovimientosDeudaPendiente finalizado sin registros";
              UtilidadesLog.debug(mensaje);
              gestor.enviarInterfaz(interfaz);  // DBLG500001016 - Que no quede en temporal cuando está vacia.
              return new DTOSalidaBatch( 0, mensaje );
          }
          // DTOINTMovimientosCC dtoMov 
          //mientras( listaMovs.tieneElementos ) 
          DTOINTMovimientosCC dtoMov = null;
          DTOINTDatosCliente dtoCliente = null;
          ArrayList listaMovsCliente = null;
          Boolean hayDatos = Boolean.FALSE;
          
          int cantMovsCliente;    
          for (int j = 0; j < cantClientes; j++) {
              dtoCliente = (DTOINTDatosCliente)listaClientes.get(j);
              listaMovsCliente = new ArrayList();
              for (int h = 0; h < cantMovimientos; h++) {
                  DTOINTMovimientosCC dtoIntMov =(DTOINTMovimientosCC)listaMovs.get(h);
                  if((dtoIntMov.getCliente()).equals(dtoCliente.getOidCliente())) {
                      listaMovsCliente.add(dtoIntMov);
                  }
              }
              cantMovsCliente = listaMovsCliente.size();
              for(int k = 0; k < cantMovsCliente; k++) {
                  //dtoMov = (DTOINTMovimientosCC)listaMovsCliente.siguiente 
                  hayDatos = Boolean.TRUE;
                  dtoMov = (DTOINTMovimientosCC)listaMovsCliente.get(k);  
          
                  if (dtoMov.getImportePendiente() != null && dtoMov.getImportePendiente().doubleValue() > 0) {
                    registro.anyadirCampo(IRegistroSicc.BAN3_CODIGO_CONSULTORA,dtoCliente.getCodigoCliente());
                    registro.anyadirCampo(IRegistroSicc.BAN3_DIGITO_CONTROL_CHEQUEO,dtoCliente.getDigitoControlDocumento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_TIPO_DOCUMENTO,dtoCliente.getTipoDocumento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_NUMERO_DOCUMENTO_IDENTIDAD,dtoCliente.getNumeroDocumento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_DIGITO_CONTROL_DOCUMENTO_IDENTIDAD,dtoCliente.getDigitoControlDocumento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_CONSULTORA_APELLIDO1,dtoCliente.getApellido1());
                    registro.anyadirCampo(IRegistroSicc.BAN3_CONSULTORA_APELLIDO2,dtoCliente.getApellido2());
                    registro.anyadirCampo(IRegistroSicc.BAN3_CONSULTORA_NOMBRE1,dtoCliente.getNombre1());
                    registro.anyadirCampo(IRegistroSicc.BAN3_CONSULTORA_NOMBRE2,dtoCliente.getNombre2());
                    registro.anyadirCampo(IRegistroSicc.BAN3_ZONA_CONSULTORA,dtoCliente.getZonaConsultora());
                    registro.anyadirCampo(IRegistroSicc.BAN3_CODIGO_EMPRESA,new String());
                    registro.anyadirCampo(IRegistroSicc.BAN3_NUMERO_FACTURA_BOLETA,dtoMov.getNumeroIdentificadorCuota());
                    registro.anyadirCampo(IRegistroSicc.BAN3_TIPO_PERIODO,dtoMov.getCodigoTipoPeriodo());
                    registro.anyadirCampo(IRegistroSicc.BAN3_PERIODO,dtoMov.getCodigoPeriodo());
                    registro.anyadirCampo(IRegistroSicc.BAN3_FECHA_DOCUMENTO,dtoMov.getFechaDocumento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_FECHA_VENCIMIENTO,dtoMov.getFechaVencimiento());
                    registro.anyadirCampo(IRegistroSicc.BAN3_MODO_PAGO,dtoMov.getMedioPago());
                    registro.anyadirCampo(IRegistroSicc.BAN3_REFERENCIA_EXTERNA,dtoMov.getReferenciaNumeroDocumentoExterno());
                    registro.anyadirCampo(IRegistroSicc.BAN3_DEUDA,dtoMov.getImportePendiente());
          
                    gestor.anyadirRegistro(interfaz,registro);
                    //Añadido incidencia 13120
                    registro.vaciar();
                  }
              }    
          }
    
          if (!hayDatos.booleanValue()){
              UtilidadesLog.debug(" *** enviarMovimientosDeudaPendiente Procesado sin datos ***");
              gestor.enviarInterfaz(interfaz);
              return new DTOSalidaBatch(0,"MovDeudaPendiente SIN DATOS");
          }

          gestor.enviarInterfaz(interfaz);
      } catch (RemoteException ne) {
          if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
              UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
          } else {                                
              throw new MareException(ne.detail != null? ne.detail: ne,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      } catch (InterfacesException ie) {            
            UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
      }
      UtilidadesLog.info("MONINTBean.enviarMovimientosDeudaPendiente(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch(0,"enviarMovimientosDeudaPendiente finalizado");
  }

    public DTOINTCargaInicialConsultorasDeudas cargaInicialConsultorasDeudas(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONINTBean.cargaInicialConsultorasDeudas(DTOUnidadAdministrativa dtoe): Entrada");
        DTOINTCargaInicialConsultorasDeudas dtos = new DTOINTCargaInicialConsultorasDeudas();
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(dtoe.getOidPais());
        dtoBelcorp.setOidIdioma(dtoe.getOidIdioma());
        
        MONMantenimientoSEG monSeg = this.getMONMantenimientoSEG();
        MONUnidadesAdministrativas monUA = this.getMONUnidadesAdministrativas();
        MONConfiguracionClientes monCC = this.getMONConfiguracionClientes();
        
        try{
            dtos.setListaEmpresas(monSeg.recuperarEmpresasPorPais(dtoBelcorp));
            dtos.setListaRegiones(new DTOSalida(monUA.obtenerRegiones(dtoe)));
            dtos.setListaZonas(monUA.obtenerZonasPorRegiones(dtoe));
            dtos.setListaTiposClasificacion(monCC.obtenerClasificaciones(dtoBelcorp));
            dtos.setListaTiposSubtiposClientes(monCC.obtenerTipoSubtipo(dtoBelcorp));
        } catch (RemoteException re) {            
            UtilidadesLog.error(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        
        DTOString dtoString = new DTOString();
        dtoString.setOidPais(dtoe.getOidPais());
        dtoString.setCadena(IGestorInterfaces.COD_INTERFAZ_BAN2);
        DTOCargaInicialInterfaz dtoLote = cargaInicial(dtoString);
        
        // A Falta que funcione en CDOS el carga Inicial
        //dtos.setNumeroLote("NumFalso");
        //dtos.setDescripcionLote("Descripcion del lote Falso");
        dtos.setNumeroLote(dtoLote.getNumeroLote().toString());
        dtos.setDescripcionLote(dtoLote.getDescripcion());
        
        UtilidadesLog.info("MONINTBean.cargaInicialConsultorasDeudas(DTOUnidadAdministrativa dtoe): Salida");
        return dtos;
    }


// MONUnidadesAdministrativas
     private MONUnidadesAdministrativas getMONUnidadesAdministrativas() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTBean.getMONUnidadesAdministrativas(): Entrada");
        MONUnidadesAdministrativasHome home = (MONUnidadesAdministrativasHome)UtilidadesEJB.getHome("MONUnidadesAdministrativas", MONUnidadesAdministrativasHome.class);
            
        // Se obtiene el interfaz remoto
        MONUnidadesAdministrativas ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONUnidadesAdministrativas",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTBean.getMONUnidadesAdministrativas(): Salida");               
        return ejb;
    }  

// MONConfiguracionClientes
     private MONConfiguracionClientes getMONConfiguracionClientes() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTBean.getMONConfiguracionClientes(): Entrada");
        MONConfiguracionClientesHome home = (MONConfiguracionClientesHome)UtilidadesEJB.getHome("MONConfiguracionClientes", MONConfiguracionClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONConfiguracionClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTBean.getMONConfiguracionClientes(): Salida");         
        return ejb;
    }   

// MONMantenimientoSEG
     private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTBean.getMONMantenimientoSEG(): Entrada");
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONMantenimientoSEG",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTBean.getMONMantenimientoSEG(): Salida");
        return ejb;
    }   

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

   public Date obtenerUltimaFecha(Long []listaCriterios, String codigoInterfaz) throws MareException {
      UtilidadesLog.info("MONINTBean.obtenerUltimaFecha(Long []listaCriterios, String codigoInterfaz): Entrada");
      // Se recibe un Array de Long con los criterios por los que se debe enviar la interfaz 
        // String criterios = Concatenamos en un String separados por & todos los oids contenidos 
      // en el ArrayList recibido. Si alguno es null, se concatenará el string "null". (por ejemplo: 02&11&null&null&04) 
      
      String criterios = "";
      
      for (int i=0; i < listaCriterios.length; i++) {
         if (listaCriterios[i] != null) {
            criterios += listaCriterios[i].toString();
         } else {
            criterios += "null";
         }
         if (i < listaCriterios.length - 1) {
            criterios += "&";
         }
      }
        
        // Long pais = primera posicion del Array recibido 
        // String codigoInterfaz = codigoInterfaz recibido 
        // Date fecha = DAOINT.obtenerUltimaFecha(pais, codigoInterfaz, criterios) 
      Date fecha = new DAOINT().obtenerUltimaFecha(listaCriterios[0], codigoInterfaz, criterios);
            
      UtilidadesLog.info("MONINTBean.obtenerUltimaFecha(Long []listaCriterios, String codigoInterfaz): Salida");
      return fecha;
   }

    private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
    }

    private MONUnidadesGeograficasHome getMONUnidadesGeograficasHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONUnidadesGeograficasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONUnidadesGeograficas"), MONUnidadesGeograficasHome.class);
    }

    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoSEGHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
    }

    private MONClientesHome getMONClientesHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
    }
    
    private HashMap obtenerDatosClientes(ArrayList listaCltes, Long oidPais) throws MareException{
        UtilidadesLog.info("MONINTBean.obtenerDatosClientes(ArrayList listaCltes, Long oidPais) Entrada");
        StringBuffer filtroClientes = this.crearFiltroClientes(listaCltes);
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT cod_clie, oid_clie ");
        consulta.append(" FROM mae_clien ");
        consulta.append(" WHERE ");
        consulta.append(filtroClientes.toString());
        consulta.append(" AND pais_oid_pais = " + oidPais);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
         
        try {
           resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {         
              codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }      
        
        HashMap hashClie = new HashMap();
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
          for (int i=0; i<resultado.getRowCount(); i++){
              hashClie.put(this.objectToString(resultado.getValueAt(i,"COD_CLIE")), 
                             this.objectToLong(resultado.getValueAt(i,"OID_CLIE")));
          }
        }  
        UtilidadesLog.info("MONINTBean.obtenerDatosClientes(ArrayList listaCltes, Long oidPais) Salida");
        return hashClie;
        
    }    
    
    private HashMap obtenerDatosTransacciones(ArrayList listaTransacc, Long oidPais) throws MareException{
        UtilidadesLog.info("MONINTBean.obtenerDatosTransacciones(ArrayList listaTransacc, Long oidPais) Entrada");
        StringBuffer filtroTransacciones = this.crearFiltroTransacciones(listaTransacc);
        StringBuffer consulta = new StringBuffer();
        consulta.append(" SELECT COD_TIPO_TRAN, OID_TIPO_TRAN ");
        consulta.append(" FROM CCC_TIPO_TRANS ");
        consulta.append(" WHERE ");
        consulta.append(filtroTransacciones.toString());
        consulta.append(" AND pais_oid_pais = " + oidPais);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
         
        try {
           resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {         
              codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }      
        
        HashMap hashTrns = new HashMap();
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
          for (int i=0; i<resultado.getRowCount(); i++){
              hashTrns.put(this.objectToString(resultado.getValueAt(i,"COD_TIPO_TRAN")), 
                             this.objectToLong(resultado.getValueAt(i,"OID_TIPO_TRAN")));
          }
        }  
        UtilidadesLog.info("MONINTBean.obtenerDatosTransacciones(ArrayList listaTransacc, Long oidPais) Salida");
        return hashTrns;
    }
    
    private HashMap obtenerDatosBancos(ArrayList listaBancos) throws MareException{
        UtilidadesLog.info("MONINTBean.obtenerDatosBancos(ArrayList listaBancos) Entrada");
        StringBuffer consulta = new StringBuffer();
        StringBuffer filtroBancos = this.crearFiltroBancos(listaBancos);
        consulta.append(" SELECT OID_CUEN_CORR_BANC, SOCI_OID_SOCI, COD_CC ");
        consulta.append(" FROM CCC_CUENT_CORRI_BANCA  ");
        consulta.append(" WHERE ");
        consulta.append(filtroBancos.toString());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
         
        try {
           resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {         
              codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }      
        
        HashMap hashBancos = new HashMap();
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
          for (int i=0; i<resultado.getRowCount(); i++){
              DTOINTCtaCteEmpresa datosCtaCteEmpresa = new DTOINTCtaCteEmpresa();
              datosCtaCteEmpresa.setOidCtaCteBanc(this.bigDecimalToLong(resultado.getValueAt(i,"OID_CUEN_CORR_BANC")));
              datosCtaCteEmpresa.setSociedad(this.bigDecimalToLong(resultado.getValueAt(i,"SOCI_OID_SOCI")));
              
              UtilidadesLog.debug("COD_CC: " + this.objectToString(resultado.getValueAt(i,"COD_CC")));              
              
              hashBancos.put(this.objectToString(resultado.getValueAt(i,"COD_CC")), 
                             datosCtaCteEmpresa);
          }
        }  
        UtilidadesLog.info("MONINTBean.obtenerDatosBancos(ArrayList listaBancos) Salida");
        return hashBancos;
    }
    
    private StringBuffer crearFiltroBancos(ArrayList listaBcos) throws MareException{
        StringBuffer filtroBancos = new StringBuffer();
        filtroBancos.append(" ");
        if (listaBcos.size() > 0) {
            filtroBancos.append(" (");      
            String bancos = "";
            int k = 0;
            Iterator  it = listaBcos.iterator();
            while (it.hasNext()){
                String oid = (String)it.next();
                if (k == 0) {
                  bancos = "'" + oid.toString() + "'";
                } else {
                  bancos = bancos + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroBancos.append(" COD_CC IN (" + bancos.toString() + ") ");
                  if (it.hasNext()){
                      filtroBancos.append(" OR ");                  
                  }                
                  k=0;
                  bancos = "";
                } else {
                   if (!it.hasNext()){
                        filtroBancos.append(" COD_CC IN (" + bancos.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroBancos.append(" ) ");      
        }     
        
        return filtroBancos;
    }
    
    private StringBuffer crearFiltroTransacciones(ArrayList listaTrn) throws MareException{
        StringBuffer filtroTrn = new StringBuffer();
        filtroTrn.append(" ");
        if (listaTrn.size() > 0) {
            filtroTrn.append("  (");      
            String transacciones = "";
            int k = 0;
            Iterator  it = listaTrn.iterator();
            while (it.hasNext()){
                String oid = (String)it.next();
                if (k == 0) {
                  transacciones = "'" + oid.toString() + "'";
                } else {
                  transacciones = transacciones + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroTrn.append(" COD_TIPO_TRAN IN (" + transacciones.toString() + ") ");
                  if (it.hasNext()){
                      filtroTrn.append(" OR ");                  
                  }                
                  k=0;
                  transacciones = "";
                } else {
                   if (!it.hasNext()){
                        filtroTrn.append(" COD_TIPO_TRAN IN (" + transacciones.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroTrn.append(" ) ");      
        }     
        
        return filtroTrn;
    }
  
        private StringBuffer crearFiltroClientes(ArrayList listaClies) throws MareException{
        StringBuffer filtroClie = new StringBuffer();
        filtroClie.append(" ");
        if (listaClies.size() > 0) {
            filtroClie.append(" (");      
            String clientes = "";
            int k = 0;
            Iterator  it = listaClies.iterator();
            while (it.hasNext()){
                String oid = (String)it.next();
                if (k == 0) {
                  clientes = "'" + oid.toString() + "'";
                } else {
                  clientes = clientes + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroClie.append(" cod_clie IN (" + clientes.toString() + ") ");
                  if (it.hasNext()){
                      filtroClie.append(" OR ");                  
                  }                
                  k=0;
                  clientes = "";
                } else {
                   if (!it.hasNext()){
                        filtroClie.append(" cod_clie IN (" + clientes.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroClie.append(" ) ");      
        }     
        
        return filtroClie;
    }

    private Long bigDecimalToLong(Object numero) {
      if (numero != null) {
          return new Long(((BigDecimal) numero).longValue());
      } else {
          return null;
      }
    }    
    
    private void grabarMovimientoBancario(HashMap hashMovimientosBancos, Long subprocesoMarcaCreacion, Long pais, 
                                          Long numLote, Long tipoAbono, Integer numHist) throws MareException {
        UtilidadesLog.info("MONINTBean.grabarMovimientoBancario(DTOINTRecepcionarBancosRegistro registro): Entrada");
        StringBuffer query = new StringBuffer();
        
        Iterator it = ((Collection) hashMovimientosBancos.values()).iterator();
        
        while (it.hasNext()){ 
            DTOINTRecepcionarBancosRegistro registro = (DTOINTRecepcionarBancosRegistro)it.next();
            if (!(registro == null)){
                //armo string de insercion
                
                UtilidadesLog.debug("genero cadena con dto.: " + registro);
                query.append(this.armadoStrInsert(registro, subprocesoMarcaCreacion, pais, numLote, tipoAbono, numHist));
            }
        }
        if (query!=null){
            //se envia a BD  
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            try {      
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
            } catch (Exception e) {
              throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }            
        }
        UtilidadesLog.info("MONINTBean.grabarMovimientoBancario(DTOINTRecepcionarBancosRegistro registro): Salida");        
    }
    
    private StringBuffer armadoStrInsert(DTOINTRecepcionarBancosRegistro rec, Long subprocesoMarcaCreacion, Long oidPais, 
                                         Long lote, Long tipoAbono, Integer numHist) throws MareException {
        UtilidadesLog.info("MONINTBean.armadoStrInsert(DTOINTRecepcionarBancosRegistro rec, Long subMC, Long oidPais, Long tipoAbonoCreacion, Long subprocesoMarcaCreacion): Entrada");
        
        StringBuffer cadena = new StringBuffer();
        
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
        // gPineda - V-CCC040 - 26/01/2007
        SimpleDateFormat simpledateformatHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //Fecha de sistema:
        java.util.Date now = GregorianCalendar.getInstance().getTime();		   
        long feP = now.getTime();			
        java.sql.Date fechaSistema = new java.sql.Date(feP);
        UtilidadesLog.debug("***  " + fechaSistema);
        
        try {
            cadena.append("INSERT INTO CCC_MOVIM_BANCA ( ");
            cadena.append(" OID_MOVI_BANC, ");
            cadena.append(" SOCI_OID_SOCI, ");
            cadena.append(" SUBP_OID_MARC_CREA, "); 
            cadena.append(" TCAB_OID_ABON_CREA, "); 
            cadena.append(" CCBA_OID_CC_BANC, ");
            cadena.append(" NUM_CONS_TRAN, ");
            cadena.append(" NUM_LOTE, ");
            cadena.append(" PAIS_OID_PAIS, ");
            cadena.append(" CLIE_OID_CLIE, ");          
            cadena.append(" COD_CONS, ");
            cadena.append(" COD_ERRO, ");
            cadena.append(" VAL_DIGI_CHEQ_FACT, ");
            cadena.append(" VAL_ESTA_MOVI_PEND, ");
            cadena.append(" FEC_PAGO, ");
            cadena.append(" FEC_PROC, ");
            cadena.append(" VAL_HORA_PROC, ");
            cadena.append(" VAL_HORA_NORM_ADIC, ");
            cadena.append(" COD_IDEN_PROC, ");
            cadena.append(" IMP_PAGO, ");
            cadena.append(" VAL_NOMB_OFIC, ");
            cadena.append(" VAL_NUME_DOCU, ");
            cadena.append(" NUM_FACT_BOLE, ");
            cadena.append(" NUM_LOTE_EXTE, ");
            cadena.append(" COD_OFIC_RECA, ");
            cadena.append(" VAL_USUA_PROC, ");
            cadena.append(" NUM_CUPO, ");
            cadena.append(" TTRA_OID_TIPO_TRANS, ");
            cadena.append(" COD_USUA, ");
            cadena.append(" TIER_OID_ERRO, ");
            cadena.append(" TCAB_OID_ABON_ULTI, ");
            cadena.append(" SUBP_OID_MARC_ULTI, ");
            //CNoziglia corrigiendo errores tras la performance
            cadena.append(" IMP_APLI, ");
            cadena.append(" IMP_SALD_PEND, ");
            cadena.append(" VAL_IMPO_MOVI, ");  
            
            //cvalenzu - V-CCC-016 - FEC_MOVI_APLI debe tener sysdate
            cadena.append(" FEC_MOVI_APLI, ");  
            //FIN - cvalenzu - V-CCC-016 - FEC_MOVI_APLI debe tener sysdate
            
            cadena.append(" NUM_HIST ");
            
            cadena.append(" ) VALUES ( ");
            
            cadena.append("CCC_CMBA_SEQ.NEXTVAL, ");
            cadena.append(rec.getEmpresa() +  ",");
            cadena.append(subprocesoMarcaCreacion +  ",");
            cadena.append(tipoAbono +  ",");
            cadena.append(rec.getOidCtaCte() +  ",");
            cadena.append(rec.getConsecutivoTransaccion() +  ",");
            cadena.append(lote+  ",");
            cadena.append(oidPais +  ",");
            cadena.append(rec.getOidCliente() +  ",");
            
            //cvalenzu - Incidencia V_CCC_12 - 4/12/2006
            //cadena.append(rec.getCodConsultora() +  ",");
            cadena.append("'" + rec.getCodConsultora() +  "',");
            //FIN - Incidencia V_CCC_12
            
            cadena.append("'" + rec.getCodigoError() +  "',");
            cadena.append(rec.getDigitoChequeoFactura() +  ",");
            cadena.append("'" + CCCConstantes.MOVIMIENTO_BANCARIO_PENDIENTE +  "',");
            cadena.append(" TO_Date( '" + simpledateformat.format(toDate(rec.getFechaPago())) +
                "', 'DD-MM-YYYY'), ");
            // gPineda - V-CCC040 - 26/01/2007
            //cadena.append(" TO_Date( '" + simpledateformat.format(rec.getFechaProceso()) +
            //    "', 'DD-MM-YYYY'), ");        
            cadena.append(" TO_Date( '" + simpledateformatHora.format(rec.getFechaProceso()) +
            "', 'YYYY-MM-DD HH24:MI:SS'), ");        

            /* gPineda - V-CCC040 - 26/01/2007
            cadena.append(" TRUNC(TO_DATE (substr('" + rec.getEnvioFecha() +
                "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')),  "); */
            cadena.append(" TO_DATE (substr('" + simpledateformatHora.format(rec.getEnvioFecha()) +
                "', 1, 19), 'YYYY-MM-DD HH24:MI:SS'),  "); 
                
            cadena.append("'" + rec.getHorarioNormalAdicional() +  "',");
            cadena.append("'" + rec.getIdenProceso() +  "',");
            cadena.append(rec.getImportePago() +  ",");
            
            cadena.append("'" + rec.getNombreOficina() +  "',");
            
            cadena.append("'" + rec.getNumeroDocumento() +  "',");
            
            //cvalenzu - V-CCC-016 - NUM_FACT_BOLE debe tener NULL si se recibe null
            //estaba poniendo ceros.
            if(rec.getNumeroFacturaBoleta()!=null && rec.getNumeroFacturaBoleta().longValue()!=0) {
              cadena.append(rec.getNumeroFacturaBoleta() +  ",");  
            }
            else {
              cadena.append("NULL ,");
            }           
            //FIN - cvalenzu - V-CCC-016 - NUM_FACT_BOLE debe tener NULL si se recibe null
            
            cadena.append(rec.getNumeroLoteExterno() +  ",");
            
            // gPineda - V-CCC040 - 26/01/2007
            if( rec.getOficinaRecaudadora().equals("") ){
                cadena.append(" NULL, ");
            }else{
                cadena.append(rec.getOficinaRecaudadora() +  ",");
            }
            
            cadena.append("'" + rec.getUsuarioProceso() +  "',");
                
            
            //cvalenzu - V-CCC-016 - NUM_CUPO debe tener NULL si se recibe null
            //estaba poniendo ceros.
            if(rec.getNumeroCupon()!=null && rec.getNumeroCupon().longValue()!=0) {
              cadena.append(rec.getNumeroCupon() +  ",");  
            }
            else {
              cadena.append("NULL ,");
            }                     
            //FIN - cvalenzu - V-CCC-016 - NUM_CUPO debe tener NULL si se recibe null           
            
            cadena.append(rec.getOidTipoTransaccion() +  ",");
            cadena.append("'" + sessionContext.getCallerPrincipal().getName() +  "',");
            cadena.append(rec.getErrorOid() + ",");
            cadena.append(tipoAbono + ",");
            cadena.append(subprocesoMarcaCreacion + ",");
            //CNoziglia corrigiendo errores tras la performance
            cadena.append("0" + ",");//IMP_APLI va 0 por defecto
            cadena.append(rec.getImportePago() +  ",");//IMP_SALD_PEND
            cadena.append(rec.getImportePago() +  ",");//VAL_IMPO_MOVI
            
            /* gPineda - V-CCC040 - 26/01/2007 - El formato debe incluir la hora
            //cvalenzu - V-CCC-016 - FEC_MOVI_APLI debe tener sysdate
            cadena.append(" TO_Date( '" + simpledateformat.format(fechaSistema) +
                "', 'DD-MM-YYYY'), ");        
            //FIN - cvalenzu - V-CCC-016 - FEC_MOVI_APLI debe tener sysdate */
            cadena.append(" TO_Date( '" + simpledateformatHora.format(fechaSistema) +
                "', 'YYYY-MM-DD HH24:MI:SS'), ");  
           
           
            cadena.append(numHist);
            
            //cadena.append(tipoAbonoCreacion +  ",");
            
           //N,I,15.0,,,0,360,00000,,0,CTB06,guest,1) 
            cadena.append(");");
        }catch(Exception e){      
          throw new MareException(
              CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ,
              e);
        }              
        UtilidadesLog.info("MONINTBean.armadoStrInsert(DTOINTRecepcionarBancosRegistro rec, Long subMC, Long oidPais, Long tipoAbonoCreacion, Long subprocesoMarcaCreacion): Salida");
        return cadena;
    }

    public DTOSalidaBatch recepcionarMovimientosBatchDeamon(DTOBatch dtoBatch) throws MareException
    {
        IMareDTO dtoPais = (DTOString)dtoBatch.getDTOOnline();
        DTORecepcionarMovimientos dto = new DTORecepcionarMovimientos();
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
          dto.setOidPais( paisLocal.getOid());
          dto.setNumeroLote(new Long(getMONGestorInterfacesHome().create().obtenerNumeroLote()));
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException();
        }
        dto.setObservaciones("");
        dto.setDescripcionLote("");
        dto.setFechaGenerar(new java.sql.Date(System.currentTimeMillis()));
        DTOBatch dtoB = new DTOBatch(" ", new MareBusinessID( " " ), dto);
        this.recepcionarMovimientosBatch(dtoB);
        return new DTOSalidaBatch(0,"Proceso recepcionar Movimientos Bancarios por demonio finalizado");
    }

    private ProcesosLocalHome getProcesosLocalHome() {
            return new ProcesosLocalHome();
    }

    private SubprocesosLocalHome getSubprocesosLocalHome() {
            return new SubprocesosLocalHome();
    }

    private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() {
            return new TiposAbonoSubprocesoLocalHome();
    }

    private TiposAbonoLocalHome getTiposAbonoLocalHome() {
            return new TiposAbonoLocalHome();
    }

    private TiposErrorLocalHome getTiposErrorLocalHome() {
            return new TiposErrorLocalHome();
    }
    
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }
    
    private ViaLocalHome getViaLocalHome() {
            return new ViaLocalHome();
    }
    

}
