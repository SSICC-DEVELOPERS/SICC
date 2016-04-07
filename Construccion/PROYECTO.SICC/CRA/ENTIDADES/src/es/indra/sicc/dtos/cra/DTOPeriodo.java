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
 */

package es.indra.sicc.dtos.cra;
import java.sql.Date;
import java.io.Serializable;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         
 * Componente:        DTO's
 * Fecha:             06/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 *                    
 * @version           1.0
 * @autor             Federico G. Stilman
 * @version           2.0
 * @autor             Carlos Ferreira
 */

public class DTOPeriodo extends DTOAuditableSICC {
    private Long marca;
    private Long oid;
    private Long pais;
    private Long canal;
    private Long acceso;
    private String nombre;
    private Boolean status;
    private Date fechaInicio;
    private Date fechaFin;
    private Long tipo;
    private String codigoPeriodo;

    // gdmarzi --> sobran duracion y subAcceso segun V3
    private Integer duracion;
    private Long subAcceso;    //Jrivas: se agrego el subAcceso para pasar en el metodo obtienePeriodosAnteriores
    private Long oidPeriodoCorporativo;
    private String codigoTipoPeriodo;
    Boolean periodoCorto;
    Boolean periodoCruce;
    
    // dmorello, Cambio CRA-01
    private Integer anio;



    public DTOPeriodo() {
        super();
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre) {
        nombre = newNombre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean newStatus) {
        status = newStatus;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer newDuracion) {
        duracion = newDuracion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date newFechaInicio) {
        fechaInicio = newFechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date newFechaFin) {
        fechaFin = newFechaFin;
    }

    public Long getSubAcceso() {
        return subAcceso;
    }

    public void setSubAcceso(Long newSubAcceso) {
        subAcceso = newSubAcceso;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipoPeriodo) {
        tipo = newTipoPeriodo;
    }

    public String getCodigoPeriodo()
    {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String newCodigoPeriodo)
    {
        codigoPeriodo = newCodigoPeriodo;
    }

    public Long getOidPeriodoCorporativo()
    {
        return oidPeriodoCorporativo;
    }

    public void setOidPeriodoCorporativo(Long newOidPeriodoCorporativo)
    {
        oidPeriodoCorporativo = newOidPeriodoCorporativo;
    }

    public String getCodigoTipoPeriodo()
    {
        return codigoTipoPeriodo;
    }

    public void setCodigoTipoPeriodo(String newCodigoTipoPeriodo)
    {
        codigoTipoPeriodo = newCodigoTipoPeriodo;
    }

    public Boolean getPeriodoCorto()
    {
        return periodoCorto;
    }

    public void setPeriodoCorto(Boolean newPeriodoCorto)
    {
        periodoCorto = newPeriodoCorto;
    }

    public Boolean getPeriodoCruce()
    {
        return periodoCruce;
    }

    public void setPeriodoCruce(Boolean newPeriodoCruce)
    {
        periodoCruce = newPeriodoCruce;
    }

    public Integer getAnio()
    {
        return anio;
    }

    public void setAnio(Integer anio)
    {
        this.anio = anio;
    }
}