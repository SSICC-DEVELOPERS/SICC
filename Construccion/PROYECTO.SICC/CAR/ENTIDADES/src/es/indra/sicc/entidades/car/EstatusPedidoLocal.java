package es.indra.sicc.entidades.car;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAR_ESTAT_PEDID")
public class EstatusPedidoLocal implements Serializable {

	public EstatusPedidoLocal() {}

	public EstatusPedidoLocal(Long oid, String cod_esta)	{
	
		this.oid=oid;
	        this.setCodigoEstatus(cod_esta);
	
	}

	@Id
	@Column(name="OID_ESTA_PEDI")
	private Long oid;
	@Column(name="COD_ESTA")
	private String codigoEstatus;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoEstatus() {return codigoEstatus;}
      
	public void setCodigoEstatus(String codigoEstatus){this.codigoEstatus=codigoEstatus;}
			
	
}
