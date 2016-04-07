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

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOBuscarAccionesProcesosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarTiposBloqueoUsuario;
import es.indra.sicc.dtos.mae.DTOClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOTipoBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarUsuariosBloqueo;
import es.indra.sicc.entidades.mae.UsuariosBloqueoLocal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;


/**
 * Creado por cambio COL-BLO-001 (V4)
 * @author dmorello
 * @since 14-03-2008
 */
public class DAOBloqueosClientes {

  public DAOBloqueosClientes() {
  }
  
  /**
   * Obtiene OID y descripcion de las acciones de bloqueo para cargar un combo
   * @author dmorello
   * @since 14-03-2008
   */
  public RecordSet obtenerValoresAccionesBloqueo() throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.obtenerValoresAccionesBloqueo(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      query.append("SELECT oid_valo_acci_bloq, des_valo_bloq ");
      query.append("  FROM mae_valor_accio_bloqu ");
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOBloqueosClientes.obtenerValoresAccionesBloqueo(): Salida");
      return rs;
  }
  
  
  /**
   * Obtiene OID y descripcion de los motivos de rechazo (STO) para cargar un combo
   * @author dmorello
   * @since 14-03-2008
   */
  public RecordSet obtenerMotivosRechazo() throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.obtenerMotivosRechazo(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      query.append("SELECT oid_moti_rech, des_moti_rech ");
      query.append("  FROM sto_motiv_recha ");
      query.append(" ORDER BY des_moti_rech ");
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOBloqueosClientes.obtenerMotivosRechazo(): Salida");
      return rs;
  }
  
