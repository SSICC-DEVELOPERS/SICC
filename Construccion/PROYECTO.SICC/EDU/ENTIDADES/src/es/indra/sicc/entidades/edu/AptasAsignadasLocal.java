package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_APTAS_ASIGN")
@NamedQueries({
@NamedQuery(name="AptasAsignadasLocal.FindfindByCurso",query="SELECT OBJECT(a) FROM AptasAsignadasLocal AS a WHERE a.curso=?1")
})
public class AptasAsignadasLocal implements Serializable {

	public AptasAsignadasLocal() {}

	public AptasAsignadasLocal(Long oid, Integer numConvocatoria, Long cliente, Long curso, Long subtipo, Boolean apta, Boolean dataMart)	{
	
		this.oid=oid;
                this.numConvocatoria=numConvocatoria;
                this.cliente=cliente;
                this.curso=curso; //N Incidencia:   BELC300006978 
                this.subtipo=subtipo;
                this.apta=apta;
                this.dataMart=dataMart;                
	
	}

	@Id
	@Column(name="OID_APTA_ASIG")
	private Long oid;
	@Column(name="NUM_CONV")
	private Integer numConvocatoria;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="ASAP_OID_ASIG")
	private Long curso;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subtipo;
	@Column(name="IND_APTA")
	private Boolean apta;
	@Column(name="IND_DATA_MART")
	private Boolean dataMart;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumConvocatoria() {return numConvocatoria;}
      
	public void setNumConvocatoria(Integer numConvocatoria){this.numConvocatoria=numConvocatoria;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getCurso() {return curso;}
      
	public void setCurso(Long curso){this.curso=curso;}
		
	public Long getSubtipo() {return subtipo;}
      
	public void setSubtipo(Long subtipo){this.subtipo=subtipo;}
		
	public Boolean getApta() {return apta;}
      
	public void setApta(Boolean apta){this.apta=apta;}
		
	public Boolean getDataMart() {return dataMart;}
      
	public void setDataMart(Boolean dataMart){this.dataMart=dataMart;}
			
	
}
