package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_PATRO_MENSA")
@NamedQueries({
@NamedQuery(name="PatronMensajeLocal.FindBySeccion",query="select Object(i) from PatronMensajeLocal as i where i.oidPatronSeccion = ?1")
})
public class PatronMensajeLocal implements Serializable {

	public PatronMensajeLocal() {}

	public PatronMensajeLocal(Long oid, Long pase_oid_patr_secc, Long mens_oid_mens, Integer num_orde_impr)	{
	
		this.oid=oid;
                this.oidPatronSeccion=pase_oid_patr_secc;
                this.oidMensajeAsociado=mens_oid_mens;
                this.ordenImpresion=num_orde_impr;
	}

	@Id
	@Column(name="OID_PATR_MENS")
	private Long oid;
	@Column(name="PASE_OID_PATR_SECC")
	private Long oidPatronSeccion;
	@Column(name="MENS_OID_MENS")
	private Long oidMensajeAsociado;
	@Column(name="NUM_ORDE_IMPR")
	private Integer ordenImpresion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPatronSeccion() {return oidPatronSeccion;}
      
	public void setOidPatronSeccion(Long oidPatronSeccion){this.oidPatronSeccion=oidPatronSeccion;}
		
	public Long getOidMensajeAsociado() {return oidMensajeAsociado;}
      
	public void setOidMensajeAsociado(Long oidMensajeAsociado){this.oidMensajeAsociado=oidMensajeAsociado;}
		
	public Integer getOrdenImpresion() {return ordenImpresion;}
      
	public void setOrdenImpresion(Integer ordenImpresion){this.ordenImpresion=ordenImpresion;}
			
	
}