  /**
   * Recupera los tipos de bloqueo de BD, permitiendo filtrar por codigo y/o
   * descripcion i18n
   * @author dmorello
   * @since 14-03-2008
   */
  public RecordSet consultarTiposBloqueo(DTOTipoBloqueo dtoe) throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.consultarTiposBloqueo(DTOTipoBloqueo dtoe): Entrada");
      UtilidadesLog.debug("dtoe: " + dtoe);
      UtilidadesLog.debug("dtoe.idioma: " + dtoe.getOidIdioma());
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      query.append("SELECT * FROM (");
      query.append("SELECT   ROW_NUMBER() OVER(ORDER BY tipo.cod_tipo_bloq) AS OID,");
      query.append("         tipo.oid_tipo_bloq,");
      query.append("         tipo.cod_tipo_bloq,");
      query.append("         (SELECT val_i18n");
      query.append("            FROM v_gen_i18n_sicc");
      query.append("           WHERE attr_enti = 'MAE_TIPO_BLOQU'");
      query.append("             AND idio_oid_idio = ").append(dtoe.getOidIdioma());
      query.append("             AND val_oid = tipo.oid_tipo_bloq) AS des_tipo_bloq,");
      query.append("         tipo.ind_bloq_fina,");
      query.append("         formabloqueo.des_valo_bloq,");
      query.append("         formadesbloqueo.des_valo_bloq AS des_valo_desb,");
      query.append("         tipo.num_nive_grav_bloq,");
      query.append("         motivo.des_moti_rech,");
      query.append("         formabloqueo.oid_valo_acci_bloq,");
      query.append("         formadesbloqueo.oid_valo_acci_bloq AS oid_valo_acci_desb,");
      query.append("         motivo.oid_moti_rech");
      query.append("    FROM mae_tipo_bloqu tipo, ");
      query.append("         mae_valor_accio_bloqu formabloqueo, ");
      query.append("         mae_valor_accio_bloqu formadesbloqueo,");
      query.append("         sto_motiv_recha motivo");
      query.append("   WHERE tipo.maab_oid_valo_acci_bloq = formabloqueo.oid_valo_acci_bloq (+)");
      query.append("     AND tipo.maab_oid_valo_acci_desb = formadesbloqueo.oid_valo_acci_bloq (+)");
      query.append("     AND tipo.stmr_oid_moti_rech = motivo.oid_moti_rech (+)");
      if (dtoe.getCodigo() != null) {
          query.append(" AND tipo.cod_tipo_bloq LIKE '").append(dtoe.getCodigo()).append('\'');
      }
      query.append(")");
      if (dtoe.getDescripcion() != null) {
          query.append(" WHERE des_tipo_bloq LIKE '").append(dtoe.getDescripcion()).append('\'');
      }
      query.append(" ORDER BY cod_tipo_bloq ");

      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoe));
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.debug("rs:" + rs);
      if (rs == null || rs.getRowCount() == 0) {
          String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          throw new MareException("", UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOBloqueosClientes.consultarTiposBloqueo(DTOTipoBloqueo dtoe): Salida");
      return rs;
  }
  
  /**
   * Recupera los OIDs de los bloqueos financieros que existan en BD
   * @author dmorello
   * @since 14-03-2008
   */
  public RecordSet obtenerBloqueosFinancieros() throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.obtenerBloqueosFinancieros(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      query.append("SELECT oid_tipo_bloq FROM mae_tipo_bloqu ");
      query.append(" WHERE ind_bloq_fina = 1");
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOBloqueosClientes.obtenerBloqueosFinancieros(): Salida");
      return rs;
  }
  
  /**
   * Accede a MAE_TIPO_BLOQU y recupera OID y descripcion i18n de todos los
   * tipos de bloqueo (con el idioma que viene en el DTO de entrada)
   * @author dmorello
   * @since 14-03-2008
   */
  public RecordSet obtenerTiposBloqueo(DTOBelcorp dtoe) throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueo(DTOBelcorp dtoe): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
        
        query.append("SELECT tb.OID_TIPO_BLOQ, ");
        query.append(       "PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dtoe.getOidIdioma()
                           +", tb.OID_TIPO_BLOQ, 'MAE_TIPO_BLOQU') DES_TIPO_BLOQ ");
        query.append(  "FROM MAE_TIPO_BLOQU tb ");
        query.append("ORDER BY DES_TIPO_BLOQ ");
        
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueo(DTOBelcorp dtoe): Salida");
      return rs;
  }
  
  /**
   * Verifica si un nivel de gravedad ya existe para algun tipo de bloqueo
   * distinto al que esta siendo tratado. Permite excluir de la validacion el
   * tipo de bloqueo con el que se esta trabajando (por ejemplo, al modificarlo).
   * @param nivelGravedad nivel de gravedad del que se quiere ver que no se repita
   * @param oidTipoBloqueoExcluir OID del tipo de bloqueo a excluir de la validacion. Puede ser nulo.
   * @return Boolean.TRUE si el nivel de gravedad no se repite, Boolean.FALSE en caso contrario.
   * 
   * @author dmorello
   * @since 14-03-2008
   */
  public Boolean validarNivelGravedadSinRepetir(Integer nivelGravedad, Long oidTipoBloqueoExcluir) throws MareException {
      UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueo(DTOBelcorp dtoe): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      query.append("SELECT COUNT(*) ");
      query.append("    FROM mae_tipo_bloqu tipo");
      query.append("   WHERE tipo.num_nive_grav_bloq = ").append(nivelGravedad);
      if (oidTipoBloqueoExcluir != null) {
        query.append("   AND tipo.oid_tipo_bloq != ").append(oidTipoBloqueoExcluir);
      }
      
      RecordSet rs = null;
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      BigDecimal count = (BigDecimal)rs.getValueAt(0,0);
      UtilidadesLog.debug("count: " + count);
      UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueo(DTOBelcorp dtoe): Salida");
      if (count.longValue() == 0) {
          return Boolean.TRUE;
      } else {
          return Boolean.FALSE;
      }
  }

    /**
     * Consulta paginada para Lista editable de CU MAE 'Acciones-procesos-bloqueo'.
     * Los registros recuperados van ordenados 'DESC' por Tipo Bloqueo/Proceso bloqueo/
     * Accion bloqueo.
     * @author eiraola
     * @since 17/10/2007
     */
    public RecordSet buscarAccionesProcesosBloqueo(DTOBuscarAccionesProcesosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.buscarAccionesProcesosBloqueo(dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        
        // Agregado para paginar y mantener los distintos ordenes de registros
        query.append("SELECT rownum as OID, consultaOriginal.* FROM ( ");
        
        // Consulta original - Inicio
        query.append("SELECT apb.OID_ACCI_PROC_BLOQ, ");
        query.append(       "apb.TIBQ_OID_TIPO_BLOQ, ");
        query.append(       "PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + dtoE.getOidIdioma() +
                            ", apb.TIBQ_OID_TIPO_BLOQ, 'MAE_TIPO_BLOQU') DES_TIPO_BLOQ, ");
        query.append(       "apb.MAPB_OID_PROC_BLOQ, ");
        query.append(       "pb.DES_PROC_BLOQ, ");
        query.append(       "apb.MABL_OID_ACCI_BLOQ, ");
        query.append(       "ab.DES_ACCI_BLOQ ");
        query.append(  "FROM MAE_ACCIO_PROCE_BLOQU apb, ");
        query.append(       "MAE_TIPO_BLOQU tb, ");
        query.append(       "MAE_PROCE_BLOQU pb, ");
        query.append(       "MAE_ACCIO_BLOQU ab ");
        query.append( "WHERE apb.TIBQ_OID_TIPO_BLOQ = tb.OID_TIPO_BLOQ ");
        query.append(   "AND apb.MAPB_OID_PROC_BLOQ = pb.OID_PROC_BLOQ ");
        query.append(   "AND apb.MABL_OID_ACCI_BLOQ = ab.OID_ACCI_BLOQ ");
        query.append(   "AND apb.PAIS_OID_PAIS = " + dtoE.getOidPais() + " ");
        if (dtoE.getOidTipoBloqueo() != null) {
            query.append(   "AND apb.TIBQ_OID_TIPO_BLOQ = " + dtoE.getOidTipoBloqueo() + " ");
        }
        if (dtoE.getOidProcesoBloqueo() != null) {
            query.append(   "AND apb.MAPB_OID_PROC_BLOQ = " + dtoE.getOidProcesoBloqueo() + " ");
        }
        if (dtoE.getOidAccionBloqueo() != null) {
            query.append(   "AND apb.MABL_OID_ACCI_BLOQ = " + dtoE.getOidAccionBloqueo() + " ");
        }
        query.append("ORDER BY DES_TIPO_BLOQ, DES_PROC_BLOQ, DES_ACCI_BLOQ ");
        
        // Consulta original - Fin
        query.append(" ) consultaOriginal "); // Agregado para paginar
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(
                    UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoE) );
        } catch (Exception e) {
            UtilidadesLog.error(" Error en consulta DAOBloqueosClientes.buscarAccionesProcesosBloqueo" + e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.buscarAccionesProcesosBloqueo(dtoE): Salida");
        return rs;
    }
    
    /**
     * Consulta para combo de 'Procesos bloqueo'
     * @author eiraola
     * @since 17/10/2007
     */
    public RecordSet obtenerProcesosBloqueo(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerProcesosBloqueo(dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT pb.OID_PROC_BLOQ, ");
        query.append(       "pb.DES_PROC_BLOQ ");
        query.append(  "FROM MAE_PROCE_BLOQU pb ");
        query.append("ORDER BY pb.DES_PROC_BLOQ ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" Error en consulta DAOBloqueosClientes.obtenerProcesosBloqueo" + e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerProcesosBloqueo(dtoE): Salida");
        return rs;
    }

    /**
     * Consulta para combo de 'Acciones bloqueo' (dependiente de 'Proceso bloqueo').
     * @author eiraola
     * @since 17/10/2007
     */
    public RecordSet obtenerAccionesBloqueo(DTOOID dtoOid) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerAccionesBloqueo(dtoOid): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT ab.OID_ACCI_BLOQ, ");
        query.append(       "ab.DES_ACCI_BLOQ ");
        query.append(  "FROM MAE_ACCIO_BLOQU ab ");
        query.append( "WHERE ab.MAPB_OID_PROC_BLOQ = " + dtoOid.getOid() + " ");
        query.append("ORDER BY ab.DES_ACCI_BLOQ ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" Error en consulta DAOBloqueosClientes.obtenerAccionesBloqueo" + e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerAccionesBloqueo(dtoOid): Salida");
        return rs;
    }
    
    /**
     * Recupera OID, descripcion i18n e indicador de DNI para los tipos de
     * documentos (MAE) asociados al país recibido por parametro.
     * @author dmorello
     * @since 05-11-2007
     */
    RecordSet obtenerTiposDocumentoPais(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposDocumentoPais(DTOBelcorp dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

        query.append("SELECT   tdoc.oid_tipo_docu AS oid, gen.val_i18n AS descripcion, ");
        query.append("         tdoc.ind_dni ");
        query.append("    FROM mae_tipo_docum tdoc ");
        query.append("       , v_gen_i18n_sicc gen ");
        query.append("   WHERE tdoc.pais_oid_pais = ").append(dtoe.getOidPais());
        query.append("     AND tdoc.oid_tipo_docu = gen.val_oid ");
        query.append("     AND gen.attr_enti = 'MAE_TIPO_DOCUM' ");
        query.append("     AND gen.idio_oid_idio = ").append(dtoe.getOidIdioma());
        query.append("ORDER BY descripcion");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposDocumentoPais(DTOBelcorp dtoe): Salida");
        return rs;
    }
    
    
    /**
     * Recupera información sobre los bloqueos existentes para los clientes
     * recuperados según los filtros del parámetro de entrada.
     * @throws MareException Si no encuentra clientes para los filtros recibidos
     * @author dmorello
     * @since 05-11-2007
     */
    public RecordSet buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        Vector params = new Vector();
        
        query.append(" SELECT ROW_NUMBER() OVER (ORDER BY cod_clie DESC) AS OID, ");
        query.append("        oid_bloq, oid_clie, cod_clie, val_nom1, val_nom2, val_ape1, val_ape2, ");
        query.append("        CASE WHEN fec_bloq IS NOT NULL AND fec_desb IS NULL");
        query.append("             THEN 'S' ELSE 'N' END AS ind_bloq, ");
        query.append("        DECODE(tibq_oid_tipo_bloq,NULL,NULL, ");
        query.append("               pq_apl_aux.valor_gen_i18n_sicc(?, tibq_oid_tipo_bloq, 'MAE_TIPO_BLOQU')) AS des_tipo_bloq, ");
        params.add(dtoe.getOidIdioma());
        query.append("        fec_bloq, fec_desb, val_moti_bloq, val_usua_bloq, val_usua_desb, ");
        query.append("        cod_valo_bloq, cod_valo_desb, obs_bloq, obs_desb,  ");
        query.append("        tibq_oid_tipo_bloq ");
        query.append(" FROM ( ");
        query.append("     SELECT bloq.oid_bloq, cli.oid_clie, cli.cod_clie, ");
        query.append("            cli.val_nom1, cli.val_nom2, cli.val_ape1, cli.val_ape2, ");
        query.append("            bloq.TIBQ_OID_TIPO_BLOQ, bloq.FEC_BLOQ, bloq.FEC_DESB, ");
        query.append("            bloq.val_moti_bloq, bloq.VAL_USUA_BLOQ, bloq.VAL_USUA_DESB, ");
        query.append("            acbloq.cod_valo_bloq, acdesb.cod_valo_bloq AS cod_valo_desb, ");
        query.append("            bloq.obs_bloq, bloq.obs_desb, ");
        query.append("            ROW_NUMBER() OVER(PARTITION BY cli.cod_clie, bloq.TIBQ_OID_TIPO_BLOQ  "); // sapaza -- PER-SiCC-2011-0466 -- 04/07/2011
        query.append("                              ORDER BY cli.cod_clie DESC, bloq.fec_desb DESC NULLS FIRST) AS aux ");
        query.append("       FROM mae_clien cli ");
        query.append("          , mae_clien_ident ident ");
        query.append("          , mae_clien_bloqu bloq ");
        query.append("          , mae_valor_accio_bloqu acbloq ");
        query.append("          , mae_valor_accio_bloqu acdesb ");
        query.append("      WHERE cli.pais_oid_pais = ? ");
        params.add(dtoe.getOidPais());
        if (dtoe.getCodigo() != null) {
           query.append("     AND cli.cod_clie = ? ");
           params.add(dtoe.getCodigo());
        }
        if (dtoe.getNombre1() != null) {
            query.append("    AND cli.val_nom1 LIKE ? ");
            params.add(dtoe.getNombre1());
        }
        if (dtoe.getNombre2() != null) {
            query.append("    AND cli.val_nom2 LIKE ? ");
            params.add(dtoe.getNombre2());
        }
        if (dtoe.getApellido1() != null) {
            query.append("    AND cli.val_ape1 LIKE ? ");
            params.add(dtoe.getApellido1());
        }
        if (dtoe.getApellido2() != null) {
            query.append("    AND cli.val_ape2 LIKE ? ");
            params.add(dtoe.getApellido2());
        }
        query.append("    AND ident.clie_oid_clie = cli.oid_clie ");
        if (dtoe.getOidTipoDocumento() != null) {
            query.append("    AND ident.tdoc_oid_tipo_docu = ? ");
            params.add(dtoe.getOidTipoDocumento());
        }
        if (dtoe.getDocumentoIdentificacion() != null) {
            query.append("    AND ident.num_docu_iden = ? ");
            params.add(dtoe.getDocumentoIdentificacion());
        }
        query.append("        AND bloq.clie_oid_clie (+) = cli.oid_clie ");
        query.append("        AND bloq.maab_oid_valo_acci_bloq = acbloq.oid_valo_acci_bloq (+) ");
        query.append("        AND bloq.maab_oid_valo_acci_desb = acdesb.oid_valo_acci_bloq (+) ");
        query.append(" ) ");
        query.append(" WHERE aux = 1 ");
        query.append(" ORDER BY cod_clie DESC ");
        
        RecordSet rs = null;
        try {
            String s = UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoe);
            rs = bs.dbService.executePreparedQuery(s, params);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (rs == null || rs.getRowCount() == 0) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe): Salida");
        return rs;
    }


    
    /**
     * Consulta sobre entidad 'MAE Valores Usuario Bloqueo' para combo de 'Accion permitida'.
     * @author eiraola
     * @since 08/11/2007
     */
    public RecordSet obtenerValoresUsuarioBloqueo(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerValoresUsuarioBloqueo(dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT mvub.OID_VALO_USUA_BLOQ, ");
        query.append(       "mvub.DES_VALO_BLOQ ");
        query.append(  "FROM MAE_VALOR_USUAR_BLOQU mvub ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" Error en consulta DAOBloqueosClientes.obtenerValoresUsuarioBloqueo " + e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerValoresUsuarioBloqueo(dtoE): Salida");
        return rs;
    }
    
    /**
     * Consulta paginada para Lista editable de CU MAE 'Usuarios-bloqueo'.
     * Los registros recuperados van ordenados por Codigo Usuario y Tipo Bloqueo.
     * @author eiraola
     * @since 17/10/2007
     */
    public RecordSet buscarUsuariosBloqueo(DTOBuscarUsuariosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.buscarUsuariosBloqueo(dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        
        // Agregado para paginar y mantener los distintos ordenes de registros
        query.append("SELECT rownum as OID, consultaOriginal.* FROM ( ");
        
        // Consulta original - Inicio
        query.append("SELECT mub.OID_USUA_BLOQ, ");
        query.append(       "u.IDUSER, ");
        query.append(       "p.NAME COD_USUA, ");
        //query.append(       "pv.stringvalue || ' ' || pv2.stringvalue || ' ' || pv3.stringvalue || ' ' || "
        query.append(       "pv.stringvalue || ' ' || pv3.stringvalue || ' ' || "
                             + "pv4.stringvalue NOM_USUA, ");
        query.append(       "mub.TIBQ_OID_TIPO_BLOQ OID_TIPO_BLOQ, ");
        query.append(       "PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dtoE.getOidIdioma()
                             +", mub.TIBQ_OID_TIPO_BLOQ, 'MAE_TIPO_BLOQU') DES_TIPO_BLOQ, ");
        query.append(       "mub.MVUB_OID_VALO_USUA_BLOQ OID_VALO_USUA_BLOQ, ");
        query.append(       "(SELECT DES_VALO_BLOQ FROM MAE_VALOR_USUAR_BLOQU "
                             +"WHERE OID_VALO_USUA_BLOQ = mub.MVUB_OID_VALO_USUA_BLOQ) DES_ACCI_PERM ");
        query.append(  "FROM principals p LEFT JOIN propertyvalues pv  ON pv.idproperty  = 5 AND pv.idprincipal  = p.idprincipal ");
        // dmorello, 14/11/2007: Se deja de recuperar el segundo nombre
        //query.append(                    "LEFT JOIN propertyvalues pv2 ON pv2.idproperty = 6 AND pv2.idprincipal = p.idprincipal ");
        query.append(                    "LEFT JOIN propertyvalues pv3 ON pv3.idproperty = 2 AND pv3.idprincipal = p.idprincipal ");
        query.append(                    "LEFT JOIN propertyvalues pv4 ON pv4.idproperty = 3 AND pv4.idprincipal = p.idprincipal, ");
        query.append(       "USERS u, ");
        query.append(       "MAE_USUAR_BLOQU mub ");
        query.append( "WHERE u.IDUSER = p.IDPRINCIPAL ");
        query.append(   "AND mub.USER_OID_USER = u.IDUSER ");
        if (dtoE.getCodigoUsuario() != null) {
            query.append("AND p.NAME = '"+ dtoE.getCodigoUsuario() +"' ");
        }
        if (dtoE.getOidTipoBloqueo() != null) {
            query.append("AND mub.TIBQ_OID_TIPO_BLOQ = " + dtoE.getOidTipoBloqueo() + " ");
        }
        if (dtoE.getOidAccionPermitida() != null) {
            query.append("AND mub.MVUB_OID_VALO_USUA_BLOQ = " + dtoE.getOidAccionPermitida() + " ");
        }
        query.append("ORDER BY COD_USUA, DES_TIPO_BLOQ ");
        // Consulta original - Fin
        
        query.append(" ) consultaOriginal "); // Agregado para paginar
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(
                    UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoE) );
        } catch (Exception e) {
            UtilidadesLog.error(" Error en consulta DAOBloqueosClientes.buscarUsuariosBloqueo " + e.getMessage());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.buscarUsuariosBloqueo(dtoE): Salida");
        return rs;
    }
    
    /**
     * Accede a MAE_TIPO_BLOQU y recupera OID y descripcion i18n de todos los
     * tipos de bloqueo para los cuales el usuario del DTO de entrada cuenta con
     * permiso para bloquear.
     * @author dmorello
     * @since 11-12-2007
     */
    public RecordSet obtenerTiposBloqueoUsuario(DTOString dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueoUsuario(DTOString dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        
        query.append(" SELECT   tb.oid_tipo_bloq ");
        query.append("        , pq_apl_aux.valor_gen_i18n_sicc (?, tb.oid_tipo_bloq, 'MAE_TIPO_BLOQU') des_tipo_bloq ");
        parametros.add(dtoe.getOidIdioma());
        query.append("     FROM mae_tipo_bloqu tb ");
        query.append("        , mae_valor_accio_bloqu vab ");
        query.append("        , mae_usuar_bloqu ub ");
        query.append("        , mae_valor_usuar_bloqu vub ");
        query.append("        , users u ");
        query.append("        , principals p ");
        query.append("    WHERE tb.MAAB_OID_VALO_ACCI_BLOQ = vab.OID_VALO_ACCI_BLOQ ");
        query.append("      AND vab.COD_VALO_BLOQ IN (?, ?) ");
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_AMBOS);
        query.append("      AND tb.oid_tipo_bloq = ub.tibq_oid_tipo_bloq ");
        query.append("      AND ub.PAIS_OID_PAIS = ? ");
        parametros.add(dtoe.getOidPais());
        query.append("      AND ub.user_oid_user = u.iduser ");
        query.append("      AND u.iduser = p.idprincipal ");
        query.append("      AND p.NAME = ? ");
        parametros.add(dtoe.getCadena());
        query.append("      AND ub.mvub_oid_valo_usua_bloq = vub.oid_valo_usua_bloq ");
        query.append("      AND vub.cod_valo_bloq IN (?, ?) ");
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_BLOQUEAR);
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_AMBOS);
        query.append(" ORDER BY des_tipo_bloq ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueoUsuario(DTOString dtoe): Salida");
        return rs;
    }
    
    
    public void insertarBloqueo(DTOClienteBloqueo dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.insertarBloqueo(DTOClienteBloqueo dtoe): Entrada");
        UtilidadesLog.debug("dtoe: " + dtoe);
        UtilidadesLog.debug("dtoe.codFormaBloqueo: " + dtoe.getCodFormaBloqueo());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        Vector parametros = new Vector();
        
        String strFechaBloq = new SimpleDateFormat("dd/MM/yyyy").format(new Timestamp(System.currentTimeMillis()));
        
        insert.append("INSERT INTO MAE_CLIEN_BLOQU (");
        insert.append("     OID_BLOQ, CLIE_OID_CLIE, TIBQ_OID_TIPO_BLOQ, ");
        insert.append("     MAAB_OID_VALO_ACCI_BLOQ, FEC_BLOQ, ");
        if (dtoe.getMotivoBloqueo() != null) {
            insert.append(" VAL_MOTI_BLOQ, ");
        }
        if (dtoe.getObservacionesBloqueo() != null) {
            insert.append(" OBS_BLOQ, ");
        }
        insert.append("     VAL_USUA_BLOQ ");
        insert.append(") VALUES (");
        insert.append("     MAE_CLBL_SEQ.nextval, ");
        insert.append(dtoe.getOidCliente()).append(',');
        insert.append(dtoe.getOidTipoBloqueo()).append(',');
        insert.append("    (SELECT oid_valo_acci_bloq");
        insert.append("       FROM mae_valor_accio_bloqu");
        insert.append("      WHERE cod_valo_bloq = '").append(dtoe.getCodFormaBloqueo()).append("'),");
        insert.append("    TO_DATE('").append(strFechaBloq).append("', 'DD/MM/YYYY'),");
        if (dtoe.getMotivoBloqueo() != null) {
            insert.append('\'').append(dtoe.getMotivoBloqueo()).append("',");
        }
        if (dtoe.getObservacionesBloqueo() != null) {
            insert.append('\'').append(dtoe.getObservacionesBloqueo()).append("',");
        }
        insert.append('\'').append(dtoe.getUsuarioBloqueo()).append("');");
        
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insert.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.insertarBloqueo(DTOClienteBloqueo dtoe): Salida");
    }
    
    
    /**
     * Actualiza un registro en MAE_CLIEN_BLOQU de acuerdo a los datos del dtoe,
     * tanto para una modificacion de bloqueo como para un desbloqueo.
     * @author dmorello
     * @since 12-12-2007
     */
    public void actualizarBloqueo(DTOClienteBloqueo dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.actualizarBloqueo(DTOClienteBloqueo dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        Vector parametros = new Vector();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        update.append("UPDATE mae_clien_bloqu SET");
        if (Boolean.FALSE.equals(dtoe.getIndDesbloqueo())) {
            // Fecha desbloqueo nula ---> Se trata de una modificación de bloqueo
            // Actualizo: tipo bloqueo, forma bloqueo, fecha bloqueo, motivo bloqueo, obs. bloqueo, usuario bloqueo
            update.append("     tibq_oid_tipo_bloq = ?, ");
            parametros.add(dtoe.getOidTipoBloqueo());
            update.append("     maab_oid_valo_acci_bloq = (SELECT oid_valo_acci_bloq");
            update.append("                                FROM mae_valor_accio_bloqu");
            update.append("                               WHERE cod_valo_bloq = ?),");
            parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
            update.append("     fec_bloq = TO_DATE(?, 'DD/MM/YYYY'), ");
            parametros.add(sdf.format(new Timestamp(System.currentTimeMillis())));
            if (dtoe.getMotivoBloqueo() != null) {
                update.append(" val_moti_bloq = ?, ");
                parametros.add(dtoe.getMotivoBloqueo());
            }
            if (dtoe.getObservacionesBloqueo() != null) {
                update.append(" obs_bloq = ?, ");
                parametros.add(dtoe.getObservacionesBloqueo());
            }
            update.append("     val_usua_bloq = ? ");
            parametros.add(dtoe.getUsuarioBloqueo());
        } else {
            // Fecha desbloqueo NO nula ---> Se trata de un desbloqueo
            // Actualizo: forma desbloqueo, obs. desbloqueo, usuario desbloqueo
            update.append("     maab_oid_valo_acci_desb = (SELECT oid_valo_acci_bloq");
            update.append("                                FROM mae_valor_accio_bloqu");
            update.append("                               WHERE cod_valo_bloq = ?),");
            parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
            update.append("     fec_desb = TO_DATE(?, 'DD/MM/YYYY'), ");
            parametros.add(sdf.format(new Timestamp(System.currentTimeMillis())));
            if (dtoe.getObservacionesDesbloqueo() != null) {
                update.append(" obs_desb = ?, ");
                parametros.add(dtoe.getObservacionesDesbloqueo());
            }
            update.append("     val_usua_desb = ? ");
            parametros.add(dtoe.getUsuarioDesbloqueo());
        }
        update.append(" WHERE oid_bloq = ?");
        parametros.add(dtoe.getOid());
        
        try {
            bs.dbService.executePreparedUpdate(update.toString(), parametros);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.actualizarBloqueo(DTOClienteBloqueo dtoe): Salida");
    }
    
    
    /**
     * Recupera el histórico de bloqueos (conjunto de registros de MAE_CLIEN_BLOQU)
     * para el cliente cuyo OID se recibe por parámetro.
     * @throws MareException Si no encuentra registros para el cliente recibido
     * @author dmorello
     * @since 13/12/2007
     */
    public RecordSet consultarHistoricoBloqueosCliente(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.consultarHistoricoBloqueosCliente(DTOOID dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        // dmorello, 13/12/2007: El siguiente ORDER BY ya deja ordenados los registros...
        query.append("SELECT ROW_NUMBER () OVER (ORDER BY fec_bloq DESC, bloqueo.oid_bloq DESC) AS OID ");
        query.append("     , pq_apl_aux.valor_gen_i18n_sicc (").append(dtoe.getOidIdioma());
        query.append("                      , bloqueo.tibq_oid_tipo_bloq, 'MAE_TIPO_BLOQU') AS des_tipo_bloq ");
        query.append("     , bloqueo.fec_bloq ");
        query.append("     , accbloq.cod_valo_bloq ");
        query.append("     , bloqueo.val_usua_bloq ");
        query.append("     , bloqueo.val_moti_bloq ");
        query.append("     , bloqueo.obs_bloq ");
        query.append("     , bloqueo.fec_desb ");
        query.append("     , accdesb.cod_valo_bloq AS cod_valo_desb ");
        query.append("     , bloqueo.val_usua_desb ");
        query.append("     , bloqueo.obs_desb ");
        query.append("  FROM mae_clien_bloqu bloqueo ");
        query.append("     , mae_valor_accio_bloqu accbloq ");
        query.append("     , mae_valor_accio_bloqu accdesb ");
        query.append(" WHERE bloqueo.clie_oid_clie = ").append(dtoe.getOid());
        query.append("   AND bloqueo.maab_oid_valo_acci_bloq = accbloq.oid_valo_acci_bloq(+) ");
        query.append("   AND bloqueo.maab_oid_valo_acci_desb = accdesb.oid_valo_acci_bloq(+) ");
        
        RecordSet rs = null;
        
        try {
            String queryPag = UtilidadesPaginacion.armarQueryPaginacionEspecial(query.toString(), dtoe);
            rs = bs.dbService.executeStaticQuery(queryPag);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if (rs == null || rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.consultarHistoricoBloqueosCliente(DTOOID dtoe): Salida");
        return rs;
    }

    /**
     * Verifica que un cierto tipo de bloqueo sea más grave que el que tiene actualmente
     * un bloqueo a cliente, para lo cual verifica que el nivel de gravedad del nuevo
     * tipo sea MENOR al nivel de gravedad actual.
     * Si alguno de los tipos de bloqueo (actual o nuevo) no tiene nivel de gravedad
     * asignado, le asigna 999 (sólo a los fines de comparar, no lo escribe en BD)
     * @return true Si el nuevo tipo de bloqueo es más grave; false en caso contrario
     * @param oidNuevoTipoBloqueo OID del nuevo tipo de bloqueo
     * @param oidBloqueo OID del bloqueo cliente actual
     * @author dmorello
     * @since 21-12-2007
     */
    public boolean validarMayorGravedadNuevoTipoBloqueo(Long oidBloqueo, Long oidNuevoTipoBloqueo) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.validarMayorGravedadNuevoTipoBloqueo(Long oidBloqueo, Long oidNuevoTipoBloqueo): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT (SELECT NVL (tipo.num_nive_grav_bloq, 999) ");
        query.append("           FROM mae_clien_bloqu bloqueo ");
        query.append("              , mae_tipo_bloqu tipo ");
        query.append("          WHERE bloqueo.oid_bloq = ").append(oidBloqueo);
        query.append("            AND bloqueo.tibq_oid_tipo_bloq = tipo.oid_tipo_bloq");
        query.append("        )AS gravedad_actual ");
        query.append("      , (SELECT NVL (tipo.num_nive_grav_bloq, 999) ");
        query.append("           FROM mae_tipo_bloqu tipo ");
        query.append("          WHERE tipo.oid_tipo_bloq = ").append(oidNuevoTipoBloqueo);
        query.append("        ) AS gravedad_nueva ");
        query.append("   FROM DUAL ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        BigDecimal gravedadActual = (BigDecimal)rs.getValueAt(0, "GRAVEDAD_ACTUAL");
        BigDecimal gravedadNueva = (BigDecimal)rs.getValueAt(0, "GRAVEDAD_NUEVA");
        
        UtilidadesLog.debug("gravedadActual: " + gravedadActual);
        UtilidadesLog.debug("gravedadNueva : " + gravedadNueva);
        
        // El nuevo nivel de gravedad debe ser MENOR al actual
        UtilidadesLog.info("DAOBloqueosClientes.validarMayorGravedadNuevoTipoBloqueo(Long oidBloqueo, Long oidNuevoTipoBloqueo): Salida");
        if (gravedadNueva.compareTo(gravedadActual) < 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    /**
     * Devuelve los OIDs de todos los tipos de bloqueo si dtoe.oidTipoBloqueo
     * es null, caso contrario devuelve el OID del tipo de bloqueo hallado
     * Para cada uno, devuelve un indicador de forma de bloqueo manual ['S'|'N']
     * y un indicador de forma de desbloqueo manual.
     * Devuelve otros dos indicadores ['S'|'N'], uno dice si el usuario recibido
     * en el dtoe tiene permiso para bloquear con cada tipo de bloqueo, y otro
     * si tiene permiso para desbloquear a clientes con cada tipo de bloqueo.
     * 
     * @author dmorello
     * @since 04-01-2008
     */
    public RecordSet obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe) throws MareException {
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        
        query.append(" SELECT tipo_bloqueo.oid_tipo_bloq ");
        query.append("      , CASE WHEN tipo_bloqueo.cod_valo_bloq IN (?, ?) ");
        query.append("            THEN 'S' ELSE 'N' ");
        query.append("        END ");
        query.append("            AS bloqueo_manual ");
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_AMBOS);
        query.append("      , CASE WHEN tipo_bloqueo.cod_valo_desb IN (?, ?) ");
        query.append("            THEN 'S' ELSE 'N' ");
        query.append("        END ");
        query.append("            AS desbloqueo_manual ");
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_AMBOS);
        query.append("      , CASE WHEN usu_permisos.cod_valo_bloq IN (?, ?) ");
        query.append("                AND tipo_bloqueo.cod_valo_bloq IN (?, ?) ");
        query.append("            THEN 'S' ELSE 'N' ");
        query.append("        END ");
        query.append("            AS permiso_bloquear ");
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_BLOQUEAR);
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_AMBOS);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_AMBOS);
        query.append("      , CASE WHEN usu_permisos.cod_valo_bloq IN (?, ?) ");
        query.append("                AND tipo_bloqueo.cod_valo_desb IN (?, ?) ");
        query.append("            THEN 'S' ELSE 'N' ");
        query.append("        END ");
        query.append("            AS permiso_desbloquear ");
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_DESBLOQUEAR);
        parametros.add(ConstantesMAE.COD_VALOR_USUARIO_AMBOS);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
        parametros.add(ConstantesMAE.COD_VALOR_ACCION_AMBOS);
        query.append("   FROM ");
        query.append("        (SELECT tipo.oid_tipo_bloq ");
        query.append("              , acc_bloq.cod_valo_bloq AS cod_valo_bloq ");
        query.append("              , acc_desb.cod_valo_bloq AS cod_valo_desb ");
        query.append("           FROM mae_tipo_bloqu tipo ");
        query.append("              , mae_valor_accio_bloqu acc_bloq ");
        query.append("              , mae_valor_accio_bloqu acc_desb ");
        query.append("          WHERE tipo.maab_oid_valo_acci_bloq = acc_bloq.oid_valo_acci_bloq ");
        query.append("            AND tipo.maab_oid_valo_acci_desb = acc_desb.oid_valo_acci_bloq ");
        if (dtoe.getOidTipoBloqueo() != null) {
            query.append("        AND tipo.oid_tipo_bloq = ? ");
            parametros.add(dtoe.getOidTipoBloqueo());
        }
        query.append("         ) tipo_bloqueo ");
        query.append("       , (SELECT ub.tibq_oid_tipo_bloq, vub.cod_valo_bloq  ");
        query.append("            FROM mae_usuar_bloqu ub ");
        query.append("               , mae_valor_usuar_bloqu vub ");
        query.append("               , users u ");
        query.append("               , principals p ");
        query.append("           WHERE ub.pais_oid_pais = ? ");
        parametros.add(dtoe.getOidPais());
        query.append("             AND ub.user_oid_user = u.iduser ");
        query.append("             AND u.iduser = p.idprincipal ");
        query.append("             AND p.name = ? ");
        parametros.add(dtoe.getUsuario());
        query.append("             AND ub.mvub_oid_valo_usua_bloq = vub.oid_valo_usua_bloq ");
        query.append("         ) usu_permisos ");
        query.append(" WHERE tipo_bloqueo.oid_tipo_bloq = usu_permisos.tibq_oid_tipo_bloq (+) ");
        query.append(" ORDER BY oid_tipo_bloq ");        
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOBloqueosClientes.obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe): Salida");
        return rs;
    }
}