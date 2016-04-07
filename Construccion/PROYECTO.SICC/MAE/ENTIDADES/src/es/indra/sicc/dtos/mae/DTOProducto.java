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

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.util.Vector;



/**
 * Sistema:         Belcorp
 * Modulo:           MAE
 * Submódulo:     Mantenimiento de Materiales
 * Componente:   DTO's
 * Fecha:             02/12/2003
 * Observaciones:     
 *                    
 * @version          1.0
 * @autor             Luis Ramos
 * 
 * pperanzola - 06/09/2005 - [1] se modifica segun diseño de Cod unico de venta
 * pperanzola - 20/10/2005 - [2] se modifica segun SICC-DMCO-PRE-GCC-001
 *          
 */

public class DTOProducto extends DTOAuditableSICC 
{
    private Long oid;
    private String codSAP;
    private String codAntiguo;
    private String descSAP;
    private Vector descSapI18n;
    private String descCorta;
    private Boolean indLote;
    private Boolean productoServicio;
    private Long unidadNegocio;
    private Long negocio;
    private Long generico;
    private Long supergenerico;
    private String jerarquia1;
    private String jerarquia2;
    private String jerarquia3;
    private Long lineaProducto;
    private String atributo1;
    private String atributo2;
    private String atributo3;
    private BigDecimal alto;
    private BigDecimal ancho;
    private BigDecimal largo;
    private Long unidMedidaDimensiones;
    private BigDecimal volumen;
    private Long unidMedidaVolumen;
    private BigDecimal peso;
    private Long unidMedidaPeso;
    private Integer unidDentroPedido;
    private Integer unidPorCaja;
    private BigDecimal costeEstandar;
    private BigDecimal precioPosicionamiento;
    private Character situacion;
//    private Boolean esSituacionActivo;
    private Long estatus;
    private Character cajaBolsa;
//    private Boolean estaDentroCaja;
    private String codImpuesto;
    private BigDecimal precioCatalogo;
    private BigDecimal precioContable;
    private Long oidMarca;
	private Long formaPago;
	private String grupoArticulos;
    
    private String codigoUnicoVenta; //[1]
    private Long programaFidelizacion; //[2]


    public Long getOidMarca()
      {
        return oidMarca;
      }

      public void setOidMarca(Long newOidMarca)
      {
        oidMarca = newOidMarca;
      }    

    public DTOProducto()
    {
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long newOid)
    {
        oid = newOid;
    }

    public String getCodSAP()
    {
        return codSAP;
    }

    public void setCodSAP(String newCodSAP)
    {
        codSAP = newCodSAP;
    }

    public String getCodAntiguo()
    {
        return codAntiguo;
    }

    public void setCodAntiguo(String newCodAntiguo)
    {
        codAntiguo = newCodAntiguo;
    }

    public String getDescSAP()
    {
        return descSAP;
    }

    public void setDescSAP(String newDescSAP)
    {
        descSAP = newDescSAP;
    }

    public String getDescCorta()
    {
        return descCorta;
    }

    public void setDescCorta(String newDescCorta)
    {
        descCorta = newDescCorta;
    }

    public Boolean getIndLote()
    {
        return indLote;
    }

    public void setIndLote(Boolean newIndLote)
    {
        indLote = newIndLote;
    }

    public Boolean getProductoServicio()
    {
        return productoServicio;
    }

    public void setProductoServicio(Boolean newProductoServicio)
    {
        productoServicio = newProductoServicio;
    }

    public Long getUnidadNegocio()
    {
        return unidadNegocio;
    }

    public void setUnidadNegocio(Long newUnidadNegocio)
    {
        unidadNegocio = newUnidadNegocio;
    }

    public Long getNegocio()
    {
        return negocio;
    }

    public void setNegocio(Long newNegocio)
    {
        negocio = newNegocio;
    }

    public Long getGenerico()
    {
        return generico;
    }

    public void setGenerico(Long newGenerico)
    {
        generico = newGenerico;
    }

    public Long getSupergenerico()
    {
        return supergenerico;
    }

    public void setSupergenerico(Long newSupergenerico)
    {
        supergenerico = newSupergenerico;
    }

    public String getJerarquia1()
    {
        return jerarquia1;
    }

    public void setJerarquia1(String newJerarquia1)
    {
        jerarquia1 = newJerarquia1;
    }

    public String getJerarquia2()
    {
        return jerarquia2;
    }

    public void setJerarquia2(String newJerarquia2)
    {
        jerarquia2 = newJerarquia2;
    }

    public String getJerarquia3()
    {
        return jerarquia3;
    }

    public void setJerarquia3(String newJerarquia3)
    {
        jerarquia3 = newJerarquia3;
    }

    public Long getLineaProducto()
    {
        return lineaProducto;
    }

    public void setLineaProducto(Long newLineaProducto)
    {
        lineaProducto = newLineaProducto;
    }

    public String getAtributo1()
    {
        return atributo1;
    }

