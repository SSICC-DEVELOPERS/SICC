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
package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuscarConsultorasInicial;
import es.indra.sicc.dtos.msg.DTOBuscarConsultorasOid;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.DTODestinatarioMensaje;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class DAOMSG {
    public RecordSet obtenerMediosEnvioPorPais(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMediosEnvioPorPais(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT a.oid_medi_envi_pais, b.des_medi_envi ");
            buf.append("    FROM msg_medio_envio_pais a, msg_medio_envio b ");
            buf.append("   WHERE a.MEEN_OID_MEDI_ENVI = b.oid_medi_envi ");
            buf.append("     AND pais_oid_pais = " + DTOE.getOidPais());
            buf.append("     AND cod_esta = 'A' ");
            buf.append("ORDER BY b.des_medi_envi ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMediosEnvioPorPais(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    public RecordSet obtenerMetacaracterEstructura(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMetacaracterEstructura(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        UtilidadesLog.debug("<<<<  Entro a DAOMSG.obtenerMetacaracterEstructura  >>>>");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //buf.append("  SELECT oid_meta, val_lite_iden, ");
            buf.append("  SELECT oid_meta,  "); // modificado de acuerdo de incindencia BELC300010574 (quitado campo "val_lite_iden") ver Notas.
            buf.append("         (SELECT val_i18n ");
            buf.append("            FROM v_gen_i18n_sicc ");
            buf.append("           WHERE attr_enti = 'MSG_METAC' ");
            buf.append("             AND attr_num_atri = 1 ");
            buf.append("             AND idio_oid_idio = " + DTOE.getOidIdioma());
            buf.append("             AND val_oid = oid_meta) descripcion ");
            buf.append("    FROM msg_metac ");
            buf.append("   WHERE time_oid_tipo = " + ConstantesMSG.OID_METACARACTER_E);
            buf.append(" ORDER BY descripcion ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMetacaracterEstructura(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    public RecordSet obtenerFormularios() throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerFormularios(): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT oid_form, cod_form ");
            buf.append("  FROM fac_formu ");
            buf.append(" WHERE ind_acti = 1 ");
            buf.append(" ORDER BY cod_form ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerFormularios(): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajesPorPais(DTOSiccPaginacion DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajesPorPais(DTOSiccPaginacion DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT oid_mens OID, cod_mens, des_mens, val_text ");
            buf.append("   FROM msg_mensa ");
            buf.append("  WHERE pais_oid_pais = " + DTOE.getOidPais());
            buf.append("  ORDER BY des_mens ");

            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), DTOE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajesPorPais(DTOSiccPaginacion DTOE): Salida");

        return respuesta;
    }

    public DTOSeccion obtenerSeccion(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerSeccion(DTOOID DTOE): Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        DTOSeccion salida = null;
        ArrayList mensajes = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT oid_patr_secc, cod_secc, num_orde_secc, metc_oid_meta, ");
            buf.append("         (SELECT val_i18n ");
            buf.append("            FROM v_gen_i18n_sicc ");
            buf.append("           WHERE attr_enti = 'MSG_METAC' ");
            buf.append("             AND val_oid = metc_oid_meta ");
            buf.append("             AND idio_oid_idio = " + DTOE.getOidIdioma());
            buf.append("             AND attr_num_atri = 1) des_meta ");
            buf.append("    FROM msg_patro_secci ");
            buf.append("   WHERE oid_patr_secc = " + DTOE.getOid());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());

            if (!respuesta.esVacio()) {
                salida = new DTOSeccion();
                salida.setOidSeccion((respuesta.getValueAt(0, 0) != null) ? new Long(((BigDecimal) respuesta.getValueAt(0, 0)).toString()) : null);
                salida.setCodigo((String) respuesta.getValueAt(0, 1));
                salida.setOrdenSecuencia((respuesta.getValueAt(0, 2) != null) ? new Integer(((BigDecimal) respuesta.getValueAt(0, 2)).toString()) : null);
                salida.setOidMetacaracter((respuesta.getValueAt(0, 3) != null) ? new Long(((BigDecimal) respuesta.getValueAt(0, 3)).toString()) : null);
                salida.setDesMetacaracter((String) respuesta.getValueAt(0, 4));
            }

            buf = new StringBuffer();

            //buf.append("    SELECT a.MENS_OID_MENS, val_text, num_orde_impr ");  //oid_patr_mens
            buf.append("    SELECT a.MENS_OID_MENS, b.COD_MENS, val_text, num_orde_impr "); //inc. 14027            
            buf.append("      FROM msg_patro_mensa a, msg_mensa b ");
            buf.append("     WHERE pase_oid_patr_secc = " + DTOE.getOid());
            buf.append("	   AND a.mens_oid_mens = b.oid_mens ");
            buf.append("  ORDER BY num_orde_impr ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());

            if (!respuesta.esVacio()) {
                UtilidadesLog.debug("hay registros");

                DTOMensajeSeccion dtoSeccion = null;

                for (int i = 0; i < respuesta.getRowCount(); i++) {
                    dtoSeccion = new DTOMensajeSeccion();
                    dtoSeccion.setOidMensaje((respuesta.getValueAt(i, 0) != null) ? new Long(((BigDecimal) respuesta.getValueAt(i, 0)).toString())
                                                                                  : null);
                    dtoSeccion.setCodigoMensaje((String) respuesta.getValueAt(i, 1)); //inc. 14027
                    dtoSeccion.setTexto((String) respuesta.getValueAt(i, 2));
                    dtoSeccion.setOrdenImpresion((respuesta.getValueAt(i, 3) != null)
                                                 ? new Integer(((BigDecimal) respuesta.getValueAt(i, 3)).toString()) : null);
                    mensajes.add(dtoSeccion);
                }

                salida.setMensajes(mensajes);
            }

            UtilidadesLog.info("DAOMSG.obtenerSeccion(DTOOID DTOE): Salida");

            return salida;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public int obtenerNumeroSecciones(Long oidPatron) throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerNumeroSecciones(Long oidPatron): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT num_orde_secc ");
            buf.append("  FROM msg_patro_secci ");
            buf.append(" WHERE patr_oid_patr = " + oidPatron);
            buf.append(" ORDER BY num_orde_secc DESC ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerNumeroSecciones(Long oidPatron): Salida");

        if (respuesta.esVacio() == false) {
            return ((BigDecimal) respuesta.getValueAt(0, 0)).intValue();
        } else {
            return 0;
        }
    }

    public RecordSet obtenerPatronesOrigen(Long oidPais)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerPatronesOrigen(Long oidPais): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT A.PATR_OID_PATR_ORIG, ");
            buf.append("       B.COD_PATR || ' ' || B.DES_PATR ");
            buf.append("  FROM MSG_PATRO_PERIO A,  ");
            buf.append("       MSG_PATRO B ");
            buf.append(" WHERE A.PATR_OID_PATR=B.OID_PATR ");
            buf.append("   AND A.PATR_OID_PATR=A.PATR_OID_PATR_ORIG ");
            buf.append("   AND B.PAIS_OID_PAIS=  " + oidPais);
            buf.append(" ORDER BY b.des_patr ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
        
            UtilidadesLog.error(e);
            
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerPatronesOrigen(Long oidPais): Salida");

        return respuesta;
    }

    public RecordSet obtenerSecciones(Long oidPatron) throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerSecciones(Long oidPatron): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT oid_patr_secc, cod_secc ");
            buf.append("    FROM msg_patro_secci ");
            buf.append("   WHERE patr_oid_patr = " + oidPatron);
            buf.append(" ORDER BY num_orde_secc ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerSecciones(Long oidPatron): Salida");

        return respuesta;
    }

    public RecordSet buscarPatrones(DTOPatron DTOE) throws MareException {
    
        UtilidadesLog.info("DAOMSG.buscarPatrones(DTOPatron DTOE): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT a.oid_patr OID, a.cod_patr, a.des_patr, b.VAL_NOMB_FORM, d.des_medi_envi, ");
            buf.append("         a.ind_acti, ind_patr_peri, '' cod_tipo_peri, '' cod_peri  ");
            buf.append("    FROM msg_patro a, fac_formu b, msg_medio_envio_pais c, msg_medio_envio d ");
            buf.append("   WHERE b.oid_form = a.fors_oid_form ");
            buf.append("     AND c.oid_medi_envi_pais = a.meep_oid_medi_envi_pais ");
            buf.append("     AND d.oid_medi_envi = c.meen_oid_medi_envi ");
            buf.append("     AND a.pais_oid_pais = " + DTOE.getOidPais());

            if ((DTOE.getCodigo() != null) && !("".equals(DTOE.getCodigo()))) {
                buf.append("     AND a.cod_patr LIKE '" + DTOE.getCodigo() + "' ");
            }

            if ((DTOE.getDescripcion() != null) && !("".equals(DTOE.getDescripcion()))) {
                buf.append("     AND a.des_patr LIKE '" + DTOE.getDescripcion() + "' ");
            }

            if (DTOE.getOidFormulario() != null) {
                buf.append("     AND a.fors_oid_form = " + DTOE.getOidFormulario());
            }

            if (DTOE.getOidMedioEnvio() != null) {
                buf.append("     AND a.meep_oid_medi_envi_pais = " + DTOE.getOidMedioEnvio());
            }

            if (DTOE.getActivo() != null) {
                buf.append("     AND a.ind_acti = " + (DTOE.getActivo().booleanValue() ? 1 : 0));
            }

            if (DTOE.getPatronPeriodo() != null) {
                buf.append("     AND a.ind_patr_peri = " + (DTOE.getPatronPeriodo().booleanValue() ? 1 : 0));
            }

            buf.append("   ORDER BY a.des_patr ");

            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), DTOE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        if (respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOMSG.buscarPatrones(DTOPatron DTOE): Salida");

        return respuesta;
    }

    public RecordSet buscarPatronesPorPeriodo(DTOPatron DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.buscarPatronesPorPeriodo(DTOPatron DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT a.oid_patr OID, a.cod_patr, a.des_patr, b.cod_form, c.des_medi_envi, a.ind_acti, ");
            buf.append("         a.ind_patr_peri, e.cod_tipo_peri, f.cod_peri ");
            buf.append("    FROM msg_patro a, ");
            buf.append("         fac_formu b, ");
            buf.append("         msg_medio_envio c, ");
            buf.append("         msg_medio_envio_pais d, ");
            buf.append("         seg_tipo_perio e, ");
            buf.append("         seg_perio_corpo f, ");
            buf.append("         msg_patro_perio g ");
            buf.append("   WHERE a.fors_oid_form = b.oid_form ");
            buf.append("     AND a.oid_patr = g.patr_oid_patr_orig ");
            buf.append("     AND g.peri_oid_peri = f.oid_peri ");
            buf.append("     AND f.tipe_oid_tipo_peri = e.oid_tipo_peri ");
            buf.append("     AND a.meep_oid_medi_envi_pais = d.oid_medi_envi_pais ");
            buf.append("     AND d.meen_oid_medi_envi = c.oid_medi_envi ");
            buf.append("     AND a.pais_oid_pais = " + DTOE.getOidPais());

            if ((DTOE.getCodigo() != null) && !("".equals(DTOE.getCodigo()))) {
                buf.append("     AND a.cod_patr LIKE '" + DTOE.getCodigo() + "' ");
            }

            if ((DTOE.getDescripcion() != null) && !("".equals(DTOE.getDescripcion()))) {
                buf.append("     AND a.des_patr LIKE '" + DTOE.getDescripcion() + "' ");
            }

            if (DTOE.getOidFormulario() != null) {
                buf.append("     AND a.fors_oid_form = " + DTOE.getOidFormulario());
            }

            if (DTOE.getOidMedioEnvio() != null) {
                buf.append("     AND a.meep_oid_medi_envi_pais = " + DTOE.getOidMedioEnvio());
            }

            if (DTOE.getActivo() != null) {
                buf.append("     AND a.ind_acti = " + (DTOE.getActivo().booleanValue() ? 1 : 0));
            }

            if (DTOE.getPatronPeriodo() != null) {
                buf.append("     AND a.ind_patr_peri = " + (DTOE.getPatronPeriodo().booleanValue() ? 1 : 0));
            }

            if (DTOE.getOidPeriodo() != null) {
                buf.append("     AND g.peri_oid_peri = " + DTOE.getOidPeriodo());
            }

            buf.append("   ORDER BY a.des_patr ");

            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), DTOE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOMSG.buscarPatronesPorPeriodo(DTOPatron DTOE): Salida");

        return respuesta;
    }

    //NOTA: en incidencia 4096 se indica que la descripcion no se recupera
    public RecordSet obtenerTiposMensaje(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerTiposMensaje(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT OID_TIPO_MENS, COD_TIPO_MENS ");
            buf.append("FROM MSG_TIPO_MENSA ");
            buf.append("ORDER BY COD_TIPO_MENS");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTiposMensaje(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    //Incidencia 4138
    //se obtienen el oid y la descripcion
    public RecordSet obtenerTiposGeneracionDatos(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerTiposGeneracionDatos(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            Long oidIdioma = null;

            if (DTOE != null) {
                oidIdioma = DTOE.getOidIdioma();
            }

            buf.append("SELECT M.OID_TIPO_GENE_DATO, V.VAL_I18N");
            buf.append(" FROM MSG_TIPO_GENER_DATOS M, V_GEN_I18N_SICC V");
            buf.append(" WHERE V.ATTR_NUM_ATRI = 1 AND");
            buf.append(" V.ATTR_ENTI = 'MSG_TIPO_GENER_DATOS' AND ");
            buf.append(" V.VAL_OID = M.OID_TIPO_GENE_DATO");

            if (oidIdioma != null) {
                buf.append(" AND V.IDIO_OID_IDIO = ").append(oidIdioma.toString());
            }

            buf.append(" ORDER BY V.VAL_I18N");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTiposGeneracionDatos(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    //Incidencia 4140
    //solo obtendremos el oid y el código.
    public RecordSet obtenerTiposPermanencia() throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerTiposPermanencia(): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT OID_TIPO_PERM, COD_TIPO_PERM");
            buf.append(" FROM MSG_TIPO_PERMA");
            buf.append(" ORDER BY COD_TIPO_PERM");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTiposPermanencia(): Salida");

        return respuesta;
    }

    public RecordSet obtenerTiposDestinatario(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerTiposDestinatario(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String whereString;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT M.OID_TIPO_DEST, V.VAL_I18N");
            buf.append(" FROM MSG_TIPO_ASIGN_DESTI M, V_GEN_I18N_SICC V");
            buf.append(" WHERE V.VAL_OID = M.OID_TIPO_DEST");
            buf.append(" AND V.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            buf.append(" AND V.ATTR_NUM_ATRI = 1");
            buf.append(" AND V.ATTR_ENTI = 'MSG_TIPO_ASIGN_DESTI' ");
            buf.append(" ORDER BY V.VAL_I18N");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTiposDestinatario(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    public RecordSet consultarConsultoras(DTOBuscarConsultorasOid DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.consultarConsultoras(DTOBuscarConsultorasOid DTOE): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("  SELECT b.oid_buzo_mens OID, a.cod_clie, b.dato_vari_01, b.dato_vari_02, b.dato_vari_03, ");
        query.append("         b.dato_vari_04, b.dato_vari_05, b.dato_vari_06, b.dato_vari_07, ");
        query.append("         b.dato_vari_08, b.dato_vari_09, b.dato_vari_10 ");
        query.append("    FROM mae_clien a, msg_buzon_mensa b, msg_mensa c, msg_mensa_tipo_asign d ");
        query.append("   WHERE a.oid_clie = b.clie_oid_clie ");

        //        query.append("	   AND b.mens_oid_mens = " + DTOE.getOidMensaje());
        if (DTOE.getOidCliente() != null) {
            query.append("	AND b.clie_oid_clie =  " + DTOE.getOidCliente());
        }

        query.append("     AND b.mens_oid_mens = c.oid_mens ");
        query.append("     AND c.cod_mens LIKE '" + DTOE.getCodMensaje() + "' ");
        query.append("     AND c.pais_oid_pais = " + DTOE.getOidPais());
        query.append("     AND b.ind_list_cons = 1 ");
        query.append("     AND c.oid_mens = d.mens_oid_mens ");
        query.append("     AND d.tide_oid_tipo_dest = " + ConstantesMSG.OID_CONSULTORAS);
        query.append("ORDER BY b.clie_oid_clie ");

        try {
            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE));
        } catch (Exception exception) {
            
            UtilidadesLog.error(exception);
            
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.consultarConsultoras(DTOBuscarConsultorasOid DTOE): Salida");

        return respuesta;
    }

    public RecordSet obtenerListaConsultoras(DTOBuscarConsultorasOid DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerListaConsultoras(DTOBuscarConsultorasOid DTOE): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("  SELECT   b.oid_buzo_mens OID, a.cod_clie, b.dato_vari_01, b.dato_vari_02, b.dato_vari_03, ");
        query.append("           b.dato_vari_04, b.dato_vari_05, b.dato_vari_06, b.dato_vari_07, ");
        query.append("           b.dato_vari_08, b.dato_vari_09, b.dato_vari_10 ");
        query.append("      FROM mae_clien a, msg_buzon_mensa b, msg_mensa c, msg_mensa_tipo_asign d ");
        query.append("     WHERE a.oid_clie = b.clie_oid_clie ");

        //        query.append("       AND b.mens_oid_mens = " + DTOE.getOidMensaje());
        if (DTOE.getOidCliente() != null) {
            query.append("	AND b.clie_oid_clie =  " + DTOE.getOidCliente());
        }

        query.append("     AND b.ind_list_cons = 1 ");
        query.append("     AND b.ind_acti = " + ConstantesMSG.IND_ACTIVO);
        query.append("     AND b.ind_esta_mens = 0 ");
        query.append("     AND b.mens_oid_mens = c.oid_mens ");

        query.append("     AND c.cod_mens LIKE '" + DTOE.getCodMensaje() + "' ");
        query.append("     AND c.pais_oid_pais = " + DTOE.getOidPais());
        query.append("     AND c.oid_mens = d.mens_oid_mens ");
        query.append("     AND d.tide_oid_tipo_dest = " + ConstantesMSG.OID_CONSULTORAS);
        query.append(" ORDER BY b.clie_oid_clie ");

        try {
            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE));
        } catch (Exception exception) {
        
            UtilidadesLog.error(exception);
            
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerListaConsultoras(DTOBuscarConsultorasOid DTOE): Salida");

        return respuesta;
    }

    public RecordSet obtenerListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("  SELECT   b.oid_buzo_mens OID, a.cod_clie, b.dato_vari_01, b.dato_vari_02, b.dato_vari_03, ");
        query.append("           b.dato_vari_04, b.dato_vari_05, b.dato_vari_06, b.dato_vari_07, ");
        query.append("           b.dato_vari_08, b.dato_vari_09, b.dato_vari_10 ");
        query.append("      FROM mae_clien a, msg_buzon_mensa b ");
        query.append("     WHERE a.oid_clie = b.clie_oid_clie ");
        query.append("       AND b.mens_oid_mens = " + DTOE.getOidMensaje());
        query.append("       AND b.ind_list_cons = 1 ");
        query.append("       AND b.ind_acti = " + ConstantesMSG.IND_ACTIVO);
        query.append("       AND b.ind_esta_mens = 0 ");
        query.append("  ORDER BY b.clie_oid_clie ");

        try {
            respuesta = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE));
        } catch (Exception exception) {
        
            UtilidadesLog.error(exception);
            
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerListaConsultorasInicial(DTOBuscarConsultorasInicial DTOE): Salida");

        return respuesta;
    }

    public RecordSet buscarMensajes(DTOMensaje DTOE) throws MareException {
    
        UtilidadesLog.info("DAOMSG.buscarMensajes(DTOMensaje DTOE): Entrada");
    
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();
        String whereString = "";

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //armar consulta
        try {
            buf.append("SELECT m.oid_mens OID, m.cod_mens, m.des_mens, tm.cod_tipo_mens,    ");
            buf.append("       m.val_bloq_grup_perm, tper.cod_tipo_perm                     ");
            buf.append("  FROM msg_mensa m, msg_tipo_mensa tm, msg_tipo_perma tper          ");
            buf.append(" WHERE tm.oid_tipo_mens = m.tmen_oid_tipo_mens                      ");
            buf.append("   AND tper.oid_tipo_perm = m.tper_oid_tipo_perm                    ");

            if (DTOE.getOidPais() != null) {
                buf.append("	AND m.PAIS_OID_PAIS =  " + DTOE.getOidPais());
            }

            if ((DTOE.getCodigo() != null) && (!DTOE.getCodigo().equals(""))) {
                buf.append(" 	AND m.COD_MENS LIKE '" + DTOE.getCodigo() + "'  ");
            }

            if (DTOE.getOidTipoMensaje() != null) {
                buf.append("	AND m.TMEN_OID_TIPO_MENS =  " + DTOE.getOidTipoMensaje());
            }

            if ((DTOE.getBloque() != null) && (!DTOE.getBloque().equals(""))) {
                buf.append("	AND m.VAL_BLOQ_GRUP_PERM LIKE '" + DTOE.getBloque() + "'  ");
            }

            if (DTOE.getOidPermanencia() != null) {
                buf.append("	AND m.TPER_OID_TIPO_PERM = " + DTOE.getOidPermanencia());
            }

            String queryPaginada;

            try {
                queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), DTOE);
            } catch (Exception exception) {
                //System.out.println("error en query paginada (UtilidadesPaginacion) ");
                
                UtilidadesLog.error(exception);
                
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("query paginada: " + queryPaginada);

            respuesta = bs.dbService.executeStaticQuery(queryPaginada);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOMSG.buscarMensajes(DTOMensaje DTOE): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajeUnidadAdministrativa(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajeUnidadAdministrativa(Long oidMensaje): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT e.oid_mens_unid_admi, e.zorg_oid_regi, e.zzon_oid_zona,   ");
            buf.append("       e.zscc_oid_secc, e.terr_oid_terr, a.des_regi, b.des_zona, c.des_secci,   ");
            buf.append("       d.cod_terr   ");
            buf.append("  FROM zon_regio a,   ");
            buf.append("       zon_zona b,   ");
            buf.append("       zon_secci c,   ");
            buf.append("       zon_terri d,   ");
            buf.append("       msg_mensa_unida_admin e   ");
            buf.append(" WHERE a.oid_regi = e.zorg_oid_regi   ");
            buf.append("   AND b.oid_zona (+)= e.zzon_oid_zona   ");
            buf.append("   AND c.oid_secc (+)= e.zscc_oid_secc   ");
            buf.append("   AND d.oid_terr (+)= e.terr_oid_terr   ");
            buf.append("   AND e.mens_oid_mens =  " + oidMensaje);

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajeUnidadAdministrativa(Long oidMensaje): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajeTipoCliente(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajeTipoCliente(Long oidMensaje): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("  SELECT mtc.oid_mens_tipo_clie, mtc.ticl_oid_tipo_clie, mtc.sbti_oid_subt_clie,  ");
            buf.append("         mtc.tccl_oid_tipo_clas, mtc.clas_oid_clas  ");
            buf.append("    FROM msg_mensa_tipo_clien mtc  ");
            buf.append("   WHERE mtc.mens_oid_mens =   " + oidMensaje);

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajeTipoCliente(Long oidMensaje): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajeMarca(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajeMarca(Long oidMensaje): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT OID_MENS_MARC, MARC_OID_MARC");
            buf.append(" FROM MSG_MENSA_MARCA");
            buf.append(" WHERE 1 = 1");

            if (oidMensaje != null) {
                buf.append(" AND MENS_OID_MENS = ").append(oidMensaje.toString());
            }

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajeMarca(Long oidMensaje): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajeCodigoVenta(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajeCodigoVenta(Long oidMensaje): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("   SELECT mcv.OID_MENS_CODI_VENT, mcv.VAL_CODI_VENT ");
            buf.append("   FROM msg_mensa_codig_venta mcv ");
            buf.append("   WHERE mcv.MENS_OID_MENS = " + oidMensaje);

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajeCodigoVenta(Long oidMensaje): Salida");

        return respuesta;
    }

    public RecordSet obtenerMensajeCliente(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMensajeCliente(Long oidMensaje): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT OID_MENS_DEST, CLIE_OID_CLIE");
            buf.append(" FROM MSG_MENSA_DESTI");
            buf.append(" WHERE 1 = 1");

            if (oidMensaje != null) {
                buf.append(" AND MENS_OID_MENS = ").append(oidMensaje.toString());
            }

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerMensajeCliente(Long oidMensaje): Salida");

        return respuesta;
    }

    public Long obtenerNumeroSecuencial(Long oidMens, Long oidCliente, Long oidPais)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerNumeroSecuencial(Long oidMens, Long oidCliente, Long oidPais): Entrada");
            
        StringBuffer query_aux = new StringBuffer();

        try {
            query_aux.append("SELECT MSG_BUM2_SEQ.NEXTVAL NUM_SECU FROM DUAL");

            RecordSet rta_numSec = BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());

            UtilidadesLog.info("DAOMSG.obtenerNumeroSecuencial(Long oidMens, Long oidCliente, Long oidPais): Salida");

            if (rta_numSec.getRowCount() > 0) {
                return new Long(((BigDecimal) rta_numSec.getValueAt(0, "NUM_SECU")).longValue());
            } else {
                return new Long("0");
            }
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerMetacaracter(DTOBelcorp dtoin)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerMetacaracter(DTOBelcorp dtoin): Entrada");
            
        //Documentation
        //Obtiene los metacaracteres existentes utilizando el servicio DBService. 
        //
        //Accede a la tabla MSG_METACARACTER y obtiene: 
        //- LITERAL_IDENTIFICADOR 
        //- DESCRIPCION 
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT mtc.VAL_LITE_IDEN, v.val_i18n  descripcion ");
            buf.append(" FROM MSG_METAC mtc, v_gen_i18n_sicc v ");
            buf.append(" WHERE mtc.OID_META = v.VAL_OID ");
            buf.append(" AND v.ATTR_ENTI = 'MSG_METAC' ");
            buf.append(" AND v.IDIO_OID_IDIO = 1 ");
            buf.append(" AND v.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND mtc.VAL_ESTA = '" + ConstantesMSG.IND_METACAR_ACTIVADO + "' ");
			buf.append(" AND ( mtc.TIME_OID_TIPO = " + ConstantesMSG.OID_METACARACTER_F);
            buf.append(" OR mtc.TIME_OID_TIPO = " + ConstantesMSG.OID_METACARACTER_C + " )");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(respuesta);

        UtilidadesLog.info("DAOMSG.obtenerMetacaracter(DTOBelcorp dtoin): Salida");

        return dtoSalida;
    }

    /**
     * Realiza una búsqueda de todos los patrones utilizando el servicio DBService.
     * Paola Cabrera
     * Fecha: 15/12/2004
     *
     */
    public RecordSet obtenerTodosPatrones(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerTodosPatrones(DTOBelcorp DTOE): Entrada");
            
        BelcorpService bs = null;
        RecordSet respuesta = null;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT OID_PATR, ");
            buf.append(" COD_PATR ");
            buf.append(" FROM MSG_PATRO ");
            buf.append(" ORDER BY COD_PATR ");

            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTodosPatrones(DTOBelcorp DTOE): Salida");

        return respuesta;
    }

    /*Elimina los mensajes de faltantes anunciados generados por PED que no estén impresos.
     * @author Sergio Saavedra
     * fecha 22/12/04
     */
    public void eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto): Entrada");
            
        BelcorpService bs;
        int respuesta;
        StringBuffer buf = new StringBuffer();

        /*estos datos deben estar con dato, sio o si
        pais
        codigoMensaje
        oidCliente
        moduloOrigen
        datoVariable1*/

        if ((dto.getOidPais() != null) && (dto.getCodigoMensaje() != null) && (dto.getOidCliente() != null) && (dto.getModuloOrigen() != null) &&
                (dto.getDatoVariable1() != null)) {
                
            UtilidadesLog.debug("todos los datos, ok...");

            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                buf.append("DELETE msg_buzon_mensa ");
                buf.append("WHERE ");
                buf.append("clie_oid_clie = " + dto.getOidCliente().longValue());
                buf.append(" and modu_oid_modu_orig = " + dto.getModuloOrigen().longValue());
                buf.append(" and dato_vari_01 = " + dto.getDatoVariable1());
                buf.append(" and mens_oid_mens = (Select oid_mens");
                buf.append(" from msg_mensa where pais_oid_pais = " + dto.getOidPais().longValue());
                buf.append(" and cod_mens = '" + dto.getCodigoMensaje() + "'");
                buf.append(") and ind_esta_mens <> " + ConstantesMSG.IND_ACTIVO.longValue());
                
                UtilidadesLog.debug("antes de borrar de buzon...");
                
                respuesta = bs.dbService.executeUpdate(buf.toString());
                
                UtilidadesLog.debug("luego de borrar de buzon...");
                
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAOMSG.eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto): Salida");
        
    }

    public RecordSet obtenerCodigosMensajesPorPais(DTOBelcorp dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerCodigosMensajesPorPais(DTOBelcorp dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT OID_MENS, COD_MENS ");
        query.append(" FROM MSG_MENSA ");
        query.append(" WHERE PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append(" ORDER BY COD_MENS ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerCodigosMensajesPorPais(DTOBelcorp dtoe): Salida");

        return rs;
    }

    public RecordSet obtenerTipoMetacaracter(DTOBelcorp dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerTipoMetacaracter(DTOBelcorp dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT tm.oid_tipo, descripcion.val_i18n ");
        query.append(" FROM msg_tipo_metac tm, gen_i18n_sicc descripcion ");
        query.append(" WHERE tm.oid_tipo = descripcion.val_oid ");
        query.append(" AND descripcion.attr_enti = 'MSG_TIPO_METAC' ");
        query.append(" AND descripcion.attr_num_atri = 1 ");
        query.append(" AND descripcion.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" order by 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerTipoMetacaracter(DTOBelcorp dtoe): Salida");

        return rs;
    }
    
    
    /**    
     *@Author: pperez 
     *@Fecha: 19/10/2006
     *@throws: MareException
     *@return: DTODestinatarioMensaje[] 
     *@param: Long oidMensaje
     *@Observaciones: CAMBIO MSG-002
    */ 
    
    public DTODestinatarioMensaje[] obtenerTiposDestinatariosMensaje(Long oidMensaje) throws MareException {

        UtilidadesLog.info("DAOMSG.obtenerTiposDestinatariosMensaje(Long oidMensaje): Entrada");

        DTODestinatarioMensaje[] resultado = null;
        DTODestinatarioMensaje dtoDestMensaje = null;
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT mta.tide_oid_tipo_dest TIPO_DESTINATARIO ");
        query.append("   FROM MSG_MENSA_TIPO_ASIGN mta  ");
        query.append("  WHERE mta.mens_oid_mens = " + oidMensaje);
        

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (!rs.esVacio())  {
            int cant = rs.getRowCount();
            resultado = new DTODestinatarioMensaje[cant];
            for (int i=0; i<cant; i++ )  {
                dtoDestMensaje = new DTODestinatarioMensaje();
                dtoDestMensaje.setOidTipoDestinatario(new Long(((BigDecimal) rs.getValueAt(i,"TIPO_DESTINATARIO")).longValue()));
                resultado[i] = dtoDestMensaje;
            }
        }
        UtilidadesLog.info("DAOMSG.obtenerTiposDestinatariosMensaje(Long oidMensaje): Salida");
        return resultado;
    }
    
    public DTODestinatarioMensaje[] obtenerTiposDestinatariosMensaje(DTOBuzonMensajes[] oidsMensaje) throws MareException {


        DTODestinatarioMensaje[] resultado = null;
        DTODestinatarioMensaje dtoDestMensaje = null;
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        //  Agregado por HRCS - Fecha 04/07/2007 - Incidencia Sicc20070287
        HashSet codigos = new HashSet();
        for (int i = 0 ; i < oidsMensaje.length ; i++){
            codigos.add( oidsMensaje[i].getOidMensaje() );
        }
        query.append(" SELECT mta.mens_oid_mens MENSAJE, mta.tide_oid_tipo_dest TIPO_DESTINATARIO ");
        query.append("   FROM MSG_MENSA_TIPO_ASIGN mta ");
        query.append(" WHERE mta.mens_oid_mens IN " + codigos.toString().replace('[','(').replace(']',')') );      

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR",ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (!rs.esVacio())  {
            int cant = rs.getRowCount();
            resultado = new DTODestinatarioMensaje[cant];
            for (int i=0; i<cant; i++ )  {
                dtoDestMensaje = new DTODestinatarioMensaje();
                //Lo meto aca porque no tengo ganas de crear una propiedad 
                dtoDestMensaje.setOidMensaje(new Long(((BigDecimal) rs.getValueAt(i,"MENSAJE")).longValue()));
                dtoDestMensaje.setOidTipoDestinatario(new Long(((BigDecimal) rs.getValueAt(i,"TIPO_DESTINATARIO")).longValue()));
                resultado[i] = dtoDestMensaje;
            }
        }
        UtilidadesLog.info("DAOMSG.obtenerTiposDestinatariosMensaje(Long oidMensaje): Salida");
        return resultado;
    }

    /**
     * Realiza una búsqueda de todos los errores que se producen al validar el Texto Fijo 
     * y datos variables de un mensaje.
     * Sergio Apaza
     * Fecha: 14/07/2010
     * RCR: PER-SiCC-2010-0450
     */
    public int obtenerNumeroRegistrosConError(String texto) throws MareException {
    
        UtilidadesLog.info("DAOMSG.obtenerNumeroRegistrosConError(String texto): Entrada");
    
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" WITH MSG_MENSA_AUX AS (SELECT '" + texto.replaceAll("'","''") + "' VAL_TEXT FROM dual) ");
            buf.append(" SELECT 'comp \"<\"  y \">\" ' comparacion ");
            buf.append("   FROM MSG_MENSA_AUX ");
            buf.append("  WHERE (LENGTH(VAL_TEXT) - LENGTH(REPLACE(VAL_TEXT,'<',''))) - (LENGTH(VAL_TEXT) - LENGTH(REPLACE(VAL_TEXT,'>',''))) <>0 ");
            buf.append("union ");
            buf.append(" SELECT 'comp \"<txt>\"  y \"</txt>\" ' comparacion ");
            buf.append("  FROM MSG_MENSA_AUX ");
            buf.append("  WHERE (LENGTH( ");
            buf.append("        REPLACE(REPLACE(VAL_TEXT,'<txt>','123XXX'),'</txt>','456YYY')) - LENGTH(REPLACE( ");
            buf.append("        REPLACE(REPLACE(VAL_TEXT,'<txt>','123XXX'),'</txt>','456YYY'),'123XXX',''))) - (LENGTH( ");
            buf.append("        REPLACE(REPLACE(VAL_TEXT,'<txt>','123XXX'),'</txt>','456YYY')) - LENGTH(REPLACE( ");
            buf.append("        REPLACE(REPLACE(VAL_TEXT,'<txt>','123XXX'),'</txt>','456YYY'),'456YYY',''))) <>0 ");
            buf.append("union ");
            buf.append(" SELECT 'comp \"<fijo>\"  y \"</fijo>\" ' comparacion ");
            buf.append("  FROM MSG_MENSA_AUX ");
            buf.append(" WHERE (LENGTH( ");
            buf.append("       REPLACE(REPLACE(VAL_TEXT,'<fijo>','123XXX'),'</fijo>','456YYY')) - LENGTH(REPLACE( ");
            buf.append("       REPLACE(REPLACE(VAL_TEXT,'<fijo>','123XXX'),'</fijo>','456YYY'),'123XXX',''))) - (LENGTH( ");
            buf.append("       REPLACE(REPLACE(VAL_TEXT,'<fijo>','123XXX'),'</fijo>','456YYY')) - LENGTH(REPLACE( ");
            buf.append("       REPLACE(REPLACE(VAL_TEXT,'<fijo>','123XXX'),'</fijo>','456YYY'),'456YYY',''))) <>0 ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerNumeroRegistrosConError(String texto): Salida");

        if (respuesta.esVacio() == false) {
            return respuesta.getRowCount();
        } else {
            return 0;
        }
    }

    /**
     * Retorna la lista de patrones no validos en el xml
     * @return
     * @throws MareException
     */
    public List getListVariablesNoValidas() throws MareException {
    
        UtilidadesLog.info("DAOMSG.getListVariablesNoValidas(): Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        List listVariables = new ArrayList();
        Vector vparametro= new Vector();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT VAL_VALI  ");
            buf.append(" FROM MSG_MENSA_VARIA_VALID  ");
            buf.append(" WHERE IND_VALI  = ? ");
            vparametro.add("N") ;
            
            //respuesta = bs.dbService.executeStaticQuery(buf.toString());
             respuesta = bs.dbService.executePreparedQuery(buf.toString(),vparametro);
            
            if (!respuesta.esVacio()) {
                UtilidadesLog.debug("hay registros");     
                for (int i = 0; i < respuesta.getRowCount(); i++) {
                    listVariables.add((String)respuesta.getValueAt(i, 0));
                }
            }

            UtilidadesLog.info("DAOMSG.getListVariablesNoValidas(): Salida");

            return listVariables;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    
    /**
     * Retorna la lista de patrones validos en el xml
     * @return
     * @throws MareException
     */
    public List getListVariablesValidas() throws MareException {
    
        UtilidadesLog.info("DAOMSG.getListVariablesValidas(): Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        List listVariables = new ArrayList();
        Vector vparametro= new Vector();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT  VAL_VALI   ");
            buf.append(" FROM MSG_MENSA_VARIA_VALID  ");
            buf.append(" WHERE IND_VALI  = ? ");
            vparametro.add("S") ;
            
            //respuesta = bs.dbService.executeStaticQuery(buf.toString());
             respuesta = bs.dbService.executePreparedQuery(buf.toString(),vparametro);
            
            if (!respuesta.esVacio()) {
                UtilidadesLog.debug("hay registros");     
                for (int i = 0; i < respuesta.getRowCount(); i++) {
                    listVariables.add((String)respuesta.getValueAt(i, 0));
                }
            }

            UtilidadesLog.info("DAOMSG.getListVariablesValidas(): Salida");

            return listVariables;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    public String obtenerCodigoTipoMensaje(DTOMensaje DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOMSG.obtenerCodigoTipoMensaje(DTOMensaje DTOE): Entrada");
            
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        Vector parametros = new Vector();
        String codigo="";
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT COD_TIPO_MENS ");
            buf.append("FROM MSG_TIPO_MENSA ");
            buf.append("WHERE  OID_TIPO_MENS = ? ");
            
            parametros.add(DTOE.getOidTipoMensaje());
            UtilidadesLog.debug("query: " + buf.toString());

            respuesta = bs.dbService.executePreparedQuery(buf.toString(),parametros);
            
            
            if (!respuesta.esVacio()) {
                UtilidadesLog.debug("hay registros");     
               
                     codigo = (String)respuesta.getValueAt(0, 0);
               
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMSG.obtenerCodigoTipoMensaje(DTOMensaje DTOE): Salida");

        return codigo;
    }
}
