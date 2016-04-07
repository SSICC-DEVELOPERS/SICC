package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MENSA_UNIDA_ADMIN")
@NamedQueries({
@NamedQuery(name="MensajeUnidadAdministrativaLocal.FindByMensaje",query="select Object(i) from MensajeUnidadAdministrativaLocal as i where i.mens_oid_mens = ?1")
})
public class MensajeUnidadAdministrativaLocal implements Serializable {

	public MensajeUnidadAdministrativaLocal() {}

	public MensajeUnidadAdministrativaLocal(Long oid, Long mens_oid_mens)	{
	
		this.oid=oid;
                this.mens_oid_mens=mens_oid_mens;
	
	}

	@Id
	@Column(name="OID_MENS_UNID_ADMI")
	private Long oid;
	@Column(name="MENS_OID_MENS")
	private Long mens_oid_mens;
	@Column(name="ZORG_OID_REGI")
	private Long zorg_oid_regi;
	@Column(name="ZZON_OID_ZONA")
	private Long zzon_oid_zona;
	@Column(name="ZSCC_OID_SECC")
	private Long zscc_oid_secc;
	@Column(name="TERR_OID_TERR")
	private Long terr_oid_terr;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMens_oid_mens() {return mens_oid_mens;}
      
	public void setMens_oid_mens(Long mens_oid_mens){this.mens_oid_mens=mens_oid_mens;}
		
	public Long getZorg_oid_regi() {return zorg_oid_regi;}
      
	public void setZorg_oid_regi(Long zorg_oid_regi){this.zorg_oid_regi=zorg_oid_regi;}
		
	public Long getZzon_oid_zona() {return zzon_oid_zona;}
      
	public void setZzon_oid_zona(Long zzon_oid_zona){this.zzon_oid_zona=zzon_oid_zona;}
		
	public Long getZscc_oid_secc() {return zscc_oid_secc;}
      
	public void setZscc_oid_secc(Long zscc_oid_secc){this.zscc_oid_secc=zscc_oid_secc;}
		
	public Long getTerr_oid_terr() {return terr_oid_terr;}
      
	public void setTerr_oid_terr(Long terr_oid_terr){this.terr_oid_terr=terr_oid_terr;}
			
	
}
