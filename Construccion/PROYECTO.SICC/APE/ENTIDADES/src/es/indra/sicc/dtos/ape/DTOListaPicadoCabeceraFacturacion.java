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

import es.indra.sicc.util.DTOBelcorp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class DTOListaPicadoCabeceraFacturacion extends DTOBelcorp {

    private Long oidConfiguracionCD;
    private Long oidLinea;
    private Long oidPeriodo;
    private Date fechaCreacion;
    private Long oidRegion;
    private Long numeroUnidadesTotales;
    private String textoChequeo;
    private String textoPrimerPedido;
    private String secuencia; 
    private Double volumen;
    private Date fechaFacturacion;
    private String origenChequeo;
    private Boolean indicadorImpresion;
    private String codTerritorial;   
    private String codConsult;
    private String nomComplConsult;
    private String descrLineaArmado;
    private String descrPeriodo;
    private String codBarr;
    private Long numeroTotCaj;
    
    // detalles
    private HashMap detalles;   //hash q' contiene nºcaja (key) - nºpag. para esa caja - arraylist 
                                //de DTOListaPicadoDetalleFacturacion, con los detalles para esa caja
    
    // Cambio 20090839 - dmorello, 06/10/2009
    private Integer longitudNumeroEtiqueta;
                                
    public DTOListaPicadoCabeceraFacturacion()
    {
    }


    public void setOidConfiguracionCD(Long oidConfiguracionCD)
    {
        this.oidConfiguracionCD = oidConfiguracionCD;
    }


    public Long getOidConfiguracionCD()
    {
        return oidConfiguracionCD;
    }


    public void setOidLinea(Long oidLinea)
    {
        this.oidLinea = oidLinea;
    }


    public Long getOidLinea()
    {
        return oidLinea;
    }


    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }


    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }


    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }


    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }


    public void setOidRegion(Long oidRegion)
    {
        this.oidRegion = oidRegion;
    }


    public Long getOidRegion()
    {
        return oidRegion;
    }


    public void setNumeroUnidadesTotales(Long numeroUnidadesTotales)
    {
        this.numeroUnidadesTotales = numeroUnidadesTotales;
    }


    public Long getNumeroUnidadesTotales()
    {
        return numeroUnidadesTotales;
    }


    public void setTextoChequeo(String textoChequeo)
    {
        this.textoChequeo = textoChequeo;
    }


    public String getTextoChequeo()
    {
        return textoChequeo;
    }


    public void setTextoPrimerPedido(String textoPrimerPedido)
    {
        this.textoPrimerPedido = textoPrimerPedido;
    }


    public String getTextoPrimerPedido()
    {
        return textoPrimerPedido;
    }


    public void setSecuencia(String secuencia)
    {
        this.secuencia = secuencia;
    }


    public String getSecuencia()
    {
        return secuencia;
    }


    public void setVolumen(Double volumen)
    {
        this.volumen = volumen;
    }


    public Double getVolumen()
    {
        return volumen;
    }


    public void setFechaFacturacion(Date fechaFacturacion)
    {
        this.fechaFacturacion = fechaFacturacion;
    }


    public Date getFechaFacturacion()
    {
        return fechaFacturacion;
    }


    public void setOrigenChequeo(String origenChequeo)
    {
        this.origenChequeo = origenChequeo;
    }


    public String getOrigenChequeo()
    {
        return origenChequeo;
    }


    public void setIndicadorImpresion(Boolean indicadorImpresion)
    {
        this.indicadorImpresion = indicadorImpresion;
    }


    public Boolean getIndicadorImpresion()
    {
        return indicadorImpresion;
    }

    public void setCodTerritorial(String codTerritorial)
    {
        this.codTerritorial = codTerritorial;
    }


    public String getCodTerritorial()
    {
        return codTerritorial;
    }


    public void setNomComplConsult(String nomComplConsult)
    {
        this.nomComplConsult = nomComplConsult;
    }


    public String getNomComplConsult()
    {
        return nomComplConsult;
    }


    public void setDescrLineaArmado(String descrLineaArmado)
    {
        this.descrLineaArmado = descrLineaArmado;
    }


    public String getDescrLineaArmado()
    {
        return descrLineaArmado;
    }


    public void setDescrPeriodo(String descrPeriodo)
    {
        this.descrPeriodo = descrPeriodo;
    }


    public String getDescrPeriodo()
    {
        return descrPeriodo;
    }


    public void setCodBarr(String codBarr)
    {
        this.codBarr = codBarr;
    }


    public String getCodBarr()
    {
        return codBarr;
    }


    public void setNumeroTotCaj(Long numeroTotCaj)
    {
        this.numeroTotCaj = numeroTotCaj;
    }


    public Long getNumeroTotCaj()
    {
        return numeroTotCaj;
    }


    public void setDetalles(HashMap detalles)
    {
        this.detalles = detalles;
    }


    public HashMap getDetalles()
    {
        return detalles;
    }


    public void setCodConsult(String codConsult)
    {
        this.codConsult = codConsult;
    }


    public String getCodConsult()
    {
        return codConsult;
    }

    public void setLongitudNumeroEtiqueta(Integer longitudNumeroEtiqueta) {
        this.longitudNumeroEtiqueta = longitudNumeroEtiqueta;
    }

    public Integer getLongitudNumeroEtiqueta() {
        return longitudNumeroEtiqueta;
    }
}
