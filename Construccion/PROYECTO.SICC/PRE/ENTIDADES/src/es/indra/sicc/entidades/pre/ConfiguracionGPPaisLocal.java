package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CONFI_GP")
@NamedQueries({
@NamedQuery(name="ConfiguracionGPPaisLocal.FindByPaisMarcaCanal",query="SELECT OBJECT(a) "
+" FROM ConfiguracionGPPaisLocal AS a WHERE a.oidPais = ?1 AND a.oidMarca = ?2 AND a.oidCanal = ?3")
})
public class ConfiguracionGPPaisLocal implements Serializable {

	public ConfiguracionGPPaisLocal() {}

	public ConfiguracionGPPaisLocal(Long oid, Long pais_oid_pais, Long marc_oid_marc, Long cana_oid_cana, Integer val_incr)	{
	
		this.oid=oid;
                this.oidPais=pais_oid_pais;
                this.oidMarca=marc_oid_marc;
                this.oidCanal=cana_oid_cana;
                this.incremento=val_incr;
	
	}

	@Id
	@Column(name="OID_CONF_GP")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="VAL_INCR")
	private Integer incremento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Integer getIncremento() {return incremento;}
      
	public void setIncremento(Integer incremento){this.incremento=incremento;}
			
	
}
