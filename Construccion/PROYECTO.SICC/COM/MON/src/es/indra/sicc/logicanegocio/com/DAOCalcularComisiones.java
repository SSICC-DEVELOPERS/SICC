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

/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DAOCalcularComisiones
 * Fecha:             06/04/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334-N034
 * Descripcion:       DAOCalcularComisiones
 * @version           1.0
 * @autor             pcabrera
 */
package es.indra.sicc.logicanegocio.com;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.com.DTOClienteComision;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.sicc.dtos.com.DTOGerenteZona;
import es.indra.sicc.dtos.com.DTOCalculoReporte;
import es.indra.sicc.dtos.com.DTOCuotaCalculoReporte;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.util.Date;

import java.util.ArrayList;


public class DAOCalcularComisiones {
    public DAOCalcularComisiones() {
    }

    /**
    *@Author: Pcabrera, 06/04/2005
    *@throws es.indra.mare.common.exception.MareException
    *@return DTOGerenteZona
    *@param Long oidCLiente
    *@param DTODatosCalculosComision dto
    * modificaciones BELC300019954 - 19/07/2005 - pperanzola
    */
    public DTOGerenteZona validarGerente(Long oidCLiente, DTODatosCalculosComision dto) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.validarGerente(Long oidCLiente, DTODatosCalculosComision dto): Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();

        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append(" SELECT oid_secc OID,  ");
        query.append(" 'SECCION' tipo ");
        query.append(" FROM zon_secci s ");
        query.append(" WHERE s.clie_oid_clie = " + oidCLiente);
        query.append(" AND s.IND_BORR = 0 ");
        query.append(" AND s.IND_ACTI = 1");

        if (dto.getOidSeccion() != null) {
            query.append(" AND s.oid_secc = " + dto.getOidSeccion());
        }

        query.append(" UNION ALL ");

        query.append(" SELECT oid_zona OID, ");
        query.append(" 'ZONA' tipo ");
        query.append(" FROM zon_zona z ");
        query.append(" WHERE z.clie_oid_clie = " + oidCLiente);
        query.append(" AND z.IND_BORR = 0 ");
        query.append(" AND z.IND_ACTI = 1");

        if (dto.getOidZona() != null) {
            query.append(" AND z.oid_zona = " + dto.getOidZona());
        }

        query.append(" AND z.pais_oid_pais = " + dto.getOidPais());
        query.append(" UNION ALL ");

        query.append(" SELECT oid_regi OID, ");
        query.append(" 'REGION' tipo ");
        query.append(" FROM zon_regio r ");
        query.append(" WHERE r.clie_oid_clie = " + oidCLiente);
        query.append(" AND r.IND_BORR = 0 ");
        query.append(" AND r.IND_ACTI = 1");

        if (dto.getOidRegion() != null) {
            query.append(" AND r.oid_regi = " + dto.getOidRegion());
        }

        query.append(" AND r.pais_oid_pais = " + dto.getOidPais());
        query.append(" UNION ALL ");

        query.append(" SELECT oid_subg_vent OID, ");
        query.append(" 'SUBGERENCIA' tipo ");
        query.append(" FROM zon_sub_geren_venta sgv ");
        query.append(" WHERE sgv.clie_oid_clie =  " + oidCLiente);
        query.append(" AND sgv.IND_BORR = 0 ");
        query.append(" AND sgv.IND_ACTI = 1");

        if (dto.getOidSV() != null) {
            query.append(" AND sgv.oid_subg_vent = " + dto.getOidSV());
        }

        query.append(" AND sgv.pais_oid_pais = " + dto.getOidPais());

