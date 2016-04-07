package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CRITE_BUSQU")
@NamedQueries({
@NamedQuery(name="CriterioBusquedaLocal.FindAll", query="SELECT OBJECT(o) FROM CriterioBusquedaLocal o"),
@NamedQuery(name="CriterioBusquedaLocal.FindByPais", query="SELECT OBJECT(o) FROM CriterioBusquedaLocal o WHERE o.pais_oid_pais = ?1")
})
public class CriterioBusquedaLocal implements Serializable {

	public CriterioBusquedaLocal() {}

	public CriterioBusquedaLocal(Long oid, Long pais_oid_pais, Long atre_oid_atri_esp1, Long atre_oid_atri_esp2) {
            this.oid=oid;
            this.pais_oid_pais = pais_oid_pais;
            this.atre_oid_atri_esp1 = atre_oid_atri_esp1;
            this.atre_oid_atri_esp2 = atre_oid_atri_esp2;
	}

	@Id
	@Column(name="OID_CRIT_BUSQ")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais_oid_pais;
	@Column(name="ATRE_OID_ATRI_ESP1")
	private Long atre_oid_atri_esp1;
	@Column(name="ATRE_OID_ATRI_ESP2")
	private Long atre_oid_atri_esp2;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais_oid_pais() {return pais_oid_pais;}
      
	public void setPais_oid_pais(Long pais_oid_pais){this.pais_oid_pais=pais_oid_pais;}
		
	public Long getAtre_oid_atri_esp1() {return atre_oid_atri_esp1;}
      
	public void setAtre_oid_atri_esp1(Long atre_oid_atri_esp1){this.atre_oid_atri_esp1=atre_oid_atri_esp1;}
		
	public Long getAtre_oid_atri_esp2() {return atre_oid_atri_esp2;}
      
	public void setAtre_oid_atri_esp2(Long atre_oid_atri_esp2){this.atre_oid_atri_esp2=atre_oid_atri_esp2;}
			
	
}
