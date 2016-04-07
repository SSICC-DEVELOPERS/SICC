package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CICLO_VIDA")
@NamedQueries({
@NamedQuery(name="CicloVidaLocal.FindByUK",query="SELECT OBJECT(c) "
+ "FROM CicloVidaLocal AS c WHERE c.codigoCicloVida = ?1")
})
public class CicloVidaLocal implements Serializable {

	public CicloVidaLocal() {}

	public CicloVidaLocal(Long oid, String cod_cicl_vida)	{
	
		this.oid=oid;
                this.codigoCicloVida=cod_cicl_vida;
	
	}

	@Id
	@Column(name="OID_CICL_VIDA")
	private Long oid;
	@Column(name="COD_CICL_VIDA")
	private String codigoCicloVida;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoCicloVida() {return codigoCicloVida;}
      
	public void setCodigoCicloVida(String codigoCicloVida){this.codigoCicloVida=codigoCicloVida;}
			
	
}
