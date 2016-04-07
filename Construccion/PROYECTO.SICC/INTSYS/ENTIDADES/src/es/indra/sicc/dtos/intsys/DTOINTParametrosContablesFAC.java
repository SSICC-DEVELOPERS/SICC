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

import es.indra.sicc.util.DTOBelcorp;
public class DTOINTParametrosContablesFAC extends DTOBelcorp {
    private Long oid;
    private Long pais;
    private String codigoApunte;
    private String tipoAsiento;
    private String identificadorCabeceraDetalle;
    private String descripcion;
    private String grupoArticulos;
    private Long marcaProducto;
    private Long negocio;
    private Long producto;
    private Long cuentaContable;
    private String indicadorDebeHaber;
    private Long importeAContabilizar;
    private String codigoImporteAContabilizar;
    
    public DTOINTParametrosContablesFAC()
    {
    }

    public String getCodigoApunte()
    {
        return codigoApunte;
    }

    public void setCodigoApunte(String codigoApunte)
    {
        this.codigoApunte = codigoApunte;
    }

    public String getCodigoImporteAContabilizar()
    {
        return codigoImporteAContabilizar;
    }

    public void setCodigoImporteAContabilizar(String codigoImporteAContabilizar)
    {
        this.codigoImporteAContabilizar = codigoImporteAContabilizar;
    }

    public Long getCuentaContable()
    {
        return cuentaContable;
    }

    public void setCuentaContable(Long cuentaContable)
    {
        this.cuentaContable = cuentaContable;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getGrupoArticulos()
    {
        return grupoArticulos;
    }

    public void setGrupoArticulos(String grupoArticulos)
    {
        this.grupoArticulos = grupoArticulos;
    }

    public String getIdentificadorCabeceraDetalle()
    {
        return identificadorCabeceraDetalle;
    }

    public void setIdentificadorCabeceraDetalle(String identificadorCabeceraDetalle)
    {
        this.identificadorCabeceraDetalle = identificadorCabeceraDetalle;
    }

    public Long getImporteAContabilizar()
    {
        return importeAContabilizar;
    }

    public void setImporteAContabilizar(Long importeAContabilizar)
    {
        this.importeAContabilizar = importeAContabilizar;
    }

    public String getIndicadorDebeHaber()
    {
        return indicadorDebeHaber;
    }

    public void setIndicadorDebeHaber(String indicadorDebeHaber)
    {
        this.indicadorDebeHaber = indicadorDebeHaber;
    }

    public Long getMarcaProducto()
    {
        return marcaProducto;
    }

    public void setMarcaProducto(Long marcaProducto)
    {
        this.marcaProducto = marcaProducto;
    }

    public Long getNegocio()
    {
        return negocio;
    }

    public void setNegocio(Long negocio)
    {
        this.negocio = negocio;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public Long getPais()
    {
        return pais;
    }

    public void setPais(Long pais)
    {
        this.pais = pais;
    }

    public Long getProducto()
    {
        return producto;
    }

    public void setProducto(Long producto)
    {
        this.producto = producto;
    }

    public String getTipoAsiento()
    {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento)
    {
        this.tipoAsiento = tipoAsiento;
    }
}