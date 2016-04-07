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

package es.indra.sicc.logicanegocio.intsys;
import java.math.BigDecimal;

public class VentaTotalCampania  {
	/*Eliminado por incidencia BELC300017117
    private Long almacen;
	private Long periodo;
	private Long sociedad;
	private Long subacceso;
	private Long tipoCliente;
	private Long unidadesVendidas;
	private Long unidadesFaltantes;
	private Long unidadesDevueltas;
	private Long unidadesAnuladas;
	private Long unidadesCanje;
	private Long unidadesTrueque;
    
    //BELC300016770
	private Long tipoSolicitud;
    private String codigoPais;
    private String codigoAlmacen;
    private String canalBPS;
    private String codigoMedio;
    private String codigoSociedad;
    private BigDecimal ventaNetaAtendida;
    private BigDecimal ventaNetaFaltante;
    private BigDecimal ventaNetaDevoluciones;
    private BigDecimal ventaNetaAnulaciones;
    private BigDecimal ventaNetaCanjes;
    private BigDecimal ventaNetaTrueques;
    private Long numeroZonas;
    private Long numeroOrdenes;
    private Long numeroPedidos;*/
    
    //BELC300017117  
    private Long almacen;
    private Long periodo;
    private Long sociedad;
    private Long subacceso;
    private Long tipoCliente;
    private Long tipoSolicitud;
    private Long unidadesVendidas;
    private BigDecimal precioFacturaTotalLocal;
    private BigDecimal precioCatalogoTotalLocal;
    private Long numeroZonas;
    private Long numeroOrdenes;
    private Long numeroPedidos;
    private String codigoPais;
    private String codigoAlmacen;
    private String canalBPS;
    private String codigoMedio;
    private String codigoSociedad;
    private Boolean flagUnidadesVendidas;
    private Boolean flagUnidadesFaltantes;
    private Boolean flagUnidadesDevueltas;
    private Boolean flagUnidadesAnuladas;
    private Boolean flagUnidadesCanje;
    private Boolean flagUnidadesTrueque;
    
    /* Agregado por SICC-GCC-INT-SAB-004 - dmorello, 22/11/2006 */
    private Long unidadesPorAtender;
    
    /* BELC300024603 - dmorello, 08/01/2007 */
    private Long unidadesVendidasVendidas;
    private Long unidadesVendidasFaltantes;
    private Long unidadesVendidasDevueltas;
    private Long unidadesVendidasAnuladas;
    private Long unidadesVendidasCanje;
    private Long unidadesVendidasTrueque;
    private BigDecimal precioFacturaTotalLocalVendidas;
    private BigDecimal precioFacturaTotalLocalFaltantes;
    private BigDecimal precioFacturaTotalLocalDevueltas;
    private BigDecimal precioFacturaTotalLocalAnuladas;
    private BigDecimal precioFacturaTotalLocalCanje;
    private BigDecimal precioFacturaTotalLocalTrueque;
    private BigDecimal precioCatalogoTotalLocalVendidas;
    private BigDecimal precioCatalogoTotalLocalFaltantes;
    /* Fin BELC300024603 - dmorello, 05/01/2007 */

	public VentaTotalCampania() {
	}

