package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_SOLIC_CONCU_PUNTA")
@NamedQueries({
@NamedQuery(name="SolicitudConcursoPuntajeLocal.FindAll",query="select object(o) from SolicitudConcursoPuntajeLocal o"),
@NamedQuery(name="SolicitudConcursoPuntajeLocal.FindByUK",query="SELECT OBJECT(o) FROM SolicitudConcursoPuntajeLocal AS o "
+ " WHERE o.concurso = ?1 AND "
+ " o.periodo = ?2 AND "
+ " o.solicitud = ?3 AND "
+ " o.consultora = ?4 AND "
+ " o.gerente IS NULL"),
@NamedQuery(name="SolicitudConcursoPuntajeLocal.FindByUKGerente",query="SELECT OBJECT(o) FROM SolicitudConcursoPuntajeLocal AS o "
+ " WHERE o.concurso = ?1 AND "
+ " o.periodo = ?2 AND "
+ " o.solicitud = ?3 AND "
+ " o.consultora = ?4 AND "
+ " o.gerente = ?5"),
@NamedQuery(name="SolicitudConcursoPuntajeLocal.FindByConcurso",query="SELECT OBJECT(o) FROM SolicitudConcursoPuntajeLocal AS o "
+ " WHERE o.concurso = ?1")
})
public class SolicitudConcursoPuntajeLocal implements Serializable {

	public SolicitudConcursoPuntajeLocal() {}

	public SolicitudConcursoPuntajeLocal(Long oid, Long copaOidParaGral, Long socaOidSoliCabe, Long perdOidPeri, Long clieOidClie, Long gerente)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setSolicitud(socaOidSoliCabe);
	        this.setPeriodo(perdOidPeri);
	        this.setConsultora(clieOidClie);
	        this.setGerente(gerente);
	
	}

	@Id
	@Column(name="OID_SOLI_CONC_PUNT")
	private Long oid;
	@Column(name="NUM_PUNT")
	private Integer numeroPuntos;
	@Column(name="VAL_PUNT_BONI")
	private Integer puntajeBonificacion;
	@Column(name="VAL_PUNT_FALT_NANU")
	private Integer puntajeFaltantesNoAnunciados;
	@Column(name="FEC_DOCU")
	private java.sql.Date fechaDocumento;
	@Column(name="IND_ANUL")
	private Boolean anulada;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long solicitud;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;
	@Column(name="IMP_MONT")
	private java.math.BigDecimal monto;
	@Column(name="NUM_UNID")
	private Integer unidades;
	@Column(name="CLIE_OID_CLIE_GERE")
	private Long gerente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPuntos() {return numeroPuntos;}
      
	public void setNumeroPuntos(Integer numeroPuntos){this.numeroPuntos=numeroPuntos;}
		
	public Integer getPuntajeBonificacion() {return puntajeBonificacion;}
      
	public void setPuntajeBonificacion(Integer puntajeBonificacion){this.puntajeBonificacion=puntajeBonificacion;}
		
	public Integer getPuntajeFaltantesNoAnunciados() {return puntajeFaltantesNoAnunciados;}
      
	public void setPuntajeFaltantesNoAnunciados(Integer puntajeFaltantesNoAnunciados){this.puntajeFaltantesNoAnunciados=puntajeFaltantesNoAnunciados;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public Boolean getAnulada() {return anulada;}
      
	public void setAnulada(Boolean anulada){this.anulada=anulada;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getSolicitud() {return solicitud;}
      
	public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
		
	public java.math.BigDecimal getMonto() {return monto;}
      
	public void setMonto(java.math.BigDecimal monto){this.monto=monto;}
		
	public Integer getUnidades() {return unidades;}
      
	public void setUnidades(Integer unidades){this.unidades=unidades;}
		
	public Long getGerente() {return gerente;}
      
	public void setGerente(Long gerente){this.gerente=gerente;}
			
	
}
