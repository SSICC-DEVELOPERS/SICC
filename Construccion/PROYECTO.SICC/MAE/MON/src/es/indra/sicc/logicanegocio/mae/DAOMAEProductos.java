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

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;
import es.indra.sicc.dtos.mae.DTOBuscarProductosOferta;
import es.indra.sicc.dtos.mae.DTOBusquedaKit;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOConsultaKit;
import es.indra.sicc.dtos.mae.DTOImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.ZONEjbLocators;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
public class DAOMAEProductos {
    //	private static final String FILE = "DAOMAEProductos.java";
    private Hashtable entidades = new Hashtable();
    private String usuario;

    public DAOMAEProductos() {
        // entidades
        entidades.put("Generico", "MAE_GENER");
        entidades.put("Marca", "SEG_MARCA");
        entidades.put("Negocio", "MAE_NEGOC");
        entidades.put("SuperGenerico", "MAE_SUPER_GENER");
        entidades.put("UnidadNegocio", "MAE_UNIDA_NEGOC");
        entidades.put("Productos", "MAE_PRODU");
        entidades.put("LineaProductos", "MAE_LINEA_PRODU");
        entidades.put("UnidadMedida", "MAE_UNIDA_MEDID");
        entidades.put("Estatus", "MAE_ESTAT_PRODU");

        entidades.put("Internacionalizacion", "V_GEN_I18N_SICC");
    }

    public DAOMAEProductos(String newusuario) {
        UtilidadesLog.info("antes");
        setUsuario(newusuario);
        UtilidadesLog.info("despues");

        // entidades
        entidades.put("Generico", "MAE_GENER");
        entidades.put("Marca", "SEG_MARCA");
        entidades.put("Negocio", "MAE_NEGOC");
        entidades.put("SuperGenerico", "MAE_SUPER_GENER");
        entidades.put("UnidadNegocio", "MAE_UNIDA_NEGOC");
        entidades.put("Productos", "MAE_PRODU");
        entidades.put("LineaProductos", "MAE_LINEA_PRODU");
        entidades.put("UnidadMedida", "MAE_UNIDA_MEDID");
        entidades.put("Estatus", "MAE_ESTAT_PRODU");

        entidades.put("Internacionalizacion", "V_GEN_I18N_SICC");
        UtilidadesLog.info("mas despues");
    }

