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
 * @autor: Igor Dedough
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOCabeceraPremElegidos;
import es.indra.sicc.dtos.inc.DTODetallePremElegidos;
import es.indra.sicc.dtos.inc.DTOElegirPremiosRec;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.PremiosElegidosLocal;
import es.indra.sicc.entidades.inc.PremiosElegidosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.ejb.CreateException;
import es.indra.sicc.dtos.inc.DTOBuscarClientesConcurso;
import es.indra.sicc.util.DTODate;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOMantenimientoPremiacion {
    private static final boolean debug = true;

    public DAOMantenimientoPremiacion() {
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dto
     * @version 1.0 24 may 2005
     * @author Igor Dedough
     * Modificado: Cristian Valenzuela
     * Fecha: 27/06/2006
     * Incidencia: DBLG500000953
     * Comentario: Se agrega la funcion TRUNC para que elimine la hora
     * de la fecha en el filtro de la consulta
     */
    public DTOSalida buscarConcursosPremiosRec(DTOElegirPremiosRec dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoPremiacion.buscarConcursosPremiosRec"
            +"(DTOElegirPremiosRec dto):Entrada");        

        StringBuffer consulta = new StringBuffer("");
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();

        consulta.append(" SELECT cpg.oid_para_gral OID, i18n.val_i18n pais, ");
        consulta.append(" cpg.num_conc numeroconcurso, ");
        consulta.append(" cpg.num_vers VERSION, ");
        consulta.append(" cpg.val_nomb nombreconcurso, ");
        consulta.append(" marca.des_marc marca, canal.cod_cana canal, ");
        consulta.append(" peridesde.val_nomb_peri periododesde, ");
        consulta.append(" perihasta.val_nomb_peri periodohasta ");
        consulta.append(" FROM inc_concu_param_gener cpg, ");
        consulta.append(" cra_perio peridesde, ");
        consulta.append(" cra_perio perihasta, ");
        consulta.append(" v_gen_i18n_sicc i18n, ");
        consulta.append(" seg_marca marca, ");
        consulta.append(" seg_canal canal ");
        consulta.append(" WHERE cpg.diri_oid_diri = " + ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
        consulta.append(" AND cpg.bcal_oid_base_calc = " + ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS);
        consulta.append(" AND peridesde.fec_inic <= TRUNC(SYSDATE) ");        
        consulta.append(" AND TRUNC(SYSDATE) <= perihasta.fec_fina ");
        consulta.append(" AND i18n.attr_num_atri = 1 ");
        
        if (dto.getOidIdioma() != null) {
            consulta.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        }

        consulta.append(" AND i18n.ATTR_ENTI = 'SEG_PAIS' ");

        if (dto.getOidPais() != null) {
            consulta.append(" AND i18n.VAL_OID = " + dto.getOidPais());
        }

        consulta.append(" AND cpg.PERD_OID_PERI_DESD = periDesde.OID_PERI ");
        consulta.append(" AND cpg.PERD_OID_PERI_HAST = periHasta.OID_PERI ");
        consulta.append(" AND cpg.CANA_OID_CANA = canal.OID_CANA ");
        consulta.append(" AND cpg.MARC_OID_MARC = marca.OID_MARC ");

        if (dto.getOidPais() != null) {
            consulta.append(" AND cpg.PAIS_OID_PAIS = " + dto.getOidPais());
        }

        try {
            r = bs.dbService.executeStaticQuery(consulta.toString());            
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
        }

        if (r.esVacio()) {
            /*throw new MareException(null, null,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            */
        }

        UtilidadesLog.debug("**** Resultado de consulta " + r.toString());        

        DTOSalida output = new DTOSalida();
        output.setResultado(r);
        UtilidadesLog.info("DAOMantenimientoPremiacion.buscarConcursosPremiosRec"
        +"(DTOElegirPremiosRec dto):Salida");
        return output;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dto
     * @version 1.00 17 jun 2005
     * @author Cristian Valenzuela
     * Modificado:    Cristian Valenzuela
     * Incidencias:   DBLG500000582, DBLG500000583
     * Fecha:         19/4/2006
     */
    public DTOSalida buscarNivelesPremiacion(DTOElegirPremiosRec dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoPremiacion.buscarNivelesPremiacion "
            +"(DTOElegirPremios Rec dto):Salida");
        UtilidadesLog.debug("Entro a buscarNivelesPremiacion - "
            +"DAOMantenimientoPremiacion");

        StringBuffer consulta = new StringBuffer("");
        RecordSet r = null;
        BelcorpService bs = null;
        bs = BelcorpService.getInstance();

        consulta.append(" SELECT rownum OID, ");        
        consulta.append(" pnp.NUM_NIVE AS numeronivel, ");
        consulta.append(" NVL (lpa.num_prem, ");
        consulta.append(" NVL (pm.num_prem,  ");
        consulta.append(" NVL (pd.num_prem, pp.num_prem))) numeropremio, ");
        consulta.append(" i.val_i18n tipopremio, ");        
        consulta.append(" NVL (NVL (pnp.num_cant_fija_punt,  ");
        consulta.append(" pnp.num_cant_inic_punt), 0) costepuntos, ");        
        consulta.append(" pg.oid_para_gral, ");
        consulta.append(" pg.perd_oid_peri_desd, ");
        consulta.append(" pg.num_conc, pg.num_vers, ");
        consulta.append(" pnp.num_cant_inic_punt cantidadinicial, ");
        consulta.append(" pnp.num_cant_fina_punt cantidadfinal, ");
        consulta.append(" pnp.val_punt_serv puntosservicio, ");
        consulta.append(" pgp.IND_NIVE_ELEG nivelelegido, ");
        consulta.append(" pnp.oid_para_nive_prem ");
        consulta.append(" FROM inc_concu_param_gener pg, ");
        consulta.append(" inc_param_gener_premi pgp, ");
        consulta.append(" inc_param_nivel_premi pnp, ");
        consulta.append(" inc_premi_artic pa, ");
        consulta.append(" inc_lote_premi_artic lpa, ");
        consulta.append(" inc_premi_monet pm, ");
        consulta.append(" inc_premi_descu pd, ");
        consulta.append(" inc_premi_punto pp, ");
        consulta.append(" inc_tipo_premi tp, ");
        consulta.append(" v_gen_i18n_sicc i ");
        consulta.append(" WHERE pg.oid_para_gral = " + dto.getOidConcurso());
        consulta.append(" AND pgp.copa_oid_para_gral = pg.oid_para_gral ");
        consulta.append(
            " AND pgp.oid_para_gene_prem = pnp.pagp_oid_para_gene_prem ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pa.panp_oid_para_nive_prem(+) ");
        consulta.append(" AND lpa.prar_oid_prem_arti(+) = pa.oid_prem_arti ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pm.panp_oid_para_nive_prem(+) ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pd.oid_para_nive_prem(+) ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pp.panp_oid_para_nive_prem(+) ");
        consulta.append(" AND pnp.tpre_oid_tipo_prem = tp.oid_tipo_prem ");
        consulta.append(" AND i.attr_enti = 'INC_TIPO_PREMI' ");
        consulta.append(" AND i.attr_num_atri = 1 ");
        consulta.append(" AND i.val_oid = tp.oid_tipo_prem ");
        consulta.append(" AND i.idio_oid_idio = " + dto.getOidIdioma());
        consulta.append(" ORDER BY OID ");

        try {
            r = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (r.esVacio()) {
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("**** Resultado de consulta " + r.toString());

        DTOSalida output = new DTOSalida();
        output.setResultado(r);

        UtilidadesLog.info("DAOMantenimientoRanking.buscarNivelesPremiacion("
            +" DTOElegirPremiosRec dto):Salida");

        return output;
    }

    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     * @version 1.00 24 jun 2005
     * @author Cristian Valenzuela
     */
    public void salvarPremiosElegidos(DTOCabeceraPremElegidos dtoe)
        throws MareException, CreateException {
        UtilidadesLog.info("DAOMantenimientoPremiacion.salvarPremiosElegidos("
            +"DTOCabeceraPremElegidos dtoe):entrada");
        UtilidadesLog.debug("DAOMantenimientoPremiacion.salvarPremiosElegidos");

        ArrayList datosDTOS = dtoe.getPremiosElegidos();
        int tamano = datosDTOS.size();
        try {            
            PremiosElegidosLocalHome pelh = this.getPremiosElegidosLocalHome();
            PremiosElegidosLocal pel;
    
            for (int i = 0; i < tamano; i++) {
                DTODetallePremElegidos dtoDetalle = (DTODetallePremElegidos) datosDTOS.get(i);
                pel = pelh.create(dtoDetalle.getNumeroPremio(),
                            dtoe.getOidCliente(), dtoe.getOidConcurso(),
                            dtoDetalle.getOidNivelPremiacion(),
                            new java.sql.Date(System.currentTimeMillis()));
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        

        UtilidadesLog.info("DAOMantenimientoRanking.salvarPremiosElegidos(DTO"
            +"CabeceraPremElegidos dtoe):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     * @version 1.00 17 jun 2005
     * @author Cristian Valenzuela
     */
    public DTOSalida cargarNivelesPremiacion(DTOCabeceraPremElegidos dtoe)
        throws MareException {
        UtilidadesLog.info( "DAOMantenimientoPremiacion.cargarNivelesPremiacion( "
            +"DTOCabeceraPremElegidos dtoe):Salida");
        UtilidadesLog.debug("Entro a cargarNivelesPremiacion - "
            +"DAOMantenimientoPremiacion");

        StringBuffer consulta = new StringBuffer("");
        RecordSet r = null;
        BelcorpService bs = null;
        bs = BelcorpService.getInstance();

        consulta.append(" SELECT * ");
        consulta.append(" FROM (SELECT rownum OID, ");
        //jrivas 23/2/2006
        //consulta.append(" pgp.NUM_NIVE AS numeronivel, ");
        consulta.append(" pnp.NUM_NIVE AS numeronivel, ");
        consulta.append(" NVL (lpa.num_prem, NVL (pm.num_prem, ");
        consulta.append(" NVL (pd.num_prem, pp.num_prem))) numeropremio, ");
        consulta.append(" i.val_i18n tipopremio, ");
        consulta.append(" NVL (NVL (pnp.num_cant_fija_punt,  ");
        consulta.append(" pnp.num_cant_inic_punt), 0) costepuntos, ");
        consulta.append(" pg.oid_para_gral, ");
        consulta.append(" pg.perd_oid_peri_desd,  ");
        consulta.append(" pg.num_conc, pg.num_vers, ");
        consulta.append(" pnp.num_cant_inic_punt cantidadinicial, ");
        consulta.append(" pnp.num_cant_fina_punt cantidadfinal, ");
        consulta.append(" pnp.val_punt_serv puntosservicio, ");
        consulta.append(" pgp.IND_NIVE_ELEG nivelelegido, ");
        consulta.append(" pnp.oid_para_nive_prem, pnp.VAL_NIVE_SELE ");
        consulta.append(" FROM inc_concu_param_gener pg, ");
        consulta.append(" inc_param_gener_premi pgp, ");
        consulta.append(" inc_param_nivel_premi pnp, ");
        consulta.append(" inc_premi_artic pa, ");
        consulta.append(" inc_lote_premi_artic lpa, ");
        consulta.append(" inc_premi_monet pm, ");
        consulta.append(" inc_premi_descu pd, ");
        consulta.append(" inc_premi_punto pp, ");
        consulta.append(" inc_tipo_premi tp, ");
        consulta.append(" v_gen_i18n_sicc i ");
        consulta.append(" WHERE pg.oid_para_gral = " + dtoe.getOidConcurso());
        consulta.append(" AND pgp.copa_oid_para_gral = pg.oid_para_gral ");
        consulta.append(
            " AND pgp.oid_para_gene_prem = pnp.pagp_oid_para_gene_prem ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pa.panp_oid_para_nive_prem(+) ");
        consulta.append(" AND lpa.prar_oid_prem_arti(+) = pa.oid_prem_arti ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pm.panp_oid_para_nive_prem(+) ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pd.oid_para_nive_prem(+) ");
        consulta.append(
            " AND pnp.oid_para_nive_prem = pp.panp_oid_para_nive_prem(+) ");
        consulta.append(" AND pnp.tpre_oid_tipo_prem = tp.oid_tipo_prem ");
        consulta.append(" AND i.attr_enti = 'INC_TIPO_PREMI' ");
        consulta.append(" AND i.attr_num_atri = 1 ");
        consulta.append(" AND i.val_oid = tp.oid_tipo_prem ");
        consulta.append(" AND i.idio_oid_idio = " + dtoe.getOidIdioma());
        consulta.append(" ORDER BY OID) ");
        consulta.append(" WHERE VAL_NIVE_SELE = 1 ");
        /*consulta.append(" WHERE nivelelegido = 1 ");
        consulta.append(" OR ((nivelelegido = 0 OR nivelelegido IS NULL) ");
        consulta.append(" AND (((cantidadinicial <= " +
            dtoe.getSaldoCliente() + ") ");
        consulta.append(" AND (( " + dtoe.getSaldoCliente() +
            " < cantidadfinal) OR cantidadfinal IS NULL)) ");
        consulta.append(" OR ((( " + dtoe.getSaldoCliente() +
            " + puntosservicio >= cantidadfinal)  ");
        consulta.append(" OR cantidadfinal IS NULL )))) ");*/

        try {
            r = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (r.esVacio()) {
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("* Resultado de consulta " + r.toString());

        DTOSalida output = new DTOSalida();
        output.setResultado(r);
        UtilidadesLog.info("DAOMantenimientoPremiacion.cargarNivelesPremiacion( "
            +"DTOCabeceraPremElegidos dtoe):Salida");

        return output;
    }

   /**
   * Sistema:     Belcorp
   * Modulo:      INC
   * Fecha:       23/12/2005
   * @version     1.0
   * @autor       Viviana Bongiovanni
   * Modificado:  Cristian Valenzuela
   * Fecha:       16/3/2006
   * Incidencia:  22724 
   */
   
    /*public RecordSet obtenerConcursos(DTOPaginado dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoRanking.obtenerConcursos(DTOPaginado dtoe): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
    
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException ex) {
        UtilidadesLog.error("ERROR ", e);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
    
      query.append(" SELECT CPG.OID_PARA_GRAL oid, CPG.NUM_CONC numeroConcurso, ");
      query.append(" CPG.NUM_VERS version, CPG.VAL_NOMB nombreConcurso ");
      query.append(" FROM INC_CONCU_PARAM_GENER CPG, INC_PARAM_GENER_PREMI PGP,INC_PLANT_CONCU PLC ");
      query.append(" WHERE CPG.OID_PARA_GRAL = PGP.COPA_OID_PARA_GRAL  ");
      query.append(" AND CPG.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" AND CPG.IND_ACTI = 1 ");
      query.append(" AND CPG.PLC2_OID_PLAN_CONC = PLC.OID_PLAN_CONC ");
      query.append(" AND PGP.IND_PREM_ELEC = 1 ");
    
      try {
          String queryPagina = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
                    
          rs = bs.dbService.executeStaticQuery(queryPagina);
          
      } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", e);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMantenimientoRanking.obtenerConcursos(DTOPaginado dtoe): Salida");
      return rs;

  }  */
 public RecordSet obtenerConcursos(DTODate dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoPremiacion.obtenerConcursos(DTODate dtoe): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
    
      try {
          bs = BelcorpService.getInstance();
      }
      catch (MareMiiServiceNotFoundException ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String fechaSdf = sdf.format(dtoe.getFecha());           
    
      query.append(" SELECT CPG.OID_PARA_GRAL oid, ");
      query.append(" cpg.num_conc || ' - ' || cpg.num_vers numeroconcurso, ");      
      query.append(" CPG.NUM_VERS version, CPG.VAL_NOMB nombreConcurso ");
      query.append(" FROM INC_CONCU_PARAM_GENER CPG, INC_PARAM_GENER_PREMI PGP,INC_PLANT_CONCU PLC, ");      
      query.append(" CRA_PERIO PER ");      
      query.append(" WHERE CPG.OID_PARA_GRAL = PGP.COPA_OID_PARA_GRAL  ");
      query.append(" AND CPG.PAIS_OID_PAIS = " + dtoe.getOidPais());	          
      query.append(" AND CPG.PERD_OID_PERI_DESD = PER.OID_PERI ");      
      query.append(" AND PER.FEC_INIC <= TO_DATE('" + fechaSdf + "', 'YYYY-MM-DD') ");      
      query.append(" AND CPG.IND_ACTI = 1 ");
      query.append(" AND CPG.PLC2_OID_PLAN_CONC = PLC.OID_PLAN_CONC ");
      query.append(" AND PGP.IND_PREM_ELEC = 1 ");
      query.append(" ORDER BY numeroconcurso ");          
    
      try {                   
          rs = bs.dbService.executeStaticQuery(query.toString());          
      }
      catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMantenimientoPremiacion.obtenerConcursos(DTODate dtoe): Salida");
      return rs;
  }

   /**
   * Sistema:     Belcorp
   * Modulo:      INC
   * Fecha:       26/12/2005
   * @version     3.0
   * @autor       Viviana Bongiovanni
   * Modificado:  Cristian Valenzuela
   * Incidencia:  22634
   * Fecha:       21/2/2006
   * Modificado:  Cristian Valenzuela
   * Incidencia:  DBLG500000581
   * Fecha:       19/4/2006
   */
  public RecordSet obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoPremiacion.obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      Long oidConcurso = null;
    
      try {
          bs = BelcorpService.getInstance();
      }
      catch (MareMiiServiceNotFoundException ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      // Obtiene el oid de concurso
      if(dtoe.getOidConcurso()!=null){
          oidConcurso = dtoe.getOidConcurso();
          
      }
      else {
          try {
              ConcursoParametrosGeneralesLocalHome concParamGenHome = this.getConcursoParametrosGeneralesLocalHome();              
              ConcursoParametrosGeneralesLocal concParamGen = concParamGenHome.findByCamposClave(dtoe.getNumeroConcurso().toString(),
                                                                                                 dtoe.getVersionConcurso(), dtoe.getOidPais());                                                                                     
              oidConcurso = concParamGen.getOid();                                                   
              
          } catch (NoResultException fe) {
              UtilidadesLog.error("ERROR ", fe);
              throw new MareException(fe,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch (PersistenceException ce) {
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
      }
      
        query.append(" SELECT   clie.oid_clie OID, clie.cod_clie codigo_cliente, ");
        query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
        query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
        query.append(" SUM (NVL(num_punt,0)) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
        query.append(" FROM inc_cuent_corri_punto ccp, ");
        query.append(" inc_concu_param_gener cpg, ");
        query.append(" (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
        query.append(" SUM (NVL (pni.num_cant_fija_punt, ");
        query.append(" pni.num_cant_inic_punt ");
        query.append(" ) ");
        query.append(" ) coste_premio ");
        query.append(" FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
        query.append(" WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
        query.append(" GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
        query.append(" inc_param_gener_premi pgp, ");
        query.append(" inc_plant_concu plc, ");
        query.append(" mae_clien clie, ");
        query.append(" mae_clien_tipo_subti tip ");
        query.append(" WHERE cpg.oid_para_gral = " + oidConcurso);
        query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
        query.append(" AND ccp.clie_oid_clie(+) = " + dtoe.getOidCliente());
        query.append(" AND ccp.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        query.append(" AND prem_eleg.clie_oid_clie(+) = clie.oid_clie ");
        query.append(" AND prem_eleg.copa_oid_para_gral(+) = " + oidConcurso);
        query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
        
        // DBLG500000969 - gPineda - 02/11/2006
        //query.append(" AND pgp.tele_oid_tipo_elec = 1 ");
        
        query.append(" AND plc.val_part = 1 ");
        query.append(" AND clie.oid_clie = tip.clie_oid_clie ");
        query.append(" AND tip.ind_ppal = 1 ");
        query.append(" AND (   (tip.ticl_oid_tipo_clie = 2 AND cpg.diri_oid_diri = 1) ");
        query.append(" OR (tip.ticl_oid_tipo_clie = 4 AND cpg.diri_oid_diri = 2) ");
        query.append(" ) ");
        query.append(" GROUP BY ccp.copa_oid_para_gral, ");
        query.append(" clie.oid_clie, ");
        query.append(" clie.cod_clie, ");
        query.append(" clie.val_nom1, ");
        query.append(" clie.val_nom2, ");
        query.append(" clie.val_ape1, ");
        query.append(" clie.val_ape2, ");
        query.append(" prem_eleg.coste_premio		  ");
        query.append(" UNION ");
        query.append(" SELECT   clie.oid_clie OID, clie.cod_clie codigo_cliente, ");
        query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
        query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
        query.append(" SUM (NVL(num_punt,0)) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
        query.append(" FROM inc_cuent_corri_punto ccp, ");
        query.append(" inc_concu_param_gener cpg, ");
        query.append(" (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
        query.append(" SUM (NVL (pni.num_cant_fija_punt, ");
        query.append(" pni.num_cant_inic_punt ");
        query.append(" ) ");
        query.append(" ) coste_premio ");
        query.append(" FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
        query.append(" WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
        query.append(" GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
        query.append(" inc_param_gener_premi pgp, ");
        query.append(" inc_plant_concu plc, ");
        query.append(" mae_clien clie, ");
        query.append(" inc_clasi_parti_concu pac, ");
        query.append(" inc_parti_concu_detal pad, ");
        query.append(" v_mae_tipif_clien tic ");
        query.append(" WHERE cpg.oid_para_gral = " + oidConcurso);
        query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
        query.append(" AND ccp.clie_oid_clie(+) = " + dtoe.getOidCliente());
        query.append(" AND ccp.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        query.append(" AND cpg.oid_para_gral = pac.copa_oid_para_gral ");
        query.append(" AND pac.paci_oid_part_conc_cabe = pad.paci_oid_part_conc_cabe ");
        query.append(" AND tic.clie_oid_clie = clie.oid_clie ");
        query.append(" AND NVL (pad.ticl_oid_tipo_clie, -1) = ");
        query.append(" DECODE (pad.ticl_oid_tipo_clie, ");
        query.append(" NULL, -1, ");
        query.append(" tic.ticl_oid_tipo_clie ");
        query.append(" ) ");
        query.append(" AND NVL (pad.sbti_oid_subt_clie, -1) = ");
        query.append(" DECODE (pad.sbti_oid_subt_clie, ");
        query.append(" NULL, -1, ");
        query.append(" tic.sbti_oid_subt_clie ");
        query.append(" ) ");
        query.append(" AND NVL (pad.tccl_oid_tipo_clas, -1) = ");
        query.append(" DECODE (pad.tccl_oid_tipo_clas, ");
        query.append(" NULL, -1, ");
        query.append(" tic.tccl_oid_tipo_clasi ");
        query.append(" ) ");
        query.append(" AND NVL (pad.clas_oid_clas, -1) = ");
        query.append(" DECODE (pad.clas_oid_clas, ");
        query.append(" NULL, -1, ");
        query.append(" tic.clas_oid_clas ");
        query.append(" ) ");
        query.append(" AND prem_eleg.clie_oid_clie(+) = clie.oid_clie ");
        query.append(" AND prem_eleg.copa_oid_para_gral(+) = " + oidConcurso);
        query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
        
        // DBLG500000969 - gPineda - 02/11/2006
        //query.append(" AND pgp.tele_oid_tipo_elec = 1 ");
        
        query.append(" AND plc.val_part = 0 ");
        query.append(" GROUP BY ccp.copa_oid_para_gral, ");
        query.append(" clie.oid_clie, ");
        query.append(" clie.cod_clie, ");
        query.append(" clie.val_nom1, ");
        query.append(" clie.val_nom2, ");
        query.append(" clie.val_ape1, ");
        query.append(" clie.val_ape2, ");
        query.append(" prem_eleg.coste_premio ");
        
        /* DBLG500000969 - gPineda - 02/11/2006
        query.append(" UNION ");
        query.append(" SELECT   clie.oid_clie OID, clie.cod_clie codigo_cliente, ");
        query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
        query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
        query.append(" SUM (NVL(num_punt,0)) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
        query.append(" FROM inc_cuent_corri_punto ccp, ");
        query.append(" inc_concu_param_gener cpg, ");
        query.append(" (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
        query.append(" SUM (NVL (pni.num_cant_fija_punt, ");
        query.append(" pni.num_cant_inic_punt ");
        query.append(" ) ");
        query.append(" ) coste_premio ");
        query.append(" FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
        query.append(" WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
        query.append(" GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
        query.append(" inc_param_gener_premi pgp, ");
        query.append(" inc_plant_concu plc, ");
        query.append(" mae_clien clie, ");
        query.append(" inc_ganad gan, ");
        query.append(" inc_param_nivel_premi nip ");
        query.append(" WHERE cpg.oid_para_gral = " + oidConcurso);
        query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
        query.append(" AND ccp.clie_oid_clie(+) = " + dtoe.getOidCliente());
        query.append(" AND ccp.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        query.append(" AND clie.oid_clie = gan.clie_oid_clie ");
        query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(" AND gan.panp_oid_para_nive_prem = nip.oid_para_nive_prem ");
        query.append(" AND nip.pagp_oid_para_gene_prem = pgp.oid_para_gene_prem ");
        query.append(" AND gan.ind_desp = 0 ");
        query.append(" AND prem_eleg.clie_oid_clie(+) = clie.oid_clie ");
        query.append(" AND prem_eleg.copa_oid_para_gral(+) = " + oidConcurso);
        query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
        query.append(" AND pgp.tele_oid_tipo_elec = 2 ");
        query.append(" GROUP BY ccp.copa_oid_para_gral, ");
        query.append(" clie.oid_clie, ");
        query.append(" clie.cod_clie, ");
        query.append(" clie.val_nom1, ");
        query.append(" clie.val_nom2, ");
        query.append(" clie.val_ape1, ");
        query.append(" clie.val_ape2, ");
        query.append(" prem_eleg.coste_premio ");
        */
      
      
      
    
      /*query.append(" SELECT   ccp.clie_oid_clie oid, clie.cod_clie codigo_cliente, ");
      query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
      query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
      query.append(" SUM (num_punt) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
      query.append(" FROM inc_cuent_corri_punto ccp,  ");
      query.append(" inc_concu_param_gener cpg, ");
      query.append("    (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
      query.append("            SUM (NVL (pni.num_cant_fija_punt,pni.num_cant_inic_punt)) coste_premio ");
      query.append("     FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
      query.append("     WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
      query.append("     GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
      query.append(" inc_param_gener_premi pgp, ");
      query.append(" inc_plant_concu plc, ");
      query.append(" mae_clien clie, ");
      query.append(" MAE_CLIEN_TIPO_SUBTI TIP ");
      query.append(" WHERE cpg.oid_para_gral = " + oidConcurso );
      //Agregado por Cristian Valenzuela - 21/2/2006      
      query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
      //FIN - Agregado por Cristian Valenzuela - 21/2/2006
      query.append(" AND ccp.clie_oid_clie = clie.oid_clie ");
      query.append(" AND ccp.copa_oid_para_gral = cpg.oid_para_gral ");
      query.append(" AND prem_eleg.clie_oid_clie(+) = clie.oid_clie ");
      query.append(" AND prem_eleg.copa_oid_para_gral(+) = "  + oidConcurso );
      query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
      query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
      query.append(" AND pgp.tele_oid_tipo_elec = " + ConstantesINC.TIPO_ELECCION_DURANTE_CONCURSO);
      query.append(" AND plc.val_part = 1   ");
      query.append(" AND CLIE.OID_CLIE = TIP.CLIE_OID_CLIE ");
      query.append(" AND TIP.IND_PPAL = 1 ");
      query.append(" AND ( (  TIP.TICL_OID_TIPO_CLIE = " + ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
      query.append(" AND  CPG.DIRI_OID_DIRI = " + ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS + ") ");
      query.append(" OR  (TIP.TICL_OID_TIPO_CLIE = " + ConstantesMAE.OID_TIPO_CLIENTE_GERENTE ); 
      query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.OID_DIRIGIDO_A_GERENTE + ") )");
      query.append(" GROUP BY ccp.copa_oid_para_gral, ccp.clie_oid_clie, clie.cod_clie, ");
      query.append(" clie.val_nom1 , clie.val_nom2, clie.val_ape1 , clie.val_ape2, prem_eleg.coste_premio  ");
      
      query.append(" UNION ");
      
      query.append(" SELECT ccp.clie_oid_clie oid, clie.cod_clie codigo_cliente, ");
      query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
      query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
      query.append(" SUM (num_punt) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
      query.append(" FROM inc_cuent_corri_punto ccp, ");
      query.append(" inc_concu_param_gener cpg, ");
      query.append("      (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
      query.append("       SUM (NVL (pni.num_cant_fija_punt, pni.num_cant_inic_punt)) coste_premio ");
      query.append("       FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
      query.append("       WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
      query.append("       GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
      query.append(" inc_param_gener_premi pgp, ");
      query.append(" inc_plant_concu plc, ");
      query.append(" mae_clien clie, ");
      query.append(" inc_clasi_parti_concu pac, ");
      query.append(" inc_parti_concu_detal pad, ");
      query.append(" v_mae_tipif_clien tic ");
      query.append(" WHERE cpg.oid_para_gral = "  + oidConcurso );
      //Agregado por Cristian Valenzuela - 21/2/2006      
      query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
      //FIN - Agregado por Cristian Valenzuela - 21/2/2006
      query.append(" AND ccp.clie_oid_clie = clie.oid_clie ");
      query.append(" AND ccp.copa_oid_para_gral = cpg.oid_para_gral ");
      query.append(" AND ccp.copa_oid_para_gral = pac.copa_oid_para_gral ");
      query.append(" AND pac.paci_oid_part_conc_cabe = pad.paci_oid_part_conc_cabe ");
      query.append(" AND tic.clie_oid_clie = ccp.clie_oid_clie ");
      query.append(" AND NVL (pad.ticl_oid_tipo_clie, -1) =  ");
      query.append("             DECODE (pad.ticl_oid_tipo_clie, NULL, -1,tic.ticl_oid_tipo_clie) ");
      query.append(" AND NVL (pad.sbti_oid_subt_clie, -1) = ");
      query.append("             DECODE (pad.sbti_oid_subt_clie,NULL, -1, tic.sbti_oid_subt_clie) ");
      query.append(" AND NVL (pad.tccl_oid_tipo_clas, -1) = ");
      query.append("             DECODE (pad.tccl_oid_tipo_clas,NULL, -1, tic.tccl_oid_tipo_clasi) ");
      query.append(" AND NVL (pad.clas_oid_clas, -1) = ");
      query.append("             DECODE (pad.clas_oid_clas, NULL, -1, tic.clas_oid_clas) ");
      query.append(" AND prem_eleg.clie_oid_clie(+) = ccp.clie_oid_clie ");
      query.append(" AND prem_eleg.copa_oid_para_gral(+) = "  + oidConcurso );
      query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
      query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
      query.append(" AND pgp.tele_oid_tipo_elec = " + ConstantesINC.TIPO_ELECCION_DURANTE_CONCURSO);
      query.append(" AND plc.val_part = 0 ");      
      query.append(" GROUP BY ccp.copa_oid_para_gral, ccp.clie_oid_clie , clie.cod_clie, ");
      query.append(" clie.val_nom1 , clie.val_nom2, clie.val_ape1 , clie.val_ape2, prem_eleg.coste_premio ");
      
      query.append(" UNION ");
      
      query.append(" SELECT   ccp.clie_oid_clie oid, clie.cod_clie codigo_cliente, ");
      query.append(" clie.val_nom1 nombre1, clie.val_nom2 nombre2, ");
      query.append(" clie.val_ape1 apellido1, clie.val_ape2 apellido2, ");
      query.append(" SUM (num_punt) - NVL (prem_eleg.coste_premio, 0) saldo_cliente ");
      query.append(" FROM inc_cuent_corri_punto ccp, ");
      query.append(" inc_concu_param_gener cpg, ");
      query.append("      (SELECT DISTINCT pel.clie_oid_clie, pel.copa_oid_para_gral, ");
      query.append("       SUM (NVL (pni.num_cant_fija_punt,pni.num_cant_inic_punt)) coste_premio ");
      query.append("       FROM inc_premi_elegi pel, inc_param_nivel_premi pni ");
      query.append("       WHERE pel.panp_oid_para_nive_prem = pni.oid_para_nive_prem ");
      query.append("       GROUP BY pel.clie_oid_clie, pel.copa_oid_para_gral) prem_eleg, ");
      query.append(" inc_param_gener_premi pgp, ");
      query.append(" inc_plant_concu plc, ");
      query.append(" mae_clien clie, ");
      query.append(" inc_ganad gan, ");
      query.append(" inc_param_nivel_premi nip ");
      query.append(" WHERE cpg.oid_para_gral = "  + oidConcurso );
      //Agregado por Cristian Valenzuela - 21/2/2006      
      query.append(" AND clie.oid_clie = " + dtoe.getOidCliente());
      //FIN - Agregado por Cristian Valenzuela - 21/2/2006
      query.append(" AND ccp.clie_oid_clie = clie.oid_clie ");
      query.append(" AND ccp.copa_oid_para_gral = cpg.oid_para_gral ");
      query.append(" AND ccp.clie_oid_clie = gan.clie_oid_clie ");
      query.append(" AND ccp.copa_oid_para_gral = pgp.copa_oid_para_gral ");
      query.append(" AND gan.clie_oid_clie = ccp.clie_oid_clie ");
      query.append(" AND gan.panp_oid_para_nive_prem = nip.oid_para_nive_prem ");
      query.append(" AND nip.pagp_oid_para_gene_prem = pgp.oid_para_gene_prem ");
      query.append(" AND gan.ind_desp = 0 ");
      query.append(" AND prem_eleg.clie_oid_clie(+) = clie.oid_clie ");
      query.append(" AND prem_eleg.copa_oid_para_gral(+) = " + oidConcurso );
      query.append(" AND cpg.oid_para_gral = pgp.copa_oid_para_gral ");
      query.append(" AND cpg.plc2_oid_plan_conc = plc.oid_plan_conc ");
      query.append(" AND pgp.tele_oid_tipo_elec = "  + ConstantesINC.TIPO_ELECCION_FINAL_CONCURSO);
      query.append(" GROUP BY ccp.copa_oid_para_gral, ccp.clie_oid_clie, clie.cod_clie, ");
      query.append(" clie.val_nom1, clie.val_nom2, clie.val_ape1 , clie.val_ape2, prem_eleg.coste_premio  ");*/      
      
      try {
          String queryPagina = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
          
          rs = bs.dbService.executeStaticQuery(queryPagina);
      }
      catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMantenimientoPremiacion.obtenerClientesPorConcurso(DTOBuscarClientesConcurso dtoe): Salida");
      return rs;
  }
  
    private PremiosElegidosLocalHome getPremiosElegidosLocalHome() {
            return new PremiosElegidosLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

  
}
