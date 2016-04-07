/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es pobtenerMensajesImpresionropiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonImpresion;
import es.indra.sicc.dtos.msg.DTODestinatarioMensaje;
import es.indra.sicc.dtos.msg.DTOMensajeImpresion;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.dtos.msg.DTOSeleccionMensajes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;


public class DAOImpresion {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOImpresion() {
    }

    /*
     * 13/12/2004 - pperez: metodo obtenerMensajesImpresion
     * 15/06/2005 - rgiorgi: inc. 19162
     * 21/02/2006 - pperanzola: se corrige para mejorar la performance de la consulta
     * */
    public DTOMensajeImpresion[] obtenerMensajesImpresion(DTOFACCabeceraSolicitud dto) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerMensajesImpresion(Long periodo, Long oidCliente, Long pais): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();
        Vector nMensajes = new Vector();

        try {
            
            /*buf.append(" SELECT mensa.oid_mens, mensa.val_text, mensa.tper_oid_tipo_perm, mensa.fec_perm_desd,  ");
            buf.append("        mensa.fec_perm_hast, mensa.tmen_oid_tipo_mens, mensa.cod_peri, ");
            buf.append("        mensa.cod_peri2, mensa.cod_peri3, mensa.tide_oid_tipo_dest, ");
            buf.append("        buzon.oid_buzo_mens, buzon.clie_oid_clie, buzon.num_secu, buzon.dato_vari_01, ");
            buf.append("        buzon.dato_vari_02, buzon.dato_vari_03, buzon.dato_vari_04, buzon.dato_vari_05, ");
            buf.append("        buzon.dato_vari_06, buzon.dato_vari_07, buzon.dato_vari_08, buzon.dato_vari_09, ");
            buf.append("        buzon.dato_vari_10, buzon.dato_vari_11, buzon.dato_vari_12, buzon.dato_vari_13, ");
            buf.append("        buzon.dato_vari_14, buzon.dato_vari_15, buzon.dato_vari_16, buzon.dato_vari_17, ");
            buf.append("        buzon.dato_vari_18, buzon.dato_vari_19, buzon.dato_vari_20, buzon.ind_esta_mens, ");
            buf.append("        buzon.modu_oid_modu_orig, buzon.val_nom1_clie, buzon.val_nom2_clie, ");
            buf.append("        buzon.val_ape1_clie, buzon.val_ape2_clie, buzon.val_apel_casa_clie, ");
            buf.append("        buzon.ind_list_cons, buzon.ind_acti, mensa.OID_PERI, mensa.ind_excl_tipo, ");
            buf.append(aniadirExisteUnidadAdministrativa(dto));
            buf.append(" FROM ");
            buf.append(" (SELECT c1.oid_peri ,a.oid_mens, a.val_text, a.tper_oid_tipo_perm, a.fec_perm_desd, ");
            buf.append("         a.fec_perm_hast, a.tmen_oid_tipo_mens, c1.oid_peri cod_peri, ");
            buf.append(" 		 d.oid_peri cod_peri2, e.oid_peri cod_peri3, b.tide_oid_tipo_dest, b.oid_mens_tipo_dest, a.ind_excl_tipo ");
            buf.append("   FROM msg_mensa_tipo_asign b, ");
            buf.append("        cra_perio c, ");
            buf.append("        seg_perio_corpo c1, ");
            buf.append("        seg_perio_corpo d, ");
            buf.append("        seg_perio_corpo e, ");
            buf.append("        msg_mensa a ");
            buf.append("   WHERE a.oid_mens = b.mens_oid_mens ");
            buf.append("    AND c.oid_peri = " + dto.getPeriodo());
            buf.append("    AND a.pais_oid_pais = " + dto.getOidPais());
            buf.append("    AND c.peri_oid_peri = c1.oid_peri ");
            buf.append("    AND a.peri_oid_peri_desd = d.oid_peri(+) ");
            buf.append("    AND a.peri_oid_peri_hast = e.oid_peri(+) ) mensa, ");
            buf.append(" (SELECT f.MENS_OID_MENS,f.oid_buzo_mens, f.clie_oid_clie, f.num_secu, f.dato_vari_01, ");
            buf.append("         f.dato_vari_02, f.dato_vari_03, f.dato_vari_04, f.dato_vari_05, ");
            buf.append("         f.dato_vari_06, f.dato_vari_07, f.dato_vari_08, f.dato_vari_09, ");
            buf.append("         f.dato_vari_10, f.dato_vari_11, f.dato_vari_12, f.dato_vari_13, ");
            buf.append("         f.dato_vari_14, f.dato_vari_15, f.dato_vari_16, f.dato_vari_17, ");
            buf.append("         f.dato_vari_18, f.dato_vari_19, f.dato_vari_20, f.ind_esta_mens, ");
            buf.append("         f.modu_oid_modu_orig, f.val_nom1_clie, f.val_nom2_clie, ");
            buf.append("         f.val_ape1_clie, f.val_ape2_clie, f.val_apel_casa_clie, ");
            buf.append("         f.ind_list_cons, f.ind_acti ");
            buf.append("    FROM msg_buzon_mensa f  ");
            buf.append("    WHERE f.clie_oid_clie = "+ dto.getOidCliente() + " and f.ind_acti = 1) buzon ");
            buf.append(" where mensa.oid_mens = buzon.MENS_OID_MENS(+) ");
            //buf.append(" and buzon.ind_acti = 1 ");
            buf.append(" ORDER BY mensa.oid_mens,mensa.oid_mens_tipo_dest,buzon.num_secu ");*/
            
             String ambitoGeografico = "";
             if ((dto.getTerritorio() != null) && (dto.getSeccion() != null) && (dto.getZona() != null) && (dto.getRegion() != null)) {
                 ambitoGeografico = "T";
             }
             if ((dto.getTerritorio() == null) && (dto.getSeccion() != null) && (dto.getZona() != null) && (dto.getRegion() != null)) {
                 ambitoGeografico = "S";
             }
             if ((dto.getTerritorio() == null) && (dto.getSeccion() == null) && (dto.getZona() != null) && (dto.getRegion() != null)) {
                 ambitoGeografico = "Z";             
             }
             if ((dto.getTerritorio() == null) && (dto.getSeccion() == null) && (dto.getZona() == null) && (dto.getRegion() != null)) {
                ambitoGeografico = "R";             
             }
             
            //sapaza -- cambio Optimizacion Querys GP5 -- 22/03/2011
            Vector params = new Vector();
            params.add(dto.getOidPais()); 
            params.add(dto.getOidCliente()); 
            params.add(dto.getPeriodo()); 
            params.add(ambitoGeografico); 
            params.add(dto.getTerritorio()); 
            params.add(dto.getSeccion()); 
            params.add(dto.getZona()); 
            params.add(dto.getRegion()); 
            respuesta = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.MSG_PR_OBTIE_DATOS_IMPRE", params);
            //respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
       
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("respuesta: " + respuesta);

        Long oidMensajeAnterior = new Long(-1);
        Long oidTipoDestinatarioAnterior = new Long(-1);
        Long oidBuzonAnterior = new Long(-1);

        DTOMensajeImpresion[] dtoMensajeImpresiones = new DTOMensajeImpresion[respuesta.getRowCount()];

        DTOMensajeImpresion dtoMensajeImpresion = null;
        Vector vDestinatario = null;
        Vector vBuzonImpresion = null;

        int j = 0;
        int k = 0;

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("Fila " + i + ": " + respuesta.getRow(i));
            if (((BigDecimal) respuesta.getValueAt(i, "OID_MENS")).intValue() != oidMensajeAnterior.intValue()) {
                dtoMensajeImpresion = new DTOMensajeImpresion();

                oidTipoDestinatarioAnterior = new Long(-1);
                oidBuzonAnterior = new Long(-1);
                j = 0;
                k = 0;
                oidMensajeAnterior = bigDecimalToLong(respuesta.getValueAt(i, "OID_MENS"));
                dtoMensajeImpresion.setOidMensaje(bigDecimalToLong(respuesta.getValueAt(i, "OID_MENS")));
                dtoMensajeImpresion.setTexto((String) respuesta.getValueAt(i, "VAL_TEXT"));
                dtoMensajeImpresion.setOidTipoPermanencia(bigDecimalToLong(respuesta.getValueAt(i, "TPER_OID_TIPO_PERM")));
                dtoMensajeImpresion.setFechaPermanenciaDesde((Date) respuesta.getValueAt(i, "FEC_PERM_DESD"));
                dtoMensajeImpresion.setFechaPermanenciaHasta((Date) respuesta.getValueAt(i, "FEC_PERM_HAST"));
                dtoMensajeImpresion.setOidTipoMensaje(bigDecimalToLong(respuesta.getValueAt(i, "TMEN_OID_TIPO_MENS")));
                dtoMensajeImpresion.setContadorUnidadAdministrativa(bigDecimalToLong(respuesta.getValueAt(i, "CONTADOR")));
                if (respuesta.getValueAt(i, "COD_PERI")!=null){
                    dtoMensajeImpresion.setCodigoPeriodoInicial(((BigDecimal) respuesta.getValueAt(i, "COD_PERI")).toString());
                }
                if (respuesta.getValueAt(i, "OID_PERI")!=null){
                    dtoMensajeImpresion.setOidPeriodo(new Long(respuesta.getValueAt(i, "OID_PERI").toString()));
                }
                if (respuesta.getValueAt(i, "COD_PERI2")!=null){
                    dtoMensajeImpresion.setCodigoPeriodoDesde(((BigDecimal) respuesta.getValueAt(i, "COD_PERI2")).toString());
                }
                if (respuesta.getValueAt(i, "COD_PERI3")!=null){
                    dtoMensajeImpresion.setCodigoPeriodoHasta(((BigDecimal) respuesta.getValueAt(i, "COD_PERI3")).toString());
                }
                if ((respuesta.getValueAt(i, "IND_EXCL_TIPO") != null) && (bigDecimalToLong(respuesta.getValueAt(i, "IND_EXCL_TIPO")).equals(new Long(1)))) {
                    dtoMensajeImpresion.setExclusionTipologia(Boolean.TRUE);
                } else {
                    dtoMensajeImpresion.setExclusionTipologia(Boolean.FALSE);
                }

                nMensajes.addElement(dtoMensajeImpresion);
            }

            if (((BigDecimal) respuesta.getValueAt(i, "TIDE_OID_TIPO_DEST")).intValue() != oidTipoDestinatarioAnterior.intValue()) {
                if (j == 0) {
                    vDestinatario = new Vector();
                }

                oidTipoDestinatarioAnterior = bigDecimalToLong(respuesta.getValueAt(i, "TIDE_OID_TIPO_DEST"));

                DTODestinatarioMensaje dtoDestinatarioMensaje = new DTODestinatarioMensaje();
                dtoDestinatarioMensaje.setOidTipoDestinatario(bigDecimalToLong(respuesta.getValueAt(i, "TIDE_OID_TIPO_DEST")));
                vDestinatario.add(dtoDestinatarioMensaje);
                dtoMensajeImpresion.setDestinatario(vDestinatario);

                j++;
            }

            Long oidBuz = bigDecimalToLong(respuesta.getValueAt(i, "OID_BUZO_MENS"));

            if (((oidBuz == null) && (oidBuzonAnterior != null)) || ((oidBuz != null) && (oidBuzonAnterior == null)) || (((oidBuz != null) && (oidBuzonAnterior != null)) && (oidBuz.intValue() != oidBuzonAnterior.intValue()))) {
                if (oidBuz != null) {
                    //agregado por Sapaza, fecha 12-10-2007, incidencia Sicc20070474
                    boolean encontrado = false;
                    if(k > 0) {
                        for(int l=0; l<vBuzonImpresion.size(); l++) {
                            DTOBuzonImpresion dtoBuzon = (DTOBuzonImpresion)vBuzonImpresion.get(l);

                            if(oidBuz.intValue() == dtoBuzon.getOidBuzon().intValue()) {
                                encontrado = true;
                            }
                        }
                    }
                
                    if(!encontrado) {
                        DTOBuzonImpresion dtoBuzonImpresion = new DTOBuzonImpresion();
                        oidBuzonAnterior = oidBuz;
                        dtoBuzonImpresion.setOidBuzon(oidBuz);
                        dtoBuzonImpresion.setOidCliente(bigDecimalToLong(respuesta.getValueAt(i, "CLIE_OID_CLIE")));
                        dtoBuzonImpresion.setNumeroSecuencia(bigDecimalToLong(respuesta.getValueAt(i, "NUM_SECU")));
                        dtoBuzonImpresion.setNombre1((String) respuesta.getValueAt(i, "VAL_NOM1_CLIE"));
                        dtoBuzonImpresion.setNombre2((String) respuesta.getValueAt(i, "VAL_NOM2_CLIE"));
                        dtoBuzonImpresion.setApellido1((String) respuesta.getValueAt(i, "VAL_APE1_CLIE"));
                        dtoBuzonImpresion.setApellido2((String) respuesta.getValueAt(i, "VAL_APE2_CLIE"));
                        dtoBuzonImpresion.setApellidoCasada((String) respuesta.getValueAt(i, "VAL_APEL_CASA_CLIE"));
                        dtoBuzonImpresion.setDatoVariable1((String) respuesta.getValueAt(i, "DATO_VARI_01"));
                        UtilidadesLog.debug("dato variable 1 seteado: " + dtoBuzonImpresion.getDatoVariable1());
                        dtoBuzonImpresion.setDatoVariable2((String) respuesta.getValueAt(i, "DATO_VARI_02"));
                        dtoBuzonImpresion.setDatoVariable3((String) respuesta.getValueAt(i, "DATO_VARI_03"));
                        dtoBuzonImpresion.setDatoVariable4((String) respuesta.getValueAt(i, "DATO_VARI_04"));
                        dtoBuzonImpresion.setDatoVariable5((String) respuesta.getValueAt(i, "DATO_VARI_05"));
                        dtoBuzonImpresion.setDatoVariable6((String) respuesta.getValueAt(i, "DATO_VARI_06"));
                        dtoBuzonImpresion.setDatoVariable7((String) respuesta.getValueAt(i, "DATO_VARI_07"));
                        dtoBuzonImpresion.setDatoVariable8((String) respuesta.getValueAt(i, "DATO_VARI_08"));
                        dtoBuzonImpresion.setDatoVariable9((String) respuesta.getValueAt(i, "DATO_VARI_09"));
                        dtoBuzonImpresion.setDatoVariable10((String) respuesta.getValueAt(i, "DATO_VARI_10"));
                        dtoBuzonImpresion.setDatoVariable11((String) respuesta.getValueAt(i, "DATO_VARI_11"));
                        dtoBuzonImpresion.setDatoVariable12((String) respuesta.getValueAt(i, "DATO_VARI_12"));
                        dtoBuzonImpresion.setDatoVariable13((String) respuesta.getValueAt(i, "DATO_VARI_13"));
                        dtoBuzonImpresion.setDatoVariable14((String) respuesta.getValueAt(i, "DATO_VARI_14"));
                        dtoBuzonImpresion.setDatoVariable15((String) respuesta.getValueAt(i, "DATO_VARI_15"));
                        dtoBuzonImpresion.setDatoVariable16((String) respuesta.getValueAt(i, "DATO_VARI_16"));
                        dtoBuzonImpresion.setDatoVariable17((String) respuesta.getValueAt(i, "DATO_VARI_17"));
                        dtoBuzonImpresion.setDatoVariable18((String) respuesta.getValueAt(i, "DATO_VARI_18"));
                        dtoBuzonImpresion.setDatoVariable19((String) respuesta.getValueAt(i, "DATO_VARI_19"));
                        dtoBuzonImpresion.setDatoVariable20((String) respuesta.getValueAt(i, "DATO_VARI_20"));
                        dtoBuzonImpresion.setIndEstado(bigDecimalToInteger(respuesta.getValueAt(i, "IND_ESTA_MENS")));
                        dtoBuzonImpresion.setIndListaConsultora(bigDecimalToInteger(respuesta.getValueAt(i, "IND_LIST_CONS")));
                        dtoBuzonImpresion.setOidModuloOrigen(bigDecimalToLong(respuesta.getValueAt(i, "MODU_OID_MODU_ORIG")));
                        dtoBuzonImpresion.setIndActivo(bigDecimalToInteger(respuesta.getValueAt(i, "IND_ACTI")));
    
                        if (k == 0) {
                            vBuzonImpresion = new Vector();
                        }
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                            UtilidadesLog.debug("dtoBuzonImpresion: " + dtoBuzonImpresion);
                        vBuzonImpresion.add(dtoBuzonImpresion);
                        dtoMensajeImpresion.setBuzon(vBuzonImpresion);
                        k++;
                    }    
                } else {
                    dtoMensajeImpresion.setBuzon(null);
                }
            } //if buzon
        } //for cantidad de registros

