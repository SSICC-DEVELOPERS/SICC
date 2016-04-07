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
import es.indra.sicc.dtos.ape.DTOBuscarAnaqueles;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesDetalle;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabeceraDetalles;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabecera;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import javax.ejb.DuplicateKeyException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ape.DTOCopiaOrdenAnaqueles;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoOrdenAnaquelesBean implements SessionBean  {
  private SessionContext ctx;
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       24/01/2007
    * @version     1.0
    * @autor       SCS
    * Devolver el resultado de la invocación a DAOMantenimientoOrdenAnaqueles.obtenerNroAnaquelesAOrdenar(dtoE)
    */
  public DTOSalida obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoOrdenAnaqueles().obtenerNroAnaquelesAOrdenar(dtoE);
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE): Salida");
    return dtoSalida;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/01/2007
    * @version     1.0
    * @autor       SCS
    * Se invoca a los métodos actualizarOrdenAnaquelesCabecera y actualizarOrdenAnaquelesDetalle 
    */
  public void actualizarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles DTOE) throws MareException {
      // Se actualiza la entidad APE:OrdenAnaquelesCabecera 
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles DTOE): Entrada");
      
      UtilidadesLog.debug("recibo: " + DTOE);
      
      if (DTOE.getOid()==null){   //es un orden anaquel nuevo 
          DTOE.setOid(this.actualizarOrdenAnaquelesCabecera(DTOE));
      }else{
          //es una modificacion, solo actualizo en: APE_ORDEN_ANAQU_CABEC, el val_defe
          this.actualizarOrdenAnaquelesCabeceraValDefe(DTOE);
      }
      
      DTOOrdenAnaquelesCabecera dtoCabecera = new DTOOrdenAnaquelesCabecera();
      dtoCabecera.setOid(DTOE.getOid());
      
      // Se actualiza la entidad APE:OrdenAnaquelesDetalle 
      
      int detallesMide = DTOE.getDetalles().size();
      DTOOrdenAnaquelesDetalle dtoDetalle = new DTOOrdenAnaquelesDetalle();
      
      //primero borro todos los detalles
      this.remuevoDetalles(dtoCabecera.getOid().longValue());
      for (int i = 0; i < detallesMide; i++) {
          dtoDetalle = (DTOOrdenAnaquelesDetalle)DTOE.getDetalles().get(i);
          dtoDetalle.setOrdenAnaquelCabecera(dtoCabecera);
          this.actualizarOrdenAnaquelesDetalle(dtoDetalle);
      }
      
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles DTOE): Salida");

  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/01/2007
    * @version     1.0
    * @autor       SCS
    * Si no se ha seleccionado previamente una entidad OrdenAnaquelesCabecera la actualiza, 
    * sino crea una nueva entidad OrdenAnaquelesCabecera 
    */
  public Long actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera DTOE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera DTOE): Entrada");
      
      UtilidadesLog.debug("recibo: " + DTOE);
      
      if (DTOE.getOid()==null) {   //es un orden anaquel nuevo 
          //Crear un registro nuevo en la entidad APE:OrdenAnaquelesCabecera: ordenAnaquelCabecera. 
          
          StringBuffer query = new StringBuffer();                        
          Long oidAnaquelCabecera = null;
          RecordSet rs = null;
          query.append(" SELECT APE_OACA_SEQ.NEXTVAL FROM DUAL");                                  
      
          rs = this.executeQuery(query.toString());

      
          if(rs != null && !rs.esVacio()){
              oidAnaquelCabecera = this.bigDecimalToLong(rs.getValueAt(0,0));
              
              long valDef = 0;
              if (DTOE.getValorDefecto().booleanValue()){
                  valDef = 1;
              }else    {
                  valDef = 0; 
              }    
              UtilidadesLog.debug("DTOE.getValorDefecto(): " + DTOE.getValorDefecto());
              UtilidadesLog.debug("DTOE.getMapaZonaCabecera().getOid().longValue(): " + DTOE.getMapaZonaCabecera().getOid().longValue());
              UtilidadesLog.debug("DTOE.getLineaArmado().getOid().longValue(): " + DTOE.getSublineaArmado().getLineaArmado().getOid().longValue());
              UtilidadesLog.debug("valDef: " + valDef);
          
              StringBuffer query1 = new StringBuffer();
              query1.append(" INSERT INTO APE_ORDEN_ANAQU_CABEC (OID_ANAQ_CABE, ");
              query1.append(" COD_MAPA_ORDE, ");
              query1.append(" MZCA_OID_MAPA_ZONA_CABE, ");
              query1.append(" LIAR_OID_LINE_ARMA, ");
              query1.append(" VAL_DEFE ");
              query1.append(" ) VALUES ( " + oidAnaquelCabecera + ", " + ConstantesAPE.COD_MAPA_ORDEN + ", " + DTOE.getMapaZonaCabecera().getOid().longValue());
              query1.append(", " + DTOE.getSublineaArmado().getLineaArmado().getOid().longValue() + ", " + valDef +" )");
              UtilidadesLog.debug("antes de insert....");
              try {
                  BelcorpService bs = UtilidadesEJB.getBelcorpService();
                  bs.dbService.executeUpdate(query1.toString());     
                  
              } catch (DuplicateKeyException ex) {
                  UtilidadesLog.error(ex);
                  ctx.setRollbackOnly();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_CLAVE_DUPLICADA));
              } catch (Exception e){        
                  UtilidadesLog.error("insert APE_ORDEN_ANAQU_CABEC: Exception", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              } 
              UtilidadesLog.debug("luego de insert....(voy por las traducciones)");
              //la i18n, para la descripcion de orden anaqueles ; 
              try{
                  UtilidadesLog.debug("a punto de insertar i18, para APE_ORDEN_ANAQU_CABEC");
                  // Descripcion      
                  int cantDesc = DTOE.getDescripcionOrdenAnaqueles().size();
                  Vector descTrad = DTOE.getDescripcionOrdenAnaqueles();
                  DTOI18nSICC dtoTraduccion = null;
                  Long oidIdioma = null;
                  String descripcion = null;
                  
                  UtilidadesLog.debug("oidAnaquelCabecera: " +oidAnaquelCabecera);
                  Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
            
                  for (int i=0; i < cantDesc; i++){
                      dtoTraduccion = (DTOI18nSICC)descTrad.get(i);
                      oidIdioma = dtoTraduccion.getOidIdioma();
                      descripcion = (String)dtoTraduccion.getValorI18n();
                      
                      UtilidadesLog.debug("descripcion (vector!!) :" + descripcion);
                      
                      e18nLH.create("APE_ORDEN_ANAQU_CABEC", new Long(1), oidIdioma,
                                    descripcion, oidAnaquelCabecera);                                                      
                  }                  
              }catch(PersistenceException e){
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(e);
                  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }              
              
              UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera DTOE): Salida");
              return oidAnaquelCabecera;
          }   
          return oidAnaquelCabecera;
      }else{
          //es una modificacion 
          UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera DTOE): Salida");
          return DTOE.getOid();
      }
  }

  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.executeQuery(String query): Salida");  
    return rs;
  }

  private Long bigDecimalToLong(Object numero) {
      if (numero != null) {
          return new Long(((BigDecimal) numero).longValue());
      } else {
          return null;
      }
  }


    private void remuevoDetalles(long oidAnaqCabe) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.remuevoDetalles(long oidAnaqCabe): Entrada");
      StringBuffer query = new StringBuffer();
      //primero deleteo y luego creo
      query.append("DELETE FROM APE_ORDEN_ANAQU_DETAL WHERE OACA_OID_ANAQ_CABE = " + oidAnaqCabe);
      try {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        bs.dbService.executeUpdate(query.toString());
      } catch (Exception e){        
        UtilidadesLog.error("deleteo APE_ORDEN_ANAQU_DETAL: Exception", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }                
      
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.remuevoDetalles(long oidAnaqCabe): Salida");
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/02/2007
    * @version     1.0
    * @autor       SCS
    * Se actualiza el valor: val_defe, de la tabla: APE_ORDEN_ANAQU_CABEC
    */  
  private void actualizarOrdenAnaquelesCabeceraValDefe(DTOOrdenAnaquelesCabeceraDetalles DTOE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesDetalle DTOE): Entrada");
      StringBuffer query = new StringBuffer();        
      long valDef = 0;
      if (DTOE.getValorDefecto().booleanValue()){
          valDef = 1;
      }else    {
          valDef = 0; 
      }
      query.append("UPDATE APE_ORDEN_ANAQU_CABEC set VAL_DEFE = " + valDef);
      query.append(" WHERE OID_ANAQ_CABE = " + DTOE.getOid().longValue()); 
      try {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
           bs.dbService.executeUpdate(query.toString());        
      } catch (Exception e){        
           UtilidadesLog.error("UPDATE APE_ORDEN_ANAQU_CABEC set VAL_DEFE: Exception", e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }   
      
      
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesDetalle DTOE): Salida");
  }      
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       25/01/2007
    * @version     1.0
    * @autor       SCS
    * Si no se ha seleccionado previamente una entidad OrdenAnaquelesDetalle la actualiza, 
    * sino crea una nueva entidad OrdenAnaquelesDetalle 
    */
  public void actualizarOrdenAnaquelesDetalle(DTOOrdenAnaquelesDetalle DTOE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesDetalle(DTOOrdenAnaquelesDetalle DTOE): Entrada");
      
      UtilidadesLog.debug("getOrdenAnaquelCabecera().getOid(): " + DTOE.getOrdenAnaquelCabecera().getOid());
      
      if (DTOE.getOrdenAnaquelCabecera().getOid()==null) {   //es un orden anaquel nuevo 
          //Crear un registro nuevo en la entidad APE:OrdenAnaquelesDetalle: ordenAnaquelDetalle
          StringBuffer query = new StringBuffer();                        
          Long oidAnaquelDetalle = null;
          RecordSet rs = null;
          query.append(" SELECT APE_OACD_SEQ.NEXTVAL FROM DUAL");                                  
      
          rs = this.executeQuery(query.toString());
      
          if(rs != null && !rs.esVacio()){
              oidAnaquelDetalle = this.bigDecimalToLong(rs.getValueAt(0,0));
                  
              StringBuffer query1 = new StringBuffer();
              query1.append(" INSERT INTO APE_ORDEN_ANAQU_DETAL (OID_ORDE_ANAQ_DETA, ");
              query1.append(" NUM_ORDE, ");
              query1.append(" OACA_OID_ANAQ_CABE, ");
              query1.append(" MCDD_OID_MAPA_CENT_DIST_DETA");
              query1.append(" ) VALUES ( " + oidAnaquelDetalle + ", " + DTOE.getNumeroOrden().longValue());
              //query1.append(", " + DTOE.getOrdenAnaquelCabecera().getOid().longValue() + ", " + DTOE.getNumeroAnaquel() + " )");
              query1.append(", " + DTOE.getOrdenAnaquelCabecera().getOid().longValue() + ", " + DTOE.getOidAnaquel() + " )");
          
              try {
                  BelcorpService bs = UtilidadesEJB.getBelcorpService();
                  bs.dbService.executeUpdate(query1.toString());        
              } catch (Exception e){        
                  UtilidadesLog.error("insert APE_ORDEN_ANAQU_DETAL: Exception", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }   
          }   
      }else{
          StringBuffer query = new StringBuffer();                        
          Long oidAnaquelDetalle = null;
          RecordSet rs = null;
          query.append(" SELECT APE_OACD_SEQ.NEXTVAL FROM DUAL");                                  
      
          rs = this.executeQuery(query.toString());
      
          if(rs != null && !rs.esVacio()){
              oidAnaquelDetalle = this.bigDecimalToLong(rs.getValueAt(0,0));
              
              StringBuffer query1 = new StringBuffer();
              query1.append(" INSERT INTO APE_ORDEN_ANAQU_DETAL (OID_ORDE_ANAQ_DETA, ");
              query1.append(" NUM_ORDE, ");
              query1.append(" OACA_OID_ANAQ_CABE, ");
              //query1.append(" NUM_ANAQ ");
              query1.append(" MCDD_OID_MAPA_CENT_DIST_DETA");
              query1.append(" ) VALUES ( " + oidAnaquelDetalle + ", " + DTOE.getNumeroOrden().longValue());
              //query1.append(", " + DTOE.getOrdenAnaquelCabecera().getOid().longValue() + ", " + DTOE.getNumeroAnaquel() + " )");
              query1.append(", " + DTOE.getOrdenAnaquelCabecera().getOid().longValue() + ", " + DTOE.getOidAnaquel() + " )");
          
              try {
                  BelcorpService bs = UtilidadesEJB.getBelcorpService();
                  bs.dbService.executeUpdate(query1.toString());        
              } catch (Exception e){        
                  UtilidadesLog.error("insert APE_ORDEN_ANAQU_DETAL: Exception", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }   
          } 
      }
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.actualizarOrdenAnaquelesDetalle(DTOOrdenAnaquelesDetalle DTOE): Salida");
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       SCS
    * Obtiene los datos de la entidad OrdenAnaquelesCabecera y OrdenAnaquelesDetalle cuya UK se recibe como parametro de entrada 
    */
  public DTOOrdenAnaquelesCabeceraDetalles obtenerOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabecera dtoE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabecera dtoE): Entrada");
      
      UtilidadesLog.debug("DTOOrdenAnaquelesCabecera: " + dtoE);
    
      DAOMantenimientoOrdenAnaqueles daoMOA = new DAOMantenimientoOrdenAnaqueles();
      
      DTOOrdenAnaquelesCabecera dtoEresu = new DTOOrdenAnaquelesCabecera();
      dtoEresu = daoMOA.obtenerOrdenAnaquelesCabecera(dtoE);
      DTOOrdenAnaquelesCabeceraDetalles dtoCabDet = new DTOOrdenAnaquelesCabeceraDetalles();
      
      dtoCabDet.setOid(dtoEresu.getOid());
      dtoCabDet.setCodigoMapaOrden(dtoEresu.getCodigoMapaOrden());
      dtoCabDet.setDescOrdenAnaqueles(dtoEresu.getDescOrdenAnaqueles());
      dtoCabDet.setMapaZonaCabecera(dtoEresu.getMapaZonaCabecera());
      dtoCabDet.setSublineaArmado(dtoEresu.getSublineaArmado());
      dtoCabDet.setValorDefecto(dtoEresu.getValorDefecto());
  
      dtoCabDet.setDetalles(daoMOA.obtenerOrdenAnaquelesDetalles(dtoEresu)); 
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabecera dtoE): Salida");    
      
      UtilidadesLog.debug("valor x def: " + dtoCabDet.getValorDefecto());
      UtilidadesLog.debug("dtoCabDet: " + dtoCabDet);
      
      return dtoCabDet;
   
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       SCS
    * Recupera los números de anaqueles a ordenar 
    */
  public DTOSalida obtenerMapasOrdenPorMapaZonas(DTOOID dtoE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerMapasOrdenPorMapaZonas(DTOOID dtoE): Entrada");
      DTOSalida dtoSalida = new DAOMantenimientoOrdenAnaqueles().obtenerMapasOrdenPorMapaZonas(dtoE);
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerMapasOrdenPorMapaZonas(DTOOID dtoE): Salida");
      return dtoSalida;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       SCS
    * Elimina los datos de las entidades OrdenAnaquelesCabecera y OrdenAnaquelesDetalle 
    */
  public void eliminarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles dtoE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.eliminarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles dtoE): Entrada");
      
      DAOMantenimientoOrdenAnaqueles daoMOA = new DAOMantenimientoOrdenAnaqueles();
      UtilidadesLog.debug("a punto de eliminar cabecera/detalles para oid: " + dtoE.getOid().longValue());
      daoMOA.eliminarOrdenAnaquelesDetalles(dtoE.getOid());
      daoMOA.eliminarOrdenAnaquelesCabecera(dtoE.getOid());
      //traducciones
      this.eliminoTraduccionesAnaqueles(dtoE.getOid());
      
      
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.eliminarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles dtoE): Salida");
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       SCS
    * Recupera el Orden de Anaqueles por default para para el MapaZonas que se recibe por parámetro. 
    */
  public DTOOrdenAnaquelesCabecera obtenerDefaultOrdenAnaqueles(DTOOID dtoE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerDefaultOrdenAnaqueles(DTOOID dtoE): Entrada");
      DAOMantenimientoOrdenAnaqueles daoMOA = new DAOMantenimientoOrdenAnaqueles();
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerDefaultOrdenAnaqueles(DTOOID dtoE): Salida");
      return daoMOA.obtenerDefaultOrdenAnaqueles(dtoE);
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       23/01/2007
    * @version     1.0actualizarOrdenAnaquelesDetalle 
    * @autor       Viviana Bongiovanni
    */
  public void copiarOrdenAnaqueles(DTOCopiaOrdenAnaqueles dtoe) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaqueles.copiarOrdenAnaqueles(DTOCopiaOrdenAnaqueles dtoe): Entrada");
      UtilidadesLog.debug("dtoe: " + dtoe);
      
      try {
          DAOMantenimientoOrdenAnaqueles daoMantenimientoOrdenAnaqueles = new DAOMantenimientoOrdenAnaqueles();
          
          DTOOrdenAnaquelesCabecera dtoOrdenAnaquelesCabeceraAux = 
                               daoMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesCabecera(dtoe.getOrdenAnaquelOrigen());
          
          dtoe.getOrdenAnaquelDestino().setSublineaArmado(dtoOrdenAnaquelesCabeceraAux.getSublineaArmado());                                         
          
          Long oidAnaquelDestino = this.actualizarOrdenAnaquelesCabecera(dtoe.getOrdenAnaquelDestino());
          dtoe.getOrdenAnaquelDestino().setOid(oidAnaquelDestino);
          
          UtilidadesLog.debug("oidAnaquelDestino: " + oidAnaquelDestino);
      
          ArrayList detalles = daoMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesDetalles(dtoe.getOrdenAnaquelOrigen()); 
          
          UtilidadesLog.debug("detalles: " + detalles);
          
          int cant = detalles.size();
          DTOOrdenAnaquelesDetalle dtoDetalle = null;
          
          for(int i=0; i<cant; i++){
              dtoDetalle = (DTOOrdenAnaquelesDetalle)detalles.get(i);
              dtoDetalle.setOid(null);
              dtoDetalle.setOrdenAnaquelCabecera(dtoe.getOrdenAnaquelDestino());
              
              this.actualizarOrdenAnaquelesDetalle(dtoDetalle);
          }
        
          UtilidadesLog.info("MONMantenimientoOrdenAnaqueles.copiarOrdenAnaqueles(DTOCopiaOrdenAnaqueles dtoe): Salida");
          
      }  catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
    } 
  }
  
  private void eliminoTraduccionesAnaqueles(Long oidAnaqCabe) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.eliminoTraduccionesAnaqueles(Long oidAnaqCabe): Entrada");
      //elimino traducciones
      UtilidadesLog.debug("a punto de eliminar i18, para APE_ORDEN_ANAQU_CABEC");
      try {
          Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
          Collection col = e18nLH.findByEntAtrPK("APE_ORDEN_ANAQU_CABEC", new Long(1), oidAnaqCabe);
          Iterator it = col.iterator();
          Entidadi18nLocal entidadi18n = null;
          try {
              while (it.hasNext()){
                  entidadi18n = (Entidadi18nLocal)it.next();
                  UtilidadesLog.debug("borrando entidadi18n: " + entidadi18n.getDetalle());         
                  e18nLH.remove(entidadi18n);       
              }
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      }   catch (NoResultException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }   catch (PersistenceException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.eliminoTraduccionesAnaqueles(Long oidAnaqCabe): Salida");
  }

    /**
     * Carga de combo con Anaqueles para Ordenar
     * @autor eiraola
     * @since 27/Jun/2007
     */
  public DTOSalida obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE) throws MareException {
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE): Entrada");
      DTOSalida dtoSalida = new DAOMantenimientoOrdenAnaqueles().obtenerNumerosAnaquelesAOrdenar(dtoE);
      UtilidadesLog.info("MONMantenimientoOrdenAnaquelesBean.obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE): Salida");
      return dtoSalida;
  }
  
}