    public void setAtributo1(String newAtributo1)
    {
        atributo1 = newAtributo1;
    }

    public String getAtributo2()
    {
        return atributo2;
    }

    public void setAtributo2(String newAtributo2)
    {
        atributo2 = newAtributo2;
    }

    public String getAtributo3()
    {
        return atributo3;
    }

    public void setAtributo3(String newAtributo3)
    {
        atributo3 = newAtributo3;
    }

    public BigDecimal getAlto()
    {
        return alto;
    }

    public void setAlto(BigDecimal newAlto)
    {
        alto = newAlto;
    }

    public BigDecimal getAncho()
    {
        return ancho;
    }

    public void setAncho(BigDecimal newAncho)
    {
        ancho = newAncho;
    }

    public BigDecimal getLargo()
    {
        return largo;
    }

    public void setLargo(BigDecimal newLargo)
    {
        largo = newLargo;
    }

    public Long getUnidMedidaDimensiones()
    {
        return unidMedidaDimensiones;
    }

    public void setUnidMedidaDimensiones(Long newUnidMedidaDimensiones)
    {
        unidMedidaDimensiones = newUnidMedidaDimensiones;
    }

    public BigDecimal getVolumen()
    {
        return volumen;
    }

    public void setVolumen(BigDecimal newVolumen)
    {
        volumen = newVolumen;
    }

    public Long getUnidMedidaVolumen()
    {
        return unidMedidaVolumen;
    }

    public void setUnidMedidaVolumen(Long newUnidMedidaVolumen)
    {
        unidMedidaVolumen = newUnidMedidaVolumen;
    }

    public BigDecimal getPeso()
    {
        return peso;
    }

    public void setPeso(BigDecimal newPeso)
    {
        peso = newPeso;
    }

    public Long getUnidMedidaPeso()
    {
        return unidMedidaPeso;
    }

    public void setUnidMedidaPeso(Long newUnidMedidaPeso)
    {
        unidMedidaPeso = newUnidMedidaPeso;
    }

    public Integer getUnidDentroPedido()
    {
        return unidDentroPedido;
    }

    public void setUnidDentroPedido(Integer newUnidDentroPedido)
    {
        unidDentroPedido = newUnidDentroPedido;
    }

    public Integer getUnidPorCaja()
    {
        return unidPorCaja;
    }

    public void setUnidPorCaja(Integer newUnidPorCaja)
    {
        unidPorCaja = newUnidPorCaja;
    }

    public BigDecimal getCosteEstandar()
    {
        return costeEstandar;
    }

    public void setCosteEstandar(BigDecimal newCosteEstandar)
    {
        costeEstandar = newCosteEstandar;
    }

    public BigDecimal getPrecioPosicionamiento()
    {
        return precioPosicionamiento;
    }

    public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento)
    {
        precioPosicionamiento = newPrecioPosicionamiento;
    }

    public Character getSituacion()
    {
        return situacion;
    }

    public void setSituacion(Character newSituacion)
    {
        situacion = newSituacion;
    }

    public Long getEstatus()
    {
        return estatus;
    }

    public void setEstatus(Long newEstatus)
    {
        estatus = newEstatus;
    }

    public Character getCajaBolsa()
    {
        return cajaBolsa;
    }

    public void setCajaBolsa(Character newCajaBolsa)
    {
        cajaBolsa = newCajaBolsa;
    }



    public String getCodImpuesto()
    {
        return codImpuesto;
    }

    public void setCodImpuesto(String newCodImpuesto)
    {
        codImpuesto = newCodImpuesto;
    }

    public BigDecimal getPrecioCatalogo()
    {
        return precioCatalogo;
    }

    public void setPrecioCatalogo(BigDecimal newPrecioCatalogo)
    {
        precioCatalogo = newPrecioCatalogo;
    }

    public BigDecimal getPrecioContable()
    {
        return precioContable;
    }

    public void setPrecioContable(BigDecimal newPrecioContable)
    {
        precioContable = newPrecioContable;
    }

    public Vector getDescSapI18n() {
        return descSapI18n;
    }

    public void setDescSapI18n(Vector newDescSapI18n) {
        descSapI18n = newDescSapI18n;
    }

	public Long getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Long newFormaPago) {
		formaPago = newFormaPago;
	}

	public String getGrupoArticulos() {
		return grupoArticulos;
	}

	public void setGrupoArticulos(String newGrupoArticulos) {
		grupoArticulos = newGrupoArticulos;
	}
    
    // /* [1]
    public String getCodigoUnicoVenta() {
        return codigoUnicoVenta;
    }
    public void setCodigoUnicoVenta(String newCodigoUnicoVenta) {
        codigoUnicoVenta = newCodigoUnicoVenta;
    }
    // */ [1]
    // /* [2]
    public Long getProgramaFidelizacion()
    {
        return programaFidelizacion;
    }

    public void setProgramaFidelizacion(Long programaFidelizacion)
    {
        this.programaFidelizacion = programaFidelizacion;
    }
    // */ [2]
}