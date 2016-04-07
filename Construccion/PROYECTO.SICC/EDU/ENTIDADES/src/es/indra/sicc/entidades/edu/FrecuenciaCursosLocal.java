package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_FRECU_CURSO")
public class FrecuenciaCursosLocal implements Serializable {

	public FrecuenciaCursosLocal() {}

	public FrecuenciaCursosLocal(Long oid, Long codigo)	{
	
		this.oid=oid;
                this.codigo=codigo;
	
	}

	@Id
	@Column(name="OID_FREC")
	private Long oid;
	@Column(name="COD_FREC")
	private Long codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigo() {return codigo;}
      
	public void setCodigo(Long codigo){this.codigo=codigo;}
			
	
}