        DTOGerenteZona dtoG = null;

        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());

            if (!rs.esVacio()) {
                dtoG = new DTOGerenteZona();
                UtilidadesLog.debug("Cantidad ::: " + rs.getRowCount());

                ArrayList seccion = new ArrayList();
                ArrayList zona = new ArrayList();
                ArrayList region = new ArrayList();
                ArrayList subg = new ArrayList();

                for (int i = 0; i < rs.getRowCount(); i++) {
                    String concepto = rs.getValueAt(i, "TIPO").toString();
                    String oid = rs.getValueAt(i, "OID").toString();

                    if (concepto.equals("SECCION")) {
                        //seccion.add(i, new Long(oid));
                        seccion.add(seccion.size(), new Long(oid));
                    } else if (concepto.equals("ZONA")) {
                        //zona.add(i, new Long(oid));
                        zona.add(zona.size(), new Long(oid));
                    } else if (concepto.equals("REGION")) {
                        //region.add(i, new Long(oid));
                        region.add(region.size(), new Long(oid));
                    } else if (concepto.equals("SUBGERENCIA")) {
                        //subg.add(i, new Long(oid));
                        subg.add(subg.size(), new Long(oid));
                    }

                    Long[] arrayRegion = (Long[]) region.toArray(new Long[region.size()]);
                    Long[] arraySeccion = (Long[]) seccion.toArray(new Long[seccion.size()]);
                    Long[] arrayZona = (Long[]) zona.toArray(new Long[zona.size()]);
                    Long[] arraySub = (Long[]) subg.toArray(new Long[subg.size()]);

                    // Guardamos la jerarquia de UA mas alta
                    if (arraySub.length != 0) {
                        dtoG.setOidSubgerenciaVentas(arraySub);
                    } else if (arrayRegion.length != 0) {
                        dtoG.setOidRegion(arrayRegion);
                    } else if (arrayZona.length != 0) {
                        dtoG.setOidZona(arrayZona);
                    } else if (arraySeccion.length != 0) {
                        dtoG.setOidSeccion(arraySeccion);
                    }

                    dtoG.setOidGerente(oidCLiente);
                }
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.validarGerente(Long oidCLiente, DTODatosCalculosComision dto): Salida");

        return dtoG;
    }

    private Long bigDecimalToLong(Object numero) {
        UtilidadesLog.info("DAOCalcularComisiones.bigDecimalToLong(Object numero): Entrada");

        if (numero != null) {
            UtilidadesLog.info("DAOCalcularComisiones.bigDecimalToLong(Object numero): Salida");

            return new Long(((BigDecimal) numero).longValue());
        } else {
            UtilidadesLog.info("DAOCalcularComisiones.bigDecimalToLong(Object numero): Salida");

            return null;
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      COM
           * Fecha:       08/04/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida recuperarGerentesCobranza(DTODatosCalculosComision dto) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarGerentesCobranza(DTODatosCalculosComision dto): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT acu.CLIE_OID_CLIE, acuCli.NUM_DIAS, acuCli.OID_COMI_COBR_ACUM, ");
        query.append(" acu.PERD_OID_PERI, acuCli.VAL_NIVE_TRAM, ");
        query.append(" acu.VAL_CANT_FACT, acuCli.VAL_PORC_COMI,  ");
        query.append(" acuCli.VAL_PORC_OBJE, acuCli.VAL_PORC_RECU, adic.COD_EMPL ");
        query.append(" FROM COM_COMIS_COBRA_ACUMU_CLIEN acuCli, ");
        query.append(" COM_COMIS_COBRA_ACUMU acu, MAE_CLIEN_DATOS_ADICI adic ");
        query.append(" WHERE acu.OID_COMI_COBR_ACUM = acuCli.COC2_OID_COMI_COBR_ACUM");
        query.append(" AND COMI_OID_COMI = " + dto.getOidComision());
        query.append(" AND PERD_OID_PERI = " + dto.getOidPeriodo());
        query.append(" AND acu.CLIE_OID_CLIE = adic.CLIE_OID_CLIE ");

        // Obtener los clientes
        StringBuffer clientes = new StringBuffer();
        ArrayList clientesArrayList = dto.getGerentes();        
        int cantGerentes = 0;
        int numIN = 0;

        if (clientesArrayList.size() != 0) {
            query.append(" AND ");
        }

        for (int i = 0; i < dto.getGerentes().size(); i++) {
            clientes.append(" ," + ((DTOClienteComision) clientesArrayList.get(i)).getOid());
            cantGerentes++;

            if (cantGerentes == 999) {
                if (numIN != 0) {
                    query.append(" OR ");
                }

                query.append(" acu.CLIE_OID_CLIE IN(" + clientes.toString().substring(2) + ") ");
                clientes = new StringBuffer();
                cantGerentes = 0;
                numIN++;
            }
        }

        if ((numIN != 0) && (clientes.length() != 0)) {
            query.append(" OR ");
        }

        if (clientes.length() != 0) {
            query.append(" acu.CLIE_OID_CLIE IN(" + clientes.toString().substring(2) + ") ");
        }

        query.append(" ORDER BY acu.CLIE_OID_CLIE, acuCli.NUM_DIAS ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOCalcularComisiones.recuperarGerentesCobranza(DTODatosCalculosComision dto): Salida");

        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      COM
           * Fecha:       08/04/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida recuperarConsultoras(Long oidPeriodo, DTOGerenteZona dto) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarConsultoras(Long oidPeriodo, DTOGerenteZona dto): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append(" SELECT DISTINCT cliadm.CLIE_OID_CLIE  ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN cliAdm, ZON_TERRI_ADMIN terrAdm, ");

        // UA
        Long[] subg = dto.getOidSubgerenciaVentas();
        Long[] region = dto.getOidRegion();
        Long[] zona = dto.getOidZona();
        Long[] seccion = dto.getOidSeccion();

        if (subg != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ZON_REGIO r, ");
        } else if (region != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ");
        } else if (zona != null) {
            query.append(" ZON_SECCI s, ");
        }

        query.append(" CRA_PERIO cra, CRA_PERIO craI, CRA_PERIO craF ");
        query.append(" WHERE cliAdm.IND_ACTI = 1 ");
        query.append(" AND cra.OID_PERI = " + oidPeriodo);
        query.append(" AND craI.OID_PERI = PERD_OID_PERI_INI ");
        query.append(" AND craF.OID_PERI(+) = PERD_OID_PERI_FIN ");
        query.append(" AND craI.FEC_INIC <= cra.FEC_INIC ");
        query.append(" AND (PERD_OID_PERI_FIN IS NULL OR cra.FEC_FINA <= craF.FEC_FINA) ");
        query.append(" AND cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.IND_BORR = 0 ");

        StringBuffer UA = new StringBuffer();

        // Busca los clientes 
        if (subg != null) {
            // De las subgerencias
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");
            query.append(" AND z.ZORG_OID_REGI = r.OID_REGI ");
            query.append(" AND r.IND_ACTI = 1 ");
            query.append(" AND r.IND_BORR = 0 ");

            for (int i = 0; i < subg.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(subg[i]);
            }

            query.append(" AND r.ZSGV_OID_SUBG_VENT IN (" + UA.toString() + ") ");
        } else if (region != null) {
            // De las regiones
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");

            for (int i = 0; i < region.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(region[i]);
            }

            query.append(" AND z.ZORG_OID_REGI IN (" + UA.toString() + ") ");
        } else if (zona != null) {
            // De las zonas
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");

            for (int i = 0; i < zona.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(zona[i]);
            }

            query.append(" AND s.ZZON_OID_ZONA IN (" + UA.toString() + ") ");
        } else if (seccion != null) {
            // De las secciones                                  
            for (int i = 0; i < seccion.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(seccion[i]);
            }

            query.append(" AND terrAdm.ZSCC_OID_SECC IN (" + UA.toString() + ") ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOCalcularComisiones.recuperarConsultoras(Long oidPeriodo, DTOGerenteZona dto): Salida");

        return dtoSalida;
    }

    /**
    *@Author: Pcabrera, 08/04/2005
    *@throws es.indra.mare.common.exception.MareException
    *@return BigDecimal
    *@param  oidPeriodo
    *@param  
    *@cambio jpbosnja se cambia porque anda mal!!!!!
    */
    public BigDecimal calcularCuotas(Long oidPeriodo, ArrayList consultoras) throws MareException {
        /*
         *    Hacer una consulta JDBC en la entidad Movimiento Cuenta Corriente
              filtrando por los parámetros recibidos
              -> Hacer la suma del campo IMP_MOVI de los registros encontrados.
              -> Retornar el campo importe
        *
        */
        UtilidadesLog.info("DAOCalcularComisiones.calcularCuotas(Long oidPeriodo, ArrayList consultoras): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append(" SELECT SUM(cuenta.IMP_MOVI) as suma ");
        query.append(" FROM ccc_movim_cuent_corri cuenta ");

        //query.append(" WHERE cuenta.clie_oid_clie = " + oidCliente );
        query.append(" WHERE cuenta.CLIE_OID_CLIE in ( ");

        // vbongiov -- 25/10/2006
        int h=0;
        int num = consultoras.size();
        
        for (int i = 0; i < num; i++) {
            
            if(h>999){
                query = query.delete(query.length() - 2, query.length());
                query.append("  ) OR cuenta.CLIE_OID_CLIE IN (  ");
                h=0;
            }                
            
            if (i == (num - 1)) {
                query.append(consultoras.get(i));
            } else {
                query.append(consultoras.get(i) + ", ");
            }
            
            h++;
        }
       
        query.append(" ) ");
        query.append(" AND cuenta.PERD_OID_PERI = " + oidPeriodo);

        //query.append(" group by cuenta.clie_oid_clie ");    
        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //20-09-2005 - rgiorgi: incidencia Perú COM-12
        //if(!rs.esVacio()) {
        if (!rs.esVacio() && (rs.getValueAt(0, 0) != null)) {
            UtilidadesLog.info("DAOCalcularComisiones.calcularCuotas(Long oidPeriodo, ArrayList consultoras): Salida");

            return new BigDecimal(rs.getValueAt(0, 0).toString());
        } else {
            UtilidadesLog.info("DAOCalcularComisiones.calcularCuotas(Long oidPeriodo, ArrayList consultoras): Salida");

            return new BigDecimal(0);
        }
    }

    /**
     *@Author: pperez
     *@Fecha: 12/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones: DTOSalida recuperarConsolidados(Long oidPeriodo, Long oidCliente, Long oidAcceso)
    */
    public DTOSalida recuperarConsolidados(Long oidPeriodo, Long oidCliente, Long[] oidAccesos) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarConsolidados(Long oidPeriodo, Long oidCliente, Long[] oidAccesos): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT oid_soli_cabe, VAL_NUME_SOLI  ");
            query.append("    FROM ped_solic_cabec ca, seg_acces ac, seg_subac sub  ");
            query.append("   WHERE ca.clie_oid_clie =  " + oidCliente);
            query.append("     AND ca.perd_oid_peri = " + oidPeriodo);
            query.append("     AND ca.sbac_oid_sbac = sub.oid_sbac  ");
            query.append("     AND sub.acce_oid_acce = ac.oid_acce  ");
            query.append("     AND ac.oid_acce IN (" + arrayToString(oidAccesos) + ") ");
            query.append("     AND ca.ind_ts_no_conso != 1 ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarConsolidados(Long oidPeriodo, Long oidCliente, Long[] oidAccesos): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha: 12/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones: DTOSalida recuperarCuotas(Long oidCliente, Long numSolic)
    */
    public DTOSalida recuperarCuotas(Long oidCliente, Long numSolic) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarCuotas(Long oidCliente, Long numSolic): Entrada");
        
        String ejercCuota = cerosIzq(numSolic.toString().substring(0,(numSolic.toString().length()-8)), 2);
        UtilidadesLog.debug("ejercCuota: " + ejercCuota);
        String numIdenCuota = removerCerosIzq(numSolic.toString().substring(numSolic.toString().length()-8));
        UtilidadesLog.debug("numIdenCuota: " + numIdenCuota);

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT cuota.oid_movi_cc OID, cuota.imp_pend importependiente,  ");
            query.append("         cuota.fec_docu fechadocumento, cuota.fec_venc fechavencimiento  ");
            query.append("    FROM ccc_movim_cuent_corri cuota  ");
            query.append("   WHERE cuota.clie_oid_clie =   " + oidCliente);
            query.append("   AND cuota.NUM_IDEN_CUOT = " + numIdenCuota);
            query.append("   AND cuota.VAL_EJER_CUOT = '" + ejercCuota + "' ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarCuotas(Long oidCliente, Long numSolic): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha: 12/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones: DTOSalida validarFechaConsolidado(Long oidCuota)
    */
    public DTOSalida validarFechaConsolidado(Long oidCuota) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.validarFechaConsolidado(Long oidCuota): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT cuota.oid_movi_cc OID, cuota.FEC_ULTI_MOVI FECHAMOVI ");
            query.append("   FROM ccc_movim_cuent_corri cuota  ");
            query.append("   WHERE cuota.oid_movi_cc =  " + oidCuota);

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.validarFechaConsolidado(Long oidCuota): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha: 12/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones: DTOSalida recuperarSolicitudes(Long oidConsolidado)
     * @cambio Incidencia SiCC 20070278. Se verifica que las posiciones sean estadisticables.
     * @autor gdmarzi
    */
    public DTOSalida recuperarSolicitudes(Long oidConsolidado) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarSolicitudes(Long oidConsolidado): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT ptsp.oid_tipo_soli_pais tiposolicitudpais,  ");
            query.append("         pts.clso_oid_clas_soli clasesolicitud, cabec.fec_fact fechafacturacion,  ");
            query.append("         cabec.num_docu_orig documentolegal, sposi.ind_limi_vent limiteventa,  ");
            query.append("         sposi.ind_ctrl_stoc controlstock,  ");
            query.append("         sposi.ind_ctrl_liqu controlliquidacion,  ");
            query.append("         sposi.num_unid_dema unidadesdemandadas,  ");
            query.append("         sposi.num_unid_aten unidadesatendidas,  ");
            query.append("         sposi.val_prec_cata_unit_loca preciocatalogo,  ");
            query.append("         sposi.val_prec_neto_unit_loca precioneto, ptsp.pais_oid_pais pais,  ");
            query.append("         sposi.prod_oid_prod producto, sposi.VAL_PREC_FACT_unit_LOCA preciofactura  ");
            query.append("    FROM ped_tipo_solic pts,  ");
            query.append("         ped_tipo_solic_pais ptsp,  ");
            query.append("         ped_solic_posic sposi,  ");
            query.append("         ped_solic_cabec cabec,  ");
            query.append("         pre_ofert_detal oferDetal, ");
            query.append("         pre_tipo_ofert tipoOfer ");
            query.append("   WHERE pts.oid_tipo_soli = ptsp.tsol_oid_tipo_soli  ");
            query.append("     AND cabec.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais  ");
            query.append("     AND sposi.soca_oid_soli_cabe = cabec.oid_soli_cabe  ");
            query.append("     AND cabec.SOCA_OID_SOLI_CABE = " + oidConsolidado);
            query.append("     AND sposi.ofde_oid_deta_ofer = oferDetal.ofer_oid_ofer ");
            query.append("     AND oferDetal.tofe_oid_tipo_ofer = tipoOfer.oid_tipo_ofer ");
            query.append("     AND tipoOfer.ind_esta = 1 ");
            query.append("  ORDER BY tiposolicitudpais, sposi.OID_SOLI_POSI  ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarSolicitudes(Long oidConsolidado): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha: 12/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones:  DTOSalida recuperarComisionesProductos(Long oidComision)
    */
    public DTOSalida recuperarComisionesProductos(Long oidComision) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarComisionesProductos(Long oidComision): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT sgen_oid_supe_gene supergenerico, nego_oid_nego negocio,  ");
            query.append("         gene_oid_gene generico, uneg_oid_unid_nego unidadnegocio,  ");
            query.append("         mapr_oid_marc_prod marca, tofe_oid_tipo_ofer tipooferta,  ");
            query.append("         prod_oid_prod producto, copr_oid_comi_prod,  ");
            query.append("         tprodu.cod_tipo_prod indicadorie, civi_oid_cicl_vida ciclovida,  ");
            query.append("         cra.cana_oid_cana canal  ");
            query.append("    FROM com_comis_produ cprodu,  ");
            query.append("         com_tipo_produ tprodu,  ");
            query.append("         cra_perio cra,  ");
            query.append("         com_comis com  ");
            query.append("   WHERE cprodu.comi_oid_comi = " + oidComision);
            query.append("     AND cprodu.comi_oid_comi = com.oid_comi  ");
            query.append("     AND tprodu.oid_tipo_prod = cprodu.tpro_oid_tipo_prod  ");
            query.append("     AND cra.oid_peri = com.perd_oid_peri  ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarComisionesProductos(Long oidComision): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha: 13/04/2005
     *@throws:
     *@return:
     *@param:
     *@Observaciones: DTOSalida recuperarProductos(Long oidProducto, Long oidPeriodo)
    */
    public DTOSalida recuperarProductos(Long oidProducto, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarProductos(Long oidProducto, Long oidPeriodo): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("  SELECT pr.mapr_oid_marc_prod marca, pr.uneg_oid_unid_nego unegocio,  ");
            query.append("         pr.nego_oid_nego negocio, pr.gene_oid_gene generico,  ");
            query.append("         pr.sgen_oid_supe_gene supergenerico, peri.cana_oid_cana canal,  ");
            query.append("         deta.tofe_oid_tipo_ofer tipooferta, deta.civi_oid_ciclo_vida ciclovida, pr.oid_prod producto  ");
            query.append("    FROM mae_produ pr,  ");
            query.append("         pre_ofert_detal deta,  ");
            query.append("         pre_ofert ofer,  ");
            query.append("         pre_matri_factu_cabec cabe,  ");
            query.append("         cra_perio peri  ");
            query.append("   WHERE pr.oid_prod = " + oidProducto);
            query.append("     AND deta.ofer_oid_ofer = ofer.oid_ofer  ");
            query.append("     AND ofer.mfca_oid_cabe = cabe.oid_cabe  ");
            query.append("     AND cabe.perd_oid_peri = peri.oid_peri  ");
            query.append("     AND deta.prod_oid_prod = pr.oid_prod  ");
            query.append("     AND peri.oid_peri =  " + oidPeriodo);

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarProductos(Long oidProducto, Long oidPeriodo): Salida");

        return new DTOSalida(respuesta);
    }

    /**
     *@Author: pperez
     *@Fecha:
     *@throws:
     *@return:
     *@param:
     *@Observaciones:
    */
    public DTOSalida recuperarComisionesMetasSAP(Long oidPeriodo, DTOGerenteZona dtoGerente) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.recuperarComisionesMetasSAP(Long oidPeriodo, DTOGerenteZona dtoGerente): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            if (dtoGerente.getOidSubgerenciaVentas() != null) {
                query.append("     SELECT   SUM (intsap.val_vent_neta_esta) vtanetaestadisticable   ");
                query.append("         FROM INT_FUENT_VENTA_PREVI_SAP intsap, ZON_ZONA zona, ZON_REGIO region   ");
                query.append("        WHERE intsap.perd_oid_peri = " + oidPeriodo);
                query.append("          AND intsap.ZZON_OID_ZONA = zona.OID_ZONA   ");
                query.append("          AND zona.ZORG_OID_REGI = region.OID_REGI   ");
                query.append("     	    AND region.ZSGV_OID_SUBG_VENT = (" + arrayToString(dtoGerente.getOidSubgerenciaVentas()) + ")   ");
                query.append("     GROUP BY intsap.perd_oid_peri   ");
            } else if (dtoGerente.getOidRegion() != null) {
                query.append("     SELECT   SUM (intsap.val_vent_neta_esta) vtanetaestadisticable   ");
                query.append("         FROM INT_FUENT_VENTA_PREVI_SAP intsap, ZON_ZONA zona   ");
                query.append("        WHERE intsap.perd_oid_peri = " + oidPeriodo);
                query.append("          AND intsap.ZZON_OID_ZONA = zona.OID_ZONA   ");
                query.append("          AND zona.ZORG_OID_REGI IN (" + arrayToString(dtoGerente.getOidRegion()) + ")   ");
                query.append("     GROUP BY intsap.perd_oid_peri   ");
            } else if (dtoGerente.getOidZona() != null) {
                query.append("     SELECT   SUM (intsap.val_vent_neta_esta) vtanetaestadisticable  ");
                query.append("         FROM INT_FUENT_VENTA_PREVI_SAP intsap  ");
                query.append("        WHERE intsap.perd_oid_peri = " + oidPeriodo);
                query.append("          AND intsap.ZZON_OID_ZONA IN (" + arrayToString(dtoGerente.getOidZona()) + ")   ");
                query.append("     GROUP BY intsap.perd_oid_peri    ");
            } else if (dtoGerente.getOidSeccion() != null) {
                query.append("     SELECT SUM (intsap.val_vent_neta_esta) vtanetaestadisticable   ");
                query.append("       FROM INT_FUENT_VENTA_PREVI_SAP intsap, ZON_SECCI secci   ");
                query.append("      WHERE intsap.perd_oid_peri =   " + oidPeriodo);
                query.append("        AND intsap.zzon_oid_zona = secci.zzon_oid_zona   ");
                query.append("        AND secci.oid_secc IN (" + arrayToString(dtoGerente.getOidSeccion()) + ")   ");
                query.append("     GROUP BY intsap.perd_oid_peri  ");
            }

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCalcularComisiones.recuperarComisionesMetasSAP(Long oidPeriodo, DTOGerenteZona dtoGerente): Salida");

        return new DTOSalida(respuesta);
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      COM
           * Fecha:       08/04/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
     * @modificado jpbosnja porque estaba mal
           */

    //public BigDecimal calcularImportePago(Long consultora, Integer tramoActual, Integer tramoAnterior, DTODatosCalculosComision dto) throws MareException {
    public DTOCalculoReporte calcularImportePago(DTOGerenteZona gerenteZona, Integer tramoActual, Integer tramoAnterior, DTODatosCalculosComision dto) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.calcularImportePago(ArrayList consultoras, Integer tramoActual, Integer tramoAnterior, DTODatosCalculosComision dto): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer oidAcceso = new StringBuffer();
        Long[] oidAccesoArr = dto.getOidAccesos();
        
        DTOCalculoReporte dtoCalculoReporte = new DTOCalculoReporte();
        DTOCuotaCalculoReporte dtoCuotaCalculoReporte = null;
        //se cambian los campos de fecha
        //primer query: fec_valo ====> fec_movi
        //segundo query: fec_valo ===> fec_ulti_movi
        //Se usa el alias para zafar ;) (Gacevedo)
        
        query.append(" SELECT cuentaCorr.oidCuota, cuentaCorr.VAL_EJER_CUOT, cuentaCorr.CLIE_OID_CLIE, cuentaCorr.COD_TERR, ");
        query.append(" cuentaCorr.FEC_DOCU, cuentaCorr.fec_movi as fec_valo, NVL(cuentaCorr.IMP_PAGO,0) IMP_PAGO, NVL(cuentaCorr.IMP_MOVI,0) IMP_MOVI ");
        query.append(" FROM ( ");
        query.append(" SELECT hist.MVCC_OID_MOVI_CC oidCuota, ccc.VAL_EJER_CUOT, ccc.CLIE_OID_CLIE, terr.COD_TERR, ");
        query.append(" hist.FEC_DOCU, hist.fec_movi, hist.IMP_PAGO, hist.IMP_MOVI ");
        query.append(" FROM CCC_HISTO_MOVIM_CC hist, CCC_MOVIM_CUENT_CORRI ccc, SEG_SUBAC subacc, ");
        query.append(" ZON_TERRI_ADMIN terrAdm, ZON_TERRI terr ");
        query.append(" WHERE hist.MVCC_OID_MOVI_CC = ccc.OID_MOVI_CC ");
      
        query.append("  AND EXISTS ( ");

        // vbongiov -- 27/10/2006
        query.append(" SELECT DISTINCT cliadm.CLIE_OID_CLIE  ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN cliAdm, ZON_TERRI_ADMIN terrAdm, ");

        // UA
        Long[] subg = gerenteZona.getOidSubgerenciaVentas();
        Long[] region = gerenteZona.getOidRegion();
        Long[] zona = gerenteZona.getOidZona();
        Long[] seccion = gerenteZona.getOidSeccion();

        if (subg != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ZON_REGIO r, ");
        } else if (region != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ");
        } else if (zona != null) {
            query.append(" ZON_SECCI s, ");
        }

        query.append(" CRA_PERIO cra, CRA_PERIO craI, CRA_PERIO craF ");
        query.append(" WHERE cliAdm.IND_ACTI = 1 ");
        query.append(" AND cra.OID_PERI = " + dto.getOidPeriodo());
        query.append(" AND craI.OID_PERI = PERD_OID_PERI_INI ");
        query.append(" AND craF.OID_PERI(+) = PERD_OID_PERI_FIN ");
        query.append(" AND craI.FEC_INIC <= cra.FEC_INIC ");
        query.append(" AND (PERD_OID_PERI_FIN IS NULL OR cra.FEC_FINA <= craF.FEC_FINA) ");
        query.append(" AND cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.IND_BORR = 0 ");

        StringBuffer UA = new StringBuffer();

        // Busca los clientes 
        if (subg != null) {
            // De las subgerencias
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");
            query.append(" AND z.ZORG_OID_REGI = r.OID_REGI ");
            query.append(" AND r.IND_ACTI = 1 ");
            query.append(" AND r.IND_BORR = 0 ");

            for (int i = 0; i < subg.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(subg[i]);
            }

            query.append(" AND r.ZSGV_OID_SUBG_VENT IN (" + UA.toString() + ") ");
        } else if (region != null) {
            // De las regiones
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");

            for (int i = 0; i < region.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(region[i]);
            }

            query.append(" AND z.ZORG_OID_REGI IN (" + UA.toString() + ") ");
        } else if (zona != null) {
            // De las zonas
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");

            for (int i = 0; i < zona.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(zona[i]);
            }

            query.append(" AND s.ZZON_OID_ZONA IN (" + UA.toString() + ") ");
        } else if (seccion != null) {
            // De las secciones                                  
            for (int i = 0; i < seccion.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(seccion[i]);
            }

            query.append(" AND terrAdm.ZSCC_OID_SECC IN (" + UA.toString() + ") ");
        }

        query.append(" AND cliadm.clie_oid_clie = ccc.clie_oid_clie ) ");
        
        query.append(" AND ccc.PERD_OID_PERI = " + dto.getOidPeriodo());
        query.append(" AND ccc.SBAC_OID_SBAC = subacc.OID_SBAC ");

        for (int i = 0; i < oidAccesoArr.length; i++) {
            if (i != 0) {
                oidAcceso.append(" ,");
            }

            oidAcceso.append(oidAccesoArr[i]);
        }

        query.append(" AND subacc.ACCE_OID_ACCE IN ( " + oidAcceso.toString() + ") ");
        query.append(" AND hist.CLIE_OID_CLIE = ccc.CLIE_OID_CLIE ");        
        query.append(" AND ccc.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.TERR_OID_TERR = terr.OID_TERR ");
        query.append(" AND (TO_DATE(hist.FEC_MOVI) - TO_DATE(hist.FEC_DOCU)) BETWEEN (" + tramoAnterior + ") AND " + tramoActual + " ");
        
        /* 
         * dmorello, 13/07/2006: El valor del campo OIDCUOTA puede repetirse en
         * las dos queries que se unen, y hay que considerar todos los registros.
         * Se cambia UNION por UNION ALL.
         */
        //query.append(" UNION ");
        query.append(" UNION ALL ");
        query.append(" SELECT ccc.OID_MOVI_CC oidCuota, ccc.VAL_EJER_CUOT, ccc.CLIE_OID_CLIE, terr.COD_TERR, ");
        //por homologacion de campos entre cuenta corriente e historico
        //el campo que se graba en IMP_MOVI del historico es IMP_MOVI_CUEN de la cuenta corriente
        query.append(" ccc.FEC_DOCU, ccc.fec_ulti_movi,ccc.IMP_PAGO, ccc.imp_movi_cuen ");
        query.append(" FROM CCC_MOVIM_CUENT_CORRI ccc, ");        
        query.append(" SEG_SUBAC subacc, ");
        query.append(" ZON_TERRI_ADMIN terrAdm, ZON_TERRI terr ");

        // vbongiov -- 27/10/2006
        query.append(" WHERE EXISTS ( ");
        query.append(" SELECT DISTINCT cliadm.CLIE_OID_CLIE  ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN cliAdm, ZON_TERRI_ADMIN terrAdm, ");

        if (subg != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ZON_REGIO r, ");
        } else if (region != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ");
        } else if (zona != null) {
            query.append(" ZON_SECCI s, ");
        }

        query.append(" CRA_PERIO cra, CRA_PERIO craI, CRA_PERIO craF ");
        query.append(" WHERE cliAdm.IND_ACTI = 1 ");
        query.append(" AND cra.OID_PERI = " + dto.getOidPeriodo());
        query.append(" AND craI.OID_PERI = PERD_OID_PERI_INI ");
        query.append(" AND craF.OID_PERI(+) = PERD_OID_PERI_FIN ");
        query.append(" AND craI.FEC_INIC <= cra.FEC_INIC ");
        query.append(" AND (PERD_OID_PERI_FIN IS NULL OR cra.FEC_FINA <= craF.FEC_FINA) ");
        query.append(" AND cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.IND_BORR = 0 ");

        UA = new StringBuffer();

        // Busca los clientes 
        if (subg != null) {
            // De las subgerencias
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");
            query.append(" AND z.ZORG_OID_REGI = r.OID_REGI ");
            query.append(" AND r.IND_ACTI = 1 ");
            query.append(" AND r.IND_BORR = 0 ");

            for (int i = 0; i < subg.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(subg[i]);
            }

            query.append(" AND r.ZSGV_OID_SUBG_VENT IN (" + UA.toString() + ") ");
        } else if (region != null) {
            // De las regiones
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");

            for (int i = 0; i < region.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(region[i]);
            }

            query.append(" AND z.ZORG_OID_REGI IN (" + UA.toString() + ") ");
        } else if (zona != null) {
            // De las zonas
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");

            for (int i = 0; i < zona.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(zona[i]);
            }

            query.append(" AND s.ZZON_OID_ZONA IN (" + UA.toString() + ") ");
        } else if (seccion != null) {
            // De las secciones                                  
            for (int i = 0; i < seccion.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(seccion[i]);
            }

            query.append(" AND terrAdm.ZSCC_OID_SECC IN (" + UA.toString() + ") ");
        }

        query.append(" AND cliadm.clie_oid_clie = ccc.clie_oid_clie ) ");
        
        query.append(" AND ccc.PERD_OID_PERI = " + dto.getOidPeriodo());
        query.append(" AND ccc.SBAC_OID_SBAC = subacc.OID_SBAC ");
        query.append(" AND subacc.ACCE_OID_ACCE IN ( " + oidAcceso.toString() + ") ");
        query.append(" AND ccc.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.TERR_OID_TERR = terr.OID_TERR ");
        query.append(" AND (TO_DATE(ccc.FEC_ULTI_MOVI) - TO_DATE(ccc.FEC_DOCU)) BETWEEN (" + tramoAnterior + " ) AND " + tramoActual + " ) cuentaCorr");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        // Valor de retorno
        if (rs.esVacio()) {
            dtoCalculoReporte.setImportePagado(new BigDecimal(0));
            
            UtilidadesLog.debug("dtoCalculoReporte: " + dtoCalculoReporte);
            
            UtilidadesLog.info("DAOCalcularComisiones.calcularImportePago(ArrayList consultoras, Integer tramoActual, Integer tramoAnterior, DTODatosCalculosComision dto): Salida");
            
            return dtoCalculoReporte;
            
        } else {
        
            int cant = rs.getRowCount();
            BigDecimal importePagoTotal = new BigDecimal(0);
            BigDecimal importePago = null;
            ArrayList cuotas = new ArrayList();
            
            for(int i=0; i < cant; i++) {
                dtoCuotaCalculoReporte = new DTOCuotaCalculoReporte();
                
                dtoCuotaCalculoReporte.setOidCuota(new Long(((BigDecimal)rs.getValueAt(i, "OIDCUOTA")).toString()));
                dtoCuotaCalculoReporte.setEjerCuota((String)rs.getValueAt(i, "VAL_EJER_CUOT"));
                dtoCuotaCalculoReporte.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).toString()));
                dtoCuotaCalculoReporte.setCodTerri(new Integer(((BigDecimal)rs.getValueAt(i, "COD_TERR")).toString()));
                
                dtoCuotaCalculoReporte.setFechaDocu((Date)rs.getValueAt(i, "FEC_DOCU"));
                dtoCuotaCalculoReporte.setFechaValor((Date)rs.getValueAt(i, "FEC_VALO"));
                
                importePago = (BigDecimal)rs.getValueAt(i, "IMP_PAGO");
                
                dtoCuotaCalculoReporte.setImportePagado(importePago);
                dtoCuotaCalculoReporte.setImporteCuota((BigDecimal)rs.getValueAt(i, "IMP_MOVI"));
                
                cuotas.add(dtoCuotaCalculoReporte);
                
                // Sumo todas las cuotas                
                importePagoTotal = importePagoTotal.add(importePago);
            }
            
            // Arma el dto de salida
            dtoCalculoReporte.setImportePagado(importePagoTotal);
            dtoCalculoReporte.setCuota(cuotas);            
        
            UtilidadesLog.debug("dtoCalculoReporte: " + dtoCalculoReporte);
            
            UtilidadesLog.info("DAOCalcularComisiones.calcularImportePago(ArrayList consultoras, Integer tramoActual, Integer tramoAnterior, DTODatosCalculosComision dto): Salida");
            
            return dtoCalculoReporte;
        }
    }
    
    /**
     * Sistema:     Belcorp
     * Modulo:      COM
     * Fecha:       27/10/2006
     * @version     1.0
     * @autor       Viviana Bongiovanni
     */
    public Boolean hayConsultoras(Long oidPeriodo, DTOGerenteZona dto) throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.hayConsultoras(Long oidPeriodo, DTOGerenteZona dto): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        query.append(" SELECT COUNT(1)  ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN cliAdm, ZON_TERRI_ADMIN terrAdm, ");

        // UA
        Long[] subg = dto.getOidSubgerenciaVentas();
        Long[] region = dto.getOidRegion();
        Long[] zona = dto.getOidZona();
        Long[] seccion = dto.getOidSeccion();

        if (subg != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ZON_REGIO r, ");
        } else if (region != null) {
            query.append(" ZON_SECCI s, ZON_ZONA z, ");
        } else if (zona != null) {
            query.append(" ZON_SECCI s, ");
        }

        query.append(" CRA_PERIO cra, CRA_PERIO craI, CRA_PERIO craF ");
        query.append(" WHERE cliAdm.IND_ACTI = 1 ");
        query.append(" AND cra.OID_PERI = " + oidPeriodo);
        query.append(" AND craI.OID_PERI = PERD_OID_PERI_INI ");
        query.append(" AND craF.OID_PERI(+) = PERD_OID_PERI_FIN ");
        query.append(" AND craI.FEC_INIC <= cra.FEC_INIC ");
        query.append(" AND (PERD_OID_PERI_FIN IS NULL OR cra.FEC_FINA <= craF.FEC_FINA) ");
        query.append(" AND cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
        query.append(" AND terrAdm.IND_BORR = 0 ");

        StringBuffer UA = new StringBuffer();

        // Busca los clientes 
        if (subg != null) {
            // De las subgerencias
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");
            query.append(" AND z.ZORG_OID_REGI = r.OID_REGI ");
            query.append(" AND r.IND_ACTI = 1 ");
            query.append(" AND r.IND_BORR = 0 ");

            for (int i = 0; i < subg.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(subg[i]);
            }

            query.append(" AND r.ZSGV_OID_SUBG_VENT IN (" + UA.toString() + ") ");
        } else if (region != null) {
            // De las regiones
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");
            query.append(" AND s.ZZON_OID_ZONA = z.OID_ZONA ");
            query.append(" AND z.IND_ACTI = 1 ");
            query.append(" AND z.IND_BORR = 0 ");

            for (int i = 0; i < region.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(region[i]);
            }

            query.append(" AND z.ZORG_OID_REGI IN (" + UA.toString() + ") ");
        } else if (zona != null) {
            // De las zonas
            query.append(" AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
            query.append(" AND s.IND_ACTI = 1 ");
            query.append(" AND s.IND_BORR = 0 ");

            for (int i = 0; i < zona.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(zona[i]);
            }

            query.append(" AND s.ZZON_OID_ZONA IN (" + UA.toString() + ") ");
        } else if (seccion != null) {
            // De las secciones                                  
            for (int i = 0; i < seccion.length; i++) {
                if (i != 0) {
                    UA.append(" ,");
                }

                UA.append(seccion[i]);
            }

            query.append(" AND terrAdm.ZSCC_OID_SECC IN (" + UA.toString() + ") ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        Boolean hayConsultoras = null;
        
        if(!(((BigDecimal)rs.getValueAt(0, 0)).toString().equals("0"))){
            hayConsultoras = Boolean.TRUE;
        } else {
            hayConsultoras = Boolean.FALSE;
        }
        
        UtilidadesLog.debug("hayConsultoras: " + hayConsultoras);

        UtilidadesLog.info("DAOCalcularComisiones.hayConsultoras(Long oidPeriodo, DTOGerenteZona dto): Salida");
        return hayConsultoras;     
    }

    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();

            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }

    private String arrayToString(Long[] array) {
        UtilidadesLog.info("DAOCalcularComisiones.arrayToString(Long[] array): Entrada");

        StringBuffer strSalida = new StringBuffer();

        for (int i = 0; i < (array.length - 1); i++) {
            strSalida.append(array[i] + ",");
        }

        strSalida.append(array[array.length - 1]);
        UtilidadesLog.info("DAOCalcularComisiones.arrayToString(Long[] array): Salida");

        return strSalida.toString();
    }
    
   /**
	 * Sistema:     Belcorp
	 * Modulo:      COM
	 * Fecha:       04/11/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    private String cerosIzq(String cadena1, int cantidad) {
    
        UtilidadesLog.info("DAOCalcularComisiones.cerosIzq(String cadena1, int cantidad): Entrada ");
        UtilidadesLog.debug("cadena1: " + cadena1);
        
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
        
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        
        UtilidadesLog.info("DAOCalcularComisiones.cerosIzq(String cadena1, int cantidad): Salida ");
        return cadena2.toString();
    }
    
    /**
	 * Sistema:     Belcorp
	 * Modulo:      COM
	 * Fecha:       04/11/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    private String removerCerosIzq(String cadena) {
    
        UtilidadesLog.info("DAOCalcularComisiones.removerCerosIzq(String cadena1): Entrada ");
        UtilidadesLog.debug("cadena: " + cadena);
        String cadena1 = "";
        String cadena2 = "";
        
        for(int i=0; i < cadena.length() ;i++) {
            cadena1 = cadena.substring(i,i+1);
            UtilidadesLog.debug("cadena1: " + cadena1);
            
            if(!cadena1.equals("0")) {
              cadena2 = cadena.substring(i); 
              break;
            }
        }
        
        UtilidadesLog.info("DAOCalcularComisiones.removerCerosIzq(String cadena1): Salida ");
        return cadena2;
    }
    
    /**
     * Recibe un conjunto de Gerentes de cualquier nivel de UA y valida que
     * pertenezca a la jerarquia definida para la comision
     * @author eiroala
     * @date 17/11/2006 
     * @observacion Metodo creado por inc. DBLG700000215
     */
    public DTOGerenteZona validarGerenteAlcanceGeo(Long oidCliente, DTODatosCalculosComision dto) 
            throws MareException {
        UtilidadesLog.info("DAOCalcularComisiones.validarGerenteAlcanceGeo(Long oidCLiente, DTODatosCalculosComision dto): Entrada");
        /* Premisas: Un gerente puede tener a su cargo varias UA pero siempre
         * que correspondan a un mismo nivel Ej. Gerente de varias regiones
         */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        // Validamos si el Gerente es de la SUBGERENCIA que indique la Comision
        // (si la comision no indica subgerencia entonces cualquier gerente sera
        // valido)
        query.append("SELECT oid_subg_vent OID, ");
        query.append("'SUBGERENCIA' tipo ");
        query.append("FROM zon_sub_geren_venta sgv ");
        query.append("WHERE sgv.clie_oid_clie = " + oidCliente);
        query.append(" AND sgv.IND_BORR = 0");
        query.append(" AND sgv.IND_ACTI = 1");
        query.append(" AND sgv.pais_oid_pais = " + dto.getOidPais());

        if (dto.getOidSV() != null) {
            query.append(" AND sgv.oid_subg_vent = " + dto.getOidSV());
        }
        
        query.append(" UNION ALL ");
        
        // Validamos si el Gerente es de la REGION que indique la Comision
        // (si la comision no indica region entonces cualquier gerente de una
        // region perteneciente a la subgerencia que indique sera valido)
        query.append("SELECT oid_regi OID, ");
        query.append("'REGION' tipo ");
        query.append("FROM zon_regio r ");
        query.append("WHERE r.clie_oid_clie = " + oidCliente);
        query.append(" AND r.IND_BORR = 0");
        query.append(" AND r.IND_ACTI = 1");
        query.append(" AND r.pais_oid_pais = " + dto.getOidPais());
        
        if (dto.getOidSV() != null) {
            query.append(" AND r.ZSGV_OID_SUBG_VENT = " + dto.getOidSV());
            
            if (dto.getOidRegion() != null) {
                query.append(" AND r.oid_regi = " + dto.getOidRegion());
            }
        }
        
        query.append(" UNION ALL ");
        
        query.append("SELECT oid_zona OID, ");
        query.append("'ZONA' tipo ");
        query.append("FROM zon_zona z ");
        query.append("WHERE z.clie_oid_clie = " + oidCliente);
        query.append(" AND z.IND_BORR = 0");
        query.append(" AND z.IND_ACTI = 1");
        query.append(" AND z.pais_oid_pais = " + dto.getOidPais());

        if (dto.getOidSV() != null) {
            if (dto.getOidRegion() != null) {
                query.append(" AND z.ZORG_OID_REGI = " + dto.getOidRegion());
                
                if (dto.getOidZona() != null) {
                    query.append(" AND z.oid_zona = " + dto.getOidZona());
                }
            } else {
                query.append("AND z.zorg_oid_regi IN (");
                query.append("SELECT r.oid_regi FROM zon_regio r WHERE r.ZSGV_OID_SUBG_VENT = " + dto.getOidSV() + ")");
            }
        }
        
        query.append(" UNION ALL ");

        query.append("SELECT oid_secc OID, ");
        query.append("'SECCION' tipo ");
        query.append("FROM zon_secci s ");
        query.append("WHERE s.clie_oid_clie = " + oidCliente);
        query.append(" AND s.IND_BORR = 0");
        query.append(" AND s.IND_ACTI = 1");
        
        if (dto.getOidSV() != null) {
            if (dto.getOidRegion() != null) {
                if (dto.getOidZona() != null) {
                    query.append(" AND s.ZZON_OID_ZONA = " + dto.getOidZona());
            
                    if (dto.getOidSeccion() != null) {            
                        query.append(" AND s.oid_secc = " + dto.getOidSeccion());
                    }
                } else {
                    query.append("AND s.zzon_oid_zona IN (SELECT z.oid_zona FROM "); 
                    query.append("zon_zona z WHERE z.ZORG_OID_REGI = " + dto.getOidRegion() + ")" );
                }
            } else {
                query.append("AND s.zzon_oid_zona IN (SELECT z.oid_zona FROM zon_zona z ");
                query.append("WHERE z.ZORG_OID_REGI IN (");
                query.append("SELECT r.oid_regi FROM zon_regio r WHERE r.ZSGV_OID_SUBG_VENT = " + dto.getOidSV() + "))" );
            }
        }
        

        DTOGerenteZona dtoG = null;

        try {
            rs =  bs.dbService.executeStaticQuery(query.toString());

            if (!rs.esVacio()) {
                int cantAmbitosGerenciados = rs.getRowCount();
                UtilidadesLog.debug("Cantidad de Gerencias del ambito de comision a su cargo ::: " + rs.getRowCount());
                
                dtoG = new DTOGerenteZona();

                ArrayList subg = new ArrayList();
                ArrayList region = new ArrayList();
                ArrayList zona = new ArrayList();
                ArrayList seccion = new ArrayList();
                
                String concepto;
                String oid;

                for (int i = 0; i < cantAmbitosGerenciados; i++) {
                    oid = rs.getValueAt(i, "OID").toString();
                    concepto = rs.getValueAt(i, "TIPO").toString();
                    
                    if (concepto.equals("SUBGERENCIA")) {
                        subg.add(subg.size(), new Long(oid));
                    } else if (concepto.equals("REGION")) {
                        region.add(region.size(), new Long(oid));
                    } else if (concepto.equals("ZONA")) {
                        zona.add(zona.size(), new Long(oid));
                    } else if (concepto.equals("SECCION")) {
                        seccion.add(seccion.size(), new Long(oid));
                    }
                    
                    Long[] arraySub = (Long[]) subg.toArray(new Long[subg.size()]);
                    Long[] arrayRegion = (Long[]) region.toArray(new Long[region.size()]);
                    Long[] arrayZona = (Long[]) zona.toArray(new Long[zona.size()]);
                    Long[] arraySeccion = (Long[]) seccion.toArray(new Long[seccion.size()]);

                    // Guardamos la jerarquia de UA mas alta
                    if (arraySub.length != 0) {
                        dtoG.setOidSubgerenciaVentas(arraySub);
                    } else if (arrayRegion.length != 0) {
                        dtoG.setOidRegion(arrayRegion);
                    } else if (arrayZona.length != 0) {
                        dtoG.setOidZona(arrayZona);
                    } else if (arraySeccion.length != 0) {
                        dtoG.setOidSeccion(arraySeccion);
                    }

                    dtoG.setOidGerente(oidCliente);
                }
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOCalcularComisiones.validarGerenteAlcanceGeo(Long oidCLiente, DTODatosCalculosComision dto): Salida");
        return dtoG;
    }
}
