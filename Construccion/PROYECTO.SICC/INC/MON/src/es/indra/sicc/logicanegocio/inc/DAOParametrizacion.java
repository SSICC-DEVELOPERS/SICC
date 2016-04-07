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
 * @autor: Dante Castiglione
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 * 
 *  
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.inc.DTOBusquedaPlantilla;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.Vector;

public class DAOParametrizacion {
    public DAOParametrizacion() {
    }

    public RecordSet consultarTiposCalificacion(DTOBelcorp DTOE)
        throws MareException {
        UtilidadesLog.info("DAOParametrizacion.consultarTiposCalificacion(DTOB"
            +"elcorp DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" select OID_TIPO_CALI, ");
        query.append(" VAL_I18N from INC_TIPO_CALIF tc, V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = tc.OID_TIPO_CALI ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_TIPO_CALIF' ");
        query.append(" and i.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" order by VAL_I18N ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarTiposCalificacion(DTOB"
            +"elcorp DTOE):Salida");
        return rs;
    }

    public RecordSet consultarDirigidoA(DTOBelcorp DTOE) throws MareException{
        UtilidadesLog.info("DAOParametrizacion.consultarDirigidoA(DTOBelcorp "
            +"DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" select OID_DIRI, VAL_I18N from INC_DIRIG d, ");
        query.append(" V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = d.OID_DIRI ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_DIRIG' ");
        query.append(" and i.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" order by VAL_I18N ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarDirigidoA(DTOBelcorp "
            +"DTOE):Salida");
        return rs;
    }

    public RecordSet consultarBasesCalculo(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("DAOParametrizacion.consultarBasesCalculo( "
            +" DTOBelcorp DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" select OID_BASE_CALC,  ");
        query.append(" VAL_I18N from INC_BASE_CALCU bc, V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = bc.OID_BASE_CALC ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_BASE_CALCU' ");
        query.append(" and i.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" order by VAL_I18N ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarBasesCalculo(DTOBelcor"
            +"p DTOE):Salida");
        return rs;
    }

    public RecordSet consultarTiposVenta(DTOBelcorp DTOE) throws MareException{
        UtilidadesLog.info("DAOParametrizacion.consultarTiposVenta(DTOBelcorp "
            +"DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" select OID_TIPO_VENT, ");
        query.append(" VAL_I18N from INC_TIPO_VENTA tv, V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = tv.OID_TIPO_VENT ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_TIPO_VENTA' ");
        query.append(" and i.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" order by VAL_I18N ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarTiposVenta(DTOBelcorp"
            +"DTOE):Salida");
        return rs;
    }

    public RecordSet consultarTiposConcursoIVR(DTOBelcorp DTOE)
        throws MareException {
        UtilidadesLog.info("DAOParametrizacion.consultarTiposConcursoIVR(DTOBe"
            +"lcorp DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" select OID_CONC_IVR, VAL_I18N from INC_CONCU_IVR c, ");
        query.append(" V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = c.OID_CONC_IVR ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_CONCU_IVR' ");
        query.append(" and i.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" order by VAL_I18N ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarTiposConcursoIVR(DTOBe"
            +"lcorp DTOE):Salida");
        return rs;
    }
    
    //Modificado por Cristian Valenzuela
    //Incidencia: BELC300023763
    //Fecha: 29/09/2006

    public RecordSet buscarPlantillas(DTOBusquedaPlantilla DTOE)
        throws MareException {
        UtilidadesLog.info("DAOParametrizacion.buscarPlantillas(DTOBusquedaPla"
            +"ntilla DTOE):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        
        query.append(" SELECT DISTINCT PC.OID, ");
        query.append(" PC.NUMERO, ");
        query.append(" PC.NOMBRE, ");
        query.append(" PAISPLANT.PAIS, ");
        query.append(" PC.MARCA, ");
        query.append(" PC.CANAL, ");
        query.append(" PC.ACCESO ");
        query.append(" FROM ( ");
        query.append(" SELECT PP.PLC2_OID_PLAN_CONC, ");
        query.append(" PP.PAIS_OID_PAIS OIDPAIS, ");
        query.append(" '' PAIS ");
        query.append(" FROM INC_PAIS_PLANT PP, SEG_PAIS P ");        
        query.append(" WHERE P.OID_PAIS = PP.PAIS_OID_PAIS ");
        query.append(" ) PAISPLANT ");
        query.append(" RIGHT OUTER JOIN ( ");
        query.append(" SELECT DISTINCT ");
        query.append(" A.OID_PLAN_CONC OID, ");
        query.append(" A.OID_PLAN_CONC NUMERO, ");
        query.append(" I.VAL_I18N NOMBRE, ");
        query.append(" '' PAIS, ");
        query.append(" '' MARCA, ");
        query.append(" I3.VAL_I18N CANAL, ");
        query.append(" '' ACCESO ");
        query.append(" FROM ");
        query.append(" INC_PLANT_CONCU A, ");        
        query.append(" INC_MARCA_PLANT C, ");
        query.append(" INC_ACCES_PLANT D, ");
        query.append(" SEG_MARCA F, ");
        query.append(" V_GEN_I18N_SICC I, ");        
        query.append(" V_GEN_I18N_SICC I3 ");        
        query.append(" WHERE C.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC  ");        

        if (DTOE.getNumeroPlantilla() != null) {
            query.append(" AND A.OID_PLAN_CONC = " + 
                DTOE.getNumeroPlantilla());
        }

        if (DTOE.getOidCanal() != null) {
            query.append(" AND A.CANA_OID_CANA = " + DTOE.getOidCanal());
        }
        
        if (DTOE.getIndBloqueado() != null) {
            query.append(" AND A.IND_BLOQ = " + DTOE.getIndBloqueado());
        }

        if (DTOE.getOidMarca() != null) {
            query.append(" AND C.MARC_OID_MARC = " + DTOE.getOidMarca());
        }

        query.append(" AND D.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC  ");

        if (DTOE.getOidAcceso() != null) {
            query.append(" AND D.ACCE_OID_ACCE = " + DTOE.getOidAcceso());
        }

        query.append(" AND F.OID_MARC = C.MARC_OID_MARC  ");
        query.append(" AND I.VAL_OID = A.OID_PLAN_CONC  ");

        if (DTOE.getNombrePlantilla() != null) {
            query.append(" AND I.VAL_I18N LIKE '" + 
                DTOE.getNombrePlantilla() + "'");
        }

        query.append(" AND I.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND I.ATTR_NUM_ATRI = 1  ");
        query.append(" AND I.ATTR_ENTI = 'INC_PLANT_CONCU' ");        
        query.append(" AND I3.VAL_OID = A.CANA_OID_CANA ");
        query.append(" AND I3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND I3.ATTR_NUM_ATRI = 1 ");
        query.append(" AND I3.ATTR_ENTI = 'SEG_CANAL' ");        
        query.append(" ) PC ON (PC.OID = PAISPLANT.PLC2_OID_PLAN_CONC) ");
        
        if(DTOE.getOidPaisPlantilla()!=null) {        
            query.append(" WHERE PAISPLANT.OIDPAIS = " + DTOE.getOidPaisPlantilla()  + 
            " OR PAISPLANT.OIDPAIS IS NULL ");            
        }

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                UtilidadesPaginacion.armarQueryPaginacion(
                    query.toString(), DTOE));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug(" El recordset es vacio");
            throw new MareException(new Exception(), UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("rs " + rs);

        Long[] arrayOids = this.obtieneOids(rs, new Long(0));

        for (int i = 0; i < arrayOids.length; i++) {
            UtilidadesLog.debug(" arrayOids " + arrayOids[i]);
        }

        RecordSet rPaises = obtieneDescPaisesPorOid(arrayOids, DTOE);
        RecordSet rMarcas = obtieneDescMarcasPorOid(arrayOids, DTOE);
        RecordSet rAccesos = obtieneDescAccesosPorOid(arrayOids, DTOE);

        rs = this.armaRSetFinalInsertarComisiones(rs, rPaises, rMarcas, rAccesos);
        UtilidadesLog.info("DAOParametrizacion.buscarPlantillas(DTOBusquedaPla"
            +"ntilla DTOE):Salida");
        return rs;
    }
    
    private RecordSet armaRSetFinalInsertarComisiones(RecordSet r,
        RecordSet rPaises, RecordSet rMarcas, RecordSet rAccesos) {
        
        UtilidadesLog.info("DAOParametrizacion.armaRSetFinalInsertarComisiones"
            +"(RecordSet r, RecordSet rPaises, RecordSet rMarcas, RecordSet"
            +"rAccesos):Entrada");
        
        UtilidadesLog.debug("RS CASI FINAL: " + r);
        UtilidadesLog.debug("rPaises: " + rPaises);
        UtilidadesLog.debug("rMarcas: " + rMarcas);
        UtilidadesLog.debug("rAccesos: " + rAccesos);

        for (int i = 0; i < r.getRowCount(); i++) {
            String descPais = "";
            BigDecimal oidPlantilla = (BigDecimal) r.getValueAt(i, 0);                
            
            for (int j = 0; j < rPaises.getRowCount(); j++) {                 
                Long oidPlanPais = (Long) rPaises.getValueAt(j, 0);                                  
                
                if(oidPlantilla.longValue() == oidPlanPais.longValue()) {
                    descPais = (String) rPaises.getValueAt(j, 1);                                        
                }
            }
            
            String descMarca = (String) rMarcas.getValueAt(i, 1);            
            String descAcceso = (String) rAccesos.getValueAt(i, 1);
            
            r.setValueAt(descPais, i, 3);                
            r.setValueAt(descMarca, i, 4);
            r.setValueAt(descAcceso, i, 6);           
        }      

       UtilidadesLog.debug("RecordSet FINAL: " + r);
       UtilidadesLog.info("DAOParametrizacion.armaRSetFinalInsertarComisiones"
            +"(RecordSet r, RecordSet rPaises, RecordSet rMarcas, RecordSet"
            +"rAccesos):Salida");
        return r;
    }

    private Long[] obtieneOids(RecordSet r, Long indexCol) {
        // Recorre el RecordSet y devuelve un array de Longs con los elementos
        //de la columna "indexCol".
       
        UtilidadesLog.info("DAOParametrizacion.obtieneOids(RecordSet r, Long "
            +"indexCol):Entrada");
        Vector v = new Vector();

        for (int i = 0; i < r.getRowCount(); i++) {
            BigDecimal b = (BigDecimal) r.getValueAt(i, indexCol.intValue());
            Long oid = new Long(b.longValue());
            v.add(oid);
        }

        Long[] array = (Long[]) v.toArray(new Long[v.size()]);
        UtilidadesLog.info("DAOParametrizacion.obtieneOids(RecordSet r, Long "
            +"indexCol):Salida");
        return array;
    }

    private String generaINClause(Long[] oids) throws MareException {
        UtilidadesLog.info("DAOParametrizacion.generaINClause(Long[] oids):"
            +"Entrada");
        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");

            for (int i = 0; i < oids.length; i++) {
                Long oid = oids[i];

                if (i != 0) {
                    sClausula.append(", ");
                }

                sClausula.append("" + oid);
            }

            sClausula.append(")");
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                sCodigoError));
        }
        UtilidadesLog.info("DAOParametrizacion.generaINClause(Long[] oids):"
            +"Salida");
        return sClausula.toString();
    }

    private RecordSet concatenaCampos(RecordSet r) {
        // Recordset de Entrada tiene el sig. formato: [oid, desc],
        // ordenado por oid en forma ascendente. 
        // Concatena en una sola tupla aquellas descripciones que posean el 
        // mismo oid.
        UtilidadesLog.info("DAOParametrizacion.concatenaCampos(RecordSet r):"
            +"Entrada");
        UtilidadesLog.debug(" Recordset entrada: " + r);

        RecordSet rToReturn = new RecordSet();

        Vector vCols = new Vector();
        vCols.add("Oid");
        vCols.add("Desc");
        rToReturn.setColumnIdentifiers(vCols);

        int cantFilasOriginal = r.getRowCount();

        if (r.getRowCount() > 0) {
            // Obtengo el primero elemento fuera del bucle.
            BigDecimal bigBuffer = (BigDecimal) r.getValueAt(0, 0);
            String descBuffer = (String) r.getValueAt(0, 1);

            if (descBuffer == null) {
                descBuffer = "";
            }

            long oidAnterior = bigBuffer.longValue();
            StringBuffer sCadena = new StringBuffer(descBuffer);

            // Corte de control. 
            for (int i = 1; i < cantFilasOriginal; i++) {
                UtilidadesLog.debug(" Bucle: " + i);

                // Obtenemos el oid. 
                BigDecimal bigOid = (BigDecimal) r.getValueAt(i, 0);
                String sDesc = (String) r.getValueAt(i, 1);

                if (sDesc == null) {
                    sDesc = "";
                }

                if ((oidAnterior == bigOid.longValue()) && (i != cantFilasOriginal)) {
                    // Si el oid del registro anterior es el mismo que el actual.            
                    // continua concatenando descripcion.
                    UtilidadesLog.debug(" Match! - oid: " + oidAnterior);

                    // Concatena la desc. a sCadena. 
                    if (!sCadena.equals("")) {
                        sCadena.append(", ");
                    }

                    sCadena.append(sDesc);
                    UtilidadesLog.debug("sCadena actual: " + sCadena.toString());
                } else {
                    // Graba el oid y la cadena en el Recordset a retornar
                    Vector vFila = new Vector();
                    vFila.add(new Long(oidAnterior));
                    vFila.add(sCadena.toString());
                    rToReturn.addRow(vFila);
                    UtilidadesLog.debug("************ Agrega vfila: " + vFila);

                    // Setea "oidAnterior" con el oid actual y limpia sCadena.
                    String sDescNueva = (String) r.getValueAt(i, 1);

                    if (sDescNueva == null) {
                        sDescNueva = "";
                    }

                    sCadena = new StringBuffer(sDescNueva);
                }

                oidAnterior = bigOid.longValue();
            }

            Vector vFila = new Vector();
            vFila.add(new Long(oidAnterior));
            vFila.add(sCadena.toString());
            rToReturn.addRow(vFila);
            UtilidadesLog.debug(" Agrega ultima vfila: " + vFila);
        }

        UtilidadesLog.debug(" RecordSet Salida: " + rToReturn);
        UtilidadesLog.info("DAOParametrizacion.concatenaCampos(RecordSet r):"
            +"Salida");
        return rToReturn;
    }

    //Modificado por Cristian Valenzuela
    //Incidencia: BELC300023763
    //Fecha: 13/09/2006
    private RecordSet obtieneDescPaisesPorOid(Long[] arrayOids, 
        DTOBusquedaPlantilla DTOE) throws MareException {
        UtilidadesLog.info("DAOParametrizacion.obtieneDescPaisesPorOid(Long[] "
            +"arrayOids, DTOBusquedaPlantilla DTOE):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        String oids = this.generaINClause(arrayOids);

        query.append(" SELECT A.OID_PLAN_CONC OID, ");
        query.append(" I2.VAL_I18N DESC2 ");
        query.append(" FROM  INC_PLANT_CONCU A, ");
        query.append(" INC_PAIS_PLANT B, ");
        query.append(" V_GEN_I18N_SICC I2 ");
        query.append(" WHERE B.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC ");
        query.append(" AND A.OID_PLAN_CONC " + oids);
        query.append(" AND I2.VAL_OID = B.PAIS_OID_PAIS ");
        query.append(" AND I2.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND I2.ATTR_NUM_ATRI = 1 ");
        query.append(" AND I2.ATTR_ENTI = 'SEG_PAIS' ");
        query.append(" ORDER BY A.OID_PLAN_CONC ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            rs = this.concatenaCampos(rs);    
        }
        
        UtilidadesLog.info("DAOParametrizacion.obtieneDescPaisesPorOid(Long[] "
            +"arrayOids, DTOBusquedaPlantilla DTOE):Salida");
        return rs;
    }

    private RecordSet obtieneDescMarcasPorOid(Long[] arrayOids, 
        DTOBusquedaPlantilla DTOE) throws MareException {
        UtilidadesLog.info("DAOParametrizacion.obtieneDescMarcasPorOid(Long[]"
            +" arrayOids, DTOBusquedaPlantilla DTOE):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        String oids = this.generaINClause(arrayOids);

        query.append(" SELECT ");
        query.append(" A.OID_PLAN_CONC OID, ");
        query.append(" F.DES_MARC ");
        query.append(" FROM ");
        query.append(" INC_PLANT_CONCU A, ");
        query.append(" INC_MARCA_PLANT C, ");
        query.append(" SEG_MARCA F ");
        query.append(" WHERE A.OID_PLAN_CONC " + oids);
        query.append(" AND C.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC ");
        query.append(" AND F.OID_MARC = C.MARC_OID_MARC ");
        query.append(" ORDER BY A.OID_PLAN_CONC ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug(" El recordset es vacio");
            throw new MareException(new Exception(), UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        rs = this.concatenaCampos(rs);
        UtilidadesLog.info("DAOParametrizacion.obtieneDescMarcasPorOid(Long[] "
            +"arrayOids, DTOBusquedaPlantilla DTOE):Salida");
        return rs;
    }

    private RecordSet obtieneDescAccesosPorOid(Long[] arrayOids, 
        DTOBusquedaPlantilla DTOE) throws MareException {
        UtilidadesLog.info("DAOParametrizacion.obtieneDescAccesosPorOid(Long[]"
            +"arrayOids, DTOBusquedaPlantilla DTOE):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        String oids = this.generaINClause(arrayOids);

        query.append(" SELECT ");
        query.append(" A.OID_PLAN_CONC OID, ");
        query.append(" I4.VAL_I18N DESC4 ");
        query.append(" FROM ");
        query.append(" INC_PLANT_CONCU A, ");
        query.append(" INC_ACCES_PLANT D, ");
        query.append(" V_GEN_I18N_SICC I4 ");
        query.append(" WHERE A.OID_PLAN_CONC " + oids);
        query.append(" AND D.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC ");
        query.append(" AND I4.VAL_OID = D.ACCE_OID_ACCE ");
        query.append(" AND I4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND I4.ATTR_NUM_ATRI = 1 ");
        query.append(" AND I4.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" ORDER BY A.OID_PLAN_CONC ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("********* El recordset es vacio");
            throw new MareException(new Exception(), UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        rs = this.concatenaCampos(rs);
        UtilidadesLog.info("DAOParametrizacion.obtieneDescAccesosPorOid(Long[]"
            +"arrayOids, DTOBusquedaPlantilla DTOE):Salida");
        return rs;
    }
    
    // vbongiov -- INC 014 -- 20/10/2008
    public RecordSet consultarEstadoConcurso(DTOBelcorp dtoe)  throws MareException
    {
        UtilidadesLog.info("DAOParametrizacion.consultarEstadoConcurso(DTOBelcorp DTOE):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        query.append(" select OID_VIGE_CONC, VAL_I18N from INC_VIGEN_CONCU c, ");
        query.append(" V_GEN_I18N_SICC i ");
        query.append(" where i.VAL_OID = c.OID_VIGE_CONC ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.ATTR_ENTI = 'INC_VIGEN_CONCU' ");
        query.append(" and i.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        query.append(" order by VAL_I18N ");
        try
        {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        }
        catch(MareException me)
        {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        }
        catch(Exception e)
        {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("DAOParametrizacion.consultarTiposConcursoIVR(DTOBelcorp DTOE):Salida");
        return rs;
    }
}
