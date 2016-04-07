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
 * @author Dante Castiglione
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005  
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList; // JVM - sicc 20070237, ArrayList


public class Cliente extends Participante implements Serializable{
    //private Long                      oidCliente;
    //private String                    nombre;
    //private TipificacionCliente[]     tipificacionCliente;
    private HistoricoEstatusCliente[] historicoEstatusCliente;
    private Long oidEstatus;
    private Long oidEstatusFuturo;
    private Periodo periodoPrimerContacto;
    private HashMap periodosConPedidos;
    private ClienteRecomendante clienteRecomendante;
    private ClienteRecomendante clienteRecomendador;         // JVM - sicc 20070381, clienteRecomendador
    private boolean indRecomendante;
    private ArrayList clienteRecomendado = new ArrayList();  // JVM - sicc 20070237, clienteRecomendado
    private boolean indRecomendadosEnMAE=false;              // JVM - sicc 20070237, indRecomendadosEnMAE
    private boolean indRecomendadosEnINC=false;              // JVM - sicc 20070237, indRecomendadosEnINC
    private Periodo periodo;                                 // JVM - sicc 20070381, periodo
    
    //jrivas DBLG5000839 30/8/2006
    private boolean indRecomendado;
  
    //jrivas SICC20070287 06/06/2007
    private DatosPersonales datosPersonales;

    //private AmbitoGeografico          ambitoGeografico;
    public Cliente() {
    }

    public Boolean pasoPedidos(Long oidPeriodo) {
        return new Boolean(this.periodosConPedidos.containsKey(oidPeriodo));
    }

    public HistoricoEstatusCliente[] getHistoricoEstatusCliente() {    
        return historicoEstatusCliente;
    }

    public void setHistoricoEstatusCliente(
        HistoricoEstatusCliente[] historicoEstatusCliente) {
        this.historicoEstatusCliente = historicoEstatusCliente;
    }

    public Long getOidEstatus() {
        return oidEstatus;
    }

    public void setOidEstatus(Long oidEstatus) {
        this.oidEstatus = oidEstatus;
    }

    public Long getOidEstatusFuturo() {
        return oidEstatusFuturo;
    }

    public void setOidEstatusFuturo(Long oidEstatusFuturo) {
        this.oidEstatusFuturo = oidEstatusFuturo;
    }

    public Periodo getPeriodoPrimerContacto() {
        return periodoPrimerContacto;
    }

    public void setPeriodoPrimerContacto(Periodo periodoPrimerContacto) {
        this.periodoPrimerContacto = periodoPrimerContacto;
    }

    public HashMap getPeriodosConPedidos() {
        return periodosConPedidos;
    }

    public void setPeriodosConPedidos(HashMap periodosConPedidos) {
        this.periodosConPedidos = periodosConPedidos;
    }

    public ClienteRecomendante getClienteRecomendante() {
        return clienteRecomendante;
    }

    public void setClienteRecomendante(ClienteRecomendante clienteRecomendante) {
        this.clienteRecomendante = clienteRecomendante;
    }



    public boolean getIndRecomendante()
    {
    return indRecomendante;
    }
    
    public void setIndRecomendado(boolean indRecomendado)
    {
    this.indRecomendado = indRecomendado;
    }
    
    public boolean getIndRecomendado()
    {
    return indRecomendado;
    }
    
    public void setIndRecomendante(boolean indRecomendante)
    {
    this.indRecomendante = indRecomendante;
    }

  
    /**
    * Agregado por dmorello, 19/01/2006
    */
    public String toString() {
    
        StringBuffer sb = new StringBuffer();
        
        sb.append("Cliente:");
        
        sb.append("\nhistoricoEstatusCliente:"
            + this.getHistoricoEstatusCliente());
        sb.append("\noidEstatus:"
            + this.getOidEstatus());
        sb.append("\noidEstatusFuturo:"
            + this.getOidEstatusFuturo());
        sb.append("\nperiodoPrimerContacto:"
            + this.getPeriodoPrimerContacto());
        sb.append("\nperiodosConPedidos:"
            + this.getPeriodosConPedidos());
        sb.append("\nclienteRecomendante:"
            + this.getClienteRecomendante());
        sb.append("\nindRecomendante:"
            + this.getIndRecomendante());
            
        return sb.toString();
    }

    public DatosPersonales getDatosPersonales()
    {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales)
    {
        this.datosPersonales = datosPersonales;
    }
  
    /*
    * JVM - sicc 2007, se agrega el metodo getClienteRecomendado
    */
    public ArrayList getClienteRecomendado() {      
      return clienteRecomendado;
    }
    
    /*
    * JVM - sicc 2007, se agrega el metodo setClienteRecomendado
    */
    public void setClienteRecomendado(ArrayList clienteRecomendado) {
      if (clienteRecomendado != null) {
          this.clienteRecomendado = clienteRecomendado;
      }
    }  

  /*
   * JVM - sicc 2007, se agrega el metodo setClienteRecomendado
   */
    public void setIndRecomendadosEnMAE(boolean indRecomendadosEnMAE) {
        this.indRecomendadosEnMAE = indRecomendadosEnMAE;
    }

    /*
    * JVM - sicc 2007, se agrega el metodo setClienteRecomendado
    */
    public boolean getIndRecomendadosEnMAE() {
        return indRecomendadosEnMAE;
    }

    /*
    * JVM - sicc 2007, se agrega el metodo setClienteRecomendado
    */
    public void setIndRecomendadosEnINC(boolean indRecomendadosEnINC) {
        this.indRecomendadosEnINC = indRecomendadosEnINC;
    }
    
    /*
    * JVM - sicc 2007, se agrega el metodo setClienteRecomendado
    */
    public boolean getIndRecomendadosEnINC() {
        return indRecomendadosEnINC;
    }
    
    /*
     * JVM, sicc 20070381, setClienteRecomendador
     */
    public void setClienteRecomendador(ClienteRecomendante clienteRecomendador) {
        this.clienteRecomendador = clienteRecomendador;
    }

    /*
     * JVM, sicc 20070381, getClienteRecomendador
     */
    public ClienteRecomendante getClienteRecomendador() {
        return clienteRecomendador;
    }

    /*
     * JVM, sicc 20070381, getClienteRecomendador
     */
    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    /*
     * JVM, sicc 20070381, getClienteRecomendador
     */
    public Periodo getPeriodo() {
        return periodo;
    }

}
