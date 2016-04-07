package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_NIVEL_SOCIO_ECONO_ASOCI")
@NamedQueries({
@NamedQuery(name="AsociacionNivelesLocal.FindAll", query="SELECT Object(o) FROM AsociacionNivelesLocal o")
})
public class AsociacionNivelesLocal implements Serializable {

	public AsociacionNivelesLocal() {}

	public AsociacionNivelesLocal(Long oid, Long oidNivelSociBelcorp, Long oidTipoNivelSociPersonal)	{
		this.oid=oid;
		this.oidNivelSociBelcorp = oidNivelSociBelcorp;
		this.oidTipoNivelSociPersonal = oidTipoNivelSociPersonal;
	}

	@Id
	@Column(name="OID_NIVE_SOEC_ASOC")
	private Long oid;
	@Column(name="NSEB_OID_NIVE_SOEC_BELC")
	private Long oidNivelSociBelcorp;
	@Column(name="NSEP_OID_TIPO_NIVE_SOEC_PERS")
	private Long oidTipoNivelSociPersonal;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidNivelSociBelcorp() {return oidNivelSociBelcorp;}
      
	public void setOidNivelSociBelcorp(Long oidNivelSociBelcorp){this.oidNivelSociBelcorp=oidNivelSociBelcorp;}
		
	public Long getOidTipoNivelSociPersonal() {return oidTipoNivelSociPersonal;}
      
	public void setOidTipoNivelSociPersonal(Long oidTipoNivelSociPersonal){this.oidTipoNivelSociPersonal=oidTipoNivelSociPersonal;}
			
	
}
