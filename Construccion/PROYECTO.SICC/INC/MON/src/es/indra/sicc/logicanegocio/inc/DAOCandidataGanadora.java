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
 * @author : Dante Castiglione
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


public class DAOCandidataGanadora {
    private static final boolean debug = true;
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOCandidataGanadora() {
    }

    /**
     * Acualiza candidata ganadora según la evaluacion de requisitos premiacion
     * @author Dante Castiglione
     * Se agrega el parámetro tipoCierre Incidencia SICC 20070148
     */
    public void actualizaCandidataGanadora(ClientePremiacion clientePremiacion, String tipoCierre) throws MareException {
        String codigoUsuario = "ADMIN";
        /*
         * Autor : JVM
         * Fecha : 26-Mar-2006
         * Desc  : SICC-20070148 se agrega el parametro tipoCierre en el metodo 
         */
         
        String t;
        
        UtilidadesLog.info("DAOCandidataGanadora.actualizaCandidataGanadora"
            +"(ClientePremiacion clientePremiacion, String tipoCierre):Entrada");

        HashMap clientesPremiacionConcurso = 
            clientePremiacion.getClientesPremiacionConcurso();
            
        Collection clientesCollection = clientesPremiacionConcurso.values();
        Iterator clientesIterator = clientesCollection.iterator();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** Nro. de ClientesPremiacionConcurso: " + clientesCollection.size());

        while (clientesIterator.hasNext()) {
            ClientePremiacionConcurso clientePremiacionConcurso = (ClientePremiacionConcurso) clientesIterator.next();
            
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("ClientePremiacionConcurso.getActualizarCandidataGanadora = " + clientePremiacionConcurso.getActualizarCandidataGanadora());
              UtilidadesLog.debug("clientePremiacionConcurso.getRequisitosPremiacionSuperado()= " + clientePremiacionConcurso.getRequisitosPremiacionSuperado());
              UtilidadesLog.debug("tipoCierre= " + tipoCierre);
              UtilidadesLog.debug("ConstantesFAC.TIPO_CIERRE_ZONA="+ConstantesFAC.TIPO_CIERRE_PERIODO);
              UtilidadesLog.debug("ConstantesFAC.TIPO_CIERRE_ZONA="+ConstantesFAC.TIPO_CIERRE_ZONA);
            }  

            /*
             * Autor : JVM
             * Fecha : 26-Mar-2006
             * Desc  : SICC-20070148, se modifica la condición 
             */
            if (clientePremiacionConcurso.getActualizarCandidataGanadora() && 
                (   
                    (tipoCierre == null) ||
                    (
                        (tipoCierre != null && tipoCierre == ConstantesFAC.TIPO_CIERRE_PERIODO) ||
                        (
                            (clientePremiacionConcurso.getRequisitosPremiacionSuperado() == true) &&
                            (tipoCierre != null && tipoCierre == ConstantesFAC.TIPO_CIERRE_ZONA)
                        )
                    )
                )
               ) 
            {
            
                BelcorpService bs;
                StringBuffer query = new StringBuffer();
        
                try {
                    bs = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }
                                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                  UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + clientePremiacionConcurso.getRequisitosPremiacionSuperado());
                  UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + clientePremiacionConcurso.getOidConcurso());
                  UtilidadesLog.debug("CLIE_OID_CLIE:  " + clientePremiacion.getOidCliente());
                  UtilidadesLog.debug("clientePremiacion.getPeriodo().getOidPeriodo():  " + clientePremiacion.getPeriodo().getOidPeriodo());
                }
                
                try {
                    query.append(" UPDATE INC_CANDI_GANAD CG ");
                    query.append(" SET ");

                    /*
                     * Autor : JVM
                     * Fecha : 26-Mar-2006
                     * Desc  : SICC-20070148 se agrega condición
                     */        
                    t=" ";
                    if((tipoCierre == null) || (tipoCierre!=null && tipoCierre==ConstantesFAC.TIPO_CIERRE_PERIODO))
                    {
                        query.append(" CG.BINC_OID_BASE_INCU = " + clientePremiacionConcurso.getOidBaseIncumplida());                
                        t=",";
                    }
                    
                    //Se corrige en base la incidencia Bloqueante PED-28
                    //El campo VAL_REQU_PREM_SUPE es number de 1, y estaba tratando de grabarse un boolean
                    //query.append(" , CG.VAL_REQU_PREM_SUPE = " + clientePremiacionConcurso.getRequisitosPremiacionSuperado());

                    /*
                     * Autor : JVM
                     * Fecha : 26-Mar-2006
                     * Desc  : SICC-20070148 se agrega condición
                     */                                                             
                    if((clientePremiacionConcurso.getRequisitosPremiacionSuperado()==true) &&
                       ((tipoCierre==null) || (tipoCierre != null && tipoCierre == ConstantesFAC.TIPO_CIERRE_ZONA))
                      ) 
                    {
                        query.append(t+" CG.VAL_REQU_PREM_SUPE = 1");    
                    }else {
                        query.append(t+" CG.VAL_REQU_PREM_SUPE = 0");
                    }

                    /*
                     * Autor : JVM
                     * Fecha : 26-Mar-2006
                     * Desc  : SICC-20070148 se agrega condición
                     */  
                    if (clientePremiacionConcurso.getUltimoPeriodoEvaluado() != null) {
                        query.append(" , ");
                        query.append(" CG.PERD_OID_PERI_EVAL = " + clientePremiacionConcurso.getUltimoPeriodoEvaluado().getOidPeriodo());
                    }
                    
                    // sapaza -- PER-SiCC-2010-0403 -- 07/07/2010
                    if((tipoCierre == null) && (clientePremiacionConcurso.getOidReglaRechazada() != null)) {
                        query.append(" , ");
                        query.append(" CG.REGL_OID_REGL = " + clientePremiacionConcurso.getOidReglaRechazada());    
                    }
                    
                    // sapaza -- PER-SiCC-2014-0081 -- 30/01/2014
                    if(!clientePremiacionConcurso.getRequisitosPremiacionSuperado()) {
                        query.append(" WHERE ");
                        query.append(" CG.OID_CAND_GANA IN ( ");
                        query.append(" SELECT OID_CAND_GANA ");
                        query.append(" FROM INC_CANDI_GANAD CG, CRA_PERIO T5 ");
                        query.append(" WHERE CG.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
                        query.append(" AND CG.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
                        query.append(" AND CG.VAL_REQU_PREM_SUPE = 0 ");
                        query.append(" AND CG.BINC_OID_BASE_INCU IS NULL ");
                        query.append(" AND CG.PERD_OID_PERI_EVAL = T5.OID_PERI(+)  ");
                        query.append(" AND  ( ");
                        query.append(" (SELECT T4.FEC_INIC FROM CRA_PERIO T4 WHERE T4.OID_PERI = " + clientePremiacion.getPeriodo().getOidPeriodo());
                        query.append(") >= T5.FEC_INIC  ");
                        query.append(" OR CG.PERD_OID_PERI_EVAL is null ");
                        query.append(" ) ");
                        query.append(" ) ");
                    
                        bs.dbService.executeUpdate(query.toString());
                    }     
                    
                    // sapaza -- PER-SiCC-2014-0854 -- 13/10/2014
                    if((tipoCierre == null) && (clientePremiacionConcurso.getOidReglaRechazada() != null)) {
                        StringBuffer update = new StringBuffer();
                        update.append("update INC_PREMI_ELEGI ");
                        update.append("   set ind_pend = 4, COD_MOTI_INVA=10, ");
                        update.append("       usu_modi = '" + codigoUsuario + "', ");
                        update.append("       fec_modi = SYSDATE ");
                        update.append("where copa_oid_para_gral = " + clientePremiacionConcurso.getOidConcurso());
                        update.append("  and clie_oid_clie = " + clientePremiacion.getOidCliente());
                        update.append("  and ind_pend = 1 ");
                        
                        bs.dbService.executeUpdate(update.toString());    
                    }
                    
                    /*// sapaza -- PER-SiCC-2011-0700 -- 05/10/2011
                    if((tipoCierre == null) && (clientePremiacionConcurso.getOidReglaRechazada() != null)) {
                        this.actualizarReglaCuentaCorriente(clientePremiacion.getOidCliente(), clientePremiacionConcurso.getOidConcurso(),
                                      clientePremiacion.getPeriodo().getOidPeriodo(), clientePremiacionConcurso.getOidReglaRechazada(),
                                      new Long(clientePremiacionConcurso.getSaldoPuntosConcurso().longValue()));
                    }*/
                    
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }                            
            }
            else { // sapaza -- PER-SiCC-2010-0403 -- 07/07/2010

                if (tipoCierre == null && (clientePremiacionConcurso.getOidReglaRechazada() != null)) {

                    BelcorpService bs;
                    StringBuffer query = new StringBuffer();
                    
                    try {
                        bs = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }
        
                    try {
                        query.append(" UPDATE INC_CANDI_GANAD CG ");
                        query.append(" SET ");
                        
                        query.append(" CG.REGL_OID_REGL = " + clientePremiacionConcurso.getOidReglaRechazada());    
                        
                        query.append(" WHERE ");
                        query.append(" CG.OID_CAND_GANA IN ( ");
                        query.append(" SELECT OID_CAND_GANA ");
                        query.append(" FROM INC_CANDI_GANAD CG, CRA_PERIO T5 ");
                        query.append(" WHERE CG.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
                        query.append(" AND CG.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
                        query.append(" AND CG.VAL_REQU_PREM_SUPE = 0 ");
                        query.append(" AND CG.BINC_OID_BASE_INCU IS NULL ");
                        query.append(" AND CG.PERD_OID_PERI_EVAL = T5.OID_PERI(+)  ");
                        query.append(" AND  ( ");
                        query.append(" (SELECT T4.FEC_INIC FROM CRA_PERIO T4 WHERE T4.OID_PERI = " + clientePremiacion.getPeriodo().getOidPeriodo());
                        query.append(") >= T5.FEC_INIC  ");
                        query.append(" OR CG.PERD_OID_PERI_EVAL is null ");
                        query.append(" ) ");
                        query.append(" ) ");
                        bs.dbService.executeUpdate(query.toString());
                        
                        // sapaza -- PER-SiCC-2014-0854 -- 13/10/2014
                        StringBuffer update = new StringBuffer();
                        update.append("update INC_PREMI_ELEGI ");
                        update.append("   set ind_pend = 4, COD_MOTI_INVA=10, ");
                        update.append("       usu_modi = '" + codigoUsuario + "', ");
                        update.append("       fec_modi = SYSDATE ");
                        update.append("where copa_oid_para_gral = " + clientePremiacionConcurso.getOidConcurso());
                        update.append("  and clie_oid_clie = " + clientePremiacion.getOidCliente());
                        update.append("  and ind_pend = 1 ");
                        
                        bs.dbService.executeUpdate(update.toString());    
                    
                        // sapaza -- PER-SiCC-2014-0081 -- 30/01/2014
                        /*// sapaza -- PER-SiCC-2011-0700 -- 05/10/2011
                        this.actualizarReglaCuentaCorriente(clientePremiacion.getOidCliente(), clientePremiacionConcurso.getOidConcurso(),
                                clientePremiacion.getPeriodo().getOidPeriodo(), clientePremiacionConcurso.getOidReglaRechazada(),
                                new Long(clientePremiacionConcurso.getSaldoPuntosConcurso().longValue()));*/
                    
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
                }                    
            }
        }
        
        UtilidadesLog.info("DAOCandidataGanadora.actualizaCandidataGanadora("
            +"ClientePremiacion clientePremiacion):Salida");
    }

    /**
     * @author Dante Castiglione
     */
    public DTOOIDs obtenerCandidatasARevertir(Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOCandidataGanadora.obtenerCandidatasARevertir("
            +"Long oidCliente):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" OID_CAND_GANA ");
            query.append(" FROM INC_CANDI_GANAD ");
            query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND VAL_REQU_PREM_SUPE <> 1 ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOOIDs dtoOids = new DTOOIDs();

        if (respuesta.esVacio()) {
            dtoOids.setOids(null);
        } else {
            Long[] ids = new Long[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                            "OID_CAND_GANA")).longValue());
            }

            dtoOids.setOids(ids);
        }

        UtilidadesLog.info("DAOCandidataGanadora.obtenerCandidatasARevertir("
            +"Long oidCliente):Salida");

        return dtoOids;
    }

    /*
     * Este metodo verifica si en periodos anteriores al recibido
     * se han inclumplido las metas para el cliente y concurso recibido
     */
    public Boolean validarInclumplientosAnterioresMetas(Long oidCliente,
        Long oidConcurso, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOCandidataGanadora.validarInclumplientosAnteri"
            +"oresMetas(Long oidCliente, Long oidConcurso, Long oidPeriodo)"
            +":Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" OID_CAND_GANA ");
            query.append(" FROM INC_CANDI_GANAD, ");
            query.append(" CRA_PERIO ");
            query.append(" WHERE PERD_OID_PERI = OID_PERI ");
            query.append(" AND CLIE_OID_CLIE      = " + oidCliente.longValue());
            query.append(" AND COPA_OID_PARA_GRAL = " +
                oidConcurso.longValue());
            query.append(" AND FEC_INIC <=  ");
            query.append(" (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " +
                oidPeriodo.longValue());
            query.append(" ) ");
            query.append(" AND IND_META_SUPE <> 1 ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.debug("*** retorna: FALSE");
            UtilidadesLog.info("DAOCandidataGanadora.validarInclumplientosAnte"
                +"rioresMetas(Long oidCliente, Long oidConcurso, Long "
                +"oidPeriodo):Salida");

            return new Boolean(false);
        } else {
            UtilidadesLog.debug("*** retorna: TRUE");
            UtilidadesLog.info("DAOCandidataGanadora.validarInclumplientosAnter"
                +"ioresMetas(Long oidCliente, Long oidConcurso, Long "
                +"oidPeriodo):Salida");

            return new Boolean(true);
        }
    }

    /*
     * Este metodo verifica si en el periodo recibido
     * han clumplido las metas para el cliente y concurso recibido
     */
    public Boolean validarIncumplimientoMetas(Long oidCliente,
        Long oidConcurso, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOCandidataGanadora.validarIncumplimientoMetas("
            +"Long oidCliente, Long oidConcurso, Long oidPeriodo):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" OID_CAND_GANA ");
            query.append(" FROM INC_CANDI_GANAD ");
            query.append(" WHERE CLIE_OID_CLIE    = " + oidCliente.longValue());
            query.append(" AND COPA_OID_PARA_GRAL = " + oidConcurso.longValue());
            query.append(" AND PERD_OID_PERI      = " + oidPeriodo.longValue());
            query.append(" AND IND_META_SUPE <> 1 ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.debug("*** retorna: FALSE");
            UtilidadesLog.info("DAOCandidataGanadora.validarIncumplimientoM"
                +"etas(Long oidCliente, Long oidConcurso, Long oidPeriodo):"
                +"Salida");

            return new Boolean(false);
        } else {
            UtilidadesLog.debug("*** retorna: TRUE");
            UtilidadesLog.info("DAOCandidataGanadora.validarIncumplimiento"
                +"Metas(Long oidCliente, Long oidConcurso, Long oidPeriodo):"
                +"Salida");

            return new Boolean(true);
        }
    }
    
    //jrivas BLO-001
    public void actualizaCandidataGanadoraBloqueo(ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOCandidataGanadora.actualizaCandidataGanadoraBloqueo:Entrada");
           
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" UPDATE INC_CANDI_GANAD CG ");
            query.append("    SET CG.BINC_OID_BASE_INCU = " + ConstantesINC.BASE_INCUMPLIDA_CLIENTE_BLOQUEADO);
            query.append("        , CG.PERD_OID_PERI_EVAL = " + clientePremiacion.getPeriodo().getOidPeriodo());
            query.append("  WHERE CG.OID_CAND_GANA IN ( ");
            query.append("           SELECT OID_CAND_GANA ");
            query.append("             FROM INC_CANDI_GANAD CG, INC_CONCU_PARAM_GENER CPG ");
            query.append("            WHERE CG.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            query.append("              AND CG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
            query.append("              AND CPG.IND_ACTI = 1) ");
            bs.dbService.executeUpdate(query.toString());
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }                            

        UtilidadesLog.info("DAOCandidataGanadora.actualizaCandidataGanadoraBloqueo:Salida");
    }      
    

    // sapaza -- PER-SiCC-2011-0700 -- 05/10/2011    
    private void actualizarReglaCuentaCorriente(Long oidCliente, Long oidConcurso, Long oidPeriodo, Long oidRegla, Long puntaje) throws MareException {
        UtilidadesLog.info("DAOCandidataGanadora.actualizarReglaCuentaCorriente():Entrada");
        DAOConcurso dao = new DAOConcurso();
        StringBuffer insert = new StringBuffer();
        Long oidInsertar = SecuenciadorOID.obtenerSiguienteValor("INC_CUCP_SEQ");
        Long puntajeAux = new Long(puntaje.longValue() * (-1));
        
        BelcorpService bs;
        RecordSet respuesta;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        insert.append(" INSERT INTO INC_CUENT_CORRI_PUNTO ( ");
        insert.append(" OID_CUEN_CORR_PUNT, ");
        insert.append(" NUM_MOVI, ");
        insert.append(" NUM_PUNT, ");
        insert.append(" NUM_PUNT_EXIG, ");
        insert.append(" FEC_MOVI, ");
        insert.append(" COPA_OID_PARA_GRAL, ");
        insert.append(" CLIE_OID_CLIE, ");
        insert.append(" PERD_OID_PERI, ");
        insert.append(" TMOV_OID_TIPO_MOVI, ");
        insert.append(" VAL_DESC ");
        insert.append(" ) VALUES (  ");
        insert.append(oidInsertar + ", ");//oid
        insert.append(oidInsertar + ", ");//num_movimiento
        insert.append(puntajeAux + ", ");
        insert.append("0, ");
        insert.append("TRUNC(SYSDATE), ");
        insert.append(oidConcurso + ", ");
        insert.append(oidCliente + ", ");
        insert.append(oidPeriodo + ", ");
        insert.append(ConstantesINC.TIPO_MOVIMIENTO_CARGO + ", ");
        insert.append("'BASE INCUMPLIDA - CARGO REGLA N° " + oidRegla + "'");
        insert.append(" )");
        
        if(log.isInfoEnabled()) 
            UtilidadesLog.info("Insertamos ---> "+insert.toString());
            
        try {
            bs.dbService.executeUpdate(insert.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOCandidataGanadora.actualizarReglaCuentaCorriente():Salida");
    }
    
}
