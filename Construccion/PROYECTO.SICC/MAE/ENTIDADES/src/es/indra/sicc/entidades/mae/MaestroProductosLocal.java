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
 
package es.indra.sicc.entidades.mae;
import javax.ejb.EJBLocalObject;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.EJBLocalObjectSICCAuditable;
import es.indra.mare.common.exception.MareException;
import java.util.Vector;

public interface MaestroProductosLocal extends EJBLocalObjectSICCAuditable 
{

    public Long getOid();

    public void setOid(Long newOid);

    public String getCodigoSAP();

    public void setCodigoSAP(String newCodigoSAP);

    public String getCodigoAntiguo();

    public void setCodigoAntiguo(String newCodigoAntiguo);

    public String getDescripcionCorta();

    public void setDescripcionCorta(String newDescripcionCorta);

    public Boolean getEsLote();

    public void setEsLote(Boolean newEsLote);

    public Boolean getIndProductoServicio();

    public void setIndProductoServicio(Boolean newIndProductoServicio);

    public String getJerarquia1();

    public void setJerarquia1(String newJerarquia1);

    public String getJerarquia2();

    public void setJerarquia2(String newJerarquia2);

    public String getJerarquia3();

    public void setJerarquia3(String newJerarquia3);

    public String getAtributo1();

    public void setAtributo1(String newAtributo1);

    public String getAtributo2();

    public void setAtributo2(String newAtributo2);

    public String getAtributo3();

    public void setAtributo3(String newAtributo3);

    public BigDecimal getAlto();

    public void setAlto(BigDecimal newAlto);

    public BigDecimal getLargo();

    public void setLargo(BigDecimal newLargo);

    public BigDecimal getAncho();

    public void setAncho(BigDecimal newAncho);

    public BigDecimal getVolumen();

    public void setVolumen(BigDecimal newVolumen);

    public BigDecimal getPeso();

    public void setPeso(BigDecimal newPeso);

    public Integer getUnidadesDentroPedido();

    public void setUnidadesDentroPedido(Integer newUnidadesDentroPedido);

    public Integer getUnidadesCaja();

    public void setUnidadesCaja(Integer newUnidadesCaja);

    public BigDecimal getCosteEstandard();

    public void setCosteEstandard(BigDecimal newCosteEstandard);

    public BigDecimal getPrecioPosicionamiento();

    public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento);

    public String getSituacion();

    public void setSituacion(String newSituacion);

    public String getIndCajaBolsa();

    public void setIndCajaBolsa(String newIndCajaBolsa);

    public Long getFormaPago();

    public void setFormaPago(Long newFormaPago);

    public String getCodigoImpuesto();

    public void setCodigoImpuesto(String newCodigoImpuesto);

    public BigDecimal getPrecioCatalogo();

    public void setPrecioCatalogo(BigDecimal newPrecioCatalogo);

    public BigDecimal getPrecioContable();

    public void setPrecioContable(BigDecimal newPrecioContable);

    public Boolean getEsKit();

    public void setEsKit(Boolean newEsKit);

    public Integer getPorcentajeUnidades();

    public void setPorcentajeUnidades(Integer newPorcentajeUnidades);

    public Long getGenerico();

    public void setGenerico(Long newGenerico);

    public Long getSuperGenerico();

    public void setSuperGenerico(Long newSuperGenerico);

    public Long getStatus();

    public void setStatus(Long newStatus);

    public Long getUnidadMedidaDimensiones();

    public void setUnidadMedidaDimensiones(Long newUnidadMedidaDimensiones);

    public Long getLineaDeProducto();

    public void setLineaDeProducto(Long newLineaDeProducto);

    public Long getNegocio();

    public void setNegocio(Long newNegocio);

    public Long getPeriodoInicio();

    public void setPeriodoInicio(Long newPeriodoInicio);

    public Long getPeriodoFin();

    public void setPeriodoFin(Long newPeriodoFin);

    public Long getUnidadMedidaPeso();

    public void setUnidadMedidaPeso(Long newUnidadMedidaPeso);

    public Long getUnidadMedidaVolumen();

    public void setUnidadMedidaVolumen(Long newUnidadMedidaVolumen);

    public Long getMarcaProducto();

    public void setMarcaProducto(Long newMarcaProducto);

    public Long getUnidadNegocio();

    public void setUnidadNegocio(Long newUnidadNegocio);

    public void setTraducciones(Vector valores) throws MareException;

	public String getGrupoArticulos();

	public void setGrupoArticulos(String newGrupoArticulos);

    String getCodigoUnicoVenta();

    void setCodigoUnicoVenta(String codigoUnicoVenta);
    
    Long getProgramaFidelizacion();

    void setProgramaFidelizacion(Long programaFidelizacion);


}