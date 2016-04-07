package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_SUPER_GENER")
@NamedQueries({
@NamedQuery(name="SuperGenericoLocal.FindAll",query="select object(o) from SuperGenericoLocal o"),
@NamedQuery(name="SuperGenericoLocal.FindByUk",query="SELECT OBJECT(s) "
+ " FROM SuperGenericoLocal AS s "
+ " WHERE s.oidPais=?1 "
+ " AND s.codigoSupergenerico=?2")
})
public class SuperGenericoLocal implements Serializable {

	public SuperGenericoLocal() {}

	public SuperGenericoLocal(Long oid, Long paisOidPais, String codSupeGene) {
            this.oid=oid;
            this.oidPais = paisOidPais;
            this.codigoSupergenerico = codSupeGene;
	}

	@Id
	@Column(name="OID_SUPE_GENE")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="COD_SUPE_GENE")
	private String codigoSupergenerico;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getCodigoSupergenerico() {return codigoSupergenerico;}
      
	public void setCodigoSupergenerico(String codigoSupergenerico){this.codigoSupergenerico=codigoSupergenerico;}
			
	
}