        DTOMensajeImpresion[] dtoMensajesFinal = new DTOMensajeImpresion[nMensajes.size()];

        for (int x = 0; x < nMensajes.size(); x++) {
            dtoMensajesFinal[x] = (DTOMensajeImpresion) nMensajes.get(x);
        }
       
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("Array de DTOMensajesFinal a devolver: " + dtoMensajesFinal);

        UtilidadesLog.info("DAOImpresion.obtenerMensajesImpresion(Long periodo, Long oidCliente, Long pais): Salida");

        return dtoMensajesFinal;
    }

    /*
     * Pablo Perez
     * 13/12/2004
     */
    public Boolean existeUnidadAdministrativa(DTOMensajeUnidadAdministrativa DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.existeUnidadAdministrativa(DTOMensajeUnidadAdministrativa DTOE): Entrada");
    
        /*
        //Obtiene si la unidad administrativa del cliente existe para el mensaje que se está procesando utilizando el servicio DBService

        SELECT COUNT(*) INTO contador
        FROM MSG_MENSA_UNIDA_ADMIN
        WHERE MENS_OID_MENS = DTOE.oidMensaje

        //Concatenar a la select las condiciones que correspondan según los argumentos de entrada

        Si DTOE.territorio != null y DTOE.seccion != null y DTOE.zona != null y DTOE.region != null
        AND (TERR_OID_TERR = 1 AND ZSCC_OID_SECC = 1 AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC = 1 AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = 1)

        Si DTOE.territorio == null y DTOE.seccion != null y DTOE.zona != null y DTOE.region != null
        AND (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC = 1 AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = 1)

        Si DTOE.territorio == null y DTOE.seccion == null y DTOE.zona != null y DTOE.region != null
        AND (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA = 1 AND ZORG_OID_REGI = 1)
        OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = 1)

        Si DTOE.territorio == null y DTOE.seccion == null y DTOE.zona == null y DTOE.region != null
        AND (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = 1)

        Si contador > 0
        devolver true
        en otro caso
        devolver false
         * */
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append(" SELECT COUNT (*) AS contador  ");
            buf.append("   FROM msg_mensa_unida_admin  ");
            buf.append("  WHERE mens_oid_mens =  " + DTOE.getOid());

            if ((DTOE.getOidTerritorio() != null) && (DTOE.getOidSeccion() != null) && (DTOE.getOidZona() != null) && (DTOE.getOidRegion() != null)) {
                // Pueden existir parentesis demas
                buf.append("    AND ((TERR_OID_TERR = " + DTOE.getOidTerritorio() + " AND ZSCC_OID_SECC = " + DTOE.getOidSeccion());
                buf.append("          AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC = " + DTOE.getOidSeccion());
                buf.append("        AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL ");
                buf.append("        AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = " + DTOE.getOidRegion() + "))");
            }

            if ((DTOE.getOidTerritorio() == null) && (DTOE.getOidSeccion() != null) && (DTOE.getOidZona() != null) && (DTOE.getOidRegion() != null)) {
                // Pueden existir parentesis demas
                buf.append("  AND ((TERR_OID_TERR IS NULL AND ZSCC_OID_SECC = " + DTOE.getOidSeccion());
                buf.append("        AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL ");
                buf.append("        AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = " + DTOE.getOidRegion() + "))");
            }

            if ((DTOE.getOidTerritorio() == null) && (DTOE.getOidSeccion() == null) && (DTOE.getOidZona() != null) && (DTOE.getOidRegion() != null)) {
                // Pueden existir parentesis demas
                buf.append("   AND ((TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL ");
                buf.append("        AND ZZON_OID_ZONA = " + DTOE.getOidZona() + " AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
                buf.append("    OR (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = " + DTOE.getOidRegion() + "))");
            }

            if ((DTOE.getOidTerritorio() == null) && (DTOE.getOidSeccion() == null) && (DTOE.getOidZona() == null) && (DTOE.getOidRegion() != null)) {
                buf.append(" AND (TERR_OID_TERR IS NULL AND ZSCC_OID_SECC IS NULL AND ZZON_OID_ZONA IS NULL AND ZORG_OID_REGI = " + DTOE.getOidRegion() + ")");
            }

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        int contador = ((BigDecimal) respuesta.getValueAt(0, 0)).intValue();

        UtilidadesLog.info("DAOImpresion.existeUnidadAdministrativa(DTOMensajeUnidadAdministrativa DTOE): Salida"+ (contador > 0));

        if (contador > 0) {
            // if(contador == 0)
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
    
    public StringBuffer aniadirExisteUnidadAdministrativa(DTOFACCabeceraSolicitud DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.aniadirExisteUnidadAdministrativa(DTOMensajeUnidadAdministrativa DTOE): Entrada");
        StringBuffer buf = new StringBuffer();
        buf.append(" ( SELECT COUNT (*) ");
        buf.append("   FROM msg_mensa_unida_admin mu");
        buf.append("  WHERE mu.mens_oid_mens =  mensa.oid_mens");

        if ((DTOE.getTerritorio() != null) && (DTOE.getSeccion() != null) && (DTOE.getZona() != null) && (DTOE.getRegion() != null)) {
            // Pueden existir parentesis demas
            buf.append("    AND ((mu.TERR_OID_TERR = " + DTOE.getTerritorio() + " AND mu.ZSCC_OID_SECC = " + DTOE.getSeccion());
            buf.append("          AND mu.ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC = " + DTOE.getSeccion());
            buf.append("        AND mu.ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL ");
            buf.append("        AND mu.ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL AND mu.ZZON_OID_ZONA IS NULL AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + "))) as contador ");
        }

        if ((DTOE.getTerritorio() == null) && (DTOE.getSeccion() != null) && (DTOE.getZona() != null) && (DTOE.getRegion() != null)) {
            // Pueden existir parentesis demas
            buf.append("  AND ((mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC = " + DTOE.getSeccion());
            buf.append("        AND ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL ");
            buf.append("        AND ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL AND mu.ZZON_OID_ZONA IS NULL AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + "))) as contador ");
        }

        if ((DTOE.getTerritorio() == null) && (DTOE.getSeccion() == null) && (DTOE.getZona() != null) && (DTOE.getRegion() != null)) {
            // Pueden existir parentesis demas
            buf.append("   AND ((mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL ");
            buf.append("        AND mu.ZZON_OID_ZONA = " + DTOE.getZona() + " AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")");
            buf.append("    OR (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL AND mu.ZZON_OID_ZONA IS NULL AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + "))) as contador ");
        }

        if ((DTOE.getTerritorio() == null) && (DTOE.getSeccion() == null) && (DTOE.getZona() == null) && (DTOE.getRegion() != null)) {
            buf.append(" AND (mu.TERR_OID_TERR IS NULL AND mu.ZSCC_OID_SECC IS NULL AND mu.ZZON_OID_ZONA IS NULL AND mu.ZORG_OID_REGI = " + DTOE.getRegion() + ")) as contador ");
        }
        return buf;

    }

    /*
     * Pablo Perez
     * 13/12/2004
     */
    public Boolean existeTipificacionCliente(DTOMensajeTipoCliente DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.existeTipificacionCliente(DTOMensajeTipoCliente DTOE): Entrada");
        /*
        //Obtiene si la tipificación del cliente existe para el mensaje que se está procesando utilizando el servicio DBService
        Si contador > 0
        devolver true
        en otro caso
        devolver false
        */
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append(" SELECT COUNT (1) AS contador ");
            buf.append("   FROM msg_mensa_tipo_clien ");
            buf.append("  WHERE mens_oid_mens =  " + DTOE.getOid());
            //  Modificado por HRCS - Fecha 24/05/2007 - Incidencia Sicc20070203
            //  En caso se reciba varias clasificaciones y/o varios tipos de clasificaciones
            if ((DTOE.getOidsClasificaciones() != null) || (DTOE.getOidsTipoClasificaciones() != null))   {
                if ((DTOE.getOidsClasificaciones() != null) && (DTOE.getOidsTipoClasificaciones() != null) && (DTOE.getOidSubtipoCliente() != null) && (DTOE.getOidTipoCliente() != null)) {
                    buf.append("   AND ((CLAS_OID_CLAS IN (" + DTOE.getOidsClasificaciones() + ") AND TCCL_OID_TIPO_CLAS IN (" + DTOE.getOidsTipoClasificaciones() +")");
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IN (" + DTOE.getOidsTipoClasificaciones()+")");
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE IS NULL AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + "))");
                }
                if ((DTOE.getOidsClasificaciones() == null) && (DTOE.getOidsTipoClasificaciones() != null) && (DTOE.getOidSubtipoCliente() != null) && (DTOE.getOidTipoCliente() != null)) {
                    buf.append("   AND ((CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IN (" + DTOE.getOidsTipoClasificaciones()+")");
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE IS NULL AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + "))");
                }
            }
            //  En caso se reciba una sola clasificacion y/o un solo tipo de clasificacion
            else if ((DTOE.getOidClasificacion() != null) || (DTOE.getOidTipoClasificacion() != null))  {
                if ((DTOE.getOidClasificacion() != null) && (DTOE.getOidTipoClasificacion() != null) && (DTOE.getOidSubtipoCliente() != null) && (DTOE.getOidTipoCliente() != null)) {
                    buf.append("   AND ((CLAS_OID_CLAS = " + DTOE.getOidClasificacion() + " AND TCCL_OID_TIPO_CLAS = " + DTOE.getOidTipoClasificacion());
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS = " + DTOE.getOidTipoClasificacion());
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE IS NULL AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + "))");
                }
                if ((DTOE.getOidClasificacion() == null) && (DTOE.getOidTipoClasificacion() != null) && (DTOE.getOidSubtipoCliente() != null) && (DTOE.getOidTipoCliente() != null)) {
                    buf.append("   AND ((CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS = " + DTOE.getOidTipoClasificacion());
                    buf.append("          AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                    buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE IS NULL AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + "))");
                }
            }
            //  En caso solo se reciba subtipo y tipo de cliente
            else if ((DTOE.getOidSubtipoCliente() != null) && (DTOE.getOidTipoCliente() != null)) {
                buf.append("   AND ((CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE = " + DTOE.getOidSubtipoCliente() + " AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + ")");
                buf.append("     OR (CLAS_OID_CLAS IS NULL AND TCCL_OID_TIPO_CLAS IS NULL AND SBTI_OID_SUBT_CLIE IS NULL AND TICL_OID_TIPO_CLIE = " + DTOE.getOidTipoCliente() + "))");
            }
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
       
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("respuesta: " + respuesta);

        int contador = ((BigDecimal) respuesta.getValueAt(0, 0)).intValue();

        UtilidadesLog.info("DAOImpresion.existeTipificacionCliente(DTOMensajeTipoCliente DTOE): Salida "+(contador > 0));

        if (contador > 0) {
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }

    public Boolean existeMarca(DTOMensajeMarca DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.existeMarca(DTOMensajeMarca DTOE): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append("  SELECT COUNT(1)  ");
            buf.append("  FROM MSG_MENSA_MARCA ");
            buf.append("  WHERE MENS_OID_MENS = " + DTOE.getOid());
            buf.append("  AND MARC_OID_MARC = " + DTOE.getOidMarca());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOImpresion.existeMarca(DTOMensajeMarca DTOE): Salida "+(((BigDecimal) respuesta.getValueAt(0, 0)).intValue() > 0));

        if (((BigDecimal) respuesta.getValueAt(0, 0)).intValue() > 0) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public RecordSet obtenerCodigosVenta(Long oidMensaje) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerCodigosVenta(Long oidMensaje): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append("  SELECT VAL_CODI_VENT  ");
            buf.append("  FROM MSG_MENSA_CODIG_VENTA ");
            buf.append("  WHERE MENS_OID_MENS = " + oidMensaje);

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOImpresion.obtenerCodigosVenta(Long oidMensaje): Salida");

        return respuesta;
    }

    /**
     * @author mbobadill
     * @date 14/12/04
     * Obtiene todos los mensajes para un patrón determinado, para un cliente y un período -
     * estos dos últimos si no vienen a null-. Y para aquellos mensajes que tengan registros en el buzón
     * de mensajes se recuperan los datos del buzón. Se utiliza el servicio DBService.
     */
    public DTOMensajeImpresion[] obtenerMensajesImpresionPorPatron(DTOSeleccionMensajes dtoe) throws MareException {

        UtilidadesLog.info("DAOImpresion.obtenerMensajesImpresionPorPatron(DTOSeleccionMensajes dtoe): Entrada");

        RecordSet rs;
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT   ");
            buf.append(" I.CLIE_OID_CLIE,   ");
            buf.append(" D.OID_MENS,   ");
            buf.append(" E.TIDE_OID_TIPO_DEST,   ");
            buf.append(" I.OID_BUZO_MENS,   ");
            buf.append(" I.NUM_SECU,  ");
            buf.append(" D.TMEN_OID_TIPO_MENS,   ");
            buf.append(" D.VAL_TEXT,   ");
            buf.append(" D.TPER_OID_TIPO_PERM,   ");
            buf.append(" D.FEC_PERM_DESD,   ");
            buf.append(" D.FEC_PERM_HAST,   ");

            if (dtoe.getOidPeriodo() != null) {
                buf.append(" F.OID_PERI COD_PERI,   ");
                buf.append(" G.OID_PERI COD_PERI2,   ");
                buf.append(" H.OID_PERI COD_PERI3,   ");
            }

            buf.append(" I.DATO_VARI_01,   ");
            buf.append(" I.DATO_VARI_02,  ");
            buf.append(" I.DATO_VARI_03,   ");
            buf.append(" I.DATO_VARI_04,   ");
            buf.append(" I.DATO_VARI_05,  ");
            buf.append(" I.DATO_VARI_06,   ");
            buf.append(" I.DATO_VARI_07,   ");
            buf.append(" I.DATO_VARI_08,  ");
            buf.append(" I.DATO_VARI_09,   ");
            buf.append(" I.DATO_VARI_10,   ");
            buf.append(" I.DATO_VARI_11,  ");
            buf.append(" I.DATO_VARI_12,  ");
            buf.append(" I.DATO_VARI_13,  ");
            buf.append(" I.DATO_VARI_14,   ");
            buf.append(" I.DATO_VARI_15,  ");
            buf.append(" I.DATO_VARI_16,  ");
            buf.append(" I.DATO_VARI_17,  ");
            buf.append(" I.DATO_VARI_18,  ");
            buf.append(" I.DATO_VARI_19,  ");
            buf.append(" I.DATO_VARI_20,   ");
            buf.append(" I.IND_ESTA_MENS,  ");
            buf.append(" I.MODU_OID_MODU_ORIG,   ");
            buf.append(" I.VAL_NOM1_CLIE,   ");
            buf.append(" I.VAL_NOM2_CLIE,  ");
            buf.append(" I.VAL_APE1_CLIE,  ");
            buf.append(" I.VAL_APE2_CLIE,   ");
            buf.append(" I.VAL_APEL_CASA_CLIE,   ");
            buf.append(" I.IND_LIST_CONS,  ");
            buf.append(" I.IND_ACTI,   ");
            buf.append(" D.IND_EXCL_TIPO ");            

            buf.append(" FROM MSG_PATRO A,   ");
            buf.append(" MSG_PATRO_SECCI B,   ");
            buf.append(" MSG_PATRO_MENSA C,  ");
            buf.append(" MSG_MENSA D,   ");
            buf.append(" MSG_MENSA_TIPO_ASIGN E,   ");

            if (dtoe.getOidPeriodo() != null) {
                buf.append(" SEG_PERIO_CORPO F,  ");
                buf.append(" SEG_PERIO_CORPO G,  ");
                buf.append(" SEG_PERIO_CORPO H,  ");
            }

            buf.append(" MSG_BUZON_MENSA I   ");
            buf.append(" WHERE A.OID_PATR = " + dtoe.getOidPatron());
            buf.append(" AND A.OID_PATR = B.PATR_OID_PATR  ");
            buf.append(" AND B.OID_PATR_SECC = C.PASE_OID_PATR_SECC  ");
            buf.append(" AND C.MENS_OID_MENS = D.OID_MENS   ");
            buf.append(" AND D.OID_MENS = E.MENS_OID_MENS   ");

            if (dtoe.getOidPeriodo() == null) {
                buf.append(" AND D.TPER_OID_TIPO_PERM != " + ConstantesMSG.OID_PERMANENCIA_H);
            }

            if (dtoe.getOidPeriodo() != null) {
                buf.append(" AND F.OID_PERI = " + dtoe.getOidPeriodo());
                buf.append(" AND D.PERI_OID_PERI_DESD = G.OID_PERI (+)   ");
                buf.append(" AND D.PERI_OID_PERI_HAST = H.OID_PERI (+)    ");
            }

            buf.append(" AND D.OID_MENS = I.MENS_OID_MENS (+)  ");

            if (dtoe.getOidCliente() != null) {
                buf.append(" AND (I.CLIE_OID_CLIE = " + dtoe.getOidCliente() + " OR I.CLIE_OID_CLIE IS NULL )");
            }

            buf.append(" ORDER BY I.CLIE_OID_CLIE, D.OID_MENS, E.OID_MENS_TIPO_DEST, I.NUM_SECU   ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("rs.getRowCount(): " + rs.getRowCount());

        Long oidMensajeAnterior = new Long(-1);
        Long oidTipoDestinatarioAnterior = new Long(-1);
        Long oidBuzonAnterior = new Long(-1);

        //DTOMensajeImpresion[] dTOMensajeImpresion = new DTOMensajeImpresion[rs.getRowCount()];
        Vector nMensajes = new Vector();
        DTOMensajeImpresion dtoMensajeImpresion = null;
        Vector vDestinatario = null;
        Vector vBuzonImpresion = null;

        Object bandera = null;
        int j = 0;
        int k = 0;

        for (int i = 0; i < rs.getRowCount(); i++) {
            //DTODestinatarioMensaje destinatario = new DTODestinatarioMensaje();

            //-----------------------------1---------------------------------------------------------------
            if ((rs.getValueAt(i, "OID_MENS") != null) && (bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() != oidMensajeAnterior.longValue())) {
                dtoMensajeImpresion = new DTOMensajeImpresion();
                j = 0;
                k = 0;

                //if(rs.getValueAt(i,"OID_MENS")!=null)
                dtoMensajeImpresion.setOidMensaje(bigDecimalToLong(rs.getValueAt(i, "OID_MENS")));

                //if(rs.getValueAt(i,"OID_MENS")!=null)
                oidMensajeAnterior = bigDecimalToLong(rs.getValueAt(i, "OID_MENS"));
                oidTipoDestinatarioAnterior = new Long(-1);

                if (rs.getValueAt(i, "VAL_TEXT") != null) {
                    dtoMensajeImpresion.setTexto(rs.getValueAt(i, "VAL_TEXT").toString());
                }

                if (rs.getValueAt(i, "TPER_OID_TIPO_PERM") != null) {
                    dtoMensajeImpresion.setOidTipoPermanencia(bigDecimalToLong(rs.getValueAt(i, "TPER_OID_TIPO_PERM")));
                }

                if (rs.getValueAt(i, "FEC_PERM_DESD") != null) {
                    dtoMensajeImpresion.setFechaPermanenciaDesde((Date) rs.getValueAt(i, "FEC_PERM_DESD"));
                }

                if (rs.getValueAt(i, "FEC_PERM_HAST") != null) {
                    dtoMensajeImpresion.setFechaPermanenciaHasta((Date) rs.getValueAt(i, "FEC_PERM_HAST"));
                }

                if (rs.getValueAt(i, "TMEN_OID_TIPO_MENS") != null) {
                    dtoMensajeImpresion.setOidTipoMensaje(bigDecimalToLong(rs.getValueAt(i, "TMEN_OID_TIPO_MENS")));
                }

                if (dtoe.getOidPeriodo() != null) {
                    if (rs.getValueAt(i, "COD_PERI") != null) {
                        dtoMensajeImpresion.setCodigoPeriodoInicial(((BigDecimal) rs.getValueAt(i, "COD_PERI")).toString());

                        if (rs.getValueAt(i, "COD_PERI2") != null) {
                            dtoMensajeImpresion.setCodigoPeriodoDesde(((BigDecimal) rs.getValueAt(i, "COD_PERI2")).toString());
                        }

                        if (rs.getValueAt(i, "COD_PERI3") != null) {
                            dtoMensajeImpresion.setCodigoPeriodoHasta(((BigDecimal) rs.getValueAt(i, "COD_PERI3")).toString());
                        }
                    }
                }

                if ((rs.getValueAt(i, "IND_EXCL_TIPO") != null) && (bigDecimalToLong(rs.getValueAt(i, "IND_EXCL_TIPO")).equals(new Long(1)))) {
                    dtoMensajeImpresion.setExclusionTipologia(Boolean.TRUE);
                } else {
                    dtoMensajeImpresion.setExclusionTipologia(Boolean.FALSE);
                }
                
                nMensajes.addElement(dtoMensajeImpresion);
                
            }

            //----------------------------fin 1-----------------------------------------------------------
            //-----------------------------2-----------------------------------------------------------
            if (((bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() == oidMensajeAnterior.longValue()) && (bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")).longValue() != oidTipoDestinatarioAnterior.longValue())) || ((bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() != oidMensajeAnterior.longValue()) && (bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")).longValue() == oidTipoDestinatarioAnterior.longValue()))) {
                //if(rs.getValueAt(i,"TIDE_OID_TIPO_DEST")!=null && 
                //  bigDecimalToLong(rs.getValueAt(i,"TIDE_OID_TIPO_DEST")).intValue()!= oidTipoDestinatarioAnterior.intValue() ){
                if (j == 0) {
                    vDestinatario = new Vector();
                }

                DTODestinatarioMensaje dtoDestinatarioMensaje = new DTODestinatarioMensaje();

                dtoDestinatarioMensaje.setOidTipoDestinatario(bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")));
                vDestinatario.add(dtoDestinatarioMensaje);
                
                UtilidadesLog.debug("agrego destinatario: " + dtoDestinatarioMensaje);
                
                dtoMensajeImpresion.setDestinatario(vDestinatario);
                oidTipoDestinatarioAnterior = bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST"));
                j++;
            }

            //----------------------------fin 2-------------------------------------------------------------------
            //-----------------------------3-----------------------------------------------------------
            if ((rs.getValueAt(i, "OID_BUZO_MENS") != null) && 
                (bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS")).longValue() != oidBuzonAnterior.longValue())) {

                DTOBuzonImpresion dtoBuzonImpresion = new DTOBuzonImpresion();
            
                //--------------------------4------------------------------------------
                if (rs.getValueAt(i, "OID_BUZO_MENS") != null) {
                    dtoBuzonImpresion.setOidBuzon(bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS")));
                    oidBuzonAnterior = bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS"));

                    if (rs.getValueAt(i, "CLIE_OID_CLIE") != null) {
                        dtoBuzonImpresion.setOidCliente(bigDecimalToLong(rs.getValueAt(i, "CLIE_OID_CLIE")));
                    }

                    if (rs.getValueAt(i, "NUM_SECU") != null) {
                        dtoBuzonImpresion.setNumeroSecuencia(bigDecimalToLong(rs.getValueAt(i, "NUM_SECU")));
                    }

                    if (rs.getValueAt(i, "VAL_NOM1_CLIE") != null) {
                        dtoBuzonImpresion.setNombre1(rs.getValueAt(i, "VAL_NOM1_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_NOM2_CLIE") != null) {
                        dtoBuzonImpresion.setNombre2(rs.getValueAt(i, "VAL_NOM2_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APE1_CLIE") != null) {
                        dtoBuzonImpresion.setApellido1(rs.getValueAt(i, "VAL_APE1_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APE2_CLIE") != null) {
                        dtoBuzonImpresion.setApellido2(rs.getValueAt(i, "VAL_APE2_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APEL_CASA_CLIE") != null) {
                        dtoBuzonImpresion.setApellidoCasada(rs.getValueAt(i, "VAL_APEL_CASA_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_01") != null) {
                        dtoBuzonImpresion.setDatoVariable1(rs.getValueAt(i, "DATO_VARI_01").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_02") != null) {
                        dtoBuzonImpresion.setDatoVariable2(rs.getValueAt(i, "DATO_VARI_02").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_03") != null) {
                        dtoBuzonImpresion.setDatoVariable3(rs.getValueAt(i, "DATO_VARI_03").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_04") != null) {
                        dtoBuzonImpresion.setDatoVariable4(rs.getValueAt(i, "DATO_VARI_04").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_05") != null) {
                        dtoBuzonImpresion.setDatoVariable5(rs.getValueAt(i, "DATO_VARI_05").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_06") != null) {
                        dtoBuzonImpresion.setDatoVariable6(rs.getValueAt(i, "DATO_VARI_06").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_07") != null) {
                        dtoBuzonImpresion.setDatoVariable7(rs.getValueAt(i, "DATO_VARI_07").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_08") != null) {
                        dtoBuzonImpresion.setDatoVariable8(rs.getValueAt(i, "DATO_VARI_08").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_09") != null) {
                        dtoBuzonImpresion.setDatoVariable9(rs.getValueAt(i, "DATO_VARI_09").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_10") != null) {
                        dtoBuzonImpresion.setDatoVariable10(rs.getValueAt(i, "DATO_VARI_10").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_11") != null) {
                        dtoBuzonImpresion.setDatoVariable11(rs.getValueAt(i, "DATO_VARI_11").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_12") != null) {
                        dtoBuzonImpresion.setDatoVariable12(rs.getValueAt(i, "DATO_VARI_12").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_13") != null) {
                        dtoBuzonImpresion.setDatoVariable13(rs.getValueAt(i, "DATO_VARI_13").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_14") != null) {
                        dtoBuzonImpresion.setDatoVariable14(rs.getValueAt(i, "DATO_VARI_14").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_15") != null) {
                        dtoBuzonImpresion.setDatoVariable15(rs.getValueAt(i, "DATO_VARI_15").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_16") != null) {
                        dtoBuzonImpresion.setDatoVariable16(rs.getValueAt(i, "DATO_VARI_16").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_17") != null) {
                        dtoBuzonImpresion.setDatoVariable17(rs.getValueAt(i, "DATO_VARI_17").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_18") != null) {
                        dtoBuzonImpresion.setDatoVariable18(rs.getValueAt(i, "DATO_VARI_18").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_19") != null) {
                        dtoBuzonImpresion.setDatoVariable19(rs.getValueAt(i, "DATO_VARI_19").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_20") != null) {
                        dtoBuzonImpresion.setDatoVariable20(rs.getValueAt(i, "DATO_VARI_20").toString());
                    }

                    if (rs.getValueAt(i, "IND_ESTA_MENS") != null) {
                        dtoBuzonImpresion.setIndEstado(new Integer(rs.getValueAt(i, "IND_ESTA_MENS").toString()));
                    }

                    if (rs.getValueAt(i, "IND_LIST_CONS") != null) {
                        dtoBuzonImpresion.setIndListaConsultora(new Integer(rs.getValueAt(i, "IND_LIST_CONS").toString()));
                    }

                    if (rs.getValueAt(i, "MODU_OID_MODU_ORIG") != null) {
                        dtoBuzonImpresion.setOidModuloOrigen(bigDecimalToLong(rs.getValueAt(i, "MODU_OID_MODU_ORIG")));
                    }

                    if (rs.getValueAt(i, "IND_ACTI") != null) {
                        dtoBuzonImpresion.setIndActivo(bigDecimalToInteger(rs.getValueAt(i, "IND_ACTI")));
                    }

                    dtoBuzonImpresion.setOidIdioma(dtoe.getOidIdioma());

                    if (k == 0) {
                        vBuzonImpresion = new Vector();
                    }
                    
                    //UtilidadesLog.debug("agrego buzon: " + dtoBuzonImpresion);
                    
                    vBuzonImpresion.add(dtoBuzonImpresion);
                    dtoMensajeImpresion.setBuzon(vBuzonImpresion);
                    k++;
                } //----------------------------------------------fin 4------------------------
            } //---------------------------------fin 3-----------------------------------

            //no va mas}
        }

        DTOMensajeImpresion[] dtoMensajesFinal = new DTOMensajeImpresion[nMensajes.size()];

        for (int x = 0; x < nMensajes.size(); x++) {
            dtoMensajesFinal[x] = (DTOMensajeImpresion) nMensajes.get(x);
        }

        UtilidadesLog.info("DAOImpresion.obtenerMensajesImpresionPorPatron(DTOSeleccionMensajes dtoe): Salida");

        return dtoMensajesFinal;
    }

    public RecordSet obtenerTipificacionCliente(DTOOID DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerTipificacionCliente(DTOOID DTOE): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append("  SELECT B.TICL_OID_TIPO_CLIE, ");
            buf.append("  B.SBTI_OID_SUBT_CLIE, ");
            buf.append("  B.TCCL_OID_TIPO_CLASI, ");
            buf.append("  B.CLAS_OID_CLAS ");
            buf.append("  FROM MAE_CLIEN A, ");
            buf.append("  V_MAE_TIPIF_CLIEN B ");
            buf.append("  WHERE A.OID_CLIE = " + DTOE.getOid());
            /*  inicio CAMBIO MSG 002 - pperez  */
            if (DTOE.getOidPais() != null)  {
                buf.append("  AND A.PAIS_OID_PAIS = " + DTOE.getOidPais());
            }
            /*  fin CAMBIO MSG 002 - pperez  */
            buf.append("  AND A.OID_CLIE = B.CLIE_OID_CLIE ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("respuesta: " + respuesta);
        UtilidadesLog.info("DAOImpresion.obtenerTipificacionCliente(DTOOID DTOE): Salida");

        return respuesta;
    }

    public DTOMensajeUnidadAdministrativa obtenerUACliente(Long oidCliente) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerUACliente(Long oidCliente): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();
        DTOMensajeUnidadAdministrativa dtos = new DTOMensajeUnidadAdministrativa();

        try {
            buf.append("  SELECT F.OID_REGI,  ");
            buf.append("  E.OID_ZONA, ");
            buf.append("  D.OID_SECC, ");
            buf.append("  C.OID_TERR ");
            buf.append("  FROM MAE_CLIEN_UNIDA_ADMIN A, ");
            buf.append("  ZON_TERRI_ADMIN B,  ");
            buf.append("  ZON_TERRI C, ");
            buf.append("  ZON_SECCI D, ");
            buf.append("  ZON_ZONA E, ");
            buf.append("  ZON_REGIO F ");
            buf.append("  WHERE A.CLIE_OID_CLIE = " + oidCliente);
            buf.append("  AND A.ZTAD_OID_TERR_ADMI = B.OID_TERR_ADMI ");
            buf.append("  AND B.TERR_OID_TERR = C.OID_TERR ");
            buf.append("  AND B.ZSCC_OID_SECC = D.OID_SECC ");
            buf.append("  AND D.ZZON_OID_ZONA = E.OID_ZONA ");
            buf.append("  AND E.ZORG_OID_REGI = F.OID_REGI ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /*
         * INC 22026 - dmorello, 26/01/2006
         * Si no se recuperan resultados con la query anterior (es decir, si el
         * cliente no tiene UA), el método devolverá null.
         */
        if (! respuesta.esVacio()) {
            dtos.setOidRegion(new Long(((BigDecimal) respuesta.getValueAt(0, "OID_REGI")).longValue()));
            dtos.setOidSeccion(new Long(((BigDecimal) respuesta.getValueAt(0, "OID_SECC")).longValue()));
            dtos.setOidTerritorio(new Long(((BigDecimal) respuesta.getValueAt(0, "OID_TERR")).longValue()));
            dtos.setOidZona(new Long(((BigDecimal) respuesta.getValueAt(0, "OID_ZONA")).longValue()));
    
            UtilidadesLog.info("DAOImpresion.obtenerUACliente(Long oidCliente): Salida " + dtos);
    
            return dtos;
        } else {
            UtilidadesLog.info("DAOImpresion.obtenerUACliente(Long oidCliente): Salida null");
            return null;
        }
    }

    public RecordSet obtenerMarcasCliente(Long oidCliente) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerMarcasCliente(Long oidCliente): Entrada");
    
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        try {
            buf.append("  SELECT MARC_OID_MARC ");
            buf.append("  FROM MAE_CLIEN_MARCA ");
            buf.append("  WHERE CLIE_OID_CLIE = " + oidCliente);

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOImpresion.obtenerMarcasCliente(Long oidCliente): Salida");

        return respuesta;
    }

    /**
     * @author mbobadilla
     * @date 16/12/04
     * SICC-DMCO-MSG-201-324-N019
     * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */
    public DTOMensajeImpresion[] obtenerMensajesPorConsultora(DTOSeleccionMensajes DTOE) throws MareException {
    
        UtilidadesLog.info("DAOImpresion.obtenerMensajesPorConsultora(DTOSeleccionMensajes DTOE): Entrada");

        RecordSet rs;
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" Select * from( SELECT I.CLIE_OID_CLIE, ");
            buf.append("  D.OID_MENS, ");
            buf.append("  E.TIDE_OID_TIPO_DEST, ");
            buf.append("  I.OID_BUZO_MENS, ");
            buf.append("  I.NUM_SECU, ");
            buf.append("  D.TMEN_OID_TIPO_MENS,");
            buf.append("  D.VAL_TEXT, ");
            buf.append("  D.TPER_OID_TIPO_PERM, ");
            buf.append("  D.FEC_PERM_DESD, ");
            buf.append("  D.FEC_PERM_HAST, ");
            buf.append("  F.COD_PERI COD_PERI, ");
            buf.append("  G.COD_PERI COD_PERI2, ");
            buf.append("  H.COD_PERI COD_PERI3, ");
            buf.append("  I.DATO_VARI_01, ");
            buf.append("  I.DATO_VARI_02, ");
            buf.append("  I.DATO_VARI_03,");
            buf.append("  I.DATO_VARI_04,");
            buf.append("  I.DATO_VARI_05, ");
            buf.append("  I.DATO_VARI_06, ");
            buf.append("  I.DATO_VARI_07,");
            buf.append("  I.DATO_VARI_08, ");
            buf.append("  I.DATO_VARI_09, ");
            buf.append("  I.DATO_VARI_10, ");
            buf.append("  I.DATO_VARI_11, ");
            buf.append("  I.DATO_VARI_12,");
            buf.append("  I.DATO_VARI_13, ");
            buf.append("  I.DATO_VARI_14, ");
            buf.append("  I.DATO_VARI_15, ");
            buf.append("  I.DATO_VARI_16, ");
            buf.append("  I.DATO_VARI_17, ");
            buf.append("  I.DATO_VARI_18, ");
            buf.append("  I.DATO_VARI_19, ");
            buf.append("  I.DATO_VARI_20, ");
            buf.append("  I.IND_ESTA_MENS, ");
            buf.append("  I.MODU_OID_MODU_ORIG, ");
            buf.append("  I.VAL_NOM1_CLIE, ");
            buf.append("  I.VAL_NOM2_CLIE, ");
            buf.append("  I.VAL_APE1_CLIE, ");
            buf.append("  I.VAL_APE2_CLIE, ");
            buf.append("  I.VAL_APEL_CASA_CLIE, ");
            buf.append("  I.IND_LIST_CONS, ");
            buf.append("  I.IND_ACTI ");
            buf.append("  FROM MSG_MENSA  D, ");
            buf.append("  MSG_MENSA_TIPO_ASIGN E, ");
            buf.append("  SEG_PERIO_CORPO F, ");
            buf.append("  SEG_PERIO_CORPO G, ");
            buf.append("  SEG_PERIO_CORPO H, ");
            buf.append("  MSG_BUZON_MENSA I  ");

            if (DTOE.getOidPatron() != null) {
                buf.append(", MSG_PATRO A,  ");
                buf.append("  MSG_PATRO_SECCI B,  ");
                buf.append("  MSG_PATRO_MENSA C  ");
            }

            // INC 22029 - dmorello, 08/02/2006 se elimina el left outer join  
            buf.append("  WHERE D.OID_MENS = I.MENS_OID_MENS ");

            if (DTOE.getOidCliente() != null) {
                // DBLG500000596 - dmorello, 19/05/2006 se quita el OR I.CLIE_OID_CLIE IS NULL
                buf.append("  AND I.CLIE_OID_CLIE = " + DTOE.getOidCliente());
            }

            // Incidencia BELC300012716
            /*
             * dmorello, 06/02/2006: Se quita el outer join y se agrega la
             * condición de OID cliente nulo para adecuar al modelo de componentes
             * dmorello, 19/05/2006: se quita CLIE_OID_CLIE IS NOT NULL por DBLG500000596
             */
            // DBLG500000596 - dmorello, 19/05/2006 se quita el OR I.CLIE_OID_CLIE IS NULL
            //En MSG_BUZON_MENSA el campo PERI_OID_PERI se guarda el periodo corporativo
            //y no el periodo cra, por lo que se comenta el filtro. (Gacevedo)
            //buf.append("  AND I.PERI_OID_PERI = " + DTOE.getOidPeriodo());

            if (DTOE.getFechaImpresion() != null) {
                // INC 22027 - dmorello, 22/12/2005
                // Se elimina el left outer join, ya que no está en el modelo y además es incorrecto y genera una excepción.
                /*
                 * dmorello, 20/02/2006
                 * Se reemplaza la comparación de fechas por la comparación de VARCHARs
                 * convirtiendo las fechas a ese tipo de datos, ya que en la BD la fecha
                 * de impresión también tiene hora y la comparación podría dar
                 * distinto incorrectamente.
                 */
                // DBLG500000596 - dmorello, 19/05/2006 se quita el OR I.CLIE_OID_CLIE IS NULL
                buf.append("  AND TO_CHAR(I.FEC_IMPR,'DD/MM/YYYY') = '"
                    + DTOE.getFechaImpresion() + "'");
            }

            if (DTOE.getNumeroLoteImpresion() != null) {
                // INC 22027 - dmorello, 05/01/2006: Se quita el outer join ya que el modelo así lo indica.
                // DBLG500000596 - dmorello, 19/05/2006 se quita el OR I.CLIE_OID_CLIE IS NULL
                buf.append("  AND I.NUM_LOTE_IMPR = " + DTOE.getNumeroLoteImpresion());
            }

            // INC 22027 - dmorello, 05/01/2006: Se descomenta la siguiente línea, ya que debe ir en la query según el modelo.
            // DBLG500000596 - dmorello, 19/05/2006 se quita el OR I.CLIE_OID_CLIE IS NULL
            buf.append("  AND I.IND_ESTA_MENS = " + ConstantesMSG.IND_ACTIVO);
            buf.append("  AND D.OID_MENS = E.MENS_OID_MENS ");
            buf.append("  AND F.OID_PERI = " + DTOE.getOidPeriodo());
            buf.append("  AND D.PERI_OID_PERI_DESD = G.OID_PERI (+)");
            buf.append("  AND D.PERI_OID_PERI_HAST = H.OID_PERI (+) ");
            // DBLG400000802 - gacevedo, 20/06/2006 se comenta el filtro del indicador de activo
            //buf.append("  AND I.IND_ACTI = " + ConstantesMSG.IND_ACTIVO);

            if (DTOE.getOidPatron() != null) {
                buf.append("  AND A.OID_PATR = " + DTOE.getOidPatron());
                buf.append("  AND A.OID_PATR = B.PATR_OID_PATR  ");
                buf.append("  AND B.OID_PATR_SECC = C.PASE_OID_PATR_SECC ");
                buf.append("  AND C.MENS_OID_MENS = D.OID_MENS  ");
            }
            buf.append("  UNION ");
            buf.append("  SELECT   i.clie_oid_clie, d.oid_mens, e.tide_oid_tipo_dest, i.oid_buzo_mens, ");
            buf.append("  i.num_secu, d.tmen_oid_tipo_mens, d.val_text, d.tper_oid_tipo_perm, ");
            buf.append("  d.fec_perm_desd, d.fec_perm_hast, f.cod_peri cod_peri, ");
            buf.append("  g.cod_peri cod_peri2, h.cod_peri cod_peri3, i.dato_vari_01 , ");
            buf.append("  i.dato_vari_02, i.dato_vari_03, i.dato_vari_04, i.dato_vari_05, ");
            buf.append("  i.dato_vari_06, i.dato_vari_07, i.dato_vari_08, i.dato_vari_09, ");
            buf.append("  i.dato_vari_10, i.dato_vari_11, i.dato_vari_12, i.dato_vari_13, ");
            buf.append("  i.dato_vari_14, i.dato_vari_15, i.dato_vari_16, i.dato_vari_17, ");
            buf.append("  i.dato_vari_18, i.dato_vari_19, i.dato_vari_20, i.ind_esta_mens, ");
            buf.append("  i.modu_oid_modu_orig, i.val_nom1_clie, i.val_nom2_clie, ");
            buf.append("  i.val_ape1_clie, i.val_ape2_clie, i.val_apel_casa_clie, ");
            buf.append("  i.ind_list_cons, i.ind_acti ");
            buf.append("  FROM msg_mensa d, ");
            buf.append("  msg_mensa_tipo_asign e, ");
            buf.append("  seg_perio_corpo f, ");
            buf.append("  seg_perio_corpo g, ");
            buf.append("  seg_perio_corpo h, ");
            buf.append("  msg_buzon_mensa i, ");
            buf.append("  msg_patro a, ");
            buf.append("  msg_patro_secci b, ");
            buf.append("  msg_patro_mensa c ");
            buf.append("  WHERE d.oid_mens = i.mens_oid_mens(+) ");
            buf.append("  AND e.tide_oid_tipo_dest =2  ");
            buf.append("  AND d.oid_mens = e.mens_oid_mens ");
            buf.append("  AND f.oid_peri = " + DTOE.getOidPeriodo());
            buf.append("  AND d.peri_oid_peri_desd = g.oid_peri(+) ");
            buf.append("  AND d.peri_oid_peri_hast = h.oid_peri(+) ");
            buf.append("  AND a.oid_patr = " + DTOE.getOidPatron());
            buf.append("  AND a.oid_patr = b.patr_oid_patr ");
            buf.append("  AND b.oid_patr_secc = c.pase_oid_patr_secc ");
            buf.append("  AND c.mens_oid_mens = d.oid_mens) ");
            buf.append(" ORDER BY clie_oid_clie, oid_mens, tide_oid_tipo_dest, num_secu ");
            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            UtilidadesLog.debug("rs========== " + rs.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
                Long oidMensajeAnterior = new Long(-1);
        Long oidTipoDestinatarioAnterior = new Long(-1);
        Long oidBuzonAnterior = new Long(-1);

        //DTOMensajeImpresion[] dTOMensajeImpresion = new DTOMensajeImpresion[rs.getRowCount()];
        Vector nMensajes = new Vector();
        DTOMensajeImpresion dtoMensajeImpresion = null;
        Vector vDestinatario = null;
        Vector vBuzonImpresion = null;

        Object bandera = null;
        int j = 0;
        int k = 0;

        /* dmorello, 04/09/2006: Se adecua el armado del DTO a lo indicado en DMCO */
        
        for (int i = 0; i < rs.getRowCount(); i++) {
            //DTODestinatarioMensaje destinatario = new DTODestinatarioMensaje();

            //-----------------------------1---------------------------------------------------------------
            if ((rs.getValueAt(i, "OID_MENS") != null) && (bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() != oidMensajeAnterior.longValue())) {
                dtoMensajeImpresion = new DTOMensajeImpresion();
                j = 0;
                k = 0;

                //if(rs.getValueAt(i,"OID_MENS")!=null)
                dtoMensajeImpresion.setOidMensaje(bigDecimalToLong(rs.getValueAt(i, "OID_MENS")));

                //if(rs.getValueAt(i,"OID_MENS")!=null)
                oidMensajeAnterior = bigDecimalToLong(rs.getValueAt(i, "OID_MENS"));
                oidTipoDestinatarioAnterior = new Long(-1);

                if (rs.getValueAt(i, "VAL_TEXT") != null) {
                    dtoMensajeImpresion.setTexto(rs.getValueAt(i, "VAL_TEXT").toString());
                }

                if (rs.getValueAt(i, "TPER_OID_TIPO_PERM") != null) {
                    dtoMensajeImpresion.setOidTipoPermanencia(bigDecimalToLong(rs.getValueAt(i, "TPER_OID_TIPO_PERM")));
                }

                if (rs.getValueAt(i, "FEC_PERM_DESD") != null) {
                    dtoMensajeImpresion.setFechaPermanenciaDesde((Date) rs.getValueAt(i, "FEC_PERM_DESD"));
                }

                if (rs.getValueAt(i, "FEC_PERM_HAST") != null) {
                    dtoMensajeImpresion.setFechaPermanenciaHasta((Date) rs.getValueAt(i, "FEC_PERM_HAST"));
                }

                if (rs.getValueAt(i, "TMEN_OID_TIPO_MENS") != null) {
                    dtoMensajeImpresion.setOidTipoMensaje(bigDecimalToLong(rs.getValueAt(i, "TMEN_OID_TIPO_MENS")));
                }

                if (DTOE.getOidPeriodo() != null) {
                    if (rs.getValueAt(i, "COD_PERI") != null) {
                        dtoMensajeImpresion.setCodigoPeriodoInicial(rs.getValueAt(i, "COD_PERI").toString());

                        if (rs.getValueAt(i, "COD_PERI2") != null) {
                            dtoMensajeImpresion.setCodigoPeriodoDesde(rs.getValueAt(i, "COD_PERI2").toString());
                        }

                        if (rs.getValueAt(i, "COD_PERI3") != null) {
                            dtoMensajeImpresion.setCodigoPeriodoHasta(((BigDecimal) rs.getValueAt(i, "COD_PERI3")).toString());
                        }
                    }
                }
                
                nMensajes.addElement(dtoMensajeImpresion);
                
            }

            //----------------------------fin 1-----------------------------------------------------------
            //-----------------------------2-----------------------------------------------------------
            if (((bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() == oidMensajeAnterior.longValue()) && (bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")).longValue() != oidTipoDestinatarioAnterior.longValue())) || ((bigDecimalToLong(rs.getValueAt(i, "OID_MENS")).longValue() != oidMensajeAnterior.longValue()) && (bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")).longValue() == oidTipoDestinatarioAnterior.longValue()))) {
                //if(rs.getValueAt(i,"TIDE_OID_TIPO_DEST")!=null && 
                //  bigDecimalToLong(rs.getValueAt(i,"TIDE_OID_TIPO_DEST")).intValue()!= oidTipoDestinatarioAnterior.intValue() ){
                if (j == 0) {
                    vDestinatario = new Vector();
                }

                DTODestinatarioMensaje dtoDestinatarioMensaje = new DTODestinatarioMensaje();

                dtoDestinatarioMensaje.setOidTipoDestinatario(bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST")));
                vDestinatario.add(dtoDestinatarioMensaje);
                
                UtilidadesLog.debug("agrego destinatario: " + dtoDestinatarioMensaje);
                
                dtoMensajeImpresion.setDestinatario(vDestinatario);
                oidTipoDestinatarioAnterior = bigDecimalToLong(rs.getValueAt(i, "TIDE_OID_TIPO_DEST"));
                j++;
            }

            //----------------------------fin 2-------------------------------------------------------------------
            //-----------------------------3-----------------------------------------------------------
            if ((rs.getValueAt(i, "OID_BUZO_MENS") != null) && 
                (bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS")).longValue() != oidBuzonAnterior.longValue())) {

                DTOBuzonImpresion dtoBuzonImpresion = new DTOBuzonImpresion();
            
                //--------------------------4------------------------------------------
                if (rs.getValueAt(i, "OID_BUZO_MENS") != null) {
                    dtoBuzonImpresion.setOidBuzon(bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS")));
                    oidBuzonAnterior = bigDecimalToLong(rs.getValueAt(i, "OID_BUZO_MENS"));

                    if (rs.getValueAt(i, "CLIE_OID_CLIE") != null) {
                        dtoBuzonImpresion.setOidCliente(bigDecimalToLong(rs.getValueAt(i, "CLIE_OID_CLIE")));
                    }

                    if (rs.getValueAt(i, "NUM_SECU") != null) {
                        dtoBuzonImpresion.setNumeroSecuencia(bigDecimalToLong(rs.getValueAt(i, "NUM_SECU")));
                    }

                    if (rs.getValueAt(i, "VAL_NOM1_CLIE") != null) {
                        dtoBuzonImpresion.setNombre1(rs.getValueAt(i, "VAL_NOM1_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_NOM2_CLIE") != null) {
                        dtoBuzonImpresion.setNombre2(rs.getValueAt(i, "VAL_NOM2_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APE1_CLIE") != null) {
                        dtoBuzonImpresion.setApellido1(rs.getValueAt(i, "VAL_APE1_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APE2_CLIE") != null) {
                        dtoBuzonImpresion.setApellido2(rs.getValueAt(i, "VAL_APE2_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "VAL_APEL_CASA_CLIE") != null) {
                        dtoBuzonImpresion.setApellidoCasada(rs.getValueAt(i, "VAL_APEL_CASA_CLIE").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_01") != null) {
                        dtoBuzonImpresion.setDatoVariable1(rs.getValueAt(i, "DATO_VARI_01").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_02") != null) {
                        dtoBuzonImpresion.setDatoVariable2(rs.getValueAt(i, "DATO_VARI_02").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_03") != null) {
                        dtoBuzonImpresion.setDatoVariable3(rs.getValueAt(i, "DATO_VARI_03").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_04") != null) {
                        dtoBuzonImpresion.setDatoVariable4(rs.getValueAt(i, "DATO_VARI_04").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_05") != null) {
                        dtoBuzonImpresion.setDatoVariable5(rs.getValueAt(i, "DATO_VARI_05").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_06") != null) {
                        dtoBuzonImpresion.setDatoVariable6(rs.getValueAt(i, "DATO_VARI_06").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_07") != null) {
                        dtoBuzonImpresion.setDatoVariable7(rs.getValueAt(i, "DATO_VARI_07").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_08") != null) {
                        dtoBuzonImpresion.setDatoVariable8(rs.getValueAt(i, "DATO_VARI_08").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_09") != null) {
                        dtoBuzonImpresion.setDatoVariable9(rs.getValueAt(i, "DATO_VARI_09").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_10") != null) {
                        dtoBuzonImpresion.setDatoVariable10(rs.getValueAt(i, "DATO_VARI_10").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_11") != null) {
                        dtoBuzonImpresion.setDatoVariable11(rs.getValueAt(i, "DATO_VARI_11").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_12") != null) {
                        dtoBuzonImpresion.setDatoVariable12(rs.getValueAt(i, "DATO_VARI_12").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_13") != null) {
                        dtoBuzonImpresion.setDatoVariable13(rs.getValueAt(i, "DATO_VARI_13").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_14") != null) {
                        dtoBuzonImpresion.setDatoVariable14(rs.getValueAt(i, "DATO_VARI_14").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_15") != null) {
                        dtoBuzonImpresion.setDatoVariable15(rs.getValueAt(i, "DATO_VARI_15").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_16") != null) {
                        dtoBuzonImpresion.setDatoVariable16(rs.getValueAt(i, "DATO_VARI_16").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_17") != null) {
                        dtoBuzonImpresion.setDatoVariable17(rs.getValueAt(i, "DATO_VARI_17").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_18") != null) {
                        dtoBuzonImpresion.setDatoVariable18(rs.getValueAt(i, "DATO_VARI_18").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_19") != null) {
                        dtoBuzonImpresion.setDatoVariable19(rs.getValueAt(i, "DATO_VARI_19").toString());
                    }

                    if (rs.getValueAt(i, "DATO_VARI_20") != null) {
                        dtoBuzonImpresion.setDatoVariable20(rs.getValueAt(i, "DATO_VARI_20").toString());
                    }

                    if (rs.getValueAt(i, "IND_ESTA_MENS") != null) {
                        dtoBuzonImpresion.setIndEstado(new Integer(rs.getValueAt(i, "IND_ESTA_MENS").toString()));
                    }

                    if (rs.getValueAt(i, "IND_LIST_CONS") != null) {
                        dtoBuzonImpresion.setIndListaConsultora(new Integer(rs.getValueAt(i, "IND_LIST_CONS").toString()));
                    }

                    if (rs.getValueAt(i, "MODU_OID_MODU_ORIG") != null) {
                        dtoBuzonImpresion.setOidModuloOrigen(bigDecimalToLong(rs.getValueAt(i, "MODU_OID_MODU_ORIG")));
                    }

                    if (rs.getValueAt(i, "IND_ACTI") != null) {
                        dtoBuzonImpresion.setIndActivo(bigDecimalToInteger(rs.getValueAt(i, "IND_ACTI")));
                    }

                    dtoBuzonImpresion.setOidIdioma(DTOE.getOidIdioma());

                    if (k == 0) {
                        vBuzonImpresion = new Vector();
                    }
                    
                    //UtilidadesLog.debug("agrego buzon: " + dtoBuzonImpresion);
                    
                    vBuzonImpresion.add(dtoBuzonImpresion);
                    dtoMensajeImpresion.setBuzon(vBuzonImpresion);
                    k++;
                } //----------------------------------------------fin 4------------------------
            } //---------------------------------fin 3-----------------------------------

            //no va mas}
        }

        DTOMensajeImpresion[] dtoMensajesFinal = new DTOMensajeImpresion[nMensajes.size()];

        for (int x = 0; x < nMensajes.size(); x++) {
            dtoMensajesFinal[x] = (DTOMensajeImpresion) nMensajes.get(x);
        }
        
        /* Fin dmorello 04/09/2006 */


        
        UtilidadesLog.info("DAOImpresion.obtenerMensajesPorConsultora(DTOSeleccionMensajes DTOE): Salida");

        return dtoMensajesFinal;
    }

    




    /**
     * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    private Integer bigDecimalToInteger(Object numero) {
    
        if (numero != null) {
            return new Integer(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }
    
    /**
     * Metodo que obtiene las clasificaciones y tipo de clasificaciones de un cliente
     * @throws es.indra.mare.common.exception.MareException
     * @return Lista con las clasificaciones y tipos de clasificaciones
     * @param oidCliente
     */
    public ArrayList obtenerClasificacionTipoCliente(Long oidCliente, Long tipoCliente, Long subtipoCliente) throws MareException {
    
        UtilidadesLog.debug("DAOImpresion.obtenerClasificacionTipoCliente(Long oidCliente, Long tipoCliente, Long subtipoCliente): Entrada");
        ArrayList codigos = new ArrayList();
        StringBuffer buf = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet respuesta;
        try {
            buf.append(" SELECT cc.clas_oid_clas, cc.tccl_oid_tipo_clasi ");
            buf.append(" FROM mae_clien_tipo_subti cts, mae_clien_clasi cc ");
            buf.append(" WHERE "+ oidCliente +"=cts.clie_oid_clie ");
            buf.append(" AND cts.oid_clie_tipo_subt = cc.ctsu_oid_clie_tipo_subt ");
            if (tipoCliente!=null) buf.append(" AND "+ tipoCliente +"=cts.ticl_oid_tipo_clie ");
            if (subtipoCliente!=null) buf.append(" AND "+ subtipoCliente +"=cts.sbti_oid_subt_clie ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!respuesta.esVacio())   {
            String codClasi = "";
            String codTipoClasi = "";
            for(int i=0; i<respuesta.getRowCount(); i++)   {
                if (respuesta.getValueAt(i,0)!=null)
                    codClasi = respuesta.getValueAt(i,0) + "," + codClasi;
                if (respuesta.getValueAt(i,1)!=null)
                    codTipoClasi = respuesta.getValueAt(i,1) + "," + codTipoClasi;
            }
            codClasi = codClasi.substring( 0, codClasi.length()-1);
            codTipoClasi = codTipoClasi.substring( 0, codTipoClasi.length()-1);
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("codClasi:["+ codClasi +"] - codTipoClasi: ["+ codTipoClasi +"]");
            
            codigos.add( 0, codClasi );
            codigos.add( 1, codTipoClasi );
        }
        UtilidadesLog.debug("DAOImpresion.obtenerClasificacionTipoCliente(Long oidCliente, Long tipoCliente, Long subtipoCliente): Salida");
        return codigos;
    }    
}