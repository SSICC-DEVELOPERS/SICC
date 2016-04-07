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
 * @autor: Damasia Maneiro
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
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOActualizaIndicadorDespachado;
import es.indra.sicc.dtos.inc.DTOObtenerTipoSubtipoSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.entidades.inc.GanadorasLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


class DAODespachoPremios {
    private UtilidadesLog log = new UtilidadesLog();

    public DAODespachoPremios() {
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo retorna un objeto de la clase 
    * TipoSolicitudPosicion con los datos de tipo de solicitud, tipo y subtipo
    * de posicion.  
    */
    public TipoSolicitudPosicion obtenerTipoSubtipoSolicitud(DTOObtenerTipoSubtipoSolicitud DTOE)
        throws MareException {
        UtilidadesLog.info("DAODespachoPremios.obtenerTipoSubtipoSolicitud("
            +"DTOObtenerTipoSubtipoSolicitud DTOE):Entrada");

        BelcorpService bs;
        RecordSet rs1;
        RecordSet rs2;
        RecordSet resultado = null;
        String codigoError;
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        TipoSolicitudPosicion tipoSolicitudPosicion = 
            new TipoSolicitudPosicion();
        BigDecimal subtipoPosicion = null;

        try {
            bs = BelcorpService.getInstance();

            Long tipoCliente = null;
    
            if (ConstantesINC.TIPO_CONSULTORA.equals(DTOE.getOidDirigidoA())) {
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
            }
    
            if (ConstantesINC.TIPO_GERENTE.equals(DTOE.getOidDirigidoA())) {
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
            }
            
            // Obtiene la clase de solicitud
            // vbongiov -- 16/08/2006
            Long claseSolicitud = null;
            
            if(ConstantesBEL.INC010.equals(DTOE.getOidOperacion())){
                claseSolicitud = ConstantesPED.CLASE_SOL_C1;       
            } else {
                claseSolicitud = ConstantesPED.CLASE_SOL_I1;
            }
         
            try {
                query.append(" SELECT TSOP.OID_TIPO_SOLI_PAIS, ");
                query.append(" TPOS_OID_TIPO_POSI, ");
                query.append(" STPO_OID_SUBT_POSI,");
                query.append(" TSPR.PROD_OID_PROD, ACCE.OID_ACCE, TSOLI.SBAC_OID_SBAC ");
                query.append(" FROM PED_TIPO_SOLIC_PROCE TSPR, PED_TIPO_SOLIC_PAIS TSOP,");
                query.append(" PED_TIPO_SOLIC TSOLI, SEG_ACCES ACCE, ");
                query.append(" INC_SOLIC_CONCU_PUNTA SCP, ");
                query.append(" PED_SOLIC_CABEC PSC ");
                query.append(" WHERE TSPR.TSPA_OID_TIPO_SOLI_PAIS =  ");
                query.append("  TSOP.OID_TIPO_SOLI_PAIS");
                query.append(" AND TSOP.TSOL_OID_TIPO_SOLI = TSOLI.OID_TIPO_SOLI");
                query.append(" AND TSOP.PAIS_OID_PAIS = " + DTOE.getOidPais());
                query.append(" AND TSPR.OPER_OID_OPER = " + DTOE.getOidOperacion());
                query.append(" AND TSOLI.TICL_OID_TIPO_CLIE = " + tipoCliente);
                query.append(" AND TSOLI.ACCE_OID_ACCE = ACCE.OID_ACCE");
                query.append(" AND ACCE.CANA_OID_CANA = " + DTOE.getOidCanal());
                query.append(" AND TSOLI.MARC_OID_MARC = " + DTOE.getOidMarca());
                
                
                if(DTOE.getOidConcurso() != null) {
                    query.append(" AND SCP.COPA_OID_PARA_GRAL (+) = " +  DTOE.getOidConcurso());
                }
                
                if (ConstantesINC.TIPO_CONSULTORA.equals(DTOE.getOidDirigidoA())) {
                    query.append(" AND SCP.CLIE_OID_CLIE = " + DTOE.getOidCliente());
                    
                    query.append(" AND SCP.CLIE_OID_CLIE = PSC.CLIE_OID_CLIE ");
                    query.append(" AND PSC.CLIE_OID_CLIE = " + DTOE.getOidCliente());
                       
                } else if (ConstantesINC.TIPO_GERENTE.equals(DTOE.getOidDirigidoA())) {
                    query.append(" AND SCP.CLIE_OID_CLIE_GERE = " + DTOE.getOidCliente());
                }
                
                if(DTOE.getOidPeriodo()!=null){
                    query.append(" AND SCP.PERD_OID_PERI = " + DTOE.getOidPeriodo());
                }                
                
                query.append(" AND SCP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
                query.append(" AND PSC.TSPA_OID_TIPO_SOLI_PAIS_CONS = TSOP.TSOL_OID_TIPO_CONS ");
                query.append(" AND TSOLI.CLSO_OID_CLAS_SOLI = " + claseSolicitud );
                query.append(" GROUP BY TSOP.OID_TIPO_SOLI_PAIS,TPOS_OID_TIPO_POSI,");
                query.append(" STPO_OID_SUBT_POSI,TSPR.PROD_OID_PROD, ACCE.OID_ACCE, ");
                query.append(" TSOLI.SBAC_OID_SBAC, TSOP.TSOL_OID_TIPO_CONS ");
                
                rs1 = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }
    
            if (!rs1.esVacio()) {
                resultado = rs1;
                
            } else {                
                try {
                    query1.append(" SELECT TSOP.OID_TIPO_SOLI_PAIS, ");
                    query1.append(" TPOS_OID_TIPO_POSI, ");
                    query1.append(" STPO_OID_SUBT_POSI,");
                    query1.append(
                        " TSPR.PROD_OID_PROD, ACCE.OID_ACCE, TSOLI.SBAC_OID_SBAC ");
                    query1.append(
                        " FROM PED_TIPO_SOLIC_PROCE TSPR, PED_TIPO_SOLIC_PAIS TSOP,");
                    query1.append(" PED_TIPO_SOLIC TSOLI, SEG_ACCES ACCE");
                    query1.append(" WHERE TSPR.TSPA_OID_TIPO_SOLI_PAIS =  ");
                    query1.append("  TSOP.OID_TIPO_SOLI_PAIS");
                    query1.append(" AND TSOP.TSOL_OID_TIPO_SOLI = TSOLI.OID_TIPO_SOLI");
                    query1.append(" AND TSOP.PAIS_OID_PAIS = " + DTOE.getOidPais());
                    query1.append(" AND TSPR.OPER_OID_OPER = " + DTOE.getOidOperacion());
                    query1.append(" AND TSOLI.TICL_OID_TIPO_CLIE = " + tipoCliente);
                    query1.append(" AND TSOLI.ACCE_OID_ACCE = ACCE.OID_ACCE");
                    query1.append(" AND ACCE.CANA_OID_CANA = " + DTOE.getOidCanal());
                    query1.append(" AND TSOLI.MARC_OID_MARC = " + DTOE.getOidMarca());
                  
                    resultado = bs.dbService.executeStaticQuery(query1.toString());
                    
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }
            }
                
            if (resultado != null && !resultado.esVacio()) {

                tipoSolicitudPosicion.setTipoSolicitud(new Long(
                        ((BigDecimal) resultado.getValueAt(0, "OID_TIPO_SOLI_PAIS"))
                            .longValue()));
    
                if (resultado.getValueAt(0, "TPOS_OID_TIPO_POSI") != null) {
                    tipoSolicitudPosicion.setTipoPosicion(new Long(
                            ((BigDecimal) resultado.getValueAt(0, "TPOS_OID_TIPO_POSI"))
                                .longValue()));
                }
    
                if (resultado.getValueAt(0, "STPO_OID_SUBT_POSI") != null) {
                    tipoSolicitudPosicion.setSubtipoPosicion(new Long(
                            ((BigDecimal) resultado.getValueAt(0, "STPO_OID_SUBT_POSI"))
                                .longValue()));
                }
    
                if (resultado.getValueAt(0, "PROD_OID_PROD") != null) {
                    tipoSolicitudPosicion.setProducto(new Long(
                            ((BigDecimal) resultado.getValueAt(0, "PROD_OID_PROD"))
                                .longValue()));
                }
    
                tipoSolicitudPosicion.setAcceso(new Long(
                        ((BigDecimal) resultado.getValueAt(0, "OID_ACCE")).longValue()));
    
                if (resultado.getValueAt(0, "SBAC_OID_SBAC") != null) {
                    tipoSolicitudPosicion.setSubacceso(new Long(
                            ((BigDecimal) resultado.getValueAt(0, "SBAC_OID_SBAC"))
                                .longValue()));
                }
            }
            
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        } 

        UtilidadesLog.info("DAODespachoPremios.obtenerTipoSubtipoSolicitud("
            +"DTOObtenerTipoSubtipoSolicitud DTOE):Salida");

        return tipoSolicitudPosicion;
    }

    /**
    * Fecha de Creacion: 04/05/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo actualiza el flag despachado de la entidad
    * INC:Ganadoras.
    * 
    * Modificado: Cristian Valenzuela
    * Fecha: 9/11/2006
    * Incidencia: BELC300023086
    *
    */
  
    /*public void actualizarIndicadorDespachado(
        ClientePremiacion clientePremiacion, Long nivelPremiacion,
        ClientePremiacionConcurso clienteConcurso, Long oidPeriodoControl, Long oidCabSol) throws MareException {*/
        
      public void actualizarIndicadorDespachado(DTOActualizaIndicadorDespachado dtoe) 
        throws MareException {
        
        UtilidadesLog.info("DAODespachoPremios.actualizarIndicadorDespachado"+
        "(DTOActualizaIndicadorDespachado dtoe):Entrada");       
        
        ClientePremiacion clientePremiacion = dtoe.getClientePremiacion();
        ClientePremiacionConcurso clienteConcurso = dtoe.getClienteConcurso();
        Long oidNivelPremiacion = dtoe.getOidNivelPremiacion();
        Long oidPeriodoControl = dtoe.getOidPeriodoControl();
        Long oidCabSol = dtoe.getOidCabSol();
        Long oidGanadora = dtoe.getOidGanadora();        
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("oidNivelPremiacion: " + oidNivelPremiacion);
          UtilidadesLog.debug("oidPeriodoControl: " + oidPeriodoControl);
          UtilidadesLog.debug("oidCabSol: " + oidCabSol);
          UtilidadesLog.debug("oidGanadora: " + oidGanadora);
        }
        
        try {
            GanadorasLocalHome ganadorasLocalHome = this.getGanadorasLocalHome();
                
            DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
            Concurso concurso = despacharPremiosHelper.obtenerConcurso(clienteConcurso.getOidConcurso());                
                
            Long oidPeriodo = null;
            
            // vbongiov -- 10/08/2006 -- Inc DBLG500000767
            if (oidPeriodoControl==null) {
                ///jrivas 12/7/2006  DBLG500000754
                //se necesita primero ver si tengo periodo despacho, si no lo ntego, guardo periodo actual.
                if ((concurso.getPeriodoDeDespacho() != null) && 
                    (concurso.getPeriodoDeDespacho().getOidPeriodo() != null) && 
                    (!concurso.getIndRanking())) {
                    oidPeriodo = concurso.getPeriodoDeDespacho().getOidPeriodo();
                }
                else {
                    // Obtener periodo actual 
                    // vbongiov - 10/05/2006 - DBLG500000363
                    MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();            
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("pais: " + clientePremiacion.getOidPais() + 
                                        "marca: " + clientePremiacion.getOidMarca() +
                                        "canal: " + clientePremiacion.getOidCanal());
                    
                    DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                clientePremiacion.getOidMarca(),
                                                clientePremiacion.getOidCanal());
                    oidPeriodo = periodoActual.getOid();                                            
                }                    
            }
            else {
                oidPeriodo = oidPeriodoControl;
            }            
                                            
            /*UtilidadesLog.debug("UK: cliente: " + clientePremiacion.getOidCliente() +
            " periodo: " + oidPeriodo + " nivel: " + oidNivelPremiacion);                                                           
            Collection ganadoras = ganadorasLocalHome.findByUK(clientePremiacion.getOidCliente(),
            oidPeriodo, oidNivelPremiacion);*/
            
            if(oidGanadora!=null) {
            
              GanadorasLocal ganadora = ganadorasLocalHome.findByPrimaryKey(oidGanadora);
              
              if(ganadora != null) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("ganadora: " + ganadora.getOid());
                  
                ganadora.setDespachado(Boolean.TRUE);
                //cvalenzu - BELC300023086
                ganadora.setCabeceraSolicitud(oidCabSol);                
                //FIN - cvalenzu - BELC300023086                
                ganadorasLocalHome.merge(ganadora);
              }
            }            
        } catch (NoResultException fe) {
            //UtilidadesLog.debug(fe);
            //throw new MareException(fe,UtilidadesError.armarCodigoError(
            //CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("DAODespachoPremios.actualizarIndicadorDespachado"+
        "(DTOActualizaIndicadorDespachado dtoe):Salida");       
    }

    /**
    * Fecha de Creacion: 04/05/2005
    * Autor: Damasia Maneiro
    * Comentario: guarda un registro en la cuenta corriente de puntos de 
    * acuerdo a los parametros de entrada.
    *
    */
    public void actualizarCuentaCorrientePuntos(
        ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clienteConcurso, PremioPuntos premioPuntos)
        throws MareException {
        UtilidadesLog.info("DAODespachoPremios. actualizarCuentaCorrientePunto"
            +"s(ClientePremiacion clientePremiacion, ClientePremiacionConcurso"
            +"clienteConcurso,PremioPuntos premioPuntos):Entrada");

        try {
            UtilidadesLog.debug("premioPuntos.getImportePremio() " +
                premioPuntos.getImportePremio());
            UtilidadesLog.debug("clienteConcurso.getSaldoPuntosExigidos() " +
                clienteConcurso.getSaldoPuntosExigidos());
            UtilidadesLog.debug("premioPuntos.getOidConcursoDestino() " +
                premioPuntos.getOidConcursoDestino());
            UtilidadesLog.debug("clientePremiacion.getOidCliente() " +
                clientePremiacion.getOidCliente());
            UtilidadesLog.debug(
                "clientePremiacion.getPeriodo().getOidPeriodo() " +
                clientePremiacion.getPeriodo().getOidPeriodo());

            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesHome = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concursoParametrosGenerales = concursoParametrosGeneralesHome.findByPrimaryKey(
                                                    clienteConcurso.getOidConcurso());
            String numeroConcurso = concursoParametrosGenerales.getNumeroConcurso();

            CuentaCorrientePuntosLocalHome cuentaCorrientePuntosLocalHome = this.getCuentaCorrientePuntosLocalHome();
            CuentaCorrientePuntosLocal cuentaCorrientePuntosLocal;

            //public Long ejbCreate(Integer numPunt, Integer numPuntExig, Date 
            //fecMovi, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri
            // Long tmovOidTipoMovi) throws MareException
            cuentaCorrientePuntosLocal = cuentaCorrientePuntosLocalHome.create(new Integer(premioPuntos.getImportePremio().intValue()),
                                                                new Integer(clienteConcurso.getSaldoPuntosExigidos().intValue()),
                                                                new Date(System.currentTimeMillis()),
                                                                premioPuntos.getOidConcursoDestino(),
                                                                clientePremiacion.getOidCliente(),
                                                                clientePremiacion.getPeriodo().getOidPeriodo(),
                                                                ConstantesINC.TIPO_MOVIMIENTO_ABONO);

            cuentaCorrientePuntosLocal.setVal_desc("Puntos premio del concurso " + numeroConcurso);
            cuentaCorrientePuntosLocalHome.merge(cuentaCorrientePuntosLocal);
        } catch (NoResultException fe) {
            //UtilidadesLog.error("ERROR ", e);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        }

        UtilidadesLog.info("DAODespachoPremios. actualizarCuentaCorrientePun"
            +"tos(ClientePremiacion clientePremiacion, ClientePremiacionConc"
            +"urso clienteConcurso, PremioPuntos premioPuntos):Salida");
    }
    
    /**
    * Fecha de Creacion: 21/06/06
    * Autor: Viviana Bongiovanni
    * Inc DBLG500000775
    */
    public void actualizarIndicadorListarGanador(
        ClientePremiacion clientePremiacion, Long nivelPremiacion,
        ClientePremiacionConcurso clienteConcurso, Long oidPeriodoControl) throws MareException {
        UtilidadesLog.info("DAODespachoPremios.actualizarIndicadorListarGanador("
            +"ClientePremiacion clientePremiacion, Long nivelPremiacion, "
            +"ClientePremiacionConcurso clienteConcurso, Long oidPeriodoControl):Entrada");

        try {
            GanadorasLocalHome ganadorasLocalHome = this.getGanadorasLocalHome();

            DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
            Concurso concurso = despacharPremiosHelper.obtenerConcurso(clienteConcurso.getOidConcurso());                
                
            // vbongiov -- 10/08/2006 -- Inc DBLG500000767
            Long oidPeriodo = null;
            if (oidPeriodoControl==null) {                    
                //jrivas 12/7/2006  DBLG500000754
                //se necesita primero ver si tengo periodo despacho, si no lo ntego, guardo periodo actual.
                if ((concurso.getPeriodoDeDespacho() != null) && (concurso.getPeriodoDeDespacho().getOidPeriodo() != null) && (!concurso.getIndRanking())) {
                    oidPeriodo = concurso.getPeriodoDeDespacho().getOidPeriodo();
                } else {                        
                    // Obtener periodo actual 
                    // vbongiov - 10/05/2006 - DBLG500000363
                    MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();            
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("pais: " + clientePremiacion.getOidPais() + " marca: " + clientePremiacion.getOidMarca() +
                                        "canal: " + clientePremiacion.getOidCanal());
                    
                    DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                clientePremiacion.getOidMarca(),
                                                clientePremiacion.getOidCanal());
                    
                    oidPeriodo = periodoActual.getOid();                                                                                        
                }            
            } else {
                oidPeriodo = oidPeriodoControl;
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("UK: cliente: " + clientePremiacion.getOidCliente() +
                " periodo: " + oidPeriodo + " nivel: " + nivelPremiacion);                                        
                        
            Collection ganadoras = ganadorasLocalHome.findByUK(clientePremiacion.getOidCliente(),
                                                              oidPeriodo,
                                                              nivelPremiacion);
                                                              
            GanadorasLocal ganadora;
            Iterator it = ganadoras.iterator();

            while (it.hasNext()) {
                ganadora = (GanadorasLocal) it.next();
                UtilidadesLog.debug("ganadora: " + ganadora.getOid());
                ganadora.setListarGanador(Boolean.TRUE);
                ganadorasLocalHome.merge(ganadora);
            }
            
        } catch (NoResultException fe) {
            //UtilidadesLog.debug(fe);
            //throw new MareException(fe,UtilidadesError.armarCodigoError(
            //CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("DAODespachoPremios.actualizarIndicadorListarGanador("
            +"ClientePremiacion clientePremiacion, Long nivelPremiacion, "
            +"ClientePremiacionConcurso clienteConcurso, Long oidPeriodoControl):Salida");
    }

    private GanadorasLocalHome getGanadorasLocalHome() {
            return new GanadorasLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010  
    public String validaPremioBloqueado(String codigoRegion, String codigoConcurso, String codigoPeriodo, 
                                            Long oidProducto, Long codigoVenta) throws MareException {
      UtilidadesLog.info("DAODespachoPremios.validaPremioBloqueado(String codigoRegion, String codigoConcurso): Entrada");
      BelcorpService bs;
      RecordSet rs = null;
        
      StringBuffer query = new StringBuffer();

      query.append("SELECT blo.IND_REEM ");
      query.append("  FROM INC_PREMI_BLOQU blo, MAE_PRODU pro ");
      query.append(" WHERE pro.OID_PROD = " + oidProducto); 
      query.append("   AND blo.COD_REGI = '" + codigoRegion + "' "); 
      query.append("   AND blo.COD_CONC = '" + codigoConcurso + "' "); 
      query.append("   AND blo.CAM_BLOQ = '" + codigoPeriodo + "' "); 
      query.append("   AND blo.COD_SAP = pro.COD_SAP ");  
      query.append("   AND blo.COD_VENT_FICT = '" + codigoVenta + "' "); 
      
      try {
          bs = BelcorpService.getInstance();
          rs = bs.dbService.executeStaticQuery(query.toString());  
          
          if( rs.getRowCount() > 0 ){
            String indicadorReemplazo = (String)rs.getValueAt(0, 0);
            UtilidadesLog.info("DAODespachoPremios.validaPremioBloqueado(String codigoRegion, String codigoConcurso): Salida");
            return indicadorReemplazo;
          } else{
            UtilidadesLog.info("DAODespachoPremios.validaPremioBloqueado(String codigoRegion, String codigoConcurso): Salida2");
            return null;
          }            
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
    }   

    //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010                        
    public void insertarPremioPendiente(Premio premioGanado, ClientePremiacion clientePremiacion, Concurso concurso, DTOPosicionSolicitud dtoPosicionSolicitud) throws MareException {
        UtilidadesLog.info("DAODespachoPremios.insertarPremioPendiente(Premio premioGanado, ClientePremiacion clientePremiacion): Entrada");
        
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        StringBuffer insert = new StringBuffer();
        String codigoCliente = null;
        RecordSet rs = null;
        
        query.append("SELECT COD_CLIE ");
        query.append("  FROM MAE_CLIEN ");
        query.append(" WHERE OID_CLIE = " + clientePremiacion.getOidCliente());
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString()); 
            codigoCliente = (String)rs.getValueAt(0, 0);

            insert.append(" INSERT INTO INC_PREMI_PENDI_SOLIC ( ");
            insert.append("   COR_PREM_PEND, COD_PAIS, ");
            insert.append("   CAM_BLOQ, COD_CONC, ");
            insert.append("   COD_CLIE, COD_REGI, ");
            insert.append("   COD_SAP, COD_VENT_FICT, ");
            insert.append("   PROD_OID_PROD, COPA_OID_PARA_GRAL,  ");
            insert.append("   PANP_OID_PARA_NIVE_PREM, LOPA_OID_LOTE_PREM_ARTI, ");
            insert.append("   ICTP_OID_CONC_TIPO_PROG, NUM_UNID_DEMA, ");
            insert.append("   USU_CREA, FEC_CREA, ");
            insert.append("   USU_MODI, FEC_MODI) ");
            insert.append(" VALUES (INC_PPEN_SEQ.nextval ");
            insert.append(" , (SELECT COD_PAIS FROM SEG_PAIS WHERE OID_PAIS = " + clientePremiacion.getOidPais() + ")");
            insert.append(" , '" + clientePremiacion.getPeriodo().getCodperiodo() + "'");
            insert.append(" , '" + concurso.getNumeroConcurso() + "'");
            insert.append(" , '" + codigoCliente + "'");
            insert.append(" , '" + clientePremiacion.getDatosPersonales().getCodRegion() + "'");
            insert.append(" , (SELECT COD_SAP FROM MAE_PRODU WHERE OID_PROD = " + dtoPosicionSolicitud.getProducto() + ")");
            insert.append(" , '" + dtoPosicionSolicitud.getCodigoVentaFicticio() + "'");
            insert.append(" , " + dtoPosicionSolicitud.getProducto());
            insert.append(" , " + concurso.getOidConcurso());
            insert.append(" , " + premioGanado.getNivel().getOidNivel());
            insert.append(" , " + premioGanado.getOidPremio());
            insert.append(" , (SELECT ICTP_OID_CONC_TIPO_PROG FROM INC_CONCU_PARAM_GENER WHERE OID_PARA_GRAL = " + concurso.getOidConcurso() + ")");
            insert.append(" , " + dtoPosicionSolicitud.getUnidadesDemandadas());
            insert.append(" , 'ADMIN'");
            insert.append(" , SYSDATE");
            insert.append(" , 'ADMIN'");
            insert.append(" , SYSDATE");
            insert.append(" ) ");
            
            bs.dbService.executeUpdate(insert.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAODespachoPremios.insertarPremioPendiente(Premio premioGanado, ClientePremiacion clientePremiacion): Salida");
    }

    // sapaza -- PER-SiCC-2012-0398 -- 22/05/2012
    public String ejecutarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidConcurso, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOSolicitud.ejecutarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidConcurso, Long oidCliente): Entrada ");
        StringBuffer query = new StringBuffer();
        RecordSet respuesta;
        BelcorpService bs;
        String resultado;

        try {
            bs = BelcorpService.getInstance();
            
            ArrayList params = new ArrayList();
            params.add(oidPais.toString());
            params.add(oidPeriodo.toString());
            params.add(oidConcurso.toString());
            params.add(oidCliente.toString());
            
            respuesta = bs.dbService.executeProcedure("PQ_PLANI.INC_PR_PROGR_NUEVA_REGAL", params);
            
            resultado = respuesta.getValueAt(0,0).toString();
            UtilidadesLog.debug("resultado: " + resultado);
            
            UtilidadesLog.info("DAOSolicitud.ejecutarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidConcurso, Long oidCliente): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        return resultado;
    }

    // sapaza -- PER-SiCC-2012-0398 -- 20/06/2012
    public boolean consultarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOSolicitud.consultarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidConcurso, Long oidCliente): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        boolean resultado = false;

        try {
            bs = BelcorpService.getInstance();
            
            query.append(" SELECT COUNT(1) ");
            query.append("   FROM NVS_CONSU_REGAL_PEDID reg, MAE_CLIEN cli, CUP_PROG_NUEVA_CUPON cup, ");
            query.append("        CRA_PERIO per, SEG_PERIO_CORPO cor, SEG_PAIS pai ");
            query.append("  WHERE reg.CONS_COD_CONS = cli.COD_CLIE ");
            query.append("    AND reg.CONS_COD_PROG = cup.COD_PROG ");
            query.append("    AND reg.COD_PERI_DESP = cor.COD_PERI ");
            query.append("    AND reg.CONS_COD_PAIS = pai.COD_PAIS ");
            query.append("    AND cor.OID_PERI = per.PERI_OID_PERI ");
            query.append("    AND pai.OID_PAIS = " + oidPais + " ");
            query.append("    AND per.OID_PERI = " + oidPeriodo + " ");
            query.append("    AND cli.OID_CLIE = " + oidCliente + " ");
            query.append("    AND reg.EST_REGA = '01' ");
            query.append("    AND cup.IND_PREM_INCE = '1' ");
            
            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
    
            BigDecimal cantidad = (BigDecimal)rs.getValueAt(0, 0);
            if (cantidad.intValue() > 0) {
              resultado = true;
            }
            
            UtilidadesLog.info("DAOSolicitud.consultarProgramasNuevasRegalo(Long oidPais, Long oidPeriodo, Long oidCliente): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        return resultado;
    }
    
}
