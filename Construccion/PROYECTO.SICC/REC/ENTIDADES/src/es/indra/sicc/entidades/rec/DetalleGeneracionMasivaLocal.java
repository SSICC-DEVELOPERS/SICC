package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="REC_DETAL_GENER_MASIV")
@NamedQueries({
@NamedQuery(name="DetalleGeneracionMasivaLocal.FindAll",query="select object(o) from DetalleGeneracionMasivaLocal o"),
@NamedQuery(name="DetalleGeneracionMasivaLocal.FindByUK",query="SELECT OBJECT(s) FROM DetalleGeneracionMasivaLocal s WHERE s.cliente = ?1 AND s.numeroSolicitud =?2 AND s.numeroGeneracion =?3 AND s.tipoSolicitud = ?4")
})
public class DetalleGeneracionMasivaLocal implements Serializable {

	public DetalleGeneracionMasivaLocal() {}

	public DetalleGeneracionMasivaLocal(Long oid, Long numeroGeneracion, Long numeroSolicitud, Long cliente, Long tipoSolicitud)	{
	
		this.oid=oid;
                this.numeroGeneracion=numeroGeneracion;
                this.numeroSolicitud=numeroSolicitud;
                this.cliente=cliente;
                this.tipoSolicitud=tipoSolicitud;
	
	}

	@Id
	@Column(name="OID_DETA_GENE_MASI")
	private Long oid;
	@Column(name="NUM_DOCU_REFE")
	private Long numeroDocumentoReferencia;
	@Column(name="NUM_UNID")
	private Integer numeroUnidades;
	@Column(name="IMP_PREC_CATA_ORIG")
	private BigDecimal precioCatalogoOrigen;
	@Column(name="IMP_NETO_ORIG")
	private BigDecimal importeNetoOrigen;
	@Column(name="IMP_PREC_CATA_DEST")
	private BigDecimal precioCatalogoDestino;
	@Column(name="IMP_NETO_DEST")
	private BigDecimal importeNetoDestino;
	@Column(name="IMP_DIFE")
	private BigDecimal importeDiferencia;
	@Column(name="IND_SELE")
	private Boolean indicativoSeleccion;
	@Column(name="NUM_ATEN")
	private Long numeroAtencion;
	@Column(name="CAGM_OID_CABE_GENE_MASI")
	private Long numeroGeneracion;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long numeroSolicitud;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumentoReferencia;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroDocumentoReferencia() {return numeroDocumentoReferencia;}
      
	public void setNumeroDocumentoReferencia(Long numeroDocumentoReferencia){this.numeroDocumentoReferencia=numeroDocumentoReferencia;}
		
	public Integer getNumeroUnidades() {return numeroUnidades;}
      
	public void setNumeroUnidades(Integer numeroUnidades){this.numeroUnidades=numeroUnidades;}
		
	public BigDecimal getPrecioCatalogoOrigen() {return precioCatalogoOrigen;}
      
	public void setPrecioCatalogoOrigen(BigDecimal precioCatalogoOrigen){this.precioCatalogoOrigen=precioCatalogoOrigen;}
		
	public BigDecimal getImporteNetoOrigen() {return importeNetoOrigen;}
      
	public void setImporteNetoOrigen(BigDecimal importeNetoOrigen){this.importeNetoOrigen=importeNetoOrigen;}
		
	public BigDecimal getPrecioCatalogoDestino() {return precioCatalogoDestino;}
      
	public void setPrecioCatalogoDestino(BigDecimal precioCatalogoDestino){this.precioCatalogoDestino=precioCatalogoDestino;}
		
	public BigDecimal getImporteNetoDestino() {return importeNetoDestino;}
      
	public void setImporteNetoDestino(BigDecimal importeNetoDestino){this.importeNetoDestino=importeNetoDestino;}
		
	public BigDecimal getImporteDiferencia() {return importeDiferencia;}
      
	public void setImporteDiferencia(BigDecimal importeDiferencia){this.importeDiferencia=importeDiferencia;}
		
	public Boolean getIndicativoSeleccion() {return indicativoSeleccion;}
      
	public void setIndicativoSeleccion(Boolean indicativoSeleccion){this.indicativoSeleccion=indicativoSeleccion;}
		
	public Long getNumeroAtencion() {return numeroAtencion;}
      
	public void setNumeroAtencion(Long numeroAtencion){this.numeroAtencion=numeroAtencion;}
		
	public Long getNumeroGeneracion() {return numeroGeneracion;}
      
	public void setNumeroGeneracion(Long numeroGeneracion){this.numeroGeneracion=numeroGeneracion;}
		
	public Long getNumeroSolicitud() {return numeroSolicitud;}
      
	public void setNumeroSolicitud(Long numeroSolicitud){this.numeroSolicitud=numeroSolicitud;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getTipoDocumentoReferencia() {return tipoDocumentoReferencia;}
      
	public void setTipoDocumentoReferencia(Long tipoDocumentoReferencia){this.tipoDocumentoReferencia=tipoDocumentoReferencia;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
			
	
}
