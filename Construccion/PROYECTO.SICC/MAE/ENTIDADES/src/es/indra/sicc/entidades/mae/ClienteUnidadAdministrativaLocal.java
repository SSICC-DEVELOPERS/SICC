package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLIEN_UNIDA_ADMIN")
@NamedQueries({
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindUAActiva",query="SELECT OBJECT(a) FROM ClienteUnidadAdministrativaLocal AS a "
+ " WHERE a.clie_oid_clie = ?1 AND "
+ " a.ztad_oid_terr_admi = ?2 AND "
+ " a.ind_acti = 1"),
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindByCliente",query="SELECT OBJECT(a) FROM ClienteUnidadAdministrativaLocal AS a "
+ " WHERE a.clie_oid_clie = ?1"),
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindOidTerriAdmin",query="SELECT OBJECT(o) FROM ClienteUnidadAdministrativaLocal AS o "
+ " WHERE o.clie_oid_clie = ?1 "
+ " AND o.ind_acti = 1 "
+ " AND o.perd_oid_peri_fin IS NULL"),
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindUAActivaByCliente",query="SELECT OBJECT(o) FROM ClienteUnidadAdministrativaLocal AS o "
+ " WHERE o.clie_oid_clie = ?1 "
+ " AND o.ind_acti = 1"),
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindUAUltima",query="SELECT OBJECT(o) FROM ClienteUnidadAdministrativaLocal AS o "
+ " WHERE o.clie_oid_clie = ?1 "
+ " AND o.perd_oid_peri_fin IS NULL"),
@NamedQuery(name="ClienteUnidadAdministrativaLocal.FindAll",query="SELECT OBJECT(o) FROM ClienteUnidadAdministrativaLocal AS o ")
})
public class ClienteUnidadAdministrativaLocal implements Serializable {

	public ClienteUnidadAdministrativaLocal() {}

	public ClienteUnidadAdministrativaLocal(Long oid, Long clie_oid_clie, Long perd_oid_peri_ini, Long perd_oid_peri_fin,
                Long ztad_oid_terr_admi, Long ind_acti)	{
	
            this.oid=oid;
            this.clie_oid_clie = clie_oid_clie;
            this.perd_oid_peri_ini = perd_oid_peri_ini;
            this.perd_oid_peri_fin = perd_oid_peri_fin;
            this.ztad_oid_terr_admi = ztad_oid_terr_admi;
            this.ind_acti = ind_acti;
	}

	@Id
	@Column(name="OID_CLIE_UNID_ADMI")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long clie_oid_clie;
	@Column(name="PERD_OID_PERI_INI")
	private Long perd_oid_peri_ini;
	@Column(name="PERD_OID_PERI_FIN")
	private Long perd_oid_peri_fin;
	@Column(name="ZTAD_OID_TERR_ADMI")
	private Long ztad_oid_terr_admi;
	@Column(name="IND_ACTI")
	private Long ind_acti;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getClie_oid_clie() {return clie_oid_clie;}
      
	public void setClie_oid_clie(Long clie_oid_clie){this.clie_oid_clie=clie_oid_clie;}
		
	public Long getPerd_oid_peri_ini() {return perd_oid_peri_ini;}
      
	public void setPerd_oid_peri_ini(Long perd_oid_peri_ini){this.perd_oid_peri_ini=perd_oid_peri_ini;}
		
	public Long getPerd_oid_peri_fin() {return perd_oid_peri_fin;}
      
	public void setPerd_oid_peri_fin(Long perd_oid_peri_fin){this.perd_oid_peri_fin=perd_oid_peri_fin;}
		
	public Long getZtad_oid_terr_admi() {return ztad_oid_terr_admi;}
      
	public void setZtad_oid_terr_admi(Long ztad_oid_terr_admi){this.ztad_oid_terr_admi=ztad_oid_terr_admi;}
		
	public Long getInd_acti() {return ind_acti;}
      
	public void setInd_acti(Long ind_acti){this.ind_acti=ind_acti;}
			
	
}
