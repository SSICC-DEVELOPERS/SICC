package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_EXIGE_CUMPL")
@NamedQueries({
@NamedQuery(name="ExigenciasCumplidasLocal.FindAll",query="select object(o) from ExigenciasCumplidasLocal o"),
@NamedQuery(name="ExigenciasCumplidasLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM ExigenciasCumplidasLocal AS a "
+ " WHERE a.consultora = ?1 "
+ " AND a.concurso = ?2 "
+ " AND a.periodo = ?3"),
@NamedQuery(name="ExigenciasCumplidasLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM ExigenciasCumplidasLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class ExigenciasCumplidasLocal implements Serializable {

	public ExigenciasCumplidasLocal() {}

	public ExigenciasCumplidasLocal(Long oid, Boolean indExigCump, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri)	{
	
		this.oid=oid;
                this.setExigenciasCumplidas(indExigCump);
	        this.setConcurso(copaOidParaGral);
	        this.setConsultora(clieOidClie);
	        this.setPeriodo(perdOidPeri);
	
	}

	@Id
	@Column(name="OID_EXIG_CUMP")
	private Long oid;
	@Column(name="FEC_CUMP")
	private java.sql.Date fechaCumplimiento;
	@Column(name="IND_EXIG_CUMP")
	private Boolean exigenciasCumplidas;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="CLIE_OID_CLIE")
	private Long consultora;
	@Column(name="PERD_OID_PERI")
	private Long periodo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Date getFechaCumplimiento() {return fechaCumplimiento;}
      
	public void setFechaCumplimiento(java.sql.Date fechaCumplimiento){this.fechaCumplimiento=fechaCumplimiento;}
		
	public Boolean getExigenciasCumplidas() {return exigenciasCumplidas;}
      
	public void setExigenciasCumplidas(Boolean exigenciasCumplidas){this.exigenciasCumplidas=exigenciasCumplidas;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getConsultora() {return consultora;}
      
	public void setConsultora(Long consultora){this.consultora=consultora;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
			
	
}
