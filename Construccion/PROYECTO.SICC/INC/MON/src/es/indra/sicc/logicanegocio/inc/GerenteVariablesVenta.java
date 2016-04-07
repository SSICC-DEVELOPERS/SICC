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

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class GerenteVariablesVenta implements Serializable {
    private Long oidGerente;
    private UnidadesAdministrativasGerenciadas unidadesGerenciadas;
    private ResultadoVariablesVenta resultadosVariables;
    // vbongiov -- 6/04/2006 - inc 22684
    private boolean procesado;
    
    public GerenteVariablesVenta() {
      procesado = false;
    }

    public Long getOidGerente() {
        return oidGerente;
    }

    public void setOidGerente(Long oidGerente) {
        this.oidGerente = oidGerente;
    }

    public UnidadesAdministrativasGerenciadas getUnidadesGerenciadas() {
        return unidadesGerenciadas;
    }

    public void setUnidadesGerenciadas(UnidadesAdministrativasGerenciadas unidadesGerenciadas) {
        this.unidadesGerenciadas = unidadesGerenciadas;
    }

    public void setResultadosVariables(ResultadoVariablesVenta resultadosVariables) {
        this.resultadosVariables = resultadosVariables;
    }

    public ResultadoVariablesVenta getResultadosVariables() {
        return resultadosVariables;
    }

    /**
    * @return
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripcion: este método calcula los resultados de variables de venta que dependen
    * solamente del gerente para el periodo recibido por parametro.
    */
    public void calcularResultadosVariables(Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("GerenteVariablesVenta.calcularResultadosVariables(Periodo periodoCierre):Entrada");

        ResultadoVariablesVenta resVarVta = new ResultadoVariablesVenta();
        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        DAOCalculoVariablesVenta dao = new DAOCalculoVariablesVenta();
        HashMap map = new HashMap();
        Collection MapCollectionValues;
        Iterator it;
        int nroClientes = 0;
        Integer estNueva = null;
        Integer estReingresada = null;
        Integer estEgresada = null;

        resVarVta.setActivasIniciales(variablesVentaHelper.obtenerActivasIniciales(this, periodoCierre));
        map = dao.recuperarIngresosReingresosEgresos(this, periodoCierre);
        
        estNueva = (Integer) map.get(ConstantesMAE.OID_ESTATUS_NUEVA);
        UtilidadesLog.debug("estNueva: " + estNueva);
        resVarVta.setIngresos(estNueva!=null?estNueva:Integer.valueOf("0"));
        
        estReingresada = (Integer) map.get(ConstantesMAE.OID_ESTATUS_REINGRESADA);
        UtilidadesLog.debug("estReingresada: " + estReingresada);
        resVarVta.setReingresos(estReingresada!=null?estReingresada:Integer.valueOf("0"));
        
        estEgresada = (Integer) map.get(ConstantesMAE.OID_ESTATUS_EGRESADA);
        UtilidadesLog.debug("estEgresada: " + estEgresada);
        resVarVta.setEgresos(estEgresada!=null?estEgresada:Integer.valueOf("0"));

        MapCollectionValues = map.values();
        it = MapCollectionValues.iterator();

        for (int i = 0; it.hasNext(); i++) {
            nroClientes += ((Integer) it.next()).longValue();
        }

        resVarVta.setNumeroClientes(new Integer(nroClientes));
        resVarVta.setEntregadas(variablesVentaHelper.obtenerEntregadas(this, periodoCierre));
        resVarVta.setRecibidas(dao.recuperarRecibidas(this, periodoCierre));
        resVarVta.setActivasFinales(variablesVentaHelper.obtenerActivasFinales(this, periodoCierre));

        resVarVta.setCapitalizacion(variablesVentaHelper.obtenerCapitalizacion(resVarVta));

        resVarVta.setPorcentajeRetencion(variablesVentaHelper.obtenerRetencion(this, periodoCierre));
        resVarVta.setNumeroOrdenes(variablesVentaHelper.obtenerNumeroSolicitudes(this, periodoCierre));

        resultadosVariables = resVarVta; //Inc 19710

        resVarVta.setRotacion(variablesVentaHelper.obtenerRotacion(this));

        UtilidadesLog.debug("***Rotacion: " + resVarVta.getRotacion());

        resultadosVariables = resVarVta;
        UtilidadesLog.debug("resultadosVariables: " + resultadosVariables);

        UtilidadesLog.info("GerenteVariablesVenta.calcularResultadosVariables(Periodo periodoCierre):Salida");
    }

  
  public boolean getProcesado()
  {
    return procesado;
  }

  public void setProcesado(boolean procesado)
  {
    this.procesado = procesado;
  }
}
