package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BEL_MOVIM_CAJA_DETAL")
public class MovimientosDeCajaDetalleLocal implements Serializable {

	public MovimientosDeCajaDetalleLocal() {}

        public MovimientosDeCajaDetalleLocal(Long oid, Long movimientoDeCajaCabecera, Long medioPagoBelcenter, Integer numeroLinea, Long tipoMovimientoCaja)  {
                this.oid=oid;
                this.movimientoDeCajaCabecera = movimientoDeCajaCabecera;
                this.medioPagoBelcenter = medioPagoBelcenter;
                this.numeroLinea = numeroLinea;
                this.tipoMovimientoCaja= tipoMovimientoCaja;
        }


	public MovimientosDeCajaDetalleLocal(Long oid, Long movimientoDeCajaCabecera, Long medioPagoBelcenter, Integer numeroLinea,  Long tipoMovimientoCaja, BigDecimal importe, BigDecimal diferenciaVuelto, BigDecimal importeDivisa, String numeroCheque,  String numeroTarjeta, String numeroValeCompra, Long tipoTarjeta, Long monedaAlternativa, Timestamp fecha)	{
		this.oid=oid;
                this.movimientoDeCajaCabecera = movimientoDeCajaCabecera;
                this.medioPagoBelcenter = medioPagoBelcenter;
                this.numeroLinea = numeroLinea;
                this.tipoMovimientoCaja= tipoMovimientoCaja;
                this.importe = importe;
                this.diferenciaVuelto = diferenciaVuelto;
                this.importeDivisa = importeDivisa;
                this.numeroCheque = numeroCheque;
                this.numeroTarjeta = numeroTarjeta;
                this.numeroValeCompra = numeroValeCompra;
                this.tipoTarjeta = tipoTarjeta;
                this.monedaAlternativa = monedaAlternativa;
                this.fecha = fecha;
	}
        

	@Id
	@Column(name="OID_DETA")
	private Long oid;
	@Column(name="MCAC_OID_CABE")
	private Long movimientoDeCajaCabecera;
	@Column(name="MPBC_OID_MEDI_PAGO_BELC")
	private Long medioPagoBelcenter;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;
	@Column(name="IMP_MOVI")
	private java.math.BigDecimal importe;
	@Column(name="IMP_VUEL")
	private java.math.BigDecimal diferenciaVuelto;
	@Column(name="IMP_DIVI")
	private java.math.BigDecimal importeDivisa;
	@Column(name="NUM_CHEQE")
	private String numeroCheque;
	@Column(name="NUM_TARJ")
	private String numeroTarjeta;
	@Column(name="NUM_VALE_COMP")
	private String numeroValeCompra;
	@Column(name="FEC_MOVI")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fecha;
	@Column(name="TITR_OID_TIPO_TARJ")
	private Long tipoTarjeta;
	@Column(name="MONE_OID_MONE")
	private Long monedaAlternativa;
	@Column(name="TMVC_OID_TIPO_MOVI_CAJA")
	private Long tipoMovimientoCaja;
	@Column(name="CBAN_OID_BANC")
	private Long oidBanco;
	@Column(name="MCAD_OID_DETA")
	private Long oidMovimientoDeCajaDetalleOrigen;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidSolicitudCabecera;
	@Column(name="SOCA_OID_SOLI_CABE_NOTA")
	private Long oidSolicitudCabeceraNota;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMovimientoDeCajaCabecera() {return movimientoDeCajaCabecera;}
      
	public void setMovimientoDeCajaCabecera(Long movimientoDeCajaCabecera){this.movimientoDeCajaCabecera=movimientoDeCajaCabecera;}
		
	public Long getMedioPagoBelcenter() {return medioPagoBelcenter;}
      
	public void setMedioPagoBelcenter(Long medioPagoBelcenter){this.medioPagoBelcenter=medioPagoBelcenter;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public java.math.BigDecimal getDiferenciaVuelto() {return diferenciaVuelto;}
      
	public void setDiferenciaVuelto(java.math.BigDecimal diferenciaVuelto){this.diferenciaVuelto=diferenciaVuelto;}
		
	public java.math.BigDecimal getImporteDivisa() {return importeDivisa;}
      
	public void setImporteDivisa(java.math.BigDecimal importeDivisa){this.importeDivisa=importeDivisa;}
		
	public String getNumeroCheque() {return numeroCheque;}
      
	public void setNumeroCheque(String numeroCheque){this.numeroCheque=numeroCheque;}
		
	public String getNumeroTarjeta() {return numeroTarjeta;}
      
	public void setNumeroTarjeta(String numeroTarjeta){this.numeroTarjeta=numeroTarjeta;}
		
	public String getNumeroValeCompra() {return numeroValeCompra;}
      
	public void setNumeroValeCompra(String numeroValeCompra){this.numeroValeCompra=numeroValeCompra;}
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public Long getTipoTarjeta() {return tipoTarjeta;}
      
	public void setTipoTarjeta(Long tipoTarjeta){this.tipoTarjeta=tipoTarjeta;}
		
	public Long getMonedaAlternativa() {return monedaAlternativa;}
      
	public void setMonedaAlternativa(Long monedaAlternativa){this.monedaAlternativa=monedaAlternativa;}
		
	public Long getTipoMovimientoCaja() {return tipoMovimientoCaja;}
      
	public void setTipoMovimientoCaja(Long tipoMovimientoCaja){this.tipoMovimientoCaja=tipoMovimientoCaja;}
		
	public Long getOidBanco() {return oidBanco;}
      
	public void setOidBanco(Long oidBanco){this.oidBanco=oidBanco;}
		
	public Long getOidMovimientoDeCajaDetalleOrigen() {return oidMovimientoDeCajaDetalleOrigen;}
      
	public void setOidMovimientoDeCajaDetalleOrigen(Long oidMovimientoDeCajaDetalleOrigen){this.oidMovimientoDeCajaDetalleOrigen=oidMovimientoDeCajaDetalleOrigen;}
		
	public Long getOidSolicitudCabecera() {return oidSolicitudCabecera;}
      
	public void setOidSolicitudCabecera(Long oidSolicitudCabecera){this.oidSolicitudCabecera=oidSolicitudCabecera;}
		
	public Long getOidSolicitudCabeceraNota() {return oidSolicitudCabeceraNota;}
      
	public void setOidSolicitudCabeceraNota(Long oidSolicitudCabeceraNota){this.oidSolicitudCabeceraNota=oidSolicitudCabeceraNota;}
			
	
}
