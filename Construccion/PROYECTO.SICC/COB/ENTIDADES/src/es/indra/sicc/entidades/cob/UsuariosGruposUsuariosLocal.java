package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_USUAR_GRUPO_USUAR")
@NamedQueries({
@NamedQuery(name="UsuariosGruposUsuariosLocal.FindAll",query="select object(o) from UsuariosGruposUsuariosLocal o")
})
public class UsuariosGruposUsuariosLocal implements Serializable {

	public UsuariosGruposUsuariosLocal() {}

	public UsuariosGruposUsuariosLocal(Long oid, Long usuario, Long grupoUsuario)	{
	
		this.oid=oid;
                this.setUsuario(usuario);
	        this.setGrupoUsuario(grupoUsuario);
	
	}

	@Id
	@Column(name="OID_USUA_GRUP_USUA")
	private Long oid;
	@Column(name="USCO_OID_USUA_COBR")
	private Long usuario;
	@Column(name="GUCO_OID_GRUP_USUA_COBR")
	private Long grupoUsuario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getUsuario() {return usuario;}
      
	public void setUsuario(Long usuario){this.usuario=usuario;}
		
	public Long getGrupoUsuario() {return grupoUsuario;}
      
	public void setGrupoUsuario(Long grupoUsuario){this.grupoUsuario=grupoUsuario;}
			
	
}
