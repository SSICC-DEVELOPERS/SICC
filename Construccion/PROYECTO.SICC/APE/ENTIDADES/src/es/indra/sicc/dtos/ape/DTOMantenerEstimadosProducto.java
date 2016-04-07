/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Collection;

public class DTOMantenerEstimadosProducto extends DTOSiccPaginacion{
	private Long oidEstimado;
	private Long oidCanal;
	private Long oidCentroDistribucion;
	private Long oidLineaArmado;
	private Long oidProducto;
    private Long oidMarca;
	private Long oidPeriodo;
	private Long oidProcedencia;
	private Long unidadesEstimadas;  
	private String codigoProducto;  
	private Boolean fueraPedido;
    private Long oidLineaArmadoMAV;
    private Boolean mantenerEstimadosManuales;
    private Collection estimadosAEliminar;
    private Boolean sobreEscribir;
    private String desProducto;
  
    public DTOMantenerEstimadosProducto() {
        super();
    }
    
    public Boolean getSobreEscribir() {
        return this.sobreEscribir;
    }
    
    public void setSobreEscribir(Boolean sobreEscribir) {
        this.sobreEscribir = sobreEscribir;
    }
    
    public Long getOidLineaArmadoMAV() {
        return this.oidLineaArmadoMAV;
    }
    
    public void setOidLineaArmadoMAV(Long oidLineaArmadoMAV) {
        this.oidLineaArmadoMAV = oidLineaArmadoMAV;
    }
    
    public Boolean getMantenerEstimadosManuales() {
        return this.mantenerEstimadosManuales;
    }
    
    public void setMantenerEstimadosManuales(Boolean mantenerEstimadosManuales) {
        this.mantenerEstimadosManuales = mantenerEstimadosManuales;
    }
    
    public Collection getEstimadosAEliminar() {
        return this.estimadosAEliminar;
    }
    
    public void setEstimadosAEliminar(Collection estimadosAEliminar) {
        this.estimadosAEliminar = estimadosAEliminar;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidEstimado() {
        return oidEstimado;
    }

    public void setOidEstimado(Long oidEstimado) {
        this.oidEstimado = oidEstimado;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCentroDistribucion() {
        return oidCentroDistribucion;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidLineaArmado() {
        return oidLineaArmado;
    }

    public void setOidLineaArmado(Long oidLineaArmado) {
        this.oidLineaArmado = oidLineaArmado;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidProcedencia() {
        return oidProcedencia;
    }

    public void setOidProcedencia(Long oidProcedencia) {
        this.oidProcedencia = oidProcedencia;
    }

    public Long getUnidadesEstimadas() {
        return unidadesEstimadas;
    }

    public void setUnidadesEstimadas(Long unidadesEstimadas) {
        this.unidadesEstimadas = unidadesEstimadas;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
	
    public Boolean getFueraPedido() {
        return fueraPedido;
    }

    public void setFueraPedido(Boolean fueraPedido) {
        this.fueraPedido = fueraPedido;
    }
    
    //Agregado por cambio 20090839
    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }
}