    public Long getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Long almacen) {
        this.almacen = almacen;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long periodo) {
        this.periodo = periodo;
    }

    public Long getSociedad() {
        return sociedad;
    }

    public void setSociedad(Long sociedad) {
        this.sociedad = sociedad;
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long subacceso) {
        this.subacceso = subacceso;
    }

    public Long getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Long tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Long getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(Long tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Long getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(Long unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public BigDecimal getPrecioFacturaTotalLocal() {
        return precioFacturaTotalLocal;
    }

    public void setPrecioFacturaTotalLocal(BigDecimal precioFacturaTotalLocal) {
        this.precioFacturaTotalLocal = precioFacturaTotalLocal;
    }

    public BigDecimal getPrecioCatalogoTotalLocal() {
        return precioCatalogoTotalLocal;
    }

    public void setPrecioCatalogoTotalLocal(BigDecimal precioCatalogoTotalLocal) {
        this.precioCatalogoTotalLocal = precioCatalogoTotalLocal;
    }

    public Long getNumeroZonas() {
        return numeroZonas;
    }

    public void setNumeroZonas(Long numeroZonas) {
        this.numeroZonas = numeroZonas;
    }

    public Long getNumeroOrdenes() {
        return numeroOrdenes;
    }

    public void setNumeroOrdenes(Long numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }

    public Long getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(Long numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoAlmacen() {
        return codigoAlmacen;
    }

    public void setCodigoAlmacen(String codigoAlmacen) {
        this.codigoAlmacen = codigoAlmacen;
    }

    public String getCanalBPS() {
        return canalBPS;
    }

    public void setCanalBPS(String canalBPS) {
        this.canalBPS = canalBPS;
    }

    public String getCodigoMedio() {
        return codigoMedio;
    }

    public void setCodigoMedio(String codigoMedio) {
        this.codigoMedio = codigoMedio;
    }

    public String getCodigoSociedad() {
        return codigoSociedad;
    }

    public void setCodigoSociedad(String codigoSociedad) {
        this.codigoSociedad = codigoSociedad;
    }

    public Boolean getFlagUnidadesVendidas() {
        return flagUnidadesVendidas;
    }

    public void setFlagUnidadesVendidas(Boolean flagUnidadesVendidas) {
        this.flagUnidadesVendidas = flagUnidadesVendidas;
    }

    public Boolean getFlagUnidadesFaltantes() {
        return flagUnidadesFaltantes;
    }

    public void setFlagUnidadesFaltantes(Boolean flagUnidadesFaltantes) {
        this.flagUnidadesFaltantes = flagUnidadesFaltantes;
    }

    public Boolean getFlagUnidadesDevueltas() {
        return flagUnidadesDevueltas;
    }

    public void setFlagUnidadesDevueltas(Boolean flagUnidadesDevueltas) {
        this.flagUnidadesDevueltas = flagUnidadesDevueltas;
    }

    public Boolean getFlagUnidadesAnuladas() {
        return flagUnidadesAnuladas;
    }

    public void setFlagUnidadesAnuladas(Boolean flagUnidadesAnuladas) {
        this.flagUnidadesAnuladas = flagUnidadesAnuladas;
    }

    public Boolean getFlagUnidadesCanje() {
        return flagUnidadesCanje;
    }

    public void setFlagUnidadesCanje(Boolean flagUnidadesCanje) {
        this.flagUnidadesCanje = flagUnidadesCanje;
    }

    public Boolean getFlagUnidadesTrueque() {
        return flagUnidadesTrueque;
    }

    public void setFlagUnidadesTrueque(Boolean flagUnidadesTrueque) {
        this.flagUnidadesTrueque = flagUnidadesTrueque;
    }

    public Long getUnidadesPorAtender()
    {
      return unidadesPorAtender;
    }
  
    public void setUnidadesPorAtender(Long unidadesPorAtender)
    {
      this.unidadesPorAtender = unidadesPorAtender;
    }

    public Long getUnidadesVendidasVendidas()
    {
      return unidadesVendidasVendidas;
    }
  
    public void setUnidadesVendidasVendidas(Long unidadesVendidasVendidas)
    {
      this.unidadesVendidasVendidas = unidadesVendidasVendidas;
    }
  
    public Long getUnidadesVendidasFaltantes()
    {
      return unidadesVendidasFaltantes;
    }
  
    public void setUnidadesVendidasFaltantes(Long unidadesVendidasFaltantes)
    {
      this.unidadesVendidasFaltantes = unidadesVendidasFaltantes;
    }
  
    public Long getUnidadesVendidasDevueltas()
    {
      return unidadesVendidasDevueltas;
    }
  
    public void setUnidadesVendidasDevueltas(Long unidadesVendidasDevueltas)
    {
      this.unidadesVendidasDevueltas = unidadesVendidasDevueltas;
    }
  
    public Long getUnidadesVendidasAnuladas()
    {
      return unidadesVendidasAnuladas;
    }
  
    public void setUnidadesVendidasAnuladas(Long unidadesVendidasAnuladas)
    {
      this.unidadesVendidasAnuladas = unidadesVendidasAnuladas;
    }
  
    public Long getUnidadesVendidasCanje()
    {
      return unidadesVendidasCanje;
    }
  
    public void setUnidadesVendidasCanje(Long unidadesVendidasCanje)
    {
      this.unidadesVendidasCanje = unidadesVendidasCanje;
    }
  
    public Long getUnidadesVendidasTrueque()
    {
      return unidadesVendidasTrueque;
    }
  
    public void setUnidadesVendidasTrueque(Long unidadesVendidasTrueque)
    {
      this.unidadesVendidasTrueque = unidadesVendidasTrueque;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalVendidas()
    {
      return precioFacturaTotalLocalVendidas;
    }
  
    public void setPrecioFacturaTotalLocalVendidas(BigDecimal precioFacturaTotalLocalVendidas)
    {
      this.precioFacturaTotalLocalVendidas = precioFacturaTotalLocalVendidas;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalFaltantes()
    {
      return precioFacturaTotalLocalFaltantes;
    }
  
    public void setPrecioFacturaTotalLocalFaltantes(BigDecimal precioFacturaTotalLocalFaltantes)
    {
      this.precioFacturaTotalLocalFaltantes = precioFacturaTotalLocalFaltantes;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalDevueltas()
    {
      return precioFacturaTotalLocalDevueltas;
    }
  
    public void setPrecioFacturaTotalLocalDevueltas(BigDecimal precioFacturaTotalLocalDevueltas)
    {
      this.precioFacturaTotalLocalDevueltas = precioFacturaTotalLocalDevueltas;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalAnuladas()
    {
      return precioFacturaTotalLocalAnuladas;
    }
  
    public void setPrecioFacturaTotalLocalAnuladas(BigDecimal precioFacturaTotalLocalAnuladas)
    {
      this.precioFacturaTotalLocalAnuladas = precioFacturaTotalLocalAnuladas;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalCanje()
    {
      return precioFacturaTotalLocalCanje;
    }
  
    public void setPrecioFacturaTotalLocalCanje(BigDecimal precioFacturaTotalLocalCanje)
    {
      this.precioFacturaTotalLocalCanje = precioFacturaTotalLocalCanje;
    }
  
    public BigDecimal getPrecioFacturaTotalLocalTrueque()
    {
      return precioFacturaTotalLocalTrueque;
    }
  
    public void setPrecioFacturaTotalLocalTrueque(BigDecimal precioFacturaTotalLocalTrueque)
    {
      this.precioFacturaTotalLocalTrueque = precioFacturaTotalLocalTrueque;
    }
  
    public BigDecimal getPrecioCatalogoTotalLocalVendidas()
    {
      return precioCatalogoTotalLocalVendidas;
    }
  
    public void setPrecioCatalogoTotalLocalVendidas(BigDecimal precioCatalogoTotalLocalVendidas)
    {
      this.precioCatalogoTotalLocalVendidas = precioCatalogoTotalLocalVendidas;
    }
  
    public BigDecimal getPrecioCatalogoTotalLocalFaltantes()
    {
      return precioCatalogoTotalLocalFaltantes;
    }
  
    public void setPrecioCatalogoTotalLocalFaltantes(BigDecimal precioCatalogoTotalLocalFaltantes)
    {
      this.precioCatalogoTotalLocalFaltantes = precioCatalogoTotalLocalFaltantes;
    }

}