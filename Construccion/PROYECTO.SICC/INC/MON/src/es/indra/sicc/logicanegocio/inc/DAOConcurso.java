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
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.inc.DTOBuscar;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOBuscarCtaCtePtos;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.dtos.inc.DTOBuscarPlantillas;
import es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipante;
import es.indra.sicc.dtos.inc.DTOCursoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOCursosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTODespachoPremios;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOIncAmbitoGeografico;
import es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOMovimientoCtaCte;
import es.indra.sicc.dtos.inc.DTOMultinivel;
import es.indra.sicc.dtos.inc.DTOObtencionPuntos;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosGerentes;
import es.indra.sicc.dtos.inc.DTOPedidoPremiar;
import es.indra.sicc.dtos.inc.DTOProductoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOProductosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.dtos.inc.DTORequisitosPremiacion;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOVariablesVenta;
import es.indra.sicc.dtos.inc.DTOVariablesVentaProyectada;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

//import es.indra.sicc.dtos.inc.DTOBuscar;
//import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
public class DAOConcurso {

    public DAOConcurso() {
    }
    
    //Modificado por Cristian Valenzuela
    //Incidencia: BELC300023763
    //Fecha: 13/09/2006

    public RecordSet buscarListaPlantillas(DTOBuscarPlantillas DTOE)
            throws MareException {
        
        UtilidadesLog.info("DAOConcurso.buscarListaPlantillas(DTOBuscarPlantillas DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID,A.OID2,A.DESC1,A.DESC2 ");
        query.append(" from (select pp.PLC2_OID_PLAN_CONC,  ");
        query.append(" pp.OID_PAIS_PLAN  ");
        query.append(" from inc_pais_plant pp  ");
        query.append(" where pp.PAIS_OID_PAIS = " + DTOE.getOidPais() + ") paisPlant ");
        query.append(" right outer join( ");
        query.append(" SELECT  PC.OID_PLAN_CONC OID,  ");
        query.append(" PC.OID_PLAN_CONC OID2,  ");
        query.append(" G.VAL_I18N DESC1,  ");
        query.append(" G2.VAL_I18N DESC2  ");
        query.append(" FROM INC_PLANT_CONCU PC, ");
        query.append(" INC_BASE_CALCU BC, ");
        query.append(" V_GEN_I18N_SICC G,  ");
        query.append(" V_GEN_I18N_SICC G2  ");
        query.append(" WHERE PC.BCAL_OID_BASE_CALC = BC.OID_BASE_CALC (+) ");
        
        if ((DTOE != null) && (DTOE.getNroPlantilla() != null)) {
            query.append(" AND PC.OID_PLAN_CONC = " + DTOE.getNroPlantilla());
        }
        
        query.append(" AND PC.IND_ACTI = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND G.ATTR_ENTI = 'INC_PLANT_CONCU' ");
        query.append(" AND G.VAL_OID = PC.OID_PLAN_CONC ");
        query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        
        if ((DTOE != null) && (DTOE.getNombrePlantilla() != null)) {
            query.append(" AND G.VAL_I18N LIKE '%" + DTOE.getNombrePlantilla() + "%'");
        }
        
        query.append(" AND G2.ATTR_ENTI(+) = 'INC_BASE_CALCU' ");
        query.append(" AND G2.VAL_OID(+) = PC.BCAL_OID_BASE_CALC ");
        query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        query.append(" ) A on (A.OID = paisPlant.PLC2_OID_PLAN_CONC) ");

        /*query.append("SELECT A.OID_PLAN_CONC OID, A.OID_PLAN_CONC OID2, G.VAL_I18N DESC1, G2.VAL_I18N DESC2 ");
        query.append("FROM INC_PLANT_CONCU A, INC_PAIS_PLANT B, INC_BASE_CALCU C, V_GEN_I18N_SICC G, V_GEN_I18N_SICC G2 ");
        query.append("WHERE A.OID_PLAN_CONC = B.PLC2_OID_PLAN_CONC");
        query.append(" AND G.ATTR_ENTI = 'INC_PLANT_CONCU'");
        query.append(" AND G.VAL_OID = A.OID_PLAN_CONC");
        query.append(" AND G2.ATTR_ENTI(+) = 'INC_BASE_CALCU'");
        query.append(" AND G2.VAL_OID(+) = A.BCAL_OID_BASE_CALC");
        query.append(" AND A.BCAL_OID_BASE_CALC = C.OID_BASE_CALC(+)");*/
        //Jrivas 24/6/2005
        //Incidencia 19440
        /*query.append(" AND A.IND_ACTI = " + ConstantesINC.IND_ACTIVO);

        if ((DTOE != null) && (DTOE.getNroPlantilla() != null)) {
            query.append(" AND A.OID_PLAN_CONC = " + DTOE.getNroPlantilla());
        }

        if ((DTOE != null) && (DTOE.getNombrePlantilla() != null)) {
            query.append(" AND G.VAL_I18N LIKE '%" + DTOE.getNombrePlantilla() + "%'");
        }

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        }

        if ((DTOE != null) && (DTOE.getOidPais() != null)) {
            query.append(" AND B.PAIS_OID_PAIS = " + DTOE.getOidPais());
        }*/
        
        
        
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE);

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginada);
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs == null) || rs.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOConcurso.buscarListaPlantillas(DTOBuscarPlantillas DTOE): Salida");
        return rs;
    }

    public RecordSet buscarListaAmbitosGeograficos(DTOBuscar DTOE) {
        return null;
    }

    public RecordSet buscarListaEstatusVentaConsultora(DTOBuscar DTOE) {
        return null;
    }

    public RecordSet buscarListaEstatusVentaCalificacion(DTOBuscar DTOE) {
        return null;
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return
       * @param DTOE
       * @author Marcelo J. Maidana -- Creado: 20/04/2005.
       * Modificado por Cristian Valenzuela
       * Incidencia: BELC300023763
       * Fecha: 13/09/2006
       */
    public RecordSet cargarNroPlantilla(DTOBelcorp DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.cargarNroPlantilla(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
        query.append(" SELECT A.OID_PLAN_CONC OID, A.OID_PLAN_CONC ");
        //Eliminado por BELC300023763
        /*query.append(" FROM INC_PLANT_CONCU A , INC_PAIS_PLANT B ");
        query.append(" WHERE B.PLC2_OID_PLAN_CONC = A.OID_PLAN_CONC");
        query.append(" AND A.IND_ACTI = " + ConstantesINC.IND_ACTIVO);
        if ((DTOE != null) && (DTOE.getOidPais() != null)) {
            query.append(" AND B.PAIS_OID_PAIS = " + DTOE.getOidPais());
        }
        query.append(" ORDER BY OID_PLAN_CONC");*/
        //Fin Eliminado por BELC300023763
        
        //Agregado por BELC300023763
        query.append(" FROM (SELECT PP.PLC2_OID_PLAN_CONC, PP.OID_PAIS_PLAN ");
        query.append(" FROM INC_PAIS_PLANT PP ");
        query.append(" WHERE PP.PAIS_OID_PAIS = " + DTOE.getOidPais() + ") PAISPLANT ");
        query.append(" RIGHT OUTER JOIN ");
        query.append(" INC_PLANT_CONCU A ");
        query.append(" ON (A.OID_PLAN_CONC = PAISPLANT.PLC2_OID_PLAN_CONC) ");
        query.append(" WHERE A.IND_ACTI = " + ConstantesINC.IND_ACTIVO);
        query.append(" ORDER BY OID_PLAN_CONC ");
        //Fin Agregado por BELC300023763        

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.cargarNroPlantilla(DTOBelcorp DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author mdolce -- Creado: 11/07/2005.
     */
    public RecordSet obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
      
        /*V-INC-30:  Se quita el filtro: (val_esta_gene_meta) = ‘B’, para el caso oidAgrupacion=5 */
        if(dtoIn.getOidAgrugacion().equals(new Long(5))){
           query.append(" SELECT   concu.oid_para_gral, concu.num_conc || ' ' || concu.num_vers ");
           query.append(" FROM inc_concu_param_gener concu, ");
           query.append(" (SELECT 1 AS dirig, pacon.copa_oid_para_gral, ");
           query.append(" pacon.tven_oid_tipo_vent ");
           query.append(" FROM inc_concu_param_consu pacon ");
           query.append(" UNION ");
           query.append(" SELECT 2 AS dirig, pager.copa_oid_para_gral, ");
           query.append(" pager.tven_oid_tipo_vent ");
           query.append(" FROM inc_concu_param_geren pager) tipo_venta, inc_versi_concu vers ");
           query.append(" WHERE concu.pais_oid_pais =  " + dtoIn.getOidPais());
           //query.append(" AND concu.val_esta_gene_meta = 'B' ");
           query.append(" and concu.OID_PARA_GRAL = tipo_venta.copa_oid_para_gral ");
	         query.append(" and concu.DIRI_OID_DIRI = tipo_venta.dirig ");
           query.append(" AND concu.oid_para_gral = vers.copa_oid_para_gral ");
           query.append(" AND (vers.esc2_oid_esta_conc = 2 OR vers.esc2_oid_esta_conc = 11) ");
           
           
           if(dtoIn.getOidTipoCliente() != null){
	            query.append(" and tipo_venta.tven_oid_tipo_vent =  " + dtoIn.getOidTipoCliente());
           }
           
           if(dtoIn.getOidMarca() != null){
              query.append("  AND concu.marc_oid_marc =  " + dtoIn.getOidMarca());
           }
           
           if(dtoIn.getOidCanal() != null){
              query.append("  AND concu.cana_oid_cana = " + dtoIn.getOidCanal());
           }
           query.append(" ORDER BY 2 ");
          
        
        }else{
        
            query.append(" SELECT   concu.oid_para_gral, concu.num_conc || ' ' || concu.num_vers ");
            query.append(" FROM inc_concu_param_gener concu, inc_versi_concu vers ");
    
            UtilidadesLog.debug("++++++++el oid agrupacion es " + dtoIn.getOidAgrugacion());
    
            if (dtoIn.getOidAgrugacion().equals(new Long(1))) {
                query.append(" ,inc_multi multi");
            }
    
            query.append(" WHERE concu.pais_oid_pais = " + dtoIn.getOidPais());
    
            if (dtoIn.getOidMarca() != null) {
                query.append(" AND concu.marc_oid_marc = " + dtoIn.getOidMarca());
            }
    
            if (dtoIn.getOidCanal() != null) {
                query.append(" AND concu.cana_oid_cana = " + dtoIn.getOidCanal());
            }
    
            if (dtoIn.getOidAgrugacion().equals(new Long(1))) {
                query.append(" AND concu.oid_para_gral = multi.copa_oid_para_gral ");
            } else {
                //  Comentado por HRCS - Fecha 27/02/2006 - Incidencia SiCC 20070066
                /*if (dtoIn.getOidAgrugacion().equals(new Long(2))) {
                    query.append(" and concu.VAL_ESTA_GENE_META = 'B'");
                }else{*/
                   if (dtoIn.getOidAgrugacion().equals(new Long(3))) {
                      query.append(" 	 and concu.DIRI_OID_DIRI = 2");
                   }else{
                      if (dtoIn.getOidAgrugacion().equals(new Long(4))) {
                         query.append(" AND concu.BCAL_OID_BASE_CALC = 4 ");
                      }
                   
                   }
                /*}*/
            }
           
            
            query.append(" AND concu.oid_para_gral = vers.copa_oid_para_gral ");
            query.append(" AND (vers.esc2_oid_esta_conc = 2 OR vers.esc2_oid_esta_conc = 11) ");
            
            query.append(" ORDER BY 2 ");
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOConcurso.obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn): Salida  " +  rs);
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author mdolce -- Creado: 19/07/2005.
     */
    public RecordSet obtenerNivelesConcursoREP(DTOBelcorp dtoIn)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerNivelesConcursoREP(DTOBelcorp dtoIn): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
        query.append(" SELECT   genepremi.copa_oid_para_gral, parampremi.oid_para_nive_prem, ");
        query.append(" parampremi.num_nive  ");
        query.append(" FROM inc_param_nivel_premi parampremi, inc_param_gener_premi genepremi  ");
        query.append(" WHERE parampremi.pagp_oid_para_gene_prem = genepremi.oid_para_gene_prem  ");
        query.append(" ORDER BY 2 ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOConcurso.obtenerNivelesConcursoREP(DTOBelcorp dtoIn): Salida");
        return rs;
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return
       * @param DTOE
       * @author Marcelo J. Maidana -- 20/04/2005
       * Modificado por Cristian Valenzuela 31/8/2005
       */
    public RecordSet cargarNroConcurso(DTOBuscarNumConcurso DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.cargarNroConcurso(DTOBuscarNumConcurso DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append("SELECT DISTINCT NUM_CONC, NUM_CONC descripcion ");
        query.append("FROM INC_CONCU_PARAM_GENER ");
        query.append("WHERE 1 = 1");

        if ((DTOE != null) && (DTOE.getOidPais() != null)) {
            query.append(" AND PAIS_OID_PAIS = " + DTOE.getOidPais());
        }

        if ((DTOE.getIndActivo() != null) && (DTOE.getIndActivo().equals(Integer.valueOf("1")) || DTOE.getIndActivo().equals(Integer.valueOf("0")))) {
            query.append(" AND IND_ACTI = " + DTOE.getIndActivo());
        }

         if (DTOE.getIndRanking()!= null)  {
            query.append(" AND IND_RANK = " + DTOE.getIndRanking());
        }

        query.append(" ORDER BY descripcion ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.cargarNroConcurso(DTOBuscarNumConcurso DTOE): Salida");
        return rs;
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return
       * @param DTOE
       * @author Viviana Bongiovanni --1/08/2005
       */
    public RecordSet cargarNroConcursoVersion(DTOBuscarNumConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.cargarNroConcursoVersion(DTOBuscarNumConcurso DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append("SELECT OID_PARA_GRAL, NUM_CONC || ' - '|| NUM_VERS descripcion ");
        query.append(" FROM INC_CONCU_PARAM_GENER ");
        query.append(" WHERE PAIS_OID_PAIS = " + DTOE.getOidPais());

        if ((DTOE.getIndActivo() != null) && (DTOE.getIndActivo().equals(Integer.valueOf("1")) || DTOE.getIndActivo().equals(Integer.valueOf("0")))) {
            query.append(" AND IND_ACTI = " + DTOE.getIndActivo());
        }

        query.append(" ORDER BY descripcion");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.cargarNroConcursoVersion(DTOBuscarNumConcurso DTOE): Salida");
        return rs;
    }

    public DTOObtencionPuntos buscarObtencionPuntos(DTOBuscar DTOE) {
        return null;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public RecordSet obtenerAccesos(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerAccesos(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT B.OID_ACCE AS OID, C.VAL_I18N AS DESCRIPCION ");
        query.append(" FROM INC_ACCES_PLANT A, SEG_ACCES B, V_GEN_I18N_SICC C ");
        query.append(" WHERE C.ATTR_ENTI = 'SEG_ACCES' ");
        query.append(" AND C.ATTR_NUM_ATRI = 1 ");
        query.append(" AND C.VAL_OID = B.OID_ACCE ");
        query.append(" AND A.ACCE_OID_ACCE = B.OID_ACCE ");

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND C.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        }

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.PLC2_OID_PLAN_CONC = " + DTOE.getOid());
        }

        query.append(" ORDER BY C.VAL_I18N ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerAccesos(DTOOID DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public RecordSet obtenerMarcas(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMarcas(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT B.OID_MARC AS OID, B.DES_MARC AS DESCRIPCION ");
        query.append(" FROM INC_MARCA_PLANT A, SEG_MARCA B ");
        query.append(" WHERE A.MARC_OID_MARC = B.OID_MARC");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.PLC2_OID_PLAN_CONC = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerMarcas(DTOOID DTOE): Salida");
        return rs;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 15 abr 2005
     * @author: Damasia Maneiro
     *
     * cambio de tipo argumento de DTOBelcorp a DTOBuscarPlantillas
     *(ext DTOSiccPaginacion) pues ke en DT esta incorrecto
     * y confugurarPaginado no acepta DTOBelcorp en si. 21/04/05
     *
       inc. 20333
       ------------------------------------------------------------------------
       DAOConcurso.obtenerListaVersionesConcurso

       //Realiza una consulta utilizando el servicio DBService

        SELECT B.OID_VERS_CONC,
                      A.PAIS_OID_PAIS, --DESCRIPCION INTERNACIONALIZABLE
                      B.NUM_CONC,
                      B.VAL_VERS_NUEV,
                      B.OID_ESTADO_CONCURSO, --DESCRIPCION INTERNACIONALIZABLE
                      A.MARC_OID_MARC,--DESCRIPCION INTERNACIONALIZABLE
                      B.PERI_OID_PERI
                      B.COPA_OID_PARA_GRAL

        FROM INC_CONCU_PARAM_GENER A, INC_VERSI_CONCU B

        WHERE A.OID_PARA_GRAL =
        **********----------------------------MODIFICADO------------------------**********
                     B.COPA_OID_PARA_GRAL_ORIG
        **********--------------------------------------------------------------**********
                     AND (B.OID_ESTADO_CONCURSO = ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION

                     OR B.OID_ESTADO_CONCURSO = ConstantesINC.OID_ESTADO_SOLICITADA_APROBACION)

        @CHANGELOG
        --------------------------
        2005.08.2 GMIOTTI DT
        Se modifica el campo de join COPA_OID_PARA_GRAL por COPA_OID_PARA_GRAL_ORIG

     */
    public RecordSet obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe): Entrada");
        
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT ");
            query.append(" B.OID_VERS_CONC,");
            query.append(" (SELECT v.val_i18n");
            query.append(" FROM v_gen_i18n_sicc v");
            query.append(" WHERE v.val_oid = A.PAIS_OID_PAIS");
            query.append(" AND v.idio_oid_idio = " + dtoe.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1 ");
            query.append(" AND v.attr_enti = 'SEG_PAIS') AS pais,");
            query.append(" B.NUM_CONC,");
            query.append(" B.VAL_VERS_NUEV,");
            query.append(" B.ESC2_OID_ESTA_CONC,");
            query.append(" (SELECT v.val_i18n");
            query.append(" FROM v_gen_i18n_sicc v");
            query.append(" WHERE v.val_oid = B.ESC2_OID_ESTA_CONC");
            query.append(" AND v.idio_oid_idio = " + dtoe.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1");
            query.append(" AND v.attr_enti = 'INC_ESTAD_CONCU')");
            query.append(" AS estadoConcurso,");
            query.append(" m.DES_MARC, ");

            // Modificado por ssantana 10/8/2005, 
            query.append(" (select cra_perio.VAL_NOMB_PERI from cra_perio where cra_perio.oid_peri = b.perd_oid_peri), ");

            // Fin modificado por ssantana, 10/8/2005
            query.append(" B.COPA_OID_PARA_GRAL, ");

            // Agregado por ssantana, 10/8/2005, inc. 20442
            query.append(" a.PLC2_OID_PLAN_CONC, ");
            query.append(" a.OID_PARA_GRAL ");

            // Fin agregado por ssantana, 10/8/2005, inc. 20442
            query.append(" FROM INC_CONCU_PARAM_GENER A, INC_VERSI_CONCU B,");
            query.append(" SEG_MARCA m");
            query.append(" WHERE A.OID_PARA_GRAL = B.COPA_OID_PARA_GRAL_ORIG "); // <- inc. 20333 se pasa a COPA_OID_PARA_GRAL_ORIG 
            query.append(" AND (B.ESC2_OID_ESTA_CONC = " + ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION);
            query.append(" OR B.ESC2_OID_ESTA_CONC = " + ConstantesINC.OID_ESTADO_SOLICITADA_APROBACION + ")");
            query.append(" AND A.MARC_OID_MARC = m.OID_MARC");
            query.append(" ORDER BY B.NUM_CONC "); // inc.20419 - idedough -
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe): Salida");
        return respuesta;
    }

    /*
     * Fecha Creacion: 15/04/2005
     * Autor: Damasia Maneiro
     *
     * */
    public RecordSet obtenerListaClasificacionParticipantes(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerListaClasificacionParticipantes(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT A.OID_CLAS_PART_CONC, B.OID_PART_CONC_CABE, ");
            //query.append(" (SELECT v.val_i18n ");
            //query.append(" FROM v_gen_i18n_sicc v ");
            //query.append(" WHERE v.val_oid = B.OID_PART_CONC_CABE ");
            //query.append(" AND v.idio_oid_idio = " + DTOE.getOidIdioma());
            //query.append(" AND v.attr_num_atri = 1 ");
            //query.append(" AND v.attr_enti = 'INC_PARTI_CONCU_CABEC') AS INC_PARTI ");    //  Comentado por HRCS (Incidencia: V-INC-033)
            query.append(" B.DES_DESC AS INC_PARTI ");
            query.append(" FROM INC_CLASI_PARTI_CONCU A, INC_PARTI_CONCU_CABEC B ");
            query.append(" WHERE A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
            query.append(" AND B.OID_PART_CONC_CABE = A.PACI_OID_PART_CONC_CABE ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcurso.obtenerListaClasificacionParticipantes(DTOOID DTOE): Salida");
            return null;
        } else {
            UtilidadesLog.info("DAOConcurso.obtenerListaClasificacionParticipantes(DTOOID DTOE): Salida");
            return respuesta;
        }
    }

    /*
     * Fecha Creacion: 15/04/2005
     * Autor: Damasia Maneiro
     *
     * */
    public RecordSet obtenerListaParticipantes(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerListaParticipantes(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT A.OID_PART_CONC_CABE, ");
            //query.append(" (SELECT v.val_i18n ");
            //query.append(" FROM v_gen_i18n_sicc v ");
            //query.append(" WHERE v.val_oid = A.OID_PART_CONC_CABE ");
            //query.append(" AND v.idio_oid_idio = " + DTOE.getOidIdioma());
            //query.append(" AND v.attr_num_atri = 1 ");
            //query.append(" AND v.attr_enti = 'INC_PARTI_CONCU_CABEC') AS INC_PARTI ");    //  Comentado por HRCS (Incidencia: V-INC-033)
            query.append(" A.DES_DESC AS INC_PARTI ");
            query.append(" FROM INC_PARTI_CONCU_CABEC A ");
            query.append(" WHERE A.PAIS_OID_PAIS = " + DTOE.getOidPais());
            query.append(" AND A.DIRI_OID_DIRI = " + DTOE.getOid());

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcurso.obtenerListaParticipantes(DTOOID DTOE): Salida");
            return null;
        } else {
            UtilidadesLog.info("DAOConcurso.obtenerListaParticipantes(DTOOID DTOE): Salida");
            return respuesta;
        }
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @version 1.0 24 abr 2005
     * @author Igor Dedough
     *
     * Realiza una consulta utilizando el servicio DBService
     * select A.OID_CUEN_CORR_PUN, D.OID_TIPO_MOVI (internacionalizable),
     * A.FEC_MOVI, B.VAL_NOMB_PERI, G.DES_MARC,
     * H.OID_CANA (descripcion internacionalizable), A.NUM_PUNT, A.NUM_PUNT_EXIG,
     * A.OID_CUEN_CORR_PUN (internacionalizable), F.NUM_CONC, F.NUM_VERS
     * from INC_CUENT_CORRI_PUNTO A, CRA_PERIO B, INC_TIPO_MOVIM D,
     * MAE_CLIEN E, INC_CONCU_PARAM_GENER F, SEG:MARCA G, SEG_CANAL H
     * where A.COPA_OID_PARA_GRAL = DTOE.oidConcurso
     * and A.TMOV_OID_TIPO_MOVI = D.OID_TIPO_MOVI
     * and A.CLIE_OID_CLIE = E.OID_CLIE
     * and E.COD_CLIE = DTOE.codigoCliente
     * and E.PAIS_OID_PAIS = DTOE.pais
     * and A.PERD_OID_PERI = B.OID_PERI
     * and B.CANA_OID_CANA = H.OID_CANA
     * and B.MARC_OID_MARC = G.OID_MARC
     * and F.OID_PARA_GRAL = A.COPA_OID_PARA_GRAL
     */
    public RecordSet buscarCtaCtePtos(DTOBuscarCtaCtePtos DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.buscarCtaCtePtos(DTOBuscarCtaCtePtos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if (DTOE != null) {
            query.append(" SELECT A.OID_CUEN_CORR_PUNT,");
            query.append(" D.OID_TIPO_MOVI, ");
            query.append(" (SELECT v.val_i18n ");
            query.append(" FROM v_gen_i18n_sicc v ");
            query.append(" WHERE v.val_oid = D.OID_TIPO_MOVI ");
            query.append(" AND v.idio_oid_idio = " + DTOE.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1 ");
            query.append(" AND v.attr_enti = 'INC_TIPO_MOVIM') ");
            query.append(" AS DESC_TIPO_MOVI, ");
            query.append(" A.FEC_MOVI, B.VAL_NOMB_PERI, G.DES_MARC,");
            query.append(" H.OID_CANA, ");
            query.append(" (SELECT v.val_i18n ");
            query.append(" FROM v_gen_i18n_sicc v ");
            query.append(" WHERE v.val_oid = H.OID_CANA ");
            query.append(" AND v.idio_oid_idio = " + DTOE.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1 ");
            query.append(" AND v.attr_enti = 'SEG_CANAL') AS CANAL,");
            query.append(" A.NUM_PUNT, A.NUM_PUNT_EXIG, ");
            query.append(" A.OID_CUEN_CORR_PUNT, ");
            
            //Modificado por Cristian Valenzuela - 31/1/2006
            /*query.append(" (SELECT v.val_i18n ");
            query.append(" FROM v_gen_i18n_sicc v ");
            query.append(" WHERE v.val_oid = A.OID_CUEN_CORR_PUNT ");
            query.append(" AND v.idio_oid_idio = " + DTOE.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1 ");
            query.append(" AND v.attr_enti = 'INC_TIPO_MOVIM') ");
            query.append(" AS DESC_CUEN_CORR_PUNT,");*/
            
            query.append(" A.VAL_DESC, ");
            //FIN - Modificado por Cristian Valenzuela - 31/1/2006
            
            query.append(" F.NUM_CONC ||' - '|| F.NUM_VERS ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO A, CRA_PERIO B,");
            query.append(" INC_TIPO_MOVIM D, MAE_CLIEN E,");
            query.append(" INC_CONCU_PARAM_GENER F, SEG_MARCA G, SEG_CANAL H ");
            query.append(" WHERE ");

            if (DTOE.getNumeroConcurso() != null) {
                query.append(" f.NUM_CONC = '" + DTOE.getNumeroConcurso() + "' AND ");
            }

            query.append(" A.TMOV_OID_TIPO_MOVI = D.OID_TIPO_MOVI");
            query.append(" AND A.CLIE_OID_CLIE = E.OID_CLIE");

            if (DTOE.getCodigoCliente() != null) {
                query.append(" AND E.COD_CLIE = '" + DTOE.getCodigoCliente() +"' ");
            }

            if (DTOE.getOidPais() != null) {
                query.append(" AND E.PAIS_OID_PAIS = " + DTOE.getOidPais());
            }

            query.append(" and A.PERD_OID_PERI = B.OID_PERI");
            query.append(" and B.CANA_OID_CANA = H.OID_CANA");
            query.append(" and B.MARC_OID_MARC = G.OID_MARC");
            query.append(" and F.OID_PARA_GRAL = A.COPA_OID_PARA_GRAL");
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOConcurso.buscarCtaCtePtos(DTOBuscarCtaCtePtos DTOE): Salida");
        return rs;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @version 1.00 24 abr 2005
     * @author Igor Dedough
     *
     * //Este método obtiene las versiones
     * para el caso de uso "mantener versiones concurso".
     * //Los nombres de los campos no son los de BBDD
     * porque todavía no están creadas todas las tablas.
     * SELECT A.OID_VERSION, --columna oculta, se utiliza para la paginación
     * A.COPA_OID_PARA_GRAL, --columna oculta
     * A.COPA_OID_PARA_GRAL_ORIGEN, --columna oculta
     * A.NUM_CONC,
     * A.NUM_VERS,
     * C.OID_ESTADO_CONCURSO (descripcion internacionalizable),
     * B.PERD_OID_PERI_DESD, --columna oculta
     * B.PERD_OID_PERI_HAST, --columna oculta
     * D.FEC_INIC, --columna oculta
     * E.FEC_FINA --columna oculta
     * FROM INC_VERSIO_CONCU A,
     * INC_CONCU_PARAM_GENER B,
     * INC_ESTAD_CONCU C,
     * CRA_PERIO D,
     * CRA_PERIO E
     * WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL
     * AND B.PAIS_OID_PAIS = DTOE.pais
     * AND A.OID_ESTAT_CONCU = C.OID_ESTAT_CONCU
     * AND B.PERD_OID_PERI_DESD = D.OID_PERI
     * AND B.PERD_OID_PERI_HAST = E.OID_PERI
     */
    /**---------mlsantiago - DT - 25/05/2005---------
     Se ha modificado el método DAOConcurso.obtenerVersionesConcurso(DTOE :
     DTOOIDPaginado) : RecordSet (ya que antes no se obtenían todos los concursos con sus
     respectivas versiones)
     {
     //Este método obtiene las versiones para el caso de uso "mantener versiones concurso".
     SELECT
     A.OID_VERS_CONC,  --columna oculta, se utiliza para la paginación
     A.COPA_OID_PARA_GRAL, --columna oculta, puede ser nula
     A.COPA_OID_PARA_GRAL_ORIG, --columna oculta
     A.NUM_CONC,
     A.VAL_VERS_NUEV,
     C.OID_ESTA_CONC, (descripcion internacionalizable),
     B.PERD_OID_PERI_DESD, --columna oculta
     B.PERD_OID_PERI_HAST, --columna oculta
     D.FEC_INIC, --columna oculta
     E.FEC_FINA --columna oculta
     FROM
     INC_VERSI_CONCU A,
     INC_CONCU_PARAM_GENER B,
     INC_ESTAD_CONCU C,
     CRA_PERIO D,
     CRA_PERIO E
     WHERE A.COPA_OID_PARA_GRAL_ORIG = B.OID_PARA_GRAL
     AND B.PAIS_OID_PAIS = DTOE.pais
     AND A.ESC2_OID_ESTA_CONC = C.OID_ESTA_CONC
     AND B.PERD_OID_PERI_DESD = D.OID_PERI
     AND B.PERD_OID_PERI_HAST = E.OID_PERI

     Devolver el recordset obtenido
     } */
    public RecordSet obtenerVersionesConcurso(DTOOIDPaginado dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerVersionesConcurso(DTOOIDPaginado dtoe): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if (dtoe != null) {
            query.append(" SELECT A.OID_VERS_CONC,");
            query.append(" A.COPA_OID_PARA_GRAL,");
            query.append(" A.COPA_OID_PARA_GRAL_ORIG,");
            query.append(" A.NUM_CONC, ");
            query.append(" A.VAL_VERS_NUEV, ");
            query.append(" C.OID_ESTA_CONC, ");
            query.append(" (SELECT v.val_i18n ");
            query.append(" FROM v_gen_i18n_sicc v ");
            query.append(" WHERE v.val_oid = C.OID_ESTA_CONC ");
            query.append(" AND v.idio_oid_idio = " + dtoe.getOidIdioma());
            query.append(" AND v.attr_num_atri = 1 ");
            query.append(" AND v.attr_enti = 'INC_ESTAD_CONCU')");
            query.append(" AS DESC_OID_EST_CONC,");
            query.append(" B.PERD_OID_PERI_DESD,");
            query.append(" B.PERD_OID_PERI_HAST,");
            query.append(" D.FEC_INIC,");
            query.append(" E.FEC_FINA, ");
            
            /* Cambio por Ssantana, 09/05/2006, Versionado */
            query.append(" a.perd_oid_peri ");
            /* Fin Cambio por ssantana, 09/05/2006, Versionado */
            
            query.append(" FROM INC_VERSI_CONCU A,");
            query.append(" INC_CONCU_PARAM_GENER B,");
            query.append(" INC_ESTAD_CONCU C, ");
            query.append(" CRA_PERIO D, ");
            query.append(" CRA_PERIO E ");
            
            query.append(" WHERE A.COPA_OID_PARA_GRAL_ORIG = B.OID_PARA_GRAL ");
            query.append(" AND B.PAIS_OID_PAIS = " + dtoe.getOidPais());
            
            //Agregado por cvalenzu, 9/5/2006, Versionado
            query.append(" AND B.IND_ACTI = "  + ConstantesINC.IND_ACTIVO);
            //FIN - Agregado por cvalenzu, 9/5/2006, Versionado
            
            query.append(" AND A.ESC2_OID_ESTA_CONC = C.OID_ESTA_CONC ");
            //Agregado por cvalenzu, 9/5/2006, Versionado            
            query.append(" AND A.VICO_OID_VIGE_CONC != " + ConstantesINC.OID_VIG_CONCU_NO_VIGENTE);
            //FIN - Agregado por cvalenzu, 9/5/2006, Versionado
            
            query.append(" AND B.PERD_OID_PERI_DESD = D.OID_PERI ");
            query.append(" AND B.PERD_OID_PERI_HAST = E.OID_PERI ");
            query.append(" ORDER BY A.NUM_CONC ");

            
            //query.append(" AND B.IND_RANK = 0");
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerVersionesConcurso(DTOOIDPaginado dtoe): Salida");
        return rs;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @version 1.00 24 abr 2005
     * @author Igor Dedough
     *
     * //Realiza una consulta utilizando el servicio DBService.
     * //Revisar la select porque todavía no está creada la tabla
     * y los nombres de los campos son ficticios
     * SELECT COUNT(*)
     * FROM INC_VERSIO_CONCU
     * WHERE NUM_CONC = DTOE.numeroConcurso
     * AND NUM_VERS > DTOE.version
     * AND OID_ESTAD_CONCU = ConstantesINC.OID_ESTADO_APROBADO
     * AND COPA_OID_PARA_GRAL_ORIGEN IS NOT NULL
     * Si count(*) > 0   Devolver true   en otro caso    Devolver false
     */
    public Boolean obtenerVersionesSuperiores(DTOVersion dtoe)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerVersionesSuperiores(DTOVersion dtoe): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if (dtoe != null) {
            query.append(" SELECT COUNT(*) cant ");
            query.append(" FROM INC_VERSI_CONCU ");
            query.append(" WHERE ");

            if (dtoe.getNumeroConcurso() != null) {
                query.append(" NUM_CONC = '" + dtoe.getNumeroConcurso() + "' AND ");
            }

            if (dtoe.getVersionNueva() != null) {
                query.append(" VAL_VERS_NUEV > " + dtoe.getVersionNueva() + " AND ");
            }

            query.append(" ESC2_OID_ESTA_CONC = " + ConstantesINC.OID_ESTADO_APROBADO);
            query.append(" AND COPA_OID_PARA_GRAL_ORIG IS NOT NULL ");
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerVersionesSuperiores(DTOVersion dtoe): Salida");
        return (new Integer(rs.getValueAt(0, 0).toString()).intValue() > 0) ? Boolean.TRUE : Boolean.FALSE;
    }

    public DTOProgramaNuevas obtenerProgramaNuevas(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerProgramaNuevas(DTOOID DTOE): Entrada");
        
        /*
        select A.OID_PROG_NUEV, A.NUM_PEDI_EVAL, A.NUM_PEDI_PREM, A.TREQ_OID_TIPO_REQU, B.TEXI_OID_TIPO_EXIG
        from INC_PROGR_NUEVA A, INC_CONCU_PARAM_GENER B
        where B.OID_PARA_GRAL = 1 --DTOE.oid
        and A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL

        select C.OID_REQU_PROG_NUEV, C.NUM_PEDI, C.VAL_EXIG_MINI, D.NUM_NIVE
        from INC_PROGR_NUEVA A, INC_CONCU_PARAM_GENER B, INC_REQUI_PROGR_NUEVA C, INC_PARAM_NIVEL_PREMI D
        where C.PRNU_OID_PROG_NUEV = A.OID_PROG_NUEV
        and A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL
        and C.PANP_OID_PARA_NIVE_PREM = D.OID_PARA_NIVE_PREM (+)
        and B.OID_PARA_GRAL = 1 --DTOE.oid
         */
        BelcorpService bs;
        RecordSet rs;
        RecordSet rs2;
        String codigoError;
        StringBuffer query = new StringBuffer();
        StringBuffer query2 = new StringBuffer();
        DTOProgramaNuevas dto = null;

        //preparar query 1
        query.append(" SELECT A.OID_PROG_NUEV, A.NUM_PEDI_EVAL, A.NUM_PEDI_PREM, A.TREQ_OID_TIPO_REQU, B.TEXI_OID_TIPO_EXIG ");
        query.append(" FROM INC_PROGR_NUEVA A, INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND B.OID_PARA_GRAL = " + DTOE.getOid());
        }

        //preparar query 2
        // INC 21056: Se modifica la query para tomar el número del nivel en vez de su OID.
        query2.append(" SELECT C.OID_REQU_PROG_NUEV, C.NUM_PEDI, C.VAL_EXIG_MINI, D.NUM_NIVE ");
        query2.append(" FROM INC_PROGR_NUEVA A, INC_CONCU_PARAM_GENER B, INC_REQUI_PROGR_NUEVA C, INC_PARAM_NIVEL_PREMI D ");
        query2.append(" WHERE C.PRNU_OID_PROG_NUEV = A.OID_PROG_NUEV ");
        query2.append(" AND A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");
        query2.append(" AND C.PANP_OID_PARA_NIVE_PREM = D.OID_PARA_NIVE_PREM (+)");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query2.append(" AND B.OID_PARA_GRAL = " + DTOE.getOid());
        }
        // dmorello - 25/11/2005
        // Se agrega este ordenamiento para que aparezcan los ítems correctamente
        query2.append(" ORDER BY C.NUM_PEDI ASC ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            rs2 = bs.dbService.executeStaticQuery(query2.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        //jrivas 8/6/2005
        //si no tiene nada la primer query, entonces retorno null.
        if ((rs != null) && !rs.esVacio()) {
            dto = new DTOProgramaNuevas();

            dto.setOidProgramaNuevas(new Long(((BigDecimal) rs.getValueAt(0, "OID_PROG_NUEV")).toString()));
            dto.setPeriodosEvaluar(new Integer(((BigDecimal) rs.getValueAt(0, "NUM_PEDI_EVAL")).toString()));

            // Modificado por ssantana, 3/6/2005
            // Se contempla posibilidad de NULL en este campo 
            BigDecimal bigOidTipoExigencia = (BigDecimal) rs.getValueAt(0, "TEXI_OID_TIPO_EXIG");

            if (bigOidTipoExigencia != null) {
                dto.setOidTipoExigencia(new Long(bigOidTipoExigencia.longValue()));
            } else {
                dto.setOidTipoExigencia(null); // <-- Esta demás, pero por claridad.
            }

            // Fin Modificacion ssantana, 3/6/2005
            dto.setOidTipoRequisito(new Long(((BigDecimal) rs.getValueAt(0, "TREQ_OID_TIPO_REQU")).toString()));
            dto.setPedidosPremiar(new Integer(((BigDecimal) rs.getValueAt(0, "NUM_PEDI_PREM")).toString()));

            //DTOPedidoPremiar
            if ((rs2 != null) && !rs2.esVacio()) {
                DTOPedidoPremiar dtop = null;
                ArrayList al = new ArrayList();

                for (int i = 0; i < rs2.getRowCount(); i++) {
                    dtop = new DTOPedidoPremiar();

                    dtop.setExigenciaMinima((BigDecimal) rs2.getValueAt(i, "VAL_EXIG_MINI")); //BigDecimal
                    dtop.setNumeroPedido(new Integer(((BigDecimal) rs2.getValueAt(i, "NUM_PEDI")).toString())); //Integer

                    // INC 21056: Dado que cambió la segunda query, se toma el número del nivel y no el OID.
                    BigDecimal bigOidNivelPremiacion = (BigDecimal) rs2.getValueAt(i, "NUM_NIVE");
                    //Jrivas 21205 14/10/2005
                    if (bigOidNivelPremiacion != null) {
                        dtop.setOidNivelPremiacion(new Long(bigOidNivelPremiacion.longValue()));
                    } else {
                        dtop.setOidNivelPremiacion(null); // <-- Esta demás, pero por claridad.
                    }

                    //dtop.setOidNivelPremiacion(new Long(((BigDecimal) rs2.getValueAt(i, "PANP_OID_PARA_NIVE_PREM")).toString())); //Long
                    dtop.setOidPedidoPremiar(new Long(((BigDecimal) rs2.getValueAt(i, "OID_REQU_PROG_NUEV")).toString())); //Long
                    al.add(dtop);
                }

                dto.setListaPedidosPremiar(al);
            }
        }

        UtilidadesLog.info("DAOConcurso.obtenerProgramaNuevas(DTOOID DTOE): Salida");
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 22/04/2005
     */
    public DTOListaEstatusVenta obtenerListaEstatusVenta(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerListaEstatusVenta(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOListaEstatusVenta dtoLst = null;

        query.append(" SELECT A.OID_ESTA_VENT OID, B.OID_ESTA_CLIE, VG.VAL_I18N DESC_ESTA_CLIE, C.OID_PERI OID_PERI_DESDE, C.VAL_NOMB_PERI DESC_PERI_DESDE, D.OID_PERI OID_PERI_HASTA, D.VAL_NOMB_PERI DESC_PERI_HASTA ");
        query.append(" FROM INC_ESTAT_VENTA_CONSU A, MAE_ESTAT_CLIEN B, CRA_PERIO C, CRA_PERIO D, V_GEN_I18N_SICC VG ");
        query.append(" WHERE A.ESTA_OID_ESTA_CLIE = B.OID_ESTA_CLIE ");
        query.append(" AND A.PERD_OID_PERI_DESD = C.OID_PERI ");
        query.append(" AND A.PERD_OID_PERI_HAST = D.OID_PERI");
        query.append(" AND VG.ATTR_ENTI = 'MAE_ESTAT_CLIEN'");
        query.append(" AND VG.VAL_OID = B.OID_ESTA_CLIE");

        if (DTOE != null) {
            if (DTOE.getOidIdioma() != null) {
                query.append(" AND VG.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }

            if (DTOE.getOid() != null) {
                query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
            }
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            /*codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(codigoError));*/
            DTOEstatusVenta dtoEV = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtoEV = new DTOEstatusVenta();
                dtoEV.setOidEstatus(new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString()));
                dtoEV.setOidEstatusVentaMae(new Long(((BigDecimal) rs.getValueAt(i, "OID_ESTA_CLIE")).toString()));
                dtoEV.setOidPeriodoDesde(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERI_DESDE")).toString()));
                dtoEV.setOidPeriodoHasta(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERI_HASTA")).toString()));
                dtoEV.setDesEstatus(rs.getValueAt(i, "DESC_ESTA_CLIE").toString());
                dtoEV.setDesPeriodoDesde(rs.getValueAt(i, "DESC_PERI_DESDE").toString());
                dtoEV.setDesPeriodoHasta(rs.getValueAt(i, "DESC_PERI_HASTA").toString());
                al.add(dtoEV);
            }

            dtoLst = new DTOListaEstatusVenta();
            dtoLst.setEstatusVenta(al);
        }

        UtilidadesLog.info("DAOConcurso.obtenerListaEstatusVenta(DTOOID DTOE): Salida");
        return dtoLst;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 22/04/2005
     */
    public DTOListaAmbitosGeograficos obtenerListaAmbitosGeograficos(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerListaAmbitosGeograficos(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOListaAmbitosGeograficos dtoLst = null;

        query.append(" SELECT F.OID_AMBITO_GEOGRAFICO, A.OID_SUBG_VENT, A.DES_SUBG_VENT, B.OID_REGI, B.DES_REGI, C.OID_ZONA, C.DES_ZONA, D.OID_SECC, D.DES_SECCI, E.OID_TERR , E.COD_TERR ");
        query.append(" FROM ZON_SUB_GEREN_VENTA A, ZON_REGIO B, ZON_ZONA C, ZON_SECCI D, ZON_TERRI E, INC_AMBIT_GEOGR F ");
        query.append(" WHERE F.ZSGV_OID_SUBG_VENT = A.OID_SUBG_VENT ");
        query.append(" AND F.ZORG_OID_REGI = B.OID_REGI(+) ");
        query.append(" AND F.ZZON_OID_ZONA = C.OID_ZONA(+) ");
        query.append(" AND F.ZSCC_OID_SECC = D.OID_SECC(+) ");
        query.append(" AND F.TERR_OID_TERR = E.OID_TERR(+) ");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND F.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            /*codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(codigoError));*/
            DTOIncAmbitoGeografico dtoInc = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtoInc = new DTOIncAmbitoGeografico();
                dtoInc.setOidAmbitoGeografico((rs.getValueAt(i, "OID_AMBITO_GEOGRAFICO") != null)
                                              ? new Long(((BigDecimal) rs.getValueAt(i, "OID_AMBITO_GEOGRAFICO")).toString()) : null);
                dtoInc.setOidSubgerencia((rs.getValueAt(i, "OID_SUBG_VENT") != null)
                                         ? new Long(((BigDecimal) rs.getValueAt(i, "OID_SUBG_VENT")).toString()) : null);
                dtoInc.setOidRegion((rs.getValueAt(i, "OID_REGI") != null) ? new Long(((BigDecimal) rs.getValueAt(i, "OID_REGI")).toString()) : null);
                dtoInc.setOidZona((rs.getValueAt(i, "OID_ZONA") != null) ? new Long(((BigDecimal) rs.getValueAt(i, "OID_ZONA")).toString()) : null);
                dtoInc.setOidSeccion((rs.getValueAt(i, "OID_SECC") != null) ? new Long(((BigDecimal) rs.getValueAt(i, "OID_SECC")).toString()) : null);
                dtoInc.setOidTerritorio((rs.getValueAt(i, "OID_TERR") != null) ? new Long(((BigDecimal) rs.getValueAt(i, "OID_TERR")).toString()) : null);
                dtoInc.setDesSubgerencia((rs.getValueAt(i, "DES_SUBG_VENT") != null) ? rs.getValueAt(i, "DES_SUBG_VENT").toString() : null);
                dtoInc.setDesRegion((rs.getValueAt(i, "DES_REGI") != null) ? rs.getValueAt(i, "DES_REGI").toString() : null);
                dtoInc.setDesZona((rs.getValueAt(i, "DES_ZONA") != null) ? rs.getValueAt(i, "DES_ZONA").toString() : null);
                dtoInc.setDesSeccion((rs.getValueAt(i, "DES_SECCI") != null) ? rs.getValueAt(i, "DES_SECCI").toString() : null);
                dtoInc.setDesTerritorio((rs.getValueAt(i, "COD_TERR") != null) ? rs.getValueAt(i, "COD_TERR").toString() : null);
                al.add(dtoInc);
            }

            dtoLst = new DTOListaAmbitosGeograficos();
            dtoLst.setAmbitoGeografico(al);
        }

        UtilidadesLog.info("DAOConcurso.obtenerListaAmbitosGeograficos(DTOOID DTOE): Salida");
        return dtoLst;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Cristian Valenzuela -- 5/7/2005
     */
    public DTOObtencionPuntos obtenerObtencionPuntos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerObtencionPuntos(DTOOID DTOE): Entrada");
        UtilidadesLog.debug("********** DTOOID " + DTOE);

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT A.OID_OBTE_PUNT, A.VAL_FACT_CONV, A.NUM_PUNT_ASIG, A.IND_COMU_OBTE, B.COD_MENS, A.VAL_PUNT_ACUM, A.IND_ACTI, A.IND_CONS, B.PAIS_OID_PAIS ");
        
        // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
        query.append(" ,A.NUM_CAMP_SINP_PERM ");
        
        query.append(" FROM INC_OBTEN_PUNTO A, MSG_MENSA B, INC_CONCU_PARAM_GENER C ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
        query.append(" AND A.MENS_OID_MENS = B.OID_MENS(+) ");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND C.OID_PARA_GRAL = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOObtencionPuntos dtos = null;

        if (!rs.esVacio()) {
            dtos = new DTOObtencionPuntos();

            dtos.setOidObtencionPuntos(new Long(((BigDecimal) rs.getValueAt(0, "OID_OBTE_PUNT")).toString()));
            dtos.setFactorConversion((BigDecimal) rs.getValueAt(0, "VAL_FACT_CONV"));
            dtos.setPuntosAsignar(new Integer(((BigDecimal) rs.getValueAt(0, "NUM_PUNT_ASIG")).toString()));
            dtos.setIndComunicacion(new Integer(((BigDecimal) rs.getValueAt(0, "IND_COMU_OBTE")).toString()));

            if (rs.getValueAt(0, "COD_MENS") != null) {
                dtos.setMensaje(rs.getValueAt(0, "COD_MENS").toString());
            }

            if (rs.getValueAt(0, "PAIS_OID_PAIS") != null) {
                dtos.setOidPais(new Long(((BigDecimal) rs.getValueAt(0, "PAIS_OID_PAIS")).toString()));
            }

            if (rs.getValueAt(0, "VAL_PUNT_ACUM") != null) {
                dtos.setIndPuntajeAcumulativo(new Integer(((BigDecimal) rs.getValueAt(0, "VAL_PUNT_ACUM")).toString()));
            }

            if (rs.getValueAt(0, "IND_ACTI") != null) {
                dtos.setIndActividad(new Integer(((BigDecimal) rs.getValueAt(0, "IND_ACTI")).toString()));
            }

            if (rs.getValueAt(0, "IND_CONS") != null) {
                dtos.setIndConstancia(new Integer(((BigDecimal) rs.getValueAt(0, "IND_CONS")).toString()));
            }
            
            // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
            if (rs.getValueAt(0, "NUM_CAMP_SINP_PERM") != null) {
                dtos.setNumPeriodosSinPedido(new Integer(((BigDecimal) rs.getValueAt(0, "NUM_CAMP_SINP_PERM")).toString()));
            }
        }

        UtilidadesLog.debug("****** DTOObtencionPuntos " + dtos);
        UtilidadesLog.info("DAOConcurso.obtenerObtencionPuntos(DTOOID DTOE): Salida");
        return dtos;
    }

    public RecordSet obtenerTiposExigencia(DTOBelcorp dtoE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerTiposExigencia(DTOBelcorp dtoE): Entrada");
        //Obtener los campos: 
        //oidTipoExigencia 
        //descripcion (internacionalizable) 
        //de la entidad INC:TipoExigencia
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT ITE.OID_TIPO_EXIG, i1.val_i18n  ");
            query.append(" FROM v_gen_i18n_sicc I1, INC_TIPO_EXIGE ITE ");
            query.append(" WHERE ");
            query.append(" i1.attr_enti = 'INC_TIPO_EXIGE' AND  ");
            query.append(" i1.ATTR_NUM_ATRI = 1   ");
            query.append(" AND i1.VAL_OID = ITE.OID_TIPO_EXIG ");
            query.append(" AND i1.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
            query.append(" ORDER BY i1.val_i18n ");

            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTiposExigencia(DTOBelcorp dtoE): Salida");
        return rs;
    }

    public RecordSet obtenerTiposRequisito(DTOBelcorp dtoE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTiposRequisito(DTOBelcorp dtoE): Entrada");
        //Obtener los campos: 
        //oidTipoExigencia 
        //descripcion (internacionalizable) 
        //de la entidad INC:TipoRequisito
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT ITE.OID_TIPO_REQU, i1.val_i18n  ");
            query.append(" FROM v_gen_i18n_sicc I1, INC_TIPO_REQUI ITE ");
            query.append(" WHERE ");
            query.append(" i1.attr_enti = 'INC_TIPO_REQUI' AND  ");
            query.append(" i1.ATTR_NUM_ATRI = 1   ");
            query.append(" AND i1.VAL_OID = ITE.OID_TIPO_REQU ");
            query.append(" AND i1.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
            query.append(" ORDER BY i1.val_i18n ");

            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTiposRequisito(DTOBelcorp dtoE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     *
     */
    public DTOListaMontoVentaRecomendadas obtenerMontoVentaRecomendadas(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMontoVentaRecomendadas(DTOOID DTOE): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOListaMontoVentaRecomendadas dtos = null;

//        query.append(" SELECT A.OID_MONT_VENT_RECO OIDMONTO, NVL(A.VAL_CANT_MONT_VENT, 0) CANT, VG.VAL_I18N DESCTIPO, B.OID_TIPO_MONT_VENT_RECO OIDTIPO ");
        query.append(" SELECT A.OID_MONT_VENT_RECO OIDMONTO, A.VAL_CANT_MONT_VENT CANT, VG.VAL_I18N DESCTIPO, B.OID_TIPO_MONT_VENT_RECO OIDTIPO ");

        query.append(" FROM INC_MONTO_VENTA_RECOM A, INC_TIPO_MONTO_VENTA_RECOM B, V_GEN_I18N_SICC VG ");
        query.append(" WHERE A.TMVR_OID_TIPO_MONT_VENT_RECO (+) = B.OID_TIPO_MONT_VENT_RECO ");
        query.append(" AND VG.ATTR_ENTI LIKE 'INC_TIPO_MONTO_VENTA_RECOM' ");
        query.append(" AND VG.VAL_OID = B.OID_TIPO_MONT_VENT_RECO ");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid()); // OID CONCURSO
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND VG.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            /*codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(codigoError));*/
            dtos = new DTOListaMontoVentaRecomendadas();

            DTOMontoVentaRecomendadas dtoMonto = null;
            ArrayList al = new ArrayList();
            Object o = null;

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtoMonto = new DTOMontoVentaRecomendadas();
                dtoMonto.setOidMontoVenta(((o = rs.getValueAt(i, "OIDMONTO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                dtoMonto.setOidTipoMontoVenta(((o = rs.getValueAt(i, "OIDTIPO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                dtoMonto.setDescTipoMontoVenta(((o = rs.getValueAt(i, "DESCTIPO")) != null) ? o.toString() : "");
                dtoMonto.setCantidad(((o = rs.getValueAt(i, "CANT")) != null) ? (BigDecimal) o : null);
                al.add(dtoMonto);
            }

            dtos.setMontosVenta(al);
        }

        UtilidadesLog.info("DAOConcurso.obtenerMontoVentaRecomendadas(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     */
    public DTOParametrosConsultoras obtenerParametrosConsultoras(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerParametrosConsultoras(DTOOID DTOE): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOParametrosConsultoras dtos = null;

        query.append(" SELECT A.OID_CONC_PARA_CONS, A.IMP_MONT_MINI_PEDI, A.NUM_UNID_MINI_PEDI, A.IND_REIN_PIER_PUNT, B.BCAL_OID_BASE_CALC, A.IND_RECO_EFEC, B.TEXI_OID_TIPO_EXIG, A.PERD_OID_PERI_INIC_EVAL , A.VAL_PERI_EVAL, A.NUM_MINI_PEDI, A.NUM_MINI_PEDI_RECO, A.TVEN_OID_TIPO_VENT, ");
        // vbongiov -- Cambio 20080580 -- 13/8/2008
        query.append(" A.IND_PREM_CAMP_EFEC, IND_GENE_PUNT_A_RECO, COPA_CONC_PUNT_RECO ");
        query.append(" FROM INC_CONCU_PARAM_CONSU A, INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND B.OID_PARA_GRAL = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            /*codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(codigoError));*/
            dtos = new DTOParametrosConsultoras();

            Object o = null;
            BigDecimal ind = null;

            dtos.setOidParamConsultoras(((o = rs.getValueAt(0, "OID_CONC_PARA_CONS")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long
            dtos.setMontoMinimoPedido(((o = rs.getValueAt(0, "IMP_MONT_MINI_PEDI")) != null) ? new BigDecimal(((BigDecimal) o).toString()) : null); //BigDecimal
            dtos.setUnidadesMinimasPedido(((o = rs.getValueAt(0, "NUM_UNID_MINI_PEDI")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer

            ind = (BigDecimal) rs.getValueAt(0, "IND_REIN_PIER_PUNT");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndReingresosPierdenPuntaje(Boolean.TRUE);
            } else {
                dtos.setIndReingresosPierdenPuntaje(Boolean.FALSE);
            }

            dtos.setOidBaseCalculo(((o = rs.getValueAt(0, "BCAL_OID_BASE_CALC")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long

            ind = (BigDecimal) rs.getValueAt(0, "IND_RECO_EFEC");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndRecomendacionEfectiva(Boolean.TRUE);
            } else {
                dtos.setIndRecomendacionEfectiva(Boolean.FALSE);
            }

            dtos.setOidEfectividad(((o = rs.getValueAt(0, "TEXI_OID_TIPO_EXIG")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long
            dtos.setOidPeriodoInicialEvaluacion(((o = rs.getValueAt(0, "PERD_OID_PERI_INIC_EVAL")) != null) ? new Long(((BigDecimal) o).toString())
                                                                                                            : null); //Long
            dtos.setNroPeriodosEvaluar(((o = rs.getValueAt(0, "VAL_PERI_EVAL")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer
            dtos.setNroMinimoPedidos(((o = rs.getValueAt(0, "NUM_MINI_PEDI")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer
            dtos.setNroMinimoPedidosRecomendada(((o = rs.getValueAt(0, "NUM_MINI_PEDI_RECO")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer
            
            // vbongiov -- 17/03/2008 -- Cambio RI 20080535
            ind = (BigDecimal) rs.getValueAt(0, "IND_PREM_CAMP_EFEC");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPremioCampEfect(Boolean.TRUE);
            } else {
                dtos.setIndPremioCampEfect(Boolean.FALSE);
            }       
            
            // vbongiov -- Cambio 20080580 -- 13/8/2008
            ind = (BigDecimal) rs.getValueAt(0, "IND_GENE_PUNT_A_RECO");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndGenerarPuntajeARecomendadas(Boolean.TRUE);
            } else {
                dtos.setIndGenerarPuntajeARecomendadas(Boolean.FALSE);
            }    
            
            dtos.setOidConcursoPuntajeRecomendada(((o = rs.getValueAt(0, "COPA_CONC_PUNT_RECO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long            

            dtos.setOidTipoVenta(((o = rs.getValueAt(0, "TVEN_OID_TIPO_VENT")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long
        }

        UtilidadesLog.info("DAOConcurso.obtenerParametrosConsultoras(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 11/07/2006
     * Incidencia: DBLG500000743
     */
    public DTOParametrosGeneralesPremiacion obtenerParametrosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerParametrosPremiacion(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOParametrosGeneralesPremiacion dtos = null;
        
        query.append(" SELECT A.OID_PARA_GENE_PREM, A.NUM_NIVE, A.IND_PREM_ACUM_NIVE,  ");
        query.append(" A.IND_NIVE_ROTA, A.NUM_ROTA, A.IND_ACCE_NIVE_SUPE, A.IND_PREM_ELEC,  ");
        query.append(" A.IND_PERI_DESP_EXIG, A.NUM_PERI, A.IND_COMU, B.COD_MENS,  ");
        query.append(" A.TELE_OID_TIPO_ELEC, A.TPRM_OID_TIPO_PION, A.PERD_OID_PERI,  ");
        query.append(" B.PAIS_OID_PAIS, A.VAL_HAST_NIVE,  ");
        // vbongiov -- Cambio 20080811 -- 26/08/2009
        query.append(" sorteo.NUM_ASIG, sorteo.PROD_OID_PROD, prod.COD_SAP ");

        // sapaza -- PER-SiCC-2010-0210 -- 23/04/2010
        query.append(" ,A.PERD_OID_PERI_INIC ");
        
        // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
        query.append(" ,A.IND_NOPR_DEFE ");
        
        query.append(" FROM INC_PARAM_GENER_PREMI A, MSG_MENSA B, INC_CONCU_PARAM_GENER C,  ");
        // vbongiov -- Cambio 20080811 -- 26/08/2009
        query.append(" INC_PARAM_NIVEL_PREMI nivel, INC_PREMI_SORTE sorteo, MAE_PRODU prod ");
        
        query.append(" WHERE A.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL  ");
        query.append(" AND A.MENS_OID_MENS = B.OID_MENS(+)  ");
        
        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND C.OID_PARA_GRAL = " + DTOE.getOid());
        }
        
        // vbongiov -- Cambio 20080811 -- 26/08/2009
        query.append(" AND nivel.PAGP_OID_PARA_GENE_PREM(+) = A.OID_PARA_GENE_PREM ");
        query.append(" AND sorteo.PANP_OID_PARA_NIVE_PREM(+) = nivel.OID_PARA_NIVE_PREM ");
        query.append(" AND prod.OID_PROD(+) = sorteo.PROD_OID_PROD ");
        

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
           
            dtos = new DTOParametrosGeneralesPremiacion();

            Object o = null;
            BigDecimal ind = null;

            dtos.setOidParamGralesPremiacion(((o = rs.getValueAt(0, "OID_PARA_GENE_PREM")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- OID_PARA_GENE_PREM
            dtos.setOidTipoPremiacion(((o = rs.getValueAt(0, "TPRM_OID_TIPO_PION")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- TPRM_OID_TIPO_PION

            ind = (BigDecimal) rs.getValueAt(0, "IND_PERI_DESP_EXIG");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPeriodoDespacho(Boolean.TRUE); //Boolean -- IND_PERI_DESP_EXIG
            } else {
                dtos.setIndPeriodoDespacho(Boolean.FALSE); //Boolean -- IND_PERI_DESP_EXIG
            }

            dtos.setOidPeriodo(((o = rs.getValueAt(0, "PERD_OID_PERI")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- PERD_OID_PERI
            
             // sapaza -- PER-SiCC-2010-0210 -- 23/04/2010
            dtos.setOidPeriodoInicio(((o = rs.getValueAt(0, "PERD_OID_PERI_INIC")) != null) ? 
                                new Long(((BigDecimal) o).toString()) : null); //Long -- PERD_OID_PERI_INIC
            
            dtos.setNroPeriodosObtencion(((o = rs.getValueAt(0, "NUM_PERI")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- NUM_PERI 

            ind = (BigDecimal) rs.getValueAt(0, "IND_COMU");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndComunicacion(Boolean.TRUE); //Boolean -- IND_COMU
            } else {
                dtos.setIndComunicacion(Boolean.FALSE); //Boolean -- IND_COMU
            }

            dtos.setMensaje(((o = rs.getValueAt(0, "COD_MENS")) != null) ? o.toString() : ""); //String -- COD_MENS 
            dtos.setOidPais(((o = rs.getValueAt(0, "PAIS_OID_PAIS")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- PAIS_OID_PAIS

            dtos.setNroNiveles(((o = rs.getValueAt(0, "NUM_NIVE")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- NUM_NIVE 

            ind = (BigDecimal) rs.getValueAt(0, "IND_PREM_ACUM_NIVE");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPremiosAcumulativosNiveles(Boolean.TRUE); //Boolean -- IND_PREM_ACUM_NIVE 
            } else {
                dtos.setIndPremiosAcumulativosNiveles(Boolean.FALSE); //Boolean -- IND_PREM_ACUM_NIVE 
            }
            
            dtos.setHastaNivel(((o = rs.getValueAt(0, "VAL_HAST_NIVE")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- VAL_HAST_NIVE               

            ind = (BigDecimal) rs.getValueAt(0, "IND_NIVE_ROTA");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndNivelesRotativos(Boolean.TRUE); //Boolean -- IND_NIVE_ROTA
            } else {
                dtos.setIndNivelesRotativos(Boolean.FALSE); //Boolean -- IND_NIVE_ROTA
            }

            dtos.setNroRotaciones(((o = rs.getValueAt(0, "NUM_ROTA")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- NUM_ROTA 

            ind = (BigDecimal) rs.getValueAt(0, "IND_ACCE_NIVE_SUPE");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndAccesoNivelPremioSuperior(Boolean.TRUE); //Boolean -- IND_ACCE_NIVE_SUPE 
            } else {
                dtos.setIndAccesoNivelPremioSuperior(Boolean.FALSE); //Boolean -- IND_ACCE_NIVE_SUPE 
            }

            ind = (BigDecimal) rs.getValueAt(0, "IND_PREM_ELEC");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPremiosElectivos(Boolean.TRUE); //Boolean -- IND_PREM_ELEC
            } else {
                dtos.setIndPremiosElectivos(Boolean.FALSE); //Boolean -- IND_PREM_ELEC
            }

            dtos.setOidTipoEleccion(((o = rs.getValueAt(0, "TELE_OID_TIPO_ELEC")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Lont -- TELE_OID_TIPO_ELEC 
            
            // vbongiov -- Cambio 20080811 -- 26/08/2009
             dtos.setCantidadNumerosAOtorgar(((o = rs.getValueAt(0, "NUM_ASIG")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- NUM_ASIG 
             dtos.setOidProducto(((o = rs.getValueAt(0, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- PROD_OID_PROD 
             dtos.setCodProducto(((o = rs.getValueAt(0, "COD_SAP")) != null) ? (String) o : null); //String -- COD_SAP 
            
             // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
             ind = (BigDecimal) rs.getValueAt(0, "IND_NOPR_DEFE");

             if ((ind != null) && (ind.intValue() == 1)) {
                 dtos.setIndSinPremioPorDefecto(Boolean.TRUE); 
             } else {
                 dtos.setIndSinPremioPorDefecto(Boolean.FALSE); 
             } 
        }

        UtilidadesLog.info("DAOConcurso.obtenerParametrosPremiacion(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     */
    public DTORequisitosPremiacion obtenerRequisitosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerRequisitosPremiacion(DTOOID DTOE): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTORequisitosPremiacion dtos = null;

        query.append(" SELECT A.OID_REQU_PREM OID, A.VAL_MONT_MINI_CONC MONTOMINCONC, A.NUM_PEDI NROPEDIDOS, A.VAL_CUOT_INGR CUOTA, A.IND_PEDI_PERI INDPEDIPERI, ");
        query.append(" A.VAL_MONT_MINI_PEDI MONTOMINPEDI, A. IND_PAGO_TIEM INDPAGO, A.NUM_DIAS_GRAC DIASGRAC, A.PERD_OID_PERI_DESD PERIODODESDE, A.PERD_OID_PERI PERIODOHASTA, ");
        query.append(" A.NUM_PERI_ESPE_PAGO ,A.PERD_OID_PERI_MAXI, CRA_PERIO.VAL_NOMB_PERI , A.VADE_OID_VALI_DEUD, ");
        query.append(" I18N.VAL_I18N  ");
        query.append(" FROM INC_REQUI_PREMI A, INC_CONCU_PARAM_GENER B,  V_GEN_I18N_SICC I18N, ");
        query.append("  INC_VALID_DEUDA, CRA_PERIO ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append("AND B.OID_PARA_GRAL = " + DTOE.getOid());
        }
        
        // vbongiov -- cambio 20090929 -- 9/11/2009
        query.append(" AND A.VADE_OID_VALI_DEUD = INC_VALID_DEUDA.OID_VALI_DEUD(+) ");
        query.append(" AND I18N.ATTR_ENTI(+) = 'INC_VALID_DEUDA' ");
        query.append(" AND I18N.ATTR_NUM_ATRI(+) = 1 ");
        query.append(" AND I18N.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
        query.append(" AND I18N.VAL_OID(+) = INC_VALID_DEUDA.OID_VALI_DEUD ");
        query.append(" AND A.PERD_OID_PERI_MAXI = CRA_PERIO.OID_PERI(+) ");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if ((rs != null) && !rs.esVacio()) {
            dtos = new DTORequisitosPremiacion();

            Object o = null;
            BigDecimal ind = null;

            dtos.setOidRequisitosPremiacion(((o = rs.getValueAt(0, "OID")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- OID
            dtos.setMontoMinimoConcurso(((o = rs.getValueAt(0, "MONTOMINCONC")) != null) ? (BigDecimal) o : null); //Integer -- montoMinConc MONTOMINCONC

            dtos.setNumeroPedidos(((o = rs.getValueAt(0, "NROPEDIDOS")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- nroPedidos NROPEDIDOS
            dtos.setCuotaMinimaIngreso(((o = rs.getValueAt(0, "CUOTA")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- cuota

            ind = (BigDecimal) rs.getValueAt(0, "INDPEDIPERI");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPasarPedidoPeriodoPremiacion(Boolean.TRUE); //Boolean -- indPediPeri INDPEDIPERI
            } else {
                dtos.setIndPasarPedidoPeriodoPremiacion(Boolean.FALSE); //Boolean -- indPediPeri INDPEDIPERI
            }

            dtos.setMontoMinimoPedido(((o = rs.getValueAt(0, "MONTOMINPEDI")) != null) ? (BigDecimal) o : new BigDecimal(0)); //Integer -- montoMinPedi MONTOMINPEDI

            ind = (BigDecimal) rs.getValueAt(0, "INDPAGO");

            if ((ind != null) && (ind.intValue() == 1)) {
                dtos.setIndPagoTiempo(Boolean.TRUE); //Boolean -- indPago INDPAGO
            } else {
                dtos.setIndPagoTiempo(Boolean.FALSE); //Boolean -- indPago
            }

            dtos.setDiasGracia(((o = rs.getValueAt(0, "DIASGRAC")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //Integer -- diasGrac DIASGRAC
            dtos.setOidPeriodoDesde(((o = rs.getValueAt(0, "PERIODODESDE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- periodoDesde PERIODODESDE
            dtos.setOidPeriodoHasta(((o = rs.getValueAt(0, "PERIODOHASTA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- periodoHasta
            dtos.setNumeroPerioEspera(((o = rs.getValueAt(0, "NUM_PERI_ESPE_PAGO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtos.setOidPeriodoMax(((o = rs.getValueAt(0, "PERD_OID_PERI_MAXI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtos.setPeriodoMaxDescrip(((o = rs.getValueAt(0, "VAL_NOMB_PERI")) != null) ? o.toString() : "");
            dtos.setoidValiDeuda(((o = rs.getValueAt(0, "VADE_OID_VALI_DEUD")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtos.setDescripValidaDeuda(((o = rs.getValueAt(0, "VAL_I18N")) != null) ? o.toString() : "");
        }

        UtilidadesLog.info("DAOConcurso.obtenerRequisitosPremiacion(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     */
    public DTOCursosExigidosPremiacion obtenerCursosExigidosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerCursosExigidosPremiacion(DTOOID DTOE): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOCursosExigidosPremiacion dtos = null;

        query.append(" SELECT A.OID_CURS_EXIG_PREM OIDCURSOEXIGIDO, D.OID_TIPO_CURS OIDTIPOCURSO, VG.VAL_I18N TIPOCURSO ");
        query.append(" FROM INC_CURSO_EXIGI_PREMI A, INC_REQUI_PREMI B, INC_CONCU_PARAM_GENER C, EDU_TIPO_CURSO D, V_GEN_I18N_SICC VG ");
        query.append(" WHERE A.REPR_OID_REQU_PREM = B.OID_REQU_PREM ");
        query.append(" AND A.TICU_OID_TIPO_CURS = D.OID_TIPO_CURS ");
        query.append(" AND B.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
        query.append(" AND VG.ATTR_ENTI LIKE 'EDU_TIPO_CURSO' ");
        query.append(" AND VG.VAL_OID = D.OID_TIPO_CURS");

        if (DTOE != null) {
            if (DTOE.getOidIdioma() != null) {
                query.append(" AND VG.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }

            if (DTOE.getOid() != null) {
                query.append(" AND C.OID_PARA_GRAL = " + DTOE.getOid());
            }
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        if ((rs != null) && !rs.esVacio()) {
            /*codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(codigoError));*/
            dtos = new DTOCursosExigidosPremiacion();

            DTOCursoExigidoPremiacion dto = null;
            ArrayList al = new ArrayList();
            Object o = null;

            for (int i = 0; i < rs.getRowCount(); i++) {
                dto = new DTOCursoExigidoPremiacion();
                dto.setOidCursoExigido(((o = rs.getValueAt(i, "OIDCURSOEXIGIDO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- OIDCURSOEXIGIDO
                dto.setOidTipoCurso(((o = rs.getValueAt(i, "OIDTIPOCURSO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //Long -- OIDTIPOCURSO
                dto.setTipoCurso(((o = rs.getValueAt(i, "TIPOCURSO")) != null) ? o.toString() : ""); //String -- TIPOCURSO
                al.add(dto);
            }

            dtos.setLstCursosExigidosPremiacion(al);
        }

        UtilidadesLog.info("DAOConcurso.obtenerCursosExigidosPremiacion(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Cristian Valenzuela 22/07/2005
     * @incidencia 21383 - retornar las descripciones
     * @autor gdmarzi
     */
    public DTOProductosExigidosPremiacion obtenerProductosExigidosPremiacion(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerProductosExigidosPremiacion(DTOOID DTOE): Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOProductosExigidosPremiacion dtos = null;

        query.append(" SELECT ");
        query.append("  A.OID_PROD_EXIG_PREM OID, ");
        query.append("  A.PROD_OID_PROD OIDCODIGOPRODUCTO,  ");
        query.append("  D.COD_SAP CODIGOPRODUCTO,  ");
        query.append("  A.GENE_OID_GENE OIDGENERICO,  ");
        query.append("  ( SELECT VAL_I18N ");
        query.append("    FROM V_GEN_I18N_SICC ");
        query.append("    WHERE ATTR_ENTI = 'MAE_GENER' AND VAL_OID = A.GENE_OID_GENE AND IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append("  ) GENERICO , ");
        query.append("  A.MAPR_OID_MARC_PROD OIDMARCA,  ");
        query.append("  I.DES_MARC_PROD MARCA,  ");
        query.append("  A.NEGO_OID_NEGO OIDNEGOCIO,  ");
        query.append("  ( SELECT VAL_I18N ");
        query.append("    FROM V_GEN_I18N_SICC ");
        query.append("    WHERE ATTR_ENTI = 'MAE_NEGOC' AND VAL_OID = A.NEGO_OID_NEGO AND IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append("  ) NEGO , ");
        query.append("  A.SGEN_OID_SUPE_GENE OIDSUPERGENERICO,  ");
        query.append("  ( SELECT VAL_I18N ");
        query.append("    FROM V_GEN_I18N_SICC ");
        query.append("    WHERE ATTR_ENTI = 'MAE_SUPER_GENER' AND VAL_OID = A.SGEN_OID_SUPE_GENE AND IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append("  ) SUPERGENERICO , ");
        query.append("  A.UNEG_OID_UNID_NEGO OIDUNIDADNEGO,  ");
        query.append("  ( SELECT VAL_I18N ");
        query.append("    FROM V_GEN_I18N_SICC ");
        query.append("    WHERE ATTR_ENTI = 'MAE_UNIDA_NEGOC' AND VAL_OID = A.UNEG_OID_UNID_NEGO AND IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append("  ) UNIDADNEGOCIO ");
        query.append(" FROM ");
        query.append("  INC_PRODU_EXIGI_PREMI A, ");
        query.append("  INC_REQUI_PREMI B,  ");
        query.append("  INC_CONCU_PARAM_GENER C,  ");
        query.append("  MAE_PRODU D,  ");
        query.append("  SEG_MARCA_PRODU I  ");
        query.append(" WHERE ");
        query.append("  A.REPR_OID_REQU_PREM = B.OID_REQU_PREM  ");
        query.append("  AND B.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL  ");
        query.append("  AND D.OID_PROD (+)= A.PROD_OID_PROD ");
        query.append("  AND A.MAPR_OID_MARC_PROD = I.OID_MARC_PROD  ");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND C.OID_PARA_GRAL = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        if ((rs != null) && !rs.esVacio()) {
            dtos = new DTOProductosExigidosPremiacion();

            DTOProductoExigidoPremiacion dto = null;
            Object o = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dto = new DTOProductoExigidoPremiacion();

                //OIDPRODEXIGIDO
                dto.setOidProductoExigido(((o = rs.getValueAt(i, "OID")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //OIDMARCA
                dto.setOidMarca(((o = rs.getValueAt(i, "OIDMARCA")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //MARCA
                dto.setMarca(((o = rs.getValueAt(i, "MARCA")) != null) ? o.toString() : "");

                //OIDUNIDADNEGO
                dto.setOidUnidadNegocio(((o = rs.getValueAt(i, "OIDUNIDADNEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //UNIDADNEGOCIO
                dto.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDADNEGOCIO")) != null) ? o.toString() : "");

                //OIDNEGOCIO
                dto.setOidNegocio(((o = rs.getValueAt(i, "OIDNEGOCIO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //NEGO
                dto.setNegocio(((o = rs.getValueAt(i, "NEGO")) != null) ? o.toString() : "");

                //OIDSUPERGENERICO
                dto.setOidSuperGenerico(((o = rs.getValueAt(i, "OIDSUPERGENERICO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //SUPERGENERICO
                dto.setSuperGenerico(((o = rs.getValueAt(i, "SUPERGENERICO")) != null) ? o.toString() : "");

                //OIDGENERICO
                dto.setOidGenerico(((o = rs.getValueAt(i, "OIDGENERICO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //GENERICO
                dto.setGenerico(((o = rs.getValueAt(i, "GENERICO")) != null) ? o.toString() : "");

                //OIDCODIGOPRODUCTO
                dto.setOidCodigoProducto(((o = rs.getValueAt(i, "OIDCODIGOPRODUCTO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

                //CODIGOPRODUCTO
                dto.setCodigoProducto(((o = rs.getValueAt(i, "CODIGOPRODUCTO")) != null) ? o.toString() : "");

                al.add(dto);
            }

            dtos.setLstProductosExigidosPremiacion(al);
        }

        UtilidadesLog.info("DAOConcurso.obtenerProductosExigidosPremiacion(DTOOID DTOE): Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 25/04/2005
     *         Marcelo J. Maidana -- 27/05/2005 -- Modificado de acuerdo a inc. 17158.
     */
    public DTODespachoPremios obtenerDespachoPremios(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerDespachoPremios(DTOOID DTOE): Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTODespachoPremios dto = null;

        query.append(" SELECT A.OID_DESP_PREM OID, A.IND_COMU_DESP_AUTO, A.IND_COMU_DESP_MANU, B.COD_MENS COD_MENS_1, C.COD_MENS COD_MENS_2, nvl(b.pais_oid_pais, c.pais_oid_pais) PAIS_OID_PAIS ");
        query.append(" FROM INC_DESPA_PREMI A, MSG_MENSA B, MSG_MENSA C, INC_CONCU_PARAM_GENER D ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = D.OID_PARA_GRAL ");
        query.append(" AND A.MENS_OID_MENS_AUTO = B.OID_MENS(+) ");
        query.append(" AND A.MENS_OID_MENS_MANU = C.OID_MENS(+)");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND D.OID_PARA_GRAL = " + DTOE.getOid());
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        if ((rs != null) && !rs.esVacio()) {
            dto = new DTODespachoPremios();

            Long oid = new Long(((BigDecimal) (rs.getValueAt(0, "OID"))).longValue());
            Long pais = null;

            if (rs.getValueAt(0, "PAIS_OID_PAIS") != null) {
                pais = new Long(((BigDecimal) (rs.getValueAt(0, "PAIS_OID_PAIS"))).longValue());
            }

            BigDecimal indComuDespAuto = (BigDecimal) rs.getValueAt(0, "IND_COMU_DESP_AUTO");
            BigDecimal indComuDespManu = (BigDecimal) rs.getValueAt(0, "IND_COMU_DESP_MANU");
            String codMens1 = (String) rs.getValueAt(0, "COD_MENS_1");
            String codMens2 = (String) rs.getValueAt(0, "COD_MENS_2");

            dto.setOidDespachoPremios(oid);

            if ((indComuDespAuto != null) && (indComuDespAuto.intValue() == 1)) {
                dto.setIndComunicacionProcesoAutomatico(Boolean.TRUE);
            } else {
                dto.setIndComunicacionProcesoAutomatico(Boolean.FALSE);
            }

            if ((indComuDespManu != null) && (indComuDespManu.intValue() == 1)) {
                dto.setIndComunicacionProcesoManual(Boolean.TRUE);
            } else {
                dto.setIndComunicacionProcesoManual(Boolean.FALSE);
            }

            dto.setMensajeDespachoAutomatico(codMens1);
            dto.setOidPais(pais);
            dto.setMensajeDespachoManual(codMens2);
        }

        UtilidadesLog.debug("*** DTO retornado: " + dto);
        UtilidadesLog.info("DAOConcurso.obtenerDespachoPremios(DTOOID DTOE): Salida");

        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     */
    public RecordSet obetenerProductosValidos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obetenerProductosValidos(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append("SELECT A.OID_PROD_VALI, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append("A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, A.PROD_OID_PROD, ");
        query.append("A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, NULL, NULL, ");
        query.append("G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append("G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append("C.COD_SAP, NULL, NULL, NULL, NULL, NULL ");
        query.append("FROM INC_PRODU_VALID A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append("V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append("V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append("WHERE B.OID_MARC_PROD = A.MAPR_OID_MARC_PROD ");
        query.append("AND C.OID_PROD = A.PROD_OID_PROD ");
        query.append("AND G1.ATTR_ENTI LIKE 'MAE_UNIDA_NEGOC' ");
        query.append("AND G1.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append("AND G2.ATTR_ENTI LIKE 'MAE_NEGOC' ");
        query.append("AND G2.VAL_OID = A.NEGO_OID_NEGO ");
        query.append("AND G3.ATTR_ENTI LIKE 'MAE_SUPER_GENER' ");
        query.append("AND G3.VAL_OID = A.SGEN_OID_SUPE_GENE ");
        query.append("AND G4.ATTR_ENTI LIKE 'MAE_GENER' ");
        query.append("AND G4.VAL_OID = A.GENE_OID_GENE ");
        query.append("AND G5.ATTR_ENTI LIKE 'PRE_TIPO_OFERT' ");
        query.append("AND G5.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append("AND G6.ATTR_ENTI LIKE 'PRE_CICLO_VIDA' ");
        query.append("AND G6.VAL_OID = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.PRDU_OID_PROD = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        if ((rs == null) || rs.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obetenerProductosValidos(DTOOID DTOE): Salida");
        return rs;
    }
    
        /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 26/10/2006
     * Comentario: se modifica la consulta por performance
     */
    public RecordSet obtenerProductosExcluidos(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerProductosExcluidos(DTOOID DTOE): Entrada");
       
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID_PROD_EXCL,  ");
        query.append(" A.MAPR_OID_MARC_PROD,  ");
        query.append(" A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO,  ");
        query.append(" A.SGEN_OID_SUPE_GENE,  ");
        query.append(" A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD,  ");
        query.append(" A.TOFE_OID_TIPO_OFER,  ");
        query.append(" A.CIVI_OID_CICL_VIDA, ");
        query.append(" A.PERD_OID_PERI_DESD,  ");
        query.append(" A.PERD_OID_PERI_HAST,  ");
        query.append(" B.DES_MARC_PROD,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " +  DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS UNIDA_NEGOC,   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = A.NEGO_OID_NEGO ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " +  DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS NEGOC,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = A.SGEN_OID_SUPE_GENE  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " +  DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS SUPER_GENER,	     ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = A.GENE_OID_GENE ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " +  DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS GENER,	  	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " +  DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS TIPO_OFERT, 		    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = A.CIVI_OID_CICL_VIDA ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1             ");
        query.append(" ) AS CICLO_VIDA,	   	    ");
        query.append(" C.COD_SAP,  ");
        query.append(" D.VAL_NOMB_PERI DESC_PERI_DESD, ");
        query.append(" E.VAL_NOMB_PERI DESC_PERI_HAST,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL ");
        query.append(" FROM INC_PRODU_EXCLU A, ");
        query.append(" SEG_MARCA_PRODU B, ");
        query.append(" MAE_PRODU C, ");
        query.append(" CRA_PERIO D, ");
        query.append(" CRA_PERIO E,	    ");
        query.append(" MAE_UNIDA_NEGOC F, ");
        query.append(" MAE_NEGOC G, ");
        query.append(" MAE_SUPER_GENER H, ");
        query.append(" MAE_GENER I,      ");
        query.append(" PRE_TIPO_OFERT J,    ");
        query.append(" PRE_CICLO_VIDA K    ");
        query.append(" WHERE A.PRDU_OID_PROD = " + DTOE.getOid());
        query.append(" AND B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST    ");
        query.append(" AND F.OID_UNID_NEGO(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G.OID_NEGO(+) = A.NEGO_OID_NEGO ");
        query.append(" AND H.OID_SUPE_GENE(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND I.OID_GENE(+) = A.GENE_OID_GENE ");
        query.append(" AND J.OID_TIPO_OFER(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND K.OID_CICL_VIDA(+) = A.CIVI_OID_CICL_VIDA ");

        /*query.append(" SELECT A.OID_PROD_EXCL, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD, A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, A.PERD_OID_PERI_DESD, ");
        query.append(" A.PERD_OID_PERI_HAST, B.DES_MARC_PROD, G1.VAL_I18N UNIDA_NEGOC, ");
        query.append(" G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, G4.VAL_I18N GENER, ");
        query.append(" G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, D.VAL_NOMB_PERI DESC_PERI_DESD, E.VAL_NOMB_PERI DESC_PERI_HAST, ");
        query.append(" NULL, NULL, NULL, NULL, NULL ");
        query.append(" FROM INC_PRODU_EXCLU A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" CRA_PERIO D, CRA_PERIO E, ");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append(" WHERE B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC' ");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC' ");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO ");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER' ");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER' ");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE ");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT' ");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA' ");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.PRDU_OID_PROD = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosExcluidos(DTOOID DTOE): Salida");
        return rs;
    }
    
        /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 26/10/2006
     * Comentario: se modifica la consulta por performance
     */
    public RecordSet obtenerProductosBonificados(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerProductosBonificados(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID_PROD_BONI,  ");
        query.append(" A.MAPR_OID_MARC_PROD,  ");
        query.append(" A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO,  ");
        query.append(" A.SGEN_OID_SUPE_GENE,  ");
        query.append(" A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD,  ");
        query.append(" A.TOFE_OID_TIPO_OFER,  ");
        query.append(" A.CIVI_OID_CICL_VIDA, ");
        query.append(" A.PERD_OID_PERI_DESD,  ");
        query.append(" A.PERD_OID_PERI_HAST,  ");
        query.append(" B.DES_MARC_PROD, ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS UNIDA_NEGOC,    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = A.NEGO_OID_NEGO ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS NEGOC,         ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = A.SGEN_OID_SUPE_GENE  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS SUPER_GENER,	   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = A.GENE_OID_GENE ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS GENER,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS TIPO_OFERT, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = A.CIVI_OID_CICL_VIDA ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1             ");
        query.append(" ) AS CICLO_VIDA, ");
        query.append(" C.COD_SAP,  ");
        query.append(" D.VAL_NOMB_PERI DESC_PERI_DESD, ");
        query.append(" E.VAL_NOMB_PERI DESC_PERI_HAST,  ");
        query.append(" A.NUM_PUNT_UNID,  ");
        query.append(" A.VAL_FACT_MULT,  ");
        query.append(" NULL, ");
        query.append(" NULL,  ");
        query.append(" NULL ");
        query.append(" FROM INC_PRODU_BONIF A, ");
        query.append(" SEG_MARCA_PRODU B, ");
        query.append(" MAE_PRODU C, ");
        query.append(" CRA_PERIO D, ");
        query.append(" CRA_PERIO E, ");
        query.append(" MAE_UNIDA_NEGOC F, ");
        query.append(" MAE_NEGOC G, ");
        query.append(" MAE_SUPER_GENER H, ");
        query.append(" MAE_GENER I,      ");
        query.append(" PRE_TIPO_OFERT J,    ");
        query.append(" PRE_CICLO_VIDA K    ");
        query.append(" WHERE A.PRDU_OID_PROD = " + DTOE.getOid());
        query.append(" AND B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST ");
        query.append(" AND F.OID_UNID_NEGO(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G.OID_NEGO(+) = A.NEGO_OID_NEGO ");
        query.append(" AND H.OID_SUPE_GENE(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND I.OID_GENE(+) = A.GENE_OID_GENE ");
        query.append(" AND J.OID_TIPO_OFER(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND K.OID_CICL_VIDA(+) = A.CIVI_OID_CICL_VIDA ");

        /*query.append(" SELECT A.OID_PROD_BONI, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, A.PROD_OID_PROD, ");
        query.append(" A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, A.PERD_OID_PERI_DESD, ");
        query.append(" A.PERD_OID_PERI_HAST, B.DES_MARC_PROD, ");
        query.append(" G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append(" G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, D.VAL_NOMB_PERI DESC_PERI_DESD, E.VAL_NOMB_PERI DESC_PERI_HAST, A.NUM_PUNT_UNID, ");
        query.append(" A.VAL_FACT_MULT, NULL, NULL, NULL  ");
        query.append(" FROM INC_PRODU_BONIF A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" CRA_PERIO D, CRA_PERIO E,");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3,");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6");
        query.append(" WHERE ");
        query.append(" B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC'");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC'");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER'");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER'");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT'");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA'");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.PRDU_OID_PROD = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosBonificados(DTOOID DTOE): Salida");
        return rs;
    }
    
        /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 26/10/2006
     * Comentario: Se modifica la consulta por performance
     */
    public RecordSet obtenerProductosExigidos(DTOOID DTOE)
            throws MareException {
        
        UtilidadesLog.info("DAOConcurso.obtenerProductosExigidos(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID_PROD_EXIG,  ");
        query.append(" A.MAPR_OID_MARC_PROD,  ");
        query.append(" A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO,  ");
        query.append(" A.SGEN_OID_SUPE_GENE,  ");
        query.append(" A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD,  ");
        query.append(" A.TOFE_OID_TIPO_OFER,  ");
        query.append(" A.CIVI_OID_CICL_VIDA, ");
        query.append(" A.PERD_OID_PERI_DESD,  ");
        query.append(" A.PERD_OID_PERI_HAST,  ");
        query.append(" B.DES_MARC_PROD, ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS UNIDA_NEGOC,    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = A.NEGO_OID_NEGO ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS NEGOC,         ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = A.SGEN_OID_SUPE_GENE  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS SUPER_GENER,	   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = A.GENE_OID_GENE ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS GENER,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS TIPO_OFERT, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = A.CIVI_OID_CICL_VIDA ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1     ");        
        query.append(" ) AS CICLO_VIDA, ");
        query.append(" C.COD_SAP,  ");
        query.append(" D.VAL_NOMB_PERI DESC_PERI_DESD, ");
        query.append(" E.VAL_NOMB_PERI DESC_PERI_HAST,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" A.NUM_UNID_EXIG, ");
        query.append(" A.IMP_MONT_EXIG,  ");
        query.append(" A.NUM_PUNT_EXIG, ");
        // vbongiov -- Cambio 20080807 -- 15/04/2009
        query.append(" A.IND_AGRUP ");        
        query.append(" FROM INC_PRODU_EXIGI A, ");
        query.append(" SEG_MARCA_PRODU B, ");
        query.append(" MAE_PRODU C, ");
        query.append(" CRA_PERIO D, ");
        query.append(" CRA_PERIO E, ");
        query.append(" MAE_UNIDA_NEGOC F, ");
        query.append(" MAE_NEGOC G, ");
        query.append(" MAE_SUPER_GENER H, ");
        query.append(" MAE_GENER I,      ");
        query.append(" PRE_TIPO_OFERT J,    ");
        query.append(" PRE_CICLO_VIDA K ");
        query.append(" WHERE A.PRDU_OID_PROD = " + DTOE.getOid());
        query.append(" AND B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST ");
        query.append(" AND F.OID_UNID_NEGO(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G.OID_NEGO(+) = A.NEGO_OID_NEGO ");
        query.append(" AND H.OID_SUPE_GENE(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND I.OID_GENE(+) = A.GENE_OID_GENE ");
        query.append(" AND J.OID_TIPO_OFER(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND K.OID_CICL_VIDA(+) = A.CIVI_OID_CICL_VIDA ");
        
        /*query.append(" SELECT A.OID_PROD_EXIG, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD, A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, ");
        query.append(" A.PERD_OID_PERI_DESD, A.PERD_OID_PERI_HAST, B.DES_MARC_PROD, ");
        query.append(" G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append(" G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, D.VAL_NOMB_PERI DESC_PERI_DESD, E.VAL_NOMB_PERI DESC_PERI_HAST, ");
        query.append(" NULL, NULL, A.NUM_UNID_EXIG, A.IMP_MONT_EXIG, A.NUM_PUNT_EXIG ");
        query.append(" FROM INC_PRODU_EXIGI A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" CRA_PERIO D, CRA_PERIO E, ");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append(" WHERE B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI_DESD ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HAST ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC' ");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC' ");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO ");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER' ");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER' ");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE ");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT' ");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA' ");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.PRDU_OID_PROD = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosExigidos(DTOOID DTOE): Salida");
        return rs;
    }
    
        /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 26/10/2006
     * Comentario: Se modifica la consulta por performance
     */
    public RecordSet obtenerProductosACalificar(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerProductosACalificar(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID_PROD_CALI,  ");
        query.append(" A.MAPR_OID_MARC_PROD,  ");
        query.append(" A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO,  ");
        query.append(" A.SGEN_OID_SUPE_GENE,  ");
        query.append(" A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD,  ");
        query.append(" A.TOFE_OID_TIPO_OFER,  ");
        query.append(" A.CIVI_OID_CICL_VIDA,  ");
        query.append(" NULL, ");
        query.append(" NULL,  ");
        query.append(" B.DES_MARC_PROD, ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS UNIDA_NEGOC,    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = A.NEGO_OID_NEGO ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS NEGOC,         ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = A.SGEN_OID_SUPE_GENE  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS SUPER_GENER,	   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = A.GENE_OID_GENE ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS GENER,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS TIPO_OFERT, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = A.CIVI_OID_CICL_VIDA ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1             ");
        query.append(" ) AS CICLO_VIDA, ");
        query.append(" C.COD_SAP,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL ");
        query.append(" FROM INC_PRODU_CALIF A, ");
        query.append(" SEG_MARCA_PRODU B, ");
        query.append(" MAE_PRODU C, ");
        query.append(" MAE_UNIDA_NEGOC D, ");
        query.append(" MAE_NEGOC E, ");
        query.append(" MAE_SUPER_GENER F, ");
        query.append(" MAE_GENER G,      ");
        query.append(" PRE_TIPO_OFERT H,    ");
        query.append(" PRE_CICLO_VIDA I ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        query.append(" AND B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD    ");
        query.append(" AND D.OID_UNID_NEGO(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND E.OID_NEGO(+) = A.NEGO_OID_NEGO ");
        query.append(" AND F.OID_SUPE_GENE(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G.OID_GENE(+) = A.GENE_OID_GENE ");
        query.append(" AND H.OID_TIPO_OFER(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND I.OID_CICL_VIDA(+) = A.CIVI_OID_CICL_VIDA ");

        /*query.append(" SELECT A.OID_PROD_CALI, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD, A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, ");
        query.append(" NULL, NULL, B.DES_MARC_PROD, ");
        query.append(" G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append(" G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, NULL, NULL, NULL, NULL, NULL ");
        query.append(" FROM INC_PRODU_CALIF A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append(" WHERE B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC' ");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC' ");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO ");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER' ");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER' ");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE ");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT' ");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA' ");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosACalificar(DTOOID DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 26/04/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 26/10/2006
     * Comentario: Se modifica la consulta por performance
     */
    public RecordSet obtenerProductosExcluidosCalificacion(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerProductosExcluidosCalificacion(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT A.OID_PROD_EXCL_CALI,  ");
        query.append(" A.MAPR_OID_MARC_PROD,  ");
        query.append(" A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO,  ");
        query.append(" A.SGEN_OID_SUPE_GENE,  ");
        query.append(" A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD,  ");
        query.append(" A.TOFE_OID_TIPO_OFER,  ");
        query.append(" A.CIVI_OID_CICL_VIDA, ");
        query.append(" A.PERD_OID_PERI,  ");
        query.append(" A.PERD_OID_PERI_HASTA,  ");
        query.append(" B.DES_MARC_PROD, ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS UNIDA_NEGOC,    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = A.NEGO_OID_NEGO ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS NEGOC,         ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = A.SGEN_OID_SUPE_GENE  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS SUPER_GENER,	   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = A.GENE_OID_GENE ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS GENER,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS TIPO_OFERT, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = A.CIVI_OID_CICL_VIDA ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1             ");
        query.append(" ) AS CICLO_VIDA, ");
        query.append(" C.COD_SAP,  ");
        query.append(" D.VAL_NOMB_PERI DESC_PERI_DESD, ");
        query.append(" E.VAL_NOMB_PERI DESC_PERI_HAST,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL ");
        query.append(" FROM INC_PRODU_EXCLU_CALIF A, ");
        query.append(" SEG_MARCA_PRODU B, ");
        query.append(" MAE_PRODU C, ");
        query.append(" CRA_PERIO D, ");
        query.append(" CRA_PERIO E, ");
        query.append(" MAE_UNIDA_NEGOC F, ");
        query.append(" MAE_NEGOC G, ");
        query.append(" MAE_SUPER_GENER H, ");
        query.append(" MAE_GENER I,      ");
        query.append(" PRE_TIPO_OFERT J,    ");
        query.append(" PRE_CICLO_VIDA K ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        query.append(" AND B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HASTA ");
        query.append(" AND F.OID_UNID_NEGO(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G.OID_NEGO(+) = A.NEGO_OID_NEGO ");
        query.append(" AND H.OID_SUPE_GENE(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND I.OID_GENE(+) = A.GENE_OID_GENE ");
        query.append(" AND J.OID_TIPO_OFER(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND K.OID_CICL_VIDA(+) = A.CIVI_OID_CICL_VIDA ");

        /*query.append(" SELECT A.OID_PROD_EXCL_CALI, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, A.PROD_OID_PROD, ");
        query.append(" A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, A.PERD_OID_PERI, ");
        query.append(" A.PERD_OID_PERI_HASTA, B.DES_MARC_PROD, ");
        query.append(" G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append(" G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, D.VAL_NOMB_PERI DESC_PERI_DESD, E.VAL_NOMB_PERI DESC_PERI_HAST, ");
        query.append(" NULL, NULL, NULL, NULL, NULL ");
        query.append(" FROM INC_PRODU_EXCLU_CALIF A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" CRA_PERIO D, CRA_PERIO E, ");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append(" WHERE B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND D.OID_PERI(+) = A.PERD_OID_PERI ");
        query.append(" AND E.OID_PERI(+) = A.PERD_OID_PERI_HASTA ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC' ");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC' ");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO ");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER' ");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER' ");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE ");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT' ");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA' ");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOid() != null) {
                query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
            }

            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosExcluidosCalificacion(DTOOID DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public RecordSet obtenerMaximoNumeroPremio(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMaximoNumeroPremio(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT MAX(PREMIO) ");
        query.append(" FROM( ");
        query.append(" SELECT D.NUM_PREM AS PREMIO ");
        query.append(" FROM INC_PARAM_GENER_PREMI A, ");
        query.append(" INC_PARAM_NIVEL_PREMI B, ");
        query.append(" INC_PREMI_ARTIC C, ");
        query.append(" INC_LOTE_PREMI_ARTIC D ");

        query.append(" WHERE B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        }

        query.append(" AND C.PANP_OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        query.append(" AND D.PRAR_OID_PREM_ARTI = C.OID_PREM_ARTI ");
        query.append(" UNION ");
        query.append(" SELECT F.NUM_PREM AS PREMIO ");
        query.append(" FROM INC_PARAM_GENER_PREMI A, ");
        query.append(" INC_PARAM_NIVEL_PREMI B, ");
        query.append(" INC_PREMI_PUNTO F ");

        query.append(" WHERE B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        }

        query.append(" AND F.PANP_OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        query.append(" UNION ");
        query.append(" SELECT G.NUM_PREM AS PREMIO ");
        query.append(" FROM INC_PARAM_GENER_PREMI A, ");
        query.append(" INC_PARAM_NIVEL_PREMI B, ");
        query.append(" INC_PREMI_MONET G ");

        query.append(" WHERE B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        }

        query.append(" AND G.PANP_OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        query.append(" UNION ");
        query.append(" SELECT H.NUM_PREM AS PREMIO ");
        query.append(" FROM INC_PARAM_GENER_PREMI A, ");
        query.append(" INC_PARAM_NIVEL_PREMI B, ");
        query.append(" INC_PREMI_DESCU H ");

        query.append(" WHERE B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM");

        if ((DTOE != null) && (DTOE.getOid() != null)) {
            query.append(" AND A.COPA_OID_PARA_GRAL = " + DTOE.getOid());
        }

        query.append(" AND H.OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        query.append(" ) NUMERO_PREMIO");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        if ((rs == null) || rs.esVacio()) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerMaximoNumeroPremio(DTOOID DTOE): Salida");
        return rs;
    }
    
        /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     * Modificado por: Cristian Valenzuela
     * Incidencia: DBLG500000773
     * Comentario: Se modifica la consulta por performance
     */
    public RecordSet obtenerProductosValidos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerProductosValidos(DTOOID DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT a.oid_prod_vali,  ");
        query.append(" a.mapr_oid_marc_prod,  ");
        query.append(" a.uneg_oid_unid_nego, ");
        query.append(" a.nego_oid_nego,  ");
        query.append(" a.sgen_oid_supe_gene,  ");
        query.append(" a.gene_oid_gene, ");
        query.append(" a.prod_oid_prod,  ");
        query.append(" a.tofe_oid_tipo_ofer,  ");
        query.append(" a.civi_oid_cicl_vida,  ");
        query.append(" NULL, ");
        query.append(" NULL,  ");
        query.append(" b.des_marc_prod, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V5  ");
        query.append(" WHERE V5.VAL_OID = a.uneg_oid_unid_nego ");
        query.append(" AND V5.ATTR_ENTI = 'MAE_UNIDA_NEGOC'   ");
        query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V5.ATTR_NUM_ATRI = 1     ");
        query.append(" ) AS unida_negoc,    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V6  ");
        query.append(" WHERE V6.VAL_OID = a.nego_oid_nego ");
        query.append(" AND V6.ATTR_ENTI = 'MAE_NEGOC'  ");
        query.append(" AND V6.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V6.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS negoc,         ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V7  ");
        query.append(" WHERE V7.VAL_OID = a.sgen_oid_supe_gene  ");
        query.append(" AND V7.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
        query.append(" AND V7.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V7.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS super_gener,	   	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V8  ");
        query.append(" WHERE  V8.VAL_OID = a.gene_oid_gene ");
        query.append(" AND V8.ATTR_ENTI = 'MAE_GENER'  ");
        query.append(" AND V8.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V8.ATTR_NUM_ATRI = 1  ");
        query.append(" ) AS gener,	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V3  ");
        query.append(" WHERE V3.VAL_OID = a.tofe_oid_tipo_ofer ");
        query.append(" AND V3.ATTR_ENTI = 'PRE_TIPO_OFERT'  ");
        query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1  ");
        query.append(" )AS tipo_ofert, 	    ");
        query.append(" (SELECT VAL_I18N  ");
        query.append(" FROM V_GEN_I18N_SICC V4  ");
        query.append(" WHERE V4.VAL_OID = a.civi_oid_cicl_vida ");
        query.append(" AND V4.ATTR_ENTI = 'PRE_CICLO_VIDA'   ");
        query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1             ");
        query.append(" ) AS ciclo_vida,	    ");
        query.append(" c.cod_sap,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL,  ");
        query.append(" NULL ");
        query.append(" FROM inc_produ_valid a, ");
        query.append(" seg_marca_produ b, ");
        query.append(" mae_produ c,	    ");
        query.append(" MAE_UNIDA_NEGOC d, ");
        query.append(" MAE_NEGOC e, ");
        query.append(" MAE_SUPER_GENER f, ");
        query.append(" MAE_GENER g,      ");
        query.append(" PRE_TIPO_OFERT h,    ");
        query.append(" PRE_CICLO_VIDA i ");
        query.append(" WHERE a.prdu_oid_prod = " + DTOE.getOid());
        query.append(" AND b.oid_marc_prod(+) = a.mapr_oid_marc_prod ");
        query.append(" AND c.oid_prod(+) = a.prod_oid_prod    ");
        query.append(" AND d.oid_unid_nego(+) = a.uneg_oid_unid_nego ");
        query.append(" AND h.oid_tipo_ofer(+) = a.tofe_oid_tipo_ofer ");
        query.append(" AND i.OID_CICL_VIDA(+) = a.civi_oid_cicl_vida ");
        query.append(" AND e.oid_nego(+) = a.nego_oid_nego ");
        query.append(" AND f.oid_supe_gene(+) = a.sgen_oid_supe_gene ");
        query.append(" AND g.oid_gene(+) = a.gene_oid_gene ");

        /*query.append(" SELECT A.OID_PROD_VALI, A.MAPR_OID_MARC_PROD, A.UNEG_OID_UNID_NEGO, ");
        query.append(" A.NEGO_OID_NEGO, A.SGEN_OID_SUPE_GENE, A.GENE_OID_GENE, ");
        query.append(" A.PROD_OID_PROD, A.TOFE_OID_TIPO_OFER, A.CIVI_OID_CICL_VIDA, ");
        query.append(" NULL, NULL, B.DES_MARC_PROD, ");
        query.append(" G1.VAL_I18N UNIDA_NEGOC, G2.VAL_I18N NEGOC, G3.VAL_I18N SUPER_GENER, ");
        query.append(" G4.VAL_I18N GENER, G5.VAL_I18N TIPO_OFERT, G6.VAL_I18N CICLO_VIDA, ");
        query.append(" C.COD_SAP, NULL, NULL, NULL, NULL, NULL ");
        query.append(" FROM INC_PRODU_VALID A, SEG_MARCA_PRODU B, MAE_PRODU C, ");
        query.append(" V_GEN_I18N_SICC G1, V_GEN_I18N_SICC G2, V_GEN_I18N_SICC G3, ");
        query.append(" V_GEN_I18N_SICC G4, V_GEN_I18N_SICC G5, V_GEN_I18N_SICC G6 ");
        query.append(" WHERE B.OID_MARC_PROD(+) = A.MAPR_OID_MARC_PROD ");
        query.append(" AND C.OID_PROD(+) = A.PROD_OID_PROD ");
        query.append(" AND G1.ATTR_ENTI(+) LIKE 'MAE_UNIDA_NEGOC' ");
        query.append(" AND G1.VAL_OID(+) = A.UNEG_OID_UNID_NEGO ");
        query.append(" AND G2.ATTR_ENTI(+) LIKE 'MAE_NEGOC' ");
        query.append(" AND G2.VAL_OID(+) = A.NEGO_OID_NEGO ");
        query.append(" AND G3.ATTR_ENTI(+) LIKE 'MAE_SUPER_GENER' ");
        query.append(" AND G3.VAL_OID(+) = A.SGEN_OID_SUPE_GENE ");
        query.append(" AND G4.ATTR_ENTI(+) LIKE 'MAE_GENER' ");
        query.append(" AND G4.VAL_OID(+) = A.GENE_OID_GENE ");
        query.append(" AND G5.ATTR_ENTI(+) LIKE 'PRE_TIPO_OFERT' ");
        query.append(" AND G5.VAL_OID(+) = A.TOFE_OID_TIPO_OFER ");
        query.append(" AND G6.ATTR_ENTI(+) LIKE 'PRE_CICLO_VIDA' ");
        query.append(" AND G6.VAL_OID(+) = A.CIVI_OID_CICL_VIDA");

        if (DTOE != null) {
            if (DTOE.getOidIdioma() != null) {
                query.append(" AND G1.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G2.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G3.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G4.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G5.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
                query.append(" AND G6.IDIO_OID_IDIO(+) = " + DTOE.getOidIdioma());
            }

            if (DTOE.getOid() != null) {
                query.append(" AND A.PRDU_OID_PROD = " + DTOE.getOid());
            }
        }*/

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerProductosValidos(DTOOID DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public RecordSet obtenerIncrementosPorRango(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerIncrementosPorRango(Long oidConcurso): Entrada");
        
        BelcorpService bs;
        RecordSet rs = new RecordSet();
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT OID_RANG, VAL_DESD, VAL_HAST, VAL_INCR ");
        query.append(" FROM INC_RANGO ");
        query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        
        UtilidadesLog.info("DAOConcurso.obtenerIncrementosPorRango(Long oidConcurso): Salida");
        return rs;
    }

    /**
     * @author: ssantana, 03/05/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param DTOTipoProducto DTOE
     */
    public RecordSet obtenerTiposProducto(DTOTipoProducto DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerTiposProducto(DTOTipoProducto DTOE): Entrada");

        StringBuffer query = new StringBuffer("");
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();

        query.append(" SELECT inc_tipo_produ.oid_tipo_prod, v_gen_i18n_sicc.val_i18n ");
        query.append(" FROM inc_tipo_produ, v_gen_i18n_sicc ");
        query.append(" WHERE inc_tipo_produ.ind_prod = " + DTOE.getIndGrupoProducto());
        query.append(" AND v_gen_i18n_sicc.val_oid = inc_tipo_produ.oid_tipo_prod ");
        query.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        query.append(" AND v_gen_i18n_sicc.attr_enti = 'INC_TIPO_PRODU' ");
        query.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + DTOE.getOidIdioma());
        query.append(" ORDER BY 1 ");

        try {
            r = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.debug("R: " + r);
        UtilidadesLog.info("DAOConcurso.obtenerTiposProducto(DTOTipoProducto DTOE): Salida");
        return r;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public RecordSet obtenerTiposVentaIncremental(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerTiposVentaIncremental(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT TV.OID_TIPO_VENT_INCR, G.VAL_I18N ");
        query.append(" FROM INC_TIPO_VENTA_INCRE TV, V_GEN_I18N_SICC G ");
        query.append(" WHERE TV.OID_TIPO_VENT_INCR = G.VAL_OID");
        query.append(" AND G.ATTR_ENTI LIKE 'INC_TIPO_VENTA_INCRE'");

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        }

        query.append(" ORDER BY G.VAL_I18N ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerTiposVentaIncremental(DTOBelcorp DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public RecordSet obtenerTiposDeterminacionMetas(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("DAOConcurso.obtenerTiposDeterminacionMetas(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT TV.OID_TIPO_DETE_META, G.VAL_I18N ");
        query.append(" FROM INC_TIPO_DETER_METAS TV, V_GEN_I18N_SICC G ");
        query.append(" WHERE TV.OID_TIPO_DETE_META = G.VAL_OID");
        query.append(" AND G.ATTR_ENTI LIKE 'INC_TIPO_DETER_METAS'");

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        }

        query.append(" ORDER BY G.VAL_I18N ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerTiposDeterminacionMetas(DTOBelcorp DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public RecordSet obtenerFormaCalculoMetas(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerFormaCalculoMetas(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT TV.OID_FORM_CALC_META, G.VAL_I18N ");
        query.append(" FROM INC_FORMA_CALCU_METAS TV, V_GEN_I18N_SICC G ");
        query.append(" WHERE TV.OID_FORM_CALC_META = G.VAL_OID");
        query.append(" AND G.ATTR_ENTI LIKE 'INC_FORMA_CALCU_METAS'");

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        }

        query.append(" ORDER BY G.VAL_I18N ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerFormaCalculoMetas(DTOBelcorp DTOE): Salida");
        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public RecordSet obtenerTiposIncremento(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTiposIncremento(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT TV.OID_TIPO_INCR, G.VAL_I18N ");
        query.append(" FROM INC_TIPO_INCRE TV, V_GEN_I18N_SICC G ");
        query.append(" WHERE TV.OID_TIPO_INCR = G.VAL_OID");
        query.append(" AND G.ATTR_ENTI LIKE 'INC_TIPO_INCRE'");

        if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
            query.append(" AND G.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        }

        query.append(" ORDER BY G.VAL_I18N ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        
        UtilidadesLog.info("DAOConcurso.obtenerTiposIncremento(DTOBelcorp DTOE): Salida");
        return rs;
    }

    public RecordSet obtenerFormaCalculo(DTOBelcorp dtoE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerFormaCalculo(DTOBelcorp dtoE): Entrada");
        //Obtener los campos: 
        //oidFormaCalculo 
        //descripcion (internacionalizable) 
        //de la entidad INC:FormaCalculo
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT A.OID_FORM_CALC, B.VAL_I18N ");
        query.append(" FROM INC_FORMA_CALCU A, V_GEN_I18N_SICC B ");
        query.append(" WHERE ");
        query.append(" B.ATTR_ENTI = 'INC_FORMA_CALCU' ");
        query.append(" AND B.ATTR_NUM_ATRI = 1 ");
        query.append(" AND B.VAL_OID = A.OID_FORM_CALC ");
        query.append(" AND B.IDIO_OID_IDIO = " + dtoE.getOidIdioma());

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerFormaCalculo(DTOBelcorp dtoE): Salida");
        return rs;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Paola Cabrera -- 10/05/2005
      */
    public RecordSet obtenerCalculoPremio(DTOBelcorp dtoE)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerCalculoPremio(DTOBelcorp dtoE): Entrada");
        //Obtener los campos: 
        //oidCalculoPremio  
        //descripcion (internacionalizable) 
        //oidCalculoPremio 
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT ic.oid_calc_prem, i1.val_i18n ");
            query.append(" FROM v_gen_i18n_sicc i1, inc_calcu_premi ic ");
            query.append(" WHERE i1.attr_enti = 'INC_CALCU_PREMI' ");
            query.append(" AND i1.attr_num_atri = 1 ");
            query.append(" AND i1.val_oid = ic.oid_calc_prem ");
            query.append(" AND i1.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
            query.append(" ORDER BY i1.val_i18n ");

            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("DAOConcurso.obtenerCalculoPremio(DTOBelcorp dtoE): Salida");
        return rs;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       12/05/2005
          * @version     1.0
          * @autor       Viviana Bongiovanni
          */
    public DTOSalida obtenerTipoEleccion(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoEleccion(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT elecc.OID_TIPO_ELEC, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_ELECC elecc, v_gen_i18n_sicc i18n ");
        query.append(" WHERE elecc.OID_TIPO_ELEC = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_ELECC' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerTipoEleccion(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       12/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremiacion(DTOBoolean dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremiacion(DTOBoolean dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT prem.OID_TIPO_PION, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_PCION prem, v_gen_i18n_sicc i18n ");
        query.append(" WHERE prem.OID_TIPO_PION = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_PCION' ");
        
        if(dtoe.getValor()){
            query.append(" AND prem.OID_TIPO_PION = "+ ConstantesINC.OID_TIPO_PREMIACION_SORTEO);
        } else {
            query.append(" AND prem.OID_TIPO_PION != "+ ConstantesINC.OID_TIPO_PREMIACION_SORTEO);
        }
        
        
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremiacion(DTOBoolean dtoe): Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       12/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremio(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremio(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT prem.OID_TIPO_PREM, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_PREMI prem, v_gen_i18n_sicc i18n ");
        query.append(" WHERE prem.OID_TIPO_PREM = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremio(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       17/05/2005
          * @version     1.0
          * @autor       Carlos Leal
          * Modificado:  Cristian Valenzuela 23/8/2005
          */
    public DTOVariablesVenta obtenerVariablesVenta(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerVariablesVenta(DTOOID dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOVariablesVenta dTOVariablesVenta = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT A.OID_CONC_VARI_VENT_GERE OID, ");
        query.append(" A.IND_ACVA ACTIVAS, ");
        query.append(" A.IND_INGR INGRESO, ");
        query.append(" A.IND_REIN REINGRESO, ");
        query.append(" A.IND_EGRE EGRESOS, ");
        query.append(" A.IND_ENTR ENTREGADAS, ");
        query.append(" A.IND_RECI RECIBIDAS, ");
        query.append(" A.IND_CAPI CAPITALIZACION, ");
        query.append(" A.IND_ACTI_FINA ACTIVASFINALES, ");
        query.append(" A.IND_ADAD ACTIVIDAD, ");
        query.append(" A.IND_NUME_PEDI NUMEROPEDIDOS, ");
        query.append(" A.IND_PREC_PROM_UNIT PRECIOPROMEDIOUNITARIO, ");
        query.append(" A.IND_PROM_VENT_PEDI PROMEDIOVENTAPEDIDO, ");
        query.append(" A.IND_PROM_UNID_PEDI PROMEDIOUNIDADESPEDIDO, ");
        query.append(" A.IND_PROM_ORDE_PEDI PROMEDIOORDENESPEDIDO, ");
        query.append(" A.IND_RETE RETENCION, ");
        query.append(" A.IND_VENT_ESTA VENTAESTADISTICABLE ");
        query.append(" FROM INC_CONCU_VARIA_VENTA_GEREN A, ");
        query.append(" INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE   A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL   and ");
        query.append(" B.OID_PARA_GRAL = " + dtoe.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        // **********************************************************************************
        // Agregado por ssantana - 3/6/2005 
        // - Chequea si el RecordSet devuelto en la consulta anterior es vacío, 
        //   por las dudas.
        // **********************************************************************************
        if ((rs != null) && !rs.esVacio()) {
            dTOVariablesVenta = new DTOVariablesVenta();

            //   dtos.oid = oid 
            dTOVariablesVenta.setOid(new Long(((BigDecimal) (rs.getValueAt(0, "OID"))).longValue()));

            //   dtos.indActivas = activas 
            Boolean activasNoNula = null;
            BigDecimal activas = (BigDecimal) rs.getValueAt(0, "ACTIVAS");
            if (activas != null) {
                activasNoNula = ((activas.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndActivas(activasNoNula);

            //   dtos.indIngreso = ingreso 
            Boolean ingresoNoNulo = null;
            BigDecimal ingreso = (BigDecimal) rs.getValueAt(0, "INGRESO");
            if (ingreso != null) {
                ingresoNoNulo = ((ingreso.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndIngreso(ingresoNoNulo);

            //   dtos.indReingreso = reingreso 
            Boolean reingresoNoNulo = null;
            BigDecimal reingreso = (BigDecimal) rs.getValueAt(0, "REINGRESO");
            if (reingreso != null) {
                reingresoNoNulo = ((reingreso.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndReingreso(reingresoNoNulo);

            //   dtos.indEgresos = egresos 
            Boolean egresosNoNulo = null;
            BigDecimal egresos = (BigDecimal) rs.getValueAt(0, "EGRESOS");
            if (egresos != null) {
                egresosNoNulo = ((egresos.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndEgresos(egresosNoNulo);

            //   dtos.indEntregadas = entregadas 
            Boolean entregadasNoNula = null;
            BigDecimal entregadas = (BigDecimal) rs.getValueAt(0, "ENTREGADAS");
            if (entregadas != null) {
                entregadasNoNula = ((entregadas.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndEntregadas(entregadasNoNula);

            //   dtos.indRecibidas = recibidas 
            Boolean recibidasNoNula = null;
            BigDecimal recibidas = (BigDecimal) rs.getValueAt(0, "RECIBIDAS");
            if (recibidas != null) {
                recibidasNoNula = ((recibidas.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndRecibidas(recibidasNoNula);

            //   dtos.indCapitalizacion = capitalizacion 
            Boolean capitalizacionNoNula = null;
            BigDecimal capitalizacion = (BigDecimal) rs.getValueAt(0, "CAPITALIZACION");
            if (capitalizacion != null) {
                capitalizacionNoNula = ((capitalizacion.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndCapitalizacion(capitalizacionNoNula);

            //   dtos.indActivasFinales = activasFinales 
            Boolean activasFinalesNoNula = null;
            BigDecimal activasFinales = (BigDecimal) rs.getValueAt(0, "ACTIVASFINALES");
            if (activasFinales != null) {
                activasFinalesNoNula = ((activasFinales.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }
            dTOVariablesVenta.setIndActivasFinales(activasFinalesNoNula);

            //   dtos.indActividad = actividad 
            Boolean actividadNoNula = null;
            BigDecimal actividad = (BigDecimal) rs.getValueAt(0, "ACTIVIDAD");

            if (actividad != null) {
                actividadNoNula = ((actividad.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndActividad(actividadNoNula);

            //   dtos.indNumeroPedidos = numeroPedidos 
            Boolean numeroPedidosNoNula = null;
            BigDecimal numeroPedidos = (BigDecimal) rs.getValueAt(0, "NUMEROPEDIDOS");

            if (numeroPedidos != null) {
                numeroPedidosNoNula = ((numeroPedidos.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndNumeroPedidos(numeroPedidosNoNula);

            //   dtos.indPrecioPromedioUnitario = precioPromedioUnitario 
            Boolean precioPromedioUnitarioNoNulo = null;
            BigDecimal precioPromedioUnitario = (BigDecimal) rs.getValueAt(0, "PRECIOPROMEDIOUNITARIO");

            if (precioPromedioUnitario != null) {
                precioPromedioUnitarioNoNulo = ((precioPromedioUnitario.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndPrecioPromedioUnitario(precioPromedioUnitarioNoNulo);

            //   dtos.indPromedioVentaPedido = promedioVentaPedido 
            Boolean promedioVentaPedidoNoNulo = null;
            BigDecimal promedioVentaPedido = (BigDecimal) rs.getValueAt(0, "PROMEDIOVENTAPEDIDO");

            if (promedioVentaPedido != null) {
                promedioVentaPedidoNoNulo = ((promedioVentaPedido.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndPromedioVentaPedido(promedioVentaPedidoNoNulo);

            //   dtos.indPromedioUnidadesPedido = promedioUnidadesPedido 
            Boolean promedioUnidadesPedidoNoNula = null;
            BigDecimal promedioUnidadesPedido = (BigDecimal) rs.getValueAt(0, "PROMEDIOUNIDADESPEDIDO");

            if (promedioUnidadesPedido != null) {
                promedioUnidadesPedidoNoNula = ((promedioUnidadesPedido.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndPromedioUnidadesPedido(promedioUnidadesPedidoNoNula);

            //   dtos.indPromedioOrdenesPedido = promedioOrdenesPedido 
            Boolean promedioOrdenesPedidoNoNulo = null;
            BigDecimal promedioOrdenesPedido = (BigDecimal) rs.getValueAt(0, "PROMEDIOORDENESPEDIDO");

            if (promedioOrdenesPedido != null) {
                promedioOrdenesPedidoNoNulo = ((promedioOrdenesPedido.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndPromedioOrdenesPedido(promedioOrdenesPedidoNoNulo);

            //   dtos.indRetencion = retencion 
            Boolean retencionNoNulo = null;
            BigDecimal retencion = (BigDecimal) rs.getValueAt(0, "RETENCION");

            if (retencion != null) {
                retencionNoNulo = ((retencion.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndRetencion(retencionNoNulo);

            //   dtos.indVentaEstadisticable = ventaEstadisticable 
            Boolean ventaEstadisticableNoNula = null;
            BigDecimal ventaEstadisticable = (BigDecimal) rs.getValueAt(0, "VENTAESTADISTICABLE");

            if (ventaEstadisticable != null) {
                ventaEstadisticableNoNula = ((ventaEstadisticable.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOVariablesVenta.setIndVentaEstadisticable(ventaEstadisticableNoNula);
            UtilidadesLog.debug("******** dTOVariablesVenta " + dTOVariablesVenta);
        }

        UtilidadesLog.info("DAOConcurso.obtenerVariablesVenta(DTOOID dtoe): Salida");
        return dTOVariablesVenta;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       18/05/2005
          * @version     1.0
          * @autor       Carlos Leal
    **/
    public DTOParametrosGerentes obtenerParametrosGerentes(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerParametrosGerentes(DTOOID dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOParametrosGerentes dTOParametrosGerentes = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT  A.OID_CONC_PARA_GERE OID , ");
        query.append(" A.VAL_RECO_EFEC RECOMENDACIONEFECTIVA, ");
        query.append(" A.VAL_PERI_EVAL PERIODOSEVALUAR, ");
        query.append(" A.NUM_MINI_PEDI NUMEROMINIMOPEDIDOS, ");
        query.append(" A.NUM_MINI_PEDI_RECO NUMEROMINIMOPEDIDOSRECOMENDADA, ");
        query.append(" A.PERD_OID_PERI PERIODOINICIALEVALUACION, ");
        query.append(" A.TVEN_OID_TIPO_VENT TIPOVENTA, ");
        query.append(" A.FCAL_OID_FORM_CALC FORMACALCULO, ");
        query.append(" B.BCAL_OID_BASE_CALC BASECALCULO ");
        query.append(" FROM INC_CONCU_PARAM_GEREN A, ");
        query.append(" INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL and ");
        query.append(" B.OID_PARA_GRAL = " + dtoe.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);

            if (!rs.esVacio()) {
                dTOParametrosGerentes = new DTOParametrosGerentes();

                dTOParametrosGerentes.setOidParamGerentes(new Long(((BigDecimal) (rs.getValueAt(0, "OID"))).longValue()));

                Boolean recomendacionEfectivaNoNulo = null;
                BigDecimal recomendacionEfectiva = (BigDecimal) rs.getValueAt(0, "RECOMENDACIONEFECTIVA");

                if (recomendacionEfectiva != null) {
                    recomendacionEfectivaNoNulo = ((recomendacionEfectiva.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
                }

                dTOParametrosGerentes.setIndRecomendacionEfectiva(recomendacionEfectivaNoNulo);
                dTOParametrosGerentes.setNumeroPeriodosEvaluar((rs.getValueAt(0, "PERIODOSEVALUAR") == null) ? null
                                                                                                             : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                        "PERIODOSEVALUAR"))).intValue()));
                dTOParametrosGerentes.setNumeroMinimoPedidos((rs.getValueAt(0, "NUMEROMINIMOPEDIDOS") == null) ? null
                                                                                                               : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                          "NUMEROMINIMOPEDIDOS"))).intValue()));
                dTOParametrosGerentes.setNumeroMinimoPedidosRecomendada((rs.getValueAt(0, "NUMEROMINIMOPEDIDOSRECOMENDADA") == null) ? null
                                                                                                                                     : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                                                "NUMEROMINIMOPEDIDOSRECOMENDADA"))).intValue()));
                dTOParametrosGerentes.setOidFormaCalculo(new Long(((BigDecimal) (rs.getValueAt(0, "FORMACALCULO"))).longValue()));
                dTOParametrosGerentes.setOidPeriodoInicialEvaluacion((rs.getValueAt(0, "PERIODOINICIALEVALUACION") == null) ? null
                                                                                                                            : new Long(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                                    "PERIODOINICIALEVALUACION"))).longValue()));

                if (rs.getValueAt(0, "TIPOVENTA") != null) {
                    dTOParametrosGerentes.setOidTipoVenta(new Long(((BigDecimal) (rs.getValueAt(0, "TIPOVENTA"))).longValue()));
                }

                dTOParametrosGerentes.setOidBaseCalculo((rs.getValueAt(0, "BASECALCULO") == null) ? null
                                                                                                  : new Long(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                          "BASECALCULO"))).longValue()));
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("**** dTOParametrosGerentes: " + dTOParametrosGerentes);
        UtilidadesLog.info("DAOConcurso.obtenerParametrosGerentes(DTOOID dtoe): Salida");

        return dTOParametrosGerentes;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Carlos Leal
    **/
    public DTOMultinivel obtenerMultinivel(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMultinivel(DTOOID dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOMultinivel dTOMultinivel = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT A.OID_MULT oid, ");
        query.append(" A.PERD_OID_PERI_DESD periodoDesde, ");
        query.append(" A.PERD_OID_PERI periodoHasta, ");
        query.append(" A.NUM_PERI_PARA_CALC periodosParaCalculo, ");
        query.append(" A.NUM_PERI_SOBR_CALC periodosSobreCalculo, ");
        query.append(" A.NUM_MINI_RECO numeroMinimoRecomendadas, ");
        query.append(" A.IMP_MONT_MINI_RED montoMinimoRed, ");
        query.append(" A.NUM_PEDI_MINI_RED pedidosMinimosRed, ");
        query.append(" A.NUM_UNID_MINI_RED unidadesMinimasRed, ");
        query.append(" A.IMP_MONT_MINI_MADR montoMinimoMadre, ");
        query.append(" A.NUM_PEDI_MINI_MADR pedidosMinimosMadre, ");
        query.append(" A.NUM_UNID_MINI_MADR unidadesMinimasMadre, ");
        query.append(" A.IMP_MONT_MINI_PEDI_POR_HIJA montoMinimoPedidoPorHijas, ");
        query.append(" A.NUM_PEDI_MINI_HIJA pedidosMinimosHijas, ");
        query.append(" A.NUM_UNID_MINI_HIJA unidadesMinimasHijas, ");
        query.append(" A.CPRE_OID_CALC_PREM calculoPremio, ");
        query.append(" A.VAL_PORC_SOBR_VENT porcentajeSobreVenta, ");
        query.append(" A.VAL_PORC_SOBR_COBR porcentajeSobreCobranza, ");
        query.append(" A.IND_ACTI actividad, ");
        query.append(" A.IMP_MONT_MINI_PEDI_HIJA montoMinimoPedidoHijas, ");
        query.append(" A.NUM_UNID_MINI_PEDI_HIJA unidadesMinimasPedidoHijas, ");
        query.append(" A.IND_PAGO_TIEM pagoTiempo, ");
        query.append(" A.PERD_OID_PERI_TIEM_DESD periodoATiempoDesde, ");
        query.append(" A.PERD_OID_PERI_TIEM_HAST periodoATiempoHasta, ");
        query.append(" A.NUM_DIAS_GRAC diasGracia ");
        query.append(" FROM INC_MULTI A, ");
        query.append(" INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL and ");
        query.append(" B.OID_PARA_GRAL = " + dtoe.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            dTOMultinivel = new DTOMultinivel();

            //  dtos.oid = oid 
            dTOMultinivel.setOid(new Long(((BigDecimal) (rs.getValueAt(0, "OID"))).longValue()));

            //  dtos.periodosParaCalculo = periodosParaCalculo 
            dTOMultinivel.setPeriodosParaCalculo(new Integer(((BigDecimal) (rs.getValueAt(0, "PERIODOSPARACALCULO"))).intValue()));

            //  dtos.periodosSobreCalculo = periodosSobreCalculo 
            dTOMultinivel.setPeriodosSobreCalculo(new Integer(((BigDecimal) (rs.getValueAt(0, "PERIODOSSOBRECALCULO"))).intValue()));

            //  dtos.numeroMinimoRecomendadas = numeroMinimoRecomendadas   
            dTOMultinivel.setNumeroMinimoRecomendadas(new Integer(((BigDecimal) (rs.getValueAt(0, "NUMEROMINIMORECOMENDADAS"))).intValue()));

            //  dtos.actividad = actividad
            dTOMultinivel.setActividad((((BigDecimal) (rs.getValueAt(0, "ACTIVIDAD"))).equals(new BigDecimal(1))) ? new Boolean(true)
                                                                                                                  : new Boolean(false));

            //  dtos.oidPeriodoHasta = periodoHasta 
            dTOMultinivel.setOidPeriodoHasta(new Long(((BigDecimal) (rs.getValueAt(0, "PERIODOHASTA"))).longValue()));

            //  dtos.oidPeriodoDesde = periodoDesde 
            dTOMultinivel.setOidPeriodoDesde(new Long(((BigDecimal) (rs.getValueAt(0, "PERIODODESDE"))).longValue()));

            //  dtos.oidCalculoPremio = calculoPremio 
            dTOMultinivel.setOidCalculoPremio((rs.getValueAt(0, "CALCULOPREMIO") == null) ? null
                                                                                          : new Long(((BigDecimal) (rs.getValueAt(0, "CALCULOPREMIO"))).longValue()));

            //  dtos.montoMinimoPedidoPorHijas = montoMinimoPedidoPorHijas 
            dTOMultinivel.setMontoMinimoPedidoPorHijas((rs.getValueAt(0, "MONTOMINIMOPEDIDOPORHIJAS") == null) ? new BigDecimal(0)
                                                                                                               : (BigDecimal) (rs.getValueAt(0,
                                                                                                                                             "MONTOMINIMOPEDIDOPORHIJAS")));

            //  dtos.montoMinimoPedidoHijas = montoMinimoPedidosHijas 
            dTOMultinivel.setMontoMinimoPedidoHijas((rs.getValueAt(0, "MONTOMINIMOPEDIDOHIJAS") == null) ? new BigDecimal(0)
                                                                                                         : (BigDecimal) (rs.getValueAt(0,
                                                                                                                                       "MONTOMINIMOPEDIDOHIJAS")));

            //  dtos.unidadesMinimasPedidoHijas = unidadesMinimasPedidoHijas 
            dTOMultinivel.setUnidadesMinimasPedidoHijas((rs.getValueAt(0, "UNIDADESMINIMASPEDIDOHIJAS") == null) ? new Integer(0)
                                                                                                                 : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                            "UNIDADESMINIMASPEDIDOHIJAS"))).intValue()));

            //  dtos.montoMinimoRed = montoMinimoRed
            dTOMultinivel.setMontoMinimoRed((rs.getValueAt(0, "MONTOMINIMORED") == null) ? new BigDecimal(0) : (BigDecimal) (rs.getValueAt(0, "MONTOMINIMORED")));

            //  dtos.pedidosMinimosRed = pedidosMinimosRed 
            dTOMultinivel.setPedidosMinimosRed((rs.getValueAt(0, "PEDIDOSMINIMOSRED") == null) ? new Integer(0)
                                                                                               : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                          "PEDIDOSMINIMOSRED"))).intValue()));

            //  dtos.unidadesMinimasRed = unidadesMinimasRed 
            dTOMultinivel.setUnidadesMinimasRed((rs.getValueAt(0, "UNIDADESMINIMASRED") == null) ? new Integer(0)
                                                                                                 : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                            "UNIDADESMINIMASRED"))).intValue()));

            //  dtos.montoMinimoMadre = montoMinimoMadre 
            dTOMultinivel.setMontoMinimoMadre((rs.getValueAt(0, "MONTOMINIMOMADRE") == null) ? new BigDecimal(0)
                                                                                             : (BigDecimal) (rs.getValueAt(0, "MONTOMINIMOMADRE")));

            //  dtos.pedidosMinimosMadre = pedidosMinimosMadre 
            dTOMultinivel.setPedidosMinimosMadre((rs.getValueAt(0, "PEDIDOSMINIMOSMADRE") == null) ? new Integer(0)
                                                                                                   : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                              "PEDIDOSMINIMOSMADRE"))).intValue()));

            //  dtos.unidadesMinimasMadre = unidadesMinimasMadre 
            dTOMultinivel.setUnidadesMinimasMadre((rs.getValueAt(0, "UNIDADESMINIMASMADRE") == null) ? new Integer(0)
                                                                                                     : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                "UNIDADESMINIMASMADRE"))).intValue()));

            //  dtos.pedidosMinimosHijas = pedidosMinimosHijas 
            dTOMultinivel.setPedidosMinimosHijas((rs.getValueAt(0, "PEDIDOSMINIMOSHIJAS") == null) ? new Integer(0)
                                                                                                   : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                              "PEDIDOSMINIMOSHIJAS"))).intValue()));

            //  dtos.unidadesMinimasHijas = unidadesMinimasHijas 
            dTOMultinivel.setUnidadesMinimasHijas((rs.getValueAt(0, "UNIDADESMINIMASHIJAS") == null) ? new Integer(0)
                                                                                                     : new Integer(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                                "UNIDADESMINIMASHIJAS"))).intValue()));

            //  dtos.porcentajeSobreVenta = porcentajeSobreVenta 
            dTOMultinivel.setPorcentajeSobreVenta((rs.getValueAt(0, "PORCENTAJESOBREVENTA") == null) ? new BigDecimal(0)
                                                                                                     : ((BigDecimal) rs.getValueAt(0,
                                                                                                                                   "PORCENTAJESOBREVENTA")));

            //  dtos.porcentajeSobreCobranza = porcentajeSobreCobranza           
            dTOMultinivel.setPorcentajeSobreCobranza((rs.getValueAt(0, "PORCENTAJESOBRECOBRANZA") == null) ? new BigDecimal(0)
                                                                                                           : ((BigDecimal) rs.getValueAt(0,
                                                                                                                                         "PORCENTAJESOBRECOBRANZA")));

            //  dtos.pagoTiempo = pagoTiempo
            Boolean pagoTiempoNoNulo = null;
            BigDecimal pagoTiempo = (BigDecimal) rs.getValueAt(0, "PAGOTIEMPO");

            if (pagoTiempo != null) {
                pagoTiempoNoNulo = ((pagoTiempo.equals(new BigDecimal(1))) ? new Boolean(true) : new Boolean(false));
            }

            dTOMultinivel.setPagoTiempo(pagoTiempoNoNulo);

            //  dtos.diasGracia = txtDiasGracia 
            dTOMultinivel.setDiasGracia((rs.getValueAt(0, "DIASGRACIA") == null) ? null
                                                                                 : new Integer(((BigDecimal) (rs.getValueAt(0, "DIASGRACIA"))).intValue()));

            //  dtos.oidPeriodoATiempoDesde = periodoATiempoDesde 
            dTOMultinivel.setOidPeriodoATiempoDesde((rs.getValueAt(0, "PERIODOATIEMPODESDE") == null) ? null
                                                                                                      : new Long(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                              "PERIODOATIEMPODESDE"))).longValue()));

            //  dtos.oidPeriodoATiempoHasta = periodoATiempoHasta 
            dTOMultinivel.setOidPeriodoATiempoHasta((rs.getValueAt(0, "PERIODOATIEMPOHASTA") == null) ? null
                                                                                                      : new Long(((BigDecimal) (rs.getValueAt(0,
                                                                                                                                              "PERIODOATIEMPOHASTA"))).longValue()));
        }

        UtilidadesLog.debug("dtoMultinivel: " + dTOMultinivel);
        UtilidadesLog.info("DAOConcurso.obtenerMultinivel(DTOOID dtoe): Salida");

        return dTOMultinivel;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Carlos Leal
       * Modificado:  Cristian Valenzuela 7/7/2005
    **/
    public RecordSet obtenerAgrupacion(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerAgrupacion(DTOBelcorp dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ia.oid_agru, ");
        query.append(" i1.val_i18n ");
        query.append(" FROM v_gen_i18n_sicc i1, inc_agrup ia ");
        query.append(" WHERE i1.attr_enti = 'INC_AGRUP' AND ");
        query.append(" i1.attr_num_atri = 1 AND ");
        query.append(" i1.val_oid = ia.oid_agru AND ");
        query.append(" i1.IDIO_OID_IDIO =  " + dtoe.getOidIdioma());
        query.append(" ORDER BY i1.val_i18n ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOConcurso.obtenerAgrupacion(DTOBelcorp dtoe): Salida");

        return rs;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Carlos Leal
    **/
    public DTOVariablesVentaProyectada obtenerVariablesVentaProyectada(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerVariablesVentaProyectada(DTOOID dtoe): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        DTOVariablesVentaProyectada dTOVariablesVentaProyectada = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT  A.OID_CONC_VARI_VENT_PROY oid, ");
        query.append(" A.IND_ACTI activas, ");
        query.append(" A.IND_INGR ingreso, ");
        query.append(" A.IND_REIN reingreso, ");
        query.append(" A.IND_EGRE egresos, ");
        query.append(" A.IND_ENTR entregadas, ");
        query.append(" A.IND_RECI recibidas, ");
        query.append(" A.IND_CAPI capitalizacion, ");
        query.append(" A.IND_ACTI_FINA activasFinales, ");
        query.append(" A.IND_ADAD actividad, ");
        query.append(" A.IND_NUME_PEDI numeroPedidos, ");
        query.append(" A.IND_PREC_PROM_UNIT precioPromedioUnitario, ");
        query.append(" A.IND_PROM_VENT_PEDI promedioVentaPedido, ");
        query.append(" A.IND_PROM_UNID_PEDI promedioUnidadesPedido, ");
        query.append(" A.IND_PROM_ORDE_PEDI promedioOrdenesPedido, ");
        query.append(" A.IND_RETE retencion, ");
        query.append(" A.IND_VENT_ESTA ventaEstadisticable ");
        query.append(" FROM INC_CONCU_VARIA_VENTA_PROYE A, ");
        query.append(" INC_CONCU_PARAM_GENER B ");
        query.append(" WHERE A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL and ");
        query.append(" B.OID_PARA_GRAL = " + dtoe.getOid());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if ((rs != null) && !rs.esVacio()) {
            dTOVariablesVentaProyectada = new DTOVariablesVentaProyectada();

            //    dtos.oid = oid 
            dTOVariablesVentaProyectada.setOid(new Long(((BigDecimal) (rs.getValueAt(0, "OID"))).longValue()));

            //    dtos.indActivas = activas 
            dTOVariablesVentaProyectada.setIndActivas((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "ACTIVAS")))) ? new Boolean(true)
                                                                                                                             : new Boolean(false));

            //    dtos.indIngreso = ingreso 
            dTOVariablesVentaProyectada.setIndIngreso((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "INGRESO")))) ? new Boolean(true)
                                                                                                                             : new Boolean(false));

            //    dtos.indReingreso = reingreso 
            dTOVariablesVentaProyectada.setIndReingreso((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "REINGRESO")))) ? new Boolean(true)
                                                                                                                                 : new Boolean(false));

            //    dtos.indEgresos = egresos 
            dTOVariablesVentaProyectada.setIndEgresos((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "EGRESOS")))) ? new Boolean(true)
                                                                                                                             : new Boolean(false));

            //    dtos.indEntregadas = entregadas 
            dTOVariablesVentaProyectada.setIndEntregadas((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "ENTREGADAS"))))
                                                         ? new Boolean(true) : new Boolean(false));

            //    dtos.indRecibidas = recibidas 
            dTOVariablesVentaProyectada.setIndRecibidas((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "RECIBIDAS")))) ? new Boolean(true)
                                                                                                                                 : new Boolean(false));

            //    dtos.indCapitalizacion = capitalizacion 
            dTOVariablesVentaProyectada.setIndCapitalizacion((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "CAPITALIZACION"))))
                                                             ? new Boolean(true) : new Boolean(false));

            //    dtos.indActivasFinales = activasFinales 
            dTOVariablesVentaProyectada.setIndActivasFinales((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "ACTIVASFINALES"))))
                                                             ? new Boolean(true) : new Boolean(false));

            //    dtos.indActividad = actividad 
            dTOVariablesVentaProyectada.setIndActividad((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "ACTIVIDAD")))) ? new Boolean(true)
                                                                                                                                 : new Boolean(false));

            //    dtos.indNumeroPedidos = numeroPedidos 
            dTOVariablesVentaProyectada.setIndNumeroPedidos((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "NUMEROPEDIDOS"))))
                                                            ? new Boolean(true) : new Boolean(false));

            //    dtos.indPrecioPromedioUnitario = precioPromedioUnitario 
            dTOVariablesVentaProyectada.setIndPrecioPromedioUnitario((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "PRECIOPROMEDIOUNITARIO"))))
                                                                     ? new Boolean(true) : new Boolean(false));

            //   dtos.indPromedioVentaPedido = promedioVentaPedido 
            dTOVariablesVentaProyectada.setIndPromedioVentaPedido((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "PROMEDIOVENTAPEDIDO"))))
                                                                  ? new Boolean(true) : new Boolean(false));

            //    dtos.indPromedioUnidadesPedido = promedioUnidadesPedido 
            dTOVariablesVentaProyectada.setIndPromedioUnidadesPedido((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0,
                                                                                                                           "PROMEDIOUNIDADESPEDIDO"))))
                                                                     ? new Boolean(true) : new Boolean(false));

            //    dtos.indPromedioOrdenesPedido = promedioOrdenesPedido 
            dTOVariablesVentaProyectada.setIndPromedioOrdenesPedido((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "PROMEDIOORDENESPEDIDO"))))
                                                                    ? new Boolean(true) : new Boolean(false));

            //    dtos.indRetencion = retencion 
            dTOVariablesVentaProyectada.setIndRetencion((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "RETENCION")))) ? new Boolean(true)
                                                                                                                                 : new Boolean(false));

            //    dtos.indVentaEstadisticable = ventaEstadisticable 
            dTOVariablesVentaProyectada.setIndVentaEstadisticable((new BigDecimal(1).equals((BigDecimal) (rs.getValueAt(0, "VENTAESTADISTICABLE"))))
                                                                  ? new Boolean(true) : new Boolean(false));
        }

        UtilidadesLog.info("DAOConcurso.obtenerVariablesVentaProyectada(DTOOID dtoe): Salida");

        return dTOVariablesVentaProyectada;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremiosPuntos(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremiosPuntos(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT prem.OID_TIPO_PREM_PUNT, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_PREMI_PUNTO prem, v_gen_i18n_sicc i18n ");
        query.append(" WHERE prem.OID_TIPO_PREM_PUNT = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI_PUNTO' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremiosPuntos(DTOBelcorp dtoe): Salida");

        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremioMonetario(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremioMonetario(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT prem.OID_TIPO_PREM_MONE, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_PREMI_MONET prem, v_gen_i18n_sicc i18n ");
        query.append(" WHERE prem.OID_TIPO_PREM_MONE = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI_MONET' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConcurso.obtenerTipoPremioMonetario(DTOBelcorp dtoe): Salida");

        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerFormaPago(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerFormaPago(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT pago.OID_FORM_PAGO, i18n.VAL_I18N ");
        query.append(" FROM INC_FORMA_PAGO pago, v_gen_i18n_sicc i18n ");
        query.append(" WHERE pago.OID_FORM_PAGO = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_FORMA_PAGO' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerFormaPago(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoCumplimiento(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoCumplimiento(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT cump.OID_TIPO_CUMP, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_CUMPL cump, v_gen_i18n_sicc i18n ");
        query.append(" WHERE cump.OID_TIPO_CUMP = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_CUMPL' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerTipoCumplimiento(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.0
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoDescuento(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerTipoDescuento(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT de.OID_TIPO_DESC, i18n.VAL_I18N ");
        query.append(" FROM INC_TIPO_DESCU de, v_gen_i18n_sicc i18n ");
        query.append(" WHERE de.OID_TIPO_DESC = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'INC_TIPO_DESCU' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOConcurso.obtenerTipoDescuento(DTOBelcorp dtoe): Salida");

        return dtoSalida;
    }

    /**
     * @Author: ssantana, 26/5/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param DTOBelcorp DTOE
     */
    public DTOSalida obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE)
            throws MareException {
        /*
         * Obtener los campos:
         *   oid
         *   descripcion (internacionalizable)
         *   de la entidad INC:TipoMontoVentaRecomendada
         */
        UtilidadesLog.info("DAOConcurso.obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE): Entrada");

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer sQuery = new StringBuffer("");

        sQuery.append(" SELECT   inc_tipo_monto_venta_recom.oid_tipo_mont_vent_reco, ");
        sQuery.append(" v_gen_i18n_sicc.val_i18n ");
        sQuery.append(" FROM inc_tipo_monto_venta_recom, v_gen_i18n_sicc ");
        sQuery.append(" WHERE inc_tipo_monto_venta_recom.oid_tipo_mont_vent_reco = ");
        sQuery.append(" v_gen_i18n_sicc.val_oid ");
        sQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        sQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'INC_TIPO_MONTO_VENTA_RECOM' ");
        sQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + DTOE.getOidIdioma());
        sQuery.append(" ORDER BY inc_tipo_monto_venta_recom.oid_tipo_mont_vent_reco ");

        try {
            r = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        dtoSalida.setResultado(r);

        UtilidadesLog.debug("DTOSalida: " + dtoSalida);
        UtilidadesLog.info("DAOConcurso.obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE): Salida");

        return dtoSalida;
    }

    /**
     * @author: cvalenzu, 1/8/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param DTOBuscarConcursos DTOE
     */
    public RecordSet buscarConcursos(DTOBuscarConcursos DTOE) 
        throws MareException {
        
        UtilidadesLog.info("DAOConcurso.buscarConcursos(DTOBuscarConcursos DTOE): Entrada");
        UtilidadesLog.debug("********* DTOBuscarConcursos " + DTOE);

        StringBuffer sqlQuery = new StringBuffer("");

        String nroConcurso = DTOE.getNroConcurso();
        Long oidPlantilla = DTOE.getOidPlantilla();
        Long oidIdioma = DTOE.getOidIdioma();
        Long oidMarca = DTOE.getOidMarca();
        Long oidCanal = DTOE.getOidCanal();
        Boolean indActivo = DTOE.getIndActivo();
        String sNombreConcurso = DTOE.getNombreConcurso();
        String sNombrePlantilla = DTOE.getNombrePlantilla();
        Integer nVersion = DTOE.getVersion();

        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();

        // Nota: 2/6/2005 - Debido a que en el DMCO se menciona que pueden venir varias tuplas
        //                  corresp. a un mismo "inc_concu_param_gener.oid_para_gral" 
        //                  por repeticion de Accesos, y como se debe mostrar así, le agrego
        //                  ROWNUM as OID para poder paginar correctamente, y envío 
        //                  "inc_concu_param_gener.oid_para_gral" al final. 
        //jrivas 8/6/2005
        //El concurso puede no tener acceso
        
         //Se hace el paginado "a mano"
        sqlQuery.append(" SELECT * FROM ( ");
        
        //Consulta principal        
        sqlQuery.append(" SELECT ROWNUM AS OID, E.* FROM ( ");        
        sqlQuery.append(" SELECT DISTINCT inc_concu_param_gener.num_conc, ");
        sqlQuery.append("                  inc_concu_param_gener.val_nomb, ");
        sqlQuery.append("                  inc_concu_param_gener.plc2_oid_plan_conc, v.val_i18n, ");
        sqlQuery.append("                  inc_concu_param_gener.num_vers, seg_marca.des_marc, ");
        sqlQuery.append(" 				   vcanal.val_i18n canal,  ");
        sqlQuery.append(" 				   '' acceso, ");
        sqlQuery.append("                  inc_concu_param_gener.oid_para_gral, ");
        
        /*
         * 03/05/2006, Ssantana, Versionado
         */
        sqlQuery.append("                  inc_versi_concu.vico_oid_vige_conc, ");        
        sqlQuery.append("                  inc_versi_concu.esc2_oid_esta_conc ");
        /*
         * Fin, 03/05/2006, Ssantana, Versionado
         */
        
        // sapaza -- PER-SiCC-2011-0295 -- 08/06/2011
        sqlQuery.append("                  , '0' ind_despacho ");

        sqlQuery.append("             FROM inc_concu_param_gener, ");
        sqlQuery.append("                  inc_acces_concu, ");
        sqlQuery.append("                  inc_plant_concu, ");
        sqlQuery.append("                  seg_marca, ");
        sqlQuery.append("                  seg_canal, ");
        sqlQuery.append("                  v_gen_i18n_sicc v, ");
        sqlQuery.append("                  v_gen_i18n_sicc vcanal, ");
        sqlQuery.append("                  v_gen_i18n_sicc vacceso, ");

        /*
         * 03/05/2006, Ssantana, Versionado
         */
        sqlQuery.append("                  inc_versi_concu "); 
        /*
         * Fin, 03/05/2006, Ssantana, Versionado
         */
        
                                          
        sqlQuery.append(" WHERE inc_acces_concu.copa_oid_para_gral(+) = inc_concu_param_gener.oid_para_gral ");

        //Modificado Jrivas 23/6/2005
        //Todos los concursos que deberia de modificar o consultar son solamente los que no son de ranking.
        sqlQuery.append(" AND inc_concu_param_gener.IND_RANK = 0");

        if (nroConcurso != null) {
            sqlQuery.append(" AND inc_concu_param_gener.NUM_CONC = '" + nroConcurso + "'");
        }

        //Modificado por Cristian Valenzuela 11/7/2005 - BELC300019262  
        if (indActivo != null) {
            if (!indActivo.booleanValue()) {
                sqlQuery.append(" AND inc_concu_param_gener.ind_acti = 0 ");
            }
        }

        if ((sNombreConcurso != null) && !sNombreConcurso.equals("")) {
            sqlQuery.append(" AND inc_concu_param_gener.val_nomb LIKE '" + sNombreConcurso + "' ");
        }

        if (nVersion != null) {
            sqlQuery.append(" AND inc_concu_param_gener.num_vers = " + nVersion);
        }

        if (oidPlantilla != null) {
            sqlQuery.append(" AND inc_plant_concu.oid_plan_conc = " + oidPlantilla);
        }

        sqlQuery.append(" AND inc_plant_concu.oid_plan_conc = inc_concu_param_gener.plc2_oid_plan_conc  ");
        sqlQuery.append(" AND inc_plant_concu.oid_plan_conc = v.val_oid  ");
        sqlQuery.append(" AND v.attr_enti = 'INC_PLANT_CONCU'  ");
        sqlQuery.append(" AND v.attr_num_atri = 1  ");
        sqlQuery.append(" AND v.idio_oid_idio = " + oidIdioma);

        if ((sNombrePlantilla != null) && !sNombrePlantilla.equals("")) {
            sqlQuery.append(" AND v.val_i18n LIKE '" + sNombrePlantilla + "' ");
        }

        sqlQuery.append(" AND seg_marca.oid_marc = inc_concu_param_gener.marc_oid_marc ");

        if (oidMarca != null) {
            sqlQuery.append(" AND seg_marca.oid_marc = " + oidMarca);
        }

        sqlQuery.append(" AND seg_canal.oid_cana = inc_concu_param_gener.cana_oid_cana ");

        if (oidCanal != null) {
            sqlQuery.append(" AND seg_canal.oid_cana = " + oidCanal);
        }

        sqlQuery.append(" AND seg_canal.oid_cana = vcanal.val_oid ");
        sqlQuery.append(" AND vcanal.attr_num_atri = 1 ");
        sqlQuery.append(" AND vcanal.attr_enti = 'SEG_CANAL' ");
        sqlQuery.append(" AND vcanal.idio_oid_idio = " + oidIdioma);
        
        //jrivas 8/6/2005
        //El concurso puede no tener acceso
        sqlQuery.append(" AND vacceso.val_oid(+) = inc_acces_concu.acce_oid_acce ");
        sqlQuery.append(" AND vacceso.attr_num_atri(+) = 1 ");
        sqlQuery.append(" AND vacceso.attr_enti(+) = 'SEG_ACCES' ");
        sqlQuery.append(" AND vacceso.idio_oid_idio(+) = " + oidIdioma);       
       
       
        /*
         * 03/05/2006, Ssantana, Versionado
         */
        sqlQuery.append(" AND inc_versi_concu.copa_oid_para_gral = ");
        sqlQuery.append("               inc_concu_param_gener.oid_para_gral ");
        /*
         * Fin, 03/05/2006, Ssantana, Versionado
         */

       
        sqlQuery.append(" ORDER BY inc_concu_param_gener.num_conc) E ");
        
        //Fin de la consulta
        //Esta ultima parte es para el paginado realizado "a mano"
        sqlQuery.append(" ) WHERE ROWNUM < = " + DTOE.getTamanioPagina());
        sqlQuery.append(" AND OID > " + DTOE.getIndicadorSituacion());
        sqlQuery.append(" ORDER BY OID ");

        try {            
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
        }
        catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.debug("************ Resultado: " + r);

        if (r.esVacio()) {
            UtilidadesLog.debug("Rs es vacío, lanza Exception ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE");

            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        //25/8/2005 - CRISTIAN VALENZUELA  
        //CAMBIOS PARA QUE APAREZCA UN SOLO REGISTRO CON LOS ACCESOS
        //CONCATENADOS
        
        //1° Se obtienen los oids de concurso
        Long[] arrayOids = this.obtieneOids(r, new Long(9));

        for (int i = 0; i < arrayOids.length; i++) {
            UtilidadesLog.debug("********** arrayOids " + arrayOids[i]);
        }

        //2° Se ejecuta otra consulta que traera las descripciones de los accesos
        RecordSet rAccesos = obtieneDescAccesosPorOid(arrayOids, oidIdioma);
        
        //3° Se arma el RecordSet final con todos los datos
        r = this.armaRSetFinal(r, rAccesos);        
        
        // sapaza -- PER-SiCC-2011-0295 -- 08/06/2011
        RecordSet rDespachos = obtienePremiosDespachadosPorOid(arrayOids);
        r = this.armaRSetFinalAux(r, rDespachos);        
         
        UtilidadesLog.info("DAOConcurso.buscarConcursos(DTOBuscarConcursos DTOE): Salida");
        //25/8/2005 - CRISTIAN VALENZUELA
        //CAMBIOS PARA QUE APAREZCA UN SOLO REGISTRO CON LOS ACCESOS
        //CONCATENADOS
        return r;
    }
    
    // Metodo que Recorre un RecordSet y devuelve un array de Longs 
     //con los elementos de la columna "indexCol".
     private Long[] obtieneOids(RecordSet r, Long indexCol) {        
        UtilidadesLog.info("DAOConcurso.obtieneOids(RecordSet r, Long indexCol): Entrada");
        Vector v = new Vector();

        for (int i = 0; i < r.getRowCount(); i++) {
            BigDecimal b = (BigDecimal) r.getValueAt(i, indexCol.intValue());
            Long oid = new Long(b.longValue());
            v.add(oid);
        }

        Long[] array = (Long[]) v.toArray(new Long[v.size()]);
        
        UtilidadesLog.info("DAOConcurso.obtieneOids(RecordSet r, Long indexCol): Salida");
        return array;
    }
    
     //Metodo que obtendra las descripciones de los accesos
     private RecordSet obtieneDescAccesosPorOid(Long[] arrayOids, Long oidIdioma)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtieneDescAccesosPorOid(Long[] arrayOids, Long oidIdioma): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        String oids = this.generaINClause(arrayOids);

        query.append(" SELECT inc_concu_param_gener.oid_para_gral as oid, ");
        query.append(" vacceso.VAL_I18N ");
        query.append(" FROM inc_concu_param_gener, ");
        query.append(" inc_acces_concu, ");
        query.append(" inc_plant_concu, ");
        query.append(" v_gen_i18n_sicc vacceso ");
        query.append(" WHERE inc_concu_param_gener.OID_PARA_GRAL " + oids);
        query.append(" AND inc_concu_param_gener.PLC2_OID_PLAN_CONC = inc_plant_concu.OID_PLAN_CONC ");
        query.append(" AND inc_acces_concu.COPA_OID_PARA_GRAL(+) = inc_concu_param_gener.OID_PARA_GRAL ");
        query.append(" AND vacceso.val_oid(+) = inc_acces_concu.acce_oid_acce ");
        query.append(" AND vacceso.attr_num_atri(+) = 1 ");
        query.append(" AND vacceso.attr_enti(+) = 'SEG_ACCES' ");
        query.append(" AND vacceso.idio_oid_idio(+) = " + oidIdioma);
        query.append(" ORDER BY inc_concu_param_gener.oid_para_gral ");        

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.debug("********* El recordset es vacio");
            throw new MareException(new Exception(), 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        rs = this.concatenaCampos(rs);
        
        UtilidadesLog.info("DAOConcurso.obtieneDescAccesosPorOid(Long[] arrayOids, Long oidIdioma): Salida");

        return rs;
    }

     private RecordSet concatenaCampos(RecordSet r) {
        // Recordset de Entrada tiene el sig. formato: [oid, desc],
        // ordenado por oid en forma ascendente. 
        // Concatena en una sola tupla aquellas descripciones que posean el mismo oid.
        UtilidadesLog.info("DAOConcurso.concatenaCampos(RecordSet r): Entrada");
        UtilidadesLog.debug("********* Recordset entrada: " + r);

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
                UtilidadesLog.debug("************ Bucle: " + i);

                // Obtenemos el oid. 
                BigDecimal bigOid = (BigDecimal) r.getValueAt(i, 0);
                String sDesc = (String) r.getValueAt(i, 1);

                if (sDesc == null) {
                    sDesc = "";
                }

                if ((oidAnterior == bigOid.longValue()) && (i != cantFilasOriginal)) {
                    // Si el oid del registro anterior es el mismo que el actual.            
                    // continua concatenando descripcion.
                    UtilidadesLog.debug("********** Match! - oid: " + oidAnterior);

                    // Concatena la desc. a sCadena. 
                    if (!sCadena.equals("")) {
                        sCadena.append(", ");
                    }

                    sCadena.append(sDesc);
                    UtilidadesLog.debug("************ sCadena actual: " + sCadena.toString());
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
            UtilidadesLog.debug("************** Agrega ultima vfila: " + vFila);
        }

        UtilidadesLog.debug("************* RecordSet Salida: " + rToReturn);
        UtilidadesLog.info("DAOConcurso.concatenaCampos(RecordSet r): Salida");

        return rToReturn;
    }
    
    //Metodo que genera la clausula IN dependiendo un array de Long
    //Devuelve un String, por ejemplo: IN(1834, 1835, 1836)
    private String generaINClause(Long[] oids) throws MareException {
        UtilidadesLog.info("DAOConcurso.generaINClause(Long[] oids): Entrada");
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
        }
        catch (Exception ex) {
            
        }

        UtilidadesLog.info("DAOConcurso.generaINClause(Long[] oids): Salida");
        return sClausula.toString();
    }
    
     private RecordSet armaRSetFinal(RecordSet r, RecordSet rAccesos) {
        // Arma el RecordSet final añadiendo los valores de Desc en rAcceso 
        //al RecordSet r. 
        UtilidadesLog.info("DAOConcurso.armaRSetFinal(RecordSet r, RecordSet rAccesos): Entrada");
        UtilidadesLog.debug("****** RS CASI FINAL: " + r);
        UtilidadesLog.debug("****** rAccesos: " + rAccesos);

        for (int i = 0; i < r.getRowCount(); i++) {
            String descAcceso = (String) rAccesos.getValueAt(i, 1);
            r.setValueAt(descAcceso, i, 8);
        }

        UtilidadesLog.debug("******** RecordSet FINAL: " + r);
        
        UtilidadesLog.info("DAOConcurso.armaRSetFinal(RecordSet r, RecordSet rAccesos): Salida");

        return r;
    }    

    /**
     * @author: ssaavedra, 2/6/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param Long
     */
    public ArrayList obtenerMontoMinimoRangoConsultoras(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMontoMinimoRangoConsultoras(Long oidConcurso): Entrada");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        String codigoError = null;
        ArrayList arrReturn = new ArrayList();

        query.append(" SELECT A.OID_MONT_MINI_RANG_CONS ");
        query.append(" from ");
        query.append(" INC_MONTO_MINIM_RANGO_CONSU A, ");
        query.append(" INC_CLASI_PARTI_CALIF B, ");
        //query.append(" INC_ESTAT_VENTA_CONSU C ");
        query.append(" INC_ESTAT_VENTA C "); //Inc 21722
        query.append(" where ");
        query.append(" CLPC_OID_CLAS_PART_CALI = OID_CLAS_PART_CALI ");
        //query.append(" AND A.ESVE_OID_ESTA_VENT = C.OID_ESTA_VENT ");
        query.append(" AND A.ESTV_OID_ESTA_VENT = C.OID_ESTA_VENT ");
        query.append(" AND B.COPA_OID_PARA_GRAL = C.COPA_OID_PARA_GRAL ");
        query.append(" AND C.COPA_OID_PARA_GRAL = " + oidConcurso.longValue());

        UtilidadesLog.debug("query obtenerMontoMinimoRangoConsultoras: " + query);

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("Rs retornado: " + rs);

        if ((rs != null) && !rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                arrReturn.add(new Long(((BigDecimal) rs.getValueAt(i, "OID_MONT_MINI_RANG_CONS")).toString()));
            }
        }

        UtilidadesLog.info("DAOConcurso.obtenerMontoMinimoRangoConsultoras(Long oidConcurso): Salida");
        return arrReturn;
    }

    public String obtenerCodigoMaximo(String codigo) throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerCodigoMaximo(String codigo): Entrada");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;
        String maxCod = null;
        StringBuffer query = new StringBuffer("");

        query.append(" SELECT NUM_CONC");
        query.append(" FROM INC_CONCU_PARAM_GENER  ");
        query.append(" WHERE  ");
        query.append(" NUM_CONC LIKE '" + codigo + "%' ");
        query.append(" ORDER BY NUM_CONC DESC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(sCodigoError));
        }

        if (!rs.esVacio()) {
            maxCod = (String) rs.getValueAt(0, 0);
        }

        UtilidadesLog.info("DAOConcurso.obtenerCodigoMaximo(String codigo): Salida");
        return maxCod;
    }

    /**
     * @author: ssantana, 3/6/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param Long oidConcurso
     * @param Long oidDirigidoA
     */
    public ArrayList obtenerListasCalificacionParticipantes(Long oidDirigidoA, Long oidConcurso, Long oidIdioma)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerListasCalificacionParticipantes(Long oidDirigidoA, Long oidConcurso, Long oidIdioma): Entrada");

        ArrayList aList = new ArrayList();
        BelcorpService bs = null;
        RecordSet r = null;

        StringBuffer sqlQuery = new StringBuffer("");
        /*sqlQuery.append(" SELECT inc_clasi_parti_calif.oid_clas_part_cali, v_gen_i18n_sicc.val_i18n, ");
        sqlQuery.append(" inc_clasi_parti_calif.paci_oid_part_conc_cabe ");
        sqlQuery.append(" FROM inc_clasi_parti_calif, v_gen_i18n_sicc ");
        sqlQuery.append(" WHERE inc_clasi_parti_calif.paci_oid_part_conc_cabe = v_gen_i18n_sicc.val_oid ");
        sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'INC_PARTI_CONCU_CABEC' ");
        sqlQuery.append(" AND inc_clasi_parti_calif.copa_oid_para_gral = " + oidConcurso);*/
        //modificador por V-INC22
        
        
        sqlQuery.append("  SELECT    inc_clasi_parti_calif.oid_clas_part_cali OIDCLASPARTCALI,  ");
        //sqlQuery.append("            PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+oidIdioma);
        //sqlQuery.append("            ,inc_clasi_parti_calif.paci_oid_part_conc_cabe,");
        //sqlQuery.append("           'INC_PARTI_CONCU_CABEC') DESCLASIFIPARTICIPANTES,  ");
        sqlQuery.append("            inc_parti_concu_cabec.des_desc DESCLASIFIPARTICIPANTES, ");
        sqlQuery.append("            inc_clasi_parti_calif.paci_oid_part_conc_cabe OIDPARTCONCCABE , ");
        sqlQuery.append("            inc_monto_minim_rango_consu.imp_mont_mini  impmontminiconsultora, ");
        sqlQuery.append("            inc_estat_venta.esta_oid_esta_clie OIDESTACLIEN , ");
        sqlQuery.append("            PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+ oidIdioma);
        sqlQuery.append("            ,mae_estat_clien.oid_esta_clie,");
        sqlQuery.append("            'MAE_ESTAT_CLIEN') DESESTADOCLIENTE, ");
        sqlQuery.append("            inc_monto_minim_rango_geren.imp_monto_minim impmontminigerente ");
        sqlQuery.append("     FROM   inc_monto_minim_rango_consu, ");
        sqlQuery.append("            inc_estat_venta, ");
        sqlQuery.append("            mae_estat_clien, "); 
        sqlQuery.append("            inc_clasi_parti_calif, ");
        sqlQuery.append("            inc_monto_minim_rango_geren,  ");
        sqlQuery.append("            inc_parti_concu_cabec ");      // Agregado por HRCS (Incidencia V-INC-033)
        sqlQuery.append("    WHERE   inc_clasi_parti_calif.oid_clas_part_cali = inc_monto_minim_rango_consu.clpc_oid_clas_part_cali(+) ");
        sqlQuery.append("        AND Inc_clasi_parti_calif.oid_clas_part_cali = inc_monto_minim_rango_geren.clpc_oid_clas_part_cali(+) ");
        sqlQuery.append("        AND inc_monto_minim_rango_consu.estv_oid_esta_vent = inc_estat_venta.oid_esta_vent ");
        sqlQuery.append("        AND inc_estat_venta.esta_oid_esta_clie = mae_estat_clien.oid_esta_clie ");
        sqlQuery.append("        AND inc_clasi_parti_calif.paci_oid_part_conc_cabe = inc_parti_concu_cabec.oid_part_conc_cabe ");  // Agregado por HRCS (Incidencia V-INC-033)
        sqlQuery.append("        AND inc_clasi_parti_calif.copa_oid_para_gral = "+ oidConcurso);


        bs = BelcorpService.getInstance();

        try {
            UtilidadesLog.debug("Realiza query...");
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        if (!r.esVacio()) {
            int cantFilas = r.getRowCount();
            DTOCalificacionParticipante dtoCalificacionParticipante = null;

            for (int i = 0; i < cantFilas; i++) {
                UtilidadesLog.debug("Bucle " + i + "/" + (cantFilas - 1));
                dtoCalificacionParticipante = new DTOCalificacionParticipante();

                if (r.getValueAt(i, "OIDCLASPARTCALI") != null) {
                    dtoCalificacionParticipante.setOid(new Long(((BigDecimal)r.getValueAt(i, "OIDCLASPARTCALI")).longValue()));
                }
                if (r.getValueAt(i, "OIDPARTCONCCABE") != null) {
                    dtoCalificacionParticipante.setOidParticipante(new Long(((BigDecimal)r.getValueAt(i, "OIDPARTCONCCABE")).longValue()));
                }
                if(r.getValueAt(i, "DESCLASIFIPARTICIPANTES")!=null){
                    dtoCalificacionParticipante.setDesParticipante(r.getValueAt(i, "DESCLASIFIPARTICIPANTES").toString());
                }

                if (oidDirigidoA.longValue() == ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue()) {
                    //modificador por V-INC22
                    //dtoCalificacionParticipante = this.oidDirigidoAConsultora(dtoCalificacionParticipante, oidIdioma);
                    if(r.getValueAt(i,"DESESTADOCLIENTE")!=null){
                        dtoCalificacionParticipante.setDesEstatusVenta(r.getValueAt(i,"DESESTADOCLIENTE").toString());
                    }
                    if(r.getValueAt(i,"IMPMONTMINICONSULTORA")!=null){
                        dtoCalificacionParticipante.setMontoMinimo((BigDecimal)r.getValueAt(i,"IMPMONTMINICONSULTORA"));
                    }
                    if (r.getValueAt(i,"OIDESTACLIEN")!=null) {
                        dtoCalificacionParticipante.setOidEstatusVenta(new Long(((BigDecimal)r.getValueAt(i,"OIDESTACLIEN")).longValue()));
                    }
                }

                if (oidDirigidoA.longValue() == ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
                    //modificador por V-INC22
                    //dtoCalificacionParticipante = this.oidDirigidoAGerente(dtoCalificacionParticipante);
                    if(r.getValueAt(i,"IMPMONTMINIGERENTE")!=null){
                        dtoCalificacionParticipante.setMontoMinimo((BigDecimal)r.getValueAt(i,"IMPMONTMINIGERENTE"));
                    }
                }
                aList.add(dtoCalificacionParticipante);
            }
        }

        UtilidadesLog.info("DAOConcurso.obtenerListasCalificacionParticipantes(Long oidDirigidoA, Long oidConcurso, Long oidIdioma): Salida");
        return aList;
    }

    /**
     * @author: ssantana
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOCalificacionParticipante
     * @param Long oidIdioma
     * @param DTOCalificacionParticipante dtoCalificacionParticipante
     */
    private DTOCalificacionParticipante oidDirigidoAConsultora(DTOCalificacionParticipante dtoCalificacionParticipante, Long oidIdioma)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.oidDirigidoAConsultora(DTOCalificacionParticipante dtoCalificacionParticipante, Long oidIdioma): Entrada");

        BelcorpService bs = null;
        RecordSet r = null;

        StringBuffer sqlQuery = new StringBuffer("");

        // ssantana, 21/6/2005 - Inc. 18472
        sqlQuery.append(" SELECT inc_monto_minim_rango_consu.imp_mont_mini, ");
        //sqlQuery.append(" inc_monto_minim_rango_consu.esve_oid_esta_vent, ");
        sqlQuery.append(" inc_estat_venta.ESTA_OID_ESTA_CLIE, ");
        sqlQuery.append(" v_gen_i18n_sicc.val_i18n ");
        sqlQuery.append(" FROM inc_monto_minim_rango_consu, ");
        //sqlQuery.append(" inc_estat_venta_consu, ");//Inc 21722
        sqlQuery.append(" inc_estat_venta, ");
        sqlQuery.append(" mae_estat_clien, ");
        sqlQuery.append(" v_gen_i18n_sicc ");
        sqlQuery.append(" WHERE inc_monto_minim_rango_consu.clpc_oid_clas_part_cali = " + dtoCalificacionParticipante.getOid());
        //sqlQuery.append(" AND inc_monto_minim_rango_consu.esve_oid_esta_vent = inc_estat_venta.oid_esta_vent ");
        sqlQuery.append(" AND inc_monto_minim_rango_consu.ESTV_OID_ESTA_VENT = inc_estat_venta.oid_esta_vent ");
        sqlQuery.append(" AND inc_estat_venta.esta_oid_esta_clie = mae_estat_clien.oid_esta_clie ");
        sqlQuery.append(" AND mae_estat_clien.oid_esta_clie = v_gen_i18n_sicc.val_oid ");
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_ESTAT_CLIEN' ");
        sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + oidIdioma);
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");

        bs = BelcorpService.getInstance();

        try {
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        // Segun DMCO (inc. BELC300018472) solo se obtendria UN SOLO registro. 
        if (!r.esVacio()) {
            UtilidadesLog.debug("RecordSet no es vacio, setea valores");

            BigDecimal bigMontoMinimo = (BigDecimal) r.getValueAt(0, 0);
            BigDecimal bigOidEstatusVenta = (BigDecimal) r.getValueAt(0, 1);
            String sDescEstatusVenta = (String) r.getValueAt(0, 2);

            dtoCalificacionParticipante.setMontoMinimo(bigMontoMinimo);

            if (bigOidEstatusVenta != null) {
                dtoCalificacionParticipante.setOidEstatusVenta(new Long(bigOidEstatusVenta.longValue()));
            }

            dtoCalificacionParticipante.setDesEstatusVenta(sDescEstatusVenta);
        }

        UtilidadesLog.info("DAOConcurso.oidDirigidoAConsultora(DTOCalificacionParticipante dtoCalificacionParticipante, Long oidIdioma): Salida");
        return dtoCalificacionParticipante;
    }

    /**
     * @author: ssantana
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOCalificacionParticipante
     * @param DTOCalificacionParticipante dtoCalificacionParticipante
     */
    private DTOCalificacionParticipante oidDirigidoAGerente(DTOCalificacionParticipante dtoCalificacionParticipante)
            throws MareException {
        UtilidadesLog.info("DAOConcurso.oidDirigidoAGerente(DTOCalificacionParticipante dtoCalificacionParticipante): Entrada");
        
        RecordSet r = null;
        BelcorpService bs = null;
        StringBuffer sqlQuery = new StringBuffer("");

        //Realiza una consulta utilizando el servicio DBService.
        sqlQuery.append(" SELECT inc_monto_minim_rango_geren.imp_monto_minim ");
        sqlQuery.append(" FROM inc_monto_minim_rango_geren ");
        sqlQuery.append(" WHERE inc_monto_minim_rango_geren.clpc_oid_clas_part_cali = " + dtoCalificacionParticipante.getOid());

        bs = BelcorpService.getInstance();

        try {
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }

        if (!r.esVacio()) {
            //del registro obtenido  en el RecordSet si no es nulo hacer:
            BigDecimal bigMontoMinimo = (BigDecimal) r.getValueAt(0, 0);
            dtoCalificacionParticipante.setMontoMinimo(bigMontoMinimo);
        }

        UtilidadesLog.info("DAOConcurso.oidDirigidoAGerente(DTOCalificacionParticipante dtoCalificacionParticipante): Salida");
        return dtoCalificacionParticipante;
    }
    
        /**
     * @author: Cleal
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaEstatusVenta
     */
    public DTOListaEstatusVenta obtenerListaEstatusVentaCalificacion(DTOOID DTOE) throws MareException{
        //Descripción: obtiene la lista de estatus de venta para el mantenimiento de los parametros de calificacion. 
        UtilidadesLog.info("DAOConcurso.obtenerListaEstatusVentaCalificacion(): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOListaEstatusVenta dtoL = null;
        DTOEstatusVenta dtoEV = new DTOEstatusVenta();
        
          query.append(" SELECT ");
          query.append(" IEV.OID_ESTA_VENT OID, ");
          query.append(" MEC.OID_ESTA_CLIE OID_ESTA_CLIE, ");
          query.append(" VG.VAL_I18N DESC_ESTA_CLIE, ");
          query.append(" CRP_D.OID_PERI OID_PERI_DESDE, ");
          query.append(" CRP_D.VAL_NOMB_PERI DESC_PERI_DESDE, ");
          query.append(" CRP_H.OID_PERI OID_PERI_HASTA, ");
          query.append(" CRP_H.VAL_NOMB_PERI DESC_PERI_HASTA");
          query.append(" FROM  ");
          query.append(" INC_ESTAT_VENTA IEV, ");
          query.append(" MAE_ESTAT_CLIEN MEC, ");
          query.append(" CRA_PERIO CRP_D, ");
          query.append(" CRA_PERIO CRP_H, ");
          query.append(" V_GEN_I18N_SICC VG ");
          query.append(" WHERE  ");
          query.append(" IEV.ESTA_OID_ESTA_CLIE = MEC.OID_ESTA_CLIE ");
          query.append(" AND IEV.PERD_OID_PERI_DESD = CRP_D.OID_PERI ");  
          query.append(" AND IEV.PERD_OID_PERI_HAST = CRP_H.OID_PERI ");
          query.append(" AND  VG.ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
          query.append(" AND  VG.VAL_OID = MEC.OID_ESTA_CLIE ");
          
           if (DTOE != null) {
            if (DTOE.getOidIdioma() != null) {
                query.append(" AND VG.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }

             if (DTOE.getOid() != null) {
                query.append(" AND IEV.COPA_OID_PARA_GRAL = " + DTOE.getOid());
            }
        }
        
            try {
                bs = BelcorpService.getInstance();
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (MareMiiServiceNotFoundException e) {
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
            if(rs!=null && !rs.esVacio()){
                ArrayList arr = new ArrayList();
                dtoL = new DTOListaEstatusVenta();
                for(int i=0; i<rs.getRowCount();i++){
                    dtoEV = new DTOEstatusVenta();
                    dtoEV.setOidEstatus(new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString()));
                    dtoEV.setOidEstatusVentaMae(new Long(((BigDecimal) rs.getValueAt(i, "OID_ESTA_CLIE")).toString()));
                    dtoEV.setOidPeriodoDesde(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERI_DESDE")).toString()));
                    dtoEV.setOidPeriodoHasta(new Long(((BigDecimal) rs.getValueAt(i, "OID_PERI_HASTA")).toString()));
                    dtoEV.setDesEstatus(rs.getValueAt(i, "DESC_ESTA_CLIE").toString());
                    dtoEV.setDesPeriodoDesde(rs.getValueAt(i, "DESC_PERI_DESDE").toString());
                    dtoEV.setDesPeriodoHasta(rs.getValueAt(i, "DESC_PERI_HASTA").toString());
                    arr.add(dtoEV);
                }
                dtoL.setEstatusVenta(arr);
            }
            UtilidadesLog.info("DAOConcurso.obtenerListaEstatusVentaCalificacion(): Salida");
            return dtoL;
    }
    
     /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       25/06/2006
           * @version     1.0
           * @autor       mdolce
           */
    public DTOSalida obtenerBaseIncumplimiento(DTOBelcorp dtoe)throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerBaseIncumplimiento(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT base.oid_base_incu, descripcion.val_i18n ");
        query.append(" FROM inc_base_incum base, gen_i18n_sicc descripcion ");
        query.append(" WHERE base.oid_base_incu = descripcion.val_oid ");
        query.append(" AND descripcion.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND descripcion.attr_enti = 'INC_BASE_INCUM' ");
        query.append(" AND descripcion.attr_num_atri = 1 ");


        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerBaseIncumplimiento(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    
     public DTOSalida obtenerConcursosMonetarios(DTOBusquedaClienteCalificado dtoe)throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerConcursosMonetarios(DTOBusquedaClienteCalificado dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT distinct concu.oid_para_gral, concu.num_conc || ' ' || concu.num_vers ");
        query.append(" FROM inc_concu_param_gener concu, ");
        query.append(" inc_param_gener_premi gralpremi, ");
        query.append(" inc_param_nivel_premi nivelpremi, ");
        query.append(" inc_premi_monet pmonet ");
        query.append(" WHERE pmonet.fpag_oid_form_pago = 2 ");
        query.append(" AND pmonet.panp_oid_para_nive_prem = nivelpremi.oid_para_nive_prem ");
        query.append(" AND nivelpremi.pagp_oid_para_gene_prem = gralpremi.oid_para_gene_prem ");
        query.append(" AND gralpremi.copa_oid_para_gral = concu.oid_para_gral ");
		   	query.append(" and concu.MARC_OID_MARC = " + dtoe.getOidMarca());
			  query.append(" and concu.CANA_OID_CANA = " + dtoe.getOidCanal());
			  query.append(" and concu.PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append(" ORDER BY 1 ");


        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerConcursosMonetarios(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    
     public DTOSalida obtenerMontoVentaRep(DTOBelcorp dtoe)throws MareException {
        UtilidadesLog.info("DAOConcurso.obtenerMontoVentaRep(DTOBelcorp dtoe): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT MAX (imp) ");
        query.append("FROM (SELECT   SUM (imp_mont) AS imp, punta.clie_oid_clie AS cli ");
        query.append("FROM inc_solic_concu_punta punta ");
        query.append("WHERE punta.clie_oid_clie NOT IN (SELECT gana.clie_oid_clie ");
        query.append("FROM inc_ganad gana) ");
        query.append("GROUP BY punta.clie_oid_clie) ");


        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOConcurso.obtenerMontoVentaRep(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    
      /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/07/2007
           * @version     1.0
           * @autor       cvalenzuela
           */
    
    public RecordSet obtenerTiposPrograma(DTOBelcorp DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerTiposPrograma(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
        query.append(" SELECT OID_TIPO_PROG, DES_TIPO_PROG ");
        query.append(" FROM INC_CONCU_TIPO_PROG ");
        query.append(" ORDER BY DES_TIPO_PROG ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTiposPrograma(DTOBelcorp DTOE): Salida");
        return rs;
    }

 public RecordSet obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
        query.append(" Select i.OID_PARA_GRAL, i.NUM_CONC ");
        query.append(" FROM INC_CONCU_PARAM_GENER i ");
        query.append(" where i.PAIS_OID_PAIS = "+DTOE.getOidPais() );
        query.append(" and i.CANA_OID_CANA = "+DTOE.getOidCanal() );
        query.append(" and i.MARC_OID_MARC = "+DTOE.getOidMarca() );
        query.append(" and i.IND_ACTI = 1 ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE): Salida");
        return rs;
    }

 public RecordSet obtenerTipoMovimiento(DTOBelcorp DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerTipoMovimiento(DTOBuscarConcursos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
        query.append(" SELECT TM.OID_TIPO_MOVI,  ");
        query.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC( "+DTOE.getOidIdioma());
        query.append(" ,TM.OID_TIPO_MOVI,'INC_TIPO_MOVIM')DESCRIP ");
        query.append(" FROM INC_TIPO_MOVIM TM ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTipoMovimiento(DTOBuscarConcursos DTOE): Salida");
        return rs;
    }
  public RecordSet obtenerClienteParticipante(DTOMovimientoCtaCte DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerTipoMovimiento(DTOBuscarConcursos DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
	
        query.append(" SELECT TIC.CLIE_OID_CLIE, COPA_OID_PARA_GRAL ");
        query.append("   FROM INC_CLASI_PARTI_CONCU PAC, ");
        query.append("        INC_PARTI_CONCU_DETAL PAD, ");
        query.append("        V_MAE_TIPIF_CLIEN TIC, ");
        query.append("        MAE_CLIEN MC ");
        query.append("  WHERE PAC.PACI_OID_PART_CONC_CABE = PAD.PACI_OID_PART_CONC_CABE ");
        query.append("    AND NVL (PAD.TICL_OID_TIPO_CLIE, -1) = DECODE (PAD.TICL_OID_TIPO_CLIE, ");
        query.append("                       NULL, -1,TIC.TICL_OID_TIPO_CLIE) ");
        query.append("    AND NVL (PAD.SBTI_OID_SUBT_CLIE, -1) = DECODE (PAD.SBTI_OID_SUBT_CLIE, ");
        query.append("                       NULL, -1, TIC.SBTI_OID_SUBT_CLIE) ");
        query.append("    AND NVL (PAD.TCCL_OID_TIPO_CLAS, -1) = DECODE (PAD.TCCL_OID_TIPO_CLAS, ");
        query.append("                      NULL, -1,TIC.TCCL_OID_TIPO_CLASI) ");
        query.append("    AND NVL (PAD.CLAS_OID_CLAS, -1) =DECODE (PAD.CLAS_OID_CLAS, ");
        query.append("                                 NULL, -1,TIC.CLAS_OID_CLAS) ");
        query.append("          AND TIC.CLIE_OID_CLIE = MC.OID_CLIE ");
        query.append(" 		 AND MC.COD_CLIE = '"+DTOE.getCodCliente()+"'");
        query.append("    AND COPA_OID_PARA_GRAL = "+ DTOE.getOidConcurso());

        
        
        
        
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTipoMovimiento(DTOBuscarConcursos DTOE): Salida");
        if(rs.esVacio()){
          return null;
        }
        return rs;
    
    }
 
   public RecordSet obtenerDescalificacionClienteConcurso(Long cliente, Long concurso) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerDescalificacionesCliente(Long cliente, Long concurso ):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT id.OID_DESC, id.FEC_DESC, id.CLIE_OID_CLIE, ");
        query.append(" id.COPA_OID_PARA_GRAL, id.PERD_OID_PERI, id.CADE_OID_CAUS_DESC ");
        query.append(" FROM INC_DESCA id, inc_concu_param_gener con ");
        query.append(" WHERE id.CLIE_OID_CLIE = "+cliente);
        query.append(" and con.IND_ACTI = 1 ");
        query.append(" and con.OID_PARA_GRAL = ID.COPA_OID_PARA_GRAL ");
        query.append(" and con.OID_PARA_GRAL ="+concurso);
        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
            UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            return null;
        }
        UtilidadesLog.info("DAOClientePremiacion.obtenerDescalificacionesCliente(Long cliente, Long concurso ):Salida");
        return rs;
        
    }   
    
    // vbongiov -- Cambio 20090930 -- 16/07/2009
    public RecordSet obtenerClasificacionConcurso(DTOBelcorp DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerTiposPrograma(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT OID_CLAS_CONC, DES_CLAS_CONC ");
        query.append(" FROM INC_CLASI_CONCU ");
        query.append(" ORDER BY DES_CLAS_CONC ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTiposPrograma(DTOBelcorp DTOE): Salida");
        return rs;
    }
    //Agregado por cambio 20090929 09/09/20009
     public RecordSet validaDeuda(DTOBelcorp dtoe) throws MareException{
           UtilidadesLog.info("DAOConcurso.validarDeuda(DTOBelcorp dtoe): Entrada");
           BelcorpService bs;
           RecordSet rs;
           String codigoError;      

           StringBuffer query = new StringBuffer();
           
           query.append(" SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
           query.append("         FROM V_GEN_I18N_SICC  ");
           query.append("              WHERE  V_GEN_I18N_SICC.ATTR_ENTI = 'INC_VALID_DEUDA' ");
           query.append("                      AND V_GEN_I18N_SICC.IDIO_OID_IDIO =  " + dtoe.getOidIdioma());
           query.append("                      AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
           
           try {
               bs = BelcorpService.getInstance();
               rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (MareMiiServiceNotFoundException e) {
               codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           } catch (Exception e) {
               UtilidadesLog.error("ERROR ", e);
               codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
               throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           }
           
           UtilidadesLog.info("DAOConcurso.validarDeuda(DTOBelcorp dtoe): Salida");
           return rs;
     }

    // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
    public RecordSet obtenerTipoOfertaConcurso(DTOBelcorp DTOE) throws MareException {        
        UtilidadesLog.info("DAOConcurso.obtenerTipoOfertaConcurso(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT OID_TIPO_OFER_CONC, DES_TIPO_OFER_CONC ");
        query.append(" FROM INC_TIPO_OFERT_CONCU ");
        query.append(" ORDER BY DES_TIPO_OFER_CONC ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOConcurso.obtenerTipoOfertaConcurso(DTOBelcorp DTOE): Salida");
        return rs;
    }

    // sapaza -- PER-SiCC-2011-0295 -- 08/06/2011
    private RecordSet obtienePremiosDespachadosPorOid(Long[] arrayOids)
           throws MareException {
       UtilidadesLog.info("DAOConcurso.obtienePremiosDespachagosPorOid(Long[] arrayOids): Entrada");
       StringBuffer query = new StringBuffer();
       RecordSet rs = new RecordSet();
       BelcorpService belcorpService = null;

       String oids = this.generaINClause(arrayOids);

       query.append(" SELECT inc_concu_param_gener.oid_para_gral oid, ");
       query.append("        NVL((SELECT 1 ");
       query.append("           FROM inc_ganad gan, inc_param_nivel_premi pre, inc_param_gener_premi pge ");
       query.append("          WHERE gan.panp_oid_para_nive_prem = pre.oid_para_nive_prem ");
       query.append("            AND pre.pagp_oid_para_gene_prem = pge.oid_para_gene_prem ");
       query.append("            AND pge.copa_oid_para_gral = inc_concu_param_gener.oid_para_gral ");
       query.append("            AND ROWNUM = 1),0) encontrado ");
       query.append(" FROM inc_concu_param_gener ");
       query.append(" WHERE inc_concu_param_gener.OID_PARA_GRAL " + oids);
       query.append(" ORDER BY inc_concu_param_gener.oid_para_gral ");        

       try {
           rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
       }
       catch (Exception e) {
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e, 
           UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }

       UtilidadesLog.info("DAOConcurso.obtienePremiosDespachadosPorOid(Long[] arrayOids): Salida");
       return rs;
    }

    // sapaza -- PER-SiCC-2011-0295 -- 08/06/2011
    private RecordSet armaRSetFinalAux(RecordSet r, RecordSet rDespachos) {
       // Arma el RecordSet final añadiendo los valores de Desc en rAcceso 
       //al RecordSet r. 
       UtilidadesLog.info("DAOConcurso.armaRSetFinalAux(RecordSet r, RecordSet rDespachos): Entrada");
       UtilidadesLog.debug("****** RS CASI FINAL: " + r);
       UtilidadesLog.debug("****** rDespachos: " + rDespachos);

       for (int i = 0; i < r.getRowCount(); i++) {
           String descAcceso = rDespachos.getValueAt(i, 1).toString();
           r.setValueAt(descAcceso, i, 12);
       }

       UtilidadesLog.debug("******** RecordSet FINAL: " + r);
       
       UtilidadesLog.info("DAOConcurso.armaRSetFinalAux(RecordSet r, RecordSet rDespachos): Salida");

       return r;
    }
    
}

