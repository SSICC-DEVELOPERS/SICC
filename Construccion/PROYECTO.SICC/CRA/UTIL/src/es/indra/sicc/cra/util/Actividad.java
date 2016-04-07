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

package es.indra.sicc.cra.util;

import java.sql.Date;
import java.io.Serializable;


public class Actividad implements Serializable {
    private Long pais;
    private Long marca;
    private Long canal;
    private Long periodo;
    private String idNegocio;

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


}