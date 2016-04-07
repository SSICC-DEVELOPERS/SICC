package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="EDU_ASIGN_APTAS")
public class AsignaAptasLocal implements Serializable {

	public AsignaAptasLocal() {}

	public AsignaAptasLocal(Long oid, Long curso, Timestamp fecha)	{
	
		this.oid=oid;
                this.curso=curso;
                this.fecha=fecha;                
	
	}

	@Id
	@Column(name="OID_ASIG")
	private Long oid;
	@Column(name="MCUR_OID_CURS")
	private Long curso;
	@Column(name="FEC")
	private java.sql.Timestamp fecha;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCurso() {return curso;}
      
	public void setCurso(Long curso){this.curso=curso;}
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
			
	
}
