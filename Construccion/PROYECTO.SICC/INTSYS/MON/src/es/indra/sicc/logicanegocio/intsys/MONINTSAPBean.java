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

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.bel.DTOStock;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.bel.MovimientosAlmacenDetalleLocal;
import es.indra.sicc.logicanegocio.intsys.PaqueteDeAyudaIdioma.GestorIdiomasINT; //incidencia 20408
import es.indra.sicc.util.Cronometrador;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.lang.Math;
import javax.ejb.CreateException;
import javax.ejb.SessionBean; 
import javax.ejb.SessionContext;
import javax.ejb.FinderException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
//import es.indra.sicc.cmn.negocio.interfaces.exception.InterfacesFinFicheroException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTORegistroInterface;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.intsys.DTOINTEnviarMovimientos;
import es.indra.sicc.dtos.intsys.DTOINTAsignacionAlmacen;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialStockDiarios;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.logicanegocio.intsys.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.bel.MONRegistroAbastecimiento;
import es.indra.sicc.logicanegocio.bel.MONRegistroAbastecimientoHome;
import es.indra.sicc.logicanegocio.bel.DAOMovimientosAlmacen;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenBean;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.bel.AlmacenesLocal;
import es.indra.sicc.entidades.bel.AlmacenesLocalHome;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocal;
import es.indra.sicc.entidades.bel.TipoMovimientosAlmacenLocalHome;
import es.indra.sicc.entidades.bel.MovimientosAlmacenCabeceraLocalHome;
import es.indra.sicc.entidades.bel.MovimientosAlmacenDetalleLocalHome;
import es.indra.sicc.entidades.bel.OperacionesLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;//Añadido por incidencia 12389
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;//Añadido por incidencia 12389
import es.indra.sicc.entidades.seg.IdiomaLocal;
import es.indra.sicc.entidades.seg.IdiomaLocalHome;
import es.indra.sicc.entidades.seg.MarcaProductoLocal;
import es.indra.sicc.entidades.seg.MarcaProductoLocalHome;
import es.indra.sicc.entidades.intsys.MovimientoStockLocal;
import es.indra.sicc.entidades.intsys.MovimientoStockLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.mae.UnidadesNegocioLocal;
import es.indra.sicc.entidades.mae.UnidadesNegocioLocalHome;
import es.indra.sicc.entidades.mae.NegocioLocal;
import es.indra.sicc.entidades.mae.NegocioLocalHome;
import es.indra.sicc.entidades.mae.EstatusLocal;
import es.indra.sicc.entidades.mae.EstatusLocalHome;
import es.indra.sicc.entidades.mae.GenericoLocal;
import es.indra.sicc.entidades.mae.GenericoLocalHome;
import es.indra.sicc.entidades.mae.SuperGenericoLocal;
import es.indra.sicc.entidades.mae.UnidadesMedidaLocal;
import es.indra.sicc.entidades.mae.UnidadesMedidaLocalHome;
import es.indra.sicc.entidades.mae.SuperGenericoLocalHome;
import es.indra.sicc.entidades.mae.MagnitudLocal;
import es.indra.sicc.entidades.mae.MagnitudLocalHome;
import es.indra.sicc.entidades.pre.TipoOfertaLocal;
import es.indra.sicc.entidades.pre.TipoOfertaLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONINTSAPBean implements SessionBean  {
    private final static String MON_PROCESO_PED = "MONProcesosPED";
    private SessionContext ctx;
    private DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen;
    private final static int cantidadRegistrosAProcesar = 2000; 
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
      this.ctx=ctx;
    }

    public void generarEntradaSAP(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.generarEntradaSAP(DTOOID dto): Entrada");
        //El ssitema comprueba si ha recibido la interfaz desde SAP
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        MONRegistroAbastecimiento ra = this.getMONRegistroAbastecimiento();
        InterfazInfo interfaz=null;
        IRegistroSicc registro = null;
        try{
          try{
              //Modificado por incidencia BELC300012238
              interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAM50,dto.getOid());  
              UtilidadesLog.debug("****Interfaz Importada");
          }catch (InterfacesException iex) {
              UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException: "+iex);
              //INT-0002	No hay fichero de interfaz: 
              //Modificado por incidencia BELC300012259
              //Eliminada la linea por incidencia BELC300016779
              //DTOINTError dtoError = new DTOINTError (interfaz,registro,ErroresDeNegocio.INT_0002 + IGestorInterfaces.COD_INTERFAZ_SAM50);
              //gi.registrarError(dtoError);
              UtilidadesLog.debug("Error importarInterfaz: "+ErroresDeNegocio.INT_0002 +" "+ IGestorInterfaces.COD_INTERFAZ_SAM50);
              return;
          }catch(RemoteException re){              
              UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException");
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          }
          try{
              String codigoIdioma=null;
              DTORegistroInterface registroInterface=null;
              //registro = gi.cargarRegistro(interfaz);
              while ((registro=gi.cargarRegistro(interfaz))!=null){
                  UtilidadesLog.debug("****Registro de la Interfaz cargado: ");
                  registroInterface = new DTORegistroInterface();
                  registroInterface.setCodigoPais((String)registro.obtenerCampo(IRegistroSicc.SAM50_PAIS));
                  registroInterface.setCodigoCanal((String)registro.obtenerCampo(IRegistroSicc.SAM50_CANAL));
                  registroInterface.setCodigoAcceso((String)registro.obtenerCampo(IRegistroSicc.SAM50_ACCESO));
                  registroInterface.setCodigoSubacceso((String)registro.obtenerCampo(IRegistroSicc.SAM50_SUBACCESO));
                  if (registro.obtenerCampo(IRegistroSicc.SAM50_FECHA_RECEPCION_INT)!=null){
                    registroInterface.setFechaRecepcionInteface(new Timestamp(((Date)registro.obtenerCampo(IRegistroSicc.SAM50_FECHA_RECEPCION_INT)).getTime()));
                  }
                  registroInterface.setUnidadesConfirmadas((BigDecimal)registro.obtenerCampo(IRegistroSicc.SAM50_UNIDADES_CONFIRMADAS));
                  registroInterface.setNumeroSolicitudReposicion((String)registro.obtenerCampo(IRegistroSicc.SAM50_NUMERO_SOLICITUD_REPOSICION));
                  //Añadido por incidencia 13783
                  registroInterface.setCodigoProducto((String)registro.obtenerCampo(IRegistroSicc.SAM50_CODIGO_PRODUCTO));
                  ra.generarEntradaSAP(registroInterface);              
              }
          }catch (InterfacesException iex) {
              UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException");
              //INT-0002	No hay fichero de interfaz: 
              //Modificado por incidencia BELC300012259
              DTOINTError dtoError = new DTOINTError (interfaz,registro,ErroresDeNegocio.INT_0002 + IGestorInterfaces.COD_INTERFAZ_SAM50);
              gi.registrarError(dtoError);
              return;
          }catch(RemoteException re){              
              UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException");
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
          }        
        }catch (InterfacesException ix){
          UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");
        }catch(RemoteException re){              
              UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
  
        }
        UtilidadesLog.info("MONINTSAPBean.generarEntradaSAP(DTOOID dto): Salida");
    }


    public void recepcionarNegocio(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.recepcionarNegocio(DTOOID pais): Entrada");
        /*Documentation
        1 - el sistema comprueba si ha recibido la interfaz desde SAP: 
        MONGestorInterfaces gi = MONGestorInterfacesHome.create() 
        InterfazInfo interfaz = gi.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAM1, pais.oid ) 
        Si se recibe una InterfacesException finaliza el caso de uso 
        */
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo interfaz=null;
        IRegistroSicc registro=null;
        String codigoIdioma=null;
        String codigo=null;
        String descripcion=null;
        IdiomaLocalHome idiomaLocalHome= this.getIdiomaLocalHome();
        IdiomaLocal idiomaLocal=null;
        NegocioLocalHome negocioLocalHome= this.getNegocioLocalHome();
        NegocioLocal negocioLocal=null;
        Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
        Entidadi18nLocal e18nLocal=null;
        try 
        {

            // sapaza -- Error en Lectura de archivos SAM -- 15/06/2011
            try {
                interfaz=gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAM1,pais.getOid());
            }catch (InterfacesException ie) {        
                UtilidadesLog.error("ERROR", ie);
                throw new MareException(ie,
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
            }

          while ((registro=gi.cargarRegistro(interfaz))!=null)
          {
            //Ver diseño incidencia 12782
            codigo = (String)registro.obtenerCampo(IRegistroSicc.SAM1_CODIGO);
            if (codigo==null || codigo.trim().equals("")) 
            {
                DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + " código");
                gi.registrarError(dtoError);
                continue;
            }
            descripcion = (String)registro.obtenerCampo(IRegistroSicc.SAM1_DESCRIPCION);
            if (descripcion==null || descripcion.trim().equals("")) 
            {
                DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + " descripción");
                gi.registrarError(dtoError);
                continue;
            }
            
            try 
            {
              codigoIdioma = (String)registro.obtenerCampo(IRegistroSicc.SAM1_CODIGO_IDIOMA );
              idiomaLocal = idiomaLocalHome.findByCodigo(codigoIdioma) ;
            }catch (NoResultException fe) {
              // El idioma no existe 
              //gi.registrarError( interfaz, registro, mensaje INT-0001 + codigoIdioma ) 
              DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0001 + codigoIdioma);
              gi.registrarError(dtoError);
              continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            try 
            { 
                negocioLocal = negocioLocalHome.findByUk(pais.getOidPais(),codigo);
                if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)) 
                {
                    //Se actualiza la descripción con registro.obtenerCampo( IRegistroSicc.SAM1_DESCRIPCION ) 
                    //Hay que obtener el registro correspondiente a i18n
                    try 
                    {
                        UtilidadesLog.debug("Existe el negocio. Busca el registro en i18n");
                        e18nLocal=e18nLH.findByEntAtrIdioPK("MAE_NEGOC", new Long(1),idiomaLocal.getOid(),negocioLocal.getOid());
                    }catch (NoResultException fe)
                    {
                        UtilidadesLog.error("recepcionarNegocio: No hay datos en I18N FinderException", fe);
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "gen_i18n_sicc " + "Exception" + fe.getMessage());
                        gi.registrarError(dtoError);
                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }//fin try
                    UtilidadesLog.debug("Actualiza el registro en la tabla i18n");
                    //e18nLocal.setDetalle(descripcion);    //  Modificado por Incidencia Sicc20080595
                    DAOINT dao = new DAOINT();
                    dao.actualizarDescripcion18n(e18nLocal.getOid(), "MAE_NEGOC", descripcion);
                }else
                {
                    
                    //modificado por incidencia 20408
                    //idioma <>ES
                    UtilidadesLog.debug("El idioma es distinto de ES"); 
                    GestorIdiomasINT gestorIdiomas= new GestorIdiomasINT();
                    gestorIdiomas.setSessionContext(this.ctx);
                    gestorIdiomas.generarDescripcionIdiomaNoES(negocioLocal.getOid(), "MAE_NEGOC",idiomaLocal.getOid(), descripcion);
                }//fin si
            } catch (NoResultException fex) 
            {
                if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)) 
                {
                    // No existe el negocio, hay que crearlo
                    try 
                    {
                        UtilidadesLog.debug("No existe el negocio. Lo creamos");
                        negocioLocal = negocioLocalHome.create( pais.getOidPais(), codigo);
                        //Insertamos en la tabla I18N
                        UtilidadesLog.debug("Inserta en i18n");
                        e18nLocal=e18nLH.create("MAE_NEGOC",new Long(1),idiomaLocal.getOid(),descripcion ,negocioLocal.getOid());
                        UtilidadesLog.debug("Ha insertado en i18n");
                    }catch(PersistenceException ce) 
                    {
                        UtilidadesLog.error("*** Error create en recepcionarNegocio", ce);
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Negocio " + "Exception: " + ce.getMessage());
                        gi.registrarError(dtoError);
                        continue;
                    }//fin try
                }else
                {
                    //idioma<>es
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Negocio");
                    gi.registrarError(dtoError);
                    continue;
                }//fin if
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }//fin try
          }//fin while
        } catch (RemoteException re) 
        {          
          ctx.getRollbackOnly();
          UtilidadesLog.error("***MONINTSAP.recepcionarNegocio: error RemoteException");
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) 
        {          
          ctx.getRollbackOnly();
          UtilidadesLog.error("***ACABA CASO DE USO MONINTSAP.recepcionarNegocio: error InterfacesException");
          return;

        }
        UtilidadesLog.info("MONINTSAPBean.recepcionarNegocio(DTOOID pais): Salida");
    }

    public void recepcionarSupergenerico(DTOOID pais) throws MareException {
        /*1 - el sistema comprueba si ha recibido la interfaz desde SAP: 
        MONGestorInterfaces gi = MONGestorInterfacesHome.create() 
        InterfazInfo interfaz = gi.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAM2, pais.oid ) 
        Si se recibe una InterfacesException finaliza el caso de uso*/
        UtilidadesLog.info("MONINTSAPBean.recepcionarSupergenerico(DTOOID pais): Entrada");
        Cronometrador.startTransaction("MONINTSAPBean.recepcionarSupergenerico");
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo interfaz=null;
        IRegistroSicc registro=null;
        String codigoIdioma=null;
        String codigoSupergenerico=null;
        String descripcion=null;
        IdiomaLocalHome idiomaLocalHome= this.getIdiomaLocalHome();
        IdiomaLocal idiomaLocal=null;
        SuperGenericoLocalHome superGenericoLocalHome= this.getSuperGenericoLocalHome();
        SuperGenericoLocal superGenericoLocal=null;
        Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
        Entidadi18nLocal e18nLocal=null;
          
        try{
            // sapaza -- Error en Lectura de archivos SAM -- 15/06/2011
            try {
                interfaz=gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAM2,pais.getOid());
            }catch (InterfacesException ie) {        
                UtilidadesLog.error("ERROR", ie);
                throw new MareException(ie,
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
            }

            while ((registro=gi.cargarRegistro(interfaz))!=null){
                Cronometrador.startTransaction("RegistroSuperGenerico");
                codigoSupergenerico = (String)registro.obtenerCampo(IRegistroSicc.SAM2_CODIGO_SUPERGENERICO);
                if (codigoSupergenerico==null || codigoSupergenerico.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + "codigo supergenerico");
                    gi.registrarError(dtoError);
                    continue;
                }
                descripcion = (String)registro.obtenerCampo(IRegistroSicc.SAM2_DESCRIPCION);
                if (descripcion==null || descripcion.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + "descripcion ");
                    gi.registrarError(dtoError);
                    continue;
                }
                try{
                    codigoIdioma = (String)registro.obtenerCampo(IRegistroSicc.SAM2_CODIGO_IDIOMA );
                    idiomaLocal = idiomaLocalHome.findByCodigo(codigoIdioma) ;
                }catch (NoResultException fe) {
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try{
                    superGenericoLocal = superGenericoLocalHome.findByUk(pais.getOidPais(),codigoSupergenerico);
                    if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)){
                        try{
                            UtilidadesLog.debug("Existe superGenerico. Busca el registro en i18n");
                            e18nLocal=e18nLH.findByEntAtrIdioPK("MAE_SUPER_GENER", new Long(1),idiomaLocal.getOid(),superGenericoLocal.getOid());
                        }catch (NoResultException fe){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "gen_i18n_sicc " + "Exception" + fe.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        UtilidadesLog.debug("Actualiza el registro en la tabla i18n");
                        //e18nLocal.setDetalle(descripcion);    //  Modificado por Incidencia Sicc20080595
                        DAOINT dao = new DAOINT();
                        dao.actualizarDescripcion18n(e18nLocal.getOid(), "MAE_SUPER_GENER", descripcion);
                    }else{
                        //modificado por incidencia 20408
                        UtilidadesLog.debug("El idioma es distinto de ES");   
                        GestorIdiomasINT gestorIdiomas= new GestorIdiomasINT();
                        gestorIdiomas.setSessionContext(this.ctx);
                        gestorIdiomas.generarDescripcionIdiomaNoES(superGenericoLocal.getOid(), "MAE_SUPER_GENER",idiomaLocal.getOid(), descripcion);
                    }
                } catch( NoResultException fex ) { 
                    // No existe supergenerico, hay que crearlo
                    if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)){
                        try{
                            superGenericoLocal = superGenericoLocalHome.create( pais.getOidPais(), codigoSupergenerico);
                            e18nLocal=e18nLH.create("MAE_SUPER_GENER",new Long(1),idiomaLocal.getOid(),descripcion,superGenericoLocal.getOid());
                        }catch(PersistenceException ce1){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "SuperGenerico " + "Exception: " + ce1.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }
                    }else{
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Supergenerico");
                        gi.registrarError(dtoError);
                        continue;
                    }//Fin if
                 }  catch (PersistenceException ce) {   
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } // Fin catch 
                Cronometrador.endTransaction("RegistroSuperGenerico");
            }// Fin while
        }catch (RemoteException re){              
            ctx.getRollbackOnly();
            UtilidadesLog.error("***MONINTSAP.recepcionarSupergenerico: error RemoteException",re);
            throw new MareException(re,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (InterfacesException ie){
            ctx.getRollbackOnly();
            UtilidadesLog.error("***ACABA CASO DE USO MONINTSAP.recepcionarSupergenerico: error InterfacesException",ie);
            return;
        }
        Cronometrador.endTransaction("MONINTSAPBean.recepcionarSupergenerico");
        UtilidadesLog.info("MONINTSAPBean.recepcionarSupergenerico(DTOOID pais): Salida");
    }

    public void recepcionarGenerico(DTOOID pais) throws MareException {
        /*1 - el sistema comprueba si ha recibido la interfaz desde SAP: 
        MONGestorInterfaces gi = MONGestorInterfacesHome.create() 
        InterfazInfo interfaz = gi.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAM3, pais.oid ) 
        Si se recibe una InterfacesException finaliza el caso de uso */
        UtilidadesLog.info("MONINTSAPBean.recepcionarGenerico(DTOOID pais): Entrada");
        Cronometrador.startTransaction("MONINTSAPBean.recepcionarGenerico");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        InterfazInfo interfaz=null;
        IRegistroSicc registro=null;
        String codigoIdioma=null;
        String codigoGenerico=null;
        String descripcion=null;
        IdiomaLocalHome idiomaLocalHome= this.getIdiomaLocalHome();
        IdiomaLocal idiomaLocal=null;
        GenericoLocalHome genericoLocalHome= this.getGenericoLocalHome();
        GenericoLocal genericoLocal=null;
        Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
        Entidadi18nLocal e18nLocal=null;
        
        try{
            // sapaza -- Error en Lectura de archivos SAM -- 15/06/2011
            try {
                interfaz=gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAM3,pais.getOid());
            }catch (InterfacesException ie) {        
                UtilidadesLog.error("ERROR", ie);
                throw new MareException(ie,
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
            }
            
            while ((registro=gi.cargarRegistro(interfaz))!=null){
                Cronometrador.startTransaction("RegistroGenerico");
                codigoGenerico = (String)registro.obtenerCampo(IRegistroSicc.SAM3_CODIGO_GENERICO);
                if (codigoGenerico==null || codigoGenerico.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + "código generico");
                    gi.registrarError(dtoError);
                    continue;
                }
                descripcion = (String)registro.obtenerCampo(IRegistroSicc.SAM3_DESCRIPCION);
                if (descripcion==null || descripcion.trim().equals("")){
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0011 + "descripción");
                    gi.registrarError(dtoError);
                    continue;
                }
                try{
                    codigoIdioma = (String)registro.obtenerCampo(IRegistroSicc.SAM3_CODIGO_IDIOMA );
                    idiomaLocal = idiomaLocalHome.findByCodigo(codigoIdioma);
                }catch (NoResultException fe) {
                    DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                try{ 
                    genericoLocal = genericoLocalHome.findByUk(pais.getOidPais(),codigoGenerico);
                    if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)){
                        try{
                            e18nLocal=e18nLH.findByEntAtrIdioPK("MAE_GENER", new Long(1),idiomaLocal.getOid(),genericoLocal.getOid());
                        }catch (NoResultException fe){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "gen_i18n_sicc " + "Exception" + fe.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        //e18nLocal.setDetalle(descripcion);    //  Modificado por Incidencia Sicc20080595
                        DAOINT dao = new DAOINT();
                        dao.actualizarDescripcion18n(e18nLocal.getOid(), "MAE_GENER", descripcion);
                    }else{
                        GestorIdiomasINT gestorIdiomas= new GestorIdiomasINT();
                        gestorIdiomas.setSessionContext(this.ctx);
                        gestorIdiomas.generarDescripcionIdiomaNoES(genericoLocal.getOid(), "MAE_GENER",idiomaLocal.getOid(), descripcion);
                    }
                }catch (NoResultException fex){
                    if (idiomaLocal.getCodigo().equals(ConstantesINT.COD_IDIOMA_ES)){
                        try{
                            genericoLocal = genericoLocalHome.create( pais.getOidPais(), codigoGenerico);
                            e18nLocal=e18nLH.create("MAE_GENER",new Long(1),idiomaLocal.getOid(),descripcion ,genericoLocal.getOid());
                        }catch(PersistenceException ce){
                            DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Generico " + "Exception: " + ce.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }//Fin catch
                    }else{
                        DTOINTError dtoError =new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Generico");
                        gi.registrarError(dtoError);
                        continue;
                    }//fin if                    
                 }  catch (PersistenceException ce) {   
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }//fin while
                Cronometrador.endTransaction("RegistroGenerico");
            } //fin catch
        } catch (RemoteException re){          
            ctx.getRollbackOnly();
            UtilidadesLog.error("***MONINTSAP.recepcionarGenerico: error RemoteException",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie){
            ctx.getRollbackOnly();
            UtilidadesLog.error("***ACABA CASO DE USO MONINTSAP.recepcionarGenerico: error InterfacesException",ie);
            return;
        }
        Cronometrador.endTransaction("MONINTSAPBean.recepcionarGenerico");
        UtilidadesLog.info("MONINTSAPBean.recepcionarGenerico(DTOOID pais): Salida");
    }


    public void recepcionarDescripcionProductosIdioma(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.recepcionarDescripcionProductosIdioma(DTOOID pais): Entrada");
        Cronometrador.startTransaction("MONINTSAPBean.recepcionarDescripcionProductosIdioma");
       //EL DISEÑO SE CORRESPONDE CON LA INCIDENCIA 12863
        MONGestorInterfaces gi = null;
        InterfazInfo interfaz=null;
        MaestroProductosLocalHome maestroHome=null;
        MaestroProductosLocal maestroLocal=null;
        IRegistroSicc registro=null;
        IdiomaLocalHome idiomaHome=null;
        IdiomaLocal idiomaLocal=null;
        String descripcion=null;
      
        try{   
           gi= this.getMONGestorInterfaces();
           
           
           // sapaza -- Error en Lectura de archivos SAM -- 15/06/2011
           try {
               interfaz =gi.importarInterfaz((String)IGestorInterfaces.COD_INTERFAZ_SAM5, pais.getOid());
           }catch (InterfacesException ie) {        
               UtilidadesLog.error("ERROR", ie);
               throw new MareException(ie,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
           }
           
           maestroHome= this.getMaestroProductosLocalHome();
            while ((registro=gi.cargarRegistro(interfaz))!=null){
                Cronometrador.startTransaction("RegistroProductoIdioma");
                try{
                    maestroLocal=maestroHome.findByUK(pais.getOid(), (String)registro.obtenerCampo(IRegistroSicc.SAM5_CODIGO_PRODUCTO));
                }catch(FinderException fe){
                    String codigoProducto=IRegistroSicc.SAM5_CODIGO_PRODUCTO;
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0005 + codigoProducto);
                    gi.registrarError(dtoError);
                    continue;
                 }
                try{
                    idiomaHome = this.getIdiomaLocalHome();
                    idiomaLocal=idiomaHome.findByCodigo((String)registro.obtenerCampo(IRegistroSicc.SAM5_CODIGO_IDIOMA));
                }catch(NoResultException fe){
                    String codigoIdioma=IRegistroSicc.SAM5_CODIGO_IDIOMA;
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            
                descripcion= (String)registro.obtenerCampo(IRegistroSicc.SAM5_DESCRIPCION_EN_IDIOMA);
                if (descripcion==null || descripcion.trim().equals("")) {
                    //falta añadir ErroresNegocio.INT_14
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0014 + descripcion);
                    gi.registrarError(dtoError);
                    continue;
                }
                
                //modificado por incidencia 20408
                GestorIdiomasINT gestorIdiomas= new GestorIdiomasINT();
                gestorIdiomas.setSessionContext(this.ctx);
                gestorIdiomas.generarDescripcionIdiomaNoES(maestroLocal.getOid(), "MAE_PRODU",idiomaLocal.getOid(), descripcion);
                Cronometrador.endTransaction("RegistroProductoIdioma");
            }// WHILE
       }catch (InterfacesException ie) {            
            UtilidadesLog.error("***ACABA CASO DE USO MONINSAP.recepcionarStocksDiarios: error InterfacesException \n RETURN",ie);
            return;
         }catch(RemoteException re){                 
          UtilidadesLog.error("Error RemoteException",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

        }
        Cronometrador.endTransaction("MONINTSAPBean.recepcionarDescripcionProductosIdioma");
        UtilidadesLog.info("MONINTSAPBean.recepcionarDescripcionProductosIdioma(DTOOID pais): Salida");    
    }

    
    private ArrayList ordenar(ArrayList listaRegistros){
        UtilidadesLog.info("MONINTSAPBean.ordenar(ArrayList listaRegistros): Entrada");
        int i;
        int j;
        int n=listaRegistros.size();
        int posicionMenor;
        IRegistroSicc registroMenor=null;        
        IRegistroSicc registroAux=null;        
      
        ArrayList listaOrdenada = new ArrayList();
	      j = 0;
      
        while (j < n) {
		      registroMenor=(IRegistroSicc)listaRegistros.get(j);  
          posicionMenor = j;
          
          for (i = j; i < n; i++) {
                
                if (registroMenor.SAM6_CODIGO.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_CODIGO) > 0 ){
                    registroMenor=(IRegistroSicc)listaRegistros.get(i); 
                    posicionMenor = i;
                }else{ //si no es mmayor puede ser igual
                        if(registroMenor.SAM6_CODIGO.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_CODIGO) == 0 ){
                        //Si es iguakl decide el segundo parametro el almacen
                                if (registroMenor.SAM6_ALMACEN_SICC.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_ALMACEN_SICC) > 0 ){
                                          registroMenor=(IRegistroSicc)listaRegistros.get(i); 
                                          posicionMenor = i;
                                }else{
                                     if(registroMenor.SAM6_ALMACEN_SICC.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_ALMACEN_SICC) == 0 ){
                                                //Si es igual decide el tercer parametro el almacen
                                               if (registroMenor.SAM6_PRODUCTO_SAP.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_PRODUCTO_SAP) > 0 ){   
                                                      registroMenor=(IRegistroSicc)listaRegistros.get(i); 
                                                      posicionMenor = i;
                                                      //SI EL PRODUCTO ES MENOR LO CAMBIO SI NO NADA..
                                              }
                                              //else{
                                               //     if(registroMenor.SAM6_PRODUCTO_SAP.compareTo(((IRegistroSicc)listaRegistros.get(i)).SAM6_PRODUCTO_SAP) == 0 ){
                                                 //         UtilidadesLog.debug("SOn iguales los productos da igual metemos el primero que llegue");
                                                   // }
                                               
                                               //}
                                     }
                                
                                    
                                }
                        }
                
                }
          }//FOR
          registroAux=(IRegistroSicc)listaRegistros.get(j);//guardamos el registro que vamos a quitar de la listaRegistro en la posicion del menor
          registroMenor=(IRegistroSicc)listaRegistros.get(posicionMenor);//guardamos el registro de la posicion menor
          listaRegistros.set(posicionMenor,registroAux);//ponemos el auxiliar en la lista de nuevo, en la psicion delmenor.
          listaOrdenada.add(registroMenor);//añadimos a la nueva lista ordenada el menor
          j++;
    
        }//while 
     
       UtilidadesLog.info("MONINTSAPBean.ordenar(ArrayList listaRegistros): Salida");
     
     return listaOrdenada;
     
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
    public DTOSalidaBatch enviarMovimientosAlmacenDiarios(DTOBatch dtoBatch) 
        throws MareException {
        UtilidadesLog.info("MONINTSAPBean.enviarMovimientosAlmacenDiarios(DTOBatch dtoBatch): Entrada");
        //Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como
        //handle de la interfaz que se va a procesar
        
        Cronometrador.startTransaction("Enviar Movimientos Almacen Diarios");
        DTOINTEnviarMovimientos dtoe = (DTOINTEnviarMovimientos) dtoBatch.getDTOOnline();
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();        
        String interfazStr = IGestorInterfaces.COD_INTERFAZ_SAM7;
        Long pais = dtoe.getOidPais();
        String observaciones = dtoe.getObservaciones();
        String numeroLote = dtoe.getNumeroLote();
        //Modificado por incidencia 12254
        InterfazInfo interfaz = new InterfazInfo(interfazStr,numeroLote,pais);
        interfaz.setObservaciones(dtoe.getObservaciones());
        //fin modificacion 12254
        //Añadido por incidencia BELC300012977
        try{
            interfaz = gi.crearInterfaz(interfaz);
        }catch (InterfacesException ife){
            UtilidadesLog.error("enviarMovimientosAlmacenDiarios: InterfacesException:gi.crearInterfaz",ife);
            return new DTOSalidaBatch(0, "enviarMovimientosAlmacenDiarios finalizo con error - no pudo leer la interfaz");
        }catch (RemoteException re) {
            UtilidadesLog.error("enviarMovimientosAlmacenDiarios: RemoteException:gi.crearInterfaz",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //FIN añadido de la incidencia BELC300012977
       /* DAOMovimientosAlmacen daoMovimientosAlmacen = new DAOMovimientosAlmacen();
        //se crecuperan las cabeceras de movimientos de almacén
        ArrayList listaMovimientos = daoMovimientosAlmacen.obtenerMovimientosAlmacen(dtoe.getOidPais(),dtoe.getCanal(),
                                    dtoe.getAcceso(),dtoe.getSubaccesos(), dtoe.getTipoMovimientos());*/
        Cronometrador.startTransaction("Obtener Movimientos Almacen"); 
        RecordSet rs = this.obtenerMovimientosAlmacen(dtoe.getOidPais(),dtoe.getCanal(),dtoe.getAcceso(),dtoe.getSubaccesos(), dtoe.getTipoMovimientos());
        Cronometrador.endTransaction("Obtener Movimientos Almacen");                             
        Cronometrador.startTransaction("Añadir Registros"); 
        if (!(rs == null)){
            for(int i = 0; i < rs.getRowCount(); i++){  
              try{
                  RegistroSicc registro = new RegistroSicc();
                  registro.anyadirCampo(IRegistroSicc.SAM7_NUMEROLOTE, numeroLote);
                  registro.anyadirCampo(IRegistroSicc.SAM7_PAIS,this.objectToString(rs.getValueAt(i,"PAIS")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_CANAL,this.objectToString(rs.getValueAt(i,"CANAL")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_ACCESO,this.objectToString(rs.getValueAt(i,"ACCESO")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_SUBACCESO,this.objectToString(rs.getValueAt(i,"SUBACCESO")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_TIPO_PERIODO,this.objectToString(rs.getValueAt(i,"COD_TIPO_PERI")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_PERIODO,this.objectToString(rs.getValueAt(i,"COD_PERI")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_FECHA, this.objectToString(rs.getValueAt(i,"FECHA")));                
                  registro.anyadirCampo(IRegistroSicc.SAM7_TIPO_OFERTA,this.objectToString(rs.getValueAt(i,"COD_TIPO_OFER")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_TIPO_MOVIMIENTO, this.objectToString(rs.getValueAt(i,"COD_TIPO_MOVI")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_NEGOCIO,this.objectToString(rs.getValueAt(i,"COD_NEGO")));
                  //se modifica el campo a sacar por la interfaz debido a incidencia de aceptacion
                  //registro.anyadirCampo(IRegistroSicc.SAM7_MARCA_PRODUCTO, this.objectToString(rs.getValueAt(i,"COD_MARC_PROD")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_MARCA_PRODUCTO, this.objectToString(rs.getValueAt(i,"OID_MARC_PROD")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_INDICADOR_IST, this.objectToString(rs.getValueAt(i,"INDICADOR_ITS")));                        
                  registro.anyadirCampo(IRegistroSicc.SAM7_CODIGO_SAP,this.objectToString(rs.getValueAt(i,"COD_SAP")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_CANTIDAD, this.bigDecimalToFloat(rs.getValueAt(i,"CANTIDAD")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_PRECIO_VENTA_NETO,this.bigDecimalToFloat(rs.getValueAt(i,"VAL_PREC_VENT_NETO")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_PRECIO_CONTABLE,this.bigDecimalToFloat(rs.getValueAt(i,"VAL_PREC_CONT")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_ALMACEN_ORIGEN_SICC,this.objectToString(rs.getValueAt(i,"COD_ALMA_SALI")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_ALMACEN_DESTINO_SICC,this.objectToString(rs.getValueAt(i,"COD_ALMA_ENTR")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_ALMACEN_NUMERO_DOCUMENTO,this.objectToString(rs.getValueAt(i,"NUM_DOCU_REFE")));    
                  registro.anyadirCampo(IRegistroSicc.SAM7_TIPO_POSICION,this.objectToString(rs.getValueAt(i,"COD_TIPO_POSI")));
                  registro.anyadirCampo(IRegistroSicc.SAM7_SUBTIPO_POSICION,this.objectToString(rs.getValueAt(i,"COD_SUBT_POSI")));                   
                  gi.anyadirRegistro(interfaz,registro);
                  registro.vaciar();
              } catch (InterfacesException ife){                      
                  UtilidadesLog.error("enviarMovimientosAlmacenDiarios: InterfacesException:gi.anyadirRegistro",ife);
              } catch (RemoteException re) {                        
                  UtilidadesLog.error("enviarMovimientosAlmacenDiarios: RemoteException:gi.anyadirRegistro",re);
                  throw new MareException(re, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }              
          }
          Cronometrador.endTransaction("Añadir Registros"); 
          Cronometrador.startTransaction("Crear Interfaz"); 
          try {
              UtilidadesLog.debug("****ANTES enviarInterfaz FIN CICLO*****");
              gi.enviarInterfaz(interfaz);
          } catch (InterfacesException ife){              
                //Modificado por incidencia 12399 relacionada con la incidencia 12274
                // mensaje INT-0009 Error al enviar interfaz:
              UtilidadesLog.debug("****ERROR enviarInterfaz*****");
              DTOINTError dtoError = new DTOINTError(interfaz,null,ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + "Lote: " + interfaz.getNumeroLote() );
              try {
                gi.registrarError( dtoError );
              } catch (InterfacesException e){
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));              
              }  catch (RemoteException re) {               
                  UtilidadesLog.error("enviarMovimientosAlmacenDiarios: RemoteException:gi.enviarInterfaz",re);
                  throw new MareException(re,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }            
           }catch (RemoteException re) {               
                  UtilidadesLog.error("enviarMovimientosAlmacenDiarios: RemoteException:gi.enviarInterfaz",re);
                  throw new MareException(re,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
           }
           Cronometrador.endTransaction("Crear Interfaz"); 
           Cronometrador.startTransaction("Buscar Oids Detalle de Movimientos"); 
           RecordSet rsOidsDetalle = this.obtenerOidsMovimientosAlmacenDetalles(dtoe.getOidPais(),dtoe.getCanal(),dtoe.getAcceso(),dtoe.getSubaccesos(), dtoe.getTipoMovimientos());
           Cronometrador.endTransaction("Buscar Oids Detalle de Movimientos"); 
           Cronometrador.startTransaction("Agregar Numero de Lote"); 
           if (!(rsOidsDetalle == null)){
              BelcorpService bs = UtilidadesEJB.getBelcorpService();
              StringBuffer stringUpdateMov = this.crearStringUpdateMovimientosAlmacen(rsOidsDetalle,numeroLote);
              try {      
                  bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",stringUpdateMov.toString());
              } catch (Exception e) {
                throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
           }
           Cronometrador.endTransaction("Agregar Numero de Lote"); 
      }
      Cronometrador.endTransaction("Enviar Movimientos Almacen Diarios");
      UtilidadesLog.info("MONINTSAPBean.enviarMovimientosAlmacenDiarios(DTOBatch dtoBatch): Salida");
      return new DTOSalidaBatch(0, "enviarMovimientosAlmacenDiarios fin");
  }           
            

    
    private Boolean comparaCabecera (DTOMovimientoAlmacenCabecera dto1, DTOMovimientoAlmacenCabecera dto2){
        /**
         * Realiza una comparacion entre 2 DTOMovimientoAlmacenCabecera 
         * Se afinaron los criterios de agrupacion acorde incidencia SC-INT-SAM-01-1 y 2, 22835 CQ
         */
        UtilidadesLog.info("MONINTSAPBean.comparaCabecera(DTOMovimientoAlmacenCabecera dto1, DTOMovimientoAlmacenCabecera dto2): Entrada");
        
        UtilidadesLog.debug("**OidTipoMovimientoAlmacen DTO1: "+dto1.getOidTipoMovimientoAlmacen()+" y DTO2: "+dto2.getOidTipoMovimientoAlmacen());
        if (dto1.getOidTipoMovimientoAlmacen()!=null && dto2.getOidTipoMovimientoAlmacen()!=null){
            if (dto1.getOidTipoMovimientoAlmacen().longValue()!=dto2.getOidTipoMovimientoAlmacen().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidTipoMovimientoAlmacen() != dto2.getOidTipoMovimientoAlmacen()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**Fecha DTO1: "+dto1.getFecha()+" y DTO2: "+dto2.getFecha());
        if (dto1.getFecha()!=null && dto2.getFecha()!=null){
            if (!(dto1.getFecha().toString().equals(dto2.getFecha().toString()))){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getFecha() != dto2.getFecha()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidAlmacenSalida DTO1: "+dto1.getOidAlmacenSalida()+" y DTO2: "+dto2.getOidAlmacenSalida());
        if (dto1.getOidAlmacenSalida()!=null && dto2.getOidAlmacenSalida()!=null){
            if (dto1.getOidAlmacenSalida().longValue()!=dto2.getOidAlmacenSalida().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAlmacenSalida() != dto2.getOidAlmacenSalida()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidAlmacenEntrada DTO1: "+dto1.getOidAlmacenEntrada()+" y DTO2: "+dto2.getOidAlmacenEntrada());
        if (dto1.getOidAlmacenEntrada()!=null && dto2.getOidAlmacenEntrada()!=null){
            if (dto1.getOidAlmacenEntrada().longValue()!=dto2.getOidAlmacenEntrada().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAlmacenEntrada() != dto2.getOidAlmacenEntrada()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidCanal DTO1: "+dto1.getOidCanal()+" y DTO2: "+dto2.getOidCanal());        
        if (dto1.getOidCanal()!=null && dto2.getOidCanal()!=null){
            if (dto1.getOidCanal().longValue()!=dto2.getOidCanal().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidCanal() != dto2.getOidCanal()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidAcceso DTO1: "+dto1.getOidAcceso()+" y DTO2: "+dto2.getOidAcceso());
        if (dto1.getOidAcceso()!=null && dto2.getOidAcceso()!=null){
            if (dto1.getOidAcceso().longValue()!=dto2.getOidAcceso().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAcceso() != dto2.getOidAcceso()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidSubacceso DTO1: "+dto1.getOidSubacceso()+" y DTO2: "+dto2.getOidSubacceso());
        if (dto1.getOidSubacceso()!=null && dto2.getOidSubacceso()!=null){
            if (dto1.getOidSubacceso().longValue()!=dto2.getOidSubacceso().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidSubacceso() != dto2.getOidSubacceso()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("**OidPeriodo DTO1: "+dto1.getOidPeriodo()+" y DTO2: "+dto2.getOidPeriodo());
        if (dto1.getOidPeriodo()!=null && dto2.getOidPeriodo()!=null){
            if (dto1.getOidPeriodo().longValue()!=dto2.getOidPeriodo().longValue()){
                UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidPeriodo() != dto2.getOidPeriodo()){
            UtilidadesLog.debug("****Metodo  comparaCabecera: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.info("MONINTSAPBean.comparaCabecera(DTOMovimientoAlmacenCabecera dto1, DTOMovimientoAlmacenCabecera dto2): Salida");
        return new Boolean(true);
    }
    
    private Boolean comparaDetalle (DTOMovimientoAlmacenDetalle dto1, DTOMovimientoAlmacenDetalle dto2) {
        /**
         * Realiza la comparacion de dos DTOMovimientoAlmacenDetalle
         * Se afinaron los criterios de agrupacion acorde incidencia SC-INT-SAM-01-1 y 2, 22835 CQ
         */
        UtilidadesLog.info("MONINTSAPBean.comparaDetalle(DTOMovimientoAlmacenDetalle dto1, DTOMovimientoAlmacenDetalle dto2): Entrada");
        /*
        numeroMovimiento;
        oidTipoMovimientoAlmacen;
        oidCanal;
        oidAcceso;
        oidSubacceso;
        oidAlmacenSalida;
        oidAlmacenEntrada;
        oidProducto;
        cantidad;
        precioVentaNeto;
        precioContable;
        numeroPosicionReferencia;
        numeroDocumentoReferencia;
        operacion;
        movimientoOk;
        oid; //BELC300006139 
        oidMovimientoCabecera; //BELC300006139 
        numeroLinea; //BELC300006139 
        oidTipoOferta; //BELC300008595
        observaciones;//Añadido despues*/
        
        /*UtilidadesLog.debug("NumeroMovimiento DTO1: "+dto1.getNumeroMovimiento()+" y DTO2: "+dto2.getNumeroMovimiento());
        if (dto1.getNumeroMovimiento()!=null && dto2.getNumeroMovimiento()!=null){
            if (!(dto1.getNumeroMovimiento().equals(dto2.getNumeroMovimiento()))){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getNumeroMovimiento() != dto2.getNumeroMovimiento()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }*/
        
        UtilidadesLog.debug("OidTipoMovimientoAlmacen DTO1: "+dto1.getOidTipoMovimientoAlmacen()+" y DTO2: "+dto2.getOidTipoMovimientoAlmacen());
        if (dto1.getOidTipoMovimientoAlmacen() !=null && dto2.getOidTipoMovimientoAlmacen()!=null){
            if (dto1.getOidTipoMovimientoAlmacen().longValue() != dto2.getOidTipoMovimientoAlmacen().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidTipoMovimientoAlmacen() != dto2.getOidTipoMovimientoAlmacen()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }

        UtilidadesLog.debug("OidCanal DTO1: "+dto1.getOidCanal()+" y DTO2: "+dto2.getOidCanal());
        if (dto1.getOidCanal()!=null && dto2.getOidCanal()!=null){
            if (dto1.getOidCanal().longValue() != dto2.getOidCanal().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);            
            }
        }else if (dto1.getOidCanal() != dto2.getOidCanal()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);            
        }
        
        UtilidadesLog.debug("OidAcceso DTO1: "+dto1.getOidAcceso()+" y DTO2: "+dto2.getOidAcceso());
        if (dto1.getOidAcceso()!=null && dto2.getOidAcceso()!=null){
            if (dto1.getOidAcceso().longValue() != dto2.getOidAcceso().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAcceso() != dto2.getOidAcceso()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("OidSubacceso DTO1: "+dto1.getOidSubacceso()+" y DTO2: "+dto2.getOidSubacceso());
        if (dto1.getOidSubacceso()!=null && dto2.getOidSubacceso()!=null){
            if (dto1.getOidSubacceso().longValue()!=dto2.getOidSubacceso().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidSubacceso() != dto2.getOidSubacceso()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("OidAlmacenSalida DTO1: "+dto1.getOidAlmacenSalida()+" y DTO2: "+dto2.getOidAlmacenSalida());
        if (dto1.getOidAlmacenSalida()!=null && dto2.getOidAlmacenSalida()!=null){
            if (dto1.getOidAlmacenSalida().longValue()!=dto2.getOidAlmacenSalida().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAlmacenSalida() != dto2.getOidAlmacenSalida()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("OidAlmacenEntrada DTO1: "+dto1.getOidAlmacenEntrada()+" y DTO2: "+dto2.getOidAlmacenEntrada());
        if (dto1.getOidAlmacenEntrada()!=null && dto2.getOidAlmacenEntrada()!=null){
            if (dto1.getOidAlmacenEntrada().longValue()!=dto2.getOidAlmacenEntrada().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidAlmacenEntrada() != dto2.getOidAlmacenEntrada()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("OidProducto DTO1: "+dto1.getOidProducto()+" y DTO2: "+dto2.getOidProducto());
        if (dto1.getOidProducto()!=null && dto2.getOidProducto()!=null){
            if (dto1.getOidProducto().longValue()!=dto2.getOidProducto().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getOidProducto() != dto2.getOidProducto()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
       /* BELC300022806 no se debe comparar el precio ni la cantidad ya que son valores a sumar y no determinan la
        * agrupacion
             
        UtilidadesLog.debug("Cantidad DTO1: "+dto1.getCantidad()+" y DTO2: "+dto2.getCantidad());
        if (dto1.getCantidad()!=null && dto2.getCantidad()!=null){
            if (dto1.getCantidad().longValue()!=dto2.getCantidad().longValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getCantidad() != dto2.getCantidad()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("PrecioVentaNeto DTO1: "+dto1.getPrecioVentaNeto()+" y DTO2: "+dto2.getPrecioVentaNeto());
        if (dto1.getPrecioVentaNeto()!=null && dto2.getPrecioVentaNeto()!=null){
            if (dto1.getPrecioVentaNeto().doubleValue() != dto2.getPrecioVentaNeto().doubleValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getPrecioVentaNeto() != dto2.getPrecioVentaNeto()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("PrecioContable DTO1: "+dto1.getPrecioContable()+" y DTO2: "+dto2.getPrecioContable());
        if (dto1.getPrecioContable()!=null && dto2.getPrecioContable()!=null){
            if (dto1.getPrecioContable().doubleValue()!=dto2.getPrecioContable().doubleValue()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }else if (dto1.getPrecioContable() != dto2.getPrecioContable()){
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        */
       
        //Agregado por cambios SAM02
        //Cristian Valenzuela - 30/9/2005
        UtilidadesLog.debug("Tipo posicion DTO1: "+dto1.getOidTipoPosicion()+" y DTO2: "+dto2.getOidTipoPosicion());
        if(dto1.getOidTipoPosicion()!=null && dto2.getOidTipoPosicion()!=null) {
            if(dto1.getOidTipoPosicion().longValue()!=dto2.getOidTipoPosicion().longValue()) {
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);    
            }            
        }
        else if(dto1.getOidTipoPosicion() != dto2.getOidTipoPosicion()) {
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);
        }
        
        UtilidadesLog.debug("SubTipo posicion DTO1: "+dto1.getOidSubtipoPosicion()+" y DTO2: "+dto2.getOidSubtipoPosicion());
        if(dto1.getOidSubtipoPosicion()!=null && dto2.getOidSubtipoPosicion()!=null) {
            if(dto1.getOidSubtipoPosicion().longValue()!= dto2.getOidSubtipoPosicion().longValue())  {
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);    
            }
        }
        else if(dto1.getOidSubtipoPosicion() != dto2.getOidSubtipoPosicion())  {
            UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
            return new Boolean(false);    
        }
        
        if(dto2.getOidTipoPosicion()==null||dto2.getOidSubtipoPosicion()==null){
            UtilidadesLog.debug("OidTipoOferta DTO1: "+dto1.getOidTipoOferta()+" y DTO2: "+dto2.getOidTipoOferta());
            if (dto1.getOidTipoOferta()!=null && dto2.getOidTipoOferta()!=null){
                if (dto1.getOidTipoOferta().longValue()!=dto2.getOidTipoOferta().longValue()){
                    UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                    return new Boolean(false);
                }
            }else if (dto1.getOidTipoOferta() != dto2.getOidTipoOferta()){
                UtilidadesLog.debug("****Metodo  comparaDetalle: Salida False");
                return new Boolean(false);
            }
        }               
        //FIN - Agregado por cambios SAM02
        
        UtilidadesLog.info("MONINTSAPBean.comparaDetalle(DTOMovimientoAlmacenDetalle dto1, DTOMovimientoAlmacenDetalle dto2): Salida");
        return new Boolean(true);
    }
    
    private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTSAPBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTSAPBean.getMONGestorInterfaces(): Salida");
        return ejb;
	}  
    
    private MONRegistroAbastecimiento getMONRegistroAbastecimiento() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTSAPBean.getMONRegistroAbastecimiento(): Entrada");			
        MONRegistroAbastecimientoHome home = (MONRegistroAbastecimientoHome)UtilidadesEJB.getHome(
            "MONRegistroAbastecimiento", MONRegistroAbastecimientoHome.class);
            
        // Se obtiene el interfaz remoto
        MONRegistroAbastecimiento ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONRegistroAbastecimiento",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTSAPBean.getMONRegistroAbastecimiento(): Salida");
        return ejb;
	}


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException
    {
        MaestroProductosLocalHome maestroLocalhome = (MaestroProductosLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");
        return maestroLocalhome;
    }


    /**
     * @author
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * 
     * @author pperanzola
     * @date 06/09/2005
     *         [1] Se modifica según diseño de Código único de venta
     */

    public void recepcionarProductos(DTOOID dto) throws MareException{
        UtilidadesLog.info("MONINTSAPBean.recepcionarProductos(DTOOID dto): Entrada");
        Cronometrador.startTransaction("MONINTSAPBean.recepcionarProductos");
        MONGestorInterfaces gi = null;
        InterfazInfo interfaz=null;
       
        IRegistroSicc registro=null;
       
       
        MaestroProductosLocalHome maestroHome=null;
        MaestroProductosLocal maestroLocal=null;
        PaisLocal paisLocal=null;
        PaisLocalHome paisHome=null;
        MarcaProductoLocalHome marcaProductoHome = null;//this.getMarcaProductoLocalHome();
        MarcaProductoLocal marcaProductolocal = null;
        UnidadesNegocioLocal unidadNegocioLocal=null;
        UnidadesNegocioLocalHome unidadNegocioHome=null;
        NegocioLocal negocioLocal=null;
        NegocioLocalHome negocioHome=null;
        GenericoLocal genericoLocal=null;
        GenericoLocalHome genericoHome=null;
        SuperGenericoLocal superGenericoLocal= null;
        SuperGenericoLocalHome superGenericoHome=null;
        EstatusLocalHome estatusHome=null;
        EstatusLocal estatusLocal= null;
        UnidadesMedidaLocalHome unidadMedidaHomeVolumen=null;
        UnidadesMedidaLocal unidadMedidaLocalVolumen=null;
        UnidadesMedidaLocalHome unidadMedidaHomePeso=null;
        UnidadesMedidaLocal unidadMedidaLocalPeso=null;
        IdiomaLocalHome idiomaHome=null;
        IdiomaLocal idiomaLocal=null;
        DAOINT dao=new DAOINT();
       
        // Cambios en el diseño, Incidencia 13002
        Long oidUnidadNegocio = null;
        Long oidNegocio = null;
        Long oidGenerico = null;
        Long oidSupergenerico = null;
        Long oidEstatus = null;
        Long oidUnidadMedidaVolumen = null;
        Long oidUnidadMedidaPeso = null;

        String codigoUnidadNegocio = null;
        String codigoNegocio = null;
        String codigoGenerico = null;
        String codigoSupergenerico = null;
        String codigoEstatus = null;
        String codigoUnidadMedidaVolumen = null;
        String codigoUnidadMedidaPeso = null;
        String descripcion = null;
        String indicadorProductoServicio=null;
        String grupoArticulos=null;
        String jerarquia1=null;
        String jerarquia2=null;
        String jerarquia3=null;
        Integer dimensionAlto=null;
        Integer dimensionLargo=null;
        Integer dimensionAncho=null;
        String indicadorDentroFueraCajaBolsa=null;
        Integer volumen=null;
        Integer pesoBruto=null;
        Float precioCosteEstandar=null;
        String codigoAntiguo=null;

        String codigoUnicoVenta = null; // [1]

        try{
            // sapaza -- PER-SiCC-2011-0056 -- 22/11/2011
            String indicadorActualizacion = dao.obtenerIndicadorActualizacion(dto.getOid());
            
            idiomaHome = this.getIdiomaLocalHome();
            try{
                  idiomaLocal=idiomaHome.findByCodigo(ConstantesINT.COD_IDIOMA_ES);
            }catch(NoResultException fe){                  
                String codigoIdioma=IRegistroSicc.SAM5_CODIGO_IDIOMA;
                DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0001 + codigoIdioma);
                gi.registrarError(dtoError);
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
          
            String codigoSAP=null;
            gi= this.getMONGestorInterfaces();

            // sapaza -- Error en Lectura de archivos SAM -- 15/06/2011
            try {
                interfaz =gi.importarInterfaz((String)IGestorInterfaces.COD_INTERFAZ_SAM4, dto.getOid());//  Incidencia  puesta
            }catch (InterfacesException ie) {        
                UtilidadesLog.error("ERROR", ie);
                throw new MareException(ie,
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
            }
            
            paisHome=getPaisLocalHome(); 
            marcaProductoHome=getMarcaProductoLocalHome();
            Entidadi18nLocal e18nLocal=null;
            Entidadi18nLocalHome e18nLH=this.getEntidadi18nLocalHome();
            negocioHome=getNegocioLocalHome();
            genericoHome=getGenericoLocalHome();
            superGenericoHome=getSuperGenericoLocalHome();
            estatusHome=getEstatusLocalHome();
            unidadMedidaHomeVolumen=getUnidadesMedidaLocalHome();
            MagnitudLocal magnitudLocalVolumen=null;
            MagnitudLocalHome magnitudHomeVolumen=getMagnitudLocalHome();
            unidadMedidaHomePeso=getUnidadesMedidaLocalHome();
            MagnitudLocal magnitudLocalPeso=null;
            MagnitudLocalHome magnitudHomePeso=magnitudHomeVolumen;
            MaestroProductosLocal mProductoLocal=null;
            MaestroProductosLocalHome productoHome=null;
            
            productoHome=getMaestroProductosLocalHome();
            
            while ((registro=gi.cargarRegistro(interfaz))!=null){
                Cronometrador.startTransaction("CargaProducto");
                codigoSAP = (String)registro.obtenerCampo( IRegistroSicc.SAM4_CODIGO_SAP );
                if( codigoSAP == null || codigoSAP.trim().equals("") ){
                    //atencion FALTA DE INCIDENCIA HABRA QUE PONER ERORES DE NEGOCIO.INT0011 DIGO YO?
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,"El campo codigoSAP no puede ser nulo");
                    gi.registrarError(dtoError);
                    continue;
                }       
                
                try{
                    paisLocal=paisHome.findByUk( (String)registro.obtenerCampo(IRegistroSicc.SAM4_PAIS) );//(IRegistroSicc.SAM6_CODIGO) );
                }catch(NoResultException fe){
                    String codigoIdioma=IGestorInterfaces.COD_INTERFAZ_SAM4;
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0003 + codigoIdioma);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try{
                    marcaProductolocal=marcaProductoHome.findByUk((String)registro.obtenerCampo(IRegistroSicc.SAM4_MARCA));
                }catch(NoResultException fe){
                    String codigoIdioma=IRegistroSicc.SAM4_MARCA;
                    DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0004 + codigoIdioma);
                    gi.registrarError(dtoError);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                oidUnidadNegocio = null;
                codigoUnidadNegocio = (String)registro.obtenerCampo(IRegistroSicc.SAM4_UNIDAD_NEGOCIO);
                if (!((codigoUnidadNegocio==null)||(codigoUnidadNegocio.trim().equals("")))){
                    unidadNegocioHome=getUnidadesNegocioLocalHome();
                    try{
                         unidadNegocioLocal=unidadNegocioHome.findByUk(dto.getOid(),codigoUnidadNegocio);
                    }catch(NoResultException fe ){
                        try{
                            unidadNegocioLocal=unidadNegocioHome.create( dto.getOid(), codigoUnidadNegocio);
                            e18nLocal=e18nLH.create("MAE_UNIDA_NEGOC",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", unidadNegocioLocal.getOid());
                        }catch(PersistenceException ce){
                             DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "UnidadNegocio\n" +ce.getMessage());
                             gi.registrarError(dtoError);
                             continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidUnidadNegocio = unidadNegocioLocal.getOid();
                }
                  
                oidNegocio = null;
                codigoNegocio = (String)registro.obtenerCampo(IRegistroSicc.SAM4_NEGOCIO);
                if (!((codigoNegocio==null)||(codigoNegocio.trim().equals("")))){
                    try{
                         negocioLocal=negocioHome.findByUk(dto.getOid(),codigoNegocio);
                    }catch(NoResultException fe ){
                        try{
                            negocioLocal=negocioHome.create( dto.getOid(),codigoNegocio);
                            e18nLocal=e18nLH.create("MAE_NEGOC",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", negocioLocal.getOid());
                        }catch(PersistenceException ce){
                            DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "UnidadNegocio\n" +ce.getMessage());
                             gi.registrarError(dtoError);
                             continue;
                        } 
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidNegocio = negocioLocal.getOid();
                }
        
                oidGenerico = null;
                codigoGenerico = (String)registro.obtenerCampo(IRegistroSicc.SAM4_GENERICO);
                if (!((codigoGenerico==null)||(codigoGenerico.trim().equals("")))){
                    try{
                        genericoLocal=genericoHome.findByUk(dto.getOid(),codigoGenerico);
                    }catch(NoResultException fe ){
                        try{
                            genericoLocal=genericoHome.create(dto.getOid(),codigoGenerico);
                            e18nLocal=e18nLH.create("MAE_GENER",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", genericoLocal.getOid());
                        }catch(PersistenceException ce){
                            DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Generico\n" +ce.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidGenerico = genericoLocal.getOid();
                }
  
                oidSupergenerico = null;
                codigoSupergenerico = (String)registro.obtenerCampo(IRegistroSicc.SAM4_SUPERGENERICO);
                if (!((codigoSupergenerico==null)||(codigoSupergenerico.trim().equals("")))){
                    try{
                        superGenericoLocal=superGenericoHome.findByUk(dto.getOid(),codigoSupergenerico);
                    }catch(NoResultException fe ){
                        try{
                            superGenericoLocal=superGenericoHome.create(dto.getOid(),codigoSupergenerico);
                            e18nLocal=e18nLH.create("MAE_SUPER_GENER",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", superGenericoLocal.getOid());
                        }catch(PersistenceException ce){
                            DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Supergenerico\n" +ce.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidSupergenerico = superGenericoLocal.getOid();
                }
  
                oidEstatus = null;
                codigoEstatus = (String)registro.obtenerCampo(IRegistroSicc.SAM4_ESTATUS_PRODUCTO);
                if (!((codigoEstatus==null)||(codigoEstatus.trim().equals("")))){
                    try{
                        estatusLocal=estatusHome.findByUk(dto.getOid(),codigoEstatus);
                    }catch(NoResultException fe ){
                        try{
                            estatusLocal=estatusHome.create(codigoEstatus,dto.getOid());
                            e18nLocal=e18nLH.create("MAE_ESTAT_PRODU",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", estatusLocal.getOid());
                        }catch(PersistenceException ce){
                            DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Estatus\n" +ce.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidEstatus = estatusLocal.getOid();
                }
          
                oidUnidadMedidaVolumen = null;
                codigoUnidadMedidaVolumen = (String)registro.obtenerCampo(IRegistroSicc.SAM4_UNIDAD_MEDIDA_VOLUMEN);
                if (!((codigoUnidadMedidaVolumen==null)||(codigoUnidadMedidaVolumen.trim().equals("")))){
                    try{
                        unidadMedidaLocalVolumen=unidadMedidaHomeVolumen.findByUk(dto.getOid(),codigoUnidadMedidaVolumen);
                    }catch(NoResultException fe ){
                        try{
                            magnitudLocalVolumen=magnitudHomeVolumen.findByUk(ConstantesINT.COD_UNIDAD_MEDIDA_VOLUMEN);
                            try{
                                unidadMedidaLocalVolumen=unidadMedidaHomeVolumen.create(dto.getOid(),codigoUnidadMedidaVolumen, magnitudLocalVolumen.getOid(), Boolean.FALSE);
                                e18nLocal=e18nLH.create("MAE_UNIDA_MEDID",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", unidadMedidaLocalVolumen.getOid());
                            }catch(PersistenceException ce){
                                DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "UnidadesMedida\n" +ce.getMessage());
                                gi.registrarError(dtoError);
                                continue;
                            }                                
                        }catch(NoResultException e){
                            DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Magnitud\n" +e.getMessage());
                            gi.registrarError(dtoError);
                            continue;
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidUnidadMedidaVolumen = unidadMedidaLocalVolumen.getOid();
                }
                
                oidUnidadMedidaPeso = null;
                codigoUnidadMedidaPeso = (String)registro.obtenerCampo(IRegistroSicc.SAM4_UNIDAD_MEDIDA_PESO);
                if (!((codigoUnidadMedidaPeso==null)||(codigoUnidadMedidaPeso.trim().equals("")))){        
                    try{
                        unidadMedidaLocalPeso=unidadMedidaHomePeso.findByUk(dto.getOid(),codigoUnidadMedidaPeso);
                    }catch(NoResultException fe ){
                        try{
                            magnitudLocalPeso=magnitudHomePeso.findByUk(ConstantesINT.COD_UNIDAD_MEDIDA_PESO);
                            try{
                                unidadMedidaLocalPeso=unidadMedidaHomePeso.create(dto.getOid(),codigoUnidadMedidaPeso, magnitudLocalPeso.getOid(),Boolean.FALSE);
                                e18nLocal=e18nLH.create("MAE_UNIDA_MEDID",new Long(1),(Long)idiomaLocal.getPrimaryKey(),"Descripcion Pendiente", unidadMedidaLocalPeso.getOid());
                            }catch(PersistenceException ce){
                                 DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "UnidadesMedida\n" +ce.getMessage());
                                 gi.registrarError(dtoError);
                                 continue;
                            }
                        }catch(NoResultException e){
                              DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "UnidadesMedida\n" +e.getMessage());
                              gi.registrarError(dtoError);
                              continue;
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    oidUnidadMedidaPeso = unidadMedidaLocalPeso.getOid();
                }               
                
                codigoUnicoVenta = (String) registro.obtenerCampo( IRegistroSicc.SAM4_CODIGO_UNICO_VENTA); //[1]
                //obtenemos la descripcion del producto
                descripcion=(String)registro.obtenerCampo(IRegistroSicc.SAM4_DESCRIPCION_SAP);
                //obtenemos los campos del fichero
                indicadorProductoServicio=(String)registro.obtenerCampo(IRegistroSicc.SAM4_INDICADOR_PRODUCTO_SERVICIO);
                grupoArticulos=(String)registro.obtenerCampo(IRegistroSicc.SAM4_GRUPO_ARTICULOS);
                jerarquia1=(String)registro.obtenerCampo(IRegistroSicc.SAM4_JERARQUIA_1);
                jerarquia2=(String)registro.obtenerCampo(IRegistroSicc.SAM4_JERARQUIA_2);
                jerarquia3=(String)registro.obtenerCampo(IRegistroSicc.SAM4_JERARQUIA_3);
                dimensionAlto=(Integer)registro.obtenerCampo(IRegistroSicc.SAM4_DIMENSION_ALTO);
                dimensionLargo=(Integer)registro.obtenerCampo(IRegistroSicc.SAM4_DIMENSION_LARGO);
                dimensionAncho=(Integer)registro.obtenerCampo(IRegistroSicc.SAM4_DIMENSION_ANCHO);
                indicadorDentroFueraCajaBolsa=(String)registro.obtenerCampo(IRegistroSicc.SAM4_INDICADOR_DENTRO_FUERA_CAJA_BOLSA);
                volumen=(Integer)registro.obtenerCampo(IRegistroSicc.SAM4_VOLUMEN);
                pesoBruto=(Integer)registro.obtenerCampo(IRegistroSicc.SAM4_PESO_BRUTO);
                precioCosteEstandar=(Float)registro.obtenerCampo(IRegistroSicc.SAM4_PRECIO_COSTE_ESTANDAR);
                codigoAntiguo=(String)registro.obtenerCampo(IRegistroSicc.SAM4_UNIDAD_CODIGO_ANTIGUO);
                
                try{
                    mProductoLocal=productoHome.findByUK(dto.getOid(),(String)registro.obtenerCampo(IRegistroSicc.SAM4_CODIGO_SAP));
                    mProductoLocal.setMarcaProducto(marcaProductolocal.getOid());
                }catch(FinderException fe ){
                    try{
                        mProductoLocal=productoHome.create((String)registro.obtenerCampo(IRegistroSicc.SAM4_CODIGO_SAP),dto.getOid(),new Vector(),marcaProductolocal.getOid());
                    }catch(CreateException ce){
                        DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Producto\n" +ce.getMessage());
                        gi.registrarError(dtoError);
                        continue;
                    }
                }
                //seteamos todos los campos
                mProductoLocal.setMarcaProducto(marcaProductolocal.getOid());
                mProductoLocal.setUnidadNegocio(oidUnidadNegocio);
                mProductoLocal.setNegocio(oidNegocio);
                mProductoLocal.setGenerico(oidGenerico);
                mProductoLocal.setSuperGenerico(oidSupergenerico);
                mProductoLocal.setStatus(oidEstatus);
                mProductoLocal.setUnidadMedidaVolumen(oidUnidadMedidaVolumen);
                mProductoLocal.setUnidadMedidaPeso(oidUnidadMedidaPeso);
                
                //jrivas 16/3/2006 INC. DBLG500000436
                //mProductoLocal.setDescripcionCorta(descripcion);
                
                //los campos a continuacion se añaden por incidencia 20506
                if (indicadorProductoServicio!=null){
                    if (indicadorProductoServicio.equals("S")){
                        mProductoLocal.setIndProductoServicio(new Boolean(true));
                    }else{
                        mProductoLocal.setIndProductoServicio(new Boolean(false));
                    }
                }
                if (grupoArticulos!=null){
                    mProductoLocal.setGrupoArticulos(grupoArticulos);
                }
                if (jerarquia1 != null){
                    mProductoLocal.setJerarquia1(jerarquia1);
                }
                if (jerarquia2 != null){
                    mProductoLocal.setJerarquia2(jerarquia2);
                }
                if (jerarquia3 != null){
                    mProductoLocal.setJerarquia3(jerarquia3);
                }
                if (dimensionAlto != null){
                    mProductoLocal.setAlto(new BigDecimal(((Integer)dimensionAlto).intValue()));
                }
                if (dimensionLargo != null){
                    mProductoLocal.setLargo(new BigDecimal(((Integer)dimensionLargo).intValue()));
                }
                if (dimensionAncho != null){
                    mProductoLocal.setAncho(new BigDecimal(((Integer)dimensionAncho).intValue()));
                }
                if("L".equals(indicadorActualizacion)) { // sapaza -- PER-SiCC-2011-0056 -- 22/11/2011
                    if (indicadorDentroFueraCajaBolsa != null){
                        mProductoLocal.setIndCajaBolsa(indicadorDentroFueraCajaBolsa);
                    }
                }    
                if (volumen != null){
                    mProductoLocal.setVolumen(new BigDecimal(((Integer)volumen).intValue()));
                }
                if (pesoBruto != null){
                    mProductoLocal.setPeso(new BigDecimal(((Integer)pesoBruto).intValue()));
                }
                if (precioCosteEstandar != null){
                    mProductoLocal.setCosteEstandard(new BigDecimal(((Float)precioCosteEstandar).floatValue()));
                }
                if (codigoAntiguo != null){
                    mProductoLocal.setCodigoAntiguo(codigoAntiguo);
                }
            
                mProductoLocal.setCodigoUnicoVenta(codigoUnicoVenta); //[1]
                //modificado por la incidencia 20440
                //comprobamos si existe la descripcion del producto. Si existe se actualiza, sino, se inserta
                try{
                    e18nLocal=e18nLH.findByEntAtrIdioPK("MAE_PRODU", new Long(1),(Long)idiomaLocal.getPrimaryKey(),mProductoLocal.getOid());
                    //e18nLocal.setDetalle(descripcion);
                    //modificado por Sapaza, fecha 13-02-2008, incidencia SiCC-20080561
                    dao.actualizarDescripcion18n(e18nLocal.getOid(), "MAE_PRODU", descripcion);
                }catch (NoResultException fe){
                    //insertamos la descripcion internacionalizable del producto
                    try{
                       e18nLocal=e18nLH.create("MAE_PRODU",new Long(1),(Long)idiomaLocal.getPrimaryKey(),descripcion, mProductoLocal.getOid());
                    }catch(PersistenceException ce){
                       DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0013 + "Producto\n" +ce.getMessage());
                       gi.registrarError(dtoError);
                       continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } 
                Cronometrador.endTransaction("CargaProducto");
            }                 
            
            //sapaza -- cambio APE -- 20/07/2010
            //invocamos al proceso de Actualizar Productos en APE
             dao.actualizarMaestrosProductosAPE(dto.getOid());
            
        }catch (InterfacesException ie) {        
            UtilidadesLog.error("ERROR",ie);
            //preguntar
            return;
        }catch(RemoteException re){             
            UtilidadesLog.error("[CS]MError RemoteException",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

        }
        Cronometrador.endTransaction("MONINTSAPBean.recepcionarProductos");
        UtilidadesLog.info("MONINTSAPBean.recepcionarProductos(DTOOID dto): Salida");
    }
    
    
    public void recepcionarStocksDiarios(DTOOID dto) throws MareException{
    UtilidadesLog.info("MONINTSAPBean.recepcionarStocksDiarios(DTOOID dto): Entrada");
        MONGestorInterfaces gi = null;
        InterfazInfo interfaz=null;
        gi= this.getMONGestorInterfaces();   
        String codPais = "";
        ArrayList listaRegistros = new ArrayList();   
        ArrayList listaAlmacenes = new ArrayList();
        ArrayList listaProductos = new ArrayList();
        ArrayList listaDetalles = new ArrayList();
        int contadorRegistros = 0;
        Long oidPais = null;
        Long oidProducto = null;
        Long tipoMovimiento = null;
        Long oidTipoMovimiento = null;
        Long oidTipoMovimientoPositivo = null;
        Long oidTipoMovimientoNegativo = null;
        Cronometrador.startTransaction("Recepcionar Stocks Diarios ----> ");
        Cronometrador.startTransaction("Cargar Registros --> "); 
        try{
             interfaz =gi.importarInterfaz((String)IGestorInterfaces.COD_INTERFAZ_SAM6, dto.getOid()); 
             UtilidadesLog.debug("[CS]MIMPORTAMOS INTERFAZ recepcionarStocksDiarios: ");
        }catch (InterfacesException ie) {            
            UtilidadesLog.debug("***ACABA CASO DE USO MONINSAP.recepcionarStocksDiarios: error InterfacesException \n REturn");
            UtilidadesLog.error("ERROR", ie);
            try{
                gi.cerrarInterfaz(interfaz);
            }catch(Exception e){
                //UtilidadesLog.error(e);
            }
            // sapaza -- Error en Lectura de archivo SAM-6 -- 13/06/2011
            throw new MareException(ie,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));
        }catch(RemoteException re){                 
          UtilidadesLog.debug("error RemoteException");
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        
        try {
            for(IRegistroSicc registro = gi.cargarRegistro(interfaz, false);
                  registro != null;
                  registro = gi.cargarRegistro(interfaz, false)) {
                  if (contadorRegistros == 0){
                    codPais = (String)registro.obtenerCampo((String)IRegistroSicc.SAM6_CODIGO);
                    listaAlmacenes.add(registro.obtenerCampo((String)IRegistroSicc.SAM6_ALMACEN_SICC));
                  } else {
                    if (!(listaAlmacenes.contains(registro.obtenerCampo((String)IRegistroSicc.SAM6_ALMACEN_SICC)))) {
                      listaAlmacenes.add(registro.obtenerCampo((String)IRegistroSicc.SAM6_ALMACEN_SICC));  
                    }
                  }                                    
                  listaProductos.add(registro.obtenerCampo((String)IRegistroSicc.SAM6_PRODUCTO_SAP));
                  String codigoAlmacen = (String)registro.obtenerCampo((String)IRegistroSicc.SAM6_ALMACEN_SICC);
                  String codigoProducto = (String)registro.obtenerCampo((String)IRegistroSicc.SAM6_PRODUCTO_SAP);
                  Long valorStock = new Long(((Long)registro.obtenerCampo(IRegistroSicc.SAM6_STOCK_LIBRE_DISPOSICION)).longValue());
                  DTOINTCargaInicialStockDiarios dtoRegistro = new DTOINTCargaInicialStockDiarios();
                  dtoRegistro.setCodAlmacen(codigoAlmacen.toString());
                  dtoRegistro.setCodProducto(codigoProducto.toString());
                  dtoRegistro.setValorStock(valorStock);
                  listaRegistros.add(dtoRegistro);                  
                  contadorRegistros++;
            } 
        }catch (InterfacesException ie) {
             UtilidadesLog.debug("***ACABA CASO DE USO MONINSAP.recepcionarStocksDiarios: error InterfacesException \n Continue Diseño");
        }catch(RemoteException re){                
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(re,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Cronometrador.endTransaction("Cargar Registros --> ");
        Cronometrador.startTransaction("Cargar Movimientos --> ");
        oidPais = this.obtenerOidPais(codPais);
        boolean cargarRegistro = false;
        if (!(oidPais == null)){          
          HashMap hashAlmacenes = this.obtenerDatosAlmacenes(codPais,listaAlmacenes);
          HashMap hashProductos = new HashMap();
          HashMap hashMovimientosAlmacen = new HashMap();
          RecordSet tipoMovimientos = this.obtenerDatosTipoMovimiento(oidPais);
          if ((!(tipoMovimientos == null))&&(!(tipoMovimientos.esVacio()))){
            oidTipoMovimiento = this.bigDecimalToLong(tipoMovimientos.getValueAt(0,"OID_MOVI_STOC"));
            oidTipoMovimientoPositivo = this.bigDecimalToLong(tipoMovimientos.getValueAt(0,"TMAL_OID_TIPO_MOVI_ALMA"));
            oidTipoMovimientoNegativo = this.bigDecimalToLong(tipoMovimientos.getValueAt(0,"TMAL_OID_TIPO_NEGA_ALMA"));         
          }
          for (int i=0;i<listaRegistros.size();i++){
            cargarRegistro = false;
            DTOINTCargaInicialStockDiarios dtoStockDiario = (DTOINTCargaInicialStockDiarios)listaRegistros.get(i);
            DTOINTAsignacionAlmacen dtoAlmacen = (DTOINTAsignacionAlmacen)hashAlmacenes.get(dtoStockDiario.getCodAlmacen());
            if (!(dtoAlmacen == null)){
                if (i==0){      
                    Cronometrador.startTransaction("Cargar Productos --> ");  
                    hashProductos = this.obtenerOidsProductos(oidPais, listaProductos);         
                    Cronometrador.endTransaction("Cargar Productos --> ");  
                }  
                oidProducto = (Long)hashProductos.get(dtoStockDiario.getCodProducto());
                if (!(oidProducto == null)){
                    if (dtoStockDiario.getValorStock().doubleValue() >= 0){
                          tipoMovimiento = oidTipoMovimientoPositivo;  
                          cargarRegistro = true;
                    } else {
                          tipoMovimiento = oidTipoMovimientoNegativo;  
                          Long saldo = this.obtenerValorSaldoStock(tipoMovimiento, dtoAlmacen.getOidAlmacen(), oidProducto);
                          
                          if( saldo.longValue() < Math.abs(dtoStockDiario.getValorStock().longValue())){
                              cargarRegistro = false;
                              try {
                                UtilidadesLog.debug("saldo.longValue() < Math.abs(((Float)dtoStockDiario.getValorStock()).longValue() )");                              
                                IRegistroSicc registro = new RegistroSicc();
                                registro.anyadirCampo(registro.SAM6_CODIGO, codPais);
                                registro.anyadirCampo(registro.SAM6_ALMACEN_SICC, dtoStockDiario.getCodAlmacen());
                                registro.anyadirCampo(registro.SAM6_PRODUCTO_SAP, dtoStockDiario.getCodProducto());
                                registro.anyadirCampo(registro.SAM6_STOCK_LIBRE_DISPOSICION, dtoStockDiario.getValorStock());
                                DTOINTError dtoError= new DTOINTError(interfaz,registro,ErroresDeNegocio.INT_0008 + registro.SAM6_STOCK_LIBRE_DISPOSICION);                               
                                gi.registrarError(dtoError); 
                              } catch (InterfacesException ix){
                                  UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");                                  
                              } catch(RemoteException re){              
                                  UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");                                  
                                  throw new MareException(re,
                                        UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                              }                 
                          } else {
                              cargarRegistro = true;
                          }                        
                    }
                    if (cargarRegistro == true) {
                        if (hashMovimientosAlmacen == null || hashMovimientosAlmacen.get(dtoAlmacen.getOidAlmacen()) == null) {
                            DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera = new DTOMovimientoAlmacenCabecera();
                            dtoMovimientoAlmacenCabecera.setOidPais(oidPais);
                            dtoMovimientoAlmacenCabecera.setNumeroDocumento( (interfaz.getNumeroLote().toString()).substring(0,10) );
                            dtoMovimientoAlmacenCabecera.setFecha(new Date(System.currentTimeMillis()));
                            dtoMovimientoAlmacenCabecera.setOidAlmacenSalida(dtoAlmacen.getOidAlmacen());
                            dtoMovimientoAlmacenCabecera.setOidMarca(dtoAlmacen.getOidPais());            
                            dtoMovimientoAlmacenCabecera.setOidCanal(dtoAlmacen.getOidCanal()); 
                            dtoMovimientoAlmacenCabecera.setOidAcceso(dtoAlmacen.getOidAcceso()); 
                            dtoMovimientoAlmacenCabecera.setOidSubacceso(dtoAlmacen.getOidSubacceso()); 
                            dtoMovimientoAlmacenCabecera.setOidPeriodo(dtoAlmacen.getOidPeriodo());        
                            dtoMovimientoAlmacenCabecera.setObservaciones(ConstantesINT.OBSERV_SAM6 ) ;
                            dtoMovimientoAlmacenCabecera.setIndicadorNoGenerarCabecera(new Boolean(false));
                            
                            DTOMovimientoAlmacen dtoMovAlmacen = new DTOMovimientoAlmacen();
                            dtoMovAlmacen.setCabecera(dtoMovimientoAlmacenCabecera);
                            dtoMovAlmacen.setDetalle(listaDetalles); 
                            dtoMovAlmacen.setOidPais(oidPais);
                            dtoMovAlmacen.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO); 
                            hashMovimientosAlmacen.put(dtoAlmacen.getOidAlmacen(), dtoMovAlmacen);
                        }
                        DTOMovimientoAlmacenDetalle dtoDetalle= new DTOMovimientoAlmacenDetalle();
              
                        dtoDetalle.setOidTipoMovimientoAlmacen(tipoMovimiento);
                        dtoDetalle.setOidAlmacenSalida(dtoAlmacen.getOidAlmacen());
                        dtoDetalle.setOidProducto(oidProducto);  
                        dtoDetalle.setCantidad(new Long(dtoStockDiario.getValorStock().longValue()));
                        dtoDetalle.setObservaciones(ConstantesINT.OBSERV_SAM6 + "/" + interfaz.getNumeroLote());
                        dtoDetalle.setOperacion(ConstantesINT.COD_OP_INT124);
                        DTOMovimientoAlmacen dtoMovimiento = new DTOMovimientoAlmacen();
                        dtoMovimiento = (DTOMovimientoAlmacen)hashMovimientosAlmacen.get(dtoAlmacen.getOidAlmacen());                    
                        ArrayList lista = new ArrayList();
                        lista = dtoMovimiento.getDetalle();
                        lista.add(dtoDetalle);
                        dtoMovimiento.setDetalle(lista);
                        hashMovimientosAlmacen.put(dtoAlmacen.getOidAlmacen(), dtoMovimiento);
                    }
                } else {
                    try {
                      UtilidadesLog.info("Codigo de Producto no existe");  
                      IRegistroSicc registro = new RegistroSicc();
                      registro.anyadirCampo(registro.SAM6_CODIGO, codPais);
                      registro.anyadirCampo(registro.SAM6_ALMACEN_SICC, dtoStockDiario.getCodAlmacen());
                      registro.anyadirCampo(registro.SAM6_PRODUCTO_SAP, dtoStockDiario.getCodProducto());
                      registro.anyadirCampo(registro.SAM6_STOCK_LIBRE_DISPOSICION, dtoStockDiario.getValorStock());
                      DTOINTError dtoError = new DTOINTError (interfaz,registro,ErroresDeNegocio.INT_0005 + registro.SAM6_PRODUCTO_SAP);                      
                      gi.registrarError(dtoError);                      
                    } catch (InterfacesException ix){
                        UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");
                    } catch(RemoteException re){              
                        UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");                        
                        throw new MareException(re,
                              UtilidadesError.armarCodigoError(
                                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }                 
                }
            } else {   
              try {
                UtilidadesLog.info("Codigo de Almacen no existe");
                IRegistroSicc registro = new RegistroSicc();
                registro.anyadirCampo(registro.SAM6_CODIGO, codPais);
                registro.anyadirCampo(registro.SAM6_ALMACEN_SICC, dtoStockDiario.getCodAlmacen());
                registro.anyadirCampo(registro.SAM6_PRODUCTO_SAP, dtoStockDiario.getCodProducto());
                registro.anyadirCampo(registro.SAM6_STOCK_LIBRE_DISPOSICION, dtoStockDiario.getValorStock());
                DTOINTError dtoError = new DTOINTError (interfaz,registro,ErroresDeNegocio.INT_0006 + registro.SAM6_ALMACEN_SICC);                
                gi.registrarError(dtoError);
                gi.cerrarInterfaz(interfaz);
                return;
              } catch (InterfacesException ix){
                  UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");                  
              } catch(RemoteException re){              
                  UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");
                  throw new MareException(re,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }                 
            }          
          }
          try {
            gi.cerrarInterfaz(interfaz);
          } catch (InterfacesException ix){
                  UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");            
          } catch(RemoteException re){              
              UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");
              throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }                 
          Cronometrador.endTransaction("Cargar Movimientos --> ");
          Iterator it = ((Collection) hashMovimientosAlmacen.values()).iterator();
          
          //Agregado por Sapaza, fecha 03-06-2008, Se inicializa el stock disponible a 0, siempre y cuando haya datos para actualizar
          if(it.hasNext()) {
            inicializarStock();      
          }

          while (it.hasNext()){ 
            Cronometrador.startTransaction("Grabar Movimientos --> ");
            this.grabarMovimientoAlmacenYStock((DTOMovimientoAlmacen)it.next());
            Cronometrador.endTransaction("Grabar Movimientos --> ");
          }
        } else {
              try {
                UtilidadesLog.info("Codigo de Pais no existe");
                IRegistroSicc registro = new RegistroSicc();
                registro.anyadirCampo(registro.SAM6_CODIGO, codPais);
                DTOINTCargaInicialStockDiarios dtoStockDiario = (DTOINTCargaInicialStockDiarios)listaRegistros.get(0);
                registro.anyadirCampo(registro.SAM6_ALMACEN_SICC, dtoStockDiario.getCodAlmacen());
                registro.anyadirCampo(registro.SAM6_PRODUCTO_SAP, dtoStockDiario.getCodProducto());
                registro.anyadirCampo(registro.SAM6_STOCK_LIBRE_DISPOSICION, dtoStockDiario.getValorStock());
                DTOINTError dtoError = new DTOINTError (interfaz,registro, ErroresDeNegocio.INT_0003 + registro.SAM6_CODIGO);                
                gi.registrarError(dtoError);
                gi.cerrarInterfaz(interfaz);
              } catch (InterfacesException ix){
                  UtilidadesLog.debug("***MONINSAP.generarEntradaSAP: error InterfacesException del gi.registrarError");                  
              } catch(RemoteException re){              
                  UtilidadesLog.error("***MONINSAP.generarEntradaSAP: error RemoteException del gi.registrarError");                  
                  throw new MareException(re,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              } 
        }
        Cronometrador.endTransaction("Recepcionar Stocks Diarios ----> ");
        UtilidadesLog.info("MONINTSAPBean.recepcionarStocksDiarios(DTOOID dto): Salida");
    }


    public void enviarMovimientosAlmacenDiariosBatch(DTOINTEnviarMovimientos dtoe) throws MareException {  
    UtilidadesLog.info("MONINTSAPBean.enviarMovimientosAlmacenDiariosBatch(DTOINTEnviarMovimientos dtoe): Entrada");
    
    DTOBatch dtoBatch = new DTOBatch("Enviar Movimientos Almacen Diarios", new MareBusinessID("INTEnviarMovimientosAlmacenDiarios"), dtoe);

    try {
        BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
    } catch (RemoteException re) {
        UtilidadesLog.error("#*ERROR*# MONINTSAP:enviarMovimientosAlmacenDiariosBatch", re);

        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
    }    
    UtilidadesLog.info("MONINTSAPBean.enviarMovimientosAlmacenDiariosBatch(DTOINTEnviarMovimientos dtoe): Entrada");
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }


  /**
   * 
   * @mejora se elimino la subquery que obtenia los movimientos de almacen por reclamos, los cuales no pasan por esta intreface ahora.
   * @cambio a causa de la mejora anterior, se eliminaron los filtros por tipo y subtipo de posicion en la ultima subquery.
   */
  private RecordSet obtenerMovimientosAlmacen(Long pais, Long canal, 
        Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos)throws MareException {    
        
        UtilidadesLog.info("MONINTSAPBean.obtenerMovimientosAlmacen:(Long pais, Long canal, Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos) Entrada");
       
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        StringBuffer filtroSubaccesos = this.crearFiltroSubacceso(subaccesos);
        StringBuffer filtroTiposMovimientos = this.crearFiltroTipoMovimientos(tiposMovimientos);
        
        consulta.append("SELECT * FROM (");
        consulta.append("(");
        consulta.append("SELECT PAI.COD_PAIS PAIS,  ");
        consulta.append("       CAN.COD_CANA CANAL, ");
        consulta.append("       AC.COD_ACCE ACCESO,");
        consulta.append("       SA.COD_SBAC SUBACCESO,");
        consulta.append("       STP.COD_TIPO_PERI,");
        consulta.append("       SPC.COD_PERI,");
        consulta.append("       TO_CHAR(MA.FEC_MOVI,'YYYYMMDD') FECHA,");
        consulta.append("       PTO.COD_TIPO_OFER,");
        consulta.append("       TMA.COD_TIPO_MOVI,	");
        consulta.append("       MN.COD_NEGO,");
        consulta.append("       SMP.COD_MARC_PROD,");
        consulta.append("       CASE WHEN (TMA.IND_MOVI_ENTR_ALMA = 1) THEN");
	   		consulta.append("           'T'");
        consulta.append("       ELSE");
	   	  consulta.append("         CASE WHEN (TMA.COD_OPER_1 = '+') THEN");
		   	consulta.append("           CASE WHEN (MAD.VAL_CANT > 0) THEN");
		   	consulta.append("             'I'");
	 		  consulta.append("           ELSE");
		   	consulta.append("             'S'");
				consulta.append("           END");
		    consulta.append("         ELSE");
		   	consulta.append("           CASE WHEN (TMA.COD_OPER_1 = '-') THEN");
			  consulta.append("             CASE WHEN (MAD.VAL_CANT > 0) THEN");
			  consulta.append("               'S'");
		 		consulta.append("             ELSE");
			  consulta.append("               'I'");						
				consulta.append("             END");
			  consulta.append("           END");
		    consulta.append("         END");
	      consulta.append("       END INDICADOR_ITS,	 ");  	  
	      consulta.append(" MP.COD_SAP,");
        consulta.append(" MAD.VAL_CANT CANTIDAD,");
	      consulta.append(" NVL(MAD.VAL_PREC_VENT_NETO,0) VAL_PREC_VENT_NETO,");
	      consulta.append(" NVL(MAD.VAL_PREC_CONT,0) VAL_PREC_CONT,   ");   
	      consulta.append(" BA_SALI.COD_ALMA COD_ALMA_SALI,");
	      consulta.append(" BA_ENTR.COD_ALMA COD_ALMA_ENTR,	");   																						  
        consulta.append(" MAD.NUM_DOCU_REFE NUM_DOCU_REFE,");
	      consulta.append(" PTP.COD_TIPO_POSI,");
	      consulta.append(" PSP.COD_SUBT_POSI, SMP.OID_MARC_PROD");
        consulta.append(" FROM BEL_MOVIM_ALMAC_CABEC MA,");
        consulta.append(" SEG_ACCES AC,");
        consulta.append(" SEG_SUBAC SA,");
        consulta.append(" BEL_MOVIM_ALMAC_DETAL MAD,");
        consulta.append(" BEL_TIPO_MOVIM_ALMAC TMA,");
        consulta.append(" SEG_PAIS PAI,");
        consulta.append(" SEG_CANAL CAN,");
        consulta.append(" SEG_PERIO_CORPO SPC,");
        consulta.append(" CRA_PERIO PER,");
        consulta.append(" SEG_TIPO_PERIO STP,");
        consulta.append(" BEL_ALMAC BA_ENTR,");
        consulta.append(" BEL_ALMAC BA_SALI,");
        consulta.append(" MAE_PRODU MP,");
        consulta.append(" MAE_NEGOC MN,");
        consulta.append(" SEG_MARCA_PRODU SMP,");
        consulta.append(" PED_TIPO_POSIC PTP,");
        consulta.append(" PED_SUBTI_POSIC PSP,");
        consulta.append(" PRE_TIPO_OFERT PTO	");	 
        consulta.append(" WHERE MA.SBAC_OID_SBAC = SA.OID_SBAC");
        consulta.append(" AND SA.ACCE_OID_ACCE = AC.OID_ACCE");        
        consulta.append(" AND MAD.NUM_LOTE_SAPM IS NULL");
        consulta.append(" AND MAD.MVAL_OID_MOVI_ALMA = MA.OID_MOVI_ALMA");
        consulta.append(" AND TMA.OID_TIPO_MOVI_ALMA = MAD.TMAL_OID_TIPO_MOVI_ALMA");
        consulta.append(" AND PAI.OID_PAIS = MA.PAIS_OID_PAIS");
        consulta.append(" AND CAN.OID_CANA = AC.CANA_OID_CANA");
        consulta.append(" AND SPC.OID_PERI = PER.PERI_OID_PERI");
        consulta.append(" AND MA.PERD_OID_PERI = PER.OID_PERI");
        consulta.append(" AND SPC.TIPE_OID_TIPO_PERI = STP.OID_TIPO_PERI");
        consulta.append(" AND BA_ENTR.OID_ALMA(+) = MAD.ALMC_OID_ALMA_ENTR");
        consulta.append(" AND BA_SALI.OID_ALMA = MAD.ALMC_OID_ALMA_SALI");
        consulta.append(" AND MP.OID_PROD = MAD.PROD_OID_PROD");
        consulta.append(" AND MP.NEGO_OID_NEGO = MN.OID_NEGO(+)");
        consulta.append(" AND SMP.OID_MARC_PROD(+) = MP.MAPR_OID_MARC_PROD");
        consulta.append(" AND PTP.OID_TIPO_POSI = MAD.TPOS_OID_TIPO_POSI");
        consulta.append(" AND PSP.OID_SUBT_POSI = MAD.STPO_OID_SUBT_POSI");
        consulta.append(" AND PTO.OID_TIPO_OFER(+) = MAD.TOFE_OID_TIPO_OFER");
        consulta.append("  AND MA.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        if (canal!=null){
            consulta.append(" AND AC.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if (acceso!=null){
            consulta.append(" AND SA.ACCE_OID_ACCE = ? ");
            parametros.add(acceso);
        }
        consulta.append(filtroSubaccesos.toString());
        consulta.append(filtroTiposMovimientos.toString());        
        consulta.append(" AND (MAD.OPER_OID_OPER = " + ConstantesBEL.OP_ACTUALIZAR_HOJA_DEMANDA + " OR MAD.OPER_OID_OPER = " +  ConstantesBEL.OP_INGRESO_FISICO_HOJA_DEMANDA  + " OR MAD.OPER_OID_OPER = " + ConstantesBEL.OP_GENERAR_REGISTRO_ABASTECIMIENTO + ")");                
        consulta.append(" )");
        consulta.append(" UNION ALL ");
        consulta.append(" (");
        consulta.append(" SELECT PAI.COD_PAIS PAIS,");
        consulta.append("       CAN.COD_CANA CANAL,");
        consulta.append("       AC.COD_ACCE ACCESO,");
        consulta.append("      SA.COD_SBAC SUBACCESO,");
        consulta.append("      STP.COD_TIPO_PERI,");
        consulta.append("   SPC.COD_PERI,");
        consulta.append("   TO_CHAR(MA.FEC_MOVI,'YYYYMMDD') FECHA,");
        consulta.append("   PTO.COD_TIPO_OFER,");
        consulta.append("  TMA.COD_TIPO_MOVI,	");
        consulta.append("  MN.COD_NEGO,");
        consulta.append("  SMP.COD_MARC_PROD,");
        consulta.append(" CASE WHEN (TMA.IND_MOVI_ENTR_ALMA = 1) THEN");
    	  consulta.append(" 		'T'");
        consulta.append("  ELSE");
        consulta.append("  	   CASE WHEN (TMA.COD_OPER_1 = '+') THEN");
        consulta.append("   		CASE WHEN (SUM(MAD.VAL_CANT) > 0) THEN");
        consulta.append("   			'I'");
        consulta.append("	    ELSE");
        consulta.append("   	   		'S'");
        consulta.append("		END");
        consulta.append("   ELSE");
        consulta.append("   	   CASE WHEN (TMA.COD_OPER_1 = '-') THEN");
        consulta.append("	   		CASE WHEN (SUM(MAD.VAL_CANT) > 0) THEN");
        consulta.append("	   			'S'");
        consulta.append(" 		    ELSE");
        consulta.append("	   	   		'I'	");					
        consulta.append("			END");
        consulta.append("   END");
        consulta.append("  END");
        consulta.append(" END INDICADOR_ITS,	   	  ");
        consulta.append(" MP.COD_SAP,");
        consulta.append("  SUM(MAD.VAL_CANT) CANTIDAD,");
        consulta.append(" DECODE(SUM(ABS(MAD.VAL_CANT)),0,0,SUM(NVL(MAD.VAL_PREC_VENT_NETO,0))/SUM(ABS(MAD.VAL_CANT))) VAL_PREC_VENT_NETO,");
        consulta.append(" DECODE(SUM(ABS(MAD.VAL_CANT)),0,0,SUM(NVL(MAD.VAL_PREC_CONT,0))/SUM(ABS(MAD.VAL_CANT))) VAL_PREC_CONT,      ");
        consulta.append(" BA_SALI.COD_ALMA COD_ALMA_SALI,");
        consulta.append(" BA_ENTR.COD_ALMA COD_ALMA_ENTR,	  "); 	
        // vbongiov -- 25/10/2006 -- DBLG700000179
        consulta.append(" NULL NUM_DOCU_REFE,");
        consulta.append(" NULL AS COD_TIPO_POSI,");
        consulta.append(" NULL AS COD_SUBT_POSI , SMP.OID_MARC_PROD");
        consulta.append(" FROM BEL_MOVIM_ALMAC_CABEC MA,");
        consulta.append("      SEG_ACCES AC,");
        consulta.append("      SEG_SUBAC SA,");
        consulta.append("     BEL_MOVIM_ALMAC_DETAL MAD,");
        consulta.append(" BEL_TIPO_MOVIM_ALMAC TMA,");
        consulta.append(" SEG_PAIS PAI,");
        consulta.append(" SEG_CANAL CAN,");
        consulta.append(" SEG_PERIO_CORPO SPC,");
        consulta.append(" CRA_PERIO PER,");
        consulta.append(" SEG_TIPO_PERIO STP,");
        consulta.append(" PRE_TIPO_OFERT PTO,");
        consulta.append(" BEL_ALMAC BA_ENTR,");
        consulta.append(" BEL_ALMAC BA_SALI,");
        consulta.append(" MAE_PRODU MP,");
        consulta.append(" MAE_NEGOC MN,");
        consulta.append(" SEG_MARCA_PRODU SMP	");	 
        consulta.append(" WHERE MA.SBAC_OID_SBAC = SA.OID_SBAC");
        consulta.append(" AND SA.ACCE_OID_ACCE = AC.OID_ACCE");
        consulta.append(" AND MAD.NUM_LOTE_SAPM IS NULL");
        consulta.append(" AND MAD.MVAL_OID_MOVI_ALMA = MA.OID_MOVI_ALMA");
        consulta.append(" AND TMA.OID_TIPO_MOVI_ALMA = MAD.TMAL_OID_TIPO_MOVI_ALMA");
        consulta.append(" AND PAI.OID_PAIS = MA.PAIS_OID_PAIS");
        consulta.append(" AND CAN.OID_CANA = AC.CANA_OID_CANA");
        consulta.append(" AND SPC.OID_PERI = PER.PERI_OID_PERI");
        consulta.append(" AND MA.PERD_OID_PERI = PER.OID_PERI");
        consulta.append(" AND SPC.TIPE_OID_TIPO_PERI = STP.OID_TIPO_PERI");
        consulta.append(" AND PTO.OID_TIPO_OFER(+) = MAD.TOFE_OID_TIPO_OFER");
        consulta.append(" AND BA_ENTR.OID_ALMA(+) = MAD.ALMC_OID_ALMA_ENTR");
        consulta.append(" AND BA_SALI.OID_ALMA = MAD.ALMC_OID_ALMA_SALI");
        consulta.append(" AND MP.OID_PROD = MAD.PROD_OID_PROD");
        consulta.append(" AND MP.NEGO_OID_NEGO = MN.OID_NEGO(+)");
        consulta.append(" AND SMP.OID_MARC_PROD(+) = MP.MAPR_OID_MARC_PROD");
        consulta.append("  AND MA.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        if (canal!=null){
            consulta.append(" AND AC.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if (acceso!=null){
            consulta.append(" AND SA.ACCE_OID_ACCE = ? ");
            parametros.add(acceso);
        }
        consulta.append(filtroSubaccesos.toString());
        consulta.append(filtroTiposMovimientos.toString());
        consulta.append(" AND (MAD.OPER_OID_OPER <> " + ConstantesBEL.OP_ACTUALIZAR_HOJA_DEMANDA + " OR MAD.OPER_OID_OPER <> " +  ConstantesBEL.OP_INGRESO_FISICO_HOJA_DEMANDA  + " OR MAD.OPER_OID_OPER <> " + ConstantesBEL.OP_GENERAR_REGISTRO_ABASTECIMIENTO + ")");
        consulta.append(" GROUP BY PAI.COD_PAIS,");
        consulta.append(" 	 CAN.COD_CANA,");
        consulta.append("	 AC.COD_ACCE,");
        consulta.append("	 SA.COD_SBAC,");
        consulta.append("	 STP.COD_TIPO_PERI,");
        consulta.append(" SPC.COD_PERI,");
        consulta.append(" TO_CHAR(MA.FEC_MOVI,'YYYYMMDD'),");
        consulta.append("     PTO.COD_TIPO_OFER,");
        consulta.append(" TMA.COD_TIPO_MOVI,");
        consulta.append("     MN.COD_NEGO,");
        consulta.append("   SMP.COD_MARC_PROD,");
        consulta.append(" MP.COD_SAP,");
        consulta.append("     BA_SALI.COD_ALMA,");
        consulta.append("   BA_ENTR.COD_ALMA,	 ");  																						  
        consulta.append(" TMA.COD_OPER_1,");
        consulta.append(" TMA.IND_MOVI_ENTR_ALMA,	SMP.OID_MARC_PROD");
        consulta.append(")");
        consulta.append(") WHERE CANTIDAD <> 0");
  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        
        try {
          resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
           UtilidadesLog.error("obtenerLineasReversion:",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }      
        UtilidadesLog.info("MONINTSAPBean.obtenerMovimientosAlmacen:(Long pais, Long canal, Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos) Salida");
        return resultado;
    }
    
    private StringBuffer crearFiltroSubacceso (ArrayList subaccesos) {
        StringBuffer filtroSubaccesos = new StringBuffer();
        filtroSubaccesos.append(" ");
        if (subaccesos.size()>0){
            filtroSubaccesos.append(" AND ( ");      
            String oidsSubaccesos = "";
            int j = 0;
            Iterator  it = subaccesos.iterator();
            while (it.hasNext()){
                Long oid = (Long)it.next();
                if (j == 0) {
                  oidsSubaccesos = "'" + oid.toString() + "'";
                } else {
                  oidsSubaccesos = oidsSubaccesos + ",'" + oid.toString() + "'";
                }
                if (j==999){
                    filtroSubaccesos.append(" SA.OID_SBAC IN (" + oidsSubaccesos.toString() + ") ");
                    if (it.hasNext()){
                      filtroSubaccesos.append(" OR ");                  
                    }                
                    j=0;
                    oidsSubaccesos = "";
                } else {
                  if (!it.hasNext()){
                    filtroSubaccesos.append(" SA.OID_SBAC IN (" + oidsSubaccesos.toString() + ") ");
                  }
                  j++;
                }        
            }
            filtroSubaccesos.append(") ");      
        }
      return filtroSubaccesos;
    }

    private StringBuffer crearFiltroTipoMovimientos(ArrayList tiposMovimientos)  {
        StringBuffer filtroTiposMovimientos = new StringBuffer();
        filtroTiposMovimientos.append(" ");
        if (tiposMovimientos.size() > 0) {
            filtroTiposMovimientos.append(" AND (");      
            String tipoMov = "";
            int k = 0;
            Iterator  it = tiposMovimientos.iterator();
            while (it.hasNext()){
                Long oid = (Long)it.next();
                if (k == 0) {
                  tipoMov = "'" + oid.toString() + "'";
                } else {
                  tipoMov = tipoMov + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroTiposMovimientos.append(" MAD.TMAL_OID_TIPO_MOVI_ALMA IN (" + tipoMov.toString() + ") ");
                  if (it.hasNext()){
                      filtroTiposMovimientos.append(" OR ");                  
                  }                
                  k=0;
                  tipoMov = "";
                } else {
                   if (!it.hasNext()){
                        filtroTiposMovimientos.append(" MAD.TMAL_OID_TIPO_MOVI_ALMA IN (" + tipoMov.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroTiposMovimientos.append(" ) ");      
        }     
        return filtroTiposMovimientos;
    }  
    
    private String objectToString(Object obj) {
        if (obj != null) {
            return obj.toString();
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
    
    
      private RecordSet obtenerOidsMovimientosAlmacenDetalles(Long pais, Long canal, 
        Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos)throws MareException {    
        
        UtilidadesLog.info("MONINTSAPBean.obtenerOidsMovimientosAlmacenDetalle:(Long pais, Long canal, Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos) Entrada");
       
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        StringBuffer filtroSubaccesos = this.crearFiltroSubacceso(subaccesos);
        StringBuffer filtroTiposMovimientos = this.crearFiltroTipoMovimientos(tiposMovimientos);        
        
        consulta.append(" SELECT MAD.OID_DETA  ");
        consulta.append(" FROM BEL_MOVIM_ALMAC_CABEC MA, ");
        consulta.append("      SEG_ACCES AC, ");
        consulta.append("      SEG_SUBAC SA, ");
        consulta.append("      BEL_MOVIM_ALMAC_DETAL MAD ");
        consulta.append("WHERE MA.SBAC_OID_SBAC = SA.OID_SBAC ");
        consulta.append("  AND SA.ACCE_OID_ACCE = AC.OID_ACCE ");
        consulta.append("  AND MA.PAIS_OID_PAIS = ?");
        consulta.append("  AND MAD.NUM_LOTE_SAPM IS NULL ");
        consulta.append("  AND MAD.MVAL_OID_MOVI_ALMA = MA.OID_MOVI_ALMA ");
        parametros.add(pais);
        if (canal!=null){
            consulta.append(" AND AC.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if (acceso!=null){
            consulta.append(" AND SA.ACCE_OID_ACCE = ? ");
            parametros.add(acceso);
        }
        consulta.append(filtroSubaccesos.toString());
        consulta.append(filtroTiposMovimientos.toString());        
  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        
        try {
          resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {          
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }      
        UtilidadesLog.info("MONINTSAPBean.obtenerOisMovimientosAlmacenDetalle:(Long pais, Long canal, Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos) Salida");
        return resultado;
    }
    
      private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

      private BigDecimal objectToBigDecimal(Object numero) {
        if (numero != null) {
            return new BigDecimal(((Float) numero).doubleValue());
        } else {
            return new BigDecimal(0);
        }
    }

    
    private StringBuffer crearStringUpdateMovimientosAlmacen(RecordSet oids, String numeroLote){
        UtilidadesLog.info("MONINTSAPBean.crearStringUpdateMovimientosAlmacen:(RecordSet oids, String numeroLote) Entrada");
        StringBuffer updateMovimientos = new StringBuffer();
        String bufferOids = "";
        int a = 0;
        
        for (int i = 0;i<oids.getRowCount();i++) {
            if (a == 0) {
                bufferOids = (this.bigDecimalToLong(oids.getValueAt(i,"OID_DETA"))).toString();                
            } else {
                bufferOids = bufferOids.toString() + "," +  (this.bigDecimalToLong(oids.getValueAt(i,"OID_DETA"))).toString();
            }
            if (a == 999){
                updateMovimientos.append("UPDATE BEL_MOVIM_ALMAC_DETAL SET NUM_LOTE_SAPM = " + numeroLote.toString() + " WHERE OID_DETA IN (" + bufferOids.toString() + ");");                        
                bufferOids = "";
                a = 0;
            } else {
                int b = i;
                b++;
                a++;
                if (b == oids.getRowCount()){
                    updateMovimientos.append("UPDATE BEL_MOVIM_ALMAC_DETAL SET NUM_LOTE_SAPM = " + numeroLote.toString() + " WHERE OID_DETA IN (" + bufferOids.toString() + ");");                        
                }
           }
        }
        UtilidadesLog.info("MONINTSAPBean.crearStringUpdateMovimientosAlmacen:(RecordSet oids, String numeroLote) Salida");
        return updateMovimientos;
    }
    
    private HashMap obtenerDatosAlmacenes(String codPais, ArrayList listaAlmacenes) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerOidsPaisYAlmacenes(String codPais, ArrayList listaAlmacenes) Entrada");
      StringBuffer consulta = new StringBuffer();
      StringBuffer filtroAlmacenes = this.crearFiltroAlmacenes(listaAlmacenes);
      
      consulta.append("SELECT OID_PAIS,");
	    consulta.append("       OID_ALMA,");
	    consulta.append("       OID_ACCE,");
	    consulta.append("       OID_SBAC,");
	    consulta.append("       OID_PERI,");
	    consulta.append("       CANA_OID_CANA,");
	    consulta.append("       MARC_OID_MARC,");
      consulta.append("       COD_ALMA ");
      consulta.append("FROM");
      consulta.append("   (");
      consulta.append("   SELECT PAI.OID_PAIS,");
		  consulta.append("          ALM.OID_ALMA,");
		  consulta.append("          ACC.OID_ACCE,");
		  consulta.append("          SUB.OID_SBAC,");
		  consulta.append("          PER.OID_PERI,");
		  consulta.append("          ACC.CANA_OID_CANA,");
		  consulta.append("          PER.MARC_OID_MARC,");
      consulta.append("          ALM.COD_ALMA,  ");
		  consulta.append("          SUM(1) OVER (PARTITION BY PAI.OID_PAIS, OID_ALMA ORDER BY ROWNUM) ORDEN   ");
      consulta.append("   FROM SEG_PAIS PAI,");
		  consulta.append("        BEL_ALMAC ALM,");
		  consulta.append("        PED_ASIGN_ALMAC PAA,");
		  consulta.append("        CRA_PERIO PER,");
		  consulta.append("        SEG_SUBAC SUB,");
		  consulta.append("        SEG_ACCES ACC");
	    consulta.append("   WHERE PAI.COD_PAIS = '" + codPais.toString() + "'");
		  consulta.append("     AND ALM.PAIS_OID_PAIS = PAI.OID_PAIS ");
      consulta.append(filtroAlmacenes.toString());		  
		  consulta.append("     AND PAA.PAIS_OID_PAIS = PAI.OID_PAIS");
	  	consulta.append("     AND PAA.ALMC_OID_ALMA = ALM.OID_ALMA");
		  consulta.append("     AND PER.PAIS_OID_PAIS = PAI.OID_PAIS");
		  consulta.append("     AND PER.CANA_OID_CANA = ACC.CANA_OID_CANA");
		  consulta.append("     AND SUB.OID_SBAC = PAA.SBAC_OID_SBAC");
		  consulta.append("     AND SUB.ACCE_OID_ACCE = ACC.OID_ACCE");
		  consulta.append("     AND PER.FEC_FINA >= TRUNC(SYSDATE)");
		  consulta.append("     AND PER.FEC_INIC <= TRUNC(SYSDATE)");
      consulta.append("   ) ");
      consulta.append("WHERE ORDEN = 1");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
       
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {         
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }      
      
      HashMap hashAlmacenes = new HashMap();
      if ((!(resultado == null))&&(!(resultado.esVacio()))){
        for (int i=0; i<resultado.getRowCount(); i++){
            DTOINTAsignacionAlmacen datosAlmacen = new DTOINTAsignacionAlmacen();
            datosAlmacen.setOidPais(this.bigDecimalToLong(resultado.getValueAt(i,"OID_PAIS")));
            datosAlmacen.setOidAlmacen(this.bigDecimalToLong(resultado.getValueAt(i,"OID_ALMA")));
            datosAlmacen.setOidAcceso(this.bigDecimalToLong(resultado.getValueAt(i,"OID_ACCE")));
            datosAlmacen.setOidSubacceso(this.bigDecimalToLong(resultado.getValueAt(i,"OID_SBAC")));
            datosAlmacen.setOidPeriodo(this.bigDecimalToLong(resultado.getValueAt(i,"OID_PERI")));
            datosAlmacen.setOidCanal(this.bigDecimalToLong(resultado.getValueAt(i,"CANA_OID_CANA")));
            datosAlmacen.setOidMarca(this.bigDecimalToLong(resultado.getValueAt(i,"MARC_OID_MARC")));
            hashAlmacenes.put(this.objectToString(resultado.getValueAt(i,"COD_ALMA")),datosAlmacen);
        }
      }      
      UtilidadesLog.info("MONINTSAPBean.obtenerOidsPaisYAlmacenes(String codPais, ArrayList listaAlmacenes) Salida");
      return hashAlmacenes;      
    }
    
    
    private StringBuffer crearFiltroAlmacenes(ArrayList listaAlmacenes)  {
        StringBuffer filtroAlmacenes = new StringBuffer();
        filtroAlmacenes.append(" ");
        if (listaAlmacenes.size() > 0) {
            filtroAlmacenes.append(" AND (");      
            String almacenes = "";
            int k = 0;
            Iterator  it = listaAlmacenes.iterator();
            while (it.hasNext()){
                String oid = (String)it.next();
                if (k == 0) {
                  almacenes = "'" + oid.toString() + "'";
                } else {
                  almacenes = almacenes + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroAlmacenes.append(" ALM.COD_ALMA IN (" + almacenes.toString() + ") ");
                  if (it.hasNext()){
                      filtroAlmacenes.append(" OR ");                  
                  }                
                  k=0;
                  almacenes = "";
                } else {
                   if (!it.hasNext()){
                        filtroAlmacenes.append(" ALM.COD_ALMA IN (" + almacenes.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroAlmacenes.append(" ) ");      
        }     
        return filtroAlmacenes;
    }  
    
    private HashMap obtenerOidsProductos(Long oidPais, ArrayList listaProductos) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerOidsProductos(Long oidPais, ArrayList listaProductos) Entrada");
      
      HashMap hashProductos = new HashMap();
      ArrayList listaAuxiliar = new ArrayList();
      int count = 0;
      for (int x=0; x<listaProductos.size(); x++){
          if (count < 2000) {
            listaAuxiliar.add(count, listaProductos.get(x));
            if (x == listaProductos.size()-1) {
                  RecordSet resultado = this.crearQueryProductos(oidPais, listaAuxiliar);                  
                  if ((!(resultado == null))&&(!(resultado.esVacio()))){
                    for (int i=0; i<resultado.getRowCount(); i++){
                        hashProductos.put(this.objectToString(resultado.getValueAt(i,"COD_SAP")), this.bigDecimalToLong(resultado.getValueAt(i,"OID_PROD")));
                    }
                  }      
                  listaAuxiliar.clear();
             }
            count++;
          } else {
            listaAuxiliar.add(count, listaProductos.get(x));
            RecordSet resultado = this.crearQueryProductos(oidPais, listaAuxiliar);                              
            if ((!(resultado == null))&&(!(resultado.esVacio()))){
              for (int i=0; i<resultado.getRowCount(); i++){
                  hashProductos.put(this.objectToString(resultado.getValueAt(i,"COD_SAP")), this.bigDecimalToLong(resultado.getValueAt(i,"OID_PROD")));
              }
            }      
            count = 0;
            listaAuxiliar.clear();
          }       
      }
      
      UtilidadesLog.info("MONINTSAPBean.obtenerOidsProductos(Long oidPais, ArrayList listaProductos) Salida");
      return hashProductos;            
    }
    
    
    private RecordSet crearQueryProductos(Long oidPais, ArrayList listaProductos) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.crearQueryProductos(Long oidPais, ArrayList listaProductos) Entrada");

      StringBuffer consulta = new StringBuffer();
      consulta.append("SELECT OID_PROD, ");
      consulta.append("       COD_SAP ");
      consulta.append(" FROM MAE_PRODU MP ");
      consulta.append(" WHERE MP.PAIS_OID_PAIS = " + oidPais);
      consulta.append(this.crearFiltroProductos(listaProductos));
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
       
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {                       
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                      
      }              
                  
      UtilidadesLog.info("MONINTSAPBean.crearQueryProductos(Long oidPais, ArrayList listaProductos) Entrada");                  
      return resultado;
    }
    
    
    private StringBuffer crearFiltroProductos(ArrayList listaProductos)  {
        StringBuffer filtroProductos = new StringBuffer();
        filtroProductos.append(" ");
        if (listaProductos.size() > 0) {
            filtroProductos.append(" AND (");      
            String productos = "";
            int k = 0;
            Iterator  it = listaProductos.iterator();
            while (it.hasNext()){
                String oid = (String)it.next();
                if (k == 0) {
                  productos = "'" + oid.toString() + "'";
                } else {
                  productos = productos + ",'" + oid.toString() + "'";
                }
                if (k==999){
                  filtroProductos.append(" MP.COD_SAP IN (" + productos.toString() + ") ");
                  if (it.hasNext()){
                      filtroProductos.append(" OR ");                  
                  }                
                  k=0;
                  productos = "";
                } else {
                   if (!it.hasNext()){
                        filtroProductos.append(" MP.COD_SAP IN (" + productos.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroProductos.append(" ) ");      
        }     
        return filtroProductos;
    }  

    private Long obtenerOidPais(String codPais) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerOidPais(Stirng codPais) Entrada");
      StringBuffer consulta = new StringBuffer();
      
      consulta.append("SELECT OID_PAIS ");	    
      consulta.append(" FROM SEG_PAIS PAIS ");
      consulta.append(" WHERE PAIS.COD_PAIS = '" + codPais.toString() + "'");      
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
       
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }  
      
      Long oidPais = null;
      
      if ((!(resultado == null))&&(!(resultado.esVacio()))){        
            oidPais = this.bigDecimalToLong(resultado.getValueAt(0,"OID_PAIS"));
      }      
      UtilidadesLog.info("MONINTSAPBean.obtenerOidPais(Stirng codPais) Salida");
      return oidPais;            
    }
    
     private RecordSet obtenerDatosTipoMovimiento (Long oidPais) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerDatosTipoMovimiento (Long oidPais) Entrada");
      StringBuffer consulta = new StringBuffer();
      
      consulta.append(" SELECT IMS.OID_MOVI_STOC, ");
	    consulta.append("       IMS.TMAL_OID_TIPO_MOVI_ALMA, ");
	    consulta.append("       IMS.TMAL_OID_TIPO_NEGA_ALMA "); 
      consulta.append(" FROM INT_MOVIM_STOCK IMS ");
      consulta.append(" WHERE IMS.PAIS_OID_PAIS = " + oidPais);
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
       
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }        
      UtilidadesLog.info("MONINTSAPBean.obtenerDatosTipoMovimiento (Long oidPais) Salida");
      return resultado;
    }
        
     private Long obtenerValorSaldoStock (Long oidTipoMovimientoNegativo, Long oidAlmacen, Long oidProducto) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerValorSaldoStock (Long oidTipoMovimientoNegativo, Long oidAlmacen, Long oidProducto) Entrada");
      StringBuffer consulta = new StringBuffer();
      Long saldo = new Long(0);
      
      consulta.append(" SELECT STO.VAL_SALD ");
      consulta.append(" FROM BEL_TIPO_MOVIM_ALMAC TMA, ");
      consulta.append("      BEL_STOCK STO ");
      consulta.append(" WHERE TMA.OID_TIPO_MOVI_ALMA = " + oidTipoMovimientoNegativo);
      consulta.append("   AND STO.ALMC_OID_ALMA = " + oidAlmacen);
      consulta.append("   AND STO.ESME_OID_ESTA_MERC = TMA.ESME_OID_ESTA_MERC_1 ");
      consulta.append("   AND STO.PROD_OID_PROD = " + oidProducto);
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
       
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }        
      
      if ((!(resultado == null))&&(!(resultado.esVacio()))){
        saldo = this.bigDecimalToLong(resultado.getValueAt(0,"VAL_SALD"));
      }
      UtilidadesLog.info("MONINTSAPBean.obtenerValorSaldoStock (Long oidTipoMovimientoNegativo, Long oidAlmacen, Long oidProducto) Salida");
      return saldo;
    }

   public void grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dtoMovimientoAlmacen) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dtoMovimientoAlmacen):Entrada");
        if (!(dtoMovimientoAlmacen == null)){
            if ((!(dtoMovimientoAlmacen.getCabecera() == null)) && (!(dtoMovimientoAlmacen.getDetalle() == null))){
               this.procesarMovimientoAlmacen(dtoMovimientoAlmacen);
            }        
        }
        UtilidadesLog.info("MONINTSAPBean.grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dtoMovimientoAlmacen):Salida");        
    }
    
     private void procesarMovimientoAlmacen(DTOMovimientoAlmacen dtoMovimientoAlmacen) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.procesarMovimientoAlmacen(DTOMovimientoAlmacen dtoMovimientoAlmacen):Entrada");
        dtoMovimientoAlmacen = this.grabarMovimientoCabecera(dtoMovimientoAlmacen);
    
        int longitud = dtoMovimientoAlmacen.getDetalle().size();
        DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera = (DTOMovimientoAlmacenCabecera)dtoMovimientoAlmacen.getCabecera();
        Long oidOperacion = this.obtenerOidOperacion(ConstantesINT.COD_OP_INT124);
        ArrayList arrayMovimientosDetalle = dtoMovimientoAlmacen.getDetalle();        
        ArrayList arrayProductos = new ArrayList();          
        int count = 0;
        for (int i = 0; i < longitud; i++) {
            DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = (DTOMovimientoAlmacenDetalle)arrayMovimientosDetalle.get(i);            
            arrayProductos.add(count, dtoMovimientoAlmacenDetalle.getOidProducto());
            if (count == cantidadRegistrosAProcesar){
                Cronometrador.startTransaction("Generar Movimientos Detalle y Stock -->");
                this.insertarStockYMovimientosDetalle(dtoMovimientoAlmacenCabecera, arrayMovimientosDetalle, arrayProductos, i ,count, dtoMovimientoAlmacen, oidOperacion);
                Cronometrador.endTransaction("Generar Movimientos Detalle y Stock -->");
                arrayProductos.clear();
                count = 0;                                                                            
            } else {
                if (i == longitud - 1){
                    Cronometrador.startTransaction("Generar Movimientos Detalle y Stock -->");                
                    this.insertarStockYMovimientosDetalle(dtoMovimientoAlmacenCabecera, arrayMovimientosDetalle, arrayProductos, i ,count, dtoMovimientoAlmacen, oidOperacion);
                    Cronometrador.endTransaction("Generar Movimientos Detalle y Stock -->");
                    arrayProductos.clear();                                        
                    count = 0;                                                            
                } else {
                    count++;
                }
            }
       }
        
        UtilidadesLog.info("MONINTSAPBean.procesarMovimientoAlmacen(DTOMovimientoAlmacen dtoMovimientoAlmacen):Salida");
    }
    
    private void insertarStockYMovimientosDetalle(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera, ArrayList arrayMovimientosDetalle, 
                      ArrayList arrayProductos, int i, int count, DTOMovimientoAlmacen dtoMovimientoAlmacen, Long oidOperacion) throws MareException{

        UtilidadesLog.info("MONINTSAPBean.insertarStockYMovimientosDetalle():Entrada");
        
        Cronometrador.startTransaction("Obtener Stock Productos Estado 1 -->>");
        HashMap hashStockProductoEstado1 = this.obtenerStockProductos(dtoMovimientoAlmacenCabecera.getOidAlmacenSalida(), 
                                                  this.dtoTipoMovimientoAlmacen.getOidEstadoMercancia1(), arrayProductos);     
        Cronometrador.endTransaction("Obtener Stock Productos Estado 1 -->>");
        StringBuffer query = new StringBuffer();
        Cronometrador.startTransaction("Obtener Cadenas Stock Estado 1 -->>");
        query.append(this.obtenerCadenasStock(dtoMovimientoAlmacen, i, count, hashStockProductoEstado1, this.dtoTipoMovimientoAlmacen.getOidEstadoMercancia1()));         
        Cronometrador.endTransaction("Obtener Cadenas Stock Estado 1 -->>");
        if (this.dtoTipoMovimientoAlmacen.getOidEstadoMercancia2() != null){
            Cronometrador.startTransaction("Obtener Stock Productos Estado 2 -->>");
            HashMap hashStockProductoEstado2 = this.obtenerStockProductos(dtoMovimientoAlmacenCabecera.getOidAlmacenSalida(), 
                                                      this.dtoTipoMovimientoAlmacen.getOidEstadoMercancia2(), arrayProductos);                
            Cronometrador.endTransaction("Obtener Stock Productos Estado 2 -->>");                                                      
            Cronometrador.startTransaction("Obtener Cadenas Stock Estado 2 -->>");    
            query.append(this.obtenerCadenasStock(dtoMovimientoAlmacen, i, count, hashStockProductoEstado2, this.dtoTipoMovimientoAlmacen.getOidEstadoMercancia2()));        
            Cronometrador.startTransaction("Obtener Cadenas Stock Estado 2 -->>");
        }
        Cronometrador.startTransaction("Obtener Cadenas Detalle Movimiento -->>");
        query.append(this.generarCadenaInsercionDetalleMovimiento(dtoMovimientoAlmacenCabecera.getOid(), arrayMovimientosDetalle, i, count, oidOperacion,dtoMovimientoAlmacenCabecera.getNumeroMovimiento()));
        Cronometrador.endTransaction("Obtener Cadenas Detalle Movimiento -->>");
        
        Cronometrador.startTransaction("Insercion Detalles de Movimientos y Stock-->");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {      
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
          throw new MareException(e,
          UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        Cronometrador.endTransaction("Insercion Detalles de Movimientos y Stock-->");
        
        UtilidadesLog.info("MONINTSAPBean.insertarStockYMovimientosDetalle():Salida");    
    
    }
    
    private DTOMovimientoAlmacen grabarMovimientoCabecera(DTOMovimientoAlmacen dtoMovimientoAlmacen) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.grabarMovimientoCabecera(DTOMovimientoAlmacen dtoMovimientoAlmacen):Entrada");        
        if (dtoMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen()!=null) {
            this.dtoTipoMovimientoAlmacen = this.recuperarOperaciones(dtoMovimientoAlmacen.getCabecera().getOidTipoMovimientoAlmacen());
        } else {
            ArrayList array = dtoMovimientoAlmacen.getDetalle();
            DTOMovimientoAlmacenDetalle dto = (DTOMovimientoAlmacenDetalle)array.get(0);
            this.dtoTipoMovimientoAlmacen = this.recuperarOperaciones(dto.getOidTipoMovimientoAlmacen());
        }

        if (this.dtoTipoMovimientoAlmacen.getMantieneMovimientos().booleanValue() == true) {
            if (dtoMovimientoAlmacen.getCabecera().getIndicadorNoGenerarCabecera() == null
                || dtoMovimientoAlmacen.getCabecera().getIndicadorNoGenerarCabecera().booleanValue() == false) {
                DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
                
                dtoNumeroSolicitud.setOidPais(dtoMovimientoAlmacen.getCabecera().getOidPais());
                dtoNumeroSolicitud.setOidIdioma(dtoMovimientoAlmacen.getCabecera().getOidIdioma());
                dtoNumeroSolicitud.setOperacion("BEL001");
                dtoNumeroSolicitud.setOidCanal(dtoMovimientoAlmacen.getCabecera().getOidCanal());
                dtoNumeroSolicitud.setOidAcceso(dtoMovimientoAlmacen.getCabecera().getOidAcceso());
                dtoNumeroSolicitud.setOidSubacceso(dtoMovimientoAlmacen.getCabecera().getOidSubacceso());

                MONProcesosPED monProcesosPED = this.getMONProcesosPED();
                String numeroDocumento = null;
	
                try {
                    numeroDocumento = monProcesosPED.generaNumeroDocumento(dtoNumeroSolicitud);
                } catch (RemoteException ex) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("grabarMovimientoCabecera: RemoteException: MovimientosAlmacenCabecera",
                        ex);
                    throw new MareException(ex,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }			
        
                dtoMovimientoAlmacen.getCabecera().setNumeroMovimiento(numeroDocumento);
                dtoMovimientoAlmacen.getCabecera().setOid(this.obtenerOidMovimientosAlmacenCabecera());
                
                DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera =  dtoMovimientoAlmacen.getCabecera();                
                StringBuffer insercionCabecera = this.crearStringInsercionMovimientosAlmacenCabecera(dtoMovimientoAlmacenCabecera);
                
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                int resultado;
                String codigoError = null;
      
                try {
                  resultado = bs.dbService.executeUpdate(insercionCabecera.toString());
                } catch (Exception e) {
                    codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }  
                if (resultado == 0) {
                   codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                   throw new MareException(codigoError);
                }
            }
        }

        UtilidadesLog.info("MONINTSAPBean.grabarMovimientoCabecera(DTOMovimientoAlmacen dtoMovimientoAlmacen):Salida");
        return dtoMovimientoAlmacen;
    }
    
    private Long obtenerOidMovimientosAlmacenCabecera() throws MareException {
        UtilidadesLog.info("MONINTSAPBean.obtenerOidMovimientosAlmacenCabecera():Entrada");
        StringBuffer consulta = new StringBuffer();
        Long oid = null;
        consulta.append(" SELECT BEL_MVAL_SEQ.NEXTVAL ");
        consulta.append(" FROM DUAL ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
      
        try {
          resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                    
        
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
            oid = this.bigDecimalToLong(resultado.getValueAt(0,0));    
        }
        UtilidadesLog.info("MONINTSAPBean.obtenerOidMovimientosAlmacenCabecera():Salida");        
        return oid;
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
    
     private MONProcesosPED getMONProcesosPED() throws MareException {
        // Se obtiene el interfaz home
        MONProcesosPEDHome home = (MONProcesosPEDHome) UtilidadesEJB.getHome(MON_PROCESO_PED,
                MONProcesosPEDHome.class);

        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONProcesosPED", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        return ejb;
    }
    
    
    private DTOTipoMovimientoAlmacen recuperarOperaciones(Long oidTipoMovimientoAlmacen) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.recuperarOperaciones(Long oidTipoMovimientoAlmacen):Entrada");
        StringBuffer consulta = new StringBuffer();
                
        consulta.append(" SELECT TMA.IND_MANT_MOVI, ");
        consulta.append("        TMA.COD_OPER_1, ");
        consulta.append("        TMA.COD_OPER_2, ");
        consulta.append("        TMA.ESME_OID_ESTA_MERC_1, ");
        consulta.append("        TMA.ESME_OID_ESTA_MERC_2, ");
        consulta.append("        TMA.OID_TIPO_MOVI_ALMA ");
        consulta.append(" FROM BEL_TIPO_MOVIM_ALMAC TMA ");
        consulta.append(" WHERE TMA.OID_TIPO_MOVI_ALMA = " + oidTipoMovimientoAlmacen);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
      
        try {
          resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
      
        DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen = new DTOTipoMovimientoAlmacen();     
        
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
            dtoTipoMovimientoAlmacen.setMantieneMovimientos(this.bigDecimalToBoolean(resultado.getValueAt(0,"IND_MANT_MOVI"))); 
            if (!(this.objectToString(resultado.getValueAt(0,"COD_OPER_1")) == null)) {
                dtoTipoMovimientoAlmacen.setOperacion1(new Character(this.objectToString(resultado.getValueAt(0,"COD_OPER_1")).charAt(0)));     
            }
            if (!(this.objectToString(resultado.getValueAt(0,"COD_OPER_2")) == null)) {        
                dtoTipoMovimientoAlmacen.setOperacion2(new Character(this.objectToString(resultado.getValueAt(0,"COD_OPER_2")).charAt(0))); 
            }
            dtoTipoMovimientoAlmacen.setOidEstadoMercancia1(this.bigDecimalToLong(resultado.getValueAt(0,"ESME_OID_ESTA_MERC_1")));
            dtoTipoMovimientoAlmacen.setOidEstadoMercancia2(this.bigDecimalToLong(resultado.getValueAt(0,"ESME_OID_ESTA_MERC_2"))); 
            dtoTipoMovimientoAlmacen.setOid(this.bigDecimalToLong(resultado.getValueAt(0,"OID_TIPO_MOVI_ALMA"))); 
        }
        
        UtilidadesLog.info("MONINTSAPBean.recuperarOperaciones(Long oidTipoMovimientoAlmacen):Salida"); 
        return dtoTipoMovimientoAlmacen;        
    }
    
     private StringBuffer crearStringInsercionMovimientosAlmacenCabecera(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.crearStringInsercionMovimientosAlmacenCabecera(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera):Entrada");
        StringBuffer consulta = new StringBuffer();
                
        consulta.append(" INSERT INTO BEL_MOVIM_ALMAC_CABEC VALUES (");
        consulta.append(dtoMovimientoAlmacenCabecera.getOid() + ",");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidPais() + ",");
        consulta.append("'" + dtoMovimientoAlmacenCabecera.getNumeroDocumento() + "',");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidSubacceso() + ",");
        consulta.append("SYSDATE,");
        consulta.append("'" + dtoMovimientoAlmacenCabecera.getObservaciones() + "',");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidAlmacenEntrada() + ",");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidAlmacenSalida() + ",");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidTipoMovimientoAlmacen() + ",");
        consulta.append(dtoMovimientoAlmacenCabecera.getOidPeriodo() + ",");
        consulta.append(dtoMovimientoAlmacenCabecera.getNumeroMovimiento() + ")");

        UtilidadesLog.info("MONINTSAPBean.crearStringInsercionMovimientosAlmacenCabecera(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera):Salida"); 
        return consulta;        
    }
    
    
    
    private StringBuffer obtenerCadenasStock(DTOMovimientoAlmacen dtoMovimientoAlmacen, int i, int count, HashMap hashProductoStock, Long estado) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.obtenerCadenaInsercionStock(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Entrada"); 
      StringBuffer cadena = new StringBuffer();
      ArrayList arrayDetalle = dtoMovimientoAlmacen.getDetalle();   
      DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera = dtoMovimientoAlmacen.getCabecera();      
      for (int x=i-count; x<=i; x++){
          DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = (DTOMovimientoAlmacenDetalle)arrayDetalle.get(x);
          DTOStock dtoStock = (DTOStock)hashProductoStock.get(dtoMovimientoAlmacenDetalle.getOidProducto());
          if (dtoStock == null) {
              cadena.append(this.generarCadenaInsercionStock(dtoMovimientoAlmacenCabecera.getOidAlmacenSalida(), dtoMovimientoAlmacenDetalle, estado));             
          } else {
              cadena.append(this.generarCadenaUpdateStock(dtoStock, dtoMovimientoAlmacenDetalle));              
          }         
      }
      UtilidadesLog.info("MONINTSAPBean.obtenerCadenaInsercionStock(DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCabecera, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Salida"); 
      return cadena;
    }
    
    
    private HashMap obtenerStockProductos (Long oidAlmacen, Long oidEstado, ArrayList arrayProductos) throws MareException {
        UtilidadesLog.info("MONINTSAPBean.obtenerStockProductos (Long oidAlmacen, Long oidEstado, ArrayList arrayProductos):Entrada"); 
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT STO.PROD_OID_PROD, STO.VAL_SALD, STO.OID_STOC ");
        consulta.append(" FROM BEL_STOCK STO ");
        consulta.append(" WHERE STO.ALMC_OID_ALMA = " + oidAlmacen );
        consulta.append(" AND STO.ESME_OID_ESTA_MERC = " + oidEstado );
        consulta.append(this.crearFiltroProductosStock(arrayProductos));
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
      
        try {
          resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        HashMap stock = new HashMap();
        
        if ((!(resultado == null))&&(!(resultado.esVacio()))){
            for (int i = 0; i<resultado.getRowCount();i++){
              DTOStock dtoStock = new DTOStock();
              dtoStock.setOidStock(this.bigDecimalToLong(resultado.getValueAt(i,"OID_STOC")));
              dtoStock.setSaldo(this.bigDecimalToLong(resultado.getValueAt(i,"VAL_SALD")));
              stock.put(this.bigDecimalToLong(resultado.getValueAt(i,"PROD_OID_PROD")), dtoStock);
            }         
        }        
        UtilidadesLog.info("MONINTSAPBean.obtenerStockProductos (Long oidAlmacen, Long oidEstado, ArrayList arrayProductos):Salida"); 
        return stock;
    }
    
    private StringBuffer crearFiltroProductosStock(ArrayList listaProductos)  {
        StringBuffer filtroProductos = new StringBuffer();
        filtroProductos.append(" ");
        if (listaProductos.size() > 0) {
            filtroProductos.append(" AND (");      
            String productos = "";
            int k = 0;
            Iterator  it = listaProductos.iterator();
            while (it.hasNext()){
                Long oid = (Long)it.next();
                if (k == 0) {
                  productos = oid.toString();
                } else {
                  productos = productos + "," + oid.toString();
                }
                if (k==999){
                  filtroProductos.append(" STO.PROD_OID_PROD IN (" + productos.toString() + ") ");
                  if (it.hasNext()){
                      filtroProductos.append(" OR ");                  
                  }                
                  k=0;
                  productos = "";
                } else {
                   if (!it.hasNext()){
                        filtroProductos.append(" STO.PROD_OID_PROD IN (" + productos.toString() + ") ");
                   }
                   k++;
                }        
            }
            filtroProductos.append(" ) ");      
        }     
        return filtroProductos;
    }  

    private StringBuffer generarCadenaInsercionStock(Long oidAlmacen, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle, Long estado) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.generarCadenaInsercionStock(Long oidAlmacen, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Entrada"); 
      StringBuffer cadena = new StringBuffer();
        cadena.append("INSERT INTO BEL_STOCK VALUES (");
        cadena.append("BEL_STCK_SEQ.NEXTVAL,");
        cadena.append(oidAlmacen +  ",");
        cadena.append(estado + ",");
        cadena.append(dtoMovimientoAlmacenDetalle.getOidProducto() + ",");
        cadena.append(dtoMovimientoAlmacenDetalle.getCantidad());
        cadena.append(");");            
      UtilidadesLog.info("MONINTSAPBean.generarCadenaInsercionStock(Long oidAlmacen, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Salida"); 
      return cadena;
    }
    
    
    private StringBuffer generarCadenaUpdateStock(DTOStock dtoStock, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle) {
      UtilidadesLog.info("MONINTSAPBean.generarCadenaUpdateStock(DTOStock dtoStock, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Entrada"); 
      StringBuffer cadena = new StringBuffer();
      Long saldo = new Long(0);
      saldo = new Long(dtoStock.getSaldo().longValue() + dtoMovimientoAlmacenDetalle.getCantidad().longValue());
      cadena.append("UPDATE BEL_STOCK ");
      cadena.append(" SET VAL_SALD = " + saldo);
      cadena.append(" WHERE OID_STOC = " + dtoStock.getOidStock());
      cadena.append(";");            
      
      UtilidadesLog.info("MONINTSAPBean.generarCadenaUpdateStock(DTOStock dtoStock, DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle):Salida"); 
      return cadena;
    }
    
    
    private Long obtenerOidOperacion (String codOperacion) throws MareException {
      UtilidadesLog.info("MONINTSAPBean.obtenerOidOperacion(String codOperacion):Entrada"); 
      Long oid = null;
      StringBuffer consulta = new StringBuffer();
      
      consulta.append(" SELECT OID_OPER ");
      consulta.append(" FROM BEL_OPERA ");
      consulta.append(" WHERE COD_OPER = '" + codOperacion.toString() + "'");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }        
      
            
      if ((!(resultado == null))&&(!(resultado.esVacio()))){
          oid = this.bigDecimalToLong(resultado.getValueAt(0,0));    
      }
      
      UtilidadesLog.info("MONINTSAPBean.obtenerOidOperacion(String codOperacion):Salida"); 
      return oid;
    }
    
    private StringBuffer generarCadenaInsercionDetalleMovimiento(Long oidMovimientoAlmacenCabecera, ArrayList arrayMovimientoAlmacenDetalle, 
                                              int i, int count, Long oidOperacion, String numeroMovimiento) throws MareException {
      UtilidadesLog.info("MONINTSAPBean.generarCadenaInsercionDetalleMovimiento():Entrada"); 
      
      StringBuffer cadena = new StringBuffer();    
      for (int x=i-count; x<=i; x++){
          DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle = (DTOMovimientoAlmacenDetalle)arrayMovimientoAlmacenDetalle.get(x);          
          cadena.append(this.crearCadenaInsercionDetalleMovimiento(oidMovimientoAlmacenCabecera, x+1, dtoMovimientoAlmacenDetalle, oidOperacion, numeroMovimiento));             
      }
      
      UtilidadesLog.info("MONINTSAPBean.generarCadenaInsercionDetalleMovimiento():Salida"); 
      return cadena;
    }
    
    private StringBuffer crearCadenaInsercionDetalleMovimiento (Long oidMovimientoAlmacenCabecera, int numeroLinea, 
                            DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle, Long oidOperacion, String numeroMovimiento) throws MareException{
      UtilidadesLog.info("MONINTSAPBean.crearCadenaInsercionDetalleMovimiento(Long oidMovimientoAlmacenCabecera, int numeroLinea,  DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle, Long oidOperacion):Entrada"); 
      StringBuffer cadena = new StringBuffer();
          cadena.append(" INSERT INTO BEL_MOVIM_ALMAC_DETAL VALUES (");
          cadena.append("BEL_MADE_SEQ.NEXTVAL,");
          cadena.append(oidMovimientoAlmacenCabecera + ",");
          cadena.append(numeroLinea + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getCantidad() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getPrecioVentaNeto() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getPrecioContable() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getNumeroDocumentoReferencia() + ", ");
          cadena.append(dtoMovimientoAlmacenDetalle.getNumeroPosicionReferencia() + ",");
          cadena.append(this.dtoTipoMovimientoAlmacen.getOid() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidProducto() + ",");
          cadena.append(oidOperacion + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidAlmacenEntrada() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidAlmacenSalida() + ",");
          cadena.append(numeroMovimiento.toString() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidTipoOferta() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getNumeroLoteSAP() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidTipoPosicion() + ",");
          cadena.append(dtoMovimientoAlmacenDetalle.getOidSubtipoPosicion());
          cadena.append(");");
      UtilidadesLog.info("MONINTSAPBean.crearCadenaInsercionDetalleMovimiento(Long oidMovimientoAlmacenCabecera, int numeroLinea,  DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle, Long oidOperacion):Salida"); 
      return cadena;
    }
    
     //Agregado por Sapaza, fecha 03-06-2008, Se inicializa el stock disponible a 0
     private void inicializarStock() throws MareException {
        UtilidadesLog.info("MONINTSAPBean.inicializarStock():Entrada");
        StringBuffer update = new StringBuffer();
                
        update.append(" UPDATE BEL_STOCK ");
        update.append("    SET VAL_SALD=0 ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {      
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
          throw new MareException(e,
          UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONINTSAPBean.inicializarStock():Salida"); 
    }
    
    private IdiomaLocalHome getIdiomaLocalHome() {
            return new IdiomaLocalHome();
    }

    private NegocioLocalHome getNegocioLocalHome() {
            return new NegocioLocalHome();
    }

    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
            return new Entidadi18nLocalHome();
    }

    private SuperGenericoLocalHome getSuperGenericoLocalHome() {
            return new SuperGenericoLocalHome();
    }

    private GenericoLocalHome getGenericoLocalHome() {
            return new GenericoLocalHome();
    }

    private MarcaProductoLocalHome getMarcaProductoLocalHome() {
            return new MarcaProductoLocalHome();
    }

    private EstatusLocalHome getEstatusLocalHome() {
            return new EstatusLocalHome();
    }

    private MagnitudLocalHome getMagnitudLocalHome() {
            return new MagnitudLocalHome();
    }

    private UnidadesMedidaLocalHome getUnidadesMedidaLocalHome() {
            return new UnidadesMedidaLocalHome();
    }
    
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }
    
    private UnidadesNegocioLocalHome getUnidadesNegocioLocalHome() {
            return new UnidadesNegocioLocalHome();
    }
    
}
