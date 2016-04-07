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
 * @autor Javier Quiroga - CDOS - 
 * @date 25/05/2005
 * Correcciones del Peer Review Noziglia C.
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocalHome;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocalHome;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.RequisitosPremiacionLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOConcursoPremiacion {
    private UtilidadesLog log = new UtilidadesLog();

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Concurso concurso
    * @return void
    * @documentation
      Descripcion: Este método carga los atributos de Concurso provenientes de 
      ParametrosGeneralesPremiacion
      Implementacion:

      1) Intentar recuperar el objeto de la entidad 
        ParametrosGeneralesPremiacion invocando al findByUK con oidConcurso
        Si se recupera el objeto, cargo los atributos de concurso según la 
        siguiente correspondencia (el detalle de la carga esta es los puntos 
        sucesivos):

      concurso.indPeriodoDespachoExigido = ParametrosGeneralesPremiacion
        .periodoDespachoExigido
      concurso.periodoDespacho = ParametrosGeneralesPremiacion.periodoDespacho 
        (se debe hacer un join con las entidades CRA:Periodo y 
            SEG:PeriodoCorporativo para crear un objeto de la clase periodo)
      concurso.numeroPeriodos = ParametrosGeneralesPremiacion.numeroPeriodos
      concurso.tipoPremiacion = ParametrosGeneralesPremiacion.tipoPremiacion
      concurso.accesoNivelSuperior = ParametrosGeneralesPremiacion
        .accesoNivelSuperior
      concurso.nivelesRotatorios = ParametrosGeneralesPremiacion
        .nivelesRotatorios
      concurso.premiosAcumulativosNiveles = ParametrosGeneralesPremiacion
        .premiosAcumulativosNiveles
      concurso.comunicacionAutomatica = ParametrosGeneralesPremiacion
        .comunicacion

      Si no se recupera inicializo los atributos y finalizo la ejecucion del 
        método

      concurso.indPeriodoDespachoExigido = new Boolean(false)
      concurso.periodoDespacho = null
      concurso.numeroPeriodos = null
      concurso.tipoPremiacion = null
      concurso.accesoNivelSuperior = new Boolean(false)
      concurso.nivelesRotatorios = new Boolean(false)
      concurso.premiosAcumulativosNiveles = new Boolean(false)
      concurso.comunicacionAutomatica = new Boolean(false)

      2) Cargo periodoDespacho:

      a) Generar una instancia de DTOETramitarCierre
      b) rellenar sus atributos pais, marca, canal y periodo con pais, marca, 
        canal y periodoDespacho de concurso
      c) invocar a DAOClientePremiacion.obtenerPeriodo( DTOETramitarCierre )

      3) Calculo periodoDespachoDespuesObtencion

      a) Generar una instancia de DTOETramitarCierre
      b) rellenar sus atributos pais, marca, canal y periodo con pais, marca, 
        canal y periodoDespacho de concurso
      c) if numeroPeriodos != null
      periodoDespachoDespuesObtencion = DAOClientePremiacion.obtenerPeriodo( 
        DTOETramitarCierre, numeroPedidos )
      else
      periodoDespachoDespuesObtencion = null

      4) Cargo datos de Obtencion de Puntos
      Intentar recuperar el objeto de la entidad INC:ObtencionPuntos invocando 
        al findByUK con oidConcurso
      Si se recupera el objeto, cargo los atributos de concurso según la 
        siguiente correspondencia:
      concurso.puntajeAcumulativo = INC:ObtencionPuntos.puntajeAcumulativo
      concurso.comunicacionEnObtencionPuntos = INC:ObtencionPuntos
        .indComunicacionObtencion

      5) Cargo datos de Parametros Consultoras.
      Intentar recuperar el objeto de la entidad 
        INC:ConcursoParametrosConsultoras invocando al findByUK con oidConcurso
      Si se recupera el objeto, cargo los atributos de concurso según la
        siguiente correspondencia:
      concurso.numeroMinimoPedido = INC:ConcursoParametrosConsultoras
        .numeroMinimoPedidos
      concurso.numeroMinimoPedidoRecomendada = 
        INC:ConcursoParametrosConsultoras.numeroMinimoPedidosRecomendada.
    *
    * Comentario: Este metodo utiliza las entidades 
    *   ParametrosGeneralesPremiacion, ObtencionPuntos y 
    *       ConcursoParametrosConsultoras,
    * porfavor recordar colocar las EJB Local references a estas entidades 
    *   en el MON desde donde se llame a este metodo
    *
    */
    public void obtenerParametrosGeneralesPremiacion(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerParametrosGeneralesPr"
            +"emiacion( Concurso concurso): Entrada");

        //1. Intentar recuperar el objeto de la entidad 
        //ParametrosGeneralesPremiacion
        /*ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLocalHome = null;
        ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionLocal = null;
        Periodo pedTmp = null;

        try {
            parametrosGeneralesPremiacionLocalHome = this.getParametrosGeneralesPremiacionLocalHome();

            parametrosGeneralesPremiacionLocal = parametrosGeneralesPremiacionLocalHome.findByUK(concurso.getOidConcurso());
            UtilidadesLog.debug("obtenerParametrosGeneralesPremiacion lo encontre gg "+ parametrosGeneralesPremiacionLocal.getOid());
            pedTmp = cargarPeriodoDespacho(parametrosGeneralesPremiacionLocal.getPeriodoDespacho());
            concurso.setPeriodoDespacho(pedTmp);
            concurso.setIndPeriodoDespachoExigido(parametrosGeneralesPremiacionLocal.getPeriodoDespachoExigido());
            concurso.setNumeroPeriodos(integer2Long(parametrosGeneralesPremiacionLocal.getNumeroPeriodos()));
            concurso.setTipoPremiacion(parametrosGeneralesPremiacionLocal.getTipoPremiacion());
            concurso.setAccesoNivelSuperior(switch2boolean(parametrosGeneralesPremiacionLocal.getAccesoNivelSuperior()));
            concurso.setNivelesRotatorios(switch2boolean(parametrosGeneralesPremiacionLocal.getNivelesRotativos()));
            concurso.setPremiosAcumulativosNiveles(switch2boolean(parametrosGeneralesPremiacionLocal.getPremiosAcumulativosNiveles()));
            concurso.setComunicacionAutomatica(switch2boolean(parametrosGeneralesPremiacionLocal.getComunicacion()));
            //jrivas 18/7/2006 DBLG500001049
            concurso.setNumeroRotaciones(parametrosGeneralesPremiacionLocal.getNumeroRotaciones());      
            
            // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
            concurso.setSinPremioPorDefecto(parametrosGeneralesPremiacionLocal.getSinPremioPorDefecto());
            
        } catch (NoResultException fex) {
            UtilidadesLog.debug("*obtenerParametrosGeneralesPremiacion no lo "
                +"encontre");
            concurso.setIndPeriodoDespachoExigido(Boolean.FALSE);
            concurso.setPeriodoDespacho(null);
            concurso.setNumeroPeriodos(null);
            concurso.setTipoPremiacion(null);
            concurso.setAccesoNivelSuperior(false);
            concurso.setNivelesRotatorios(false);
            concurso.setPremiosAcumulativosNiveles(false);
            concurso.setComunicacionAutomatica(false);
            concurso.setNumeroRotaciones(null);                    

            // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
            concurso.setSinPremioPorDefecto(false);
             
            return; //-- aca finaliza el metodo 
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }*/
        
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        Periodo pedTmp = null;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT PERD_OID_PERI, ");
            buf.append( " IND_PERI_DESP_EXIG, ");
            buf.append("  NUM_PERI,  ");
            buf.append("  TPRM_OID_TIPO_PION, ");
            buf.append("  IND_ACCE_NIVE_SUPE, ");
            buf.append("  IND_NIVE_ROTA, ");
            buf.append("  IND_PREM_ACUM_NIVE, ");
            buf.append("  IND_COMU, ");
            buf.append("  NUM_ROTA, ");
            buf.append("  IND_NOPR_DEFE ");
            buf.append(" FROM INC_PARAM_GENER_PREMI ");
            buf.append(" WHERE COPA_OID_PARA_GRAL =" + concurso.getOidConcurso());

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("Resultado (Premiacion): " + rs);

            if (!rs.esVacio()) {
                pedTmp = cargarPeriodoDespacho(object2Long(rs.getValueAt(0, "PERD_OID_PERI")));
                concurso.setPeriodoDespacho(pedTmp);
                concurso.setIndPeriodoDespachoExigido(new Boolean(object2boolean(rs.getValueAt(0, "IND_PERI_DESP_EXIG"))));
                concurso.setNumeroPeriodos(object2Long(rs.getValueAt(0, "NUM_PERI")));
                concurso.setTipoPremiacion(object2Long(rs.getValueAt(0, "TPRM_OID_TIPO_PION")));
                concurso.setAccesoNivelSuperior(object2boolean(rs.getValueAt(0, "IND_ACCE_NIVE_SUPE")));
                concurso.setNivelesRotatorios(object2boolean(rs.getValueAt(0, "IND_NIVE_ROTA")));
                concurso.setPremiosAcumulativosNiveles(object2boolean(rs.getValueAt(0, "IND_PREM_ACUM_NIVE")));
                concurso.setComunicacionAutomatica(object2boolean(rs.getValueAt(0, "IND_COMU")));
                concurso.setNumeroRotaciones(object2Integer(rs.getValueAt(0, "NUM_ROTA")));
                concurso.setSinPremioPorDefecto(object2boolean(rs.getValueAt(0, "IND_NOPR_DEFE")));
                        
            } else {
                UtilidadesLog.debug("*obtenerParametrosGeneralesPremiacion no lo "
                    +"encontre");
                concurso.setIndPeriodoDespachoExigido(Boolean.FALSE);
                concurso.setPeriodoDespacho(null);
                concurso.setNumeroPeriodos(null);
                concurso.setTipoPremiacion(null);
                concurso.setAccesoNivelSuperior(false);
                concurso.setNivelesRotatorios(false);
                concurso.setPremiosAcumulativosNiveles(false);
                concurso.setComunicacionAutomatica(false);
                concurso.setNumeroRotaciones(null);                    

                // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                concurso.setSinPremioPorDefecto(false);
                 
                return; //-- aca finaliza el metodo 
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //2. Cargo periodoDespacho 
        DTOETramitarCierre dtoETramitarCierre = new DTOETramitarCierre();
        DAOClientePremiacion daoClientePremiacion = new DAOClientePremiacion();
        Periodo periodoDespacho = null;
        Periodo pedTmp2 = null;

        dtoETramitarCierre.setOidPais(concurso.getOidPais());
        dtoETramitarCierre.setOidMarca(concurso.getOidMarca());
        dtoETramitarCierre.setOidCanal(concurso.getOidCanal());

        pedTmp2 = concurso.getPeriodoDeDespacho();

        if (pedTmp2 != null) {
            dtoETramitarCierre.setOidPeriodo(pedTmp2.getOidPeriodo());
            periodoDespacho = daoClientePremiacion.obtenerPeriodo(
                dtoETramitarCierre);
            concurso.setPeriodoDespacho(periodoDespacho);
        }

        //jrivas 18/8/2005
        //INC 20450
        //3. Calculo periodoDespachoDespuesObtencion 
        
        /*DTOETramitarCierre dtoETramitarCierre2 = new DTOETramitarCierre();
        Periodo periodoDespachoDespuesObtencion = null;

        if (pedTmp2 != null) {
            dtoETramitarCierre2.setOidPais(concurso.getOidPais());
            dtoETramitarCierre2.setOidMarca(concurso.getOidMarca());
            dtoETramitarCierre2.setOidCanal(concurso.getOidCanal());
            dtoETramitarCierre2.setOidPeriodo(pedTmp2.getOidPeriodo());

            if (concurso.getNumeroPeriodos() != null) {
                periodoDespachoDespuesObtencion = 
                    daoClientePremiacion.obtenerPeriodo(dtoETramitarCierre2,
                        concurso.getNumeroPeriodos().intValue());
            }
        }
        concurso.setPeriodoDespachoDespuesObtencion(
            periodoDespachoDespuesObtencion);*/

        //4. Cargo datos de Obtencion de Puntos 
        /*ObtencionPuntosLocalHome obtencionPuntosLocalHome = null;
        ObtencionPuntosLocal obtencionPuntosLocal = null;

        try {
            obtencionPuntosLocalHome = this.getObtencionPuntosLocalHome();
            obtencionPuntosLocal = obtencionPuntosLocalHome.findByUK(concurso.getOidConcurso());

            concurso.setPuntajeAcumulativo(switch2boolean(obtencionPuntosLocal.getPuntoAcumulado()));
            concurso.setComunicacionEnObtencionPuntos(switch2boolean(obtencionPuntosLocal.getIndComuObte()));
        } catch (NoResultException fex) {
            UtilidadesLog.debug("No encontre entidad ObtencionPuntos");
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }*/

        try {
            buf = new StringBuffer();
            buf.append(" SELECT VAL_PUNT_ACUM, ");
            buf.append( " IND_COMU_OBTE ");
            buf.append(" FROM INC_OBTEN_PUNTO ");
            buf.append(" WHERE COPA_OID_PARA_GRAL =" + concurso.getOidConcurso());

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("Resultado (Obtencion): " + rs);

            if (!rs.esVacio()) {
                concurso.setPuntajeAcumulativo(object2boolean(rs.getValueAt(0, "VAL_PUNT_ACUM")));
                concurso.setComunicacionEnObtencionPuntos(object2boolean(rs.getValueAt(0, "IND_COMU_OBTE")));
                        
            } else {
                UtilidadesLog.debug("No encontre entidad ObtencionPuntos");
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        //5. Cargo datos de Parametros Consultoras o Parametros Gerentes
        Long numeroMinPedid=null;
        Long numeroMinPedidRecom=null;
        UtilidadesLog.debug("oidConcu: " + concurso.getOidConcurso() +
            " dirigido a " + concurso.getDirigidoA());
        try {
        if (concurso.getDirigidoA().equals(ConstantesINC.TIPO_CONSULTORA)) {
            /*ConcursoParametrosConsultorasLocalHome 
                concursoParametrosConsultorasLocalHome = null;
            ConcursoParametrosConsultorasLocal 
                concursoParametrosConsultorasLocal =  null;

            try {
                concursoParametrosConsultorasLocalHome = this.getConcursoParametrosConsultorasLocalHome();
                concursoParametrosConsultorasLocal = concursoParametrosConsultorasLocalHome.findByUK(concurso.getOidConcurso());
            } catch (NoResultException fex) {
                UtilidadesLog.debug("No encontre entidad ConcursoParametros"
                    +"Consultora");
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            numeroMinPedid = integer2Long(concursoParametrosConsultorasLocal
                .getNumeroMinimoPedidos());
            numeroMinPedidRecom = integer2Long(
                concursoParametrosConsultorasLocal
                    .getNumeroMinimoPedidosRecomendada());*/
                    
             try {
                 buf = new StringBuffer();
                 buf.append(" SELECT NUM_MINI_PEDI, ");
                 buf.append( " NUM_MINI_PEDI_RECO ");
                 buf.append(" FROM INC_CONCU_PARAM_CONSU ");
                 buf.append(" WHERE COPA_OID_PARA_GRAL =" + concurso.getOidConcurso());

                 rs = bs.dbService.executeStaticQuery(buf.toString());
                 UtilidadesLog.debug("Resultado (Para Cons): " + rs);

                 if (!rs.esVacio()) {
                     numeroMinPedid = object2Long(rs.getValueAt(0, "NUM_MINI_PEDI"));
                     numeroMinPedidRecom = object2Long(rs.getValueAt(0, "NUM_MINI_PEDI_RECO"));
                             
                 } else {
                     UtilidadesLog.debug("No encontre entidad ObtencionPuntos");
                 }
                 
             } catch (Exception e) {
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e,
                     UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
             }
             
        } else {
            ConcursoParametrosGerentesLocalHome 
                concursoParametrosGerentesLocalHome = null;
            ConcursoParametrosGerentesLocal 
                concursoParametrosGerentesLocal = null;

            try {
                concursoParametrosGerentesLocalHome = this.getConcursoParametrosGerentesLocalHome();
                concursoParametrosGerentesLocal = concursoParametrosGerentesLocalHome.findByConcurso(concurso.getOidConcurso());
            } catch (NoResultException fex) {
                UtilidadesLog.debug(
                    "No encontre entidad ConcursoParametrosGerentes");
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if (concursoParametrosGerentesLocal!=null){
                numeroMinPedid = integer2Long(concursoParametrosGerentesLocal.getNumeroMinimoPedidos());
                numeroMinPedidRecom = integer2Long(concursoParametrosGerentesLocal.getNumeroMinimoPedidosRecomendada());
            }
        }

        if (numeroMinPedid != null) {
            concurso.setNumeroMinimoPedido(numeroMinPedid);
        } else {
            concurso.setNumeroMinimoPedido(new Long(0));
        }

        if (numeroMinPedidRecom != null) {
            concurso.setNumeroMinimoPedidoRecomendada(numeroMinPedidRecom);
        } else {
            concurso.setNumeroMinimoPedidoRecomendada(new Long(0));
        }
        
        // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
        Long numeroPeriodosVinculo = concurso.getNumeroMinimoPedido();
        if(concurso.getNumeroMinimoPedidoRecomendada().longValue() > numeroPeriodosVinculo.longValue())
            numeroPeriodosVinculo = concurso.getNumeroMinimoPedidoRecomendada();
        concurso.setNumeroPeriodosVinculo(numeroPeriodosVinculo);    
        
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            UtilidadesLog.debug("error vivi");
            throw new MareException(ex);
        }

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerParametrosGeneralesP"
            +"remiacion(Concurso concurso): Salida");
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Long oidPeriodoDespacho
    * @return Periodo
    * @documentation
      Realiza un join con las entidades CRA:Periodo y SEG:PeriodoCorporativo 
      y retorna los datos en un objeto de tipo Periodo
    */
    private Periodo cargarPeriodoDespacho(Long oidPeriodoDespacho)
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.cargarPeriodoDespacho(Long "
            +"oidPeriodoDespacho): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        Periodo retVal = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT ");
            buf.append( " T2.COD_PERI, T1.FEC_INIC, T1.FEC_FINA, ");
            buf.append(" T1.CANA_OID_CANA, T1.MARC_OID_MARC,  ");
            buf.append(" T1.PAIS_OID_PAIS ");
            buf.append(" FROM CRA_PERIO T1, SEG_PERIO_CORPO T2 ");
            buf.append(" WHERE T1.PERI_OID_PERI=T2.OID_PERI ");
            buf.append(" AND T1.OID_PERI=" + oidPeriodoDespacho);

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("Resultado : " + rs);

            if (!rs.esVacio()) {
                //Cargar Objeto Periodo
                retVal = new Periodo();
                retVal.setOidPeriodo(oidPeriodoDespacho);
                retVal.setCodperiodo(object2String(
                    rs.getValueAt(0, "COD_PERI")));
                retVal.setFechaDesde(object2Date(
                    rs.getValueAt(0, "FEC_INIC")));
                retVal.setFechaHasta(object2Date(
                    rs.getValueAt(0, "FEC_FINA")));
                retVal.setOidCanal(object2Long(
                    rs.getValueAt(0, "CANA_OID_CANA")));
                retVal.setOidMarca(object2Long(
                    rs.getValueAt(0, "MARC_OID_MARC")));
                retVal.setOidPais(object2Long(
                    rs.getValueAt(0, "PAIS_OID_PAIS")));
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOConcursoPremiacion.cargarPeriodoDespacho(Long "
                +"oidPeriodoDespacho): Salida");

        return retVal;
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Concurso concurso
    * @return void
    * @documentation
      Descripcion: Este método carga los atributos de Concurso provenientes de
      RequisitosPremiacion

      Implementacion:

      1) Obtener el objeto de la entidad RequisitosPremiacion invocando al 
      findByUK con oidConcurso
      Si se recupera el objeto, cargo los atributos del objeto según la 
      siguiente correspondencia:

      concurso.pedidoEnPeriodo = RequisitosPremiacion.pedidoEnPeriodo
      concurso.montoMinimoPedido = RequisitosPremiacion.montoMinimoPedido
      concurso.montoMinimoConcurso = RequisitosPremiacion.montoMinimoConcurso
      concurso.cuotaMinimaIngreso = RequisitosPremiacion.cuotaIngreso
      concurso.numeroPedidos = RequisitosPremiacion.numeroPedidos
      concurso.indAsistenciaCursos = RequisitosPremiacion.asistenciaCurso
      concurso.indPagoATiempo = RequisitosPremiacion.pagoATiempo
      concurso.diasGracia = RequisitosPremiacion.diasGracia

      Si no se recupera, inicializo los atributos Boolean en false 
      (new Boolean(false)) y el resto de los atributos en null

      Caso contrario inicializarlos en cero

    * Comentario: Este metodo utiliza la entidad RequisitosPremiacion, 
    * porfavor recordar colocar la EJB Local
    * reference a esta entidad en el MON desde donde se llame a este metodo
    *
    */
    public void obtenerRequisitosPremiacion(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerRequisitosPremiacion"
            +"(Concurso concurso): Entrada");

        /*RequisitosPremiacionLocalHome requisitosPremiacionLocalHome;
        RequisitosPremiacionLocal requisitosPremiacionLocal = null;

        try {
            requisitosPremiacionLocalHome = this.getRequisitosPremiacionLocalHome();
            requisitosPremiacionLocal = requisitosPremiacionLocalHome.findByUK(concurso.getOidConcurso());

            UtilidadesLog.debug("requisitosPremiacionLocal.getMontoMinimoPedido"
                +"()GGG: " + requisitosPremiacionLocal.getMontoMinimoPedido());
            concurso.setPedidoEnPeriodo(switch2boolean(requisitosPremiacionLocal.getPedidoEnPeriodo()));

            //Inc 20585
            //concurso.setMontoMinimoPedido(requisitosPremiacionLocal
            //.getMontoMinimoPedido());
            concurso.setMontoMinimoPedidoPremiacion(requisitosPremiacionLocal
                .getMontoMinimoPedido());
            concurso.setMontoMinimoConcurso(requisitosPremiacionLocal
                .getMontoMinimoConcurso());
            concurso.setCuotaMinimaIngreso(integer2Double(
                    requisitosPremiacionLocal.getCuotaIngreso()));
            concurso.setNumeroPedidos(integer2Long(
                    requisitosPremiacionLocal.getNumeroPedidos()));
            concurso.setIndAsistenciaCursos(switch2boolean(
                    requisitosPremiacionLocal.getAsistenciaCurso()));
            concurso.setIndPagoATiempo(
                requisitosPremiacionLocal.getPagoATiempo().booleanValue());
            concurso.setDiasGracia(integer2Long(
                    requisitosPremiacionLocal.getDiasGracia()));
                    
            // vbongiov -- Cambio 20090929 -- 18/09/2009                    
            concurso.setOidValidaDeuda(requisitosPremiacionLocal.getOidValidaDeuda());
            concurso.setNumPerioEspe(requisitosPremiacionLocal.getNumPerioEspe());            
            concurso.setPeriodoMaxi(this.cargarPeriodoMaximo(requisitosPremiacionLocal.getPeriodoMaxi()));                    
        
        } catch (NoResultException fex) {
            UtilidadesLog.debug("No encontre requisito premiacion concurso GGG:"
                +" " + concurso.getOidConcurso());
            concurso.setPedidoEnPeriodo(false);
            //concurso.setMontoMinimoPedido(null);
            concurso.setMontoMinimoPedidoPremiacion(null);
            concurso.setMontoMinimoConcurso(null);
            concurso.setCuotaMinimaIngreso(null);
            concurso.setNumeroPedidos(null);
            concurso.setIndAsistenciaCursos(false);
            concurso.setIndPagoATiempo(false);
            concurso.setDiasGracia(null);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }*/
        
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
                 
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT IND_PEDI_PERI, ");
            buf.append("  VAL_MONT_MINI_PEDI, ");
            buf.append( " VAL_MONT_MINI_CONC, ");
            buf.append("  VAL_CUOT_INGR,  ");
            buf.append("  NUM_PEDI, ");
            buf.append("  IND_ASIS_CURS, ");
            buf.append("  IND_PAGO_TIEM, ");
            buf.append("  NUM_DIAS_GRAC ");
            buf.append(" FROM INC_REQUI_PREMI ");
            buf.append(" WHERE COPA_OID_PARA_GRAL =" + concurso.getOidConcurso());

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("Resultado (Requisitos): " + rs);

            if (!rs.esVacio()) {
                concurso.setPedidoEnPeriodo(object2boolean(rs.getValueAt(0, "IND_PEDI_PERI")));
                concurso.setMontoMinimoPedidoPremiacion((BigDecimal) rs.getValueAt(0, "VAL_MONT_MINI_PEDI"));
                concurso.setMontoMinimoConcurso((BigDecimal) rs.getValueAt(0, "VAL_MONT_MINI_CONC"));
                concurso.setCuotaMinimaIngreso(object2Double(rs.getValueAt(0, "VAL_CUOT_INGR")));
                concurso.setNumeroPedidos(object2Long(rs.getValueAt(0, "NUM_PEDI")));
                concurso.setIndAsistenciaCursos(object2boolean(rs.getValueAt(0, "IND_ASIS_CURS")));
                concurso.setIndPagoATiempo(object2boolean(rs.getValueAt(0, "IND_PAGO_TIEM")));
                concurso.setDiasGracia(object2Long(rs.getValueAt(0, "NUM_DIAS_GRAC")));
                        
            } else {
                UtilidadesLog.debug("No encontre requisito premiacion concurso GGG:"
                    +" " + concurso.getOidConcurso());
                concurso.setPedidoEnPeriodo(false);
                //concurso.setMontoMinimoPedido(null);
                concurso.setMontoMinimoPedidoPremiacion(null);
                concurso.setMontoMinimoConcurso(null);
                concurso.setCuotaMinimaIngreso(null);
                concurso.setNumeroPedidos(null);
                concurso.setIndAsistenciaCursos(false);
                concurso.setIndPagoATiempo(false);
                concurso.setDiasGracia(null);
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerRequisitosPremiacion("
            +"Concurso concurso): Salida");
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Concurso concurso
    * @return void
    * @documentation
      Descripcion: Este método carga la lista de curso exigidos si el indicador
      de asistencia a cursos está en true

      Implementacion:

      if (concurso.indAsistenciaCursos) {

      Hacer un join entre RequisitosPremiacion y CursosExigidosPremiacion
      filtrando por oidConcurso
      Agregar cada OID de tipoCurso recuperado a concurso.tipoCursosExigidos 
      (objetos del tipo Long)

      }
    */
    public void obtenerTipoCursosExigidos(Concurso concurso) 
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerTipoCursosExigidos("
            +"Concurso concurso): Entrada");

        if (concurso.getIndAsistenciaCursos()) {
            BelcorpService bs;
            RecordSet rs;
            StringBuffer buf = new StringBuffer();

            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                buf.append(" SELECT T2.TICU_OID_TIPO_CURS ");
                buf.append(" FROM INC_REQUI_PREMI T1,  ");
                buf.append(" INC_CURSO_EXIGI_PREMI T2 ");
                buf.append(" WHERE T1.OID_REQU_PREM=T2.REPR_OID_REQU_PREM ");
                buf.append(" AND T1.COPA_OID_PARA_GRAL=" +
                    concurso.getOidConcurso());

                rs = bs.dbService.executeStaticQuery(buf.toString());
                UtilidadesLog.debug("Resultado : " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if ((concurso.getTipoCursosExigidos() == null) && !rs.esVacio()) {
                concurso.setTipoCursosExigidos(new ArrayList());
            }

            Object tmpVal = null;

            for (int i = 0; i < rs.getRowCount(); i++) {
                tmpVal = rs.getValueAt(i, "TICU_OID_TIPO_CURS");

                if (tmpVal != null) {
                    concurso.getTipoCursosExigidos().add(new Long(
                            ((BigDecimal) tmpVal).longValue()));
                }
            }
        }

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerTipoCursosExigidos("
            +"Concurso concurso): Salida");
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Concurso concurso
    * @return void
    * @documentation
      Descripcion: Este método carga la lista de productos exigidos

      Implementacion:

      Hacer un join entre ProductosExigidosPremiacion y RequisitosPremiacion
      filtrando por oidConcurso

      Agregar cada OID de codigoProducto recuperado a concurso.
      productosExigidosPremiacion (objetos del tipo Long)

      Ejemplo:

      concurso.productosExigidosPremiacion.add( oidCodigoProducto );
    */
    public void obtenerProductosExigidos(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerProductosExigidos("
            +"Concurso concurso): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT DISTINCT P.OID_PROD ");
            buf.append(" FROM INC_PRODU_EXIGI_PREMI T1, INC_REQUI_PREMI T2, MAE_PRODU P ");
            buf.append(" WHERE T1.REPR_OID_REQU_PREM=T2.OID_REQU_PREM ");
            buf.append(" AND T2.COPA_OID_PARA_GRAL = "  + concurso.getOidConcurso());
            buf.append(" AND T1.MAPR_OID_MARC_PROD = P.MAPR_OID_MARC_PROD ");
            buf.append(" AND (T1.PROD_OID_PROD = P.OID_PROD OR T1.PROD_OID_PROD IS NULL) ");
            buf.append(" AND (T1.NEGO_OID_NEGO = P.NEGO_OID_NEGO OR T1.NEGO_OID_NEGO IS NULL) ");
            buf.append(" AND (T1.SGEN_OID_SUPE_GENE = P.SGEN_OID_SUPE_GENE OR T1.SGEN_OID_SUPE_GENE IS NULL) ");
            buf.append(" AND (T1.UNEG_OID_UNID_NEGO = P.UNEG_OID_UNID_NEGO OR T1.UNEG_OID_UNID_NEGO IS NULL) ");
            buf.append(" AND (T1.GENE_OID_GENE = P.GENE_OID_GENE OR T1.GENE_OID_GENE IS NULL) ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
            //UtilidadesLog.debug("Resultado : " + rs);   java.io.IOException: Message too long 
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if ((concurso.getProductosExigidosPremiacion() == null) &&
                !rs.esVacio()) {
            concurso.setProductosExigidosPremiacion(new ArrayList());
        }

        Object tmpVal = null;

        for (int i = 0; i < rs.getRowCount(); i++) {
            tmpVal = rs.getValueAt(i, "OID_PROD");

            if (tmpVal != null) {
                concurso.getProductosExigidosPremiacion().add(new Long(
                        ((BigDecimal) tmpVal).longValue()));
            }
        }

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerProductosExigidos("
            +"Concurso concurso): Salida");
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param DTOETramitarCierre dtoe
    * @return DTOOIDs
    * @documentation
      Descripcion: Este método obtiene la lista de concursos a evaluar en el 
      cierre de zona

      Implementacion:

      1) Obtener la fecha desde del periodo recibido como parametro en el DTO
      Acceder a CRA_PERIO filtrando por periodo, marca, canal y pais y 
      recuperar la fechaDesde (FEC_INIC)

      2) Recuperar oidConcurso de CandidataGanadora (hacer join con 
      ConcursoParametrosGenerales para marca y canal
      y con CRA_PERIO para obtener la fecha desde de ultimoPeriodoEvaluado)
      sin permitir repeticiones, filtrando por:

      requisitosPremiacionSuperados == false
      baseIncumplida == null
      oidMarca == dtoe.oidMarca
      oidCanal == dtoe.oidMarca
      oidPais == dtoe.oidPais
      oidPeriodo == dtoe.oidPeriodo
      dirigidoA == "Consultoras"
      ultimoPeriodoEvaluado.fechaDesde < fecha recuperada en el punto 1

      3) Los OIDs de concurso recuperados se retornan en objeto del tipo 
      DTOOIDs
    */
    public DTOOIDs obtenerConcursos(DTOETramitarCierre dtoe, Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerConcursos(DTOETramit"
            +"arCierre dtoe):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {

            buf.append(" SELECT T1.COPA_OID_PARA_GRAL ");
            buf.append(" FROM INC_CANDI_GANAD T1, INC_CONCU_PARAM_GENER T2, ");
            buf.append("      INC_PARAM_GENER_PREMI PRE, INC_REQUI_PREMI REQ "); 
            buf.append(" WHERE ");           
            buf.append("     PRE.COPA_OID_PARA_GRAL = T2.OID_PARA_GRAL ");

            // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
            buf.append(" AND (((" + dtoe.getOidPeriodo() + " BETWEEN PRE.PERD_OID_PERI_INIC AND PRE.PERD_OID_PERI) ");
            buf.append("      AND PRE.PERD_OID_PERI_INIC IS NOT NULL) OR  (PRE.PERD_OID_PERI IS NULL)  ");
            buf.append("      OR ((PRE.PERD_OID_PERI_INIC IS NULL) AND PRE.PERD_OID_PERI = " + dtoe.getOidPeriodo() + ")) ");

            // sapaza -- Cambio 20090929 -- 23/02/2010
            /*buf.append(" AND ((REQ.VADE_OID_VALI_DEUD IS NULL AND (PRE.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            buf.append("                                   OR PRE.PERD_OID_PERI IS NULL )) ");
            buf.append("      OR   (REQ.VADE_OID_VALI_DEUD IS NOT NULL)) ");*/
            
            // sapaza -- PER-SiCC-2010-0175 -- 14/04/2010
            buf.append(" AND PRE.TPRM_OID_TIPO_PION <> " + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS);
            
            buf.append(" AND T1.COPA_OID_PARA_GRAL=T2.OID_PARA_GRAL ");
            buf.append(" AND T2.PAIS_OID_PAIS = " + dtoe.getOidPais());
            buf.append(" AND T2.CANA_OID_CANA = " + dtoe.getOidCanal());
            buf.append(" AND T2.MARC_OID_MARC = " + dtoe.getOidMarca());
            
            // sapaza -- SIN-RCR-20130906 AJUSTE PREMIACION CONSULTORAS -- 06/09/2013
            //buf.append(" AND T1.VAL_REQU_PREM_SUPE = 0 ");
            buf.append(" AND (T1.VAL_REQU_PREM_SUPE = 0 OR T2.BCAL_OID_BASE_CALC=4) ");
            
            buf.append(" AND T1.BINC_OID_BASE_INCU IS NULL ");
            buf.append(" AND T2.DIRI_OID_DIRI=" + ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
            
            //jrivas 20080535 Se saca la validación de último Periodo Evaluado
            /*buf.append(" AND T1.PERD_OID_PERI_EVAL = T5.OID_PERI(+) ");
            buf.append(" AND  ((SELECT T4.FEC_INIC FROM CRA_PERIO T4 WHERE ");
            buf.append(" T4.OID_PERI = " + dtoe.getOidPeriodo() + ") >= T5.FEC_INIC ");
            buf.append(" OR T1.PERD_OID_PERI_EVAL is null)");*/
            
            //jrivas 18/1/2006
            //INC-44
            buf.append(" AND T1.CLIE_OID_CLIE = " + oidCliente);
            buf.append(" AND T2.IND_ACTI = 1 ");
            
            // sapaza -- Cambio 20090929 -- 23/02/2010
            buf.append(" AND REQ.COPA_OID_PARA_GRAL(+) = T2.OID_PARA_GRAL");
             
            //jrivas 12/02/2007 DBLG70000320 Mejora Para que no procese los descalificados.
            buf.append("      AND NOT EXISTS ( ");
            buf.append("             SELECT * ");
            buf.append("               FROM INC_DESCA DES ");
            buf.append("              WHERE T1.CLIE_OID_CLIE = DES.CLIE_OID_CLIE ");
            buf.append("                AND T1.COPA_OID_PARA_GRAL = DES.COPA_OID_PARA_GRAL) ");
            
            buf.append(" GROUP BY T1.COPA_OID_PARA_GRAL " );

            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOOIDs dtoOid = new DTOOIDs();
        Long[] lista = null;

        if (!rs.esVacio()) {
            lista = new Long[rs.getRowCount()];

            Object tmpVal = null;

            for (int i = 0; i < rs.getRowCount(); i++) {
                tmpVal = rs.getValueAt(i, 0);

                if (tmpVal != null) {
                    lista[i] = new Long(((BigDecimal) tmpVal).longValue());
                }
            }

            dtoOid.setOids(lista);
        }

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerConcursos(DTOETramitar"
            +"Cierre dtoe): Salida");

        return dtoOid;
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException
    * @param Concurso concurso
    * @return void
    * @documentation
        Descripcion: este metodo obtiene los tipos de monto y sus cantidades 
        para un concurso determinado.

        Implementacion:
        1.- Efectuar una query filtrando la entidad INC:MontoVentaRecomendadas
        por el oidConcurso del concurso recibido por parametro.

        2.- Por cada registro recuperado crear un objeto de la clase TipoMonto, 
        completar sus campos como se detalla a continuacion y agregarlo a 
        un ArrayList:
        - tipo = INC:MontoVentaRecomendadas.tipoMontoVenta
        - cantidad = INC:MontoVentaRecomendadas.cantidadMontoVenta

        3.- Asignar el ArrayList del punto anterior al atributo 
        concurso.montosRecomendada
    */
    public void obtenerTiposMonto(Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOConcursoPremiacion.obtenerTiposMonto(Concurso "
            +"concurso): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(
                " SELECT tmvr_oid_tipo_mont_vent_reco, val_cant_mont_vent ");
            buf.append(" FROM inc_monto_venta_recom ");
            buf.append(" WHERE copa_oid_para_gral=" +
                concurso.getOidConcurso());
            buf.append(" ORDER BY TMVR_OID_TIPO_MONT_VENT_RECO ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        ArrayList alist = new ArrayList();
        TipoMonto tipMonto = null;

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal cantidad = (BigDecimal)rs.getValueAt(i,"VAL_CANT_MONT_VENT");
            if (cantidad != null) {
                tipMonto = new TipoMonto();
                tipMonto.setTipo(new Long(
                        ((BigDecimal) rs.getValueAt(i,
                            "TMVR_OID_TIPO_MONT_VENT_RECO")).longValue()));
                tipMonto.setCantidad(cantidad);
            } else {
                tipMonto = null;
            }
            alist.add(tipMonto);
        }

        concurso.setMontosRecomendada(alist);

        UtilidadesLog.info("DAOConcursoPremiacion.obtenerTiposMonto(Concurso "
            +"concurso):Salida");
    }
    
    /**
       * Sistema:     Belcorp
       * Modulo:      INC
       * Fecha:       18/10/2006
       * @version     1.0
       * @autor       Viviana Bongiovanni
    **/
    public RecordSet recuperarDatosDescripcionAbono(Long oidPeriodo, Long oidIdioma, Long oidTipoMovimiento) throws MareException {
        UtilidadesLog.info("MONPremiacionBean.recuperarDatosDescripcionAbono(Long oidPeriodo, Long oidIdioma, Long oidTipoMovimiento): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT gen1.VAL_I18N descTipoMov, mar.DES_MARC, gen2.VAL_I18N descCanal, corp.COD_PERI ");
        query.append(" FROM V_GEN_I18N_SICC gen1, CRA_PERIO cra, ");
        query.append(" SEG_MARCA mar, V_GEN_I18N_SICC gen2, SEG_PERIO_CORPO corp ");
        query.append(" WHERE cra.OID_PERI = " + oidPeriodo);
        query.append(" AND cra.MARC_OID_MARC = mar.OID_MARC ");
        query.append(" AND gen2.ATTR_NUM_ATRI = 1 ");
        query.append(" AND gen2.ATTR_ENTI= 'SEG_CANAL' ");
        query.append(" AND gen2.VAL_OID = cra.CANA_OID_CANA ");
        query.append(" AND gen2.IDIO_OID_IDIO = " + oidIdioma);
        query.append(" AND corp.OID_PERI = cra.PERI_OID_PERI ");
        query.append(" AND gen1.ATTR_NUM_ATRI = 1  ");
        query.append(" AND gen1.ATTR_ENTI= 'INC_TIPO_MOVIM' ");
        query.append(" AND gen1.VAL_OID = " + oidTipoMovimiento);
        query.append(" AND gen1.IDIO_OID_IDIO = " + oidIdioma);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONPremiacionBean.recuperarDatosDescripcionAbono(Long oidPeriodo, Long oidIdioma, Long oidTipoMovimiento): Salida");

        return rs;

    }


     /**
    * @autor jquiroga@indra.com.ar
    */

    private Long integer2Long(Integer num) {
        if (num == null) {
            return null;
        }
        return new Long(num.longValue());
    }

    /**
    * @autor jquiroga@indra.com.ar
    */ 

    private boolean switch2boolean(Boolean obj) {
        if ((obj == null) || !obj.booleanValue()) {
            return false;
        }
        return true;
    }

     /**
    * @autor jquiroga@indra.com.ar
    */ 
    private Double integer2Double(Integer num) {
        if (num == null) {
            return null;
        }
        return new Double(num.doubleValue());
    }

     /**
    * @autor jquiroga@indra.com.ar
    */ 
    private Long object2Long(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Long(((BigDecimal) obj).longValue());
    }
    
    private Integer object2Integer(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Integer(((BigDecimal) obj).intValue());
    }
    
    private Double object2Double(Object obj) {
        if (obj == null) {
            return null;
        }
        return new Double(((BigDecimal) obj).doubleValue());
    }

     /**
    * @autor jquiroga@indra.com.ar
    */ 
    private String object2String(Object obj) {
        if (obj == null) {
            return null;
        }
        return (String) obj;
    }
    
     /**
    * @autor jquiroga@indra.com.ar
    */ 
    private Date object2Date(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Date) obj;
    }
    
    private boolean object2boolean(Object obj) {
        if (obj == null) {
            return false;
        }
        
        double indicador = object2Double(obj);
        
        if (indicador > 0) {
            return true;
        } else {
            return false;
        }
    }
    
   // vbongiov -- Cambio 20090929 -- 18/09/2009
   private Periodo cargarPeriodoMaximo(Long oidPeriodoMaximo) throws MareException {
       UtilidadesLog.info("DAOConcursoPremiacion.cargarPeriodoMaximo(Long oidPeriodoMaximo): Entrada");

       BelcorpService bs;
       RecordSet rs;
       StringBuffer buf = new StringBuffer();
       Periodo retVal = null;

       try {
           bs = BelcorpService.getInstance();
       } catch (MareMiiServiceNotFoundException e) {
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
               UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }

       try {
           buf.append(" SELECT ");
           buf.append( " T2.COD_PERI, T1.FEC_INIC, T1.FEC_FINA, ");
           buf.append(" T1.CANA_OID_CANA, T1.MARC_OID_MARC,  ");
           buf.append(" T1.PAIS_OID_PAIS ");
           buf.append(" FROM CRA_PERIO T1, SEG_PERIO_CORPO T2 ");
           buf.append(" WHERE T1.PERI_OID_PERI=T2.OID_PERI ");
           buf.append(" AND T1.OID_PERI=" + oidPeriodoMaximo);

           rs = bs.dbService.executeStaticQuery(buf.toString());
           UtilidadesLog.debug("Resultado : " + rs);

           if (!rs.esVacio()) {
               //Cargar Objeto Periodo
               retVal = new Periodo();
               retVal.setOidPeriodo(oidPeriodoMaximo);
               retVal.setCodperiodo(object2String(
                   rs.getValueAt(0, "COD_PERI")));
               retVal.setFechaDesde(object2Date(
                   rs.getValueAt(0, "FEC_INIC")));
               retVal.setFechaHasta(object2Date(
                   rs.getValueAt(0, "FEC_FINA")));
               retVal.setOidCanal(object2Long(
                   rs.getValueAt(0, "CANA_OID_CANA")));
               retVal.setOidMarca(object2Long(
                   rs.getValueAt(0, "MARC_OID_MARC")));
               retVal.setOidPais(object2Long(
                   rs.getValueAt(0, "PAIS_OID_PAIS")));
           }
       } catch (Exception e) {
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
               UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }

       UtilidadesLog.info("DAOConcursoPremiacion.cargarPeriodoMaximo(Long oidPeriodoMaximo): Salida");

       return retVal;
   }

    
    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private ObtencionPuntosLocalHome getObtencionPuntosLocalHome() {
            return new ObtencionPuntosLocalHome();
    }

    private RequisitosPremiacionLocalHome getRequisitosPremiacionLocalHome() {
            return new RequisitosPremiacionLocalHome();
    }

    private ConcursoParametrosConsultorasLocalHome getConcursoParametrosConsultorasLocalHome() {
            return new ConcursoParametrosConsultorasLocalHome();
    }

    private ConcursoParametrosGerentesLocalHome getConcursoParametrosGerentesLocalHome() {
            return new ConcursoParametrosGerentesLocalHome();
    }


    
}