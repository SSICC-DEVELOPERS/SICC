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
 
package es.indra.sicc.dtos.edu;

import es.indra.sicc.util.DTOBelcorp;
import java.sql.Date;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.math.BigDecimal;
/*
 * @CHANGELOG 
   2005.11.17 GMIOTTI DT Se cambia el nombre del atributo cursosRecibidos por cursosExigidos
 */
public class DTOCurso extends DTOBelcorp {

    private DTORelacionesCurso relacion;
    private Long cursosExigidos[];
    private String nombre;
    private Integer codigo;
    private Boolean accesoDataMart;
    private Boolean accesoInformacion;
    private String objetivo;
    private String contenido;
    private Date fechaDisponible;
    private Date fechaLanzamiento;
    private Date fechaFin;
    private Boolean alcance;
    private Integer numeroParticipantes;
    private Boolean bloqueoExtemporaneas;
    private String relacionMaterial;
    private Integer numeroOrdenes;
    private BigDecimal montoVentas;
    private Integer numeroCampanyas;
    private Date fechaUltimo;
    private Date fechaConcreta;
    private Integer numeroUnidades;
    private Boolean condicionPedido;
    private Boolean controlMorosidad;
    private Date fechaIngreso;
    private String descripcion;
    private Long oid;
    private DTOI18nSICC attriTraducible[];

    public DTOCurso() {
      super();
    }

    public DTORelacionesCurso getRelacion() {
        return this.relacion;
    }

    public void setRelacion(DTORelacionesCurso newRelacion) {
        this.relacion = newRelacion;
    }

    public Long[] getCursosExigidos() {
        return this.cursosExigidos;
    }

    public void setCursosExigidos(Long newCursosExigidos[]) {
        this.cursosExigidos = newCursosExigidos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer newCodigo) {
        this.codigo = newCodigo;
    }

    public Boolean getAccesoDataMart() {
        return this.accesoDataMart;
    }

    public void setAccesoDataMart(Boolean newAccesoDataMart) {
        this.accesoDataMart = newAccesoDataMart;
    }

    public Boolean getAccesoInformacion() {
        return this.accesoInformacion;
    }

    public void setAccesoInformacion(Boolean newAccesoInformacion) {
        this.accesoInformacion = newAccesoInformacion;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String newObjetivo) {
        this.objetivo = newObjetivo;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String newContenido) {
        this.contenido = newContenido;
    }

    public Date getFechaDisponible() {
        return this.fechaDisponible;
    }

    public void setFechaDisponible(Date newFechaDisponible) {
        this.fechaDisponible = newFechaDisponible;
    }

    public Date getFechaLanzamiento() {
        return this.fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date newFechaLanzamiento) {
        this.fechaLanzamiento = newFechaLanzamiento;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date newFechaFin) {
        this.fechaFin = newFechaFin;
    }

    public Boolean getAlcance() {
        return this.alcance;
    }

    public void setAlcance(Boolean newAlcance) {
        this.alcance = newAlcance;
    }

    public Integer getNumeroParticipantes() {
        return this.numeroParticipantes;
    }

    public void setNumeroParticipantes(Integer newNumeroParticipantes) {
        this.numeroParticipantes = newNumeroParticipantes;
    }

    public Boolean getBloqueoExtemporaneas() {
        return this.bloqueoExtemporaneas;
    }

    public void setBloqueoExtemporaneas(Boolean newBloqueoExtemporaneas) {
        this.bloqueoExtemporaneas = newBloqueoExtemporaneas;
    }

    public String getRelacionMaterial() {
        return this.relacionMaterial;
    }

    public void setRelacionMaterial(String newRelacionMaterial) {
        this.relacionMaterial = newRelacionMaterial;
    }

    public Integer getNumeroOrdenes() {
        return this.numeroOrdenes;
    }

    public void setNumeroOrdenes(Integer newNumeroOrdenes) {
        this.numeroOrdenes = newNumeroOrdenes;
    }

    public BigDecimal getMontoVentas() {
        return this.montoVentas;
    }

    public void setMontoVentas(BigDecimal newMontoVentas) {
        this.montoVentas = newMontoVentas;
    }

    public Integer getNumeroCampanyas() {
        return this.numeroCampanyas;
    }

    public void setNumeroCampanyas(Integer newNumeroCampanyas) {
        this.numeroCampanyas = newNumeroCampanyas;
    }

    public Date getFechaUltimo() {
        return this.fechaUltimo;
    }

    public void setFechaUltimo(Date newFechaUltimo) {
        this.fechaUltimo = newFechaUltimo;
    }

    public Date getFechaConcreta() {
        return this.fechaConcreta;
    }

    public void setFechaConcreta(Date newFechaConcreta) {
        this.fechaConcreta = newFechaConcreta;
    }

    public Integer getNumeroUnidades() {
        return this.numeroUnidades;
    }

    public void setNumeroUnidades(Integer newNumeroUnidades) {
        this.numeroUnidades = newNumeroUnidades;
    }

    public Boolean getCondicionPedido() {
        return this.condicionPedido;
    }

    public void setCondicionPedido(Boolean newCondicionPedido) {
        this.condicionPedido = newCondicionPedido;
    }

    public Boolean getControlMorosidad() {
        return this.controlMorosidad;
    }

    public void setControlMorosidad(Boolean newControlMorosidad) {
        this.controlMorosidad = newControlMorosidad;
    }

    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date newFechaIngreso) {
        this.fechaIngreso = newFechaIngreso;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        this.descripcion = newDescripcion;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long newOid) {
        this.oid = newOid;
    }

    public DTOI18nSICC[] getAttriTraducible() {
        return this.attriTraducible;
    }

    public void setAttriTraducible(DTOI18nSICC newAttriTraducible[]) {
        this.attriTraducible = newAttriTraducible;
    }
}
