/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOCruzarCupon3conCupon1;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.sql.Date;
import javax.ejb.DuplicateKeyException;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Vector;

import javax.persistence.NoResultException;


public class DAOGestionCuponTramite {
    public DAOGestionCuponTramite() {
    }

    public DTOSalida cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto, long numeroDiasCruceCupon3, boolean comparoImportePorIgual)
        throws MareException {
        //se modifica segun cambio fac 03, modulo ccc (SCS-29/01/2008)
        UtilidadesLog.info("DAOGestionCuponTramite.cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto): Entrada");

        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //FieldPosition pos = new FieldPosition(0);

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");

        sQuery.append(" SELECT m.* FROM CCC_MOVIM_BANCA m, ");
        sQuery.append(" /*CCC_CUENT_CORRI_BANCA c, CCC_SUCUR s,*/ ");
        sQuery.append(" /*CCC_BANCO b*/ MAE_CLIEN cli WHERE ");

        //joins 
        //sQuery.append(" m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
        sQuery.append(" m.CCBA_OID_CC_BANC = ? ");
        parametros.add(dto.getOidCtaCteBria());
        //sQuery.append(" AND c.SUCU_OID_SUCU = s.OID_SUCU ");
        //sQuery.append(" AND s.CBAN_OID_BANC = b.OID_BANC ");
        sQuery.append(" AND m.CLIE_OID_CLIE = cli.OID_CLIE ");

        //criterios (Si alguno de los criterios es null no filtra) 
        if (dto.getOidPais() != null) {
            sQuery.append(" AND m.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }

        /*if (dto.getOidBanco() != null) {
            sQuery.append(" AND b.OID_BANC = ? ");
            parametros.add(dto.getOidBanco());
        }*/

        if (dto.getCodigoCliente() != null) {
            sQuery.append(" AND cli.COD_CLIE = ? ");
            parametros.add(dto.getCodigoCliente());
        }

        sQuery.append(" AND m.IMP_APLI <> 0 ");

        if (dto.getNumeroCupon() != null) {
            sQuery.append(" AND m.NUM_CUPO = ? ");
            parametros.add(dto.getNumeroCupon());
        }

        /*
        if (dto.getFechaDoc() != null) {
            sQuery.append(" AND m.FEC_PAGO > TO_DATE(?, 'dd/MM/yyyy') ");

            java.sql.Date fecvenc = new java.sql.Date(UtilidadesFecha.minusDays(
                        dto.getFechaDoc(), 2).getTime());
            StringBuffer fechaStringVD = new StringBuffer();
            StringBuffer fecha = formato.format(fecvenc, fechaStringVD, pos);
            parametros.add(fechaStringVD.toString());
        }

        if (dto.getFechaDoc() != null) {
            sQuery.append(" AND m.FEC_PAGO <  TO_DATE(?, 'dd/MM/yyyy')  ");

            java.sql.Date fecvenc = new java.sql.Date(UtilidadesFecha.addDays(
                        dto.getFechaDoc(), 2).getTime());
            StringBuffer fechaStringVD = new StringBuffer();
            StringBuffer fecha = formato.format(fecvenc, fechaStringVD, pos);
            parametros.add(fechaStringVD.toString());
        }*/
        
        
        sQuery.append(" AND m.FEC_PAGO > TO_DATE(?, 'dd-MM-yyyy') ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        long nroDiasCruceAmilisecs = (numeroDiasCruceCupon3*24*60*60*1000);
        
        String fechaComp = sdf.format(new Date( (System.currentTimeMillis() - nroDiasCruceAmilisecs) ));
        
        UtilidadesLog.debug("numero de dias de cruce (pas a milisec's): " + nroDiasCruceAmilisecs);
        UtilidadesLog.debug("fecha del sistema - numero de dias de cruce: " + fechaComp);

        parametros.add(fechaComp);        

        if (dto.getImporte() != null) {
            if (comparoImportePorIgual){
                sQuery.append(" AND m.IMP_PAGO = ? ");
                parametros.add(dto.getImporte());
            }else{
                sQuery.append(" AND m.IMP_PAGO <> ? ");
                parametros.add(dto.getImporte());
            }
        }

        /**(
        *Fecha documento - 2 < Fecha de pago (de la entidad Movimientos Bancarios) < Fecha documento + 2 (se buscan movimientos en un margen de dos días desde fecha del documento del cupón).
        *)*/
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
                    
             UtilidadesLog.info("resultado:" + resultado); 
             UtilidadesLog.info(" parametros : " + parametros);
              
             
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("cruzarCupon3conCupon1: Exception", e);
            this.logSql("cruzarCupon3conCupon1. SQL: ", sQuery.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtos = new DTOSalida(resultado);

        UtilidadesLog.info("DAOGestionCuponTramite.cruzarCupon3conCupon1(DTOCruzarCupon3conCupon1 dto): Salida");

        return dtos;
    }

    public DTOSalida consultarCupon3(DTOConsultarCupon3 dto)
        throws MareException {
        
        UtilidadesLog.info("DAOGestionCuponTramite.consultarCupon3(DTOConsultarCupon3 dto): Entrada");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //FieldPosition pos = new FieldPosition(0);

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");

        /*De la SELECT Obtendremos un RecordSet con los campos:
        *oidDetalleCuponTramiteDepuracion (oculto)
        anio
        mes
        numero
        periodo
        codigoCliente
        fechaDigitacion
        fechaDoc
        banco (descripcion)
        numeroOperacion (numeroLinea)
        importe */
        sQuery.append(" SELECT d.OID_DETA_CUPO_TRAM_DEPU OID, c.VAL_ANIO, ");
        sQuery.append(" c.VAL_PERI_MES, c.NUM_CUPE, ");
        sQuery.append(" p.VAL_NOMB_PERI, m.COD_CLIE, d.FEC_DIGI, d.FEC_DOCU, b.DES_CC, ");
        sQuery.append(" d.NUM_LINE, d.IMP_DETA ");
        
        sQuery.append(" FROM CCC_CUPON_TRAMI_DEPUR c, CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
        sQuery.append(" CCC_SITUA_CUPON s, MAE_CLIEN m, CRA_PERIO p, "); 
        sQuery.append(" CCC_CUENT_CORRI_BANCA b ");
        
        sQuery.append(" WHERE ");

        //joins 
        sQuery.append(" c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
        sQuery.append(" AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ");
        sQuery.append(" AND d.CLIE_OID_CLIE = m.OID_CLIE(+) ");
        
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
        sQuery.append(" AND c.PERD_OID_PERI = p.OID_PERI(+) ");
        sQuery.append(" AND d.CCBA_OID_CC_BANC = b.OID_CUEN_CORR_BANC ");

        //criterios - Los que venga a null no se aplican como criterios de filtro 
        if (dto.getOidPais() != null) {
            sQuery.append(" AND c.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }

        /*if (dto.getOidSubacceso() != null) {
            sQuery.append(" AND c.SBAC_OID_SBAC = ? ");
            parametros.add(dto.getOidSubacceso());
        }*/

        //cambio fac 03, modulo ccc (SCS-29/01/2008) 
        if (dto.getOidPeriodo() != null) {
            sQuery.append(" AND c.PERD_OID_PERI = ? ");
            parametros.add(dto.getOidPeriodo());
        }

        if (dto.getAnio() != null) {
            sQuery.append(" AND c.VAL_ANIO = ? ");
            parametros.add(dto.getAnio());
        }

        if (dto.getMes() != null) {
            sQuery.append(" AND c.VAL_PERI_MES = ? ");
            parametros.add(dto.getMes());
        }

        if (dto.getNumero() != null) {
            sQuery.append(" AND c.NUM_CUPE = ? ");
            parametros.add(dto.getNumero());
        }

        if (dto.getCodigoCliente() != null) {
            sQuery.append(" AND m.COD_CLIE = ? ");
            parametros.add(dto.getCodigoCliente());
        }

        if (dto.getFechaDoc() != null) {
            sQuery.append("AND d.FEC_DOCU = TO_DATE(?, 'dd/MM/yyyy') ");
            parametros.add(formato.format(dto.getFechaDoc()));
        }

        if (dto.getFechaMovBanc() != null) {
            sQuery.append("AND d.FEC_MOVI_BANC = TO_DATE(?, 'dd/MM/yyyy') ");
            parametros.add(formato.format(dto.getFechaMovBanc()));
        }

        if (dto.getOidCtaCteBria() != null) {
            sQuery.append(" AND d.CCBA_OID_CC_BANC = ? ");
            parametros.add(dto.getOidCtaCteBria());
        }
        
        if (dto.getOidSituacion() != null) {
            sQuery.append(" AND d.SICU_OID_SITU_CUPO = ? ");
            parametros.add(dto.getOidSituacion());
        }

        RecordSet resultado = null;
        String codigoError = null;

        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sQuery.toString(),
                dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada,
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarCupon3: Exception", e);
            this.logSql("consultarCupon3. SQL: ", sqlPaginada, parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("la consulta SQL trae: " + resultado);
        DTOSalida dtos = new DTOSalida(resultado);
        UtilidadesLog.debug("dto que se devuelve" + dtos);
        UtilidadesLog.info("DAOGestionCuponTramite.consultarCupon3(DTOConsultarCupon3 dto): Salida");
        return dtos;
    }

    public DTOSalida consultarCupon3(DTOCancelarCupon3 dto, Long oidConciliado)
        throws MareException {
        
        UtilidadesLog.info("DAOGestionCuponTramite.DTOCancelarCupon3 dto, Long oidConciliado): Entrada");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //FieldPosition pos = new FieldPosition(0);

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");

        /*De la SELECT Obtendremos un RecordSet con los campos:

        oidDetalleCuponTramite(oculto),
        numeroLote,
        anio,
        mes,
        codigoCliente,
        fechaDoc,
        fechaMovBanc (fechaPago),
        banco (descripción)
        importe */
        sQuery.append(" SELECT d.OID_DETA_CUPO_TRAM_DEPU OID, mov.NUM_LOTE,c.VAL_ANIO, ");
        sQuery.append(" c.VAL_PERI_MES, m.COD_CLIE, d.FEC_DOCU, FEC_PAGO, ");
        //sQuery.append(" b.DES_BANC, d.IMP_DETA ");
        sQuery.append(" b.DES_CC, d.IMP_DETA ");
        
        sQuery.append(" FROM CCC_CUPON_TRAMI_DEPUR c, CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
        sQuery.append(" CCC_SITUA_CUPON s, MAE_CLIEN m,  ");
        sQuery.append(" CCC_CUENT_CORRI_BANCA b, CCC_MOVIM_BANCA mov ");
        
        //sQuery.append(" CCC_BANCO b, CCC_MOVIM_BANCA mov ");
        
        sQuery.append(" WHERE ");

        //joins 
        sQuery.append(" c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
        sQuery.append(" AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ");
        sQuery.append(" AND d.CLIE_OID_CLIE = m.OID_CLIE ");
        
        //cambio fac 03, modulo ccc (SCS-29/01/2008), no hace falta el periodo
        //sQuery.append(" AND c.PERD_OID_PERI = p.OID_PERI ");
        
        sQuery.append(" AND d.CCBA_OID_CC_BANC = b.OID_CUEN_CORR_BANC ");
        sQuery.append(" AND d.CMBA_OID_MOVI_BANC = mov.OID_MOVI_BANC (+)");

        //criterios - Los que venga a null no se aplican como criterios de filtro 
        if (dto.getOidPais() != null) {
            sQuery.append(" AND c.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }

        if (dto.getAnio() != null) {
            sQuery.append(" AND c.VAL_ANIO = ? ");
            parametros.add(dto.getAnio());
        }

        if (dto.getMes() != null) {
            sQuery.append(" AND c.VAL_PERI_MES = ? ");
            parametros.add(dto.getMes());
        }

        if (dto.getNumero() != null) {
            sQuery.append(" AND c.NUM_CUPE = ? ");
            parametros.add(dto.getNumero());
        }

        /*if (dto.getOidSubacceso() != null) {
            sQuery.append(" AND c.SBAC_OID_SBAC = ? ");
            parametros.add(dto.getOidSubacceso());
        }*/
        
        if (dto.getOidPeriodo() != null) {
            sQuery.append(" AND c.PERD_OID_PERI = ? ");
            parametros.add(dto.getOidPeriodo());
        }

        if (dto.getCodigoCliente() != null) {
            sQuery.append(" AND m.COD_CLIE = ? ");
            parametros.add(dto.getCodigoCliente());
        }

        if (dto.getFechaDoc() != null) {
            sQuery.append("AND d.FEC_DOCU = TO_DATE(?, 'dd/MM/yyyy') ");
            parametros.add(formato.format(dto.getFechaDoc()));
        }

        if (dto.getFechaMovBanc() != null) {
            sQuery.append("AND d.FEC_MOVI_BANC = TO_DATE(?, 'dd/MM/yyyy') ");
            parametros.add(formato.format(dto.getFechaMovBanc()));
        }

        if (dto.getOidCtaCteBria() != null) {
            sQuery.append(" AND d.CCBA_OID_CC_BANC = ? ");
            parametros.add(dto.getOidCtaCteBria());
        }

        if (dto.getOidSituacion() != null) {
            sQuery.append(" AND d.SICU_OID_SITU_CUPO = ? ");
            parametros.add(dto.getOidSituacion());
        }
        
        //cambio fac 03, modulo ccc (SCS-29/01/2008), no qro los conc.!
        if (dto.getOidSituacion() == null) {
            sQuery.append(" AND d.SICU_OID_SITU_CUPO NOT IN (" + oidConciliado.longValue() + ")");
        }

        RecordSet resultado = null;
        String codigoError = null;

        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sQuery.toString(),
                dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada,
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarCupon3: Exception", e);
            this.logSql("consultarCupon3. SQL: ", sqlPaginada, parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Envolvemos en RecordSet en un DTOSalida y lo devolvemos
        DTOSalida dtos = new DTOSalida(resultado);

        UtilidadesLog.info("DAOGestionCuponTramite.consultarCupon3(DTOCancelarCupon3 dto, Long oidConciliado): Salida");

        return dtos;
    }

    public DTOOID cabCuponTramitePorNumero(Integer numero,
                                           String anio,
                                           String mes,
                                           Long pais)
        throws MareException {
        //indidencia 9869 resuelta
        UtilidadesLog.info("DAOGestionCuponTramite.cabCuponTramitePorNumero(Integer numero): Entrada");

        //Recupera la cabecera cuyo número (secuencial) se corresponde con el parámetro recibido 
        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");

        sQuery.append("SELECT * FROM CCC_CUPON_TRAMI_DEPUR WHERE ");
        sQuery.append("NUM_CUPE = ?");
        sQuery.append(" and VAL_ANIO = ?");
        sQuery.append(" and VAL_PERI_MES = ?");
        sQuery.append(" and PAIS_OID_PAIS = ?");
        parametros.add(numero);
        parametros.add(anio);
        parametros.add(mes);
        parametros.add(pais);

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("cabCuponTramitePorNumero: Exception", e);
            this.logSql("cabCuponTramitePorNumero. SQL: ", sQuery.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOOID dto = new DTOOID();

        //Si existe el numero lo envolvemos en un DTOOID; 
        if (resultado != null && !resultado.esVacio()) {
            dto.setOid(new Long(
                    ((BigDecimal) (resultado.getValueAt(0, 0))).longValue()));
        }
        //Si no existe el numero el DTOOID.oid = null; 
        else {
            dto.setOid(null);
        }

        //retornamos el DTOOID;
        UtilidadesLog.info("DAOGestionCuponTramite.cabCuponTramitePorNumero(Integer numero): Salida");

        return dto;
    }

    public DTOSalida numLineaDetalleCuponTramitePorOIDCab(DTOOID dto)
        throws MareException {
        
        UtilidadesLog.info("DAOGestionCuponTramite.numLineaDetalleCuponTramitePorOIDCab(DTOOID dto): Entrada");

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");

        //Obtiene el número de la última línea de DetalleCuponesTramiteDepuracion por OID de CabeceraCuponesTramiteDepuración 
        //Entrada: DTOOID dto; 
        //Salida: DTOSalida 
        sQuery.append(
            " SELECT DECODE ( (SELECT MAX(NUM_LINE) FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        sQuery.append("WHERE  CTDE_OID_CUPO_TRAM_DEPU = ? ),null,0, ");
        sQuery.append(
            " (SELECT MAX(NUM_LINE) FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        sQuery.append(
            " WHERE  CTDE_OID_CUPO_TRAM_DEPU = ? ) ) numero FROM DUAL ");
        parametros.add(dto.getOid());
        parametros.add(dto.getOid());

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("numLineaDetalleCuponTramitePorOIDCab: Exception", e);
            this.logSql("numLineaDetalleCuponTramitePorOIDCab SQL: ",
                sQuery.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Envolvemos en RecordSet en un DTOSalida y lo devolvemos
        DTOSalida dtos = new DTOSalida(resultado);

        UtilidadesLog.info("DAOGestionCuponTramite.numLineaDetalleCuponTramitePorOIDCab(DTOOID dto): Salida");
        return dtos;
    }

    public void creoCabeceraYDetalle(DTOCruzarCupon3conCupon1 dto, String situCupo) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.creoCabeceraYDetalle(): Entrada");
        
        StringBuffer query = new StringBuffer();                        
        Long oidCTD = null;
        Long oidDCTD = null;
        RecordSet rs = null;
        Long oidCabecera = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        query.append(" SELECT CCC_CTDE_SEQ.NEXTVAL FROM DUAL");                                  
        rs = this.executeQuery(query.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaDocumento = sdf.format(dto.getFechaDoc());            
        if((rs != null) && !(rs.esVacio()) ) {
            oidCabecera = existeUK(dto.getOidPais().longValue(), 
                        dto.getNumero().longValue(),
                        dto.getAnio(),
                        dto.getMes());
            if ((oidCabecera==null)) {                                                  
                oidCTD = this.bigDecimalToLong(rs.getValueAt(0,0));
                StringBuffer insert = new StringBuffer();
                
                insert.append("INSERT INTO CCC_CUPON_TRAMI_DEPUR (OID_CUPO_TRAM_DEPU, ");
                insert.append("NUM_CUPE, VAL_ANIO, VAL_PERI_MES, FEC_DOCU, VAL_REFE_EXTE, ");
                insert.append("VAL_OBSE, PAIS_OID_PAIS, MARC_OID_MARC, PERD_OID_PERI, ");
                insert.append("CANA_OID_CANA) VALUES ( " + oidCTD.longValue() + ", ");
                insert.append(dto.getNumero().longValue() + ", '" + dto.getAnio() + "', ");
                insert.append("'" + dto.getMes() + "', " + "TO_DATE('" + fechaDocumento + "', 'dd-MM-yyyy')" + ", " + "'" + dto.getReferenciaExterna() + "', ");
                insert.append("'" +dto.getObservaciones()+"'" + ", " + dto.getOidPais() + ", " + dto.getOidMarca().longValue());
                insert.append(", " + dto.getOidPeriodo().longValue() + ", " + dto.getOidCanal().longValue()  + ")");
                
                UtilidadesLog.debug("insert cabe.... " + insert.toString());
                try {
                    bs.dbService.executeUpdate(insert.toString());     
                    
                } catch (DuplicateKeyException ex) {
                    UtilidadesLog.error(ex);
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } catch (Exception e){        
                    UtilidadesLog.error("insert CCC_CUPON_TRAMI_DEPUR: Exception", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 
            }             
        }
        StringBuffer query1 = new StringBuffer();                                    
        query1.append(" SELECT CCC_DCTD_SEQ.NEXTVAL FROM DUAL");   
        RecordSet rs1 = null;
        rs1 = this.executeQuery(query1.toString());
        if(rs1 != null && !rs.esVacio()) {
            oidDCTD = this.bigDecimalToLong(rs1.getValueAt(0,0));
            StringBuffer insertDeta = new StringBuffer();
            
            Long cliente = null;
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = this.getClienteDatosBasicosLocalHome();
            ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;

            try {
                clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByCodigoYPais(dto.getOidPais(),
                        dto.getCodigoCliente());
            } catch (NoResultException fe) {
                //GEN-0007 no existe -->
               /* this.loguearError("cruzarCupon3conCupon1: FinderException", fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));*/
               UtilidadesLog.error("No se encontro datos basicos de cliente para codigo y pais");
            }
            if (clienteDatosBasicosLocal != null)
                cliente = clienteDatosBasicosLocal.getOid();
            
            DTOOID dtoOID2 = new DTOOID();
            DAOGestionCuponTramite daoGestionCuponTramite = new DAOGestionCuponTramite();
            dtoOID2 = daoGestionCuponTramite.cabCuponTramitePorNumero(dto.getNumero(), 
                                                                      dto.getAnio(),
                                                                      dto.getMes(),
                                                                      dto.getOidPais());
            Long cabeceraCupon = dtoOID2.getOid();
            DTOOID dtoOIDCabecera = new DTOOID();
            dtoOIDCabecera.setOid(cabeceraCupon); 
            Long numeroLinea = null;
            if (cabeceraCupon != null) {
                DTOSalida dtoNumeroLinea=(daoGestionCuponTramite.numLineaDetalleCuponTramitePorOIDCab(dtoOIDCabecera));
                if (!dtoNumeroLinea.getResultado().esVacio()) {
                    try {
                        UtilidadesLog.debug("numero de linea: " + dtoNumeroLinea.getResultado().getValueAt(0,0));
                        numeroLinea = new Long(((BigDecimal) dtoNumeroLinea.getResultado().getValueAt(0,0)).longValue());
                        numeroLinea =new Long(numeroLinea.longValue()+1);
                    } catch(Exception ex) {
                        ex.printStackTrace();	
                    }
                }
            }

            DAOCCC daoCCC = new DAOCCC();
            DTOOID dtoOID = daoCCC.obtenerOIDSituacionCuponPorCodigo(situCupo);
            Long situacion = dtoOID.getOid();
            UtilidadesLog.debug("situacion.... " + situacion);
            String fechaDigitacion = sdf.format(dto.getFechaDigitacion());            
            
            insertDeta.append("INSERT INTO CCC_DETAL_CUPON_TRAMI_DEPUR (OID_DETA_CUPO_TRAM_DEPU, ");
            insertDeta.append("CLIE_OID_CLIE, IMP_DETA, FEC_DIGI, NUM_LINE, FEC_DOCU, REF_EXTE, ");
            insertDeta.append("OBS_DETA_CUPO "); 
            
            if (dto.getNumeroCupon()!=null)
                insertDeta.append(", NUM_CUPO ");
            
            insertDeta.append(", CTDE_OID_CUPO_TRAM_DEPU, CCBA_OID_CC_BANC, ");
            insertDeta.append("SICU_OID_SITU_CUPO) VALUES ( " + oidDCTD.longValue() + ", ");
            insertDeta.append(cliente + ", " + dto.getImporte() + ", " + "TO_DATE('" + fechaDigitacion + "', 'dd-MM-yyyy')" + ", " + numeroLinea + ", ");
            insertDeta.append("TO_DATE('" + fechaDocumento + "', 'dd-MM-yyyy')" + ", " + "'"+dto.getReferenciaExterna()+"', " + "'"+dto.getObservaciones() +"'");
            
            if (dto.getNumeroCupon()!=null)
                insertDeta.append(", " + dto.getNumeroCupon().longValue());

            if (oidCabecera!=null)
                insertDeta.append(", " + oidCabecera.longValue() + ", " );
            else
                insertDeta.append(", " + oidCTD.longValue() + ", " );
            insertDeta.append(dto.getOidCtaCteBria().longValue() + ", " + situacion + ")");
    
            UtilidadesLog.debug("insert deta.... " + insertDeta.toString());
            try {
                bs.dbService.executeUpdate(insertDeta.toString());     
                
            } catch (DuplicateKeyException ex) {
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (Exception e){        
                UtilidadesLog.error("insert CCC_DETAL_CUPON_TRAMI_DEPUR: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        }    
        UtilidadesLog.info("DAOGestionCuponTramite.creoCabeceraYDetalle(): Salida");
    }
    
    public Long existeUK(long pais, long num_cupe, String anio, String mes) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.existeUK(long pais, long num_cupe, String anio, String mes): Entrada");
        StringBuffer query = new StringBuffer();                        
        //BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        Long resu = null;
        query.append("SELECT * FROM CCC_CUPON_TRAMI_DEPUR WHERE pais_oid_pais = " + pais);
        query.append(" AND NUM_CUPE = " + num_cupe);
        query.append(" AND VAL_ANIO = " + Long.valueOf(anio).longValue());
        query.append(" AND VAL_PERI_MES = " + Long.valueOf(mes).longValue());
        rs = this.executeQuery(query.toString());
        if (rs.getRowCount()>0){
            UtilidadesLog.info("DAOGestionCuponTramite.existeUK(long pais, long num_cupe, String anio, String mes): Salida (true)");
            resu = new Long(((BigDecimal) rs.getValueAt(0,0)).longValue());
            return resu;
        }else{
            UtilidadesLog.info("DAOGestionCuponTramite.existeUK(long pais, long num_cupe, String anio, String mes): Salida (false)");
            return resu;
        }    
    
    }
    
    public void updateSitu(Long oid, Long situ) throws MareException {
        //cambio fac 03, modulo ccc (SCS-29/01/2008)
        UtilidadesLog.info("DAOGestionCuponTramite.updateSitu(Long oid, Long situ): Entrada");
        StringBuffer update = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        update.append(" UPDATE CCC_DETAL_CUPON_TRAMI_DEPUR ");
        update.append(" SET SICU_OID_SITU_CUPO = " + situ.longValue());
        update.append(" WHERE OID_DETA_CUPO_TRAM_DEPU = " + oid.longValue());
        
        try {
            bs.dbService.executeUpdate(update.toString());     
            
        } catch (DuplicateKeyException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){        
            UtilidadesLog.error("insert CCC_CUPON_TRAMI_DEPUR: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        
        UtilidadesLog.info("DAOGestionCuponTramite.updateSitu(Long oid, Long situ): Salida");
    }
    
    public void eliminoDetalle(long oidDetalle) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.eliminoDetalle(long oidDetalle): Entrada");
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        query.append("WHERE OID_DETA_CUPO_TRAM_DEPU in (" + oidDetalle + ")");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          int reg = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("DAOFactoresConversion.eliminoDetalle(long oidDetalle): Se han eliminado ["+reg+"] registros");
        } catch (Exception e) {
          UtilidadesLog.error("DAOFactoresConversion.eliminoDetalle(long oidDetalle): Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOGestionCuponTramite.eliminoDetalle(long oidDetalle): Salida");
    }

    public boolean masDetalles(Long oidDetalle) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.masDetalles(long oidDetalle): Entrada");
        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");
        
        sQuery.append("SELECT COUNT(*) AS COUNT FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        sQuery.append("WHERE OID_DETA_CUPO_TRAM_DEPU NOT IN(?) ");
        parametros.add(oidDetalle);
        sQuery.append("AND CTDE_OID_CUPO_TRAM_DEPU IN (SELECT DISTINCT ");
        sQuery.append("CTDE_OID_CUPO_TRAM_DEPU FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        sQuery.append("WHERE OID_DETA_CUPO_TRAM_DEPU = ?) ");
        parametros.add(oidDetalle);
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("masDetalles: Exception", e);
            this.logSql("masDetalles. SQL: ", sQuery.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOGestionCuponTramite.masDetalles(long oidDetalle): Salida");
        if (((BigDecimal)(resultado.getValueAt(0, 0))).longValue() > 0)
            return true;
        else 
            return false;
    }
    
    public long cabeceraParaEsteDetalle(Long oidDetalle) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.cabeceraParaEsteDetalle(long oidDetalle): Entrada");
        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");
        long resu = 0;

        sQuery.append("SELECT DISTINCT CTDE_OID_CUPO_TRAM_DEPU FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
        sQuery.append("WHERE OID_DETA_CUPO_TRAM_DEPU = ?");
        parametros.add(oidDetalle);

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("cabeceraParaEsteDetalle: Exception", e);
            this.logSql("cabeceraParaEsteDetalle. SQL: ", sQuery.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOGestionCuponTramite.cabeceraParaEsteDetalle(long oidDetalle): Salida");
        if ((resultado!=null) && (resultado.getRowCount()>0))
            return resu = ((BigDecimal)(resultado.getValueAt(0, 0))).longValue();
        else
            return 0;
    }
    
    public void eliminoCabecera(long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOGestionCuponTramite.eliminoCabecera(long oidDetalle): Entrada");
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM CCC_CUPON_TRAMI_DEPUR ");
        query.append("WHERE OID_CUPO_TRAM_DEPU in (" + oidCabecera + ")");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          int reg = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("DAOFactoresConversion.eliminoDetalle(long oidDetalle): Se han eliminado ["+reg+"] registros");
        } catch (Exception e) {
          UtilidadesLog.error("DAOFactoresConversion.eliminoDetalle(long oidDetalle): Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOGestionCuponTramite.eliminoCabecera(long oidDetalle): Salida");
    }
    
    private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Entrada");
        RecordSet rs = null;
    
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
        throw new MareException( ex, 
            UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Salida");  
        return rs;
    }  
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }    
    
    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome()
        throws MareException {
        UtilidadesLog.info("MONGestionCuponTramiteBean.getClienteDatosBasicosLocalHome(): Entrada");
        UtilidadesLog.info("MONGestionCuponTramiteBean.getClienteDatosBasicosLocalHome(): Salida");

        return new ClienteDatosBasicosLocalHome();
    }
    
}
