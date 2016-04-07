/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.dtos.cra;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;

public class DTODatosPlanificador extends DTOAuditableSICC {

    private Long pais;
    private Long marca;
    private Long canal;
    private Long periodo;
    private String idNegocio;
    private Date fechaEjecucion;

    public DTODatosPlanificador() {
    }

    public Long getPais()
    {
        return pais;
    }

    public void setPais(Long pais)
    {
        this.pais = pais;
    }

    public Long getMarca()
    {
        return marca;
    }

    public void setMarca(Long marca)
    {
        this.marca = marca;
    }

    public Long getCanal()
    {
        return canal;
    }

    public void setCanal(Long canal)
    {
        this.canal = canal;
    }

    public Long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Long periodo)
    {
        this.periodo = periodo;
    }

    public String getIdNegocio()
    {
        return idNegocio;
    }

    public void setIdNegocio(String idNegocio)
    {
        this.idNegocio = idNegocio;
    }

    public Date getFechaEjecucion()
    {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion)
    {
        this.fechaEjecucion = fechaEjecucion;
    }
}