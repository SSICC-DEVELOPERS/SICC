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


public class DTODetallePlantillaCurso  extends es.indra.sicc.util.DTOBelcorp {

    private String valor;
    private Boolean visible;
    private Boolean modificable;
    private Boolean obligatorio;
    private Long cursosRequisito[];
    private String nombresCursoRequisito[];
    private Long oid;
    private DTOParametro parametro;

    public DTODetallePlantillaCurso() {
        super();
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String newValor) {
        this.valor = newValor;
    }

    public Boolean getVisible() {
        return this.visible;
    }

    public void setVisible(Boolean newVisible) {
        this.visible = newVisible;
    }

    public Boolean getModificable() {
        return this.modificable;
    }

    public void setModificable(Boolean newModificable) {
        this.modificable = newModificable;
    }

    public Boolean getObligatorio() {
        return this.obligatorio;
    }

    public void setObligatorio(Boolean newObligatorio) {
        this.obligatorio = newObligatorio;
    }

    public Long[] getCursosRequisito() {
        return this.cursosRequisito;
    }

    public void setCursosRequisito(Long newCursosRequisito[]) {
        this.cursosRequisito = newCursosRequisito;
    }

    public String[] getNombresCursoRequisito() {
        return this.nombresCursoRequisito;
    }

    public void setNombresCursoRequisito(String newNombresCursoRequisito[]) {
        this.nombresCursoRequisito = newNombresCursoRequisito;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long newOid) {
        this.oid = newOid;
    }

    public DTOParametro getParametro() {
        return this.parametro;
    }

    public void setParametro(DTOParametro newParametro) {
        this.parametro = newParametro;
    }
}