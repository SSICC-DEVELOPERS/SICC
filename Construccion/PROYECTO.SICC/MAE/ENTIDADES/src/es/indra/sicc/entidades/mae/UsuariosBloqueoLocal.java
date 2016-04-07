package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_USUAR_BLOQU")
@NamedQueries({
@NamedQuery(name="UsuariosBloqueoLocal.FindAll",query="select object(o) from UsuariosBloqueoLocal o")
})
public class UsuariosBloqueoLocal implements Serializable {

	public UsuariosBloqueoLocal() {}

	public UsuariosBloqueoLocal(Long oid, Long idUser, Long oidTipoBloqueo, Long oidValoUsuaBloq, Long oidPais)	{
            this.oid=oid;
            this.idUser = idUser;
            this.oidTipoBloqueo = oidTipoBloqueo;
            this.oidAccionPermitida = oidValoUsuaBloq;
            this.oidPais = oidPais;
        }

	@Id
	@Column(name="OID_USUA_BLOQ")
	private Long oid;
	@Column(name="USER_OID_USER")
	private Long idUser;
	@Column(name="TIBQ_OID_TIPO_BLOQ")
	private Long oidTipoBloqueo;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MVUB_OID_VALO_USUA_BLOQ")
	private Long oidAccionPermitida;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdUser() {return idUser;}
      
	public void setIdUser(Long idUser){this.idUser=idUser;}
		
	public Long getOidTipoBloqueo() {return oidTipoBloqueo;}
      
	public void setOidTipoBloqueo(Long oidTipoBloqueo){this.oidTipoBloqueo=oidTipoBloqueo;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidAccionPermitida() {return oidAccionPermitida;}
      
	public void setOidAccionPermitida(Long oidAccionPermitida){this.oidAccionPermitida=oidAccionPermitida;}
			
	
}
