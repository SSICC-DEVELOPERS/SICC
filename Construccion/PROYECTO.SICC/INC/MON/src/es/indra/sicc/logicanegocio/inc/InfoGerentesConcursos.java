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
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class InfoGerentesConcursos implements Serializable {
    private HashMap concursos; //Inci 19164
    private ArrayList gerentes;
    private Periodo periodoCierre;

    public InfoGerentesConcursos(DTOFACProcesoCierre dtoe)
            throws MareException {
        UtilidadesLog.info("InfoGerentesConcursos.InfoGerentesConcursos(DTOFACProcesoCierre dtoe):Entrada");
        

        DTOETramitarCierre dtoTram = new DTOETramitarCierre();
        DAOClientePremiacion dAOClientePremiacion = new DAOClientePremiacion();
        DAOCargaVariablesVenta dAOCargaVariablesVenta = new DAOCargaVariablesVenta();

        dtoTram.setOidCanal(dtoe.getCanal());
        dtoTram.setOidMarca(dtoe.getMarca());
        dtoTram.setOidPeriodo(dtoe.getPeriodo());
        dtoTram.setOidZona(dtoe.getZona());
        dtoTram.setOidIdioma(dtoe.getOidIdioma());
        dtoTram.setOidPais(dtoe.getOidPais());

        periodoCierre = dAOClientePremiacion.obtenerPeriodo(dtoTram);
        concursos = dAOCargaVariablesVenta.recuperarConcursosVariablesVenta(periodoCierre);
        gerentes = new ArrayList();

        UtilidadesLog.info("InfoGerentesConcursos.InfoGerentesConcursos(DTOFACProcesoCierre dtoe):Salida");
    }

    public void setConcursos(HashMap concursos) {
        this.concursos = concursos;
    }

    public HashMap getConcursos() {
        return concursos;
    }

    public void setGerentes(ArrayList gerentes) {
        this.gerentes = gerentes;
    }

    public ArrayList getGerentes() {
        return gerentes;
    }

    public void setPeriodoCierre(Periodo periodoCierre) {
        this.periodoCierre = periodoCierre;
    }

    public Periodo getPeriodoCierre() {
        return periodoCierre;
    }

    /**
    * @return GerenteVariablesVenta
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    */
    public GerenteVariablesVenta getGerente(Long oidGerente)
            throws MareException {
        UtilidadesLog.info("InfoGerentesConcursos.getGerente(Long oidGerente):Entrada");

        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        GerenteVariablesVenta gerVarVta;

        int size = gerentes.size();

        for (int i = 0; i < size; i++) {
            GerenteVariablesVenta gerenteVariablesVenta = (GerenteVariablesVenta) gerentes.get(i);

            if (oidGerente.equals(gerenteVariablesVenta.getOidGerente())) {
                UtilidadesLog.debug("lo tiene cargado");
                UtilidadesLog.info("InfoGerentesConcursos.getGerente(Long oidGerente):Salida");

                return gerenteVariablesVenta;
            }
        }
        
        UtilidadesLog.debug("Va a buscarlo");
        gerVarVta = variablesVentaHelper.recuperarGerente(oidGerente, periodoCierre);
        gerentes.add(gerVarVta);
        UtilidadesLog.info("InfoGerentesConcursos.getGerente(Long oidGerente):Salida");

        return gerVarVta;
    }

    /**
    * @return boolean
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    * Descripcion: verifica si el ambito recibido por parametro corresponde a alguno del concurso recibido por parametro.
    * Modificado: vbongiov -- 6/04/2006 - inc 22684
    */
    public boolean cumpleAmbitoGeografico(Long oidConcurso, AmbitoGeografico ambGeo, Long oidGerente) {
        UtilidadesLog.info("InfoGerentesConcursos.cumpleAmbitoGeografico(Long oidConcurso, AmbitoGeografico ambGeo):Entrada");

        ConcursoVariablesVenta concVarVta = (ConcursoVariablesVenta) getConcurso(oidConcurso);
        ArrayList ambitosGeo = concVarVta.getAmbitosGerograficos();

        int size = ambitosGeo.size();

        for (int i = 0; i < size; i++) {
            if (((AmbitoGeografico) ambitosGeo.get(i)).equalsAmbitoGerente(ambGeo, oidGerente)) {
                UtilidadesLog.info("InfoGerentesConcursos.cumpleAmbitoGeografico(Long oidConcurso, AmbitoGeografico ambGeo):Salida");

                return true;
            }
        }

        UtilidadesLog.info("InfoGerentesConcursos.cumpleAmbitoGeografico(Long oidConcurso, AmbitoGeografico ambGeo):Salida");

        return false;
    }

    /**
    * @return ConcursoVariablesVenta
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    * Descripcion: retorna el objeto concurso de acuerdo al oidConcurso recibido por parametro.
    * Modificado: Carlos Leal segun Inc 19164
    */
    public ConcursoVariablesVenta getConcurso(Long oidConcurso) {
        UtilidadesLog.info("InfoGerentesConcursos.getConcurso(Long oidConcurso):Entrada");
        UtilidadesLog.debug("oidConcurso: " + oidConcurso);

        ConcursoVariablesVenta concursoVariablesVenta = null;

        int size = concursos.size();

        for (int i = 0; i < size; i++) {
            ConcursoVariablesVenta conc = (ConcursoVariablesVenta) concursos.get(oidConcurso);
            UtilidadesLog.debug("conc.getOidConcurso(): " + conc.getOidConcurso());

            if (oidConcurso.equals(conc.getOidConcurso())) {
                UtilidadesLog.debug("****Salio InfoGerentesConcursos.getConcurso****");
                concursoVariablesVenta = conc;
            }
        }
        UtilidadesLog.info("InfoGerentesConcursos.getConcurso(Long oidConcurso):Salida");
        return concursoVariablesVenta;
    }

    /**
    * @return ConcursoVariablesVenta
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    * Descripcion: verifica si el periodoCierre esta contenido en los periodos de control del concurso recibido por parametro.
    */
    public boolean contenidoEnPeriodoControl(Long oidConcurso) {
        UtilidadesLog.info("InfoGerentesConcursos.contenidoEnPeriodoControl(Long oidConcurso):Entrada");

        ConcursoVariablesVenta concVarVta = new ConcursoVariablesVenta();

        concVarVta = getConcurso(oidConcurso);

        ArrayList concVarVtaArrayList = concVarVta.getPeriodosControl();
        UtilidadesLog.debug("concVarVta.getPeriodosControl(): " + concVarVtaArrayList);
        int size = concVarVtaArrayList.size();

        for (int i = 0; i < size; i++) {
            if (periodoCierre.equals((Periodo) concVarVtaArrayList.get(i))) {
                UtilidadesLog.info("InfoGerentesConcursos.contenidoEnPeriodoControl(Long oidConcurso):Salida TRUE");
                return true;
            }
        }

        UtilidadesLog.info("InfoGerentesConcursos.contenidoEnPeriodoControl(Long oidConcurso):Salida FALSE");

        return false;
    }
}
