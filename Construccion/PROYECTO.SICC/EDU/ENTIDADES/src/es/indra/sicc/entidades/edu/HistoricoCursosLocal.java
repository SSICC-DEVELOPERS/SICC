package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="EDU_HISTO_CURSO")
public class HistoricoCursosLocal implements Serializable {

	public HistoricoCursosLocal() {}

	public HistoricoCursosLocal(Long oid, Long curso, 
                          Integer numConvocatoria, 
                          Long cliente, 
                          Long subtipo, 
                          Date fechaAsistencia, 
                          Integer asistenciaCurso, 
                          Boolean apta, 
                          Boolean invitadaCurso)	{
	
		this.oid=oid;
                this.curso=curso;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.subtipo=subtipo;
                this.fechaAsistencia=fechaAsistencia;
                this.asistenciaCurso=asistenciaCurso;
                this.apta=apta;
                this.invitadaCurso=invitadaCurso;
	
	}
        
        public HistoricoCursosLocal(Long oid, Long curso, Integer numConvocatoria, Long cliente, 
        Long subtipo, Date fechaAsistencia, Integer asistenciaCurso, Boolean apta, Boolean invitadaCurso, Long nothing) {
        
                this.oid=oid;
                this.curso=curso;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.subtipo=subtipo;
                this.fechaAsistencia=fechaAsistencia;
                this.asistenciaCurso=asistenciaCurso;
                this.apta=apta;
                this.invitadaCurso=invitadaCurso;
        
        }
        
        public HistoricoCursosLocal(Long oid, Long curso, Integer numConvocatoria, 
        Long cliente, Long subtipo, Date fechaAsistencia, Integer asistenciaCurso) {
        
                this.oid=oid;
                this.curso=curso;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.subtipo=subtipo;
                this.fechaAsistencia=fechaAsistencia;
                this.asistenciaCurso=asistenciaCurso;
        
        }        
    
	@Id
	@Column(name="OID_HIST")
	private Long oid;
	@Column(name="MCUR_OID_CURS")
	private Long curso;
	@Column(name="IND_APTA")
	private Boolean apta;
	@Column(name="IND_INVIT")
	private Boolean invitadaCurso;
	@Column(name="NUM_CONV")
	private Integer numConvocatoria;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subtipo;
	@Column(name="FEC_ASIS")
	private java.sql.Date fechaAsistencia;
	@Column(name="IND_ASIS")
	private Integer asistenciaCurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCurso() {return curso;}
      
	public void setCurso(Long curso){this.curso=curso;}
		
	public Boolean getApta() {return apta;}
      
	public void setApta(Boolean apta){this.apta=apta;}
		
	public Boolean getInvitadaCurso() {return invitadaCurso;}
      
	public void setInvitadaCurso(Boolean invitadaCurso){this.invitadaCurso=invitadaCurso;}
		
	public Integer getNumConvocatoria() {return numConvocatoria;}
      
	public void setNumConvocatoria(Integer numConvocatoria){this.numConvocatoria=numConvocatoria;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getSubtipo() {return subtipo;}
      
	public void setSubtipo(Long subtipo){this.subtipo=subtipo;}
		
	public java.sql.Date getFechaAsistencia() {return fechaAsistencia;}
      
	public void setFechaAsistencia(java.sql.Date fechaAsistencia){this.fechaAsistencia=fechaAsistencia;}
		
	public Integer getAsistenciaCurso() {return asistenciaCurso;}
      
	public void setAsistenciaCurso(Integer asistenciaCurso){this.asistenciaCurso=asistenciaCurso;}
			
	
}
