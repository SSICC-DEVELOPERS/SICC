package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_GENER")
@NamedQueries({
@NamedQuery(name="GenericoLocal.FindAll",query="select object(o) from GenericoLocal o"),
@NamedQuery(name="GenericoLocal.FindByUk",query="SELECT OBJECT(g) "
+ " FROM GenericoLocal AS g "
+ " WHERE g.oidPais=?1 "
+ " AND g.codigoGenerico=?2")
})
public class GenericoLocal implements Serializable {

	public GenericoLocal() {}

	public GenericoLocal(Long oid, Long paisOidPais, String codGene)	{
            this.oid = oid;
            this.oidPais = paisOidPais;
            this.codigoGenerico = codGene;
	}

	@Id
	@Column(name="OID_GENE")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_GENE")
	private String codigoGenerico;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoGenerico() {return codigoGenerico;}
      
	public void setCodigoGenerico(String codigoGenerico){this.codigoGenerico=codigoGenerico;}
			
	
}
