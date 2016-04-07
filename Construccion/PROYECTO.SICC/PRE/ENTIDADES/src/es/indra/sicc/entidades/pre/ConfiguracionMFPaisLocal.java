package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CONFI_MF_PAIS")
@NamedQueries({
@NamedQuery(name="ConfiguracionMFPaisLocal.FindByPaisMarcaCanal",query="SELECT OBJECT(i) "
+"FROM ConfiguracionMFPaisLocal AS i WHERE i.oidPais = ?1 AND i.oidMarca = ?2 AND i.oidCanal = ?3")
})
public class ConfiguracionMFPaisLocal implements Serializable {

	public ConfiguracionMFPaisLocal() {}

	public ConfiguracionMFPaisLocal(Long oid, Long pais_oid_pais, Long marc_oid_marc, Long cana_oid_cana, Long mone_oid_mone) {
	
		this.oid=oid;
                this.oidPais=pais_oid_pais;
                this.oidMarca=marc_oid_marc;
                this.oidCanal=cana_oid_cana;
                this.oidMoneda=mone_oid_mone;
	
	}

	@Id
	@Column(name="OID_CONF_MF")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="MONE_OID_MONE")
	private Long oidMoneda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidMoneda() {return oidMoneda;}
      
	public void setOidMoneda(Long oidMoneda){this.oidMoneda=oidMoneda;}
			
	
}
