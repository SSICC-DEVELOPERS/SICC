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
 * Autor : Igor Dedough
 */
 
package es.indra.sicc.dtos.inc;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOCabeceraPremElegidos extends DTOBelcorp  {
    private Long oidConcurso;
    private Long oidCliente;
    private Double saldoCliente;
    private RecordSet rsDetallePremiosElectivos;
    private ArrayList premiosElegidos;
        
    public DTOCabeceraPremElegidos() { }
    
    public void setPremiosElegidos(ArrayList newPremiosElegidos) {
      this.premiosElegidos = newPremiosElegidos;
    }
    
    public ArrayList getPremiosElegidos() {
      return this.premiosElegidos;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setSaldoCliente(Double saldoCliente) {
        this.saldoCliente = saldoCliente;
    }

    public Double getSaldoCliente() {
        return saldoCliente;
    }

    public void setRsDetallePremiosElectivos(RecordSet rsDetallePremiosElectivos) {
        this.rsDetallePremiosElectivos = rsDetallePremiosElectivos;
    }

    public RecordSet getRsDetallePremiosElectivos() {
        return rsDetallePremiosElectivos;
    }
}