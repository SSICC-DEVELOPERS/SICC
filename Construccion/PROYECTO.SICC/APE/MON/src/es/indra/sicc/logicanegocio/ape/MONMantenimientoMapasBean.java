/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalle;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOMapaZonasLineasArmado;      
import es.indra.sicc.logicanegocio.ape.DAOMantenimientoMapas;
import java.util.HashMap;
import es.indra.sicc.entidades.ape.MapaZonaCabeceraLocalHome;
import es.indra.sicc.entidades.ape.MapaZonaCabeceraLocal;
import es.indra.sicc.entidades.ape.MapaZonaDetalleLocalHome;
import es.indra.sicc.entidades.ape.MapaZonaDetalleLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalleSubLineas;
import es.indra.sicc.dtos.ape.DTOCopiarMapaZonas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOExpandirAnaquel;
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoMapasBean implements SessionBean  {
  private SessionContext ctx;    
  public void ejbCreate() { }
  public void ejbActivate() { }
  public void ejbPassivate() { }
  public void ejbRemove() { }
  public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       23/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerMapasCDPorCD(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapasCDPorCD(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoMapas().obtenerMapasCDPorCD(dtoe);
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapasCDPorCD(DTOOID dtoe): Salida");
    return dtoSalida;
  }

  /**
   * Datos para recarga del combo 'Mapa de zonas' a partir del oid
   * seleccionado en 'Mapa centro distribucion'. Necesita recibir el idioma.
   * @autor eiraola
   * @since 24/01/2007
   */
  public DTOSalida obtenerMapaZonaPorMapaCD(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonaPorMapaCD(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoMapas().obtenerMapaZonaPorMapaCD(dtoe);
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonaPorMapaCD(DTOOID dtoe): Salida");
    return dtoSalida;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void insertarMapaZonas(DTOMapaZonasLineasArmado dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.insertarMapaZonas(DTOMapaZonasLineasArmado dtoe): Entrada");
    
    try {
        DTOMapaZonasCabecera dtoMapaZonasCabecera = dtoe.getMapaZonasCabecera();
        
        if(dtoMapaZonasCabecera.getValorDefecto().booleanValue()){
          
          DTOOID oidMapaCD = new DTOOID();
          oidMapaCD.setOid(dtoMapaZonasCabecera.getMapaCentroDistribucionCabecerea().getOid());
          
          DAOMantenimientoMapas daoMantenimientoMapas = new DAOMantenimientoMapas();
          Long oidDefault = daoMantenimientoMapas.obtenerOIDMapaZonasDefault(oidMapaCD);
    
          if(oidDefault!=null){
            
            if(dtoMapaZonasCabecera.getOid()== null || !oidDefault.equals(dtoMapaZonasCabecera.getOid())){
              
              ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                             UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                              ErroresDeNegocio.APE_0035));
    
              ex.setPosicion(ExcepcionParametrizada.POSICION_INICIAL);
              ex.addParameter(dtoMapaZonasCabecera.getMapaCentroDistribucionCabecerea().getCentroDistribucion().getDescripcion());
    
              ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
              ex.addParameter(dtoMapaZonasCabecera.getMapaCentroDistribucionCabecerea().getDescripcionMapa());
    
              throw ex;
            }
          }      
        }
        
        // vbongiov -- LG_V400000053 -- 6/11/2007
        if(this.validarMapa(dtoe.getMapaZonasDetalles(), 
                            dtoe.getMapaZonasCabecera().getMapaCentroDistribucionCabecerea().getOid()).booleanValue()){
          // Guargar el mapa zona
          this.insertarCabeceraMapaZonas(dtoe.getMapaZonasCabecera());
          this.insertarDetalleMapaZonas(dtoe.getMapaZonasDetalles());
          
        }
    
    }  catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
    } 
    
    UtilidadesLog.info("MONMantenimientoMapasBean.insertarMapaZonas(DTOMapaZonasLineasArmado dtoe): Salida");
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public Boolean validarMapa(ArrayList detalles, Long oidMapaCentroDistribucionCab) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.validarMapa(ArrayList detalles, Long oidMapaCentroDistribucionCab): Entrada");
  
    HashMap oidSublin = new HashMap();
    DTOOIDs oidsSublineas = new DTOOIDs();
    DTOMapaZonasDetalle dtoMapaZonasDetalle = null;
    Long oidSublinea = null;
   
    int cant = detalles.size();
    
    for(int i=0; i<cant; i++){     
        dtoMapaZonasDetalle = (DTOMapaZonasDetalle)detalles.get(i);      
        oidSublinea = (Long)oidSublin.get(dtoMapaZonasDetalle.getSublineaArmado().getOid());
        
        if(oidSublinea == null){
          oidSublin.put(dtoMapaZonasDetalle.getSublineaArmado().getOid(), dtoMapaZonasDetalle.getSublineaArmado().getOid());
        }      
    }
    
    UtilidadesLog.debug("oidSublin: " + oidSublin);   
    
    Long[] oids = new Long[oidSublin.size()];
    int k = 0;
    Iterator it = oidSublin.entrySet().iterator();         
        
    while (it.hasNext()) { 
        Map.Entry entry = (Map.Entry) it.next();
         oids[k] = (Long)entry.getKey();
         k++;
    }      

    oidsSublineas.setOids(oids);
        
    DAOMantenimientoMapas daoMantenimientoMapas = new DAOMantenimientoMapas();
    ArrayList zonas = null;
    
    /*
     * BELC400000321 - dmorello, 25/04/2007
     * Paso a trabajar con una lista de objetos DatosZona
     */
    //DatosZona datos = daoMantenimientoMapas.obtenerDatosZona(oidsSublineas);
    ArrayList datosZonas = daoMantenimientoMapas.obtenerDatosZona(oidsSublineas, oidMapaCentroDistribucionCab);
    
    // Verfica solapamiento
    int cant1 = oidsSublineas.getOids().length;
    Long[] oidSublineas = oidsSublineas.getOids();
    Long oidSubl = null;
    ZonasSublinea zonasSublinea = null;
    
    for (int i = 0; i < cant1; i++) {
        oidSublinea = oidSublineas[i];
        zonas = new ArrayList();
        UtilidadesLog.debug("oidSublinea ["+i+"]: " + oidSublinea);
        
        for(int j=0; j<cant; j++){     
            dtoMapaZonasDetalle = (DTOMapaZonasDetalle)detalles.get(j);      
            oidSubl = dtoMapaZonasDetalle.getSublineaArmado().getOid();
            UtilidadesLog.debug("oidSubl pag: " + oidSubl);
            
            if(oidSubl.equals(oidSublinea)){
                UtilidadesLog.debug("iguales");
                zonasSublinea = new ZonasSublinea();
                zonasSublinea.setOidSublinea(oidSubl);
                zonasSublinea.setBahiaDesde(Integer.valueOf(dtoMapaZonasDetalle.getBahiaDesde().toString()));
                zonasSublinea.setBahiaHasta(Integer.valueOf(dtoMapaZonasDetalle.getBahiaHasta().toString()));
            
                zonas.add(zonasSublinea);
            }        
        }
        
        UtilidadesLog.debug("zonas size: " + zonas.size());
        // Ordenar por bahia asc
        zonas = ordenarPorBahia(zonas);
        
        /*
         * BELC400000321 - dmorello, 25/04/2007
         * Crear una variable datos del tipo DatosZona y asignarle el elemento de
         * datosZonas que se corresponda con el oidSublinea que estamos tratando.
         */
        UtilidadesLog.debug("Busco el DatosZonas de la sublinea actual: " + oidSublinea);
        DatosZona datos = null;
        for (int j = 0; (j < datosZonas.size()) && (datos == null); j++) {
          DatosZona aux = (DatosZona)datosZonas.get(j);
          if (aux.getOidSublinea().equals(oidSublinea)) {
            datos = aux;
          }
        }
        
        ZonasSublinea ultimoEleZona = (ZonasSublinea)zonas.get(zonas.size()-1);
        
        UtilidadesLog.debug("ultimoEleZona.getBahiaHasta(): " + ultimoEleZona.getBahiaHasta());
        UtilidadesLog.debug("datos.getBahiaMayor(): " + datos.getBahiaMayor());
        
        if(ultimoEleZona.getBahiaHasta().intValue() > datos.getBahiaMayor().intValue()){        
            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                          ErroresDeNegocio.APE_0936));

            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            ex.addParameter(datos.getBahiaMayor().toString());
  
            throw ex;          
        }
        
        if(!ultimoEleZona.getBahiaHasta().equals(datos.getBahiaMayor())){        
            throw new MareException(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                          ErroresDeNegocio.APE_0036));
        }
        
        int incremento = datos.getIncremento().intValue(); 
        int auxBahiaHasta = 1 - incremento;
        int cantZonas = zonas.size();
        ZonasSublinea zonasSublinea1 = null;
        
        for (int m = 0; m < cantZonas; m++) {
            zonasSublinea1 = (ZonasSublinea)zonas.get(m);
      
            UtilidadesLog.debug("zonasSublinea1.getBahiaDesde(): " + zonasSublinea1.getBahiaDesde());
            UtilidadesLog.debug("auxBahiaHasta + incremento: " + (auxBahiaHasta + incremento));
            
            /*
             * BELC400000321 - dmorello, 25/04/2007
             * Se agregan las siguientes verificaciones
             */
            boolean cambiarIncrementoADos = false;
             
            int bahiaDesde = zonasSublinea1.getBahiaDesde().intValue();
            if (bahiaDesde > datos.getMaxBahiaImpar().intValue()) {
                cambiarIncrementoADos = true;
                if (bahiaDesde % 2 != 0) {
                    /* El error APE_0036 del DMCO aparece como APE_0936 en SICCErrores */
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0936));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(datos.getMaxBahiaImpar().toString());
                    
                    throw ex;        
                }
            }
            
            if (datos.getFrenteEspalda().booleanValue() && bahiaDesde > datos.getMaxBahiaPar().intValue() ) {
                cambiarIncrementoADos = true;
                if (bahiaDesde % 2 == 0) {
                    /* El error APE_0036 del DMCO aparece como APE_0936 en SICCErrores */
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0936));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(datos.getMaxBahiaImpar().toString());
                    
                    throw ex;        
                }
            }
            
            int bahiaHasta = zonasSublinea1.getBahiaHasta().intValue();
            if (bahiaHasta > datos.getMaxBahiaImpar().intValue()) {
                cambiarIncrementoADos = true;
                if (bahiaHasta % 2 != 0) {
                    /* El error APE_0036 del DMCO aparece como APE_0936 en SICCErrores */
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0936));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(datos.getMaxBahiaImpar().toString());
                    
                    throw ex;        
                }
            }
            
            if (datos.getFrenteEspalda().booleanValue() && bahiaHasta > datos.getMaxBahiaPar().intValue()) {
                cambiarIncrementoADos = true;
                if (bahiaHasta % 2 == 0) {
                    /* El error APE_0036 del DMCO aparece como APE_0936 en SICCErrores */
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0936));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(datos.getMaxBahiaImpar().toString());
                    
                    throw ex;        
                }
            }
            
            /* Fin BELC400000321 dmorello 25/04/2007 */
            
            // vbongiov -- LG_V400000053 -- 7/11/2007            
            UtilidadesLog.debug("!datos.getFrenteEspalda().booleanValue(): " + !datos.getFrenteEspalda().booleanValue());
            if(!datos.getFrenteEspalda().booleanValue()){
                // La Bahia desde no es impar
                if(zonasSublinea1.getBahiaDesde().intValue() % 2 == 0){
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0006));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(zonasSublinea1.getBahiaDesde().toString());
                    
                    throw ex;        
                }
                
                // La Bahia hasta no es impar
                if(auxBahiaHasta % 2 == 0){
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                 UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                                  ErroresDeNegocio.APE_0006));
        
                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(new Integer(auxBahiaHasta).toString());
                    
                    throw ex;        
                }            
            }
            
            if(zonasSublinea1.getBahiaDesde().intValue()!=(auxBahiaHasta + incremento)){
            
                if(zonasSublinea1.getBahiaDesde().intValue()<(auxBahiaHasta + incremento)){
                    throw new MareException(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                          ErroresDeNegocio.APE_0005));
                } else {
                    throw new MareException(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                          ErroresDeNegocio.APE_0036));
                }
                
            } else {
                auxBahiaHasta = zonasSublinea1.getBahiaHasta().intValue();
            }
            
            /* BELC400000321 - dmorello, 27/04/2007 */
            if (cambiarIncrementoADos)
                incremento = 2;
        }
    }
    
    UtilidadesLog.debug("Boolean.TRUE");
    
    UtilidadesLog.info("MONMantenimientoMapasBean.validarMapa(ArrayList detalles, Long oidMapaCentroDistribucionCab): Salida");
    return Boolean.TRUE;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  private ArrayList ordenarPorBahia(ArrayList zonas) throws MareException {
      Collections.sort(zonas, new BahiaComparator());      
      return zonas;
  }
  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       29/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void insertarCabeceraMapaZonas(DTOMapaZonasCabecera dtoMapaCabecera) throws MareException {
      UtilidadesLog.info("MONMantenimientoMapasBean.insertarCabeceraMapaZonas(DTOMapaZonasCabecera dtoMapaCabecera): Entrada");
   
      try {
          MapaZonaCabeceraLocalHome mapaZonaCabLH = new MapaZonaCabeceraLocalHome();
          Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
          
          if(dtoMapaCabecera.getOid()== null){
            UtilidadesLog.debug("Insercion");  
         
            // Datos generales   
            MapaZonaCabeceraLocal mapaZonaCabL;
            try {
                mapaZonaCabL = mapaZonaCabLH.create(dtoMapaCabecera.getValorDefecto(), dtoMapaCabecera.getMapaCentroDistribucionCabecerea().getOid());
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
         
            // Descripcion      
            int cantDesc = dtoMapaCabecera.getDescripcionMapaZonas().size();
            Vector descTrad = dtoMapaCabecera.getDescripcionMapaZonas();
            DTOI18nSICC dtoTraduccion = null;
            Long oidIdioma = null;
            String descripcion = null;
            
            for (int i=0; i < cantDesc; i++){
                dtoTraduccion = (DTOI18nSICC)descTrad.get(i);
                oidIdioma = dtoTraduccion.getOidIdioma();
                descripcion = dtoTraduccion.getValorI18n();
                
                try {
                    entidadi18nLocalHome.create("APE_MAPA_ZONA_CABEC", new Long(1), oidIdioma, 
                                               descripcion, mapaZonaCabL.getOid());
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
                                         
            dtoMapaCabecera.setOid(mapaZonaCabL.getOid());
            
          } else if(dtoMapaCabecera.getOid()!= null){
            UtilidadesLog.debug("Modificacion");  
            
            MapaZonaCabeceraLocal mapaZonaCabL = mapaZonaCabLH.findByPrimaryKey(dtoMapaCabecera.getOid());
            mapaZonaCabL.setValorDefecto(dtoMapaCabecera.getValorDefecto());         
            
            try {
                mapaZonaCabLH.merge(mapaZonaCabL);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            // Actualizo descripciones
            int cantDesc = dtoMapaCabecera.getDescripcionMapaZonas().size();
            Vector descTrad = dtoMapaCabecera.getDescripcionMapaZonas();
            DTOI18nSICC dtoTraduccion = null;
            Long oidIdioma = null;
            String descripcion = null;
            Entidadi18nLocal entidadi18n = null;
            
            for (int i=0; i < cantDesc; i++){
                dtoTraduccion = (DTOI18nSICC)descTrad.get(i);
                oidIdioma = dtoTraduccion.getOidIdioma();
                descripcion = dtoTraduccion.getValorI18n();
                
                try {
                    entidadi18n = entidadi18nLocalHome.findByEntAtrIdioPK("APE_MAPA_ZONA_CABEC", new Long(1), 
                                           oidIdioma, dtoMapaCabecera.getOid());
                } catch (NoResultException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                entidadi18n.setDetalle(descripcion);
                
                try {
                    entidadi18nLocalHome.merge(entidadi18n);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
          }
          
      }  catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }  catch (PersistenceException e){   
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONMantenimientoMapasBean.insertarCabeceraMapaZonas(DTOMapaZonasCabecera dtoMapaCabecera): Salida");
  }

  public void insertarDetalleMapaZonas(ArrayList dtoMapaDetalle) throws MareException {
      UtilidadesLog.info("MONMantenimientoMapasBean.insertarDetalleMapaZonas(ArrayList dtoMapaDetalle): Entrada");
      
      try {
      
          int cant = dtoMapaDetalle.size();
          DTOMapaZonasDetalle dtoMapaZonasDetalle = null;
          MapaZonaDetalleLocalHome mapaZonaDetLH = new MapaZonaDetalleLocalHome();
          MapaZonaDetalleLocal mapaZonaDetL = null;
    
          for(int i=0; i<cant; i++){     
              dtoMapaZonasDetalle = (DTOMapaZonasDetalle)dtoMapaDetalle.get(i);     
              
              if(dtoMapaZonasDetalle.getOid()==null){
                  UtilidadesLog.debug("Insercion");  
                  
                  try {
                      mapaZonaDetLH.create(dtoMapaZonasDetalle.getOidZona(), 
                                           dtoMapaZonasDetalle.getBahiaDesde(),
                                           dtoMapaZonasDetalle.getBahiaHasta(), 
                                           dtoMapaZonasDetalle.getSublineaArmado().getOid(),
                                           dtoMapaZonasDetalle.getMapaZonaCabecera().getOid());
                  } catch (PersistenceException e) {
                      ctx.setRollbackOnly();
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                  }
                                       
              } else if(dtoMapaZonasDetalle.getOid()!=null){
                  UtilidadesLog.debug("Modificacion");  
            
                  mapaZonaDetL = mapaZonaDetLH.findByPrimaryKey(dtoMapaZonasDetalle.getOid());
                  
                  mapaZonaDetL.setBahiaHasta(dtoMapaZonasDetalle.getBahiaHasta());
                  
                  try {
                      mapaZonaDetLH.merge(mapaZonaDetL);
                  } catch (PersistenceException e) {
                      ctx.setRollbackOnly();
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                  }
              }
          }
      }   catch (NoResultException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }   catch (PersistenceException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONMantenimientoMapasBean.insertarDetalleMapaZonas(ArrayList dtoMapaDetalle): Salida");
  }
  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerMapaZonasCabecera(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonasCabecera(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoMapas().obtenerMapaZonasCabecera(dtoe);
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonasCabecera(DTOOID dtoe): Salida");
    return dtoSalida;
  }
  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       30/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOMapaZonasDetalleSubLineas obtenerMapaZonasDetalle(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonasDetalle(DTOOID dtoe): Entrada");
    DTOMapaZonasDetalleSubLineas dtoSalida = new DAOMantenimientoMapas().obtenerMapaZonasDetalle(dtoe);
    UtilidadesLog.info("MONMantenimientoMapasBean.obtenerMapaZonasDetalle(DTOOID dtoe): Salida");
    return dtoSalida;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       31/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void modificarMapaZonas(DTOMapaZonasLineasArmado dtoe) throws MareException {
      UtilidadesLog.info("MONMantenimientoMapasBean.modificarMapaZonas(DTOMapaZonasLineasArmado dtoe): Entrada");
      
      try {
          this.eliminarDetalles(dtoe.getDetallesEliminados());
          
          this.insertarMapaZonas(dtoe);
          
      }  catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      } 
      
      UtilidadesLog.info("MONMantenimientoMapasBean.modificarMapaZonas(DTOMapaZonasLineasArmado dtoe): Salida");
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       31/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void eliminarDetalles(DTOOIDs detallesEliminados) throws MareException {  
      UtilidadesLog.info("MONMantenimientoMapasBean.eliminarDetalles(DTOOIDs detallesEliminados): Entrada");
      
      try {
          if(detallesEliminados != null){
              MapaZonaDetalleLocalHome mapaZonaDetLH = new MapaZonaDetalleLocalHome();
              MapaZonaDetalleLocal mapaZonaDetL = null;
              
              Long[] oidDetallesElim = detallesEliminados.getOids();
              int cant = oidDetallesElim.length;
              
              for(int i=0; i< cant;i++){
                  mapaZonaDetL = mapaZonaDetLH.findByPrimaryKey(oidDetallesElim[i]);
                  
                  try {
                    mapaZonaDetLH.remove(mapaZonaDetL);
                  } catch (PersistenceException e) {
                      ctx.setRollbackOnly();
                      UtilidadesLog.error("ERROR ", e);
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                  }
              }
          }
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONMantenimientoMapasBean.eliminarDetalles(DTOOIDs detallesEliminados): Salida");
  }
  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       31/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void eliminarMapaZonas(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.eliminarMapaZonas(DTOOID dtoe): Entrada");
    
    DAOMantenimientoMapas daoMantenimientoMapas = new DAOMantenimientoMapas();
    try {
        daoMantenimientoMapas.eliminarMapaZonasCabecera(dtoe);
    } catch (MareException e) {
        // Este catch se hace para hacer rollback cuando la excepcion
        // proviene de operaciones sobre entity beans
        ctx.setRollbackOnly();
        throw e;
    }
    
    UtilidadesLog.info("MONMantenimientoMapasBean.eliminarMapaZonas(DTOOID dtoe): Salida");
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       2/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void copiarMapaZonas(DTOCopiarMapaZonas dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapasBean.copiarMapaZonas(DTOCopiarMapaZonas dtoe): Entrada");
    
    try {
        DAOMantenimientoMapas daoMantenimientoMapas = new DAOMantenimientoMapas();
        ArrayList detalles = daoMantenimientoMapas.obtenerDetallesACopiar(dtoe.getMapaZonasDetalle(), dtoe.getMapaZonasCabecera() );
        
        //Insertamos la nueva cabecera 
        this.insertarCabeceraMapaZonas(dtoe.getMapaZonasCabecera());
        
        //Se copia los detalles 
        this.insertarDetalleMapaZonas(detalles);
    }  catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        ex.printStackTrace();
        throw new MareException(ex);
    } 
    
    UtilidadesLog.info("MONMantenimientoMapasBean.copiarMapaZonas(DTOCopiarMapaZonas dtoe): Salida");
  
  }

   /** 
   * Autor: Cristian Valenzuela
   * Fecha: 5/2/2007
   */
    public DTOSalida obtenerProximoCodigoMapaCD(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMapasBean.obtenerProximoCodigoMapaCD"+
        "(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DTOSalida();                
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        dtoSalida = dao.obtenerProximoCodigoMapaCD(dtoe);        
        UtilidadesLog.info("MONMantenimientoMapasBean.obtenerProximoCodigoMapaCD"+
        "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    
   /** 
   * Autor: Cristian Valenzuela
   * Fecha: 7/2/2007
   */

    public DTOOID generarMapaCentroDistribucion(DTOMapaCentroDistribucionCabecera dtoe) 
        throws MareException {
        UtilidadesLog.info("MONMantenimientoMapasBean.generarMapaCentroDistribucion"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Entrada");
        UtilidadesLog.debug("********** DTOMapaCentroDistribucionCabecera: " + dtoe);
        
        UtilidadesLog.debug("********** Llamando a insertarCabeceraMapaCD");
        this.insertarCabeceraMapaCD(dtoe);          
        
        DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();        
        DTOConfiguracionCentroDistribucion dtoConfiguracion = dtoe.getCentroDistribucion();
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(dtoConfiguracion.getOidCentroDistribucion());
        
        UtilidadesLog.debug("********** Llamando a buscarSublineasCD");
        ArrayList sublineas = dao.buscarSublineasCD(dtoOid);
        int cant = sublineas.size();
        UtilidadesLog.debug("**** cant " + cant);        
        
        ArrayList detallesAInsertar = new ArrayList();        
        
        for(int i=0; i<cant; i++) {
            DTOSublineaArmado dtoSublinea = (DTOSublineaArmado)sublineas.get(i);
            UtilidadesLog.debug("********** DTOSublineaArmado " + dtoSublinea);
            
            UtilidadesLog.debug("********** Llamando a generarDetallesMapaCD");
            ArrayList dtosTemp1 = this.generarDetallesMapaCD(dtoe, dtoSublinea, Boolean.TRUE);
            int contador = dtosTemp1.size();
            UtilidadesLog.debug("********** contador: " + contador);
            for(int j=0; j<contador; j++) {                
                detallesAInsertar.add((DTOMapaCentroDistribucionDetalle)dtosTemp1.get(j));          
            }
            
            if(dtoSublinea.getFrenteEspalda()!=null && 
            dtoSublinea.getFrenteEspalda().booleanValue() == true) {
                UtilidadesLog.debug("********** Llamando a generarDetallesMapaCD");
                ArrayList dtosTemp2 = this.generarDetallesMapaCD(dtoe, dtoSublinea, Boolean.FALSE);
                int contador2 = dtosTemp2.size();
                UtilidadesLog.debug("********** contador2: " + contador2);
                for(int k=0; k<contador2; k++) {
                    detallesAInsertar.add((DTOMapaCentroDistribucionDetalle)dtosTemp2.get(k));              
                }
            }
        }
        
        UtilidadesLog.debug("********** Llamando a insertarDetallesMapaCD");
        this.insertarDetallesMapaCD(detallesAInsertar);                
        DTOOID dtoRespuesta = new DTOOID();
        dtoRespuesta.setOid(dtoe.getOid());        
        UtilidadesLog.debug("********** DTOOID dtoRespuesta: " + dtoRespuesta);
        UtilidadesLog.info("MONMantenimientoMapasBean.generarMapaCentroDistribucion"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Salida");
        return dtoRespuesta;
    }

    /*
     * Modificado por dmorello, 24/07/2007
     * El uso de Entity Beans se reemplaza por JDBC
     */
    public void insertarCabeceraMapaCD(DTOMapaCentroDistribucionCabecera dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONMantenimientoMapasBean.insertarCabeceraMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Entrada");
        
        UtilidadesLog.debug("********** DTOMapaCentroDistribucionCabecera: " + dtoe);
        
        //try {
            DTOConfiguracionCentroDistribucion dtoConfiguracion = dtoe.getCentroDistribucion();            
            //MapaCentroDistribucionCabeceraLocalHome mdclh = this.getMapaCentroDistribucionCabeceraLocalHome();
            //MapaCentroDistribucionCabeceraLocal mdcl = mdclh.create(dtoe.getCodigoMapa(),
            //dtoConfiguracion.getOidCentroDistribucion());
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            // Obtengo el OID para la cabecera del mapa CD
            Long oidCabecera = SecuenciadorOID.obtenerSiguienteValor("APE_MCDC_SEQ");
            
            // Inserto la cabecera y también su descripción I18N
            StringBuffer insertCab = new StringBuffer();
            Vector parametros = new Vector();
            insertCab.append("BEGIN ");
            insertCab.append("INSERT INTO APE_MAPA_CENTR_DISTR_CABEC ");
            insertCab.append("(OID_MAPA_CENT_DIST_CABE, NUM_CODI_MAPA, CCDI_OID_CONF_CENT_DIST) ");
            insertCab.append("VALUES (?,?,?); ");
            parametros.add(oidCabecera);
            parametros.add(dtoe.getCodigoMapa());
            parametros.add(dtoConfiguracion.getOidCentroDistribucion());
            
            //Este campo es internacionalizable
            //- descipcionMapa = cabecera.descripcionMapa            
            //Entidadi18nLocalHome entidadi18nLocalHome = CMNEjbLocators.getEntidadi18nLocalHome();
            Iterator it = dtoe.getAttriTraducible().iterator();
            while (it.hasNext()) {
                DTOI18nSICC dto = (DTOI18nSICC) it.next();                
                //UtilidadesLog.debug("************* Antes de hacer el create en Entidad i18n");
                //Entidadi18nLocal i18n = entidadi18nLocalHome.create("APE_MAPA_CENTR_DISTR_CABEC", 
                //new Long(1), dto.getOidIdioma(), dto.getValorI18n(), mdcl.getOid());
                //UtilidadesLog.debug("************* Despues de hacer el create en Entidad i18n");

                insertCab.append("INSERT INTO GEN_I18N_SICC ");
                insertCab.append("(OID_I18N, ATTR_ENTI, ATTR_NUM_ATRI, IDIO_OID_IDIO, VAL_I18N, VAL_OID) ");
                insertCab.append("VALUES (");
                insertCab.append("GEN_I18N_SEQ.nextval, 'APE_MAPA_CENTR_DISTR_CABEC', 1, ?, ?, ?); ");
                parametros.add(dto.getOidIdioma());
                parametros.add(dto.getValorI18n());
                parametros.add(oidCabecera);
            }
            
            insertCab.append("END;");
            
            try {
                bs.dbService.executePreparedUpdate(insertCab.toString(), parametros);
            } catch (Exception e) {
                String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
            
            //UtilidadesLog.debug("********** mdcl.getOid(): " + mdcl.getOid());
            //dtoe.setOid(mdcl.getOid());        
            dtoe.setOid(oidCabecera);
            
            UtilidadesLog.info("MONMantenimientoMapasBean.insertarCabeceraMapaCD"+
            "(DTOMapaCentroDistribucionCabecera dtoe): Salida");
        //}
        //catch (CreateException ce) {
        //    UtilidadesLog.error("ERROR ", ce);
        //    ctx.setRollbackOnly();
        //    throw new MareException(ce, 
        //    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        //}
        //catch (NamingException ne) {
        //    UtilidadesLog.error("ERROR ", ne);
        //    throw new MareException(ne, 
        //    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        //}           
    }

    public ArrayList generarDetallesMapaCD(DTOMapaCentroDistribucionCabecera dtoe, 
        
        //Gpons - 12/03/2007 - Inc. BELC400000223: Cambio Tipo de Dato de Campos
        
        DTOSublineaArmado sublinea, Boolean frente) throws MareException  {
        UtilidadesLog.info("MONMantenimientoMapasBean.generarDetallesMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe, DTOSublineaArmado sublinea, Boolean frente): Entrada");            
        
        UtilidadesLog.debug("************* DTOMapaCentroDistribucionCabecera: " + dtoe);
        UtilidadesLog.debug("************* DTOSublineaArmado " + sublinea);
        UtilidadesLog.debug("************* Boolean " + frente);
            
        Integer incrementoBahia = new Integer(2);
        Integer bahia;   
        Integer bahias;          
        Integer niveles;            
        Integer columnas;
            
        if(frente.booleanValue()==true) {
            bahia = new Integer("1");
            bahias = sublinea.getBahiasFrente();
            niveles = sublinea.getNumeroNivelesFrente();
            columnas = sublinea.getNumeroColumnasFrente();
        }
        else {
            bahia = new Integer("2");
            bahias = sublinea.getBahiaEspalda();
            niveles = sublinea.getNumeroNivelesEspalda();
            columnas = sublinea.getNumeroColumnasEspalda();                
        }      
        
        UtilidadesLog.debug("************* bahia: " + bahia);
        UtilidadesLog.debug("************* bahias " + bahias);
        UtilidadesLog.debug("************* niveles: " + niveles);
        UtilidadesLog.debug("************* columnas " + columnas);
        
        ArrayList detalles = new ArrayList();
        
        for(int contadorBahias=1 ; contadorBahias<=bahias.intValue(); contadorBahias++) {
            char nivel = 'A';             
            for(int contadorNivel=1; contadorNivel<=niveles.intValue(); contadorNivel++) {
               for(int contadorPosicion=1; contadorPosicion<=columnas.intValue(); contadorPosicion++) {               
                   StringBuffer sb = new StringBuffer();
                   sb.append(sublinea.getLetraParaAnaquel()); // char - 1
                   
                   if(bahia.toString().length()>1) {
                        sb.append(bahia.toString());    
                   }
                   else  {
                        StringBuffer sbBahia = new StringBuffer();
                        sbBahia.append("0");
                        sbBahia.append(bahia.toString());                   
                        sb.append(sbBahia.toString()); //Integer - 2                         
                   }                   
                   
                   sb.append(nivel); // char - 1
                   sb.append(contadorPosicion); //int - 1
                   String numeroAnaquel = sb.toString();
                   UtilidadesLog.debug("************* numeroAnaquel " + numeroAnaquel);
                   
                   DTOMapaCentroDistribucionDetalle detalle = new DTOMapaCentroDistribucionDetalle();
                   detalle.setMapaCentroDistribucionCabecera(dtoe);
                   detalle.setAnaquelDestino(null);
                   detalle.setSublineaArmado(sublinea);
                   detalle.setNumeroAnaquel(numeroAnaquel);
                   detalle.setCapacidad(new Long(1));
                   detalle.setExpandido(Boolean.FALSE);
                   UtilidadesLog.debug("************* DTOMapaCentroDistribucionDetalle " + detalle);
                   detalles.add(detalle);  
               }            
               nivel++;
               UtilidadesLog.debug("************* nivel " + nivel);
            }               
            bahia = new Integer(bahia.intValue() + incrementoBahia.intValue());
            UtilidadesLog.debug("************* bahia " + bahia);
        }
        
        UtilidadesLog.info("MONMantenimientoMapasBean.generarDetallesMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe, DTOSublineaArmado sublinea, Boolean frente): Salida");
        return detalles;
    }

    /*
     * Modificado por dmorello, 24/07/2007
     * El uso de Entity Beans se reemplaza por JDBC
     */
    public void insertarDetallesMapaCD(ArrayList detalles) throws MareException  {        
        UtilidadesLog.info("MONMantenimientoMapasBean.insertarDetallesMapaCD"+
        "(ArrayList detalles): Entrada");
        
        int cant = detalles.size();
        UtilidadesLog.debug("******* cant " + cant);
        
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer inserts = new StringBuffer();
            StringBuffer insertDet = new StringBuffer();
        
            for(int i=0; i<cant; i++) {            
                DTOMapaCentroDistribucionDetalle dtoDetalle = (DTOMapaCentroDistribucionDetalle)detalles.get(i);
                
                DTOMapaCentroDistribucionCabecera dtoCabecera = dtoDetalle.getMapaCentroDistribucionCabecera();
                DTOSublineaArmado dtoSublinea = dtoDetalle.getSublineaArmado();        
                DTOMapaCentroDistribucionDetalle anaquelDestino = dtoDetalle.getAnaquelDestino();
                
                UtilidadesLog.debug("******* i " + i);                
                UtilidadesLog.debug("******* DTOMapaCentroDistribucionDetalle " + dtoDetalle);                
                
                insertDet = new StringBuffer();
                insertDet.append("INSERT INTO APE_MAPA_CENTR_DISTR_DETAL ");
                insertDet.append("(OID_MAPA_CENT_DIST_DETA, NUM_ANAQ, NUM_CAPA, MCDC_OID_MAPA_CENT_DIST_CABE,");
                insertDet.append(" SBAR_OID_SUBL_ARMA, IND_EXPA ");
                if (anaquelDestino != null && anaquelDestino.getOid() != null) {
                    insertDet.append(", MCDD_OID_MAPA_CENT_DIST_DETA ");
                }
                insertDet.append(") VALUES ( ");
                insertDet.append(" APE_MCDD_SEQ.nextval"); 
                insertDet.append(", '").append(dtoDetalle.getNumeroAnaquel()).append("' ");
                insertDet.append(", ").append(dtoDetalle.getCapacidad());
                insertDet.append(", ").append(dtoCabecera.getOid());
                insertDet.append(", ").append(dtoSublinea.getOid());
                insertDet.append(", ").append(dtoDetalle.getExpandido().booleanValue() ? ConstantesAPE.TRUE : ConstantesAPE.FALSE);
                if (anaquelDestino != null && anaquelDestino.getOid() != null) {
                    insertDet.append(", ").append(anaquelDestino.getOid());
                }
                insertDet.append(");");
                inserts.append(insertDet);
                UtilidadesLog.debug("insertDet: " + insertDet);
            }
            
            try {
               bs.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",inserts.toString());
            } catch (Exception e) {
                String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        UtilidadesLog.info("MONMantenimientoMapasBean.insertarDetallesMapaCD"+
        "(ArrayList detalles): Salida");
    }

    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 12/2/2007
   */
    public DTOSalida obtenerNumerosAnaquelPorMapaCD(DTOOID oidMapaCD) 
    throws MareException  {    
        UtilidadesLog.info("MONMantenimientoMapasBean.obtenerNumerosAnaquelPorMapaCD"+
        "(DTOOID oidMapaCD): Entrada");        
        DTOSalida dtoSalida = new DTOSalida();                
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        dtoSalida = dao.obtenerNumerosAnaquelPorMapaCD(oidMapaCD);                
        UtilidadesLog.info("MONMantenimientoMapasBean.obtenerNumerosAnaquelPorMapaCD"+
        "(DTOOID oidMapaCD): Salida");
        return dtoSalida;  
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 12/2/2007
   */
    public DTOSalida buscarAnaquelesExpandidos(DTOOID dtoe) throws MareException {        
        UtilidadesLog.info("MONMantenimientoMapasBean.buscarAnaquelesExpandidos"+
        "(DTOOID oidMapaCD): Entrada");                
        DTOSalida dtoSalida = new DTOSalida();                
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        dtoSalida = dao.buscarAnaquelesExpandidos(dtoe);                     
        UtilidadesLog.info("MONMantenimientoMapasBean.buscarAnaquelesExpandidos"+
        "(DTOOID oidMapaCD): Salida");
        return dtoSalida;    
    }

 /** 
   * Autor: Cristian Valenzuela
   * Fecha: 14/2/2007
   */
   
   /* Modificado por: Cristian Valenzuela
      Fecha: 4/5/2007  */
    public DTOExpandirAnaquel expandirAnaquel(DTOExpandirAnaquel dtoe) throws MareException  {    
        UtilidadesLog.info("MONMantenimientoMapasBean.expandirAnaquel"+
        "(DTOExpandirAnaquel dtoe): Entrada");                 
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        if(dao.existenProductosEnAnaqueles(dtoe.getAnaquelesOrigen(), 
                dtoe.getOidPeriodo()).booleanValue()) {
            UtilidadesLog.debug("******* true, sale");
            dtoe.setMostrarMensaje(Boolean.TRUE);
        }
        else  {
            UtilidadesLog.debug("******* false, llama a expandirAnaquel");
            dtoe.setMostrarMensaje(Boolean.FALSE);
            try {
                dao.expandirAnaquel(dtoe);
            } catch (MareException e) {
                ctx.setRollbackOnly();
                throw e;
            }
        }
        
        UtilidadesLog.info("MONMantenimientoMapasBean.expandirAnaquel"+
        "(DTOExpandirAnaquel dtoe): Salida");     
        return dtoe;
    }
    
     /** 
   * Autor: Cristian Valenzuela
   * Fecha: 14/2/2007
   */
    public void moverExpandir(DTOExpandirAnaquel dtoe) throws MareException   {
        UtilidadesLog.info("MONMantenimientoMapasBean.moverExpandir"+
        "(DTOExpandirAnaquel dtoe): Entrada");           
         DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
         dao.moverProductos(dtoe.getAnaquelesOrigen(), dtoe.getAnaquelDestino());
         dao.expandirAnaquel(dtoe);
         UtilidadesLog.info("MONMantenimientoMapasBean.moverExpandir"+
        "(DTOExpandirAnaquel dtoe): Salida");           
    }
    
     /** 
   * Autor: Cristian Valenzuela
   * Fecha: 12/2/2007
   */
    public void dividirAnaquel(DTOOIDs anaquelesDividir) throws MareException {
        UtilidadesLog.info("MONMantenimientoMapasBean.dividirAnaquel"+
        "(DTOOIDs anaquelesDividir): Entrada");                
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        try {
            dao.dividirAnaquel(anaquelesDividir); 
        } catch (MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        UtilidadesLog.info("MONMantenimientoMapasBean.dividirAnaquel"+
        "(DTOOIDs anaquelesDividir): Salida");             
    }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 19/2/2007
   */
    public void copiarMapaCentroDistribucion(DTOMapaCentroDistribucionCabecera dtoe) 
    throws MareException {
        UtilidadesLog.info("MONMantenimientoMapasBean.copiarMapaCentroDistribucion"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Entrada"); 
        DAOMantenimientoMapas dao = new DAOMantenimientoMapas();
        dao.obtenerCopiaCabeceraMapaCD(dtoe);
        ArrayList detalles = dao.obtenerCopiaDetalleMapaCD(dtoe);
        try {
            dao.copiarMapaCentroDistribucion(dtoe, detalles);  
        } catch (MareException e) {
            // Este catch se hace para hacer rollback cuando la excepcion
            // proviene de operaciones con entity beans
            ctx.setRollbackOnly();
            throw e;
        }
        UtilidadesLog.info("MONMantenimientoMapasBean.copiarMapaCentroDistribucion"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Salida");    
    }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoMapas.obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoMapas().obtenerMapaCDPorCDYLinea(dtoe);
    UtilidadesLog.info("MONMantenimientoMapas.obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe)): Salida");
    return dtoSalida;
  }
}