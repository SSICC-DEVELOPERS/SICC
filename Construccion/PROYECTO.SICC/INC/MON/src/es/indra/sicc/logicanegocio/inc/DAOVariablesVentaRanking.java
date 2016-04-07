/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 *
 * @autor       Diego Morello
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.inc.DTOVentaRankingGerente;
import es.indra.sicc.entidades.inc.VentasRankingGerentesLocal;
import es.indra.sicc.entidades.inc.VentasRankingGerentesLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOVariablesVentaRanking {
    public DAOVariablesVentaRanking() {
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      modulo eje: INC
         * Fecha:       22/06/05
         * @version     1.00
         * @autor       Diego Morello
         */
    public HashMap recuperarVariablesVentaRankingConcurso(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarVariablesVenta"
            +"RankingConcurso(Long oidConcurso):Entrada");
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { oidConcurso };
        dtoOids.setOids(oids);

        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarVariablesVenta"
            +"RankingConcurso(Long oidConcurso):Salida");
        return concurso.getVariablesVentaConcursoRanking();
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      modulo eje: INC
         * Fecha:       22/06/05
         * @version     1.00
         * @autor       Diego Morello
         */
    public Periodo recuperarPeriodoDesde(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodoDesde("
            +"Long oidConcurso):Entrada");
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { oidConcurso };
        dtoOids.setOids(oids);

        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodoDesde("
            +"Long oidConcurso):Salida");
        return concurso.getPeriodoDesde();
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      modulo eje: INC
         * Fecha:       22/06/05
         * @version     1.00
         * @autor       Diego Morello
         */
    public Periodo recuperarPeriodoHasta(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodoHasta("
            +"Long oidConcurso):Entrada");
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { oidConcurso };
        dtoOids.setOids(oids);

        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodoHasta("
            +"Long oidConcurso):Salida");
        return concurso.getPeriodoHasta();
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      modulo eje: INC
         * Fecha:       22/06/05
         * @version     1.00
         * @autor       Diego Morello
         */
    public void recuperarIndicadoresConcurso(
        GerenteConcursoVariablesVentaRanking gerConc) throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarIndicadoresCon"
            +"curso(GerenteConcursoVariablesVentaRanking gerConc):Entrada");
        Long oidConcurso = gerConc.getConcurso();
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { oidConcurso };
        dtoOids.setOids(oids);

        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        gerConc.setIndProductosExigidos(concurso.getIndProductosExigidos());
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarIndicadoresCon"
            +"curso(GerenteConcursoVariablesVentaRanking gerConc):Salida");
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      modulo eje: INC
         * Fecha:       29/06/05
         * @version     1.00
         * @autor       Sergio Saavedra
    * Descripion:  Recupera la cantidad de periodos del concurso pasado por 
    *   parametro
         */
    public ArrayList recuperarPeriodosConcurso(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodosConcurso"
            +"(Long oidConcurso):Entrada");
        FactoriaConcurso fc = FactoriaConcurso.getFactoriaConcurso();

        DTOOIDs para = new DTOOIDs();
        Long[] vect = { oidConcurso };
        para.setOids(vect);

        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursosPorOID(para);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarPeriodosConcurso"
            +"(Long oidConcurso):Salida");
        return concurso.getCronograma();
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   06/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void grabarVentaRankingGerente(DTOVentaRankingGerente dtoE)
            throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.grabarVentaRankingGerente"
            +"(DTOVentaRankingGerente dtoE):Entrada");
        VentasRankingGerentesLocalHome home = this.getVentasRankingGerentesLocalHome();
        VentasRankingGerentesLocal vtaRankGerentes = null;

        // Intento acceder al entity
        try {
            vtaRankGerentes = home.findByUK(dtoE.getOidZona(), 
                                        dtoE.getConcurso(), dtoE.getOidSeccion(), 
                                            dtoE.getOidSubgerencia(), dtoE.getGerente(), 
                                            dtoE.getOidRegion());
        } catch (NoResultException e) {
            // Si no existe, lo creo
            try {
                vtaRankGerentes = home.create(dtoE.getOidZona(), 
                            dtoE.getConcurso(), dtoE.getOidSeccion(), 
                            dtoE.getOidSubgerencia(),dtoE.getGerente(), 
                            dtoE.getOidRegion());
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                int error = UtilidadesError.armarCodigoError(CodigosError
                    .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
                throw new MareException(ce, error);
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        // Preparo la información para asignar al entity (paso al formato 
        //numérico esperado)
        Double importeVentas = bigToDouble(dtoE.getImporteVentas());
        Long activasFinales = bigToLong(dtoE.getActivasFinales());
        Double numeroPedidos = bigToDouble(dtoE.getNumeroPedidos());
        Double porcentajeActividad = bigToDouble(dtoE.getPorcentajeActividad());
        Double constancia = bigToDouble(dtoE.getConstancia());
        Double ingresos = bigToDouble(dtoE.getIngresos());
        Double reingresos = bigToDouble(dtoE.getReingresos());
        Double egresos = bigToDouble(dtoE.getEgresos());
        Double entregadas = bigToDouble(dtoE.getEntregadas());
        Double recibidas = bigToDouble(dtoE.getRecibidas());
        Double capitalizacion = bigToDouble(dtoE.getCapitalizacion());
        Double ppu = bigToDouble(dtoE.getPpu());
        Double pvp = bigToDouble(dtoE.getPvp());
        Double pup = bigToDouble(dtoE.getPup());
        Double pop = bigToDouble(dtoE.getPop());
        Double retencion = bigToDouble(dtoE.getRetencion());
        Double cobranza = bigToDouble(dtoE.getCobranza());
        Double rotacion = bigToDouble(dtoE.getRotacion());

        // Asigno la informacion al entity
        vtaRankGerentes.setImporteVentas(importeVentas);
        vtaRankGerentes.setUnidades(dtoE.getUnidades());
        vtaRankGerentes.setActivasIniciales(dtoE.getActivasIniciales());
        vtaRankGerentes.setActivasFinales(activasFinales);
        vtaRankGerentes.setNumeroPedidos(numeroPedidos);
        vtaRankGerentes.setPorcentajeActividad(porcentajeActividad);
        vtaRankGerentes.setConstancia(constancia);
        vtaRankGerentes.setIngresos(ingresos);
        vtaRankGerentes.setReingresos(reingresos);
        vtaRankGerentes.setEgresos(egresos);
        vtaRankGerentes.setEntregadas(entregadas);
        vtaRankGerentes.setRecibidas(recibidas);
        vtaRankGerentes.setCapitalizacion(capitalizacion);
        vtaRankGerentes.setPpu(ppu);
        vtaRankGerentes.setPvp(pvp);
        vtaRankGerentes.setPup(pup);
        vtaRankGerentes.setPop(pop);
        vtaRankGerentes.setRetencion(retencion);
        vtaRankGerentes.setCobranza(cobranza);
        vtaRankGerentes.setRotacion(rotacion);
        home.merge(vtaRankGerentes);
        UtilidadesLog.info("DAOVariablesVentaRanking.grabarVentaRankingGerente"
            +"(DTOVentaRankingGerente dtoE):Salida");
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   12/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Long recuperarDiasGracia(Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarDiasGracia(Long "
            +"oidConcurso):Entrada");
        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { oidConcurso };
        dtoOids.setOids(oids);

        ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOVariablesVentaRanking.recuperarDiasGracia(Long"
            +"oidConcurso):Salida");
        return concurso.getDiasGracia();
    }
    

   private Double bigToDouble(BigDecimal numero) {
        if (numero != null) {
            return new Double(numero.doubleValue());
        } else {
            return null;
        }
   }
   
   private Long bigToLong(Integer numero) {
        if (numero != null) {
            return new Long(numero.longValue());
        } else {
            return null;
        }
   }
   
    private VentasRankingGerentesLocalHome getVentasRankingGerentesLocalHome() {
            return new VentasRankingGerentesLocalHome();
    }


}
