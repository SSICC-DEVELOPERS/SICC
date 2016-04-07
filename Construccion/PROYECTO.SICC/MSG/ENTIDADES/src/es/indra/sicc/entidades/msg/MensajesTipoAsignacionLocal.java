package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MENSA_TIPO_ASIGN")
@NamedQueries({
@NamedQuery(name="MensajesTipoAsignacionLocal.FindByTipo",query="select Object(i) from MensajesTipoAsignacionLocal as i where i.mens_oid_mens = ?1 and i.tide_oid_tipo_dest = ?2"),
@NamedQuery(name="MensajesTipoAsignacionLocal.FindByMensaje",query="select Object(i) from MensajesTipoAsignacionLocal as i where i.mens_oid_mens = ?1")
})
public class MensajesTipoAsignacionLocal implements Serializable {

	public MensajesTipoAsignacionLocal() {}

	public MensajesTipoAsignacionLocal(Long oid,Long mens_oid_mens, Long tide_oid_tipo_dest)	{
	
		this.oid=oid;
                this.mens_oid_mens=mens_oid_mens;
                this.tide_oid_tipo_dest=tide_oid_tipo_dest;
	}

	@Id
	@Column(name="OID_MENS_TIPO_DEST")
	private Long oid;
	@Column(name="MENS_OID_MENS")
	private Long mens_oid_mens;
	@Column(name="TIDE_OID_TIPO_DEST")
	private Long tide_oid_tipo_dest;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMens_oid_mens() {return mens_oid_mens;}
      
	public void setMens_oid_mens(Long mens_oid_mens){this.mens_oid_mens=mens_oid_mens;}
		
	public Long getTide_oid_tipo_dest() {return tide_oid_tipo_dest;}
      
	public void setTide_oid_tipo_dest(Long tide_oid_tipo_dest){this.tide_oid_tipo_dest=tide_oid_tipo_dest;}
			
	
}
