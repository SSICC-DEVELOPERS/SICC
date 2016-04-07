/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.cal;



import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import es.indra.sicc.dtos.cal.DTOCargarOID;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTOConsultaGerente;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.cal.DTOIngresoConsultora;
import es.indra.sicc.dtos.cal.DTODatosClien;
import es.indra.sicc.util.DTOOID;


import java.util.Vector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DAOContactos 
{
  public DAOContactos()
  {
  }
  
  public DTOSalida consultarProgramasLanzamiento (DTOSiccPaginacion dto) throws MareException  {
        UtilidadesLog.info("DAOContactos.consultarProgramasLanzamiento (DTOSiccPaginacion dto): Entrada");
  
        StringBuffer consulta = new StringBuffer("");
        Vector parametros=new Vector();
        DTOSalida dtoS = new DTOSalida();
        
        consulta.append(" SELECT A.oid_guia as OID,  ");
        consulta.append(" A.cod_guia as codGuia, B.des_cort_dpto as departamento, ");
        consulta.append(" A.val_titu as titulo, A.fec_inic_vali as fechaIni, ");
        consulta.append(" A.fec_fin_vali as fechaFin, A.val_desc_guia as descGuia ");
        consulta.append(" FROM cal_guias A, seg_depto_empre B ");
        consulta.append(" WHERE (SYSDATE BETWEEN A.fec_inic_vali ");
        consulta.append(" AND fec_fin_vali OR ");
        consulta.append(" A.fec_inic_vali >= SYSDATE) ");
        consulta.append(" AND B.oid_depa = A.dpte_oid_depa ");
        
        String codigoError = null;
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);
        RecordSet rs;
        try {
            rs = (RecordSet) BelcorpService.getInstance().dbService.executePreparedQuery(sqlPaginada,parametros);
        }
        catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        /*if (rs.esVacio()){
          UtilidadesLog.info("****DAOContactos.consultarProgramasLanzamiento: No hay datos ");
          throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/
        dtoS.setResultado(rs);
        
        UtilidadesLog.info("DAOContactos.consultarProgramasLanzamiento (DTOSiccPaginacion dto): Salida");
        
        return dtoS;
  }
  
  public DTOSalida cargarContactos(DTOCargarOID dto) throws MareException  {
  
        UtilidadesLog.info("DAOContactos.cargarContactos(DTOCargarOID dto): Entrada");
  
        //Carga los contactos de un cliente. Primero los que no están cerrados y después el resto ordenados por fecha 
        //de contacto más reciente a más antigua. Consulta paginada. 
        
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        
        sql.append("SELECT * FROM (SELECT ROWNUM as linea, XY.* FROM (");		
        sql.append(" SELECT oidContacto, codOperador, descMotivoContacto, descEstado, ");
        sql.append(" descAtributoEstado, fechaContacto, horaInicio, horaFin  ");
        sql.append(" FROM ( (SELECT 0 as flag, A.oid_cont as oidContacto,  ");
        sql.append(" A.cod_oper as codOperador, B.val_i18n as descMotivoContacto, ");
        sql.append(" E.val_i18n as descEstado, D.val_i18n as descAtributoEstado,  ");
        sql.append(" A.fec_cont as fechaContacto, ");
        sql.append(" TO_CHAR(A.val_hora_inic, 'HH:MI:SS') as horaInicio, ");
        sql.append(" TO_CHAR(A.val_hora_fin, 'HH:MI:SS') as horaFin  ");
        sql.append(" FROM cal_conta A, v_gen_i18n_sicc B, cal_atrib_estad_conta C, ");
        sql.append(" v_gen_i18n_sicc D, v_gen_i18n_sicc E  ");
        sql.append(" WHERE A.clie_oid_clie = ? AND  ");
        parametros.add(dto.getOid());
        sql.append(" B.attr_enti = 'CAL_MOTIV_CONTA' AND ");
        sql.append(" B.attr_num_atri = 1 AND ");
        sql.append(" B.idio_oid_idio = ? AND ");
        parametros.add(dto.getOidIdioma());
        sql.append(" B.val_oid = A.moco_oid_moti_cont AND ");
        sql.append(" C.oid_atri_esta_cont = A.atec_oid_atri_esta_cont AND ");
        sql.append(" C.teco_oid_tipo_esta_cont <> ? AND  ");
        parametros.add(ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_CERRADO);
        sql.append(" D.attr_enti = 'CAL_ATRIB_ESTAD_CONTA' AND ");
        sql.append(" D.attr_num_atri = 1 AND ");
        sql.append(" D.idio_oid_idio = ? AND ");
        parametros.add(dto.getOidIdioma());
        sql.append(" D.val_oid = C.oid_atri_esta_cont AND ");
        sql.append(" E.attr_enti = 'CAL_TIPO_ESTAD_CONTA' AND ");
        sql.append(" E.attr_num_atri = 1 AND  ");
        sql.append(" E.idio_oid_idio = ? AND  ");
        parametros.add(dto.getOidIdioma());
        sql.append(" E.val_oid = C.teco_oid_tipo_esta_cont) ");
        sql.append(" UNION (SELECT 1 as flag, A.oid_cont as oidContacto, ");
        sql.append(" A.cod_oper as codOperador, B.val_i18n as descMotivoContacto, ");
        sql.append(" E.val_i18n as descEstado, D.val_i18n as descAtributoEstado, ");
        sql.append(" A.fec_cont as fechaContacto,  ");
        sql.append(" TO_CHAR(A.val_hora_inic, 'HH:MI:SS') as horaInicio,  ");
        sql.append(" TO_CHAR(A.val_hora_fin, 'HH:MI:SS') as horaFin  ");
        sql.append(" FROM cal_conta A, v_gen_i18n_sicc B, cal_atrib_estad_conta C, ");
        sql.append(" v_gen_i18n_sicc D, v_gen_i18n_sicc E ");
        sql.append(" WHERE A.clie_oid_clie = ? AND  ");
        parametros.add(dto.getOid());
        sql.append(" B.attr_enti = 'CAL_MOTIV_CONTA' AND ");
        sql.append(" B.attr_num_atri = 1 AND ");
        sql.append(" B.idio_oid_idio = ? AND ");
        parametros.add(dto.getOidIdioma());
        sql.append(" B.val_oid = A.moco_oid_moti_cont AND ");
        sql.append(" C.oid_atri_esta_cont = A.atec_oid_atri_esta_cont AND ");
        sql.append(" C.teco_oid_tipo_esta_cont = ? AND  ");
        parametros.add(ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_CERRADO);
        sql.append(" D.attr_enti = 'CAL_ATRIB_ESTAD_CONTA' AND ");
        sql.append(" D.attr_num_atri = 1 AND  ");
        sql.append(" D.idio_oid_idio = ? AND  ");
        parametros.add(dto.getOidIdioma());
        sql.append(" D.val_oid = C.oid_atri_esta_cont AND ");
        sql.append(" E.attr_enti = 'CAL_TIPO_ESTAD_CONTA' AND ");
        sql.append(" E.attr_num_atri = 1 AND ");
        sql.append(" E.idio_oid_idio = ? AND ");
        parametros.add(dto.getOidIdioma());
        sql.append(" E.val_oid = C.teco_oid_tipo_esta_cont) )");
        sql.append(" ORDER BY flag, fechaContacto DESC ");
        sql.append(") XY ) WHERE linea > " + dto.getIndicadorSituacion() + " AND ROWNUM <= " + dto.getTamanioPagina() );
                
        RecordSet resultado = null;
        String codigoError = null;
        
        this.logSql("cargarContactos. SQL: ", sql.toString(), parametros);
        try {
          resultado = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" cargarContactos: Exception",e);
            this.logSql(" cargarContactos. SQL: ", sql.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /*inc. BELC300024370
          if (resultado.esVacio()){
          UtilidadesLog.debug("****DAOContactos.cargarContactos: No hay datos ");
          throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/
        
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(resultado);
        
        UtilidadesLog.info("DAOContactos.cargarContactos(DTOCargarOID dto): Salida");
        
        return dtoS;
  }
  
  public DTOSalida cargarMotivosTipoCliente (DTOCargarOID dto) throws MareException  {
  
        UtilidadesLog.info("DAOContactos.cargarMotivosTipoCliente (DTOCargarOID dto): Entrada");
        
        //Carga los motivos de contacto por tipo de cliente. Consulta paginada
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        
        sql.append(" SELECT A.moco_oid_moti_cont as OID, ");
        sql.append(" B.val_i18n as descMotivo, C.COD_PROC as codProceso ");
        sql.append(" FROM cal_motiv_tipo_clien A, v_gen_i18n_sicc B, cal_motiv_conta C ");
        sql.append(" WHERE A.moco_oid_moti_cont > ? AND  ");
        parametros.add(dto.getIndicadorSituacion());
        sql.append(" A.pais_oid_pais = ? AND  ");
        parametros.add(dto.getOidPais());
        sql.append(" A.ticl_oid_tipo_clie = ? AND ");
        parametros.add(dto.getOid());
        sql.append(" B.attr_enti = 'CAL_MOTIV_CONTA' AND ");
        sql.append(" B.attr_num_atri = 1 AND ");
        sql.append(" B.idio_oid_idio = ? AND ");
        parametros.add(dto.getOidIdioma());
        sql.append(" B.val_oid = A.moco_oid_moti_cont AND ");
        sql.append(" C.oid_moti_cont = A.moco_oid_moti_cont ");
        
        RecordSet resultado = null;
        String codigoError = null;
        
        String consulta = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dto); 
        this.logSql("cargarMotivosTipoCliente. SQL: ",consulta, parametros);
        
        try {
            resultado = BelcorpService.getInstance().dbService.executePreparedQuery(consulta, 
            parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" cargarMotivosTipoCliente: Exception",e);
            this.logSql(" cargarMotivosTipoCliente. SQL: ",consulta,
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()){
          UtilidadesLog.debug("****DAOContactos.cargarMotivosTipoCliente: No hay datos ");
          throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(resultado);
        
        UtilidadesLog.info("DAOContactos.cargarMotivosTipoCliente (DTOCargarOID dto): Salida");
        
        return dtoS;
  }
  
  public DTOSalida obtenerDatosDireccionTelefonoGerente (DTOConsultaGerente dto) throws MareException  {
  
        UtilidadesLog.info("DAOContactos.obtenerDatosDireccionTelefonoGerente (DTOConsultaGerente dto): Entrada");
        
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        String codigoError = null;
        sql.append(" SELECT B.val_nom1 as nombre1, B.val_nom2 as nombre2, "); 
        sql.append(" B.val_ape1 as apellido1,B.val_ape2 as apellido2, "); 
        sql.append(" H.VAL_TEXT_COMU, ");
        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'MAE_TIPO_DIREC' AND IDIO.idio_oid_idio = 1 AND "); 
        sql.append(" IDIO.val_oid = I.OID_TIPO_DIRE ) AS DIRECCION,	");
        sql.append(" G.DES_ABRV_TIPO_VIA, F.VAL_NOMB_VIA, ");	
        sql.append(" F.NUM_PPAL, F.IND_DIRE_PPAL ");
        sql.append(" FROM zon_zona A, mae_clien B, "); 
        sql.append(" MAE_CLIEN_DIREC F,	SEG_TIPO_VIA G,	"); 
        sql.append(" MAE_CLIEN_COMUN H,	MAE_TIPO_DIREC I	"); 
        sql.append(" WHERE "); 
        sql.append(" A.oid_zona = ? "); 
        parametros.add(dto.getOidZona());
        sql.append(" AND B.oid_clie (+) = A.clie_oid_clie "); 
        sql.append(" AND F.CLIE_OID_CLIE (+)= B.OID_CLIE ");  
        sql.append(" AND G.OID_TIPO_VIA  (+)= F.TIVI_OID_TIPO_VIA ");  
        sql.append(" AND I.OID_TIPO_DIRE (+)= F.TIDC_OID_TIPO_DIRE ");  
        sql.append(" AND I.OID_TIPO_DIRE (+)= F.TIDC_OID_TIPO_DIRE ");
        sql.append(" AND F.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        sql.append(" AND H.CLIE_OID_CLIE  (+)= B.OID_CLIE ");
        sql.append(" AND H.TICM_OID_TIPO_COMU (+) = ? ");       
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO);
    
        RecordSet resultado = null;
      
        try {
            resultado = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), 
            parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerDatosDireccionTelefonoGerente: Exception",e);
            this.logSql(" obtenerDatosDireccionTelefonoGerente. SQL: ",sql.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()){
            UtilidadesLog.debug("****DAOContactos.obtenerDatosDireccionTelefonoGerente: No hay datos ");
            throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(resultado);
     
        UtilidadesLog.info("DAOContactos.obtenerDatosDireccionTelefonoGerente (DTOConsultaGerente dto): Salida");
    
    return dtoS;
  }
  
   public RecordSet obtenerCodUsuario (DTOBelcorp dto) throws MareException  {
   
        UtilidadesLog.info("DAOContactos.obtenerCodUsuario (DTOBelcorp dto): Entrada");
        
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        String codigoError = null;
        
        sql.append("	SELECT DISTINCT CB.COD_USUA , CB.COD_USUA ");
        sql.append("	FROM CAL_CABEC_BUZON CB 	");
        
        //Incidencia BELC300012528
        sql.append("    WHERE CB.PAIS_OID_PAIS = ?   ");
        parametros.add(dto.getOidPais());
        
         
        RecordSet resultado = null;
      
        try {
            resultado = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), 
            parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerCodUsuario: Exception",e);
            this.logSql(" obtenerCodUsuario. SQL: ",sql.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()){
            UtilidadesLog.debug("****DAOContactos.obtenerCodUsuario: No hay datos ");
            throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
            
        UtilidadesLog.info("DAOContactos.obtenerCodUsuario (DTOBelcorp dto): Salida");
        
    return resultado;
  } 
  
   public RecordSet obtenerBuzonUsuario (DTOCliente dto) throws MareException  {
   
        UtilidadesLog.info("DAOContactos.obtenerBuzonUsuario (DTOCliente dto): Entrada");
        
        StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        String codigoError = null;
        
        sql.append("	SELECT CB.OID_CABE_BUZO, CB.VAL_DESC_CABE_BUZO 	");
        sql.append("	FROM CAL_CABEC_BUZON CB 	");
        sql.append("	WHERE COD_USUA = ?	");
        parametros.add(dto.getCodCliente());
        
         
        RecordSet resultado = null;
      
        try {
            resultado = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), 
            parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerBuzonUsuario: Exception",e);
            this.logSql(" obtenerBuzonUsuario. SQL: ",sql.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()){
            UtilidadesLog.debug("****DAOContactos.obtenerBuzonUsuario: No hay datos ");
            throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
            
        UtilidadesLog.info("DAOContactos.obtenerBuzonUsuario (DTOCliente dto): Salida");
        
        return resultado;
    } 
  
  
  
    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
            
        //this.logStackTrace(e);
        UtilidadesLog.error(e);
    }

    private void logStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("DAOContactos.logSql(String metodo, String sql, Vector params): Entrada");
    
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        
        UtilidadesLog.info("DAOContactos.logSql(String metodo, String sql, Vector params): Salida");
    }

    /** 
     * Método para obtener los status de una consultora
     * @param entrada DTOIngresoConsultora con el oid del cliente
     * @return DTOSalida con los status encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida obtenerStatusConsultora (DTOIngresoConsultora entrada) throws MareException {
    
        UtilidadesLog.info("DAOContactos.obtenerStatusConsultora (DTOIngresoConsultora entrada): Entrada");
        
        //incidencia 12328
	// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        sql.append("SELECT HT.OID_HIST_ESTA OID, MAE.COD_CLIE,PCI.COD_PERI PERIODO_INICIO,PCF.COD_PERI PERIODO_FIN,I18N.VAL_I18N ");
        sql.append(" FROM MAE_CLIEN_HISTO_ESTAT HT, MAE_CLIEN MAE, CRA_PERIO PI,CRA_PERIO PF, SEG_PERIO_CORPO PCI, SEG_PERIO_CORPO PCF, V_GEN_I18N_SICC I18N  ");
        sql.append(" WHERE ");
        sql.append(" MAE.OID_CLIE=HT.CLIE_OID_CLIE ");
        sql.append(" AND PI.OID_PERI=HT.PERD_OID_PERI ");
        sql.append(" AND PF.OID_PERI(+)= HT.PERD_OID_PERI_PERI_FIN ");
        sql.append(" AND PI.PERI_OID_PERI=PCI.OID_PERI ");
        sql.append(" AND PF.PERI_OID_PERI = PCF.OID_PERI(+)  ");
        sql.append(" AND I18N.ATTR_ENTI ='MAE_ESTAT_CLIEN' AND I18N.VAL_OID = HT.ESTA_OID_ESTA_CLIE AND I18N.ATTR_NUM_ATRI = 1 AND I18N.IDIO_OID_IDIO = ? "); 
        parametros.add(entrada.getOidIdioma());
        sql.append(" AND HT.CLIE_OID_CLIE = ? "); 
        parametros.add(entrada.getOidCliente());
        sql.append(" AND PI.CANA_OID_CANA = ? ");
        parametros.add(entrada.getOidCanal());
        sql.append(" AND PI.PAIS_OID_PAIS = ? ");
        parametros.add(entrada.getOidPais());
        sql.append(" AND PI.MARC_OID_MARC = ?"); 
        parametros.add(entrada.getOidMarca());
        sql.append(" ORDER BY PERIODO_INICIO DESC, OID"); 
        sql.append(") XY ) WHERE linea > " + entrada.getIndicadorSituacion() + " AND ROWNUM <= " + entrada.getTamanioPagina() );

		
	// Se ejecuta la consulta 
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerStatusConsultora: Exception", e);
            this.logSql("obtenerStatusConsultora. SQL: ", sql.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*if (rs.esVacio()) {
            //GEN-0007 --> 005
            UtilidadesLog.info("****obtenerStatusConsultora: no hay datos ");				
                  codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }*/
        DTOSalida dtoSalida = new DTOSalida(rs);
        
        UtilidadesLog.info("DAOContactos.obtenerStatusConsultora (DTOIngresoConsultora entrada): Salida");

        return dtoSalida;
    }

    /** 
     * se rediseña por cambio COL-blo-01 (SCS-23/10/2007)
     */
    public DTOSalida obtenerHistoricoDatos(DTOIngresoConsultora entrada) throws MareException {
        UtilidadesLog.info("DAOContactos.obtenerHistoricoDatos(DTOIngresoConsultora entrada): Entrada");

        RecordSet resultado = null;
        StringBuffer consulta = new StringBuffer();
        RecordSet resultado1 = null;
        StringBuffer consulta1 = new StringBuffer();
        RecordSet rsFinal = new RecordSet();
        //
        DTOSalida dtoSalida = new DTOSalida();
        
        String fecha = new String();
        String codPeri = new String();
        String tipBlo = new String();
        String motiBlo = new String();
        String obs = new String();       
        
        consulta.append("SELECT i1.VAL_I18N TIPO_BLOQ, ");
        consulta.append("MCB.VAL_MOTI_BLOQ MOTI_BLOQ, ");
        consulta.append("MCB.OBS_BLOQ OBS ");
        consulta.append("FROM MAE_TIPO_BLOQU MTB, ");
        consulta.append("MAE_CLIEN_BLOQU MCB, MAE_CLIEN mc, V_GEN_I18N_SICC i1 ");
        consulta.append("WHERE MCB.FEC_DESB IS NULL ");
        consulta.append("AND mc.OID_CLIE = MCB.CLIE_OID_CLIE ");
        consulta.append("AND mc.PAIS_OID_PAIS = " + entrada.getOidPais().longValue());
        consulta.append(" AND MCB.CLIE_OID_CLIE = " + entrada.getOidCliente().longValue());
        consulta.append(" AND MCB.TIBQ_OID_TIPO_BLOQ = MTB.OID_TIPO_BLOQ ");
        consulta.append("AND i1.VAL_OID = MTB.OID_TIPO_BLOQ ");
        consulta.append("AND i1.ATTR_ENTI = 'MAE_TIPO_BLOQU' ");
        consulta.append("AND i1.ATTR_NUM_ATRI = 1 ");
        consulta.append("AND i1.IDIO_OID_IDIO = 1 ");
        consulta.append("ORDER BY MCB.FEC_BLOQ DESC");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try {
            resultado = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("cons. 1, obtener HistoricoDatos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }          
        
        if ((resultado!=null) && (resultado.getRowCount()>0)){
            tipBlo = resultado.getValueAt(0,"TIPO_BLOQ").toString();
            motiBlo = resultado.getValueAt(0,"MOTI_BLOQ").toString();
            if (resultado.getValueAt(0,"OBS")!=null)
                obs = resultado.getValueAt(0,"OBS").toString();   
            else obs = new String(" ");   
        }else{
            tipBlo = new String(" ");
            motiBlo = new String(" ");
            obs = new String(" ");
        }
        //
        consulta1.append("SELECT ");
        consulta1.append("cliente.FEC_INGR, ");
        consulta1.append("cliente.COD_PERI ");
        consulta1.append("FROM ");  
        consulta1.append("(SELECT periodo.fec_ingr, periodo.cod_peri, periodo.fec_inic ");  
        consulta1.append("FROM (SELECT   pc.cod_peri, p.fec_inic, mae.fec_ingr ");  
        consulta1.append("FROM CRA_PERIO p, seg_perio_corpo pc, MAE_CLIEN mae "); 
        consulta1.append("WHERE p.fec_inic <= mae.fec_ingr "); 
        consulta1.append("AND p.fec_fina >= mae.fec_ingr ");
        consulta1.append("AND p.peri_oid_peri = pc.oid_peri "); 
        consulta1.append("AND p.cana_oid_cana = " + entrada.getOidCanal().longValue() ); //CANAL
        consulta1.append("AND p.pais_oid_pais = " + entrada.getOidPais().longValue()); //PAIS
        consulta1.append("AND p.marc_oid_marc = " + entrada.getOidMarca().longValue()); //MARCA
        consulta1.append("AND mae.oid_clie = " + entrada.getOidCliente().longValue()); //CLIENTE
        consulta1.append("ORDER BY p.fec_inic) periodo ");  
        consulta1.append("WHERE ROWNUM <= 1) cliente ");        
        
        bs = UtilidadesEJB.getBelcorpService();
        String codigoError1 = null;
        try {
            resultado1 = bs.dbService.executeStaticQuery(consulta1.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("cons. 2, obtener HistoricoDatos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }          
        
        if ((resultado1!=null) && (resultado1.getRowCount()>0)){
            fecha = resultado1.getValueAt(0,"FEC_INGR").toString();
            codPeri = resultado1.getValueAt(0,"COD_PERI").toString();        
        }else{
            UtilidadesLog.debug("sin data, cons. 2");
            fecha = new String(" ");
            codPeri = new String(" ");
        }
        
        rsFinal.addColumn("FEC_INGRE");
        rsFinal.addColumn("COD_PERI");
        rsFinal.addColumn("TIPO_BLOQ");
        rsFinal.addColumn("MOTI_BLOQ");        
        rsFinal.addColumn("OBS");        
        
        rsFinal.addRow(new Object[] {fecha,
                                     codPeri,
                                     tipBlo,
                                     motiBlo,
                                     obs});
        UtilidadesLog.debug("retorno el rsFinal: " + rsFinal);
        dtoSalida.setResultado(rsFinal);                             
        UtilidadesLog.info("DAOContactos.obtenerHistoricoDatos(DTOIngresoConsultora entrada): Salida");

        return dtoSalida;
    }

    /** 
     * Método para obtener lqs clasifiacaciones de un cliente
     * @param entrada DTODatosClien con el oid del cliente
     * @return DTOSalida con las clasificaciones encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron clasificaciones
     */
    public DTOSalida consultarClasificacion (DTODatosClien entrada)
        throws MareException {
        
        UtilidadesLog.info("DAOContactos.consultarClasificacion (DTODatosClien entrada): Entrada");

		// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT MAE.OID_CLIE,  ");
        sql.append(" MAE.COD_CLIE, ");
        sql.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'MAE_TIPO_CLIEN' AND IDIO.IDIO_OID_IDIO = ? AND IDIO.ATTR_NUM_ATRI=1 AND IDIO.VAL_OID=TF.TICL_OID_TIPO_CLIE) TIPO_CLIENTE,  ");
        parametros.add(entrada.getOidIdioma());
        sql.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'MAE_SUBTI_CLIEN' AND IDIO.IDIO_OID_IDIO = ? AND IDIO.ATTR_NUM_ATRI=1 AND IDIO.VAL_OID=TF.SBTI_OID_SUBT_CLIE) SUBTIPO_CLIENTE,  ");
        parametros.add(entrada.getOidIdioma());
        sql.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' AND IDIO.IDIO_OID_IDIO = ? AND IDIO.ATTR_NUM_ATRI=1 AND IDIO.VAL_OID=TF.TCCL_OID_TIPO_CLASI) TIPO_CLASIFICACION_CLIENTE,  ");
        parametros.add(entrada.getOidIdioma());
        sql.append(" (SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE IDIO.ATTR_ENTI = 'MAE_CLASI' AND IDIO.IDIO_OID_IDIO = ? AND IDIO.ATTR_NUM_ATRI=1 AND IDIO.VAL_OID=TF.CLAS_OID_CLAS) CLASIFICACION_CLIENTE  ");
        parametros.add(entrada.getOidIdioma());
        sql.append(" FROM  ");
        sql.append(" V_MAE_TIPIF_CLIEN TF,  ");
        sql.append(" MAE_CLIEN MAE  ");
        sql.append(" WHERE  ");
        sql.append(" TF.CLIE_OID_CLIE = ?  ");
        parametros.add(entrada.getOidCliente());
        sql.append(" AND MAE.oid_clie = TF.CLIE_OID_CLIE");
		
		// Se ejecuta la consulta 
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarClasificacion: Exception", e);
            this.logSql("consultarClasificacion. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        /*if (rs.esVacio()) {
            //GEN-0007 --> 005
            UtilidadesLog.info("****consultarClasificacion: no hay datos ");				
                  codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }*/
		DTOSalida dtoSalida = new DTOSalida(rs);
        
        UtilidadesLog.info("DAOContactos.consultarClasificacion (DTODatosClien entrada): Salida");

        return dtoSalida;
    }


    /** 
     * Método para obtener las consultoras hijas de un cliente
     * @param datosCliente DTODatosClien con el oid del cliente
     * @return DTOSalida con las consultoras encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron consultoras
     */
     //Modificado por incidencia BELC300013227
    public RecordSet consultarConsultorasHijas (DTOOID entrada)
        throws MareException {
        
        UtilidadesLog.info("DAOContactos.consultarConsultorasHijas (DTOOID entrada): Entrada");

		// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT VIN.CLIE_OID_CLIE_VNDO, MAE1.COD_CLIE, MAE1.VAL_NOM1||' '||MAE1.VAL_NOM2||' '||MAE1.VAL_APE1||' '||MAE1.VAL_APE2 CLIENTE, VIN.FEC_DESD, VIN.FEC_HAST ");
        sql.append(" FROM MAE_TIPO_VINCU TV, MAE_CLIEN_VINCU VIN, MAE_CLIEN MAE1 ");
        sql.append(" WHERE  ");
        sql.append(" tv.COD_TIPO_VINC = '01'  "); //Madre / Hija  
        //pzerbino por Incidencia BELC300023306 26/7/2006        
        sql.append(" AND VIN.TIVC_OID_TIPO_VINC = TV.OID_TIPO_VINC   ");
        sql.append(" AND vin.CLIE_OID_CLIE_VNTE = mae1.OID_CLIE  ");
        sql.append(" AND TV.PAIS_OID_PAIS = MAE1.PAIS_OID_PAIS   ");
        //sql.append(" AND MAE1.OID_CLIE = VIN.CLIE_OID_CLIE_VNDO   ");
        //sql.append(" AND VIN.CLIE_OID_CLIE_VNTE = ? ");
        sql.append(" AND VIN.CLIE_OID_CLIE_VNDO = ? ");
        parametros.add(entrada.getOid());
        sql.append(" AND TV.PAIS_OID_PAIS = ?  ");
        parametros.add(entrada.getOidPais());
  
		// Se ejecuta la consulta 
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs =  BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarConsultorasHijas: Exception", e);
            this.logSql("consultarConsultorasHijas. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        /*if (rs.esVacio()) {
            //GEN-0007 --> 005
            UtilidadesLog.info("****consultarConsultorasHijas: no hay datos ");				
                  codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }*/
		//DTOSalida dtoSalida = new DTOSalida(rs);
        
        UtilidadesLog.info("DAOContactos.consultarConsultorasHijas (DTOOID entrada): Salida");

        return rs;
    }

    /** 
     * Método para obtener los nombres de un cliente
     * @param oidCliente DTOOID con el oid de cliente
     * @return DTOSalida con los nombres encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida consultarNombresCliente (DTOOID entrada) throws MareException {
    
        UtilidadesLog.info("DAOContactos.consultarNombresCliente (DTOOID entrada): Entrada");
    
        /*
        RESUMEN: Se obtienen los nombres y los apellidos del cliente con el oid que se pasa por cabecera. 
        */

		// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT A.COD_CLIE, A.VAL_NOM1, A.VAL_NOM2, A.VAL_APE1, A.VAL_APE2 ");
        sql.append(" FROM MAE_CLIEN A ");
        sql.append(" WHERE A.OID_CLIE = ? ");
        parametros.add(entrada.getOid());
		
		// Se ejecuta la consulta 
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarNombresCliente: Exception", e);
            this.logSql("consultarNombresCliente. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        /*if (rs.esVacio()) {
            //GEN-0007 --> 005
            UtilidadesLog.info("****consultarNombresCliente: no hay datos ");				
                  codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }*/
		DTOSalida dtoSalida = new DTOSalida(rs);
        
        UtilidadesLog.info("DAOContactos.consultarNombresCliente (DTOOID entrada): Salida");

        return dtoSalida;
    }
    
    /** 
     * mdolce
     * 15/05/2005
     * Método para obtener los motivos de contacto
     * @param dtoBelcorp con el idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida obtenerMotivosContacto (DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("DAOContactos.obtenerMotivosContacto (DTOBelcorp dto): Entrada");
    
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();

       StringBuffer query = new StringBuffer();

       try {
            query.append(" select a.OID_MOTI_CONT, gen.VAL_I18N ");
            query.append(" from cal_motiv_conta a, gen_i18n_sicc gen ");
            query.append(" where a.OID_MOTI_CONT = gen.VAL_OID ");
            query.append(" and   gen.ATTR_ENTI = 'CAL_MOTIV_CONTA' ");
            query.append(" and   gen.ATTR_NUM_ATRI = 1 ");
            query.append(" and   gen.IDIO_OID_IDIO = " + dto.getOidIdioma());
            resultado = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
  		 }
     catch(Exception e) {
          e.printStackTrace();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
      UtilidadesLog.info("DAOContactos.obtenerMotivosContacto (DTOBelcorp dto): Salida");
     return dtoS;
    }
    
    
}