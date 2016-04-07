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
 * 
 * @author: DMorello
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 *  
 *  
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;


public class ConcursosRankingHelper {
    public ConcursosRankingHelper() {
    }

    /**
     * Este metodo retorna un objeto AmbitoGeografico con los datos de la 
     * region (oidRegion) o zona (oidZona) pasado por parametro y completa 
     * la subgerencia correspondiente a esa region o zona. Si el parametro 
     * pasado es el de zona, entonces tambien se completa la region 
     * correspondiente a esa zona.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public AmbitoGeografico completarAmbitoGeografico(Long oidRegion,
        Long oidZona) throws MareException {
        AmbitoGeografico ambitoGeografico = new AmbitoGeografico();

        if ((oidRegion == null) && (oidZona == null)) {
            ambitoGeografico = null;
        } else {
            DAOConcursosRanking dao = new DAOConcursosRanking();

            if (oidRegion != null) {
                RecordSet ambitoCompleto = 
                    dao.completarAmbitoPorRegion(oidRegion);
                BigDecimal decOidSubgerencia = (BigDecimal) 
                    ambitoCompleto.getValueAt(0, "ZSGV_OID_SUBG_VENT");
                Long oidSubgerencia = new Long(decOidSubgerencia.longValue());
                ambitoGeografico.setOidSubgerencia(oidSubgerencia);
                ambitoGeografico.setOidRegion(oidRegion);
            }

            if (oidZona != null) {
                RecordSet ambitoCompleto = dao.completarAmbitoPorZona(oidZona);
                BigDecimal decOidRegion = (BigDecimal) 
                    ambitoCompleto.getValueAt(0,"ZORG_OID_REGI");
                oidRegion = new Long(decOidRegion.longValue());

                BigDecimal decOidSubgerencia = (BigDecimal) 
                    ambitoCompleto.getValueAt(0,"ZSGV_OID_SUBG_VENT");
                    
                Long oidSubgerencia = new Long(decOidSubgerencia.longValue());
                ambitoGeografico.setOidSubgerencia(oidSubgerencia);
                ambitoGeografico.setOidRegion(oidRegion);
                ambitoGeografico.setOidZona(oidZona);
            }
        }

        return ambitoGeografico;
    }

    /**
     * Este metodo elimina todos los resultados ranking correspondientes al
     * concurso pasado por parametro (oidConcurso)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void eliminarResultadosRanking(Long oidConcurso,
        Long oidPeriodoCalculo) throws MareException {
        UtilidadesLog.info(
            "Empezo eliminarResultadosRanking con oidPeriodoCalculo: " +
            oidPeriodoCalculo + " y oidConcurso: " + oidConcurso);

        DAOBaseCalculo dao = new DAOBaseCalculo();
        DTOOIDs oidsResultadosRanking = dao.obtenerResultadosRanking(
            oidConcurso, oidPeriodoCalculo);

        UtilidadesLog.info("oidsResultadosRanking: " + oidsResultadosRanking);

        Long[] oids = oidsResultadosRanking.getOids();

        if (oids != null) {
            for (int i = 0; i < oids.length; i++) {
                dao.eliminarResultadoRanking(oids[i]);
            }
        }

        UtilidadesLog.info("Termino eliminarResultadosRanking");
    }

    /**
     * Este metodo valida que la unidad administrativa pasada por parametro 
     * (uniAdm)
     * corresponda a una de las unidades administrativas del concurso pasado
     * por parametro (oidConcurso)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Boolean validarAmbitoGeografico(Long oidConcurso,
        AmbitoGeografico ambGeo, Long oidGerente) throws MareException {
        UtilidadesLog.info("Empezo validarAmbitoGeografico con ambGeo: " +
            ambGeo + " y oidConcurso: " + oidConcurso + " oidGerente: " + oidGerente);

        boolean cumple = false;
        DAOConcursosRanking dao = new DAOConcursosRanking();
        Concurso concurso = dao.obtenerConcurso(oidConcurso);
        
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        if(oidGerente == null || concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
            cumple = concurso.cumpleAmbitoGeografico(ambGeo);
        } else {
            cumple = concurso.cumpleAmbitoGeograficoGerentes(ambGeo, oidGerente);
        }
        
        UtilidadesLog.info("Termino validarAmbitoGeografico retorna: " + cumple);

        return new Boolean(cumple);
    }

    /**
     * Descripcion: retorna un numero indicador del tipo de Unidad 
     * Administrativa Gerenciada que es distinto de null
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   01/07/2005
     * @version 1.00
     * @autor   Sergio Saavedra
     */
    public Integer obtenerTipoUnidadesAdministrativas(
        UnidadesAdministrativasGerenciadas obje) throws MareException {
        Integer resu = null;

        if (obje.getSubGerencias() != null) {
            resu = ConstantesUnidadAdministrativa.SUBGERENCIA;
        }

        if (obje.getRegiones() != null) {
            resu = ConstantesUnidadAdministrativa.REGION;
        }

        if (obje.getZonas() != null) {
            resu = ConstantesUnidadAdministrativa.ZONA;
        }

        if (obje.getSecciones() != null) {
            resu = ConstantesUnidadAdministrativa.SECCION;
        }

        return resu;
    }

    /**
     * Descripcion: este metodo retorna un objeto DatosCliente con sus
     * datos recuperados.
     * 
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   07/07/2005
     * @version 1.00
     * @autor   Sergio Saavedra
     */
    public DatosConsultora obtenerDatosConsultora(Long oidCliente)
        throws MareException {
        DatosConsultora datosConsultora = new DatosConsultora();

        datosConsultora.setOidConsultora(oidCliente);

        DAOConcursosRanking daoCR = new DAOConcursosRanking();
        datosConsultora.setPeriodoPrimerContacto(
            daoCR.obtenerPrimerContactoCliente(oidCliente));

        datosConsultora.setPeriodosConPedidos(
            daoCR.obtenerPeriodosConPedidosCliente(oidCliente));

        return datosConsultora;
    }
}
