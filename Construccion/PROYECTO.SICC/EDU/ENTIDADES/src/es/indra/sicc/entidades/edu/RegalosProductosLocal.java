package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_REGAL_DETAL")
public class RegalosProductosLocal implements Serializable {

	public RegalosProductosLocal() {}

	public RegalosProductosLocal(Long oid, Long regalo, Long producto)	{
	
		this.oid=oid;
                this.regalo=regalo;
                this.producto=producto;                
	
	}

	@Id
	@Column(name="OID_DETA")
	private Long oid;
	@Column(name="REGA_OID_REGA")
	private Long regalo;
	@Column(name="PROD_OID_PROD")
	private Long producto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getRegalo() {return regalo;}
      
	public void setRegalo(Long regalo){this.regalo=regalo;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
			
	
}
