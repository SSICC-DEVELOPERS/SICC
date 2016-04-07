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
@Table(name="EDU_APTAS_CURSO")
@NamedQueries({
@NamedQuery(name="AptasACursosLocal.FindByCursoPruebas",query="SELECT OBJECT(a) FROM AptasACursosLocal AS a WHERE a.curso=?1 AND a.pruebas=true"),
@NamedQuery(name="AptasACursosLocal.FindByUK",query="SELECT OBJECT(a) FROM AptasACursosLocal AS a WHERE a.curso=?1 AND a.cliente=?2")
})
public class AptasACursosLocal implements Serializable {

	public AptasACursosLocal() {}

	public AptasACursosLocal(Long oid, Long curso, Integer numConvocatoria, Long cliente, Long subtipo)	{
	
		this.oid=oid;
                this.curso=curso;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.subtipo=subtipo;                
	
	}

        public AptasACursosLocal(Long oid, Long curso, Integer numConvocatoria, Long cliente, Long subtipo, Date fechaAsistencia, Boolean dataMart, Boolean apta, Boolean invitadaCurso, Integer asistenciaCurso, Boolean pruebas)     {
        
                this.oid=oid;
                this.curso=curso;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.subtipo=subtipo;
                this.fechaAsistencia=fechaAsistencia;
                this.dataMart=dataMart;
                this.apta=apta;
                this.invitadaCurso=invitadaCurso;
                this.asistenciaCurso=asistenciaCurso;
                this.pruebas=pruebas;                
        
        }

	@Id
	@Column(name="OID_APTA")
	private Long oid;
	@Column(name="MCUR_OID_CURS")
	private Long curso;
	@Column(name="FEC_ASIS")
	private java.sql.Date fechaAsistencia;
	@Column(name="IND_ACCE_DMRT")
	private Boolean dataMart;
	@Column(name="IND_APTA_CURS")
	private Boolean apta;
	@Column(name="IND_INVI")
	private Boolean invitadaCurso;
	@Column(name="IND_ASIS")
	private Integer asistenciaCurso;
	@Column(name="IND_PRUE")
	private Boolean pruebas;
	@Column(name="NUM_CONV")
	private Integer numConvocatoria;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subtipo;
	@Column(name="IND_ENVI")
	private Boolean envio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCurso() {return curso;}
      
	public void setCurso(Long curso){this.curso=curso;}
		
	public java.sql.Date getFechaAsistencia() {return fechaAsistencia;}
      
	public void setFechaAsistencia(java.sql.Date fechaAsistencia){this.fechaAsistencia=fechaAsistencia;}
		
	public Boolean getDataMart() {return dataMart;}
      
	public void setDataMart(Boolean dataMart){this.dataMart=dataMart;}
		
	public Boolean getApta() {return apta;}
      
	public void setApta(Boolean apta){this.apta=apta;}
		
	public Boolean getInvitadaCurso() {return invitadaCurso;}
      
	public void setInvitadaCurso(Boolean invitadaCurso){this.invitadaCurso=invitadaCurso;}
		
	public Integer getAsistenciaCurso() {return asistenciaCurso;}
      
	public void setAsistenciaCurso(Integer asistenciaCurso){this.asistenciaCurso=asistenciaCurso;}
		
	public Boolean getPruebas() {return pruebas;}
      
	public void setPruebas(Boolean pruebas){this.pruebas=pruebas;}
		
	public Integer getNumConvocatoria() {return numConvocatoria;}
      
	public void setNumConvocatoria(Integer numConvocatoria){this.numConvocatoria=numConvocatoria;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getSubtipo() {return subtipo;}
      
	public void setSubtipo(Long subtipo){this.subtipo=subtipo;}
		
	public Boolean getEnvio() {return envio;}
      
	public void setEnvio(Boolean envio){this.envio=envio;}
			
	
}
