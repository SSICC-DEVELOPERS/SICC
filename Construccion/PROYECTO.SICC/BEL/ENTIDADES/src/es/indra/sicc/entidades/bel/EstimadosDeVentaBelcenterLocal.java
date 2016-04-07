package es.indra.sicc.entidades.bel;

import es.indra.mare.common.exception.MareException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="BEL_ESTIM_VENTA_BELCE")
public class EstimadosDeVentaBelcenterLocal implements Serializable {

	public EstimadosDeVentaBelcenterLocal() {}

	public EstimadosDeVentaBelcenterLocal(Long oid, Long subacceso, Long producto, Long unidadesEstimadas, Integer paginaCatalogo, BigDecimal precioCatalogo, BigDecimal costeEstandar, Long tipoOferta, Long cicloVida, Long monedaTransaccion, Long condicionPromocion, Long catalogo, Long periodo, Long argumentoVenta, Long estrategia) {
                this.oid = oid;
                this.subacceso = subacceso;
                this.producto = producto;
                this.unidadesEstimadas = unidadesEstimadas;
                this.paginaCatalogo = paginaCatalogo;
                this.precioCatalogo = precioCatalogo;
                this.costeEstandar = costeEstandar;
                this.tipoOferta = tipoOferta;
                this.cicloVida = cicloVida;
                this.monedaTransaccion = monedaTransaccion;
                this.condicionPromocion = condicionPromocion;
                this.catalogo = catalogo;
                this.periodo = periodo;
                this.argumentoVenta = argumentoVenta;
                this.estrategia = estrategia;
	}
        
        public EstimadosDeVentaBelcenterLocal(Long oid, Long subacceso, Long producto, Long unidadesEstimadas, Integer paginaCatalogo, BigDecimal precioCatalogo, BigDecimal costeEstandar, Long tipoOferta, Long cicloVida, Long monedaTransaccion, Long condicionPromocion, Long catalogo, Long periodo, Long argumentoVenta, Long estrategia, Integer posicionPorPagina, BigDecimal valorVenta, BigDecimal precioPosicionamiento, String centro, Boolean indicadorOfertaGenerada, Long formaPagoCabecera) {
                this.oid = oid;
                this.subacceso = subacceso;
                this.producto = producto;
                this.unidadesEstimadas = unidadesEstimadas;
                this.paginaCatalogo = paginaCatalogo;
                this.precioCatalogo = precioCatalogo;
                this.costeEstandar = costeEstandar;
                this.tipoOferta = tipoOferta;
                this.cicloVida = cicloVida;
                this.monedaTransaccion = monedaTransaccion;
                this.condicionPromocion = condicionPromocion;
                this.catalogo = catalogo;
                this.periodo = periodo;
                this.argumentoVenta = argumentoVenta;
                this.estrategia = estrategia;
                this.posicionPorPagina = posicionPorPagina;
                this.valorVenta = valorVenta;
                this.precioPosicionamiento = precioPosicionamiento;
                this.centro = centro;
                this.indicadorOfertaGenerada = indicadorOfertaGenerada;
                this.formaPagoCabecera = formaPagoCabecera;
        }

	@Id
	@Column(name="OID_ESTI")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="NUM_UNID_ESTI")
	private Long unidadesEstimadas;
	@Column(name="NUM_PAGI_CATA")
	private Integer paginaCatalogo;
	@Column(name="VAL_POSI_PAGI")
	private Integer posicionPorPagina;
	@Column(name="VAL_PREC_CATA")
	private java.math.BigDecimal precioCatalogo;
	@Column(name="VAL_VALO_VENT")
	private java.math.BigDecimal valorVenta;
	@Column(name="VAL_PREC_POSI")
	private java.math.BigDecimal precioPosicionamiento;
	@Column(name="VAL_COST_ESTA")
	private java.math.BigDecimal costeEstandar;
	@Column(name="VAL_CNTR")
	private String centro;
	@Column(name="IND_OFER_GENE")
	private Boolean indicadorOfertaGenerada;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long cicloVida;
	@Column(name="MONE_OID_MONE")
	private Long monedaTransaccion;
	@Column(name="CNDP_OID_COND_PROM")
	private Long condicionPromocion;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long formaPagoCabecera;
	@Column(name="OCAT_OID_CATA")
	private Long catalogo;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ARGV_OID_ARGU_VENT")
	private Long argumentoVenta;
	@Column(name="COES_OID_ESTR")
	private Long estrategia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getUnidadesEstimadas() {return unidadesEstimadas;}
      
	public void setUnidadesEstimadas(Long unidadesEstimadas){this.unidadesEstimadas=unidadesEstimadas;}
		
	public Integer getPaginaCatalogo() {return paginaCatalogo;}
      
	public void setPaginaCatalogo(Integer paginaCatalogo){this.paginaCatalogo=paginaCatalogo;}
		
	public Integer getPosicionPorPagina() {return posicionPorPagina;}
      
	public void setPosicionPorPagina(Integer posicionPorPagina){this.posicionPorPagina=posicionPorPagina;}
		
	public java.math.BigDecimal getPrecioCatalogo() {return precioCatalogo;}
      
	public void setPrecioCatalogo(java.math.BigDecimal precioCatalogo){this.precioCatalogo=precioCatalogo;}
		
	public java.math.BigDecimal getValorVenta() {return valorVenta;}
      
	public void setValorVenta(java.math.BigDecimal valorVenta){this.valorVenta=valorVenta;}
		
	public java.math.BigDecimal getPrecioPosicionamiento() {return precioPosicionamiento;}
      
	public void setPrecioPosicionamiento(java.math.BigDecimal precioPosicionamiento){this.precioPosicionamiento=precioPosicionamiento;}
		
	public java.math.BigDecimal getCosteEstandar() {return costeEstandar;}
      
	public void setCosteEstandar(java.math.BigDecimal costeEstandar){this.costeEstandar=costeEstandar;}
		
	public String getCentro() {return centro;}
      
	public void setCentro(String centro){this.centro=centro;}
		
	public Boolean getIndicadorOfertaGenerada() {return indicadorOfertaGenerada;}
      
	public void setIndicadorOfertaGenerada(Boolean indicadorOfertaGenerada){this.indicadorOfertaGenerada=indicadorOfertaGenerada;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getCicloVida() {return cicloVida;}
      
	public void setCicloVida(Long cicloVida){this.cicloVida=cicloVida;}
		
	public Long getMonedaTransaccion() {return monedaTransaccion;}
      
	public void setMonedaTransaccion(Long monedaTransaccion){this.monedaTransaccion=monedaTransaccion;}
		
	public Long getCondicionPromocion() {return condicionPromocion;}
      
	public void setCondicionPromocion(Long condicionPromocion){this.condicionPromocion=condicionPromocion;}
		
	public Long getFormaPagoCabecera() {return formaPagoCabecera;}
      
	public void setFormaPagoCabecera(Long formaPagoCabecera){this.formaPagoCabecera=formaPagoCabecera;}
		
	public Long getCatalogo() {return catalogo;}
      
	public void setCatalogo(Long catalogo){this.catalogo=catalogo;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getArgumentoVenta() {return argumentoVenta;}
      
	public void setArgumentoVenta(Long argumentoVenta){this.argumentoVenta=argumentoVenta;}
		
	public Long getEstrategia() {return estrategia;}
      
	public void setEstrategia(Long estrategia){this.estrategia=estrategia;}
			
	
}
