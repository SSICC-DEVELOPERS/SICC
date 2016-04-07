/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOEmpleAdam extends DTOBelcorp{

    private Long oidCliente;
    private String codCliente;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String codPlanilla;
    private Long oidTipoCliente;
    private String descripcionTipoCliente;
    private Long oidSubTipoCliente;
    private String descripcionSubTipoCliente;
    private BigDecimal importePendiente;
    private BigDecimal lineaCreditoConcedida;
    private BigDecimal LineaCreditoDisponible;
    private BigDecimal importeDeudaCalculado;
    private BigDecimal importeDeudaEnviarAdam;
    private BigDecimal importeDeudaDescontar;


    public void setOidCliente(Long oidCliente){
        this.oidCliente = oidCliente;
    }


    public Long getOidCliente(){
        return oidCliente;
    }


    public void setCodCliente(String codCliente){
        this.codCliente = codCliente;
    }


    public String getCodCliente(){
        return codCliente;
    }


    public void setNombre1(String nombre1){
        this.nombre1 = nombre1;
    }


    public String getNombre1(){
        return nombre1;
    }


    public void setNombre2(String nombre2){
        this.nombre2 = nombre2;
    }


    public String getNombre2(){
        return nombre2;
    }


    public void setApellido1(String apellido1){
        this.apellido1 = apellido1;
    }


    public String getApellido1(){
        return apellido1;
    }


    public void setApellido2(String apellido2){
        this.apellido2 = apellido2;
    }


    public String getApellido2(){
        return apellido2;
    }


    public void setCodPlanilla(String codPlanilla){
        this.codPlanilla = codPlanilla;
    }


    public String getCodPlanilla(){
        return codPlanilla;
    }


    public void setOidTipoCliente(Long oidTipoCliente){
        this.oidTipoCliente = oidTipoCliente;
    }


    public Long getOidTipoCliente(){
        return oidTipoCliente;
    }


    public void setDescripcionTipoCliente(String descripcionTipoCliente){
        this.descripcionTipoCliente = descripcionTipoCliente;
    }


    public String getDescripcionTipoCliente(){
        return descripcionTipoCliente;
    }


    public void setOidSubTipoCliente(Long oidSubTipoCliente){
        this.oidSubTipoCliente = oidSubTipoCliente;
    }


    public Long getOidSubTipoCliente(){
        return oidSubTipoCliente;
    }


    public void setDescripcionSubTipoCliente(String descripcionSubTipoCliente){
        this.descripcionSubTipoCliente = descripcionSubTipoCliente;
    }


    public String getDescripcionSubTipoCliente(){
        return descripcionSubTipoCliente;
    }


    public void setImportePendiente(BigDecimal importePendiente){
        this.importePendiente = importePendiente;
    }


    public BigDecimal getImportePendiente(){
        return importePendiente;
    }


    public void setLineaCreditoConcedida(BigDecimal lineaCreditoConcedida){
        this.lineaCreditoConcedida = lineaCreditoConcedida;
    }


    public BigDecimal getLineaCreditoConcedida(){
        return lineaCreditoConcedida;
    }


    public void setLineaCreditoDisponible(BigDecimal LineaCreditoDisponible){
        this.LineaCreditoDisponible = LineaCreditoDisponible;
    }


    public BigDecimal getLineaCreditoDisponible(){
        return LineaCreditoDisponible;
    }


    public void setImporteDeudaCalculado(BigDecimal importeDeudaCalculado){
        this.importeDeudaCalculado = importeDeudaCalculado;
    }


    public BigDecimal getImporteDeudaCalculado(){
        return importeDeudaCalculado;
    }


    public void setImporteDeudaEnviarAdam(BigDecimal importeDeudaEnviarAdam){
        this.importeDeudaEnviarAdam = importeDeudaEnviarAdam;
    }


    public BigDecimal getImporteDeudaEnviarAdam(){
        return importeDeudaEnviarAdam;
    }


    public void setImporteDeudaDescontar(BigDecimal importeDeudaDescontar){
        this.importeDeudaDescontar = importeDeudaDescontar;
    }


    public BigDecimal getImporteDeudaDescontar(){
        return importeDeudaDescontar;
    }
}