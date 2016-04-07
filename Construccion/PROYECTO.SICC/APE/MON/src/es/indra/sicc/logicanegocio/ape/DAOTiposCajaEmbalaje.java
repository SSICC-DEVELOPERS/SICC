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
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOTiposCajaEmbalaje;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.ejb.DuplicateKeyException;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOTiposCajaEmbalaje {

    /**
     * Obtiene las entidades TiposCajaEmbalaje que coincidan con los parámetros de la búsqueda 
     * @author hhernandez
     * @since 20-02-2007
     */
    public DTOSalida buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE) throws MareException {
        UtilidadesLog.info("DAOTiposCajaEmbalaje.buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("		SELECT ");
        query.append("      lineaTipoCaja.OID_LINE_TIPO_CAJA_EMBA oid, ");
        query.append("		  tipoCaja.OID_TIPO_CAJA_EMBA,");
        query.append("		  (SELECT inter.val_i18n ");
        query.append("			   FROM v_gen_i18n_sicc inter ");
        query.append("			  WHERE inter.attr_enti = 'APP_CONFI_CENTR_DISTR' ");
        query.append("				AND inter.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("				AND inter.val_oid = linea.CCDI_OID_CONF_CENT_DIST");
        query.append("				) as ConfCentDistribucion,");
        query.append("		  tipoCaja.VAL_TIPO_CAJA,");
        query.append("		  (interTipoCaja.val_i18n");
        /*query.append("		  (SELECT inter.val_i18n ");
        query.append("			   FROM v_gen_i18n_sicc inter ");
        query.append("			  WHERE inter.attr_enti = 'APE_TIPO_CAJA_EMBAL' ");
        query.append("				AND inter.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("				AND inter.val_oid = tipoCaja.OID_TIPO_CAJA_EMBA");
        if (dtoE.getDescripcion() != null) {
            query.append("    AND inter.val_i18n like '");
            query.append(dtoE.getDescripcion() + "'");//--DTOE.descripcion
        }*/
        query.append("       ) as TiposCajaEmbalaje, ");
        query.append("		  (SELECT inter.val_i18n ");
        query.append("			   FROM v_gen_i18n_sicc inter ");
        query.append("			  WHERE inter.attr_enti = 'APE_LINEA_ARMAD' ");
        query.append("				AND inter.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("				AND inter.val_oid = linea.OID_LINE_ARMA");
        query.append("			) AS LineaArmado,");
        query.append("			tipoCaja.NUM_CAPA,");
        query.append("			(SELECT inter.val_i18n ");
        query.append("			   FROM v_gen_i18n_sicc inter ");
        query.append("			  WHERE inter.attr_enti = 'MAE_UNIDA_MEDID' ");
        query.append("				AND inter.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("				AND inter.val_oid = tipoCaja.UNMD_OID_UNID_MEDI_CAPA");
        query.append("			) AS UnidadesMedida,	");
        query.append("			tipoCaja.IND_CUBI		");
        query.append("		FROM APE_TIPO_CAJA_EMBAL tipoCaja, APE_LINEA_TIPO_CAJA_EMBAL lineaTipoCaja, APE_LINEA_ARMAD linea, v_gen_i18n_sicc interTipoCaja");
        query.append("		WHERE");
        query.append("				linea.OID_LINE_ARMA = lineaTipoCaja.LIAR_OID_LINE_ARMA");
        query.append("				AND lineaTipoCaja.TCEM_OID_TIPO_CAJA_EMBA = tipoCaja.OID_TIPO_CAJA_EMBA");
        
        query.append("				AND interTipoCaja.attr_enti = 'APE_TIPO_CAJA_EMBAL' ");
        query.append("				AND interTipoCaja.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        query.append("				AND interTipoCaja.val_oid = tipoCaja.OID_TIPO_CAJA_EMBA");
        
        if (dtoE.getDescripcion() != null) {
            query.append("    AND interTipoCaja.val_i18n like '");
            query.append(dtoE.getDescripcion() + "'");//--DTOE.descripcion
        }
                
        if (dtoE.getLineaArmadoConsultada() != null) {
            query.append("    AND linea.OID_LINE_ARMA = ");
            query.append(dtoE.getLineaArmadoConsultada());
        }
        
        if (dtoE.getTipoCaja() != null) {
            query.append("    AND tipoCaja.VAL_TIPO_CAJA = '");
            query.append(dtoE.getTipoCaja() + "'");
        }
        
        if (dtoE.getCentroDistribucion() != null) {
            query.append("    AND linea.CCDI_OID_CONF_CENT_DIST = ");
            query.append(dtoE.getCentroDistribucion());
        }        
        //query.append("				AND linea.OID_LINE_ARMA = 1 --DTOE.lineaArmadoConsultada");
        //query.append("				AND tipoCaja.VAL_TIPO_CAJA = 1 --DTOE.tipoCaja AND		");
        //query.append("				AND linea.CCDI_OID_CONF_CENT_DIST = 1 --DTOE.centroDistribucion");
        String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoE);
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(sql);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if (rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOTiposCajaEmbalaje.buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE): Salida");
        return dtoSalida;
    }
    
    /**
     * Obtiene la entidad TiposCajaEmbalaje previamente seleccionada 
     * @author hhernandez
     * @since 20-02-2007
     */    
    public DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje (DTOOID dtoe) throws MareException{
      UtilidadesLog.debug("DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje (DTOOID dtoe): Entrada");
      
      StringBuffer query = new StringBuffer();
  
      query.append("		SELECT");
      query.append("		  tipoCaja.OID_TIPO_CAJA_EMBA oid,");
      query.append("		  tipoCaja.VAL_TIPO_CAJA as tipoCaja,");
      query.append("		  (SELECT inter.val_i18n ");
      query.append("			   FROM v_gen_i18n_sicc inter ");
      query.append("			  WHERE inter.attr_enti = 'APE_TIPO_CAJA_EMBAL' ");
      query.append("				AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
      query.append("				AND inter.val_oid = tipoCaja.OID_TIPO_CAJA_EMBA");
      query.append("				) AS descTipoCaja, ");//--DTOE.descripcion
      query.append("			tipoCaja.UNMD_OID_UNID_MEDI_CAPA as unidadMedidaCapacidad ,");
      query.append("			tipoCaja.NUM_CAPA as capacidad ,			  ");
      query.append("			tipoCaja.NUM_CAPA_MINI as capacidadMinima,");
      query.append("			tipoCaja.IND_CUBI as indicadorCubicaje,");
      query.append("			tipoCaja.NUM_PORC_SEGU as porcentajeSeguridad,");
      query.append("			tipoCaja.NUM_NIVE_APLI as nivelAplicacion,");
      query.append("			tipoCaja.NUM_ETIQ as numeroEtiquetas,  ");
      query.append("			tipoCaja.PAIS_OID_PAIS  as pais,  ");
      query.append("			tipoCaja.VAL_ALTO   as alto,  ");
      query.append("			tipoCaja.VAL_LARG  as largo,  ");
      query.append("			tipoCaja.VAL_ANCH   as ancho,  ");
      query.append("      tipocaja.UNMD_OID_UNID_MEDI_EXTE  as UNIDADMEDIDAEXTERIOR");
      query.append("		FROM APE_TIPO_CAJA_EMBAL tipoCaja");
      query.append("		WHERE");
      query.append("				tipoCaja.OID_TIPO_CAJA_EMBA = "+dtoe.getOid()+" ");
  
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
        UtilidadesLog.error("DAOFactoresConversion.obtenerTiposCajaEmbalaje(DTOOID dtoe): Exception",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      if (rs.esVacio()) {
        UtilidadesLog.debug("DAOFactoresConversion.obtenerTiposCajaEmbalaje(DTOOID dtoe): no hay datos ");				
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      UtilidadesLog.debug("DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje (DTOOID dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
      DTOTiposCajaEmbalaje dtoTiposCajaEmbalaje = new DTOTiposCajaEmbalaje();
      UtilidadesLog.debug("dtoTiposCajaEmbalaje:" + dtoTiposCajaEmbalaje );
      UtilidadesLog.debug("rs.esVacio():" + rs.esVacio() );
      
      try{
        if (!rs.esVacio()) 
        {
          UtilidadesLog.debug("asigna setOid" );
          BigDecimal bd = (BigDecimal)rs.getValueAt(0, "OID");
          dtoTiposCajaEmbalaje.setOid(new Long(bd.longValue()));
          dtoTiposCajaEmbalaje.setTipoCaja(rs.getValueAt(0, "TIPOCAJA").toString());
          dtoTiposCajaEmbalaje.setDescripcion(rs.getValueAt(0, "DESCTIPOCAJA").toString()); 
          dtoTiposCajaEmbalaje.setOidUnidadMedidaCapacidad(new Long((((BigDecimal)rs.getValueAt(0,"UNIDADMEDIDACAPACIDAD"))).longValue()));
          dtoTiposCajaEmbalaje.setCapacidad((((BigDecimal)rs.getValueAt(0,"CAPACIDAD"))));
          dtoTiposCajaEmbalaje.setCapacidadMinima((((BigDecimal)rs.getValueAt(0,"CAPACIDADMINIMA"))));
          
          UtilidadesLog.debug("rs.getValueAt(0,indicadorCubicaje):" + rs.getValueAt(0,"INDICADORCUBICAJE"));
          dtoTiposCajaEmbalaje.setIndicadorCubicaje(rs.getValueAt(0,"INDICADORCUBICAJE").equals("1") ? Boolean.TRUE: Boolean.FALSE);
          
          dtoTiposCajaEmbalaje.setPorcentajeSeguridad((((BigDecimal)rs.getValueAt(0,"PORCENTAJESEGURIDAD"))));
          dtoTiposCajaEmbalaje.setNivelAplicacion((((BigDecimal)rs.getValueAt(0,"NIVELAPLICACION")))); 
          dtoTiposCajaEmbalaje.setNumeroEtiquetas(new Long((((BigDecimal)rs.getValueAt(0,"NUMEROETIQUETAS"))).longValue()));
          dtoTiposCajaEmbalaje.setOidUnidadMedidaExterior(new Long((((BigDecimal)rs.getValueAt(0,"UNIDADMEDIDAEXTERIOR"))).longValue()));
          dtoTiposCajaEmbalaje.setAlto((((BigDecimal)rs.getValueAt(0,"ALTO"))));
          dtoTiposCajaEmbalaje.setAncho((((BigDecimal)rs.getValueAt(0,"ANCHO"))));
          dtoTiposCajaEmbalaje.setLargo((((BigDecimal)rs.getValueAt(0,"LARGO"))));
          dtoTiposCajaEmbalaje.setOidPais(new Long((((BigDecimal)rs.getValueAt(0,"PAIS"))).longValue()));
          UtilidadesLog.debug("asigna setOidPais" );
        }
      }
      catch(Exception e) {
        UtilidadesLog.error("DAOFactoresConversion.obtenerTiposCajaEmbalaje(DTOOID dtoe): Exception",e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
      }
      UtilidadesLog.info("DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje (DTOOID dtoe): Salida");
      return dtoTiposCajaEmbalaje;
  }
    
    
    /**
     * Obtiene los datos de las entidades LineasTipoCajaEmbalaje asociadas a la entidad TiposCajaEmbalaje previamente seleccionada 
     * @author hhernandez
     * @since 20-02-2007
     */
    public DTOOIDs obtenerLineasTipoCajaEmbalaje (DTOOID dtoE) throws MareException {
        UtilidadesLog.info("obtenerLineasTipoCajaEmbalaje (DTOOID dtoE): Entrada");
        DTOOIDs dtoOids = new DTOOIDs();
        
        StringBuffer query = new StringBuffer();
        query.append("		SELECT");
        query.append("		  lineaTipoCaja.LIAR_OID_LINE_ARMA ");
        query.append("		FROM APE_LINEA_TIPO_CAJA_EMBAL lineaTipoCaja ");
        query.append("		WHERE");
        query.append("				lineaTipoCaja.TCEM_OID_TIPO_CAJA_EMBA  = "+dtoE.getOid()+" ");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
          rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
          UtilidadesLog.error("DAOFactoresConversion.obtenerLineasTipoCajaEmbalaje(DTOOID dtoe): Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if (!rs.esVacio()) {
          UtilidadesLog.debug("DTOTiposCajaEmbalaje obtenerLineasTipoCajaEmbalaje (DTOOID dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
          int tamLineas= rs.getRowCount();
          Long[] oidsLineas = new Long[tamLineas];
          for (int i = 0; i < tamLineas; i++) {
            oidsLineas[i] = new Long((((BigDecimal)rs.getValueAt(i,"LIAR_OID_LINE_ARMA"))).longValue());
            UtilidadesLog.debug("oidsLineas[" + i + "]:" + oidsLineas[i]);
          }
          // Armo el DTOOIDs
          dtoOids.setOids(oidsLineas);          
        }
        else{
          UtilidadesLog.debug("DAOFactoresConversion.obtenerLineasTipoCajaEmbalaje(DTOOID dtoe): no hay datos ");				
          //throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DTOTiposCajaEmbalaje obtenerLineasTipoCajaEmbalaje (DTOOID dtoe): Salida");
        return dtoOids;
    }
    
    /**
     * Se eliminan las entidades TiposCajaEmbalaje cuyos oids se reciben como parametros de entrada
     * @author hhernandez
     * @since 21-02-2007
     */
    public void eliminarTiposCajaEmbalaje(DTOOIDs dtoE) throws MareException{
      UtilidadesLog.debug("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): Entrada");
      StringBuffer query = new StringBuffer();
      Long[] oids = dtoE.getOids();
      if(oids.length>0){ // Si hay OIDs en el DTO
        // Se extraen los OIDs del DTO
        StringBuffer sOids = new StringBuffer();
        for(int i=0;i<oids.length;i++){
          sOids.append(oids[i]+",");
        }
        // Se completa la instruccion SQL
        //1ro:Eliminar registros APE:LineasTipoCajaEmbalaje, campo tipoCajaEmbalaje = sOids
        query.append("  BEGIN ");
        query.append("DELETE FROM APE_LINEA_TIPO_CAJA_EMBAL ");
        query.append("      WHERE TCEM_OID_TIPO_CAJA_EMBA IN ("+sOids.substring(0,sOids.length()-1)+"); ");
        //2do:Eliminar registros de APE:TiposCajaEmbalaje, oid  = sOids
        query.append("DELETE FROM APE_TIPO_CAJA_EMBAL ");
        query.append("      WHERE OID_TIPO_CAJA_EMBA IN ("+sOids.substring(0,sOids.length()-1)+"); ");
        query.append("  END; ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          int reg = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE):: Se han eliminado ["+reg+"] registros");
        } catch (SQLException se) {
            UtilidadesLog.error("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): SQLException", se);
            throw new MareException(se, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));  
        } catch (Exception e) {
          UtilidadesLog.error("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
      }else{
        UtilidadesLog.debug("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): No hay OIDs en el DTO, length=0");
      }
      UtilidadesLog.debug("DAOTiposCajaEmbalaje.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): Salida");
  }
 
  /**
   * Para Insertar LineasTiposCajaEmbalaje 
   * @author hhernandez
   * @since 21-02-2007
   */  
    public void insertarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado) throws MareException
    {
        UtilidadesLog.info("DAOTiposCajaEmbalaje.insertarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): Entrada");
        StringBuffer query = new StringBuffer();
        Long[] oids = lineasArmado.getOids();
        if(oids.length>0){ // Si hay OIDs en el DTO
          // Se extraen los OIDs del DTO
          StringBuffer sOids = new StringBuffer();
          //Formando el SQL de Insertado de LineaTipoCajaEmbalaje
          query.append("  BEGIN");
          for(int i=0;i<oids.length;i++){
            query.append(" INSERT INTO APE_LINEA_TIPO_CAJA_EMBAL (OID_LINE_TIPO_CAJA_EMBA, ");
            query.append(" TCEM_OID_TIPO_CAJA_EMBA, ");
            query.append(" LIAR_OID_LINE_ARMA  ");
            query.append(" ) VALUES ( APE_LTCE_SEQ.NEXTVAL, " + oidTipoCajaEmbalaje + ", " +  oids[i] +" );");
          }
          query.append("  END;");
          try {
              BelcorpService bs = UtilidadesEJB.getBelcorpService();
              bs.dbService.executeUpdate(query.toString());     
          } catch (DuplicateKeyException ex) {
              UtilidadesLog.error(ex);
              //ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_CLAVE_DUPLICADA));
          } catch (Exception e){        
              UtilidadesLog.error("insert APE_LINEA_TIPO_CAJA_EMBAL: Exception", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }          
        }else{
          UtilidadesLog.debug("DAOTiposCajaEmbalaje.insertarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): No hay OIDs en lineasArmado, length=0");
        }        
        UtilidadesLog.info("DAOTiposCajaEmbalaje.insertarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): Salida");
    }    
 
  /**
   * Para Eliminar LineasTiposCajaEmbalaje 
   * @author hhernandez
   * @since 21-02-2007
   */  
    public void eliminarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado) throws MareException
    {
        UtilidadesLog.info("DAOTiposCajaEmbalaje.eliminarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): Entrada");
        StringBuffer query = new StringBuffer();
        Long[] oids = lineasArmado.getOids();
        if(oids.length>0){ // Si hay OIDs en el DTO
          // Se extraen los OIDs del DTO
          StringBuffer sOids = new StringBuffer();
           for(int i=0;i<oids.length;i++){
            sOids.append(oids[i]+",");
          }
          //Formando el SQL 
          query.append("DELETE FROM APE_LINEA_TIPO_CAJA_EMBAL ");
          query.append("      WHERE  TCEM_OID_TIPO_CAJA_EMBA = " + oidTipoCajaEmbalaje);
          query.append("             AND LIAR_OID_LINE_ARMA IN ("+sOids.substring(0,sOids.length()-1)+") ");
          try {
              BelcorpService bs = UtilidadesEJB.getBelcorpService();
              bs.dbService.executeUpdate(query.toString());     
          } catch (DuplicateKeyException ex) {
              UtilidadesLog.error(ex);
              //ctx.setRollbackOnly();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_CLAVE_DUPLICADA));
          } catch (Exception e){        
              UtilidadesLog.error("Eliminar APE_ORDEN_ANAQU_CABEC: Exception", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }else{
          UtilidadesLog.debug("DAOTiposCajaEmbalaje.eliminarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): No hay OIDs en lineasArmado, length=0");
        }        
        UtilidadesLog.info("DAOTiposCajaEmbalaje.eliminarLineasTiposCajaEmbalaje(Long oidTipoCajaEmbalaje, DTOOIDs lineasArmado): Salida");
    } 
 
   /**
   * Función utilitario para ejecutar una senetncia SQL 
   * @author hhernandez
   * @since 21-02-2007
   */  
   private RecordSet executeQuery(String query) throws MareException {
      UtilidadesLog.info("DAOTiposCajaEmbalaje.executeQuery(String query): Entrada");
      RecordSet rs = null;
      
      try {
        BelcorpService belcorpService = BelcorpService.getInstance();
        rs = belcorpService.dbService.executeStaticQuery( query );
      } catch ( Exception ex ) {
        throw new MareException( ex, 
            UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
      }       
      UtilidadesLog.info("DAOTiposCajaEmbalaje.executeQuery(String query): Salida");  
      return rs;
    } 
    
  private Long bigDecimalToLong(Object numero) {
      if (numero != null) {
          return new Long(((BigDecimal) numero).longValue());
      } else {
          return null;
      }
  }    
}