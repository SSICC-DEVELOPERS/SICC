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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultaCurso extends DTOSiccPaginacion {

    private Long marca;
    private Long canal;
    private Long tipoCurso;
    private Integer codigo;
    private String nombre;

    public DTOConsultaCurso() {
        super();
    }

    public Long getMarca() {
        return this.marca;
    }

    public void setMarca(Long newMarca) {
        this.marca = newMarca;
    }

    public Long getCanal() {
        return this.canal;
    }

    public void setCanal(Long newCanal) {
        this.canal = newCanal;
    }

    public Long getTipoCurso() {
        return this.tipoCurso;
    }

    public void setTipoCurso(Long newTipoCurso) {
        this.tipoCurso = newTipoCurso;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer newCodigo) {
        this.codigo = newCodigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }
}