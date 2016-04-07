package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="BEL_MOVIM_ALMAC_DETAL")
@NamedQueries({
@NamedQuery(name="MovimientosAlmacenDetalleLocal.FindByOperacion",query="SELECT OBJECT(m) FROM MovimientosAlmacenDetalleLocal m WHERE m.movimientoAlmacenCabecera=?1 AND m.operacionReferencia=?2"),
@NamedQuery(name="MovimientosAlmacenDetalleLocal.FindByOperacionNumLinea",query="SELECT OBJECT(m) FROM MovimientosAlmacenDetalleLocal m WHERE m.movimientoAlmacenCabecera=?1 AND m.numeroLinea=?2 AND m.operacionReferencia=?3")
})
public class MovimientosAlmacenDetalleLocal implements Serializable {

	public MovimientosAlmacenDetalleLocal() {}

	public MovimientosAlmacenDetalleLocal(Long oid, Long movimientoAlmacenCabecera, Integer numeroLinea, Long cantidad, Long tipoMovimientoAlmacen, Long producto, Long operacionReferencia, Long almacenSalida, Long numeroMovimiento)	{
		this.oid=oid;
                this.movimientoAlmacenCabecera = movimientoAlmacenCabecera;
                this.numeroLinea = numeroLinea;
                this.cantidad = cantidad;
                this.tipoMovimientoAlmacen = tipoMovimientoAlmacen;
                this.producto = producto;
                this.operacionReferencia = operacionReferencia;
                this.almacenSalida = almacenSalida;
                this.nMovimiento = numeroMovimiento;
	}

        public MovimientosAlmacenDetalleLocal(Long oid, Long movimientoAlmacenCabecera, Integer numeroLinea,  Long cantidad, Long tipoMovimientoAlmacen, Long producto, Long operacionReferencia, Long almacenSalida, BigDecimal precioVentaNeto, BigDecimal precioContable, Long numeroDocumentoReferencia, Integer numeroPosicionReferencia, Long almacenEntrada, Long numeroMovimiento, Long tipoOferta) {
                    this.oid=oid;
                    this.movimientoAlmacenCabecera = movimientoAlmacenCabecera;
                    this.numeroLinea = numeroLinea;
                    this.cantidad = cantidad;
                    this.tipoMovimientoAlmacen = tipoMovimientoAlmacen;
                    this.producto = producto;
                    this.operacionReferencia = operacionReferencia;
                    this.almacenSalida = almacenSalida;
                    this.precioVentaNeto = precioVentaNeto;
                    this.precioContable = precioContable;
                    this.numeroDocumentoReferencia = numeroDocumentoReferencia;
                    this.numeroPosicionReferencia = numeroPosicionReferencia;
                    this.almacenEntrada = almacenEntrada;
                    this.nMovimiento = numeroMovimiento;
                    this.tipoOferta = tipoOferta;
        }



	@Id
	@Column(name="OID_DETA")
	private Long oid;
	@Column(name="MVAL_OID_MOVI_ALMA")
	private Long movimientoAlmacenCabecera;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="VAL_CANT")
	private Long cantidad;
	@Column(name="VAL_PREC_VENT_NETO")
	private java.math.BigDecimal precioVentaNeto;
	@Column(name="VAL_PREC_CONT")
	private java.math.BigDecimal precioContable;
	@Column(name="NUM_DOCU_REFE")
	private Long numeroDocumentoReferencia;
	@Column(name="NUM_POSI_REFE")
	private Integer numeroPosicionReferencia;
	@Column(name="TMAL_OID_TIPO_MOVI_ALMA")
	private Long tipoMovimientoAlmacen;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="OPER_OID_OPER")
	private Long operacionReferencia;
	@Column(name="ALMC_OID_ALMA_ENTR")
	private Long almacenEntrada;
	@Column(name="ALMC_OID_ALMA_SALI")
	private Long almacenSalida;
	@Column(name="N_MOVIMIENTO")
	private Long nMovimiento;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long tipoOferta;
	@Column(name="NUM_LOTE_SAPM")
	private Long numeroLoteSAP;
	@Column(name="TPOS_OID_TIPO_POSI")
	private Long tipoPosicion;
	@Column(name="STPO_OID_SUBT_POSI")
	private Long subtipoPosicion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMovimientoAlmacenCabecera() {return movimientoAlmacenCabecera;}
      
	public void setMovimientoAlmacenCabecera(Long movimientoAlmacenCabecera){this.movimientoAlmacenCabecera=movimientoAlmacenCabecera;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public Long getCantidad() {return cantidad;}
      
	public void setCantidad(Long cantidad){this.cantidad=cantidad;}
		
	public java.math.BigDecimal getPrecioVentaNeto() {return precioVentaNeto;}
      
	public void setPrecioVentaNeto(java.math.BigDecimal precioVentaNeto){this.precioVentaNeto=precioVentaNeto;}
		
	public java.math.BigDecimal getPrecioContable() {return precioContable;}
      
	public void setPrecioContable(java.math.BigDecimal precioContable){this.precioContable=precioContable;}
		
	public Long getNumeroDocumentoReferencia() {return numeroDocumentoReferencia;}
      
	public void setNumeroDocumentoReferencia(Long numeroDocumentoReferencia){this.numeroDocumentoReferencia=numeroDocumentoReferencia;}
		
	public Integer getNumeroPosicionReferencia() {return numeroPosicionReferencia;}
      
	public void setNumeroPosicionReferencia(Integer numeroPosicionReferencia){this.numeroPosicionReferencia=numeroPosicionReferencia;}
		
	public Long getTipoMovimientoAlmacen() {return tipoMovimientoAlmacen;}
      
	public void setTipoMovimientoAlmacen(Long tipoMovimientoAlmacen){this.tipoMovimientoAlmacen=tipoMovimientoAlmacen;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getOperacionReferencia() {return operacionReferencia;}
      
	public void setOperacionReferencia(Long operacionReferencia){this.operacionReferencia=operacionReferencia;}
		
	public Long getAlmacenEntrada() {return almacenEntrada;}
      
	public void setAlmacenEntrada(Long almacenEntrada){this.almacenEntrada=almacenEntrada;}
		
	public Long getAlmacenSalida() {return almacenSalida;}
      
	public void setAlmacenSalida(Long almacenSalida){this.almacenSalida=almacenSalida;}
		
	public Long getNMovimiento() {return nMovimiento;}
      
	public void setNMovimiento(Long nMovimiento){this.nMovimiento=nMovimiento;}
		
	public Long getTipoOferta() {return tipoOferta;}
      
	public void setTipoOferta(Long tipoOferta){this.tipoOferta=tipoOferta;}
		
	public Long getNumeroLoteSAP() {return numeroLoteSAP;}
      
	public void setNumeroLoteSAP(Long numeroLoteSAP){this.numeroLoteSAP=numeroLoteSAP;}
		
	public Long getTipoPosicion() {return tipoPosicion;}
      
	public void setTipoPosicion(Long tipoPosicion){this.tipoPosicion=tipoPosicion;}
		
	public Long getSubtipoPosicion() {return subtipoPosicion;}
      
	public void setSubtipoPosicion(Long subtipoPosicion){this.subtipoPosicion=subtipoPosicion;}
			
	
}
