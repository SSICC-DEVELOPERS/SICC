package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_REGAL")
public class RegalosLocal implements Serializable {

	public RegalosLocal() {}

	public RegalosLocal(Long oid, Integer codigo, Long pais)	{
	
		this.oid=oid;
                this.codigo=codigo;
                this.pais=pais;                
	
	}

	@Id
	@Column(name="OID_REGA")
	private Long oid;
	@Column(name="COD_REGA")
	private Integer codigo;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
