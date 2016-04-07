package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ESTAD_GRUPO_USUAR")
@NamedQueries({
@NamedQuery(name="EstadoGrupoUsuarioLocal.FindAll",query="select object(o) from EstadoGrupoUsuarioLocal o")
})
public class EstadoGrupoUsuarioLocal implements Serializable {

	public EstadoGrupoUsuarioLocal() {}

	public EstadoGrupoUsuarioLocal(Long oid, Character codigo)	{
	
		this.oid=oid;
                this.setCod(codigo);
	
	}

	@Id
	@Column(name="OID_ESTA_GRUP_USUA")
	private Long oid;
	@Column(name="COD_ESTA_GRUP_USUA")
	private Character cod;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Character getCod() {return cod;}
      
	public void setCod(Character cod){this.cod=cod;}
			
	
}
