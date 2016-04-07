package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="INT_RECEP_VENTA_ASOCI")
@NamedQueries({
@NamedQuery(name="RecepcionVentasAsociadasLocal.FindAll",query="select object(o) from RecepcionVentasAsociadasLocal o"),
@NamedQuery(name="RecepcionVentasAsociadasLocal.FindByUK",query="SELECT OBJECT(O) FROM RecepcionVentasAsociadasLocal o WHERE o.consultora = ?1 AND o.numeroLote = ?2")
})
public class RecepcionVentasAsociadasLocal implements Serializable {

	public RecepcionVentasAsociadasLocal() {}

	public RecepcionVentasAsociadasLocal(Long oid, Long numeroLote, Date fechaOrdenInternet, Long consultora, Long canal, Long marca, Long sociedad) {
            this.oid=oid;
	    this.numeroLote=numeroLote;
	    this.fechaOrdenInternet=fechaOrdenInternet;
	    this.consultora=consultora;
	    this.canal=canal;
	    this.marca=marca;
	    this.sociedad=sociedad;
	}

	@Id
	@Column(name="OID_RECE_VENT_ASOC")
	private Long oid;
	@Column(name="NUM_LOTE")
	private Long numeroLote;
        //@Temporal(TemporalType.DATE)
	@Column(name="FEC_ORDE_INTE")
	private Date fechaOrdenInternet;
	@Column(name="COD_INTE")
	private String codigoInterfaz;
	@Column(name="VAL_IDEN_PLAT_INTE")
	private Long identEnPlataformaIn;
	@Column(name="IMP_VENT_INTE")
	private BigDecimal importeVentaInternet;
	@Column(name="IMP_ABON_CONS")
	private BigDecimal importeAbonoConsultora;
	@Column(name="IND_GENE_PUNT")
	private Boolean indGeneroPuntos;
	@Column(name="NUM_PUNT")
	private Long numeroPunto;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;
	@Column(name="CANA_OID_CANA")
	private Long canal;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="SOCI_OID_SOCI")
	private Long sociedad;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroLote() {return numeroLote;}
      
	public void setNumeroLote(Long numeroLote){this.numeroLote=numeroLote;}
		
	public Date getFechaOrdenInternet() {return fechaOrdenInternet;}
      
	public void setFechaOrdenInternet(Date fechaOrdenInternet){this.fechaOrdenInternet=fechaOrdenInternet;}
		
	public String getCodigoInterfaz() {return codigoInterfaz;}
      
	public void setCodigoInterfaz(String codigoInterfaz){this.codigoInterfaz=codigoInterfaz;}
		
	public Long getIdentEnPlataformaIn() {return identEnPlataformaIn;}
      
	public void setIdentEnPlataformaIn(Long identEnPlataformaIn){this.identEnPlataformaIn=identEnPlataformaIn;}
		
	public BigDecimal getImporteVentaInternet() {return importeVentaInternet;}
      
	public void setImporteVentaInternet(BigDecimal importeVentaInternet){this.importeVentaInternet=importeVentaInternet;}
		
	public BigDecimal getImporteAbonoConsultora() {return importeAbonoConsultora;}
      
	public void setImporteAbonoConsultora(BigDecimal importeAbonoConsultora){this.importeAbonoConsultora=importeAbonoConsultora;}
		
	public Boolean getIndGeneroPuntos() {return indGeneroPuntos;}
      
	public void setIndGeneroPuntos(Boolean indGeneroPuntos){this.indGeneroPuntos=indGeneroPuntos;}
		
	public Long getNumeroPunto() {return numeroPunto;}
      
	public void setNumeroPunto(Long numeroPunto){this.numeroPunto=numeroPunto;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Long getSociedad() {return sociedad;}
      
	public void setSociedad(Long sociedad){this.sociedad=sociedad;}
			
	
}