    public void setUsuario(String newUser) {
        usuario = newUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public RecordSet buscarUnidadesNegocioPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesNegocioPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N");
        query.append("   FROM V_GEN_I18N_SICC i, MAE_UNIDA_NEGOC t ");
        query.append("  WHERE i.VAL_OID = t.OID_UNID_NEGO ");
        query.append("    AND i.ATTR_ENTI = 'MAE_UNIDA_NEGOC' ");
        query.append("    AND i.ATTR_NUM_ATRI = 1 ");
        query.append("    AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("    AND t.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesNegocioPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    public RecordSet buscarNegocioPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarNegocioPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N");
        query.append("   FROM V_GEN_I18N_SICC i, MAE_NEGOC t ");
        query.append("  WHERE i.VAL_OID = t.OID_NEGO ");
        query.append("    AND i.ATTR_ENTI = 'MAE_NEGOC' ");
        query.append("    AND i.ATTR_NUM_ATRI = 1 ");
        query.append("    AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("    AND t.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarNegocioPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    public RecordSet buscarGenericosPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarGenericosPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N");
        query.append("   FROM V_GEN_I18N_SICC i, MAE_GENER t ");
        query.append("  WHERE i.VAL_OID = t.OID_GENE ");
        query.append("    AND i.ATTR_ENTI = 'MAE_GENER' ");
        query.append("    AND i.ATTR_NUM_ATRI = 1 ");
        query.append("    AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("    AND t.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarGenericosPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    public RecordSet buscarSuperGenericoPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarSuperGenericoPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N");
        query.append("   FROM V_GEN_I18N_SICC i, MAE_SUPER_GENER t ");
        query.append("  WHERE i.VAL_OID = t.OID_SUPE_GENE ");
        query.append("    AND i.ATTR_ENTI = 'MAE_SUPER_GENER' ");
        query.append("    AND i.ATTR_NUM_ATRI = 1 ");
        query.append("    AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("    AND t.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarSuperGenericoPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    /** Realiza el acceso a la tabla de Maestro de Productos y recupera registros filtrados por criterios
     * @param DTOBuscarProductosOferta
          * @throws MareException
     * @return RecorSet
     */
    public RecordSet buscarProductosParaOferta(DTOBuscarProductosOferta dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarProductosParaOferta(DTOBuscarProductosOferta): Entrada"); 
        
        UtilidadesLog.debug("DTOBuscarProductosOferta: " + dto);

        StringBuffer query = new StringBuffer();

        query.append("SELECT ");
        query.append("M.OID_PROD OID, ");
        query.append("M.COD_SAP, ");
        query.append("G.VAL_I18N, ");
        query.append("M.VAL_PREC_CATA, ");
        query.append("M.VAL_PREC_POSI, ");
        query.append("M.VAL_COST_ESTD, ");
        query.append("M.VAL_ATRI_1, ");
        query.append("M.VAL_ATRI_2, ");
        query.append("M.VAL_ATRI_3, ");
        query.append("M.DES_CORT, m.PRFI_OID_PROG_FIDE ");
        query.append("FROM MAE_PRODU M, GEN_I18N_SICC G ");
        query.append("WHERE M.PAIS_OID_PAIS = '" + dto.getOidPais() + "'");
        query.append(" AND G.ATTR_ENTI = 'MAE_PRODU' ");
        query.append(" AND G.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
        query.append(" AND G.VAL_OID = M.OID_PROD ");

        //filtros condicionales.
        if ((dto.getCodigoSAP() != null)) {
            query.append(" AND UPPER(M.COD_SAP) LIKE '" + dto.getCodigoSAP().toUpperCase() + "'");
        }

        if ((dto.getDescripcion() != null)) {
            query.append(" AND G.VAL_I18N LIKE '" + dto.getDescripcion() + "'");
        }

        if ((dto.getMarca() != null)) {
            query.append(" AND M.MAPR_OID_MARC_PROD = '" + dto.getMarca() + "'");
        }

        if ((dto.getLineaProducto() != null)) {
            query.append(" AND M.LIPR_OID_LINE_PROD = '" + dto.getLineaProducto() + "'");
        }

        if ((dto.getNegocio() != null)) {
            query.append(" AND M.NEGO_OID_NEGO = '" + dto.getNegocio() + "'");
        }

        if ((dto.getGenerico() != null)) {
            query.append(" AND M.GENE_OID_GENE = '" + dto.getGenerico() + "'");
        }

        if ((dto.getSupergenerico() != null)) {
            query.append(" AND M.SGEN_OID_SUPE_GENE = '" + dto.getSupergenerico() + "'");
        }

        // vbongiov -- Cambio 20090930 -- 16/07/2009
        if(dto.getIndPremio() == null || (!dto.getIndPremio().booleanValue())){
            // CUV-40 - dmorello, 18/09/2006: Se eliminan productos con CUV nulo
            query.append(" AND M.COD_UNIC_VENT IS NOT NULL ");
        }

        RecordSet resultado = new RecordSet();

        try {
            resultado = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener productos para oferta", e);
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarProductosParaOferta(DTOBuscarProductosOferta): Salida"); 

        return resultado;
    }

    /** Realiza el acceso a la tabla de Maestro de Productos para obtener productos por criterios
     * @param DTOBusquedaMateriales
          * @throws MareException
     * @return DTOSalida
     */
    public DTOSalida buscarProductosPorCriterios(DTOBusquedaMateriales dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarProductosPorCriterios(DTOBusquedaMateriales): Entrada"); 

        StringBuffer query = new StringBuffer();

        String entidadInter = (String) entidades.get("Internacionalizacion");

        query.append(" SELECT M.OID_PROD OID, ");
        query.append(" M.COD_SAP, ");
        query.append(" M.CODI_ANTI, ");
        query.append(" M.DES_CORT, ");
        query.append(" M.IND_LOTE, ");
        query.append(" M.IND_PROD_SERV, ");
        query.append(" M.MAPR_OID_MARC_PROD, ");
        query.append(" SG.DES_MARC_PROD, "); //DES_MARC_PROD

        //Campos a mostrar descripcion
        query.append(" M.OID_PROD, ");
        query.append(" M.UNEG_OID_UNID_NEGO, ");
        query.append(" M.NEGO_OID_NEGO, ");
        query.append(" M.GENE_OID_GENE, ");
        query.append(" M.SGEN_OID_SUPE_GENE, ");

        //Internacionalizacion
        query.append(" IProd.VAL_I18N DES_MAE_PRODU, ");
        query.append(" IUnidad.VAL_I18N DES_MAE_UNIDA_NEGOC, ");
        query.append(" INegoc.VAL_I18N DES_MAE_NEGOC, ");
        query.append(" IGener.VAL_I18N DES_MAE_GENER, ");
        query.append(" ISuper.VAL_I18N DES_MAE_SUPER_GENER ");

        //query.append(agregarCampoFK(entidad));
        if (dto.getDescSAP() == null) {
            query.append(" FROM MAE_PRODU M, SEG_MARCA_PRODU SG, ");
        } else {
            query.append(" FROM MAE_PRODU M, GEN_I18N_SICC G, SEG_MARCA_PRODU SG, ");
        }

        //Internacionalizacion
        query.append(" V_GEN_I18N_SICC IProd, V_GEN_I18N_SICC IUnidad, V_GEN_I18N_SICC INegoc, ");
        query.append(" V_GEN_I18N_SICC IGener, V_GEN_I18N_SICC ISuper ");

        //query.append(" , VCA_SEG_MARCA VM "); //Vista de Marca, DMCO 3.07
        //query.append(armarJoin(entidadInter,(String)entidades.get("Marca"));

        /* LO MODIQUE PARA QUE NO TOME EL M.CODSAP,M.CODI_ANTI,M.DES_CORT
        *  COMO =   Y FILTRE COMO LIKE
        */
        UtilidadesLog.debug("***************Indicador de lote " + dto.getIndLote());

        query.append(UtilidadesBD.armarSQLWhere(new String[] {
                    "M.PAIS_OID_PAIS", "M.MAPR_OID_MARC_PROD",
                    "M.UNEG_OID_UNID_NEGO", "M.NEGO_OID_NEGO", "M.GENE_OID_GENE",
                    "M.SGEN_OID_SUPE_GENE"
                }, new Object[] {
                    dto.getOidPais(), dto.getMarca(), dto.getUnidadNegocio(),
                    dto.getNegocio(), dto.getGenerico(), dto.getSupergenerico()
                }, new boolean[] { false, false, false, false, false, false, false }));

        if (dto.getIndLote() != null) {
            if (dto.getIndLote().booleanValue()) {
                query.append(" AND M.IND_LOTE = 1 ");
            } else {
                query.append(" AND M.IND_LOTE = 0 ");
            }
        }

        if (dto.getIndProductoServicio() != null) {
            if (dto.getIndProductoServicio().booleanValue()) {
                query.append(" AND M.IND_PROD_SERV = 1 ");
            } else {
                query.append(" AND M.IND_PROD_SERV = 0 ");
            }
        }

        UtilidadesLog.info(query);

        //Dado que la marca ahora no esta internacionalizada
        if (query.toString().toUpperCase().indexOf(" WHERE ") == -1) {
            query.append(" WHERE M.MAPR_OID_MARC_PROD = SG.OID_MARC_PROD (+)"); //SEG_MARCA_PRODU.OID_MARC_PROD
        } else {
            query.append(" AND  M.MAPR_OID_MARC_PROD = SG.OID_MARC_PROD (+) ");
        }

        //MAE_PRODU
        query.append(" AND IProd.ATTR_ENTI(+) = 'MAE_PRODU'  ");
        query.append(" AND IProd.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
        query.append(" AND IProd.VAL_OID(+) = M.OID_PROD  ");
        query.append(" AND IProd.ATTR_NUM_ATRI(+) = 1 ");

        //MAE_UNIDA_NEGOC
        query.append(" AND IUnidad.ATTR_ENTI(+) = 'MAE_UNIDA_NEGOC'  ");
        query.append(" AND IUnidad.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
        query.append(" AND IUnidad.VAL_OID(+) = M.UNEG_OID_UNID_NEGO  ");
        query.append(" AND IUnidad.ATTR_NUM_ATRI(+) = 1 ");

        //MAE_NEGOC
        query.append(" AND INegoc.ATTR_ENTI(+) = 'MAE_NEGOC'  ");
        query.append(" AND INegoc.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
        query.append(" AND INegoc.VAL_OID(+) = M.NEGO_OID_NEGO  ");
        query.append(" AND INegoc.ATTR_NUM_ATRI(+) = 1 ");

        //MAE_GENER
        query.append(" AND IGener.ATTR_ENTI(+) = 'MAE_GENER'  ");
        query.append(" AND IGener.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
        query.append(" AND IGener.VAL_OID(+) = M.GENE_OID_GENE  ");
        query.append(" AND IGener.ATTR_NUM_ATRI(+) = 1 ");

        //MAE_SUPER_GENER
        query.append(" AND ISuper.ATTR_ENTI(+) = 'MAE_SUPER_GENER'  ");
        query.append(" AND ISuper.IDIO_OID_IDIO(+) = " + dto.getOidIdioma() + " ");
        query.append(" AND ISuper.VAL_OID(+) = M.SGEN_OID_SUPE_GENE  ");
        query.append(" AND ISuper.ATTR_NUM_ATRI(+) = 1 ");

        if (dto.getDescSAP() != null) {
            String entiProd = (String) entidades.get("Productos");
            query.append(" AND G.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND G.VAL_OID = M.OID_PROD ");
            query.append(" AND G.ATTR_ENTI = '" + entiProd + "' ");
            query.append(" AND UPPER(G.VAL_I18N) LIKE '" + dto.getDescSAP().toUpperCase() + "' ");
        }

        //Agregar en el query append para hacer el Like
        if (dto.getCodSAP() != null) {
            query.append(" AND M.COD_SAP LIKE UPPER('" + dto.getCodSAP().toUpperCase() + "') ");
        }

        if (dto.getCodAntiguo() != null) {
            query.append(" AND M.CODI_ANTI LIKE UPPER('" + dto.getCodAntiguo().toUpperCase() + "') ");
        }

        if (dto.getDescCorta() != null) {
            query.append(" AND UPPER(M.DES_CORT) LIKE '" + dto.getDescCorta().toUpperCase() + "' ");
        }

        //Vista marca, join. DMCO 3.07
        //query.append(" AND VM.COD_USUA (+) = '" + this.usuario + "'");
        //query.append(" AND VM.OID_MARC (+) = M.MAPR_OID_MARC_PROD ");
        query.append(" ORDER BY M.COD_SAP");

        //==================
        //FIN CREACION QUERY
        //==================
        UtilidadesLog.info(query);

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener productos por criterios", e);
        }

        UtilidadesLog.debug("Antes trae Desc");

        if (rs.esVacio()) {
            UtilidadesLog.debug("entro al if valor " + rs);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        DTOSalida dtoSal = new DTOSalida();
        dtoSal.setResultado(rs);
        UtilidadesLog.info("DAOMAEproductos.buscarProductosPorCriterios(DTOBusquedaMateriales): Salida"); 

        return dtoSal;
    }

    /** Realiza el acceso a la tabla de Negocio para obtener negocios por pais
     * @param DTOBelcorp
          * @throws MareException
     * @return RecordSet
     */
    public String obtenerDescSAP(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.obtenerDescSAP(DTOOID): Entrada"); 

        String entidad = (String) entidades.get("Productos");

        String sAND = " AND " + entidad + ".PAIS_OID_PAIS = " + dto.getOidPais() + " ";
        Hashtable atributos = cargarAtributosTraducibles(entidad);
        RecordSet rs = new RecordSet();

        if (atributos.containsKey("DESCRIPCION SAP")) {
            rs = getCodigoDescripcionTraducible(entidad, new Integer(((BigDecimal) atributos.get("DESCRIPCION SAP")).intValue()), dto.getOidIdioma(), new String[] {
                        sAND
                    }); // Todo idioma
        }

        if (!rs.esVacio()) {
            UtilidadesLog.info("DAOMAEproductos.obtenerDescSAP(DTOOID): Salida"); 
            return (String) rs.getValueAt(0, "VAL_I18N");
        } else {
            UtilidadesLog.info("DAOMAEproductos.obtenerDescSAP(DTOOID): Salida"); 
            return null;
        }
    }

    /** Realiza el acceso a la tabla de Linea de Productos por pais
     * @param DTOInternacional
          * @throws MareException
     * @return RecordSet
     */
    public RecordSet buscarLineasProductoPorPais(DTOBelcorp dto) throws MareException {
       UtilidadesLog.info("DAOMAEproductos.buscarLineasProductoPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N");
        query.append("   FROM V_GEN_I18N_SICC i, MAE_LINEA_PRODU t ");
        query.append("  WHERE i.VAL_OID = t.OID_LINE_PROD ");
        query.append("    AND i.ATTR_ENTI = 'MAE_LINEA_PRODU' ");
        query.append("    AND i.ATTR_NUM_ATRI = 1 ");
        query.append("    AND i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("    AND t.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" ORDER BY VAL_I18N ASC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEproductos.buscarLineasProductoPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    /** Realiza el acceso a la tabla de Unidades de Medida por pais
     * @param DTOBelcorp
          * @throws MareException
     * @return RecordSet
     */
    public RecordSet buscarUnidadesMedidaPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesMedidaPorPais(DTOBelcorp): Entrada"); 

        StringBuffer query = new StringBuffer();
        query.append(" SELECT uni.OID_UNID_MEDI, i18n.VAL_I18N ");
        query.append(" FROM MAE_UNIDA_MEDID uni,V_GEN_I18N_SICC i18n ");
        query.append(" WHERE uni.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND uni.OID_UNID_MEDI = i18n.VAL_OID ");
        query.append(" AND i18n.ATTR_ENTI = 'MAE_UNIDA_MEDID' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Unidades de medida por pais", e);
        }
        
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesMedidaPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    /** Realiza el acceso a la tabla de Estatus de producto por pais
     * @param DTOBelcorp
          * @throws MareException
     * @return RecordSet
     */
    public RecordSet buscarEstatusPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesMedidaPorPais(DTOBelcorp): Entrada"); 

        StringBuffer query = new StringBuffer();
        query.append(" SELECT produ.OID_ESTA_PROD, i18n.VAL_I18N ");
        query.append(" FROM MAE_ESTAT_PRODU produ,V_GEN_I18N_SICC i18n ");
        query.append(" WHERE produ.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND produ.OID_ESTA_PROD = i18n.VAL_OID ");
        query.append(" AND i18n.ATTR_ENTI = 'MAE_ESTAT_PRODU' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener Estatus cliente por pais", e);
        }
        UtilidadesLog.info("DAOMAEproductos.buscarUnidadesMedidaPorPais(DTOBelcorp): Salida"); 
        return rs;
    }

    /** Realiza el acceso a la tabla de MAE_IMPUE_UBIGE
      * @param DTOImpuestoUBIGEO
           * @throws MareException
      * @return DTOSalida
      */
    public DTOSalida buscarImpuestosUbigeo(DTOImpuestoUBIGEO dtoImpuestoUG) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarImpuestosUbigeo(DTOImpuestoUBIGEO): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        DTOSalida dtos = new DTOSalida();

        /*agregado para prueba de paginacion */
        UtilidadesLog.info("" + dtoImpuestoUG.getUltimaPagina());
        UtilidadesLog.info(dtoImpuestoUG.getTamanioPagina());
        UtilidadesLog.info(dtoImpuestoUG.getIndicadorSituacion());

        bs = UtilidadesEJB.getBelcorpService();

        try {
            StringBuffer query = new StringBuffer();

            query.append("SELECT a.OID_IMPU_UBIG as OID, m.COD_SAP, i4.VAL_I18N tasa, i1.VAL_I18N canal,");
            query.append("i2.VAL_I18N acceso,i3.VAL_I18N subacceso");
            query.append(" FROM MAE_IMPUE_UBIGE a, seg_subac b, seg_acces c, seg_canal d, mae_produ m,");
            query.append(" v_gen_i18n_sicc i1, v_gen_i18n_sicc i2, v_gen_i18n_sicc i3, v_gen_i18n_sicc i4");
            query.append(" WHERE a.SBAC_OID_SBAC = b.OID_SBAC ");
            query.append(" and b.ACCE_OID_ACCE = c.OID_ACCE ");
            query.append(" and c.CANA_OID_CANA = d.OID_CANA ");
            query.append(" and m.OID_PROD = a.PROD_OID_PROD ");
            query.append(" and i1.ATTR_ENTI = 'SEG_CANAL' ");
            query.append(" and i1.ATTR_NUM_ATRI = 1 ");
            query.append(" AND i1.IDIO_OID_IDIO = " + dtoImpuestoUG.getOidIdioma());
            query.append(" AND i1.VAL_OID = c.CANA_OID_CANA ");
            query.append(" AND i2.ATTR_ENTI = 'SEG_ACCES' ");
            query.append(" AND i2.ATTR_NUM_ATRI = 1 ");
            query.append(" AND i2.IDIO_OID_IDIO = " + dtoImpuestoUG.getOidIdioma());
            query.append(" AND i2.VAL_OID = c.OID_ACCE ");
            query.append(" AND i3.ATTR_ENTI = 'SEG_SUBAC' ");
            query.append(" AND i3.ATTR_NUM_ATRI = 1 ");
            query.append(" AND i3.IDIO_OID_IDIO = " + dtoImpuestoUG.getOidIdioma());
            query.append(" AND i3.VAL_OID = b.OID_SBAC ");
            query.append(" AND i4.ATTR_ENTI (+) = 'PED_TASA_IMPUE' ");
            query.append(" AND i4.ATTR_NUM_ATRI (+)= 1 ");
            query.append(" AND i4.IDIO_OID_IDIO (+)= " + dtoImpuestoUG.getOidIdioma());
            query.append(" AND i4.VAL_OID  (+) = a.TAIM_OID_TASA_IMPU ");

            if (dtoImpuestoUG.getAcceso() != null) {
                query.append(" and  b.ACCE_OID_ACCE = " + dtoImpuestoUG.getAcceso());
            }
            if (dtoImpuestoUG.getTasaImpuesto() != null) {
                query.append(" and a.TAIM_OID_TASA_IMPU= " + dtoImpuestoUG.getTasaImpuesto());
            }

            if (dtoImpuestoUG.getSubacceso() != null) {
                query.append(" and a.SBAC_OID_SBAC = " + dtoImpuestoUG.getSubacceso());
            }

            if (dtoImpuestoUG.getCanal() != null) {
                query.append(" and c.CANA_OID_CANA = " + dtoImpuestoUG.getCanal());
            }

            if ((dtoImpuestoUG.getMaterial() != null) && !(dtoImpuestoUG.getMaterial().equals(""))) {
                query.append(" and m.COD_SAP LIKE '" + dtoImpuestoUG.getMaterial() + "'");
            }

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoImpuestoUG);

            resultado = bs.dbService.executeStaticQuery(queryStr);

            //            resultado = bs.dbService.executeStaticQuery(query.toString());
            /*RecordSet resultadoPag = new RecordSet();
            String descripcionUBIGEO;

            if (!resultado.esVacio()) {
                    //                resultadoPag.addColumn("numerorow");
                    resultadoPag.addColumn("OID");
                    resultadoPag.addColumn("COD_SAP");
                    resultadoPag.addColumn("VEPO_OID_VALO_ESTR_GEOP");

                    //resultadoPag.addColumn("TAIM_OID_TASA_IMPU");
                    resultadoPag.addColumn("val_impu_i18n");
                    UtilidadesLog.info("resultado  " + resultado.toString());

                    for (int i = 0; i < resultado.getRowCount(); i++) {
                            //columna 2 tien oidUG
                            BigDecimal ug = (BigDecimal) resultado.getValueAt(i, 2);
                            Long oidEstGeop = new Long(ug.longValue());
                            UtilidadesLog.info("oidUG    " + oidEstGeop);

                            //ZONEjbLocators.getMONUnidadesGeograficasHome().create().obtenerDescripcionUBIGEO(oidEstGeop);
                            descripcionUBIGEO = ZONEjbLocators.getMONUnidadesGeograficasHome()
                                                                                              .create()
                                                                                              .obtenerDescripcionUBIGEO(oidEstGeop);

                            //resultadoPag.addRow(  new Object[]{resultado.getValueAt(i,0),resultado.getValueAt(i,1),resultado.getValueAt(i,2), descripcionUBIGEO, resultado.getValueAt(i,4) });
                            resultadoPag.addRow(new Object[] {
                                            resultado.getValueAt(i, 0),
                                            resultado.getValueAt(i, 1), descripcionUBIGEO,
                                            resultado.getValueAt(i, 4)
                                    });
                    }
            }

                  dtos.setResultado(resultadoPag);*/
            UtilidadesLog.debug("***********el resultado es " + resultado);
            dtos.setResultado(resultado);
            UtilidadesLog.info("DAOMAEproductos.buscarImpuestosUbigeo(DTOImpuestoUBIGEO): Salida"); 
            return dtos;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /** Métodos privados **/
    private Hashtable cargarAtributosTraducibles(String entidad) throws MareException {
         UtilidadesLog.info("DAOMAEproductos.cargarAtributosTraducibles(entidad): Entrada"); 
        StringBuffer query = new StringBuffer();
        Hashtable atributos = new Hashtable();
        RecordSet rs;

        query.append("SELECT des_atri, ");
        query.append("num_atri ");
        query.append("FROM gen_atrib_tradu ");
        query.append(UtilidadesBD.armarSQLWhere(new String[] { "NOM_ENTI" }, new Object[] {
                    entidad
                }, new boolean[] { false }));

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException("Error al obtener atributos traducibles", e);
        }

        if (!(rs == null)) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                atributos.put((String) rs.getValueAt(i, 0), (BigDecimal) rs.getValueAt(i, 1));
            }
        }
        
        UtilidadesLog.info("DAOMAEproductos.cargarAtributosTraducibles(entidad): Salida"); 

        return atributos;
    }

    private RecordSet getCodigoDescripcionTraducible(String entidad, Integer atributo, Long idioma, String[] lineasDinamicas) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.getCodigoDescripcionTraducible(entidad, atributo, idioma, lineasDinamicas): Entrada"); 
        RecordSet rs;

        StringBuffer query = new StringBuffer();
        StringBuffer query2 = new StringBuffer();

        String entidadInter = (String) entidades.get("Internacionalizacion");

        //String entidadInter = "GEN_I18N_SICC";
        query.append("SELECT val_oid ");
        query.append(",val_i18n ");
        query.append(agregarCampoFK(entidad));
        query.append("FROM " + entidadInter + " ");
        query.append(armarJoin(entidadInter, entidad));
        query.append(UtilidadesBD.armarSQLWhere(new String[] {
                    "ATTR_ENTI", "ATTR_NUM_ATRI", "IDIO_OID_IDIO"
                }, new Object[] { entidad, atributo, idioma }, new boolean[] {
                    false, false, false
                }));

        /*        query.append(UtilidadesBD.armarSQLWhere(
                        new String[] { "ATTR_ENTI", "ATTR_NUM_ATRI" },
                        new Object[] { entidad, atributo },
                        new boolean[] { false, false, false }));  */
        query.append(UtilidadesBD.armarSQLWhereDinamico(lineasDinamicas, " "));

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(UtilidadesI18N.armarSQLPatronI18n(query, idioma, "ORDER BY val_i18n "));
        } catch (MareException me) {
            getBelcorpService().log.info("Error en getCodigoDescripcionTraducible");
            throw me;
        } catch (Exception e) {
            getBelcorpService().log.info("Error en getCodigoDescripcionTraducible");
            throw new MareException("Error al obtener codigo Descripcion traducibles", e);
        }

        if (rs == null) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("DAOMAEproductos.getCodigoDescripcionTraducible(entidad, atributo, idioma, lineasDinamicas): Salida"); 

        return rs;
    }

    private String armarJoin(String entidadInter, String tabla2) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.armarJoin(entidadInter, tabla2): Entrada"); 
        StringBuffer join = new StringBuffer();
        Connection conn = null;

        try {
            conn = getBelcorpService().dbService.getConnection();

            DatabaseMetaData metaData = conn.getMetaData();

            /*
             * Todas estas tablas tienen como pl un solo campo, sino no pueden
             * ser internacionalizables
             */
            ResultSet columnasPKTabla2 = metaData.getPrimaryKeys(null, null, tabla2.toUpperCase());

            columnasPKTabla2.next();

            join.append(" INNER JOIN " + tabla2 + " ON ");
            join.append(" VAL_OID= " + tabla2 + "." + columnasPKTabla2.getString("COLUMN_NAME"));

            conn.close();
        } catch (SQLException e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }

            throw new MareException();
        } catch (Exception e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }

            throw new MareException();
        }

        join.append(" ");
        UtilidadesLog.debug(join);
        UtilidadesLog.info("DAOMAEproductos.armarJoin(entidadInter, tabla2): Salida"); 
       
        return join.toString();
    }

    private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }

    private String agregarCampoFK(String entidad) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.agregarCampoFK(entidad): Entrada"); 
        StringBuffer join = new StringBuffer();
        Connection conn = null;

        try {
            conn = getBelcorpService().dbService.getConnection();

            DatabaseMetaData metaData = conn.getMetaData();

            /*
             * Todas estas tablas tienen como pl un solo campo, sino no pueden
             * ser internacionalizables
             */
            ResultSet columnasFK = metaData.getImportedKeys(null, null, entidad.toUpperCase());

            while (columnasFK.next()) {
                join.append(", " + entidad + "." + columnasFK.getString("FKCOLUMN_NAME") + " ");
            }

            conn.close();
        } catch (SQLException e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }

            throw new MareException();
        } catch (Exception e) {
            try {
                conn.close();
            } catch (SQLException sqle) {
            }

            throw new MareException();
        }

