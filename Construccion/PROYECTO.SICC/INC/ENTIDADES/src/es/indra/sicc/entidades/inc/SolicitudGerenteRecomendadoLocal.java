package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_SOLIC_GEREN_RECOM")
@NamedQueries({
@NamedQuery(name="SolicitudGerenteRecomendadoLocal.FindAll",query="select object(o) from SolicitudGerenteRecomendadoLocal o"),
@NamedQuery(name="SolicitudGerenteRecomendadoLocal.FindByClienteGerente",query="SELECT OBJECT(a) "
+ " FROM SolicitudGerenteRecomendadoLocal "
+ " AS a WHERE a.oidClienteGerente = ?1 "
+ " AND a.oidCliente = ?2 "
+ " AND a.oidConcurso = ?3 "
+ " AND a.oidSolicitud = ?4")
})
public class SolicitudGerenteRecomendadoLocal implements Serializable {

	public SolicitudGerenteRecomendadoLocal() {}

	public SolicitudGerenteRecomendadoLocal(Long oid, Long clieOidClie, Long clieOidClieGere, Long socaOidSoliCabe, Long copaOidParaGral, Long perdOidPeri)	{
	
		this.oid=oid;
                this.setOidCliente(clieOidClie);
                this.setOidClienteGerente(clieOidClieGere);
                this.setOidSolicitud(socaOidSoliCabe);
                this.setOidConcurso(copaOidParaGral);
                this.setOidPeriodo(perdOidPeri);
	
	}

	@Id
	@Column(name="OID_SOLI_GERE_RECO")
	private Long oid;
	@Column(name="FEC_DOCU")
	private java.sql.Timestamp fechaDocumento;
	@Column(name="IND_SOLI_VALI")
	private Boolean solicitudValida;
	@Column(name="NUM_MONT_SOLI")
	private Double montoSolicitud;
	@Column(name="NUM_UNID_SOLI")
	private Long unidadesSolicitud;
	@Column(name="IND_ANUL")
	private Boolean anulada;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="CLIE_OID_CLIE_GERE")
	private Long oidClienteGerente;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long oidSolicitud;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long oidConcurso;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Timestamp fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Boolean getSolicitudValida() {return solicitudValida;}
      
	public void setSolicitudValida(Boolean solicitudValida){this.solicitudValida=solicitudValida;}
		
	public Double getMontoSolicitud() {return montoSolicitud;}
      
	public void setMontoSolicitud(Double montoSolicitud){this.montoSolicitud=montoSolicitud;}
		
	public Long getUnidadesSolicitud() {return unidadesSolicitud;}
      
	public void setUnidadesSolicitud(Long unidadesSolicitud){this.unidadesSolicitud=unidadesSolicitud;}
		
	public Boolean getAnulada() {return anulada;}
      
	public void setAnulada(Boolean anulada){this.anulada=anulada;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getOidClienteGerente() {return oidClienteGerente;}
      
	public void setOidClienteGerente(Long oidClienteGerente){this.oidClienteGerente=oidClienteGerente;}
		
	public Long getOidSolicitud() {return oidSolicitud;}
      
	public void setOidSolicitud(Long oidSolicitud){this.oidSolicitud=oidSolicitud;}
		
	public Long getOidConcurso() {return oidConcurso;}
      
	public void setOidConcurso(Long oidConcurso){this.oidConcurso=oidConcurso;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
			
	
}
