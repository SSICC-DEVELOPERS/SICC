package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_TIPO_FACTU")
public class TipoFacturacionLocal implements Serializable {

	public TipoFacturacionLocal() {}

	public TipoFacturacionLocal(Long oid, String des_tipo_fact)	{
	
		this.oid=oid;
                this.tipo = des_tipo_fact;
	}

	@Id
	@Column(name="OID_TIPO_FACT")
	private Long oid;
	@Column(name="DES_TIPO_FACT")
	private String tipo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getTipo() {return tipo;}
      
	public void setTipo(String tipo){this.tipo=tipo;}
			
	
}
