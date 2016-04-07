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
package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.rec.DTOBoletaRecojoTemporal;
import es.indra.sicc.dtos.rec.DTOFiltroProductoNoRecogible;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import es.indra.sicc.dtos.rec.DTOGestionarBoletaRecojoPendiente;
import es.indra.sicc.dtos.rec.DTOBuscarBolRecProcesadas;
import java.text.SimpleDateFormat;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.dtos.rec.DTOConsolidarBoletasRecojo;

import java.math.BigDecimal;
import es.indra.sicc.util.UtilidadesEJB;
import java.util.Date;
import es.indra.sicc.dtos.rec.DTOFiltroBoletasRecojo;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableCabecera;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesBD;
import java.util.Arrays;
import java.util.HashMap;

public class DAOGestionRecojos  {

  public DAOGestionRecojos() {
  }

   public DTOSalida obtenerProductosRecojo(DTOFiltroProductoNoRecogible dtoE) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerProductosRecojo(DTOFiltroProductoNoRecogible):Entrada");

      Long ultLineaPresentada = dtoE.getIndicadorSituacion();
      Integer cantidadLineas = dtoE.getTamanioPagina();      
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();
      
      StringBuffer query = new StringBuffer();

      query.append(" SELECT * ");
      query.append(" FROM (SELECT x.*, ");
      query.append(" CASE ");
      query.append(" WHEN (("+cantidadLineas+" - COUNT (*) OVER (PARTITION BY 1)) < 0 ");
      query.append(" ) ");
      query.append(" THEN 0 ");
      query.append(" ELSE 1 ");
      query.append(" END sicc_es_ultima_pagina ");
      query.append(" FROM (	");
      query.append(" SELECT '1'||LPAD(DOF.OID_DETA_OFER,12,'0') OID, DOF.VAL_CODI_VENT COD_VENT, NULL COD_VENT_FICT, MP.COD_SAP COD_SAP, ");
	    query.append(" IPR.VAL_I18N	DESC_PROD, ITO.VAL_I18N TIPO_OFERTA, NULL CONCURSO, NULL VERSION, NULL NIVEL ");
      query.append(" FROM MAE_PRODU MP, PRE_OFERT_DETAL DOF, V_GEN_I18N_SICC IPR, V_GEN_I18N_SICC ITO, PRE_OFERT OFE, PRE_MATRI_FACTU_CABEC MFC ");
      query.append(" WHERE MP.OID_PROD = DOF.PROD_OID_PROD ");
      query.append(" AND MP.OID_PROD = IPR.VAL_OID ");
      query.append(" AND IPR.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");//--IDIOMA
      query.append(" AND IPR.ATTR_ENTI = 'MAE_PRODU' ");
      query.append(" AND IPR.ATTR_NUM_ATRI = 1 "); //--NUMERO INTERNACIONALIZACION DE LA TABLE
      query.append(" AND DOF.TOFE_OID_TIPO_OFER = ITO.VAL_OID ");
      query.append(" AND ITO.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" "); //--IDIOMA
      query.append(" AND ITO.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
      query.append(" AND ITO.ATTR_NUM_ATRI = 1 "); //--NUMERO INTERNACIONALIZACION DE LA TABLE
      query.append(" AND MP.PAIS_OID_PAIS = "+dtoE.getOidPais()+" "); //--PAIS
      query.append(" AND DOF.OFER_OID_OFER = OFE.OID_OFER ");
      query.append(" AND OFE.MFCA_OID_CABE = MFC.OID_CABE ");
      query.append(" AND MFC.PERD_OID_PERI = "+dtoE.getOidPeriodo()+" "); //--dto.oidPeriodo
      //--OPCIONALES
      if (dtoE.getCodigoSAP()!=null&&!dtoE.getCodigoSAP().equals("")) {
          query.append(" AND UPPER(MP.COD_SAP) = UPPER('"+dtoE.getCodigoSAP()+"') ");
          //-- dto.codigoProducto -- En el caso de que este atributo sea distinto de null 
      }
      if (dtoE.getDescripcion()!=null&&!dtoE.getDescripcion().equals("")) {
          query.append(" AND UPPER(IPR.VAL_I18N) LIKE UPPER('"+dtoE.getDescripcion()+"') ");
          // - dto.descripcion DESCRIPCIONINTERNACIONLIZABLE -- En el caso de que este atributo sea distinto de null 
      }       
      if (dtoE.getCodigoVenta()!=null&&!dtoE.getCodigoVenta().equals("")) {
          query.append(" AND DOF.VAL_CODI_VENT = '"+dtoE.getCodigoVenta()+"' ");
          //--dto.codigoVenta -- En el caso de que este atributo sea distinto de null
      }
      if (dtoE.getCodigoVentaFicticio()!=null&&!dtoE.getCodigoVentaFicticio().equals("")) {
          query.append(" AND 1!=1 ");
      }
      query.append(" UNION ");
      query.append(" SELECT '2'||LPAD(AL.OID_ARTI_LOTE,12,'0') OID, NULL COD_VENT, AL.COD_VENT_FICT COD_VENT_FICT, MP.COD_SAP COD_SAP, ");
      query.append(" IPR.VAL_I18N	DESC_PROD, NULL TIPO_OFERTA, CPG.NUM_CONC CONCURSO, ");
      query.append(" CPG.NUM_VERS VERSION, PN.NUM_NIVE NIVEL ");
      query.append(" FROM MAE_PRODU MP, INC_ARTIC_LOTE AL, V_GEN_I18N_SICC IPR, INC_LOTE_PREMI_ARTIC LA, INC_PREMI_ARTIC PA, ");
	    query.append(" INC_PARAM_NIVEL_PREMI PN, INC_PARAM_GENER_PREMI PG, INC_CONCU_PARAM_GENER CPG, CRA_PERIO PD, ");
	    query.append(" CRA_PERIO PH, CRA_PERIO PSEL ");
      query.append(" WHERE MP.OID_PROD = AL.PROD_OID_PROD ");
      query.append(" AND MP.OID_PROD = IPR.VAL_OID ");
      query.append(" AND IPR.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");//--IDIOMA
      query.append(" AND IPR.ATTR_ENTI = 'MAE_PRODU' ");
      query.append(" AND IPR.ATTR_NUM_ATRI = 1 ");// --NUMERO INTERNACIONALIZACION DE LA TABLE
      query.append(" AND MP.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");// -- dto.pais 
      query.append(" AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
      query.append(" AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
      query.append(" AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
      query.append(" AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM  ");
      query.append(" AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
      query.append(" AND CPG.PERD_OID_PERI_DESD = PD.OID_PERI ");
      query.append(" AND CPG.PERD_OID_PERI_HAST = PH.OID_PERI ");
      query.append(" AND PSEL.OID_PERI = "+dtoE.getOidPeriodo()+" ");// --PERIODO SELECCIONADO
      query.append(" AND PD.FEC_INIC <= PSEL.FEC_INIC ");
      query.append(" AND PSEL.FEC_INIC <= PH.FEC_INIC ");
      //-- OPCIONALES
      if (dtoE.getCodigoVentaFicticio()!=null&&!dtoE.getCodigoVentaFicticio().equals("")) {
          query.append(" AND AL.COD_VENT_FICT = '"+dtoE.getCodigoVentaFicticio()+"' ");
          // -- DTO.CODIGOVENTAFICTICIO -- // En el caso de que este atributo sea distinto de null 
      }
      if (dtoE.getCodigoSAP()!=null&&!dtoE.getCodigoSAP().equals("")) {
          query.append(" AND UPPER(MP.COD_SAP) = UPPER('"+dtoE.getCodigoSAP()+"') ");
          //--DTO.CODIGOPRODUCTO -- // En el caso de que este atributo sea distinto de null 
      }
      if (dtoE.getDescripcion()!=null&&!dtoE.getDescripcion().equals("")) {
          query.append(" AND UPPER(IPR.VAL_I18N) LIKE UPPER('"+dtoE.getDescripcion()+"') ");
          // --DTO.DESCRIPCION DESCRIPCIONINTERNACIONLIZABLE-- // En el caso de que este atributo sea distinto de null 
      }
       if (dtoE.getCodigoVenta()!=null&&!dtoE.getCodigoVenta().equals("")) {
          query.append(" AND 1!=1 ");
       }
      
      query.append(" ORDER BY OID) x ");
      query.append(" WHERE ROWNUM <= "+(cantidadLineas.intValue()+1)+" AND OID > "+ultLineaPresentada+") y ");
      query.append(" WHERE ROWNUM <= "+cantidadLineas+" AND OID > "+ultLineaPresentada+" ");
 
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
  
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOGestionRecojos.obtenerProductosRecojo(DTOFiltroProductoNoRecogible):Salida");
      return dtoSalida;
	
  }

  public DTOSalida obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible dtoE) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible):Entrada");
      
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();
      
      StringBuffer query = new StringBuffer();
		    
      query.append(" SELECT '1'||LPAD(DOF.OID_DETA_OFER,12,'0') OID, DOF.VAL_CODI_VENT COD_VENT, NULL COD_VENT_FICT, MP.COD_SAP COD_SAP, ");
      query.append(" IPR.VAL_I18N	DESC_PROD, ITO.VAL_I18N TIPO_OFERTA, NULL CONCURSO, ");
      query.append(" NULL VERSION, NULL NIVEL, PNR.OID_PROD_NO_RECO OID_PROD_NO_RECO ");
      query.append(" FROM REC_PRODU_NO_RECOG PNR, PRE_OFERT_DETAL DOF, MAE_PRODU MP, V_GEN_I18N_SICC IPR, V_GEN_I18N_SICC ITO ");
      query.append(" WHERE PNR.OFDE_OID_DETA_OFER = DOF.OID_DETA_OFER ");
      query.append(" AND DOF.PROD_OID_PROD = MP.OID_PROD ");
      query.append(" AND MP.OID_PROD = IPR.VAL_OID ");
      query.append(" AND IPR.ATTR_NUM_ATRI = 1 ");
      query.append(" AND IPR.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");
      query.append(" AND IPR.ATTR_ENTI = 'MAE_PRODU' ");
      query.append(" AND DOF.TOFE_OID_TIPO_OFER = ITO.VAL_OID ");
      query.append(" AND ITO.ATTR_NUM_ATRI = 1 ");
      query.append(" AND ITO.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");
      query.append(" AND ITO.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
      query.append(" AND PNR.ARLO_OID_ARTI_LOTE IS NULL ");
      query.append(" AND PNR.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
      query.append(" AND PNR.MARC_OID_MARC = "+dtoE.getOidMarca()+" ");
      query.append(" AND PNR.CANA_OID_CANA = "+dtoE.getOidCanal()+" ");
      query.append(" AND PNR.PERD_OID_PERI = "+dtoE.getOidPeriodo()+" ");
      query.append(" UNION ");
      query.append(" SELECT '2'||LPAD(AL.OID_ARTI_LOTE,12,'0') OID, NULL COD_VENT, AL.COD_VENT_FICT COD_VENT_FICT, MP.COD_SAP COD_SAP, ");
      query.append(" IPR.VAL_I18N	DESC_PROD, NULL TIPO_OFERTA, CPG.NUM_CONC CONCURSO, ");
      query.append(" CPG.NUM_VERS VERSION, PN.NUM_NIVE NIVEL, PNR.OID_PROD_NO_RECO OID_PROD_NO_RECO ");
      query.append(" FROM REC_PRODU_NO_RECOG PNR, MAE_PRODU MP, INC_ARTIC_LOTE AL, V_GEN_I18N_SICC IPR, INC_LOTE_PREMI_ARTIC LA, INC_PREMI_ARTIC PA, ");
      query.append(" INC_PARAM_NIVEL_PREMI PN, INC_PARAM_GENER_PREMI PG, INC_CONCU_PARAM_GENER CPG ");
      query.append(" WHERE PNR.ARLO_OID_ARTI_LOTE = AL.OID_ARTI_LOTE ");
      query.append(" AND MP.OID_PROD = AL.PROD_OID_PROD ");
      query.append(" AND MP.OID_PROD = IPR.VAL_OID ");
      query.append(" AND IPR.ATTR_NUM_ATRI = 1 ");
      query.append(" AND IPR.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");
      query.append(" AND IPR.ATTR_ENTI = 'MAE_PRODU' ");
      query.append(" AND AL.LOPA_OID_LOTE_PREM_ARTI = LA.OID_LOTE_PREM_ARTI ");
      query.append(" AND LA.PRAR_OID_PREM_ARTI = PA.OID_PREM_ARTI ");
      query.append(" AND PA.PANP_OID_PARA_NIVE_PREM = PN.OID_PARA_NIVE_PREM ");
      query.append(" AND PN.PAGP_OID_PARA_GENE_PREM = PG.OID_PARA_GENE_PREM ");
      query.append(" AND PG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
      query.append(" AND PNR.OFDE_OID_DETA_OFER IS NULL ");
      query.append(" AND PNR.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
      query.append(" AND PNR.MARC_OID_MARC = "+dtoE.getOidMarca()+" ");
      query.append(" AND PNR.CANA_OID_CANA = "+dtoE.getOidCanal()+" ");
      query.append(" AND PNR.PERD_OID_PERI = "+dtoE.getOidPeriodo()+" ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
  
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOGestionRecojos.obtenerProductosNoRecogibles(DTOFiltroProductoNoRecogible):Salida");
      return dtoSalida;
  }
  
	private BelcorpService getBelcorpService() throws MareException {

      try {
            BelcorpService bs = BelcorpService.getInstance();
      			return bs;
      } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
	}  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       26/12/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * GCC-COL-REC-001
    */
  public RecordSet obtenerDatosMovimientoAlmacen(ArrayList numValoresProcesado, String valoresProcesado) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerDatosMovimientoAlmacen(ArrayList numBoletasRecojo): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      int cantValores = numValoresProcesado.size();
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      query.append(" select DISTINCT cab.NUM_ATEN, ");
      query.append(" periodo.PAIS_OID_PAIS, periodo.MARC_OID_MARC, periodo.CANA_OID_CANA, ");
      query.append(" subAcc.ACCE_OID_ACCE, subAcc.OID_SBAC, cab.PERD_OID_PERI_RECL, ");
      query.append(" ope.ALMC_OID_ALMA_POSV, ope.TMAL_OID_TIPO_ALMA_REC_NO_EXIT, ");
      query.append(" lineaOpe.PROD_OID_PROD, lineaOpe.TOFE_OID_TIPO_OFER, lineaOpe.NUM_UNID_DEVU, ope.TMAL_OID_TIPO_ALMA_REC_EXIT ");
      //Cambio 20080765 
      query.append(" , ope.ALMC_OID_ALMA ");
      //-Cambio 20080765 
      
      if(valoresProcesado.equals("NB")){ 
          query.append(" from REC_BOLET_RECOJ bolRec, REC_CABEC_RECLA cab,");
      } else if(valoresProcesado.equals("NA")){ 
          query.append(" from REC_CABEC_RECLA cab, ");
      }      
      
      query.append(" REC_OPERA_RECLA opeReclamo, REC_SOLIC_OPERA solicOpe, ");
      query.append(" REC_LINEA_OPERA_RECLA lineaOpe, REC_TIPO_MOVIM tipoMov, ");
      query.append(" REC_TIPOS_OPERA tipoOpe, REC_OPERA ope, ");
      query.append(" CRA_PERIO periodo, PED_SOLIC_CABEC solCab, SEG_SUBAC subacc ");
    
      
      
      if(valoresProcesado.equals("NB")){ 
      
          query.append(" where bolRec.CARE_OID_CABE_RECL = cab.OID_CABE_RECL ");
          query.append(" and bolRec.NUM_BOLE in ( ");
          
          for (int i = 0; i < cantValores; i++) {
              if ( (i+1) < cantValores ) {
                  if ((i+1)%1000 == 0) {
                      query.append(numValoresProcesado.get(i) + ") OR bolRec.NUM_BOLE IN (");
                  } else {
                      query.append(numValoresProcesado.get(i) + ",");
                  }
              } else {
                  query.append(numValoresProcesado.get(i));
              }
          }
          
          query.append(")");     
      
      } else if(valoresProcesado.equals("NA")){  
      
          query.append(" where cab.NUM_ATEN in ( ");
          
          for (int i = 0; i < cantValores; i++) {
              if ( (i+1) < cantValores ) {
                  if ((i+1)%1000 == 0) {
                      query.append(numValoresProcesado.get(i) + ") OR cab.NUM_ATEN IN (");
                  } else {
                      query.append(numValoresProcesado.get(i) + ",");
                  }
              } else {
                  query.append(numValoresProcesado.get(i));
              }
          }
          
          query.append(")");           
      }
      
      query.append(" and opeReclamo.CARE_OID_CABE_RECL = cab.OID_CABE_RECL ");
      query.append(" and solicOpe.OPRE_OID_OPER_RECL = opeReclamo.OID_OPER_RECL ");
      query.append(" and lineaOpe.OPRE_OID_OPER_RECL = opeReclamo.OID_OPER_RECL ");
      query.append(" and lineaOpe.NUM_UNID_DEVU != 0 ");
      query.append(" and lineaOpe.TIMO_OID_TIPO_MOVI = tipoMov.OID_TIPO_MOVI ");
      query.append(" and tipoMov.COD_TIPO_MOVI = '" + ConstantesREC.MOVIMIENTO_DEVUELVE + "' ");
      query.append(" and opeReclamo.TIOP_OID_TIPO_OPER = tipoOpe.OID_TIPO_OPER ");      
      query.append(" and tipoOpe.ROPE_OID_OPER = ope.OID_OPER ");
      query.append(" and cab.PERD_OID_PERI_RECL = periodo.OID_PERI ");
      query.append(" and cab.SOCA_OID_SOLI_CABE = solCab.OID_SOLI_CABE ");
      query.append(" and solCab.SBAC_OID_SBAC = subAcc.OID_SBAC ");
      //enozigli 07/08/2009 se elimina por el cambio 20080765 se solicita quitar el filtro de prod no recog.      
      /*query.append(" and not exists (select 1 ");
      query.append("                 from REC_PRODU_NO_RECOG prodNORec, INC_ARTIC_LOTE artLot ");
      query.append("                 where prodNORec.PAIS_OID_PAIS = periodo.PAIS_OID_PAIS ");
      query.append("                 and   prodNORec.MARC_OID_MARC = periodo.MARC_OID_MARC ");
      query.append("                 and   prodNORec.CANA_OID_CANA = periodo.CANA_OID_CANA ");
      query.append("                 and   prodNORec.PERD_OID_PERI = cab.PERD_OID_PERI_RECL ");
      query.append("                 and   prodNORec.ARLO_OID_ARTI_LOTE = artLot.OID_ARTI_LOTE ");
      query.append("                 and   artLot.PROD_OID_PROD = lineaOpe.PROD_OID_PROD ) ");                
      query.append(" and not exists (select 1 ");
      query.append("                 from REC_PRODU_NO_RECOG prodNORec, PRE_OFERT_DETAL oferDet ");
      query.append("                 where prodNORec.PAIS_OID_PAIS = periodo.PAIS_OID_PAIS ");
      query.append("                 and   prodNORec.MARC_OID_MARC = periodo.MARC_OID_MARC ");
      query.append("                 and   prodNORec.CANA_OID_CANA = periodo.CANA_OID_CANA ");
      query.append("                 and   prodNORec.PERD_OID_PERI = cab.PERD_OID_PERI_RECL ");
      query.append("                 and   prodNORec.OFDE_OID_DETA_OFER = oferDet.OID_DETA_OFER ");
      query.append("                 and   oferDet.PROD_OID_PROD = lineaOpe.PROD_OID_PROD ) ");
      */
      query.append(" order by  cab.NUM_ATEN ");
  
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }  
      
      UtilidadesLog.debug("rs: " + rs);
  
      UtilidadesLog.info("DAOGestionRecojos.obtenerDatosMovimientoAlmacen(ArrayList numBoletasRecojo): Salida");
      return rs;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       26/12/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * GCC-COL-REC-001
    */
  public RecordSet obtenerNumAtencion(ArrayList numBoletasRecojo) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumAtencion(ArrayList numBoletasRecojo): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      int cantValores = numBoletasRecojo.size();
  
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
  
      query.append(" select cab.NUM_ATEN ");
      query.append(" from REC_BOLET_RECOJ bolRec, REC_CABEC_RECLA cab ");
      query.append(" where bolRec.CARE_OID_CABE_RECL = cab.OID_CABE_RECL ");
      query.append(" and bolRec.NUM_BOLE in ( ");
                
      for (int i = 0; i < cantValores; i++) {
          if ( (i+1) < cantValores ) {
              if ((i+1)%1000 == 0) {
                  query.append(numBoletasRecojo.get(i) + ") OR bolRec.NUM_BOLE IN (");
              } else {
                  query.append(numBoletasRecojo.get(i) + ",");
              }
          } else {
              query.append(numBoletasRecojo.get(i));
          }
      }
      
      query.append(")");
      
      query.append(" ORDER BY cab.NUM_ATEN ");
  
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
    
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumAtencion(ArrayList numBoletasRecojo): Salida");
      return rs;
  }
  
  public RecordSet obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE): Entrada");
      UtilidadesLog.debug("dtoE: " + dtoE);
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      String fechaRecojo = null;
      if (dtoE.getFechaRecojo()!=null) {
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          fechaRecojo = sdf.format(dtoE.getFechaRecojo());
      }
      query.append("SELECT rcr.OID_CABE_RECL,  rcr.NUM_ATEN ,  ");
      //se elimina el campo num_aten por cambio 20080765
      query.append(" rbolr.num_bole, ");
      query.append(" mc.COD_CLIE, mtc.COD_TIPO_CLIE, msc.COD_SUBT_CLIE, ");
      query.append(" zr.COD_REGI||zz.COD_ZONA||zs.COD_SECC||zt.cod_terr AS CONCAT, rbr.FEC_EMIS, ");
      
      query.append(" rer.DESC_ESTA_RECO AS DESC_EST_RECOJO, ");
      
      /*query.append("(SELECT i18.VAL_I18N ");
      query.append("FROM v_gen_i18n_sicc i18 ");
      query.append("WHERE i18.attr_enti = 'REC_BOLET_RECOJ' ");
      query.append("AND i18.val_oid = rbr.EREC_OID_ESTA_RECO ");
      query.append("AND i18.idio_oid_idio = 1) AS DESC_EST_RECOJO, ");*/
      
      
      query.append(" (SELECT i18a.VAL_I18N AS DESC_NUMER_RECOJO ");
      query.append(" FROM v_gen_i18n_sicc i18a ");
      query.append(" WHERE i18a.attr_enti = 'REC_NUMER_RECOJ' ");
      query.append(" AND i18a.val_oid = rnr.OID_NUME_RECO ");
      query.append(" AND i18a.idio_oid_idio = 1) AS DESC_NUMER_RECOJO, ");
       //se agrega por cambio 20080765 
      query.append("     rnr.oid_nume_reco ");
      query.append(" FROM REC_CABEC_RECLA rcr, CRA_PERIO cp, REC_BOLET_RECOJ rbr, MAE_CLIEN mc, ");
      query.append(" MAE_CLIEN_TIPO_SUBTI mcts, mae_tipo_clien mtc, MAE_SUBTI_CLIEN msc, ");
      query.append(" ZON_TERRI zt, ZON_TERRI_ADMIN zta, ZON_SECCI zs, ZON_ZONA zz, ZON_REGIO zr, REC_NUMER_RECOJ rnr");
      query.append(", rec_estad_recoj rer ");
      //se agrega por cambio 20080765
      query.append("   , rec_bolet_recoj rbolr  ");
      query.append(" WHERE rcr.PAIS_OID_PAIS = 2001 ");
      query.append(" AND rcr.PERD_OID_PERI_RECL = cp.OID_PERI ");
      query.append(" AND cp.MARC_OID_MARC = " + dtoE.getOidMarca().longValue());
      query.append(" AND cp.CANA_OID_CANA = " + dtoE.getOidCanal().longValue());
      query.append(" AND cp.OID_PERI >= " + dtoE.getOidPerDde().longValue());
      query.append(" AND rbr.BORE_OID_BOLE_RECO = rbolr.OID_BOLE_RECO  ");
      
      if (dtoE.getOidPerHta()!=null)
          query.append(" AND cp.OID_PERI <= " + dtoE.getOidPerHta().longValue());
      //se modifica por cambio 20080765    
      query.append(" AND rbolr.CARE_OID_CABE_RECL = rcr.OID_CABE_RECL ");
      query.append(" AND rbolr.EREC_OID_ESTA_RECO = (SELECT rer.OID_ESTA_RECO FROM rec_estad_recoj rer WHERE rer.VAL_CODI = 'PR') ");
      
      if (dtoE.getFechaRecojo()!=null)
         ////se modifica por cambio 20080765
          query.append(" AND rbolr.FEC_RECO = to_date('").append(fechaRecojo).append("', 'dd/MM/yyyy') ");
          
      query.append(" AND rcr.CLIE_OID_CLIE = mc.OID_CLIE ");
      query.append(" AND mc.OID_CLIE = mcts.CLIE_OID_CLIE ");
      query.append(" AND mtc.OID_TIPO_CLIE = mcts.TICL_OID_TIPO_CLIE ");
      query.append(" AND mcts.SBTI_OID_SUBT_CLIE = msc.OID_SUBT_CLIE ");
      query.append(" AND rcr.ZTAD_OID_TERR_ADMI = zta.OID_TERR_ADMI(+) "); 
      query.append(" AND zta.TERR_OID_TERR = zt.OID_TERR(+) "); 
      query.append(" AND zta.ZSCC_OID_SECC = zs.OID_SECC(+) ");
      query.append(" AND zs.ZZON_OID_ZONA = zz.OID_ZONA(+) "); 
      query.append(" AND zz.ZORG_OID_REGI = zr.OID_REGI(+) "); 
      //se modifica por cambio 20080765
      query.append(" AND rnr.OID_NUME_RECO = rbolr.NURE_OID_NUME_RECO ");     
      query.append(" AND rbolr.erec_oid_esta_reco = rer.OID_ESTA_RECO ");
      
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      if ((rs==null)||(rs.getRowCount()==0))
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      
      UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecPend(DTOGestionarBoletaRecojoPendiente dtoE): Salida");
      return rs;
  }
  public void procesarAnular(Long[] oids) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.procesarAnular(): Entrada");
      
      StringBuffer update = new StringBuffer();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date date = new Date(System.currentTimeMillis());
      
      update.append("Update REC_BOLET_RECOJ ");
      update.append("SET FEC_RECO = ");
      update.append("TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY'), ");
      update.append("EREC_OID_ESTA_RECO = " + this.obtengoEstado("AN"));
      update.append(" WHERE CARE_OID_CABE_RECL IN (");
      for (int i = 0; i < oids.length; ) {
          UtilidadesLog.debug("oid a poner en in: " + oids[i]);
          update.append(oids[i]);
          if (++i < oids.length) {
              update.append(',');
          } else {
              update.append(')');
          }
      }      
      try {
          bs.dbService.executeUpdate(update.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }      
      
      UtilidadesLog.info("DAOGestionRecojos.procesarAnular(): Salida");
  }

  public void procesarNoExitosos(Long[] oids) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.ProcesarNoExitosos(): Entrada");
      
      StringBuffer update = new StringBuffer();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date date = new Date(System.currentTimeMillis());
      
      update.append("Update REC_BOLET_RECOJ ");
      update.append("SET FEC_RECO = ");
      update.append("TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY'), ");
      update.append("EREC_OID_ESTA_RECO = " + this.obtengoEstado("NE"));
      update.append(" WHERE CARE_OID_CABE_RECL IN (");
      for (int i = 0; i < oids.length; ) {
          UtilidadesLog.debug("oid a poner en in: " + oids[i]);
          update.append(oids[i]);
          if (++i < oids.length) {
              update.append(',');
          } else {
              update.append(')');
          }
       
      }      
      try {
          bs.dbService.executeUpdate(update.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }      
      UtilidadesLog.info("DAOGestionRecojos.ProcesarNoExitosos(): Salida");
  }
  
  public long obtengoEstado(String estado) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtengoEstado(String estado): Entrada");
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      query.append("SELECT oid_esta_reco FROM rec_estad_recoj WHERE val_codi = '" + estado + "'");
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("rs: " + rs);
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOGestionRecojos.obtengoEstado(String estado): Salida");      
      return ((BigDecimal)rs.getValueAt(0, "OID_ESTA_RECO")).longValue();
      
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       7/1/2008
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Cambio REC-01 
    */
  public DTOSalida buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe) throws MareException {
    UtilidadesLog.info("MONGestionRecojosBean.buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe:Entrada");
    
    UtilidadesLog.debug("dtoe: " + dtoe);
    
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    StringBuffer queryPaginado = new StringBuffer();
    BelcorpService bs;
    DTOSalida dtoS = new DTOSalida();

    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    
    query.append(" select bolRec.OID_BOLE_RECO_PROCE OID, bolRec.NUM_ORDE_INGR, bolRec.NUM_BOLE,  ");
    query.append(" bolRec.IND_VALI, bolRec.VAL_TEXT_VALI ");
    query.append(" from REC_BOLET_RECOJ_PROCE bolRec ");        
    query.append(" where bolRec.PAIS_OID_PAIS = " + dtoe.getOidPais());     
    query.append(" and bolRec.VAL_USUA = '" + dtoe.getUsuario() + "' "); 
    
    if(dtoe.getFechaCaptura()!=null){
        query.append(" and bolRec.FEC_CAPT = TO_DATE('" + dtoe.getFechaCaptura() + "' , '" + dtoe.getFormatoFechaPais() +"') ");     
    }
    
    if(dtoe.getOidEstadoRecojo()!=null){
        query.append(" and bolRec.EREC_OID_ESTA_RECO = " + dtoe.getOidEstadoRecojo());     
    }
    
    if(new Integer("1").equals(dtoe.getValidacion())){
        query.append(" and bolRec.IND_VALI = 1 "); 
    } else if(new Integer("0").equals(dtoe.getValidacion())){
        query.append(" and bolRec.IND_VALI = 0 ");     
    }
    
    if(dtoe.getOrden().equals("I")){
        query.append(" order by bolRec.NUM_ORDE_INGR ");     
    } else if(dtoe.getOrden().equals("B")){
        query.append(" order by bolRec.NUM_BOLE ");     
    }
    
    queryPaginado.append(" SELECT OID, num_orde_ingr,num_bole, ind_vali, val_text_vali ");
    queryPaginado.append(" FROM ( ");
    queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
    queryPaginado.append("     FROM (  ");
    queryPaginado.append(query.toString());
    queryPaginado.append("     )  queryPrincipal ");
          
    queryPaginado.append(" ) WHERE ROWNUM <= " + dtoe.getTamanioPagina() + " AND linea > " + dtoe.getIndicadorSituacion());
    
    try {
        rs = bs.dbService.executeStaticQuery(queryPaginado.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.debug("rs: " + rs);
    
    dtoS.setResultado(rs);
    
    UtilidadesLog.info("MONGestionRecojosBean.buscarBoletasRecojoProcesadas(DTOBuscarBolRecProcesadas dtoe:Salida");
    return dtoS;
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
    UtilidadesLog.info("DAOGestionRecojos.eliminarBolRecojoProcesadas(DTOOIDs dtoe):Entrada");
    
    int respuesta;
    StringBuffer query = new StringBuffer();
    StringBuffer queryIN = new StringBuffer();
    BelcorpService bs;
    
    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    Long[] oids = dtoe.getOids();
    
    for (int i = 0; i < oids.length; i++) {
        queryIN.append("," + oids[i]);
    }
    
    query.append(" DELETE REC_BOLET_RECOJ_PROCE ");
    query.append(" WHERE OID_BOLE_RECO_PROCE IN (" + queryIN.toString().substring(1) + ") ");

    try{
        respuesta = bs.dbService.executeUpdate(query.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.info("DAOGestionRecojos.eliminarBolRecojoProcesadas(DTOOIDs dtoe):Salida");
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
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe):Entrada");
    
    int respuesta;
    StringBuffer query = new StringBuffer();
    BelcorpService bs;
    
    try {
        bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    query.append(" DELETE REC_BOLET_RECOJ_PROCE bol");
    query.append(" where bol.OID_BOLE_RECO_PROCE IN (");
    query.append(" select bolRec.OID_BOLE_RECO_PROCE OID ");
    query.append(" from REC_BOLET_RECOJ_PROCE bolRec ");        
    query.append(" where bolRec.PAIS_OID_PAIS = " + dtoe.getOidPais());     
    query.append(" and bolRec.VAL_USUA = '" + dtoe.getUsuario() + "' "); 
    
    if(dtoe.getFechaCaptura()!=null){
        query.append(" and bolRec.FEC_CAPT = TO_DATE('" + dtoe.getFechaCaptura() + "' , '" + dtoe.getFormatoFechaPais() +"') ");     
    }
    
    if(dtoe.getOidEstadoRecojo()!=null){
        query.append(" and bolRec.EREC_OID_ESTA_RECO = " + dtoe.getOidEstadoRecojo());     
    }
    
    query.append(" and bolRec.IND_VALI = 1 )");         

    try{
        respuesta = bs.dbService.executeUpdate(query.toString());
    } catch (Exception ex) {
        UtilidadesLog.error("ERROR ", ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.info("MONGestionRecojosBean.eliminarBolRecojoOK(DTOBuscarBolRecProcesadas dtoe):Salida");
  }
  
 public DTOSalida obtenerEstadosRecojo(DTOBoolean dtoE) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenereEstadosRecojo(DTOBoolean):Entrada");
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();      
      StringBuffer query = new StringBuffer();

      query.append(" SELECT ER.OID_ESTA_RECO OID, ER.DESC_ESTA_RECO DESCR ");
      query.append(" FROM REC_ESTAD_RECOJ ER ");
      if (dtoE.getValor()){
        query.append(" WHERE ER.IND_ESTA_MANU = "+ConstantesCMN.VAL_TRUE+" ");
      } else {
        query.append(" WHERE ER.IND_ESTA_MANU = "+ConstantesCMN.VAL_FALSE+" ");
      }
 
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
  
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOGestionRecojos.obtenereEstadosRecojo(DTOBoolean):Salida");
      return dtoSalida;
 }

  /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       10/01/2008
    * @version     1.0
    * @autor       Emilio Noziglia
    * Cambio REC-01 
    */  
 public DTOSalida obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo dtoE) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo):Entrada");
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();      
      StringBuffer query = new StringBuffer();
      
      String fechaCaptura = null;
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      fechaCaptura = sdf.format(dtoE.getFechaCaptura());

      
      query.append(" SELECT BRT.NUM_ORDE_INGR, BRT.NUM_ORDE_INGR, LPAD(BRT.NUM_BOLE,10,'0') NUM_BOLE, brp.VAL_TEXT_VALI, NULL, BRT.OID_BOLE_RECO_TEMP OID ");
      query.append(" FROM REC_BOLET_RECOJ_TEMPO BRT, rec_bolet_recoj_proce brp ");
      query.append(" WHERE BRT.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
      query.append(" AND BRT.FEC_CAPT = TO_DATE('"+fechaCaptura+"','dd/MM/yyyy') ");
      query.append(" AND BRT.EREC_OID_ESTA_RECO = "+dtoE.getEstado()+" ");
      query.append(" AND BRT.VAL_USUA = '"+dtoE.getIdUsuario()+"' ");
      query.append(" AND brt.NUM_BOLE = brp.NUM_BOLE(+) ");
      query.append(" and brp.PAIS_OID_PAIS(+) = "+dtoE.getOidPais()+" ");
      query.append(" and brp.FEC_CAPT(+) = TO_DATE('"+fechaCaptura+"','dd/MM/yyyy') ");
      query.append(" ORDER BY BRT.NUM_ORDE_INGR DESC ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
  
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoTemporal(DTOFiltroBoletasRecojo):Salida");
      return dtoSalida;
 }	  
 
  public RecordSet validoNroBoleta(long nroBoleta) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.validoNroBoleta(long nroBoleta): Entrada");
      
      //voy a retornar==>>    
      //                      2, si su estado es igual a PR o NE  (existe registro)
      //                      0, numero de boleta no existe (NO existe registro)
      //                      1, numero de boleta existe, pero estado no es igual a PR/NE  (Exitoso)
      //                      3, numero de boleta existe, pero estado no es igual a PR/NE  (Anulado)
      
      //3.	Se valida que el numero de Boleta ingresado sea correcto, para ello se accede a la 
      //entidad REC_BOLETA_RECOJO filtrando con el numero de boleta ingresado.4.	
      //Si la validación del punto 3 resulta correcta, se valida que el campo estado_recojo sea 
      //igual a ‘PR’ (Pendiente Recojo) o ‘NE’ (No-Exitoso)
      RecordSet rs;      
      
      BelcorpService bs = getBelcorpService();      
      StringBuffer query = new StringBuffer();
      
      query.append("SELECT rer.VAL_CODI, rbr.FEC_CAPT ");
      query.append("FROM REC_BOLET_RECOJ rbr, rec_estad_recoj rer ");
      query.append("WHERE rbr.NUM_BOLE = " + nroBoleta);
      query.append(" AND rer.OID_ESTA_RECO = rbr.EREC_OID_ESTA_RECO");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
      UtilidadesLog.debug("rs: " + rs);
      UtilidadesLog.info("DAOGestionRecojos.validoNroBoleta(long nroBoleta): Salida");
      return rs;
  }
  
  public void actualizoFechaEstado(long nroBoleta, Date fechCapt, long estado) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.actualizoFechaEstado(long nroBoleta): Entrada");
      
      StringBuffer update = new StringBuffer();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date date = new Date(System.currentTimeMillis());
      
      update.append(" UPDATE REC_BOLET_RECOJ BR ");
      update.append(" SET BR.FEC_CAPT = ");
      update.append(" TO_DATE('").append(sdf.format(fechCapt)).append("','DD/MM/YYYY'), ");
      update.append(" BR.EREC_OID_ESTA_RECO = " + estado);
      update.append(" WHERE BR.NUM_BOLE = " + nroBoleta);
      //enozigli cambio 20080765 la actualización debe de realizarse tanto para la boleta de recojo 
      //consolidado que se corresponde con el numero de boleta recibida por parámetro como para las boletas de recojo orígenes
      update.append(" OR BR.OID_BOLE_RECO IN (SELECT BR1.OID_BOLE_RECO ");
                                 update.append(" FROM REC_BOLET_RECOJ BR1 ");
                                 update.append(" WHERE BR1.BORE_OID_BOLE_RECO IN (SELECT BR2.OID_BOLE_RECO FROM REC_BOLET_RECOJ BR2 WHERE BR2.NUM_BOLE = " + estado + ")) ");

      
      try {
          bs.dbService.executeUpdate(update.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }      
      UtilidadesLog.info("DAOGestionRecojos.actualizoFechaEstado(long nroBoleta): Salida");
  }


 /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       12/02/2008
    * @version     1.0
    * @autor       Emilio Noziglia
    * Cambio REC-01 
    */  
  public DTOSalida obtenerNumeroRecojo(ArrayList boletas) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumeroRecojo(ArrayList):Entrada");
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();      
      StringBuffer query = new StringBuffer();
      
      if (boletas.size()>0) {
        query.append(" SELECT NR.OID_NUME_RECO, BR.NUM_BOLE ");
        query.append(" FROM REC_BOLET_RECOJ BR, REC_NUMER_RECOJ NR ");
        query.append(" WHERE BR.NUM_BOLE IN ( ");
        for (int i=1; i<boletas.size()+1; i++) {
          DTOBoletaRecojoTemporal dtoB = (DTOBoletaRecojoTemporal)boletas.get(i-1);
          query.append(" "+dtoB.getNumeroBoleta()+" ");
          
          BigDecimal cant = new BigDecimal(i);      
          cant = cant.divide(new BigDecimal(1000),4,BigDecimal.ROUND_HALF_EVEN);
          cant = cant.subtract(new BigDecimal(cant.longValue()));
          if (i==boletas.size()){//si es el ultimo
             //no va la coma, ni nada
          } else {
            if (cant.compareTo(new BigDecimal(0))==0) {
              query.append(" ) OR BR.NUM_BOLE IN ( ");
            } else {
              query.append(",");
            }
          }
        }      
        query.append(" ) ");
        query.append(" AND BR.NURE_OID_NUME_RECO = NR.OID_NUME_RECO ");
        query.append(" ORDER BY NR.VAL_CODI ");
      } else {
        UtilidadesLog.debug("No quedaron boletas para procesar que hayan pasado la validacion OK.");
        query.append(" SELECT  null oid_nume_reco, null num_bole ");
        query.append(" from dual ");
      }
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
       
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumeroRecojo(ArrayList):Salida");
      return dtoSalida;
 }	  
  

 /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       28/02/2008
    * @version     1.0
    * @autor       Emilio Noziglia
    * Cambio REC-01 
    */  
  public HashMap obtenerNumerosBoletaProcesadas(String boletas, Long oidPais, Date fecha) throws MareException {
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumerosBoletaProcesadas():Entrada");
      RecordSet rs;
      
      BelcorpService bs = getBelcorpService();      
      StringBuffer query = new StringBuffer();
      String fechaCaptura = null;
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      fechaCaptura = sdf.format(fecha);

      query.append(" SELECT BP.NUM_BOLE ");
      query.append(" FROM REC_BOLET_RECOJ_PROCE BP ");
      query.append(" WHERE BP.NUM_BOLE IN ("+boletas+") ");
      query.append(" AND BP.FEC_CAPT = TO_DATE ('"+fechaCaptura+"', 'dd/MM/yyyy') ");
      query.append(" AND BP.PAIS_OID_PAIS = "+oidPais+" ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());      
      } catch (Exception e) {
          if (e instanceof MareException) {
              UtilidadesLog.error(((MareException) e).getOriginalCause());
              throw (MareException) e;
          } else {
              UtilidadesLog.error(e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
      
      int cantRegs = rs.getRowCount();
      HashMap boletasProcesadas = new HashMap();
      if (cantRegs>0) {
        for (int i=0; i<cantRegs; i++) {
              Long nroBoleta = new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue());
              boletasProcesadas.put(nroBoleta,nroBoleta);
        }
      }
      
      UtilidadesLog.info("DAOGestionRecojos.obtenerNumerosBoletaProcesadas():Salida");
      return boletasProcesadas;
 }	    
 
    public RecordSet obtenerParametriaIntPais(DTOBelcorp dtoPais) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerParametriaIntPais(DTOBelcorp dtoPais): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT PIP.VAL_CANT_RECO ");
        query.append(" FROM SEG_PARAM_INTER_PAIS PIP ");
        query.append(" WHERE PIP.PAIS_OID_PAIS = "+dtoPais.getOidPais()+" ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
            
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerParametriaIntPais(DTOBelcorp dtoPais): Salida"); 
        return rs;
        
    } 
    public RecordSet obtenerTipoMovimiento(DTOBelcorp dtoPais) throws MareException{
            UtilidadesLog.info("DAOGestionRecojo.obtenerParametriaNPP(DTOBelcorp dtoPais): Entrada");
            RecordSet rs = new RecordSet();
            RecordSet rs2 =  new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;

            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
        
            query.append(" SELECT PIP.COD_TRAN_AJUS_INVE_NPP ");
            query.append(" FROM SEG_PARAM_INTER_PAIS PIP ");
            query.append(" WHERE PIP.PAIS_OID_PAIS = "+dtoPais.getOidPais()+" ");
        
            try {
                    rs = bs.dbService.executeStaticQuery(query.toString());
                    UtilidadesLog.debug("rs: " + rs);
            
            } catch (Exception ex) {
                   UtilidadesLog.error("ERROR ", ex);
                   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            StringBuffer query2 = new StringBuffer();
            
            if(rs.getValueAt(0,"COD_TRAN_AJUS_INVE_NPP") != null){    
                query2.append(" SELECT bel_tipo_movim_almac.oid_tipo_movi_alma ");
                query2.append("   FROM bel_tipo_movim_almac ");            
                query2.append("        WHERE bel_tipo_movim_almac.cod_tipo_movi = '"+ rs.getValueAt(0,"COD_TRAN_AJUS_INVE_NPP").toString() + "'" );
                
                try {
                    rs2 = bs.dbService.executeStaticQuery(query2.toString());
                    UtilidadesLog.debug("rs2: " + rs2);
                
                 } catch (Exception ex) {
                       UtilidadesLog.error("ERROR ", ex);
                       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            
            UtilidadesLog.info("DAOGestionRecojo.obtenerParametriaNPP(DTOBelcorp dtoPais): Salida");
            UtilidadesLog.debug("rs2: "  + rs2);
            return rs2; 
    }
    //Agregado por cambio 20080765 
    
  public RecordSet movimientoAlmacen(ArrayList numValoresProcesado, Long tipoAlmacen)throws MareException{
      UtilidadesLog.info("DAOGestionRecojo.movimientoAlmacen(ArrayList numValoresProcesado): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        int cantValores = numValoresProcesado.size();
      
         try {
             bs = BelcorpService.getInstance();
         }catch (MareMiiServiceNotFoundException e) {
             UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
       
          query.append(" select DISTINCT cab.NUM_ATEN, ");
          query.append(" periodo.PAIS_OID_PAIS, periodo.MARC_OID_MARC, periodo.CANA_OID_CANA, ");
          query.append(" subAcc.ACCE_OID_ACCE, subAcc.OID_SBAC, cab.PERD_OID_PERI_RECL, ");
          query.append(" ope.ALMC_OID_ALMA_POSV, ope.TMAL_OID_TIPO_ALMA_REC_NO_EXIT, ");
          query.append(" lineaOpe.PROD_OID_PROD, lineaOpe.TOFE_OID_TIPO_OFER, lineaOpe.NUM_UNID_DEVU, ope.TMAL_OID_TIPO_ALMA_REC_EXIT, ");
          query.append("  ope.ALMC_OID_ALMA,  ope.TMAL_OID_TIPO_MOVI_ALMA ");      
          query.append(" from REC_CABEC_RECLA cab, ");      
          query.append(" REC_OPERA_RECLA opeReclamo, REC_SOLIC_OPERA solicOpe, ");
          query.append(" REC_LINEA_OPERA_RECLA lineaOpe, REC_TIPO_MOVIM tipoMov, ");
          query.append(" REC_TIPOS_OPERA tipoOpe, REC_OPERA ope, ");
          query.append(" CRA_PERIO periodo, PED_SOLIC_CABEC solCab, SEG_SUBAC subacc, ");      
          query.append("  REC_ESTAD_OPERA  ");
          query.append(" where cab.NUM_ATEN in ( ");
          
          for (int i = 0; i < cantValores; i++) {
              if ( (i+1) < cantValores ) {
                      if ((i+1)%1000 == 0) {
                          query.append(numValoresProcesado.get(i) + ") OR cab.NUM_ATEN IN (");
                      } else {
                         query.append(numValoresProcesado.get(i) + ",");
                      }
                } else {
                  query.append(numValoresProcesado.get(i));
                }
         }
          
          query.append(")");                 
          query.append(" and opeReclamo.CARE_OID_CABE_RECL = cab.OID_CABE_RECL ");
          query.append(" and solicOpe.OPRE_OID_OPER_RECL = opeReclamo.OID_OPER_RECL ");
          query.append(" and lineaOpe.OPRE_OID_OPER_RECL = opeReclamo.OID_OPER_RECL ");
          query.append(" and lineaOpe.NUM_UNID_DEVU != 0 ");
          query.append(" and lineaOpe.TIMO_OID_TIPO_MOVI = tipoMov.OID_TIPO_MOVI ");
          query.append(" and tipoMov.COD_TIPO_MOVI = '" + ConstantesREC.MOVIMIENTO_DEVUELVE + "' ");
          query.append(" and opeReclamo.TIOP_OID_TIPO_OPER = tipoOpe.OID_TIPO_OPER ");
          
          query.append(" AND opereclamo.ESOP_OID_ESTA_OPER  = rec_estad_opera.OID_ESTA_OPER  ");
          
          query.append(" AND rec_estad_opera.OID_ESTA_OPER = " + ConstantesREC.ESTADO_OPERACION_FACTURADO);
          query.append(" and tipoOpe.ROPE_OID_OPER = ope.OID_OPER ");
          if(tipoAlmacen != null){
            query.append(" AND  AND ope.TMAL_OID_TIPO_MOVI_ALMA = " + tipoAlmacen );
          }
          query.append(" and cab.PERD_OID_PERI_RECL = periodo.OID_PERI ");
          query.append(" and cab.SOCA_OID_SOLI_CABE = solCab.OID_SOLI_CABE ");
          query.append(" and solCab.SBAC_OID_SBAC = subAcc.OID_SBAC ");          
          query.append(" order by  cab.NUM_ATEN ");
          
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }       
          UtilidadesLog.debug("rs: " + rs);          
          UtilidadesLog.info("DAOGestionRecojo.movimientoAlmacen(ArrayList numValoresProcesado): Salida");
          return rs; 
  }
  
    /**
      * Sistema:     Belcorp
      * Modulo:      REC
      * Fecha:       07/08/2009
      * @version     1.0
      * @autor       Emilio Noziglia
      * Cambio 20080765
      */  
    public ArrayList obtenerBoletasRecojoOrigen(String boletasConsolidadas) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoOrigen(String boletasConsolidadas):Entrada");
        RecordSet rs;
        ArrayList boletasOrigen = new ArrayList();
        
        BelcorpService bs = getBelcorpService();      
        StringBuffer query = new StringBuffer();

        query.append(" SELECT BR.NUM_BOLE ");
        query.append(" FROM REC_BOLET_RECOJ BR ");
        query.append(" WHERE BR.BORE_OID_BOLE_RECO IN (SELECT BR2.OID_BOLE_RECO ");
                                        query.append(" FROM REC_BOLET_RECOJ BR2 ");
                                        query.append(" WHERE BR2.NUM_BOLE IN ("+boletasConsolidadas+") ) ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());      
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error(((MareException) e).getOriginalCause());
                throw (MareException) e;
            } else {
                UtilidadesLog.error(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        
        if (!rs.esVacio()) {
            int cantRegs = rs.getRowCount();            
            if (cantRegs>0) {
              for (int i=0; i<cantRegs; i++) {
                    Long nroBoleta = new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue());
                    DTOBoletaRecojoTemporal dtoB = new DTOBoletaRecojoTemporal();
                    dtoB.setNumeroBoleta(nroBoleta);
                    boletasOrigen.add(dtoB);
              }
            }
        }
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoOrigen(String boletasConsolidadas):Salida");
        return boletasOrigen;
    }  
    
    /**
     * Cambio 20080765
     * Busca todos los clientes pertenecientes a la zona recibida por parametro
     * que tengan boletas de recojo sin consolidar/imprimir. Considera solo las boletas
     * que tienen al menos un producto recogible.
     * @param oidZona OID de la zona donde buscar clientes
     * @return array con los OIDs de clientes con boletas de recojo sin consolidar/imprimir
     * @throws MareException
     * @author dmorello
     * @since 18/08/2009
     */
    public Long[] obtenerClientesBoletasRecojoPorZona(Long oidZona) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerClientesBoletasRecojoPorZona(Long oidZona): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT DISTINCT cabrec.clie_oid_clie");
        query.append("  FROM rec_bolet_recoj boleta");
        query.append("     , rec_cabec_recla cabrec");
        query.append("     , mae_clien_datos_adici datos");
        query.append("     , mae_clien_unida_admin ua");
        query.append("     , zon_terri_admin tad");
        query.append("     , zon_secci secc");
        query.append("     , rec_opera_recla oper");
        query.append("     , rec_linea_opera_recla linea");
        query.append("     , ped_solic_posic pos");
        query.append("     , rec_tipo_movim tmov");
        query.append(" WHERE boleta.bore_oid_bole_reco IS NULL");
        query.append("   AND NVL(boleta.ind_impr,'N') = 'N'");
        query.append("   AND boleta.care_oid_cabe_recl = cabrec.oid_cabe_recl");
        query.append("   AND cabrec.clie_oid_clie = datos.clie_oid_clie");
        query.append("   AND datos.ind_acti = 1");
        query.append("   AND cabrec.clie_oid_clie = ua.clie_oid_clie");
        query.append("   AND ua.ind_acti = 1");
        query.append("   AND ua.ztad_oid_terr_admi = tad.oid_terr_admi");
        query.append("   AND tad.zscc_oid_secc = secc.oid_secc");
        query.append("   AND secc.zzon_oid_zona = ").append(oidZona);
        query.append("   AND cabrec.oid_cabe_recl = oper.care_oid_cabe_recl");
        query.append("   AND oper.oid_oper_recl = linea.opre_oid_oper_recl");
        query.append("   AND linea.sopo_oid_soli_posi = pos.oid_soli_posi");
        query.append("   AND linea.timo_oid_tipo_movi = tmov.oid_tipo_movi");
        query.append("   AND tmov.cod_tipo_movi = '").append(ConstantesREC.MOVIMIENTO_DEVUELVE).append('\'');
        query.append("   AND pos.val_codi_vent NOT IN (");
        query.append("          SELECT pod.val_codi_vent");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 pre_ofert_detal pod,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.ofde_oid_deta_ofer = pod.oid_deta_ofer");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");
        query.append("   AND TO_CHAR (pos.val_codi_vent_fict) NOT IN (");
        query.append("          SELECT ail.cod_vent_fict");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 inc_artic_lote ail,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.arlo_oid_arti_lote = ail.oid_arti_lote");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long[] oids = null;
        
        if (rs != null) {
            int count = rs.getRowCount();
            oids = new Long[count];
            for (int i = 0; i < count; i++) {
                oids[i] = UtilidadesBD.convertirALong(rs.getValueAt(i, "CLIE_OID_CLIE"));
            }
        } else {
            oids = new Long[0];
        }
        
        UtilidadesLog.debug("oids.length: " + oids.length);
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerClientesBoletasRecojoPorZona(Long oidZona): Salida");
        return oids;
    }
    
    
    /**
     * Cambio 20080765
     * Busca todas las boletas de recojo sin consolidar/imprimir
     * que correspondan al cliente recibido por parametro
     * @param oidCliente OID del cliente para el cual se buscan boletas de recojo
     * @return array con los OIDs de las boletas de recojo halladas
     * @throws MareException
     * @author dmorello
     * @since 18/08/2009
     */
    public Long[] obtenerBoletasRecojoSinConsolidar(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoSinConsolidar(Long oidCliente): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT DISTINCT boleta.oid_bole_reco");
        query.append("  FROM rec_cabec_recla cabrec");
        query.append("     , rec_bolet_recoj boleta");
        query.append("     , rec_opera_recla oper");
        query.append("     , rec_linea_opera_recla linea");
        query.append("     , ped_solic_posic pos");
        query.append("     , rec_tipo_movim tmov");
        query.append(" WHERE cabrec.clie_oid_clie = ").append(oidCliente);
        query.append("   AND cabrec.oid_cabe_recl = boleta.care_oid_cabe_recl");
        query.append("   AND boleta.bore_oid_bole_reco IS NULL");
        query.append("   AND NVL(boleta.ind_impr,'N') = 'N'");
        query.append("   AND cabrec.oid_cabe_recl = oper.care_oid_cabe_recl");
        query.append("   AND oper.oid_oper_recl = linea.opre_oid_oper_recl");
        query.append("   AND linea.sopo_oid_soli_posi = pos.oid_soli_posi");
        query.append("   AND linea.timo_oid_tipo_movi = tmov.oid_tipo_movi");
        query.append("   AND tmov.cod_tipo_movi = '").append(ConstantesREC.MOVIMIENTO_DEVUELVE).append('\'');
        query.append("   AND pos.val_codi_vent NOT IN (");
        query.append("          SELECT pod.val_codi_vent");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 pre_ofert_detal pod,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.ofde_oid_deta_ofer = pod.oid_deta_ofer");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");
        query.append("   AND TO_CHAR (pos.val_codi_vent_fict) NOT IN (");
        query.append("          SELECT ail.cod_vent_fict");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 inc_artic_lote ail,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.arlo_oid_arti_lote = ail.oid_arti_lote");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");        
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long[] oidsBoletas = null;
        
        if (rs != null) {
            int count = rs.getRowCount();
            oidsBoletas = new Long[count];
            for (int i = 0; i < count; i++) {
                oidsBoletas[i] = UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_BOLE_RECO"));
            }
        } else {
            oidsBoletas = new Long[0];
        }
        
        UtilidadesLog.debug("oidsBoletas.length: " + oidsBoletas.length);
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerBoletasRecojoSinConsolidar(Long oidCliente): Salida");
        return oidsBoletas;
    }
    
    
    /**
     * Cambio 20080765
     * Obtiene los OIDs de las posiciones de solicitud correspondientes a las
     * boletas de recojo cuyos OIDs recibe por parametro.
     * @param oidsBoletas array con OIDs de boletas de recojo
     * @return RecordSet con OIDs de posiciones de solicitud
     * @throws MareException
     * @author dmorello
     * @since 18/08/2009
     */
    public RecordSet obtenerPosicionesBoletasRecojo(Long[] oidsBoletas) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerPosicionesBoletasRecojo(Long[] oidsBoletas): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        // Armo el IN de boletas de recojo para la query
        StringBuffer in = new StringBuffer();
        in.append('(');
        for (int i = 0; i < oidsBoletas.length; i++) {
            in.append(oidsBoletas[i]);
            if (i < oidsBoletas.length - 1) {
                in.append(',');
            }
        }
        in.append(')');
        
        query.append("SELECT linea.sopo_oid_soli_posi");
        query.append("  FROM rec_bolet_recoj boleta");
        query.append("     , rec_opera_recla oper");
        query.append("     , rec_linea_opera_recla linea");
        query.append("     , ped_solic_posic pos");
        query.append("     , rec_tipo_movim tmov");
        query.append(" WHERE boleta.oid_bole_reco IN ").append(in.toString());
        query.append("   AND boleta.care_oid_cabe_recl = oper.care_oid_cabe_recl");
        query.append("   AND oper.oid_oper_recl = linea.opre_oid_oper_recl");
        query.append("   AND linea.sopo_oid_soli_posi = pos.oid_soli_posi");
        query.append("   AND linea.timo_oid_tipo_movi = tmov.oid_tipo_movi");
        query.append("   AND tmov.cod_tipo_movi = '").append(ConstantesREC.MOVIMIENTO_DEVUELVE).append('\'');
        query.append("   AND pos.val_codi_vent NOT IN (");
        query.append("          SELECT pod.val_codi_vent");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 pre_ofert_detal pod,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.ofde_oid_deta_ofer = pod.oid_deta_ofer");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");
        query.append("   AND TO_CHAR (pos.val_codi_vent_fict) NOT IN (");
        query.append("          SELECT ail.cod_vent_fict");
        query.append("            FROM rec_produ_no_recog pnr,");
        query.append("                 inc_artic_lote ail,");
        query.append("                 ped_solic_cabec psc");
        query.append("           WHERE pnr.arlo_oid_arti_lote = ail.oid_arti_lote");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe");
        query.append("             )");        
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerPosicionesBoletasRecojo(Long[] oidsBoletas): Salida");
        return rs;
    }
    
    
    
    /**
     * Cambio 20080765
     * Obtiene el OID del estado recojo (tabla REC_ESTAD_RECOJ)
     * cuyo codigo se recibe por parametro
     * @param codigo Codigo estado recojo a buscar
     * @return OID del estado recuperado
     * @throws MareException
     * @author dmorello
     * @since 21/08/2009
     */
    public Long obtenerEstadoRecojo(String codigo) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerEstadoRecojo(String codigo): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT oid_esta_reco");
        query.append("  FROM rec_estad_recoj e");
        query.append(" WHERE val_codi = '").append(codigo).append('\'');
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long oidEstado = UtilidadesBD.convertirALong(rs.getValueAt(0,0));
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerEstadoRecojo(String codigo): Salida");
        return oidEstado;
    }
    
    /**
     * Inserta en REC_BOLET_RECOJ un registro de tipo "consolidado"
     * con los datos del DTO de entrada.
     * @param dtoe DTO con datos para el consolidado de boletas de recojo
     * @return OID del consolidado insertado
     * @throws MareException
     * @author dmorello
     * @since 18/08/2009
     */
    public Long insertarConsolidadoBoletaRecojo(DTOConsolidarBoletasRecojo dtoe) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.insertarConsolidadoBoletaRecojo(DTOConsolidarBoletasRecojo dtoe): Entrada");
        UtilidadesLog.debug("dtoe: " + dtoe);
        
        Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_BORE_SEQ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strFechaRecojo = sdf.format(dtoe.getFechaRecojo());
        
        int indPedidoServ;
        if (Boolean.TRUE.equals(dtoe.getIndPedidoServicio())) {
            indPedidoServ = 1;
        } else {
            indPedidoServ = 0;
        }
        
        insert.append("INSERT INTO REC_BOLET_RECOJ (");
        insert.append("  OID_BOLE_RECO");
        insert.append(", FEC_CAPT");
        insert.append(", FEC_EMIS");
        insert.append(", FEC_RECO");
        insert.append(", NUM_FACT");
        insert.append(", IND_PEDI_SERV");
        insert.append(", NUM_BOLE");
        insert.append(", CARE_OID_CABE_RECL");
        insert.append(", EREC_OID_ESTA_RECO");
        insert.append(", NURE_OID_NUME_RECO");
        insert.append(", BORE_OID_BOLE_RECO");
        insert.append(", IND_IMPR");
        insert.append(") VALUES (");
        insert.append(oid);                                     // OID_BOLE_RECO
        insert.append(",NULL");                                 // FEC_CAPT
        insert.append(",TRUNC(SYSDATE)");                       // FEC_EMIS
        insert.append(",TO_DATE('").append(strFechaRecojo)
            .append("', 'DD/MM/YYYY')");                        // FEC_RECO
        insert.append(',').append(dtoe.getNumeroFactura());     // NUM_FACT
        insert.append(",'").append(indPedidoServ).append('\''); // IND_PEDI_SERV
        insert.append(',').append(dtoe.getNumeroBoleta());      // NUM_BOLE
        insert.append(",NULL");                                 // CARE_OID_CABE_RECL
        insert.append(',').append(dtoe.getOidEstadoRecojo());   // EREC_OID_ESTA_RECO
        insert.append(",NULL");                                 // NURE_OID_NUME_RECO
        insert.append(",NULL");                                 // BORE_OID_BOLE_RECO
        insert.append(",'S'");                                  // IND_IMPR
        insert.append(");");
        
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insert.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOGestionRecojos.insertarConsolidadoBoletaRecojo(DTOConsolidarBoletasRecojo dtoe): Salida");
        return oid;
    }
    
    
    /**
     * Cambio 20080765
     * Actualiza boletas de recojo asignandoles un OID de boleta consolidado
     * y marcandolas como impresas.
     * @param oidsBoletas array con los OIDs de boletas a actualizar
     * @param oidConsolidado OID de la boleta consolidado
     * @throws MareException
     * @author dmorello
     * @since 19/08/2009
     */
    public void actualizarBoletasRecojoConsolidado(Long[] oidsBoletas, Long oidConsolidado)
            throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.actualizarBoletasRecojoConsolidado(Long[] oidsBoletas, Long oidConsolidado): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE REC_BOLET_RECOJ");
        update.append("   SET IND_IMPR = 'S', BORE_OID_BOLE_RECO = ").append(oidConsolidado);
        update.append(" WHERE OID_BOLE_RECO IN (");
        for (int i = 0; i < oidsBoletas.length; i++) {
            update.append(oidsBoletas[i]);
            if (i < oidsBoletas.length - 1) {
                update.append(',');
            }
        }
        update.append(")");
        
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOGestionRecojos.actualizarBoletasRecojoConsolidado(Long[] oidsBoletas, Long oidConsolidado): Salida");
    }
    
    
    /**
     * Cambio 20080765
     * Actualiza el DTO de entrada seteando los atributos: barrio, departamento,
     * municipio, telefonoCelular, telefonoFijo, primerPedido, listaPosiciones,
     * listaDetalle.
     * Estos atributos se setean con los valores correspondientes al cliente cuyo
     * OID se recibe en dtoe.oidCliente
     * @param dtoe DTOConsolidarBoletasRecojo con campo oidCliente no nulo
     * @return DTOFACDocumentoContableCabecera con la info recuperada
     * @throws MareException
     * @author dmorello
     * @since 19/08/2009
     */
    public DTOFACDocumentoContableCabecera completarDatosBoletaRecojo(DTOConsolidarBoletasRecojo dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOGestionRecojos.completarDatosBoletaRecojo(DTOFACDocumentoContableCabecera dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        // Busco informacion personal del cliente
        query.append("SELECT dir.val_barr");
        query.append("     , CASE WHEN pip.ind_busq_tele = 1 THEN");
        query.append("           (SELECT mcc.val_text_comu");
        query.append("              FROM mae_clien_comun mcc,");
        query.append("                   mae_tipo_comun mtc");
        query.append("             WHERE mcc.ticm_oid_tipo_comu = mtc.oid_tipo_comu");
        query.append("               AND mtc.cod_tipo_comu = 'TF'");
        query.append("               AND mcc.clie_oid_clie = cli.oid_clie)");
        query.append("       END AS telef_fijo");
        query.append("     , CASE WHEN pip.ind_busq_tele = 1 THEN");
        query.append("           (SELECT mcc.val_text_comu");
        query.append("              FROM mae_clien_comun mcc,");
        query.append("                   mae_tipo_comun mtc");
        query.append("             WHERE mcc.ticm_oid_tipo_comu = mtc.oid_tipo_comu");
        query.append("               AND mtc.cod_tipo_comu = 'TC'");
        query.append("               AND mcc.clie_oid_clie = cli.oid_clie)");
        query.append("       END AS telef_cel");
        query.append("     , (SELECT RTRIM(des_geog)");
        query.append("          FROM zon_valor_estru_geopo");
        query.append("         WHERE orde_1 = SUBSTR (dir.cod_unid_geog, 0, 6)");
        query.append("           AND orde_2 IS NULL) departamento");
        query.append("     , (SELECT des_geog");
        query.append("          FROM zon_valor_estru_geopo");
        query.append("         WHERE orde_1 = SUBSTR (dir.cod_unid_geog, 0, 6)");
        query.append("           AND orde_2 = SUBSTR (dir.cod_unid_geog, 7, 6)");
        query.append("           AND orde_3 IS NULL) municipio");
        query.append("     , CASE WHEN mec.cod_esta_clie IN ('01', '07')");
        query.append("          THEN '* PRIMER PEDIDO *'");
        query.append("          ELSE (SELECT val_text_vari");
        query.append("                  FROM (SELECT   ctv.val_text_vari");
        query.append("                          FROM ape_confi_texto_varia ctv,");
        query.append("                                 (SELECT mts.ticl_oid_tipo_clie,");
        query.append("                                         mts.sbti_oid_subt_clie,");
        query.append("                                         mcc.clas_oid_clas,");
        query.append("                                         mcc.tccl_oid_tipo_clasi");
        query.append("                                    FROM mae_clien_tipo_subti mts,");
        query.append("                                         mae_clien_clasi mcc");
        query.append("                                   WHERE mcc.ctsu_oid_clie_tipo_subt = mts.oid_clie_tipo_subt");
        query.append("                                     AND mts.clie_oid_clie = 1) clien");
        query.append("                           WHERE ctv.ticl_oid_tipo_clie = clien.ticl_oid_tipo_clie");
        query.append("                             AND (   ctv.sbti_oid_subt_clie = clien.sbti_oid_subt_clie");
        query.append("                                  OR ctv.sbti_oid_subt_clie IS NULL");
        query.append("                                 )");
        query.append("                             AND (   ctv.clas_oid_clas = clien.clas_oid_clas");
        query.append("                                  OR ctv.clas_oid_clas IS NULL");
        query.append("                                 )");
        query.append("                             AND (   ctv.tccl_oid_tipo_clas = clien.tccl_oid_tipo_clasi");
        query.append("                                  OR ctv.tccl_oid_tipo_clas IS NULL");
        query.append("                                 )");
        query.append("                        ORDER BY ctv.ticl_oid_tipo_clie,");
        query.append("                                 ctv.sbti_oid_subt_clie,");
        query.append("                                 ctv.tccl_oid_tipo_clas,");
        query.append("                                 ctv.clas_oid_clas)");
        query.append("                 WHERE ROWNUM = 1)");
        query.append("       END pri_ped");
        query.append("  FROM mae_clien cli,");
        query.append("       seg_param_inter_pais pip,");
        query.append("       mae_clien_direc dir,");
        query.append("       mae_clien_datos_adici dat,");
        query.append("       mae_estat_clien mec");
        query.append(" WHERE cli.oid_clie = ").append(dtoe.getOidCliente());
        query.append("   AND cli.pais_oid_pais = pip.pais_oid_pais(+)");
        query.append("   AND dir.clie_oid_clie = cli.oid_clie");
        query.append("   AND dir.ind_dire_ppal = 1");
        query.append("   AND dir.ind_elim = 0");
        query.append("   AND cli.oid_clie = dat.clie_oid_clie");
        query.append("   AND dat.esta_oid_esta_clie = mec.oid_esta_clie(+)");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        DTOFACDocumentoContableCabecera dtoCab = new DTOFACDocumentoContableCabecera();
        dtoCab.setBarrio(UtilidadesBD.convertirAString(rs.getValueAt(0, "VAL_BARR")));
        dtoCab.setTelefonoFijo(UtilidadesBD.convertirAString(rs.getValueAt(0, "TELEF_FIJO")));
        dtoCab.setTelefonoCelular(UtilidadesBD.convertirAString(rs.getValueAt(0, "TELEF_CEL")));
        dtoCab.setDepartamento(UtilidadesBD.convertirAString(rs.getValueAt(0, "DEPARTAMENTO")));
        dtoCab.setMunicipio(UtilidadesBD.convertirAString(rs.getValueAt(0, "MUNICIPIO")));
        dtoCab.setPrimerPedido(UtilidadesBD.convertirAString(rs.getValueAt(0, "PRI_PED")));
        
        UtilidadesLog.info("DAOGestionRecojos.completarDatosBoletaRecojo(DTOFACDocumentoContableCabecera dtoe): Salida");
        return dtoCab;
    }
    
    public ArrayList obtenerSolicitudesOrigenBoletas(Long[] oidsBoletas) throws MareException {
        UtilidadesLog.info("DAOGestionRecojos.obtenerSolicitudesOrigenBoletas(Long[] oidsBoletas): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        StringBuffer in = new StringBuffer(Arrays.deepToString(oidsBoletas));
        in.setCharAt(0,'(');
        in.setCharAt(in.length()-1,')');
        
        //query.append("SELECT DISTINCT cabrec.soca_oid_soli_cabe");
        //query.append("  FROM rec_bolet_recoj boleta, rec_cabec_recla cabrec");
        //query.append(" WHERE boleta.oid_bole_reco IN ").append(in);
        //query.append("   AND boleta.care_oid_cabe_recl = cabrec.oid_cabe_recl");
        
        // Plan A
        /*query.append("SELECT DISTINCT soop.soca_oid_soli_cabe");
        query.append("  FROM rec_bolet_recoj boleta");
        query.append("     , rec_opera_recla opre");
        query.append("     , rec_solic_opera soop");
        query.append(" WHERE boleta.oid_bole_reco IN ").append(in);
        query.append("   AND boleta.care_oid_cabe_recl = opre.care_oid_cabe_recl");
        query.append("   AND opre.oid_oper_recl = soop.opre_oid_oper_recl");*/
        
        // Plan B
        query.append("SELECT sol.oid_soli_cabe AS soca_oid_soli_cabe");
        query.append("  FROM rec_bolet_recoj boleta");
        query.append("     , rec_cabec_recla cabrec");
        query.append("     , ped_solic_cabec sol");
        query.append(" WHERE boleta.oid_bole_reco IN ").append(in);
        query.append("   AND boleta.care_oid_cabe_recl = cabrec.oid_cabe_recl");
        query.append("   AND cabrec.soca_oid_soli_cabe = sol.soca_oid_docu_refe");
        query.append("   AND SOL.IND_TS_NO_CONSO = 1");
         
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        ArrayList oidsSolicitudes = new ArrayList();
        for (int i = 0; i < rs.getRowCount(); i++) {
            oidsSolicitudes.add(UtilidadesBD.convertirALong(rs.getValueAt(i,0)));
        }
        
        UtilidadesLog.debug("oidsSolicitudes: " + oidsSolicitudes);
        
        UtilidadesLog.info("DAOGestionRecojos.obtenerSolicitudesOrigenBoletas(Long[] oidsBoletas): Salida");
        return oidsSolicitudes;
    }
}

