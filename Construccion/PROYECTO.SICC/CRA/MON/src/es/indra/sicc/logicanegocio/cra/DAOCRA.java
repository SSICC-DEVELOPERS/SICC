/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35obtienePeriodosPosteriores
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.cra;

import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cra.DTOCabecerasGruposZonas;
import es.indra.sicc.dtos.cra.DTOGenerarCronogramaporZonas;
import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;
import java.util.Iterator;
import java.sql.Timestamp;



/**
 * Sistema:         Belcorp
 * Modulo:          CRA - Cronograma de Actividades
 * Componente:      DAOCRA
 * Fecha:           22/1/2004
 * Observaciones:
 *
 * @version         1.0
 * @author
 */
public class DAOCRA implements IDAOCRA {
    public DAOCRA() {}

    /**
     * Obtiene los periodos por tipo de periodo.
     * Filtra de manera optativa por pais, marca, canal y tipoPeriodo
     * @author gdmarzi
     */
    public RecordSet obtienePeriodoPorTipo(Long oidPais, Long oidMarca, Long oidCanal, Long oidTipoPeriodo)
        throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodoPorTipo(Long oidPais, Long oidMarca, Long oidCanal, Long oidTipoPeriodo):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String whereString;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" select P.OID_PERI, P.VAL_NOMB_PERI, P.CANA_OID_CANA, P.MARC_OID_MARC, ");
            buf.append(" P.PAIS_OID_PAIS, P.ACCE_OID_ACCE, P.PERI_OID_PERI, P.FEC_INIC, P.FEC_FINA, P.VAL_ESTA ");
            buf.append(" from CRA_PERIO P, SEG_PERIO_CORPO PC ");
            //condiciones para el where
            whereString = UtilidadesBD.armarSQLWhere(new String[] {
                        "P.PAIS_OID_PAIS", "P.MARC_OID_MARC", "P.CANA_OID_CANA", "PC.TIPE_OID_TIPO_PERI "
                    }, new Object[] {oidPais, oidMarca, oidCanal, oidTipoPeriodo}, new boolean[] {false, false, false, false});
            buf.append(whereString);

            if(whereString.length() == 0)
                buf.append(" where ");
            else
                buf.append(" and ");

            //join entre tablas
            buf.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            buf.append(" order by P.VAL_NOMB_PERI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodoPorTipo(Long oidPais, Long oidMarca, Long oidCanal, Long oidTipoPeriodo):Salida");
        return respuesta;
    }

    /**
     * Obtiene los periodos utilizando todos los filtros posibles segun el dtoPeriodo.
     */
    public DTOSalida obtienePeriodo(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodo(DTOPeriodo dto):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();

            buf.append(" SELECT periodo.oid_peri, periodo.val_nomb_peri,  ");
            buf.append(" periodo.marc_oid_marc, periodo.cana_oid_cana,  ");//cambio para reportes
            buf.append(" periodo.FEC_INIC, periodo.FEC_FINA   ");
            buf.append(" FROM cra_perio periodo ");
            buf.append(" WHERE 1=1 ");

            if(dto.getCanal() != null)
                buf.append(" AND periodo.cana_oid_cana = " + dto.getCanal() + " ");

            if(dto.getMarca() != null)
                buf.append(" AND periodo.marc_oid_marc = " + dto.getMarca() + " ");

            if(dto.getPais() != null){
                buf.append(" AND periodo.pais_oid_pais = " + dto.getPais() + " ");
            
            }else if(dto.getOidPais() != null) {
            //Incidencia BELC300017181
                buf.append(" AND periodo.pais_oid_pais = " + dto.getOidPais() + " ");
            }

            

            if(dto.getAcceso() != null)
                buf.append(" AND periodo.acce_oid_acce = " + dto.getAcceso() + " ");

            if(dto.getTipo() != null)
                buf.append(" AND periodo.PERI_OID_PERI = " + dto.getTipo() + " ");

            if(dto.getFechaInicio() != null)
                buf.append(" AND periodo.fec_inic = to_date('" + dto.getFechaInicio() + "', 'yyyy-mm-dd') ");

            if(dto.getFechaFin() != null)
                buf.append(" AND periodo.fec_fina = to_date('" + dto.getFechaFin() + "', 'yyyy-mm-dd') ");

            if(dto.getStatus() != null) {
                if(dto.getStatus().booleanValue())
                    buf.append(" AND periodo.val_esta = 1 ");
                else
                    buf.append(" AND periodo.val_esta = 0 ");
            }

			buf.append(" ORDER BY val_nomb_peri ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodo(DTOPeriodo dto):Salida");
        return new DTOSalida(respuesta);
    }
    
    
    /**
     * Obtiene los periodos segun marca canal acceso y un rango de fechas
     * @author mdolce
     * CHANGELOG:
     * - 20/06/2008 - dmorello, cambio CRA-01: Filtro periodos por año
     * */
     
      public DTOSalida obtienePeriodoAnioAcceso(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodoAnioAcceso(DTOPeriodo dto):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();

            buf.append(" SELECT periodo.oid_peri, periodo.val_nomb_peri ");
            buf.append(" FROM cra_perio periodo ");
            if (dto.getAnio() != null) {
                buf.append(" , seg_perio_corpo pc ");
            }
            
            buf.append(" WHERE 1=1 ");
            
            if (dto.getAnio() != null) {
                buf.append(" AND periodo.peri_oid_peri = pc.oid_peri ");
                buf.append(" AND pc.val_anio = ").append(dto.getAnio());
            }

            if(dto.getCanal() != null)
                buf.append(" AND periodo.cana_oid_cana = " + dto.getCanal() + " ");

            if(dto.getMarca() != null)
                buf.append(" AND periodo.marc_oid_marc = " + dto.getMarca() + " ");

            if(dto.getPais() != null)
                buf.append(" AND periodo.pais_oid_pais = " + dto.getPais() + " ");

            if(dto.getAcceso() != null)
                buf.append(" AND periodo.acce_oid_acce = " + dto.getAcceso() + " ");

            if(dto.getTipo() != null)
                buf.append(" AND periodo.PERI_OID_PERI = " + dto.getTipo() + " ");

            if(dto.getFechaInicio() != null)
                buf.append(" AND periodo.fec_inic >= to_date('" + dto.getFechaInicio() + "', 'yyyy-mm-dd') ");

            if(dto.getFechaFin() != null)
                buf.append(" AND periodo.fec_fina <=to_date('" + dto.getFechaFin() + "', 'yyyy-mm-dd')");
                //buf.append(" AND periodo.fec_fina = to_date('" + dto.getFechaFin() + "', 'yyyy-mm-dd') ");

            if(dto.getStatus() != null) {
                if(dto.getStatus().booleanValue())
                    buf.append(" AND periodo.val_esta = 1 ");
                else
                    buf.append(" AND periodo.val_esta = 0 ");
            }

			buf.append(" ORDER BY val_nomb_peri ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodoAnioAcceso(DTOPeriodo dto):Salida");
        return new DTOSalida(respuesta);
    }
     
     
      
     

    /**
     * Obtiene los periodos filtrando por codigo de periodo corporativo.
     * @author gdmarzi
     */
    public DTOPeriodo obtienePeriodoPorCodigo(String codigo, String tipo)  throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodoPorCodigo(String codigo, String tipo):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        String whereString;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" select P.OID_PERI, P.VAL_NOMB_PERI, P.CANA_OID_CANA, P.MARC_OID_MARC, ");
            query.append(" P.PAIS_OID_PAIS, P.ACCE_OID_ACCE, P.PERI_OID_PERI, P.FEC_INIC, P.FEC_FINA, P.VAL_ESTA, ");
            query.append(" PC.COD_PERI, PC.TIPE_OID_TIPO_PERI, TP.COD_TIPO_PERI ");
            query.append(" from CRA_PERIO P, SEG_PERIO_CORPO PC, SEG_TIPO_PERIO TP");
            //condiciones para el where
            whereString = UtilidadesBD.armarSQLWhere(new String[] {"PC.COD_PERI", "TP.COD_TIPO_PERI"}, new Object[] {codigo, tipo},
                    new boolean[] {false, false});
            query.append(whereString);

            if(whereString.length() == 0)
                query.append(" where ");
            else
                query.append(" and ");

            //join entre tablas
            query.append(" P.PERI_OID_PERI = PC.OID_PERI ");
            query.append(" and TP.OID_TIPO_PERI = PC.TIPE_OID_TIPO_PERI ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //Armamos el dtoPeriodo a ser retornado
        dtoPeriodo.setOid(new Long(((BigDecimal)respuesta.getValueAt(0, "OID_PERI")).toString()));
        dtoPeriodo.setPais(new Long(((BigDecimal)respuesta.getValueAt(0, "PAIS_OID_PAIS")).toString()));
        dtoPeriodo.setMarca(new Long(((BigDecimal)respuesta.getValueAt(0, "MARC_OID_MARC")).toString()));
        dtoPeriodo.setCanal(new Long(((BigDecimal)respuesta.getValueAt(0, "CANA_OID_CANA")).toString()));
        dtoPeriodo.setAcceso(new Long(((BigDecimal)respuesta.getValueAt(0, "ACCE_OID_ACCE")).toString()));
        dtoPeriodo.setOidPeriodoCorporativo(new Long(((BigDecimal)respuesta.getValueAt(0, "PERI_OID_PERI")).toString()));
        dtoPeriodo.setFechaInicio((Date)respuesta.getValueAt(0, "FEC_INIC"));
        dtoPeriodo.setFechaFin((Date)respuesta.getValueAt(0, "FEC_FINA"));
        dtoPeriodo.setNombre((String)respuesta.getValueAt(0, "VAL_NOMB_PERI"));
        dtoPeriodo.setTipo(new Long(((BigDecimal)respuesta.getValueAt(0, "TIPE_OID_TIPO_PERI")).toString()));
        dtoPeriodo.setCodigoTipoPeriodo((String)respuesta.getValueAt(0, "COD_TIPO_PERI"));
        dtoPeriodo.setCodigoPeriodo((String)respuesta.getValueAt(0, "COD_PERI"));
        dtoPeriodo.setDuracion(new Integer((this.dayDiff(dtoPeriodo.getFechaInicio(), dtoPeriodo.getFechaFin())).intValue() + 1));

        if(respuesta.getValueAt(0, "VAL_ESTA") != null) {
            if(((BigDecimal)respuesta.getValueAt(0, "VAL_ESTA")).intValue() == 1)
                dtoPeriodo.setStatus(new Boolean("true"));
            else
                dtoPeriodo.setStatus(new Boolean("false"));
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodoPorCodigo(String codigo, String tipo):Salida");
        return dtoPeriodo;
    }

    /**
     * Devuelve los dias de diferencia entre dos fechas
     */
    private Integer dayDiff(java.sql.Date fecha1, java.sql.Date fecha2) {
        //la cantidad de milisegundos en un dia
        long oneDayMillis = 1000 * 60 * 60 * 24;

        //pasamos el resultado a dias
        int dayDifference = (int)((fecha1.getTime() - fecha2.getTime()) / oneDayMillis);
        return new Integer(dayDifference);
    }

    /**
     * main
     */
    public static void main(String[] args) throws MareException {
        DAOCRA dao = new DAOCRA();

        DTOPeriodo dto = new DTOPeriodo();
        dto.setCanal(new Long(1));
        dto.setMarca(new Long(1));
        dto.setPais(new Long(1));
        dto.setFechaInicio(new Date(System.currentTimeMillis()));

        dao.obtienePeriodosFecha(dto);
    }

    public DTOSalida obtienePeriodosFecha(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodosFecha(DTOPeriodo dto):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("SELECT  p.oid_peri as oid,  p.val_nomb_peri as nombre, ");
            query.append(" p.FEC_INIC as FECHAINICIO,  p.FEC_FINA as FECHAFIN ");
            query.append(" FROM  cra_perio p WHERE");
            query.append(" p.pais_oid_pais = " + dto.getPais());
            query.append(" AND p.marc_oid_marc = " + dto.getMarca());
            query.append(" AND p.cana_oid_cana = " + dto.getCanal());
            query.append(" AND p.fec_inic <= to_date('" + dto.getFechaInicio() + "', 'yyyy-mm-dd')");
            query.append(" AND p.fec_fina >= to_date('" + dto.getFechaInicio() + "', 'yyyy-mm-dd')");
            query.append(" ORDER BY p.fec_inic ASC ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(respuesta.esVacio())
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));

        dtoSalida.setResultado(respuesta);
        UtilidadesLog.info("DAOCRA.obtienePeriodosFecha(DTOPeriodo dto):Salida");
        return dtoSalida;
    }

    /** Obtiene todos los feriados para un grupo, actividad y fecha. **/
    public DTOSalida obtienePeriodoPMCCodigo(DTOPeriodo dto)
        throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodoPMCCodigo(DTOPeriodo dto):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" p.oid_peri as oid, ");
            query.append(" p.marc_oid_marc as marca, ");
            query.append(" p.cana_oid_cana as canal, ");
            query.append(" p.pais_oid_pais as pais, ");
            query.append(" p.acce_oid_acce as acceso, ");
            query.append(" p.peri_oid_peri as periodocorporativo, ");
            query.append(" p.fec_inic as fechaini, ");
            query.append(" p.fec_fina as fechafin, ");
            query.append(" p.val_esta as estado, ");
            query.append(" p.val_nomb_peri as nombre, ");
            query.append(" p.ind_peri_cort as escorto, ");
            query.append(" p.ind_peri_cruc escruce ");
            query.append(" FROM cra_perio p, seg_perio_corpo pc ");
            query.append(" WHERE pc.oid_peri = p.peri_oid_peri ");
            query.append(" AND pc.cod_peri = '" + dto.getCodigoPeriodo() + "' ");
            query.append(" AND p.marc_oid_marc = " + dto.getMarca());
            query.append(" AND p.cana_oid_cana = " + dto.getCanal());
            query.append(" AND p.pais_oid_pais = " + dto.getPais());

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(respuesta);
        UtilidadesLog.info("DAOCRA.obtienePeriodoPMCCodigo(DTOPeriodo dto):Salida");
        return dtoSalida;
    }

    /**
     * Retorna true si el dia(fecha) es laborable para la actividad y grupo determinado.
     * Un dia es laborable si no es festivo ni es no laborable.
     * El dia es laborable si NO hay ningun registro en la entidad cra_feria para esa actividad y grupo,
     * si aparece en cra_feria es por que es festivo(ind_fest=1) o es no laborable (ind_no_lab=1).
     * @autor gdmarzi
     */
    public boolean verificaLaborablePorGAF(Long grupo, Long actividad, Date fecha) throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneLaborablePorGAF(Long grupo, Long actividad, Date fecha):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        boolean laborable;

        SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
        String sFecha = miFecha.format(fecha);

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT * ");
            query.append(" FROM cra_feria f");
            query.append(" WHERE f.cgzo_oid_cabe_grup_zona  = " + grupo);
            query.append(" AND f.cact_oid_acti = " + actividad);
            query.append(" AND TO_CHAR(f.fec_feri, 'DD/MM/YYYY') = '" + sFecha + "' ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (respuesta.esVacio()){
            laborable = true;
        }else{
            laborable = false;
        }
        UtilidadesLog.info("DAOCRA.obtieneLaborablePorGAF(Long grupo, Long actividad, Date fecha):Salida");
        return laborable;
    }

    
    /**
     * Retorna true si el dia(fecha) es feriado para la actividad y grupo determinado.
     * Un dia es festivo(feriado) cuando esta en la entidad CRA_FERIA con el indicador IND_FEST en 1, para un grupo y actividad.
     * @correccion se considera feriado (festivo) solo los dias feriados (IND_FEST en 1 en CRA_FERIA),
     * sin considerar los dias no laborables (sabados y domingos) marcados en CRA_FERIA con el indicador IND_NO_LAB en 1.
     * @autor gdmarzi
     */
    public boolean verificaFeriadoPorGAF(Long grupo, Long actividad, Date fecha) throws MareException {
        UtilidadesLog.info("DAOCRA.verificaFeriadoPorGAF(Long grupo, Long actividad, Date fecha):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        boolean feriado;

        SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
        String sFecha = miFecha.format(fecha);

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT * ");
            query.append(" FROM cra_feria f");
            query.append(" WHERE f.cgzo_oid_cabe_grup_zona  = " + grupo);
            query.append(" AND f.cact_oid_acti = " + actividad);
            query.append(" AND TO_CHAR(f.fec_feri, 'DD/MM/YYYY') = '" + sFecha + "' ");
            query.append(" AND ind_fest = 1 ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (respuesta.esVacio()){
            feriado = false;
        }else{
            feriado = true;
        }
        UtilidadesLog.info("DAOCRA.verificaFeriadoPorGAF(Long grupo, Long actividad, Date fecha):Salida");
        return feriado;
    }


    public RecordSet obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona)
        throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona):Entrada");
        //Obtiene los grupos de zonas por pais, marca, canal y zona (detalle).
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT c.oid_cabe_grup_zona as oid ");
            query.append(" FROM cra_cabec_grupo_zona c, cra_detal_grupo_zona d ");
            query.append(" WHERE (    (c.oid_cabe_grup_zona = d.cgzo_oid_cabe_grup_zona) ");
            query.append("         AND (c.pais_oid_pais = " + oidPais + ")");
            query.append("         AND (c.marc_oid_marc = " + oidMarca + ")");
            query.append("         AND (c.cana_oid_cana = " + oidCanal + ")");
            query.append("         AND (d.zzon_oid_zona = " + oidZona + "))");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtieneGrupoPMCZ(Long oidPais, Long oidMarca, Long oidCanal, Long oidZona):Salida");
        return respuesta;
    }

    public Long obtienePeriodoSiguiente(Long oidPeriodo) throws MareException {
        //Obtiene el período siguiente al ingresado, si no hay respuesta devuelve null
        UtilidadesLog.info("DAOCRA.obtienePeriodoSiguiente(Long oidPeriodo):Entrada");
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            query.append(" SELECT B.oid_peri oid ");
            query.append(" FROM cra_perio A, cra_perio B ");
            query.append(" WHERE A.oid_peri = " + oidPeriodo);
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic > A.fec_inic ");
            query.append(" ORDER BY B.fec_inic ");                        

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(!respuesta.esVacio()){
            Long resp = new Long(((BigDecimal) respuesta.getValueAt(0,0)).longValue());
            UtilidadesLog.info("DAOCRA.obtienePeriodoSiguiente(Long oidPeriodo):Salida");
            return resp;
        }else {
            UtilidadesLog.info("DAOCRA.obtienePeriodoSiguiente(Long oidPeriodo):Salida");
            return null;
        }
    }

	    /**
     * Obtiene el periodo anterior a uno dado. 
     * 
     * Proceso 
     * ========= 
     * SELECT B.oid_peri oid 
     * 
     * FROM 
     * cra_perio A, 
     * cra_perio B 
     * 
     * WHERE 
     * A.oid_peri = oidPeriodo AND 
     * B.pais_oid_pais = A.pais_oid_pais AND 
     * B.marc_oid_marc = A.marc_oid_marc AND 
     * B.cana_oid_cana = A.cana_oid_cana AND 
     * B.fec_inic < A.fec_inic AND 
     * ROWNUM <= 1 
     * 
     * ORDER BY B.fec_inic DESC 
     * 
     * Se retorna oid. 
     */
    public Long obtienePeriodoAnterior (Long lngOidPeriodo) throws MareException {
      UtilidadesLog.info("DAOCRA.obtienePeriodoAnterior (Long lngOidPeriodo):Entrada");

      BelcorpService bs;
			StringBuffer query = new StringBuffer();
			 try {
		    	 bs = BelcorpService.getInstance();
			 } catch (MareException e) {
                UtilidadesLog.error(e);
			     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			 }
		
			 try {

			    query.append(" SELECT B.oid_peri oid ");
				query.append(" FROM cra_perio A, cra_perio B ");
				query.append(" WHERE A.oid_peri = " + lngOidPeriodo + " AND ");
				query.append(" B.pais_oid_pais = A.pais_oid_pais AND ");
				query.append(" B.marc_oid_marc = A.marc_oid_marc AND ");
				query.append(" B.cana_oid_cana = A.cana_oid_cana AND ");
				//query.append(" B.fec_inic < A.fec_inic AND ");
                query.append(" B.fec_inic < A.fec_inic ");
				//query.append(" ROWNUM <= 1 ");
				query.append(" ORDER BY B.fec_inic DESC  ");

				RecordSet rs = new RecordSet();

			    rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
    		    bs = null;
				Long lngOidPeri =  new Long(0);
    		    if (rs.esVacio()) {
                    UtilidadesLog.info("DAOCRA.obtienePeriodoAnterior (Long lngOidPeriodo):Salida");
			    	return lngOidPeri;
			    } else {

          			lngOidPeri = new Long(((BigDecimal) rs.getValueAt(0, "oid")).longValue());
          
					UtilidadesLog.info("DAOCRA.obtienePeriodoAnterior (Long lngOidPeriodo):Salida");
		        	return lngOidPeri;
		     	}

			} catch (Exception e) {
                UtilidadesLog.error(e);
				if (e instanceof MareException) {
					//((MareException)e).getOriginalCause().printStackTrace();
					throw(MareException)e;
				} else {
					throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}
			}
        

    }


    public Long obtieneOrigenCronogramaGrupoZonas (Long oidMatriz) throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneOrigenCronogramaGrupoZonas (Long oidMatriz):Entrada");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();

            buf.append(" SELECT MDO.OID_MATR_DIAS oid ");
            buf.append(" FROM CRA_MATRI_DIAS MD, CRA_MATRI_DIAS MDO ");
            buf.append(" WHERE MD.CGZO_OID_CABE_GRUP_ZONA = MDO.CGZO_OID_CABE_GRUP_ZONA ");
            buf.append(" AND MD.CACT_OID_ACTI_ORIG = MDO.CACT_OID_ACTI ");
            buf.append(" AND MD.OID_MATR_DIAS = " + oidMatriz + " ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(rs.esVacio())
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));

        Long oidOrigen = new Long(((BigDecimal) rs.getValueAt(0, "oid")).toString());
        UtilidadesLog.info("DAOCRA.obtieneOrigenCronogramaGrupoZonas (Long oidMatriz):Salida");
        return oidOrigen;
    }

    public Long obtieneOrigenCronograma (Long oidCrono) throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneOrigenCronograma (Long oidCrono):Entrada");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();

            buf.append(" SELECT CRO.OID_CRON_GRUP_ZONA oid ");
            buf.append(" FROM CRA_CRONO_GRUPO_ZONA CR, CRA_CRONO_GRUPO_ZONA CRO ");
            buf.append(" WHERE CR.CGZO_OID_CABE_GRUP_ZONA = CRO.CGZO_OID_CABE_GRUP_ZONA ");
            buf.append(" AND CR.PERD_OID_PERI = CRO.PERD_OID_PERI ");
            buf.append(" AND CR.COD_VIST_ORIG = CRO.COD_VIST ");
            buf.append(" AND CR.OID_CRON_GRUP_ZONA = " + oidCrono + " ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(rs.esVacio())
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));

        Long oidOrigen = new Long(((BigDecimal) rs.getValueAt(0, "oid")).toString());
        UtilidadesLog.info("DAOCRA.obtieneOrigenCronograma (Long oidCrono):Salida");
        return oidOrigen;
    }

    /**
     * obtieneFechasCronograma. Incidencia 8235.
     * Obtiene las Fecha Iniciales y Finales en función de los parámetros de entrada.
     * Parámetros e/s
     * Entrada: oidPais, oidMarca, oidCanal, oidPeriodo y oidZona
     * Salida: RecordSet
	 * NOTA: Según la inc. 8235 este método se encontraba en DAOCronograma
	 *       y DT resolvió ponerlo en DAOCRA 
     */
     
    /**    
     *@Author: pperez 
     *@Fecha: 18/08/2005
     *@throws: 
     *@return: 
     *@param: Se agrego un parametro: 
     *@Observaciones: 
    */ 
    public DTOSalida obtieneFechasCronograma(
	Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidZona, Long oidActividad) throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneFechasCronograma(	Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidZona, Long oidActividad):Entrada");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        //Proceso
        query.append("SELECT c.FEC_INIC, FEC_MEDI, c.FEC_FINA "); 
        query.append("FROM ");
        query.append("    CRA_CRONO c, "); 
        query.append("    CRA_PERIO p ");
        query.append("WHERE ");
        //joins
        query.append("    c.PERD_OID_PERI = p.OID_PERI AND "); 
        //criterios filtro
        query.append("    p.PAIS_OID_PAIS = "+ oidPais +" AND ");
        query.append("    p.MARC_OID_MARC = "+ oidMarca +" AND ");
        query.append("    p.CANA_OID_CANA = "+ oidCanal +" AND ");
        query.append("    p.OID_PERI = "+ oidPeriodo +" AND ");
        query.append("    c.ZZON_OID_ZONA = "+ oidZona );
        query.append("    AND c.CACT_OID_ACTI =  "+ oidActividad );

          
        RecordSet rs = new RecordSet();

        try {
            bs = BelcorpService.getInstance();
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtieneFechasCronograma(	Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo, Long oidZona, Long oidActividad):Salida");
        return new DTOSalida(rs);
    }


    /**
     * Elimina los feriados de un calendario.
     * @autor gdmarzi
     */
    public void eliminaFeriados(Long oidPais, Long oidMarca, Long oidCanal, Integer anio) throws MareException {
        UtilidadesLog.info("DAOCRA.eliminaFeriados(Long oidPais, Long oidMarca, Long oidCanal, Integer anio):Entrada");
		String codigoError;
		BelcorpService belcorpService;        
		StringBuffer query = new StringBuffer();        

		try {
			belcorpService = BelcorpService.getInstance();
		} catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
			codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
			throw new MareException(serviceNotFoundException, 
                                UtilidadesError.armarCodigoError(codigoError));
		}

        try {
            query.append(" DELETE CRA_FERIA F ");
            query.append(" WHERE ");
            query.append(" NUM_ANIO = " + anio.intValue() );
            query.append(" AND CGZO_OID_CABE_GRUP_ZONA IN ( ");
            query.append("   SELECT OID_CABE_GRUP_ZONA ");
            query.append("   FROM CRA_CABEC_GRUPO_ZONA GZ ");
            query.append("   WHERE GZ.OID_CABE_GRUP_ZONA = F.CGZO_OID_CABE_GRUP_ZONA ");
            query.append("   AND GZ.PAIS_OID_PAIS = " + oidPais.longValue() );
            query.append("   AND GZ.MARC_OID_MARC = " + oidMarca.longValue() );
            query.append("   AND GZ.CANA_OID_CANA = " + oidCanal.longValue() + " )");

			belcorpService.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOCRA.eliminaFeriados(Long oidPais, Long oidMarca, Long oidCanal, Integer anio):Salida");
        } catch(MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }
    
    
    /**
     * 
     * @autor eyache
     */
    public DTOSalida buscarFechasFacPorZona(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCRA.buscarFechasFacPorZona(DTOOID dto):Entrada");
        BelcorpService bs;        
        RecordSet rs = new RecordSet();        
        StringBuffer query = new StringBuffer();        
    
        try {
              query.append(" SELECT ZON.OID_ZONA ZONA, ");
              query.append(" 	     CRA.FEC_INIC FECHA_FACTURACION ");
              query.append(" FROM CRA_CRONO CRA, ");
              query.append(" 	 ZON_ZONA ZON, ");
              query.append(" 	 CRA_ACTIV ACT, ");
              query.append(" 	 CRA_CLASE_ACTIV CLASE ");
              query.append(" WHERE CRA.ZZON_OID_ZONA (+) = ZON.OID_ZONA ");
              query.append("   AND ACT.OID_ACTI = CRA.CACT_OID_ACTI ");
              query.append("   AND CLASE.OID_CLAS_ACTI = ACT.CLAC_OID_CLAS_ACTI ");
              query.append("   AND CLASE.COD_CLAS_ACTI = '" + ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION +  "' ");
              query.append("   AND CRA.PERD_OID_PERI = " + dto.getOid() + " ");

              bs = BelcorpService.getInstance();
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
    
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.buscarFechasFacPorZona(DTOOID dto):Salida");
        return new DTOSalida(rs);
    }   
    
    /*Marta Aurora Montiel - 22/03/05
     * Incidencia BELC300015141
     * */
     public DTOSalida obtienePeriodosPosteriores(Long oidPais, Long oidMarca, Long oidCanal) throws MareException {
            UtilidadesLog.info("DAOCRA.obtienePeriodosPosteriores(Long oidPais, Long oidMarca, Long oidCanal):Entrada");
            BelcorpService bs;        
            RecordSet rs = new RecordSet();        
            StringBuffer query = new StringBuffer();        
        
            try {
                  query.append(" SELECT P.OID_PERI OID_PERIODO, PC.COD_PERI CODIGO ");
                  query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
                  query.append(" WHERE P.PAIS_OID_PAIS = " + oidPais );
                  query.append(" AND P.MARC_OID_MARC = " + oidMarca );
                  query.append(" AND P.CANA_OID_CANA = " + oidCanal );
                  query.append(" AND P.FEC_INIC > SYSDATE " );
                  query.append(" AND P.PERI_OID_PERI = PC.OID_PERI  ");
                  
                  // Agregado por ssantana, 28/7/2005
                  query.append(" order by 2 ");
                  // Fin agregado ssantana, 28/7/2005
                  
                  bs = BelcorpService.getInstance();
                  rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        
            } catch (MareException me) {
                UtilidadesLog.error(me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.info("DAOCRA.obtienePeriodosPosteriores(Long oidPais, Long oidMarca, Long oidCanal):Salida");
            return new DTOSalida(rs);
      
      }
      
    public DTOSalida obtenerPeriodoAnioAnterior(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtenerPeriodoAnioAnterior(DTOPeriodo dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
       
      query.append(" SELECT S.COD_PERI, ");
      query.append(" S.VAL_ANIO, ");
      query.append(" C.PAIS_OID_PAIS, ");
      query.append(" C.MARC_OID_MARC, ");
      query.append(" C.CANA_OID_CANA, ");
      query.append(" C.PERI_OID_PERI ");
      query.append(" FROM CRA_PERIO C, ");
      query.append(" SEG_PERIO_CORPO S ");
      query.append(" WHERE C.OID_PERI = " + dto.getOid());
      query.append(" AND S.OID_PERI = C.PERI_OID_PERI ");
    
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }           
      
      if(!rs.esVacio()){
        String codigo = (String) rs.getValueAt(0, "COD_PERI");
        BigDecimal anio = (BigDecimal) rs.getValueAt(0, "VAL_ANIO");
        BigDecimal pais = (BigDecimal) rs.getValueAt(0, "PAIS_OID_PAIS");
        BigDecimal marca = (BigDecimal) rs.getValueAt(0, "MARC_OID_MARC");
        BigDecimal canal = (BigDecimal) rs.getValueAt(0, "CANA_OID_CANA");
        BigDecimal peri = (BigDecimal) rs.getValueAt(0, "PERI_OID_PERI");
        
        //Obtengo el año menos 1
        BigDecimal anioMenosUno = new BigDecimal(anio.longValue() - 1);
        
        //Obtengo los dos ultimos caracteres del codigo
        int inicio = codigo.length()-2;
        int fin = codigo.length();			
        String ultimosDosDigitosCodigo = codigo.substring(inicio, fin);
        
        //Genero periodo anterior
        StringBuffer periodoAnterior = new StringBuffer();
        periodoAnterior.append(anioMenosUno.toString());
        periodoAnterior.append(ultimosDosDigitosCodigo);
        
        StringBuffer query2 = new StringBuffer();
        RecordSet rs2 = new RecordSet(); 
        
        query2.append(" SELECT C.OID_PERI, ");
        query2.append(" C.VAL_NOMB_PERI, ");
        query2.append(" S.COD_PERI ");
        query2.append(" FROM CRA_PERIO C, ");
        query2.append(" SEG_PERIO_CORPO S ");
        query2.append(" WHERE COD_PERI = '" + periodoAnterior.toString() + "' ");
        query2.append(" AND S.OID_PERI = C.PERI_OID_PERI ");
        query2.append(" AND c.PAIS_OID_PAIS = " + pais.toString());
        query2.append(" AND c.MARC_OID_MARC = " + marca.toString());
        query2.append(" AND c.CANA_OID_CANA = " + canal.toString());
        
        try {
          rs2 = (RecordSet) bs.dbService.executeStaticQuery(query2.toString());    
        }
        catch (Exception e) {
           UtilidadesLog.error(e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }          
        
        if(!rs2.esVacio()) dtos.setResultado(rs2);  
        else dtos.setResultado(null);    
      }
      else {
        dtos.setResultado(null);
      }
      
      UtilidadesLog.info("DAOCRA.obtenerPeriodoAnioAnterior(DTOPeriodo dto):Salida");
      return dtos;           
   }
   
  public DTOSalida obtienePeriodosPosterioresFechaActual(DTOID dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtienePeriodosPosterioresFechaActual(DTOID dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      query.append(" SELECT	P.OID_PERI OID_PERIODO, P.VAL_NOMB_PERI ");
      query.append(" FROM CRA_PERIO P ");
      query.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
      query.append(" AND P.MARC_OID_MARC = " + dto.getMarca());
      query.append(" AND P.CANA_OID_CANA = " + dto.getCanal());
      query.append(" AND P.FEC_INIC > SYSDATE ");
      query.append(" ORDER BY P.VAL_NOMB_PERI ");
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }           
      
      if(!rs.esVacio()){          
        dtos.setResultado(rs);
      }
      else {
        dtos.setResultado(null);
      }
      
      UtilidadesLog.info("DAOCRA.obtienePeriodosPosterioresFechaActual(DTOID dto):Salida");
      return dtos;      
  }
  
   	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       04/08/2005
	 * @version     
	 * @autor       mmaidana
	 */
    public DTOSalida obtenerTipoFacturacion(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerTipoFacturacion(DTOOID dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOSalida dtos = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
        if (dto != null && dto.getOid() != null){
            query.append("SELECT CGZ.TIFA_OID_TIPO_FACT ");
            query.append("FROM CRA_CABEC_GRUPO_ZONA CGZ ");
            query.append("WHERE CGZ.OID_CABE_GRUP_ZONA = " + dto.getOid());
            
            try {
                rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
      
            if (!rs.esVacio()){          
                dtos.setResultado(rs);
            } else {
                dtos.setResultado(null);
            }
        }
        UtilidadesLog.info("DAOCRA.obtenerTipoFacturacion(DTOOID dto):Salida");
        return dtos;
    }
  
  
    /**    
     *@Author: pperez 
     *@Fecha: 17/08/2005
     *@throws: MareException
     *@return: RecordSet
     *@param: Long oidZona, Long oidPeriodo
     *@Observaciones: Incidencia BELC300011135
    */ 
    
    public RecordSet obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo) throws MareException {
        
        UtilidadesLog.info("DAOCRA.obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append("   SELECT cra.fec_inic fecha ");
        query.append("     FROM cra_crono cra, cra_activ act, cra_clase_activ clase   ");
        query.append("    WHERE cra.zzon_oid_zona =  " + oidZona);
        query.append("      AND act.oid_acti = cra.cact_oid_acti   ");
        query.append("      AND clase.oid_clas_acti = act.clac_oid_clas_acti   ");
        query.append("      AND CLASE.COD_CLAS_ACTI = '" + ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION + "' ");
        query.append("      AND cra.perd_oid_peri =  " + oidPeriodo);
        query.append("      ORDER BY fecha ASC  ");
        
        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }           
        UtilidadesLog.info("Finalizo el metodo obtenerFechasFacturacionPorPeriodoZona del DAOCRA ");
        UtilidadesLog.info("DAOCRA.obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo):Salida");
        return rs;      
    }  

    
     public Long obtenerPrimerPeriodoREP(DTOBelcorp dto) throws MareException {
        
        UtilidadesLog.info("DAOCRA.obtenerPrimerPeriodoREP(DTOBelcorp): Entrada");
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
          Date fecha = new Date(System.currentTimeMillis());
        
          SimpleDateFormat miFecha = new SimpleDateFormat("yyyy");
          String sAnio = miFecha.format(fecha);
                
          query.append(" SELECT periodos.oid_peri ");
          query.append(" FROM (SELECT cp.oid_peri, cp.fec_inic ");
          query.append(" FROM cra_perio cp, seg_perio_corpo pc ");
          query.append(" WHERE cp.peri_oid_peri = pc.oid_peri ");
          query.append(" AND pc.val_anio = " + sAnio);
          query.append(" AND cp.pais_oid_pais = " + dto.getOidPais() +") periodos ");
          query.append(" WHERE ROWNUM = 1 ");
          respuesta = bs.dbService.executeStaticQuery(query.toString());
          
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(!respuesta.esVacio()){
            Long resp = new Long(((BigDecimal) respuesta.getValueAt(0,0)).longValue());
            UtilidadesLog.info("DAOCRA.obtenerPrimerPeriodoREP(DTOBelcorp): Salida");
            return resp;
        }else {
             UtilidadesLog.info("DAOCRA.obtenerPrimerPeriodoREP(DTOBelcorp): Salida");
            return null;
        }
    }
    
    public DTOBoolean validaPeriodosREP(DTOOIDs dto) throws MareException{
        UtilidadesLog.info("DAOCRA.validaPeriodosREP(DTOOIDs dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOBoolean dtoB = new DTOBoolean();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        Long[] oids = dto.getOids();
             
        query.append(" SELECT CASE ");
        query.append(" WHEN (per.fec_inic <= per2.fec_inic) ");
        query.append(" THEN 1 ");
        query.append(" ELSE 0 ");
        query.append(" END mayor ");
        query.append(" FROM cra_perio per, cra_perio per2 ");
        query.append(" WHERE per.oid_peri = " + oids[0]);
        query.append(" AND per2.oid_peri = " + oids[1]);   
            
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        Long indicador = new Long(rs.getValueAt(0,0).toString());
        
        if(indicador.intValue() == 1){
           dtoB.setValor(true);
        }else{
           dtoB.setValor(false);
        }
             
                    
        UtilidadesLog.info("DAOCRA.validaPeriodosREP(DTOOIDs dto):Salida");
        return dtoB;
    }
    
    public Long obtienePeriodoAnteriorActual(Long oidPeriodoActual) throws MareException {
        UtilidadesLog.info("DAOCRA.obtienePeriodoAnteriorActual(Long oidPeriodoActual):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT * FROM ( ");
        query.append(" SELECT   b.oid_peri OID, pc.cod_peri codigo ");
        query.append(" FROM cra_perio a, cra_perio b, seg_perio_corpo pc ");
        query.append(" WHERE a.oid_peri = "+oidPeriodoActual);
        query.append(" AND b.pais_oid_pais = a.pais_oid_pais ");
        query.append(" AND b.marc_oid_marc = a.marc_oid_marc ");
        query.append(" AND b.cana_oid_cana = a.cana_oid_cana ");
        query.append(" AND b.fec_inic < a.fec_inic ");
        query.append(" AND b.peri_oid_peri = pc.oid_peri ");
        query.append(" ORDER BY b.fec_inic desc ");
        query.append(" ) where ROWNUM <= 1" );
            
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
      
        Long retorna = null;
        if (!rs.esVacio() && rs.getValueAt(0,"OID") !=null){          
            retorna = new Long(rs.getValueAt(0,"OID").toString());
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodoAnteriorActual(Long oidPeriodoActual):Entrada");
        return retorna;
    
    }
    
     /**    
     *@Author: cvalenzu
     *@Fecha: 02/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
     *Modificado: Cristian Valenzuela
     *Incidencia: DBLG500000867
    */ 
    
    public DTOSalida obtenerPeriodosPosterioresActual(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtenerPeriodosPosterioresActual(DTOPeriodo dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();      
      
      query.append(" SELECT PERI.oid_peri OID, PERI.val_nomb_peri DESCRIP  ");
      query.append(" FROM cra_perio PERI  ");
      query.append(" WHERE PERI.marc_oid_marc = " + dto.getMarca());
      query.append(" AND PERI.pais_oid_pais = " + dto.getPais());
      query.append(" AND PERI.cana_oid_cana = " + dto.getCanal());
      query.append(" AND PERI.val_esta = 1  ");
      query.append(" AND SYSDATE < PERI.fec_inic ");
      query.append(" ORDER BY PERI.val_nomb_peri ASC  ");
    
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }                
      
      dtos.setResultado(rs);      
      
      UtilidadesLog.info("DAOCRA.obtenerPeriodosPosterioresActual(DTOPeriodo dto):Salida");
      return dtos;           
   }
   
    /**    
     *@Author: cvalenzu
     *@Fecha: 02/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOPeriodo
    */ 
    
    public DTOSalida obtenerPeriodosPosterioresActivos(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtenerPeriodosPosterioresActivos(DTOPeriodo dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
     query.append(" SELECT PERI.oid_peri OID, PERI.val_nomb_peri DESCRIP ");
     query.append(" FROM cra_perio PERI ");
     if(dto.getOid()!=null){
       query.append(" , cra_perio PERI_PARAM  ");
     }
     query.append(" WHERE PERI.marc_oid_marc = " + dto.getMarca());
     query.append(" AND PERI.pais_oid_pais = " + dto.getPais());
     query.append(" AND PERI.cana_oid_cana = " + dto.getCanal());
     query.append(" AND PERI.val_esta = 1  ");
     if(dto.getOid()!=null){
       query.append(" AND PERI_PARAM.oid_peri = " + dto.getOid());
       query.append(" AND PERI_PARAM.fec_inic <= PERI.fec_inic  ");
     }else{
       query.append(" AND PERI.fec_fina >= SYSDATE ");
     }
     query.append(" ORDER BY PERI.val_nomb_peri ASC ");
    
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }                
      
      dtos.setResultado(rs);      
      
      UtilidadesLog.info("DAOCRA.obtenerPeriodosPosterioresActivos(DTOPeriodo dto):Salida");
      return dtos;           
   }
   
    /**    
     *@Autor: cvalenzu
     *@Fecha: 23/05/2006
     *@throws: MareException
     *@return: DTOSalida
     *@param: DTOOIDs
    */ 
    
    public DTOSalida obtenerPeriodosEntre(DTOOIDs dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtenerPeriodosEntre(DTOOIDs dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      Long[] oids = dto.getOids();
      Long oidPerInicio = oids[0];
      Long oidPerFin = oids[1];
      
      query.append(" SELECT PERI.oid_peri OID, PERI.val_nomb_peri DESCRIP ");
      query.append(" FROM cra_perio PERI, cra_perio PERI_INI, cra_perio PERI_FIN  ");
      query.append(" WHERE PERI_INI.oid_peri = " + oidPerInicio);
      query.append(" AND PERI_FIN.oid_peri = " + oidPerFin);
      query.append(" AND PERI.marc_oid_marc = PERI_INI.marc_oid_marc  ");
      query.append(" AND PERI.pais_oid_pais = PERI_INI.pais_oid_pais  ");
      query.append(" AND PERI.cana_oid_cana = PERI_INI.cana_oid_cana  ");
      query.append(" AND PERI.val_esta = 1  ");
      query.append(" AND PERI_INI.fec_inic <= PERI.fec_inic  ");
      query.append(" AND PERI.fec_fina <= PERI_FIN.fec_fina  ");
      query.append(" ORDER BY PERI.val_nomb_peri ASC ");
    
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }                
      
      dtos.setResultado(rs);      
      
      UtilidadesLog.info("DAOCRA.obtenerPeriodosEntre(DTOOIDs dto):Salida");
      return dtos;           
   }
   
   
   
   
   
/**
   * Creado por incidencia 10913
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   */
     public DTOSalida obtieneActividadesPorTipoSolicitud(DTOOID dto) throws MareException {
        
      UtilidadesLog.info("DAOCRA.obtieneActividadesPorTipoSolicitud(DTOOID dto):Entrada");
      DTOSalida dtos = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
  
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
        query.append(" SELECT C.OID_ACTI , (C.COD_ACTI || ' ' ||  G.VAL_I18N) AS descripcion");
        query.append(" FROM CRA_ACTIV C, GEN_I18N_SICC G, PED_TIPO_SOLIC TS, SEG_ACCES ACC");
        query.append(" WHERE	TS.OID_TIPO_SOLI = " + dto.getOid());
        query.append(" AND C.PAIS_OID_PAIS =  " + dto.getOidPais());
        query.append(" AND C.MARC_OID_MARC = TS.MARC_OID_MARC"); 
        query.append(" AND TS.ACCE_OID_ACCE = ACC.OID_ACCE");
        query.append(" AND C.CANA_OID_CANA = ACC.CANA_OID_CANA");
        query.append(" AND C.OID_ACTI = G.VAL_OID");
        query.append(" AND G.ATTR_ENTI = 'CRA_ACTIV'");
        query.append(" AND G.ATTR_NUM_ATRI = 1");
        query.append(" AND G.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" ORDER BY 2 ");
        UtilidadesLog.info("Consulta SQL: " + query.toString());
        rs = bs.dbService.executeStaticQuery(query.toString());    
      }
      catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }                
      dtos.setResultado(rs);      
      UtilidadesLog.info("DAOCRA.obtieneActividadesPorTipoSolicitud(DTOOID dto):Salida");
      return dtos;           

    }
    
    public DTOSalida obtenerListaPeriodosPosterioresMAV(Long oidPais, Long oidMarca, Long oidCanal) throws MareException{
        UtilidadesLog.info("DAOCRA.obtienePeriodosPosterioresMAV(Long oidPais, Long oidMarca, Long oidCanal):Entrada");
        BelcorpService bs;        
        RecordSet rs = new RecordSet();        
        StringBuffer query = new StringBuffer();        
    
        try {
              query.append(" SELECT P.OID_PERI OID_PERIODO, PC.COD_PERI CODIGO ");
              query.append(" FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
              query.append(" WHERE P.PAIS_OID_PAIS = " + oidPais );
              query.append(" AND P.MARC_OID_MARC = " + oidMarca );
              query.append(" AND P.CANA_OID_CANA = " + oidCanal );
              query.append(" AND (P.FEC_INIC >= TRUNC(SYSDATE) ");
			        query.append(" OR (P.FEC_INIC <= TRUNC(SYSDATE) ");
			        query.append(" AND P.FEC_FINA >= TRUNC(SYSDATE))) "); 
              query.append(" AND P.PERI_OID_PERI = PC.OID_PERI  ");
              query.append(" order by 2 ");
              
              bs = BelcorpService.getInstance();
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
    
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtienePeriodosPosterioresMAV(Long oidPais, Long oidMarca, Long oidCanal):Salida");
        return new DTOSalida(rs);
  
         
    }
    
  public RecordSet obtenerPeriodosEntreFechas(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerPeriodosEntreFechas(DTOPeriodo dto):Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        query.append(" SELECT PERI.oid_peri OID, PERI.val_nomb_peri DESCRIP, ");
        query.append(" FEC_INIC FECHAINICIO, FEC_FINA FECHAFINAL ");
        query.append(" FROM cra_perio PERI ");
        query.append(" WHERE 1=1 ");
        if(dto.getMarca()!=null) {
            query.append(" AND PERI.marc_oid_marc = "+dto.getMarca().toString()+" ");    
        }
        if(dto.getOidPais()!=null){
            query.append(" AND PERI.pais_oid_pais = "+dto.getOidPais().toString()+" ");    
        }
        if(dto.getCanal()!=null){
            query.append(" AND PERI.cana_oid_cana = "+dto.getCanal().toString()+" ");    
        }
        if(dto.getAcceso()!=null){
            query.append(" AND PERI.ACCE_OID_ACCE = "+dto.getAcceso().toString()+" ");    
        }
        if(dto.getStatus()!=null ){
            if(dto.getStatus().booleanValue()){
                query.append(" AND PERI.val_esta = 1 ");
            }else{
                query.append(" AND PERI.val_esta = 0 ");
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        if(dto.getFechaInicio()!=null){
            java.sql.Date fechaIni = new java.sql.Date(dto.getFechaInicio().getTime());
            String sFechaIni = sdf.format(fechaIni);   
            query.append(" AND PERI.fec_inic >= to_date('"+sFechaIni+"','YYYY-MM-DD') ");
        }
        if(dto.getFechaFin()!=null){
            java.sql.Date fechaFin = new java.sql.Date(dto.getFechaFin().getTime());
            String sFechaFin = sdf.format(fechaFin);   
            query.append(" AND PERI.fec_fina <= to_date('"+sFechaFin+"','YYYY-MM-DD') ");
        }
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());    
        }
        catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }                
        UtilidadesLog.info("DAOCRA.obtenerPeriodosEntreFechas(DTOPeriodo dto):Salida");
        return rs;
   }  
   
   /**Fecha de Creación: 19/10/2006
    * Autor: Hugo Mansi
    * Incidencia: BELC300024295
    */
    public DTOSalida obtienePeriodosRecMasivos(DTOPeriodo dtoe) throws MareException{
        UtilidadesLog.info("DAOCRA.obtienePeriodosRecMasivos(DTOPeriodo dtoe):Entrada");    
    
        BelcorpService bs;        
        RecordSet rs = new RecordSet();        
        StringBuffer query = new StringBuffer();        
        DTOSalida dtoSalida = null;
        try {
        /*
                       SELECT c.oid_peri OID, c.val_nomb_peri 
              FROM cra_perio c 
              WHERE 1 = 1 
              AND c.cana_oid_cana = dto.get (canal) 
              AND c.marc_oid_marc = dto.get (marca) 
              AND c.pais_oid_pais = dto.get (oidPais) 
              AND ((trunc(c.fec_fina) - trunc(sysdate) ) + 1) = dto.get (duracion) 
              ORDER BY 2 
         */
        
              UtilidadesLog.info("dtoe " + dtoe);    
              query.append(" SELECT   c.oid_peri OID, c.val_nomb_peri	 ");
              query.append(" FROM cra_perio c	 ");
              query.append(" WHERE 1 = 1	 ");
              query.append("       AND c.cana_oid_cana = ").append(dtoe.getCanal());
              query.append("	     AND c.marc_oid_marc = ").append(dtoe.getMarca());
              query.append("	     AND c.pais_oid_pais = " ).append (dtoe.getOidPais());
              query.append("	     AND ((trunc(c.fec_fina) - trunc(sysdate) ) + 1) <= ").append(dtoe.getDuracion());
              query.append(" ORDER BY 2	 ");              
              bs = BelcorpService.getInstance();
              rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        
        if (rs.esVacio()){
            UtilidadesLog.error("*******DAOCRA.obtienePeriodosRecMasivos(DTOPeriodo dtoe): No hay datos ");
            throw new MareException("",
                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CRA,"",ErroresDeNegocio.NO_EXISTE_PERIODO_PARA_MARCA_CANAL_INDICADOS));       
        }
        
        dtoSalida = new DTOSalida();
       
        dtoSalida.setResultado(rs);
       
        UtilidadesLog.info("DAOCRA.obtienePeriodosRecMasivos(DTOPeriodo dtoe):Salida");   
       
        return dtoSalida;
    }/*Fin del Método*/   
   
   
   /**
    * Fecha de Creacion: 28/08/06
    * Autor: Viviana Bongiovanni
    * Inc DBLG500000222
    */
    public RecordSet obtenerPrimerUltimoPeriodoAnio(DTOCriteriosPeriodo dtoe) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerPrimerUltimoPeriodoAnio(DTOCriteriosPeriodo dtoe):Entrada");
        
        BelcorpService bs;        
        RecordSet rs = new RecordSet();        
        RecordSet rsResultado = new RecordSet();        
        StringBuffer query = new StringBuffer();        
    
        try {
              query.append(" SELECT peri.OID_PERI ");
              query.append(" FROM CRA_PERIO peri, SEG_PERIO_CORPO peco ");
              query.append(" WHERE peri.PERI_OID_PERI = peco.OID_PERI ");
              query.append(" AND peri.PAIS_OID_PAIS = " + dtoe.getOidPais());
              query.append(" AND peri.MARC_OID_MARC = " + dtoe.getMarca());
              query.append(" AND peri.CANA_OID_CANA = " + dtoe.getCanal());
              query.append(" AND peco.VAL_ANIO = " + dtoe.getAnio());
              query.append(" ORDER BY peri.FEC_INIC ");
              
              bs = BelcorpService.getInstance();
              rs = bs.dbService.executeStaticQuery(query.toString());
              
              rsResultado.setColumnIdentifiers(rs.getColumnIdentifiers());
              rsResultado.addRow(rs.getRow(0));
              rsResultado.addRow(rs.getRow(rs.getRowCount()-1));
              
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCRA.obtenerPrimerUltimoPeriodoAnio(DTOCriteriosPeriodo dtoe):Salida");
        return rsResultado;
    }
 
    /**
     * Retorna el formate de fecha segun el pais.
     */
    public String obtenerFormatoFechaPais(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOCargosAbonos.obtenerFormatoFechaPais() Entrada");
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" select val_form_fech from seg_pais p ");
        sQuery.append(" where p.oid_pais = " + oidPais);
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
				String formatoFecha = rs.getValueAt(0,"VAL_FORM_FECH").toString();
        formatoFecha = formatoFecha.replace('a','y');
        formatoFecha = formatoFecha.replace('m','M');
        UtilidadesLog.info("DAOCargosAbonos.obtenerFormatoFechaPais() Salida");
        return formatoFecha;
    }
    
    /**
     * Obtiene los periodos utilizando todos los filtros posibles segun el dtoPeriodo.
     */
    public DTOSalida obtieneFechasPeriodo(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtieneFechasPeriodo(DTOPeriodo dto):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;

        try {
            bs = BelcorpService.getInstance();

            buf.append(" SELECT periodo.FEC_INIC, periodo.FEC_FINA   ");
            buf.append(" FROM cra_perio periodo ");
            buf.append(" WHERE 1=1 ");

            if(dto.getOid() != null)
                buf.append(" AND periodo.OID_PERI = " + dto.getOid() + " ");
                
            if(dto.getCanal() != null)
                buf.append(" AND periodo.cana_oid_cana = " + dto.getCanal() + " ");

            if(dto.getMarca() != null)
                buf.append(" AND periodo.marc_oid_marc = " + dto.getMarca() + " ");

            if(dto.getPais() != null){
                buf.append(" AND periodo.pais_oid_pais = " + dto.getPais() + " ");
            }else if(dto.getOidPais() != null) {
                //Incidencia BELC300017181
                buf.append(" AND periodo.pais_oid_pais = " + dto.getOidPais() + " ");
            }
            //  Ejecuta el query
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        }
        catch(MareMiiServiceNotFoundException e) {
            e.printStackTrace();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        catch(Exception e) {
            e.printStackTrace();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCRA.obtieneFechasPeriodo(DTOPeriodo dto):Salida");
        return new DTOSalida(respuesta);
    }   
    
    /**
     * BRECHA CRA-003 jrivas 16/10/2007
     */
    public DTOSalida obtenerGrupoZonas(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerGrupoZonas() Entrada");
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        
        sQuery.append(" SELECT CGZ.OID_CABE_GRUP_ZONA, ");
        sQuery.append("        (SELECT V.VAL_I18N ");
        sQuery.append("           FROM V_GEN_I18N_SICC V ");
        sQuery.append("          WHERE V.VAL_OID = CGZ.OID_CABE_GRUP_ZONA ");
        sQuery.append("            AND V.ATTR_ENTI = 'CRA_CABEC_GRUPO_ZONA' ");
        sQuery.append("            AND V.IDIO_OID_IDIO = " + dto.getOidIdioma() +") DESCR ");
        sQuery.append("   FROM CRA_CABEC_GRUPO_ZONA CGZ ");
        sQuery.append("  WHERE CGZ.CANA_OID_CANA = " + dto.getCanal());
        sQuery.append("    AND CGZ.MARC_OID_MARC = " + dto.getMarca());
        sQuery.append("    AND CGZ.PAIS_OID_PAIS = " + dto.getPais());
        sQuery.append("    AND CGZ.IND_ESTA = 1  ");
        sQuery.append("  ORDER BY 2 ASC ");        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
        UtilidadesLog.info("DAOCRA.obtenerGrupoZonas() Salida");
        return new DTOSalida(rs);
    }    
    
    /**
     * BRECHA CRA-003 jrivas 16/10/2007
     */
    public DTOSalida obtenerZonas(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerZonas() Entrada");
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" SELECT DTZ.ZZON_OID_ZONA, ZZ.DES_ZONA ");
        sQuery.append("   FROM CRA_DETAL_GRUPO_ZONA DTZ, ZON_ZONA ZZ ");
        sQuery.append("  WHERE DTZ.CGZO_OID_CABE_GRUP_ZONA = " + dto.getOid());
        sQuery.append("  AND DTZ.ZZON_OID_ZONA = ZZ.OID_ZONA ");
        sQuery.append("  ORDER BY 2 ASC ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }

        UtilidadesLog.info("DAOCRA.obtenerZonas() Salida");
        return new DTOSalida(rs);
    }  
    
    /**
     * BRECHA CRA-003 jrivas 16/10/2007
     */
    public DTOBoolean validarGeneracion(DTOGenerarCronogramaporZonas dto) throws MareException {
        UtilidadesLog.info("DAOCRA.validarGeneracion() Entrada");
        RecordSet rs;
        RecordSet rs2;
        DTOBoolean salida = new DTOBoolean();
        
        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" SELECT COUNT(*) FROM CRA_CRONO CC ");
        sQuery.append(" WHERE CC.PERD_OID_PERI = " + dto.getOidPeriodo());
        sQuery.append(" AND CC.ZZON_OID_ZONA = " + dto.getOidZonaReferencia());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
        
        if (((BigDecimal)(rs.getValueAt(0,0))).intValue() == 0) {
            UtilidadesLog.info("DAOCRA.validarGeneracion() Salida NULL");
            return null;
        } else {
            Iterator it = dto.getOidsZonasRegenerar().iterator();
            StringBuffer in = new StringBuffer();
            in.append("(");
            while (it.hasNext()) {
                in.append(it.next().toString()); 
                if (it.hasNext()) { 
                    in.append(" ,");     
                }
            }
            in.append(")");
            StringBuffer sQuery2 = new StringBuffer();
            sQuery2.append(" SELECT COUNT(*) FROM CRA_CRONO CC ");
            sQuery2.append(" WHERE CC.PERD_OID_PERI = " + dto.getOidPeriodo());
            sQuery2.append(" AND CC.ZZON_OID_ZONA IN " + in.toString());
            BelcorpService bs2 = UtilidadesEJB.getBelcorpService();
            try {
              rs2 = bs2.dbService.executeStaticQuery(sQuery2.toString());
            } catch (Exception e) {
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
            }   
            if (((BigDecimal)(rs2.getValueAt(0,0))).intValue() == 0) {
                UtilidadesLog.info("DAOCRA.validarGeneracion() Salida FALSE");
                salida.setValor(false);
                return salida;
            }  else {          
                UtilidadesLog.info("DAOCRA.validarGeneracion() Salida TRUE");
                salida.setValor(true);
                return salida;
            }
        }
    }        

    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */    
    public void obtenerDatosBorrar(DTOGenerarCronogramaporZonas dto, DTOCronograma dtoC) throws MareException {    
        UtilidadesLog.info("DAOCRA.obtenerDatosBorrar() Entrada");    

        Iterator it = dto.getOidsZonasRegenerar().iterator();
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        StringBuffer in = new StringBuffer();
        Vector oids = new Vector();
        in.append("(");
        while (it.hasNext()) {
            in.append(it.next().toString()); 
            if (it.hasNext()) { 
                in.append(" ,");     
            }
        }
        in.append(")");
        sQuery.append(" SELECT OID_CRON ");
        sQuery.append(" from CRA_CRONO CC ");
        sQuery.append(" where CC.ZZON_OID_ZONA IN " + in.toString());
        sQuery.append(" and CC.PERD_OID_PERI = " + dto.getOidPeriodo());
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        } 
        Long oid;
        for (int i = 0; i < rs.getRowCount(); i++)  {
            oid = new Long(rs.getValueAt(i, "OID_CRON").toString());
            oids.add(oid);
        }  
        ((DTOGrupoCronograma)(dtoC.getGrupos().get(0))).setBorradas(oids);
        UtilidadesLog.info("DAOCRA.obtenerDatosBorrar() Salida");            
        
    }
    
    /**
     * BRECHA CRA-003 jrivas 22/10/2007
     */    
    public HashMap obtenerDatosRegenerar(DTOGenerarCronogramaporZonas dto, DTOCronograma dtoC, HashMap periodos) throws MareException {    
        UtilidadesLog.info("DAOCRA.obtenerDatosRegenerar() Entrada");    
        HashMap salida = new HashMap();
        ArrayList actividades;
        RecordSet rs;
        RecordSet rs2;        
        StringBuffer sQuery = new StringBuffer();
        
        sQuery.append(" SELECT MAX(CC.COD_VIST) + 1 FROM CRA_CRONO CC ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        } 
        int maxCodVist = ((BigDecimal)rs.getValueAt(0,0)).intValue();

        sQuery = new StringBuffer();
        sQuery.append(" SELECT CACT_OID_ACTI, COD_TIPO_DIAS, ");
        sQuery.append(" FEC_INIC, FEC_MEDI, FEC_FINA, TIFA_OID_TIPO_FACT, VAL_FEC0,  ");
        sQuery.append(" IND_FIJA, COD_VIST, COD_VIST_ORIG,  ");
        sQuery.append(" NUM_DIAS_DESP, IND_PEND_ORIG, PERD_OID_PERI_REFE, ");
        sQuery.append(" CASE  ");
        sQuery.append("    WHEN CC.IND_PEND_ORIG = 0 ");
        sQuery.append(" THEN   ");
        sQuery.append("     (SELECT CC2.CACT_OID_ACTI FROM CRA_CRONO CC2 ");
        sQuery.append("     WHERE CC2.PERD_OID_PERI = CC.PERD_OID_PERI_REFE ");
        sQuery.append("      AND CC2.ZZON_OID_ZONA = CC.ZZON_OID_ZONA " );
        sQuery.append("      AND CC2.COD_VIST = CC.COD_VIST_ORIG)   ");
        sQuery.append(" ELSE ");
        sQuery.append("     (SELECT CA.CACT_OID_ACTI FROM CRA_ACTIV CA ");
        sQuery.append("     WHERE CA.OID_ACTI = CC.CACT_OID_ACTI) ");
        sQuery.append(" END ACTIVIDADORIGEN          ");
        sQuery.append(" from CRA_CRONO CC ");
        sQuery.append(" where CC.ZZON_OID_ZONA = " + dto.getOidZonaReferencia());
        sQuery.append(" and CC.PERD_OID_PERI = " + dto.getOidPeriodo());
        sQuery.append(" order by COD_VIST ");
        try {
          rs2 = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }

        HashMap codigos_vista = new HashMap();
        int cantZonas = dto.getOidsZonasRegenerar().size();
        int cantActiv = rs2.getRowCount();
        DTOActividadGrupo dtoActiv;
        Long actividadOrigen;
        for (int i = 0; i < cantZonas; i++) {
            Long oidZona = (Long)dto.getOidsZonasRegenerar().get(i);
            codigos_vista = new HashMap();
            actividades = new ArrayList();
            for (int j = 0; j < cantActiv; j++)  {
                
                dtoActiv = new DTOActividadGrupo();
                dtoActiv.setActividad(new Long(rs2.getValueAt(j, "CACT_OID_ACTI").toString()));
                dtoActiv.setTipoDias(rs2.getValueAt(j, "COD_TIPO_DIAS").toString().equals("1")?Boolean.TRUE:Boolean.FALSE);

                if (rs2.getValueAt(j, "FEC_MEDI") != null) {
                    dtoActiv.setFechaMedia(new Integer(rs2.getValueAt(j, "FEC_MEDI").toString()));
                }
                if (rs2.getValueAt(j, "FEC_FINA") != null) {
                    dtoActiv.setFechaFinal((Date)(rs2.getValueAt(j, "FEC_FINA")));
                }      
                dtoActiv.setTipoFacturacion(new Long(rs2.getValueAt(j, "TIFA_OID_TIPO_FACT").toString()));
                dtoActiv.setFecha0(new Long(rs2.getValueAt(j, "VAL_FEC0").toString()));                
                if (rs2.getValueAt(j, "IND_FIJA") != null) {
                    dtoActiv.setIndFija(rs2.getValueAt(j, "IND_FIJA").toString().equals("1")?Boolean.TRUE:Boolean.FALSE);
                }  
                if (rs2.getValueAt(j, "NUM_DIAS_DESP") != null) {
                    dtoActiv.setDiasDesplazamiento(new Integer(rs2.getValueAt(j, "NUM_DIAS_DESP").toString()));
                }  

                dtoActiv.setPeriodo(dto.getOidPeriodo());
                dtoActiv.setGrupo(oidZona);
                
                Integer auxCodVist = new Integer(rs2.getValueAt(j, "COD_VIST").toString());
                if (!codigos_vista.containsKey(auxCodVist)) {
                    codigos_vista.put(auxCodVist, new Integer(maxCodVist++));
                }
                dtoActiv.setIdVista((Integer)codigos_vista.get(auxCodVist));
                
                //Punto 12 recorriendo cada actividad.
                if (rs2.getValueAt(j, "PERD_OID_PERI_REFE") != null 
                        && rs2.getValueAt(j, "ACTIVIDADORIGEN") != null) {
                        
                    dtoActiv.setPeriodoReferencia(new Long(rs2.getValueAt(j, "PERD_OID_PERI_REFE").toString()));
                    actividadOrigen = new Long(rs2.getValueAt(j, "ACTIVIDADORIGEN").toString());
                    
                    if (rs2.getValueAt(j, "IND_PEND_ORIG") != null) {
                        dtoActiv.setIndPendienteOrigen(rs2.getValueAt(j, "IND_PEND_ORIG").toString().equals("1")?Boolean.TRUE:Boolean.FALSE);
                    }
                    dtoActiv.setFechaPrevista(new Timestamp(((Date)(rs2.getValueAt(j, "FEC_INIC"))).getTime()));
                    
                    this.buscarActividadOrigen(dtoActiv, actividadOrigen, oidZona, periodos);
                    
                } else { 
                    if (rs2.getValueAt(j, "IND_PEND_ORIG") != null) {
                        dtoActiv.setIndPendienteOrigen(rs2.getValueAt(j, "IND_PEND_ORIG").toString().equals("1")?Boolean.TRUE:Boolean.FALSE);
                    }  
    
                    dtoActiv.setFechaPrevista(new Timestamp(((Date)(rs2.getValueAt(j, "FEC_INIC"))).getTime()));
                    
                    Integer auxCodVistOrig = null;
                    if (rs2.getValueAt(j, "COD_VIST_ORIG") != null) {
                        auxCodVistOrig = new Integer(rs2.getValueAt(j, "COD_VIST_ORIG").toString());
                        if (!codigos_vista.containsKey(auxCodVistOrig)) {
                            codigos_vista.put(auxCodVistOrig, new Integer(maxCodVist++));
                        }
                        dtoActiv.setActividadOrigen((Integer)codigos_vista.get(auxCodVistOrig));                    
                    }
                    //FIN verificar
                }
                ((DTOGrupoCronograma)(dtoC.getGrupos().get(0))).getActividades().add(dtoActiv);
                
                UtilidadesLog.debug("dtoActiv.getIndPendienteOrigen() " + dtoActiv.getIndPendienteOrigen()); 
                //Guardo los que tengan IND_PEND_ORIG = 0 para procesarlos en el punto 14
                if (dtoActiv.getIndPendienteOrigen() != null && !dtoActiv.getIndPendienteOrigen().booleanValue()) {
                    UtilidadesLog.debug("dtoActiv " + dtoActiv); 
                    actividades.add(dtoActiv); 
                }                
            }
            //Guardo los que tengan IND_PEND_ORIG = 0 para procesarlos en el punto 14
            if (actividades != null && !actividades.isEmpty()) {
                salida.put(oidZona, actividades);   
            }
        }
        UtilidadesLog.info("DAOCRA.obtenerDatosRegenerar() Salida");            
        return salida;
        
    }  
    
    /**
     * BRECHA CRA-003 jrivas 26/11/2007
     */    
    public HashMap obtenerPeriodosAVerificar(Long oidPeriodo) throws MareException {    
        UtilidadesLog.info("DAOCRA.obtenerPeriodosAVerificar() Entrada");    

        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();

        sQuery.append(" SELECT cp.OID_PERI, cp.FEC_INIC  ");
        sQuery.append(" FROM CRA_PERIO CP, CRA_PERIO CP2 ");
        sQuery.append(" WHERE CP.OID_PERI != " + oidPeriodo);
        sQuery.append(" and CP2.OID_PERI = " + oidPeriodo);
        sQuery.append(" AND CP.PAIS_OID_PAIS = CP2.PAIS_OID_PAIS ");
        sQuery.append(" AND cp.MARC_OID_MARC = cp2.MARC_OID_MARC ");
        sQuery.append(" AND cp.CANA_OID_CANA = cp2.CANA_OID_CANA ");
        sQuery.append(" and cp.FEC_INIC > sysdate ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        } 
        Long periodo;
        Date fechaInicio;
        HashMap periodos = new HashMap();
        for (int i = 0; i < rs.getRowCount(); i++)  {
            periodo = new Long(rs.getValueAt(i, "OID_PERI").toString());
            fechaInicio = (Date)(rs.getValueAt(i, "FEC_INIC"));
            periodos.put(periodo, fechaInicio);
        }  
        UtilidadesLog.info("DAOCRA.obtenerPeriodosAVerificar() Salida");            
        return periodos;
    }    
    
    /**
     * BRECHA CRA-003 jrivas 26/11/2007
     */    
    public void procesarActividadesAEliminar(Long oidPeriodo, Long zona, String periodos) throws MareException {    
        UtilidadesLog.info("DAOCRA.procesarActividadesAEliminar() Entrada");    

        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        ArrayList oidsAModificar = new ArrayList();

        sQuery.append(" SELECT CC.OID_CRON, CC.PERD_OID_PERI, CC.COD_VIST FROM CRA_CRONO CC  ");
        sQuery.append(" WHERE CC.PERD_OID_PERI_REFE = " + oidPeriodo );
        sQuery.append(" AND CC.PERD_OID_PERI IN " + periodos);
        sQuery.append(" AND CC.ZZON_OID_ZONA = " + zona);
        sQuery.append(" AND CC.COD_VIST_ORIG IN (  ");
        sQuery.append(" SELECT CC2.COD_VIST  ");
        sQuery.append(" FROM CRA_CRONO CC2  ");
        sQuery.append(" WHERE CC2.ZZON_OID_ZONA = " + zona);
        sQuery.append(" AND CC2.PERD_OID_PERI =  " + oidPeriodo + ")");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        } 
        UtilidadesLog.debug("procesarActividadesAEliminar() rs " + rs);    
        Long oidCrono;
        Long periodo;
        String codigo;
        StringBuffer query = new StringBuffer();
        while (rs != null && rs.getRowCount() > 0) {
            query = new StringBuffer();
            query.append("(1!=1) ");
            for (int i = 0; i < rs.getRowCount(); i++)  {
                oidCrono = new Long(rs.getValueAt(i, "OID_CRON").toString());
                periodo = new Long(rs.getValueAt(i, "PERD_OID_PERI").toString());
                codigo = rs.getValueAt(i, "COD_VIST").toString();
                
                //guardar oid y armar al final.
                if (!oidsAModificar.contains(oidCrono)){
                    oidsAModificar.add(oidCrono);
                }
                
                //armar string para query recursiva
                query.append(" OR (CC.PERD_OID_PERI_REFE = " + periodo);
                query.append(" AND CC.COD_VIST_ORIG = '"+  codigo  +"')");
            }  
            sQuery = new StringBuffer();
            sQuery.append(" SELECT CC.OID_CRON, CC.PERD_OID_PERI, CC.COD_VIST FROM CRA_CRONO CC ");
            sQuery.append(" WHERE CC.PERD_OID_PERI IN " + periodos);
            sQuery.append(" AND CC.ZZON_OID_ZONA = " + zona);
            sQuery.append(" AND (" + query +")");
            bs = UtilidadesEJB.getBelcorpService();
            try {
              rs = bs.dbService.executeStaticQuery(sQuery.toString());
            } catch (Exception e) {
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
            }
            UtilidadesLog.debug("procesarActividadesAEliminar() rs " + rs);
        }
        //modificar
        if (oidsAModificar.size() > 0) {
            Iterator it = oidsAModificar.iterator();
            StringBuffer stringCrono = new StringBuffer();
            stringCrono.append("(");
            while (it.hasNext()) {
                stringCrono.append(it.next().toString()); 
                if (it.hasNext()) { 
                    stringCrono.append(" ,");     
                }
            } 
            stringCrono.append(")");
            StringBuffer crono = new StringBuffer();
            crono.append(" UPDATE CRA_CRONO CC ");
            crono.append(" SET FEC_INIC = ( ");
            crono.append(" SELECT FEC_INIC  ");
            crono.append(" FROM CRA_PERIO  ");
            crono.append(" WHERE OID_PERI = CC.PERD_OID_PERI), ");
            crono.append(" COD_VIST_ORIG = NULL, ");
            crono.append(" IND_PEND_ORIG = 1 ");
            crono.append(" WHERE CC.OID_CRON IN " + stringCrono);
            bs = UtilidadesEJB.getBelcorpService();
            try {
              bs.dbService.executeUpdate(crono.toString());
            } catch (Exception e) {
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
            } 
            
        }
        UtilidadesLog.info("DAOCRA.procesarActividadesAEliminar() Salida");            
    }   
    
    /**
     * BRECHA CRA-003 jrivas 27/11/2007
     */    
    public void buscarActividadOrigen(DTOActividadGrupo dto, Long actividadOrigen, Long oidZona, HashMap periodos) throws MareException {    

        UtilidadesLog.info("DAOCRA.buscarActividadOrigen() Entrada");    
        Integer diasDespl;
        if (dto.getDiasDesplazamiento() == null) {
            diasDespl = new Integer(0);
        } else {
            diasDespl = dto.getDiasDesplazamiento();
        }
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" SELECT COD_VIST, (FEC_INIC + " + diasDespl + ") FEC_INICIO");
        sQuery.append(" from CRA_CRONO CC ");
        sQuery.append(" where CC.ZZON_OID_ZONA = " + oidZona);
        sQuery.append(" and CC.PERD_OID_PERI = " + dto.getPeriodoReferencia());
        sQuery.append(" and CC.CACT_OID_ACTI = " + actividadOrigen);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
        if (rs != null && !rs.esVacio() && rs.getValueAt(0, "COD_VIST") != null) {
            dto.setActividadOrigen(new Integer(rs.getValueAt(0, "COD_VIST").toString()));
            dto.setFechaPrevista(new Timestamp(((Date)(rs.getValueAt(0, "FEC_INICIO"))).getTime()));
            dto.setIndPendienteOrigen(Boolean.FALSE);
        } else {
            if (periodos.containsKey(dto.getPeriodoReferencia())) {
                //Periodo Futuro
                dto.setFechaPrevista(new Timestamp(((Date)periodos.get(dto.getPeriodoReferencia())).getTime()));
                dto.setIndPendienteOrigen(Boolean.TRUE);
            } else {
                //No hago nada ya que los valores estan guardados antes de entrar al metodo.
            }
        }
        UtilidadesLog.info("DAOCRA.buscarActividadOrigen() Salida");            
    }      
    
    /**
     * BRECHA CRA-003 jrivas 4/12/2007
     */    
    public void procesarActividadesNoPendientes(Long oidPeriodo, Long zona, String periodos, ArrayList actividades) throws MareException {    
        UtilidadesLog.info("DAOCRA.procesarActividadesNoPendientes() Entrada");    

        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        StringBuffer cronoActualizar = new StringBuffer();
        ArrayList oidsAModificar = new ArrayList();

        sQuery.append(" SELECT CC.OID_CRON, CC.PERD_OID_PERI, CC.COD_VIST, CC.NUM_DIAS_DESP, CC.COD_VIST_ORIG, CC.PERD_OID_PERI_REFE,");
        sQuery.append(" CASE  ");
        sQuery.append("    WHEN CC.IND_PEND_ORIG = 0 ");
        sQuery.append(" THEN   ");
        sQuery.append("     (SELECT CC2.CACT_OID_ACTI FROM CRA_CRONO CC2 ");
        sQuery.append("     WHERE CC2.PERD_OID_PERI = CC.PERD_OID_PERI_REFE ");
        sQuery.append("      AND CC2.ZZON_OID_ZONA = CC.ZZON_OID_ZONA " );
        sQuery.append("     AND CC2.COD_VIST = CC.COD_VIST_ORIG)   ");
        sQuery.append(" ELSE ");
        sQuery.append("     (SELECT CA.CACT_OID_ACTI FROM CRA_ACTIV CA ");
        sQuery.append("     WHERE CA.OID_ACTI = CC.CACT_OID_ACTI) ");
        sQuery.append("  END ACTIVIDADORIGEN ");
        sQuery.append(" FROM CRA_CRONO CC ");
        sQuery.append(" WHERE CC.PERD_OID_PERI IN " + periodos);
        sQuery.append(" AND CC.ZZON_OID_ZONA = " + zona);
        sQuery.append(" AND CC.PERD_OID_PERI_REFE = " + oidPeriodo );

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        } 
        UtilidadesLog.debug("procesarActividadesNoPendientes() rs " + rs);    
        
        Long actividad;
        int diasDes = 0;
        Iterator it;
        DTOActividadGrupo dtoActividad;
        Calendar c;
        StringBuffer query = new StringBuffer();
        Integer codigo;
        Long oidCrono;
        Long periodo;
        Long periodoReferencia;
        String codigoOrigen;
        boolean encontre = true;
        boolean primeraPasada = true;
        ArrayList actividadesAActualizar = new ArrayList();
        DTOActividadGrupo aux;
        
        while (rs != null && rs.getRowCount() > 0 && encontre) {
            query = new StringBuffer();
            query.append("(1!=1) "); 
            
            if (!primeraPasada) {
                actividades = actividadesAActualizar;
                actividadesAActualizar = new ArrayList();
            }
            
            for (int i = 0; i < rs.getRowCount(); i++)  {
                encontre = false;
                if (rs.getValueAt(i, "ACTIVIDADORIGEN") != null) {
                    actividad = new Long(rs.getValueAt(i, "ACTIVIDADORIGEN").toString());
                    codigo = new Integer(rs.getValueAt(i, "COD_VIST").toString());
                    oidCrono = new Long(rs.getValueAt(i, "OID_CRON").toString());
                    periodo = new Long(rs.getValueAt(i, "PERD_OID_PERI").toString());
                    if (rs.getValueAt(i, "COD_VIST_ORIG") != null) {
                        codigoOrigen = rs.getValueAt(i, "COD_VIST_ORIG").toString(); 
                    } else {
                        codigoOrigen = null;
                    }
                    periodoReferencia = new Long(rs.getValueAt(i, "PERD_OID_PERI_REFE").toString());
                    
                    //Cuando es primer pasada, no tengo la relacion y la busco por actvidadOrigen, luego en la recursion simplemente busco por cod_activ_orige y priodo referencia.
                    if (primeraPasada) {
                        UtilidadesLog.debug("primeraPasada");    
                        //En la primera pasada tenemos que busca el enganche.
                        it = actividades.iterator();
                        //Busca Actividad origen y calcule fecha inicio.
                        while (it.hasNext()) {
                            dtoActividad = (DTOActividadGrupo) it.next();
                            UtilidadesLog.debug("primeraPasada " + dtoActividad);    
                            UtilidadesLog.debug("actividad " + actividad);    
                            if (dtoActividad.getActividad().equals(actividad)) {
                                UtilidadesLog.debug("encontre ");    
                                //encontre actividad origen
                                encontre = true;
                                
                                //calculamos fecha inicio
                                if (rs.getValueAt(i, "NUM_DIAS_DESP") != null) {
                                    diasDes = new Integer(rs.getValueAt(i, "NUM_DIAS_DESP").toString()).intValue();
                                } else {
                                    diasDes = 0;
                                }
                                c = new GregorianCalendar();
                                c.setTime(dtoActividad.getFechaPrevista());
                                c.add(Calendar.DATE, diasDes);
                                
                                //Guardamos la info para acualizar luego.
                                aux = new DTOActividadGrupo();
                                aux.setOid(oidCrono);
                                aux.setFechaPrevista(new Timestamp(c.getTime().getTime()));
                                aux.setPeriodoReferencia(periodo);
                                aux.setActividadOrigen(codigo);
                                actividadesAActualizar.add(aux);
                                
                                //Armamos String UPDATE
                                cronoActualizar.append(this.armarStringModificar(aux, dtoActividad.getIdVista()));
                                                                
                                //Armamos query recursion
                                query.append(" OR (CC.PERD_OID_PERI_REFE = " + periodo);
                                query.append(" AND CC.COD_VIST_ORIG = '"+  codigo  +"')");
                                break;
                            }
                        }
                    } else {
                        UtilidadesLog.debug("NO primeraPasada");    

                        //Entonces no es la primera pasada iniciamos la recursion
                        it = actividades.iterator();
                        //Busca Actividad origen y calcule fecha inicio.
                        while (it.hasNext()) {
                            dtoActividad = (DTOActividadGrupo) it.next();
                            UtilidadesLog.debug("primeraPasada " + dtoActividad);    
                            UtilidadesLog.debug("actividad " + actividad);    
                            if (dtoActividad.getActividadOrigen().toString().equals(codigoOrigen) &&
                                (dtoActividad.getPeriodoReferencia().equals(periodoReferencia))) {
                                
                                UtilidadesLog.debug("encontre ");    
                                //encontre actividad origen
                                encontre = true;
                                
                                //calculamos fecha inicio
                                if (rs.getValueAt(i, "NUM_DIAS_DESP") != null) {
                                    diasDes = new Integer(rs.getValueAt(i, "NUM_DIAS_DESP").toString()).intValue();
                                } else {
                                    diasDes = 0;
                                }
                                c = new GregorianCalendar();
                                c.setTime(dtoActividad.getFechaPrevista());
                                c.add(Calendar.DATE, diasDes);
                                
                                //Guardamos la info para acualizar luego.
                                aux = new DTOActividadGrupo();
                                aux.setOid(oidCrono);
                                aux.setFechaPrevista(new Timestamp(c.getTime().getTime()));
                                aux.setPeriodoReferencia(periodo);
                                aux.setActividadOrigen(codigo);
                                actividadesAActualizar.add(aux);

                                //Armamos String UPDATE
                                cronoActualizar.append(this.armarStringModificar(aux, null));
                                
                                //Armamos query recursion
                                query.append(" OR (CC.PERD_OID_PERI_REFE = " + periodo);
                                query.append(" AND CC.COD_VIST_ORIG = '"+  codigo  +"')");
                                break;
                            }
                        }                        
                    }
                }
            }
            primeraPasada = false;
            if (encontre) {
                sQuery = new StringBuffer();
                sQuery.append(" SELECT CC.OID_CRON, CC.PERD_OID_PERI, CC.COD_VIST, CC.NUM_DIAS_DESP, CC.COD_VIST_ORIG, CC.PERD_OID_PERI_REFE, ");
                sQuery.append(" (SELECT CC2.CACT_OID_ACTI FROM CRA_CRONO CC2 ");
                sQuery.append(" WHERE CC2.PERD_OID_PERI = CC.PERD_OID_PERI_REFE ");
                sQuery.append(" AND CC2.ZZON_OID_ZONA = CC.ZZON_OID_ZONA " );
                sQuery.append(" AND CC2.COD_VIST = CC.COD_VIST_ORIG) ACTIVIDADORIGEN ");
                sQuery.append(" FROM CRA_CRONO CC ");
                sQuery.append(" WHERE CC.PERD_OID_PERI IN " + periodos);
                sQuery.append(" AND CC.ZZON_OID_ZONA = " + zona);
                sQuery.append(" AND (" + query +")");
                bs = UtilidadesEJB.getBelcorpService();
                try {
                  rs = bs.dbService.executeStaticQuery(sQuery.toString());
                } catch (Exception e) {
                  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
                }   
                UtilidadesLog.debug("procesarActividadesNoPendientes() rs " + rs);    
            }
        }
        
        //modificar
        this.ejecutarUpdate(cronoActualizar);
        UtilidadesLog.info("DAOCRA.procesarActividadesNoPendientes() Salida");            
    }      
    
    /**
     * BRECHA CRA-003 jrivas 5/12/2007
     */  
     private void ejecutarUpdate(StringBuffer string) throws MareException { 
        try {
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", string.toString());
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }    
     } 
     
    /**
     * BRECHA CRA-003 jrivas 5/12/2007
     */  
     private StringBuffer armarStringModificar(DTOActividadGrupo dto, Integer codigo) throws MareException { 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer queryUpdate = new StringBuffer();
        queryUpdate.append("UPDATE CRA_CRONO CC ");
        queryUpdate.append(" SET FEC_INIC = TO_DATE( '" + df.format(dto.getFechaPrevista()) + "', 'YYYY-MM-DD HH24:MI:SS'), ");     
        queryUpdate.append(" IND_PEND_ORIG = 0, ");
        if (codigo != null) {
            queryUpdate.append(" COD_VIST_ORIG = " + codigo);
        }
        queryUpdate.append(" WHERE CC.OID_CRON = " + dto.getOid() + ";");
        return queryUpdate;
     }      
    
    /**
     * Cambio CRA-01
     * Obtiene informacion de la actividad cuyo OID se recibe por parametro
     * y tambien de su actividad origen en caso de poseerla
     * @author dmorello
     * @since 18-jun-2008
     */
    public RecordSet obtenerInfoActividad(Long oidActividad) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerInfoActividad(Long oidActividad): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT activ.cod_tipo_acti ");
        query.append("      , activ.num_dias_desp ");
        query.append("      , origen.oid_acti AS oid_acti_orig ");
        query.append("      , origen.cod_acti AS cod_acti_orig ");
        query.append("      , pq_apl_aux.valor_gen_i18n_sicc (").append(ConstantesSEG.IDIOMA_DEFECTO);
        query.append(", origen.oid_acti, 'CRA_ACTIV') AS val_nomb_acti_orig ");
        query.append("   FROM cra_activ activ ");
        query.append("      , cra_activ origen ");
        query.append("  WHERE activ.oid_acti = ").append(oidActividad);
        query.append("    AND activ.cact_oid_acti = origen.oid_acti(+)");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOCRA.obtenerInfoActividad(Long oidActividad): Salida");
        return rs;
    }
     
     
    /**
     * Cambio CRA-01
     * Obtiene el año del periodo cuyo OID recibe por parametro
     * Si no existe un periodo para el OID recibido, devuelve null.
     * @author dmorello
     */
    public RecordSet obtenerAnioPeriodo(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerAnioPeriodo(DTOOID dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT pc.val_anio ");
        query.append("   FROM cra_perio peri, seg_perio_corpo pc ");
        query.append("  WHERE peri.oid_peri = ").append(dtoe.getOid());
        query.append("    AND peri.peri_oid_peri = pc.oid_peri ");        
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCRA.obtenerAnioPeriodo(DTOOID dtoe): Salida");
        return rs;
    }
    
    /**
     * Cambio RI 20080621
     * Obtiene y devuelve pais, marca, canal y oid del periodo actual
     * cuyo pais, marca y canal recibe por parametro.
     * @author dmorello
     * @since 19-sep-2008
     */
    public DTOID obtenerPeriodoActual(DTOID dtoe) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerPeriodoActual(DTOID dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT oid_peri FROM ( ");
        query.append(" 	SELECT p.oid_peri ");
        query.append(" 	  FROM cra_perio p ");
        query.append(" 	 WHERE p.pais_oid_pais = ").append(dtoe.getPais());
        query.append(" 	   AND p.marc_oid_marc = ").append(dtoe.getMarca());
        query.append(" 	   AND p.cana_oid_cana = ").append(dtoe.getCanal());
        query.append(" 	   AND SYSDATE >= p.fec_inic ");
        query.append(" 	ORDER BY p.fec_inic DESC ");
        query.append(" ) ");
        query.append(" WHERE ROWNUM = 1 ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (!rs.esVacio()) {
            dtoe.setOid(new Long(((BigDecimal)rs.getValueAt(0,0)).longValue()));
        }
        
        UtilidadesLog.info("DAOCRA.obtenerPeriodoActual(DTOID dtoe): Salida");
        return dtoe;
    }
    
    /**
     * Cambio RI 20080621
     * Obtiene y devuelve pais, marca, canal y OID del periodo posterior al actual
     * cuyo pais, marca y canal recibe por parametro.
     * Si no encuentra un periodo posterior, el objeto devuelto contiene solo
     * pais, marca y canal (el OID es null)
     * @author dmorello
     * @since 19-sep-2008
     */
    public DTOID obtenerPeriodoPosteriorActual(DTOID dtoe) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerPeriodoPosteriorActual(DTOID dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT oid_peri FROM ( ");
        query.append(" 	SELECT p.oid_peri ");
        query.append(" 	  FROM cra_perio p ");
        query.append(" 	 WHERE p.pais_oid_pais = ").append(dtoe.getPais());
        query.append(" 	   AND p.marc_oid_marc = ").append(dtoe.getMarca());
        query.append(" 	   AND p.cana_oid_cana = ").append(dtoe.getCanal());
        query.append(" 	   AND SYSDATE < p.fec_inic ");
        query.append(" 	ORDER BY p.fec_inic ASC ");
        query.append(" ) ");
        query.append(" WHERE ROWNUM = 1 ");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        if (!rs.esVacio()) {
            dtoe.setOid(new Long(((BigDecimal)rs.getValueAt(0,0)).longValue()));
        }
        
        UtilidadesLog.info("DAOCRA.obtenerPeriodoPosteriorActual(DTOID dtoe): Salida");
        return dtoe;
    }
    
    /**
     * Cambio RI 20080621
     * Devuelve un DTOPeriodo con la info del periodo cuyo OID recibe por parametro.
     * Si no existe tal periodo devuelve null.
     * @author dmorello
     * @since 22-sep-2008
     */
    public DTOPeriodo obtenerPeriodo(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOCRA.obtenerPeriodo(DTOOID dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String query = "SELECT * FROM cra_perio WHERE oid_peri = " + dtoe.getOid();
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTOPeriodo dtoRetorno = null;
        if (!rs.esVacio()) {
            dtoRetorno = new DTOPeriodo();
            
            dtoRetorno.setOid(new Long(((BigDecimal)rs.getValueAt(0, "OID_PERI")).longValue()));
            dtoRetorno.setMarca(new Long(((BigDecimal)rs.getValueAt(0, "MARC_OID_MARC")).longValue()));
            dtoRetorno.setCanal(new Long(((BigDecimal)rs.getValueAt(0, "CANA_OID_CANA")).longValue()));
            dtoRetorno.setPais(new Long(((BigDecimal)rs.getValueAt(0, "PAIS_OID_PAIS")).longValue()));
            
            Object acceso = rs.getValueAt(0, "ACCE_OID_ACCE");
            if (acceso != null) {
                dtoRetorno.setAcceso(new Long(((BigDecimal)acceso).longValue()));
            }
            
            dtoRetorno.setOidPeriodoCorporativo(new Long(((BigDecimal)rs.getValueAt(0, "PERI_OID_PERI")).longValue()));
            
            dtoRetorno.setFechaInicio((Date)rs.getValueAt(0,"FEC_INIC"));
            dtoRetorno.setFechaFin((Date)rs.getValueAt(0,"FEC_FINA"));
            dtoRetorno.setStatus(Boolean.valueOf(((BigDecimal)rs.getValueAt(0,"VAL_ESTA")).longValue() == 1));
            dtoRetorno.setNombre(rs.getValueAt(0, "VAL_NOMB_PERI").toString());
            
            Object indPeriCorto = rs.getValueAt(0, "IND_PERI_CORT");
            if (indPeriCorto != null) {
                dtoRetorno.setPeriodoCorto(Boolean.valueOf(((BigDecimal)indPeriCorto).longValue() == 1));
            }

            Object indPeriCruce = rs.getValueAt(0, "IND_PERI_CRUC");
            if (indPeriCruce != null) {
                dtoRetorno.setPeriodoCruce(Boolean.valueOf(((BigDecimal)indPeriCruce).longValue() == 1));
            }
        }
        
        UtilidadesLog.info("DAOCRA.obtenerPeriodo(DTOOID dtoe): Salida");
        return dtoRetorno;
    }
    
  /**
   * Cambio RI 20080621
   * Obtiene OID y nombre del periodo actual y de los posteriores para
   * pais, marca y canal recibidos por parametro.
   * @author dmorello
   * @since 07-oct-2008
   */
  public DTOSalida obtienePeriodoActualYPosteriores(DTOID dto) throws MareException {
      UtilidadesLog.info("DAOCRA.obtienePeriodoActualYPosteriores(DTOID dto):Entrada");
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet(); 
      DTOSalida dtos = new DTOSalida();
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      query.append(" SELECT	P.OID_PERI OID_PERIODO, P.VAL_NOMB_PERI ");
      query.append(" FROM CRA_PERIO P ");
      query.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
      query.append(" AND P.MARC_OID_MARC = " + dto.getMarca());
      query.append(" AND P.CANA_OID_CANA = " + dto.getCanal());
      query.append(" AND P.FEC_FINA > SYSDATE ");
      query.append(" ORDER BY P.VAL_NOMB_PERI ");
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }           
      
      dtos.setResultado(rs);
      
      UtilidadesLog.info("DAOCRA.obtienePeriodoActualYPosteriores(DTOID dto):Salida");
      return dtos;      
  }
  
    public DTOSalida obtenerMensajesCRA() throws MareException {
         UtilidadesLog.info("DAOCRA.obtenerMensajesCRA(DTOID dto):Entrada");
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtos = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         
         query.append(" Select OID_MENS , COD_MENS ||' - '|| DES_MENS ");
         query.append("   from MSG_MENSA ");
         query.append("  where COD_MENS LIKE 'CRA%' ");
         query.append(" order by COD_MENS ");
         
         
         try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }           
         
         dtos.setResultado(rs);
         
         UtilidadesLog.info("DAOCRA.obtenerMensajesCRA(DTOID dto):Salida");
         return dtos;      
     }

}