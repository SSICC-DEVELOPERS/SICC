/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.com;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.com.DTOComisionesAccesos;
import es.indra.sicc.dtos.com.DTOComisionesClientes;
import es.indra.sicc.dtos.com.DTOComisionesCobranza;
import es.indra.sicc.dtos.com.DTOComisionesCobranzaTipoParticipante;
import es.indra.sicc.dtos.com.DTOComisionesProductos;
import es.indra.sicc.dtos.com.DTOComisionesVentas;
import es.indra.sicc.dtos.com.DTOComisionesVentasHistoricas;
import es.indra.sicc.dtos.com.DTOObtenerTramos;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.com.DTOComisionesEscalonada;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.com.DTORepCargaComision;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            COM
 * Componente:        DAOMantenimientoComisiones
 * Fecha:             16/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       
 * @version           1.0
 * @autor             
 */
public class DAOMantenimientoComisiones {

  public DAOMantenimientoComisiones() {
  }


  /** 
  * Metodo consultarComisionesAccesos  
  * @return ArrayList
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public ArrayList consultarComisionesAccesos(DTOOID dto) throws MareException {
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesAccesos(DTOOID dto): Entrada");
    ArrayList respuesta = new ArrayList();
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
  
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
  
    query.append(" SELECT A.ACCE_OID_ACCE, ");
    query.append(" C.PLCA_OID_PLAN_COMI_ACCE, ");
    query.append(" C.COMI_OID_COMI ");
    query.append(" FROM COM_COMIS_ACCES C, ");
    query.append(" COM_PLANT_COMIS_ACCES A ");
    query.append(" WHERE COMI_OID_COMI = " + dto.getOid());
    query.append(" AND C.PLCA_OID_PLAN_COMI_ACCE = A.OID_PLAN_COMI_ACCE ");
    
    UtilidadesLog.debug(query.toString());
  
    try {
         rs = bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            DTOComisionesAccesos dTOComisionesAccesos = new DTOComisionesAccesos();
            
            Long oid;
            if(rs.getValueAt(i, "ACCE_OID_ACCE")!=null) {
              oid = new Long(((BigDecimal) rs.getValueAt(i, "ACCE_OID_ACCE")).longValue());  
            }
            else {
              oid = null;
            }            
            dTOComisionesAccesos.setOid(oid);

            Long oidPlantillaComisionesAccesos;
            if(rs.getValueAt(i, "PLCA_OID_PLAN_COMI_ACCE")!=null) {
              oidPlantillaComisionesAccesos = new Long(((BigDecimal) rs.getValueAt(i, "PLCA_OID_PLAN_COMI_ACCE")).longValue());  
            }
            else {
              oidPlantillaComisionesAccesos = null;
            }            
            dTOComisionesAccesos.setOidPlantillaComisionesAccesos(oidPlantillaComisionesAccesos);

            Long oidComisiones;
            if(rs.getValueAt(i, "COMI_OID_COMI")!=null) {
              oidComisiones = new Long(((BigDecimal) rs.getValueAt(i, "COMI_OID_COMI")).longValue());  
            }
            else {
              oidComisiones = null;
            }            
            dTOComisionesAccesos.setOidComisiones(oidComisiones);
                                    
            respuesta.add(dTOComisionesAccesos);
          }
         
         }
            
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }  
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesAccesos(DTOOID dto): Salida");
    return respuesta;
  }
  
  /** 
  * Metodo consultarComisionesCobranzas  
  * @return ArrayList
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public ArrayList consultarComisionesCobranzas(DTOOID dto) throws MareException{
      UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesCobranzas(DTOOID dto): Entrada");
      ArrayList respuesta = new ArrayList();
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
      query.append(" SELECT C.OID_COMI_COBR, C.NUM_DIAS_TRAS_FACT, C.COMI_OID_COMI, C.TPAR_OID_TIPO_PART ");
      query.append(" FROM COM_COMIS_COBRA C ");          
      query.append(" WHERE C.COMI_OID_COMI = "+ dto.getOid());
      UtilidadesLog.debug(query.toString());
      
      try {
             rs = bs.dbService.executeStaticQuery(query.toString());
             if(!rs.esVacio()){
              for(int i=0;i<rs.getRowCount();i++){
                
                DTOComisionesCobranza dTOComisionesCobranza = new DTOComisionesCobranza();
                
                Integer diasTrasFacturacion;
                if(rs.getValueAt(i, "NUM_DIAS_TRAS_FACT")!=null) {
                  diasTrasFacturacion = new Integer(((BigDecimal) rs.getValueAt(i, "NUM_DIAS_TRAS_FACT")).intValue());  
                }
                else {
                  diasTrasFacturacion = null;
                }                
                dTOComisionesCobranza.setDiasTrasFacturacion(diasTrasFacturacion);//NUM_DIAS_TRAS_FACT
                
                Long oidTipoParticipante;
                if(rs.getValueAt(i, "TPAR_OID_TIPO_PART")!=null) {
                  oidTipoParticipante = new Long(((BigDecimal) rs.getValueAt(i, "TPAR_OID_TIPO_PART")).longValue());  
                }
                else {
                  oidTipoParticipante = null;
                }                
                dTOComisionesCobranza.setOidTipoParticipante(oidTipoParticipante);//TPAR_OID_TIPO_PART
                
                Long oid;
                if(rs.getValueAt(i, "OID_COMI_COBR")!=null) {
                  oid = new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_COBR")).longValue());  
                }
                else {
                  oid = null;
                }               
                dTOComisionesCobranza.setOid(oid);//OID_COMI_COBR
                
                Long oidComisiones;
                if(rs.getValueAt(i, "COMI_OID_COMI")!=null) {
                  oidComisiones = new Long(((BigDecimal) rs.getValueAt(i, "COMI_OID_COMI")).longValue());  
                }
                else {
                  oidComisiones = null;
                }                
                dTOComisionesCobranza.setOidComisiones(oidComisiones);//COMI_OID_COMI
                
                DTOOID dtoOid = new DTOOID();
                dtoOid.setOid(oid);
                
                dTOComisionesCobranza.setComisionesCobranzasTipoParticipante(consultarComisionesCobranzasTipoParticipante(dtoOid) );

                // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010                
                dTOComisionesCobranza.setComisionesEscalonada(consultarComisionesEscalonada(dtoOid) );                
                            
                respuesta.add(dTOComisionesCobranza);
              }
             
             }
                
         }catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }  
        UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesCobranzas(DTOOID dto): Salida");
        return respuesta;
  }
  
  /** 
  * Metodo consultarComisionesCobranzasTipoParticipante
  * @return ArrayList
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public ArrayList consultarComisionesCobranzasTipoParticipante(DTOOID dto) throws MareException{
  UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesCobranzasTipoParticipante(DTOOID dto): Entrada");
  ArrayList respuesta = new ArrayList();
  StringBuffer query = new StringBuffer();
  RecordSet rs = new RecordSet();
  
  BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
  query.append(" SELECT C.OID_COMI_COBR_TIPO_PART, C.VAL_NIVE_TRAM, C.NUM_DIAS_COMI, C.VAL_PORC_RECU, C.COCO_OID_COMI_COBR, C.VAL_PORC_COMI, C.VAL_PORC_ACTI, C.VAL_PORC_COMI_ACTI ");
  query.append(" FROM COM_COMIS_COBRA_TIPO_PARTI C ");          
  query.append(" WHERE C.COCO_OID_COMI_COBR = "+ dto.getOid());
  UtilidadesLog.debug(query.toString());
  
  try {
         rs = bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            DTOComisionesCobranzaTipoParticipante dTOComisionesCobranzaTipoParticipante = new DTOComisionesCobranzaTipoParticipante();

            Integer nivelTramo;
            if(rs.getValueAt(i, "VAL_NIVE_TRAM")!=null) {
              nivelTramo = new Integer(((BigDecimal) rs.getValueAt(i, "VAL_NIVE_TRAM")).intValue());  
            }
            else {
              nivelTramo = null;
            }            
            dTOComisionesCobranzaTipoParticipante.setNivelTramo(nivelTramo);//VAL_NIVE_TRAM
            
            Integer diasComision;
            if(rs.getValueAt(i, "NUM_DIAS_COMI")!=null) {
              diasComision = new Integer(((BigDecimal) rs.getValueAt(i, "NUM_DIAS_COMI")).intValue());  
            }
            else {
              diasComision = null;
            }            
            dTOComisionesCobranzaTipoParticipante.setDiasComision(diasComision);//NUM_DIAS_COMI
            
            BigDecimal valor;
            if(rs.getValueAt(i, "VAL_PORC_RECU")!=null) {
              valor = (BigDecimal) rs.getValueAt(i, "VAL_PORC_RECU");
            }
            else {
              valor = null;
            }            
            dTOComisionesCobranzaTipoParticipante.setPorcentajeRecuperacion(valor);//VAL_PORC_RECU
            
            Long oid;
            if(rs.getValueAt(i, "OID_COMI_COBR_TIPO_PART")!=null) {
              oid = new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_COBR_TIPO_PART")).longValue());  
            }
            else {
              oid = null;
            }            
            dTOComisionesCobranzaTipoParticipante.setOid(oid);//OID_COMI_COBR_TIPO_PART
            
            Long oidComisionesCobranzas;
            if(rs.getValueAt(i, "COCO_OID_COMI_COBR")!=null) {
              oidComisionesCobranzas = new Long(((BigDecimal) rs.getValueAt(i, "COCO_OID_COMI_COBR")).longValue());  
            }
            else {
              oidComisionesCobranzas = null;
            }           
            dTOComisionesCobranzaTipoParticipante.setOidComisionesCobranzas(oidComisionesCobranzas);//COCO_OID_COMI_COBR

//-----------

            BigDecimal porcentajeComision;
            if(rs.getValueAt(i, "VAL_PORC_COMI")!=null) {
              porcentajeComision = (BigDecimal) rs.getValueAt(i, "VAL_PORC_COMI");
            }
            else {
              porcentajeComision = null;
            }           
            dTOComisionesCobranzaTipoParticipante.setPorcentajeComision(porcentajeComision);     
//VAL_PORC_COMI               

            // vbongiov -- Cambio 20090913 -- 5/08/2009
            BigDecimal porcentajeActividad;
            if(rs.getValueAt(i, "VAL_PORC_ACTI")!=null) {
              porcentajeActividad = (BigDecimal) rs.getValueAt(i, "VAL_PORC_ACTI");
            }
            else {
              porcentajeActividad = null;
            }           
            dTOComisionesCobranzaTipoParticipante.setPorcentajeActividad(porcentajeActividad);     

            // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
            BigDecimal porcentajeComisionActividad;
            if(rs.getValueAt(i, "VAL_PORC_COMI_ACTI")!=null) {
              porcentajeComisionActividad = (BigDecimal) rs.getValueAt(i, "VAL_PORC_COMI_ACTI");
            }
            else {
              porcentajeComisionActividad = null;
            }           
            dTOComisionesCobranzaTipoParticipante.setPorcentajeComisionActividad(porcentajeComisionActividad);     
                                    
            respuesta.add(dTOComisionesCobranzaTipoParticipante);
          }
         
         }
            
     }catch (Exception e) {//SIEMPRE VA ESTE ERROR ACA??????
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }  
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesCobranzasTipoParticipante(DTOOID dto): Salida");
    return respuesta;
    
  }
  
  /** 
  * Metodo consultarComisionesProductos
  * @return ArrayList
  * @exception MareException 
  * @author Carlos Leal
  * @modificado Cristian Valenzuela
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public ArrayList consultarComisionesProductos(DTOOID dto) throws MareException{
  UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesProductos(DTOOID dto): Entrada");
  ArrayList respuesta = new ArrayList();
  StringBuffer query = new StringBuffer();
  RecordSet rs = new RecordSet();
  
  BelcorpService bs = UtilidadesEJB.getBelcorpService();
  
  query.append(" SELECT ");
  query.append(" C.OID_COMI_PROD, ");
  query.append(" C.COD_COMI_PROD, "); 
  query.append(" C.COMI_OID_COMI, "); 
  query.append(" C.SGEN_OID_SUPE_GENE, "); 
  query.append(" C.NEGO_OID_NEGO, "); 
  query.append(" C.GENE_OID_GENE, "); 
  query.append(" C.UNEG_OID_UNID_NEGO, "); 
  query.append(" C.MAPR_OID_MARC_PROD, "); 
  query.append(" C.CIVI_OID_CICL_VIDA, "); 
  query.append(" C.TOFE_OID_TIPO_OFER, "); 
  query.append(" C.PROD_OID_PROD, ");
  query.append(" C.TPRO_OID_TIPO_PROD, ");
  query.append(" C.TIPS_OID_TIPO_INSE_PROD, ");
  query.append(" C.COPR_OID_COMI_PROD, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V2 ");
  query.append(" WHERE V2.VAL_OID = C.TPRO_OID_TIPO_PROD ");
  query.append(" AND V2.ATTR_ENTI = 'COM_TIPO_PRODU' ");
  query.append(" AND V2.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V2.ATTR_NUM_ATRI = 1 ");	
  query.append(" ) AS TIPOPRODUCTO, ");
  query.append(" PRODU.COD_SAP AS CODIGOPRODUCTO, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V3 ");
  query.append(" WHERE V3.VAL_OID = C.TOFE_OID_TIPO_OFER ");
  query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
  query.append(" AND V3.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V3.ATTR_NUM_ATRI = 1 ");
  query.append(" )AS TIPOOFERTA, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V4 ");
  query.append(" WHERE V4.VAL_OID = C.CIVI_OID_CICL_VIDA ");
  query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA' "); 
  query.append(" AND V4.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V4.ATTR_NUM_ATRI = 1  ");          
  query.append(" ) AS CICLOVIDA,  "); 
  query.append(" MARCA.DES_MARC_PROD AS MARCA, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V5 ");
  query.append(" WHERE V5.VAL_OID = C.UNEG_OID_UNID_NEGO ");    
  query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC' "); 
  query.append(" AND V5.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V5.ATTR_NUM_ATRI = 1  ");  
  query.append(" ) AS UNIDADNEGOCIO, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V6 ");
  query.append(" WHERE V6.VAL_OID = C.NEGO_OID_NEGO ");
  query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC' ");
  query.append(" AND V6.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V6.ATTR_NUM_ATRI = 1 ");
  query.append(" ) AS NEGOCIO, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V7 ");
  query.append(" WHERE V7.VAL_OID = C.SGEN_OID_SUPE_GENE ");
  query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER' ");
  query.append(" AND V7.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V7.ATTR_NUM_ATRI = 1 ");
  query.append(" ) AS SUPERGENERICO, ");
  query.append(" (SELECT VAL_I18N ");
  query.append(" FROM V_GEN_I18N_SICC V8 ");
  query.append(" WHERE  V8.VAL_OID = C.GENE_OID_GENE ");
  query.append(" AND V8.ATTR_ENTI = 'MAE_GENER' ");
  query.append(" AND V8.IDIO_OID_IDIO = " + dto.getOidIdioma());
  query.append(" AND V8.ATTR_NUM_ATRI = 1 ");
  query.append(" ) AS GENERICO ");
  query.append(" FROM COM_COMIS_PRODU C, ");
  query.append(" COM_TIPO_INSER_PRODU T, ");
  query.append(" COM_TIPO_PRODU P, ");
  query.append(" MAE_PRODU PRODU, ");
  query.append(" SEG_MARCA_PRODU MARCA, ");
  query.append(" MAE_UNIDA_NEGOC UNIDAD, ");
  query.append(" PRE_TIPO_OFERT OFERTA, ");
  query.append(" MAE_CICLO_VIDA CICLO, ");
  query.append(" MAE_NEGOC NEGOCIO, ");
  query.append(" MAE_SUPER_GENER SUPER, ");
  query.append(" MAE_GENER GENER ");     
  query.append(" WHERE C.COMI_OID_COMI = " + dto.getOid());
  query.append(" AND C.TIPS_OID_TIPO_INSE_PROD = T.OID_TIPO_INSE_PROD ");
  query.append(" AND C.TPRO_OID_TIPO_PROD = P.OID_TIPO_PROD ");
  query.append(" AND PRODU.OID_PROD(+) = C.PROD_OID_PROD ");
  query.append(" AND MARCA.OID_MARC_PROD(+) = C.MAPR_OID_MARC_PROD ");
  query.append(" AND UNIDAD.OID_UNID_NEGO(+) = C.UNEG_OID_UNID_NEGO ");
  query.append(" AND OFERTA.OID_TIPO_OFER(+) = C.TOFE_OID_TIPO_OFER ");
  query.append(" AND CICLO.OID_CICL_VIDA(+) = C.CIVI_OID_CICL_VIDA ");
  query.append(" AND NEGOCIO.OID_NEGO(+) = C.NEGO_OID_NEGO ");
  query.append(" AND SUPER.OID_SUPE_GENE(+) = C.SGEN_OID_SUPE_GENE ");
  query.append(" AND GENER.OID_GENE(+) = C.GENE_OID_GENE ");
  query.append(" ORDER BY COD_COMI_PROD ");  
    
  UtilidadesLog.debug(query.toString());
  
  try {
         rs = bs.dbService.executeStaticQuery(query.toString());
         UtilidadesLog.debug("************* rs " + rs);
         if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            DTOComisionesProductos dTOComisionesProductos = new DTOComisionesProductos();
            
            //Seteando oid            
            Long oid;
            if(rs.getValueAt(i, "OID_COMI_PROD")!=null) {
              oid = new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_PROD")).longValue());  
            }
            else {
              oid = null;
            }           
            dTOComisionesProductos.setOid(oid);//OID_COMI_PROD    
            
            //Seteando oid ciclo vida           
            Long oidCicloVida;
            if(rs.getValueAt(i, "CIVI_OID_CICL_VIDA")!=null) {
              oidCicloVida = new Long(((BigDecimal) rs.getValueAt(i, "CIVI_OID_CICL_VIDA")).longValue());  
            }
            else {
              oidCicloVida = null;
            }            
            dTOComisionesProductos.setOidCicloVida(oidCicloVida);//TCLV_OID_CICL_VIDA         
            
            //Seteando oid de comision         
            Long oidComision;
            if(rs.getValueAt(i, "COMI_OID_COMI")!=null) {
              oidComision = new Long(((BigDecimal) rs.getValueAt(i, "COMI_OID_COMI")).longValue());  
            }
            else {
              oidComision = null;
            }            
            dTOComisionesProductos.setOidComision(oidComision);//COMI_OID_COMI            
            
            //Seteando oid generico            
            Long oidGenerico;
            if(rs.getValueAt(i, "GENE_OID_GENE")!=null) {
              oidGenerico = new Long(((BigDecimal) rs.getValueAt(i, "GENE_OID_GENE")).longValue());  
            }
            else {
              oidGenerico = null;
            }            
            dTOComisionesProductos.setOidGenerico(oidGenerico);//GENE_OID_GENE        
            
            //Seteando oid marca            
            Long oidMarcaProducto;
            if(rs.getValueAt(i, "MAPR_OID_MARC_PROD")!=null) {
              oidMarcaProducto = new Long(((BigDecimal) rs.getValueAt(i, "MAPR_OID_MARC_PROD")).longValue());  
            }
            else {
              oidMarcaProducto = null;
            }            
            dTOComisionesProductos.setOidMarcaProducto(oidMarcaProducto);//MAPR_OID_MARC_PROD            
            
            //Seteando oid negocio     
            Long oidNegocio;
            if(rs.getValueAt(i, "NEGO_OID_NEGO")!=null) {
              oidNegocio = new Long(((BigDecimal) rs.getValueAt(i, "NEGO_OID_NEGO")).longValue());  
            }
            else {
              oidNegocio = null;
            }            
            dTOComisionesProductos.setOidNegocio(oidNegocio);//NEGO_OID_NEGO     
            
            //Seteando oid producto            
            Long oidProducto;
            if(rs.getValueAt(i, "PROD_OID_PROD")!=null) {
              oidProducto = new Long(((BigDecimal) rs.getValueAt(i, "PROD_OID_PROD")).longValue());  
            }
            else {
              oidProducto = null;
            }            
            dTOComisionesProductos.setOidProducto(oidProducto);//PROD_OID_PROD        
            
            //Seteando oid supergenerico            
            Long oidSupergenerico;
            if(rs.getValueAt(i, "SGEN_OID_SUPE_GENE")!=null) {
              oidSupergenerico = new Long(((BigDecimal) rs.getValueAt(i, "SGEN_OID_SUPE_GENE")).longValue());  
            }
            else {
              oidSupergenerico = null;
            }            
            dTOComisionesProductos.setOidSupergenerico(oidSupergenerico);//SGEN_OID_SUPE_GENE           
            
            //Seteando oid unidad negocio         
            Long oidUnidadNegocio;
            if(rs.getValueAt(i, "UNEG_OID_UNID_NEGO")!=null) {
              oidUnidadNegocio = new Long(((BigDecimal) rs.getValueAt(i, "UNEG_OID_UNID_NEGO")).longValue());  
            }
            else {
              oidUnidadNegocio = null;
            }            
            dTOComisionesProductos.setOidUnidadNegocio(oidUnidadNegocio);//UNEG_OID_UNID_NEGO           
            
            //Seteando oid tipo oferta            
            Long oidTipoOferta;
            if(rs.getValueAt(i, "TOFE_OID_TIPO_OFER")!=null) {
              oidTipoOferta = new Long(((BigDecimal) rs.getValueAt(i, "TOFE_OID_TIPO_OFER")).longValue());  
            }
            else {
              oidTipoOferta = null;
            }            
            dTOComisionesProductos.setOidTipoOferta(oidTipoOferta);//TOFE_OID_TIPO_OFER
            
            //Seteando id para la lista            
            Integer idInt;
            if(rs.getValueAt(i, "COD_COMI_PROD")!=null) {
              BigDecimal id = (BigDecimal)rs.getValueAt(i, "COD_COMI_PROD");
              idInt = new Integer(id.intValue());
            }
            else {
              idInt = null;
            }
            dTOComisionesProductos.setId(idInt);
            
            //Seteando oid tipo producto           
            Long tipoProducto;
            if(rs.getValueAt(i, "TPRO_OID_TIPO_PROD")!=null) {
              BigDecimal temp = (BigDecimal)rs.getValueAt(i, "TPRO_OID_TIPO_PROD");
              tipoProducto = new Long(temp.longValue());
            }
            else {
              tipoProducto = null;
            }
            dTOComisionesProductos.setOidTipoProducto(tipoProducto);
            
            //Seteando oid tipo de insercion            
            Long tipoInsercionProducto;
            if(rs.getValueAt(i, "TIPS_OID_TIPO_INSE_PROD")!=null) {
              BigDecimal temp = (BigDecimal)rs.getValueAt(i, "TIPS_OID_TIPO_INSE_PROD");
              tipoInsercionProducto = new Long(temp.longValue());
            }
            else {
              tipoInsercionProducto = null;
            }
            dTOComisionesProductos.setOidTipoInsercionProductos(tipoInsercionProducto);
            
            //Seteando descripcion tipo producto           
            String desTipoProducto;
            if(rs.getValueAt(i, "TIPOPRODUCTO")!=null) {
              desTipoProducto = (String)rs.getValueAt(i, "TIPOPRODUCTO");
            }
            else {
              desTipoProducto = null;
            }
            dTOComisionesProductos.setDescTipoProducto(desTipoProducto);          
            
            //Seteando codigo producto            
            String codigoProducto;            
            if(rs.getValueAt(i, "CODIGOPRODUCTO")!=null) {
              codigoProducto = (String)rs.getValueAt(i, "CODIGOPRODUCTO");
            }
            else {
              codigoProducto = null;
            }
            dTOComisionesProductos.setCodProducto(codigoProducto);            
            
            //Seteando descripcion tipo oferta
            String descTipoOferta;
            if(rs.getValueAt(i, "TIPOOFERTA")!=null) {
              descTipoOferta = (String)rs.getValueAt(i, "TIPOOFERTA");
            }
            else {
              descTipoOferta = null;
            }
            dTOComisionesProductos.setDescTipoOferta(descTipoOferta);
            
            //Seteando descripcion ciclo vida
            String descCicloVida;
            if(rs.getValueAt(i, "CICLOVIDA")!=null) {
              descCicloVida = (String)rs.getValueAt(i, "CICLOVIDA");
            }
            else {
              descCicloVida = null;
            }
            dTOComisionesProductos.setDescCicloVida(descCicloVida);
            
            //Seteando descripcion marca
            String descMarca;
            if(rs.getValueAt(i, "MARCA")!=null) {
              descMarca = (String)rs.getValueAt(i, "MARCA");
            }
            else {
              descMarca = null;
            }
            dTOComisionesProductos.setDescMarcaProducto(descMarca);
            
            //Seteando descripcion unidad negocio
            String descUnidadNegocio;
            if(rs.getValueAt(i, "UNIDADNEGOCIO")!=null) {
              descUnidadNegocio = (String)rs.getValueAt(i, "UNIDADNEGOCIO");
            }
            else {
              descUnidadNegocio = null;
            }
            dTOComisionesProductos.setDescUnidadNegocio(descUnidadNegocio);
            
            //Seteando descripcion negocio
            String descNegocio;
            if(rs.getValueAt(i, "NEGOCIO")!=null) {
              descNegocio = (String)rs.getValueAt(i, "NEGOCIO");
            }
            else {
              descNegocio = null;
            }
            dTOComisionesProductos.setDescNegocio(descNegocio);
            
            //Seteando descripcion supergenerico
            String descSuperGenerico;
            if(rs.getValueAt(i, "SUPERGENERICO")!=null) {
              descSuperGenerico = (String)rs.getValueAt(i, "SUPERGENERICO");
            }
            else {
              descSuperGenerico = null;
            }
            dTOComisionesProductos.setDescSupergenerico(descSuperGenerico);
            
            //Seteando descripcion generico
            String descGenerico;
            if(rs.getValueAt(i, "GENERICO")!=null) {
              descGenerico = (String)rs.getValueAt(i, "GENERICO");
            }
            else {
              descGenerico = null;
            }
            dTOComisionesProductos.setDescGenerico(descGenerico);
            
            //Seteando oid comision producto
            Long oidComisionProducto;
            if(rs.getValueAt(i, "COPR_OID_COMI_PROD")!=null) {
              oidComisionProducto = new Long(((BigDecimal) rs.getValueAt(i, "COPR_OID_COMI_PROD")).longValue());  
            }
            else {
              oidComisionProducto = null;
            }           
            dTOComisionesProductos.setOidComisionProducto(oidComisionProducto);     
            
            respuesta.add(dTOComisionesProductos);      
          }         
         }            
     }
     catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }    
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesProductos(DTOOID dto): Salida");
    return respuesta;    
  }
  
    /** 
  * Metodo consultarComisionesVentas  
  * @return DTOComisionesVentas
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOComisionesVentas consultarComisionesVentas(DTOOID dto) throws MareException{
  UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesVentas(DTOOID dto): Entrada");
  DTOComisionesVentas respuesta = null; 
  StringBuffer query = new StringBuffer();
  RecordSet rs = new RecordSet();
  
  BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
  query.append(" SELECT C.OID_COMI_VENT, C.IND_CALC_INCO, C.VAL_CALC_INCO_FECH_EMIS, C.VAL_CALC_INCO_FECH_VENC, C.NUM_DIAS_INCO, C.IND_DEVO, C.VAL_ANUL, C.IND_FALT_NANU, C.VAL_PORC_COMI, C.IMP_FIJO_COMI, C.COMI_OID_COMI, C.FORM_OID_FORM, C.TICV_OID_TIPO_COMI_VENT, C.TCVI_OID_TIPO_COMI_VENT_INCR ");
  query.append(" FROM COM_COMIS_VENTA C ");          
  query.append(" WHERE COMI_OID_COMI = "+ dto.getOid());
  UtilidadesLog.debug(query.toString());
  
  try {
         rs = bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
            respuesta = new DTOComisionesVentas();
            
            Long oidComisiones;
            if(rs.getValueAt(0, "COMI_OID_COMI")!=null) {
              oidComisiones = new Long(((BigDecimal) rs.getValueAt(0, "COMI_OID_COMI")).longValue());  
            }
            else {
              oidComisiones = null;
            }          
            respuesta.setOidComisiones(oidComisiones);//COMI_OID_COMI
            
            BigDecimal valor1;
            if(rs.getValueAt(0, "IMP_FIJO_COMI")!=null) {
              valor1 = (BigDecimal) rs.getValueAt(0, "IMP_FIJO_COMI");
            }
            else {
              valor1 = null;
            }            
            respuesta.setImporteFijoComision(valor1);//IMP_FIJO_COMI
            
            BigDecimal valor2;
            if(rs.getValueAt(0, "VAL_PORC_COMI")!=null) {
              valor2 = (BigDecimal) rs.getValueAt(0, "VAL_PORC_COMI");
            }
            else {
              valor2 = null;
            }           
            respuesta.setPorcentajeComision(valor2);//VAL_PORC_COMI
            
            
            Boolean altantesNoAnunciados = null;
            if(rs.getValueAt(0, "IND_FALT_NANU")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "IND_FALT_NANU")).intValue()==0){
                    altantesNoAnunciados = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "IND_FALT_NANU")).intValue()==1){
                    altantesNoAnunciados = Boolean.TRUE;
              }  
            }           
            respuesta.setFaltantesNoAnunciados(altantesNoAnunciados);//IND_FALT_NANU
            
            
            
            Boolean anulaciones = null;
            if(rs.getValueAt(0, "VAL_ANUL")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "VAL_ANUL")).intValue()==0){
                    anulaciones = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "VAL_ANUL")).intValue()==1){
                    anulaciones = Boolean.TRUE;
              }  
            }            
            respuesta.setAnulaciones(anulaciones);//VAL_ANUL
            
            
            Boolean devoluciones = null;
            if(rs.getValueAt(0, "IND_DEVO")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "IND_DEVO")).intValue()==0){
                    devoluciones = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "IND_DEVO")).intValue()==1){
                    devoluciones = Boolean.TRUE;
              }             
            }
            respuesta.setDevoluciones(devoluciones);//IND_DEVO           
            
            Integer diasIncobrables;
            if(rs.getValueAt(0, "NUM_DIAS_INCO")!=null) {
              diasIncobrables = new Integer(((BigDecimal) rs.getValueAt(0, "NUM_DIAS_INCO")).intValue());  
            }
            else {
              diasIncobrables = null;
            }            
            respuesta.setDiasIncobrables(diasIncobrables);//NUM_DIAS_INCO
            
            
              
            Boolean calculoIncobrablesFechaVencimiento = null;
            if(rs.getValueAt(0, "VAL_CALC_INCO_FECH_VENC")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "VAL_CALC_INCO_FECH_VENC")).intValue()==0){
                    calculoIncobrablesFechaVencimiento = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "VAL_CALC_INCO_FECH_VENC")).intValue()==1){
                    calculoIncobrablesFechaVencimiento = Boolean.TRUE;
              }  
            }
            respuesta.setCalculoIncobrablesFechaVencimiento(calculoIncobrablesFechaVencimiento);//VAL_CALC_INCO_FECH_VENC
            
            
            
            Boolean calculoIncobrablesFechaEmision = null;
            if(rs.getValueAt(0, "VAL_CALC_INCO_FECH_EMIS")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "VAL_CALC_INCO_FECH_EMIS")).intValue()==0){
                    calculoIncobrablesFechaEmision = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "VAL_CALC_INCO_FECH_EMIS")).intValue()==1){
                    calculoIncobrablesFechaEmision = Boolean.TRUE;
              }  
            }
            respuesta.setCalculoIncobrablesFechaEmision(calculoIncobrablesFechaEmision);//VAL_CALC_INCO_FECH_EMIS
            
            Boolean calculoIncobrables = null;
            if(rs.getValueAt(0, "IND_CALC_INCO")!=null) {
              if(((BigDecimal) rs.getValueAt(0, "IND_CALC_INCO")).intValue()==0){
                    calculoIncobrables = Boolean.FALSE;
              }
              else if(((BigDecimal) rs.getValueAt(0, "IND_CALC_INCO")).intValue()==1){
                    calculoIncobrables = Boolean.TRUE;
              }  
            }          
            respuesta.setCalculoIncobrables(calculoIncobrables);//IND_CALC_INCO
            
            Long oid;
            if(rs.getValueAt(0, "OID_COMI_VENT")!=null) {
              oid = new Long(((BigDecimal) rs.getValueAt(0, "OID_COMI_VENT")).longValue());  
            }
            else {
              oid = null;
            }           
            respuesta.setOid(oid);  //OID_COMI_VENT

            Long oidFormula = null;
            if(rs.getValueAt(0, "FORM_OID_FORM")!=null) {
              oidFormula = new Long(((BigDecimal) rs.getValueAt(0, "FORM_OID_FORM")).longValue());  
            }
            else {
              oidFormula = null;
            }           
            respuesta.setOidFormula(oidFormula);

            Long aplicarComision;
            if(rs.getValueAt(0, "TICV_OID_TIPO_COMI_VENT")!=null) {
              aplicarComision = new Long(((BigDecimal) rs.getValueAt(0, "TICV_OID_TIPO_COMI_VENT")).longValue());  
            }
            else {
              aplicarComision = null;
            }           
            respuesta.setOidTipoComisionVenta(aplicarComision);

            Long comparativo;
            if(rs.getValueAt(0, "TCVI_OID_TIPO_COMI_VENT_INCR")!=null) {
              comparativo = new Long(((BigDecimal) rs.getValueAt(0, "TCVI_OID_TIPO_COMI_VENT_INCR")).longValue());  
            }
            else {
              comparativo = null;
            }           
            respuesta.setOidTipoComisionVentaIncremental(comparativo);            
         }
            
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }    
     UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesVentas(DTOOID dto): Salida");
     return respuesta;
  }
  
  /** 
  * Metodo consultarComisionesVentasHistoricas  
  * @return DTOComisionesVentasHistoricas
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOComisionesVentasHistoricas consultarComisionesVentasHistoricas (DTOOID dto) throws MareException{//FALTA TERMINAR
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesVentasHistoricas(DTOOID dto): Entrada");  
    DTOComisionesVentasHistoricas respuesta = null; 
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
  
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_COMI_VENT_HIST, C.VAL_PORC_INCR, C.IMP_MONT_INCR, C.IND_DEVO, C.IND_ANUL, C.COMI_OID_COMI, C.PERD_OID_PERI_FINA, C.PERD_OID_PERI_INIC ");
    query.append(" FROM COM_COMIS_VENTA_HISTO C ");          
    query.append(" WHERE COMI_OID_COMI = "+ dto.getOid());
    UtilidadesLog.debug(query.toString());
  
    try {
        rs = bs.dbService.executeStaticQuery(query.toString());
        if ( ! rs.esVacio() ) {
            respuesta = new DTOComisionesVentasHistoricas();
            
            Long oid;
            if(rs.getValueAt(0,"OID_COMI_VENT_HIST")!=null) {
              BigDecimal temp = (BigDecimal)rs.getValueAt(0,"OID_COMI_VENT_HIST");
              oid = new Long(temp.longValue());
            }
            else {
              oid = null;  
            }      
            respuesta.setOid(oid);
            
            
            BigDecimal valor1;
            if(rs.getValueAt(0,"VAL_PORC_INCR")!=null) {
              valor1 = (BigDecimal)rs.getValueAt(0,"VAL_PORC_INCR");
            }
            else {
              valor1 = null;
            }            
            respuesta.setPorcentajeIncremento(valor1);
            
            
            BigDecimal valor2;
            if(rs.getValueAt(0,"IMP_MONT_INCR")!=null) {
              valor2 = (BigDecimal)rs.getValueAt(0,"IMP_MONT_INCR");
            }
            else {
              valor2 = null;
            }            
            respuesta.setMontoIncremento(valor2);
            
            Boolean valBuleano = null;
            if(rs.getValueAt(0,"IND_DEVO") != null) {
              if ((((BigDecimal)rs.getValueAt(0,"IND_DEVO")).equals(new BigDecimal(1)))) {
                valBuleano = new Boolean(true);
              }
              else {
                valBuleano = new Boolean(false);
              }                
            }
            respuesta.setDevoluciones(valBuleano);
            
            
            
            Boolean otroBuleano = null;
            if(rs.getValueAt(0,"IND_ANUL") != null) {
              if ((((BigDecimal)rs.getValueAt(0,"IND_ANUL")).equals(new BigDecimal(1)))) {
                otroBuleano = new Boolean(true);
              }
              else {
                otroBuleano = new Boolean(false);
              }              
            }
            respuesta.setAnulaciones(otroBuleano);
            
            Long otroValor1;
            if(rs.getValueAt(0,"COMI_OID_COMI")!=null) {
              BigDecimal temp2 = (BigDecimal)rs.getValueAt(0,"COMI_OID_COMI");
              otroValor1 = new Long(temp2.toString());
            }
            else {
              otroValor1 = null;
            }             
            respuesta.setOidComisiones(otroValor1);
            
            
            Long otroValor2;
            if(rs.getValueAt(0,"PERD_OID_PERI_FINA")!=null) {
              BigDecimal temp3 = (BigDecimal)rs.getValueAt(0,"PERD_OID_PERI_FINA");
              otroValor2 = new Long(temp3.toString());
            }
            else {
              otroValor2 = null;
            }           
            respuesta.setOidPeriodoFinal(otroValor2);
            
            Long otroValor3;
            if(rs.getValueAt(0,"PERD_OID_PERI_INIC")!=null) {
              BigDecimal temp4 = (BigDecimal)rs.getValueAt(0,"PERD_OID_PERI_INIC");
              otroValor3 = new Long(temp4.toString());
            }
            else {
              otroValor3 = null;
            }           
            respuesta.setOidPeriodoInicio(otroValor3);
        }
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }  
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesVentasHistoricas(DTOOID dto): Salida");  
    return respuesta;
  }

  
    /** 
  * Metodo consultarComisionesClientes
  * @param  dto
  * @return ArrayList
  * @exception MareException 
  * @author Carlos Leal
  * @modificado Cristian Valenzuela
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public ArrayList consultarComisionesClientes(DTOOID dto) throws MareException{
  UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesClientes(DTOOID dto): Entrada");
  ArrayList respuesta = new ArrayList();
  StringBuffer query = new StringBuffer();
  RecordSet rs = new RecordSet();
  
  BelcorpService bs = UtilidadesEJB.getBelcorpService();
  
   query.append(" SELECT C.OID_COMI_CLIE, ");
   query.append(" C.VAL_TOPE_MAXI, ");
   query.append(" C.VAL_TOPE_MINI, ");
   query.append(" C.FEC_ANTI_DESD, ");
   query.append(" C.FEC_ANTI_HAST, ");
   query.append(" C.COMI_OID_COMI, ");
   query.append(" C.TCCC_OID_TIPO_CLIE_COMI_CABE, ");
   query.append(" C.ZSCC_OID_SECC, ");
   query.append(" C.ZSGV_OID_SUBG_VENT, ");
   query.append(" C.TERR_OID_TERR, ");
   query.append(" C.ZORG_OID_REGI, ");
   query.append(" C.ZZON_OID_ZONA, ");
   query.append(" v.VAL_I18N, ");
   query.append(" s.DES_SECCI, ");
   query.append(" g.DES_SUBG_VENT, ");
   query.append(" r.DES_REGI, ");
   query.append(" t.COD_TERR, ");
   query.append(" z.DES_ZONA, ");
   query.append(" C.COD_ORDE ");
   query.append(" FROM COM_COMIS_CLIEN C, ");
   query.append(" v_gen_i18n_sicc v, ");
   query.append(" ZON_SECCI s, ");
   query.append(" ZON_SUB_GEREN_VENTA g, ");
   query.append(" ZON_REGIO r, ");
   query.append(" ZON_TERRI t, ");
   query.append(" ZON_ZONA z ");          
   query.append(" WHERE COMI_OID_COMI = " + dto.getOid());
   query.append(" and v.VAL_OID = C.TCCC_OID_TIPO_CLIE_COMI_CABE ");
   query.append(" and v.ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC' ");
   query.append(" and v.IDIO_OID_IDIO = " + dto.getOidIdioma());
   query.append(" and v.ATTR_NUM_ATRI = 1 ");
   query.append(" and s.OID_SECC(+) = C.ZSCC_OID_SECC ");
   query.append(" and g.OID_SUBG_VENT(+) = C.ZSGV_OID_SUBG_VENT ");
   query.append(" and t.OID_TERR(+) = C.TERR_OID_TERR ");
   query.append(" and r.OID_REGI(+) = C.ZORG_OID_REGI ");
   query.append(" and z.OID_ZONA(+) = C.ZZON_OID_ZONA ");
   
  UtilidadesLog.debug(query.toString());
  
  try {
         rs = bs.dbService.executeStaticQuery(query.toString());
         UtilidadesLog.debug("************* rs " + rs);
         if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            DTOComisionesClientes dTOComisionesClientes = new DTOComisionesClientes();
            
            Date fechaTemp;
            if(rs.getValueAt(i, "FEC_ANTI_DESD")!=null) {
              fechaTemp = (Date)rs.getValueAt(i, "FEC_ANTI_DESD");
            }
            else {
              fechaTemp = null;
            }            
            dTOComisionesClientes.setFecAntiguedadDesde(fechaTemp);//FEC_ANTI_DESD
            
            Date fechaTemp2;
            if(rs.getValueAt(i, "FEC_ANTI_HAST")!=null) {
              fechaTemp2 = (Date)rs.getValueAt(i, "FEC_ANTI_HAST");
            }
            else {
              fechaTemp2 = null;
            }                       
            dTOComisionesClientes.setFecAntiguedadHasta(fechaTemp2);//FEC_ANTI_HAST
            
            
            Long oidComisiones;
            if(rs.getValueAt(i, "COMI_OID_COMI")!=null) {
              oidComisiones = new Long(((BigDecimal) rs.getValueAt(i, "COMI_OID_COMI")).longValue());  
            }
            else {
              oidComisiones = null;
            }            
            dTOComisionesClientes.setOidComisiones(oidComisiones);//COMI_OID_COMI
            
            Long oid;
            if(rs.getValueAt(i, "OID_COMI_CLIE")!=null) {
              oid = new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_CLIE")).longValue());  
            }
            else {
              oid = null;
            }           
            dTOComisionesClientes.setOid(oid);//OID_COMI_CLIE
            
            Long oidRegion;
            if(rs.getValueAt(i, "ZORG_OID_REGI")!=null) {
              oidRegion = new Long(((BigDecimal) rs.getValueAt(i, "ZORG_OID_REGI")).longValue());  
            }
            else {
              oidRegion = null;
            }                      
            dTOComisionesClientes.setOidRegion(oidRegion);//ZORG_OID_REGI
            
            Long oidSeccion;
            if(rs.getValueAt(i, "ZSCC_OID_SECC")!=null) {
              oidSeccion = new Long(((BigDecimal) rs.getValueAt(i, "ZSCC_OID_SECC")).longValue());  
            }
            else {
              oidSeccion = null;
            }           
            dTOComisionesClientes.setOidSeccion(oidSeccion);//ZSCC_OID_SECC
            
            
            Long oidSubgerencia;
            if(rs.getValueAt(i, "ZSGV_OID_SUBG_VENT")!=null) {
              oidSubgerencia = new Long(((BigDecimal) rs.getValueAt(i, "ZSGV_OID_SUBG_VENT")).longValue());  
            }
            else  {
              oidSubgerencia = null;
            }           
            dTOComisionesClientes.setOidSubgerencia(oidSubgerencia);//ZSGV_OID_SUBG_VENT
            
            
            Long oidTerritorio;
            if(rs.getValueAt(i, "TERR_OID_TERR")!=null) {
              oidTerritorio = new Long(((BigDecimal) rs.getValueAt(i, "TERR_OID_TERR")).longValue());  
            }
            else {
              oidTerritorio = null;
            }           
            dTOComisionesClientes.setOidTerritorio(oidTerritorio);//TERR_OID_TERR
            
            Long oidTipoClienteComisionesCabecera;            
            if(rs.getValueAt(i, "TCCC_OID_TIPO_CLIE_COMI_CABE")!=null) {
              oidTipoClienteComisionesCabecera = new Long(((BigDecimal) rs.getValueAt(i, "TCCC_OID_TIPO_CLIE_COMI_CABE")).longValue());              
            }
            else {
              oidTipoClienteComisionesCabecera = null;
            }          
            dTOComisionesClientes.setOidTipoClienteComisionesCabecera(oidTipoClienteComisionesCabecera);//TCCC_OID_TIPO_CLIE_COMI_CABE
            
            
            Long oidZona;
            if(rs.getValueAt(i, "ZZON_OID_ZONA")!=null) {
              oidZona = new Long(((BigDecimal) rs.getValueAt(i, "ZZON_OID_ZONA")).longValue());  
            }
            else {
              oidZona = null;
            }           
            dTOComisionesClientes.setOidZona(oidZona);//ZZON_OID_ZONA
            
            
            BigDecimal temp1;
            if(rs.getValueAt(i, "VAL_TOPE_MAXI")!=null) {
              temp1 = (BigDecimal) rs.getValueAt(i, "VAL_TOPE_MAXI");
            }
            else {
              temp1 = null;
            }            
            dTOComisionesClientes.setTopeMaximo(temp1);//VAL_TOPE_MAXI
            
            BigDecimal temp2;
            if(rs.getValueAt(i, "VAL_TOPE_MINI")!=null) {
              temp2 = (BigDecimal) rs.getValueAt(i, "VAL_TOPE_MINI");
            }
            else {
              temp2 = null;
            }            
            dTOComisionesClientes.setTopeMinimo(temp2);//VAL_TOPE_MINI
            
            BigDecimal temp3;
            if(rs.getValueAt(i, "COD_ORDE")!=null) {
              temp3 = (BigDecimal)rs.getValueAt(i, "COD_ORDE");
            }
            else {
              temp3 = null;
            }            
            dTOComisionesClientes.setNumero(new Integer(temp3.intValue()));
            
            String descTipoCliente;
            if(rs.getValueAt(i, "VAL_I18N")!=null) {
              descTipoCliente = (String)rs.getValueAt(i, "VAL_I18N");
            }
            else {
              descTipoCliente = null;
            }
            dTOComisionesClientes.setDescTipoClienteComisionesCabecera(descTipoCliente);
            
            String descSubgerencia;
            if(rs.getValueAt(i, "DES_SUBG_VENT")!=null) {
              descSubgerencia = (String)rs.getValueAt(i, "DES_SUBG_VENT");
            }
            else {
              descSubgerencia = null;
            }
            dTOComisionesClientes.setDescSubgerencia(descSubgerencia);
            
            String descRegion;
            if(rs.getValueAt(i, "DES_REGI")!=null) {
              descRegion = (String)rs.getValueAt(i, "DES_REGI");
            }
            else {
              descRegion = null;
            }
            dTOComisionesClientes.setDescRegion(descRegion);
            
            String descZona;
            if(rs.getValueAt(i, "DES_ZONA")!=null) {
              descZona = (String)rs.getValueAt(i, "DES_ZONA");
            }
            else {
              descZona = null;
            }
            dTOComisionesClientes.setDescZona(descZona);
            
            String descSeccion;
            if(rs.getValueAt(i, "DES_SECCI")!=null) {
              descSeccion = (String)rs.getValueAt(i, "DES_SECCI");
            }
            else {
              descSeccion = null;
            }
            dTOComisionesClientes.setDescSeccion(descSeccion);
            
            String descTerritorio;
            if(rs.getValueAt(i, "COD_TERR")!=null) {
              BigDecimal temp = (BigDecimal)rs.getValueAt(i, "COD_TERR");
              descTerritorio = temp.toString();
            }
            else {
              descTerritorio = null;
            }
            dTOComisionesClientes.setDescTerritorio(descTerritorio); 
            
            respuesta.add(dTOComisionesClientes);
          }         
         }
            
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }  
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesClientes(DTOOID dto): Salida");
    return respuesta; 
     
  }
  
  /** 
  * Metodo obtenerTiposParticipantes  
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposParticipantes(DTOBelcorp dto) throws MareException{
//-> Hacer consulta JDBC sobre la tabla COM_TIPO_PARTI 
//-> Obtener los campos OID_TIPO_PART y la ***descripción internacionalizada*** 
//-> Devolver RecordSet obtenido encapsulado en un DTOSalida 
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposParticipantes(DTOBelcorp dto): Entrada");
    
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_TIPO_PART, V.val_i18n ");
    query.append(" FROM COM_TIPO_PARTI C, v_gen_i18n_sicc V ");          
    query.append(" WHERE C.OID_TIPO_PART = V.val_oid ");
    query.append(" AND V.attr_enti = 'COM_TIPO_PARTI' ");
    query.append(" AND V.idio_oid_idio = "+ dto.getOidIdioma());
    query.append(" AND V.attr_num_atri = 1 ");
    query.append(" ORDER BY V.val_i18n ");
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs =  bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio())
            dtos.setResultado(rs);
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposParticipantes(DTOBelcorp dto): Salida");
     return dtos;
  }
  
  /** 
  * Metodo obtenerTiposComisionesVenta
  * @param dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposComisionesVenta(DTOBelcorp dto) throws MareException{
//-> Hacer consulta JDBC sobre la tabla COM_TIPO_COMIS_VENTA 
//-> Obtener los campos OID_TIPO_COMI_VENT y la descripción internacionalizada 
//-> Devolver RecordSet obtenido encapsulado en un DTOSalida 
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposComisionesVenta(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_TIPO_COMI_VENT, V.val_i18n ");
    query.append(" FROM COM_TIPO_COMIS_VENTA C, v_gen_i18n_sicc V ");          
    query.append(" WHERE C.OID_TIPO_COMI_VENT = V.val_oid ");
    query.append(" AND V.attr_enti = 'COM_TIPO_COMIS_VENTA' ");
    query.append(" AND V.idio_oid_idio = "+ dto.getOidIdioma());
    query.append(" AND V.attr_num_atri = 1 ");
    query.append(" ORDER BY V.val_i18n ");
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs =  bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposComisionesVenta(DTOBelcorp dto): Salida");
     return dtos;
  }
  
  /** 
  * Metodo obtenerTiposComisionesVentaIncremental
  * @param  dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposComisionesVentaIncremental(DTOBelcorp dto) throws MareException{
//-> Hacer consulta JDBC sobre la tabla COM_TIPO_COMIS_VENTA_INCRE 
//-> Obtener los campos OID_TIPO_COMI_VENT_INCR y la descripción internacionalizada 
//-> Devolver RecordSet obtenido encapsulado en un DTOSalida  
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposComisionesVentaIncremental(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_TIPO_COMI_VENT_INCR, V.val_i18n ");
    query.append(" FROM COM_TIPO_COMIS_VENTA_INCRE C, v_gen_i18n_sicc V ");          
    query.append(" WHERE C.OID_TIPO_COMI_VENT_INCR = V.val_oid ");
    query.append(" AND V.attr_enti = 'COM_TIPO_COMIS_VENTA_INCRE' ");
    query.append(" AND V.idio_oid_idio = "+ dto.getOidIdioma());
    query.append(" AND V.attr_num_atri = 1 ");
    query.append(" ORDER BY V.val_i18n ");
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs =  bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposComisionesVentaIncremental(DTOBelcorp dto): Salida");
     return dtos;
  }

  /** 
    * Metodo obtenerFormulas
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author Carlos Leal
    * @referencia SICC-DMCO-COM-201-334-N033-1
    */
    public DTOSalida obtenerFormulas(DTOBelcorp dto) throws MareException{
//-> Hacer consulta JDBC sobre la tabla COM_FORMU 
//-> Obtener los campos OID_FORM y la descripción internacionalizada 
//-> Devolver RecordSet obtenido encapsulado en un DTOSalida 
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerFormulas(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_FORM, V.val_i18n ");
    query.append(" FROM COM_FORMU C, v_gen_i18n_sicc V ");          
    query.append(" WHERE C.OID_FORM = V.val_oid ");
    query.append(" AND V.attr_enti = 'COM_FORMU' ");
    query.append(" AND V.idio_oid_idio = "+ dto.getOidIdioma());
    query.append(" AND V.attr_num_atri = 1 ");
    query.append(" ORDER BY V.val_i18n ");
    
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs =  bs.dbService.executeStaticQuery(query.toString());
         if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerFormulas(DTOBelcorp dto): Salida");
     return dtos;    
    }
  
  /** 
    * Metodo obtenerTiposClienteCOM
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author Carlos Leal
    * @referencia SICC-DMCO-COM-201-334-N033-1
    */
  public DTOSalida obtenerTiposClienteCOM(DTOBelcorp dto) throws MareException{
//-> Hacer consulta JDBC sobre la tabla COM_TIPO_CLIEN_COMIS_CABEC 
//-> COM_TIPO_CLIEN_COMIS_CABEC.PAIS_OID_PAIS = dto.pais 
//-> Obtener los campos OID_TIPO_CLIE_COMI_CABE y la descripción internacionalizada 
//-> Devolver RecordSet obtenido encapsulado en un DTOSalida 
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposClienteCOM(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT C.OID_TIPO_CLIE_COMI_CABE, V.val_i18n ");
    query.append(" FROM v_gen_i18n_sicc V, COM_TIPO_CLIEN_COMIS_CABEC C ");          
    query.append(" WHERE C.OID_TIPO_CLIE_COMI_CABE = V.val_oid ");
    query.append(" AND V.attr_enti = 'COM_TIPO_CLIEN_COMIS_CABEC' ");
    query.append(" AND V.idio_oid_idio = "+ dto.getOidIdioma());
    query.append(" AND V.attr_num_atri = 1 ");
    query.append(" AND C.PAIS_OID_PAIS = "+ dto.getOidPais());
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTiposClienteCOM(DTOBelcorp dto): Salida");
     return dtos;     
  }
  
   /** 
    * Metodo recCargaComision
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
  public DTOSalida recCargaComision(DTORepCargaComision dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.recCargaComision(DTORepCargaComision dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    String indVentaCobranza;
    
    UtilidadesLog.info("El tipo de comision es " + dto.getTipoComision());
    
    if(dto.getTipoComision()!= null){
      if(dto.getTipoComision().equals(new Long("2"))){
         indVentaCobranza = "V";
      }else{
         indVentaCobranza = "C";
      }
    }else{
       indVentaCobranza = "C";
    }
    
    query.append(" SELECT comision.oid_comi OID, descripcion.val_i18n ");
    query.append(" FROM com_comis comision, ");
    query.append(" cra_perio peri, ");
    query.append(" v_gen_i18n_sicc descripcion, ");
    query.append(" (SELECT comision.oid_comi, ");
    query.append(" (SELECT fec_inic ");
    query.append(" FROM cra_perio ");
    query.append(" WHERE oid_peri = comision.perd_oid_peri) fi, ");
    query.append(" (SELECT fec_fina ");
    query.append(" FROM cra_perio ");
    query.append(" WHERE oid_peri = comision.perd_oid_peri_hast) ff ");
    query.append(" FROM com_comis comision ");
    query.append(" WHERE comision.ind_vent_cobr = '"+ indVentaCobranza +"') fechas ");
    query.append(" WHERE fechas.oid_comi = comision.oid_comi ");
    query.append(" AND comision.ind_vent_cobr = '"+ indVentaCobranza +"'");
    query.append(" AND fechas.fi <= peri.fec_inic ");
    query.append(" AND fechas.ff >= peri.fec_fina ");
    query.append(" AND peri.oid_peri = " + dto.getOidPeriodo());
    query.append(" AND peri.pais_oid_pais = " + dto.getOidPais());
    query.append(" AND peri.cana_oid_cana = " + dto.getOidCanal());
    query.append(" AND peri.marc_oid_marc = " + dto.getOidMarca());
    query.append(" AND descripcion.attr_enti = 'COM_COMIS' ");
    query.append(" AND comision.oid_comi = descripcion.val_oid ");
    query.append(" AND descripcion.idio_oid_idio = " + dto.getOidIdioma());
    query.append(" order by 2 ");
    UtilidadesLog.debug(query.toString());         
    
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }  
     UtilidadesLog.info("DAOMantenimientoComisiones.recCargaComision(DTORepCargaComision dto): Salida");
     return dtos;     
  }
  
  /** 
    * Metodo obtenerTramos
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
  public DTOSalida obtenerTramos(DTOOID dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTramos(DTOOID dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT comtipoPart.val_nive_tram, comtipoPart.num_dias_comi ");
    query.append(" FROM com_comis_cobra_tipo_parti comtipoPart, ");
    query.append("      com_comis_cobra cobra, ");
    query.append(" com_comis comis ");
    query.append(" WHERE comtipoPart.coco_oid_comi_cobr = cobra.oid_comi_cobr ");
    query.append(" AND cobra.comi_oid_comi = comis.oid_comi ");
    query.append(" AND comis.oid_comi = " + dto.getOid());
        
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTramos(DTOOID dto): Salida");
     return dtos;     
  }
  
  
  /**
     * @date 02/06/2005  
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * @author pperanzola
     * Realizar el borrado de la siguiente forma: 
        DELETE COM_COMIS_META 
        WHERE COMI_OID_COMI = dto

   */
   public void elminarComisionesMetas (DTOOID dto) throws MareException{
        UtilidadesLog.info("DAOMantenimientoComisiones.elminarComisionesMetas(DTOOID dto): Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer qry = new StringBuffer ("");
        Vector v = new Vector();
        v.add(dto.getOid());
        qry.append(" DELETE FROM COM_COMIS_METAS");
        qry.append(" WHERE COMI_OID_COMI =? ");
        //qry.append(" WHERE COMI_OID_COMI = " + dto.getOid());
        
        try {
           //bs.dbService.executeStaticQuery(qry.toString());
            bs.dbService.executePreparedUpdate(qry.toString(),v);
        } catch (Exception ex) {            
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("DAOMantenimientoComisiones.elminarComisionesMetas(DTOOID dto): Salida");
   }
   
   /** @date 02/06/2005  
     * @throws es.indra.mare.common.exception.MareException
     * @param oidCliente
     * @param oidComision
     * @author pperanzola
    * DAOMantenimientoComisiones.recuperarTipoSubtipoClientePorGerente(oidCliente:Long, oidComision:Long) : Long 
        Entrada: 
        - oidCliente:Long 
        - oidComision:Long 
        Proceso: 
        -> Crear variable "respuesta" de tipo Long 
        -> Hacer consulta JDBC 
        SELECT CCC.COMI_OID_COMI, 
        CTS.CLIE_OID_CLIE, 
        CTS.OID_CLIE_TIPO_SUBT 
        FROM COM_COMIS_CLIEN CCC, 
        COM_TIPO_CLIEN_COMIS_CABEC TCCC, 
        COM_TIPO_CLIEN_COMIS_DETAL TCCD, 
        MAE_CLASI CLAS, 
        MAE_CLIEN_CLASI CLASI, 
        MAE_CLIEN_TIPO_SUBTI CTS 
        WHERE CCC.comi_oid_comi = oidComision 
        AND CTS.CLIE_OID_CLIE = oidCliente 
        AND CCC.tccc_oid_tipo_clie_comi_cabe = TCCC.oid_tipo_clie_comi_cabe 
        AND TCCD.tccc_oid_tipo_clie_comi_cabe = TCCC.oid_tipo_clie_comi_cabe 
        AND CLAS.oid_clas = TCCD.clas_oid_clas 
        AND CLASI.clas_oid_clas = CLAS.oid_clas 
        AND CLASI.ctsu_oid_clie_tipo_subt = CTS.oid_clie_tipo_subt 
        
        
        -> Mapear el atributo de "respuesta" con el del registro devuelto 
        -> Devolver "respuesta" 
    */
    
    public Long obtenerTipoSubtipoClientePorGerente(Long oidCliente, Long oidComision) throws MareException {
        UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTipoSubtipoClientePorGerente(Long oidCliente, Long oidComision): Entrada");
        Long respuesta = null;
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer qry = new StringBuffer("");
        RecordSet rs = null;
        
        qry.append(" SELECT ");
            qry.append(" CCC.COMI_OID_COMI, ");
            qry.append(" CTS.CLIE_OID_CLIE, ");
            qry.append(" CTS.OID_CLIE_TIPO_SUBT ");
        qry.append(" FROM ");
            qry.append(" COM_COMIS_CLIEN CCC, ");
            qry.append(" COM_TIPO_CLIEN_COMIS_CABEC TCCC, ");
            qry.append(" COM_TIPO_CLIEN_COMIS_DETAL TCCD, ");
            qry.append(" MAE_CLASI CLAS, ");
            qry.append(" MAE_CLIEN_CLASI CLASI, ");
            qry.append(" MAE_CLIEN_TIPO_SUBTI CTS ");
        qry.append(" WHERE ");
        qry.append(" CCC.comi_oid_comi = " + oidComision ); 
        qry.append(" AND CTS.CLIE_OID_CLIE = " +  oidCliente ); 
        qry.append(" AND CCC.tccc_oid_tipo_clie_comi_cabe = TCCC.oid_tipo_clie_comi_cabe  ");
        qry.append(" AND TCCD.tccc_oid_tipo_clie_comi_cabe = TCCC.oid_tipo_clie_comi_cabe ");
        qry.append(" AND CLAS.oid_clas = TCCD.clas_oid_clas  ");
        qry.append(" AND CLASI.clas_oid_clas = CLAS.oid_clas  ");
        qry.append(" AND CLASI.ctsu_oid_clie_tipo_subt = CTS.oid_clie_tipo_subt ");

        try {
            rs = bs.dbService.executeStaticQuery(qry.toString());
         
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
        }
        
        if (!rs.esVacio()){
             respuesta  = new Long (((BigDecimal) rs.getValueAt(0,"OID_CLIE_TIPO_SUBT")).longValue());
        }
        
        UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTipoSubtipoClientePorGerente(Long oidCliente, Long oidComision): Salida");
        return respuesta;            
    }
    
    /** 
    * Metodo obtenerComisiones
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
  public DTOSalida obtenerComisiones(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerComisiones(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT   comision.oid_comi OID, descripcion.val_i18n ");
    query.append("     FROM com_comis comision, v_gen_i18n_sicc descripcion ");
    query.append(" WHERE descripcion.attr_enti = 'COM_COMIS' ");
    query.append(" AND comision.oid_comi = descripcion.val_oid ");
    query.append(" AND descripcion.idio_oid_idio = " + dto.getOidIdioma());
    query.append(" ORDER BY 2  ");
        
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }          
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerComisiones(DTOBelcorp dto): Salida");
     return dtos;     
  }
  
  /** 
    * Metodo obtenerTramosPorComisionesyPeriodos
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
  public DTOSalida obtenerTramosPorComisionesyPeriodos(DTOObtenerTramos dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTramosPorComisionesyPeriodos(DTOObtenerTramos dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT cliente.val_nive_tram, cliente.num_dias ");
    query.append(" FROM com_comis_cobra_acumu comision, com_comis_cobra_acumu_clien cliente ");
    query.append(" WHERE comision.perd_oid_peri = " + dto.getOidPeriodo());
    query.append(" AND comision.comi_oid_comi = " + dto.getOidComision());
    query.append(" AND cliente.COC2_OID_COMI_COBR_ACUM = comision.oid_comi_cobr_acum ");
        
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }           
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerTramosPorComisionesyPeriodos(DTOObtenerTramos dto): Salida");
     return dtos;     
  }
  
  /** 
    * Metodo obtenerPeriodosPorComision
    * @param  dto
    * @return DTOSalida
    * @exception MareException 
    * @author mdolce
    * @referencia --
    */
  public DTOSalida obtenerPeriodosPorComision(DTOOID dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.obtenerPeriodosPorComision(DTOOID dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" SELECT peri.oid_peri, peri.val_nomb_peri ");
    query.append(" FROM cra_perio peri, ");
    query.append(" (SELECT fec_inic, pais_oid_pais, cana_oid_cana, marc_oid_marc ");
    query.append(" FROM cra_perio, com_comis comision ");
    query.append(" WHERE oid_peri = comision.perd_oid_peri AND comision.oid_comi = " + dto.getOid()+ ") fi, ");
    query.append(" (SELECT fec_fina ");
    query.append(" FROM cra_perio, com_comis comision ");
    query.append(" WHERE oid_peri = comision.perd_oid_peri_hast ");
    query.append(" AND comision.oid_comi = " +  dto.getOid() + ") ff ");
    query.append(" WHERE fi.fec_inic <= peri.fec_inic ");
    query.append(" AND ff.fec_fina >= peri.fec_fina ");
    query.append(" AND peri.pais_oid_pais = fi.pais_oid_pais ");
    query.append(" AND peri.cana_oid_cana = fi.cana_oid_cana ");
    query.append(" AND peri.marc_oid_marc = fi.marc_oid_marc ");
        
     try {
         rs = bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }        
     UtilidadesLog.info("DAOMantenimientoComisiones.obtenerPeriodosPorComision(DTOOID dto): Salida");
     return dtos;   
  
  }
  
  /** 
   * Metodo consultarComisionesEscalonada
   * @return ArrayList
   * @exception MareException 
   * @author Sergio Apaza
   * @fecha 19/08/2010
   * @RCR PER-SiCC-2010-0478
   */
  public ArrayList consultarComisionesEscalonada(DTOOID dto) throws MareException{
    UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesEscalonada(DTOOID dto): Entrada");
    ArrayList respuesta = new ArrayList();
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet();
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();

    query.append(" SELECT C.OID_COMI_ESCA, C.OID_COMI_COBR, C.NUM_DIAS_RECU, ");
    query.append("        C.NUM_DIAS_COMI, C.POR_RECU_INIC, C.POR_RECU_FINA, ");
    query.append("        C.POR_COMI, C.VAL_BONO, C.NUM_NIVE ");    
    query.append(" FROM COM_COMIS_ESCAL C ");          
    query.append(" WHERE C.OID_COMI_COBR = "+ dto.getOid());
    UtilidadesLog.debug(query.toString());
    
    try {
           rs = bs.dbService.executeStaticQuery(query.toString());
           if(!rs.esVacio()){
            for(int i=0;i<rs.getRowCount();i++){
              DTOComisionesEscalonada dtoComisionesEscalonada = new DTOComisionesEscalonada();

              if(rs.getValueAt(i, "NUM_NIVE")!=null) 
                dtoComisionesEscalonada.setNivel(new Integer(((BigDecimal) rs.getValueAt(i, "NUM_NIVE")).intValue()));  
              else 
                dtoComisionesEscalonada.setNivel(null);
                  
              if(rs.getValueAt(i, "NUM_DIAS_RECU")!=null) 
                dtoComisionesEscalonada.setDiasRecuperacion(new Integer(((BigDecimal) rs.getValueAt(i, "NUM_DIAS_RECU")).intValue()));  
              else
                dtoComisionesEscalonada.setDiasRecuperacion(null);
                
              if(rs.getValueAt(i, "NUM_DIAS_COMI")!=null) 
                dtoComisionesEscalonada.setDiasComision(new Integer(((BigDecimal) rs.getValueAt(i, "NUM_DIAS_COMI")).intValue()));  
              else
                dtoComisionesEscalonada.setDiasComision(null);
                  
              if(rs.getValueAt(i, "POR_RECU_INIC")!=null) 
                dtoComisionesEscalonada.setPorcentajeRecuperacionInicial((BigDecimal) rs.getValueAt(i, "POR_RECU_INIC"));
              else 
                dtoComisionesEscalonada.setPorcentajeRecuperacionInicial(null);

              if(rs.getValueAt(i, "POR_RECU_FINA")!=null) 
                dtoComisionesEscalonada.setPorcentajeRecuperacionFinal((BigDecimal) rs.getValueAt(i, "POR_RECU_FINA"));
              else 
                dtoComisionesEscalonada.setPorcentajeRecuperacionFinal(null);

              if(rs.getValueAt(i, "POR_COMI")!=null) 
                dtoComisionesEscalonada.setPorcentajeComision((BigDecimal) rs.getValueAt(i, "POR_COMI"));
              else 
                dtoComisionesEscalonada.setPorcentajeComision(null);

              if(rs.getValueAt(i, "VAL_BONO")!=null) 
                dtoComisionesEscalonada.setBono((BigDecimal) rs.getValueAt(i, "VAL_BONO"));
              else 
                dtoComisionesEscalonada.setBono(null);
              
              if(rs.getValueAt(i, "OID_COMI_ESCA")!=null) 
                dtoComisionesEscalonada.setOid(new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_ESCA")).longValue()));  
              
              if(rs.getValueAt(i, "OID_COMI_COBR")!=null) {
                dtoComisionesEscalonada.setOidComisionesCobranzas(new Long(((BigDecimal) rs.getValueAt(i, "OID_COMI_COBR")).longValue()));  
              }
                                      
              respuesta.add(dtoComisionesEscalonada);
            }
           
           }
              
       }catch (Exception e) {
           UtilidadesLog.error(e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }  
       
      UtilidadesLog.info("DAOMantenimientoComisiones.consultarComisionesEscalonada(DTOOID dto): Salida");
      return respuesta;
  }
 
    /** 
     * Metodo guardarComisionEscalonada
     * @return ArrayList
     * @exception MareException 
     * @author Sergio Apaza
     * @fecha 19/08/2010
     * @RCR PER-SiCC-2010-0478
     */
    public void guardarComisionEscalonada(DTOComisionesEscalonada dtoCobranzaTP, Long oidComisionCobranza) throws MareException {
       UtilidadesLog.info("DAOMantenimientoComisiones.guardarComisionEscalonada(DTOComisionesEscalonada dtoCobranzaTP, Long oidCobranza): Entrada");
       BelcorpService bs;

        StringBuffer query = new StringBuffer();
        query.append(" INSERT INTO COM_COMIS_ESCAL( ");
        query.append(" OID_COMI_ESCA, OID_COMI_COBR, NUM_DIAS_RECU, ");
        query.append(" NUM_DIAS_COMI, POR_RECU_INIC, POR_RECU_FINA, ");
        query.append(" POR_COMI, VAL_BONO, NUM_NIVE) ");
        query.append(" VALUES (COM_COCE_SEQ.nextval, ");
        query.append( oidComisionCobranza + " , " );
        query.append( dtoCobranzaTP.getDiasRecuperacion() + " , " );
        query.append( dtoCobranzaTP.getDiasComision() + " , " );
        query.append( dtoCobranzaTP.getPorcentajeRecuperacionInicial() + " , " );
        query.append( dtoCobranzaTP.getPorcentajeRecuperacionFinal() + " , " );
        query.append( dtoCobranzaTP.getPorcentajeComision() + " , " );
        query.append( dtoCobranzaTP.getBono() + " , " );
        query.append( dtoCobranzaTP.getNivel());
        query.append(" ) ");    
        
        try {
            bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAOMantenimientoComisiones.guardarComisionEscalonada(DTOComisionesEscalonada dtoCobranzaTP, Long oidCobranza): Salida");    
    }

    /** 
     * Metodo eliminarComisionesEscalonadas
     * @return ArrayList
     * @exception MareException 
     * @author Sergio Apaza
     * @fecha 19/08/2010
     * @RCR PER-SiCC-2010-0478
     */
    public void eliminarComisionesEscalonadas(Long oidComisionCobranza) throws MareException {
       UtilidadesLog.info("DAOMantenimientoComisiones.eliminarComisionesEscalonadas(Long oidComisionCobranza): Entrada");
       BelcorpService bs;

        StringBuffer query = new StringBuffer();
        query.append(" DELETE FROM COM_COMIS_ESCAL ");
        query.append(" WHERE OID_COMI_COBR = " + oidComisionCobranza);
       
        try {
            bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAOMantenimientoComisiones.eliminarComisionesEscalonadas(Long oidComisionEscalonada): Salida");    
    }
    
}