        join.append(" ");
        UtilidadesLog.debug(join);
        UtilidadesLog.info("DAOMAEproductos.agregarCampoFK(entidad): Salida"); 
        return join.toString();
    }

    public Long validarCodigoProducto(String codigoSAP, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.validarCodigoProducto(codigoSAP, oidPais): Entrada"); 
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" select m.OID_PROD ");
            buf.append(" from MAE_PRODU m ");
            buf.append(" where m.COD_SAP = '" + codigoSAP + "' ");
            buf.append(" and m.PAIS_OID_PAIS = " + oidPais.toString());

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long nReturnValue = null;

        if (!respuesta.esVacio()) {
            BigDecimal d = (BigDecimal) respuesta.getValueAt(0, 0);
            nReturnValue = new Long(d.longValue());
            UtilidadesLog.debug("el valor a retornar es " + nReturnValue.toString());
        }
        
        UtilidadesLog.info("DAOMAEproductos.validarCodigoProducto(codigoSAP, oidPais): Salida"); 

        return nReturnValue;
    }

    public DTOConsultaImpuestoUBIGEO consultarImpuestoUbigeo(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.consultarImpuestoUbigeo(DTOOID): Entrada"); 
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;
        DTOConsultaImpuestoUBIGEO consImpu = new DTOConsultaImpuestoUBIGEO();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /*Vector param = new Vector();

            param.addElement(dto.getOid());
            param.addElement(dto.getOid());
            param.addElement(dto.getOid());

            buf.append(
                "select p.COD_SAP, i.TAIM_OID_TASA_IMPU, i.VEPO_OID_VALO_ESTR_GEOP, VAL_I18N val_impu_i18n ");
            buf.append("from MAE_IMPUE_UBIGE i, MAE_PRODU p, GEN_I18N_SICC ");
            buf.append("where i.PROD_OID_PROD = p.OID_PROD ");
            buf.append("and i.OID_IMPU_UBIG = ? ");
            buf.append("and i.TAIM_OID_TASA_IMPU = VAL_OID ");
            buf.append("and ATTR_ENTI = 'PED_TASA_IMPUE' ");
            buf.append("and ATTR_NUM_ATRI = 1 ");*/
            buf.append(" SELECT m.cod_sap, i4.val_i18n tasa, a.TAIM_OID_TASA_IMPU, i1.val_i18n canal, i2.val_i18n acceso, ");
            buf.append(" i3.val_i18n subacceso ");
            buf.append(" FROM mae_impue_ubige a, seg_subac b, seg_acces c, seg_canal d, ");
            buf.append(" mae_produ m, v_gen_i18n_sicc i1, v_gen_i18n_sicc i2, v_gen_i18n_sicc i3,");
            buf.append(" v_gen_i18n_sicc i4 ");
            buf.append(" WHERE a.sbac_oid_sbac = b.oid_sbac ");
            buf.append(" AND b.acce_oid_acce = c.oid_acce ");
            buf.append(" AND c.cana_oid_cana = d.oid_cana ");
            buf.append(" AND m.oid_prod = a.prod_oid_prod ");
            buf.append(" AND i1.attr_enti = 'SEG_CANAL' ");
            buf.append(" AND i1.attr_num_atri = 1 ");
            buf.append(" AND i1.idio_oid_idio = " + dto.getOidIdioma());
            buf.append(" AND i1.val_oid = c.cana_oid_cana ");
            buf.append(" AND i2.attr_enti = 'SEG_ACCES' ");
            buf.append(" AND i2.attr_num_atri = 1 ");
            buf.append(" AND i2.idio_oid_idio = " + dto.getOidIdioma());
            buf.append(" AND i2.val_oid = c.oid_acce ");
            buf.append(" AND i3.attr_enti = 'SEG_SUBAC' ");
            buf.append(" AND i3.attr_num_atri = 1 ");
            buf.append(" AND i3.idio_oid_idio = " + dto.getOidIdioma());
            buf.append(" AND i3.val_oid = b.oid_sbac ");
            buf.append(" AND i4.attr_enti (+) = 'PED_TASA_IMPUE' ");
            buf.append(" AND i4.attr_num_atri (+) = 1 ");
            buf.append(" AND i4.idio_oid_idio (+) = " + dto.getOidIdioma());
            buf.append(" AND i4.val_oid (+)= a.taim_oid_tasa_impu ");
            buf.append(" AND a.oid_impu_ubig = " + dto.getOid());
            

           respuesta = getBelcorpService().dbService.executeStaticQuery(buf.toString());
           UtilidadesLog.debug("consultarImpuestoUbigeo: query : " +buf.toString()); 

            //respuesta = bs.dbService.executePreparedQuery(UtilidadesI18N.armarSQLPatronI18n(
            //          buf, dto.getOidIdioma(), "order by COD_SAP "), param);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            // Construye el dto de salida       
            // Código SAP
            consImpu.setProducto((String) respuesta.getValueAt(0, 0));
            consImpu.setImpuesto((String) respuesta.getValueAt(0, 1));

            // Taza Impuesto
            if ((respuesta.getValueAt(0, 2) != null) && !(respuesta.getValueAt(0, 2).equals(""))) {
                BigDecimal d1 = (BigDecimal) respuesta.getValueAt(0, 2);
                Long oidTasaImpu = new Long(d1.longValue());
                consImpu.setOidImpuesto(oidTasaImpu);
            }

            consImpu.setCanal((String) respuesta.getValueAt(0, 3));
            consImpu.setAcceso((String) respuesta.getValueAt(0, 4));
            consImpu.setSubacceso((String) respuesta.getValueAt(0, 5));
        }
        
        UtilidadesLog.info("DAOMAEproductos.consultarImpuestoUbigeo(DTOOID): Salida"); 

        return consImpu;
    }

    /*Arma el where del dto recibido*/
    private String armarWhere(DTOImpuestoUBIGEO dtoImpuestoUG) {
        UtilidadesLog.info("DAOMAEproductos.armarWhere(DTOImpuestoUBIGEO): Entrada"); 
        StringBuffer query = new StringBuffer();
        String[] camposWhere = new String[] {
            "SBAC_OID_SBAC", "TAIM_OID_TASA_IMPU"
        };
        Object[] valoresWhere = new Object[] {
            dtoImpuestoUG.getSubacceso(), dtoImpuestoUG.getTasaImpuesto(),
        };
        boolean[] operadores = new boolean[] { false, false };

        /*
         * Armamos where de los campos not null
         */
        query.append(UtilidadesBD.armarSQLWhere(camposWhere, valoresWhere, operadores));

        UtilidadesLog.debug("query: " + query);
        UtilidadesLog.info("DAOMAEproductos.armarWhere(DTOImpuestoUBIGEO): Salida"); 

        return query.toString(); //deberia retornar el string                   
    }

    /** Realiza el acceso a la tabla de Maestro de Productos para obtener Kit de productos por criterios
       * @param DTOBusquedaKit
            * @throws MareException
       * @return DTOSalida
       */
    public DTOSalida buscarKitsPorCriterios(DTOBusquedaKit criterios) throws MareException {
        //       UtilidadesLog.info("DAOMAEProductos.java - buscarProductosPorCriterios()");
        UtilidadesLog.info("DAOMAEproductos.buscarKitsPorCriterios(DTOBusquedaKit): Entrada"); 
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" M.OID_PROD AS OID, ");
        query.append(" M.COD_SAP, ");
        query.append(" M.CODI_ANTI, ");
        query.append(" NVL(G.VAL_I18N,' ') AS VAL_I18N,");
        query.append(" M.DES_CORT ");
        query.append(" FROM MAE_PRODU M, V_GEN_I18N_SICC G ");

        //Además el campo IND_KIT debe ser un 1, y PAIS_OID_PAIS debe coincidir con el pais del dto. 
        //    query.append(armarJoin(entidadInter,(String)entidades.get("Marca"));
        query.append(UtilidadesBD.armarSQLWhere(new String[] {
                    "M.PAIS_OID_PAIS", "M.IND_KIT"
                }, new Object[] { criterios.getOidPais(), "1" }, new boolean[] {
                    false, false
                }));

        if (criterios.getCodAntiguo() != null) {
            query.append(" AND M.CODI_ANTI LIKE '" + criterios.getCodAntiguo() + "' ");
        }

        if (criterios.getDescCorta() != null) {
            query.append(" AND M.DES_CORT LIKE '" + criterios.getDescCorta() + "' ");
        }

        if (criterios.getCodSAP() != null) {
            query.append(" AND M.COD_SAP LIKE '" + criterios.getCodSAP() + "' ");
        }

        if (criterios.getDescSAP() != null) {
            String entidadInter = (String) entidades.get("Internacionalizacion");

            query.append(" AND G.VAL_I18N LIKE '" + criterios.getDescSAP() + "' ");
        }
        
        /* BELC300007133 - gPineda cdos 15/08/06
         * El atributo i18n no es obligatorio, se cambia el inner join por un left join. */
        query.append(" AND G.IDIO_OID_IDIO(+) = " + criterios.getOidIdioma());
        query.append(" AND G.VAL_OID(+) = M.OID_PROD ");
        query.append(" AND G.ATTR_ENTI(+) = 'MAE_PRODU' ");
        query.append(" AND g.attr_num_atri(+) = 1 ");
        query.append(" ORDER BY M.COD_SAP");

        //PAGINACION
        String queryFinal = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), criterios);

        RecordSet rs;

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(queryFinal);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs == null) || rs.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSal = new DTOSalida();
        dtoSal.setResultado(rs);
        UtilidadesLog.info("DAOMAEproductos.buscarKitsPorCriterios(DTOBusquedaKit): Salida"); 

        return dtoSal;
    }

    /** Realiza el acceso a la tabla de Maestro de Productos para obtener datos y así llenar un DTOConsultarKit
    * @param DTOOID
    * @throws MareException
    * @return DTOConsultaKit
    */
    public DTOConsultaKit consultarKit(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.consultarKit(DTOOID): Entrada"); 
        DTOConsultaKit dtoKit = new DTOConsultaKit();

        String codigoError;
        RecordSet rs;
        StringBuffer query = new StringBuffer();

        query.append("SELECT ");

        query.append("MPRO.COD_SAP, ");

        query.append("KITPRO.NUM_UNID ");

        query.append("FROM ");

        query.append("MAE_KIT_PRODU ");

        query.append("KITPRO, ");

        query.append("MAE_PRODU ");

        query.append("MPRO ");

        query.append("WHERE ");

        query.append("KITPRO.PROD_OID_PROD_KIT = " + dto.getOid());

        query.append(" AND ");

        query.append("KITPRO.PROD_OID_PROD = ");

        query.append("MPRO.OID_PROD");

        //realizo query sencillo para cargar el recordset en productos
        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        //armo query grande
        query.setLength(0);

        query.append("SELECT ");

        query.append("pr.*, ");

        query.append("iUnidadNegocio.VAL_I18N as unidadNegocio, ");

        query.append("iNegocio.VAL_I18N as negocio, ");

        query.append("iGenerico.VAL_I18N as generico, ");

        query.append("iSuperGenerico.VAL_I18N as supergenerico, ");

        query.append("iLineaProducto.VAL_I18N as lineaproducto, ");

        query.append("iUnMedidaDim.VAL_I18N as unidadmedidadimension, ");

        query.append("iUnMedidaVol.VAL_I18N as unidadmedidavolumen, ");

        query.append("iUnMedidaPeso.VAL_I18N as unidadmedidapeso, ");

        query.append("iEstatus.VAL_I18N as estatus, ");

        query.append("iSap.VAL_I18N  as DESC_SAP, ");

        query.append("periodoInicio.COD_PERI as PeridioInicio, ");

        query.append("periodoFin.COD_PERI as PeridioFin, ");

        query.append("iCanal.VAL_I18N as Canal, ");

        query.append("smarca.OID_MARC as marca ");

        query.append("FROM MAE_PRODU pr, ");

        query.append("SEG_MARCA smarca, ");

        query.append("V_GEN_I18N_SICC iUnidadNegocio, ");

        query.append("V_GEN_I18N_SICC iNegocio, ");

        query.append("V_GEN_I18N_SICC iGenerico, ");

        query.append("V_GEN_I18N_SICC iSuperGenerico, ");

        query.append("V_GEN_I18N_SICC iLineaProducto, ");

        query.append("V_GEN_I18N_SICC iUnMedidaDim, ");

        query.append("V_GEN_I18N_SICC iUnMedidaVol, ");

        query.append("V_GEN_I18N_SICC iUnMedidaPeso, ");

        query.append("V_GEN_I18N_SICC iEstatus, ");

        query.append("V_GEN_I18N_SICC iSap, ");

        query.append("CRA_PERIO perInicio, ");

        query.append("SEG_PERIO_CORPO periodoInicio, ");

        query.append("CRA_PERIO perFin, ");

        query.append("SEG_PERIO_CORPO periodoFin, ");

        query.append("V_GEN_I18N_SICC iCanal ");

        query.append("WHERE ");

        query.append("pr.OID_PROD = " + dto.getOid());

        query.append(" AND iUnidadNegocio.ATTR_ENTI  =  'MAE_UNIDA_NEGOC' ");

        query.append(" AND iUnidadNegocio.ATTR_NUM_ATRI  =  1 ");

        query.append(" AND iUnidadNegocio.VAL_OID  =  pr.UNEG_OID_UNID_NEGO ");

        query.append(" AND iUnidadNegocio.IDIO_OID_IDIO  =  '1' ");

        query.append(" AND iNegocio.ATTR_ENTI  =  'MAE_NEGOC' ");

        query.append(" AND iNegocio.ATTR_NUM_ATRI  =  1 ");

        query.append(" AND iNegocio.VAL_OID  =  pr.NEGO_OID_NEGO ");

        query.append(" AND iNegocio.IDIO_OID_IDIO = '1' ");

        query.append(" AND iGenerico.ATTR_ENTI = 'MAE_GENER' ");

        query.append(" AND iGenerico.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iGenerico.VAL_OID = pr.GENE_OID_GENE ");

        query.append(" AND iGenerico.IDIO_OID_IDIO = '1' ");

        query.append(" AND iSuperGenerico.ATTR_ENTI = 'MAE_SUPER_GENER' ");

        query.append(" AND iSuperGenerico.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iSuperGenerico.VAL_OID = pr.SGEN_OID_SUPE_GENE ");

        query.append(" AND iSuperGenerico.IDIO_OID_IDIO = '1' ");

        query.append(" AND iLineaProducto.ATTR_ENTI = 'MAE_LINEA_PRODU' ");

        query.append(" AND iLineaProducto.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iLineaProducto.VAL_OID = pr.LIPR_OID_LINE_PROD ");

        query.append(" AND iLineaProducto.IDIO_OID_IDIO = '1' ");

        query.append(" AND iUnMedidaDim.ATTR_ENTI = 'MAE_UNIDA_MEDID' ");

        query.append(" AND iUnMedidaDim.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iUnMedidaDim.VAL_OID = pr.UNMD_OID_UNID_MEDI_DIME ");

        query.append(" AND iUnMedidaDim.IDIO_OID_IDIO = '1' ");

        query.append(" AND iUnMedidaVol.ATTR_ENTI = 'MAE_UNIDA_MEDID' ");

        query.append(" AND iUnMedidaVol.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iUnMedidaVol.VAL_OID = pr.UNMD_OID_UNID_MEDI ");

        query.append(" AND iUnMedidaVol.IDIO_OID_IDIO = '1' ");

        query.append(" AND iUnMedidaPeso.ATTR_ENTI = 'MAE_UNIDA_MEDID' ");

        query.append(" AND iUnMedidaPeso.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iUnMedidaPeso.VAL_OID = pr.UNMD_OID_UNID_MEDI_PESO ");

        query.append(" AND iUnMedidaPeso.IDIO_OID_IDIO = '1' ");

        query.append(" AND iEstatus.ATTR_ENTI = 'MAE_ESTAT_PRODU' ");

        query.append(" AND iEstatus.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iEstatus.VAL_OID = pr.MEUD_OID_ESTA_PROD ");

        query.append(" AND iEstatus.IDIO_OID_IDIO = '1' ");

        query.append(" AND iSap.ATTR_ENTI = 'MAE_PRODU' ");

        query.append(" AND iSap.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iSap.VAL_OID = pr.OID_PROD ");

        query.append(" AND iSap.IDIO_OID_IDIO = '1' ");

        query.append(" AND perInicio.OID_PERI = pr.PERD_OID_PERI_INIC ");

        query.append(" AND perInicio.PERI_OID_PERI = periodoInicio.OID_PERI ");

        query.append(" AND perFin.OID_PERI = pr.PERD_OID_PERI_INIC ");

        query.append(" AND perFin.PERI_OID_PERI = periodoFin.OID_PERI ");

        query.append(" AND smarca.OID_MARC = perinicio.MARC_OID_MARC ");

        query.append(" AND iCanal.ATTR_ENTI = 'SEG_CANAL' ");

        query.append(" AND iCanal.ATTR_NUM_ATRI = 1 ");

        query.append(" AND iCanal.VAL_OID = perInicio.CANA_OID_CANA ");

        query.append(" AND iCanal.IDIO_OID_IDIO = '1'");

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());

            dtoKit.setAlto((rs.getValueAt(0, "VAL_DIME_ALTO") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_DIME_ALTO")).doubleValue()) : null);

            dtoKit.setAncho((rs.getValueAt(0, "VAL_DIME_ANCH") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_DIME_ANCH")).doubleValue()) : null);
            ;

            dtoKit.setLargo((rs.getValueAt(0, "VAL_DIME_LARG") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_DIME_LARG")).doubleValue()) : null);
            ;

            dtoKit.setAtributo1((rs.getValueAt(0, "VAL_ATRI_1")).toString());

            dtoKit.setAtributo2((rs.getValueAt(0, "VAL_ATRI_2")).toString());

            dtoKit.setAtributo3((rs.getValueAt(0, "VAL_ATRI_3")).toString());

            dtoKit.setCanal((rs.getValueAt(0, "CANAL")).toString());

            dtoKit.setCodAntiguo((rs.getValueAt(0, "CODI_ANTI")).toString());

            dtoKit.setCodImpuesto((rs.getValueAt(0, "COD_IMPU")).toString());

            dtoKit.setCodPagoFraccionado((rs.getValueAt(0, "COS_PAGP_FRAC")).toString());

            dtoKit.setCodSAP((rs.getValueAt(0, "COD_SAP")).toString());

            dtoKit.setCosteEstandar((rs.getValueAt(0, "VAL_COST_ESTD") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_COST_ESTD")).doubleValue()) : null);

            dtoKit.setDescCorta((rs.getValueAt(0, "DES_CORT")).toString());

            dtoKit.setDescSAP((rs.getValueAt(0, "DESC_SAP")).toString());

            // dtoKit.setEsSituacionActivo(new Boolean ((rs.getValueAt(0,"COD_IND_SITU")).toString()));
            if (rs.getValueAt(0, "COD_IND_SITU") != null) {
                Boolean valor = new Boolean(((String) rs.getValueAt(0, "COD_IND_SITU")).equals("1"));
                dtoKit.setEsSituacionActivo(valor);
            }

            // dtoKit.setEstaDentroCaja(new Boolean ((rs.getValueAt(0,"COD_INT_DENT_CAJA")).toString()));
            if (rs.getValueAt(0, "COD_INT_DENT_CAJA") != null) {
                Boolean valor = new Boolean(((String) rs.getValueAt(0, "COD_INT_DENT_CAJA")).equals("1"));
                dtoKit.setEstaDentroCaja(valor);
            }

            dtoKit.setEstatus((rs.getValueAt(0, "estatus")).toString());

            dtoKit.setGenerico((rs.getValueAt(0, "GENE_OID_GENE")).toString());

            // dtoKit.setIndLote(new Boolean ((rs.getValueAt(0,"IND_LOTE")).toString()));
            if (rs.getValueAt(0, "IND_LOTE") != null) {
                Boolean valor = new Boolean(((String) rs.getValueAt(0, "IND_LOTE")).equals("1"));
                dtoKit.setIndLote(valor);
            }

            dtoKit.setJerarquia1((rs.getValueAt(0, "VAL_JERA_1")).toString());

            dtoKit.setJerarquia2((rs.getValueAt(0, "VAL_JERA_2")).toString());

            dtoKit.setJerarquia3((rs.getValueAt(0, "VAL_JERA_3")).toString());

            dtoKit.setLineaProducto((rs.getValueAt(0, "LIPR_OID_LINE_PROD")).toString());

            dtoKit.setMarca((rs.getValueAt(0, "MARCA")).toString());

            dtoKit.setNegocio((rs.getValueAt(0, "NEGO_OID_NEGO")).toString());

            dtoKit.setPeriodoFin((rs.getValueAt(0, "PERD_OID_PERI_FIN")).toString());

            dtoKit.setPeriodoInicio((rs.getValueAt(0, "PERD_OID_PERI_INIC")).toString());

            dtoKit.setPeso((rs.getValueAt(0, "VAL_PESO") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_PESO")).doubleValue()) : null);
            ;

            dtoKit.setPorcentajeUnidades((rs.getValueAt(0, "PCT_UNID") != null) ? new Integer(((BigDecimal) rs.getValueAt(0, "PCT_UNID")).intValue()) : null);
            ;

            dtoKit.setPrecioCatalogo((rs.getValueAt(0, "VAL_PREC_CATA") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "PCT_UNID")).doubleValue()) : null);
            ;

            dtoKit.setPrecioContable((rs.getValueAt(0, "VAL_PREC_CONT") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_PREC_CONT")).doubleValue()) : null);
            ;

            dtoKit.setPrecioPosicionamiento((rs.getValueAt(0, "VAL_PREC_POSI") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_PREC_POSI")).doubleValue()) : null);
            ;

            dtoKit.setProductoServicio((rs.getValueAt(0, "IND_PROD_SERV")).toString());

            dtoKit.setSupergenerico((rs.getValueAt(0, "SGEN_OID_SUPE_GENE")).toString());

            dtoKit.setUnidDentroPedido((rs.getValueAt(0, "NUM_UNID_DENT_PEDI") != null) ? new Integer(((BigDecimal) rs.getValueAt(0, "NUM_UNID_DENT_PEDI")).intValue()) : null);
            ;

            dtoKit.setUnidMedidaDimensiones((rs.getValueAt(0, "UNMD_OID_UNID_MEDI_DIME")).toString());

            dtoKit.setUnidMedidaPeso((rs.getValueAt(0, "UNMD_OID_UNID_MEDI_PESO")).toString());

            dtoKit.setUnidMedidaVolumen((rs.getValueAt(0, "UNMD_OID_UNID_MEDI")).toString());

            dtoKit.setUnidPorCaja((rs.getValueAt(0, "NUM_UNID_CAJA")).toString());

            dtoKit.setUnidadNegocio((rs.getValueAt(0, "NEGO_OID_NEGO")).toString());

            dtoKit.setVolumen((rs.getValueAt(0, "VAL_VOLU") != null) ? new Double(((BigDecimal) rs.getValueAt(0, "VAL_VOLU")).doubleValue()) : null);
            ;
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOMAEproductos.consultarKit(DTOOID): Salida"); 

        return dtoKit;
    }

    public RecordSet obtenerProductosPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.consuobtenerProductosPaisltarKit(DTOBelcorp): Entrada"); 
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT p.oid_prod OID, p.cod_sap || ' ' || i.val_i18n DESCRIPCION ");
            buf.append("   FROM mae_produ p, v_gen_i18n_sicc i ");
            buf.append("  WHERE pais_oid_pais = " + dto.getOidPais());
            buf.append("    AND i.attr_enti = 'MAE_PRODU' ");
            buf.append("    AND i.attr_num_atri = 1 ");
            buf.append("    AND i.idio_oid_idio = 1 ");
            buf.append("    AND i.val_oid = p.oid_prod ");
            buf.append("  ORDER BY 2 ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEproductos.consuobtenerProductosPaisltarKit(DTOBelcorp): Salida"); 
        return respuesta;
    }

    public DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.buscarInformacionProductos(DTOBuscarInformacionProductos): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" SELECT A.oid_prod as oid, ");
        query.append(" A.cod_sap as codSAP, ");
        query.append(" A.codi_anti as codAntiguo, ");
        query.append(" A.des_cort as descCorta, ");
        query.append(" B.val_i18n as descSAP, ");
        query.append(" DECODE(A.ind_prod_serv, '" + ConstantesCMN.VAL_FALSE + "', '" + ConstantesMAE.TXT_PRODUCTO + "', '" + ConstantesCMN.VAL_TRUE + "', '" + ConstantesMAE.TXT_SERVICIO + "', '" + ConstantesMAE.TXT_VACIO + "') as productoServicio, ");
        /*
        query.append(" C.val_i18n as marcaProducto, ");
        */
        /*ADD*/
        query.append(" P.des_marc_prod as marcaProducto, ");
        /*ADD*/
        query.append(" D.val_i18n as unidadNegocio, ");
        query.append(" E.val_i18n as negocio, ");
        query.append(" F.val_i18n as linea, ");
        query.append(" DECODE(A.cod_ind_situ, '" + ConstantesMAE.PRODUCTO_ACTIVO + "', '" + ConstantesMAE.TXT_PRODUCTO_ACTIVO + "', '" + ConstantesMAE.PRODUCTO_INACTIVO + "', '" + ConstantesMAE.TXT_PRODUCTO_INACTIVO + "','" + ConstantesMAE.TXT_VACIO + "' ) as situacion ");

        query.append(" FROM mae_produ A, ");
        query.append(" v_gen_i18n_sicc B, ");
        /*        
        query.append(" v_gen_i18n_sicc C, ");
        */
        /*ADD*/
        query.append(" seg_marca_produ P, ");
        /*ADD*/ 
        query.append(" v_gen_i18n_sicc D, ");
        query.append(" v_gen_i18n_sicc E, ");
        query.append(" v_gen_i18n_sicc F ");

        query.append(" WHERE A.oid_prod > " + dto.getIndicadorSituacion() + " AND ");
        query.append(" A.pais_oid_pais = " + dto.getOidPais() + " AND ");
        query.append(" B.attr_enti = 'MAE_PRODU' AND ");
        query.append(" B.attr_num_atri = 1 AND ");
        query.append(" B.idio_oid_idio = " + dto.getOidIdioma() + " AND ");
        query.append(" B.val_oid = A.oid_prod AND ");
        /*
        query.append(" C.attr_enti (+) = 'SEG_MARCA_PRODU' AND ");
        query.append(" C.attr_num_atri (+) = 1 AND ");
        query.append(" C.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" C.val_oid (+) = A.mapr_oid_marc_prod AND ");
        */
        /*ADD*/        
        query.append(" P.oid_marc_prod = A.mapr_oid_marc_prod AND ");
        /*ADD*/
        query.append(" D.attr_enti (+) = 'MAE_UNIDA_NEGOC' AND ");
        query.append(" D.attr_num_atri (+) = 1 AND ");
        query.append(" D.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" D.val_oid (+) = A.uneg_oid_unid_nego AND ");
        query.append(" E.attr_enti (+) = 'MAE_NEGOC' AND ");
        query.append(" E.attr_num_atri (+) = 1 AND ");
        query.append(" E.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" E.val_oid (+) = A.nego_oid_nego AND ");
        query.append(" F.attr_enti (+) = 'MAE_LINEA_PRODU' AND ");
        query.append(" F.attr_num_atri (+) = 1 AND ");
        query.append(" F.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" F.val_oid (+) = A.lipr_oid_line_prod ");

        if (dto.getCodSAP() != null) {
            query.append(" AND A.cod_sap LIKE '" + dto.getCodSAP() + "'");
        }

        if (dto.getCodAntiguo() != null) {
            query.append(" AND A.codi_anti LIKE '" + dto.getCodAntiguo() + "'");
        }

        if (dto.getDescCorta() != null) {
            query.append(" AND A.des_cort LIKE '" + dto.getDescCorta() + "'");
        }

        if (dto.getDescSAP() != null) {
            query.append(" AND B.val_i18n LIKE '" + dto.getDescSAP() + "'");
        }

        if (dto.getProductoServicio() != null) {
            query.append(" AND A.ind_prod_serv = " + dto.getProductoServicio());
        }

        if (dto.getMarcaProducto() != null) {
            query.append(" AND A.mapr_oid_marc_prod = " + dto.getMarcaProducto());
        }

        if (dto.getUnidadesNegocio() != null) {
            query.append(" AND A.uneg_oid_unid_nego = " + dto.getUnidadesNegocio());
        }

        if (dto.getNegocio() != null) {
            query.append(" AND A.nego_oid_nego = " + dto.getNegocio());
        }

        if (dto.getLinea() != null) {
            query.append(" AND A.lipr_oid_line_prod = " + dto.getLinea());
        }

        if (dto.getSituacion() != null) {
            query.append(" AND A.cod_ind_situ LIKE '" + dto.getSituacion() + "'");
        }

        if (dto.getEstatusProducto() != null) {
            query.append(" AND A.meud_oid_esta_prod = " + dto.getEstatusProducto());
        }

        if (dto.getPrecioCatalogo() != null) {
            query.append(" AND A.val_prec_cata = " + dto.getPrecioCatalogo());
        }

        if (dto.getPrecioContable() != null) {
            query.append(" AND A.val_prec_cont = " + dto.getPrecioContable());
        }

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEproductos.buscarInformacionProductos(DTOBuscarInformacionProductos): Salida"); 

        return dtoSalida;
    }

    public DTOSalida detalleInformacionProducto(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.detalleInformacionProducto(DTOOID): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" SELECT A.cod_sap as codSAP, ");
        query.append(" A.codi_anti as codAntiguo, ");
        query.append(" A.des_cort as descCorta, ");
        query.append(" B.val_i18n as descSAP, ");
        query.append(" DECODE(A.ind_prod_serv, '" + ConstantesCMN.VAL_FALSE + "', '" + ConstantesMAE.TXT_PRODUCTO + "', '" + ConstantesCMN.VAL_TRUE + "', '" + ConstantesMAE.TXT_SERVICIO + "', '" + ConstantesMAE.TXT_VACIO + "') as productoServicio, ");
        query.append(" C.val_i18n as marcaProducto, ");
        query.append(" D.val_i18n as unidadNegocio, ");
        query.append(" E.val_i18n as negocio, ");
        query.append(" F.val_i18n as linea, ");
        query.append(" DECODE(A.cod_ind_situ, '" + ConstantesMAE.PRODUCTO_ACTIVO + "', '" + ConstantesMAE.TXT_PRODUCTO_ACTIVO + "', '" + ConstantesMAE.PRODUCTO_INACTIVO + "', '" + ConstantesMAE.TXT_PRODUCTO_INACTIVO + "', '" + ConstantesMAE.TXT_VACIO + "') as situacion, ");
        query.append(" A.val_prec_cata as precioCatalogo, ");
        query.append(" A.val_prec_cont as precioContable, ");
        query.append(" G.val_i18n as estatusProducto, ");
        query.append(" DECODE(A.cod_ind_dent_caja, '" + ConstantesMAE.CAJA + "', '" + ConstantesMAE.TXT_CAJA + "', '" + ConstantesMAE.BOLSA + "', '" + ConstantesMAE.TXT_BOLSA + "', '" + ConstantesMAE.TXT_VACIO + "') as cajaBolsa, ");
        query.append(" H.cod_form_pago as codFormaPago, ");
        query.append(" A.cod_impu as codImpuesto, ");
        query.append(" I.val_i18n as generico, ");
        query.append(" J.val_i18n as supergenerico, ");
        query.append(" A.val_jera_1 as jerarquia1, ");
        query.append(" A.val_jera_2 as jerarquia2, ");
        query.append(" A.val_jera_3 as jerarquia3, ");
        query.append(" A.val_atri_1 as atributo1, ");
        query.append(" A.val_atri_2 as atributo2, ");
        query.append(" A.val_atri_3 as atributo3, ");
        query.append(" A.val_dime_alto as alto, ");
        query.append(" A.val_dime_anch as ancho, ");
        query.append(" A.val_dime_larg as largo, ");
        query.append(" K.val_i18n as unidadMedidaDimensiones, ");
        query.append(" A.val_volu as volumen, ");
        query.append(" A.val_peso as peso, ");
        query.append(" L.val_i18n as unidadMedidaPeso, ");
        query.append(" A.num_unid_dent_pedi as unidadesPedido, ");
        query.append(" A.num_unid_caja as unidadesCaja ");

        query.append(" FROM mae_produ A, ");
        query.append(" v_gen_i18n_sicc B, ");
        query.append(" v_gen_i18n_sicc C, ");
        query.append(" v_gen_i18n_sicc D, ");
        query.append(" v_gen_i18n_sicc E, ");
        query.append(" v_gen_i18n_sicc F, ");
        query.append(" v_gen_i18n_sicc G, ");
        query.append(" bel_forma_pago H, ");
        query.append(" v_gen_i18n_sicc I, ");
        query.append(" v_gen_i18n_sicc J, ");
        query.append(" v_gen_i18n_sicc K, ");
        query.append(" v_gen_i18n_sicc L ");

        query.append(" WHERE A.oid_prod = " + dto.getOid() + " AND ");
        query.append(" B.attr_enti = 'MAE_PRODU' AND ");
        query.append(" B.attr_num_atri = 1 AND ");
        query.append(" B.idio_oid_idio = " + dto.getOidIdioma() + " AND ");
        query.append(" B.val_oid = A.oid_prod AND ");
        query.append(" C.attr_enti (+) = 'SEG_MARCA_PRODU' AND ");
        query.append(" C.attr_num_atri (+) = 1 AND ");
        query.append(" C.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" C.val_oid (+) = A.mapr_oid_marc_prod AND ");
        query.append(" D.attr_enti (+) = 'MAE_UNIDA_NEGOC' AND ");
        query.append(" D.attr_num_atri (+) = 1 AND ");
        query.append(" D.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" D.val_oid (+) = A.uneg_oid_unid_nego AND ");
        query.append(" E.attr_enti (+) = 'MAE_NEGOC' AND ");
        query.append(" E.attr_num_atri (+) = 1 AND ");
        query.append(" E.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" E.val_oid (+) = A.nego_oid_nego AND ");
        query.append(" F.attr_enti (+) = 'MAE_LINEA_PRODU' AND ");
        query.append(" F.attr_num_atri (+) = 1 AND ");
        query.append(" F.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" F.val_oid (+) = A.lipr_oid_line_prod AND ");
        query.append(" G.attr_enti (+) = 'MAE_ESTAT_PRODU' AND ");
        query.append(" G.attr_num_atri (+) = 1 AND ");
        query.append(" G.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" G.val_oid (+) = A.meud_oid_esta_prod AND ");
        query.append(" H.oid_form_pago (+) = A.fopa_oid_form_pago AND ");
        query.append(" I.attr_enti (+) = 'MAE_GENER' AND ");
        query.append(" I.attr_num_atri (+) = 1 AND ");
        query.append(" I.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" I.val_oid (+) = A.gene_oid_gene AND ");
        query.append(" J.attr_enti (+) = 'MAE_SUPER_GENER' AND ");
        query.append(" J.attr_num_atri (+) = 1 AND ");
        query.append(" J.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" J.val_oid (+) = A.sgen_oid_supe_gene AND ");
        query.append(" K.attr_enti (+) = 'MAE_UNIDA_MEDID' AND ");
        query.append(" K.attr_num_atri (+) = 1 AND ");
        query.append(" K.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" K.val_oid (+) = A.unmd_oid_unid_medi_dime AND ");
        query.append(" L.attr_enti (+) = 'MAE_UNIDA_MEDID' AND ");
        query.append(" L.attr_num_atri (+) = 1 AND ");
        query.append(" L.idio_oid_idio (+) = " + dto.getOidIdioma() + " AND ");
        query.append(" L.val_oid (+) = A.unmd_oid_unid_medi_peso ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEproductos.detalleInformacionProducto(DTOOID): Salida"); 

        return dtoSalida;
    }

    public DTOSalida obtenerMarcaProducto(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.obtenerMarcaProducto(DTOBelcorp): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" select smp.OID_MARC_PROD, smp.DES_MARC_PROD ");
        query.append(" from seg_marca_produ smp ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMAEproductos.obtenerMarcaProducto(DTOBelcorp): Salida"); 

        return dtoSalida;
    }
    
    /**
     * @author pperanzola
     * @date 20/10/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * se crea según el modelo GCC-PRE-MAE-INT-001
     */
    public RecordSet obtenerProgramasFidelizacion (DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEproductos.obtenerProgramasFidelizacion (DTOBelcorp dto): Entrada"); 
        StringBuffer query = new StringBuffer();
        RecordSet rs;

        query.append(" select    OID_PROG_FIDE, DES_PROG_FIDE ");
        query.append(" from MAE_PROGR_FIDEL ");
        query.append(" where  PAIS_OID_PAIS =  " + dto.getOidPais());

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOMAEproductos.obtenerProgramasFidelizacion (DTOBelcorp dto): Salida"); 
        
        return rs;
    }
    
    public RecordSet obtenerDatosProductoFacturacion (Long oidProducto) throws MareException{
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;

        query.append("  select m.OID_PROD OID, m.COD_SAP CODIGO, m.COD_IND_DENT_CAJA INDICADOR from MAE_PRODU m ");
        query.append(" where m.OID_PROD = " + oidProducto);
        
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (rs == null || rs.esVacio()){
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        return rs;
    }


    /**
     * @author ciglesias
     * @date 13/10/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOProducto
     * @param DTOOID
     * 
     * CHANGELOG
     * ---------
     * Error MAE-001 - dmorello, 17/10/2008 - Se corrige obtencion del campo VAL_DIME_ANCH
     */
    public DTOProducto consultar(DTOOID dtoE) throws MareException{
    
        UtilidadesLog.info("DAOMAEProductos.consultar(DTOOID): Entrada"); 
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        buf.append(" SELECT * ");
        buf.append("   FROM mae_produ p, v_gen_i18n_sicc i ");
        buf.append("   WHERE p.oid_prod = '" + dtoE.getOid() + "'");
        buf.append("    AND i.attr_enti = 'MAE_PRODU' ");
        buf.append("    AND i.attr_num_atri = 1 ");
        buf.append("    AND i.idio_oid_idio = 1 ");
        buf.append("    AND i.val_oid = p.oid_prod ");
        buf.append("  ORDER BY 2 ");

        try {
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (FinderException fe) {
            String codigoError = ErroresDeNegocio.MANTENIMIENTO_MATERIALES_PROD_INEXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!respuesta.esVacio()) {
        
        DTOProducto dtoProd = new DTOProducto();

        Vector vecDesSap = new Vector();
        vecDesSap.add((String) respuesta.getValueAt(0,"VAL_I18N"));

        dtoProd.setDescSapI18n(vecDesSap);
        
        dtoProd.setOid(new Long(((BigDecimal) respuesta.getValueAt(0, "OID_PROD")).toString()));

        dtoProd.setCodSAP((String) respuesta.getValueAt(0,"COD_SAP"));
        dtoProd.setCodAntiguo((String) respuesta.getValueAt(0,"CODI_ANTI"));
        dtoProd.setDescCorta((String) respuesta.getValueAt(0,"DES_CORT"));
        dtoProd.setJerarquia1((String) respuesta.getValueAt(0,"VAL_JERA_1"));
        dtoProd.setJerarquia2((String) respuesta.getValueAt(0,"VAL_JERA_2"));
        dtoProd.setJerarquia3((String) respuesta.getValueAt(0,"VAL_JERA_3"));
        dtoProd.setAtributo1((String) respuesta.getValueAt(0,"VAL_ATRI_1"));
        dtoProd.setAtributo2((String) respuesta.getValueAt(0,"VAL_ATRI_2"));
        dtoProd.setAtributo3((String) respuesta.getValueAt(0,"VAL_ATRI_3"));
        dtoProd.setCodImpuesto((String) respuesta.getValueAt(0,"COD_IMPU"));
        dtoProd.setGrupoArticulos((String) respuesta.getValueAt(0,"VAL_GRUP_ARTI"));
        dtoProd.setCodigoUnicoVenta((String) respuesta.getValueAt(0,"COD_UNIC_VENT"));

        dtoProd.setAlto((BigDecimal) respuesta.getValueAt(0,"VAL_DIME_ALTO"));
        dtoProd.setLargo((BigDecimal) respuesta.getValueAt(0,"VAL_DIME_LARG"));
        dtoProd.setAncho((BigDecimal) respuesta.getValueAt(0,"VAL_DIME_ANCH"));
        dtoProd.setPeso((BigDecimal) respuesta.getValueAt(0,"VAL_PESO"));
        dtoProd.setVolumen((BigDecimal) respuesta.getValueAt(0,"VAL_VOLU"));
        dtoProd.setCosteEstandar((BigDecimal) respuesta.getValueAt(0,"VAL_COST_ESTD"));
        dtoProd.setPrecioPosicionamiento((BigDecimal) respuesta.getValueAt(0,"VAL_PREC_POSI"));
        dtoProd.setPrecioCatalogo((BigDecimal) respuesta.getValueAt(0,"VAL_PREC_CATA"));
        dtoProd.setPrecioContable((BigDecimal) respuesta.getValueAt(0,"VAL_PREC_CONT"));
        
        dtoProd.setUnidDentroPedido((respuesta.getValueAt(0, "NUM_UNID_DENT_PEDI") == null) ? null : new Integer(((BigDecimal) respuesta.getValueAt(0, "NUM_UNID_DENT_PEDI")).toString()));
        dtoProd.setUnidPorCaja((respuesta.getValueAt(0, "NUM_UNID_CAJA") == null) ? null : new Integer(((BigDecimal) respuesta.getValueAt(0, "NUM_UNID_CAJA")).toString()));
        dtoProd.setFormaPago((respuesta.getValueAt(0, "FOPA_OID_FORM_PAGO") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "FOPA_OID_FORM_PAGO")).toString()));
        dtoProd.setSupergenerico((respuesta.getValueAt(0, "SGEN_OID_SUPE_GENE") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "SGEN_OID_SUPE_GENE")).toString()));
        dtoProd.setGenerico((respuesta.getValueAt(0, "GENE_OID_GENE") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "GENE_OID_GENE")).toString()));
        dtoProd.setEstatus((respuesta.getValueAt(0, "MEUD_OID_ESTA_PROD") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "MEUD_OID_ESTA_PROD")).toString()));
        dtoProd.setUnidMedidaDimensiones((respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI_DIME") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI_DIME")).toString()));
        dtoProd.setLineaProducto((respuesta.getValueAt(0, "LIPR_OID_LINE_PROD") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "LIPR_OID_LINE_PROD")).toString()));
        dtoProd.setNegocio((respuesta.getValueAt(0, "NEGO_OID_NEGO") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "NEGO_OID_NEGO")).toString()));
        dtoProd.setUnidMedidaPeso((respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI_PESO") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI_PESO")).toString()));
        dtoProd.setUnidMedidaVolumen((respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "UNMD_OID_UNID_MEDI")).toString()));
        dtoProd.setOidMarca((respuesta.getValueAt(0, "MAPR_OID_MARC_PROD") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "MAPR_OID_MARC_PROD")).toString()));
        dtoProd.setUnidadNegocio((respuesta.getValueAt(0, "UNEG_OID_UNID_NEGO") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "UNEG_OID_UNID_NEGO")).toString()));
        dtoProd.setProgramaFidelizacion((respuesta.getValueAt(0, "PRFI_OID_PROG_FIDE") == null) ? null : new Long(((BigDecimal) respuesta.getValueAt(0, "PRFI_OID_PROG_FIDE")).toString())); 
        
        dtoProd.setIndLote((respuesta.getValueAt(0, "IND_LOTE") == null) ? null : ((((BigDecimal) respuesta.getValueAt(0, "IND_LOTE")).intValue() == 1) ? new Boolean(true) : new Boolean(false)));
        dtoProd.setProductoServicio((respuesta.getValueAt(0, "IND_PROD_SERV") == null) ? null : ((((BigDecimal) respuesta.getValueAt(0, "IND_PROD_SERV")).intValue() == 1) ? new Boolean(true) : new Boolean(false)));

        /*INICIO Situacion y Caja Bolsa*/
        String codIndSitu = (String) respuesta.getValueAt(0,"COD_IND_SITU");
        String indCajaBolsa = (String) respuesta.getValueAt(0,"COD_IND_DENT_CAJA");

        if ((codIndSitu != null) && (codIndSitu.length() > 0)) {
            dtoProd.setSituacion(new Character(codIndSitu.charAt(0)));
        }

        if ((indCajaBolsa != null) && (indCajaBolsa.length() > 0)) {
            dtoProd.setCajaBolsa(new Character(indCajaBolsa.charAt(0)));
        }
        /*FIN Situacion y Caja Bolsa*/
        UtilidadesLog.info("DTO de Salida " + dtoProd); 
        
        UtilidadesLog.info("DAOMAEProductos.consultar(DTOOID): Salida"); 
        return dtoProd;
        } else 
        {
            String codigoError = ErroresDeNegocio.MANTENIMIENTO_MATERIALES_PROD_INEXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
        }
    }
    /*
    private Integer toInteger(RecordSet lista, String campo)
    {
        UtilidadesLog.info("toInteger -- " + campo); 
        
        if (lista.getValueAt(0, campo) != null)
        {
            
        }
        (respuesta.getValueAt(0, "NUM_UNID_DENT_PEDI") == null) ? null : new Integer(((BigDecimal) respuesta.getValueAt(0, "NUM_UNID_DENT_PEDI")).toString())        
    }
    
    private Boolean toBoolean(RecordSet lista, String campo)
    {
                        esLote = ;
                        
(respuesta.getValueAt(0, "IND_LOTE") == null) ? null : (((BigDecimal) rs.getValueAt(0, "IND_LOTE")).intValue() == 1) ? new Boolean(true) : new Boolean(false))
    }
    
    */
    /**
     * @author enozigli
     * @date 24/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @return boolean
     * @param Long oidProducto
     * @description valida si existen ofertas con el mismo programa de fidelizacion
     *              que el producto original de MAE_PRODU para la/s campaña/s actual/es.
     */
    public boolean existenOfertasConProgFideParaProducto(Long oidProducto) throws MareException {
        UtilidadesLog.info("DAOMAEProductos.existenOfertasConProgFideParaProducto(Long oidProducto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        BelcorpService bs;
        boolean res = false;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT DET.OID_DETA_OFER RES, DET.VAL_TEXT_BREV DESCRIPCION ");
        query.append(" FROM PRE_OFERT OFE, PRE_OFERT_DETAL DET, PRE_MATRI_FACTU_CABEC CAB, CRA_PERIO PER, MAE_PRODU PRO ");
        query.append(" WHERE OFE.OID_OFER = DET.OFER_OID_OFER ");
        query.append(" AND CAB.OID_CABE = OFE.MFCA_OID_CABE ");
        query.append(" AND CAB.PERD_OID_PERI = PER.OID_PERI ");
        query.append(" AND PRO.OID_PROD = DET.PROD_OID_PROD ");
        query.append(" AND PRO.PRFI_OID_PROG_FIDE = DET.PRFI_OID_PROG_FIDE ");
        query.append(" AND PER.FEC_INIC <= SYSDATE ");
        query.append(" AND PER.FEC_FINA >= SYSDATE ");
        query.append(" AND DET.PROD_OID_PROD = "+oidProducto+" ");
                    
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }      
        
        if (!rs.esVacio() && rs.getValueAt(0,"RES") !=null) {          
            res = true;
        }
        
        UtilidadesLog.info("DAOMAEProductos.existenOfertasConProgFideParaProducto(Long oidProducto):Salida");
        return res;
    
  }    
}
