package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="PRE_DETAL_OFERT_PRECI")
@NamedQueries({
@NamedQuery(name="DetalleOfertaPrecioLocal.FindAll",query="select object(o) from DetalleOfertaPrecioLocal o"),
@NamedQuery(name="DetalleOfertaPrecioLocal.FindByOidDetalle",query="SELECT OBJECT(a) "
+" FROM DetalleOfertaPrecioLocal AS a WHERE a.oidDetaOfer = ?1")
})
public class DetalleOfertaPrecioLocal implements Serializable {

	public DetalleOfertaPrecioLocal() {}

	public DetalleOfertaPrecioLocal(Long oid, Long numOrdeRang, Long numUnidDesd, Long numUnidHast, BigDecimal valPrecCata, BigDecimal valPrecPosi, Long ofdeOidDetaOfer) {
	
		this.oid=oid;
                this.numeroOrdenRango=numOrdeRang;
                this.rangoDesde=numUnidDesd;
                this.rangoHasta=numUnidHast;
                this.precioCatalogo=valPrecCata;
                this.precioPosicionamiento=valPrecPosi;
                this.oidDetaOfer=ofdeOidDetaOfer;
	
	}

	@Id
	@Column(name="OID_DETA_OFER_PREC")
	private Long oid;
	@Column(name="NUM_ORDE_RANG")
	private Long numeroOrdenRango;
	@Column(name="NUM_UNID_DESD")
	private Long rangoDesde;
	@Column(name="NUM_UNID_HAST")
	private Long rangoHasta;
	@Column(name="VAL_PREC_CATA")
	private java.math.BigDecimal precioCatalogo;
	@Column(name="VAL_PREC_POSI")
	private java.math.BigDecimal precioPosicionamiento;
	@Column(name="OFDE_OID_DETA_OFER")
	private Long oidDetaOfer;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroOrdenRango() {return numeroOrdenRango;}
      
	public void setNumeroOrdenRango(Long numeroOrdenRango){this.numeroOrdenRango=numeroOrdenRango;}
		
	public Long getRangoDesde() {return rangoDesde;}
      
	public void setRangoDesde(Long rangoDesde){this.rangoDesde=rangoDesde;}
		
	public Long getRangoHasta() {return rangoHasta;}
      
	public void setRangoHasta(Long rangoHasta){this.rangoHasta=rangoHasta;}
		
	public java.math.BigDecimal getPrecioCatalogo() {return precioCatalogo;}
      
	public void setPrecioCatalogo(java.math.BigDecimal precioCatalogo){this.precioCatalogo=precioCatalogo;}
		
	public java.math.BigDecimal getPrecioPosicionamiento() {return precioPosicionamiento;}
      
	public void setPrecioPosicionamiento(java.math.BigDecimal precioPosicionamiento){this.precioPosicionamiento=precioPosicionamiento;}
		
	public Long getOidDetaOfer() {return oidDetaOfer;}
      
	public void setOidDetaOfer(Long oidDetaOfer){this.oidDetaOfer=oidDetaOfer;}
			
	
}
