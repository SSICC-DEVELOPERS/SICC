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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOTipoCajaEmbalaje;
import es.indra.sicc.dtos.ape.DTOVolumenProducto;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import java.math.BigDecimal;
import java.util.ArrayList;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.util.UtilidadesEJB;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Vector;

public class DAOCalculoCubicaje  {
  public DAOCalculoCubicaje() {
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * 
    * CHANGELOG
    * ---------
    * 02/10/2009 - dmorello, Cambio 20090839 - Recupero descripcion I18N del tipo de caja
    */
  public ArrayList obtenerTiposCajasCubicaje(DTOLineaArmado lineaArmado) throws MareException {
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerTiposCajasCubicaje(DTOLineaArmado lineaArmado): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT DISTINCT tipo.OID_TIPO_CAJA_EMBA, tipo.UNMD_OID_UNID_MEDI_CAPA, tipo.NUM_CAPA, ");
      query.append(" tipo.NUM_CAPA_MINI, tipo.NUM_NIVE_APLI, tipo.NUM_PORC_SEGU ");
      query.append(" , pq_apl_aux.valor_gen_i18n_sicc(1, tipo.oid_tipo_caja_emba, 'APE_TIPO_CAJA_EMBAL') AS des_tipo_caja");
      query.append(" FROM APE_LINEA_TIPO_CAJA_EMBAL linTipo, APE_TIPO_CAJA_EMBAL tipo ");   
      query.append(" WHERE linTipo.LIAR_OID_LINE_ARMA = " + lineaArmado.getOid());
      query.append(" AND linTipo.TCEM_OID_TIPO_CAJA_EMBA = tipo.OID_TIPO_CAJA_EMBA ");
      query.append(" AND tipo.IND_CUBI = 1 ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
      ArrayList tiposCajaEmb = new ArrayList();
      
      for(int i=0; i < cant; i++){
          dtoTipoCajaEmbalaje = new DTOTipoCajaEmbalaje();
          
          dtoTipoCajaEmbalaje.setOid(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CAJA_EMBA")).toString()));
          dtoTipoCajaEmbalaje.setOidUnidadMedidaCapacidad(Long.valueOf(((BigDecimal)rs.getValueAt(i,"UNMD_OID_UNID_MEDI_CAPA")).toString()));
          dtoTipoCajaEmbalaje.setCapacidad((BigDecimal)rs.getValueAt(i,"NUM_CAPA"));
          dtoTipoCajaEmbalaje.setCapacidadMinima((BigDecimal)rs.getValueAt(i,"NUM_CAPA_MINI"));
          dtoTipoCajaEmbalaje.setNivelAplicacion((BigDecimal)rs.getValueAt(i,"NUM_NIVE_APLI"));
          dtoTipoCajaEmbalaje.setPorcentajeSeguridad((BigDecimal)rs.getValueAt(i,"NUM_PORC_SEGU"));
          dtoTipoCajaEmbalaje.setDescripcion((String)rs.getValueAt(i, "DES_TIPO_CAJA"));
          
          tiposCajaEmb.add(dtoTipoCajaEmbalaje);
      }

      UtilidadesLog.debug("tiposCajaEmb: " + tiposCajaEmb);
  
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerTiposCajasCubicaje(DTOLineaArmado lineaArmado): Salida");
      return tiposCajaEmb;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public ArrayList obtenerVolumenProductos(DTOListaPicadoCabecera listaPicado) throws MareException {
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerVolumenProductos(DTOListaPicadoCabecera listaPicado): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      String inOidProd = "";
      String inOidMapaCDDet = "";

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      int cantProd = listaPicado.getDetalles().size();
      ArrayList detalles = listaPicado.getDetalles();
      DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
      HashMap oidProdH = new HashMap();
      HashMap oidMapaCDDet = new HashMap();      
      
      for (int j = 0; j < cantProd; j++) {
         dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(j);
         
         // Armamos la lista de productos - mapaCDDetalles
         if(oidProdH.get(dtoListaPicadoDetalle.getOidProducto())==null){
            oidProdH.put(dtoListaPicadoDetalle.getOidProducto(), Integer.valueOf(dtoListaPicadoDetalle.getUnidadesProducto().toString()));
         }
         
         inOidProd = inOidProd + ", (" + dtoListaPicadoDetalle.getOidProducto() + "," + dtoListaPicadoDetalle.getOidMapaCDDetalle() + ")";                  
      }

      // vbongiov -- RI 20080679 -- 2/09/2008
      query.append(" SELECT DISTINCT prod.OID_PROD, prod.COD_SAP, ");      
      query.append(" CASE WHEN (NVL(prod.VAL_VOLU,0) = 0 OR prod.UNMD_OID_UNID_MEDI IS NULL) ");
      query.append(" THEN  param.VAL_VOLU_POR_DEFE  ELSE  prod.VAL_VOLU END VAL_VOLU, ");
      query.append(" CASE WHEN (NVL(prod.VAL_VOLU,0) = 0 OR prod.UNMD_OID_UNID_MEDI IS NULL) ");
      query.append(" THEN param.UNMD_OID_UNID_MEDI ELSE prod.UNMD_OID_UNID_MEDI END  UNMD_OID_UNID_MEDI, ");
      query.append(" CASE WHEN (NVL(prod.VAL_VOLU,0) = 0 OR prod.UNMD_OID_UNID_MEDI IS NULL) THEN 1 ELSE 0 END  PROD_DEFE, ");
      query.append(" subLin.NUM_ORDE_BALA ");
      
      // sapaza -- Cambios para WCS y MUO -- 22/09/2010
      query.append(" , picado.COD_SIST_PICA "); 
      query.append(" ,apro.NUM_UNID_CAJA_MAES "); 
      query.append(" ,apro.NUM_HOLG_ADIC_CUBI "); 
      query.append(" ,caja.OID_TIPO_CAJA_EMBA ");  
      query.append(" ,pq_apl_aux.valor_gen_i18n_sicc(1, caja.OID_TIPO_CAJA_EMBA, 'APE_TIPO_CAJA_EMBAL') AS DES_TIPO_CAJA "); 

      query.append(" FROM MAE_PRODU prod, APE_ASIGN_PRODU_ANAQU_DETAL asigProdAnqDet, ");
      query.append(" APE_MAPA_CENTR_DISTR_DETAL mapCDDet, APE_SUBLI_ARMAD subLin, SEG_PARAM_INTER_PAIS param ");
      
      // sapaza -- Cambios para WCS y MUO -- 22/09/2010
      query.append(" ,APE_SISTE_PICAD picado "); 
      query.append(" ,APE_PRODU       apro "); 
      query.append(" ,APE_TIPO_CAJA_EMBAL caja "); 
      
      query.append(" WHERE asigProdAnqDet.PROD_OID_PROD = prod.OID_PROD ");
      query.append(" AND (prod.OID_PROD, mapCDDet.OID_MAPA_CENT_DIST_DETA) IN ( " + inOidProd.substring(1) + ") ");
      query.append(" AND asigProdAnqDet.MCDD_OID_MAPA_CENT_DIST_DETA = mapCDDet.OID_MAPA_CENT_DIST_DETA ");
      query.append(" AND mapCDDet.SBAR_OID_SUBL_ARMA = subLin.OID_SUBL_ARMA ");
      
      // sapaza -- Cambios para WCS y MUO -- 22/09/2010
      query.append(" AND subLin.SIPI_OID_SIST_PICA = picado.OID_SIST_PICA "); 
      query.append(" AND prod.OID_PROD = apro.PROD_OID_PROD ");  
      query.append(" AND apro.TICP_OID_TIPO_CAJA_PROD = caja.TICP_OID_TIPO_CAJA_PROD(+) ");

      query.append(" AND param.PAIS_OID_PAIS = " + listaPicado.getOidPais());     

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      DTOVolumenProducto dtoVolumenProducto = null;
      ArrayList volumenProductos = new ArrayList();
      BigDecimal oidUnidadMedVol = null;
      BigDecimal numOrden = null;
      Long oidProd = null;
      
      for(int i=0; i < cant; i++){
          dtoVolumenProducto = new DTOVolumenProducto();
          
          oidProd = Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PROD")).toString());
          dtoVolumenProducto.setOidProducto(oidProd);
      
          oidUnidadMedVol = (BigDecimal)rs.getValueAt(i,"UNMD_OID_UNID_MEDI");
          dtoVolumenProducto.setOidUnidadMedidaVolumen(oidUnidadMedVol!=null?Long.valueOf(oidUnidadMedVol.toString()):null);
          
          dtoVolumenProducto.setVolumen((BigDecimal)rs.getValueAt(i,"VAL_VOLU"));
          dtoVolumenProducto.setUnidadesProducto((Integer)oidProdH.get(oidProd));          
          dtoVolumenProducto.setOidPais(listaPicado.getOidPais());
          
          // vbongiov -- 24/01/2008
          numOrden = (BigDecimal)rs.getValueAt(i,"NUM_ORDE_BALA");          
          dtoVolumenProducto.setNumeroOrdenBalanceo(numOrden!=null?Integer.valueOf(numOrden.toString()):Integer.valueOf("999999"));
          
          // vbongiov -- RI 20080679 -- 2/09/2008
          if (((BigDecimal)rs.getValueAt(i,"PROD_DEFE")).equals(new BigDecimal("1"))){
              UtilidadesLog.info("Producto " + (String)rs.getValueAt(i,"COD_SAP") + " no posee Volumen y/o Unidad de Medida");
              
              // sapaza -- Cambios para WCS y MUO -- 22/09/2010
              insertarErrorCubicaje(listaPicado.getFechaFacturacion(), oidProd);
          }
          
          // sapaza -- Cambios para WCS y MUO -- 22/09/2010
          dtoVolumenProducto.setCodigoSistemaPicado((String)rs.getValueAt(i, "COD_SIST_PICA"));
          dtoVolumenProducto.setNumeroUnidadesCajaMaestra(Integer.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_UNID_CAJA_MAES")).toString()));
          dtoVolumenProducto.setPorcentajeCubicajeAdicional((BigDecimal)rs.getValueAt(i,"NUM_HOLG_ADIC_CUBI"));
          
          BigDecimal oidTipoCajaEmbalaje = (BigDecimal)rs.getValueAt(i,"OID_TIPO_CAJA_EMBA");
          dtoVolumenProducto.setOidTipoCajaMaestra(oidTipoCajaEmbalaje!=null?Long.valueOf(oidTipoCajaEmbalaje.toString()):null);
          dtoVolumenProducto.setDescripcionTipoCajaMaestra((String)rs.getValueAt(i, "DES_TIPO_CAJA"));
          
          if ((dtoVolumenProducto.getUnidadesProducto()!=null) && (dtoVolumenProducto.getUnidadesProducto().longValue()>0))
            volumenProductos.add(dtoVolumenProducto);
      }

      UtilidadesLog.debug("volumenProductos: " + volumenProductos);
      
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerVolumenProductos(DTOListaPicadoCabecera listaPicado): Entrada");
      return volumenProductos;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public ArrayList obtenerFactoresConversionAMedidaEstandar (DTOOIDs oidsUnidadesMedida) throws MareException {
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerFactoresConversionAMedidaEstandar (DTOOIDs oidsUnidadesMedida): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      String inOidUnidadesMedida = "";

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }


      int cantMed = oidsUnidadesMedida.getOids().length;
      Long[] oidUnidadesMedida = oidsUnidadesMedida.getOids();
      
      for (int j = 0; j < cantMed; j++) {
         inOidUnidadesMedida = inOidUnidadesMedida + "," + oidUnidadesMedida[j];
      }
        
      query.append(" SELECT fac.UNMD_OID_UNID_MEDI_ORIG, fac.NUM_FACT_CONV ");
      query.append(" FROM MAE_UNIDA_MEDID uni, APE_FACTO_CONVE fac ");
      query.append(" WHERE fac.UNMD_OID_UNID_MEDI_DEST = uni.OID_UNID_MEDI ");   
      query.append(" AND uni.PAIS_OID_PAIS = " + oidsUnidadesMedida.getOidPais());
      query.append(" AND uni.IND_UM_STND = 1 ");
      query.append(" AND fac.UNMD_OID_UNID_MEDI_ORIG IN ( " + inOidUnidadesMedida.substring(1) + ") ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      DTOFactoresConversion dtoFactoresConversion = null;
      ArrayList facConversion = new ArrayList();
      
      for(int i=0; i < cant; i++){
          dtoFactoresConversion = new DTOFactoresConversion();
          
          dtoFactoresConversion.setOidUnidadMedidaOrigen(Long.valueOf(((BigDecimal)rs.getValueAt(i,"UNMD_OID_UNID_MEDI_ORIG")).toString()));
          dtoFactoresConversion.setFactorConversion((BigDecimal)rs.getValueAt(i,"NUM_FACT_CONV"));
          
          facConversion.add(dtoFactoresConversion);
      }

      UtilidadesLog.debug("facConversion: " + facConversion);
  
      UtilidadesLog.info("DAOCalculoCubicaje.obtenerFactoresConversionAMedidaEstandar (DTOOIDs oidsUnidadesMedida): Salida");
      return facConversion;
  }
  
    // sapaza -- Cambios para WCS y MUO -- 22/09/2010
    public void insertarErrorCubicaje(Timestamp fechaFacturacion, Long oidProducto) 
            throws MareException {
        UtilidadesLog.info("DAOCalculoCubicaje.insertarErrorCubicaje(fechaFacturacion, oidProducto): Entrada");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT COUNT(1) ");
        query.append("   FROM APE_ERROR_CUBIC ");
        query.append("  WHERE TO_CHAR(FEC_FACT, 'DD/MM/yyyy') = '");
        query.append(df.format(fechaFacturacion) + "'");
        query.append("    AND PROD_OID_PROD = " + oidProducto);

        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error("Exception en DAOAsignacionProductos.obtenerProcedencia: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        Integer numRegistros = new Integer(((BigDecimal)rs.getValueAt(0,0)).intValue());

        if(numRegistros == 0) {
            StringBuffer insert = new StringBuffer();
            insert.append("INSERT INTO APE_ERROR_CUBIC ");
            insert.append("(FEC_FACT, PROD_OID_PROD) ");
            insert.append(" VALUES ");
            insert.append("(TO_DATE('" + df.format(fechaFacturacion) + "','DD/MM/yyyy'), " + oidProducto + ")");    
            
            try {
                bs.dbService.executeUpdate(insert.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAOCalculoCubicaje.insertarErrorCubicaje(fechaFacturacion, oidProducto): Salida");
    }
    
}