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
 */
package es.indra.sicc.logicanegocio.cob;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
//import es.indra.sicc.entidades.cob.EstadoUsuarioLocal;
//import es.indra.sicc.entidades.cob.EstadoUsuarioLocalHome;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocal;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocalHome;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.COBEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
//import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOResumen;
import es.indra.sicc.dtos.cob.DTOBuscarUsuariosCob;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import java.util.Collection;
//import java.util.Iterator;
import javax.ejb.FinderException;
import es.indra.sicc.util.DTOBelcorp;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOParametrizacionCOB 
{
  public DAOParametrizacionCOB()
  {
  }
  /*autor Marta Montiel
   * 28/01/05*/
  
  public RecordSet obtenerEtapasDeuda(es.indra.sicc.util.DTOBelcorp dtoe)  throws MareException{
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapasDeuda(es.indra.sicc.util.DTOBelcorp dtoe): Entrada");
  
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      query.append(" SELECT OID_ETAP_DEUD AS OID, VAL_DESC AS DESCRIPCION ");
      query.append(" FROM COB_ETAPA_DEUDA ");
      query.append(" WHERE PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" ORDER BY DESCRIPCION ");
      
       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapasDeuda(es.indra.sicc.util.DTOBelcorp dtoe): Salida");
       
       return rs;      
   
  }
  
  /*autor idedough
   * 28/01/05*/
  
  public RecordSet obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe) throws MareException{
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe): Entrada");  
  
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      query.append(" SELECT UCO.OID_USUA_COBR OID,");
      query.append("      P.name CODIGO,"); 
      query.append("      CONCAT('',CONCAT(pv.STRINGVALUE,CONCAT(' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE))))))) NOMBRE,");
      query.append("      P.IDPRINCIPAL ID_USUARIO ");
      query.append(" FROM Principals P ");
      query.append("      LEFT JOIN PROPERTYVALUES pv ON pv.IDPROPERTY=5 AND pv.IDPRINCIPAL=P.IDPRINCIPAL ");
      query.append("      LEFT JOIN PROPERTYVALUES pv2 ON pv2.IDPROPERTY=6 AND pv2.IDPRINCIPAL=p.IDPRINCIPAL ");
      query.append("      LEFT JOIN PROPERTYVALUES pv3 ON pv3.IDPROPERTY=2 AND pv3.IDPRINCIPAL=p.IDPRINCIPAL ");
      query.append("      LEFT JOIN PROPERTYVALUES pv4 ON pv4.IDPROPERTY=3 AND pv4.IDPRINCIPAL=p.IDPRINCIPAL, ");
      query.append("      USERS U, ");
      query.append("      COB_USUAR_COBRA UCO ");
      query.append(" WHERE ");
      query.append("      U.IDUSER = P.IDPRINCIPAL ");
      //               -- CODIGO --
      if(dtoe.getCodUsuario() != null && !("".equals(dtoe.getCodUsuario())))
         query.append(" AND  P.name =  '" + dtoe.getCodUsuario() + "' ");
      //               -- NOMBRE1 --
      if(dtoe.getNombre1() != null && !("".equals(dtoe.getNombre1())))
         query.append(" AND  PV.STRINGVALUE = '" + dtoe.getNombre1() + "' ");
      //               -- NOMBRE2 --
      if(dtoe.getNombre2() != null && !("".equals(dtoe.getNombre2())))
         query.append(" AND  PV2.STRINGVALUE = '" + dtoe.getNombre2() + "' ");
      //               -- APELLIDO1 --
      if(dtoe.getApellido1() != null && !("".equals(dtoe.getApellido1())))
         query.append(" AND  PV3.STRINGVALUE = '" + dtoe.getApellido1() + "' " );
      //               -- APELLIDO2 --
      if(dtoe.getApellido2() != null && !("".equals(dtoe.getApellido2())))
         query.append(" AND  PV4.STRINGVALUE = '" + dtoe.getApellido2() + "' " ); 
      //               -- Estado USUARIO COBRANZAS --
      query.append(" AND  UCO.USER_OID_USUA_COBR = U.IDUSER ");
      if(dtoe.getOidEstadoUsuario() != null)
         query.append(" AND  UCO.ESUS_OID_ESTA_USUA = " + dtoe.getOidEstadoUsuario());      
      try 
      {   rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe));        
      }
      catch (Exception ex) 
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }		             
      if(rs.esVacio()) {
        throw new MareException(null, null, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe): Salida");
      
      return rs;     
  }
  /*autor idedough
   * 28/01/05*/
  public RecordSet recuperarUsuarioCob(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOParametrizacionCOB.recuperarUsuarioCob(DTOOID dtoe): Entrada");
      
      RecordSet rs = new RecordSet();
      
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex) {   
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      query.append(" SELECT UCO.OID_USUA_COBR OID, ");
      query.append("        UCO.ESUS_OID_ESTA_USUA OID_ESTADO, "); 
      query.append("        UCO.FEC_ULTI_ESTA FECHA_ULTIMO_ESTADO,");
      query.append("        UCO.IND_JEFE_COBR IND_JEFE_COB, ");
      query.append("        UCO.IND_USUA_SUPE IND_USU_SUP, ");
      query.append("        UCO.IND_USUA_EXTE IND_USU_EXTE, ");
      query.append("        UCO.VAL_TURN_HORA_ENTR TURNO_ENTRADA, ");
      query.append("        UCO.VAL_TURN_HORA_SALI TURNO_SALIDA, ");      
      query.append("        PURE.NAME RESPALDO, ");
      query.append("        PUSU.NAME SUPERVISOR, ");      
      query.append("        UCO.VAL_OBSE OBSERVACIONES  ");      
      query.append(" FROM  ");
      query.append("        Principals PURE, ");
      query.append("        USERS URE, ");
      query.append("        Principals PUSU, ");
      query.append("        USERS USU, ");
      query.append("        COB_USUAR_COBRA UCO ");     
      query.append(" WHERE ");
      query.append("        UCO.OID_USUA_COBR = " + dtoe.getOid() + " AND ");
      //           -- USUARIO RESPALDO  --
      query.append("        UCO.USER_OID_USUA_RESP = URE.IDUSER(+) AND ");
      query.append("        URE.IDUSER = PURE.IDPRINCIPAL(+) AND ");
      //           -- USUARIO SUPERVISOR --
      query.append("        UCO.USER_OID_USUA_SUPE = USU.IDUSER(+) AND ");
      query.append("        USU.IDUSER = PUSU.IDPRINCIPAL(+) "); 
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch (Exception ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      //
      if(rs.esVacio()) {
          query = new StringBuffer();
          query.append(" SELECT UCO.OID_USUA_COBR OID, ");
          query.append("        UCO.ESUS_OID_ESTA_USUA OID_ESTADO, "); 
          query.append("        UCO.FEC_ULTI_ESTA FECHA_ULTIMO_ESTADO,");
          query.append("        UCO.IND_JEFE_COBR IND_JEFE_COB, ");
          query.append("        UCO.IND_USUA_SUPE IND_USU_SUP, ");
          query.append("        UCO.IND_USUA_EXTE IND_USU_EXTE, ");
          query.append("        UCO.VAL_TURN_HORA_ENTR TURNO_ENTRADA, ");
          query.append("        UCO.VAL_TURN_HORA_SALI TURNO_SALIDA, ");  
          query.append("        '' RESPALDO, ");
          query.append("        '' SUPERVISOR, ");
          query.append("        UCO.VAL_OBSE OBSERVACIONES  "); 
          query.append(" FROM  ");
          query.append("        COB_USUAR_COBRA UCO ");     
          query.append(" WHERE ");
          query.append("        UCO.OID_USUA_COBR = " + dtoe.getOid() );
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
              if(rs.esVacio()){
                  UtilidadesLog.debug("RecordSet esta vacio!");  
                  throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                 
              } 
          }
          catch (Exception ex) {
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
      else {
          UtilidadesLog.debug("rs no esta vacio " + rs.toString());
      }
      
        UtilidadesLog.info("DAOParametrizacionCOB.recuperarUsuarioCob(DTOOID dtoe): Salida");
      
      return rs; 
  }
  /*autor Marta Montiel
   * 28/01/05*/
  
  public RecordSet obtenerResumen(DTOResumen dtoe) throws MareException{
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerResumen(DTOResumen dtoe): Entrada");
  
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }            
       /*query.append(" SELECT distinct p.IDPRINCIPAL AS OID,CONCAT(p.name,CONCAT(' ',CONCAT(pv.STRINGVALUE,CONCAT(' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE)))))))) NOMBRE, ");
       query.append(" gen.VAL_I18N AS CANAL, ");
       query.append(" sma.DES_MARC AS MARCA, "); 
       query.append(" subvta.DES_SUBG_VENT AS SUBGERVENTA, ");
       query.append(" gen2.VAL_I18N AS REGION, ");
       query.append(" gen3.VAL_I18N AS ZONA, ");
       query.append(" secc.DES_SECCI AS SECCION, ");
       query.append(" gen5.VAL_I18N AS TERRITORIO ");
       query.append(" FROM v_gen_i18n_sicc gen, ");
       query.append(" v_gen_i18n_sicc gen2, ");
       query.append(" v_gen_i18n_sicc gen3, ");
       query.append(" v_gen_i18n_sicc gen5, ");
       query.append(" seg_marca sma, ");
       query.append(" zon_secci secc, ");
       query.append(" cob_usuar_etapa_cobra_detal cdetal, ");
       query.append(" zon_sub_geren_venta subvta, ");
       query.append(" cob_usuar_etapa_cobra_cabec ccabe, ");
       query.append(" cob_usuar_cobra usucob, ");
       query.append(" own_mare.principals p, ");
       query.append(" propertyvalues pv, ");
       query.append(" propertyvalues pv2, ");
       query.append(" propertyvalues pv3, ");
       query.append(" propertyvalues pv4, ");
       query.append(" own_mare.users u ");
       query.append(" WHERE cdetal.zsgv_oid_subg_vent = subvta.oid_subg_vent ");
       query.append(" AND ccabe.oid_usua_etap_cobr = cdetal.oid_usua_etap_cobr_deta ");
       query.append(" AND secc.oid_secc(+) = cdetal.zscc_oid_secc ");
       query.append(" AND sma.oid_marc = subvta.marc_oid_marc ");
       query.append(" AND ccabe.usco_oid_usua_cobr = usucob.oid_usua_cobr ");
       query.append(" AND gen.val_oid = subvta.cana_oid_cana ");
       query.append(" AND gen.attr_enti = 'SEG_CANAL' ");
       query.append(" AND gen.attr_num_atri = 1 ");
       query.append(" AND gen.idio_oid_idio = '" +  dtoe.getOidIdioma() + " ' ");
       query.append(" AND pv.idproperty(+) = 2 ");
       query.append(" AND pv.idprincipal(+) = p.idprincipal ");
       query.append(" AND pv2.idproperty(+) = 3 ");
       query.append(" AND pv2.idprincipal(+) = p.idprincipal ");
       query.append(" AND pv3.idproperty = 5 ");
       query.append(" AND pv3.idprincipal = p.idprincipal ");
       query.append(" AND pv4.idproperty = 6 ");
       query.append(" AND pv4.idprincipal = p.idprincipal ");
       query.append(" AND gen2.val_oid(+) = '" +  dtoe.getOidIdioma() + " ' ");
       query.append(" AND gen2.attr_enti(+) = 'ZON_REGIO' ");
       query.append(" AND gen2.attr_num_atri(+) = 1 ");
       query.append(" AND gen2.idio_oid_idio(+) = '" +  dtoe.getOidIdioma() + " ' ");
       query.append(" AND gen3.val_oid(+) = cdetal.zzon_oid_zona ");
       query.append(" AND gen3.attr_enti(+) = 'ZON_ZONA' ");
       query.append(" AND gen3.attr_num_atri(+) = 1 ");
       query.append(" AND gen3.idio_oid_idio(+) = '" +  dtoe.getOidIdioma() + " ' ");
       query.append(" AND gen5.val_oid(+) = cdetal.terr_oid_terr ");
       query.append(" AND gen5.attr_enti(+) = 'ZON_TERRI' ");
       query.append(" AND gen5.attr_num_atri(+) = 1 ");
       query.append(" AND gen5.idio_oid_idio(+) = '" +  dtoe.getOidIdioma() + " ' ");
       query.append(" AND u.iduser = p.idprincipal ");
       query.append(" AND p.idprincipal = ccabe.usco_oid_usua_cobr ");
       */
       
       /*query.append(" SELECT distinct p.IDPRINCIPAL AS OID, ");
       query.append(" p.name AS USUARIO, ");
       */
       //Se le agega "p.IDPRINCIPAL," segun BELC300017927 
       //query.append(" SELECT distinct p.name AS USUARIO, "); 
       query.append(" SELECT distinct p.IDPRINCIPAL, p.name AS USUARIO, ");
       query.append(" CONCAT(p.name,CONCAT(' ',CONCAT(pv.STRINGVALUE,CONCAT(' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE)))))))) NOMBRE,  ");
       query.append(" sma.DES_MARC AS MARCA, ");
       query.append(" gen.VAL_I18N AS CANAL, ");       
       query.append(" subvta.DES_SUBG_VENT AS SUBGERVENTA, ");
       query.append(" regio.DES_REGI AS REGION, ");
       query.append(" zona.DES_ZONA AS ZONA, ");       
    	 query.append(" secc.DES_SECCI AS SECCION, ");  
       query.append(" terri.COD_TERR AS TERRITORIO ");
       query.append(" FROM v_gen_i18n_sicc gen, ");
       query.append(" SEG_CANAL canal, ");
       query.append(" ZON_TERRI terri,  ");
       query.append(" ZON_ZONA zona, ");
       query.append(" ZON_REGIO regio, ");
       query.append(" seg_marca sma, ");
       query.append(" zon_secci secc, ");
       query.append(" cob_usuar_etapa_cobra_detal cdetal, ");
       query.append(" zon_sub_geren_venta subvta, ");
       query.append(" cob_usuar_etapa_cobra_cabec ccabe, ");
       query.append(" cob_usuar_cobra usucob, ");
       query.append(" principals p, ");
       query.append(" propertyvalues pv, ");
       query.append(" propertyvalues pv2, ");
       query.append(" propertyvalues pv3, ");
       query.append(" propertyvalues pv4, ");
       query.append(" users u ");
       query.append(" WHERE cdetal.zsgv_oid_subg_vent = subvta.oid_subg_vent  ");
       query.append(" AND ccabe.oid_usua_etap_cobr = cdetal.UECC_OID_USUA_ETAP_COBR  ");
       query.append(" AND secc.oid_secc(+) = cdetal.zscc_oid_secc  ");
       query.append(" AND sma.oid_marc = subvta.marc_oid_marc  ");
       query.append(" AND ccabe.usco_oid_usua_cobr = usucob.oid_usua_cobr  ");
       query.append(" AND gen.val_oid = subvta.cana_oid_cana  ");
       query.append(" AND gen.attr_enti = 'SEG_CANAL'  ");
       query.append(" AND gen.attr_num_atri = 1  ");
       query.append(" AND gen.idio_oid_idio = '1'  ");
       query.append(" AND pv.idproperty(+) = 2  ");
       query.append(" AND pv.idprincipal(+) = p.idprincipal  ");
       query.append(" AND pv2.idproperty(+) = 3  ");
       query.append(" AND pv2.idprincipal(+) = p.idprincipal  ");
       query.append(" AND pv3.idproperty = 5  ");
       query.append(" AND pv3.idprincipal = p.idprincipal  ");
       query.append(" AND pv4.idproperty = 6  ");
       query.append(" AND pv4.idprincipal = p.idprincipal 		 ");
       query.append(" AND terri.OID_TERR = cdetal.terr_oid_terr		 ");
       query.append(" AND zona.OID_ZONA = cdetal.zzon_oid_zona		 ");
       query.append(" AND regio.OID_REGI = cdetal.ZORG_OID_REGI		 ");
       query.append(" AND u.iduser = p.idprincipal          ");
       query.append(" AND p.idprincipal = usucob.USER_OID_USUA_COBR  ");
       
      /* Validaciones */
      if( dtoe.getOidMarca()!= null ){
        query.append(" AND subvta.MARC_OID_MARC = " + dtoe.getOidMarca() );
      }
      if( dtoe.getOidCanal() != null){
        query.append(" AND subvta.CANA_OID_CANA = " + dtoe.getOidCanal() );
      }
      if( dtoe.getOidSGV() != null ){
        query.append(" AND subvta.OID_SUBG_VENT = " + dtoe.getOidSGV() );
      }
      if( dtoe.getOidRegion() != null ){
        query.append(" AND cdetal.ZORG_OID_REGI = " + dtoe.getOidRegion() );      
      }
      if( dtoe.getOidZona() != null ){
        query.append(" AND cdetal.ZZON_OID_ZONA = " + dtoe.getOidZona() );      
      }
      if( dtoe.getOidSeccion() != null ){
        query.append(" AND cdetal.ZSCC_OID_SECC = " + dtoe.getOidSeccion() );
      }
      if( dtoe.getOidTerritorio() != null ){
        query.append(" AND cdetal.TERR_OID_TERR =  " + dtoe.getOidTerritorio() );
      }
      UtilidadesLog.debug("query   " + query.toString() );
      try 
      {   rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch (Exception ex) 
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }	
      
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerResumen(DTOResumen dtoe): Salida");
      
      return rs;    
  }
  
  /*autor idedough
   * 28/01/05*/
  public RecordSet obtenerSupervisorEspecial() throws MareException{
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerSupervisorEspecial(): Entrada");
     
     /*Acceder a la entidad UsuariosCobranzas filtrando por: 
      indUsuarioSupervisor=True 
      Obtener los registros que cumplan con el filtro. */
     RecordSet rs = new RecordSet();
     UsuariosCobranzasLocalHome usu_cobraLHome = null;
		 UsuariosCobranzasLocal usu_cobraLocal = null;
         
        UtilidadesLog.debug("CALL: this.getUsuariosCobranzasLocalHome() ");
     
        usu_cobraLHome = this.getUsuariosCobranzasLocalHome();
         
        UtilidadesLog.debug("      this.getUsuariosCobranzasLocalHome() .... [OK]");
     
     Collection col = null;
		 try{  
            UtilidadesLog.debug("CALL: usu_cobraLHome.findByIndUsuarioSupervisor(Boolean.TRUE) ");
            col = usu_cobraLHome.findByIndUsuarioSupervisor(Boolean.TRUE);        			        			
                 } catch(NoResultException nre) {
                     nre.printStackTrace();
                     throw new MareException(nre, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch(PersistenceException pex) {
                     pex.printStackTrace();
                     throw new MareException(pex, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                 }
         
        UtilidadesLog.debug("    usu_cobraLHome.findByIndUsuarioSupervisor(Boolean.TRUE) .... [OK]");     
        
     try{ 
         if(col != null){ 
            rs = new RecordSet(col);
            UtilidadesLog.debug("rs-> " + rs.toString());
         }
         //:new RecordSet();
     }catch(Exception e){  
        UtilidadesLog.debug("Error al obtener  RecordSet");
				throw new MareException(e,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
     }
     
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerSupervisorEspecial(): Salida");
     
     return rs;
  }
  
  public DTOSalida obtenerEstadoUsuario(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerEstadoUsuario(DTOBelcorp dtoe): Entrada");

     RecordSet rs = new RecordSet();
     DTOSalida dtos = new DTOSalida();            
     
     StringBuffer query = new StringBuffer();
     BelcorpService bs;
     
     try {
      bs = BelcorpService.getInstance();
     }
     catch(MareMiiServiceNotFoundException ex) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
     }       
     
     /* Modificacion realizada por Cristian Valenzuela
      * Fecha = 22/2/2005
      * Comentario = Ahora la descripcion del estado es internacionalizable
      */
          
     query.append(" SELECT OID_ESTA_USUA AS OID, b.VAL_I18N ");
     query.append(" FROM COB_ESTAD_USUAR a, GEN_I18N_SICC_COMUN b ");
     query.append(" WHERE b.ATTR_ENTI = 'COB_ESTAD_USUAR' ");
     query.append(" AND b.ATTR_NUM_ATRI = 1 ");
     query.append(" AND b.VAL_OID = a.OID_ESTA_USUA ");
     query.append(" AND b.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
     query.append(" ORDER BY VAL_I18N ");
     
     try {
      rs = bs.dbService.executeStaticQuery(query.toString());
      if(rs != null)
        dtos.setResultado(rs);
     }
     catch (Exception ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }	
     
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerEstadoUsuario(DTOBelcorp dtoe): Salida");
     
     return dtos;
  }
  
  /*autor idedough
   * 28/01/05*/
  public RecordSet obtenerEtapaAsignada (Long oidUsuarioCob) throws MareException{
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapaAsignada (Long oidUsuarioCob): Entrada");  
  
    /*Acceder a las entidades UsuariosEtapaCobranzaCabecera B y UsuariosEtapaCobranzaDetalle C, filtrando por: 
      B.oidUsuariosCobranzas= DTOE.oidUsuarioCob //recibido 
      B.oid = C.oidEtapaCobranzaCabecera 
      Obtener los registros que cumplan con el filtro. */
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }       
      query.append(" SELECT UECC.OID_USUA_ETAP_COBR OID_UECC ");
      query.append(" FROM ");
      query.append("     COB_USUAR_ETAPA_COBRA_CABEC UECC, COB_USUAR_ETAPA_COBRA_DETAL UECD ");
      query.append(" WHERE ");
      query.append("     UECC.OID_USUA_ETAP_COBR = UECD.UECC_OID_USUA_ETAP_COBR "); // <- B.oidUsuariosCobranzas    
      query.append("     AND USCO_OID_USUA_COBR = " + oidUsuarioCob); // <- oidUsuarioCobranza
      try 
      {   rs = bs.dbService.executeStaticQuery(query.toString());
      }
      catch (Exception ex) 
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapaAsignada (Long oidUsuarioCob): Salida");
      
      return rs;      
      // - solution 2 -
      /*UsuariosEtapaCobranzaCabeceraLocalHome usu_etapa_cobra_cabLHome = null;
		  UsuariosEtapaCobranzaCabeceraLocal usu_etapa_cobra_cabLocal = null;	 	
		  usu_etapa_cobra_cabLHome = COBEjbLocators.getUsuariosEtapaCobranzaCabeceraLocalHome();
      Collection colCabecera = null;
      try
      {  colCabecera = usu_etapa_cobra_cabLHome.findByPrimaryKey(oidUsuarioCob);        			
		  }
      catch(FinderException fe)
      {
				 System.out.println("Error buscando en UsuariosEtapaCobranzaCabecera");
				 throw new MareException(fe,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		  }                              
      UsuariosEtapaCobranzaDetalleLocalHome usu_etapa_cobra_detLHome = null;
		  UsuariosEtapaCobranzaDetalleLocal usu_etapa_cobra_detLocal = null;	 	
		  usu_etapa_cobra_detLHome = COBEjbLocators.getUsuariosEtapaCobranzaDetalleLocalHome();
      Collection collDetalle = null;
      try
      {  collDetalle = usu_etapa_cobra_detLHome.findAll();        			
		  }
      catch(FinderException fe)
      {
				 System.out.println("Error buscando en UsuariosEtapaCobranzaDetalle");
				 throw new MareException(fe,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		  }  
      if(collDetalle != null)
      {         
      }*/          
  }
  
  /*autor Marta Montiel
   * 28/01/05*/
   public RecordSet obtenerTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dtoe)  throws MareException{
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dtoe): Entrada");
   
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      // gPineda - V-COB006 - 30/01/2007
      //query.append(" SELECT OID_ETAP_DEUD_TIPO_CARG AS OID, VAL_DESC descripcion ");
      query.append(" SELECT  oid_etap_deud_tipo_carg AS OID, NVL(val_desc, gen.VAL_I18N) descripcion  ");
      query.append("    FROM cob_etapa_deuda_tipo_cargo etapTipoCar, ");
      query.append(" 		 ccc_tipo_cargo_abono tipoCar, ");
      query.append(" 		 gen_i18n_sicc_pais gen ");
      query.append("   WHERE ETDE_OID_ETAP_DEUD = " + dtoe.getOid() );
      query.append("    	 and etapTipoCar.TCAB_OID_TIPO_CARG_ABON = tipoCar.OID_TIPO_CARG_ABON ");
      query.append(" 		 and gen.VAL_OID = tipoCar.OID_TIPO_CARG_ABON ");
      query.append(" 		 and gen.ATTR_ENTI = 'CCC_TIPO_CARGO_ABONO' ");
      query.append(" 		 and gen.ATTR_NUM_ATRI = 1 ");
      query.append(" ORDER BY descripcion ");
                       
       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
    UtilidadesLog.info("DAOParametrizacionCOB.obtenerTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dtoe): Salida");
       
       return rs;         
  }
  
  
    public DTOSalida obtenerEtapasDeudaPorTipoCargo(DTOOID dto) throws MareException{
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapasDeudaPorTipoCargo(DTOOID dto): Entrada");
    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        try {   
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {   
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
        query.append("  select OID_ETAP_DEUD_TIPO_CARG, VAL_DESC    ");
        query.append("    from COB_ETAPA_DEUDA_TIPO_CARGO    ");
        query.append("   where TCAB_OID_TIPO_CARG_ABON =  " + dto.getOid());
    
        try {   
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {   
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOParametrizacionCOB.obtenerEtapasDeudaPorTipoCargo(DTOOID dto): Salida");
        
        return new DTOSalida(rs);
    }
    
    private UsuariosCobranzasLocalHome getUsuariosCobranzasLocalHome()
    {
    return new UsuariosCobranzasLocalHome();
    }
}
