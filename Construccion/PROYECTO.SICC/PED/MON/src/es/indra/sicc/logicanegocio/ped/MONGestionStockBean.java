package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.sicc.dtos.ped.DTOListaGestionStock;
import es.indra.sicc.entidades.ped.GestionStockLocal;
import es.indra.sicc.entidades.ped.GestionStockLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import java.math.BigDecimal;
import es.indra.sicc.util.*;

import java.util.Vector;
import java.util.Enumeration;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGestionStockBean implements SessionBean {

  //Parametros auditoria
  String ipCliente;
  String programa;
  Long oidIdioma;
  Long oidPais;


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
		this.ctx = ctx;
  }


  public void inserta(Long periodo, DTOGestionStock dto, int id) throws MareException {
    try{
        UtilidadesLog.info("MONGestionStockBean.inserta(Long periodo, DTOGestionStock dto, int id): Entrada ");
      GestionStockLocalHome gestionStockLH = null;
      GestionStockLocal gestionStock = null;
      try{
        gestionStockLH = new GestionStockLocalHome();

        UtilidadesLog.debug("peridodo= "+ periodo + "codVenta= "+ dto.getCodigoVenta() );
        gestionStock = gestionStockLH.create( periodo, new Integer(id), dto.getCodigoVenta() );

        gestionStock.setClasificacion( dto.getClasificacion() );
        gestionStock.setControlLiquidacion( dto.getControlLiquidacion() );
        gestionStock.setIndUltNoticias( dto.getIndUltNoticias() );
        gestionStock.setLimiteVenta( dto.getLimiteVenta() );
        gestionStock.setRegion( dto.getRegion() );
        gestionStock.setSubtipoCliente( dto.getSubtipoCliente() );
        gestionStock.setTipoClasificacion( dto.getTipoClasificacion() );
        gestionStock.setTipoCliente( dto.getTipoCliente() );
        gestionStock.setValorPorcentual( dto.getValorPorcentual() );
        gestionStock.setValorUnidades( dto.getValorUnidades() );
        gestionStock.setZona( dto.getZona() );
        
        gestionStockLH.merge(gestionStock);
      
      } catch(PersistenceException pe){
        throw new MareException(pe, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
    } catch( MareException me ){
      ctx.setRollbackOnly();
      throw me;
    }
        UtilidadesLog.info("MONGestionStockBean.inserta(Long periodo, DTOGestionStock dto, int id): Salida ");
  }


  public void modifica(DTOGestionStock dto, int id) throws MareException {
    try{
      UtilidadesLog.info("MONGestionStockBean.modifica(DTOGestionStock dto, int id): Entrada ");
      GestionStockLocalHome gestionStockLH = null;
      GestionStockLocal gestionStock = null;
      try{
        gestionStockLH = new GestionStockLocalHome();

        gestionStock = gestionStockLH.findByPrimaryKey( dto.getOid() );

        //La sgte. linea se comenta de acuerdo a las inc.: 10331 y 10699, teniendo en cuenta que
        //como este campo se actualiza con el rowID, de la tabla no es necesario setearle nada
        //dado que en el create del registro este campo ya tiene valor........
        //gestionStock.setId( new Integer(id) );
        
        gestionStock.setRegion( dto.getRegion() );
        gestionStock.setZona( dto.getZona() );
        gestionStock.setTipoCliente( dto.getTipoCliente() );
        gestionStock.setSubtipoCliente( dto.getSubtipoCliente() );
        gestionStock.setTipoClasificacion( dto.getTipoClasificacion() );
        gestionStock.setClasificacion( dto.getClasificacion() );
        gestionStock.setLimiteVenta( dto.getLimiteVenta() );
        gestionStock.setValorUnidades( dto.getValorUnidades() );
        gestionStock.setValorPorcentual( dto.getValorPorcentual() );
        gestionStock.setControlLiquidacion( dto.getControlLiquidacion() );
        gestionStock.setIndUltNoticias( dto.getIndUltNoticias() );
        gestionStock.setCodigoVenta( dto.getCodigoVenta() );
        
        try {
            gestionStockLH.merge(gestionStock);
        } catch (PersistenceException pe) {
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
      } catch(NoResultException nre){
        throw new MareException(nre, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch(PersistenceException pe){
        UtilidadesLog.error("Exception: ",pe);
        throw new MareException(pe, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      } 
    } catch( MareException me ){
      ctx.setRollbackOnly();
      throw me;
    }
      UtilidadesLog.info("MONGestionStockBean.modifica(DTOGestionStock dto, int id): Salida ");
  }


  public void guarda(DTOListaGestionStock dto) throws MareException {
        UtilidadesLog.info("MONGestionStockBean.guarda(DTOListaGestionStock dto): Entrada ");
  
    //DTOGestionStock[] aDTOGestionStock = null;
    Vector vGestionStock = null;
    Enumeration eGestionStock = null;
    DTOGestionStock dtoGS = null;
    int i = 0;
    
    if( dto != null && dto.getDetalles() != null ){

      //parametros auditoria
      ipCliente = dto.getIpCliente();
      programa = dto.getPrograma();
      oidIdioma = dto.getOidIdioma();
      oidPais = dto.getOidPais();

      vGestionStock = dto.getDetalles();
      if( vGestionStock != null ){
        eGestionStock = vGestionStock.elements();
      }

      while( eGestionStock != null && eGestionStock.hasMoreElements() ){
        dtoGS = (DTOGestionStock)eGestionStock.nextElement();

        /*
        if( dtoGS != null && dtoGS.getOid() != null && dtoGS.getIndEliminar() != null && 
            dtoGS.getIndEliminar().booleanValue() ){
          elimina( dtoGS.getOid() );
        } else if( dtoGS.getOid() != null ){
          modifica( dtoGS, i );
        } else{
          inserta( dto.getPeriodo(), dtoGS, i );
        }
        */

        if( dtoGS != null && dtoGS.getOid() != null && dtoGS.getOid().longValue() > 0 && 
        dtoGS.getIndEliminar() != null && dtoGS.getIndEliminar().booleanValue() ){
          elimina( dtoGS.getOid() );
        } else if( dtoGS != null && dtoGS.getOid() != null && dtoGS.getOid().longValue() > 0 ){
            //ENTRA AQUI SOLO EN CASO DE MODIFICAR
            // ES DECIR TIENE VALOR DE OID
            //DAOGestionStock dao = new DAOGestionStock();
            //SI ES QUE ES MODIFICAR, SOLO DEBE DE MODIFICAR SI VALIDAR SI ES KE EXISTE
            //LOS VALORES DE AMBITO GEOGRAFICO Y DE CLASIF DE CLIENTE ESTARAN DESHABILITADOS 
            //PARA QUE NO PERMITA REPETIR EL VALOR DE ESE REGISTRO
            
            /*RecordSet rs = dao.existeEnListaGestionStock( dto.getPeriodo(), dtoGS );
            if ( rs.esVacio() ) {
                inserta( dto.getPeriodo(), dtoGS, i );
            }else{*/
            modifica( dtoGS, i );
            //}
        } else if( dtoGS.getIndEliminar() == null || !dtoGS.getIndEliminar().booleanValue() ){
            // ENTRA AQUI SOLO EN CASO DE INSERTAR
            //  Agregado para validar si ya existe el codigo de venta antes de insertar
            DAOGestionStock dao = new DAOGestionStock();
            
            RecordSet rs = dao.existeEnListaGestionStock( dto.getPeriodo(), dtoGS );
            if ( rs.esVacio() ) {
                inserta( dto.getPeriodo(), dtoGS, i );
            }
            //  Si ya existe el codigo de venta entonces actualizar...
            else    {
                dtoGS.setOid( new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue() ) );
                modifica( dtoGS, i );
            }
        }
        
        i++;
      }

/*
      for( int i = 0; i < aDTOGestionStock.length; i++ ){
        if( aDTOGestionStock[i] != null && aDTOGestionStock[i].getOid() != null && 
            aDTOGestionStock[i].getIndEliminar() != null && 
            aDTOGestionStock[i].getIndEliminar().booleanValue() ){
          elimina( aDTOGestionStock[i].getOid() );
          
        } else if( aDTOGestionStock[i].getOid() != null ) {
          modifica( aDTOGestionStock[i], i );
        } else {
          inserta( dto.getPeriodo(), aDTOGestionStock[i], i );
        }
      }
*/
      
    }
    UtilidadesLog.info("MONGestionStockBean.guarda(DTOListaGestionStock dto): Salida ");
  }


  public void elimina(Long oid) throws MareException {
    try{
      UtilidadesLog.info("MONGestionStockBean.elimina(Long oid): Entrada ");
      GestionStockLocalHome gestionStockLH = null;
      GestionStockLocal gestionStock = null;
      try{
        gestionStockLH = new GestionStockLocalHome();

        //Se crea un DTOAuditableSICC para pasar a Parametros Auditoria
        //debido a no llega ninguno como parametro.
        DTOAuditableSICC dtoAS = new DTOAuditableSICC();
        dtoAS.setIpCliente( ipCliente );
        dtoAS.setOidIdioma( oidIdioma );
        dtoAS.setOidPais( oidPais );
        dtoAS.setPrograma( programa );

        gestionStock = gestionStockLH.findByPrimaryKey( oid );
        
        try {
            gestionStockLH.remove(gestionStock);
        } catch (PersistenceException pe) {
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
      } catch(NoResultException nre){
        throw new MareException(nre, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch(PersistenceException pe){
        throw new MareException(pe, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
    } catch( MareException me ){
      ctx.setRollbackOnly();
      throw me;
    }
      UtilidadesLog.info("MONGestionStockBean.elimina(Long oid): Salida ");
  }


  public DTOListaGestionStock consulta(DTOListaGestionStock dto) throws MareException {
    UtilidadesLog.info("MONGestionStockBean.consulta(DTOListaGestionStock dto): Entrada ");
    DAOGestionStock dao = new DAOGestionStock();
    RecordSet rs = dao.obtieneGestionStock(dto);
        

      /*if( rs != null && !rs.esVacio() ){
      //DTOGestionStock[] dtoGS = new DTOGestionStock[rs.getRowCount()];

      Vector vGestionStock = new Vector();
      DTOGestionStock dtoGS = null;
        
      UtilidadesLog.debug("rs.toString(): " + rs.toString());

      /*for( int i = 0; i < rs.getRowCount(); i++ ){

      //UtilidadesLog.debug( "dtoGS["+i+"]: " + dtoGS[i] );

        dtoGS = new DTOGestionStock();
      
        dtoGS.setOid( (rs.getValueAt( i, "OID" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OID" )).toString())) );
        dtoGS.setCodigoVenta( (rs.getValueAt( i, "OIDCODIGOVENTA" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDCODIGOVENTA" )).toString())) );
        dtoGS.setTxtCodigoVenta( (String)rs.getValueAt( i, "CODIGOVENTA" ) );
        dtoGS.setTxtCatalogo( rs.getValueAt( i, "CATALOGO" )==null?null:(((BigDecimal)rs.getValueAt( i, "CATALOGO" )).toString()));
        dtoGS.setNumPagina( (rs.getValueAt( i, "NUMPAGINA" )==null?null:new Integer(((BigDecimal)rs.getValueAt( i, "NUMPAGINA" )).toString())) );//integer
        dtoGS.setRegion( (rs.getValueAt( i, "OIDREGION" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDREGION" )).toString())) );
        dtoGS.setTxtRegion( (String)rs.getValueAt( i, "REGION" ) );
        dtoGS.setZona( (rs.getValueAt( i, "OIDZONA" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDZONA" )).toString())) );
        dtoGS.setTxtZona( (String)rs.getValueAt( i, "ZONA" ) );
        dtoGS.setTipoCliente( (rs.getValueAt( i, "OIDTIPOCLIENTE" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDTIPOCLIENTE" )).toString())) );
        dtoGS.setTxtTipoCliente( (String)rs.getValueAt( i, "TIPOCLIENTE" ) );
        dtoGS.setSubtipoCliente( (rs.getValueAt( i, "OIDSUBTIPOCLIENTE" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDSUBTIPOCLIENTE" )).toString())) );
        dtoGS.setTxtSubtipoCliente( (String)rs.getValueAt( i, "SUBTIPOCLIENTE" ) );
        dtoGS.setTipoClasificacion( (rs.getValueAt( i, "OIDTIPOCLASIFICACION" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDTIPOCLASIFICACION" )).toString())) );
        dtoGS.setTxtTipoClasificacion( (String)rs.getValueAt( i, "TIPOCLASIFICACION" ) );
        dtoGS.setClasificacion( (rs.getValueAt( i, "OIDCLASIFICACION" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "OIDCLASIFICACION" )).toString())) );
        dtoGS.setTxtClasificacion( (String)rs.getValueAt( i, "CLASIFICACION" ) );
        dtoGS.setLimiteVenta( (rs.getValueAt( i, "LIMITEVENTA" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "LIMITEVENTA" )).toString())) );
        dtoGS.setValorUnidades( (rs.getValueAt( i, "CONTROLSTOCK" )==null?null:new Long(((BigDecimal)rs.getValueAt( i, "CONTROLSTOCK" )).toString())) );
        dtoGS.setValorPorcentual( (rs.getValueAt( i, "CONTROLSOCKPORCENTUAL" )==null?null:new Double(((BigDecimal)rs.getValueAt( i, "CONTROLSOCKPORCENTUAL" )).toString())) );//Double

        BigDecimal bControlLiquidacion = (BigDecimal)rs.getValueAt( i, "CONTROLLIQUIDACION" );
        dtoGS.setControlLiquidacion( (bControlLiquidacion==null?null:numberToBoolean(bControlLiquidacion.intValue())) );//Boolean

        BigDecimal bIndUltNoticias = (BigDecimal)rs.getValueAt( i, "ULTIMASNOTICIAS" );
        dtoGS.setIndUltNoticias( (bIndUltNoticias==null?null:numberToBoolean(bIndUltNoticias.intValue())) );

        vGestionStock.add( dtoGS );
      }
      dto.setDetalles( vGestionStock );
    }*/
    dto.setResultado(rs);
    if ((rs == null) || rs.esVacio()) {
            //UtilidadesLog.debug("Tirando mare exception");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    UtilidadesLog.info("MONGestionStockBean.consulta(DTOListaGestionStock dto): Salida ");
    return dto;
  }

  private Boolean numberToBoolean( int n ){
    if( n == 1 ){
      return Boolean.TRUE;
    }else if(n == 0){
      return Boolean.FALSE;
    }
    return null;
  }


}


