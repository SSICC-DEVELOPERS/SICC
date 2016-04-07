package es.indra.sicc.dtos.inc;

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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOCabeceraConsultaIntegral extends DTOSiccPaginacion
{
    private Long oidCliente;
    private String codigoCliente;
    private String nombreApellidos;
    private Long oidConcurso;
    private String numeroConcurso;
    private String nombreConcurso;
    private Long oidPeriodoInicial;
    private String periodoInicial;
    private Long oidPeriodoFinal;
    private String periodoFinal;
    private Boolean faseCalificacion;
    private Long oidBaseCalculo;
    private Boolean multinivel;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Long oidPlantilla;
    private Long oidCampania;
    // vbongiov -- INC 014 -- 20/10/2008
    private Long oidTipoConcurso;
    private Long oidEstadoConcurso;

    public DTOCabeceraConsultaIntegral()
    {
    }

    public Long getOidCampania()
    {
        return oidCampania;
    }

    public void setOidCampania(Long oidCampania)
    {
        this.oidCampania = oidCampania;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreApellidos()
    {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos)
    {
        this.nombreApellidos = nombreApellidos;
    }

    public Long getOidConcurso()
    {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso)
    {
        this.oidConcurso = oidConcurso;
    }

    public String getNumeroConcurso()
    {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso)
    {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNombreConcurso()
    {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso)
    {
        this.nombreConcurso = nombreConcurso;
    }

    public Long getOidPeriodoInicial()
    {
        return oidPeriodoInicial;
    }

    public void setOidPeriodoInicial(Long oidPeriodoInicial)
    {
        this.oidPeriodoInicial = oidPeriodoInicial;
    }

    public String getPeriodoInicial()
    {
        return periodoInicial;
    }

    public void setPeriodoInicial(String periodoInicial)
    {
        this.periodoInicial = periodoInicial;
    }

    public Long getOidPeriodoFinal()
    {
        return oidPeriodoFinal;
    }

    public void setOidPeriodoFinal(Long oidPeriodoFinal)
    {
        this.oidPeriodoFinal = oidPeriodoFinal;
    }

    public String getPeriodoFinal()
    {
        return periodoFinal;
    }

    public void setPeriodoFinal(String periodoFinal)
    {
        this.periodoFinal = periodoFinal;
    }

    public Boolean getFaseCalificacion()
    {
        return faseCalificacion;
    }

    public void setFaseCalificacion(Boolean faseCalificacion)
    {
        this.faseCalificacion = faseCalificacion;
    }

    public Long getOidBaseCalculo()
    {
        return oidBaseCalculo;
    }

    public void setOidBaseCalculo(Long oidBaseCalculo)
    {
        this.oidBaseCalculo = oidBaseCalculo;
    }

    public Boolean getMultinivel()
    {
        return multinivel;
    }

    public void setMultinivel(Boolean multinivel)
    {
        this.multinivel = multinivel;
    }

    public Long getOidRegion()
    {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion)
    {
        this.oidRegion = oidRegion;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long oidZona)
    {
        this.oidZona = oidZona;
    }

    public Long getOidSeccion()
    {
        return oidSeccion;
    }

    public void setOidSeccion(Long oidSeccion)
    {
        this.oidSeccion = oidSeccion;
    }

    public Long getOidPlantilla()
    {
        return oidPlantilla;
    }

    public void setOidPlantilla(Long oidPlantilla)
    {
        this.oidPlantilla = oidPlantilla;
    }

    public Long getOidTipoConcurso()
    {
        return oidTipoConcurso;
    }

    public void setOidTipoConcurso(Long oidTipoConcurso)
    {
        this.oidTipoConcurso = oidTipoConcurso;
    }

    public Long getOidEstadoConcurso()
    {
        return oidEstadoConcurso;
    }

    public void setOidEstadoConcurso(Long oidEstadoConcurso)
    {
        this.oidEstadoConcurso = oidEstadoConcurso;
    }
}