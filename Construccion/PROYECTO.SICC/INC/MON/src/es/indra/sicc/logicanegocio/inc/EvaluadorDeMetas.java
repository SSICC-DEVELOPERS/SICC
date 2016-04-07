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
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.inc.DTOGerenteConcurso;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class EvaluadorDeMetas {
    public EvaluadorDeMetas() {
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: Valida si se han alcanzado las metas para los concursos con base de cálculo "Monto" y "Unidades". Si es asi se insertan en candidata ganadora.
    */
    public void evaluarMetasParaUnPeriodo(Periodo periodo)
            throws MareException {
        UtilidadesLog.info("EvaluadorDeMetas.evaluarMetasParaUnPeriodo(Periodo periodo):Entrada");

        //Inc BELC300020396 
        //BELC300020414 
        ArrayList concursos = recuperarConcursos(periodo);
        DAOMetas daoMetas = new DAOMetas();
        ArrayList dtosGerenteConcurso = daoMetas.recuperarClientesConcursos(concursos, periodo);
        DTOGerenteConcurso dtoGerenteConcurso = new DTOGerenteConcurso();
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        Concurso concurso;
        CandidataGanadoraLocal candidataGanadoraLocal = null;
        Boolean metasSuperadas = null;

        for (int i = 0; i < dtosGerenteConcurso.size(); i++) {
            concurso = null;

            try {
                dtoGerenteConcurso = (DTOGerenteConcurso) dtosGerenteConcurso.get(i);

                Long oidConcurso = dtoGerenteConcurso.getOidConcurso();

                for (int j = 0; (concursos != null) && (j < concursos.size()); j++) {
                    Concurso conc = (Concurso) concursos.get(j);

                    if (conc.getOidConcurso().equals(oidConcurso)) {
                        concurso = conc;

                        break;
                    }
                }

                if (concurso.getFaseCalificacion()) {
                    metasSuperadas = new Boolean(true);
                } else {
                    metasSuperadas = new Boolean(false);
                }

                if (isMetasSuperadas(dtoGerenteConcurso.getOidGerente(), concurso)) {
                    CandidataGanadoraLocal candidataGanadora;
                    // Se hace un create en la entidad CandidataGanadora 
                    UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + concurso.getOidConcurso());
                    UtilidadesLog.debug("CLIE_OID_CLIE:  " + dtoGerenteConcurso.getOidGerente());
                    UtilidadesLog.debug("periodo.getOidPeriodo():  " + periodo.getOidPeriodo()); 
                    
                    try {
                        candidataGanadora = this.getCandidataGanadoraLocalHome().findByUK(concurso.getOidConcurso(), dtoGerenteConcurso.getOidGerente(),
                                                                                                periodo.getOidPeriodo());
                        UtilidadesLog.debug("Candidata a ganadora: la encontre gg ");
                        candidataGanadora.setMetasSuperadas(metasSuperadas);
                        this.getCandidataGanadoraLocalHome().merge(candidataGanadora);
                        
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("Candidata a ganadora: no la encontre gg ");                        
                        UtilidadesLog.debug(fe);
                        
                        UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + new Boolean(false));
                        UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + concurso.getOidConcurso());
                        UtilidadesLog.debug("CLIE_OID_CLIE:  " + dtoGerenteConcurso.getOidGerente());
                        UtilidadesLog.debug("periodo.getOidPeriodo():  " + periodo.getOidPeriodo()); 
                        
                        candidataGanadoraLocal = this.getCandidataGanadoraLocalHome().create(metasSuperadas, new Boolean(false),
                                                                                                   periodo.getOidPeriodo(),
                                                                                                   concurso.getOidConcurso(),
                                                                                                   dtoGerenteConcurso.getOidGerente());
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }

                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (MareException me) {
                UtilidadesLog.error("ERROR ", me);
                throw new MareException(me);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e);
            }
        }
        UtilidadesLog.info("EvaluadorDeMetas.evaluarMetasParaUnPeriodo(Periodo periodo):Salida");
    }


    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    * Inc BELC300020396
    */
    private ArrayList recuperarConcursos(Periodo periodo)
            throws MareException {
        return FactoriaConcurso.getFactoriaConcurso().getConcursosMontoUnidades(periodo);
    }

    /**
    * Fecha de Creacion: 08/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    */
    private boolean isMetasSuperadas(Long oidCliente, Concurso concurso)
            throws MareException {
        UtilidadesLog.info("EvaluadorDeMetas.isMetasSuperadas(Long oidCliente, Concurso concurso):Entrada");

        DAOMetas daoMetas = new DAOMetas();
        Float puntosMeta = daoMetas.recuperarMetas(concurso, oidCliente);
        Float puntosCliente = daoMetas.obtenerSaldoPuntos(oidCliente, concurso.getOidConcurso());
        int restaPuntos = puntosMeta.intValue() - puntosCliente.intValue();

        if (restaPuntos <= 0) {
            UtilidadesLog.debug("****isMetasSuperadas: TRUE");
            UtilidadesLog.info("EvaluadorDeMetas.isMetasSuperadas(Long oidCliente, Concurso concurso):Salida");

            return true;
        } else {
            UtilidadesLog.debug("****isMetasSuperadas: FALSE");
            UtilidadesLog.info("EvaluadorDeMetas.isMetasSuperadas(Long oidCliente, Concurso concurso):Salida");

            return false;
        }
    }
    
    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    
}
