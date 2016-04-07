package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_SOLIC_CONCU_RECOM")
@NamedQueries({
@NamedQuery(name="SolicitudConcursoRecomendadasLocal.FindAll",query="select object(o) from SolicitudConcursoRecomendadasLocal o"),
@NamedQuery(name="SolicitudConcursoRecomendadasLocal.FindByUKConGerente",query="SELECT OBJECT(a) "
+ " FROM SolicitudConcursoRecomendadasLocal AS a "
+ " WHERE a.concurso = ?1 "
+ " AND a.solicitud = ?2 "
+ " AND a.gerente = ?3"),
@NamedQuery(name="SolicitudConcursoRecomendadasLocal.FindByUKSinGerente",query="SELECT OBJECT(a) "
+ " FROM SolicitudConcursoRecomendadasLocal AS a "
+ " WHERE a.concurso = ?1 "
+ " AND a.solicitud = ?2 "
+ " AND a.gerente IS NULL"),
@NamedQuery(name="SolicitudConcursoRecomendadasLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM SolicitudConcursoRecomendadasLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class SolicitudConcursoRecomendadasLocal implements Serializable {

	public SolicitudConcursoRecomendadasLocal() {}

	public SolicitudConcursoRecomendadasLocal(Long oid, Long copaOidParaGral, Long socaOidSoliCabe, Long clieOidClie, Long perdOidPeri, Long gerente)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setSolicitud(socaOidSoliCabe);
	        this.setRecomendante(clieOidClie);
	        this.setPeriodo(perdOidPeri);
	        this.setGerente(gerente);
	
	}

	@Id
	@Column(name="OID_SOLI_CONC_RECO")
	private Long oid;
	@Column(name="FEC_DOCU")
	private java.sql.Date fechaDocumento;
	@Column(name="IND_SOLI_VALI")
	private Boolean solicitudValida;
	@Column(name="IMP_MONT_SOLI")
	private java.math.BigDecimal montoSolicitud;
	@Column(name="NUM_UNID_SOLI")
	private Integer unidadesSolicitud;
	@Column(name="IND_ANUL")
	private Boolean anulada;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long solicitud;
	@Column(name="CLIE_OID_CLIE")
	private Long recomendante;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CLIE_OID_RECO_DADO")
	private Long recomendado;
	@Column(name="CLIE_OID_CLIE_GERE")
	private Long gerente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Boolean getSolicitudValida() {return solicitudValida;}
      
	public void setSolicitudValida(Boolean solicitudValida){this.solicitudValida=solicitudValida;}
		
	public java.math.BigDecimal getMontoSolicitud() {return montoSolicitud;}
      
	public void setMontoSolicitud(java.math.BigDecimal montoSolicitud){this.montoSolicitud=montoSolicitud;}
		
	public Integer getUnidadesSolicitud() {return unidadesSolicitud;}
      
	public void setUnidadesSolicitud(Integer unidadesSolicitud){this.unidadesSolicitud=unidadesSolicitud;}
		
	public Boolean getAnulada() {return anulada;}
      
	public void setAnulada(Boolean anulada){this.anulada=anulada;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getSolicitud() {return solicitud;}
      
	public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
		
	public Long getRecomendante() {return recomendante;}
      
	public void setRecomendante(Long recomendante){this.recomendante=recomendante;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getRecomendado() {return recomendado;}
      
	public void setRecomendado(Long recomendado){this.recomendado=recomendado;}
		
	public Long getGerente() {return gerente;}
      
	public void setGerente(Long gerente){this.gerente=gerente;}
			
	
}
