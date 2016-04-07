package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOProductoNoRecogible;
import es.indra.sicc.entidades.rec.ProductoNoRecogibleLocal;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.fac.MONFacturacionLocalHome;
import es.indra.sicc.logicanegocio.fac.MONImpresoraVirtualHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.rec.DTOGestionProductosNoRecogibles;
import es.indra.sicc.entidades.rec.ProductoNoRecogibleLocalHome;
import es.indra.mare.common.exception.MareException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.dtos.rec.DTOGestionarBoletaRecojoPendiente;
import es.indra.sicc.dtos.rec.DTOGestionarProdNORecuperados;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.rec.DTOFiltroBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOGestBoletasRecPend;
import es.indra.sicc.dtos.rec.DTOBoletas;
import es.indra.sicc.dtos.rec.DTOBoletaRecojoTemporal;
import java.text.SimpleDateFormat;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.entidades.rec.BoletaRecojoTemporalLocalHome;
import es.indra.sicc.entidades.rec.BoletaRecojoTemporalLocal;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.print.SpoolManager;
import es.indra.sicc.cmn.negocio.print.SpoolManagerHome;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.rec.DTOConsolidarBoletasRecojo;
import es.indra.sicc.dtos.rec.DTOGenerarBoletasRecojoCierreZona;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.logicanegocio.fac.MONFacturacionLocal;
import es.indra.sicc.logicanegocio.fac.MONImpresoraVirtual;
import es.indra.sicc.logicanegocio.fac.MONProcesosFacturacionLocal;
import es.indra.sicc.logicanegocio.fac.MONProcesosFacturacionLocalHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.BoletaRecojoColombia;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOClienteSolicitud;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocLegal;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableCabecera;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DatosClienteHelper;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.FactoriaSerializador;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDLocal;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGestionRecojosBean implements SessionBean  {

  private SessionContext sessionContext;
  private Integer tamanioSegmento;  
  private Integer numeroMaximoSegmentos;        
  private SpoolManager spoolManager;
  
  public void ejbCreate() { }
  public void ejbActivate() { }
  public void ejbPassivate() { }
  public void ejbRemove() { }

  public void setSessionContext(SessionContext ctx) {
    sessionContext = ctx;
  }

  public DTOSalida obtenerProductosRecojo(DTOFiltroProductoNoRecogible dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.obtenerProductosRecojo(DTOFiltroProductoNoRecogible):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    DTOSalida dtoS = daoGesRec.obtenerProductosRecojo(dtoE);
    UtilidadesLog.info("MONGestionRecojosBean.obtenerProductosRecojo(DTOFiltroProductoNoRecogible):Salida");
    return dtoS;
  }

  public DTOSalida obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    DTOSalida dtoS = daoGesRec.obtenerProductosNoRecogibles(dtoE);
    UtilidadesLog.info("MONGestionRecojosBean.obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible):Salida");
    return dtoS;
  }

  public void guardarProductosNoRecogibles(DTOGestionProductosNoRecogibles dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.guardarProductosNoRecogibles(DTOGestionProductosNoRecogibles):Entrada");
    
    if (dtoE.getProductosNoRecogibles()!=null&&!dtoE.getProductosNoRecogibles().isEmpty()) {
        ArrayList prodNoRecog = dtoE.getProductosNoRecogibles();
        Iterator itProdNoRecog = prodNoRecog.iterator();
        try {
          if (itProdNoRecog.hasNext()) {
            ProductoNoRecogibleLocalHome pNRLH = new ProductoNoRecogibleLocalHome(); 
            ProductoNoRecogibleLocal prodNoRecogLocal = null;
            while (itProdNoRecog.hasNext()) {
              DTOProductoNoRecogible dtoProd = (DTOProductoNoRecogible) itProdNoRecog.next();
              if (dtoProd.getTipoOperacion()!=null&&dtoProd.getTipoOperacion().equals("ALTA")) {
                  prodNoRecogLocal = pNRLH.create(dtoE.getOidPais(), dtoE.getOidCanal(), dtoE.getOidPeriodo(), dtoE.getOidMarca(),dtoProd.getOidArticuloLote(),dtoProd.getOidDetalleOferta());
              } else if (dtoProd.getTipoOperacion()!=null&&dtoProd.getTipoOperacion().equals("BAJA")) {
                  if (dtoProd.getOid()!=null) {
                    prodNoRecogLocal = pNRLH.findByPrimaryKey(dtoProd.getOid());
                    
                    pNRLH.remove(prodNoRecogLocal);
                  }
              } else {
                  UtilidadesLog.debug("El Producto "+dtoProd.getOidArticuloLote()+dtoProd.getOidDetalleOferta()+" no tiene tipo de operacion");
              }
            }
          }
        } catch (NoResultException finderException) {
            UtilidadesLog.debug(finderException);
            sessionContext.setRollbackOnly();
            throw new MareException(finderException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException createException) {
           UtilidadesLog.debug(createException);
           sessionContext.setRollbackOnly();
           throw new MareException(createException,
               UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));        
        }
    }     
    UtilidadesLog.info("MONGestionRecojosBean.guardarProductosNoRecogibles(DTOGestionProductosNoRecogibles):Salida");
  }

     public DTOSalida obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE) throws MareException
    {
        UtilidadesLog.info("MONGestionRecojosBean.obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE): Entrada");
        DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
        DTOSalida dtoS = new DTOSalida(); 
        dtoS.setResultado(daoGesRec.obtenerBoletasRecPend(dtoE));
        UtilidadesLog.info("MONGestionRecojosBean.obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE): Salida");
        return dtoS;
    }
    
    public void procesarNoExitosoAnular(DTOGestBoletasRecPend dtoE) throws MareException
    {
        UtilidadesLog.info("MONGestionRecojosBean.procesarNoExitoso(DTOOIDs oids): Entrada");
        DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
        UtilidadesLog.info("recibo dto: " + dtoE);
        Long cantRecojo = null;
        
        DTOOIDs oids = dtoE.getOids();
        DTOOIDs oidsAn = dtoE.getNumsAten();
        DTOOIDs oidsNumRe = dtoE.getOidNumRecoj();
        DTOOIDs numeBoelRe = dtoE.getNumBoletaRecojo();
        
        UtilidadesLog.debug("Recibo los oids no ex, midiendo: " + oids.getOids().length);          
        UtilidadesLog.debug("Recibo los oids anular, midiendo: " + oidsAn.getOids().length);            
        
        if (dtoE.getAnularNoExitoso().equals("NE")) {
            daoGesRec.procesarNoExitosos(oids.getOids());
            DTOBelcorp pais = new DTOBelcorp();
            pais.setOidPais(dtoE.getOidPais());
            RecordSet rs = daoGesRec.obtenerParametriaIntPais(pais);
            if(rs.getValueAt(0,"VAL_CANT_RECO")!=null){
               cantRecojo = Long.valueOf(((BigDecimal) rs.getValueAt(0,"VAL_CANT_RECO")).toString());
               
            }  
           //Agregado por cambio 20080765 
            for(int i = 0; i < oidsAn.getOids().length; i++){
                           if(oidsNumRe.getOids()[i] == ConstantesREC.OID_PRIMER_RECOJO ){                   
                                 if(cantRecojo == 1  ){
                                    DTOGestionarProdNORecuperados dtoGPnR = new DTOGestionarProdNORecuperados();
                                    
                                    ArrayList numBoletaRecojo = new ArrayList();
                                    ArrayList acciones = new ArrayList();
                                    
                                    int mide = numeBoelRe.getOids().length;
                                    for (int e = 0; e < mide; e++) {
                                        numBoletaRecojo.add(numeBoelRe.getOids()[e]);
                                    }
                                    acciones.add(ConstantesREC.MOVIMIENTO_ALMACEN);
                                    acciones.add(ConstantesREC.GENERAR_SOLICITUD);      

                                    dtoGPnR.setAcciones(acciones);
                                    dtoGPnR.setNumBoletasRecojo(numBoletaRecojo);
                                    dtoGPnR.setOidPais(dtoE.getOidPais());
                                    dtoGPnR.setOidIdioma(dtoE.getOidIdioma());
                                    UtilidadesLog.debug("llamo a: gestionarProdNORecuperados, siendo no exitoso");
                                    this.gestionarProdNORecuperados(dtoGPnR);
                                }
                                 if(cantRecojo != 1){
                                        DTOGestionarProdNORecuperados dtoGPnR = new DTOGestionarProdNORecuperados();
                                        ArrayList numAtencion = new ArrayList();
                                        ArrayList acciones = new ArrayList();
                                        
                                        int mide = oidsAn.getOids().length;
                                        for (int e = 0; e < mide; e++) {
                                            numAtencion.add(oidsAn.getOids()[e]);
                                        }    
                                       
                                        acciones.add(ConstantesREC.GENERAR_SOLICITUD);                                          
                                        dtoGPnR.setAcciones(acciones);
                                        dtoGPnR.setNumAtencion(numAtencion);
                                        dtoGPnR.setOidPais(dtoE.getOidPais());
                                        dtoGPnR.setOidIdioma(dtoE.getOidIdioma());
                                        UtilidadesLog.debug("llamo a: gestionarProdNORecuperados, siendo no exitoso");
                                        this.gestionarProdNORecuperados(dtoGPnR);
                                    }
                         } else if(oidsNumRe.getOids()[i] == ConstantesREC.OID_SEGUNDO_RECOJO){
                                 if(cantRecojo != 1){
                                     DTOGestionarProdNORecuperados dtoGPnR = new DTOGestionarProdNORecuperados();
                                     ArrayList numBoletaRecojo = new ArrayList();
                                     ArrayList acciones = new ArrayList();
                                     
                                     int mide = numeBoelRe.getOids().length;
                                     for (int e = 0; e < mide; e++) {
                                         numBoletaRecojo.add(numeBoelRe.getOids()[e]);
                                     }
                                     acciones.add(ConstantesREC.MOVIMIENTO_ALMACEN);
                                     acciones.add(ConstantesREC.GENERAR_SOLICITUD);                                          
                                     dtoGPnR.setAcciones(acciones);
                                     dtoGPnR.setNumBoletasRecojo(numBoletaRecojo);
                                     dtoGPnR.setOidPais(dtoE.getOidPais());
                                     dtoGPnR.setOidIdioma(dtoE.getOidIdioma());
                                     UtilidadesLog.debug("llamo a: gestionarProdNORecuperados, siendo no exitoso");
                                     this.gestionarProdNORecuperados(dtoGPnR);    
                         
                                 }
                          }                
            }
            
           
            //Eliminado por cambio 20080765
            /*DTOGestionarProdNORecuperados dtoGPnR = new DTOGestionarProdNORecuperados();
            
            ArrayList numAtencion = new ArrayList();
            ArrayList acciones = new ArrayList();
            
            int mide = oidsAn.getOids().length;
            for (int i = 0; i < mide; i++) {
                numAtencion.add(oidsAn.getOids()[i]);
            }
            acciones.add(ConstantesREC.MOVIMIENTO_ALMACEN);
            acciones.add(ConstantesREC.GENERAR_SOLICITUD);      
          
            dtoGPnR.setAcciones(acciones);
            dtoGPnR.setNumAtencion(numAtencion);
            dtoGPnR.setOidPais(dtoE.getOidPais());
            dtoGPnR.setOidIdioma(dtoE.getOidIdioma());
            UtilidadesLog.debug("llamo a: gestionarProdNORecuperados, siendo no exitoso");
            this.gestionarProdNORecuperados(dtoGPnR);*/
        }else{
            daoGesRec.procesarAnular(oids.getOids());
            DTOGestionarProdNORecuperados dtoGPnR = new DTOGestionarProdNORecuperados();
            
            ArrayList numAtencion = new ArrayList(); // si
            ArrayList acciones = new ArrayList();      // accion 
            ArrayList oidCabeRecla = new ArrayList(); // no      
            
            int mide = oidsAn.getOids().length;
            for (int i = 0; i < mide; i++) {
                numAtencion.add(oidsAn.getOids()[i]);
            }
            int cantidad = oids.getOids().length;
            for(int t = 0; t < cantidad; t++){
                oidCabeRecla.add(oids.getOids()[t]);
            }
            acciones.add(ConstantesREC.MOVIMIENTO_ALMACEN);
            dtoGPnR.setOidCabeRecla(oidCabeRecla);
            dtoGPnR.setAcciones(acciones);
            dtoGPnR.setNumAtencion(numAtencion);
            dtoGPnR.setOidPais(dtoE.getOidPais());
            
            UtilidadesLog.debug("llamo a: gestionarProdNORecuperados, siendo anulación");
            // Se elimina por cambio 20080765
            //this.gestionarProdNORecuperados(dtoGPnR);
            this.movimentoAlmacen(dtoGPnR);
        }
        UtilidadesLog.info("MONGestionRecojosBean.procesarNoExitoso(DTOOIDs oids): Salida");
    }    
        
   /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       26/12/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    *  Cambio REC-01 
    */
  public void gestionarProdNORecuperados(DTOGestionarProdNORecuperados dtoe) throws MareException {      
      UtilidadesLog.info("MONGestionRecojosBean.gestionarProdNORecuperados(DTOGestionarProdNORecuperados dtoe):Entrada");
      
      UtilidadesLog.debug("dtoe: " + dtoe);
      
      try{ 
      
          DAOGestionRecojos daoGestionRecojos = new DAOGestionRecojos();
          MONCapturaProcesoReclamos monCapProRec = getMONCapturaProcesoReclamos();
          MONGenerarMovimientoAlmacenHome monGenMovAlmH = this.getMONGenerarMovimientoAlmacenHome();
          MONGenerarMovimientoAlmacen monGenMovAlm = monGenMovAlmH.create();
              
          ArrayList acciones = dtoe.getAcciones();
          
          String valoresProcesado = dtoe.getNumBoletasRecojo()!=null?"NB":"NA";
          int cantValoresProcesado = dtoe.getNumBoletasRecojo()!=null?dtoe.getNumBoletasRecojo().size():dtoe.getNumAtencion().size(); 
          ArrayList numValoresProcesado = dtoe.getNumBoletasRecojo()!=null?dtoe.getNumBoletasRecojo():dtoe.getNumAtencion();     
          
          int cant = dtoe.getAcciones().size();
                  
          // Procesa las acciones
          for(int i=0; i<cant; i++){
              // Procesa los movimientos de almacen
              if(acciones.get(i).equals(ConstantesREC.MOVIMIENTO_ALMACEN)){
                  UtilidadesLog.debug("MOVIMIENTO_ALMACEN");
                  
                  RecordSet regProcesarMovAlmacen = daoGestionRecojos.obtenerDatosMovimientoAlmacen(numValoresProcesado, valoresProcesado);
                  
                  int canRegProcesarMovAlmacen = regProcesarMovAlmacen.getRowCount();
                  DTOMovimientoAlmacen dtoAlmacen = null;
                  DTOMovimientoAlmacenCabecera dtoMovAlmCab = null; 
                  DTOMovimientoAlmacenDetalle dtoMovAlmDet = null;
                  
                  ArrayList detalle = null;
                  Long numAtencionAct = null;
                  Long numAtencionAnt = null;
                  
                  
                  Timestamp fec_actu = new Timestamp(System.currentTimeMillis());
                  Date fechaActual= new Date(fec_actu.getTime());                 
                  for(int k=0; k < canRegProcesarMovAlmacen; k++){
                  
                      numAtencionAct = Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"NUM_ATEN")).toString());                     
                    
                    
                      if(!(numAtencionAct.equals(numAtencionAnt)) && k!=0){
                          UtilidadesLog.debug("dtoAlmacen_" + k + ": " + dtoAlmacen);
                          monGenMovAlm.grabarMovimientoAlmacenYStock(dtoAlmacen);
                      }              
                 
                      if(!(numAtencionAct.equals(numAtencionAnt))){
                      
                          dtoAlmacen = new DTOMovimientoAlmacen();
                          
                          dtoMovAlmCab = new DTOMovimientoAlmacenCabecera();
                          
                          dtoMovAlmCab.setOidPais(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PAIS_OID_PAIS")).toString()));
                          dtoMovAlmCab.setOidMarca(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"MARC_OID_MARC")).toString()));
                          dtoMovAlmCab.setOidCanal(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"CANA_OID_CANA")).toString()));
                          dtoMovAlmCab.setOidAcceso(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ACCE_OID_ACCE")).toString()));
                          dtoMovAlmCab.setOidSubacceso(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"OID_SBAC")).toString()));
                          dtoMovAlmCab.setOidPeriodo(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PERD_OID_PERI_RECL")).toString()));
                          dtoMovAlmCab.setFecha(fechaActual);
                          
                          detalle = new ArrayList();
                          
                          dtoAlmacen.setCabecera(dtoMovAlmCab);
                          dtoAlmacen.setDetalle(detalle); 
                          dtoAlmacen.setOidIdioma(dtoe.getOidIdioma());
                          dtoAlmacen.setOidPais(dtoe.getOidPais());
                      }
                      
                      dtoMovAlmDet = new DTOMovimientoAlmacenDetalle();
                      
                      dtoMovAlmDet.setOidAlmacenSalida(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA_POSV")).toString()));
                      //Cambio 20080765 
                      if (regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA")!=null){
                        dtoMovAlmDet.setOidAlmacenEntrada(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA")).toString()));
                      }
                      //-Cambio 20080765 
                      
                      Boolean siExitoso = dtoe.getSiExitoso();
                      if ((siExitoso!=null)&&(Boolean.TRUE.equals(siExitoso))) {
                        dtoMovAlmDet.setOidTipoMovimientoAlmacen(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"TMAL_OID_TIPO_ALMA_REC_NO_EXIT")).toString()));
                        dtoMovAlmDet.setOperacion(ConstantesBEL.COD_REC056);                        
                      } else {
                        dtoMovAlmDet.setOidTipoMovimientoAlmacen(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA_POSV")).toString()));
                        dtoMovAlmDet.setOperacion(ConstantesBEL.COD_REC057);
                      }
                      
                      dtoMovAlmDet.setOidProducto(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PROD_OID_PROD")).toString()));
                      dtoMovAlmDet.setOidTipoOferta(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"TOFE_OID_TIPO_OFER")).toString()));
                      dtoMovAlmDet.setCantidad(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"NUM_UNID_DEVU")).toString()));                      
                      
                      detalle.add(dtoMovAlmDet); 
                      
                      // Grabo porque es el ultimo registro
                      if(k==(canRegProcesarMovAlmacen - 1)){
                          UtilidadesLog.debug("dtoAlmacen_" + k + ": " + dtoAlmacen);
                          monGenMovAlm.grabarMovimientoAlmacenYStock(dtoAlmacen);
                      }
                      
                      numAtencionAnt = numAtencionAct;
                  
                }   
                  
              } else if(acciones.get(i).equals(ConstantesREC.GENERAR_SOLICITUD)){
                  UtilidadesLog.debug("GENERAR_SOLICITUD");
                  //Cambio 20080765 
                  DTOBelcorp dtoPais = new DTOBelcorp();
                  dtoPais.setOidPais(dtoe.getOidPais());
                  RecordSet rsParamIntPais = daoGestionRecojos.obtenerParametriaIntPais(dtoPais);
                  Long cantRecojo =  bigDecimalToLong(rsParamIntPais.getValueAt(0,"VAL_CANT_RECO"));
                  //- Cambio 20080765                  
              
                  // Procesa los generar solicitud
                  int canRegProcesarGenerarSolic = 0;
                  DTOAtencionReclamoREC dtoAtenReclaREC = null;
                  RecordSet regProcesarGenerarSolic = null;
                  
                  if(valoresProcesado.equals("NB")){  
                      regProcesarGenerarSolic = daoGestionRecojos.obtenerNumAtencion(numValoresProcesado);
                      
                      canRegProcesarGenerarSolic = regProcesarGenerarSolic.getRowCount();
                      
                  } else if(valoresProcesado.equals("NA")){  
                      canRegProcesarGenerarSolic = numValoresProcesado.size();
                  }
                  
                  String numRecojo = null;
                  //Cambio 20080765                   
                  Boolean primerRecojo = dtoe.getPrimerRecojo();
                  if ((primerRecojo!=null)&&(Boolean.TRUE.equals(primerRecojo))){
                      numRecojo = ConstantesREC.PRIMER_RECOJO_NO_EXITOSO;
                  } else {
                      if (Long.valueOf("1").equals(cantRecojo)){
                          numRecojo = ConstantesREC.PRIMER_RECOJO_NO_EXITOSO;
                      } else {
                          numRecojo = ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO;
                      }
                  }
                   
                  //-Cambio 20080765 
                  
                  for(int j=0; j<canRegProcesarGenerarSolic; j++){
                    
                      dtoAtenReclaREC = new DTOAtencionReclamoREC();
                      
                      if(valoresProcesado.equals("NB")){  
                          dtoAtenReclaREC.setNumAtencion(Long.valueOf(((BigDecimal)regProcesarGenerarSolic.getValueAt(j,"NUM_ATEN")).toString()));
                      } else if(valoresProcesado.equals("NA")){  
                          UtilidadesLog.debug("numValoresProcesado.get(j): " + numValoresProcesado.get(j));
                          dtoAtenReclaREC.setNumAtencion((Long)numValoresProcesado.get(j));
                      }
                      
                      dtoAtenReclaREC.setNumRecojo(numRecojo);
                      dtoAtenReclaREC.setOidPais(dtoe.getOidPais());
                      dtoAtenReclaREC.setOidIdioma(dtoe.getOidIdioma());
                      
                      UtilidadesLog.debug("dtoAtenReclaREC_" + j + ": " + dtoAtenReclaREC);
                      monCapProRec.generarSolicitudes(dtoAtenReclaREC);
                  }              
              }        
          }
          
      }  catch (NamingException ne) {
          UtilidadesLog.error("ERROR ", ne);
          throw new MareException(ne, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
      } catch (RemoteException re) {
          UtilidadesLog.error("ERROR ", re);
          throw new MareException(re, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
      } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
       
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      } 
      
      UtilidadesLog.info("MONGestionRecojosBean.gestionarProdNORecuperados(DTOGestionarProdNORecuperados dtoe):Salida");
  }
  
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       7/1/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    *  Cambio REC-01 
    */
  public DTOSalida buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe:Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    
    dtoe.setUsuario(sessionContext.getCallerPrincipal().getName());    
    DTOSalida dtoS = daoGesRec.buscarBoletasRecojoProcesadas(dtoe);
    
    UtilidadesLog.info("MONGestionRecojosBean.buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe:Salida");
    return dtoS;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       7/1/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    *  Cambio REC-01 
    */
  public DTOSalida obtenerEstadoRecojo(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.obtenerEstadoRecojo(DTOBelcorp dtoe):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    DTOBoolean dtob = new DTOBoolean();
    dtob.setValor(true);
    dtob.setOidIdioma(dtoe.getOidIdioma());
    dtob.setOidPais(dtoe.getOidPais());    
    DTOSalida dtoS = daoGesRec.obtenerEstadosRecojo(dtob);
    UtilidadesLog.info("MONGestionRecojosBean.obtenerEstadoRecojo(DTOBelcorp dtoe):Salida");
    return dtoS;
  }


    private MONGenerarMovimientoAlmacenHome getMONGenerarMovimientoAlmacenHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGenerarMovimientoAlmacenHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarMovimientoAlmacen"), MONGenerarMovimientoAlmacenHome.class);
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       10/1/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Cambio REC-01 
    */
  public void eliminarBolRecojoProcesadas(DTOOIDs dtoe) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoProcesadas(DTOOIDs dtoe):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    daoGesRec.eliminarBolRecojoProcesadas(dtoe);
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoProcesadas(DTOOIDs dtoe):Salida");
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       10/1/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Cambio REC-01 
    */
  public void eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe:Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
    daoGesRec.eliminarBolRecojoOK(dtoe);
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe):Salida");
  }


  public DTOSalida obtenerEstadosRecojo(DTOBoolean dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.obtenerEstadosRecojo(DTOBoolean dtoe):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();    
    DTOSalida dtoS = daoGesRec.obtenerEstadosRecojo(dtoE);
    UtilidadesLog.info("MONGestionRecojosBean.obtenerEstadosRecojo(DTOBoolean dtoe):Salida");
    return dtoS;
  }

  public DTOSalida obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoe):Entrada");
    DAOGestionRecojos daoGesRec = new DAOGestionRecojos();    
    DTOSalida dtoS = daoGesRec.obtenerBoletasRecojoTemporal(dtoE);
    UtilidadesLog.info("MONGestionRecojosBean.obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoe):Salida");
    return dtoS;
  }

    public DTOBoletas validarBoletasRecojo(DTOBoletas dtoE) throws MareException
    {
        UtilidadesLog.info("MONGestionRecojosBean.validarBoletasRecojo(DTOBoletas dtoE): Entrada");
        
        UtilidadesLog.debug("recibo: " + dtoE);
        int mide = dtoE.getBoletas().size();
        UtilidadesLog.debug("lista de boletas, mide: " + mide);
        DAOGestionRecojos daoGesRec = new DAOGestionRecojos();    
        for(int i=0; i<mide; i++) {
            DTOBoletaRecojoTemporal dtoTemp = (DTOBoletaRecojoTemporal)dtoE.getBoletas().get(i);
            UtilidadesLog.debug("leo boleta temporal: " + dtoTemp);
            
            RecordSet rs = daoGesRec.validoNroBoleta(dtoTemp.getNumeroBoleta().longValue());
            long resuValid = 0;

            if (rs.getRowCount()>0) {
                if (rs.getValueAt(0, "VAL_CODI").toString().equals(ConstantesREC.PENDIENTE_RECOJO)){
                     resuValid = 2;    
                 }else{
                     if (rs.getValueAt(0, "VAL_CODI").toString().equals(ConstantesREC.EXITOSO)||   
                        (rs.getValueAt(0, "VAL_CODI").toString().equals(ConstantesREC.NO_EXITOSO)))
                         resuValid = 1;  
                     if (rs.getValueAt(0, "VAL_CODI").toString().equals(ConstantesREC.ANULADO))
                         resuValid = 3;  
                 }
            }else{
                resuValid = 0;    
            }
            UtilidadesLog.info("resu: " + resuValid);    
            
            if (resuValid==2) {
                UtilidadesLog.debug("estado es igual a PR o NE, actualizo fecha y estado!");
                daoGesRec.actualizoFechaEstado(dtoTemp.getNumeroBoleta().longValue(), 
                                               dtoE.getFechaCaptura(), dtoE.getEstado().longValue());      
                //punto 6/7, fujo normal
                dtoTemp.setTextoValidacion(new String(""));
                dtoTemp.setValidacion(ConstantesREC.VALIDACION_OK);
            }else{
                if (resuValid==0) {
                    UtilidadesLog.debug("numero de boleta no existe!"); 
                    dtoTemp.setTextoValidacion(ConstantesREC.VALIDACION_ERRONEA);
                    dtoTemp.setValidacion(ConstantesREC.VALIDACION_KO);
                }
                if (resuValid==1) {
                    UtilidadesLog.debug("numero de boleta existe, pero estado no es igual a PR/NE (es Exitoso)!"); 
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    dtoTemp.setTextoValidacion("Boleta Recojida el " + rs.getValueAt(0, "FEC_CAPT").toString());
                    dtoTemp.setValidacion(ConstantesREC.VALIDACION_KO);
                }
                if (resuValid==3) {
                    UtilidadesLog.debug("numero de boleta existe, pero estado no es igual a PR/NE  (es Anulado)!"); 
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    dtoTemp.setTextoValidacion("Boleta Anulada el " + rs.getValueAt(0, "FEC_CAPT").toString());
                    dtoTemp.setValidacion(ConstantesREC.VALIDACION_KO);
                }
            }
            //guardo el dto temporal en el array q' recibo, para ret. modificado.
            UtilidadesLog.debug("guardo en misma pos. de array, dto modif.: " + dtoTemp);
            dtoE.getBoletas().set(i, dtoTemp);
        }
        //ahora recorro nuevamente la lista de boletas, para p/guardar en: BOLETA_RECOJO_PROCESADAS 
        mide = dtoE.getBoletas().size();
        StringBuffer insertAprocesadas = new StringBuffer();
        for(int i=0; i<mide; i++) {
            DTOBoletaRecojoTemporal dtoTempModi = (DTOBoletaRecojoTemporal)dtoE.getBoletas().get(i);
            UtilidadesLog.debug("leo boleta temporal (modificada): " + dtoTempModi);
            
            if (dtoTempModi.getPreValidado()!=null&&"SI".equals(dtoTempModi.getPreValidado())){
            } else {
                this.agregarInsertAprocesadas(insertAprocesadas, dtoTempModi, 
                                              dtoE.getOidPais().longValue(),
                                              dtoE.getEstado().longValue());
            }
            
        }
        this.grabarBolRecojProc(insertAprocesadas);
        UtilidadesLog.info("MONGestionRecojosBean.validarBoletasRecojo(DTOBoletas dtoE): Salida");
        UtilidadesLog.debug("retorno: " + dtoE);
        return dtoE;
    }
    
    private void grabarBolRecojProc(StringBuffer query) throws MareException {
       BelcorpService bs = BelcorpService.getInstance();   
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("Error en grabarMovCCyDetCargoAbono ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }    
    
    private void agregarInsertAprocesadas(StringBuffer insert, 
                                          DTOBoletaRecojoTemporal dtoTempModi, 
                                          long oidPais,
                                          long estadoRecojo) throws MareException {            
        UtilidadesLog.info("MONGestionRecojosBean.agregarInsertAprocesadas(StringBuffer insert, DTOBoletaRecojoTemporal dtoTempModi, long oidPais, long estadoRecojo): Entrada");
        
        StringBuffer query  = new StringBuffer();
        StringBuffer values = new StringBuffer();
        Long oidBolRecProc = new Long(SecuenciadorOID.obtenerSiguienteValor("REC_BRPR_SEQ").longValue());
        DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
        
        long oidValid = 0;
        
        if (dtoTempModi.getValidacion().equals(ConstantesREC.VALIDACION_OK))
            oidValid = 1;
        query.append(" INSERT INTO REC_BOLET_RECOJ_PROCE (");
        query.append(" OID_BOLE_RECO_PROCE, ");
        values.append(oidBolRecProc).append(",");
        
        query.append(" VAL_TEXT_VALI, ");
        values.append("'"+dtoTempModi.getTextoValidacion()+"'").append(",");
        
        query.append(" NUM_BOLE, ");
        values.append(dtoTempModi.getNumeroBoleta().longValue()).append(",");
        
        query.append(" NUM_ORDE_INGR, ");
        values.append(dtoTempModi.getOrdenIngreso().longValue()).append(",");
        
        query.append(" FEC_CAPT, ");
        values.append(" to_date( '" + new java.sql.Date(dtoTempModi.getFechaCaptura().getTime()) + "', 'YYYY-MM-DD'), ");                   
        
        query.append(" VAL_USUA, ");
        values.append("'"+sessionContext.getCallerPrincipal().getName()+"'").append(",");
        
        query.append(" IND_VALI, ");
        values.append(oidValid).append(",");
        
        query.append(" PAIS_OID_PAIS, ");
        values.append(oidPais).append(",");
        
        query.append(" EREC_OID_ESTA_RECO ");
        values.append(estadoRecojo);
        
        query.append(") VALUES (");
        query.append(values);
        query.append(");");
        insert.append(query.toString());
        
        UtilidadesLog.info("MONGestionRecojosBean.agregarInsertAprocesadas(StringBuffer insert, DTOBoletaRecojoTemporal dtoTempModi, long oidPais, long estadoRecojo): Salida");
    }


/**
  * Sistema:     Belcorp
  * Modulo:      REC
  * Fecha:       06/02/2008    
  * @autor       Emilio Noziglia
  * REC-058 Capturar Boletas Recojo
  */
  public DTOBoletas procesarBoletasRecojoTemporal(DTOBoletas dtoE) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.procesarBoletasRecojoTemporal(DTOBoletas dtoE): Entrada");
    
    try {
        ArrayList boletas = dtoE.getBoletas();
        ArrayList aEliminar = new ArrayList();
        BoletaRecojoTemporalLocalHome brth = new BoletaRecojoTemporalLocalHome();
        BoletaRecojoTemporalLocal bolRecTem = null;
        java.sql.Date fechaCaptura = new java.sql.Date(dtoE.getFechaCaptura().getTime());
        UtilidadesLog.debug("Fecha de Captura: "+dtoE.getFechaCaptura());
        UtilidadesLog.debug("Fecha de Captura sql: "+fechaCaptura.toString());        
        Long oidEstado = dtoE.getEstado();
        Long oidPais = dtoE.getOidPais();
        //guardo las boletas de recojo temporal
        int cantBol = boletas.size();
        StringBuffer nrosBoletaNuevos = new StringBuffer();
        
        for (int i=0; i<cantBol; i++){
            DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i);
            if ("BAJA".equalsIgnoreCase(dtoB.getTipoOperacion())) {
                if (dtoB.getOid()!=null){
                  bolRecTem = brth.findByPrimaryKey(dtoB.getOid());
                  
                  brth.remove(bolRecTem);
                } else {
                  UtilidadesLog.debug("La Boleta "+dtoB.getNumeroBoleta()+" no estaba en la BD.");
                }
                aEliminar.add(new Long(i));
            } else if ("ALTA".equalsIgnoreCase(dtoB.getTipoOperacion()))  {
                bolRecTem = brth.create(dtoB.getNumeroBoleta(), fechaCaptura, dtoB.getIdUsuario(), dtoB.getOrdenIngreso(), oidPais, oidEstado);
                dtoB.setOid(bolRecTem.getOid());
                dtoB.setFechaCaptura(fechaCaptura);
                nrosBoletaNuevos.append(dtoB.getNumeroBoleta()+",");
            } else {
                dtoB.setFechaCaptura(fechaCaptura);
            }
        }
        //saco del array los eliminados por el usuario
        for (int j=0; j<aEliminar.size(); j++) {            
            boletas.remove(((Long)aEliminar.get(j)).intValue());
        }        
        
        //proceso las boletas de recojo temporal
        if (dtoE.getIndProcesar()){
            
            String boletasNuevas = nrosBoletaNuevos.toString();
            
            if (boletasNuevas.length()>0) {
                DAOGestionRecojos daoGr = new DAOGestionRecojos();
                //elimino la ultima coma
                boletasNuevas = boletasNuevas.substring(0,boletasNuevas.length()-1);                
                HashMap boletasProcesadas = daoGr.obtenerNumerosBoletaProcesadas(boletasNuevas, dtoE.getOidPais(), dtoE.getFechaCaptura());
                cantBol = boletas.size();
                for (int i=0; i<cantBol; i++) {
                    DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i);                                        
                    if ("ALTA".equals(dtoB.getTipoOperacion())) {
                        if (boletasProcesadas.containsKey(dtoB.getNumeroBoleta())){
                            dtoB.setPreValidado(new String("SI"));
                        } else {
                            dtoB.setPreValidado(new String("NO"));
                        }
                    }
                }                
            }
            
            dtoE = validarBoletasRecojo(dtoE);
            
            DTOBatch dtoBatch = new DTOBatch("Procesar Boletas de Recojo Temporal", new MareBusinessID("RECProcesarBoletasRecojoBatch"), dtoE);    
            try {
                BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
            } catch (RemoteException re) {
                UtilidadesLog.error("#*ERROR*# MONGestionRecojos:procesarBoletasRecojoTemporal", re);
    
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
            
            //elimino las que resultaron OK del array y de la BD.
            boletas = dtoE.getBoletas();
            cantBol = boletas.size();
            aEliminar = new ArrayList();
            for (int i=0; i<cantBol; i++){
                DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i);
                if (ConstantesREC.VALIDACION_OK.equalsIgnoreCase(dtoB.getValidacion())) {
                    if (dtoB.getOid()!=null){
                      bolRecTem = brth.findByPrimaryKey(dtoB.getOid());
                      brth.remove(bolRecTem);
                    } else {
                      UtilidadesLog.debug("ERROR: La Boleta "+dtoB.getNumeroBoleta()+" no estaba en la BD o tiene el oid nulo.");
                    }
                    aEliminar.add(new Long(i));
                }             
            }
            for (int j=0; j<aEliminar.size(); j++) {            
                boletas.remove(((Long)aEliminar.get(j)).intValue());
            }               
        }
        
        UtilidadesLog.info("MONGestionRecojosBean.procesarBoletasRecojoTemporal(DTOBoletas dtoE): Salida");
        return dtoE;
        
    }  catch (NoResultException finderException) {
        UtilidadesLog.debug(finderException);
        sessionContext.setRollbackOnly();
        throw new MareException(finderException,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch (PersistenceException removeException) {
        UtilidadesLog.debug(removeException);
        sessionContext.setRollbackOnly();
        throw new MareException(removeException,
            UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }



  public DTOSalidaBatch procesarBoletasRecojoTemporalBatch(DTOBatch dtoE) throws MareException {
        UtilidadesLog.info("MONGestionRecojosBean.procesarBoletasRecojoTemporalBatch(DTOBatch dtoE):Entrada");

        DTOBoletas dto = (DTOBoletas)dtoE.getDTOOnline();
        UtilidadesLog.debug(" --- dto entrada (DTOBoletas): " + dto); 
        
        DAOGestionRecojos daoGesRec = new DAOGestionRecojos();
        int count = 0;
        ArrayList segmento = new ArrayList();
        boolean ejecuta = false;
        int segmentosEjecutandoSimultaneamente = 0;
        
        MareMGC mgc = new MareMGC();
        mgc = (MareMGC) MareMii.getService(new MareTopic("Configuration"));
        String tamanio = (String) mgc.getProperty("application/TamanioSegmentoREC");
        String numero = (String) mgc.getProperty("application/NumeroMaximoSegmentosREC");
        if ((tamanio == null) || (tamanio.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 500
            this.tamanioSegmento = new Integer(5);
        } else {
            this.tamanioSegmento = new Integer(tamanio);
        }
        if ((numero == null) || (numero.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 12 (numero de procesadores de ejecucion)
            this.numeroMaximoSegmentos = new Integer(4);
        } else {
            this.numeroMaximoSegmentos = new Integer(numero);
        }        
        
        //cambio 20080765
        StringBuffer nrosBoletaConsolidados = new StringBuffer();        
        ArrayList boletas = dto.getBoletas();
        ArrayList boletasOK = new ArrayList();
        //selecciono las que salieron OK
        for (int i=0; i<boletas.size(); i++) {
           DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i);
           if (ConstantesREC.VALIDACION_OK.equalsIgnoreCase(dtoB.getValidacion())) {
                boletasOK.add(dtoB);
                nrosBoletaConsolidados.append(dtoB.getNumeroBoleta()+",");
           }
        }
        
        String boletasConsolidadas = nrosBoletaConsolidados.toString();
        boletasConsolidadas = boletasConsolidadas.substring(0,boletasConsolidadas.length()-1);
        ArrayList boletasOrigen = daoGesRec.obtenerBoletasRecojoOrigen(boletasConsolidadas);
        RecordSet boletasNoExitosas = null;
        Long estado = dto.getEstado();
        int cant = 0;
        UtilidadesLog.debug("Estado:"+estado);
        if (estado.equals(ConstantesREC.OID_SI_EXITOSO)) {              
            //mando a procesar boletasOK
            cant = boletasOrigen.size();
            UtilidadesLog.debug("Boletas:"+boletasOrigen);
        } else if (estado.equals(ConstantesREC.OID_NO_EXITOSO)) {              
            boletasNoExitosas = daoGesRec.obtenerNumeroRecojo(boletasOrigen).getResultado();
            cant = boletasNoExitosas.getRowCount();
            UtilidadesLog.debug("Boletas:"+boletasNoExitosas);
        } else {
            UtilidadesLog.debug("ERROR: No esta seteado el estado en el DTOBoletas.");
        }            
        Long nroRecojo = null;
        Long nroBoleta = null;
        for (int i = 0; i < cant; ) {
            if (estado.equals(ConstantesREC.OID_SI_EXITOSO)) {
                DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletasOrigen.get(i);
                //-cambio 20080765
                nroBoleta = new Long (dtoB.getNumeroBoleta().longValue());                
            } else {
                nroBoleta = new Long (((BigDecimal)boletasNoExitosas.getValueAt(i, "NUM_BOLE")).toString());
                nroRecojo = new Long (((BigDecimal)boletasNoExitosas.getValueAt(i, "OID_NUME_RECO")).toString());
            }
            UtilidadesLog.debug("count:"+count);
            if (count == this.tamanioSegmento.intValue()) {
                count = 0;
                ejecuta = true;                
            } else {
                if ((i>0)&&(nroRecojo!=null)&&
                    (nroRecojo.equals(new Long (((BigDecimal)boletasNoExitosas.getValueAt(i-1, "OID_NUME_RECO")).toString())))) {
                    //no llego al tamaño del segmento pero cambio el numero de recojo
                    count = 0;
                    ejecuta = true;                        
                } else {
                    UtilidadesLog.debug("Agrego Boleta:"+nroBoleta);
                    segmento.add(nroBoleta);
                    count++;
                    i++;
                }
            }         

            if (ejecuta){
                UtilidadesLog.debug("ejecuta1");
                DTOGestionarProdNORecuperados dtoAProc = new DTOGestionarProdNORecuperados();
                dtoAProc.setNumBoletasRecojo(segmento);
                dtoAProc.setOidPais(dto.getOidPais());
                dtoAProc.setOidIdioma(dto.getOidIdioma());
                ArrayList acciones = new ArrayList();

                if (estado.equals(ConstantesREC.OID_SI_EXITOSO)) {
                    dtoAProc.setSiExitoso(Boolean.TRUE);
                    acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
                } else if (estado.equals(ConstantesREC.OID_NO_EXITOSO)) {
                    dtoAProc.setSiExitoso(Boolean.FALSE);                        
                    if(ConstantesREC.OID_PRIMER_RECOJO.equals(nroRecojo)){
                        //Cambio 20080765 
                        dtoAProc.setPrimerRecojo(Boolean.TRUE);
                        
                        DTOBelcorp dtoPais = new DTOBelcorp();
                        dtoPais.setOidPais(dto.getOidPais());
                        RecordSet rsParamIntPais = daoGesRec.obtenerParametriaIntPais(dtoPais);
                        Long cantRecojo =  bigDecimalToLong(rsParamIntPais.getValueAt(0,"VAL_CANT_RECO"));     
                        if (Long.valueOf("1").equals(cantRecojo)){
                            acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
                            acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));                        
                        } else {
                            acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));
                        }
                        //-Cambio 20080765 
                    } else {
                        acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
                        acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));
                    }
                }
                dtoAProc.setAcciones(acciones);
                
                ejecucionBatch(dtoAProc, dtoE.getProcessID());
                ejecuta = false;
                segmento = new ArrayList();
                segmentosEjecutandoSimultaneamente++;
            }            
            
            if (segmentosEjecutandoSimultaneamente == numeroMaximoSegmentos.intValue()){
                try{
                    UtilidadesLog.debug("*** Se espera el procesamiento en Batch ***");
                    UtilidadesLog.debug("*** El IDProceso es = "+dtoE.getProcessID());
                    UtilidadesLog.debug("esperarProcesamiento1");
                    this.esperarProcesamiento(dtoE.getProcessID());
                } catch(InterruptedException ie) {
                    UtilidadesLog.error("ERROR" , ie);
                    String codigoError = ie.getMessage();
                    throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
                }    
                segmentosEjecutandoSimultaneamente = 0;
                count = 0;
            }
        }
        
        UtilidadesLog.debug("Tamaño segmento:"+segmento.size());
        if (segmento.size()>0){
            DTOGestionarProdNORecuperados dtoAProc = new DTOGestionarProdNORecuperados();
            dtoAProc.setNumBoletasRecojo(segmento);
            dtoAProc.setOidPais(dto.getOidPais());
            dtoAProc.setOidIdioma(dto.getOidIdioma());            
            ArrayList acciones = new ArrayList();

            if (estado.equals(ConstantesREC.OID_SI_EXITOSO)) {
                dtoAProc.setSiExitoso(Boolean.TRUE);
                acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
            } else if (estado.equals(ConstantesREC.OID_NO_EXITOSO)) {
                dtoAProc.setSiExitoso(Boolean.FALSE);                        
                if(ConstantesREC.OID_PRIMER_RECOJO.equals(nroRecojo)){
                    //Cambio 20080765 
                    dtoAProc.setPrimerRecojo(Boolean.TRUE);
                    
                    DTOBelcorp dtoPais = new DTOBelcorp();
                    dtoPais.setOidPais(dto.getOidPais());
                    RecordSet rsParamIntPais = daoGesRec.obtenerParametriaIntPais(dtoPais);
                    Long cantRecojo =  bigDecimalToLong(rsParamIntPais.getValueAt(0,"VAL_CANT_RECO"));     
                    if (Long.valueOf("1").equals(cantRecojo)){
                        acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
                        acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));                        
                    } else {
                        acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));
                    }
                    //-Cambio 20080765 
                } else {
                    acciones.add(new String(ConstantesREC.MOVIMIENTO_ALMACEN));
                    acciones.add(new String(ConstantesREC.GENERAR_SOLICITUD));
                }
            }
            UtilidadesLog.debug("ejecuta2");
            dtoAProc.setAcciones(acciones);            
            ejecucionBatch(dtoAProc, dtoE.getProcessID());
            segmento= new ArrayList();
        } 
        
        try{
            UtilidadesLog.debug("esperarProcesamiento2");
            this.esperarProcesamiento(dtoE.getProcessID());
        } catch(InterruptedException ie) {
            UtilidadesLog.error("ERROR ", ie);
            String codigoError = ie.getMessage();
            throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
        }        
        UtilidadesLog.info("MONGestionRecojosBean.procesarBoletasRecojoTemporalBatch(DTOBatch dtoE):Salida");  
        return new DTOSalidaBatch(0,"Ejecucion MONGestionRecojosBean:procesarBoletasRecojoTemporalBatch completada");
  }
  
  
  private void ejecucionBatch(DTOGestionarProdNORecuperados dtoE, String IDProceso) throws MareException {
        UtilidadesLog.info("MONGestionRecojosBean.ejecucionBatch(DTOGestionarProdNORecuperados dtoE, String IDProceso): Entrada");
    
        UtilidadesLog.debug(" tamanio de segmento = "+dtoE.getNumBoletasRecojo().size());
        IMareDTO DTOSegmento = dtoE;
        DTOSubBatch dtoSubBatch = new DTOSubBatch("REC_PROC_BOL_TEMP_",IDProceso,sessionContext.getCallerPrincipal().getName() ,new MareBusinessID("RECProcesarSegmentoBoletasRecojo"),DTOSegmento);
        try{
            BatchUtil.executeMLN( dtoSubBatch, new MareBusinessID( "INTProcesoInterfaces" ));
        }catch(RemoteException re){
            UtilidadesLog.error("ERROR ", re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
        }
        UtilidadesLog.info("MONGestionRecojosBean.ejecucionBatch(DTOGestionarProdNORecuperados dtoE, String IDProceso): Salida");
    } 
    
    private void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException {
        UtilidadesLog.info("MONGestionRecojosBean.esperarProcesamiento(String codigoProceso): Entrada");
        BatchUtil.esperarHijos(codigoProceso);	
        UtilidadesLog.info("MONGestionRecojosBean.esperarProcesamiento(String codigoProceso): Salida");
    }   

  public DTOSalidaBatch procesarSegmentoBoletasRecojoTemporal(DTOBatch dtoE) throws MareException {
        UtilidadesLog.info("MONGestionRecojosBean.procesarSegmentoBoletasRecojoTemporal(DTOBatch dtoE): Entrada");
        DTOGestionarProdNORecuperados dto = (DTOGestionarProdNORecuperados)dtoE.getDTOOnline();
        this.gestionarProdNORecuperados(dto);        
        UtilidadesLog.info("MONGestionRecojosBean.procesarSegmentoBoletasRecojoTemporal(DTOBatch dtoE): Salida");        
        return new DTOSalidaBatch(0,"Ejecucion MONGestionRecojosBean:procesarSegmentoBoletasRecojoTemporal completada");        
  }

  private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");
  }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome) context.lookup( "java:comp/env/BusinessFacadeBATCH" );
    }

    private MONCapturaProcesoReclamos getMONCapturaProcesoReclamos() throws MareException {
         // Se obtiene el interfaz home
         MONCapturaProcesoReclamosHome home = (MONCapturaProcesoReclamosHome)UtilidadesEJB.getHome(
             "MONCapturaProcesoReclamos", MONCapturaProcesoReclamosHome.class);
             
         // Se obtiene el interfaz remoto
         MONCapturaProcesoReclamos ejb = null;
         try {
             ejb = home.create();
         } catch (Exception e) {
             UtilidadesLog.error(e);
             sessionContext.setRollbackOnly();
             String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
             throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         } 
         return ejb;
     }
     //Agregado por cambio 20080765

    public void movimentoAlmacen(DTOGestionarProdNORecuperados dtoe) throws MareException {
        UtilidadesLog.info("MONGestionRecojoBean.movimientoAlmacen(): Entrada");
               try{   
                       DAOGestionRecojos daoGestionRecojos = new DAOGestionRecojos();
                       MONGenerarMovimientoAlmacenHome monGenMovAlmH = this.getMONGenerarMovimientoAlmacenHome();
                       MONGenerarMovimientoAlmacen monGenMovAlm = monGenMovAlmH.create();
                       String valoresProcesado = dtoe.getNumBoletasRecojo()!=null?"NB":"NA";
                       int cantValoresProcesado = dtoe.getNumBoletasRecojo()!=null?dtoe.getNumBoletasRecojo().size():dtoe.getNumAtencion().size(); 
                       ArrayList numValoresProcesado = dtoe.getNumBoletasRecojo()!=null?dtoe.getNumBoletasRecojo():dtoe.getNumAtencion();       
                       DTOBelcorp dtoPais = new DTOBelcorp();
                       dtoPais.setOidPais(dtoe.getOidPais());
                       UtilidadesLog.debug("MOVIMIENTO_ALMACEN");
                       RecordSet  movAlmac = daoGestionRecojos.obtenerTipoMovimiento(dtoPais);
                       Long oidMovimi = null;
                       
                       if(!movAlmac.esVacio()){
                              oidMovimi = Long.valueOf(((BigDecimal)movAlmac.getValueAt(0,"OID_TIPO_MOVI_ALMA")).toString());
                       }
                       RecordSet regProcesarMovAlmacen = daoGestionRecojos.movimientoAlmacen(numValoresProcesado, oidMovimi);
                       
                       int canRegProcesarMovAlmacen = regProcesarMovAlmacen.getRowCount();
                       DTOMovimientoAlmacen dtoAlmacen = null;
                       DTOMovimientoAlmacenCabecera dtoMovAlmCab = null; 
                       DTOMovimientoAlmacenDetalle dtoMovAlmDet = null;
                       
                       ArrayList detalle = null;                       
                       Long almacen = null;
                       Long tipoMovimiento = null;
                       
                       
                       Timestamp fec_actu = new Timestamp(System.currentTimeMillis());
                       Date fechaActual= new Date(fec_actu.getTime());                 
                       for(int k=0; k < canRegProcesarMovAlmacen; k++){
                       
                          
                           almacen =  Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA")).toString());
                           tipoMovimiento = Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"TMAL_OID_TIPO_MOVI_ALMA")).toString());
                         
                                 
                      
                           if(!(almacen.equals(null) && tipoMovimiento.equals(null))){
                               dtoAlmacen = new DTOMovimientoAlmacen();
                               
                               dtoMovAlmCab = new DTOMovimientoAlmacenCabecera();
                               
                               dtoMovAlmCab.setOidPais(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PAIS_OID_PAIS")).toString()));
                               dtoMovAlmCab.setOidMarca(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"MARC_OID_MARC")).toString()));
                               dtoMovAlmCab.setOidCanal(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"CANA_OID_CANA")).toString()));
                               dtoMovAlmCab.setOidAcceso(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ACCE_OID_ACCE")).toString()));
                               dtoMovAlmCab.setOidSubacceso(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"OID_SBAC")).toString()));
                               dtoMovAlmCab.setOidPeriodo(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PERD_OID_PERI_RECL")).toString()));
                               dtoMovAlmCab.setFecha(fechaActual);
                               
                               detalle = new ArrayList();
                               
                               dtoAlmacen.setCabecera(dtoMovAlmCab);
                               dtoAlmacen.setDetalle(detalle); 
                               dtoAlmacen.setOidIdioma(dtoe.getOidIdioma());
                               dtoAlmacen.setOidPais(dtoe.getOidPais());
                        
                               dtoMovAlmDet = new DTOMovimientoAlmacenDetalle();
                           
                               dtoMovAlmDet.setOidAlmacenSalida(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA_POSV")).toString()));           
                               dtoMovAlmDet.setOidTipoMovimientoAlmacen(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"ALMC_OID_ALMA_POSV")).toString()));                   
                               dtoMovAlmDet.setOidProducto(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"PROD_OID_PROD")).toString()));
                               dtoMovAlmDet.setOidTipoOferta(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"TOFE_OID_TIPO_OFER")).toString()));
                               dtoMovAlmDet.setCantidad(Long.valueOf(((BigDecimal)regProcesarMovAlmacen.getValueAt(k,"NUM_UNID_DEVU")).toString()));                      
                               dtoMovAlmDet.setOperacion(ConstantesREC.OPERCION_REC060); 
                               detalle.add(dtoMovAlmDet);                       
                               UtilidadesLog.debug("dtoAlmacen_" + k + ": " + dtoAlmacen);
                               monGenMovAlm.grabarMovimientoAlmacenYStock(dtoAlmacen);
                           
                           }
                       
                     }  // for  
                       
                       
               
               }catch (NamingException ne) {
                       UtilidadesLog.error("ERROR ", ne);
                       throw new MareException(ne, 
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                           
               } catch (RemoteException re) {
                       UtilidadesLog.error("ERROR ", re);
                       throw new MareException(re, 
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                           
               } catch (CreateException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                          
               } catch (Exception ex) {
                        UtilidadesLog.error("ERROR ", ex);
                        ex.printStackTrace();
                        throw new MareException(ex);
               }     
               
               UtilidadesLog.info("MONGestionRecojoBean.movimientoAlmacen(): Salida");
                
    }
    //Agregado por cambio 20080765
    public void generaSolicitudes(DTOGestionarProdNORecuperados dtoe) throws MareException {
        UtilidadesLog.info("MONGestionRecojoBean.generaSolicitudes(DTOGestionarProdNORecuperados dtoe): Entrada");
             
                          UtilidadesLog.debug("GENERAR_SOLICITUD");
            try{          
                          // Procesa los generar solicitud
                          int canRegProcesarGenerarSolic = 0;
                          DTOAtencionReclamoREC dtoAtenReclaREC = null;
                          RecordSet regProcesarGenerarSolic = null;
                          MONCapturaProcesoReclamos monCapProRec = getMONCapturaProcesoReclamos();
                          DAOGestionRecojos daoGestionRecojos = new DAOGestionRecojos();
                          String valoresProcesado = dtoe.getNumBoletasRecojo()!=null?"NB":"NA";
                          ArrayList numValoresProcesado = dtoe.getNumAtencion();     
                          
                          canRegProcesarGenerarSolic = numValoresProcesado.size();
                          
                          
                          String numRecojo = null;
                          
                          numRecojo = ConstantesREC.PRIMER_RECOJO_NO_EXITOSO;
                          
                          
                          for(int j=0; j<canRegProcesarGenerarSolic; j++){
                            
                              dtoAtenReclaREC = new DTOAtencionReclamoREC();
                              
                              if(valoresProcesado.equals("NB")){  
                                  dtoAtenReclaREC.setNumAtencion(Long.valueOf(((BigDecimal)regProcesarGenerarSolic.getValueAt(j,"NUM_ATEN")).toString()));
                              } else if(valoresProcesado.equals("NA")){  
                                  UtilidadesLog.debug("numValoresProcesado.get(j): " + numValoresProcesado.get(j));
                                  dtoAtenReclaREC.setNumAtencion((Long)numValoresProcesado.get(j));
                              }
                              
                              dtoAtenReclaREC.setNumRecojo(numRecojo);
                              dtoAtenReclaREC.setOidPais(dtoe.getOidPais());
                              dtoAtenReclaREC.setOidIdioma(dtoe.getOidIdioma());
                              
                              UtilidadesLog.debug("dtoAtenReclaREC_" + j + ": " + dtoAtenReclaREC);
                              monCapProRec.generarSolicitudes(dtoAtenReclaREC);
                          }              
            } catch (RemoteException re) {
                  UtilidadesLog.error("ERROR ", re);
                  throw new MareException(re, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                
            } catch (Exception ex) {
                  UtilidadesLog.error("ERROR ", ex);
                  ex.printStackTrace();
                  throw new MareException(ex);
            }                         
        
        UtilidadesLog.info("MONGestionRecojoBean.generaSolicitudes(DTOGestionarProdNORecuperados dtoe): Salida");
    }

    /**
     * Cambio 20080765
     * Ejecuta en modo batch el business ID RECGenerarBoletasRecojoCierreZona
     * @param dtoe DTOOID con un OID de zona
     * @throws MareException
     * @author dmorello
     * @since 20/08/2009
     */
    public void generarBoletasRecojoCierreZonaBatch(DTOGenerarBoletasRecojoCierreZona dtoe) throws MareException {
        UtilidadesLog.info("MONGestionRecojoBean.generarBoletasRecojoCierreZonaBatch(DTOOID dtoe): Entrada");

        MareBusinessID id = new MareBusinessID("RECGenerarBoletasRecojoCierreZona");
        DTOBatch dtoB = new DTOBatch(new String("Generar bol.rec.cierre zona"), id, dtoe, sessionContext.getCallerPrincipal().getName());

        try {
            BatchUtil.executeMLN(dtoB, "INCPROCESOSBATCH");
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONGestionRecojoBean.generarBoletasRecojoCierreZonaBatch(DTOOID dtoe): Salida");
    }

    public DTOSalidaBatch generarBoletasRecojoCierreZona(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONGestionRecojoBean.generarBoletasRecojoCierreZona(DTOBatch dtoin): Entrada");
        
        Long oidIdioma = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
        
        MONProcesosPEDLocal monProc = null;
        MONFacturacionLocal monFact = null;
        MONProcesosFacturacionLocal monPF = null;
        MONImpresoraVirtual monImpr = null;
        try {
            MONProcesosPEDLocalHome homeProc = this.getMONProcesosPEDLocalHome();
            MONFacturacionLocalHome homeFact = this.getMONFacturacionLocalHome();
            MONProcesosFacturacionLocalHome homePF = this.getMONProcesosFacturacionLocalHome();
            MONImpresoraVirtualHome homeImpr = this.getMONImpresoraVirtualHome();
            monProc = homeProc.create();
            monFact = homeFact.create();
            monPF = homePF.create();
            monImpr = homeImpr.create();
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTOGenerarBoletasRecojoCierreZona dtoe = (DTOGenerarBoletasRecojoCierreZona)dtoin.getDTOOnline();
        UtilidadesLog.debug("dtoe: " + dtoe);
        
        Long oidZona = dtoe.getOidZona();
        
        DAOGestionRecojos dao = new DAOGestionRecojos();
        
        // Obtengo los clientes para los cuales hay boletas de recojo sin consolidar
        // Si no hay clientes, salgo
        Long[] oidsClientes = dao.obtenerClientesBoletasRecojoPorZona(oidZona);
        if (oidsClientes.length > 0) {
            // Busco la impresora y abro un spool
            Long oidImpresora = this.obtenerImpresoraBoletaRecojo();
            Long idSpool = this.abrirSpool();
            
            DTOFACDocumentoContable dtoFac = null;
            
            // DTO para generar nuevos numeros de boletas de recojo
            SimpleDateFormat sdf = new SimpleDateFormat("yy");
            Integer anio = Integer.valueOf(sdf.format(new Date(System.currentTimeMillis())));
            PaisLocal pais = new PaisLocalHome().findByPrimaryKey(dtoe.getOidPais());
            DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
            dtoNumero.setOidPais(dtoe.getOidPais());
            dtoNumero.setCodPais(pais.getCod_pais());
            dtoNumero.setCodCanal("_");
            dtoNumero.setCodAcceso("_");
            dtoNumero.setCodSubacceso("_");
            dtoNumero.setOperacion("REC059");
            dtoNumero.setAnyo(anio);
            
            // DTO reutilizable con info para generar cada consolidado
            DTOConsolidarBoletasRecojo dtoCons = new DTOConsolidarBoletasRecojo();
            dtoCons.setOidPais(dtoe.getOidPais());
            
            // Genero e imprimo una boleta consolidado para cada cliente hallado
            for (int i = 0; i < oidsClientes.length; i++) {
            
                dtoCons.setOidCliente(oidsClientes[i]);
                
                // Obtengo el numero de boleta de recojo consolidado
                String strNumeroBoleta = monProc.generaNumeroDocumento(dtoNumero);
                dtoCons.setNumeroBoleta(Long.valueOf(strNumeroBoleta));
                
                // Seteo lista solicitudes, indicador pedido servicio y fecha entrega
                DTOFACDocumentoContableCabecera dtoCab;
                dtoCab = dao.completarDatosBoletaRecojo(dtoCons);
                //dtoCab.setIndPedidoServicio(dtoCons.getIndPedidoServicio());
                //dtoCab.setFechaEntrega(dtoCons.getFechaRecojo());
                
                dtoFac = new DTOFACDocumentoContable();
                dtoFac.setCabecera(dtoCab);
                
                // Completo el DTOConsolidarBoletasRecojo
                dtoCons.setOidsBoletasConsolidar(dao.obtenerBoletasRecojoSinConsolidar(dtoCons.getOidCliente()));
                dtoCons.setOidsSolicitudesOrigen(dao.obtenerSolicitudesOrigenBoletas(dtoCons.getOidsBoletasConsolidar()));
                
                // Obtengo la lista de solicitudes tal como se hace en FAC
                ArrayList listaSol = monFact.obtenerCabecerasSolicitud(dtoCons.getOidsSolicitudesOrigen());
                dtoCab.setListaSolicitudes(listaSol);
                dtoCab.setIndPedidoServicio(((DTOFACCabeceraSolicitud)listaSol.get(0)).getIndPedidoServicio());
                dtoCab.setFechaEntrega(((DTOFACCabeceraSolicitud)listaSol.get(0)).getFechaEntrega());
                dtoCab.setFechaFacturacion(new Date(System.currentTimeMillis()));
                dtoCab.setOidPeriodo(((DTOFACCabeceraSolicitud)listaSol.get(0)).getPeriodo());
                
                // Obtengo el codigo de periodo para setear...
                try {
                    PeriodoLocal periodo = new PeriodoLocalHome().findByPrimaryKey(dtoCab.getOidPeriodo());
                    PeriodoCorporativoLocal pc = new PeriodoCorporativoLocalHome().findByPrimaryKey(periodo.getOidPeriodoCorporativo());
                    dtoCab.setCodPeriodo(pc.getCodigoPeriodo());
                } catch (PersistenceException e) {
                    this.sessionContext.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                }
                
                UtilidadesLog.debug("dtoCab: " + dtoCab);
                
                dtoCons = this.completarDTOConsolidarBoletasRecojo(dtoCons, dtoFac);
                
                // Consolido las boletas y obtengo el DTO con los datos para imprimir
                dtoCons = this.consolidarBoletasRecojo(dtoCons);
                dtoCab.setOidBoletaRecojoConsolidado(dtoCons.getOidBoletaRecojoConsolidado());
                
                // Obtengo la lista de posiciones tal como se hace en FAC
                HashMap hashPosiciones = monPF.obtenerPosicionesCabeceras(dtoCons.getOidsSolicitudesOrigen(), oidIdioma);
                UtilidadesLog.debug("*** hashPosiciones: " + hashPosiciones);
                ArrayList listaPosiciones = new ArrayList();
                int oidsMide = dtoCons.getOidsSolicitudesOrigen().size();
                for (int x=0; x< oidsMide ; x++){
                    String strOid = dtoCons.getOidsSolicitudesOrigen().get(x).toString();
                    if (hashPosiciones.get(strOid) != null){                  
                      listaPosiciones.addAll((ArrayList)hashPosiciones.get(strOid));    
                      hashPosiciones.remove(strOid);
                    }
                }
                dtoCab.setListaDetalle(listaPosiciones);
                UtilidadesLog.debug("*** listaPosiciones: " + listaPosiciones);
                
                // Armo el DTO para la generacion del documento
                DTODocLegal dtoDocLegal = new DTODocLegal();
                dtoDocLegal.añadirPagina(dtoFac);
                dtoDocLegal.setIndOnline(Boolean.FALSE);
                dtoDocLegal.setUsuario(this.sessionContext.getCallerPrincipal().getName());
                
                // Genero la boleta de recojo para imprimir
                BoletaRecojoColombia docu = new BoletaRecojoColombia();
                
                DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
                DTOClienteSolicitud dtoClienteSolicitud = datosClienteHelper.obtenerDatosCliente((Long)dtoCons.getOidsSolicitudesOrigen().get(0), dtoDocLegal.getUsuario());
                
                docu.setDtoClienteSolicitud(dtoClienteSolicitud);
                docu.componerFactura(dtoDocLegal);
                
                // Preparo el DTO para el subsistema de impresion
                DTODocumento dtoDocu = new DTODocumento();
                dtoDocu.setDocumentoByte(docu.getDocument());
                dtoDocu.setDocumento(new String(docu.getDocument()));
                dtoDocu.setNumSecuencia(Integer.valueOf(1)); // Se setea asi ya que no diferenciamos tipos de solicitud
                dtoDocu.setTipoDocumento(oidImpresora);
                
                UtilidadesLog.debug("*** dtoDocu.documento: " + dtoDocu.getDocumento());
                         
                try {
                    this.spoolManager.addPrintableDocuments(dtoDocu, idSpool);
                } catch (RemoteException e) {
                    String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                }
            }
            
            // Cierro el spool
            try {
                this.spoolManager.closeSpoolColombia(idSpool);
            } catch (RemoteException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        } else {
            UtilidadesLog.debug("*** No hay boletas de recojo sin consolidar ***");
        }
        
        UtilidadesLog.info("MONGestionRecojoBean.generarBoletasRecojoCierreZona(DTOBatch dtoin): Salida");
        return new DTOSalidaBatch(0, "Generar bol.rec.cierre zona finalizado");
    }

    /**
     * Cambio 20080765
     * Genera un consolidado para un conjunto de boletas de recojo del mismo cliente.
     * @param dtoe DTOConsolidarBoletasRecojo con la info necesaria para consolidar.
     * @return dtoe
     * @throws MareException
     * @author dmorello
     * @since 20/08/2009
     */
    public DTOConsolidarBoletasRecojo consolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe) throws MareException {
    
        UtilidadesLog.info("MONGestionRecojoBean.consolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe): Entrada");
        
        DAOGestionRecojos dao = new DAOGestionRecojos();
        
        // Inserto el consolidado
        Long oidCons = dao.insertarConsolidadoBoletaRecojo(dtoe);
        UtilidadesLog.debug("oidCons: " + oidCons);
        dtoe.setOidBoletaRecojoConsolidado(oidCons);
        
        // Actualizo las boletas obtenidas con el OID del consolidado generado
        dao.actualizarBoletasRecojoConsolidado(dtoe.getOidsBoletasConsolidar(), oidCons);

        UtilidadesLog.info("MONGestionRecojoBean.consolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe): Salida");
        return dtoe;
    }

    /**
     * Cambio 20080765
     * Consolida boletas de recojo de un cliente y setea en un DTOFACDocumentoContable
     * algunos campos necesarios para emitir la boleta de recojo desde FAC.
     * @param dtoCons DTO con la informacion necesaria para generar el consolidado de boleta.
     * @param dtoFac DTO con la informacion necesaria para imprimir las boletas de recojo
     * @return dtoFac
     * @throws MareException
     * @author dmorello
     * @since 21/08/2009
     */
    public DTOFACDocumentoContable consolidarBoletasRecojoDesdeFAC(DTOConsolidarBoletasRecojo dtoCons,
            DTOFACDocumentoContable dtoFac) throws MareException {
            
        UtilidadesLog.info("MONGestionRecojoBean.consolidarBoletasRecojoDesdeFAC(DTOConsolidarBoletasRecojo dtoCons,"
                        + "DTOFACDocumentoContable dtoFac): Entrada");
        
        UtilidadesLog.debug("*** dtoCons: " + dtoCons);
        UtilidadesLog.debug("*** dtoFac.getCabecera(): " + dtoFac.getCabecera());
        
        Long oidIdioma = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
        
        MONProcesosPEDLocal monProc = null;
        MONFacturacionLocal monFact = null;
        MONProcesosFacturacionLocal monPF = null;
        MONImpresoraVirtual monImpr = null;
        try {
            MONProcesosPEDLocalHome homeProc = this.getMONProcesosPEDLocalHome();
            MONFacturacionLocalHome homeFact = this.getMONFacturacionLocalHome();
            MONProcesosFacturacionLocalHome homePF = this.getMONProcesosFacturacionLocalHome();
            //MONImpresoraVirtualHome homeImpr = this.getMONImpresoraVirtualHome();
            monProc = homeProc.create();
            monFact = homeFact.create();
            monPF = homePF.create();
            //monImpr = homeImpr.create();
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        /*} catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));*/
        }
                        
        DAOGestionRecojos dao = new DAOGestionRecojos();
                        
        dtoCons.setOidsBoletasConsolidar(dao.obtenerBoletasRecojoSinConsolidar(dtoCons.getOidCliente()));
        dtoCons.setOidsSolicitudesOrigen(dao.obtenerSolicitudesOrigenBoletas(dtoCons.getOidsBoletasConsolidar()));
        
        // Obtengo mas datos
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Integer anio = Integer.valueOf(sdf.format(new Date(System.currentTimeMillis())));
        PaisLocal pais = new PaisLocalHome().findByPrimaryKey(dtoCons.getOidPais());
        
        // Obtengo numero de boleta recojo consolidado
        DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
        dtoNumero.setOidPais(dtoCons.getOidPais());
        dtoNumero.setCodPais(pais.getCod_pais());
        dtoNumero.setCodCanal("_");
        dtoNumero.setCodAcceso("_");
        dtoNumero.setCodSubacceso("_");
        dtoNumero.setOperacion("REC059");
        dtoNumero.setAnyo(anio);
        String strNumeroBoleta = monProc.generaNumeroDocumento(dtoNumero);
        dtoCons.setNumeroBoleta(Long.valueOf(strNumeroBoleta));
        
        // Relleno informacion de solicitudes si no esta presente
        if (dtoFac.getCabecera().getListaSolicitudes() == null) {
            ArrayList listaSol = monFact.obtenerCabecerasSolicitud(dtoCons.getOidsSolicitudesOrigen());
            dtoFac.getCabecera().setListaSolicitudes(listaSol);
            UtilidadesLog.debug("listaSol: " + listaSol);
        }
        
        // Completo la informacion del dtoCons
        dtoCons = this.completarDTOConsolidarBoletasRecojo(dtoCons, dtoFac);
        dtoFac.getCabecera().setIndPedidoServicio(dtoCons.getIndPedidoServicio());
        dtoFac.getCabecera().setFechaEntrega(dtoCons.getFechaRecojo());
        
        // Consolido las boletas de recojo segun la info del dtoCons
        dtoCons = this.consolidarBoletasRecojo(dtoCons);
        
        // Relleno informacion de posiciones si no esta presente
        if (dtoFac.getCabecera().getListaDetalle() == null) {
            HashMap hashPosiciones = monPF.obtenerPosicionesCabeceras(dtoCons.getOidsSolicitudesOrigen(), oidIdioma);
            UtilidadesLog.debug("*** hashPosiciones: " + hashPosiciones);
            ArrayList listaPosiciones = new ArrayList();
            int oidsMide = dtoCons.getOidsSolicitudesOrigen().size();
            for (int x=0; x< oidsMide ; x++){
                String strOid = dtoCons.getOidsSolicitudesOrigen().get(x).toString();
                if (hashPosiciones.get(strOid) != null){                  
                  listaPosiciones.addAll((ArrayList)hashPosiciones.get(strOid));    
                  hashPosiciones.remove(strOid);
                }                
            }
            dtoFac.getCabecera().setListaDetalle(listaPosiciones);
            UtilidadesLog.debug("*** listaPosiciones: " + listaPosiciones);
        }
                        
        // Seteo info extra del dtoFac
        //dtoFac.getCabecera().setIndPedidoServicio(dtoCons.getIndPedidoServicio());
        //dtoFac.getCabecera().setFechaEntrega(dtoCons.getFechaRecojo());
        dtoFac.getCabecera().setOidBoletaRecojoConsolidado(dtoCons.getOidBoletaRecojoConsolidado());
                        
        UtilidadesLog.info("MONGestionRecojoBean.consolidarBoletasRecojoDesdeFAC(DTOConsolidarBoletasRecojo dtoCons,"
                        + "DTOFACDocumentoContable dtoFac): Salida");
        return dtoFac;
    }
    
    /**
     * Cambio 20080765
     * Completa el DTOConsolidarBoletasRecojo recibido y lo devuelve
     * @author dmorello
     * @since 10-sep-2009
     */
    private DTOConsolidarBoletasRecojo completarDTOConsolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoCons, DTOFACDocumentoContable dtoFac)
            throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.completarDTOConsolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe): Entrada");
        
        DAOGestionRecojos dao = new DAOGestionRecojos();
        
        UtilidadesLog.debug("*** dto del cual voy a setear indpedidoservicio: " + (DTOFACCabeceraSolicitud)dtoFac.getCabecera().getListaSolicitudes().get(0));
        
        // Paso estas dos lineas al for de generarBoletasRecojoCierreZona
        //dtoCons.setOidsBoletasConsolidar(dao.obtenerBoletasRecojoSinConsolidar(dtoCons.getOidCliente()));
        //dtoCons.setOidsSolicitudesOrigen(dao.obtenerSolicitudesOrigenBoletas(dtoCons.getOidsBoletasConsolidar()));
        dtoCons.setIndPedidoServicio(((DTOFACCabeceraSolicitud)dtoFac.getCabecera().getListaSolicitudes().get(0)).getIndPedidoServicio());
        dtoCons.setFechaRecojo(((DTOFACCabeceraSolicitud)dtoFac.getCabecera().getListaSolicitudes().get(0)).getFechaEntrega());
        dtoCons.setOidEstadoRecojo(dao.obtenerEstadoRecojo("PR"));
        
        // Si la fecha de recojo obtenida es null, se setea la fecha del sistema
        if (dtoCons.getFechaRecojo() == null) {
            dtoCons.setFechaRecojo(new Date(System.currentTimeMillis()));
        }
        
        UtilidadesLog.debug("dtoCons: " + dtoCons);
        
        UtilidadesLog.info("DAOGestionRecojos.completarDTOConsolidarBoletasRecojo(DTOConsolidarBoletasRecojo dtoe): Salida");
        return dtoCons;
    }
    
    private Long abrirSpool() {
        Long spool = null;
        try{
            MareMGC mgc = new MareMGC();
            mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String subaccesoUsuario = (String) mgc.getProperty("application.subaccesoImpresion");
            if (this.spoolManager == null) {
                this.spoolManager = this.getSpoolManagerHome().create(); 
            }
            spool = this.spoolManager.openSpool(new Long(subaccesoUsuario));
            FactoriaSerializador factoriaSerializador = FactoriaSerializador.getFactoriaSerializador();
            factoriaSerializador.inicializarListaSerializador();
        }catch (Exception e){
            UtilidadesLog.error("ERROR AL ABRIR EL SPOOL",e);
        }
        return spool;
    }
    
    private Long obtenerImpresoraBoletaRecojo() {
        Long oidImpresora = null;
        try{
            MareMGC mgc = new MareMGC();
            mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String subaccesoUsuario = (String) mgc.getProperty("application.subaccesoImpresion");
            
            MONImpresoraVirtualHome home = this.getMONImpresoraVirtualHome();
            MONImpresoraVirtual mon = home.create();
            oidImpresora = mon.obtenerImpresoraPorRutinaFormulario("BoletaRecojoColombia", Long.valueOf(subaccesoUsuario));
        }catch (Exception e){
            UtilidadesLog.error("ERROR AL ABRIR EL SPOOL",e);
        }
        return oidImpresora;
    }
    
    private MONProcesosPEDLocalHome getMONProcesosPEDLocalHome() throws MareException {
        Object home = UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONProcesosPED");
        return (MONProcesosPEDLocalHome)home;
    }

    private SpoolManagerHome getSpoolManagerHome() throws MareException {
        Object home = UtilidadesEJB.getHome("java:comp/env/SpoolManager", SpoolManagerHome.class );
        return (SpoolManagerHome)home;
    }

    private MONFacturacionLocalHome getMONFacturacionLocalHome() throws MareException {
        Object home = UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONFacturacion");
        return (MONFacturacionLocalHome)home;
    }

    private MONProcesosFacturacionLocalHome getMONProcesosFacturacionLocalHome() throws MareException {
        Object home = UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONProcesosFacturacion");
        return (MONProcesosFacturacionLocalHome)home;
    }

    private MONImpresoraVirtualHome getMONImpresoraVirtualHome() throws MareException {
        Object home = UtilidadesEJB.getHome("java:comp/env/MONImpresoraVirtual", MONImpresoraVirtualHome.class);
        return (MONImpresoraVirtualHome)home;
    }
}
